package com.luck.picture.lib.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.tools.JumpUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.ScreenUtils;
import com.luck.picture.lib.widget.longimage.ImageSource;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PictureSimpleFragmentAdapter extends PagerAdapter {
    private static final int MAX_CACHE_SIZE = 20;
    private final PictureSelectionConfig config;
    private final List<LocalMedia> data = new ArrayList();
    private final SparseArray<View> mCacheView = new SparseArray<>();
    private final int mScreenHeight;
    private final int mScreenWidth;
    private final OnCallBackActivity onBackPressed;

    public interface OnCallBackActivity {
        void onActivityBackPressed();
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void clear() {
        this.mCacheView.clear();
    }

    public void removeCacheView(int i) {
        if (i < this.mCacheView.size()) {
            this.mCacheView.removeAt(i);
        }
    }

    public PictureSimpleFragmentAdapter(Context context, PictureSelectionConfig pictureSelectionConfig, OnCallBackActivity onCallBackActivity) {
        this.config = pictureSelectionConfig;
        this.onBackPressed = onCallBackActivity;
        this.mScreenWidth = ScreenUtils.getScreenWidth(context);
        this.mScreenHeight = ScreenUtils.getScreenHeight(context);
    }

    public void bindData(List<LocalMedia> list) {
        if (list != null) {
            this.data.clear();
            this.data.addAll(list);
        }
    }

    public List<LocalMedia> getData() {
        return this.data;
    }

    public int getSize() {
        return this.data.size();
    }

    public void remove(int i) {
        if (getSize() > i) {
            this.data.remove(i);
        }
    }

    public LocalMedia getItem(int i) {
        if (getSize() <= 0 || i >= getSize()) {
            return null;
        }
        return this.data.get(i);
    }

    public int getCount() {
        return this.data.size();
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        if (this.mCacheView.size() > 20) {
            this.mCacheView.remove(i);
        }
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [com.luck.picture.lib.photoview.PhotoView, android.widget.ImageView] */
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        View view = this.mCacheView.get(i);
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            int i2 = R.layout.picture_image_preview;
            view = !(from instanceof LayoutInflater) ? from.inflate(i2, viewGroup, false) : XMLParseInstrumentation.inflate(from, i2, viewGroup, false);
            this.mCacheView.put(i, view);
        }
        ? r2 = (PhotoView) view.findViewById(R.id.preview_image);
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) view.findViewById(R.id.longImg);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_play);
        LocalMedia item = getItem(i);
        if (this.config.isAutoScalePreviewImage) {
            float min = (float) Math.min(item.getWidth(), item.getHeight());
            float max = (float) Math.max(item.getHeight(), item.getWidth());
            if (min > 0.0f && max > 0.0f) {
                int ceil = (int) Math.ceil((double) ((max * min) / min));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) r2.getLayoutParams();
                layoutParams.width = this.mScreenWidth;
                int i3 = this.mScreenHeight;
                if (ceil < i3) {
                    ceil += i3;
                }
                layoutParams.height = ceil;
                layoutParams.gravity = 17;
            }
        }
        String mimeType = item.getMimeType();
        if (item.isCut() && !item.isCompressed()) {
            str = item.getCutPath();
        } else if (item.isCompressed() || (item.isCut() && item.isCompressed())) {
            str = item.getCompressPath();
        } else {
            str = item.getPath();
        }
        boolean isGif = PictureMimeType.isGif(mimeType);
        int i4 = 8;
        imageView.setVisibility(PictureMimeType.isHasVideo(mimeType) ? 0 : 8);
        imageView.setOnClickListener(new PictureSimpleFragmentAdapter$$ExternalSyntheticLambda1(item, str, viewGroup));
        boolean isLongImg = MediaUtils.isLongImg(item);
        r2.setVisibility((!isLongImg || isGif) ? 0 : 8);
        r2.setOnViewTapListener(new PictureSimpleFragmentAdapter$$ExternalSyntheticLambda2(this));
        if (isLongImg && !isGif) {
            i4 = 0;
        }
        subsamplingScaleImageView.setVisibility(i4);
        subsamplingScaleImageView.setOnClickListener(new PictureSimpleFragmentAdapter$$ExternalSyntheticLambda0(this));
        if (!isGif || item.isCompressed()) {
            if (PictureSelectionConfig.imageEngine != null) {
                if (isLongImg) {
                    displayLongPic(PictureMimeType.isContent(str) ? Uri.parse(str) : Uri.fromFile(new File(str)), subsamplingScaleImageView);
                } else {
                    PictureSelectionConfig.imageEngine.loadImage(view.getContext(), str, r2);
                }
            }
        } else if (PictureSelectionConfig.imageEngine != null) {
            PictureSelectionConfig.imageEngine.loadAsGifImage(view.getContext(), str, r2);
        }
        viewGroup.addView(view, 0);
        return view;
    }

    static /* synthetic */ void lambda$instantiateItem$0(LocalMedia localMedia, String str, ViewGroup viewGroup, View view) {
        if (PictureSelectionConfig.customVideoPlayCallback != null) {
            PictureSelectionConfig.customVideoPlayCallback.startPlayVideo(localMedia);
        } else {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putBoolean(PictureConfig.EXTRA_PREVIEW_VIDEO, true);
            bundle.putString(PictureConfig.EXTRA_VIDEO_PATH, str);
            intent.putExtras(bundle);
            JumpUtils.startPictureVideoPlayActivity(viewGroup.getContext(), bundle, PictureConfig.PREVIEW_VIDEO_CODE);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$instantiateItem$1$PictureSimpleFragmentAdapter(View view, float f, float f2) {
        OnCallBackActivity onCallBackActivity = this.onBackPressed;
        if (onCallBackActivity != null) {
            onCallBackActivity.onActivityBackPressed();
        }
    }

    public /* synthetic */ void lambda$instantiateItem$2$PictureSimpleFragmentAdapter(View view) {
        OnCallBackActivity onCallBackActivity = this.onBackPressed;
        if (onCallBackActivity != null) {
            onCallBackActivity.onActivityBackPressed();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void displayLongPic(Uri uri, SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.setQuickScaleEnabled(true);
        subsamplingScaleImageView.setZoomEnabled(true);
        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
        subsamplingScaleImageView.setMinimumScaleType(2);
        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
        subsamplingScaleImageView.setImage(ImageSource.uri(uri), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
    }
}
