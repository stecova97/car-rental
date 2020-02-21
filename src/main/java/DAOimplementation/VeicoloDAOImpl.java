package main.java.DAOimplementation;


import main.java.HibernateUtil.javaHibernateUtil;
import main.java.entities.Utente;
import main.java.entities.Veicolo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class VeicoloDAOImpl {
    //private SessionFactory sessionFactory = javaHibernateUtil.getSessionFactory();


    public Veicolo selezioneVeicolo(String cod) {
        Veicolo veicolo = new Veicolo();
        Transaction transaction = null;
        Session session = null;
        try{
            session= javaHibernateUtil.getHibernateSession();
            veicolo = (Veicolo) session.createQuery("select v from Veicolo v where v.targa like ="+ cod  ).getSingleResult();
        }
        catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            veicolo=null;
            e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();
            }
        }
        return veicolo;
    }


    public List<Veicolo> elencoVeicoli() {
        List<Veicolo> veicoli;
        Transaction transaction = null;
        Session session = null;
        try{
            session= javaHibernateUtil.getHibernateSession();
            veicoli = (List<Veicolo>)session.createQuery("select v from Veicolo v").list();
        }
        catch (Exception e){
            if(transaction!=null)
                transaction.rollback();
            veicoli=null;
        }
        finally {
                session.close();
        }
        return veicoli;

    }


    public void eliminaVeicolo(String cod) {
        Session session;
        session= javaHibernateUtil.getHibernateSession();
        session.beginTransaction();
        Query q = session.createQuery("DELETE FROM Veicolo v WHERE v.targa ='" + cod + "'");
        try {
            q.executeUpdate();
            session.getTransaction().commit();
        }catch (PersistenceException pe){
            throw pe;
        }finally{
            session.close();
        }
    }


    public void salvaVeicolo(Veicolo v) {
        Transaction transaction = null;
        Session session=null;
        try {
            session=javaHibernateUtil.getHibernateSession();
            transaction= session.beginTransaction();
            session.save(v);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
        finally {
                session.close();
        }

    }

    public void updateVeicolo(Veicolo v) {
        Transaction transaction=null;
        Session session=null;

        try {
            session=javaHibernateUtil.getHibernateSession();
            transaction= session.beginTransaction();
            session.update(v);
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
    public boolean veicoloExist(String cod){
        Veicolo veicolo;
        Transaction transaction = null;
        Session session=null;
        try {
            session = javaHibernateUtil.getHibernateSession();
            transaction=session.beginTransaction();
            veicolo = session.createQuery(
                    "from Veicolo V where V.targa=:cod",
                    Veicolo.class
            ).setParameter("cod", cod).getSingleResult();
        } catch (Exception e) {
            transaction.rollback();
            veicolo=null;
        }
        finally {
            session.close();
        }
        if(veicolo == null)
            return false;
        return true;
    }




    private static VeicoloDAOImpl istanza = null;

    private VeicoloDAOImpl(){}
    //accesso al singleton
    public static synchronized VeicoloDAOImpl getVeicoloDAOImpl() {
        if (istanza == null) {
            istanza = new VeicoloDAOImpl();
        }
        return istanza;
    }
}
