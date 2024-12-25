package ir.maktabsharif.loginandregister.repository.impl;

import ir.maktabsharif.loginandregister.model.User;
import ir.maktabsharif.loginandregister.repository.UsersRepository;
import ir.maktabsharif.loginandregister.utility.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UsersRepositoryImpl extends BaseRepositoryImpl<User,Long> implements UsersRepository {
    private final EntityManagerFactory emf = JPAUtil.getEmf();
    @Override
    Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User login(String username, String password) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(getEntityClass());
        Root<User> root = cq.from(getEntityClass());
        cq.where(cb.equal(root.get("username"), username));
        cq.where(cb.equal(root.get("password"), password));
        TypedQuery<User> query = em.createQuery(cq);
        List<User> users = query.getResultList();
       return users.isEmpty() ? null : users.get(0);
    }
}
