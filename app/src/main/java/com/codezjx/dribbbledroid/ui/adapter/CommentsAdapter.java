package com.codezjx.dribbbledroid.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.codezjx.dribbbledroid.R;
import com.codezjx.dribbbledroid.databinding.CommentsListItemBinding;
import com.codezjx.dribbbledroid.model.Comment;

import java.util.List;

/**
 * Created by codezjx on 2016/6/28.<br/>
 */
public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {

    private Context mContext;
    private List<Comment> mComments;

    public CommentsAdapter(Context context, List<Comment> comments) {
        mContext = context;
        mComments = comments;
    }

    public static class CommentViewHolder extends RecyclerView.ViewHolder {
        CommentsListItemBinding mBinding;
        public CommentViewHolder(CommentsListItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommentsListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.comments_list_item,
                parent,
                false
        );
        return new CommentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        Comment comment = mComments.get(position);
        holder.mBinding.setComment(comment);
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }
}
