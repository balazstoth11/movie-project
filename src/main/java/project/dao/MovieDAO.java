package project.dao;

import jakarta.persistence.EntityManager;
import project.model.Movie;

public final class MovieDAO extends BaseDao<Movie> {

    public MovieDAO(EntityManager entityManager) {
        super(entityManager, Movie.class);
    }
}
