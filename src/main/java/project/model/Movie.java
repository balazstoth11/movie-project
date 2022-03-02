package project.model;

import jakarta.persistence.Column;

import java.util.ArrayList;
import java.util.List;

public class Movie extends BaseModel {
    @Column
    private String title;
    @Column(name = "production_year")
    private int productionYear;
    @Column
    private Category category;
    @Column
    private String director;
    @Column
    private List<String> cast;

    public Movie(String title, int productionYear, Category category, String director, List<String> cast) {
        this.title = title;
        this.productionYear = productionYear;
        this.category = category;
        this.director = director;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public Category getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getCast() {
        return new ArrayList<>(cast);
    }
}
