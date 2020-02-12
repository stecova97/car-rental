package main.java.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class javaHibernateUtil {
    private static SessionFactory sessionFactory ;
    private static StandardServiceRegistry registry;

    public static Session getHibernateSession(){
        final SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        final Session session = sf.openSession();
        return session;
    }

    public static void shutdown() {
        if(registry!=null){
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
