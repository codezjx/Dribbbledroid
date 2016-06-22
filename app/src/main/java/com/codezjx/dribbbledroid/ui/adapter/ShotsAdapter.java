package com.codezjx.dribbbledroid.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codezjx.dribbbledroid.R;
import com.codezjx.dribbbledroid.databinding.ShotsGridItemBinding;
import com.codezjx.dribbbledroid.model.Shot;
import com.codezjx.dribbbledroid.ui.ShotDetailActivity;

import java.util.List;

/**
 * Created by codezjx on 2016/6/15.<br/>
 */
public class ShotsAdapter extends RecyclerView.Adapter<ShotsAdapter.ShotsViewHolder> {

    private Context mContext;
    private List<Shot> mShots;

    public ShotsAdapter(Context context, List<Shot> shots) {
        mContext = context;
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
        final Shot shot = mShots.get(position);
        holder.mDataBinding.setShot(shot);
        setVectorDrawableLeft(holder.mDataBinding.viewsTv, R.drawable.shot_view);
        setVectorDrawableLeft(holder.mDataBinding.commentsTv, R.drawable.shot_comment);
        setVectorDrawableLeft(holder.mDataBinding.likesTv, R.drawable.shot_like);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ShotDetailActivity.class);
                intent.putExtra(ShotDetailActivity.INTENT_EXTRA_SHOT, shot);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mShots.size();
    }

    private void setVectorDrawableLeft(TextView textView, int vectorDrawableId) {
        Resources res = mContext.getResources();
        Resources.Theme theme = mContext.getTheme();
        VectorDrawableCompat vectorDrawable = VectorDrawableCompat.create(res, vectorDrawableId, theme);
        if (vectorDrawable != null) {
            vectorDrawable.setTint(res.getColor(R.color.text_grey_lite));
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(vectorDrawable, null, null, null);
    }
}
