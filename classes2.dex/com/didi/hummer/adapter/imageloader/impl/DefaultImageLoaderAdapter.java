package com.didi.hummer.adapter.imageloader.impl;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.adapter.imageloader.DrawableCallback;
import com.didi.hummer.adapter.imageloader.IImageLoaderAdapter;
import com.didi.hummer.adapter.imageloader.ImageSizeCallback;
import com.didi.hummer.core.engine.JSCallback;

public class DefaultImageLoaderAdapter implements IImageLoaderAdapter {
    private static final int FAIL_SRC = 0;
    private static final int LOCAL_SRC = 2;
    private static final int REMOTE_SRC = 1;

    public void setImage(String str, ImageView imageView) {
        setImage(str, (Drawable) null, (Drawable) null, imageView);
    }

    public void setImage(String str, Drawable drawable, Drawable drawable2, ImageView imageView) {
        setImage(str, drawable, drawable2, imageView, (JSCallback) null);
    }

    public void setImage(String str, ImageView imageView, JSCallback jSCallback) {
        setImage(str, (Drawable) null, (Drawable) null, imageView, jSCallback);
    }

    public void setImage(String str, Drawable drawable, Drawable drawable2, ImageView imageView, final JSCallback jSCallback) {
        try {
            RequestOptions requestOptions = new RequestOptions();
            if (imageView.getScaleType() == ImageView.ScaleType.CENTER) {
                requestOptions.override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
            }
            if (drawable != null) {
                requestOptions.placeholder(drawable);
            }
            if (drawable2 != null) {
                requestOptions.error(drawable2);
            }
            if (jSCallback != null) {
                Glide.with(imageView.getContext()).load(str).apply((BaseRequestOptions<?>) requestOptions).listener(new RequestListener<Drawable>() {
                    public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                        jSCallback.call(0, false);
                        return false;
                    }

                    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                        if (dataSource.equals(DataSource.REMOTE)) {
                            jSCallback.call(1, true);
                        } else {
                            jSCallback.call(2, true);
                        }
                        return false;
                    }
                }).into(imageView);
            } else {
                Glide.with(imageView.getContext()).load(str).apply((BaseRequestOptions<?>) requestOptions).into(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGif(String str, int i, ImageView imageView) {
        setGif(str, (Drawable) null, (Drawable) null, i, imageView);
    }

    public void setGif(String str, int i, ImageView imageView, JSCallback jSCallback) {
        setGif(str, (Drawable) null, (Drawable) null, i, imageView, jSCallback);
    }

    public void setGif(String str, Drawable drawable, Drawable drawable2, int i, ImageView imageView) {
        setGif(str, drawable, drawable2, i, imageView, (JSCallback) null);
    }

    public void setGif(String str, Drawable drawable, Drawable drawable2, final int i, ImageView imageView, final JSCallback jSCallback) {
        if (i == 0) {
            i = -1;
        }
        try {
            RequestOptions requestOptions = new RequestOptions();
            if (imageView.getScaleType() == ImageView.ScaleType.CENTER) {
                requestOptions.override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
            }
            if (drawable != null) {
                requestOptions.placeholder(drawable);
            }
            if (drawable2 != null) {
                requestOptions.error(drawable2);
            }
            Glide.with(imageView.getContext()).asGif().load(str).listener(new RequestListener<GifDrawable>() {
                public boolean onLoadFailed(GlideException glideException, Object obj, Target<GifDrawable> target, boolean z) {
                    JSCallback jSCallback = jSCallback;
                    if (jSCallback != null) {
                        jSCallback.call(0, false);
                    }
                    return false;
                }

                public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target<GifDrawable> target, DataSource dataSource, boolean z) {
                    gifDrawable.setLoopCount(i);
                    if (jSCallback != null) {
                        if (dataSource.equals(DataSource.REMOTE)) {
                            jSCallback.call(1, true);
                        } else {
                            jSCallback.call(2, true);
                        }
                    }
                    return false;
                }
            }).into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setImage(int i, ImageView imageView) {
        setImage(i, imageView, (JSCallback) null);
    }

    public void setImage(int i, ImageView imageView, JSCallback jSCallback) {
        if (imageView != null) {
            imageView.setImageResource(i);
            if (jSCallback != null) {
                jSCallback.call(2, true);
            }
        } else if (jSCallback != null) {
            jSCallback.call(0, false);
        }
    }

    public void setGif(int i, int i2, ImageView imageView) {
        setGif(i, i2, imageView, (JSCallback) null);
    }

    public void setGif(int i, final int i2, ImageView imageView, final JSCallback jSCallback) {
        if (i2 == 0) {
            i2 = -1;
        }
        try {
            RequestOptions requestOptions = new RequestOptions();
            if (imageView.getScaleType() == ImageView.ScaleType.CENTER) {
                requestOptions.override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
            }
            Glide.with(imageView.getContext()).asGif().load(Integer.valueOf(i)).listener(new RequestListener<GifDrawable>() {
                public boolean onLoadFailed(GlideException glideException, Object obj, Target<GifDrawable> target, boolean z) {
                    JSCallback jSCallback = jSCallback;
                    if (jSCallback != null) {
                        jSCallback.call(0, false);
                    }
                    return false;
                }

                public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target<GifDrawable> target, DataSource dataSource, boolean z) {
                    gifDrawable.setLoopCount(i2);
                    if (jSCallback != null) {
                        if (dataSource.equals(DataSource.REMOTE)) {
                            jSCallback.call(1, true);
                        } else {
                            jSCallback.call(2, true);
                        }
                    }
                    return false;
                }
            }).into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDrawable(String str, final DrawableCallback drawableCallback) {
        try {
            Glide.with(HummerSDK.appContext).load(str).into(new CustomTarget<Drawable>() {
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    DrawableCallback drawableCallback = drawableCallback;
                    if (drawableCallback != null) {
                        drawableCallback.onDrawableLoaded(drawable);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            if (drawableCallback != null) {
                drawableCallback.onDrawableLoaded((Drawable) null);
            }
        }
    }

    public void loadDrawable(int i, DrawableCallback drawableCallback) {
        Drawable drawable = HummerSDK.appContext.getResources().getDrawable(i);
        if (drawableCallback != null) {
            drawableCallback.onDrawableLoaded(drawable);
        }
    }

    public void getImageSize(String str, final ImageSizeCallback imageSizeCallback) {
        try {
            Glide.with(HummerSDK.appContext).load(str).into(new CustomTarget<Drawable>() {
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    ImageSizeCallback imageSizeCallback = imageSizeCallback;
                    if (imageSizeCallback != null) {
                        imageSizeCallback.onSizeReady(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            if (imageSizeCallback != null) {
                imageSizeCallback.onSizeReady(0, 0);
            }
        }
    }

    public void getImageSize(int i, final ImageSizeCallback imageSizeCallback) {
        try {
            Glide.with(HummerSDK.appContext).load(Integer.valueOf(i)).into(new CustomTarget<Drawable>() {
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    ImageSizeCallback imageSizeCallback = imageSizeCallback;
                    if (imageSizeCallback != null) {
                        imageSizeCallback.onSizeReady(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            if (imageSizeCallback != null) {
                imageSizeCallback.onSizeReady(0, 0);
            }
        }
    }
}
