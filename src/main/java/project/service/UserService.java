package project.service;

import project.dao.Dao;
import project.model.User;

public class UserService {
    private final Dao<User> dao;

    public UserService(Dao<User> dao) {
        super();
        this.dao = dao;
    }

   public  User register(User user) {
        return dao.save(user);
    }
}
