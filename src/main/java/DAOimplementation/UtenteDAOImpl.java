package main.java.DAOimplementation;

import main.java.DAO.UtenteDAO;
import main.java.DTO.UtenteDTO;
import main.java.HibernateUtil.javaHibernateUtil;
import main.java.entities.Utente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class UtenteDAOImpl implements UtenteDAO {
    private SessionFactory sessionFactory = javaHibernateUtil.getSessionFactory();


    public Utente loginUtente(UtenteDTO utenteDTO) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Utente utente = null;
        utente = (Utente) session.createQuery(
                "SELECT idUtente, ruolo FROM Utente WHERE email = " + utenteDTO.getEmail() + " and password = " + utenteDTO.getPsw() )
                .getSingleResult();
        session.getTransaction().commit();
        session.close();
        return utente;
    }

    @Override
    public void eliminaUtente(int id) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();

        Query q =session.createQuery("delete from Utente where idUtente = " + id);
        q.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateUtente(Utente u) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.update(u);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void salvaUtente(Utente u) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Utente utente = new Utente();
        utente.setCognome(u.getCognome());
        utente.setEmail(u.getEmail());
        utente.setIdUtente(u.getIdUtente());
        utente.setNome(u.getNome());
        utente.setPassword(u.getPassword());
        utente.setRuolo(u.getRuolo());
        session.save(utente);
        session.close();
    }

    @Override
    public List<Utente> selezionaUtenti() {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        List <Utente> utenti = null;

        utenti = (List<Utente>) session.createQuery(
                "SELECT email FROM Utente "
        ).list();
        session.getTransaction().commit();
        session.close();

        return utenti;
    }

    @Override
    public Utente trovaUtente(String email) {
        Session session =this.sessionFactory.openSession();
        session.beginTransaction();
        Utente u = null;

        u = (Utente) session.createQuery(
                "SELECT * FROM Utente WHERE email =" + email
        ).getSingleResult();
        session.getTransaction().commit();
        session.close();
        return u;

    }

    private static UtenteDAOImpl istanza = null;

    private UtenteDAOImpl(){}
    //accesso al singleton
    public static synchronized UtenteDAOImpl getUtentiDAO() {
        if (istanza == null) {
            istanza = new UtenteDAOImpl();
        }
        return istanza;
    }

}
