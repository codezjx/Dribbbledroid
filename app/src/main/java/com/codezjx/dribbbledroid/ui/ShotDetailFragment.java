package com.codezjx.dribbbledroid.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codezjx.dribbbledroid.R;
import com.codezjx.dribbbledroid.contract.ShotDetailContract;
import com.codezjx.dribbbledroid.databinding.FragmentShotDetailBinding;
import com.codezjx.dribbbledroid.model.Comment;
import com.codezjx.dribbbledroid.model.Shot;
import com.codezjx.dribbbledroid.ui.adapter.CommentsAdapter;
import com.codezjx.dribbbledroid.ui.base.AbstractSaveStateFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codezjx on 2016/6/22.<br/>
 * Fragment to show shot detail.
 */
public class ShotDetailFragment extends AbstractSaveStateFragment implements ShotDetailContract.View {

    private static final String TAG = "ShotDetailFragment" ;
    private ShotDetailContract.Presenter mPresenter;
    private FragmentShotDetailBinding mBinding;
    private List<Comment> mComments;
    private CommentsAdapter mCommentsAdapter;
            
    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_shot_detail, container, false);
    }

    @Override
    protected void onCreateViewInChild(LayoutInflater pInflater, ViewGroup pContainer, Bundle pSavedInstanceState) {
        mBinding = FragmentShotDetailBinding.bind(mRootView);
        // Init comments recycler view
        mComments = new ArrayList<Comment>();
        mCommentsAdapter = new CommentsAdapter(getContext(), mComments);
        mBinding.commentsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.commentsRecyclerView.setAdapter(mCommentsAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showShotDetail(Shot shot) {
        mBinding.setShot(shot);
        mPresenter.loadShotComments(shot.getId());
    }

    @Override
    public void showComments(List<Comment> comments) {
        mComments.addAll(comments);
        mCommentsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String errorMsg) {
        Snackbar.make(mRootView, "Error occur:" + errorMsg, Snackbar.LENGTH_LONG)
                .setAction("Close", null).show();
    }

    @Override
    public void setPresenter(ShotDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
