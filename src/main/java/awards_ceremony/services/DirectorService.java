package awards_ceremony.services;

import awards_ceremony.entities.Award;
import awards_ceremony.entities.Director;
import awards_ceremony.entities.Film;
import awards_ceremony.repositories.DirectorDao;

import java.util.Arrays;

public class DirectorService {
    public static void main(String[] args) {
        //save();
        //getAll();
        //getById(5);
        //delete(2);
        //update();
    }


    static DirectorDao directorDao = new DirectorDao();
    public static void save() {
        Film film1 = new Film("Film7");
        Award award1 = new Award("Award8");
        Director director1 = new Director("Director11", Arrays.asList(film1),award1);
        try {
            directorDao.save(director1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAll() {
        try {
            directorDao.getAll();
        }catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void update() {
        Film film1 = new Film("Film17");
        Award award1 = new Award("Award18");
        Director director1 = new Director(5,"Director21", Arrays.asList(film1),award1);
        try {
            directorDao.update(director1);
        }catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void getById(int id) {
        try {
            directorDao.getById(id);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void delete(int id) {
        try {
            directorDao.delete(id);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
