package com.tal.app.thinkacademy.lib.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.tal.app.thinkacademy.lib.imageloader.config.GlideConfigImpl;
import com.tal.app.thinkacademy.lib.imageloader.progress.OnProgressListener;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.lib.logger.XesLog;

public class ImageLoaderJ {
    public static void load(Context context, String str, ImageView imageView, int i, ImageRequestListener<Drawable> imageRequestListener, OnProgressListener onProgressListener) {
        GlideConfigImpl.Builder builder = new GlideConfigImpl.Builder();
        builder.url(str).isCropCenter(true).isCrossFade(true).imageView(imageView).requestListener(imageRequestListener).placeholder(i).progressListener(onProgressListener);
        XesImageLoader.INSTANCE.loadImage(context, builder.build());
    }

    public static void load(Context context, String str, ImageView imageView) {
        if (context != null) {
            load(context, str, imageView, 0, (ImageRequestListener<Drawable>) null, (OnProgressListener) null);
        } else {
            XesLog.dt("Picture loading failed,context is null", new Object[0]);
        }
    }

    public static void load(Context context, String str, ImageView imageView, int i, boolean z) {
        GlideConfigImpl.Builder builder = new GlideConfigImpl.Builder();
        builder.url(str).isCropCenter(z).isCrossFade(true).imageView(imageView).placeholder(i);
        XesImageLoader.INSTANCE.loadImage(context, builder.build());
    }

    public static void load(Context context, String str, ImageView imageView, int i, int i2, boolean z) {
        GlideConfigImpl.Builder builder = new GlideConfigImpl.Builder();
        builder.url(str).isCropCenter(z).isCrossFade(true).imageView(imageView).placeholder(i).errorPic(i2);
        XesImageLoader.INSTANCE.loadImage(context, builder.build());
    }

    public static void load(Context context, String str, ImageView imageView, ImageRequestListener<Drawable> imageRequestListener) {
        if (context != null) {
            load(context, str, imageView, 0, imageRequestListener, (OnProgressListener) null);
        } else {
            XesLog.dt("Picture loading failed,context is null", new Object[0]);
        }
    }

    public static void load(Context context, String str, ImageView imageView, int i, ImageRequestListener<Drawable> imageRequestListener) {
        if (context != null) {
            load(context, str, imageView, i, imageRequestListener, (OnProgressListener) null);
        } else {
            XesLog.dt("Picture loading failed,context is null", new Object[0]);
        }
    }

    public static void loadCenterInside(Context context, String str, ImageView imageView, int i) {
        GlideConfigImpl.Builder builder = new GlideConfigImpl.Builder();
        builder.url(str).isCenterInside(true).isCrossFade(true).imageView(imageView).placeholder(i);
        XesImageLoader.INSTANCE.loadImage(context, builder.build());
    }

    public static void loadFitCenter(Context context, String str, ImageView imageView) {
        GlideConfigImpl.Builder builder = new GlideConfigImpl.Builder();
        builder.url(str).isFitCenter(true).isCrossFade(true).imageView(imageView);
        XesImageLoader.INSTANCE.loadImage(context, builder.build());
    }

    public static void loadCircle(Context context, String str, ImageView imageView, int i) {
        GlideConfigImpl.Builder builder = new GlideConfigImpl.Builder();
        builder.url(str).isCropCenter(true).isCrossFade(true).imageView(imageView).isCropCircle(true).placeholder(i);
        XesImageLoader.INSTANCE.loadImage(context, builder.build());
    }

    public static void loadRounded(Context context, String str, ImageView imageView, int i, int i2, int i3) {
        GlideConfigImpl.Builder builder = new GlideConfigImpl.Builder();
        builder.url(str).isCrossFade(true).imageView(imageView).imageRadius(i).placeholder(i3);
        if (i2 > 0) {
            builder.transformation(new CenterCrop(), new RoundedCornersTransformation(i, i2));
        } else {
            builder.transformation(new CenterCrop(), new RoundedCorners(i));
        }
        XesImageLoader.INSTANCE.loadImage(context, builder.build());
    }

    public static void getDrawable(Context context, String str, final View view) {
        if (TextUtils.isEmpty(str)) {
            view.setBackgroundColor(-16777216);
        } else {
            Glide.with(context).load(str).into(new SimpleTarget<Drawable>() {
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    view.setBackground(drawable);
                }
            });
        }
    }
}
