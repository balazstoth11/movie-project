package project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Movie extends BaseModel {
    @Column
    private String title;
    @Column(name = "production_year")
    private int productionYear;
    @Column
    private Category category;
    @Column
    private String director;

    protected Movie() {
    }

    public Movie(String title, int productionYear, Category category, String director) {
        this.title = title;
        this.productionYear = productionYear;
        this.category = category;
        this.director = director;
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

    @Override
    public String toString() {
        return "Movie [title=" + title + ", productionYear=" + productionYear + ", category=" + category + ", director="
                + director + "]";
    }
    
}
