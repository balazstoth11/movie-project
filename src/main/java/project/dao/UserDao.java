package project.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import project.model.User;

import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {

    private EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    /**
     * JQPL Query vs. SQL Query ("native" query)
     */
    @Override
    public List<User> getAll() {
        Query query = entityManager.createQuery("SELECT u from User u");
        return query.getResultList();
    }

    /**
     * Lambda expression!
     *
     * @param user
     */
    @Override
    public void save(User user) {
        runInTransaction(em -> em.persist(user), entityManager);
    }

    @Override
    public void update(User user, String[] params) {
        throw new UnsupportedOperationException("no");
    }

    @Override
    public void delete(User user) {
        runInTransaction(em -> em.remove(user), entityManager);
    }
}
