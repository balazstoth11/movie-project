package project;

import java.util.List;
import java.util.logging.Logger;
import project.model.Category;
import project.model.Movie;
import project.service.MovieService;

public class Main {
    private static final Logger log = Logger.getLogger("main");

    public static void main(String[] args) {
        if (args.length == 2 && args[0].equalsIgnoreCase("movie") && args[1].equalsIgnoreCase("list")) {
            List<Movie> movies = Components.get(MovieService.class).findAll();
            movies.forEach(m -> log.info(m.toString()));
            return;
        }
        if (args.length == 6 && args[0].equalsIgnoreCase("movie") && args[1].equalsIgnoreCase("add")) {
            Movie movie = new Movie(args[2], Integer.valueOf(args[3]), Category.valueOf(args[4]), args[5]);
            Components.get(MovieService.class).add(movie);
            return;
        }
        log.info("TODO");
    }
}
