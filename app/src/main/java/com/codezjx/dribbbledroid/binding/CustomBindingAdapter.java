package com.codezjx.dribbbledroid.binding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.codezjx.dribbbledroid.utils.glide.CropCircleTransformation;

/**
 * Created by codezjx on 2016/6/16.<br/>
 * Custom {@link BindingAdapter}, for more information, visit following link.
 * @see <a href="https://developer.android.com/topic/libraries/data-binding/index.html#custom_setters">Data-binding custom setters</a>
 */
public class CustomBindingAdapter {

    @BindingAdapter({"imageUrl", "error", "placeholder", "isCircle"})
    public static void loadImage(ImageView imageView, String url, Drawable error, Drawable placeholder, boolean isCircle) {
        Context context = imageView.getContext();
        DrawableRequestBuilder builder = Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(error)
                .placeholder(placeholder)
                .crossFade();
        if (isCircle) {
            builder.bitmapTransform(new CropCircleTransformation(context));
        }
        builder.into(imageView);
    }
}
