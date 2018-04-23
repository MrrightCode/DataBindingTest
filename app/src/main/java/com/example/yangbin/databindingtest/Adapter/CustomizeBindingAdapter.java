package com.example.yangbin.databindingtest.Adapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by yangbin on 2018/4/23.
 */
public class CustomizeBindingAdapter {

    @BindingAdapter({"app:imageUrl","app:placeHolder"})
    public static void imageLoader(ImageView imageView, String url, Drawable drawable){
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(drawable)
                .into(imageView);
    }
}
