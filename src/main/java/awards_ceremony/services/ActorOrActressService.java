package awards_ceremony.services;

import awards_ceremony.entities.ActorOrActress;
import awards_ceremony.entities.Award;
import awards_ceremony.entities.Director;
import awards_ceremony.entities.Film;
import awards_ceremony.repositories.ActorOrActressDao;

import java.util.Arrays;

public class ActorOrActressService {
    public static void main(String[] args) {
        //save();
        //getAll();
        //getById(5);
        //delete(2);
        //update();
    }
    static ActorOrActressDao actorAndActressDao = new ActorOrActressDao();
    public static void save() {
        Film film1 = new Film("Film3");
        Award award1 = new Award("Award4");
        Award award2 = new Award("Award4");
        ActorOrActress actorOrActress1 = new ActorOrActress("ActorOrActress3", Arrays.asList(film1),Arrays.asList(award1,award2));
        try {
            actorAndActressDao.save(actorOrActress1);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAll() {
        try {
            actorAndActressDao.getAll();
        }catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void update() {
        Film film1 = new Film("Film13");
        Award award1 = new Award("Award14");
        Award award2 = new Award("Award24");
        ActorOrActress actorOrActress1 = new ActorOrActress(3,"ActorOrActress3", Arrays.asList(film1),Arrays.asList(award1,award2));
        try {
            actorAndActressDao.update(actorOrActress1);
        }catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void getById(int id) {
        try {
            actorAndActressDao.getById(id);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void delete(int id) {
        try {
            actorAndActressDao.delete(id);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
