package main.java.DAO;

import main.java.HibernateUtil.javaHibernateUtil;
import org.hibernate.SessionFactory;

public abstract class GenericDAO {
    private SessionFactory sessionFactory = javaHibernateUtil.getSessionFactory();


}
