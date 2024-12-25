package ir.maktabsharif.loginandregister.repository.impl;

import ir.maktabsharif.loginandregister.model.BaseModel;
import ir.maktabsharif.loginandregister.repository.BaseRepository;
import ir.maktabsharif.loginandregister.utility.JPAUtil;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Getter
public abstract class BaseRepositoryImpl<T extends BaseModel<ID>, ID extends Serializable> implements BaseRepository<T, ID> {
    private final EntityManagerFactory emf = JPAUtil.getEmf();

    abstract Class<T> getEntityClass();

    @Override
    public void saveOrUpdate(T obj) {
        if (obj.getId() == null) {
            persist(obj);
        } else merge(obj);
    }

    @Override
    public void delete(ID id) {
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Optional<T> byId = findById(id);
            byId.ifPresent(em::remove);
            transaction.commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }finally {
            em.close();
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        EntityManager em = emf.createEntityManager();
        Class<T> entityClass = getEntityClass();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> root = cq.from(entityClass);
        cq.where(cb.equal(root.get("id"), id));
        TypedQuery<T> query = em.createQuery(cq);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<T> findAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
        Root<T> root = cq.from(getEntityClass());
        cq.select(root);
        TypedQuery<T> query = em.createQuery(cq);
        return query.getResultList();
    }

    public void persist(T obj) {
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(obj);
            transaction.commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException();
        } finally {
            em.close();
        }
    }

    public void merge(T obj) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException();
        } finally {
            em.close();
        }
    }
}
