package ba.unsa.etf.rma.vj_18565;


import android.content.Context;

public class MovieListPresenter implements IMovieListPresenter {

    private IMovieListView view;
    private IMovieListInteractor interactor;
    private Context context;

    public MovieListPresenter(IMovieListView view, Context context) {
        this.view       = view;
        this.interactor = new MovieListInteractor();
        this.context    = context;
    }
    @Override
    public void refreshMovies() {
        view.setMovies(interactor.get());
        view.notifyMovieListDataSetChanged();
    }
}

