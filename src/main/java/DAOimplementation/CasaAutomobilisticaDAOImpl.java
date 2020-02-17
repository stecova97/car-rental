package main.java.DAOimplementation;

import main.java.DAO.CasaAutomobilisticaDAO;
import main.java.HibernateUtil.javaHibernateUtil;
import main.java.entities.CasaAutomobilistica;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CasaAutomobilisticaDAOImpl implements CasaAutomobilisticaDAO {
//    private SessionFactory sessionFactory = javaHibernateUtil.getSessionFactory();

    public CasaAutomobilistica selezioneCasaAutomobilistica(Integer id) {
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//
//        CasaAutomobilistica c = null;
//
//        c = (CasaAutomobilistica) session.createQuery(
//                "SELECT idCasaAutomobilistica FROM CasaAutomobilistica WHERE idCasaAutomobilistica = " + id
//        ).getSingleResult();
//
//        session.getTransaction().commit();
//        session.close();
        return  null;

    }


    public List<CasaAutomobilistica> elencoCaseAutomobilistiche() {
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//
//        List <CasaAutomobilistica> c = null;
//
//        c = (List <CasaAutomobilistica>) session.createQuery(
//                "SELECT nome FROM CasaAutomobilistica "
//        ).list();
//
//
//        session.getTransaction().commit();
//        session.close();
        return null;
    }


    private static CasaAutomobilisticaDAOImpl istanza = null;

    public static synchronized CasaAutomobilisticaDAOImpl getCasaAutomobilisticaDAOImpl() {
        if (istanza == null) {
            istanza = new CasaAutomobilisticaDAOImpl();
        }
        return istanza;
    }
}
