package retrofit.aishwarya.com.moviedata.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit.aishwarya.com.moviedata.R;
import retrofit.aishwarya.com.moviedata.intf.MovieItemClick;
import retrofit.aishwarya.com.moviedata.model.Movie;

/**
 * Created by aishwarya on 29/6/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private ArrayList<Movie> mMovieList;
    private Context mContext;
    private MovieItemClick mMovieItemClick;


    public MoviesAdapter(ArrayList<Movie> movieList, Context context, MovieItemClick  movieItemClick) {
        mMovieList = movieList;
        mContext = context;
        this.mMovieItemClick = movieItemClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);
        holder.mName.setText(movie.getMovieName());
        holder.mPrice.setText(movie.getPrice());
        Picasso.with(mContext).load(movie.getUrl()).into(holder.mImage);
        holder.bind(movie, mMovieItemClick);
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        TextView mPrice;
        ImageView mImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.name);
            mPrice = (TextView) itemView.findViewById(R.id.price);
            mImage = (ImageView) itemView.findViewById(R.id.image);
        }

        public void bind(final Movie movie, final MovieItemClick movieItemClick) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movieItemClick.onMovieItemClick(movie);
                }
            });
        }
    }
}
