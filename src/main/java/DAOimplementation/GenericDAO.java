package main.java.DAOimplementation;

import main.java.HibernateUtil.javaHibernateUtil;
import main.java.entities.Utente;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public abstract class GenericDAO<E> implements Serializable {
    private final Class<E> entity;

    protected GenericDAO(Class<E> entity) {
        this.entity = entity;
    }

    public void salva(E entity) {
        Transaction transaction = null;
        Session session=null;
        try {
            session= javaHibernateUtil.getHibernateSession();
            transaction= session.beginTransaction();
            session.save(entity);
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

    public void update(E entity) {
        Transaction transaction = null;
        Session session=null;
        try {
            session= javaHibernateUtil.getHibernateSession();
            transaction= session.beginTransaction();
            session.update(entity);
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

}
