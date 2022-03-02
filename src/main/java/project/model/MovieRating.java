package project.model;

import jakarta.persistence.Entity;

@Entity
public class MovieRating extends BaseModel{
    private int userId;
    private int movieId;
    private int rate;

    public MovieRating(int userId, int movieId, int rate) {
        this.userId = userId;
        this.movieId = movieId;
        this.rate = rate;
    }

    public int getUserId() {
        return userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getRate() {
        return rate;
    }
}
