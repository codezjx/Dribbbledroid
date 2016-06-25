package com.codezjx.dribbbledroid.presenter;

import android.util.Log;

import com.codezjx.dribbbledroid.contract.ShotDetailContract;
import com.codezjx.dribbbledroid.model.Comment;
import com.codezjx.dribbbledroid.model.Shot;
import com.codezjx.dribbbledroid.network.DribbbleApi;
import com.codezjx.dribbbledroid.network.DribbbleManager;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by codezjx on 2016/6/22.<br/>
 */
public class ShotDetailPresenter implements ShotDetailContract.Presenter {

    private static final String TAG = "ShotDetailPresenter"; 
    private Shot mShot;
    private ShotDetailContract.View mShotDetailView;
    // Record current comment page
    private int mCurrentCommentPage = 1;
    
    public ShotDetailPresenter(Shot shot, ShotDetailContract.View shotDetailView) {
        mShot = shot;
        mShotDetailView = shotDetailView;
        mShotDetailView.setPresenter(this);
    }
    
    @Override
    public void start() {
        if (mShot != null) {
            mShotDetailView.showShotDetail(mShot);
        } else {
            mShotDetailView.showError("Error: shot object is null!");
        }
    }

    @Override
    public void loadShotComments(String shotId) {
        DribbbleManager.getInstance().getDribbbleApi().getCommentList(shotId, mCurrentCommentPage, DribbbleApi.PER_PAGE_SIZE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Comment>>() {
                    @Override
                    public void call(List<Comment> comments) {
                        Log.d(TAG, "comment size:" + comments.size());
                        for (Comment comment : comments) {
                            Log.d(TAG, "comment:" + comment.getBody());
                        }
                        mShotDetailView.showComments(comments);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mShotDetailView.showError(throwable.getMessage());
                    }
                });
    }
}
