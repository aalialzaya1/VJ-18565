package ba.unsa.etf.rma.vj_18565;

import java.util.ArrayList;

public class MovieListInteractor implements IMovieListInteractor {

    @Override
    public ArrayList<Movie> get() {
        return MoviesModel.movies;
    }
}
