package retrofit.aishwarya.com.moviedata.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aishwarya on 29/6/16.
 */
public class MovieResponse {

    @SerializedName("feed")
    private Feed mFeed;

    public Feed getFeed() {
        return mFeed;
    }

    public void setFeed(Feed feed) {
        mFeed = feed;
    }
}
