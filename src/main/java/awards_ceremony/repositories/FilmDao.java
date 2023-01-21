package awards_ceremony.repositories;

import awards_ceremony.entities.ActorOrActress;
import awards_ceremony.entities.Film;
import awards_ceremony.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

public class FilmDao implements ICrud<Film> {

    @Override
    public void save(Film film) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.save(film);
            session.getTransaction().commit();
            System.out.println("Film is added");
            session.close();
        }catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAll() {
        List<Object[]> filmList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select f.filmName, a.awardName, c.categoryName, d.directorName, aoa.actorActressName from film as f\n" +
                    "inner join film_actororactress as faoa\n" +
                    "on faoa.Film_id = f.id\n" +
                    "inner join actororactress as aoa\n" +
                    "on aoa.id = faoa.actorOrActress_id\n" +
                    "inner join director as d\n" +
                    "on d.id = f.director_id\n" +
                    "inner join film_award as fa\n" +
                    "on fa.Film_id = f.id\n" +
                    "inner join award as a\n" +
                    "on a.id = fa.award_id\n" +
                    "inner join film_category as fc\n" +
                    "on f.id = fc.Film_id\n" +
                    "inner join category as c\n" +
                    "on c.id = fc.category_id";
            filmList = entityManager.createNativeQuery(query).getResultList();
            for(Object[] item : filmList){

                System.out.println("Film Name: " + item[0] + " --"
                        + " ActorActress Name: " + item[1] + " --"
                        + " Award Name: " + item[2] + " --"
                        + " Category Name: " + item[3] + " --"
                        + " Director Name: " + item[4] );
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void getById(int id) {
        List<Object[]> filmList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String sql = "select f.filmName, a.awardName, c.categoryName, d.directorName, aoa.actorActressName from film as f\n" +
                    "inner join film_actororactress as faoa\n" +
                    "on faoa.Film_id = f.id\n" +
                    "inner join actororactress as aoa\n" +
                    "on aoa.id = faoa.actorOrActress_id\n" +
                    "inner join director as d\n" +
                    "on d.id = f.director_id\n" +
                    "inner join film_award as fa\n" +
                    "on fa.Film_id = f.id\n" +
                    "inner join award as a\n" +
                    "on a.id = fa.award_id\n" +
                    "inner join film_category as fc\n" +
                    "on f.id = fc.Film_id\n" +
                    "inner join category as c\n" +
                    "on c.id = fc.category_id where f.id = ?";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter(1, id);
            filmList = query.getResultList();
            for(Object[] item : filmList){

                System.out.println("Film Name: " + item[0] + " --"
                        + " ActorActress Name: " + item[1] + " --"
                        + " Award Name: " + item[2] + " --"
                        + " Category Name: " + item[3] + " --"
                        + " Director Name: " + item[4] );
         }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(Film film) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(film);
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
        Film film = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            film = session.load(Film.class, id);
            session.delete(film);
            session.getTransaction().commit();
            getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
