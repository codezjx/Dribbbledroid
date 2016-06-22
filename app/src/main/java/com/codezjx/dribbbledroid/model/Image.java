package com.codezjx.dribbbledroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by codezjx on 2016/6/15.<br/>
 * Dribbble shot image model.
 */
public class Image implements Parcelable {

    @SerializedName("hidpi")
    private String mHidpi;

    @SerializedName("normal")
    private String mNormal;

    @SerializedName("teaser")
    private String mTeaser;

    public String getHidpi() {
        return mHidpi;
    }

    public void setHidpi(String hidpi) {
        mHidpi = hidpi;
    }

    public String getNormal() {
        return mNormal;
    }

    public void setNormal(String normal) {
        mNormal = normal;
    }

    public String getTeaser() {
        return mTeaser;
    }

    public void setTeaser(String teaser) {
        mTeaser = teaser;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mHidpi);
        dest.writeString(this.mNormal);
        dest.writeString(this.mTeaser);
    }

    public Image() {
    }

    protected Image(Parcel in) {
        this.mHidpi = in.readString();
        this.mNormal = in.readString();
        this.mTeaser = in.readString();
    }

    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}
