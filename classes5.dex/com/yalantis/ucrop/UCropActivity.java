package com.yalantis.ucrop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.immersive.ImmersiveManage;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.ScreenUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.CropImageView;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class UCropActivity extends AppCompatActivity {
    public static final int ALL = 3;
    private static final long CONTROLS_ANIMATION_DURATION = 50;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
    public static final int SCALE = 1;
    private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
    private static final int TABS_COUNT = 3;
    private static final String TAG = "UCropActivity";
    private boolean isDragFrame;
    private boolean isOpenWhiteStatusBar;
    private boolean isRotateEnabled;
    private boolean isScaleEnabled;
    private int mActiveControlsWidgetColor;
    private int mActiveWidgetColor;
    private int[] mAllowedGestures = {1, 2, 3};
    private List<AspectRatioTextView> mAspectRatioTextViews = new ArrayList();
    protected View mBlockingView;
    private Bitmap.CompressFormat mCompressFormat = DEFAULT_COMPRESS_FORMAT;
    private int mCompressQuality = 90;
    private Transition mControlsTransition;
    /* access modifiers changed from: private */
    public List<ViewGroup> mCropAspectRatioViews = new ArrayList();
    /* access modifiers changed from: private */
    public GestureCropImageView mGestureCropImageView;
    private TransformImageView.TransformImageListener mImageListener = new TransformImageView.TransformImageListener() {
        public void onRotate(float f) {
            UCropActivity.this.setAngleText(f);
        }

        public void onScale(float f) {
            UCropActivity.this.setScaleText(f);
        }

        public void onLoadComplete() {
            UCropActivity.this.mUCropView.animate().alpha(1.0f).setDuration(300).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.mBlockingView.setClickable(!UCropActivity.this.isOnTouch());
            boolean unused = UCropActivity.this.mShowLoader = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        public void onLoadFailure(Exception exc) {
            UCropActivity.this.setResultError(exc);
            UCropActivity.this.onBackPressed();
        }
    };
    private ViewGroup mLayoutAspectRatio;
    private ViewGroup mLayoutRotate;
    private ViewGroup mLayoutScale;
    private int mLogoColor;
    private OverlayView mOverlayView;
    private int mRootViewBackgroundColor;
    protected int mScreenWidth;
    protected boolean mShowBottomControls;
    /* access modifiers changed from: private */
    public boolean mShowLoader = true;
    private final View.OnClickListener mStateClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            MethodInfo.onClickEventEnter(view, UCropActivity.class);
            if (!view.isSelected()) {
                UCropActivity.this.setWidgetState(view.getId());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
        }
    };
    private int mStatusBarColor;
    private TextView mTextViewRotateAngle;
    private TextView mTextViewScalePercent;
    private int mToolbarCancelDrawable;
    private int mToolbarColor;
    private int mToolbarCropDrawable;
    private String mToolbarTitle;
    private int mToolbarWidgetColor;
    /* access modifiers changed from: private */
    public UCropView mUCropView;
    private ViewGroup mWrapperStateAspectRatio;
    private ViewGroup mWrapperStateRotate;
    private ViewGroup mWrapperStateScale;
    protected RelativeLayout uCropPhotoBox;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureTypes {
    }

    public void finish() {
        UCropActivity.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.yalantis.ucrop.UCropActivity, android.app.Activity] */
    /* access modifiers changed from: protected */
    public Activity getCurrentActivity() {
        return this;
    }

    public boolean isImmersive() {
        return true;
    }

    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        UCropActivity.super.onPause();
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        UCropActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        UCropActivity.super.onResume();
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        UCropActivity.super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void immersive() {
        ImmersiveManage.immersiveAboveAPI23(this, this.mStatusBarColor, this.mToolbarColor, this.isOpenWhiteStatusBar);
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.content.Context, java.lang.Object, com.yalantis.ucrop.UCropActivity, androidx.appcompat.app.AppCompatActivity] */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        UCropActivity.super.onCreate(bundle);
        Intent intent = getIntent();
        setNewRequestedOrientation(intent);
        getCustomOptionsData(intent);
        if (isImmersive()) {
            immersive();
        }
        setContentView(R.layout.ucrop_activity_photobox);
        this.mScreenWidth = ScreenUtils.getScreenWidth(this);
        setupViews(intent);
        setNavBar();
        setImageData(intent);
        setInitialState();
        addBlockingView();
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void setNewRequestedOrientation(Intent intent) {
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ACTIVITY_ORIENTATION, -1);
        if (getRequestedOrientation() != intExtra) {
            setRequestedOrientation(intExtra);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, com.yalantis.ucrop.UCropActivity] */
    private void getCustomOptionsData(Intent intent) {
        this.isOpenWhiteStatusBar = intent.getBooleanExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CROP_OPEN_WHITE_STATUSBAR, false);
        this.mStatusBarColor = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_TOOL_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar));
        this.mToolbarColor = intExtra;
        if (intExtra == 0) {
            this.mToolbarColor = ContextCompat.getColor(this, R.color.ucrop_color_toolbar);
        }
        if (this.mStatusBarColor == 0) {
            this.mStatusBarColor = ContextCompat.getColor(this, R.color.ucrop_color_statusbar);
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.Context, com.yalantis.ucrop.UCropActivity] */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem findItem = menu.findItem(R.id.menu_loader);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(this.mToolbarWidgetColor, BlendModeCompat.SRC_ATOP));
                findItem.setIcon(icon);
            } catch (IllegalStateException e) {
                Log.i(TAG, String.format("%s - %s", new Object[]{e.getMessage(), "必須指定輸入以及輸出的 Uri"}));
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(R.id.menu_crop);
        Drawable drawable = ContextCompat.getDrawable(this, this.mToolbarCropDrawable);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(this.mToolbarWidgetColor, BlendModeCompat.SRC_ATOP));
            findItem2.setIcon(drawable);
        }
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_crop).setVisible(!this.mShowLoader);
        menu.findItem(R.id.menu_loader).setVisible(this.mShowLoader);
        return UCropActivity.super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        MethodInfo.onOptionsItemSelectedEnter(menuItem, getClass().getName());
        if (menuItem.getItemId() == R.id.menu_crop) {
            cropAndSaveImage();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            MethodInfo.onOptionsItemSelectedEnd();
            return true;
        } else if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            MethodInfo.onOptionsItemSelectedEnd();
            return true;
        } else {
            boolean onOptionsItemSelected = UCropActivity.super.onOptionsItemSelected(menuItem);
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            MethodInfo.onOptionsItemSelectedEnd();
            return onOptionsItemSelected;
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        ActivityInfo.stopActivity();
        UCropActivity.super.onStop();
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        if (gestureCropImageView != null) {
            gestureCropImageView.cancelAllAnimations();
        }
    }

    /* access modifiers changed from: protected */
    public void setImageData(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra(UCrop.EXTRA_INPUT_URI);
        Uri uri2 = (Uri) intent.getParcelableExtra(UCrop.EXTRA_OUTPUT_URI);
        processOptions(intent);
        if (uri == null || uri2 == null) {
            setResultError(new NullPointerException("在你的 App 內复写颜色资源 (ucrop_color_toolbar_widget) 使 5.0 以前裝置正常运作"));
            onBackPressed();
            return;
        }
        try {
            boolean isOnTouch = isOnTouch(uri);
            this.mGestureCropImageView.setRotateEnabled(isOnTouch ? this.isRotateEnabled : isOnTouch);
            GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
            if (isOnTouch) {
                isOnTouch = this.isScaleEnabled;
            }
            gestureCropImageView.setScaleEnabled(isOnTouch);
            this.mGestureCropImageView.setImageUri(uri, uri2);
        } catch (Exception e) {
            setResultError(e);
            onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public boolean isOnTouch() {
        Uri uri = (Uri) getIntent().getParcelableExtra(UCrop.EXTRA_INPUT_URI);
        if (uri == null) {
            return true;
        }
        return isOnTouch(uri);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, com.yalantis.ucrop.UCropActivity] */
    private boolean isOnTouch(Uri uri) {
        if (uri == null) {
            return true;
        }
        if (PictureMimeType.isHasHttp(uri.toString())) {
            return !PictureMimeType.isGifForSuffix(PictureMimeType.getLastImgType(uri.toString()));
        }
        String mimeTypeFromMediaContentUri = PictureMimeType.getMimeTypeFromMediaContentUri(this, uri);
        if (mimeTypeFromMediaContentUri.endsWith("image/*")) {
            mimeTypeFromMediaContentUri = PictureMimeType.getImageMimeType(PictureFileUtils.getPath(this, uri));
        }
        return !PictureMimeType.isGif(mimeTypeFromMediaContentUri);
    }

    private void processOptions(Intent intent) {
        String stringExtra = intent.getStringExtra(UCrop.Options.EXTRA_COMPRESSION_FORMAT_NAME);
        Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(stringExtra) ? Bitmap.CompressFormat.valueOf(stringExtra) : null;
        if (valueOf == null) {
            valueOf = DEFAULT_COMPRESS_FORMAT;
        }
        this.mCompressFormat = valueOf;
        this.mCompressQuality = intent.getIntExtra(UCrop.Options.EXTRA_COMPRESSION_QUALITY, 90);
        this.mOverlayView.setDimmedBorderColor(intent.getIntExtra(UCrop.Options.EXTRA_DIMMED_LAYER_BORDER_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.isDragFrame = intent.getBooleanExtra(UCrop.Options.EXTRA_DRAG_CROP_FRAME, true);
        this.mOverlayView.setDimmedStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CIRCLE_STROKE_WIDTH_LAYER, 1));
        this.isScaleEnabled = intent.getBooleanExtra(UCrop.Options.EXTRA_SCALE, true);
        this.isRotateEnabled = intent.getBooleanExtra(UCrop.Options.EXTRA_ROTATE, true);
        int[] intArrayExtra = intent.getIntArrayExtra(UCrop.Options.EXTRA_ALLOWED_GESTURES);
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.mAllowedGestures = intArrayExtra;
        }
        this.mGestureCropImageView.setMaxBitmapSize(intent.getIntExtra(UCrop.Options.EXTRA_MAX_BITMAP_SIZE, 0));
        this.mGestureCropImageView.setMaxScaleMultiplier(intent.getFloatExtra(UCrop.Options.EXTRA_MAX_SCALE_MULTIPLIER, 10.0f));
        this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration((long) intent.getIntExtra(UCrop.Options.EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 500));
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_FREE_STYLE_CROP_MODE, -1);
        if (intExtra == -1 || intExtra > 2) {
            this.mOverlayView.setFreestyleCropEnabled(intent.getBooleanExtra(UCrop.Options.EXTRA_FREE_STYLE_CROP, false));
        } else {
            this.mOverlayView.setFreestyleCropMode(intExtra);
        }
        this.mOverlayView.setDragSmoothToCenter(intent.getBooleanExtra(UCrop.Options.EXTRA_DRAG_SMOOTH_CENTER, false));
        this.mOverlayView.setDragFrame(this.isDragFrame);
        this.mOverlayView.setDimmedColor(intent.getIntExtra(UCrop.Options.EXTRA_DIMMED_LAYER_COLOR, getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.mOverlayView.setCircleDimmedLayer(intent.getBooleanExtra(UCrop.Options.EXTRA_CIRCLE_DIMMED_LAYER, false));
        this.mOverlayView.setShowCropFrame(intent.getBooleanExtra(UCrop.Options.EXTRA_SHOW_CROP_FRAME, true));
        this.mOverlayView.setCropFrameColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_FRAME_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.mOverlayView.setCropFrameStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CROP_FRAME_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.mOverlayView.setShowCropGrid(intent.getBooleanExtra(UCrop.Options.EXTRA_SHOW_CROP_GRID, true));
        this.mOverlayView.setCropGridRowCount(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_ROW_COUNT, 2));
        this.mOverlayView.setCropGridColumnCount(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_COLUMN_COUNT, 2));
        this.mOverlayView.setCropGridColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.mOverlayView.setCropGridStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_X, CropImageView.DEFAULT_ASPECT_RATIO);
        float floatExtra2 = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_Y, CropImageView.DEFAULT_ASPECT_RATIO);
        int intExtra2 = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (floatExtra > CropImageView.DEFAULT_ASPECT_RATIO && floatExtra2 > CropImageView.DEFAULT_ASPECT_RATIO) {
            ViewGroup viewGroup = this.mWrapperStateAspectRatio;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.mGestureCropImageView.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra == null || intExtra2 >= parcelableArrayListExtra.size()) {
            this.mGestureCropImageView.setTargetAspectRatio(CropImageView.DEFAULT_ASPECT_RATIO);
        } else {
            this.mGestureCropImageView.setTargetAspectRatio(((AspectRatio) parcelableArrayListExtra.get(intExtra2)).getAspectRatioX() / ((AspectRatio) parcelableArrayListExtra.get(intExtra2)).getAspectRatioY());
        }
        int intExtra3 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_X, 0);
        int intExtra4 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_Y, 0);
        if (intExtra3 > 0 && intExtra4 > 0) {
            this.mGestureCropImageView.setMaxResultImageSizeX(intExtra3);
            this.mGestureCropImageView.setMaxResultImageSizeY(intExtra4);
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.Context, com.yalantis.ucrop.UCropActivity] */
    /* access modifiers changed from: protected */
    public void setupViews(Intent intent) {
        this.mStatusBarColor = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.mToolbarColor = intent.getIntExtra(UCrop.Options.EXTRA_TOOL_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar));
        this.mActiveWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_COLOR_WIDGET_ACTIVE, ContextCompat.getColor(this, R.color.ucrop_color_widget_background));
        this.mActiveControlsWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, ContextCompat.getColor(this, R.color.ucrop_color_active_controls_color));
        this.mToolbarWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar_widget));
        this.mToolbarCancelDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, R.drawable.ucrop_ic_cross);
        this.mToolbarCropDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CROP_DRAWABLE, R.drawable.ucrop_ic_done);
        String stringExtra = intent.getStringExtra(UCrop.Options.EXTRA_UCROP_TITLE_TEXT_TOOLBAR);
        this.mToolbarTitle = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.mToolbarTitle = stringExtra;
        this.mLogoColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_LOGO_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_default_logo));
        this.mShowBottomControls = !intent.getBooleanExtra(UCrop.Options.EXTRA_HIDE_BOTTOM_CONTROLS, false);
        this.mRootViewBackgroundColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_crop_background));
        setupAppBar();
        initiateRootViews();
        if (this.mShowBottomControls) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(R.id.ucrop_photobox)).findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            viewGroup.setBackgroundColor(this.mRootViewBackgroundColor);
            LayoutInflater from = LayoutInflater.from(this);
            int i = R.layout.ucrop_controls;
            if (!(from instanceof LayoutInflater)) {
                from.inflate(i, viewGroup, true);
            } else {
                XMLParseInstrumentation.inflate(from, i, viewGroup, true);
            }
            AutoTransition autoTransition = new AutoTransition();
            this.mControlsTransition = autoTransition;
            autoTransition.setDuration(CONTROLS_ANIMATION_DURATION);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.state_aspect_ratio);
            this.mWrapperStateAspectRatio = viewGroup2;
            viewGroup2.setOnClickListener(this.mStateClickListener);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.state_rotate);
            this.mWrapperStateRotate = viewGroup3;
            viewGroup3.setOnClickListener(this.mStateClickListener);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(R.id.state_scale);
            this.mWrapperStateScale = viewGroup4;
            viewGroup4.setOnClickListener(this.mStateClickListener);
            this.mLayoutAspectRatio = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
            this.mLayoutRotate = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
            this.mLayoutScale = (ViewGroup) findViewById(R.id.layout_scale_wheel);
            setupAspectRatioWidget(intent);
            setupRotateWidget();
            setupScaleWidget();
            setupStatesWrapper();
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, com.yalantis.ucrop.UCropActivity] */
    private void setupAppBar() {
        setStatusBarColor(this.mStatusBarColor);
        Toolbar findViewById = findViewById(R.id.toolbar);
        findViewById.setBackgroundColor(this.mToolbarColor);
        findViewById.setTitleTextColor(this.mToolbarWidgetColor);
        TextView textView = (TextView) findViewById.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.mToolbarWidgetColor);
        textView.setText(this.mToolbarTitle);
        Drawable mutate = AppCompatResources.getDrawable(this, this.mToolbarCancelDrawable).mutate();
        mutate.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(this.mToolbarWidgetColor, BlendModeCompat.SRC_ATOP));
        findViewById.setNavigationIcon(mutate);
        setSupportActionBar(findViewById);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void initiateRootViews() {
        this.uCropPhotoBox = (RelativeLayout) findViewById(R.id.ucrop_photobox);
        UCropView uCropView = (UCropView) findViewById(R.id.ucrop);
        this.mUCropView = uCropView;
        this.mGestureCropImageView = uCropView.getCropImageView();
        this.mOverlayView = this.mUCropView.getOverlayView();
        this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
        ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, PorterDuff.Mode.SRC_ATOP);
        findViewById(R.id.ucrop_frame).setBackgroundColor(this.mRootViewBackgroundColor);
    }

    private void setupStatesWrapper() {
        ImageView imageView = (ImageView) findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.mActiveControlsWidgetColor));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.mActiveControlsWidgetColor));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.mActiveControlsWidgetColor));
    }

    private void setNavBar() {
        int intExtra;
        if (Build.VERSION.SDK_INT >= 21 && (intExtra = getIntent().getIntExtra(UCrop.Options.EXTRA_NAV_BAR_COLOR, 0)) != 0) {
            getWindow().setNavigationBarColor(intExtra);
        }
    }

    private void setStatusBarColor(int i) {
        Window window;
        if (Build.VERSION.SDK_INT >= 21 && (window = getWindow()) != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
        }
    }

    private void setupAspectRatioWidget(Intent intent) {
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            intExtra = 2;
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio((String) null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
        int i = -1;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        if (getCurrentActivity() instanceof PictureMultiCuttingActivity) {
            this.mAspectRatioTextViews = new ArrayList();
            this.mCropAspectRatioViews = new ArrayList();
        }
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            AspectRatio aspectRatio = (AspectRatio) it.next();
            LayoutInflater layoutInflater = getLayoutInflater();
            int i2 = R.layout.ucrop_aspect_ratio;
            FrameLayout frameLayout = (FrameLayout) (!(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i2, (ViewGroup) null) : XMLParseInstrumentation.inflate(layoutInflater, i2, (ViewGroup) null));
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.mActiveControlsWidgetColor);
            aspectRatioTextView.setAspectRatio(aspectRatio);
            this.mAspectRatioTextViews.add(aspectRatioTextView);
            linearLayout.addView(frameLayout);
            this.mCropAspectRatioViews.add(frameLayout);
        }
        this.mCropAspectRatioViews.get(intExtra).setSelected(true);
        for (ViewGroup next : this.mCropAspectRatioViews) {
            i++;
            next.setTag(Integer.valueOf(i));
            next.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MethodInfo.onClickEventEnter(view, UCropActivity.class);
                    UCropActivity.this.mGestureCropImageView.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).getAspectRatio(view.isSelected()));
                    UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
                    if (!view.isSelected()) {
                        for (ViewGroup viewGroup : UCropActivity.this.mCropAspectRatioViews) {
                            viewGroup.setSelected(viewGroup == view);
                        }
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                }
            });
        }
    }

    private void setupRotateWidget() {
        this.mTextViewRotateAngle = (TextView) findViewById(R.id.text_view_rotate);
        ((HorizontalProgressWheelView) findViewById(R.id.rotate_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() {
            public void onScroll(float f, float f2) {
                UCropActivity.this.mGestureCropImageView.postRotate(f / 42.0f);
            }

            public void onScrollEnd() {
                UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            public void onScrollStart() {
                UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) findViewById(R.id.rotate_scroll_wheel)).setMiddleLineColor(this.mActiveWidgetColor);
        findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, UCropActivity.class);
                UCropActivity.this.resetRotation();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, UCropActivity.class);
                UCropActivity.this.rotateByAngle(90);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    private void setupScaleWidget() {
        this.mTextViewScalePercent = (TextView) findViewById(R.id.text_view_scale);
        ((HorizontalProgressWheelView) findViewById(R.id.scale_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() {
            public void onScroll(float f, float f2) {
                if (f > CropImageView.DEFAULT_ASPECT_RATIO) {
                    UCropActivity.this.mGestureCropImageView.zoomInImage(UCropActivity.this.mGestureCropImageView.getCurrentScale() + (f * ((UCropActivity.this.mGestureCropImageView.getMaxScale() - UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                } else {
                    UCropActivity.this.mGestureCropImageView.zoomOutImage(UCropActivity.this.mGestureCropImageView.getCurrentScale() + (f * ((UCropActivity.this.mGestureCropImageView.getMaxScale() - UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                }
            }

            public void onScrollEnd() {
                UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            public void onScrollStart() {
                UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) findViewById(R.id.scale_scroll_wheel)).setMiddleLineColor(this.mActiveWidgetColor);
    }

    /* access modifiers changed from: private */
    public void setAngleText(float f) {
        TextView textView = this.mTextViewRotateAngle;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", new Object[]{Float.valueOf(f)}));
        }
    }

    /* access modifiers changed from: private */
    public void setScaleText(float f) {
        TextView textView = this.mTextViewScalePercent;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf((int) (f * 100.0f))}));
        }
    }

    /* access modifiers changed from: private */
    public void resetRotation() {
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        gestureCropImageView.postRotate(-gestureCropImageView.getCurrentAngle());
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    /* access modifiers changed from: private */
    public void rotateByAngle(int i) {
        this.mGestureCropImageView.postRotate((float) i);
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    /* access modifiers changed from: protected */
    public void setInitialState() {
        if (!this.mShowBottomControls) {
            setAllowedGestures(0);
        } else if (this.mWrapperStateAspectRatio.getVisibility() == 0) {
            setWidgetState(R.id.state_aspect_ratio);
        } else {
            setWidgetState(R.id.state_scale);
        }
    }

    /* access modifiers changed from: private */
    public void setWidgetState(int i) {
        if (this.mShowBottomControls) {
            this.mWrapperStateAspectRatio.setSelected(i == R.id.state_aspect_ratio);
            this.mWrapperStateRotate.setSelected(i == R.id.state_rotate);
            this.mWrapperStateScale.setSelected(i == R.id.state_scale);
            int i2 = 8;
            this.mLayoutAspectRatio.setVisibility(i == R.id.state_aspect_ratio ? 0 : 8);
            this.mLayoutRotate.setVisibility(i == R.id.state_rotate ? 0 : 8);
            ViewGroup viewGroup = this.mLayoutScale;
            if (i == R.id.state_scale) {
                i2 = 0;
            }
            viewGroup.setVisibility(i2);
            changeSelectedTab(i);
            if (i == R.id.state_scale) {
                setAllowedGestures(0);
            } else if (i == R.id.state_rotate) {
                setAllowedGestures(1);
            } else {
                setAllowedGestures(2);
            }
        }
    }

    private void changeSelectedTab(int i) {
        TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.ucrop_photobox), this.mControlsTransition);
        int i2 = 0;
        this.mWrapperStateScale.findViewById(R.id.text_view_scale).setVisibility(i == R.id.state_scale ? 0 : 8);
        this.mWrapperStateAspectRatio.findViewById(R.id.text_view_crop).setVisibility(i == R.id.state_aspect_ratio ? 0 : 8);
        View findViewById = this.mWrapperStateRotate.findViewById(R.id.text_view_rotate);
        if (i != R.id.state_rotate) {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
    }

    private void setAllowedGestures(int i) {
        if (isOnTouch()) {
            GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
            boolean z = this.isScaleEnabled;
            boolean z2 = false;
            if (z && this.mShowBottomControls) {
                int[] iArr = this.mAllowedGestures;
                z = iArr[i] == 3 || iArr[i] == 1;
            }
            gestureCropImageView.setScaleEnabled(z);
            GestureCropImageView gestureCropImageView2 = this.mGestureCropImageView;
            boolean z3 = this.isRotateEnabled;
            if (!z3 || !this.mShowBottomControls) {
                z2 = z3;
            } else {
                int[] iArr2 = this.mAllowedGestures;
                if (iArr2[i] == 3 || iArr2[i] == 2) {
                    z2 = true;
                }
            }
            gestureCropImageView2.setRotateEnabled(z2);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, com.yalantis.ucrop.UCropActivity] */
    /* access modifiers changed from: protected */
    public void addBlockingView() {
        if (this.mBlockingView == null) {
            this.mBlockingView = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.toolbar);
            this.mBlockingView.setLayoutParams(layoutParams);
            this.mBlockingView.setClickable(true);
        }
        ((RelativeLayout) findViewById(R.id.ucrop_photobox)).addView(this.mBlockingView);
    }

    /* access modifiers changed from: protected */
    public void cropAndSaveImage() {
        this.mBlockingView.setClickable(true);
        this.mShowLoader = true;
        supportInvalidateOptionsMenu();
        this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, new BitmapCropCallback() {
            public void onBitmapCropped(Uri uri, int i, int i2, int i3, int i4) {
                UCropActivity uCropActivity = UCropActivity.this;
                uCropActivity.setResultUri(uri, uCropActivity.mGestureCropImageView.getTargetAspectRatio(), i, i2, i3, i4);
                if (!(UCropActivity.this.getCurrentActivity() instanceof PictureMultiCuttingActivity)) {
                    UCropActivity.this.onBackPressed();
                }
            }

            public void onCropFailure(Throwable th) {
                UCropActivity.this.setResultError(th);
                UCropActivity.this.onBackPressed();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void setResultUri(Uri uri, float f, int i, int i2, int i3, int i4) {
        setResult(-1, new Intent().putExtra(UCrop.EXTRA_OUTPUT_URI, uri).putExtra(UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, f).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, i3).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, i4).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_X, i).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_Y, i2).putExtra("com.yalantis.ucrop.EditorImage", getIntent().getBooleanExtra("com.yalantis.ucrop.EditorImage", false)));
    }

    /* access modifiers changed from: protected */
    public void setResultError(Throwable th) {
        setResult(96, new Intent().putExtra(UCrop.EXTRA_ERROR, th));
    }

    public void onBackPressed() {
        closeActivity();
    }

    /* access modifiers changed from: protected */
    public void closeActivity() {
        finish();
        exitAnimation();
    }

    /* access modifiers changed from: protected */
    public void exitAnimation() {
        int intExtra = getIntent().getIntExtra(UCrop.Options.EXTRA_WINDOW_EXIT_ANIMATION, 0);
        int i = R.anim.ucrop_anim_fade_in;
        if (intExtra == 0) {
            intExtra = R.anim.ucrop_close;
        }
        overridePendingTransition(i, intExtra);
    }
}
