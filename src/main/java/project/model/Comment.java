package project.model;

import jakarta.persistence.Column;

public class Comment extends BaseModel {
    @Column
    private User user;
    @Column(name = "movie_id")
    private int movieId;
    @Column
    private String content;

    public Comment(User user, int movieId, String content) {
        this.user = user;
        this.movieId = movieId;
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getContent() {
        return content;
    }
}
