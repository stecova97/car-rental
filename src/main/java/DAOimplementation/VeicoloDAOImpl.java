package main.java.DAOimplementation;

import main.java.DAO.VeicoloDAO;
import main.java.HibernateUtil.javaHibernateUtil;
import main.java.entities.Veicolo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class VeicoloDAOImpl implements VeicoloDAO {
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
        List<Veicolo> veicoli = new ArrayList<>();
        Transaction transaction = null;
        Session session = null;
        try{
            session= javaHibernateUtil.getHibernateSession();
            veicoli = session.createQuery("select v from Veicolo v").list();
        }
        catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            veicoli=null;
        }
        finally {
                session.close();
        }
        javaHibernateUtil.shutdown();

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
            session.saveOrUpdate(v);
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
