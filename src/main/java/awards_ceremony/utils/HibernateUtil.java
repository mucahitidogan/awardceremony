package awards_ceremony.utils;

import awards_ceremony.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null){
            try{
                Configuration configuration = new Configuration();
                //Bu aslında hibernate.cfg.xml'deki mapping yerine kullanılıyor.
                //Orada ya da burada kullanarak diğerini kullanmıyoruz.
                configuration.addAnnotatedClass(Award.class);
                configuration.addAnnotatedClass(ActorOrActress.class);
                configuration.addAnnotatedClass(Category.class);
                configuration.addAnnotatedClass(Director.class);
                configuration.addAnnotatedClass(Film.class);
                sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
