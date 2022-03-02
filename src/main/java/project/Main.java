package project;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import project.controller.AuthController;
import project.dao.UserDao;
import project.model.User;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MovieProjectPU");
        EntityManager em = emf.createEntityManager();
        AuthController ac = new AuthController(new UserDao(em));

        User user = new User("Test2", "Test2", "test@test.est", 1993, LocalDate.now(), "password1", "TestName2");
        ac.register(user);
    }
}
