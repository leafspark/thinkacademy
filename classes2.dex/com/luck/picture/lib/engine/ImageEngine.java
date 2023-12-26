package com.luck.picture.lib.engine;

import android.content.Context;
import android.widget.ImageView;
import com.luck.picture.lib.listener.OnImageCompleteCallback;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;

public interface ImageEngine {
    void loadAsGifImage(Context context, String str, ImageView imageView);

    void loadFolderImage(Context context, String str, ImageView imageView);

    void loadGridImage(Context context, String str, ImageView imageView);

    void loadImage(Context context, String str, ImageView imageView);

    @Deprecated
    void loadImage(Context context, String str, ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView);

    void loadImage(Context context, String str, ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, OnImageCompleteCallback onImageCompleteCallback);
}
