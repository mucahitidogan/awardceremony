package awards_ceremony.repositories;

import awards_ceremony.entities.Director;
import awards_ceremony.entities.Film;
import awards_ceremony.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DirectorDao implements ICrud<Director>{
    @Override
    public void save(Director director) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.save(director);
            session.getTransaction().commit();
            System.out.println("Director is added");
            session.close();
        }catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAll() {
        List<Object[]> directorList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select d.directorName, f.filmName, a.awardName  from director as d \n" +
                    "inner join director_film as df on d.id = df.Director_id\n" +
                    "inner join film as f on f.id = df.film_id\n" +
                    "inner join award as a on a.id = d.award_id";
            directorList = entityManager.createNativeQuery(query).getResultList();
            for(Object[] item : directorList){

                System.out.println("Director Name: " + item[0] + " --"
                        + " Film Name: " + item[1] + " --"
                        + " Award Name: " + item[2]
                );
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void getById(int id) {
        List<Object[]> directorList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String sql = "select d.directorName, f.filmName, a.awardName  from director as d \n" +
                    "inner join director_film as df on d.id = df.Director_id\n" +
                    "inner join film as f on f.id = df.film_id\n" +
                    "inner join award as a on a.id = d.award_id where d.id = ?";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter(1, id);
            directorList = query.getResultList();
            for(Object[] item : directorList){

                System.out.println("Director Name: " + item[0] + " --"
                        + " Film Name: " + item[1] + " --"
                        + " Award Name: " + item[2]
                );
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(Director director) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(director);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Director director = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            director = session.load(Director.class, id);
            session.delete(director);
            session.getTransaction().commit();
            getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
