package retrofit.aishwarya.com.moviedata.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aishwarya on 29/6/16.
 */
public class Image {
    @SerializedName("label")
    private String mUrl;

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
