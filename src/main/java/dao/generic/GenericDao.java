package dao.generic;

import domain.IPersistente;
import exceptions.DaoException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class GenericDao <T extends IPersistente, E extends Serializable> implements IGenericDao <T,E> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected final Class<T> persistenteClass;

    public GenericDao(Class<T> persistenteClass) {
        this.persistenteClass = persistenteClass;
    }

    @Override
    public T cadastrar(T entity) throws DaoException {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void excluir(T entity) throws DaoException {
    	entity = entityManager.merge(entity);
        if (entityManager.contains(entity)) {
        	entityManager.remove(entity);
        }
        else {
            T managedCustomer = entityManager.find(this.persistenteClass, entity);
            if (managedCustomer != null) entityManager.remove(managedCustomer);
        }
    }

    @Override
    public T alterar(T entity) {
    	entity = entityManager.merge(entity);
        return entity;
    }

    @Override
    public T consultar(E valor) {
        return entityManager.find(this.persistenteClass, valor);
    }

    @Override
    public Collection<T> buscarTodos() {
        return entityManager.createQuery(getSelectSql(), this.persistenteClass).getResultList();
    }

    @Override
    public void excluirTodos() {
        List<T> list = (List<T>) buscarTodos();
        if (list.size() > 0) {
            list.forEach(element -> {
                try {
                    excluir(element);
                } catch (DaoException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    protected String getSelectSql() {
        return "select obj from " +
                this.persistenteClass.getSimpleName() +
                " obj";
    }
}
