package iuh.software.service;

public interface CrudService<T> {

    T add (T t);
    void delete(T t);
    void update (T t);
}
