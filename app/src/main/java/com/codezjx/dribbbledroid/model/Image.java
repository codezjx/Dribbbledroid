package com.codezjx.dribbbledroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by codezjx on 2016/6/15.<br/>
 * Dribbble shot image model.
 */
public class Image {

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
}
