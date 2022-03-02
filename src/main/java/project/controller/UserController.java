package project.controller;

import project.model.User;
import project.view.UserView;

public class UserController implements BaseController {
    private User user;
    private UserView userView;

    public UserController(User user, UserView userView) {
        this.user = user;
        this.userView = userView;
    }

    @Override
    public void displayDetails(long id) {

    }
}
