package project.controller;

import project.dao.BaseDao;
import project.model.User;

public class AuthController {

    private BaseDao dao;

    public AuthController(BaseDao dao) {
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
