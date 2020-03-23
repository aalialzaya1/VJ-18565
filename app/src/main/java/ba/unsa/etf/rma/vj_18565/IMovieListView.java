package ba.unsa.etf.rma.vj_18565;

import java.util.ArrayList;

public interface IMovieListView {
    void setMovies(ArrayList<Movie> movies);
    void notifyMovieListDataSetChanged();
}
