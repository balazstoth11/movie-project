package project.view;

import project.model.Category;

import java.util.List;

public class MovieView {
    public void printMovieDetails(String title, int productionYear, Category category, String director, List<String> cast) {
        System.out.println("Title: " + title);
        System.out.println("ProductionYear: " + productionYear);
        System.out.println("Category: " + category);
        System.out.println("Director: " + director);
        System.out.println("Cast: ");
        for (String actor : cast) {
            System.out.println(actor);
        }
    }

    public void printMovieComments(String userName, String comment, int rate) {
        System.out.println("UserName: " + userName);
        System.out.println("Comment: " + comment);
        System.out.println("Rate: " + rate);
    }

    public void printAverageMovieRating(List<Integer> rateList) {
        System.out.println("Rate: ");

        int n = 0;
        for (int rate : rateList) {
            n += rate;
        }
        int avg = n / rateList.size();
        System.out.println(avg);
    }
}
