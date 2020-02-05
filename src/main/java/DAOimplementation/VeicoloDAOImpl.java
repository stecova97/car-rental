package main.java.DAOimplementation;

import main.java.DAO.VeicoloDAO;
import main.java.HibernateUtil.javaHibernateUtil;
import main.java.entities.Veicolo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class VeicoloDAOImpl implements VeicoloDAO {

    private SessionFactory sessionFactory = javaHibernateUtil.getSessionFactory();


    public Veicolo selezioneVeicolo(int cod) {
        Session session =this.sessionFactory.openSession();
        session.beginTransaction();
        Veicolo v = null;

        v = (Veicolo) session.createQuery(
                "SELECT * FROM Veicolo WHERE targa =" + cod
        ).getSingleResult();
        session.getTransaction().commit();
        session.close();
        return v;
    }


    public List<Veicolo> elencoVeicoli() {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        List <Veicolo> veicoli = null;

        veicoli = (List<Veicolo>) session.createQuery(
                "SELECT targa FROM Veicolo"
        ).list();
        session.getTransaction().commit();
        session.close();

        return veicoli;
    }


    public void eliminaVeicolo(int cod) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();

        Query q =session.createQuery("delete from Veicolo where targa = " + cod);
        q.executeUpdate();
        session.close();
    }


    public void salvaVeicolo(Veicolo v) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Veicolo veicolo = new Veicolo();
        veicolo.setModello(v.getModello());
        veicolo.setAnno_immatricolazione(v.getAnno_immatricolazione());
        veicolo.setCasa_automobilista(v.getCasa_automobilista());
        session.save(veicolo);
        session.close();
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
