package project.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class BaseDao<T> implements Dao<T> {
    java.util.logging.Logger logger = java.util.logging.Logger.getLogger("BaseDao");
    private final EntityManager entityManager;
    private final Class<T> entityClass;
    private final String entityName;

    public BaseDao(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
        this.entityName = entityManager.getMetamodel().entity(entityClass).getName();
    }

    @Override
    public Optional<T> find(long id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    /**
     * JQPL Query vs. SQL Query ("native" query)
     */
    @Override
    public List<T> findAll() {
        Query query = entityManager.createQuery(String.format("SELECT u from %s u", this.getEntityName()));
        return query.getResultList();
    }

    /**
     * Lambda expression!
     *
     * @param user
     */
    @Override
    public T save(T user) {
        return runInTransactionF(em -> em.merge(user), entityManager);
    }

    @Override
    public void delete(T user) {
        runInTransaction(em -> em.remove(user), entityManager);
    }

    /**
     * default Consumer (Function, Supplier, etc) Functional Interface commit vs. rollback ismétlés
     *
     */
    protected void runInTransaction(Consumer<EntityManager> action, EntityManager entityManager) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }

    protected <T> T runInTransactionF(Function<EntityManager, T> action, EntityManager entityManager) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            T ret = action.apply(entityManager);
            tx.commit();
            return ret;
        } catch (RuntimeException e) {
            logger.severe(e::getMessage);
            tx.rollback();
            throw e;
        }
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected Class<T> getEntityClass() {
        return entityClass;
    }

    protected String getEntityName() {
        return entityName;
    }

}
