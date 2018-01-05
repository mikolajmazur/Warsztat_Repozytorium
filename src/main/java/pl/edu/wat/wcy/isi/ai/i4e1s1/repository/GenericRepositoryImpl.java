package pl.edu.wat.wcy.isi.ai.i4e1s1.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

public class GenericRepositoryImpl<E extends Serializable> implements GenericRepository<E> {
    private final EntityManagerFactory factory;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Class<E> clazz;

    public GenericRepositoryImpl(EntityManagerFactory factory, Class<E> clazz){
        this.factory = factory;
        this.clazz = clazz;
    }

    @Override
    public void create(E entity) {
        createManagerAndBeginTransaction();
        entityManager.persist(entity);
        commitTransactionAndCloseManager();
    }

    @Override
    @SuppressWarnings("unchecked")
    public E getByPrimaryKey(Object primaryKey) {
        E result;
        createManagerAndBeginTransaction();
        result = entityManager.find(clazz, primaryKey);
        commitTransactionAndCloseManager();
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<E> getAll() {
        List<E> result;
        createManagerAndBeginTransaction();
        result = entityManager.createQuery("from " + clazz.getName()).getResultList();
        return result;
    }

    @Override
    public void update(E entity) {
        createManagerAndBeginTransaction();
        entityManager.merge(entity);
        commitTransactionAndCloseManager();
    }

    @Override
    public void delete(E entity) {
        createManagerAndBeginTransaction();
        entityManager.remove(entity);
        commitTransactionAndCloseManager();
    }

    @Override
    public void deleteByPrimaryKey(Object primaryKey) {
        E entity = this.getByPrimaryKey(primaryKey);
        this.delete(entity);
    }

    private void createManagerAndBeginTransaction(){
        this.entityManager = factory.createEntityManager();
        this.transaction = entityManager.getTransaction();
        this.transaction.begin();
    }

    private void commitTransactionAndCloseManager() {
        this.transaction.commit();
        this.entityManager.close();
    }
}
