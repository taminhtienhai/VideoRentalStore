package iuh.software.service.impl;

import iuh.software.service.CrudService;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class CrudServiceImpl<T> implements CrudService<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public T add(T t) {
        return this.entityManager.merge(t);
    }

    @Override
    public void delete(T t) {
        this.entityManager.remove(t);
    }

    @Override
    public void update(T t) {
        this.entityManager.merge(t);
        this.entityManager.flush();
    }
}

