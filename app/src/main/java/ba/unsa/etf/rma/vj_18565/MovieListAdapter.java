package ba.unsa.etf.rma.vj_18565;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MovieListAdapter extends ArrayAdapter<Movie> {

    private int resource;
    public TextView titleView;
    public TextView genreView;
    public ImageView imageView;

    public MovieListAdapter(@NonNull Context context, int _resource, ArrayList<Movie> items) {
        super(context, _resource,items);
        resource = _resource;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.addAll(movies);
    }

    public Movie getMovie(int position) {
        return getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LinearLayout newView;
        if (convertView == null) {
            newView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li;
            li = (LayoutInflater)getContext().
                    getSystemService(inflater);
            li.inflate(resource, newView, true);
        } else {
            newView = (LinearLayout)convertView;
        }

        Movie movie = getItem(position);

        titleView = newView.findViewById(R.id.title);
        genreView = newView.findViewById(R.id.genre);
        imageView = newView.findViewById(R.id.icon);
        titleView.setText(movie.getTitle());
        genreView.setText(movie.getGenre());

        String genreMatch = movie.getGenre();
        try {
            Class res = R.drawable.class;
            Field field = res.getField(genreMatch);
            int drawableId = field.getInt(null);
            imageView.setImageResource(drawableId);
        }
        catch (Exception e) {
            imageView.setImageResource(R.drawable.picture1);
        }

        return newView;
    }

}

