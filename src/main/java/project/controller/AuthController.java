package project.controller;

import project.dao.UserDao;
import project.model.User;

public class AuthController {

    private UserDao dao;

    public AuthController(UserDao dao) {
        this.dao = dao;
    }

    public void register(User user) {
        dao.save(user);
        System.out.println("Successful registration!");
    }

    public void login(User user) {

    }

    public void logout(User user) {

    }

    private boolean isLoggedIn(User user) {
        return true;
    }
}
