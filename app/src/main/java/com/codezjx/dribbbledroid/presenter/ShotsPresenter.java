package com.codezjx.dribbbledroid.presenter;

import android.util.Log;

import com.codezjx.dribbbledroid.contract.ShotsContract;
import com.codezjx.dribbbledroid.model.Shot;
import com.codezjx.dribbbledroid.network.DribbbleApi;
import com.codezjx.dribbbledroid.network.DribbbleManager;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * Created by codezjx on 2016/6/14.<br/>
 */
public class ShotsPresenter implements ShotsContract.Presenter {

    private static final String TAG = "ShotsPresenter";
    private ShotsContract.View mShotsView;
    // Record current shots page
    private int mCurrentPage = 1;

    public ShotsPresenter(ShotsContract.View shotsView) {
        mShotsView = shotsView;
        mShotsView.setPresenter(this);
    }

    @Override
    public void getShotList(String list, String timeframe, String sort) {
        DribbbleManager.getInstance().getDribbbleApi().getShotList(list, timeframe, sort, mCurrentPage, DribbbleApi.PER_PAGE_SIZE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<List<Shot>>() {
                @Override
                public void call(List<Shot> shots) {
                    Log.d(TAG, "shots size:" + shots.size());
                    for (Shot shot : shots) {
                        Log.d(TAG, "shot id:" + shot.getId() + " title:" + shot.getTitle());
                    }
                    mShotsView.showShots(shots);
                }
            }, new Action1<Throwable>() {
                @Override
                public void call(Throwable throwable) {
                    mShotsView.showError(throwable.getMessage());
                }
            });
    }

    @Override
    public void start() {

    }
}
