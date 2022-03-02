package project.dao;

import jakarta.persistence.EntityManager;
import project.model.User;

public final class UserDAO extends BaseDao<User> {

    public UserDAO(EntityManager entityManager) {
        super(entityManager, User.class);
    }
}
