package com.codezjx.dribbbledroid.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.codezjx.dribbbledroid.R;
import com.codezjx.dribbbledroid.databinding.ShotsGridItemBinding;
import com.codezjx.dribbbledroid.model.Shot;

import java.util.List;

/**
 * Created by codezjx on 2016/6/15.<br/>
 */
public class ShotsAdapter extends RecyclerView.Adapter<ShotsAdapter.ShotsViewHolder> {

    private List<Shot> mShots;

    public ShotsAdapter(List<Shot> shots) {
        mShots = shots;
    }

    public static class ShotsViewHolder extends RecyclerView.ViewHolder {
        ShotsGridItemBinding mDataBinding;
        public ShotsViewHolder(ShotsGridItemBinding dataBinding) {
            super(dataBinding.getRoot());
            mDataBinding = dataBinding;
        }
    }

    @Override
    public ShotsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ShotsGridItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.shots_grid_item,
                parent,
                false
        );
        return new ShotsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ShotsViewHolder holder, int position) {
        Shot shot = mShots.get(position);
        holder.mDataBinding.setShot(shot);
    }

    @Override
    public int getItemCount() {
        return mShots.size();
    }
}
