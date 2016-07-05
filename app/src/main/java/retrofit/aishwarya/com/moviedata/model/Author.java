package retrofit.aishwarya.com.moviedata.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aishwarya on 29/6/16.
 */
public class Author {
    @SerializedName("name")
    private Name mName;
    @SerializedName("uri")
    private Name mUri;

    public Name getName() {
        return mName;
    }

    public void setName(Name name) {
        mName = name;
    }

    public Name getUri() {
        return mUri;
    }

    public void setUri(Name uri) {
        mUri = uri;
    }
}
