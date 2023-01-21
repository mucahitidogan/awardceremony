package awards_ceremony.services;

import awards_ceremony.entities.*;
import awards_ceremony.repositories.FilmDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilmService {
    public static void main(String[] args) {
        //save();
        getAll();
        //getById(4);
        //update();
        //delete(4);
    }

    static FilmDao filmDao = new FilmDao();
    public static void save() {
        ActorOrActress actorOrActress1 = new ActorOrActress("ActorOrActress1");
        ActorOrActress actorOrActress2 = new ActorOrActress("ActorOrActress3");
        Award award1 = new Award("Award1");
        Award award2 = new Award("Award3");
        Category category1 = new Category("Category1");
        Category category2 = new Category("Category3");
        Film film1 = new Film("Film4",
                                Arrays.asList(actorOrActress2),
                                new Director("Director2"),
                                Arrays.asList(award2),
                                Arrays.asList(category2));
        try {
            filmDao.save(film1);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void getAll() {
        try {
            filmDao.getAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getById(int id) {
        try {
            filmDao.getById(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(){
        ActorOrActress actorOrActress1 = new ActorOrActress("ActorOrActress27");
        Award award1 = new Award("Award28");
        Category category1 = new Category("Category33");
        Film film1 = new Film(4,"Film4",
                Arrays.asList(actorOrActress1),
                new Director("Director15"),
                Arrays.asList(award1),
                Arrays.asList(category1));
        try {
            filmDao.update(film1);
            getAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        try {
            filmDao.delete(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
