package main.java.DAOimplementation;

import main.java.DAO.RuoloDAO;
import main.java.DAO.VeicoloDAO;
import main.java.HibernateUtil.javaHibernateUtil;
import main.java.entities.Ruolo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;


public class RuoloDAOImpl implements RuoloDAO {
//    private SessionFactory sessionFactory = javaHibernateUtil.getSessionFactory();


    public Ruolo trovaRuolo(String descrizione) {
        Ruolo ruolo;
        Transaction transaction=null;
        Session session=null;

        try{
            session = javaHibernateUtil.getHibernateSession();
            transaction = session.beginTransaction();
            ruolo = session.createQuery("from Ruolo where descrizione=:descrizione", Ruolo.class)
                    .setParameter("descrizione",descrizione).getSingleResult();
        }
        catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            ruolo=null;
        }
        finally {
                session.close();
        }
        return ruolo;
    }


    private static RuoloDAOImpl istanza = null;

    public static synchronized RuoloDAOImpl getRuoloDAOImpl() {
        if (istanza == null) {
            istanza = new RuoloDAOImpl();
        }
        return istanza;
    }
}
