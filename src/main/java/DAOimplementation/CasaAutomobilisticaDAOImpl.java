package main.java.DAOimplementation;


import main.java.HibernateUtil.javaHibernateUtil;
import main.java.entities.CasaAutomobilistica;
import main.java.entities.Ruolo;
import main.java.entities.Veicolo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CasaAutomobilisticaDAOImpl  {
//    private SessionFactory sessionFactory = javaHibernateUtil.getSessionFactory();

    public CasaAutomobilistica selezioneCasaAutomobilistica(int id) {
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

    public CasaAutomobilistica trovaCasa(String c) {
        CasaAutomobilistica casa;
        Transaction transaction = null;
        Session session=null;
        try {
            session = javaHibernateUtil.getHibernateSession();
            transaction=session.beginTransaction();
            casa = session.createQuery(
                    "from CasaAutomobilistica C where C.nome=:c",
                    CasaAutomobilistica.class
            ).setParameter("c", c).getSingleResult();
        } catch (Exception e) {
            transaction.rollback();
            casa=null;
        }
        finally {
            session.close();
        }
        javaHibernateUtil.shutdown();

        return casa;
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
