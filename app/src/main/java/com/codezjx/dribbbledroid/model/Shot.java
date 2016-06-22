package com.codezjx.dribbbledroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by codezjx on 2016/6/14.<br/>
 * Dribbble shot item model.
 */
public class Shot implements Parcelable {

    @SerializedName("id")
    private String mId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("views_count")
    private int mViewsCount;

    @SerializedName("comments_count")
    private int mCommentsCount;

    @SerializedName("likes_count")
    private int mLikesCount;

    @SerializedName("user")
    private User mUser;

    @SerializedName("images")
    private Image mImage;

    @SerializedName("team")
    private Team mTeam;

    @SerializedName("animated")
    private boolean mAnimated;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getViewsCount() {
        return mViewsCount;
    }

    public void setViewsCount(int viewsCount) {
        mViewsCount = viewsCount;
    }

    public int getCommentsCount() {
        return mCommentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        mCommentsCount = commentsCount;
    }

    public int getLikesCount() {
        return mLikesCount;
    }

    public void setLikesCount(int likesCount) {
        mLikesCount = likesCount;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public Image getImage() {
        return mImage;
    }

    public void setImage(Image image) {
        mImage = image;
    }

    public Team getTeam() {
        return mTeam;
    }

    public void setTeam(Team team) {
        mTeam = team;
    }

    public boolean isAnimated() {
        return mAnimated;
    }

    public void setAnimated(boolean animated) {
        mAnimated = animated;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mId);
        dest.writeString(this.mTitle);
        dest.writeString(this.mDescription);
        dest.writeInt(this.mViewsCount);
        dest.writeInt(this.mCommentsCount);
        dest.writeInt(this.mLikesCount);
        dest.writeParcelable(this.mUser, flags);
        dest.writeParcelable(this.mImage, flags);
        dest.writeParcelable(this.mTeam, flags);
        dest.writeByte(this.mAnimated ? (byte) 1 : (byte) 0);
    }

    public Shot() {
    }

    protected Shot(Parcel in) {
        this.mId = in.readString();
        this.mTitle = in.readString();
        this.mDescription = in.readString();
        this.mViewsCount = in.readInt();
        this.mCommentsCount = in.readInt();
        this.mLikesCount = in.readInt();
        this.mUser = in.readParcelable(User.class.getClassLoader());
        this.mImage = in.readParcelable(Image.class.getClassLoader());
        this.mTeam = in.readParcelable(Team.class.getClassLoader());
        this.mAnimated = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Shot> CREATOR = new Parcelable.Creator<Shot>() {
        @Override
        public Shot createFromParcel(Parcel source) {
            return new Shot(source);
        }

        @Override
        public Shot[] newArray(int size) {
            return new Shot[size];
        }
    };
}
