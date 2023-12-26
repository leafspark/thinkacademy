package com.tal.user.global.trade.image;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TalTradeImageLoader {
    private static TalTradeImageLoader instance;
    private ExecutorService mExecutorService = new ThreadPoolExecutor(0, 10, 10, TimeUnit.SECONDS, new LinkedBlockingDeque());
    /* access modifiers changed from: private */
    public TalTradeImageLru mImageLru = new TalTradeImageLru();

    public static ImageTask newTask(String str) {
        return new ImageTask(str);
    }

    /* access modifiers changed from: private */
    public static TalTradeImageLoader getInstance() {
        if (instance == null) {
            synchronized (TalTradeImageLoader.class) {
                if (instance == null) {
                    instance = new TalTradeImageLoader();
                }
            }
        }
        return instance;
    }

    private TalTradeImageLoader() {
    }

    /* access modifiers changed from: package-private */
    public void bindImage(final ImageView imageView, final ImageTask imageTask) {
        Bitmap loadBitmapFromMemCache = this.mImageLru.loadBitmapFromMemCache(imageTask.url);
        if (loadBitmapFromMemCache != null) {
            setImage(imageView, imageTask.width, imageTask.height, loadBitmapFromMemCache);
            return;
        }
        if (imageTask.holderImage != 0) {
            imageView.setImageResource(imageTask.holderImage);
        }
        imageView.setTag(imageTask.url);
        this.mExecutorService.submit(new Runnable() {
            public void run() {
                Handler handler = new Handler(Looper.getMainLooper());
                final Bitmap downloadBitmapFromUrl = TalTradeImageRequest.downloadBitmapFromUrl(imageTask.url);
                AnonymousClass1 r2 = new Runnable() {
                    public void run() {
                        if (imageTask.url.equals(imageView.getTag())) {
                            if (downloadBitmapFromUrl != null) {
                                TalTradeImageLoader.this.mImageLru.addBitmapToMemoryCache(imageTask.url, downloadBitmapFromUrl);
                                TalTradeImageLoader.this.setImage(imageView, imageTask.width, imageTask.height, downloadBitmapFromUrl);
                            } else if (imageTask.errorImage != 0) {
                                imageView.setImageResource(imageTask.errorImage);
                            }
                        }
                    }
                };
                if (!(handler instanceof Handler)) {
                    handler.post(r2);
                } else {
                    AsynchronousInstrumentation.handlerPost(handler, r2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void setImage(ImageView imageView, int i, int i2, Bitmap bitmap) {
        if (i == 0 || i2 == 0) {
            i = bitmap.getWidth();
            i2 = bitmap.getHeight();
        }
        if (!(i == 0 || i2 == 0)) {
            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
        }
        imageView.setImageBitmap(bitmap);
    }

    public static class ImageTask {
        int errorImage;
        int height;
        int holderImage;
        public String url;
        int width;

        ImageTask(String str) {
            this.url = str;
        }

        public ImageTask placeHolder(int i) {
            this.holderImage = i;
            return this;
        }

        public ImageTask error(int i) {
            this.errorImage = i;
            return this;
        }

        public ImageTask scale(int i, int i2) {
            this.width = i;
            this.height = i2;
            return this;
        }

        public void bindImage(ImageView imageView) {
            TalTradeImageLoader.getInstance().bindImage(imageView, this);
        }
    }
}
