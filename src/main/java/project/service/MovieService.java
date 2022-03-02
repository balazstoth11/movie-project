package project.service;

import java.util.List;
import project.dao.MovieDAO;
import project.dao.MovieRatingDAO;
import project.model.Movie;
import project.model.MovieRating;
import project.model.User;

public class MovieService {
    private final MovieDAO movieDao;
    private final MovieRatingDAO ratingDao;

    public MovieService(MovieDAO movieDao, MovieRatingDAO ratingDao) {
        super();
        this.movieDao = movieDao;
        this.ratingDao = ratingDao;
    }

    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    public Movie add(Movie movie) {
        return movieDao.save(movie);
    }

    public MovieRating rate(User user, Movie movie, int star) {
        MovieRating movieRating = this.ratingDao.findAllByUserIdAndMovieId(user.getId(), movie.getId())
                .orElseGet(() -> createRating(user, movie));
        return ratingDao.save(movieRating);
    }

    MovieRating createRating(User user, Movie movie) {
        return new MovieRating(user.getId(), movie.getId(), 0);
    }

}
