package awards_ceremony.repositories;

public interface ICrud<T> {
    void save(T t);
    void getAll();
    void getById(int id);
    void update(T t);
    void delete(int id);
}
