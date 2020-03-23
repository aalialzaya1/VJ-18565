package ba.unsa.etf.rma.vj_18565;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static ba.unsa.etf.rma.vj_18565.MoviesModel.movies;

public class MainActivity extends AppCompatActivity implements IMovieListView {

    private Button button;
    private ListView listView;
    private EditText editText;

    private IMovieListPresenter movieListPresenter;

    private MovieListAdapter movieListAdapter;

    public IMovieListPresenter getPresenter() {
        if (movieListPresenter == null) {
            movieListPresenter = new MovieListPresenter(this, this);
        }
        return movieListPresenter;
    }

    private AdapterView.OnItemClickListener listItemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Intent movieDetailIntent = new Intent(MainActivity.this,
                            MovieDetailActivity.class);
                    Movie movie = movieListAdapter.getMovie(position);
                    movieDetailIntent.putExtra("title", movie.getTitle());
                    movieDetailIntent.putExtra("homepage", movie.getHomepage());
                    MainActivity.this.startActivity(movieDetailIntent);
                }
            };

    private AdapterView.OnClickListener listener = new AdapterView.OnClickListener() {
        @Override
        public void onClick(View v) {
            String url = getIntent().getStringExtra("homepage");
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieListAdapter=new MovieListAdapter(getApplicationContext(), R.layout.list_element, new ArrayList<Movie>());
        listView= (ListView) findViewById(R.id.listView);
        listView.setAdapter(movieListAdapter);
        getPresenter().refreshMovies();

        listView.setOnItemClickListener(listItemClickListener);
        String title = getIntent().getStringExtra("title");

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Neki tekst");
        sendIntent.setType("text/plain");

        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }

    @Override
    public void setMovies(ArrayList<Movie> movies) {
        movieListAdapter.setMovies(movies);
    }

    @Override
    public void notifyMovieListDataSetChanged() {
        movieListAdapter.notifyDataSetChanged();
    }
}
