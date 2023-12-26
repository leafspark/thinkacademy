package com.yalantis.ucrop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.ScreenUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.yalantis.ucrop.PicturePhotoGalleryAdapter;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class PictureMultiCuttingActivity extends UCropActivity {
    private static final int MIN_NUM = 1;
    /* access modifiers changed from: private */
    public int cutIndex;
    private boolean isAnimation;
    private boolean isCamera;
    private boolean isWithVideoImage;
    /* access modifiers changed from: private */
    public final ArrayList<LocalMedia> list = new ArrayList<>();
    private PicturePhotoGalleryAdapter mAdapter;
    private RecyclerView mRecyclerView;
    /* access modifiers changed from: private */
    public int oldCutIndex;
    private String renameCropFilename;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.renameCropFilename = intent.getStringExtra(UCrop.Options.EXTRA_RENAME_CROP_FILENAME);
        this.isCamera = intent.getBooleanExtra(UCrop.Options.EXTRA_CAMERA, false);
        this.isWithVideoImage = intent.getBooleanExtra(UCrop.Options.EXTRA_WITH_VIDEO_IMAGE, false);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(UCrop.Options.EXTRA_CUT_CROP);
        this.isAnimation = getIntent().getBooleanExtra(UCrop.Options.EXTRA_MULTIPLE_RECYCLERANIMATION, true);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() == 0) {
            onBackPressed();
            return;
        }
        this.list.addAll(parcelableArrayListExtra);
        if (this.list.size() > 1) {
            initLoadCutData();
            addPhotoRecyclerView();
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [android.content.Context, com.yalantis.ucrop.PictureMultiCuttingActivity] */
    private void addPhotoRecyclerView() {
        boolean booleanExtra = getIntent().getBooleanExtra(UCrop.Options.EXTRA_SKIP_MULTIPLE_CROP, true);
        RecyclerView recyclerView = new RecyclerView(this);
        this.mRecyclerView = recyclerView;
        recyclerView.setId(R.id.id_recycler);
        this.mRecyclerView.setBackgroundColor(ContextCompat.getColor(this, R.color.ucrop_color_widget_background));
        this.mRecyclerView.setLayoutParams(new RelativeLayout.LayoutParams(-1, ScreenUtils.dip2px(this, 80.0f)));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        if (this.isAnimation) {
            this.mRecyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getApplicationContext(), R.anim.ucrop_layout_animation_fall_down));
        }
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        SimpleItemAnimator itemAnimator = this.mRecyclerView.getItemAnimator();
        Objects.requireNonNull(itemAnimator);
        itemAnimator.setSupportsChangeAnimations(false);
        resetCutDataStatus();
        this.list.get(this.cutIndex).setCut(true);
        PicturePhotoGalleryAdapter picturePhotoGalleryAdapter = new PicturePhotoGalleryAdapter(this.list);
        this.mAdapter = picturePhotoGalleryAdapter;
        this.mRecyclerView.setAdapter(picturePhotoGalleryAdapter);
        if (booleanExtra) {
            this.mAdapter.setOnItemClickListener(new PicturePhotoGalleryAdapter.OnItemClickListener() {
                public void onItemClick(int i, View view) {
                    if (!PictureMimeType.isHasVideo(((LocalMedia) PictureMultiCuttingActivity.this.list.get(i)).getMimeType()) && PictureMultiCuttingActivity.this.cutIndex != i) {
                        PictureMultiCuttingActivity.this.resetLastCropStatus();
                        int unused = PictureMultiCuttingActivity.this.cutIndex = i;
                        PictureMultiCuttingActivity pictureMultiCuttingActivity = PictureMultiCuttingActivity.this;
                        int unused2 = pictureMultiCuttingActivity.oldCutIndex = pictureMultiCuttingActivity.cutIndex;
                        PictureMultiCuttingActivity.this.resetCutData();
                    }
                }
            });
        }
        this.uCropPhotoBox.addView(this.mRecyclerView);
        changeLayoutParams(this.mShowBottomControls);
        ((RelativeLayout.LayoutParams) ((FrameLayout) findViewById(R.id.ucrop_frame)).getLayoutParams()).addRule(2, R.id.id_recycler);
        ((RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(2, R.id.controls_wrapper);
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [android.content.Context, com.yalantis.ucrop.PictureMultiCuttingActivity] */
    /* access modifiers changed from: protected */
    public void resetCutData() {
        Uri uri;
        String str;
        this.uCropPhotoBox.removeView(this.mRecyclerView);
        if (this.mBlockingView != null) {
            this.uCropPhotoBox.removeView(this.mBlockingView);
        }
        setContentView(R.layout.ucrop_activity_photobox);
        this.uCropPhotoBox = (RelativeLayout) findViewById(R.id.ucrop_photobox);
        addBlockingView();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        LocalMedia localMedia = this.list.get(this.cutIndex);
        String path = localMedia.getPath();
        boolean isHasHttp = PictureMimeType.isHasHttp(path);
        String lastImgType = PictureMimeType.getLastImgType(PictureMimeType.isContent(path) ? PictureFileUtils.getPath(this, Uri.parse(path)) : path);
        if (!TextUtils.isEmpty(localMedia.getAndroidQToPath())) {
            uri = Uri.fromFile(new File(localMedia.getAndroidQToPath()));
        } else {
            uri = (isHasHttp || PictureMimeType.isContent(path)) ? Uri.parse(path) : Uri.fromFile(new File(path));
        }
        extras.putParcelable(UCrop.EXTRA_INPUT_URI, uri);
        File externalFilesDir = Environment.getExternalStorageState().equals("mounted") ? getExternalFilesDir(Environment.DIRECTORY_PICTURES) : getCacheDir();
        if (TextUtils.isEmpty(this.renameCropFilename)) {
            str = DateUtils.getCreateFileName("IMG_CROP_") + lastImgType;
        } else {
            str = this.isCamera ? this.renameCropFilename : PictureFileUtils.rename(this.renameCropFilename);
        }
        extras.putParcelable(UCrop.EXTRA_OUTPUT_URI, Uri.fromFile(new File(externalFilesDir, str)));
        intent.putExtras(extras);
        setupViews(intent);
        refreshPhotoRecyclerData();
        setImageData(intent);
        setInitialState();
        double dip2px = (double) (this.cutIndex * ScreenUtils.dip2px(this, 60.0f));
        if (dip2px > ((double) this.mScreenWidth) * 0.8d) {
            this.mRecyclerView.scrollBy(ScreenUtils.dip2px(this, 60.0f), 0);
        } else if (dip2px < ((double) this.mScreenWidth) * 0.4d) {
            this.mRecyclerView.scrollBy(ScreenUtils.dip2px(this, -60.0f), 0);
        }
    }

    private void refreshPhotoRecyclerData() {
        resetCutDataStatus();
        this.list.get(this.cutIndex).setCut(true);
        this.mAdapter.notifyItemChanged(this.cutIndex);
        this.uCropPhotoBox.addView(this.mRecyclerView);
        changeLayoutParams(this.mShowBottomControls);
        ((RelativeLayout.LayoutParams) ((FrameLayout) findViewById(R.id.ucrop_frame)).getLayoutParams()).addRule(2, R.id.id_recycler);
        ((RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(2, R.id.controls_wrapper);
    }

    /* access modifiers changed from: private */
    public void resetLastCropStatus() {
        int i;
        int size = this.list.size();
        if (size > 1 && size > (i = this.oldCutIndex)) {
            this.list.get(i).setCut(false);
            this.mAdapter.notifyItemChanged(this.cutIndex);
        }
    }

    private void resetCutDataStatus() {
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.list.get(i).setCut(false);
        }
    }

    private void initLoadCutData() {
        ArrayList<LocalMedia> arrayList = this.list;
        if (arrayList == null || arrayList.size() == 0) {
            onBackPressed();
            return;
        }
        int size = this.list.size();
        if (this.isWithVideoImage) {
            getIndex(size);
        }
    }

    private void getIndex(int i) {
        int i2 = 0;
        while (i2 < i) {
            LocalMedia localMedia = this.list.get(i2);
            if (localMedia == null || !PictureMimeType.isHasImage(localMedia.getMimeType())) {
                i2++;
            } else {
                this.cutIndex = i2;
                return;
            }
        }
    }

    private void changeLayoutParams(boolean z) {
        if (this.mRecyclerView.getLayoutParams() != null) {
            if (z) {
                ((RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(12, 0);
                ((RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(2, R.id.wrapper_controls);
                return;
            }
            ((RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(12);
            ((RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(2, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void setResultUri(Uri uri, float f, int i, int i2, int i3, int i4) {
        try {
            int size = this.list.size();
            int i5 = this.cutIndex;
            if (size < i5) {
                onBackPressed();
                return;
            }
            LocalMedia localMedia = this.list.get(i5);
            localMedia.setCutPath(uri.getPath());
            localMedia.setCut(true);
            localMedia.setCropResultAspectRatio(f);
            localMedia.setCropOffsetX(i);
            localMedia.setCropOffsetY(i2);
            localMedia.setCropImageWidth(i3);
            localMedia.setCropImageHeight(i4);
            localMedia.setAndroidQToPath(SdkVersionUtils.checkedAndroid_Q() ? localMedia.getCutPath() : localMedia.getAndroidQToPath());
            resetLastCropStatus();
            int i6 = this.cutIndex + 1;
            this.cutIndex = i6;
            if (this.isWithVideoImage && i6 < this.list.size() && PictureMimeType.isHasVideo(this.list.get(this.cutIndex).getMimeType())) {
                while (true) {
                    if (this.cutIndex >= this.list.size()) {
                        break;
                    } else if (PictureMimeType.isHasImage(this.list.get(this.cutIndex).getMimeType())) {
                        break;
                    } else {
                        this.cutIndex++;
                    }
                }
            }
            int i7 = this.cutIndex;
            this.oldCutIndex = i7;
            if (i7 >= this.list.size()) {
                for (int i8 = 0; i8 < this.list.size(); i8++) {
                    LocalMedia localMedia2 = this.list.get(i8);
                    localMedia2.setCut(!TextUtils.isEmpty(localMedia2.getCutPath()));
                }
                setResult(-1, new Intent().putExtra(UCrop.Options.EXTRA_OUTPUT_URI_LIST, this.list));
                onBackPressed();
                return;
            }
            resetCutData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        PicturePhotoGalleryAdapter picturePhotoGalleryAdapter = this.mAdapter;
        if (picturePhotoGalleryAdapter != null) {
            picturePhotoGalleryAdapter.setOnItemClickListener((PicturePhotoGalleryAdapter.OnItemClickListener) null);
        }
        super.onDestroy();
    }
}
