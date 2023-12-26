package com.tal.app.thinkacademy.lib.imageloader.progress;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

public class GlideRequests extends RequestManager {
    public GlideRequests(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    public <ResourceType> GlideRequest<ResourceType> as(Class<ResourceType> cls) {
        return new GlideRequest<>(this.glide, this, cls, this.context);
    }

    public synchronized GlideRequests applyDefaultRequestOptions(RequestOptions requestOptions) {
        return GlideRequests.super.applyDefaultRequestOptions(requestOptions);
    }

    public synchronized GlideRequests setDefaultRequestOptions(RequestOptions requestOptions) {
        return GlideRequests.super.setDefaultRequestOptions(requestOptions);
    }

    public GlideRequests addDefaultRequestListener(RequestListener<Object> requestListener) {
        return GlideRequests.super.addDefaultRequestListener(requestListener);
    }

    public GlideRequest<Bitmap> asBitmap() {
        return GlideRequests.super.asBitmap();
    }

    public GlideRequest<GifDrawable> asGif() {
        return GlideRequests.super.asGif();
    }

    public GlideRequest<Drawable> asDrawable() {
        return GlideRequests.super.asDrawable();
    }

    public GlideRequest<Drawable> load(Bitmap bitmap) {
        return GlideRequests.super.load(bitmap);
    }

    public GlideRequest<Drawable> load(Drawable drawable) {
        return GlideRequests.super.load(drawable);
    }

    public GlideRequest<Drawable> load(String str) {
        return GlideRequests.super.load(str);
    }

    public GlideRequest<Drawable> load(Uri uri) {
        return GlideRequests.super.load(uri);
    }

    public GlideRequest<Drawable> load(File file) {
        return GlideRequests.super.load(file);
    }

    public GlideRequest<Drawable> load(Integer num) {
        return GlideRequests.super.load(num);
    }

    @Deprecated
    public GlideRequest<Drawable> load(URL url) {
        return GlideRequests.super.load(url);
    }

    public GlideRequest<Drawable> load(byte[] bArr) {
        return GlideRequests.super.load(bArr);
    }

    public GlideRequest<Drawable> load(Object obj) {
        return GlideRequests.super.load(obj);
    }

    public GlideRequest<File> downloadOnly() {
        return GlideRequests.super.downloadOnly();
    }

    public GlideRequest<File> download(Object obj) {
        return GlideRequests.super.download(obj);
    }

    public GlideRequest<File> asFile() {
        return GlideRequests.super.asFile();
    }

    /* access modifiers changed from: protected */
    public void setRequestOptions(RequestOptions requestOptions) {
        if (requestOptions instanceof GlideOptions) {
            GlideRequests.super.setRequestOptions(requestOptions);
        } else {
            GlideRequests.super.setRequestOptions(new GlideOptions().apply((BaseRequestOptions) requestOptions));
        }
    }
}
