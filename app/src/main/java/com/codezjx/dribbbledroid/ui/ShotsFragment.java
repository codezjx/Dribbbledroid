package com.codezjx.dribbbledroid.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codezjx.dribbbledroid.R;
import com.codezjx.dribbbledroid.contract.ShotsContract;
import com.codezjx.dribbbledroid.databinding.FragmentShotsBinding;
import com.codezjx.dribbbledroid.model.Shot;
import com.codezjx.dribbbledroid.ui.adapter.ShotsAdapter;
import com.codezjx.dribbbledroid.ui.base.AbstractSaveStateFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codezjx on 2016/6/15.<br/>
 * Fragment to show shots.
 */
public class ShotsFragment extends AbstractSaveStateFragment implements ShotsContract.View {

    private static final int COLUMNS = 2;
    private ShotsContract.Presenter mPresenter;
    private FragmentShotsBinding mBinding;
    private ShotsAdapter mAdapter;
    private List<Shot> mShots;

    public static ShotsFragment newInstance() {
        return new ShotsFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.getShotList("animated", "year", "");
        }
    }

    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container) {
        mBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_shots,
                container,
                false);
        return mBinding.getRoot();
    }

    @Override
    protected void onCreateViewInChild(LayoutInflater pInflater, ViewGroup pContainer, Bundle pSavedInstanceState) {
        mShots = new ArrayList<Shot>();
        // Init recycler view
        mAdapter = new ShotsAdapter(getContext(), mShots);
        mBinding.shotsRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), COLUMNS));
        mBinding.shotsRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showShots(List<Shot> shots) {
        mShots.addAll(shots);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String errorMsg) {
        Snackbar.make(mRootView, "Error occur:" + errorMsg, Snackbar.LENGTH_LONG)
                .setAction("Close", null).show();
    }

    @Override
    public void setPresenter(ShotsContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
