package com.xueersi.lib.graffiti.img;

import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import com.xueersi.lib.graffiti.WXTGraffitiEngine;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.process.HistoryStackManager;
import com.xueersi.lib.graffiti.utils.MainHandler;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoadImageManager {
    /* access modifiers changed from: private */
    public WXTGraffitiEngine.ImageLoader imageLoader;
    /* access modifiers changed from: private */
    public final MainHandler mainHandler = new MainHandler(Looper.getMainLooper());
    private OnLoadListener onLoadListener;
    private final Map<String, ImageFetcher> resultHandlerMap = new ConcurrentHashMap();

    public interface Fetcher {
        Drawable getDrawable();
    }

    public interface OnLoadListener {
        void onPlaceHolder(WXWBAction wXWBAction, Drawable drawable);

        void onReady(WXWBAction wXWBAction, Drawable drawable);
    }

    private class LoadTask implements Runnable {
        String refId;
        RealImageResultHandler resultHandler;

        public LoadTask(String str, RealImageResultHandler realImageResultHandler) {
            this.refId = str;
            this.resultHandler = realImageResultHandler;
        }

        public void run() {
            if (LoadImageManager.this.imageLoader != null) {
                LoadImageManager.this.imageLoader.onLoadImage(this.refId, this.resultHandler);
            }
        }
    }

    public void setImageLoader(WXTGraffitiEngine.ImageLoader imageLoader2) {
        this.imageLoader = imageLoader2;
    }

    public Fetcher getFetcherByAction(WXWBAction wXWBAction) {
        if (wXWBAction == null) {
            return null;
        }
        String actionKey = HistoryStackManager.getActionKey(wXWBAction);
        if (TextUtils.isEmpty(actionKey)) {
            return null;
        }
        ImageFetcher imageFetcher = this.resultHandlerMap.get(actionKey);
        if (imageFetcher != null) {
            return imageFetcher;
        }
        String refId = wXWBAction.getRefConfig() != null ? wXWBAction.getRefConfig().getRefId() : "";
        RealImageResultHandler realImageResultHandler = new RealImageResultHandler(wXWBAction);
        realImageResultHandler.setLoadListener(this.onLoadListener);
        ImageFetcher imageFetcher2 = new ImageFetcher(new LoadTask(refId, realImageResultHandler));
        this.resultHandlerMap.put(actionKey, imageFetcher2);
        return imageFetcher2;
    }

    private class ImageFetcher implements Fetcher {
        private boolean firstLoad = true;
        private final LoadTask loadTask;
        private final RealImageResultHandler resultHandler;

        public ImageFetcher(LoadTask loadTask2) {
            this.loadTask = loadTask2;
            this.resultHandler = loadTask2.resultHandler;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.drawable.Drawable getDrawable() {
            /*
                r2 = this;
                com.xueersi.lib.graffiti.img.LoadImageManager$RealImageResultHandler r0 = r2.resultHandler
                if (r0 == 0) goto L_0x001c
                boolean r1 = r2.firstLoad
                if (r1 != 0) goto L_0x0016
                boolean r0 = r0.isRecycled()
                if (r0 == 0) goto L_0x000f
                goto L_0x0016
            L_0x000f:
                com.xueersi.lib.graffiti.img.LoadImageManager$RealImageResultHandler r0 = r2.resultHandler
                android.graphics.drawable.Drawable r0 = r0.getDrawable()
                goto L_0x001d
            L_0x0016:
                r2.loadImage()
                r0 = 0
                r2.firstLoad = r0
            L_0x001c:
                r0 = 0
            L_0x001d:
                if (r0 != 0) goto L_0x0031
                com.xueersi.lib.graffiti.img.LoadImageManager r1 = com.xueersi.lib.graffiti.img.LoadImageManager.this
                com.xueersi.lib.graffiti.WXTGraffitiEngine$ImageLoader r1 = r1.imageLoader
                if (r1 == 0) goto L_0x0031
                com.xueersi.lib.graffiti.img.LoadImageManager r0 = com.xueersi.lib.graffiti.img.LoadImageManager.this
                com.xueersi.lib.graffiti.WXTGraffitiEngine$ImageLoader r0 = r0.imageLoader
                android.graphics.drawable.Drawable r0 = r0.globalPlaceHolder()
            L_0x0031:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xueersi.lib.graffiti.img.LoadImageManager.ImageFetcher.getDrawable():android.graphics.drawable.Drawable");
        }

        public void recycle() {
            RealImageResultHandler realImageResultHandler = this.resultHandler;
            if (realImageResultHandler != null) {
                realImageResultHandler.recycle();
            }
        }

        private void loadImage() {
            if (this.loadTask != null) {
                LoadImageManager.this.mainHandler.post(this.loadTask);
            }
        }
    }

    private static class RealImageResultHandler implements WXTGraffitiEngine.ImageLoader.ResultHandler {
        private final WXWBAction action;
        private Drawable drawable;
        private boolean isRecycled = false;
        private WeakReference<OnLoadListener> loadListener;

        public void setLoadListener(OnLoadListener onLoadListener) {
            this.loadListener = new WeakReference<>(onLoadListener);
        }

        public RealImageResultHandler(WXWBAction wXWBAction) {
            this.action = wXWBAction;
        }

        public void placeHolder(Drawable drawable2) {
            if (this.drawable == null) {
                this.drawable = drawable2;
            }
            this.isRecycled = false;
            WeakReference<OnLoadListener> weakReference = this.loadListener;
            if (weakReference != null && weakReference.get() != null) {
                ((OnLoadListener) this.loadListener.get()).onPlaceHolder(this.action, drawable2);
            }
        }

        public void ready(Drawable drawable2) {
            this.drawable = drawable2;
            this.isRecycled = false;
            WeakReference<OnLoadListener> weakReference = this.loadListener;
            if (weakReference != null && weakReference.get() != null) {
                ((OnLoadListener) this.loadListener.get()).onReady(this.action, drawable2);
            }
        }

        public Drawable getDrawable() {
            return this.drawable;
        }

        public void recycle() {
            this.drawable = null;
            this.isRecycled = true;
        }

        public boolean isRecycled() {
            return this.isRecycled;
        }
    }

    public void setOnLoadListener(OnLoadListener onLoadListener2) {
        this.onLoadListener = onLoadListener2;
    }

    public void clear(WXWBAction wXWBAction) {
        ImageFetcher remove;
        if (wXWBAction != null && (remove = this.resultHandlerMap.remove(HistoryStackManager.getActionKey(wXWBAction))) != null) {
            remove.recycle();
        }
    }

    public void destroy() {
        clearAll();
        this.onLoadListener = null;
        this.imageLoader = null;
    }

    public void clearAll() {
        recycleAll();
        this.resultHandlerMap.clear();
    }

    public void recycleAll() {
        for (Map.Entry next : this.resultHandlerMap.entrySet()) {
            if (!(next == null || next.getValue() == null)) {
                ((ImageFetcher) next.getValue()).recycle();
            }
        }
    }
}
