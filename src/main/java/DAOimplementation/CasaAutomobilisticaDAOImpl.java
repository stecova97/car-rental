package main.java.DAOimplementation;

import main.java.DAO.CasaAutomobilisticaDAO;
import main.java.HibernateUtil.javaHibernateUtil;
import main.java.entities.CasaAutomobilistica;
import main.java.entities.Ruolo;
import main.java.entities.Veicolo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CasaAutomobilisticaDAOImpl implements CasaAutomobilisticaDAO {
//    private SessionFactory sessionFactory = javaHibernateUtil.getSessionFactory();

    public CasaAutomobilistica selezioneCasaAutomobilistica(Integer id) {
        CasaAutomobilistica c;
        Transaction transaction=null;
        Session session=null;

        try{
            session = javaHibernateUtil.getHibernateSession();
            transaction = session.beginTransaction();
            c = session.createQuery("from CasaAutomobilistica where idCasaAutomobilistica=:id", CasaAutomobilistica.class)
                    .setParameter("id",id).getSingleResult();
        }
        catch (Exception e){
            if(transaction!=null)
                transaction.rollback();
            c=null;
        }
        finally {
            session.close();
        }
        return c;

    }


    public List<CasaAutomobilistica> elencoCaseAutomobilistiche() {
        List<CasaAutomobilistica> c = new ArrayList<>();
        Transaction transaction = null;
        Session session = null;
        try{
            session= javaHibernateUtil.getHibernateSession();
            c = (List<CasaAutomobilistica>)session.createQuery("from CasaAutomobilistica").list();
        }
        catch (Exception e){
                transaction.rollback();
            c=null;
        }
        finally {
            session.close();
        }
        return c;
    }


    private static CasaAutomobilisticaDAOImpl istanza = null;

    public static synchronized CasaAutomobilisticaDAOImpl getCasaAutomobilisticaDAOImpl() {
        if (istanza == null) {
            istanza = new CasaAutomobilisticaDAOImpl();
        }
        return istanza;
    }
}
