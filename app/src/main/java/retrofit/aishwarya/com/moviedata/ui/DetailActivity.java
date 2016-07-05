package retrofit.aishwarya.com.moviedata.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit.aishwarya.com.moviedata.R;
import retrofit.aishwarya.com.moviedata.model.Movie;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                Movie movie = bundle.getParcelable("movies");
                initUi(movie);
            }
        }

    }

    private void initUi(Movie movie) {
        if (movie != null) {
            TextView summary = (TextView) findViewById(R.id.summary);
            ImageView image = (ImageView) findViewById(R.id.image);
            if (summary != null) {
                summary.setText(movie.getSummary());
            }
            Picasso.with(this).load(movie.getUrl()).into(image);
        }

    }
}
