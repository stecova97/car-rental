package main.java.DAOimplementation;

import main.java.DAO.RuoloDAO;
import main.java.DAO.VeicoloDAO;
import main.java.HibernateUtil.javaHibernateUtil;
import main.java.entities.Ruolo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;


public class RuoloDAOImpl implements RuoloDAO {
//    private SessionFactory sessionFactory = javaHibernateUtil.getSessionFactory();


    public Ruolo trovaRuolo() {
//        Session session =this.sessionFactory.openSession();
//        session.beginTransaction();
//        Ruolo r = null;
//
//        r = (Ruolo) session.createQuery(
//                "SELECT idRuolo FROM Ruolo"
//        ).getSingleResult();
//
//        session.getTransaction().commit();
//        session.close();
        return null;

    }

    private static RuoloDAOImpl istanza = null;

    public static synchronized RuoloDAOImpl getRuoloDAOImpl() {
        if (istanza == null) {
            istanza = new RuoloDAOImpl();
        }
        return istanza;
    }
}
