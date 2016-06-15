package com.codezjx.dribbbledroid.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by codezjx on 2016/6/15.<br/>
 */
public class ActivityUtils {

    /**
     * The {@link Fragment} is added to the container view with specify id. The operation is
     * performed by the {@link FragmentManager}.
     *
     */
    public static void addFragmentToActivity (FragmentManager fragmentManager, Fragment fragment, int frameId) {
        if (fragmentManager == null || fragment == null) {
            return;
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }
}
