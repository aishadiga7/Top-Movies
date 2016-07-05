package retrofit.aishwarya.com.moviedata.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by aishwarya on 29/6/16.
 */
public class Entry {
    @SerializedName("im:name")
    private Name mImName;
    @SerializedName("rights")
    private Name mRights;
    @SerializedName("im:image")
    private ArrayList<Image> mImages;
    @SerializedName("summary")
    private Name mSummary;
    @SerializedName("im:rentalPrice")
    private RentalPrice mRentalPrice;
    @SerializedName("im:price")
    private Name mPrice;
    @SerializedName("title")
    private Name mTitle;

    public Name getImName() {
        return mImName;
    }

    public void setImName(Name imName) {
        mImName = imName;
    }

    public Name getRights() {
        return mRights;
    }

    public void setRights(Name rights) {
        mRights = rights;
    }

    public ArrayList<Image> getImages() {
        return mImages;
    }

    public void setImages(ArrayList<Image> images) {
        mImages = images;
    }

    public Name getSummary() {
        return mSummary;
    }

    public void setSummary(Name summary) {
        mSummary = summary;
    }

    public RentalPrice getRentalPrice() {
        return mRentalPrice;
    }

    public void setRentalPrice(RentalPrice rentalPrice) {
        mRentalPrice = rentalPrice;
    }

    public Name getPrice() {
        return mPrice;
    }

    public void setPrice(Name price) {
        mPrice = price;
    }

    public Name getTitle() {
        return mTitle;
    }

    public void setTitle(Name title) {
        mTitle = title;
    }
}
