package com.codezjx.dribbbledroid.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by codezjx on 2016/6/15.<br/>
 * Base abstract fragment which will not reCreate view.
 */
public abstract class AbstractSaveStateFragment extends Fragment {
    protected View mRootView;

    @Override
    public View onCreateView(LayoutInflater pInflater, ViewGroup pContainer, Bundle pSavedInstanceState) {
        if (mRootView == null) {
            mRootView = getContentView(pInflater, pContainer);
            onCreateViewInChild(pInflater, pContainer, pSavedInstanceState);
        }
        // If the mRootView is already init, just return.(Warning: we must remove it from parent, otherwise it will cause a Exception)
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }
        return mRootView;
    }

    protected abstract View getContentView(LayoutInflater pInflater, ViewGroup pContainer);

    protected abstract void onCreateViewInChild(LayoutInflater pInflater, ViewGroup pContainer, Bundle pSavedInstanceState);
}
