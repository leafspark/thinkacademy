package com.didi.hummer.adapter.imageloader;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.didi.hummer.core.engine.JSCallback;

public interface IImageLoaderAdapter {
    void getImageSize(int i, ImageSizeCallback imageSizeCallback);

    void getImageSize(String str, ImageSizeCallback imageSizeCallback);

    void loadDrawable(int i, DrawableCallback drawableCallback);

    void loadDrawable(String str, DrawableCallback drawableCallback);

    void setGif(int i, int i2, ImageView imageView);

    void setGif(int i, int i2, ImageView imageView, JSCallback jSCallback);

    void setGif(String str, int i, ImageView imageView);

    void setGif(String str, int i, ImageView imageView, JSCallback jSCallback);

    void setGif(String str, Drawable drawable, Drawable drawable2, int i, ImageView imageView);

    void setGif(String str, Drawable drawable, Drawable drawable2, int i, ImageView imageView, JSCallback jSCallback);

    void setImage(int i, ImageView imageView);

    void setImage(int i, ImageView imageView, JSCallback jSCallback);

    void setImage(String str, Drawable drawable, Drawable drawable2, ImageView imageView);

    void setImage(String str, Drawable drawable, Drawable drawable2, ImageView imageView, JSCallback jSCallback);

    void setImage(String str, ImageView imageView);

    void setImage(String str, ImageView imageView, JSCallback jSCallback);
}
