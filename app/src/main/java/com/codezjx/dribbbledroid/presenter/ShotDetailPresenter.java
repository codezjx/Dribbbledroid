package com.codezjx.dribbbledroid.presenter;

import com.codezjx.dribbbledroid.contract.ShotDetailContract;
import com.codezjx.dribbbledroid.model.Shot;

/**
 * Created by codezjx on 2016/6/22.<br/>
 */
public class ShotDetailPresenter implements ShotDetailContract.Presenter {

    private Shot mShot;
    private ShotDetailContract.View mShotDetailView;
    
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
}
