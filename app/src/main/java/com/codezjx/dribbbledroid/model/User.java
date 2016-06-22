package com.codezjx.dribbbledroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by codezjx on 2016/6/14.<br/>
 * Dribbble user model.
 */
public class User implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mId);
        dest.writeString(this.mName);
        dest.writeString(this.mUserName);
        dest.writeString(this.mAvatarUrl);
        dest.writeString(this.mLocation);
        dest.writeString(this.mBio);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.mId = in.readString();
        this.mName = in.readString();
        this.mUserName = in.readString();
        this.mAvatarUrl = in.readString();
        this.mLocation = in.readString();
        this.mBio = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
