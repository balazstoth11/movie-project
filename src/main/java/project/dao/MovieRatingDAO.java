package project.dao;

import jakarta.persistence.EntityManager;
import java.util.Optional;
import project.model.MovieRating;

public final class MovieRatingDAO extends BaseDao<MovieRating> {

    public MovieRatingDAO(EntityManager entityManager) {
        super(entityManager, MovieRating.class);
    }

    private final String q01 = "SELECT u FROM User u WHERE u.userId = ?1 and movieId=?2";

    public Optional<MovieRating> findAllByUserIdAndMovieId(int userId, int movieId) {
        return getEntityManager().createQuery(q01, this.getEntityClass())
                .getResultList().stream().findFirst();
    }
}
