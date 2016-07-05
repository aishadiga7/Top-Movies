package retrofit.aishwarya.com.moviedata.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aishwarya on 29/6/16.
 */
public class Movie implements Parcelable{
    private String mMovieName;
    private String mPrice;
    private String mUrl;
    private String mSummary;

    public Movie() {

    }

    protected Movie(Parcel in) {
        mMovieName = in.readString();
        mPrice = in.readString();
        mUrl = in.readString();
        mSummary = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getMovieName() {
        return mMovieName;
    }

    public void setMovieName(String movieName) {
        mMovieName = movieName;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mMovieName);
        dest.writeString(mPrice);
        dest.writeString(mUrl);
        dest.writeString(mSummary);
    }
}
