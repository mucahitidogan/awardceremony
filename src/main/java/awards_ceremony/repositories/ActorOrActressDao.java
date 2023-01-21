package awards_ceremony.repositories;


import awards_ceremony.entities.ActorOrActress;
import awards_ceremony.entities.Director;
import awards_ceremony.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ActorOrActressDao implements ICrud<ActorOrActress>{
    @Override
    public void save(ActorOrActress actorOrActress) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.save(actorOrActress);
            session.getTransaction().commit();
            System.out.println("ActorOrActress is added");
            session.close();
        }catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAll() {
        List<Object[]> actorOrActressList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select aoa.actorActressName, f.filmName, a.awardName from actororactress as aoa\n" +
                    "inner join actororactress_film aoaf on aoaf.ActorOrActress_id = aoa.id\n" +
                    "inner join film as f on f.id = aoaf.film_id\n" +
                    "inner join actororactress_award aoaa on aoaa.ActorOrActress_id = aoa.id\n" +
                    "inner join award as a on a.id = aoaa.award_id";
            actorOrActressList = entityManager.createNativeQuery(query).getResultList();
            for(Object[] item : actorOrActressList){
                System.out.println("ActorActress Name: " + item[0] + " --"
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
            String sql = "select aoa.actorActressName, f.filmName, a.awardName from actororactress as aoa\n" +
                    "inner join actororactress_film aoaf on aoaf.ActorOrActress_id = aoa.id\n" +
                    "inner join film as f on f.id = aoaf.film_id\n" +
                    "inner join actororactress_award aoaa on aoaa.ActorOrActress_id = aoa.id\n" +
                    "inner join award as a on a.id = aoaa.award_id where aoa.id = ?";
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
    public void update(ActorOrActress actorOrActress) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(actorOrActress);
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
        ActorOrActress actorOrActress = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            actorOrActress = session.load(ActorOrActress.class, id);
            session.delete(actorOrActress);
            session.getTransaction().commit();
            getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

}

