package retrofit.aishwarya.com.moviedata.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aishwarya on 29/6/16.
 */
public class Name {
    @SerializedName("label")
    private String mLabel;

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        mLabel = label;
    }
}
