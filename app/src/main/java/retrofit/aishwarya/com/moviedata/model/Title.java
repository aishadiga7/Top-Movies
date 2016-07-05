package retrofit.aishwarya.com.moviedata.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aishwarya on 29/6/16.
 */
public class Title {
    @SerializedName("label")
    private String mTitle;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
