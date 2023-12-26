package com.yalantis.ucrop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.entity.LocalMedia;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class UCrop {
    public static final String EXTRA_ASPECT_RATIO_X = "com.yalantis.ucrop.AspectRatioX";
    public static final String EXTRA_ASPECT_RATIO_Y = "com.yalantis.ucrop.AspectRatioY";
    public static final String EXTRA_EDITOR_IMAGE = "com.yalantis.ucrop.EditorImage";
    public static final String EXTRA_ERROR = "com.yalantis.ucrop.Error";
    public static final String EXTRA_INPUT_URI = "com.yalantis.ucrop.InputUri";
    public static final String EXTRA_MAX_SIZE_X = "com.yalantis.ucrop.MaxSizeX";
    public static final String EXTRA_MAX_SIZE_Y = "com.yalantis.ucrop.MaxSizeY";
    public static final String EXTRA_OUTPUT_CROP_ASPECT_RATIO = "com.yalantis.ucrop.CropAspectRatio";
    public static final String EXTRA_OUTPUT_IMAGE_HEIGHT = "com.yalantis.ucrop.ImageHeight";
    public static final String EXTRA_OUTPUT_IMAGE_WIDTH = "com.yalantis.ucrop.ImageWidth";
    public static final String EXTRA_OUTPUT_OFFSET_X = "com.yalantis.ucrop.OffsetX";
    public static final String EXTRA_OUTPUT_OFFSET_Y = "com.yalantis.ucrop.OffsetY";
    public static final String EXTRA_OUTPUT_URI = "com.yalantis.ucrop.OutputUri";
    private static final String EXTRA_PREFIX = "com.yalantis.ucrop";
    public static final int MIN_SIZE = 10;
    public static final int REQUEST_CROP = 69;
    public static final int REQUEST_MULTI_CROP = 609;
    public static final int RESULT_ERROR = 96;
    private final Intent mCropIntent = new Intent();
    private final Bundle mCropOptionsBundle;

    public static UCrop of(Uri uri, Uri uri2) {
        return new UCrop(uri, uri2);
    }

    private UCrop(Uri uri, Uri uri2) {
        Bundle bundle = new Bundle();
        this.mCropOptionsBundle = bundle;
        bundle.putParcelable(EXTRA_INPUT_URI, uri);
        bundle.putParcelable(EXTRA_OUTPUT_URI, uri2);
    }

    public UCrop withAspectRatio(float f, float f2) {
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_X, f);
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_Y, f2);
        return this;
    }

    public UCrop useSourceImageAspectRatio() {
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_X, CropImageView.DEFAULT_ASPECT_RATIO);
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_Y, CropImageView.DEFAULT_ASPECT_RATIO);
        return this;
    }

    public UCrop withMaxResultSize(int i, int i2) {
        if (i < 10) {
            i = 10;
        }
        if (i2 < 10) {
            i2 = 10;
        }
        this.mCropOptionsBundle.putInt(EXTRA_MAX_SIZE_X, i);
        this.mCropOptionsBundle.putInt(EXTRA_MAX_SIZE_Y, i2);
        return this;
    }

    public UCrop withOptions(Options options) {
        this.mCropOptionsBundle.putAll(options.getOptionBundle());
        return this;
    }

    public void startAnimationActivity(Activity activity, int i) {
        if (i != 0) {
            start(activity, 69, i);
        } else {
            start(activity, 69);
        }
    }

    public void start(Activity activity, int i, int i2) {
        activity.startActivityForResult(getIntent(activity), i);
        activity.overridePendingTransition(i2, R.anim.ucrop_anim_fade_in);
    }

    public void start(Activity activity, int i) {
        activity.startActivityForResult(getIntent(activity), i);
    }

    public void start(AppCompatActivity appCompatActivity) {
        start(appCompatActivity, 69);
    }

    public void start(AppCompatActivity appCompatActivity, int i) {
        appCompatActivity.startActivityForResult(getIntent(appCompatActivity), i);
    }

    public void start(Context context, Fragment fragment) {
        start(context, fragment, 69);
    }

    public void start(Context context, Fragment fragment, int i) {
        fragment.startActivityForResult(getIntent(context), i);
    }

    public void startAnimationMultipleCropActivity(Activity activity, int i) {
        if (i != 0) {
            startMultiple(activity, REQUEST_MULTI_CROP, i);
        } else {
            startMultiple(activity, REQUEST_MULTI_CROP);
        }
    }

    public void startMultiple(Activity activity, int i, int i2) {
        activity.startActivityForResult(getMultipleIntent(activity), i);
        activity.overridePendingTransition(i2, R.anim.ucrop_anim_fade_in);
    }

    public void startMultiple(Activity activity) {
        start(activity, (int) REQUEST_MULTI_CROP);
    }

    public void startMultiple(Activity activity, int i) {
        activity.startActivityForResult(getMultipleIntent(activity), i);
    }

    public Intent getMultipleIntent(Context context) {
        this.mCropIntent.setClass(context, PictureMultiCuttingActivity.class);
        this.mCropIntent.putExtras(this.mCropOptionsBundle);
        return this.mCropIntent;
    }

    public Intent getIntent(Context context) {
        this.mCropIntent.setClass(context, UCropActivity.class);
        this.mCropIntent.putExtras(this.mCropOptionsBundle);
        return this.mCropIntent;
    }

    public static Uri getOutput(Intent intent) {
        return (Uri) intent.getParcelableExtra(EXTRA_OUTPUT_URI);
    }

    public static int getOutputImageWidth(Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_IMAGE_WIDTH, -1);
    }

    public static int getOutputImageHeight(Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_IMAGE_HEIGHT, -1);
    }

    public static float getOutputCropAspectRatio(Intent intent) {
        return intent.getFloatExtra(EXTRA_OUTPUT_CROP_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public static Throwable getError(Intent intent) {
        return (Throwable) intent.getSerializableExtra(EXTRA_ERROR);
    }

    public static ArrayList<LocalMedia> getMultipleOutput(Intent intent) {
        return intent.getParcelableArrayListExtra(Options.EXTRA_OUTPUT_URI_LIST);
    }

    public static class Options {
        public static final String EXTRA_ACTIVITY_ORIENTATION = "com.yalantis.ucrop.activityOrientation";
        public static final String EXTRA_ALLOWED_GESTURES = "com.yalantis.ucrop.AllowedGestures";
        public static final String EXTRA_ASPECT_RATIO_OPTIONS = "com.yalantis.ucrop.AspectRatioOptions";
        public static final String EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT = "com.yalantis.ucrop.AspectRatioSelectedByDefault";
        public static final String EXTRA_CAMERA = "com.yalantis.ucrop.isCamera";
        public static final String EXTRA_CIRCLE_DIMMED_LAYER = "com.yalantis.ucrop.CircleDimmedLayer";
        public static final String EXTRA_CIRCLE_STROKE_WIDTH_LAYER = "com.yalantis.ucrop.CircleStrokeWidth";
        public static final String EXTRA_COMPRESSION_FORMAT_NAME = "com.yalantis.ucrop.CompressionFormatName";
        public static final String EXTRA_COMPRESSION_QUALITY = "com.yalantis.ucrop.CompressionQuality";
        public static final String EXTRA_CROP_FRAME_COLOR = "com.yalantis.ucrop.CropFrameColor";
        public static final String EXTRA_CROP_FRAME_STROKE_WIDTH = "com.yalantis.ucrop.CropFrameStrokeWidth";
        public static final String EXTRA_CROP_GRID_COLOR = "com.yalantis.ucrop.CropGridColor";
        public static final String EXTRA_CROP_GRID_COLUMN_COUNT = "com.yalantis.ucrop.CropGridColumnCount";
        public static final String EXTRA_CROP_GRID_ROW_COUNT = "com.yalantis.ucrop.CropGridRowCount";
        public static final String EXTRA_CROP_GRID_STROKE_WIDTH = "com.yalantis.ucrop.CropGridStrokeWidth";
        public static final String EXTRA_CUT_CROP = "com.yalantis.ucrop.cuts";
        public static final String EXTRA_DIMMED_LAYER_BORDER_COLOR = "com.yalantis.ucrop.DimmedLayerBorderColor";
        public static final String EXTRA_DIMMED_LAYER_COLOR = "com.yalantis.ucrop.DimmedLayerColor";
        public static final String EXTRA_DRAG_CROP_FRAME = "com.yalantis.ucrop.DragCropFrame";
        public static final String EXTRA_DRAG_SMOOTH_CENTER = "com.yalantis.ucrop.DragSmoothToCenter";
        public static final String EXTRA_EDITOR_IMAGE = "com.yalantis.ucrop.EditorImage";
        public static final String EXTRA_FREE_STYLE_CROP = "com.yalantis.ucrop.FreeStyleCrop";
        public static final String EXTRA_FREE_STYLE_CROP_MODE = "com.yalantis.ucrop.FreeStyleCropMode";
        public static final String EXTRA_HIDE_BOTTOM_CONTROLS = "com.yalantis.ucrop.HideBottomControls";
        public static final String EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = "com.yalantis.ucrop.ImageToCropBoundsAnimDuration";
        public static final String EXTRA_MAX_BITMAP_SIZE = "com.yalantis.ucrop.MaxBitmapSize";
        public static final String EXTRA_MAX_SCALE_MULTIPLIER = "com.yalantis.ucrop.MaxScaleMultiplier";
        public static final String EXTRA_MULTIPLE_RECYCLERANIMATION = ".isMultipleAnimation";
        public static final String EXTRA_NAV_BAR_COLOR = "com.yalantis.ucrop.navBarColor";
        public static final String EXTRA_OUTPUT_URI_LIST = "com.yalantis.ucrop.OutputUriList";
        public static final String EXTRA_RENAME_CROP_FILENAME = "com.yalantis.ucrop.RenameCropFileName";
        public static final String EXTRA_ROTATE = "com.yalantis.ucrop.rotate";
        public static final String EXTRA_SCALE = "com.yalantis.ucrop.scale";
        public static final String EXTRA_SHOW_CROP_FRAME = "com.yalantis.ucrop.ShowCropFrame";
        public static final String EXTRA_SHOW_CROP_GRID = "com.yalantis.ucrop.ShowCropGrid";
        public static final String EXTRA_SKIP_MULTIPLE_CROP = "com.yalantis.ucrop.skip_multiple_crop";
        public static final String EXTRA_STATUS_BAR_COLOR = "com.yalantis.ucrop.StatusBarColor";
        public static final String EXTRA_TOOL_BAR_COLOR = "com.yalantis.ucrop.ToolbarColor";
        public static final String EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE = "com.yalantis.ucrop.UcropColorControlsWidgetActive";
        public static final String EXTRA_UCROP_COLOR_WIDGET_ACTIVE = "com.yalantis.ucrop.UcropColorWidgetActive";
        public static final String EXTRA_UCROP_LOGO_COLOR = "com.yalantis.ucrop.UcropLogoColor";
        public static final String EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR = "com.yalantis.ucrop.UcropRootViewBackgroundColor";
        public static final String EXTRA_UCROP_TITLE_TEXT_TOOLBAR = "com.yalantis.ucrop.UcropToolbarTitleText";
        public static final String EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE = "com.yalantis.ucrop.UcropToolbarCancelDrawable";
        public static final String EXTRA_UCROP_WIDGET_COLOR_TOOLBAR = "com.yalantis.ucrop.UcropToolbarWidgetColor";
        public static final String EXTRA_UCROP_WIDGET_CROP_DRAWABLE = "com.yalantis.ucrop.UcropToolbarCropDrawable";
        public static final String EXTRA_UCROP_WIDGET_CROP_OPEN_WHITE_STATUSBAR = "com.yalantis.ucrop.openWhiteStatusBar";
        public static final String EXTRA_WINDOW_EXIT_ANIMATION = "com.yalantis.ucrop.WindowAnimation";
        public static final String EXTRA_WITH_VIDEO_IMAGE = "com.yalantis.ucrop.isWithVideoImage";
        private final Bundle mOptionBundle = new Bundle();

        public Bundle getOptionBundle() {
            return this.mOptionBundle;
        }

        public void setCompressionFormat(Bitmap.CompressFormat compressFormat) {
            this.mOptionBundle.putString(EXTRA_COMPRESSION_FORMAT_NAME, compressFormat.name());
        }

        public void setCompressionQuality(int i) {
            this.mOptionBundle.putInt(EXTRA_COMPRESSION_QUALITY, i);
        }

        public void setRequestedOrientation(int i) {
            this.mOptionBundle.putInt(EXTRA_ACTIVITY_ORIENTATION, i);
        }

        public void setRenameCropFileName(String str) {
            this.mOptionBundle.putString(EXTRA_RENAME_CROP_FILENAME, str);
        }

        public void isCamera(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_CAMERA, z);
        }

        public void isMultipleRecyclerAnimation(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_MULTIPLE_RECYCLERANIMATION, z);
        }

        public void setCutListData(ArrayList<LocalMedia> arrayList) {
            this.mOptionBundle.putParcelableArrayList(EXTRA_CUT_CROP, arrayList);
        }

        public void isWithVideoImage(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_WITH_VIDEO_IMAGE, z);
        }

        public void setAllowedGestures(int i, int i2, int i3) {
            this.mOptionBundle.putIntArray(EXTRA_ALLOWED_GESTURES, new int[]{i, i2, i3});
        }

        public void setMaxScaleMultiplier(float f) {
            this.mOptionBundle.putFloat(EXTRA_MAX_SCALE_MULTIPLIER, f);
        }

        public void setImageToCropBoundsAnimDuration(int i) {
            this.mOptionBundle.putInt(EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, i);
        }

        public void setMaxBitmapSize(int i) {
            this.mOptionBundle.putInt(EXTRA_MAX_BITMAP_SIZE, i);
        }

        public void setDimmedLayerColor(int i) {
            this.mOptionBundle.putInt(EXTRA_DIMMED_LAYER_COLOR, i);
        }

        public void setDimmedLayerBorderColor(int i) {
            if (i != 0) {
                this.mOptionBundle.putInt(EXTRA_DIMMED_LAYER_BORDER_COLOR, i);
            }
        }

        public void setCircleStrokeWidth(int i) {
            if (i > 0) {
                this.mOptionBundle.putInt(EXTRA_CIRCLE_STROKE_WIDTH_LAYER, i);
            }
        }

        public void setCircleDimmedLayer(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_CIRCLE_DIMMED_LAYER, z);
        }

        public void setShowCropFrame(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_SHOW_CROP_FRAME, z);
        }

        public void setCropFrameColor(int i) {
            this.mOptionBundle.putInt(EXTRA_CROP_FRAME_COLOR, i);
        }

        public void setCropFrameStrokeWidth(int i) {
            this.mOptionBundle.putInt(EXTRA_CROP_FRAME_STROKE_WIDTH, i);
        }

        public void setShowCropGrid(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_SHOW_CROP_GRID, z);
        }

        public void setDragFrameEnabled(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_DRAG_CROP_FRAME, z);
        }

        public void setCropGridRowCount(int i) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_ROW_COUNT, i);
        }

        public void setScaleEnabled(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_SCALE, z);
        }

        public void setRotateEnabled(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_ROTATE, z);
        }

        public void setCropGridColumnCount(int i) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_COLUMN_COUNT, i);
        }

        public void setCropGridColor(int i) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_COLOR, i);
        }

        public void setCropGridStrokeWidth(int i) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_STROKE_WIDTH, i);
        }

        public void setToolbarColor(int i) {
            this.mOptionBundle.putInt(EXTRA_TOOL_BAR_COLOR, i);
        }

        public void isOpenWhiteStatusBar(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_UCROP_WIDGET_CROP_OPEN_WHITE_STATUSBAR, z);
        }

        public void setStatusBarColor(int i) {
            this.mOptionBundle.putInt(EXTRA_STATUS_BAR_COLOR, i);
        }

        public void setActiveWidgetColor(int i) {
            this.mOptionBundle.putInt(EXTRA_UCROP_COLOR_WIDGET_ACTIVE, i);
        }

        public void setActiveControlsWidgetColor(int i) {
            this.mOptionBundle.putInt(EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, i);
        }

        public void setToolbarWidgetColor(int i) {
            this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, i);
        }

        public void setToolbarTitle(String str) {
            this.mOptionBundle.putString(EXTRA_UCROP_TITLE_TEXT_TOOLBAR, str);
        }

        public void setToolbarCancelDrawable(int i) {
            this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, i);
        }

        public void setToolbarCropDrawable(int i) {
            this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_CROP_DRAWABLE, i);
        }

        public void setLogoColor(int i) {
            this.mOptionBundle.putInt(EXTRA_UCROP_LOGO_COLOR, i);
        }

        public void isMultipleSkipCrop(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_SKIP_MULTIPLE_CROP, z);
        }

        public void setHideBottomControls(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_HIDE_BOTTOM_CONTROLS, z);
        }

        public void setEditorImage(boolean z) {
            this.mOptionBundle.putBoolean("com.yalantis.ucrop.EditorImage", z);
        }

        public void setFreeStyleCropEnabled(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_FREE_STYLE_CROP, z);
        }

        public void setFreestyleCropMode(int i) {
            this.mOptionBundle.putInt(EXTRA_FREE_STYLE_CROP_MODE, i);
        }

        public void setCropDragSmoothToCenter(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_DRAG_SMOOTH_CENTER, z);
        }

        public void setCropExitAnimation(int i) {
            this.mOptionBundle.putInt(EXTRA_WINDOW_EXIT_ANIMATION, i);
        }

        public void setNavBarColor(int i) {
            if (i != 0) {
                this.mOptionBundle.putInt(EXTRA_NAV_BAR_COLOR, i);
            }
        }

        public void setAspectRatioOptions(int i, AspectRatio... aspectRatioArr) {
            if (i <= aspectRatioArr.length) {
                this.mOptionBundle.putInt(EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, i);
                this.mOptionBundle.putParcelableArrayList(EXTRA_ASPECT_RATIO_OPTIONS, new ArrayList(Arrays.asList(aspectRatioArr)));
                return;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Index [selectedByDefault = %d] cannot be higher than aspect ratio options count [count = %d].", new Object[]{Integer.valueOf(i), Integer.valueOf(aspectRatioArr.length)}));
        }

        public void setRootViewBackgroundColor(int i) {
            this.mOptionBundle.putInt(EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, i);
        }

        public void withAspectRatio(float f, float f2) {
            this.mOptionBundle.putFloat(UCrop.EXTRA_ASPECT_RATIO_X, f);
            this.mOptionBundle.putFloat(UCrop.EXTRA_ASPECT_RATIO_Y, f2);
        }

        public void useSourceImageAspectRatio() {
            this.mOptionBundle.putFloat(UCrop.EXTRA_ASPECT_RATIO_X, CropImageView.DEFAULT_ASPECT_RATIO);
            this.mOptionBundle.putFloat(UCrop.EXTRA_ASPECT_RATIO_Y, CropImageView.DEFAULT_ASPECT_RATIO);
        }

        public void withMaxResultSize(int i, int i2) {
            this.mOptionBundle.putInt(UCrop.EXTRA_MAX_SIZE_X, i);
            this.mOptionBundle.putInt(UCrop.EXTRA_MAX_SIZE_Y, i2);
        }
    }
}
