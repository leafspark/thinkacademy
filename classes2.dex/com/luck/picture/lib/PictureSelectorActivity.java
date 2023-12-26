package com.luck.picture.lib;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.google.firebase.messaging.ServiceStarter;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.animators.AlphaInAnimationAdapter;
import com.luck.picture.lib.animators.SlideInBottomAnimationAdapter;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.luck.picture.lib.dialog.PhotoItemSelectedDialog;
import com.luck.picture.lib.dialog.PictureCustomDialog;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.listener.OnAlbumItemClickListener;
import com.luck.picture.lib.listener.OnItemClickListener;
import com.luck.picture.lib.listener.OnPermissionDialogOptionCallback;
import com.luck.picture.lib.listener.OnPhotoSelectChangedListener;
import com.luck.picture.lib.listener.OnRecyclerViewPreloadMoreListener;
import com.luck.picture.lib.manager.UCropManager;
import com.luck.picture.lib.model.LocalMediaLoader;
import com.luck.picture.lib.model.LocalMediaPageLoader;
import com.luck.picture.lib.observable.ImagesObservable;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.DoubleUtils;
import com.luck.picture.lib.tools.JumpUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.ScreenUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.luck.picture.lib.widget.FolderPopWindow;
import com.luck.picture.lib.widget.RecyclerPreloadView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PictureSelectorActivity extends PictureBaseActivity implements View.OnClickListener, OnAlbumItemClickListener, OnPhotoSelectChangedListener<LocalMedia>, OnItemClickListener, OnRecyclerViewPreloadMoreListener {
    private static final String TAG = "PictureSelectorActivity";
    private int allFolderSize;
    protected Animation animation = null;
    protected PictureCustomDialog audioDialog;
    protected FolderPopWindow folderWindow;
    private long intervalClickTime = 0;
    protected boolean isEnterSetting;
    protected boolean isPlayAudio = false;
    protected boolean isStartAnimation = false;
    protected PictureImageGridAdapter mAdapter;
    protected RelativeLayout mBottomLayout;
    protected CheckBox mCbOriginal;
    protected ImageView mIvArrow;
    protected ImageView mIvPictureLeftBack;
    private int mOpenCameraCount;
    protected RecyclerPreloadView mRecyclerView;
    public Runnable mRunnable = new Runnable() {
        public void run() {
            try {
                if (PictureSelectorActivity.this.mediaPlayer != null) {
                    PictureSelectorActivity.this.mTvMusicTime.setText(DateUtils.formatDurationTime((long) PictureSelectorActivity.this.mediaPlayer.getCurrentPosition()));
                    PictureSelectorActivity.this.musicSeekBar.setProgress(PictureSelectorActivity.this.mediaPlayer.getCurrentPosition());
                    PictureSelectorActivity.this.musicSeekBar.setMax(PictureSelectorActivity.this.mediaPlayer.getDuration());
                    PictureSelectorActivity.this.mTvMusicTotal.setText(DateUtils.formatDurationTime((long) PictureSelectorActivity.this.mediaPlayer.getDuration()));
                    PictureSelectorActivity.this.mHandler.postDelayed(PictureSelectorActivity.this.mRunnable, 200);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    protected View mTitleBar;
    protected TextView mTvEmpty;
    protected TextView mTvMusicStatus;
    protected TextView mTvMusicTime;
    protected TextView mTvMusicTotal;
    protected TextView mTvPictureImgNum;
    protected TextView mTvPictureOk;
    protected TextView mTvPicturePreview;
    protected TextView mTvPictureRight;
    protected TextView mTvPictureTitle;
    protected TextView mTvPlayPause;
    protected TextView mTvQuit;
    protected TextView mTvStop;
    protected MediaPlayer mediaPlayer;
    protected SeekBar musicSeekBar;
    protected int oldCurrentListSize;
    protected View viewClickMask;

    /* access modifiers changed from: protected */
    public void onChangeData(List<LocalMedia> list) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.allFolderSize = bundle.getInt(PictureConfig.EXTRA_ALL_FOLDER_SIZE);
            this.oldCurrentListSize = bundle.getInt(PictureConfig.EXTRA_OLD_CURRENT_LIST_SIZE, 0);
            List<LocalMedia> obtainSelectorList = PictureSelector.obtainSelectorList(bundle);
            if (obtainSelectorList == null) {
                obtainSelectorList = this.selectionMedias;
            }
            this.selectionMedias = obtainSelectorList;
            PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
            if (pictureImageGridAdapter != null) {
                this.isStartAnimation = true;
                pictureImageGridAdapter.bindSelectData(this.selectionMedias);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorActivity, com.luck.picture.lib.PictureBaseActivity] */
    /* access modifiers changed from: protected */
    public void onResume() {
        CheckBox checkBox;
        super.onResume();
        if (this.isEnterSetting) {
            if (!PermissionChecker.isCheckWriteStorage(this)) {
                showPermissionsDialog(false, PermissionConfig.getWritePermissionArray(this), getString(R.string.picture_jurisdiction));
            } else if (this.mAdapter.isDataEmpty()) {
                readLocalMedia();
            }
            this.isEnterSetting = false;
        }
        if (this.config.isOriginalControl && (checkBox = this.mCbOriginal) != null) {
            checkBox.setChecked(this.config.isCheckOriginalImage);
        }
    }

    public int getResourceId() {
        return R.layout.picture_selector;
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [android.content.Context, com.luck.picture.lib.listener.OnPhotoSelectChangedListener, android.view.View$OnClickListener, com.luck.picture.lib.listener.OnRecyclerViewPreloadMoreListener, com.luck.picture.lib.PictureSelectorActivity, com.luck.picture.lib.listener.OnAlbumItemClickListener, com.luck.picture.lib.PictureBaseActivity] */
    /* access modifiers changed from: protected */
    public void initWidgets() {
        int i;
        String str;
        super.initWidgets();
        this.container = findViewById(R.id.container);
        this.mTitleBar = findViewById(R.id.titleBar);
        this.mIvPictureLeftBack = (ImageView) findViewById(R.id.pictureLeftBack);
        this.mTvPictureTitle = (TextView) findViewById(R.id.picture_title);
        this.mTvPictureRight = (TextView) findViewById(R.id.picture_right);
        this.mTvPictureOk = (TextView) findViewById(R.id.picture_tv_ok);
        this.mCbOriginal = (CheckBox) findViewById(R.id.cb_original);
        this.mIvArrow = (ImageView) findViewById(R.id.ivArrow);
        this.viewClickMask = findViewById(R.id.viewClickMask);
        this.mTvPicturePreview = (TextView) findViewById(R.id.picture_id_preview);
        this.mTvPictureImgNum = (TextView) findViewById(R.id.tv_media_num);
        this.mRecyclerView = (RecyclerPreloadView) findViewById(R.id.picture_recycler);
        this.mBottomLayout = (RelativeLayout) findViewById(R.id.select_bar_layout);
        this.mTvEmpty = (TextView) findViewById(R.id.tv_empty);
        isNumComplete(this.numComplete);
        if (!this.numComplete) {
            this.animation = AnimationUtils.loadAnimation(this, R.anim.picture_anim_modal_in);
        }
        this.mTvPicturePreview.setOnClickListener(this);
        if (this.config.isAutomaticTitleRecyclerTop) {
            this.mTitleBar.setOnClickListener(this);
        }
        int i2 = 8;
        this.mTvPicturePreview.setVisibility((this.config.chooseMode == PictureMimeType.ofAudio() || !this.config.enablePreview) ? 8 : 0);
        RelativeLayout relativeLayout = this.mBottomLayout;
        if (this.config.selectionMode != 1 || !this.config.isSingleDirectReturn) {
            i2 = 0;
        }
        relativeLayout.setVisibility(i2);
        this.mIvPictureLeftBack.setOnClickListener(this);
        this.mTvPictureRight.setOnClickListener(this);
        this.mTvPictureOk.setOnClickListener(this);
        this.viewClickMask.setOnClickListener(this);
        this.mTvPictureImgNum.setOnClickListener(this);
        this.mTvPictureTitle.setOnClickListener(this);
        this.mIvArrow.setOnClickListener(this);
        if (this.config.chooseMode == PictureMimeType.ofAudio()) {
            i = R.string.picture_all_audio;
        } else {
            i = R.string.picture_camera_roll;
        }
        this.mTvPictureTitle.setText(getString(i));
        this.mTvPictureTitle.setTag(R.id.view_tag, -1);
        FolderPopWindow folderPopWindow = new FolderPopWindow(this);
        this.folderWindow = folderPopWindow;
        folderPopWindow.setArrowImageView(this.mIvArrow);
        this.folderWindow.setOnAlbumItemClickListener(this);
        int i3 = 4;
        this.mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(this.config.imageSpanCount <= 0 ? 4 : this.config.imageSpanCount, ScreenUtils.dip2px(this, 2.0f), false));
        RecyclerPreloadView recyclerPreloadView = this.mRecyclerView;
        Context context = getContext();
        if (this.config.imageSpanCount > 0) {
            i3 = this.config.imageSpanCount;
        }
        recyclerPreloadView.setLayoutManager(new GridLayoutManager(context, i3));
        if (!this.config.isPageStrategy) {
            this.mRecyclerView.setHasFixedSize(true);
        } else {
            this.mRecyclerView.setReachBottomRow(2);
            this.mRecyclerView.setOnRecyclerViewPreloadListener(this);
        }
        SimpleItemAnimator itemAnimator = this.mRecyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setSupportsChangeAnimations(false);
            this.mRecyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        }
        loadAllMediaData();
        TextView textView = this.mTvEmpty;
        if (this.config.chooseMode == PictureMimeType.ofAudio()) {
            str = getString(R.string.picture_audio_empty);
        } else {
            str = getString(R.string.picture_empty);
        }
        textView.setText(str);
        StringUtils.tempTextFont(this.mTvEmpty, this.config.chooseMode);
        PictureImageGridAdapter pictureImageGridAdapter = new PictureImageGridAdapter(getContext(), this.config);
        this.mAdapter = pictureImageGridAdapter;
        pictureImageGridAdapter.setOnPhotoSelectChangedListener(this);
        int i4 = this.config.animationMode;
        if (i4 == 1) {
            this.mRecyclerView.setAdapter(new AlphaInAnimationAdapter(this.mAdapter));
        } else if (i4 != 2) {
            this.mRecyclerView.setAdapter(this.mAdapter);
        } else {
            this.mRecyclerView.setAdapter(new SlideInBottomAnimationAdapter(this.mAdapter));
        }
        if (this.config.isOriginalControl) {
            this.mCbOriginal.setVisibility(0);
            this.mCbOriginal.setChecked(this.config.isCheckOriginalImage);
            this.mCbOriginal.setOnCheckedChangeListener(new PictureSelectorActivity$$ExternalSyntheticLambda3(this));
        }
    }

    public /* synthetic */ void lambda$initWidgets$0$PictureSelectorActivity(CompoundButton compoundButton, boolean z) {
        this.config.isCheckOriginalImage = z;
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    public void onRecyclerViewPreloadMore() {
        loadMoreData();
    }

    private int getPageLimit() {
        if (ValueOf.toInt(this.mTvPictureTitle.getTag(R.id.view_tag)) != -1) {
            return this.config.pageSize;
        }
        int i = this.mOpenCameraCount > 0 ? this.config.pageSize - this.mOpenCameraCount : this.config.pageSize;
        this.mOpenCameraCount = 0;
        return i;
    }

    private void loadMoreData() {
        if (this.mAdapter != null && this.isHasMore) {
            this.mPage++;
            long j = ValueOf.toLong(this.mTvPictureTitle.getTag(R.id.view_tag));
            LocalMediaPageLoader.getInstance(getContext()).loadPageMediaData(j, this.mPage, getPageLimit(), new PictureSelectorActivity$$ExternalSyntheticLambda7(this, j));
        }
    }

    public /* synthetic */ void lambda$loadMoreData$1$PictureSelectorActivity(long j, List list, int i, boolean z) {
        if (!isFinishing()) {
            this.isHasMore = z;
            if (z) {
                hideDataNull();
                int size = list.size();
                if (size > 0) {
                    int size2 = this.mAdapter.getSize();
                    this.mAdapter.getData().addAll(list);
                    this.mAdapter.notifyItemRangeChanged(size2, this.mAdapter.getItemCount());
                } else {
                    onRecyclerViewPreloadMore();
                }
                if (size < 10) {
                    RecyclerPreloadView recyclerPreloadView = this.mRecyclerView;
                    recyclerPreloadView.onScrolled(recyclerPreloadView.getScrollX(), this.mRecyclerView.getScrollY());
                }
            } else if (this.mAdapter.isDataEmpty()) {
                showDataNull(getString(j == -1 ? R.string.picture_empty : R.string.picture_data_null), R.drawable.picture_icon_no_data);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorActivity, android.app.Activity] */
    private void loadAllMediaData() {
        if (PermissionChecker.isCheckReadStorage(this)) {
            readLocalMedia();
        } else {
            PermissionChecker.requestPermissions(this, PermissionConfig.getReadPermissionArray(this), 1);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorActivity] */
    public void initPictureSelectorStyle() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_top_titleArrowDownDrawable != 0) {
                this.mIvArrow.setImageDrawable(ContextCompat.getDrawable(this, PictureSelectionConfig.uiStyle.picture_top_titleArrowDownDrawable));
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleTextColor != 0) {
                this.mTvPictureTitle.setTextColor(PictureSelectionConfig.uiStyle.picture_top_titleTextColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleTextSize != 0) {
                this.mTvPictureTitle.setTextSize((float) PictureSelectionConfig.uiStyle.picture_top_titleTextSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextColor.length > 0 && (colorStateList3 = AttrsUtils.getColorStateList(PictureSelectionConfig.uiStyle.picture_top_titleRightTextColor)) != null) {
                this.mTvPictureRight.setTextColor(colorStateList3);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize != 0) {
                this.mTvPictureRight.setTextSize((float) PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_leftBack != 0) {
                this.mIvPictureLeftBack.setImageResource(PictureSelectionConfig.uiStyle.picture_top_leftBack);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_previewTextColor.length > 0 && (colorStateList2 = AttrsUtils.getColorStateList(PictureSelectionConfig.uiStyle.picture_bottom_previewTextColor)) != null) {
                this.mTvPicturePreview.setTextColor(colorStateList2);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_previewTextSize != 0) {
                this.mTvPicturePreview.setTextSize((float) PictureSelectionConfig.uiStyle.picture_bottom_previewTextSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotBackground != 0) {
                this.mTvPictureImgNum.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotBackground);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotTextSize != 0) {
                this.mTvPictureImgNum.setTextSize((float) PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotTextSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotTextColor != 0) {
                this.mTvPictureImgNum.setTextColor(PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotTextColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeTextColor.length > 0 && (colorStateList = AttrsUtils.getColorStateList(PictureSelectionConfig.uiStyle.picture_bottom_completeTextColor)) != null) {
                this.mTvPictureOk.setTextColor(colorStateList);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeTextSize != 0) {
                this.mTvPictureOk.setTextSize((float) PictureSelectionConfig.uiStyle.picture_bottom_completeTextSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor != 0) {
                this.mBottomLayout.setBackgroundColor(PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_container_backgroundColor != 0) {
                this.container.setBackgroundColor(PictureSelectionConfig.uiStyle.picture_container_backgroundColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText != 0) {
                this.mTvPictureRight.setText(PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                this.mTvPictureOk.setText(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText != 0) {
                this.mTvPicturePreview.setText(PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleArrowLeftPadding != 0) {
                ((RelativeLayout.LayoutParams) this.mIvArrow.getLayoutParams()).leftMargin = PictureSelectionConfig.uiStyle.picture_top_titleArrowLeftPadding;
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleBarHeight > 0) {
                this.mTitleBar.getLayoutParams().height = PictureSelectionConfig.uiStyle.picture_top_titleBarHeight;
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_barHeight > 0) {
                this.mBottomLayout.getLayoutParams().height = PictureSelectionConfig.uiStyle.picture_bottom_barHeight;
            }
            if (this.config.isOriginalControl) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle != 0) {
                    this.mCbOriginal.setButtonDrawable(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle);
                } else {
                    this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_checkbox));
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor != 0) {
                    this.mCbOriginal.setTextColor(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor);
                } else {
                    this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_white));
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize != 0) {
                    this.mCbOriginal.setTextSize((float) PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize);
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureText != 0) {
                    this.mCbOriginal.setText(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureText);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_white));
            }
        } else if (PictureSelectionConfig.style != null) {
            if (PictureSelectionConfig.style.pictureTitleDownResId != 0) {
                this.mIvArrow.setImageDrawable(ContextCompat.getDrawable(this, PictureSelectionConfig.style.pictureTitleDownResId));
            }
            if (PictureSelectionConfig.style.pictureTitleTextColor != 0) {
                this.mTvPictureTitle.setTextColor(PictureSelectionConfig.style.pictureTitleTextColor);
            }
            if (PictureSelectionConfig.style.pictureTitleTextSize != 0) {
                this.mTvPictureTitle.setTextSize((float) PictureSelectionConfig.style.pictureTitleTextSize);
            }
            if (PictureSelectionConfig.style.pictureRightDefaultTextColor != 0) {
                this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureRightDefaultTextColor);
            } else if (PictureSelectionConfig.style.pictureCancelTextColor != 0) {
                this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureCancelTextColor);
            }
            if (PictureSelectionConfig.style.pictureRightTextSize != 0) {
                this.mTvPictureRight.setTextSize((float) PictureSelectionConfig.style.pictureRightTextSize);
            }
            if (PictureSelectionConfig.style.pictureLeftBackIcon != 0) {
                this.mIvPictureLeftBack.setImageResource(PictureSelectionConfig.style.pictureLeftBackIcon);
            }
            if (PictureSelectionConfig.style.pictureUnPreviewTextColor != 0) {
                this.mTvPicturePreview.setTextColor(PictureSelectionConfig.style.pictureUnPreviewTextColor);
            }
            if (PictureSelectionConfig.style.picturePreviewTextSize != 0) {
                this.mTvPicturePreview.setTextSize((float) PictureSelectionConfig.style.picturePreviewTextSize);
            }
            if (PictureSelectionConfig.style.pictureCheckNumBgStyle != 0) {
                this.mTvPictureImgNum.setBackgroundResource(PictureSelectionConfig.style.pictureCheckNumBgStyle);
            }
            if (PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                this.mTvPictureOk.setTextColor(PictureSelectionConfig.style.pictureUnCompleteTextColor);
            }
            if (PictureSelectionConfig.style.pictureCompleteTextSize != 0) {
                this.mTvPictureOk.setTextSize((float) PictureSelectionConfig.style.pictureCompleteTextSize);
            }
            if (PictureSelectionConfig.style.pictureBottomBgColor != 0) {
                this.mBottomLayout.setBackgroundColor(PictureSelectionConfig.style.pictureBottomBgColor);
            }
            if (PictureSelectionConfig.style.pictureContainerBackgroundColor != 0) {
                this.container.setBackgroundColor(PictureSelectionConfig.style.pictureContainerBackgroundColor);
            }
            if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureRightDefaultText)) {
                this.mTvPictureRight.setText(PictureSelectionConfig.style.pictureRightDefaultText);
            }
            if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                this.mTvPictureOk.setText(PictureSelectionConfig.style.pictureUnCompleteText);
            }
            if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnPreviewText)) {
                this.mTvPicturePreview.setText(PictureSelectionConfig.style.pictureUnPreviewText);
            }
            if (PictureSelectionConfig.style.pictureTitleRightArrowLeftPadding != 0) {
                ((RelativeLayout.LayoutParams) this.mIvArrow.getLayoutParams()).leftMargin = PictureSelectionConfig.style.pictureTitleRightArrowLeftPadding;
            }
            if (PictureSelectionConfig.style.pictureTitleBarHeight > 0) {
                this.mTitleBar.getLayoutParams().height = PictureSelectionConfig.style.pictureTitleBarHeight;
            }
            if (this.config.isOriginalControl) {
                if (PictureSelectionConfig.style.pictureOriginalControlStyle != 0) {
                    this.mCbOriginal.setButtonDrawable(PictureSelectionConfig.style.pictureOriginalControlStyle);
                } else {
                    this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_checkbox));
                }
                if (PictureSelectionConfig.style.pictureOriginalFontColor != 0) {
                    this.mCbOriginal.setTextColor(PictureSelectionConfig.style.pictureOriginalFontColor);
                } else {
                    this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_white));
                }
                if (PictureSelectionConfig.style.pictureOriginalTextSize != 0) {
                    this.mCbOriginal.setTextSize((float) PictureSelectionConfig.style.pictureOriginalTextSize);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_white));
            }
        } else {
            int typeValueColor = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_title_textColor);
            if (typeValueColor != 0) {
                this.mTvPictureTitle.setTextColor(typeValueColor);
            }
            int typeValueColor2 = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_right_textColor);
            if (typeValueColor2 != 0) {
                this.mTvPictureRight.setTextColor(typeValueColor2);
            }
            int typeValueColor3 = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_container_backgroundColor);
            if (typeValueColor3 != 0) {
                this.container.setBackgroundColor(typeValueColor3);
            }
            this.mIvPictureLeftBack.setImageDrawable(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_leftBack_icon, R.drawable.picture_icon_back));
            if (this.config.downResId != 0) {
                this.mIvArrow.setImageDrawable(ContextCompat.getDrawable(this, this.config.downResId));
            } else {
                this.mIvArrow.setImageDrawable(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_arrow_down_icon, R.drawable.picture_icon_arrow_down));
            }
            int typeValueColor4 = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_bottom_bg);
            if (typeValueColor4 != 0) {
                this.mBottomLayout.setBackgroundColor(typeValueColor4);
            }
            ColorStateList typeValueColorStateList = AttrsUtils.getTypeValueColorStateList(getContext(), R.attr.picture_complete_textColor);
            if (typeValueColorStateList != null) {
                this.mTvPictureOk.setTextColor(typeValueColorStateList);
            }
            ColorStateList typeValueColorStateList2 = AttrsUtils.getTypeValueColorStateList(getContext(), R.attr.picture_preview_textColor);
            if (typeValueColorStateList2 != null) {
                this.mTvPicturePreview.setTextColor(typeValueColorStateList2);
            }
            int typeValueSizeForInt = AttrsUtils.getTypeValueSizeForInt(getContext(), R.attr.picture_titleRightArrow_LeftPadding);
            if (typeValueSizeForInt != 0) {
                ((RelativeLayout.LayoutParams) this.mIvArrow.getLayoutParams()).leftMargin = typeValueSizeForInt;
            }
            this.mTvPictureImgNum.setBackground(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_num_style, R.drawable.picture_num_oval));
            int typeValueSizeForInt2 = AttrsUtils.getTypeValueSizeForInt(getContext(), R.attr.picture_titleBar_height);
            if (typeValueSizeForInt2 > 0) {
                this.mTitleBar.getLayoutParams().height = typeValueSizeForInt2;
            }
            if (this.config.isOriginalControl) {
                this.mCbOriginal.setButtonDrawable(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_original_check_style, R.drawable.picture_original_wechat_checkbox));
                int typeValueColor5 = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_original_text_color);
                if (typeValueColor5 != 0) {
                    this.mCbOriginal.setTextColor(typeValueColor5);
                }
            }
        }
        this.mTitleBar.setBackgroundColor(this.colorPrimary);
        this.mAdapter.bindSelectData(this.selectionMedias);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
        if (pictureImageGridAdapter != null) {
            bundle.putInt(PictureConfig.EXTRA_OLD_CURRENT_LIST_SIZE, pictureImageGridAdapter.getSize());
            if (this.folderWindow.getFolderData().size() > 0) {
                bundle.putInt(PictureConfig.EXTRA_ALL_FOLDER_SIZE, this.folderWindow.getFolder(0).getImageNum());
            }
            if (this.mAdapter.getSelectedData() != null) {
                PictureSelector.saveSelectorList(bundle, this.mAdapter.getSelectedData());
            }
        }
    }

    private void isNumComplete(boolean z) {
        if (z) {
            initCompleteText(0);
        }
    }

    /* access modifiers changed from: protected */
    public void initCompleteText(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i2;
        String str6;
        String str7;
        int i3;
        String str8;
        if (this.config.selectionMode == 1) {
            if (i <= 0) {
                if (PictureSelectionConfig.uiStyle != null) {
                    if (PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                        TextView textView = this.mTvPictureOk;
                        if (PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                            str8 = String.format(getString(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText), new Object[]{Integer.valueOf(i), 1});
                        } else {
                            str8 = getString(R.string.picture_please_select);
                        }
                        textView.setText(str8);
                        return;
                    }
                    TextView textView2 = this.mTvPictureOk;
                    if (PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                        i3 = PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText;
                    } else {
                        i3 = R.string.picture_please_select;
                    }
                    textView2.setText(getString(i3));
                } else if (PictureSelectionConfig.style == null) {
                } else {
                    if (!PictureSelectionConfig.style.isCompleteReplaceNum || TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                        TextView textView3 = this.mTvPictureOk;
                        if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                            str7 = PictureSelectionConfig.style.pictureUnCompleteText;
                        } else {
                            str7 = getString(R.string.picture_done);
                        }
                        textView3.setText(str7);
                        return;
                    }
                    this.mTvPictureOk.setText(String.format(PictureSelectionConfig.style.pictureUnCompleteText, new Object[]{Integer.valueOf(i), 1}));
                }
            } else if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                    TextView textView4 = this.mTvPictureOk;
                    if (PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                        str6 = String.format(getString(PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText), new Object[]{Integer.valueOf(i), 1});
                    } else {
                        str6 = getString(R.string.picture_done);
                    }
                    textView4.setText(str6);
                    return;
                }
                TextView textView5 = this.mTvPictureOk;
                if (PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                    i2 = PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText;
                } else {
                    i2 = R.string.picture_done;
                }
                textView5.setText(getString(i2));
            } else if (PictureSelectionConfig.style == null) {
            } else {
                if (!PictureSelectionConfig.style.isCompleteReplaceNum || TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                    TextView textView6 = this.mTvPictureOk;
                    if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                        str5 = PictureSelectionConfig.style.pictureCompleteText;
                    } else {
                        str5 = getString(R.string.picture_done);
                    }
                    textView6.setText(str5);
                    return;
                }
                this.mTvPictureOk.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, new Object[]{Integer.valueOf(i), 1}));
            }
        } else if (i <= 0) {
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                    TextView textView7 = this.mTvPictureOk;
                    if (PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                        str4 = String.format(getString(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText), new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)});
                    } else {
                        str4 = getString(R.string.picture_done_front_num, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)});
                    }
                    textView7.setText(str4);
                    return;
                }
                TextView textView8 = this.mTvPictureOk;
                if (PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                    str3 = getString(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText);
                } else {
                    str3 = getString(R.string.picture_done_front_num, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)});
                }
                textView8.setText(str3);
            } else if (PictureSelectionConfig.style == null) {
            } else {
                if (PictureSelectionConfig.style.isCompleteReplaceNum) {
                    TextView textView9 = this.mTvPictureOk;
                    if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                        str2 = String.format(PictureSelectionConfig.style.pictureUnCompleteText, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)});
                    } else {
                        str2 = getString(R.string.picture_done_front_num, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)});
                    }
                    textView9.setText(str2);
                    return;
                }
                TextView textView10 = this.mTvPictureOk;
                if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                    str = PictureSelectionConfig.style.pictureUnCompleteText;
                } else {
                    str = getString(R.string.picture_done_front_num, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)});
                }
                textView10.setText(str);
            }
        } else if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                    this.mTvPictureOk.setText(String.format(getString(PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText), new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)}));
                    return;
                }
                this.mTvPictureOk.setText(getString(R.string.picture_done_front_num, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)}));
            } else if (PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                this.mTvPictureOk.setText(getString(PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText));
            } else {
                this.mTvPictureOk.setText(getString(R.string.picture_done_front_num, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)}));
            }
        } else if (PictureSelectionConfig.style == null) {
        } else {
            if (PictureSelectionConfig.style.isCompleteReplaceNum) {
                if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                    this.mTvPictureOk.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)}));
                    return;
                }
                this.mTvPictureOk.setText(getString(R.string.picture_done_front_num, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)}));
            } else if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                this.mTvPictureOk.setText(PictureSelectionConfig.style.pictureCompleteText);
            } else {
                this.mTvPictureOk.setText(getString(R.string.picture_done_front_num, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)}));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void readLocalMedia() {
        showPleaseDialog();
        if (this.config.isPageStrategy) {
            LocalMediaPageLoader.getInstance(getContext()).loadAllMedia(new PictureSelectorActivity$$ExternalSyntheticLambda6(this));
        } else {
            PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<List<LocalMediaFolder>>() {
                public List<LocalMediaFolder> doInBackground() {
                    return new LocalMediaLoader(PictureSelectorActivity.this.getContext()).loadAllMedia();
                }

                public void onSuccess(List<LocalMediaFolder> list) {
                    PictureSelectorActivity.this.initStandardModel(list);
                }
            });
        }
    }

    public /* synthetic */ void lambda$readLocalMedia$2$PictureSelectorActivity(List list, int i, boolean z) {
        if (!isFinishing()) {
            this.isHasMore = true;
            initPageModel(list);
            if (this.config.isSyncCover) {
                synchronousCover();
            }
        }
    }

    private void initPageModel(List<LocalMediaFolder> list) {
        if (list != null) {
            this.folderWindow.bindFolder(list);
            this.mPage = 1;
            LocalMediaFolder folder = this.folderWindow.getFolder(0);
            this.mTvPictureTitle.setTag(R.id.view_count_tag, Integer.valueOf(folder != null ? folder.getImageNum() : 0));
            this.mTvPictureTitle.setTag(R.id.view_index_tag, 0);
            long bucketId = folder != null ? folder.getBucketId() : -1;
            this.mRecyclerView.setEnabledLoadMore(true);
            LocalMediaPageLoader.getInstance(getContext()).loadPageMediaData(bucketId, this.mPage, new PictureSelectorActivity$$ExternalSyntheticLambda4(this));
            return;
        }
        showDataNull(getString(R.string.picture_data_exception), R.drawable.picture_icon_data_error);
        dismissDialog();
    }

    public /* synthetic */ void lambda$initPageModel$3$PictureSelectorActivity(List list, int i, boolean z) {
        if (!isFinishing()) {
            dismissDialog();
            if (this.mAdapter != null) {
                this.isHasMore = true;
                if (!z || list.size() != 0) {
                    int size = this.mAdapter.getSize();
                    int size2 = list.size();
                    int i2 = this.oldCurrentListSize + size;
                    this.oldCurrentListSize = i2;
                    if (size2 >= size) {
                        if (size <= 0 || size >= size2 || i2 == size2) {
                            this.mAdapter.bindData(list);
                        } else if (isLocalMediaSame((LocalMedia) list.get(0))) {
                            this.mAdapter.bindData(list);
                        } else {
                            this.mAdapter.getData().addAll(list);
                        }
                    }
                    if (this.mAdapter.isDataEmpty()) {
                        showDataNull(getString(R.string.picture_empty), R.drawable.picture_icon_no_data);
                    } else {
                        hideDataNull();
                    }
                } else {
                    onRecyclerViewPreloadMore();
                }
            }
        }
    }

    private void synchronousCover() {
        if (this.config.chooseMode == PictureMimeType.ofAll()) {
            PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<Boolean>() {
                public void onSuccess(Boolean bool) {
                }

                public Boolean doInBackground() {
                    int size = PictureSelectorActivity.this.folderWindow.getFolderData().size();
                    for (int i = 0; i < size; i++) {
                        LocalMediaFolder folder = PictureSelectorActivity.this.folderWindow.getFolder(i);
                        if (folder != null) {
                            folder.setFirstImagePath(LocalMediaPageLoader.getInstance(PictureSelectorActivity.this.getContext()).getFirstCover(folder.getBucketId()));
                        }
                    }
                    return true;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void initStandardModel(List<LocalMediaFolder> list) {
        if (list == null) {
            showDataNull(getString(R.string.picture_data_exception), R.drawable.picture_icon_data_error);
        } else if (list.size() > 0) {
            this.folderWindow.bindFolder(list);
            LocalMediaFolder localMediaFolder = list.get(0);
            localMediaFolder.setChecked(true);
            this.mTvPictureTitle.setTag(R.id.view_count_tag, Integer.valueOf(localMediaFolder.getImageNum()));
            List<LocalMedia> data = localMediaFolder.getData();
            PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
            if (pictureImageGridAdapter != null) {
                int size = pictureImageGridAdapter.getSize();
                int size2 = data.size();
                int i = this.oldCurrentListSize + size;
                this.oldCurrentListSize = i;
                if (size2 >= size) {
                    if (size <= 0 || size >= size2 || i == size2) {
                        this.mAdapter.bindData(data);
                    } else {
                        this.mAdapter.getData().addAll(data);
                        LocalMedia localMedia = this.mAdapter.getData().get(0);
                        localMediaFolder.setFirstImagePath(localMedia.getPath());
                        localMediaFolder.getData().add(0, localMedia);
                        localMediaFolder.setCheckedNum(1);
                        localMediaFolder.setImageNum(localMediaFolder.getImageNum() + 1);
                        updateMediaFolder(this.folderWindow.getFolderData(), localMedia);
                    }
                }
                if (this.mAdapter.isDataEmpty()) {
                    showDataNull(getString(R.string.picture_empty), R.drawable.picture_icon_no_data);
                } else {
                    hideDataNull();
                }
            }
        } else {
            showDataNull(getString(R.string.picture_empty), R.drawable.picture_icon_no_data);
        }
        dismissDialog();
    }

    private boolean isLocalMediaSame(LocalMedia localMedia) {
        LocalMedia item = this.mAdapter.getItem(0);
        if (!(item == null || localMedia == null)) {
            if (item.getPath().equals(localMedia.getPath())) {
                return true;
            }
            if (PictureMimeType.isContent(localMedia.getPath()) && PictureMimeType.isContent(item.getPath()) && !TextUtils.isEmpty(localMedia.getPath()) && !TextUtils.isEmpty(item.getPath())) {
                return localMedia.getPath().substring(localMedia.getPath().lastIndexOf("/") + 1).equals(item.getPath().substring(item.getPath().lastIndexOf("/") + 1));
            }
        }
        return false;
    }

    public void startCamera() {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (PictureSelectionConfig.onCustomCameraInterfaceListener != null) {
            if (this.config.chooseMode == 0) {
                PhotoItemSelectedDialog newInstance = PhotoItemSelectedDialog.newInstance();
                newInstance.setOnItemClickListener(this);
                newInstance.show(getSupportFragmentManager(), "PhotoItemSelectedDialog");
                return;
            }
            PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(getContext(), this.config, this.config.chooseMode);
            this.config.cameraMimeType = this.config.chooseMode;
        } else if (this.config.chooseMode == PictureMimeType.ofAudio() || !this.config.isUseCustomCamera) {
            int i = this.config.chooseMode;
            if (i == 0) {
                PhotoItemSelectedDialog newInstance2 = PhotoItemSelectedDialog.newInstance();
                newInstance2.setOnItemClickListener(this);
                newInstance2.show(getSupportFragmentManager(), "PhotoItemSelectedDialog");
            } else if (i == 1) {
                startOpenCameraImage();
            } else if (i == 2) {
                startOpenCameraVideo();
            } else if (i == 3) {
                startOpenCameraAudio();
            }
        } else {
            startCustomCamera();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorActivity, android.app.Activity] */
    private void startCustomCamera() {
        if (PermissionChecker.checkSelfPermission((Context) this, "android.permission.RECORD_AUDIO")) {
            startActivityForResult(new Intent(this, PictureCustomCameraActivity.class), PictureConfig.REQUEST_CAMERA);
            overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, R.anim.picture_anim_fade_in);
            return;
        }
        PermissionChecker.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 4);
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, PictureSelectorActivity.class);
        int id = view.getId();
        if (id == R.id.pictureLeftBack || id == R.id.picture_right) {
            FolderPopWindow folderPopWindow = this.folderWindow;
            if (folderPopWindow == null || !folderPopWindow.isShowing()) {
                onBackPressed();
            } else {
                this.folderWindow.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
        } else if (id == R.id.picture_title || id == R.id.ivArrow || id == R.id.viewClickMask) {
            if (this.folderWindow.isShowing()) {
                this.folderWindow.dismiss();
            } else if (!this.folderWindow.isEmpty()) {
                this.folderWindow.showAsDropDown(this.mTitleBar);
                if (!this.config.isSingleDirectReturn) {
                    this.folderWindow.updateFolderCheckStatus(this.mAdapter.getSelectedData());
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
        } else if (id == R.id.picture_id_preview) {
            onPreview();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
        } else if (id == R.id.picture_tv_ok || id == R.id.tv_media_num) {
            onComplete();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
        } else {
            if (id == R.id.titleBar && this.config.isAutomaticTitleRecyclerTop) {
                if (SystemClock.uptimeMillis() - this.intervalClickTime >= ((long) ServiceStarter.ERROR_UNKNOWN)) {
                    this.intervalClickTime = SystemClock.uptimeMillis();
                } else if (this.mAdapter.getItemCount() > 0) {
                    this.mRecyclerView.scrollToPosition(0);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
        }
    }

    private void onPreview() {
        List<LocalMedia> selectedData = this.mAdapter.getSelectedData();
        ArrayList arrayList = new ArrayList();
        int size = selectedData.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(selectedData.get(i));
        }
        if (PictureSelectionConfig.onCustomImagePreviewCallback != null) {
            PictureSelectionConfig.onCustomImagePreviewCallback.onCustomPreviewCallback(getContext(), selectedData, 0);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(PictureConfig.EXTRA_PREVIEW_SELECT_LIST, arrayList);
        bundle.putParcelableArrayList(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) selectedData);
        bundle.putBoolean(PictureConfig.EXTRA_BOTTOM_PREVIEW, true);
        bundle.putBoolean(PictureConfig.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
        bundle.putBoolean(PictureConfig.EXTRA_SHOW_CAMERA, this.mAdapter.isShowCamera());
        bundle.putString(PictureConfig.EXTRA_IS_CURRENT_DIRECTORY, this.mTvPictureTitle.getText().toString());
        JumpUtils.startPicturePreviewActivity(getContext(), this.config.isWeChatStyle, bundle, this.config.selectionMode == 1 ? 69 : 609);
        overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation, R.anim.picture_anim_fade_in);
    }

    private void onComplete() {
        List<LocalMedia> selectedData = this.mAdapter.getSelectedData();
        int size = selectedData.size();
        LocalMedia localMedia = selectedData.size() > 0 ? selectedData.get(0) : null;
        String mimeType = localMedia != null ? localMedia.getMimeType() : "";
        boolean isHasImage = PictureMimeType.isHasImage(mimeType);
        if (this.config.isWithVideoImage) {
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (PictureMimeType.isHasVideo(selectedData.get(i3).getMimeType())) {
                    i2++;
                } else {
                    i++;
                }
            }
            if (this.config.selectionMode == 2) {
                if (this.config.minSelectNum > 0 && i < this.config.minSelectNum) {
                    showPromptDialog(getString(R.string.picture_min_img_num, new Object[]{Integer.valueOf(this.config.minSelectNum)}));
                    return;
                } else if (this.config.minVideoSelectNum > 0 && i2 < this.config.minVideoSelectNum) {
                    showPromptDialog(getString(R.string.picture_min_video_num, new Object[]{Integer.valueOf(this.config.minVideoSelectNum)}));
                    return;
                }
            }
        } else if (this.config.selectionMode == 2) {
            if (PictureMimeType.isHasImage(mimeType) && this.config.minSelectNum > 0 && size < this.config.minSelectNum) {
                showPromptDialog(getString(R.string.picture_min_img_num, new Object[]{Integer.valueOf(this.config.minSelectNum)}));
                return;
            } else if (PictureMimeType.isHasVideo(mimeType) && this.config.minVideoSelectNum > 0 && size < this.config.minVideoSelectNum) {
                showPromptDialog(getString(R.string.picture_min_video_num, new Object[]{Integer.valueOf(this.config.minVideoSelectNum)}));
                return;
            }
        }
        if (this.config.returnEmpty && size == 0) {
            if (this.config.selectionMode == 2) {
                if (this.config.minSelectNum > 0 && size < this.config.minSelectNum) {
                    showPromptDialog(getString(R.string.picture_min_img_num, new Object[]{Integer.valueOf(this.config.minSelectNum)}));
                    return;
                } else if (this.config.minVideoSelectNum > 0 && size < this.config.minVideoSelectNum) {
                    showPromptDialog(getString(R.string.picture_min_video_num, new Object[]{Integer.valueOf(this.config.minVideoSelectNum)}));
                    return;
                }
            }
            if (PictureSelectionConfig.listener != null) {
                PictureSelectionConfig.listener.onResult(selectedData);
            } else {
                setResult(-1, PictureSelector.putIntentResult(selectedData));
            }
            exit();
        } else if (this.config.chooseMode != PictureMimeType.ofAll() || !this.config.isWithVideoImage) {
            separateMimeTypeWith(isHasImage, selectedData);
        } else {
            bothMimeTypeWith(isHasImage, selectedData);
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.luck.picture.lib.PictureSelectorActivity, android.app.Activity] */
    private void bothMimeTypeWith(boolean z, List<LocalMedia> list) {
        int i = 0;
        LocalMedia localMedia = list.size() > 0 ? list.get(0) : null;
        if (localMedia != null) {
            if (!this.config.enableCrop || this.config.isCheckOriginalImage) {
                if (this.config.isCompress) {
                    int size = list.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (PictureMimeType.isHasImage(list.get(i2).getMimeType())) {
                            i = 1;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i <= 0) {
                        onResult(list);
                    } else {
                        compressImage(list);
                    }
                } else {
                    onResult(list);
                }
            } else if (this.config.selectionMode != 1 || !z) {
                int size2 = list.size();
                int i3 = 0;
                while (i < size2) {
                    LocalMedia localMedia2 = list.get(i);
                    if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.getPath()) && PictureMimeType.isHasImage(localMedia2.getMimeType())) {
                        i3++;
                    }
                    i++;
                }
                if (i3 <= 0) {
                    onResult(list);
                } else {
                    UCropManager.ofCrop(this, (ArrayList) list);
                }
            } else {
                this.config.originalPath = localMedia.getPath();
                UCropManager.ofCrop(this, this.config.originalPath, localMedia.getMimeType());
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.luck.picture.lib.PictureSelectorActivity, android.app.Activity] */
    private void separateMimeTypeWith(boolean z, List<LocalMedia> list) {
        LocalMedia localMedia = list.size() > 0 ? list.get(0) : null;
        if (localMedia != null) {
            if (!this.config.enableCrop || this.config.isCheckOriginalImage || !z) {
                if (!this.config.isCompress || !z) {
                    onResult(list);
                } else {
                    compressImage(list);
                }
            } else if (this.config.selectionMode == 1) {
                this.config.originalPath = localMedia.getPath();
                UCropManager.ofCrop(this, this.config.originalPath, localMedia.getMimeType());
            } else {
                UCropManager.ofCrop(this, (ArrayList) list);
            }
        }
    }

    private void startPlayAudioDialog(final String str) {
        if (!isFinishing()) {
            PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(getContext(), R.layout.picture_audio_dialog);
            this.audioDialog = pictureCustomDialog;
            pictureCustomDialog.getWindow().setWindowAnimations(R.style.Picture_Theme_Dialog_AudioStyle);
            this.mTvMusicStatus = (TextView) this.audioDialog.findViewById(R.id.tv_musicStatus);
            this.mTvMusicTime = (TextView) this.audioDialog.findViewById(R.id.tv_musicTime);
            this.musicSeekBar = (SeekBar) this.audioDialog.findViewById(R.id.musicSeekBar);
            this.mTvMusicTotal = (TextView) this.audioDialog.findViewById(R.id.tv_musicTotal);
            this.mTvPlayPause = (TextView) this.audioDialog.findViewById(R.id.tv_PlayPause);
            this.mTvStop = (TextView) this.audioDialog.findViewById(R.id.tv_Stop);
            this.mTvQuit = (TextView) this.audioDialog.findViewById(R.id.tv_Quit);
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    PictureSelectorActivity.this.initPlayer(str);
                }
            }, 30);
            this.mTvPlayPause.setOnClickListener(new onAudioOnClick(str));
            this.mTvStop.setOnClickListener(new onAudioOnClick(str));
            this.mTvQuit.setOnClickListener(new onAudioOnClick(str));
            this.musicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    if (z) {
                        PictureSelectorActivity.this.mediaPlayer.seekTo(i);
                    }
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
                }
            });
            this.audioDialog.setOnDismissListener(new PictureSelectorActivity$$ExternalSyntheticLambda0(this, str));
            Handler handler = this.mHandler;
            Runnable runnable = this.mRunnable;
            if (!(handler instanceof Handler)) {
                handler.post(runnable);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, runnable);
            }
            this.audioDialog.show();
        }
    }

    public /* synthetic */ void lambda$startPlayAudioDialog$4$PictureSelectorActivity(final String str, DialogInterface dialogInterface) {
        this.mHandler.removeCallbacks(this.mRunnable);
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                PictureSelectorActivity.this.stop(str);
            }
        }, 30);
        try {
            PictureCustomDialog pictureCustomDialog = this.audioDialog;
            if (pictureCustomDialog != null && pictureCustomDialog.isShowing()) {
                this.audioDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void initPlayer(String str) {
        this.mediaPlayer = new MediaPlayer();
        try {
            if (PictureMimeType.isContent(str)) {
                this.mediaPlayer.setDataSource(getContext(), Uri.parse(str));
            } else {
                this.mediaPlayer.setDataSource(str);
            }
            this.mediaPlayer.prepare();
            this.mediaPlayer.setLooping(true);
            playAudio();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class onAudioOnClick implements View.OnClickListener {
        private String path;

        public onAudioOnClick(String str) {
            this.path = str;
        }

        public void onClick(View view) {
            MethodInfo.onClickEventEnter(view, PictureSelectorActivity.class);
            int id = view.getId();
            if (id == R.id.tv_PlayPause) {
                PictureSelectorActivity.this.playAudio();
            }
            if (id == R.id.tv_Stop) {
                PictureSelectorActivity.this.mTvMusicStatus.setText(PictureSelectorActivity.this.getString(R.string.picture_stop_audio));
                PictureSelectorActivity.this.mTvPlayPause.setText(PictureSelectorActivity.this.getString(R.string.picture_play_audio));
                PictureSelectorActivity.this.stop(this.path);
            }
            if (id == R.id.tv_Quit) {
                PictureSelectorActivity.this.mHandler.postDelayed(new PictureSelectorActivity$onAudioOnClick$$ExternalSyntheticLambda0(this), 30);
                try {
                    if (PictureSelectorActivity.this.audioDialog != null && PictureSelectorActivity.this.audioDialog.isShowing()) {
                        PictureSelectorActivity.this.audioDialog.dismiss();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                PictureSelectorActivity.this.mHandler.removeCallbacks(PictureSelectorActivity.this.mRunnable);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
        }

        public /* synthetic */ void lambda$onClick$0$PictureSelectorActivity$onAudioOnClick() {
            PictureSelectorActivity.this.stop(this.path);
        }
    }

    /* access modifiers changed from: private */
    public void playAudio() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            this.musicSeekBar.setProgress(mediaPlayer2.getCurrentPosition());
            this.musicSeekBar.setMax(this.mediaPlayer.getDuration());
        }
        if (this.mTvPlayPause.getText().toString().equals(getString(R.string.picture_play_audio))) {
            this.mTvPlayPause.setText(getString(R.string.picture_pause_audio));
            this.mTvMusicStatus.setText(getString(R.string.picture_play_audio));
        } else {
            this.mTvPlayPause.setText(getString(R.string.picture_play_audio));
            this.mTvMusicStatus.setText(getString(R.string.picture_pause_audio));
        }
        playOrPause();
        if (!this.isPlayAudio) {
            Handler handler = this.mHandler;
            Runnable runnable = this.mRunnable;
            if (!(handler instanceof Handler)) {
                handler.post(runnable);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, runnable);
            }
            this.isPlayAudio = true;
        }
    }

    public void stop(String str) {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            try {
                mediaPlayer2.stop();
                this.mediaPlayer.reset();
                if (PictureMimeType.isContent(str)) {
                    this.mediaPlayer.setDataSource(getContext(), Uri.parse(str));
                } else {
                    this.mediaPlayer.setDataSource(str);
                }
                this.mediaPlayer.prepare();
                this.mediaPlayer.seekTo(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void playOrPause() {
        try {
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 == null) {
                return;
            }
            if (mediaPlayer2.isPlaying()) {
                this.mediaPlayer.pause();
            } else {
                this.mediaPlayer.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onItemClick(int i, boolean z, long j, String str, List<LocalMedia> list) {
        this.mAdapter.setShowCamera(this.config.isCamera && z);
        this.mTvPictureTitle.setText(str);
        long j2 = ValueOf.toLong(this.mTvPictureTitle.getTag(R.id.view_tag));
        this.mTvPictureTitle.setTag(R.id.view_count_tag, Integer.valueOf(this.folderWindow.getFolder(i) != null ? this.folderWindow.getFolder(i).getImageNum() : 0));
        if (!this.config.isPageStrategy) {
            this.mAdapter.bindData(list);
            this.mRecyclerView.smoothScrollToPosition(0);
        } else if (j2 != j) {
            setLastCacheFolderData();
            if (!isCurrentCacheFolderData(i)) {
                this.mPage = 1;
                showPleaseDialog();
                LocalMediaPageLoader.getInstance(getContext()).loadPageMediaData(j, this.mPage, new PictureSelectorActivity$$ExternalSyntheticLambda5(this));
            }
        }
        this.mTvPictureTitle.setTag(R.id.view_tag, Long.valueOf(j));
        this.folderWindow.dismiss();
    }

    public /* synthetic */ void lambda$onItemClick$5$PictureSelectorActivity(List list, int i, boolean z) {
        this.isHasMore = z;
        if (!isFinishing()) {
            if (list.size() == 0) {
                this.mAdapter.clear();
            }
            this.mAdapter.bindData(list);
            this.mRecyclerView.onScrolled(0, 0);
            this.mRecyclerView.smoothScrollToPosition(0);
            dismissDialog();
        }
    }

    private void setLastCacheFolderData() {
        LocalMediaFolder folder = this.folderWindow.getFolder(ValueOf.toInt(this.mTvPictureTitle.getTag(R.id.view_index_tag)));
        folder.setData(this.mAdapter.getData());
        folder.setCurrentDataPage(this.mPage);
        folder.setHasMore(this.isHasMore);
    }

    private boolean isCurrentCacheFolderData(int i) {
        this.mTvPictureTitle.setTag(R.id.view_index_tag, Integer.valueOf(i));
        LocalMediaFolder folder = this.folderWindow.getFolder(i);
        if (folder == null || folder.getData() == null || folder.getData().size() <= 0) {
            return false;
        }
        this.mAdapter.bindData(folder.getData());
        this.mPage = folder.getCurrentDataPage();
        this.isHasMore = folder.isHasMore();
        this.mRecyclerView.smoothScrollToPosition(0);
        return true;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorActivity, android.app.Activity] */
    public void onTakePhoto() {
        if (PermissionChecker.checkSelfPermission((Context) this, "android.permission.CAMERA")) {
            startCamera();
        } else {
            PermissionChecker.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 2);
        }
    }

    public void onChange(List<LocalMedia> list) {
        changeImageNumber(list);
        calculateFileTotalSize(list);
    }

    /* access modifiers changed from: protected */
    public void calculateFileTotalSize(List<LocalMedia> list) {
        if (!this.config.isOriginalControl) {
            return;
        }
        if (this.config.isDisplayOriginalSize) {
            long j = 0;
            for (int i = 0; i < list.size(); i++) {
                j += list.get(i).getSize();
            }
            if (j > 0) {
                this.mCbOriginal.setText(getString(R.string.picture_original_image, new Object[]{PictureFileUtils.formatFileSize(j, 2)}));
                return;
            }
            this.mCbOriginal.setText(getString(R.string.picture_default_original_image));
            return;
        }
        this.mCbOriginal.setText(getString(R.string.picture_default_original_image));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.luck.picture.lib.PictureSelectorActivity, android.app.Activity] */
    public void onPictureClick(LocalMedia localMedia, int i) {
        if (this.config.selectionMode != 1 || !this.config.isSingleDirectReturn) {
            startPreview(this.mAdapter.getData(), i);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(localMedia);
        if (!this.config.enableCrop || !PictureMimeType.isHasImage(localMedia.getMimeType()) || this.config.isCheckOriginalImage) {
            handlerResult(arrayList);
            return;
        }
        this.mAdapter.bindSelectData(arrayList);
        UCropManager.ofCrop(this, localMedia.getPath(), localMedia.getMimeType());
    }

    public void startPreview(List<LocalMedia> list, int i) {
        LocalMedia localMedia = list.get(i);
        String mimeType = localMedia.getMimeType();
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        if (PictureMimeType.isHasVideo(mimeType)) {
            if (this.config.selectionMode == 1 && !this.config.enPreviewVideo) {
                arrayList.add(localMedia);
                onResult(arrayList);
            } else if (PictureSelectionConfig.customVideoPlayCallback != null) {
                PictureSelectionConfig.customVideoPlayCallback.startPlayVideo(localMedia);
            } else {
                bundle.putParcelable(PictureConfig.EXTRA_MEDIA_KEY, localMedia);
                JumpUtils.startPictureVideoPlayActivity(getContext(), bundle, PictureConfig.PREVIEW_VIDEO_CODE);
            }
        } else if (PictureMimeType.isHasAudio(mimeType)) {
            if (this.config.selectionMode == 1) {
                arrayList.add(localMedia);
                onResult(arrayList);
                return;
            }
            startPlayAudioDialog(localMedia.getPath());
        } else if (PictureSelectionConfig.onCustomImagePreviewCallback != null) {
            PictureSelectionConfig.onCustomImagePreviewCallback.onCustomPreviewCallback(getContext(), list, i);
        } else {
            List<LocalMedia> selectedData = this.mAdapter.getSelectedData();
            ImagesObservable.getInstance().saveData(new ArrayList(list));
            bundle.putParcelableArrayList(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) selectedData);
            bundle.putInt("position", i);
            bundle.putBoolean(PictureConfig.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
            bundle.putBoolean(PictureConfig.EXTRA_SHOW_CAMERA, this.mAdapter.isShowCamera());
            bundle.putLong(PictureConfig.EXTRA_BUCKET_ID, ValueOf.toLong(this.mTvPictureTitle.getTag(R.id.view_tag)));
            bundle.putInt(PictureConfig.EXTRA_PAGE, this.mPage);
            bundle.putParcelable(PictureConfig.EXTRA_CONFIG, this.config);
            bundle.putInt(PictureConfig.EXTRA_DATA_COUNT, ValueOf.toInt(this.mTvPictureTitle.getTag(R.id.view_count_tag)));
            bundle.putString(PictureConfig.EXTRA_IS_CURRENT_DIRECTORY, this.mTvPictureTitle.getText().toString());
            JumpUtils.startPicturePreviewActivity(getContext(), this.config.isWeChatStyle, bundle, this.config.selectionMode == 1 ? 69 : 609);
            overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation, R.anim.picture_anim_fade_in);
        }
    }

    /* access modifiers changed from: protected */
    public void changeImageNumber(List<LocalMedia> list) {
        if (list.size() != 0) {
            this.mTvPictureOk.setEnabled(true);
            this.mTvPictureOk.setSelected(true);
            this.mTvPicturePreview.setEnabled(true);
            this.mTvPicturePreview.setSelected(true);
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText == 0) {
                    this.mTvPicturePreview.setText(getString(R.string.picture_preview_num, new Object[]{Integer.valueOf(list.size())}));
                } else if (PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                    this.mTvPicturePreview.setText(String.format(getString(PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText), new Object[]{Integer.valueOf(list.size())}));
                } else {
                    this.mTvPicturePreview.setText(PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText);
                }
            } else if (PictureSelectionConfig.style != null) {
                if (PictureSelectionConfig.style.pictureCompleteTextColor != 0) {
                    this.mTvPictureOk.setTextColor(PictureSelectionConfig.style.pictureCompleteTextColor);
                }
                if (PictureSelectionConfig.style.picturePreviewTextColor != 0) {
                    this.mTvPicturePreview.setTextColor(PictureSelectionConfig.style.picturePreviewTextColor);
                }
                if (!TextUtils.isEmpty(PictureSelectionConfig.style.picturePreviewText)) {
                    this.mTvPicturePreview.setText(PictureSelectionConfig.style.picturePreviewText);
                } else {
                    this.mTvPicturePreview.setText(getString(R.string.picture_preview_num, new Object[]{Integer.valueOf(list.size())}));
                }
            }
            if (this.numComplete) {
                initCompleteText(list.size());
                return;
            }
            if (!this.isStartAnimation) {
                this.mTvPictureImgNum.startAnimation(this.animation);
            }
            this.mTvPictureImgNum.setVisibility(0);
            this.mTvPictureImgNum.setText(ValueOf.toString(Integer.valueOf(list.size())));
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                    this.mTvPictureOk.setText(getString(PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText));
                }
            } else if (PictureSelectionConfig.style == null) {
                this.mTvPictureOk.setText(getString(R.string.picture_completed));
            } else if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                this.mTvPictureOk.setText(PictureSelectionConfig.style.pictureCompleteText);
            }
            this.isStartAnimation = false;
            return;
        }
        this.mTvPictureOk.setEnabled(this.config.returnEmpty);
        this.mTvPictureOk.setSelected(false);
        this.mTvPicturePreview.setEnabled(false);
        this.mTvPicturePreview.setSelected(false);
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_bottom_previewDefaultText != 0) {
                this.mTvPicturePreview.setText(getString(PictureSelectionConfig.uiStyle.picture_bottom_previewDefaultText));
            } else {
                this.mTvPicturePreview.setText(getString(R.string.picture_preview));
            }
        } else if (PictureSelectionConfig.style != null) {
            if (PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                this.mTvPictureOk.setTextColor(PictureSelectionConfig.style.pictureUnCompleteTextColor);
            }
            if (PictureSelectionConfig.style.pictureUnPreviewTextColor != 0) {
                this.mTvPicturePreview.setTextColor(PictureSelectionConfig.style.pictureUnPreviewTextColor);
            }
            if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnPreviewText)) {
                this.mTvPicturePreview.setText(PictureSelectionConfig.style.pictureUnPreviewText);
            } else {
                this.mTvPicturePreview.setText(getString(R.string.picture_preview));
            }
        }
        if (this.numComplete) {
            initCompleteText(list.size());
            return;
        }
        this.mTvPictureImgNum.setVisibility(4);
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                this.mTvPictureOk.setText(getString(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText));
            }
        } else if (PictureSelectionConfig.style == null) {
            this.mTvPictureOk.setText(getString(R.string.picture_please_select));
        } else if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
            this.mTvPictureOk.setText(PictureSelectionConfig.style.pictureUnCompleteText);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorActivity, com.luck.picture.lib.PictureBaseActivity] */
    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Throwable th;
        ArrayList parcelableArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 69) {
                singleCropHandleResult(intent);
            } else if (i != 166) {
                if (i == 609) {
                    multiCropHandleResult(intent);
                } else if (i == 909) {
                    dispatchHandleCamera(intent);
                }
            } else if (intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST)) != null && parcelableArrayListExtra.size() > 0) {
                onResult(parcelableArrayListExtra);
            }
        } else if (i2 == 0) {
            previewCallback(intent);
            if (i == 909) {
                MediaUtils.deleteCamera(this, this.config.cameraPath);
            }
        } else if (i2 == 96 && intent != null && (th = (Throwable) intent.getSerializableExtra("com.yalantis.ucrop.Error")) != null) {
            ToastUtils.s(getContext(), th.getMessage());
        }
    }

    private void previewCallback(Intent intent) {
        if (intent != null) {
            if (this.config.isOriginalControl) {
                this.config.isCheckOriginalImage = intent.getBooleanExtra(PictureConfig.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
                this.mCbOriginal.setChecked(this.config.isCheckOriginalImage);
            }
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST);
            if (this.mAdapter != null && parcelableArrayListExtra != null) {
                char c = 0;
                if (intent.getBooleanExtra(PictureConfig.EXTRA_COMPLETE_SELECTED, false)) {
                    onChangeData(parcelableArrayListExtra);
                    if (this.config.isWithVideoImage) {
                        int size = parcelableArrayListExtra.size();
                        int i = 0;
                        while (true) {
                            if (i >= size) {
                                break;
                            } else if (PictureMimeType.isHasImage(((LocalMedia) parcelableArrayListExtra.get(i)).getMimeType())) {
                                c = 1;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (c <= 0 || !this.config.isCompress) {
                            onResult(parcelableArrayListExtra);
                        } else {
                            compressImage(parcelableArrayListExtra);
                        }
                    } else {
                        String mimeType = parcelableArrayListExtra.size() > 0 ? ((LocalMedia) parcelableArrayListExtra.get(0)).getMimeType() : "";
                        if (!this.config.isCompress || !PictureMimeType.isHasImage(mimeType)) {
                            onResult(parcelableArrayListExtra);
                        } else {
                            compressImage(parcelableArrayListExtra);
                        }
                    }
                } else {
                    this.isStartAnimation = true;
                }
                this.mAdapter.bindSelectData(parcelableArrayListExtra);
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.luck.picture.lib.PictureSelectorActivity, android.app.Activity] */
    private void singleDirectReturnCameraHandleResult(String str) {
        boolean isHasImage = PictureMimeType.isHasImage(str);
        if (this.config.enableCrop && !this.config.isCheckOriginalImage && isHasImage) {
            this.config.originalPath = this.config.cameraPath;
            UCropManager.ofCrop(this, this.config.originalPath, str);
        } else if (!this.config.isCompress || !isHasImage) {
            onResult(this.mAdapter.getSelectedData());
        } else {
            compressImage(this.mAdapter.getSelectedData());
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorActivity] */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008e, code lost:
        if (r2.isOpen() != false) goto L_0x0090;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bc A[Catch:{ Exception -> 0x000c }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00bd A[Catch:{ Exception -> 0x000c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dispatchHandleCamera(android.content.Intent r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x000f
            java.lang.String r1 = "PictureSelectorConfig"
            android.os.Parcelable r1 = r8.getParcelableExtra(r1)     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r1 = (com.luck.picture.lib.config.PictureSelectionConfig) r1     // Catch:{ Exception -> 0x000c }
            goto L_0x0010
        L_0x000c:
            r8 = move-exception
            goto L_0x02f8
        L_0x000f:
            r1 = r0
        L_0x0010:
            if (r1 == 0) goto L_0x0014
            r7.config = r1     // Catch:{ Exception -> 0x000c }
        L_0x0014:
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x000c }
            int r1 = r1.chooseMode     // Catch:{ Exception -> 0x000c }
            int r2 = com.luck.picture.lib.config.PictureMimeType.ofAudio()     // Catch:{ Exception -> 0x000c }
            if (r1 != r2) goto L_0x00b2
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x000c }
            int r2 = com.luck.picture.lib.config.PictureMimeType.ofAudio()     // Catch:{ Exception -> 0x000c }
            r1.cameraMimeType = r2     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r2 = r7.getAudioPath(r8)     // Catch:{ Exception -> 0x000c }
            r1.cameraPath = r2     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r1 = r1.cameraPath     // Catch:{ Exception -> 0x000c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x000c }
            if (r1 == 0) goto L_0x0039
            return
        L_0x0039:
            boolean r1 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_R()     // Catch:{ Exception -> 0x000c }
            if (r1 == 0) goto L_0x00b2
            android.content.Context r1 = r7.getContext()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            com.luck.picture.lib.config.PictureSelectionConfig r2 = r7.config     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.lang.String r2 = r2.cameraAudioFormat     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            if (r2 == 0) goto L_0x0052
            com.luck.picture.lib.config.PictureSelectionConfig r2 = r7.config     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.lang.String r2 = r2.suffixType     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            goto L_0x0056
        L_0x0052:
            com.luck.picture.lib.config.PictureSelectionConfig r2 = r7.config     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.lang.String r2 = r2.cameraAudioFormat     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
        L_0x0056:
            android.net.Uri r1 = com.luck.picture.lib.tools.MediaUtils.createAudioUri(r1, r2)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            if (r1 == 0) goto L_0x0087
            com.luck.picture.lib.config.PictureSelectionConfig r2 = r7.config     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.lang.String r2 = r2.cameraPath     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.io.InputStream r2 = com.luck.picture.lib.PictureContentResolver.getContentResolverOpenInputStream(r7, r2)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.util.Objects.requireNonNull(r2)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            okio.Source r2 = okio.Okio.source(r2)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            okio.BufferedSource r2 = okio.Okio.buffer(r2)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.io.OutputStream r3 = com.luck.picture.lib.PictureContentResolver.getContentResolverOpenOutputStream(r7, r1)     // Catch:{ Exception -> 0x0085 }
            com.luck.picture.lib.tools.PictureFileUtils.bufferCopy((okio.BufferedSource) r2, (java.io.OutputStream) r3)     // Catch:{ Exception -> 0x0085 }
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r7.config     // Catch:{ Exception -> 0x0085 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0085 }
            r3.cameraPath = r1     // Catch:{ Exception -> 0x0085 }
            goto L_0x0088
        L_0x0085:
            r1 = move-exception
            goto L_0x0098
        L_0x0087:
            r2 = r0
        L_0x0088:
            if (r2 == 0) goto L_0x00b2
            boolean r1 = r2.isOpen()     // Catch:{ Exception -> 0x000c }
            if (r1 == 0) goto L_0x00b2
        L_0x0090:
            com.luck.picture.lib.tools.PictureFileUtils.close(r2)     // Catch:{ Exception -> 0x000c }
            goto L_0x00b2
        L_0x0094:
            r8 = move-exception
            goto L_0x00a6
        L_0x0096:
            r1 = move-exception
            r2 = r0
        L_0x0098:
            r1.printStackTrace()     // Catch:{ all -> 0x00a4 }
            if (r2 == 0) goto L_0x00b2
            boolean r1 = r2.isOpen()     // Catch:{ Exception -> 0x000c }
            if (r1 == 0) goto L_0x00b2
            goto L_0x0090
        L_0x00a4:
            r8 = move-exception
            r0 = r2
        L_0x00a6:
            if (r0 == 0) goto L_0x00b1
            boolean r1 = r0.isOpen()     // Catch:{ Exception -> 0x000c }
            if (r1 == 0) goto L_0x00b1
            com.luck.picture.lib.tools.PictureFileUtils.close(r0)     // Catch:{ Exception -> 0x000c }
        L_0x00b1:
            throw r8     // Catch:{ Exception -> 0x000c }
        L_0x00b2:
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r1 = r1.cameraPath     // Catch:{ Exception -> 0x000c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x000c }
            if (r1 == 0) goto L_0x00bd
            return
        L_0x00bd:
            com.luck.picture.lib.entity.LocalMedia r1 = new com.luck.picture.lib.entity.LocalMedia     // Catch:{ Exception -> 0x000c }
            r1.<init>()     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r2 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r2 = r2.cameraPath     // Catch:{ Exception -> 0x000c }
            boolean r2 = com.luck.picture.lib.config.PictureMimeType.isContent(r2)     // Catch:{ Exception -> 0x000c }
            if (r2 == 0) goto L_0x0189
            android.content.Context r2 = r7.getContext()     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r3 = r3.cameraPath     // Catch:{ Exception -> 0x000c }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x000c }
            java.lang.String r2 = com.luck.picture.lib.tools.PictureFileUtils.getPath(r2, r3)     // Catch:{ Exception -> 0x000c }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x000c }
            r3.<init>(r2)     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r4 = r7.config     // Catch:{ Exception -> 0x000c }
            int r4 = r4.cameraMimeType     // Catch:{ Exception -> 0x000c }
            java.lang.String r4 = com.luck.picture.lib.config.PictureMimeType.getImageMimeType(r2, r4)     // Catch:{ Exception -> 0x000c }
            long r5 = r3.length()     // Catch:{ Exception -> 0x000c }
            r1.setSize(r5)     // Catch:{ Exception -> 0x000c }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x000c }
            r1.setFileName(r3)     // Catch:{ Exception -> 0x000c }
            boolean r3 = com.luck.picture.lib.config.PictureMimeType.isHasImage(r4)     // Catch:{ Exception -> 0x000c }
            if (r3 == 0) goto L_0x0118
            android.content.Context r3 = r7.getContext()     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r5 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r5 = r5.cameraPath     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.entity.MediaExtraInfo r3 = com.luck.picture.lib.tools.MediaUtils.getImageSize(r3, r5)     // Catch:{ Exception -> 0x000c }
            int r5 = r3.getWidth()     // Catch:{ Exception -> 0x000c }
            r1.setWidth(r5)     // Catch:{ Exception -> 0x000c }
            int r3 = r3.getHeight()     // Catch:{ Exception -> 0x000c }
            r1.setHeight(r3)     // Catch:{ Exception -> 0x000c }
            goto L_0x0159
        L_0x0118:
            boolean r3 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r4)     // Catch:{ Exception -> 0x000c }
            if (r3 == 0) goto L_0x0140
            android.content.Context r3 = r7.getContext()     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r5 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r5 = r5.cameraPath     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.entity.MediaExtraInfo r3 = com.luck.picture.lib.tools.MediaUtils.getVideoSize(r3, r5)     // Catch:{ Exception -> 0x000c }
            int r5 = r3.getWidth()     // Catch:{ Exception -> 0x000c }
            r1.setWidth(r5)     // Catch:{ Exception -> 0x000c }
            int r5 = r3.getHeight()     // Catch:{ Exception -> 0x000c }
            r1.setHeight(r5)     // Catch:{ Exception -> 0x000c }
            long r5 = r3.getDuration()     // Catch:{ Exception -> 0x000c }
            r1.setDuration(r5)     // Catch:{ Exception -> 0x000c }
            goto L_0x0159
        L_0x0140:
            boolean r3 = com.luck.picture.lib.config.PictureMimeType.isHasAudio(r4)     // Catch:{ Exception -> 0x000c }
            if (r3 == 0) goto L_0x0159
            android.content.Context r3 = r7.getContext()     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r5 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r5 = r5.cameraPath     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.entity.MediaExtraInfo r3 = com.luck.picture.lib.tools.MediaUtils.getAudioSize(r3, r5)     // Catch:{ Exception -> 0x000c }
            long r5 = r3.getDuration()     // Catch:{ Exception -> 0x000c }
            r1.setDuration(r5)     // Catch:{ Exception -> 0x000c }
        L_0x0159:
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r3 = r3.cameraPath     // Catch:{ Exception -> 0x000c }
            java.lang.String r5 = "/"
            int r3 = r3.lastIndexOf(r5)     // Catch:{ Exception -> 0x000c }
            int r3 = r3 + 1
            if (r3 <= 0) goto L_0x0174
            com.luck.picture.lib.config.PictureSelectionConfig r5 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r5 = r5.cameraPath     // Catch:{ Exception -> 0x000c }
            java.lang.String r3 = r5.substring(r3)     // Catch:{ Exception -> 0x000c }
            long r5 = com.luck.picture.lib.tools.ValueOf.toLong(r3)     // Catch:{ Exception -> 0x000c }
            goto L_0x0176
        L_0x0174:
            r5 = -1
        L_0x0176:
            r1.setId(r5)     // Catch:{ Exception -> 0x000c }
            r1.setRealPath(r2)     // Catch:{ Exception -> 0x000c }
            if (r8 == 0) goto L_0x0184
            java.lang.String r0 = "mediaPath"
            java.lang.String r0 = r8.getStringExtra(r0)     // Catch:{ Exception -> 0x000c }
        L_0x0184:
            r1.setAndroidQToPath(r0)     // Catch:{ Exception -> 0x000c }
            goto L_0x022b
        L_0x0189:
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r0 = r0.cameraPath     // Catch:{ Exception -> 0x000c }
            r8.<init>(r0)     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r0 = r0.cameraPath     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r2 = r7.config     // Catch:{ Exception -> 0x000c }
            int r2 = r2.cameraMimeType     // Catch:{ Exception -> 0x000c }
            java.lang.String r4 = com.luck.picture.lib.config.PictureMimeType.getImageMimeType(r0, r2)     // Catch:{ Exception -> 0x000c }
            long r2 = r8.length()     // Catch:{ Exception -> 0x000c }
            r1.setSize(r2)     // Catch:{ Exception -> 0x000c }
            java.lang.String r8 = r8.getName()     // Catch:{ Exception -> 0x000c }
            r1.setFileName(r8)     // Catch:{ Exception -> 0x000c }
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isHasImage(r4)     // Catch:{ Exception -> 0x000c }
            if (r8 == 0) goto L_0x01dc
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r7.config     // Catch:{ Exception -> 0x000c }
            boolean r0 = r0.isCameraRotateImage     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r2 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r2 = r2.cameraPath     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.tools.BitmapUtils.rotateImage(r8, r0, r2)     // Catch:{ Exception -> 0x000c }
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r0 = r0.cameraPath     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.entity.MediaExtraInfo r8 = com.luck.picture.lib.tools.MediaUtils.getImageSize(r8, r0)     // Catch:{ Exception -> 0x000c }
            int r0 = r8.getWidth()     // Catch:{ Exception -> 0x000c }
            r1.setWidth(r0)     // Catch:{ Exception -> 0x000c }
            int r8 = r8.getHeight()     // Catch:{ Exception -> 0x000c }
            r1.setHeight(r8)     // Catch:{ Exception -> 0x000c }
            goto L_0x021d
        L_0x01dc:
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r4)     // Catch:{ Exception -> 0x000c }
            if (r8 == 0) goto L_0x0204
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r0 = r0.cameraPath     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.entity.MediaExtraInfo r8 = com.luck.picture.lib.tools.MediaUtils.getVideoSize(r8, r0)     // Catch:{ Exception -> 0x000c }
            int r0 = r8.getWidth()     // Catch:{ Exception -> 0x000c }
            r1.setWidth(r0)     // Catch:{ Exception -> 0x000c }
            int r0 = r8.getHeight()     // Catch:{ Exception -> 0x000c }
            r1.setHeight(r0)     // Catch:{ Exception -> 0x000c }
            long r2 = r8.getDuration()     // Catch:{ Exception -> 0x000c }
            r1.setDuration(r2)     // Catch:{ Exception -> 0x000c }
            goto L_0x021d
        L_0x0204:
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isHasAudio(r4)     // Catch:{ Exception -> 0x000c }
            if (r8 == 0) goto L_0x021d
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r0 = r0.cameraPath     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.entity.MediaExtraInfo r8 = com.luck.picture.lib.tools.MediaUtils.getAudioSize(r8, r0)     // Catch:{ Exception -> 0x000c }
            long r2 = r8.getDuration()     // Catch:{ Exception -> 0x000c }
            r1.setDuration(r2)     // Catch:{ Exception -> 0x000c }
        L_0x021d:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x000c }
            r1.setId(r2)     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r8 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r8 = r8.cameraPath     // Catch:{ Exception -> 0x000c }
            r1.setRealPath(r8)     // Catch:{ Exception -> 0x000c }
        L_0x022b:
            com.luck.picture.lib.config.PictureSelectionConfig r8 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r8 = r8.cameraPath     // Catch:{ Exception -> 0x000c }
            r1.setPath(r8)     // Catch:{ Exception -> 0x000c }
            r1.setMimeType(r4)     // Catch:{ Exception -> 0x000c }
            boolean r8 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_Q()     // Catch:{ Exception -> 0x000c }
            if (r8 == 0) goto L_0x024b
            java.lang.String r8 = r1.getMimeType()     // Catch:{ Exception -> 0x000c }
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r8)     // Catch:{ Exception -> 0x000c }
            if (r8 == 0) goto L_0x024b
            java.lang.String r8 = android.os.Environment.DIRECTORY_MOVIES     // Catch:{ Exception -> 0x000c }
            r1.setParentFolderName(r8)     // Catch:{ Exception -> 0x000c }
            goto L_0x0250
        L_0x024b:
            java.lang.String r8 = "Camera"
            r1.setParentFolderName(r8)     // Catch:{ Exception -> 0x000c }
        L_0x0250:
            com.luck.picture.lib.config.PictureSelectionConfig r8 = r7.config     // Catch:{ Exception -> 0x000c }
            int r8 = r8.chooseMode     // Catch:{ Exception -> 0x000c }
            r1.setChooseModel(r8)     // Catch:{ Exception -> 0x000c }
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x000c }
            long r2 = com.luck.picture.lib.tools.MediaUtils.getCameraFirstBucketId(r8)     // Catch:{ Exception -> 0x000c }
            r1.setBucketId(r2)     // Catch:{ Exception -> 0x000c }
            long r2 = com.luck.picture.lib.tools.DateUtils.getCurrentTimeMillis()     // Catch:{ Exception -> 0x000c }
            r1.setDateAddedTime(r2)     // Catch:{ Exception -> 0x000c }
            r7.notifyAdapterData(r1)     // Catch:{ Exception -> 0x000c }
            boolean r8 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_Q()     // Catch:{ Exception -> 0x000c }
            java.lang.String r0 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            if (r8 == 0) goto L_0x02b2
            java.lang.String r8 = r1.getMimeType()     // Catch:{ Exception -> 0x000c }
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r8)     // Catch:{ Exception -> 0x000c }
            if (r8 == 0) goto L_0x02fb
            com.luck.picture.lib.config.PictureSelectionConfig r8 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r8 = r8.cameraPath     // Catch:{ Exception -> 0x000c }
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isContent(r8)     // Catch:{ Exception -> 0x000c }
            if (r8 == 0) goto L_0x02fb
            com.luck.picture.lib.config.PictureSelectionConfig r8 = r7.config     // Catch:{ Exception -> 0x000c }
            boolean r8 = r8.isFallbackVersion3     // Catch:{ Exception -> 0x000c }
            if (r8 == 0) goto L_0x029c
            com.luck.picture.lib.PictureMediaScannerConnection r8 = new com.luck.picture.lib.PictureMediaScannerConnection     // Catch:{ Exception -> 0x000c }
            android.content.Context r0 = r7.getContext()     // Catch:{ Exception -> 0x000c }
            java.lang.String r1 = r1.getRealPath()     // Catch:{ Exception -> 0x000c }
            r8.<init>(r0, r1)     // Catch:{ Exception -> 0x000c }
            goto L_0x02fb
        L_0x029c:
            android.content.Intent r8 = new android.content.Intent     // Catch:{ Exception -> 0x000c }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x000c }
            java.lang.String r1 = r1.getRealPath()     // Catch:{ Exception -> 0x000c }
            r2.<init>(r1)     // Catch:{ Exception -> 0x000c }
            android.net.Uri r1 = android.net.Uri.fromFile(r2)     // Catch:{ Exception -> 0x000c }
            r8.<init>(r0, r1)     // Catch:{ Exception -> 0x000c }
            r7.sendBroadcast(r8)     // Catch:{ Exception -> 0x000c }
            goto L_0x02fb
        L_0x02b2:
            com.luck.picture.lib.config.PictureSelectionConfig r8 = r7.config     // Catch:{ Exception -> 0x000c }
            boolean r8 = r8.isFallbackVersion3     // Catch:{ Exception -> 0x000c }
            if (r8 == 0) goto L_0x02c6
            com.luck.picture.lib.PictureMediaScannerConnection r8 = new com.luck.picture.lib.PictureMediaScannerConnection     // Catch:{ Exception -> 0x000c }
            android.content.Context r0 = r7.getContext()     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r2 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r2 = r2.cameraPath     // Catch:{ Exception -> 0x000c }
            r8.<init>(r0, r2)     // Catch:{ Exception -> 0x000c }
            goto L_0x02db
        L_0x02c6:
            android.content.Intent r8 = new android.content.Intent     // Catch:{ Exception -> 0x000c }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r7.config     // Catch:{ Exception -> 0x000c }
            java.lang.String r3 = r3.cameraPath     // Catch:{ Exception -> 0x000c }
            r2.<init>(r3)     // Catch:{ Exception -> 0x000c }
            android.net.Uri r2 = android.net.Uri.fromFile(r2)     // Catch:{ Exception -> 0x000c }
            r8.<init>(r0, r2)     // Catch:{ Exception -> 0x000c }
            r7.sendBroadcast(r8)     // Catch:{ Exception -> 0x000c }
        L_0x02db:
            java.lang.String r8 = r1.getMimeType()     // Catch:{ Exception -> 0x000c }
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isHasImage(r8)     // Catch:{ Exception -> 0x000c }
            if (r8 == 0) goto L_0x02fb
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x000c }
            int r8 = com.luck.picture.lib.tools.MediaUtils.getDCIMLastImageId(r8)     // Catch:{ Exception -> 0x000c }
            r0 = -1
            if (r8 == r0) goto L_0x02fb
            android.content.Context r0 = r7.getContext()     // Catch:{ Exception -> 0x000c }
            com.luck.picture.lib.tools.MediaUtils.removeMedia(r0, r8)     // Catch:{ Exception -> 0x000c }
            goto L_0x02fb
        L_0x02f8:
            r8.printStackTrace()
        L_0x02fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorActivity.dispatchHandleCamera(android.content.Intent):void");
    }

    private void notifyAdapterData(LocalMedia localMedia) {
        if (this.mAdapter != null) {
            if (!isAddSameImp(this.folderWindow.getFolder(0) != null ? this.folderWindow.getFolder(0).getImageNum() : 0)) {
                this.mAdapter.getData().add(0, localMedia);
                this.mOpenCameraCount++;
            }
            if (checkVideoLegitimacy(localMedia)) {
                if (this.config.selectionMode == 1) {
                    dispatchHandleSingle(localMedia);
                } else {
                    dispatchHandleMultiple(localMedia);
                }
            }
            this.mAdapter.notifyItemInserted(this.config.isCamera ? 1 : 0);
            this.mAdapter.notifyItemRangeChanged(this.config.isCamera ? 1 : 0, this.mAdapter.getSize());
            if (this.config.isPageStrategy) {
                manualSaveFolderForPageModel(localMedia);
            } else {
                manualSaveFolder(localMedia);
            }
            this.mTvEmpty.setVisibility((this.mAdapter.getSize() > 0 || this.config.isSingleDirectReturn) ? 8 : 0);
            if (this.folderWindow.getFolder(0) != null) {
                this.mTvPictureTitle.setTag(R.id.view_count_tag, Integer.valueOf(this.folderWindow.getFolder(0).getImageNum()));
            }
            this.allFolderSize = 0;
        }
    }

    private void dispatchHandleMultiple(LocalMedia localMedia) {
        List<LocalMedia> selectedData = this.mAdapter.getSelectedData();
        int size = selectedData.size();
        String mimeType = size > 0 ? selectedData.get(0).getMimeType() : "";
        boolean isMimeTypeSame = PictureMimeType.isMimeTypeSame(mimeType, localMedia.getMimeType());
        if (this.config.isWithVideoImage) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (PictureMimeType.isHasVideo(selectedData.get(i2).getMimeType())) {
                    i++;
                }
            }
            if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                if (this.config.maxVideoSelectNum <= 0) {
                    showPromptDialog(getString(R.string.picture_rule));
                } else if (i >= this.config.maxVideoSelectNum) {
                    showPromptDialog(getString(R.string.picture_message_max_num, new Object[]{Integer.valueOf(this.config.maxVideoSelectNum)}));
                } else {
                    selectedData.add(localMedia);
                    this.mAdapter.bindSelectData(selectedData);
                }
            } else if (selectedData.size() < this.config.maxSelectNum) {
                selectedData.add(localMedia);
                this.mAdapter.bindSelectData(selectedData);
            } else {
                showPromptDialog(StringUtils.getMsg(getContext(), localMedia.getMimeType(), this.config.maxSelectNum));
            }
        } else if (!PictureMimeType.isHasVideo(mimeType) || this.config.maxVideoSelectNum <= 0) {
            if (size >= this.config.maxSelectNum) {
                showPromptDialog(StringUtils.getMsg(getContext(), mimeType, this.config.maxSelectNum));
            } else if (isMimeTypeSame || size == 0) {
                selectedData.add(localMedia);
                this.mAdapter.bindSelectData(selectedData);
            }
        } else if (size >= this.config.maxVideoSelectNum) {
            showPromptDialog(StringUtils.getMsg(getContext(), mimeType, this.config.maxVideoSelectNum));
        } else if ((isMimeTypeSame || size == 0) && selectedData.size() < this.config.maxVideoSelectNum) {
            selectedData.add(localMedia);
            this.mAdapter.bindSelectData(selectedData);
        }
    }

    private void dispatchHandleSingle(LocalMedia localMedia) {
        List<LocalMedia> selectedData = this.mAdapter.getSelectedData();
        if (this.config.isSingleDirectReturn) {
            selectedData.add(localMedia);
            this.mAdapter.bindSelectData(selectedData);
            singleDirectReturnCameraHandleResult(localMedia.getMimeType());
            return;
        }
        if (PictureMimeType.isMimeTypeSame(selectedData.size() > 0 ? selectedData.get(0).getMimeType() : "", localMedia.getMimeType()) || selectedData.size() == 0) {
            singleRadioMediaImage();
            selectedData.add(localMedia);
            this.mAdapter.bindSelectData(selectedData);
        }
    }

    private boolean checkVideoLegitimacy(LocalMedia localMedia) {
        if (!PictureMimeType.isHasVideo(localMedia.getMimeType())) {
            return true;
        }
        if (this.config.videoMinSecond <= 0 || this.config.videoMaxSecond <= 0) {
            if (this.config.videoMinSecond > 0) {
                if (localMedia.getDuration() >= ((long) this.config.videoMinSecond)) {
                    return true;
                }
                showPromptDialog(getString(R.string.picture_choose_min_seconds, new Object[]{Integer.valueOf(this.config.videoMinSecond / ResultCode.KARAOKE_SUCCESS)}));
            } else if (this.config.videoMaxSecond <= 0 || localMedia.getDuration() <= ((long) this.config.videoMaxSecond)) {
                return true;
            } else {
                showPromptDialog(getString(R.string.picture_choose_max_seconds, new Object[]{Integer.valueOf(this.config.videoMaxSecond / ResultCode.KARAOKE_SUCCESS)}));
            }
        } else if (localMedia.getDuration() >= ((long) this.config.videoMinSecond) && localMedia.getDuration() <= ((long) this.config.videoMaxSecond)) {
            return true;
        } else {
            showPromptDialog(getString(R.string.picture_choose_limit_seconds, new Object[]{Integer.valueOf(this.config.videoMinSecond / ResultCode.KARAOKE_SUCCESS), Integer.valueOf(this.config.videoMaxSecond / ResultCode.KARAOKE_SUCCESS)}));
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.luck.picture.lib.entity.LocalMedia} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void singleCropHandleResult(android.content.Intent r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            android.net.Uri r0 = com.yalantis.ucrop.UCrop.getOutput(r7)
            if (r0 != 0) goto L_0x000a
            return
        L_0x000a:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r0 = r0.getPath()
            com.luck.picture.lib.adapter.PictureImageGridAdapter r2 = r6.mAdapter
            if (r2 == 0) goto L_0x00bd
            java.lang.String r2 = "selectList"
            java.util.ArrayList r7 = r7.getParcelableArrayListExtra(r2)
            if (r7 == 0) goto L_0x0029
            com.luck.picture.lib.adapter.PictureImageGridAdapter r2 = r6.mAdapter
            r2.bindSelectData(r7)
            com.luck.picture.lib.adapter.PictureImageGridAdapter r2 = r6.mAdapter
            r2.notifyDataSetChanged()
        L_0x0029:
            com.luck.picture.lib.adapter.PictureImageGridAdapter r2 = r6.mAdapter
            java.util.List r2 = r2.getSelectedData()
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x0040
            int r5 = r2.size()
            if (r5 <= 0) goto L_0x0040
            java.lang.Object r2 = r2.get(r3)
            com.luck.picture.lib.entity.LocalMedia r2 = (com.luck.picture.lib.entity.LocalMedia) r2
            goto L_0x0041
        L_0x0040:
            r2 = r4
        L_0x0041:
            if (r2 == 0) goto L_0x0078
            com.luck.picture.lib.config.PictureSelectionConfig r7 = r6.config
            java.lang.String r3 = r2.getPath()
            r7.originalPath = r3
            r2.setCutPath(r0)
            com.luck.picture.lib.config.PictureSelectionConfig r7 = r6.config
            int r7 = r7.chooseMode
            r2.setChooseModel(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            r7 = r7 ^ 1
            boolean r3 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_Q()
            if (r3 == 0) goto L_0x006e
            java.lang.String r3 = r2.getPath()
            boolean r3 = com.luck.picture.lib.config.PictureMimeType.isContent(r3)
            if (r3 == 0) goto L_0x006e
            r2.setAndroidQToPath(r0)
        L_0x006e:
            r2.setCut(r7)
            r1.add(r2)
            r6.handlerResult(r1)
            goto L_0x00bd
        L_0x0078:
            if (r7 == 0) goto L_0x0087
            int r2 = r7.size()
            if (r2 <= 0) goto L_0x0087
            java.lang.Object r7 = r7.get(r3)
            r4 = r7
            com.luck.picture.lib.entity.LocalMedia r4 = (com.luck.picture.lib.entity.LocalMedia) r4
        L_0x0087:
            if (r4 == 0) goto L_0x00bd
            com.luck.picture.lib.config.PictureSelectionConfig r7 = r6.config
            java.lang.String r2 = r4.getPath()
            r7.originalPath = r2
            r4.setCutPath(r0)
            com.luck.picture.lib.config.PictureSelectionConfig r7 = r6.config
            int r7 = r7.chooseMode
            r4.setChooseModel(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            r7 = r7 ^ 1
            boolean r2 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_Q()
            if (r2 == 0) goto L_0x00b4
            java.lang.String r2 = r4.getPath()
            boolean r2 = com.luck.picture.lib.config.PictureMimeType.isContent(r2)
            if (r2 == 0) goto L_0x00b4
            r4.setAndroidQToPath(r0)
        L_0x00b4:
            r4.setCut(r7)
            r1.add(r4)
            r6.handlerResult(r1)
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorActivity.singleCropHandleResult(android.content.Intent):void");
    }

    /* access modifiers changed from: protected */
    public void multiCropHandleResult(Intent intent) {
        ArrayList multipleOutput;
        if (intent != null && (multipleOutput = UCrop.getMultipleOutput(intent)) != null && multipleOutput.size() > 0) {
            this.mAdapter.bindSelectData(multipleOutput);
            this.mAdapter.notifyDataSetChanged();
            handlerResult(multipleOutput);
        }
    }

    private void singleRadioMediaImage() {
        List<LocalMedia> selectedData = this.mAdapter.getSelectedData();
        if (selectedData != null && selectedData.size() > 0) {
            int position = selectedData.get(0).getPosition();
            selectedData.clear();
            this.mAdapter.notifyItemChanged(position);
        }
    }

    private void manualSaveFolderForPageModel(LocalMedia localMedia) {
        int i;
        if (localMedia != null) {
            int size = this.folderWindow.getFolderData().size();
            boolean z = false;
            LocalMediaFolder localMediaFolder = size > 0 ? this.folderWindow.getFolderData().get(0) : new LocalMediaFolder();
            if (localMediaFolder != null) {
                int imageNum = localMediaFolder.getImageNum();
                localMediaFolder.setFirstImagePath(localMedia.getPath());
                localMediaFolder.setFirstMimeType(localMedia.getMimeType());
                localMediaFolder.setImageNum(isAddSameImp(imageNum) ? localMediaFolder.getImageNum() : localMediaFolder.getImageNum() + 1);
                if (size == 0) {
                    if (this.config.chooseMode == PictureMimeType.ofAudio()) {
                        i = R.string.picture_all_audio;
                    } else {
                        i = R.string.picture_camera_roll;
                    }
                    localMediaFolder.setName(getString(i));
                    localMediaFolder.setOfAllType(this.config.chooseMode);
                    localMediaFolder.setCameraFolder(true);
                    localMediaFolder.setChecked(true);
                    localMediaFolder.setBucketId(-1);
                    this.folderWindow.getFolderData().add(0, localMediaFolder);
                    LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
                    localMediaFolder2.setName(localMedia.getParentFolderName());
                    localMediaFolder2.setImageNum(isAddSameImp(imageNum) ? localMediaFolder2.getImageNum() : localMediaFolder2.getImageNum() + 1);
                    localMediaFolder2.setFirstImagePath(localMedia.getPath());
                    localMediaFolder2.setFirstMimeType(localMedia.getMimeType());
                    localMediaFolder2.setBucketId(localMedia.getBucketId());
                    this.folderWindow.getFolderData().add(this.folderWindow.getFolderData().size(), localMediaFolder2);
                } else {
                    String str = (!SdkVersionUtils.checkedAndroid_Q() || !PictureMimeType.isHasVideo(localMedia.getMimeType())) ? PictureMimeType.CAMERA : Environment.DIRECTORY_MOVIES;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        LocalMediaFolder localMediaFolder3 = this.folderWindow.getFolderData().get(i2);
                        if (TextUtils.isEmpty(localMediaFolder3.getName()) || !localMediaFolder3.getName().startsWith(str)) {
                            i2++;
                        } else {
                            localMedia.setBucketId(localMediaFolder3.getBucketId());
                            localMediaFolder3.setFirstImagePath(this.config.cameraPath);
                            localMediaFolder3.setFirstMimeType(localMedia.getMimeType());
                            localMediaFolder3.setImageNum(isAddSameImp(imageNum) ? localMediaFolder3.getImageNum() : localMediaFolder3.getImageNum() + 1);
                            if (localMediaFolder3.getData() != null && localMediaFolder3.getData().size() > 0) {
                                localMediaFolder3.getData().add(0, localMedia);
                            }
                            z = true;
                        }
                    }
                    if (!z) {
                        LocalMediaFolder localMediaFolder4 = new LocalMediaFolder();
                        localMediaFolder4.setName(localMedia.getParentFolderName());
                        localMediaFolder4.setImageNum(isAddSameImp(imageNum) ? localMediaFolder4.getImageNum() : localMediaFolder4.getImageNum() + 1);
                        localMediaFolder4.setFirstImagePath(localMedia.getPath());
                        localMediaFolder4.setFirstMimeType(localMedia.getMimeType());
                        localMediaFolder4.setBucketId(localMedia.getBucketId());
                        this.folderWindow.getFolderData().add(localMediaFolder4);
                        sortFolder(this.folderWindow.getFolderData());
                    }
                }
                FolderPopWindow folderPopWindow = this.folderWindow;
                folderPopWindow.bindFolder(folderPopWindow.getFolderData());
            }
        }
    }

    private void manualSaveFolder(LocalMedia localMedia) {
        LocalMediaFolder localMediaFolder;
        try {
            boolean isEmpty = this.folderWindow.isEmpty();
            int imageNum = this.folderWindow.getFolder(0) != null ? this.folderWindow.getFolder(0).getImageNum() : 0;
            if (isEmpty) {
                createNewFolder(this.folderWindow.getFolderData());
                localMediaFolder = this.folderWindow.getFolderData().size() > 0 ? this.folderWindow.getFolderData().get(0) : null;
                if (localMediaFolder == null) {
                    localMediaFolder = new LocalMediaFolder();
                    this.folderWindow.getFolderData().add(0, localMediaFolder);
                }
            } else {
                localMediaFolder = this.folderWindow.getFolderData().get(0);
            }
            localMediaFolder.setFirstImagePath(localMedia.getPath());
            localMediaFolder.setFirstMimeType(localMedia.getMimeType());
            localMediaFolder.setData(this.mAdapter.getData());
            localMediaFolder.setBucketId(-1);
            localMediaFolder.setImageNum(isAddSameImp(imageNum) ? localMediaFolder.getImageNum() : localMediaFolder.getImageNum() + 1);
            LocalMediaFolder imageFolder = getImageFolder(localMedia.getPath(), localMedia.getRealPath(), localMedia.getMimeType(), this.folderWindow.getFolderData());
            if (imageFolder != null) {
                imageFolder.setImageNum(isAddSameImp(imageNum) ? imageFolder.getImageNum() : imageFolder.getImageNum() + 1);
                if (!isAddSameImp(imageNum)) {
                    imageFolder.getData().add(0, localMedia);
                }
                imageFolder.setBucketId(localMedia.getBucketId());
                imageFolder.setFirstImagePath(this.config.cameraPath);
                imageFolder.setFirstMimeType(localMedia.getMimeType());
            }
            FolderPopWindow folderPopWindow = this.folderWindow;
            folderPopWindow.bindFolder(folderPopWindow.getFolderData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r1 = r2.allFolderSize;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isAddSameImp(int r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r2.allFolderSize
            if (r1 <= 0) goto L_0x000b
            if (r1 >= r3) goto L_0x000b
            r0 = 1
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorActivity.isAddSameImp(int):boolean");
    }

    private void updateMediaFolder(List<LocalMediaFolder> list, LocalMedia localMedia) {
        File parentFile = new File(localMedia.getRealPath()).getParentFile();
        if (parentFile != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                LocalMediaFolder localMediaFolder = list.get(i);
                String name = localMediaFolder.getName();
                if (!TextUtils.isEmpty(name) && name.equals(parentFile.getName())) {
                    localMediaFolder.setFirstImagePath(this.config.cameraPath);
                    localMediaFolder.setImageNum(localMediaFolder.getImageNum() + 1);
                    localMediaFolder.setCheckedNum(1);
                    localMediaFolder.getData().add(0, localMedia);
                    return;
                }
            }
        }
    }

    public void onBackPressed() {
        if (SdkVersionUtils.checkedAndroid_Q()) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        if (PictureSelectionConfig.listener != null) {
            PictureSelectionConfig.listener.onCancel();
        }
        exit();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Animation animation2 = this.animation;
        if (animation2 != null) {
            animation2.cancel();
            this.animation = null;
        }
        if (this.mediaPlayer != null) {
            this.mHandler.removeCallbacks(this.mRunnable);
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    public void onItemClick(View view, int i) {
        if (i != 0) {
            if (i == 1) {
                if (PictureSelectionConfig.onCustomCameraInterfaceListener != null) {
                    PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(getContext(), this.config, 1);
                    this.config.cameraMimeType = PictureMimeType.ofVideo();
                    return;
                }
                startOpenCameraVideo();
            }
        } else if (PictureSelectionConfig.onCustomCameraInterfaceListener != null) {
            PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(getContext(), this.config, 1);
            this.config.cameraMimeType = PictureMimeType.ofImage();
        } else {
            startOpenCameraImage();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorActivity, com.luck.picture.lib.PictureBaseActivity] */
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        boolean z = true;
        if (i == 1) {
            int i2 = 0;
            while (true) {
                if (i2 >= iArr.length) {
                    break;
                } else if (iArr[i2] != 0) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                readLocalMedia();
            } else {
                showPermissionsDialog(false, PermissionConfig.getReadWritePermissionArray(this), getString(R.string.picture_jurisdiction));
            }
        } else if (i != 2) {
            if (i != 4) {
                if (i == 5) {
                    if (iArr.length <= 0 || iArr[0] != 0) {
                        showPermissionsDialog(false, PermissionConfig.getReadWritePermissionArray(this), getString(R.string.picture_jurisdiction));
                    } else {
                        startCamera();
                    }
                }
            } else if (iArr.length <= 0 || iArr[0] != 0) {
                showPermissionsDialog(false, new String[]{"android.permission.RECORD_AUDIO"}, getString(R.string.picture_audio));
            } else {
                startCustomCamera();
            }
        } else if (iArr.length <= 0 || iArr[0] != 0) {
            showPermissionsDialog(true, new String[]{"android.permission.CAMERA"}, getString(R.string.picture_camera));
        } else {
            onTakePhoto();
        }
    }

    /* access modifiers changed from: protected */
    public void showPermissionsDialog(boolean z, String[] strArr, String str) {
        if (!isFinishing()) {
            if (PictureSelectionConfig.onPermissionsObtainCallback != null) {
                PictureSelectionConfig.onPermissionsObtainCallback.onPermissionsIntercept(getContext(), z, strArr, str, new OnPermissionDialogOptionCallback() {
                    public void onCancel() {
                        if (PictureSelectionConfig.listener != null) {
                            PictureSelectionConfig.listener.onCancel();
                        }
                        PictureSelectorActivity.this.exit();
                    }

                    public void onSetting() {
                        PictureSelectorActivity.this.isEnterSetting = true;
                    }
                });
                return;
            }
            PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(getContext(), R.layout.picture_wind_base_dialog);
            pictureCustomDialog.setCancelable(false);
            pictureCustomDialog.setCanceledOnTouchOutside(false);
            Button button = (Button) pictureCustomDialog.findViewById(R.id.btn_commit);
            button.setText(getString(R.string.picture_go_setting));
            ((TextView) pictureCustomDialog.findViewById(R.id.tvTitle)).setText(getString(R.string.picture_prompt));
            ((TextView) pictureCustomDialog.findViewById(R.id.tv_content)).setText(str);
            ((Button) pictureCustomDialog.findViewById(R.id.btn_cancel)).setOnClickListener(new PictureSelectorActivity$$ExternalSyntheticLambda2(this, pictureCustomDialog, z));
            button.setOnClickListener(new PictureSelectorActivity$$ExternalSyntheticLambda1(this, pictureCustomDialog));
            pictureCustomDialog.show();
        }
    }

    public /* synthetic */ void lambda$showPermissionsDialog$6$PictureSelectorActivity(PictureCustomDialog pictureCustomDialog, boolean z, View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        if (!z) {
            if (PictureSelectionConfig.listener != null) {
                PictureSelectionConfig.listener.onCancel();
            }
            exit();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$showPermissionsDialog$7$PictureSelectorActivity(PictureCustomDialog pictureCustomDialog, View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        PermissionChecker.launchAppDetailsSettings(getContext());
        this.isEnterSetting = true;
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void showDataNull(String str, int i) {
        if (this.mTvEmpty.getVisibility() == 8 || this.mTvEmpty.getVisibility() == 4) {
            this.mTvEmpty.setCompoundDrawablesRelativeWithIntrinsicBounds(0, i, 0, 0);
            this.mTvEmpty.setText(str);
            this.mTvEmpty.setVisibility(0);
        }
    }

    private void hideDataNull() {
        if (this.mTvEmpty.getVisibility() == 0) {
            this.mTvEmpty.setVisibility(8);
        }
    }
}
