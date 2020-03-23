package ba.unsa.etf.rma.vj_18565;

import android.content.Context;

public class MovieDetailPresenter implements IMovieDetailPresenter {

    private IMovieListView view;
    private IMovieListInteractor interactor;
    private Context context;
    @Override
    public void refreshMovies() {
        view.setMovies(interactor.get());
        view.notifyMovieListDataSetChanged();
    }
}