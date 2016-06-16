package com.codezjx.dribbbledroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by codezjx on 2016/6/14.<br/>
 * Dribbble team model.
 */
public class Team {

    @SerializedName("id")
    private String mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("username")
    private String mUserName;

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    @SerializedName("location")
    private String mLocation;

    @SerializedName("bio")
    private String mBio;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String bio) {
        mBio = bio;
    }
}
