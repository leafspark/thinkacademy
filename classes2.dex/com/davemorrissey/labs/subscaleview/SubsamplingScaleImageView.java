package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import com.google.firebase.messaging.ServiceStarter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int SCALE_TYPE_START = 4;
    /* access modifiers changed from: private */
    public static final String TAG = "SubsamplingScaleImageView";
    public static final int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public static final List<Integer> VALID_EASING_STYLES = Arrays.asList(new Integer[]{2, 1});
    private static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(new Integer[]{0, 90, 180, 270, -1});
    private static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(new Integer[]{1, 2, 3});
    private static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(new Integer[]{2, 1, 3, 4});
    private static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(new Integer[]{1, 2, 3});
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private static Bitmap.Config preferredBitmapConfig;
    /* access modifiers changed from: private */
    public Anim anim;
    private Bitmap bitmap;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugLinePaint;
    private Paint debugTextPaint;
    private ImageRegionDecoder decoder;
    /* access modifiers changed from: private */
    public final ReadWriteLock decoderLock;
    private final float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private final float[] dstArray;
    private boolean eagerLoadingEnabled;
    private Executor executor;
    private int fullImageSampleSize;
    private final Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    /* access modifiers changed from: private */
    public boolean isQuickScaling;
    /* access modifiers changed from: private */
    public boolean isZooming;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    /* access modifiers changed from: private */
    public int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    /* access modifiers changed from: private */
    public OnImageEventListener onImageEventListener;
    /* access modifiers changed from: private */
    public View.OnLongClickListener onLongClickListener;
    private OnStateChangedListener onStateChangedListener;
    private int orientation;
    private Rect pRegion;
    /* access modifiers changed from: private */
    public boolean panEnabled;
    private int panLimit;
    private Float pendingScale;
    /* access modifiers changed from: private */
    public boolean quickScaleEnabled;
    /* access modifiers changed from: private */
    public float quickScaleLastDistance;
    /* access modifiers changed from: private */
    public boolean quickScaleMoved;
    /* access modifiers changed from: private */
    public PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    /* access modifiers changed from: private */
    public PointF quickScaleVLastPoint;
    /* access modifiers changed from: private */
    public PointF quickScaleVStart;
    /* access modifiers changed from: private */
    public boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    /* access modifiers changed from: private */
    public Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    /* access modifiers changed from: private */
    public float scale;
    /* access modifiers changed from: private */
    public float scaleStart;
    private GestureDetector singleDetector;
    private final float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    /* access modifiers changed from: private */
    public PointF vCenterStart;
    private float vDistStart;
    /* access modifiers changed from: private */
    public PointF vTranslate;
    private PointF vTranslateBefore;
    /* access modifiers changed from: private */
    public PointF vTranslateStart;
    /* access modifiers changed from: private */
    public boolean zoomEnabled;

    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        public void onComplete() {
        }

        public void onInterruptedByNewAnim() {
        }

        public void onInterruptedByUser() {
        }
    }

    public static class DefaultOnImageEventListener implements OnImageEventListener {
        public void onImageLoadError(Exception exc) {
        }

        public void onImageLoaded() {
        }

        public void onPreviewLoadError(Exception exc) {
        }

        public void onPreviewReleased() {
        }

        public void onReady() {
        }

        public void onTileLoadError(Exception exc) {
        }
    }

    public static class DefaultOnStateChangedListener implements OnStateChangedListener {
        public void onCenterChanged(PointF pointF, int i) {
        }

        public void onScaleChanged(float f, int i) {
        }
    }

    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    public interface OnImageEventListener {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(Exception exc);
    }

    public interface OnStateChangedListener {
        void onCenterChanged(PointF pointF, int i);

        void onScaleChanged(float f, int i);
    }

    private float easeInOutQuad(long j, float f, float f2, long j2) {
        float f3;
        float f4 = ((float) j) / (((float) j2) / 2.0f);
        if (f4 < 1.0f) {
            f3 = (f2 / 2.0f) * f4;
        } else {
            float f5 = f4 - 1.0f;
            f3 = (-f2) / 2.0f;
            f4 = (f5 * (f5 - 2.0f)) - 1.0f;
        }
        return (f3 * f4) + f;
    }

    private float easeOutQuad(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / ((float) j2);
        return ((-f2) * f3 * (f3 - 2.0f)) + f;
    }

    /* access modifiers changed from: protected */
    public void onImageLoaded() {
    }

    /* access modifiers changed from: protected */
    public void onReady() {
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.maxTileWidth = Integer.MAX_VALUE;
        this.maxTileHeight = Integer.MAX_VALUE;
        this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
        this.eagerLoadingEnabled = true;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = ServiceStarter.ERROR_UNKNOWN;
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.density = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.handler = new Handler(new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (message.what == 1 && SubsamplingScaleImageView.this.onLongClickListener != null) {
                    int unused = SubsamplingScaleImageView.this.maxTouchCount = 0;
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.onLongClickListener);
                    SubsamplingScaleImageView.this.performLongClick();
                    SubsamplingScaleImageView.super.setOnLongClickListener((View.OnLongClickListener) null);
                }
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SubsamplingScaleImageView);
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_assetName) && (string = obtainStyledAttributes.getString(R.styleable.SubsamplingScaleImageView_assetName)) != null && string.length() > 0) {
                setImage(ImageSource.asset(string).tilingEnabled());
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_src) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.SubsamplingScaleImageView_src, 0)) > 0) {
                setImage(ImageSource.resource(resourceId).tilingEnabled());
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_panEnabled)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(R.styleable.SubsamplingScaleImageView_panEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_zoomEnabled)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(R.styleable.SubsamplingScaleImageView_zoomEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_quickScaleEnabled)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(R.styleable.SubsamplingScaleImageView_quickScaleEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_tileBackgroundColor)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(R.styleable.SubsamplingScaleImageView_tileBackgroundColor, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return preferredBitmapConfig;
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        preferredBitmapConfig = config;
    }

    public final void setOrientation(int i) {
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(i))) {
            this.orientation = i;
            reset(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i);
    }

    public final void setImage(ImageSource imageSource) {
        setImage(imageSource, (ImageSource) null, (ImageViewState) null);
    }

    public final void setImage(ImageSource imageSource, ImageViewState imageViewState) {
        setImage(imageSource, (ImageSource) null, imageViewState);
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2) {
        setImage(imageSource, imageSource2, (ImageViewState) null);
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2, ImageViewState imageViewState) {
        Objects.requireNonNull(imageSource, "imageSource must not be null");
        reset(true);
        if (imageViewState != null) {
            restoreState(imageViewState);
        }
        if (imageSource2 != null) {
            if (imageSource.getBitmap() != null) {
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            } else if (imageSource.getSWidth() <= 0 || imageSource.getSHeight() <= 0) {
                throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
            } else {
                this.sWidth = imageSource.getSWidth();
                this.sHeight = imageSource.getSHeight();
                this.pRegion = imageSource2.getSRegion();
                if (imageSource2.getBitmap() != null) {
                    this.bitmapIsCached = imageSource2.isCached();
                    onPreviewLoaded(imageSource2.getBitmap());
                } else {
                    Uri uri2 = imageSource2.getUri();
                    if (uri2 == null && imageSource2.getResource() != null) {
                        uri2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource2.getResource());
                    }
                    execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri2, true));
                }
            }
        }
        if (imageSource.getBitmap() != null && imageSource.getSRegion() != null) {
            onImageLoaded(Bitmap.createBitmap(imageSource.getBitmap(), imageSource.getSRegion().left, imageSource.getSRegion().top, imageSource.getSRegion().width(), imageSource.getSRegion().height()), 0, false);
        } else if (imageSource.getBitmap() != null) {
            onImageLoaded(imageSource.getBitmap(), 0, imageSource.isCached());
        } else {
            this.sRegion = imageSource.getSRegion();
            Uri uri3 = imageSource.getUri();
            this.uri = uri3;
            if (uri3 == null && imageSource.getResource() != null) {
                this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource.getResource());
            }
            if (imageSource.getTile() || this.sRegion != null) {
                execute(new TilesInitTask(this, getContext(), this.regionDecoderFactory, this.uri));
                return;
            }
            execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
        }
    }

    /* JADX INFO: finally extract failed */
    private void reset(boolean z) {
        OnImageEventListener onImageEventListener2;
        debug("reset newImage=" + z, new Object[0]);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z) {
            this.uri = null;
            this.decoderLock.writeLock().lock();
            try {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null) {
                    imageRegionDecoder.recycle();
                    this.decoder = null;
                }
                this.decoderLock.writeLock().unlock();
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 != null && !this.bitmapIsCached) {
                    bitmap2.recycle();
                }
                if (!(this.bitmap == null || !this.bitmapIsCached || (onImageEventListener2 = this.onImageEventListener) == null)) {
                    onImageEventListener2.onPreviewReleased();
                }
                this.sWidth = 0;
                this.sHeight = 0;
                this.sOrientation = 0;
                this.sRegion = null;
                this.pRegion = null;
                this.readySent = false;
                this.imageLoadedSent = false;
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            } catch (Throwable th) {
                this.decoderLock.writeLock().unlock();
                throw th;
            }
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map != null) {
            for (Map.Entry<Integer, List<Tile>> value : map.entrySet()) {
                for (Tile tile : (List) value.getValue()) {
                    boolean unused = tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        Bitmap unused2 = tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    /* access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!SubsamplingScaleImageView.this.panEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f) <= 500.0f && Math.abs(f2) <= 500.0f) || SubsamplingScaleImageView.this.isZooming))) {
                    return super.onFling(motionEvent, motionEvent2, f, f2);
                }
                PointF pointF = new PointF(SubsamplingScaleImageView.this.vTranslate.x + (f * 0.25f), SubsamplingScaleImageView.this.vTranslate.y + (f2 * 0.25f));
                new AnimationBuilder(new PointF((((float) (SubsamplingScaleImageView.this.getWidth() / 2)) - pointF.x) / SubsamplingScaleImageView.this.scale, (((float) (SubsamplingScaleImageView.this.getHeight() / 2)) - pointF.y) / SubsamplingScaleImageView.this.scale)).withEasing(1).withPanLimited(false).withOrigin(3).start();
                return true;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }

            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (!SubsamplingScaleImageView.this.zoomEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null) {
                    return super.onDoubleTapEvent(motionEvent);
                }
                SubsamplingScaleImageView.this.setGestureDetector(context);
                if (SubsamplingScaleImageView.this.quickScaleEnabled) {
                    PointF unused = SubsamplingScaleImageView.this.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                    PointF unused2 = SubsamplingScaleImageView.this.vTranslateStart = new PointF(SubsamplingScaleImageView.this.vTranslate.x, SubsamplingScaleImageView.this.vTranslate.y);
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    float unused3 = subsamplingScaleImageView.scaleStart = subsamplingScaleImageView.scale;
                    boolean unused4 = SubsamplingScaleImageView.this.isQuickScaling = true;
                    boolean unused5 = SubsamplingScaleImageView.this.isZooming = true;
                    float unused6 = SubsamplingScaleImageView.this.quickScaleLastDistance = -1.0f;
                    SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
                    PointF unused7 = subsamplingScaleImageView2.quickScaleSCenter = subsamplingScaleImageView2.viewToSourceCoord(subsamplingScaleImageView2.vCenterStart);
                    PointF unused8 = SubsamplingScaleImageView.this.quickScaleVStart = new PointF(motionEvent.getX(), motionEvent.getY());
                    PointF unused9 = SubsamplingScaleImageView.this.quickScaleVLastPoint = new PointF(SubsamplingScaleImageView.this.quickScaleSCenter.x, SubsamplingScaleImageView.this.quickScaleSCenter.y);
                    boolean unused10 = SubsamplingScaleImageView.this.quickScaleMoved = false;
                    return false;
                }
                SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
                subsamplingScaleImageView3.doubleTapZoom(subsamplingScaleImageView3.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }
        });
        this.singleDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        debug("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
        PointF center = getCenter();
        if (this.readySent && center != null) {
            this.anim = null;
            this.pendingScale = Float.valueOf(this.scale);
            this.sPendingCenter = center;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        boolean z = true;
        boolean z2 = mode != 1073741824;
        if (mode2 == 1073741824) {
            z = false;
        }
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z2 && z) {
                size = sWidth();
                size2 = sHeight();
            } else if (z) {
                size2 = (int) ((((double) sHeight()) / ((double) sWidth())) * ((double) size));
            } else if (z2) {
                size = (int) ((((double) sWidth()) / ((double) sHeight())) * ((double) size2));
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        Anim anim2 = this.anim;
        if (anim2 == null || anim2.interruptible) {
            Anim anim3 = this.anim;
            if (!(anim3 == null || anim3.listener == null)) {
                try {
                    this.anim.listener.onInterruptedByUser();
                } catch (Exception e) {
                    Log.w(TAG, "Error thrown by animation listener", e);
                }
            }
            this.anim = null;
            if (this.vTranslate == null) {
                GestureDetector gestureDetector2 = this.singleDetector;
                if (gestureDetector2 != null) {
                    gestureDetector2.onTouchEvent(motionEvent);
                }
                return true;
            } else if (this.isQuickScaling || ((gestureDetector = this.detector) != null && !gestureDetector.onTouchEvent(motionEvent))) {
                if (this.vTranslateStart == null) {
                    this.vTranslateStart = new PointF(0.0f, 0.0f);
                }
                if (this.vTranslateBefore == null) {
                    this.vTranslateBefore = new PointF(0.0f, 0.0f);
                }
                if (this.vCenterStart == null) {
                    this.vCenterStart = new PointF(0.0f, 0.0f);
                }
                float f = this.scale;
                this.vTranslateBefore.set(this.vTranslate);
                boolean onTouchEventInternal = onTouchEventInternal(motionEvent);
                sendStateChanged(f, this.vTranslateBefore, 2);
                if (onTouchEventInternal || super.onTouchEvent(motionEvent)) {
                    return true;
                }
                return false;
            } else {
                this.isZooming = false;
                this.isPanning = false;
                this.maxTouchCount = 0;
                return true;
            }
        } else {
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r1 != 262) goto L_0x03d0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean onTouchEventInternal(android.view.MotionEvent r13) {
        /*
            r12 = this;
            int r0 = r13.getPointerCount()
            int r1 = r13.getAction()
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x043f
            if (r1 == r5) goto L_0x03d1
            if (r1 == r3) goto L_0x0023
            r6 = 5
            if (r1 == r6) goto L_0x043f
            r6 = 6
            if (r1 == r6) goto L_0x03d1
            r6 = 261(0x105, float:3.66E-43)
            if (r1 == r6) goto L_0x043f
            r2 = 262(0x106, float:3.67E-43)
            if (r1 == r2) goto L_0x03d1
            goto L_0x03d0
        L_0x0023:
            int r1 = r12.maxTouchCount
            if (r1 <= 0) goto L_0x03c4
            r1 = 1084227584(0x40a00000, float:5.0)
            if (r0 < r3) goto L_0x0187
            float r0 = r13.getX(r4)
            float r6 = r13.getX(r5)
            float r7 = r13.getY(r4)
            float r8 = r13.getY(r5)
            float r0 = r12.distance(r0, r6, r7, r8)
            float r6 = r13.getX(r4)
            float r7 = r13.getX(r5)
            float r6 = r6 + r7
            float r6 = r6 / r2
            float r7 = r13.getY(r4)
            float r13 = r13.getY(r5)
            float r7 = r7 + r13
            float r7 = r7 / r2
            boolean r13 = r12.zoomEnabled
            if (r13 == 0) goto L_0x03c4
            android.graphics.PointF r13 = r12.vCenterStart
            float r13 = r13.x
            android.graphics.PointF r2 = r12.vCenterStart
            float r2 = r2.y
            float r13 = r12.distance(r13, r6, r2, r7)
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 > 0) goto L_0x0077
            float r13 = r12.vDistStart
            float r13 = r0 - r13
            float r13 = java.lang.Math.abs(r13)
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 > 0) goto L_0x0077
            boolean r13 = r12.isPanning
            if (r13 == 0) goto L_0x03c4
        L_0x0077:
            r12.isZooming = r5
            r12.isPanning = r5
            float r13 = r12.scale
            double r1 = (double) r13
            float r13 = r12.maxScale
            float r8 = r12.vDistStart
            float r8 = r0 / r8
            float r9 = r12.scaleStart
            float r8 = r8 * r9
            float r13 = java.lang.Math.min(r13, r8)
            r12.scale = r13
            float r8 = r12.minScale()
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r13 > 0) goto L_0x00ab
            r12.vDistStart = r0
            float r13 = r12.minScale()
            r12.scaleStart = r13
            android.graphics.PointF r13 = r12.vCenterStart
            r13.set(r6, r7)
            android.graphics.PointF r13 = r12.vTranslateStart
            android.graphics.PointF r0 = r12.vTranslate
            r13.set(r0)
            goto L_0x017d
        L_0x00ab:
            boolean r13 = r12.panEnabled
            if (r13 == 0) goto L_0x012c
            android.graphics.PointF r13 = r12.vCenterStart
            float r13 = r13.x
            android.graphics.PointF r3 = r12.vTranslateStart
            float r3 = r3.x
            float r13 = r13 - r3
            android.graphics.PointF r3 = r12.vCenterStart
            float r3 = r3.y
            android.graphics.PointF r8 = r12.vTranslateStart
            float r8 = r8.y
            float r3 = r3 - r8
            float r8 = r12.scale
            float r9 = r12.scaleStart
            float r10 = r8 / r9
            float r13 = r13 * r10
            float r8 = r8 / r9
            float r3 = r3 * r8
            android.graphics.PointF r8 = r12.vTranslate
            float r13 = r6 - r13
            r8.x = r13
            android.graphics.PointF r13 = r12.vTranslate
            float r3 = r7 - r3
            r13.y = r3
            int r13 = r12.sHeight()
            double r8 = (double) r13
            double r8 = r8 * r1
            int r13 = r12.getHeight()
            double r10 = (double) r13
            int r13 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x00f6
            float r13 = r12.scale
            int r3 = r12.sHeight()
            float r3 = (float) r3
            float r13 = r13 * r3
            int r3 = r12.getHeight()
            float r3 = (float) r3
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x0116
        L_0x00f6:
            int r13 = r12.sWidth()
            double r8 = (double) r13
            double r1 = r1 * r8
            int r13 = r12.getWidth()
            double r8 = (double) r13
            int r13 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r13 >= 0) goto L_0x017d
            float r13 = r12.scale
            int r1 = r12.sWidth()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getWidth()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 < 0) goto L_0x017d
        L_0x0116:
            r12.fitToBounds(r5)
            android.graphics.PointF r13 = r12.vCenterStart
            r13.set(r6, r7)
            android.graphics.PointF r13 = r12.vTranslateStart
            android.graphics.PointF r1 = r12.vTranslate
            r13.set(r1)
            float r13 = r12.scale
            r12.scaleStart = r13
            r12.vDistStart = r0
            goto L_0x017d
        L_0x012c:
            android.graphics.PointF r13 = r12.sRequestedCenter
            if (r13 == 0) goto L_0x0155
            android.graphics.PointF r13 = r12.vTranslate
            int r0 = r12.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.scale
            android.graphics.PointF r2 = r12.sRequestedCenter
            float r2 = r2.x
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.x = r0
            android.graphics.PointF r13 = r12.vTranslate
            int r0 = r12.getHeight()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.scale
            android.graphics.PointF r2 = r12.sRequestedCenter
            float r2 = r2.y
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.y = r0
            goto L_0x017d
        L_0x0155:
            android.graphics.PointF r13 = r12.vTranslate
            int r0 = r12.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.scale
            int r2 = r12.sWidth()
            int r2 = r2 / r3
            float r2 = (float) r2
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.x = r0
            android.graphics.PointF r13 = r12.vTranslate
            int r0 = r12.getHeight()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.scale
            int r2 = r12.sHeight()
            int r2 = r2 / r3
            float r2 = (float) r2
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.y = r0
        L_0x017d:
            r12.fitToBounds(r5)
            boolean r13 = r12.eagerLoadingEnabled
            r12.refreshRequiredTiles(r13)
            goto L_0x02e4
        L_0x0187:
            boolean r0 = r12.isQuickScaling
            if (r0 == 0) goto L_0x02e7
            android.graphics.PointF r0 = r12.quickScaleVStart
            float r0 = r0.y
            float r1 = r13.getY()
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            float r0 = r0 * r2
            float r1 = r12.quickScaleThreshold
            float r0 = r0 + r1
            float r1 = r12.quickScaleLastDistance
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x01a6
            r12.quickScaleLastDistance = r0
        L_0x01a6:
            float r1 = r13.getY()
            android.graphics.PointF r2 = r12.quickScaleVLastPoint
            float r2 = r2.y
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x01b4
            r1 = r5
            goto L_0x01b5
        L_0x01b4:
            r1 = r4
        L_0x01b5:
            android.graphics.PointF r2 = r12.quickScaleVLastPoint
            float r13 = r13.getY()
            r6 = 0
            r2.set(r6, r13)
            float r13 = r12.quickScaleLastDistance
            float r13 = r0 / r13
            r2 = 1065353216(0x3f800000, float:1.0)
            float r13 = r2 - r13
            float r13 = java.lang.Math.abs(r13)
            r7 = 1056964608(0x3f000000, float:0.5)
            float r13 = r13 * r7
            r7 = 1022739087(0x3cf5c28f, float:0.03)
            int r7 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x01d9
            boolean r7 = r12.quickScaleMoved
            if (r7 == 0) goto L_0x02da
        L_0x01d9:
            r12.quickScaleMoved = r5
            float r7 = r12.quickScaleLastDistance
            int r7 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x01e7
            if (r1 == 0) goto L_0x01e6
            float r13 = r13 + r2
            r2 = r13
            goto L_0x01e7
        L_0x01e6:
            float r2 = r2 - r13
        L_0x01e7:
            float r13 = r12.scale
            double r7 = (double) r13
            float r13 = r12.minScale()
            float r1 = r12.maxScale
            float r9 = r12.scale
            float r9 = r9 * r2
            float r1 = java.lang.Math.min(r1, r9)
            float r13 = java.lang.Math.max(r13, r1)
            r12.scale = r13
            boolean r13 = r12.panEnabled
            if (r13 == 0) goto L_0x0289
            android.graphics.PointF r13 = r12.vCenterStart
            float r13 = r13.x
            android.graphics.PointF r1 = r12.vTranslateStart
            float r1 = r1.x
            float r13 = r13 - r1
            android.graphics.PointF r1 = r12.vCenterStart
            float r1 = r1.y
            android.graphics.PointF r2 = r12.vTranslateStart
            float r2 = r2.y
            float r1 = r1 - r2
            float r2 = r12.scale
            float r3 = r12.scaleStart
            float r9 = r2 / r3
            float r13 = r13 * r9
            float r2 = r2 / r3
            float r1 = r1 * r2
            android.graphics.PointF r2 = r12.vTranslate
            android.graphics.PointF r3 = r12.vCenterStart
            float r3 = r3.x
            float r3 = r3 - r13
            r2.x = r3
            android.graphics.PointF r13 = r12.vTranslate
            android.graphics.PointF r2 = r12.vCenterStart
            float r2 = r2.y
            float r2 = r2 - r1
            r13.y = r2
            int r13 = r12.sHeight()
            double r1 = (double) r13
            double r1 = r1 * r7
            int r13 = r12.getHeight()
            double r9 = (double) r13
            int r13 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r13 >= 0) goto L_0x024e
            float r13 = r12.scale
            int r1 = r12.sHeight()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getHeight()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 >= 0) goto L_0x026e
        L_0x024e:
            int r13 = r12.sWidth()
            double r1 = (double) r13
            double r7 = r7 * r1
            int r13 = r12.getWidth()
            double r1 = (double) r13
            int r13 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r13 >= 0) goto L_0x02da
            float r13 = r12.scale
            int r1 = r12.sWidth()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getWidth()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 < 0) goto L_0x02da
        L_0x026e:
            r12.fitToBounds(r5)
            android.graphics.PointF r13 = r12.vCenterStart
            android.graphics.PointF r0 = r12.quickScaleSCenter
            android.graphics.PointF r0 = r12.sourceToViewCoord(r0)
            r13.set(r0)
            android.graphics.PointF r13 = r12.vTranslateStart
            android.graphics.PointF r0 = r12.vTranslate
            r13.set(r0)
            float r13 = r12.scale
            r12.scaleStart = r13
            r0 = r6
            goto L_0x02da
        L_0x0289:
            android.graphics.PointF r13 = r12.sRequestedCenter
            if (r13 == 0) goto L_0x02b2
            android.graphics.PointF r13 = r12.vTranslate
            int r1 = r12.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.scale
            android.graphics.PointF r6 = r12.sRequestedCenter
            float r6 = r6.x
            float r2 = r2 * r6
            float r1 = r1 - r2
            r13.x = r1
            android.graphics.PointF r13 = r12.vTranslate
            int r1 = r12.getHeight()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.scale
            android.graphics.PointF r3 = r12.sRequestedCenter
            float r3 = r3.y
            float r2 = r2 * r3
            float r1 = r1 - r2
            r13.y = r1
            goto L_0x02da
        L_0x02b2:
            android.graphics.PointF r13 = r12.vTranslate
            int r1 = r12.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.scale
            int r6 = r12.sWidth()
            int r6 = r6 / r3
            float r6 = (float) r6
            float r2 = r2 * r6
            float r1 = r1 - r2
            r13.x = r1
            android.graphics.PointF r13 = r12.vTranslate
            int r1 = r12.getHeight()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.scale
            int r6 = r12.sHeight()
            int r6 = r6 / r3
            float r3 = (float) r6
            float r2 = r2 * r3
            float r1 = r1 - r2
            r13.y = r1
        L_0x02da:
            r12.quickScaleLastDistance = r0
            r12.fitToBounds(r5)
            boolean r13 = r12.eagerLoadingEnabled
            r12.refreshRequiredTiles(r13)
        L_0x02e4:
            r13 = r5
            goto L_0x03c5
        L_0x02e7:
            boolean r0 = r12.isZooming
            if (r0 != 0) goto L_0x03c4
            float r0 = r13.getX()
            android.graphics.PointF r2 = r12.vCenterStart
            float r2 = r2.x
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r13.getY()
            android.graphics.PointF r3 = r12.vCenterStart
            float r3 = r3.y
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            float r3 = r12.density
            float r3 = r3 * r1
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0314
            int r6 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x0314
            boolean r6 = r12.isPanning
            if (r6 == 0) goto L_0x03c4
        L_0x0314:
            android.graphics.PointF r6 = r12.vTranslate
            android.graphics.PointF r7 = r12.vTranslateStart
            float r7 = r7.x
            float r8 = r13.getX()
            android.graphics.PointF r9 = r12.vCenterStart
            float r9 = r9.x
            float r8 = r8 - r9
            float r7 = r7 + r8
            r6.x = r7
            android.graphics.PointF r6 = r12.vTranslate
            android.graphics.PointF r7 = r12.vTranslateStart
            float r7 = r7.y
            float r13 = r13.getY()
            android.graphics.PointF r8 = r12.vCenterStart
            float r8 = r8.y
            float r13 = r13 - r8
            float r7 = r7 + r13
            r6.y = r7
            android.graphics.PointF r13 = r12.vTranslate
            float r13 = r13.x
            android.graphics.PointF r6 = r12.vTranslate
            float r6 = r6.y
            r12.fitToBounds(r5)
            android.graphics.PointF r7 = r12.vTranslate
            float r7 = r7.x
            int r13 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r13 == 0) goto L_0x034d
            r13 = r5
            goto L_0x034e
        L_0x034d:
            r13 = r4
        L_0x034e:
            android.graphics.PointF r7 = r12.vTranslate
            float r7 = r7.y
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0358
            r7 = r5
            goto L_0x0359
        L_0x0358:
            r7 = r4
        L_0x0359:
            if (r13 == 0) goto L_0x0365
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0365
            boolean r8 = r12.isPanning
            if (r8 != 0) goto L_0x0365
            r8 = r5
            goto L_0x0366
        L_0x0365:
            r8 = r4
        L_0x0366:
            if (r7 == 0) goto L_0x0372
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0372
            boolean r0 = r12.isPanning
            if (r0 != 0) goto L_0x0372
            r0 = r5
            goto L_0x0373
        L_0x0372:
            r0 = r4
        L_0x0373:
            android.graphics.PointF r9 = r12.vTranslate
            float r9 = r9.y
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 != 0) goto L_0x0384
            r6 = 1077936128(0x40400000, float:3.0)
            float r6 = r6 * r3
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0384
            r6 = r5
            goto L_0x0385
        L_0x0384:
            r6 = r4
        L_0x0385:
            if (r8 != 0) goto L_0x0396
            if (r0 != 0) goto L_0x0396
            if (r13 == 0) goto L_0x0393
            if (r7 == 0) goto L_0x0393
            if (r6 != 0) goto L_0x0393
            boolean r13 = r12.isPanning
            if (r13 == 0) goto L_0x0396
        L_0x0393:
            r12.isPanning = r5
            goto L_0x03a6
        L_0x0396:
            if (r1 > 0) goto L_0x039c
            int r13 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x03a6
        L_0x039c:
            r12.maxTouchCount = r4
            android.os.Handler r13 = r12.handler
            r13.removeMessages(r5)
            r12.requestDisallowInterceptTouchEvent(r4)
        L_0x03a6:
            boolean r13 = r12.panEnabled
            if (r13 != 0) goto L_0x03bd
            android.graphics.PointF r13 = r12.vTranslate
            android.graphics.PointF r0 = r12.vTranslateStart
            float r0 = r0.x
            r13.x = r0
            android.graphics.PointF r13 = r12.vTranslate
            android.graphics.PointF r0 = r12.vTranslateStart
            float r0 = r0.y
            r13.y = r0
            r12.requestDisallowInterceptTouchEvent(r4)
        L_0x03bd:
            boolean r13 = r12.eagerLoadingEnabled
            r12.refreshRequiredTiles(r13)
            goto L_0x02e4
        L_0x03c4:
            r13 = r4
        L_0x03c5:
            if (r13 == 0) goto L_0x03d0
            android.os.Handler r13 = r12.handler
            r13.removeMessages(r5)
            r12.invalidate()
            return r5
        L_0x03d0:
            return r4
        L_0x03d1:
            android.os.Handler r1 = r12.handler
            r1.removeMessages(r5)
            boolean r1 = r12.isQuickScaling
            if (r1 == 0) goto L_0x03e7
            r12.isQuickScaling = r4
            boolean r1 = r12.quickScaleMoved
            if (r1 != 0) goto L_0x03e7
            android.graphics.PointF r1 = r12.quickScaleSCenter
            android.graphics.PointF r2 = r12.vCenterStart
            r12.doubleTapZoom(r1, r2)
        L_0x03e7:
            int r1 = r12.maxTouchCount
            if (r1 <= 0) goto L_0x0436
            boolean r1 = r12.isZooming
            if (r1 != 0) goto L_0x03f3
            boolean r2 = r12.isPanning
            if (r2 == 0) goto L_0x0436
        L_0x03f3:
            if (r1 == 0) goto L_0x0427
            if (r0 != r3) goto L_0x0427
            r12.isPanning = r5
            android.graphics.PointF r1 = r12.vTranslateStart
            android.graphics.PointF r2 = r12.vTranslate
            float r2 = r2.x
            android.graphics.PointF r6 = r12.vTranslate
            float r6 = r6.y
            r1.set(r2, r6)
            int r1 = r13.getActionIndex()
            if (r1 != r5) goto L_0x041a
            android.graphics.PointF r1 = r12.vCenterStart
            float r2 = r13.getX(r4)
            float r13 = r13.getY(r4)
            r1.set(r2, r13)
            goto L_0x0427
        L_0x041a:
            android.graphics.PointF r1 = r12.vCenterStart
            float r2 = r13.getX(r5)
            float r13 = r13.getY(r5)
            r1.set(r2, r13)
        L_0x0427:
            r13 = 3
            if (r0 >= r13) goto L_0x042c
            r12.isZooming = r4
        L_0x042c:
            if (r0 >= r3) goto L_0x0432
            r12.isPanning = r4
            r12.maxTouchCount = r4
        L_0x0432:
            r12.refreshRequiredTiles(r5)
            return r5
        L_0x0436:
            if (r0 != r5) goto L_0x043e
            r12.isZooming = r4
            r12.isPanning = r4
            r12.maxTouchCount = r4
        L_0x043e:
            return r5
        L_0x043f:
            r1 = 0
            r12.anim = r1
            r12.requestDisallowInterceptTouchEvent(r5)
            int r1 = r12.maxTouchCount
            int r1 = java.lang.Math.max(r1, r0)
            r12.maxTouchCount = r1
            if (r0 < r3) goto L_0x049c
            boolean r0 = r12.zoomEnabled
            if (r0 == 0) goto L_0x0494
            float r0 = r13.getX(r4)
            float r1 = r13.getX(r5)
            float r3 = r13.getY(r4)
            float r6 = r13.getY(r5)
            float r0 = r12.distance(r0, r1, r3, r6)
            float r1 = r12.scale
            r12.scaleStart = r1
            r12.vDistStart = r0
            android.graphics.PointF r0 = r12.vTranslateStart
            android.graphics.PointF r1 = r12.vTranslate
            float r1 = r1.x
            android.graphics.PointF r3 = r12.vTranslate
            float r3 = r3.y
            r0.set(r1, r3)
            android.graphics.PointF r0 = r12.vCenterStart
            float r1 = r13.getX(r4)
            float r3 = r13.getX(r5)
            float r1 = r1 + r3
            float r1 = r1 / r2
            float r3 = r13.getY(r4)
            float r13 = r13.getY(r5)
            float r3 = r3 + r13
            float r3 = r3 / r2
            r0.set(r1, r3)
            goto L_0x0496
        L_0x0494:
            r12.maxTouchCount = r4
        L_0x0496:
            android.os.Handler r13 = r12.handler
            r13.removeMessages(r5)
            goto L_0x04c1
        L_0x049c:
            boolean r0 = r12.isQuickScaling
            if (r0 != 0) goto L_0x04c1
            android.graphics.PointF r0 = r12.vTranslateStart
            android.graphics.PointF r1 = r12.vTranslate
            float r1 = r1.x
            android.graphics.PointF r2 = r12.vTranslate
            float r2 = r2.y
            r0.set(r1, r2)
            android.graphics.PointF r0 = r12.vCenterStart
            float r1 = r13.getX()
            float r13 = r13.getY()
            r0.set(r1, r13)
            android.os.Handler r13 = r12.handler
            r0 = 600(0x258, double:2.964E-321)
            r13.sendEmptyMessageDelayed(r5, r0)
        L_0x04c1:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onTouchEventInternal(android.view.MotionEvent):boolean");
    }

    private void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
        if (!this.panEnabled) {
            PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = this.sRequestedCenter.y;
            } else {
                pointF.x = (float) (sWidth() / 2);
                pointF.y = (float) (sHeight() / 2);
            }
        }
        float min = Math.min(this.maxScale, this.doubleTapZoomScale);
        float f = this.scale;
        boolean z = ((double) f) <= ((double) min) * 0.9d || f == this.minScale;
        if (!z) {
            min = minScale();
        }
        float f2 = min;
        int i = this.doubleTapZoomStyle;
        if (i == 3) {
            setScaleAndCenter(f2, pointF);
        } else if (i == 2 || !z || !this.panEnabled) {
            new AnimationBuilder(f2, pointF).withInterruptible(false).withDuration((long) this.doubleTapZoomDuration).withOrigin(4).start();
        } else if (i == 1) {
            new AnimationBuilder(f2, pointF, pointF2).withInterruptible(false).withDuration((long) this.doubleTapZoomDuration).withOrigin(4).start();
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0487  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r32) {
        /*
            r31 = this;
            r11 = r31
            r12 = r32
            super.onDraw(r32)
            r31.createPaints()
            int r0 = r11.sWidth
            if (r0 == 0) goto L_0x0761
            int r0 = r11.sHeight
            if (r0 == 0) goto L_0x0761
            int r0 = r31.getWidth()
            if (r0 == 0) goto L_0x0761
            int r0 = r31.getHeight()
            if (r0 != 0) goto L_0x0020
            goto L_0x0761
        L_0x0020:
            java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile>> r0 = r11.tileMap
            if (r0 != 0) goto L_0x002f
            com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder r0 = r11.decoder
            if (r0 == 0) goto L_0x002f
            android.graphics.Point r0 = r31.getMaxBitmapDimensions(r32)
            r11.initialiseBaseLayer(r0)
        L_0x002f:
            boolean r0 = r31.checkReady()
            if (r0 != 0) goto L_0x0036
            return
        L_0x0036:
            r31.preDraw()
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r0 = r11.anim
            r9 = 0
            if (r0 == 0) goto L_0x016f
            android.graphics.PointF r0 = r0.vFocusStart
            if (r0 == 0) goto L_0x016f
            float r0 = r11.scale
            android.graphics.PointF r1 = r11.vTranslateBefore
            if (r1 != 0) goto L_0x0051
            android.graphics.PointF r1 = new android.graphics.PointF
            r1.<init>(r9, r9)
            r11.vTranslateBefore = r1
        L_0x0051:
            android.graphics.PointF r1 = r11.vTranslateBefore
            android.graphics.PointF r2 = r11.vTranslate
            r1.set(r2)
            long r1 = java.lang.System.currentTimeMillis()
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            long r3 = r3.time
            long r1 = r1 - r3
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            long r3 = r3.duration
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x006f
            r10 = 1
            goto L_0x0070
        L_0x006f:
            r10 = 0
        L_0x0070:
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            long r3 = r3.duration
            long r15 = java.lang.Math.min(r1, r3)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            int r2 = r1.easing
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            float r5 = r1.scaleStart
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            float r1 = r1.scaleEnd
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            float r3 = r3.scaleStart
            float r6 = r1 - r3
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            long r7 = r1.duration
            r1 = r31
            r3 = r15
            float r1 = r1.ease(r2, r3, r5, r6, r7)
            r11.scale = r1
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            int r2 = r1.easing
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            android.graphics.PointF r1 = r1.vFocusStart
            float r5 = r1.x
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            android.graphics.PointF r1 = r1.vFocusEnd
            float r1 = r1.x
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            android.graphics.PointF r3 = r3.vFocusStart
            float r3 = r3.x
            float r6 = r1 - r3
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            long r7 = r1.duration
            r1 = r31
            r3 = r15
            float r17 = r1.ease(r2, r3, r5, r6, r7)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            int r2 = r1.easing
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            android.graphics.PointF r1 = r1.vFocusStart
            float r5 = r1.y
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            android.graphics.PointF r1 = r1.vFocusEnd
            float r1 = r1.y
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            android.graphics.PointF r3 = r3.vFocusStart
            float r3 = r3.y
            float r6 = r1 - r3
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            long r7 = r1.duration
            r1 = r31
            r3 = r15
            float r1 = r1.ease(r2, r3, r5, r6, r7)
            android.graphics.PointF r2 = r11.vTranslate
            float r3 = r2.x
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r4 = r11.anim
            android.graphics.PointF r4 = r4.sCenterEnd
            float r4 = r4.x
            float r4 = r11.sourceToViewX(r4)
            float r4 = r4 - r17
            float r3 = r3 - r4
            r2.x = r3
            android.graphics.PointF r2 = r11.vTranslate
            float r3 = r2.y
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r4 = r11.anim
            android.graphics.PointF r4 = r4.sCenterEnd
            float r4 = r4.y
            float r4 = r11.sourceToViewY(r4)
            float r4 = r4 - r1
            float r3 = r3 - r4
            r2.y = r3
            if (r10 != 0) goto L_0x013b
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            float r1 = r1.scaleStart
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r2 = r11.anim
            float r2 = r2.scaleEnd
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0139
            goto L_0x013b
        L_0x0139:
            r1 = 0
            goto L_0x013c
        L_0x013b:
            r1 = 1
        L_0x013c:
            r11.fitToBounds(r1)
            android.graphics.PointF r1 = r11.vTranslateBefore
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r2 = r11.anim
            int r2 = r2.origin
            r11.sendStateChanged(r0, r1, r2)
            r11.refreshRequiredTiles(r10)
            if (r10 == 0) goto L_0x016c
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r0 = r11.anim
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$OnAnimationEventListener r0 = r0.listener
            if (r0 == 0) goto L_0x0169
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r0 = r11.anim     // Catch:{ Exception -> 0x0161 }
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$OnAnimationEventListener r0 = r0.listener     // Catch:{ Exception -> 0x0161 }
            r0.onComplete()     // Catch:{ Exception -> 0x0161 }
            goto L_0x0169
        L_0x0161:
            r0 = move-exception
            java.lang.String r1 = TAG
            java.lang.String r2 = "Error thrown by animation listener"
            android.util.Log.w(r1, r2, r0)
        L_0x0169:
            r0 = 0
            r11.anim = r0
        L_0x016c:
            r31.invalidate()
        L_0x016f:
            java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile>> r0 = r11.tileMap
            r15 = 270(0x10e, float:3.78E-43)
            r10 = 35
            r8 = 90
            r7 = 180(0xb4, float:2.52E-43)
            if (r0 == 0) goto L_0x0498
            boolean r0 = r31.isBaseLayerReady()
            if (r0 == 0) goto L_0x0498
            int r0 = r11.fullImageSampleSize
            float r1 = r11.scale
            int r1 = r11.calculateInSampleSize(r1)
            int r0 = java.lang.Math.min(r0, r1)
            java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile>> r1 = r11.tileMap
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
            r16 = 0
        L_0x0199:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01dc
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 != r0) goto L_0x0199
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x01bb:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0199
            java.lang.Object r3 = r2.next()
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile r3 = (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile) r3
            boolean r4 = r3.visible
            if (r4 == 0) goto L_0x01bb
            boolean r4 = r3.loading
            if (r4 != 0) goto L_0x01d9
            android.graphics.Bitmap r3 = r3.bitmap
            if (r3 != 0) goto L_0x01bb
        L_0x01d9:
            r16 = 1
            goto L_0x01bb
        L_0x01dc:
            java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile>> r1 = r11.tileMap
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r17 = r1.iterator()
        L_0x01e6:
            boolean r1 = r17.hasNext()
            if (r1 == 0) goto L_0x0493
            java.lang.Object r1 = r17.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 == r0) goto L_0x0208
            if (r16 == 0) goto L_0x0201
            goto L_0x0208
        L_0x0201:
            r13 = r7
            r14 = r8
            r3 = r10
            r5 = 15
            goto L_0x048e
        L_0x0208:
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r18 = r1.iterator()
        L_0x0212:
            boolean r1 = r18.hasNext()
            if (r1 == 0) goto L_0x0201
            java.lang.Object r1 = r18.next()
            r19 = r1
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile r19 = (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile) r19
            android.graphics.Rect r1 = r19.sRect
            android.graphics.Rect r2 = r19.vRect
            r11.sourceToViewRect(r1, r2)
            boolean r1 = r19.loading
            if (r1 != 0) goto L_0x03e2
            android.graphics.Bitmap r1 = r19.bitmap
            if (r1 == 0) goto L_0x03e2
            android.graphics.Paint r1 = r11.tileBgPaint
            if (r1 == 0) goto L_0x0244
            android.graphics.Rect r1 = r19.vRect
            android.graphics.Paint r2 = r11.tileBgPaint
            r12.drawRect(r1, r2)
        L_0x0244:
            android.graphics.Matrix r1 = r11.matrix
            if (r1 != 0) goto L_0x024f
            android.graphics.Matrix r1 = new android.graphics.Matrix
            r1.<init>()
            r11.matrix = r1
        L_0x024f:
            android.graphics.Matrix r1 = r11.matrix
            r1.reset()
            float[] r2 = r11.srcArray
            r3 = 0
            r4 = 0
            android.graphics.Bitmap r1 = r19.bitmap
            int r1 = r1.getWidth()
            float r9 = (float) r1
            r20 = 0
            android.graphics.Bitmap r1 = r19.bitmap
            int r1 = r1.getWidth()
            float r1 = (float) r1
            android.graphics.Bitmap r21 = r19.bitmap
            int r5 = r21.getHeight()
            float r5 = (float) r5
            r21 = 0
            android.graphics.Bitmap r23 = r19.bitmap
            int r6 = r23.getHeight()
            float r6 = (float) r6
            r23 = r1
            r1 = r31
            r22 = r5
            r14 = 5
            r5 = r9
            r24 = r6
            r9 = 15
            r6 = r20
            r13 = r7
            r7 = r23
            r14 = r8
            r8 = r22
            r9 = r21
            r10 = r24
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            int r1 = r31.getRequiredRotation()
            if (r1 != 0) goto L_0x02e2
            float[] r2 = r11.dstArray
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r10 = (float) r1
            r1 = r31
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x03b4
        L_0x02e2:
            int r1 = r31.getRequiredRotation()
            if (r1 != r14) goto L_0x0329
            float[] r2 = r11.dstArray
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r10 = (float) r1
            r1 = r31
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x03b4
        L_0x0329:
            int r1 = r31.getRequiredRotation()
            if (r1 != r13) goto L_0x036f
            float[] r2 = r11.dstArray
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r10 = (float) r1
            r1 = r31
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x03b4
        L_0x036f:
            int r1 = r31.getRequiredRotation()
            if (r1 != r15) goto L_0x03b4
            float[] r2 = r11.dstArray
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r10 = (float) r1
            r1 = r31
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x03b4:
            android.graphics.Matrix r1 = r11.matrix
            float[] r2 = r11.srcArray
            r27 = 0
            float[] r3 = r11.dstArray
            r29 = 0
            r30 = 4
            r25 = r1
            r26 = r2
            r28 = r3
            r25.setPolyToPoly(r26, r27, r28, r29, r30)
            android.graphics.Bitmap r1 = r19.bitmap
            android.graphics.Matrix r2 = r11.matrix
            android.graphics.Paint r3 = r11.bitmapPaint
            r12.drawBitmap(r1, r2, r3)
            boolean r1 = r11.debug
            if (r1 == 0) goto L_0x0411
            android.graphics.Rect r1 = r19.vRect
            android.graphics.Paint r2 = r11.debugLinePaint
            r12.drawRect(r1, r2)
            goto L_0x0411
        L_0x03e2:
            r13 = r7
            r14 = r8
            boolean r1 = r19.loading
            if (r1 == 0) goto L_0x0411
            boolean r1 = r11.debug
            if (r1 == 0) goto L_0x0411
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            r2 = 5
            int r3 = r11.px(r2)
            int r1 = r1 + r3
            float r1 = (float) r1
            android.graphics.Rect r2 = r19.vRect
            int r2 = r2.top
            r3 = 35
            int r4 = r11.px(r3)
            int r2 = r2 + r4
            float r2 = (float) r2
            android.graphics.Paint r4 = r11.debugTextPaint
            java.lang.String r5 = "LOADING"
            r12.drawText(r5, r1, r2, r4)
            goto L_0x0413
        L_0x0411:
            r3 = 35
        L_0x0413:
            boolean r1 = r19.visible
            if (r1 == 0) goto L_0x0487
            boolean r1 = r11.debug
            if (r1 == 0) goto L_0x0487
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ISS "
            r1.append(r2)
            int r2 = r19.sampleSize
            r1.append(r2)
            java.lang.String r2 = " RECT "
            r1.append(r2)
            android.graphics.Rect r2 = r19.sRect
            int r2 = r2.top
            r1.append(r2)
            java.lang.String r2 = ","
            r1.append(r2)
            android.graphics.Rect r4 = r19.sRect
            int r4 = r4.left
            r1.append(r4)
            r1.append(r2)
            android.graphics.Rect r4 = r19.sRect
            int r4 = r4.bottom
            r1.append(r4)
            r1.append(r2)
            android.graphics.Rect r2 = r19.sRect
            int r2 = r2.right
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.graphics.Rect r2 = r19.vRect
            int r2 = r2.left
            r4 = 5
            int r5 = r11.px(r4)
            int r2 = r2 + r5
            float r2 = (float) r2
            android.graphics.Rect r4 = r19.vRect
            int r4 = r4.top
            r5 = 15
            int r6 = r11.px(r5)
            int r4 = r4 + r6
            float r4 = (float) r4
            android.graphics.Paint r6 = r11.debugTextPaint
            r12.drawText(r1, r2, r4, r6)
            goto L_0x0489
        L_0x0487:
            r5 = 15
        L_0x0489:
            r10 = r3
            r7 = r13
            r8 = r14
            goto L_0x0212
        L_0x048e:
            r10 = r3
            r7 = r13
            r8 = r14
            goto L_0x01e6
        L_0x0493:
            r3 = r10
            r5 = 15
            goto L_0x056d
        L_0x0498:
            r13 = r7
            r14 = r8
            r3 = r10
            r5 = 15
            android.graphics.Bitmap r0 = r11.bitmap
            if (r0 == 0) goto L_0x056d
            float r1 = r11.scale
            boolean r2 = r11.bitmapIsPreview
            if (r2 == 0) goto L_0x04c0
            int r2 = r11.sWidth
            float r2 = (float) r2
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r2 = r2 / r0
            float r1 = r1 * r2
            float r0 = r11.scale
            int r2 = r11.sHeight
            float r2 = (float) r2
            android.graphics.Bitmap r4 = r11.bitmap
            int r4 = r4.getHeight()
            float r4 = (float) r4
            float r2 = r2 / r4
            float r0 = r0 * r2
            goto L_0x04c1
        L_0x04c0:
            r0 = r1
        L_0x04c1:
            android.graphics.Matrix r2 = r11.matrix
            if (r2 != 0) goto L_0x04cc
            android.graphics.Matrix r2 = new android.graphics.Matrix
            r2.<init>()
            r11.matrix = r2
        L_0x04cc:
            android.graphics.Matrix r2 = r11.matrix
            r2.reset()
            android.graphics.Matrix r2 = r11.matrix
            r2.postScale(r1, r0)
            android.graphics.Matrix r0 = r11.matrix
            int r1 = r31.getRequiredRotation()
            float r1 = (float) r1
            r0.postRotate(r1)
            android.graphics.Matrix r0 = r11.matrix
            android.graphics.PointF r1 = r11.vTranslate
            float r1 = r1.x
            android.graphics.PointF r2 = r11.vTranslate
            float r2 = r2.y
            r0.postTranslate(r1, r2)
            int r0 = r31.getRequiredRotation()
            if (r0 != r13) goto L_0x0503
            android.graphics.Matrix r0 = r11.matrix
            float r1 = r11.scale
            int r2 = r11.sWidth
            float r2 = (float) r2
            float r2 = r2 * r1
            int r4 = r11.sHeight
            float r4 = (float) r4
            float r1 = r1 * r4
            r0.postTranslate(r2, r1)
            goto L_0x0526
        L_0x0503:
            int r0 = r31.getRequiredRotation()
            if (r0 != r14) goto L_0x0515
            android.graphics.Matrix r0 = r11.matrix
            float r1 = r11.scale
            int r2 = r11.sHeight
            float r2 = (float) r2
            float r1 = r1 * r2
            r0.postTranslate(r1, r9)
            goto L_0x0526
        L_0x0515:
            int r0 = r31.getRequiredRotation()
            if (r0 != r15) goto L_0x0526
            android.graphics.Matrix r0 = r11.matrix
            float r1 = r11.scale
            int r2 = r11.sWidth
            float r2 = (float) r2
            float r1 = r1 * r2
            r0.postTranslate(r9, r1)
        L_0x0526:
            android.graphics.Paint r0 = r11.tileBgPaint
            if (r0 == 0) goto L_0x0564
            android.graphics.RectF r0 = r11.sRect
            if (r0 != 0) goto L_0x0535
            android.graphics.RectF r0 = new android.graphics.RectF
            r0.<init>()
            r11.sRect = r0
        L_0x0535:
            android.graphics.RectF r0 = r11.sRect
            boolean r1 = r11.bitmapIsPreview
            if (r1 == 0) goto L_0x0542
            android.graphics.Bitmap r1 = r11.bitmap
            int r1 = r1.getWidth()
            goto L_0x0544
        L_0x0542:
            int r1 = r11.sWidth
        L_0x0544:
            float r1 = (float) r1
            boolean r2 = r11.bitmapIsPreview
            if (r2 == 0) goto L_0x0550
            android.graphics.Bitmap r2 = r11.bitmap
            int r2 = r2.getHeight()
            goto L_0x0552
        L_0x0550:
            int r2 = r11.sHeight
        L_0x0552:
            float r2 = (float) r2
            r0.set(r9, r9, r1, r2)
            android.graphics.Matrix r0 = r11.matrix
            android.graphics.RectF r1 = r11.sRect
            r0.mapRect(r1)
            android.graphics.RectF r0 = r11.sRect
            android.graphics.Paint r1 = r11.tileBgPaint
            r12.drawRect(r0, r1)
        L_0x0564:
            android.graphics.Bitmap r0 = r11.bitmap
            android.graphics.Matrix r1 = r11.matrix
            android.graphics.Paint r2 = r11.bitmapPaint
            r12.drawBitmap(r0, r1, r2)
        L_0x056d:
            boolean r0 = r11.debug
            if (r0 == 0) goto L_0x0761
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Scale: "
            r0.append(r1)
            java.util.Locale r1 = java.util.Locale.ENGLISH
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]
            float r6 = r11.scale
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            r7 = 0
            r4[r7] = r6
            java.lang.String r6 = "%.2f"
            java.lang.String r1 = java.lang.String.format(r1, r6, r4)
            r0.append(r1)
            java.lang.String r1 = " ("
            r0.append(r1)
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.Object[] r4 = new java.lang.Object[r2]
            float r8 = r31.minScale()
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            r4[r7] = r8
            java.lang.String r1 = java.lang.String.format(r1, r6, r4)
            r0.append(r1)
            java.lang.String r1 = " - "
            r0.append(r1)
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.Object[] r4 = new java.lang.Object[r2]
            float r2 = r11.maxScale
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r4[r7] = r2
            java.lang.String r1 = java.lang.String.format(r1, r6, r4)
            r0.append(r1)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 5
            int r2 = r11.px(r1)
            float r1 = (float) r2
            int r2 = r11.px(r5)
            float r2 = (float) r2
            android.graphics.Paint r4 = r11.debugTextPaint
            r12.drawText(r0, r1, r2, r4)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Translate: "
            r0.append(r1)
            java.util.Locale r1 = java.util.Locale.ENGLISH
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]
            android.graphics.PointF r5 = r11.vTranslate
            float r5 = r5.x
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r7 = 0
            r4[r7] = r5
            java.lang.String r1 = java.lang.String.format(r1, r6, r4)
            r0.append(r1)
            java.lang.String r1 = ":"
            r0.append(r1)
            java.util.Locale r4 = java.util.Locale.ENGLISH
            java.lang.Object[] r5 = new java.lang.Object[r2]
            android.graphics.PointF r2 = r11.vTranslate
            float r2 = r2.y
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r5[r7] = r2
            java.lang.String r2 = java.lang.String.format(r4, r6, r5)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = 5
            int r4 = r11.px(r2)
            float r2 = (float) r4
            r4 = 30
            int r5 = r11.px(r4)
            float r5 = (float) r5
            android.graphics.Paint r7 = r11.debugTextPaint
            r12.drawText(r0, r2, r5, r7)
            android.graphics.PointF r0 = r31.getCenter()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Source center: "
            r2.append(r5)
            java.util.Locale r5 = java.util.Locale.ENGLISH
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r7]
            float r9 = r0.x
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r10 = 0
            r8[r10] = r9
            java.lang.String r5 = java.lang.String.format(r5, r6, r8)
            r2.append(r5)
            r2.append(r1)
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.Object[] r5 = new java.lang.Object[r7]
            float r0 = r0.y
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r5[r10] = r0
            java.lang.String r0 = java.lang.String.format(r1, r6, r5)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1 = 5
            int r1 = r11.px(r1)
            float r1 = (float) r1
            r2 = 45
            int r2 = r11.px(r2)
            float r2 = (float) r2
            android.graphics.Paint r5 = r11.debugTextPaint
            r12.drawText(r0, r1, r2, r5)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r0 = r11.anim
            r1 = -16711681(0xffffffffff00ffff, float:-1.714704E38)
            r2 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r5 = 20
            r6 = -65536(0xffffffffffff0000, float:NaN)
            if (r0 == 0) goto L_0x06fc
            android.graphics.PointF r0 = r0.sCenterStart
            android.graphics.PointF r0 = r11.sourceToViewCoord(r0)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r7 = r11.anim
            android.graphics.PointF r7 = r7.sCenterEndRequested
            android.graphics.PointF r7 = r11.sourceToViewCoord(r7)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r8 = r11.anim
            android.graphics.PointF r8 = r8.sCenterEnd
            android.graphics.PointF r8 = r11.sourceToViewCoord(r8)
            float r9 = r0.x
            float r0 = r0.y
            r10 = 10
            int r10 = r11.px(r10)
            float r10 = (float) r10
            android.graphics.Paint r13 = r11.debugLinePaint
            r12.drawCircle(r9, r0, r10, r13)
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r6)
            float r0 = r7.x
            float r7 = r7.y
            int r9 = r11.px(r5)
            float r9 = (float) r9
            android.graphics.Paint r10 = r11.debugLinePaint
            r12.drawCircle(r0, r7, r9, r10)
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r2)
            float r0 = r8.x
            float r7 = r8.y
            r8 = 25
            int r8 = r11.px(r8)
            float r8 = (float) r8
            android.graphics.Paint r9 = r11.debugLinePaint
            r12.drawCircle(r0, r7, r8, r9)
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r1)
            int r0 = r31.getWidth()
            int r0 = r0 / 2
            float r0 = (float) r0
            int r7 = r31.getHeight()
            int r7 = r7 / 2
            float r7 = (float) r7
            int r8 = r11.px(r4)
            float r8 = (float) r8
            android.graphics.Paint r9 = r11.debugLinePaint
            r12.drawCircle(r0, r7, r8, r9)
        L_0x06fc:
            android.graphics.PointF r0 = r11.vCenterStart
            if (r0 == 0) goto L_0x0717
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r6)
            android.graphics.PointF r0 = r11.vCenterStart
            float r0 = r0.x
            android.graphics.PointF r6 = r11.vCenterStart
            float r6 = r6.y
            int r5 = r11.px(r5)
            float r5 = (float) r5
            android.graphics.Paint r7 = r11.debugLinePaint
            r12.drawCircle(r0, r6, r5, r7)
        L_0x0717:
            android.graphics.PointF r0 = r11.quickScaleSCenter
            if (r0 == 0) goto L_0x073a
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r2)
            android.graphics.PointF r0 = r11.quickScaleSCenter
            float r0 = r0.x
            float r0 = r11.sourceToViewX(r0)
            android.graphics.PointF r2 = r11.quickScaleSCenter
            float r2 = r2.y
            float r2 = r11.sourceToViewY(r2)
            int r3 = r11.px(r3)
            float r3 = (float) r3
            android.graphics.Paint r5 = r11.debugLinePaint
            r12.drawCircle(r0, r2, r3, r5)
        L_0x073a:
            android.graphics.PointF r0 = r11.quickScaleVStart
            if (r0 == 0) goto L_0x0759
            boolean r0 = r11.isQuickScaling
            if (r0 == 0) goto L_0x0759
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r1)
            android.graphics.PointF r0 = r11.quickScaleVStart
            float r0 = r0.x
            android.graphics.PointF r1 = r11.quickScaleVStart
            float r1 = r1.y
            int r2 = r11.px(r4)
            float r2 = (float) r2
            android.graphics.Paint r3 = r11.debugLinePaint
            r12.drawCircle(r0, r1, r2, r3)
        L_0x0759:
            android.graphics.Paint r0 = r11.debugLinePaint
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            r0.setColor(r1)
        L_0x0761:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onDraw(android.graphics.Canvas):void");
    }

    private void setMatrixArray(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        fArr[6] = f7;
        fArr[7] = f8;
    }

    private boolean isBaseLayerReady() {
        boolean z = true;
        if (this.bitmap != null && !this.bitmapIsPreview) {
            return true;
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map == null) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (((Integer) next.getKey()).intValue() == this.fullImageSampleSize) {
                for (Tile tile : (List) next.getValue()) {
                    if (tile.loading || tile.bitmap == null) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    private boolean checkReady() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady());
        if (!this.readySent && z) {
            preDraw();
            this.readySent = true;
            onReady();
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null) {
                onImageEventListener2.onReady();
            }
        }
        return z;
    }

    private boolean checkImageLoaded() {
        boolean isBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && isBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null) {
                onImageEventListener2.onImageLoaded();
            }
        }
        return isBaseLayerReady;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            Paint paint = new Paint();
            this.bitmapPaint = paint;
            paint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if ((this.debugTextPaint == null || this.debugLinePaint == null) && this.debug) {
            Paint paint2 = new Paint();
            this.debugTextPaint = paint2;
            paint2.setTextSize((float) px(12));
            this.debugTextPaint.setColor(-65281);
            this.debugTextPaint.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.debugLinePaint = paint3;
            paint3.setColor(-65281);
            this.debugLinePaint.setStyle(Paint.Style.STROKE);
            this.debugLinePaint.setStrokeWidth((float) px(1));
        }
    }

    private synchronized void initialiseBaseLayer(Point point) {
        debug("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        this.satTemp = scaleAndTranslate;
        fitToBounds(true, scaleAndTranslate);
        int calculateInSampleSize = calculateInSampleSize(this.satTemp.scale);
        this.fullImageSampleSize = calculateInSampleSize;
        if (calculateInSampleSize > 1) {
            this.fullImageSampleSize = calculateInSampleSize / 2;
        }
        if (this.fullImageSampleSize != 1 || this.sRegion != null || sWidth() >= point.x || sHeight() >= point.y) {
            initialiseTileMap(point);
            for (Tile tileLoadTask : this.tileMap.get(Integer.valueOf(this.fullImageSampleSize))) {
                execute(new TileLoadTask(this, this.decoder, tileLoadTask));
            }
            refreshRequiredTiles(true);
        } else {
            this.decoder.recycle();
            this.decoder = null;
            execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
        }
    }

    private void refreshRequiredTiles(boolean z) {
        if (this.decoder != null && this.tileMap != null) {
            int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
            for (Map.Entry<Integer, List<Tile>> value : this.tileMap.entrySet()) {
                for (Tile tile : (List) value.getValue()) {
                    if (tile.sampleSize < min || (tile.sampleSize > min && tile.sampleSize != this.fullImageSampleSize)) {
                        boolean unused = tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            Bitmap unused2 = tile.bitmap = null;
                        }
                    }
                    if (tile.sampleSize == min) {
                        if (tileVisible(tile)) {
                            boolean unused3 = tile.visible = true;
                            if (!tile.loading && tile.bitmap == null && z) {
                                execute(new TileLoadTask(this, this.decoder, tile));
                            }
                        } else if (tile.sampleSize != this.fullImageSampleSize) {
                            boolean unused4 = tile.visible = false;
                            if (tile.bitmap != null) {
                                tile.bitmap.recycle();
                                Bitmap unused5 = tile.bitmap = null;
                            }
                        }
                    } else if (tile.sampleSize == this.fullImageSampleSize) {
                        boolean unused6 = tile.visible = true;
                    }
                }
            }
        }
    }

    private boolean tileVisible(Tile tile) {
        return viewToSourceX(0.0f) <= ((float) tile.sRect.right) && ((float) tile.sRect.left) <= viewToSourceX((float) getWidth()) && viewToSourceY(0.0f) <= ((float) tile.sRect.bottom) && ((float) tile.sRect.top) <= viewToSourceY((float) getHeight());
    }

    private void preDraw() {
        Float f;
        if (getWidth() != 0 && getHeight() != 0 && this.sWidth > 0 && this.sHeight > 0) {
            if (!(this.sPendingCenter == null || (f = this.pendingScale) == null)) {
                this.scale = f.floatValue();
                if (this.vTranslate == null) {
                    this.vTranslate = new PointF();
                }
                this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * this.sPendingCenter.x);
                this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * this.sPendingCenter.y);
                this.sPendingCenter = null;
                this.pendingScale = null;
                fitToBounds(true);
                refreshRequiredTiles(true);
            }
            fitToBounds(false);
        }
    }

    private int calculateInSampleSize(float f) {
        int i;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f *= ((float) this.minimumTileDpi) / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int sWidth2 = (int) (((float) sWidth()) * f);
        int sHeight2 = (int) (((float) sHeight()) * f);
        if (sWidth2 == 0 || sHeight2 == 0) {
            return 32;
        }
        int i2 = 1;
        if (sHeight() > sHeight2 || sWidth() > sWidth2) {
            i = Math.round(((float) sHeight()) / ((float) sHeight2));
            int round = Math.round(((float) sWidth()) / ((float) sWidth2));
            if (i >= round) {
                i = round;
            }
        } else {
            i = 1;
        }
        while (true) {
            int i3 = i2 * 2;
            if (i3 >= i) {
                return i2;
            }
            i2 = i3;
        }
    }

    /* access modifiers changed from: private */
    public void fitToBounds(boolean z, ScaleAndTranslate scaleAndTranslate) {
        float f;
        float f2;
        int i;
        if (this.panLimit == 2 && isReady()) {
            z = false;
        }
        PointF access$4800 = scaleAndTranslate.vTranslate;
        float limitedScale = limitedScale(scaleAndTranslate.scale);
        float sWidth2 = ((float) sWidth()) * limitedScale;
        float sHeight2 = ((float) sHeight()) * limitedScale;
        if (this.panLimit == 3 && isReady()) {
            access$4800.x = Math.max(access$4800.x, ((float) (getWidth() / 2)) - sWidth2);
            access$4800.y = Math.max(access$4800.y, ((float) (getHeight() / 2)) - sHeight2);
        } else if (z) {
            access$4800.x = Math.max(access$4800.x, ((float) getWidth()) - sWidth2);
            access$4800.y = Math.max(access$4800.y, ((float) getHeight()) - sHeight2);
        } else {
            access$4800.x = Math.max(access$4800.x, -sWidth2);
            access$4800.y = Math.max(access$4800.y, -sHeight2);
        }
        float f3 = 0.5f;
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? ((float) getPaddingLeft()) / ((float) (getPaddingLeft() + getPaddingRight())) : 0.5f;
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f3 = ((float) getPaddingTop()) / ((float) (getPaddingTop() + getPaddingBottom()));
        }
        if (this.panLimit == 3 && isReady()) {
            f = (float) Math.max(0, getWidth() / 2);
            i = Math.max(0, getHeight() / 2);
        } else if (z) {
            f = Math.max(0.0f, (((float) getWidth()) - sWidth2) * paddingLeft);
            f2 = Math.max(0.0f, (((float) getHeight()) - sHeight2) * f3);
            access$4800.x = Math.min(access$4800.x, f);
            access$4800.y = Math.min(access$4800.y, f2);
            float unused = scaleAndTranslate.scale = limitedScale;
        } else {
            f = (float) Math.max(0, getWidth());
            i = Math.max(0, getHeight());
        }
        f2 = (float) i;
        access$4800.x = Math.min(access$4800.x, f);
        access$4800.y = Math.min(access$4800.y, f2);
        float unused2 = scaleAndTranslate.scale = limitedScale;
    }

    private void fitToBounds(boolean z) {
        boolean z2;
        if (this.vTranslate == null) {
            z2 = true;
            this.vTranslate = new PointF(0.0f, 0.0f);
        } else {
            z2 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        float unused = this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z, this.satTemp);
        this.scale = this.satTemp.scale;
        this.vTranslate.set(this.satTemp.vTranslate);
        if (z2 && this.minimumScaleType != 4) {
            this.vTranslate.set(vTranslateForSCenter((float) (sWidth() / 2), (float) (sHeight() / 2), this.scale));
        }
    }

    private void initialiseTileMap(Point point) {
        Point point2 = point;
        boolean z = false;
        boolean z2 = true;
        debug("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point2.x), Integer.valueOf(point2.y));
        this.tileMap = new LinkedHashMap();
        int i = this.fullImageSampleSize;
        int i2 = 1;
        int i3 = 1;
        while (true) {
            int sWidth2 = sWidth() / i2;
            int sHeight2 = sHeight() / i3;
            int i4 = sWidth2 / i;
            int i5 = sHeight2 / i;
            while (true) {
                if (i4 + i2 + (z2 ? 1 : 0) > point2.x || (((double) i4) > ((double) getWidth()) * 1.25d && i < this.fullImageSampleSize)) {
                    boolean z3 = z2;
                    boolean z4 = z;
                    boolean z5 = z3;
                    i2++;
                    sWidth2 = sWidth() / i2;
                    i4 = sWidth2 / i;
                    boolean z6 = z4;
                    z2 = z5;
                    z = z6;
                }
            }
            while (true) {
                if (i5 + i3 + (z2 ? 1 : 0) > point2.y || (((double) i5) > ((double) getHeight()) * 1.25d && i < this.fullImageSampleSize)) {
                    boolean z7 = z2;
                    boolean z8 = z;
                    boolean z9 = z7;
                    i3++;
                    sHeight2 = sHeight() / i3;
                    i5 = sHeight2 / i;
                    boolean z10 = z8;
                    z2 = z9;
                    z = z10;
                }
            }
            ArrayList arrayList = new ArrayList(i2 * i3);
            int i6 = z;
            while (i6 < i2) {
                int i7 = z;
                while (i7 < i3) {
                    Tile tile = new Tile();
                    int unused = tile.sampleSize = i;
                    boolean unused2 = tile.visible = i == this.fullImageSampleSize ? z2 : z;
                    Rect unused3 = tile.sRect = new Rect(i6 * sWidth2, i7 * sHeight2, i6 == i2 + -1 ? sWidth() : (i6 + 1) * sWidth2, i7 == i3 + -1 ? sHeight() : (i7 + 1) * sHeight2);
                    Rect unused4 = tile.vRect = new Rect(0, 0, 0, 0);
                    Rect unused5 = tile.fileSRect = new Rect(tile.sRect);
                    arrayList.add(tile);
                    i7++;
                    z = false;
                    z2 = true;
                }
                boolean z11 = z;
                i6++;
                z2 = true;
            }
            boolean z12 = z;
            this.tileMap.put(Integer.valueOf(i), arrayList);
            if (i != 1) {
                i /= 2;
                boolean z13 = z12;
                z2 = true;
                z = z13;
            } else {
                return;
            }
        }
    }

    private static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private ImageRegionDecoder decoder;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
        }

        /* access modifiers changed from: protected */
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = (Context) this.contextRef.get();
                DecoderFactory decoderFactory = (DecoderFactory) this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("TilesInitTask.doInBackground", new Object[0]);
                ImageRegionDecoder imageRegionDecoder = (ImageRegionDecoder) decoderFactory.make();
                this.decoder = imageRegionDecoder;
                Point init = imageRegionDecoder.init(context, this.source);
                int i = init.x;
                int i2 = init.y;
                int access$5200 = subsamplingScaleImageView.getExifOrientation(context, uri);
                if (subsamplingScaleImageView.sRegion != null) {
                    subsamplingScaleImageView.sRegion.left = Math.max(0, subsamplingScaleImageView.sRegion.left);
                    subsamplingScaleImageView.sRegion.top = Math.max(0, subsamplingScaleImageView.sRegion.top);
                    subsamplingScaleImageView.sRegion.right = Math.min(i, subsamplingScaleImageView.sRegion.right);
                    subsamplingScaleImageView.sRegion.bottom = Math.min(i2, subsamplingScaleImageView.sRegion.bottom);
                    i = subsamplingScaleImageView.sRegion.width();
                    i2 = subsamplingScaleImageView.sRegion.height();
                }
                return new int[]{i, i2, access$5200};
            } catch (Exception e) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e);
                this.exception = e;
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.orientation));
        int i7 = this.sWidth;
        if (i7 > 0 && (i6 = this.sHeight) > 0 && !(i7 == i && i6 == i2)) {
            reset(false);
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 != null) {
                if (!this.bitmapIsCached) {
                    bitmap2.recycle();
                }
                this.bitmap = null;
                OnImageEventListener onImageEventListener2 = this.onImageEventListener;
                if (onImageEventListener2 != null && this.bitmapIsCached) {
                    onImageEventListener2.onPreviewReleased();
                }
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
        }
        this.decoder = imageRegionDecoder;
        this.sWidth = i;
        this.sHeight = i2;
        this.sOrientation = i3;
        checkReady();
        if (!checkImageLoaded() && (i4 = this.maxTileWidth) > 0 && i4 != Integer.MAX_VALUE && (i5 = this.maxTileHeight) > 0 && i5 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
            initialiseBaseLayer(new Point(this.maxTileWidth, this.maxTileHeight));
        }
        invalidate();
        requestLayout();
    }

    private static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.decoderRef = new WeakReference<>(imageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
            boolean unused = tile.loading = true;
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(Void... voidArr) {
            SubsamplingScaleImageView subsamplingScaleImageView;
            try {
                subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
                ImageRegionDecoder imageRegionDecoder = (ImageRegionDecoder) this.decoderRef.get();
                Tile tile = (Tile) this.tileRef.get();
                if (imageRegionDecoder != null && tile != null && subsamplingScaleImageView != null && imageRegionDecoder.isReady() && tile.visible) {
                    subsamplingScaleImageView.debug("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", tile.sRect, Integer.valueOf(tile.sampleSize));
                    subsamplingScaleImageView.decoderLock.readLock().lock();
                    if (imageRegionDecoder.isReady()) {
                        subsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                        if (subsamplingScaleImageView.sRegion != null) {
                            tile.fileSRect.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                        }
                        Bitmap decodeRegion = imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                        subsamplingScaleImageView.decoderLock.readLock().unlock();
                        return decodeRegion;
                    }
                    boolean unused = tile.loading = false;
                    subsamplingScaleImageView.decoderLock.readLock().unlock();
                    return null;
                } else if (tile == null) {
                    return null;
                } else {
                    boolean unused2 = tile.loading = false;
                    return null;
                }
            } catch (Exception e) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile", e);
                this.exception = e;
                return null;
            } catch (OutOfMemoryError e2) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile - OutOfMemoryError", e2);
                this.exception = new RuntimeException(e2);
                return null;
            } catch (Throwable th) {
                subsamplingScaleImageView.decoderLock.readLock().unlock();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
            Tile tile = (Tile) this.tileRef.get();
            if (subsamplingScaleImageView != null && tile != null) {
                if (bitmap != null) {
                    Bitmap unused = tile.bitmap = bitmap;
                    boolean unused2 = tile.loading = false;
                    subsamplingScaleImageView.onTileLoaded();
                } else if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                    subsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        Bitmap bitmap2;
        debug("onTileLoaded", new Object[0]);
        checkReady();
        checkImageLoaded();
        if (isBaseLayerReady() && (bitmap2 = this.bitmap) != null) {
            if (!this.bitmapIsCached) {
                bitmap2.recycle();
            }
            this.bitmap = null;
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null && this.bitmapIsCached) {
                onImageEventListener2.onPreviewReleased();
            }
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        invalidate();
    }

    private static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
            this.preview = z;
        }

        /* access modifiers changed from: protected */
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = (Context) this.contextRef.get();
                DecoderFactory decoderFactory = (DecoderFactory) this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("BitmapLoadTask.doInBackground", new Object[0]);
                this.bitmap = ((ImageDecoder) decoderFactory.make()).decode(context, this.source);
                return Integer.valueOf(subsamplingScaleImageView.getExifOrientation(context, uri));
            } catch (Exception e) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap", e);
                this.exception = e;
                return null;
            } catch (OutOfMemoryError e2) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap - OutOfMemoryError", e2);
                this.exception = new RuntimeException(e2);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 == null || num == null) {
                    if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                        if (this.preview) {
                            subsamplingScaleImageView.onImageEventListener.onPreviewLoadError(this.exception);
                        } else {
                            subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                        }
                    }
                } else if (this.preview) {
                    subsamplingScaleImageView.onPreviewLoaded(bitmap2);
                } else {
                    subsamplingScaleImageView.onImageLoaded(bitmap2, num.intValue(), false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onPreviewLoaded(android.graphics.Bitmap r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "onPreviewLoaded"
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0047 }
            r4.debug(r0, r1)     // Catch:{ all -> 0x0047 }
            android.graphics.Bitmap r0 = r4.bitmap     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0042
            boolean r0 = r4.imageLoadedSent     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0012
            goto L_0x0042
        L_0x0012:
            android.graphics.Rect r0 = r4.pRegion     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x002f
            int r0 = r0.left     // Catch:{ all -> 0x0047 }
            android.graphics.Rect r1 = r4.pRegion     // Catch:{ all -> 0x0047 }
            int r1 = r1.top     // Catch:{ all -> 0x0047 }
            android.graphics.Rect r2 = r4.pRegion     // Catch:{ all -> 0x0047 }
            int r2 = r2.width()     // Catch:{ all -> 0x0047 }
            android.graphics.Rect r3 = r4.pRegion     // Catch:{ all -> 0x0047 }
            int r3 = r3.height()     // Catch:{ all -> 0x0047 }
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r5, r0, r1, r2, r3)     // Catch:{ all -> 0x0047 }
            r4.bitmap = r5     // Catch:{ all -> 0x0047 }
            goto L_0x0031
        L_0x002f:
            r4.bitmap = r5     // Catch:{ all -> 0x0047 }
        L_0x0031:
            r5 = 1
            r4.bitmapIsPreview = r5     // Catch:{ all -> 0x0047 }
            boolean r5 = r4.checkReady()     // Catch:{ all -> 0x0047 }
            if (r5 == 0) goto L_0x0040
            r4.invalidate()     // Catch:{ all -> 0x0047 }
            r4.requestLayout()     // Catch:{ all -> 0x0047 }
        L_0x0040:
            monitor-exit(r4)
            return
        L_0x0042:
            r5.recycle()     // Catch:{ all -> 0x0047 }
            monitor-exit(r4)
            return
        L_0x0047:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onPreviewLoaded(android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap2, int i, boolean z) {
        OnImageEventListener onImageEventListener2;
        debug("onImageLoaded", new Object[0]);
        int i2 = this.sWidth;
        if (i2 > 0 && this.sHeight > 0 && !(i2 == bitmap2.getWidth() && this.sHeight == bitmap2.getHeight())) {
            reset(false);
        }
        Bitmap bitmap3 = this.bitmap;
        if (bitmap3 != null && !this.bitmapIsCached) {
            bitmap3.recycle();
        }
        if (!(this.bitmap == null || !this.bitmapIsCached || (onImageEventListener2 = this.onImageEventListener) == null)) {
            onImageEventListener2.onPreviewReleased();
        }
        this.bitmapIsPreview = false;
        this.bitmapIsCached = z;
        this.bitmap = bitmap2;
        this.sWidth = bitmap2.getWidth();
        this.sHeight = bitmap2.getHeight();
        this.sOrientation = i;
        boolean checkReady = checkReady();
        boolean checkImageLoaded = checkImageLoaded();
        if (checkReady || checkImageLoaded) {
            invalidate();
            requestLayout();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        android.util.Log.w(TAG, "Could not get orientation of image from media store");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        if (r0 != null) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getExifOrientation(android.content.Context r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "content"
            boolean r0 = r11.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L_0x006b
            r0 = 0
            java.lang.String r2 = "orientation"
            java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x005b }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x005b }
            android.net.Uri r4 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x005b }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x005b }
            if (r0 == 0) goto L_0x0052
            boolean r10 = r0.moveToFirst()     // Catch:{ Exception -> 0x005b }
            if (r10 == 0) goto L_0x0052
            int r10 = r0.getInt(r1)     // Catch:{ Exception -> 0x005b }
            java.util.List<java.lang.Integer> r11 = VALID_ORIENTATIONS     // Catch:{ Exception -> 0x005b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x005b }
            boolean r11 = r11.contains(r2)     // Catch:{ Exception -> 0x005b }
            if (r11 == 0) goto L_0x003c
            r11 = -1
            if (r10 == r11) goto L_0x003c
            r1 = r10
            goto L_0x0052
        L_0x003c:
            java.lang.String r11 = TAG     // Catch:{ Exception -> 0x005b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005b }
            r2.<init>()     // Catch:{ Exception -> 0x005b }
            java.lang.String r3 = "Unsupported orientation: "
            r2.append(r3)     // Catch:{ Exception -> 0x005b }
            r2.append(r10)     // Catch:{ Exception -> 0x005b }
            java.lang.String r10 = r2.toString()     // Catch:{ Exception -> 0x005b }
            android.util.Log.w(r11, r10)     // Catch:{ Exception -> 0x005b }
        L_0x0052:
            if (r0 == 0) goto L_0x00c3
        L_0x0054:
            r0.close()
            goto L_0x00c3
        L_0x0059:
            r10 = move-exception
            goto L_0x0065
        L_0x005b:
            java.lang.String r10 = TAG     // Catch:{ all -> 0x0059 }
            java.lang.String r11 = "Could not get orientation of image from media store"
            android.util.Log.w(r10, r11)     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x00c3
            goto L_0x0054
        L_0x0065:
            if (r0 == 0) goto L_0x006a
            r0.close()
        L_0x006a:
            throw r10
        L_0x006b:
            java.lang.String r10 = "file:///"
            boolean r10 = r11.startsWith(r10)
            if (r10 == 0) goto L_0x00c3
            java.lang.String r10 = "file:///android_asset/"
            boolean r10 = r11.startsWith(r10)
            if (r10 != 0) goto L_0x00c3
            androidx.exifinterface.media.ExifInterface r10 = new androidx.exifinterface.media.ExifInterface     // Catch:{ Exception -> 0x00bc }
            r0 = 7
            java.lang.String r11 = r11.substring(r0)     // Catch:{ Exception -> 0x00bc }
            r10.<init>(r11)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r11 = "Orientation"
            r0 = 1
            int r10 = r10.getAttributeInt(r11, r0)     // Catch:{ Exception -> 0x00bc }
            if (r10 == r0) goto L_0x00c3
            if (r10 != 0) goto L_0x0091
            goto L_0x00c3
        L_0x0091:
            r11 = 6
            if (r10 != r11) goto L_0x0098
            r10 = 90
        L_0x0096:
            r1 = r10
            goto L_0x00c3
        L_0x0098:
            r11 = 3
            if (r10 != r11) goto L_0x009e
            r10 = 180(0xb4, float:2.52E-43)
            goto L_0x0096
        L_0x009e:
            r11 = 8
            if (r10 != r11) goto L_0x00a5
            r10 = 270(0x10e, float:3.78E-43)
            goto L_0x0096
        L_0x00a5:
            java.lang.String r11 = TAG     // Catch:{ Exception -> 0x00bc }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bc }
            r0.<init>()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r2 = "Unsupported EXIF orientation: "
            r0.append(r2)     // Catch:{ Exception -> 0x00bc }
            r0.append(r10)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x00bc }
            android.util.Log.w(r11, r10)     // Catch:{ Exception -> 0x00bc }
            goto L_0x00c3
        L_0x00bc:
            java.lang.String r10 = TAG
            java.lang.String r11 = "Could not get EXIF orientation of image"
            android.util.Log.w(r10, r11)
        L_0x00c3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.getExifOrientation(android.content.Context, java.lang.String):int");
    }

    private void execute(AsyncTask<Void, Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.executor, new Void[0]);
    }

    private static class Tile {
        /* access modifiers changed from: private */
        public Bitmap bitmap;
        /* access modifiers changed from: private */
        public Rect fileSRect;
        /* access modifiers changed from: private */
        public boolean loading;
        /* access modifiers changed from: private */
        public Rect sRect;
        /* access modifiers changed from: private */
        public int sampleSize;
        /* access modifiers changed from: private */
        public Rect vRect;
        /* access modifiers changed from: private */
        public boolean visible;

        private Tile() {
        }
    }

    private static class Anim {
        /* access modifiers changed from: private */
        public long duration;
        /* access modifiers changed from: private */
        public int easing;
        /* access modifiers changed from: private */
        public boolean interruptible;
        /* access modifiers changed from: private */
        public OnAnimationEventListener listener;
        /* access modifiers changed from: private */
        public int origin;
        /* access modifiers changed from: private */
        public PointF sCenterEnd;
        /* access modifiers changed from: private */
        public PointF sCenterEndRequested;
        /* access modifiers changed from: private */
        public PointF sCenterStart;
        /* access modifiers changed from: private */
        public float scaleEnd;
        /* access modifiers changed from: private */
        public float scaleStart;
        /* access modifiers changed from: private */
        public long time;
        /* access modifiers changed from: private */
        public PointF vFocusEnd;
        /* access modifiers changed from: private */
        public PointF vFocusStart;

        private Anim() {
            this.duration = 500;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = System.currentTimeMillis();
        }
    }

    private static class ScaleAndTranslate {
        /* access modifiers changed from: private */
        public float scale;
        /* access modifiers changed from: private */
        public final PointF vTranslate;

        private ScaleAndTranslate(float f, PointF pointF) {
            this.scale = f;
            this.vTranslate = pointF;
        }
    }

    private void restoreState(ImageViewState imageViewState) {
        if (imageViewState != null && VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.orientation = imageViewState.getOrientation();
            this.pendingScale = Float.valueOf(imageViewState.getScale());
            this.sPendingCenter = imageViewState.getCenter();
            invalidate();
        }
    }

    public void setMaxTileSize(int i) {
        this.maxTileWidth = i;
        this.maxTileHeight = i;
    }

    public void setMaxTileSize(int i, int i2) {
        this.maxTileWidth = i;
        this.maxTileHeight = i2;
    }

    private Point getMaxBitmapDimensions(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.maxTileWidth), Math.min(canvas.getMaximumBitmapHeight(), this.maxTileHeight));
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.sHeight;
        }
        return this.sWidth;
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.sWidth;
        }
        return this.sHeight;
    }

    /* access modifiers changed from: private */
    public void fileSRect(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (getRequiredRotation() == 90) {
            rect2.set(rect.top, this.sHeight - rect.right, rect.bottom, this.sHeight - rect.left);
        } else if (getRequiredRotation() == 180) {
            rect2.set(this.sWidth - rect.right, this.sHeight - rect.bottom, this.sWidth - rect.left, this.sHeight - rect.top);
        } else {
            rect2.set(this.sWidth - rect.bottom, rect.left, this.sWidth - rect.top, rect.right);
        }
    }

    private int getRequiredRotation() {
        int i = this.orientation;
        return i == -1 ? this.sOrientation : i;
    }

    private float distance(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugTextPaint = null;
        this.debugLinePaint = null;
        this.tileBgPaint = null;
    }

    private float viewToSourceX(float f) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f - pointF.x) / this.scale;
    }

    private float viewToSourceY(float f) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f - pointF.y) / this.scale;
    }

    public void viewToFileRect(Rect rect, Rect rect2) {
        if (this.vTranslate != null && this.readySent) {
            rect2.set((int) viewToSourceX((float) rect.left), (int) viewToSourceY((float) rect.top), (int) viewToSourceX((float) rect.right), (int) viewToSourceY((float) rect.bottom));
            fileSRect(rect2, rect2);
            rect2.set(Math.max(0, rect2.left), Math.max(0, rect2.top), Math.min(this.sWidth, rect2.right), Math.min(this.sHeight, rect2.bottom));
            Rect rect3 = this.sRegion;
            if (rect3 != null) {
                rect2.offset(rect3.left, this.sRegion.top);
            }
        }
    }

    public void visibleFileRect(Rect rect) {
        if (this.vTranslate != null && this.readySent) {
            rect.set(0, 0, getWidth(), getHeight());
            viewToFileRect(rect, rect);
        }
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF viewToSourceCoord(float f, float f2) {
        return viewToSourceCoord(f, f2, new PointF());
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF viewToSourceCoord(float f, float f2, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f), viewToSourceY(f2));
        return pointF;
    }

    private float sourceToViewX(float f) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f * this.scale) + pointF.x;
    }

    private float sourceToViewY(float f) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f * this.scale) + pointF.y;
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF sourceToViewCoord(float f, float f2) {
        return sourceToViewCoord(f, f2, new PointF());
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF sourceToViewCoord(float f, float f2, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f), sourceToViewY(f2));
        return pointF;
    }

    private void sourceToViewRect(Rect rect, Rect rect2) {
        rect2.set((int) sourceToViewX((float) rect.left), (int) sourceToViewY((float) rect.top), (int) sourceToViewX((float) rect.right), (int) sourceToViewY((float) rect.bottom));
    }

    private PointF vTranslateForSCenter(float f, float f2, float f3) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        float unused = this.satTemp.scale = f3;
        this.satTemp.vTranslate.set(((float) paddingLeft) - (f * f3), ((float) paddingTop) - (f2 * f3));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    /* access modifiers changed from: private */
    public PointF limitedSCenter(float f, float f2, float f3, PointF pointF) {
        PointF vTranslateForSCenter = vTranslateForSCenter(f, f2, f3);
        pointF.set((((float) (getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2))) - vTranslateForSCenter.x) / f3, (((float) (getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2))) - vTranslateForSCenter.y) / f3);
        return pointF;
    }

    private float minScale() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i = this.minimumScaleType;
        if (i == 2 || i == 4) {
            return Math.max(((float) (getWidth() - paddingLeft)) / ((float) sWidth()), ((float) (getHeight() - paddingBottom)) / ((float) sHeight()));
        }
        if (i == 3) {
            float f = this.minScale;
            if (f > 0.0f) {
                return f;
            }
        }
        return Math.min(((float) (getWidth() - paddingLeft)) / ((float) sWidth()), ((float) (getHeight() - paddingBottom)) / ((float) sHeight()));
    }

    /* access modifiers changed from: private */
    public float limitedScale(float f) {
        return Math.min(this.maxScale, Math.max(minScale(), f));
    }

    private float ease(int i, long j, float f, float f2, long j2) {
        if (i == 1) {
            return easeOutQuad(j, f, f2, j2);
        }
        if (i == 2) {
            return easeInOutQuad(j, f, f2, j2);
        }
        throw new IllegalStateException("Unexpected easing type: " + i);
    }

    /* access modifiers changed from: private */
    public void debug(String str, Object... objArr) {
        if (this.debug) {
            Log.d(TAG, String.format(str, objArr));
        }
    }

    private int px(int i) {
        return (int) (this.density * ((float) i));
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> cls) {
        if (cls != null) {
            this.regionDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.regionDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> cls) {
        if (cls != null) {
            this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.bitmapDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void getPanRemaining(RectF rectF) {
        if (isReady()) {
            float sWidth2 = this.scale * ((float) sWidth());
            float sHeight2 = this.scale * ((float) sHeight());
            int i = this.panLimit;
            if (i == 3) {
                rectF.top = Math.max(0.0f, -(this.vTranslate.y - ((float) (getHeight() / 2))));
                rectF.left = Math.max(0.0f, -(this.vTranslate.x - ((float) (getWidth() / 2))));
                rectF.bottom = Math.max(0.0f, this.vTranslate.y - (((float) (getHeight() / 2)) - sHeight2));
                rectF.right = Math.max(0.0f, this.vTranslate.x - (((float) (getWidth() / 2)) - sWidth2));
            } else if (i == 2) {
                rectF.top = Math.max(0.0f, -(this.vTranslate.y - ((float) getHeight())));
                rectF.left = Math.max(0.0f, -(this.vTranslate.x - ((float) getWidth())));
                rectF.bottom = Math.max(0.0f, this.vTranslate.y + sHeight2);
                rectF.right = Math.max(0.0f, this.vTranslate.x + sWidth2);
            } else {
                rectF.top = Math.max(0.0f, -this.vTranslate.y);
                rectF.left = Math.max(0.0f, -this.vTranslate.x);
                rectF.bottom = Math.max(0.0f, (sHeight2 + this.vTranslate.y) - ((float) getHeight()));
                rectF.right = Math.max(0.0f, (sWidth2 + this.vTranslate.x) - ((float) getWidth()));
            }
        }
    }

    public final void setPanLimit(int i) {
        if (VALID_PAN_LIMITS.contains(Integer.valueOf(i))) {
            this.panLimit = i;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i);
    }

    public final void setMinimumScaleType(int i) {
        if (VALID_SCALE_TYPES.contains(Integer.valueOf(i))) {
            this.minimumScaleType = i;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i);
    }

    public final void setMaxScale(float f) {
        this.maxScale = f;
    }

    public final void setMinScale(float f) {
        this.minScale = f;
    }

    public final void setMinimumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i));
    }

    public final void setMaximumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i));
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public void setMinimumTileDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, (float) i);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public final PointF getCenter() {
        return viewToSourceCoord((float) (getWidth() / 2), (float) (getHeight() / 2));
    }

    public final float getScale() {
        return this.scale;
    }

    public final void setScaleAndCenter(float f, PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new PointF((float) (sWidth() / 2), (float) (sHeight() / 2));
        } else {
            this.sPendingCenter = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final ImageViewState getState() {
        if (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    public final void setZoomEnabled(boolean z) {
        this.zoomEnabled = z;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.quickScaleEnabled = z;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        this.panEnabled = z;
        if (!z && (pointF = this.vTranslate) != null) {
            pointF.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (sWidth() / 2)));
            this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (sHeight() / 2)));
            if (isReady()) {
                refreshRequiredTiles(true);
                invalidate();
            }
        }
    }

    public final void setTileBackgroundColor(int i) {
        if (Color.alpha(i) == 0) {
            this.tileBgPaint = null;
        } else {
            Paint paint = new Paint();
            this.tileBgPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(i);
        }
        invalidate();
    }

    public final void setDoubleTapZoomScale(float f) {
        this.doubleTapZoomScale = f;
    }

    public final void setDoubleTapZoomDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i));
    }

    public final void setDoubleTapZoomStyle(int i) {
        if (VALID_ZOOM_STYLES.contains(Integer.valueOf(i))) {
            this.doubleTapZoomStyle = i;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i);
    }

    public final void setDoubleTapZoomDuration(int i) {
        this.doubleTapZoomDuration = Math.max(0, i);
    }

    public void setExecutor(Executor executor2) {
        Objects.requireNonNull(executor2, "Executor must not be null");
        this.executor = executor2;
    }

    public void setEagerLoadingEnabled(boolean z) {
        this.eagerLoadingEnabled = z;
    }

    public final void setDebug(boolean z) {
        this.debug = z;
    }

    public boolean hasImage() {
        return (this.uri == null && this.bitmap == null) ? false : true;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener2) {
        this.onLongClickListener = onLongClickListener2;
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener2) {
        this.onImageEventListener = onImageEventListener2;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener2) {
        this.onStateChangedListener = onStateChangedListener2;
    }

    private void sendStateChanged(float f, PointF pointF, int i) {
        OnStateChangedListener onStateChangedListener2 = this.onStateChangedListener;
        if (onStateChangedListener2 != null) {
            float f2 = this.scale;
            if (f2 != f) {
                onStateChangedListener2.onScaleChanged(f2, i);
            }
        }
        if (this.onStateChangedListener != null && !this.vTranslate.equals(pointF)) {
            this.onStateChangedListener.onCenterChanged(getCenter(), i);
        }
    }

    public AnimationBuilder animateCenter(PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(pointF);
    }

    public AnimationBuilder animateScale(float f) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f);
    }

    public AnimationBuilder animateScaleAndCenter(float f, PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f, pointF);
    }

    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        private final PointF vFocus;

        private AnimationBuilder(PointF pointF) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = SubsamplingScaleImageView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = SubsamplingScaleImageView.this.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(float f, PointF pointF) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f, PointF pointF, PointF pointF2) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }

        public AnimationBuilder withDuration(long j) {
            this.duration = j;
            return this;
        }

        public AnimationBuilder withInterruptible(boolean z) {
            this.interruptible = z;
            return this;
        }

        public AnimationBuilder withEasing(int i) {
            if (SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(i))) {
                this.easing = i;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i);
        }

        public AnimationBuilder withOnAnimationEventListener(OnAnimationEventListener onAnimationEventListener) {
            this.listener = onAnimationEventListener;
            return this;
        }

        /* access modifiers changed from: private */
        public AnimationBuilder withPanLimited(boolean z) {
            this.panLimited = z;
            return this;
        }

        /* access modifiers changed from: private */
        public AnimationBuilder withOrigin(int i) {
            this.origin = i;
            return this;
        }

        public void start() {
            if (!(SubsamplingScaleImageView.this.anim == null || SubsamplingScaleImageView.this.anim.listener == null)) {
                try {
                    SubsamplingScaleImageView.this.anim.listener.onInterruptedByNewAnim();
                } catch (Exception e) {
                    Log.w(SubsamplingScaleImageView.TAG, "Error thrown by animation listener", e);
                }
            }
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft() + (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop() + (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float access$6500 = SubsamplingScaleImageView.this.limitedScale(this.targetScale);
            PointF access$6600 = this.panLimited ? SubsamplingScaleImageView.this.limitedSCenter(this.targetSCenter.x, this.targetSCenter.y, access$6500, new PointF()) : this.targetSCenter;
            Anim unused = SubsamplingScaleImageView.this.anim = new Anim();
            float unused2 = SubsamplingScaleImageView.this.anim.scaleStart = SubsamplingScaleImageView.this.scale;
            float unused3 = SubsamplingScaleImageView.this.anim.scaleEnd = access$6500;
            long unused4 = SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            PointF unused5 = SubsamplingScaleImageView.this.anim.sCenterEndRequested = access$6600;
            PointF unused6 = SubsamplingScaleImageView.this.anim.sCenterStart = SubsamplingScaleImageView.this.getCenter();
            PointF unused7 = SubsamplingScaleImageView.this.anim.sCenterEnd = access$6600;
            PointF unused8 = SubsamplingScaleImageView.this.anim.vFocusStart = SubsamplingScaleImageView.this.sourceToViewCoord(access$6600);
            PointF unused9 = SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF((float) paddingLeft, (float) paddingTop);
            long unused10 = SubsamplingScaleImageView.this.anim.duration = this.duration;
            boolean unused11 = SubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
            int unused12 = SubsamplingScaleImageView.this.anim.easing = this.easing;
            int unused13 = SubsamplingScaleImageView.this.anim.origin = this.origin;
            long unused14 = SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            OnAnimationEventListener unused15 = SubsamplingScaleImageView.this.anim.listener = this.listener;
            PointF pointF = this.vFocus;
            if (pointF != null) {
                float f = pointF.x - (SubsamplingScaleImageView.this.anim.sCenterStart.x * access$6500);
                float f2 = this.vFocus.y - (SubsamplingScaleImageView.this.anim.sCenterStart.y * access$6500);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(access$6500, new PointF(f, f2));
                SubsamplingScaleImageView.this.fitToBounds(true, scaleAndTranslate);
                PointF unused16 = SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f2));
            }
            SubsamplingScaleImageView.this.invalidate();
        }
    }
}
