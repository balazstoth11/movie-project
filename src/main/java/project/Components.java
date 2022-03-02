package project;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;
import project.dao.MovieDAO;
import project.dao.MovieRatingDAO;
import project.dao.UserDAO;
import project.service.MovieService;
import project.service.UserService;

@SuppressWarnings("rawtypes")
public class Components {

    private static final Components d = new Components();

    public static void register(Class clazz, Supplier<Object> s) {
        Components.d.def.putIfAbsent(clazz, s);
    }

    public static <T> T get(Class<T> clazz) {
        return d.getOrCreate(clazz);
    }

    ConcurrentMap<Class, Object> di;
    Map<Class, Supplier<Object>> def;

    Components() {
        this.di = new ConcurrentHashMap<>();
        this.def = Map.of( //
                EntityManager.class, this::em, //
                UserDAO.class, this::userDAO, //
                UserService.class, this::userService, //
                MovieDAO.class, this::movieDAO, //
                MovieRatingDAO.class, this::movieRatingDAO, //
                MovieService.class, this::movieService);
    }

    @SuppressWarnings("unchecked")
    <T> T getOrCreate(Class<T> clazz) {
        return (T) this.di.computeIfAbsent(clazz, c -> Objects.requireNonNull(this.def.get(c), "missing: " + c).get());
    }

    private EntityManager em() {
        return Persistence.createEntityManagerFactory("MovieProjectPU").createEntityManager();
    }

    private UserDAO userDAO() {
        return new UserDAO(this.getOrCreate(EntityManager.class));
    }

    private UserService userService() {
        return new UserService(this.getOrCreate(UserDAO.class));
    }

    private MovieDAO movieDAO() {
        return new MovieDAO(this.getOrCreate(EntityManager.class));
    }

    private MovieRatingDAO movieRatingDAO() {
        return new MovieRatingDAO(this.getOrCreate(EntityManager.class));
    }

    private MovieService movieService() {
        return new MovieService(this.getOrCreate(MovieDAO.class), this.getOrCreate(MovieRatingDAO.class));
    }
}