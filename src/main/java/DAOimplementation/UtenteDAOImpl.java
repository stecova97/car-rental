package main.java.DAOimplementation;

import main.java.DAO.UtenteDAO;
import main.java.DTO.UtenteDTO;
import main.java.HibernateUtil.javaHibernateUtil;
import main.java.entities.Utente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAOImpl implements UtenteDAO {
    //private SessionFactory sessionFactory = javaHibernateUtil.getSessionFactory();


    public Utente loginUtente(UtenteDTO utenteDTO) {
        Utente utente;
        Transaction transaction = null;
        Session session = null;
        try {
            session = javaHibernateUtil.getHibernateSession();
            transaction = session.beginTransaction();
            utente = session.createQuery("FROM Utente U WHERE U.email=:email and U.password=:password", Utente.class)
                    .setParameter("email", utenteDTO.getEmail())
                    .setParameter("password", utenteDTO.getPsw())
                    .getSingleResult();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            utente = null;

        } finally {
               session.close();
        }

        return utente;
    }

    @Override
   public void eliminaUtente(Integer id) {
        Transaction transaction = null;
        Session session = null;
        session = javaHibernateUtil.getHibernateSession();
        transaction = session.beginTransaction();

        Query q = session.createQuery("delete from Utente where idUtente = " + id);
        q.executeUpdate();

        session.close();
        javaHibernateUtil.shutdown();


    }
//
//    @Override
    public void updateUtente(Utente u) {
        Transaction transaction=null;
        Session session=null;

        try {
            session=javaHibernateUtil.getHibernateSession();
            transaction= session.beginTransaction();
            session.update(u);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction!=null)
                transaction.rollback();

        }
        finally {
                session.close();
        }

    }

    @Override
    public void salvaUtente(Utente u) {
        Transaction transaction = null;
        Session session=null;
        try {
            session=javaHibernateUtil.getHibernateSession();
            transaction= session.beginTransaction();
            session.save(u);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction!=null)
                transaction.rollback();
        }
        finally {
            if(session!=null)
                session.close();
        }
    }
//
    @Override
    public List<Utente> selezionaUtenti() {
        List<Utente> utenti = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = javaHibernateUtil.getHibernateSession()) {
            utenti = session.createQuery("from Utente", Utente.class).list();
        } catch (Exception e) {
                transaction.rollback();
        }
        return utenti;
    }
//
    @Override
    public Utente trovaUtente(String email) {
        Utente utente;
        Transaction transaction = null;
        Session session=null;
        try {
            session = javaHibernateUtil.getHibernateSession();
            transaction=session.beginTransaction();
            utente = session.createQuery(
                    "from Utente U where U.email=:email",
                    Utente.class
            ).setParameter("email", email).getSingleResult();
        } catch (Exception e) {
                transaction.rollback();
            utente=null;
        }
        finally {
                session.close();
        }
        javaHibernateUtil.shutdown();

        return utente;
    }

    public boolean utenteExist(String email){
        Utente utente;
        Transaction transaction = null;
        Session session=null;
        try {
            session = javaHibernateUtil.getHibernateSession();
            transaction=session.beginTransaction();
            utente = session.createQuery(
                    "from Utente U where U.email=:email",
                    Utente.class
            ).setParameter("email", email).getSingleResult();
        } catch (Exception e) {
            transaction.rollback();
            utente=null;
        }
        finally {
            session.close();
        }
        if(utente == null)
            return false;
        return true;
    }

    private static UtenteDAOImpl istanza = null;


    //accesso al singleton
    public static synchronized UtenteDAOImpl getUtentiDAO() {
        if (istanza == null) {
            istanza = new UtenteDAOImpl();
        }
        return istanza;
    }

}
