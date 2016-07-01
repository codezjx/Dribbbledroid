package com.codezjx.dribbbledroid.presenter;

import android.util.Log;

import com.codezjx.dribbbledroid.contract.UserDetailContract;
import com.codezjx.dribbbledroid.model.Shot;
import com.codezjx.dribbbledroid.model.User;
import com.codezjx.dribbbledroid.network.DribbbleApi;
import com.codezjx.dribbbledroid.network.DribbbleManager;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by codezjx on 2016/7/1.<br/>
 */
public class UserDetailPresenter implements UserDetailContract.Presenter {

    private static final String TAG = "UserDetailPresenter";
    private User mUser;
    private UserDetailContract.View mUserDetailView;
    // Record current shot page
    private int mCurrentShotPage = 1;

    public UserDetailPresenter(User user, UserDetailContract.View userDetailView) {
        mUser = user;
        mUserDetailView = userDetailView;
        mUserDetailView.setPresenter(this);
    }

    @Override
    public void start() {
        if (mUser != null) {
            mUserDetailView.showUserDetail(mUser);
        } else {
            mUserDetailView.showError("Error: user object is null!");
        }
    }

    @Override
    public void loadUserShots(String userId) {
        DribbbleManager.getInstance().getDribbbleApi().getUserShots(userId, mCurrentShotPage, DribbbleApi.PER_PAGE_SIZE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Shot>>() {
                    @Override
                    public void call(List<Shot> shots) {
                        for (Shot shot : shots) {
                            Log.d(TAG, "shot:" + shot.getTitle());
                        }
                        mUserDetailView.showUserShots(shots);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mUserDetailView.showError(throwable.getMessage());
                    }
                });
    }
}
