package com.codezjx.dribbbledroid.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by codezjx on 2016/6/25.<br/>
 * Dribbble comment item model.
 */
public class Comment {
    
    @SerializedName("id")
    private String mId;

    @SerializedName("body")
    private String mBody;

    @SerializedName("likes_count")
    private String mLikesCount;

    @SerializedName("likes_url")
    private String mLikesUrl;

    @SerializedName("created_at")
    private Date mCreatedAt;

    @SerializedName("updated_at")
    private Date mUpdatedAt;

    @SerializedName("user")
    private User mUser;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public String getLikesCount() {
        return mLikesCount;
    }

    public void setLikesCount(String likesCount) {
        mLikesCount = likesCount;
    }

    public String getLikesUrl() {
        return mLikesUrl;
    }

    public void setLikesUrl(String likesUrl) {
        mLikesUrl = likesUrl;
    }

    public Date getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        mCreatedAt = createdAt;
    }

    public Date getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }
}
