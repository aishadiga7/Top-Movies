package retrofit.aishwarya.com.moviedata.ui;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import retrofit.aishwarya.com.moviedata.R;
import retrofit.aishwarya.com.moviedata.adapter.MoviesAdapter;
import retrofit.aishwarya.com.moviedata.intf.MovieItemClick;
import retrofit.aishwarya.com.moviedata.model.Entry;
import retrofit.aishwarya.com.moviedata.model.Movie;
import retrofit.aishwarya.com.moviedata.model.MovieResponse;
import retrofit.aishwarya.com.moviedata.utils.DownloadUtility;

public class MainActivity extends AppCompatActivity implements MovieItemClick {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        String url = "https://itunes.apple.com/in/rss/topmovies/limit=50/genre=4431/json";
        new DownloadMovieData().execute(url);
    }

    @Override
    public void onMovieItemClick(Movie movie) {
        if (movie != null) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("movies", movie);
            startActivity(intent);
        }

    }

    private class DownloadMovieData extends AsyncTask<String, Void, MovieResponse> {

        @Override
        protected MovieResponse doInBackground(String... params) {
            MovieResponse movieResponses = null;
            try {
                String url = DownloadUtility.downloadUrl(params[0]);
                if (!TextUtils.isEmpty(url)) {
                    Gson gson = new Gson();
                    MovieResponse movieResponse = gson.fromJson(url, MovieResponse.class);
                    Log.d(TAG, "MovieResponse:" + movieResponse);
                    movieResponses = movieResponse;
                }

            } catch (IOException e) {
                e.printStackTrace();
                movieResponses = null;
            }
            return movieResponses;
        }

        @Override
        protected void onPostExecute(MovieResponse movieResponse) {
            super.onPostExecute(movieResponse);
            if (movieResponse != null) {
                handleMovieResponseData(movieResponse);
            }
        }
    }

    private void handleMovieResponseData(MovieResponse movieResponse) {
        ArrayList<Movie> movies = new ArrayList<>();
        Movie movie;
        for (Entry entry: movieResponse.getFeed().getEntry()) {
            movie = new Movie();
            movie.setMovieName(entry.getImName().getLabel());
            movie.setPrice(entry.getPrice().getLabel());
            movie.setUrl(entry.getImages().get(0).getUrl());
            movie.setSummary(entry.getSummary().getLabel());
            movies.add(movie);
        }
        Log.d(TAG, "SIZE:" +movies.size());
        initRecyclerView(movies);
    }

    private void initRecyclerView(ArrayList<Movie> movies) {
        RecyclerView movieRecyclerView = (RecyclerView) findViewById(R.id .movie_items);
        if (movieRecyclerView != null) {
            movieRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            MoviesAdapter placesAdapter = new MoviesAdapter(movies, this, this);
            movieRecyclerView.setAdapter(placesAdapter);
            movieRecyclerView.setItemAnimator(new DefaultItemAnimator());
        }
    }


}
