package pl.edu.wat.wcy.isi.ai.i4e1s1.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<E extends Serializable> {
    void create(E entity);
    E getByPrimaryKey(Object primaryKey);
    List<E> getAll();
    void update(E entity);
    void delete(E entity);
    void deleteByPrimaryKey(Object primaryKey);
}
