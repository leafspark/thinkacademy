package com.luck.picture.lib;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.luck.picture.lib.broadcast.BroadcastAction;
import com.luck.picture.lib.broadcast.BroadcastManager;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.dialog.PictureCustomDialog;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnImageCompleteCallback;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.JumpUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.ScreenUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.luck.picture.lib.widget.PreviewViewPager;
import com.luck.picture.lib.widget.longimage.ImageSource;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import okio.BufferedSource;
import okio.Okio;

public class PictureExternalPreviewActivity extends PictureBaseActivity implements View.OnClickListener {
    private SimpleFragmentAdapter adapter;
    /* access modifiers changed from: private */
    public String downloadPath;
    private ImageButton ibDelete;
    private ImageButton ibLeftBack;
    /* access modifiers changed from: private */
    public final List<LocalMedia> images = new ArrayList();
    /* access modifiers changed from: private */
    public String mMimeType;
    /* access modifiers changed from: private */
    public int mScreenHeight;
    /* access modifiers changed from: private */
    public int mScreenWidth;
    private View mTitleBar;
    /* access modifiers changed from: private */
    public int position = 0;
    /* access modifiers changed from: private */
    public TextView tvTitle;
    private PreviewViewPager viewPager;

    static /* synthetic */ void lambda$onSuccessful$2() {
    }

    public int getResourceId() {
        return R.layout.picture_activity_external_preview;
    }

    /* access modifiers changed from: protected */
    public void initWidgets() {
        super.initWidgets();
        this.mTitleBar = findViewById(R.id.titleBar);
        this.tvTitle = (TextView) findViewById(R.id.picture_title);
        this.ibLeftBack = (ImageButton) findViewById(R.id.left_back);
        this.ibDelete = (ImageButton) findViewById(R.id.ib_delete);
        this.viewPager = (PreviewViewPager) findViewById(R.id.preview_pager);
        int i = 0;
        this.position = getIntent().getIntExtra("position", 0);
        this.mScreenWidth = ScreenUtils.getScreenWidth(getContext());
        this.mScreenHeight = ScreenUtils.getScreenHeight(getContext());
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(PictureConfig.EXTRA_PREVIEW_SELECT_LIST);
        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
            this.images.addAll(parcelableArrayListExtra);
        }
        this.ibLeftBack.setOnClickListener(this);
        this.ibDelete.setOnClickListener(this);
        ImageButton imageButton = this.ibDelete;
        if (PictureSelectionConfig.style == null || !PictureSelectionConfig.style.pictureExternalPreviewGonePreviewDelete) {
            i = 8;
        }
        imageButton.setVisibility(i);
        initViewPageAdapterData();
    }

    public void initPictureSelectorStyle() {
        if (PictureSelectionConfig.style != null) {
            if (PictureSelectionConfig.style.pictureTitleTextColor != 0) {
                this.tvTitle.setTextColor(PictureSelectionConfig.style.pictureTitleTextColor);
            }
            if (PictureSelectionConfig.style.pictureTitleTextSize != 0) {
                this.tvTitle.setTextSize((float) PictureSelectionConfig.style.pictureTitleTextSize);
            }
            if (PictureSelectionConfig.style.pictureLeftBackIcon != 0) {
                this.ibLeftBack.setImageResource(PictureSelectionConfig.style.pictureLeftBackIcon);
            }
            if (PictureSelectionConfig.style.pictureExternalPreviewDeleteStyle != 0) {
                this.ibDelete.setImageResource(PictureSelectionConfig.style.pictureExternalPreviewDeleteStyle);
            }
            if (PictureSelectionConfig.style.pictureTitleBarBackgroundColor != 0) {
                this.mTitleBar.setBackgroundColor(this.colorPrimary);
                return;
            }
            return;
        }
        int typeValueColor = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_ac_preview_title_bg);
        if (typeValueColor != 0) {
            this.mTitleBar.setBackgroundColor(typeValueColor);
        } else {
            this.mTitleBar.setBackgroundColor(this.colorPrimary);
        }
    }

    private void initViewPageAdapterData() {
        this.tvTitle.setText(getString(R.string.picture_preview_image_num, new Object[]{Integer.valueOf(this.position + 1), Integer.valueOf(this.images.size())}));
        SimpleFragmentAdapter simpleFragmentAdapter = new SimpleFragmentAdapter();
        this.adapter = simpleFragmentAdapter;
        this.viewPager.setAdapter(simpleFragmentAdapter);
        this.viewPager.setCurrentItem(this.position);
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                PictureExternalPreviewActivity.this.tvTitle.setText(PictureExternalPreviewActivity.this.getString(R.string.picture_preview_image_num, new Object[]{Integer.valueOf(i + 1), Integer.valueOf(PictureExternalPreviewActivity.this.images.size())}));
                int unused = PictureExternalPreviewActivity.this.position = i;
            }
        });
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, PictureExternalPreviewActivity.class);
        int id = view.getId();
        if (id == R.id.left_back) {
            finish();
            exitAnimation();
        } else if (id == R.id.ib_delete && this.images.size() > 0) {
            int currentItem = this.viewPager.getCurrentItem();
            this.images.remove(currentItem);
            this.adapter.removeCacheView(currentItem);
            Bundle bundle = new Bundle();
            bundle.putInt("position", currentItem);
            BroadcastManager.getInstance(getContext()).action(BroadcastAction.ACTION_DELETE_PREVIEW_POSITION).extras(bundle).broadcast();
            if (this.images.size() == 0) {
                onBackPressed();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
                return;
            }
            this.tvTitle.setText(getString(R.string.picture_preview_image_num, new Object[]{Integer.valueOf(this.position + 1), Integer.valueOf(this.images.size())}));
            this.position = currentItem;
            this.adapter.notifyDataSetChanged();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public class SimpleFragmentAdapter extends PagerAdapter {
        private static final int MAX_CACHE_SIZE = 20;
        private final SparseArray<View> mCacheView = new SparseArray<>();

        public int getItemPosition(Object obj) {
            return -2;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        /* access modifiers changed from: private */
        public void clear() {
            this.mCacheView.clear();
        }

        public void removeCacheView(int i) {
            if (i < this.mCacheView.size()) {
                this.mCacheView.removeAt(i);
            }
        }

        public SimpleFragmentAdapter() {
        }

        public int getCount() {
            return PictureExternalPreviewActivity.this.images.size();
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
            LocalMedia localMedia = (LocalMedia) PictureExternalPreviewActivity.this.images.get(i);
            if (PictureExternalPreviewActivity.this.config.isAutoScalePreviewImage) {
                float min = (float) Math.min(localMedia.getWidth(), localMedia.getHeight());
                float max = (float) Math.max(localMedia.getHeight(), localMedia.getWidth());
                if (min > 0.0f && max > 0.0f) {
                    int ceil = (int) Math.ceil((double) ((max * min) / min));
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) r2.getLayoutParams();
                    layoutParams.width = PictureExternalPreviewActivity.this.mScreenWidth;
                    if (ceil < PictureExternalPreviewActivity.this.mScreenHeight) {
                        ceil += PictureExternalPreviewActivity.this.mScreenHeight;
                    }
                    layoutParams.height = ceil;
                    layoutParams.gravity = 17;
                }
            }
            if (localMedia.isCut() && !localMedia.isCompressed()) {
                str = localMedia.getCutPath();
            } else if (localMedia.isCompressed() || (localMedia.isCut() && localMedia.isCompressed())) {
                str = localMedia.getCompressPath();
            } else if (!TextUtils.isEmpty(localMedia.getAndroidQToPath())) {
                str = localMedia.getAndroidQToPath();
            } else {
                str = localMedia.getPath();
            }
            String str2 = str;
            boolean isHasHttp = PictureMimeType.isHasHttp(str2);
            String mimeType = (!isHasHttp || !TextUtils.isEmpty(localMedia.getMimeType())) ? localMedia.getMimeType() : PictureMimeType.getImageMimeType(localMedia.getPath());
            boolean isHasVideo = PictureMimeType.isHasVideo(mimeType);
            int i3 = 8;
            imageView.setVisibility(isHasVideo ? 0 : 8);
            boolean isGif = PictureMimeType.isGif(mimeType);
            boolean isLongImg = MediaUtils.isLongImg(localMedia);
            r2.setVisibility((!isLongImg || isGif) ? 0 : 8);
            if (isLongImg && !isGif) {
                i3 = 0;
            }
            subsamplingScaleImageView.setVisibility(i3);
            if (!isGif || localMedia.isCompressed()) {
                if (PictureSelectionConfig.imageEngine != null) {
                    if (isHasHttp) {
                        PictureSelectionConfig.imageEngine.loadImage(view.getContext(), str2, r2, subsamplingScaleImageView, new OnImageCompleteCallback() {
                            public void onShowLoading() {
                                PictureExternalPreviewActivity.this.showPleaseDialog();
                            }

                            public void onHideLoading() {
                                PictureExternalPreviewActivity.this.dismissDialog();
                            }
                        });
                    } else if (isLongImg) {
                        PictureExternalPreviewActivity.this.displayLongPic(PictureMimeType.isContent(str2) ? Uri.parse(str2) : Uri.fromFile(new File(str2)), subsamplingScaleImageView);
                    } else {
                        PictureSelectionConfig.imageEngine.loadImage(view.getContext(), str2, r2);
                    }
                }
            } else if (PictureSelectionConfig.imageEngine != null) {
                PictureSelectionConfig.imageEngine.loadAsGifImage(PictureExternalPreviewActivity.this.getContext(), str2, r2);
            }
            r2.setOnViewTapListener(new PictureExternalPreviewActivity$SimpleFragmentAdapter$$ExternalSyntheticLambda4(this));
            subsamplingScaleImageView.setOnClickListener(new PictureExternalPreviewActivity$SimpleFragmentAdapter$$ExternalSyntheticLambda0(this));
            if (!isHasVideo) {
                subsamplingScaleImageView.setOnLongClickListener(new PictureExternalPreviewActivity$SimpleFragmentAdapter$$ExternalSyntheticLambda2(this, str2, localMedia));
            }
            if (!isHasVideo) {
                r2.setOnLongClickListener(new PictureExternalPreviewActivity$SimpleFragmentAdapter$$ExternalSyntheticLambda3(this, str2, localMedia));
            }
            imageView.setOnClickListener(new PictureExternalPreviewActivity$SimpleFragmentAdapter$$ExternalSyntheticLambda1(localMedia, str2, viewGroup));
            viewGroup.addView(view, 0);
            return view;
        }

        public /* synthetic */ void lambda$instantiateItem$0$PictureExternalPreviewActivity$SimpleFragmentAdapter(View view, float f, float f2) {
            PictureExternalPreviewActivity.this.finish();
            PictureExternalPreviewActivity.this.exitAnimation();
        }

        public /* synthetic */ void lambda$instantiateItem$1$PictureExternalPreviewActivity$SimpleFragmentAdapter(View view) {
            PictureExternalPreviewActivity.this.finish();
            PictureExternalPreviewActivity.this.exitAnimation();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* JADX WARNING: type inference failed for: r2v1, types: [android.content.Context, com.luck.picture.lib.PictureExternalPreviewActivity, android.app.Activity] */
        public /* synthetic */ boolean lambda$instantiateItem$2$PictureExternalPreviewActivity$SimpleFragmentAdapter(String str, LocalMedia localMedia, View view) {
            if (PictureExternalPreviewActivity.this.config.isNotPreviewDownload) {
                if (PermissionChecker.isCheckWriteStorage(PictureExternalPreviewActivity.this.getContext())) {
                    String unused = PictureExternalPreviewActivity.this.downloadPath = str;
                    String mimeType = (!PictureMimeType.isHasHttp(str) || !TextUtils.isEmpty(localMedia.getMimeType())) ? localMedia.getMimeType() : PictureMimeType.getImageMimeType(localMedia.getPath());
                    PictureExternalPreviewActivity pictureExternalPreviewActivity = PictureExternalPreviewActivity.this;
                    if (PictureMimeType.isJPG(mimeType)) {
                        mimeType = "image/jpeg";
                    }
                    String unused2 = pictureExternalPreviewActivity.mMimeType = mimeType;
                    PictureExternalPreviewActivity.this.showDownLoadDialog();
                } else {
                    ? r2 = PictureExternalPreviewActivity.this;
                    PermissionChecker.requestPermissions(r2, PermissionConfig.getWritePermissionArray(r2), 1);
                }
            }
            return true;
        }

        /* JADX WARNING: type inference failed for: r2v1, types: [com.luck.picture.lib.PictureExternalPreviewActivity, android.app.Activity] */
        public /* synthetic */ boolean lambda$instantiateItem$3$PictureExternalPreviewActivity$SimpleFragmentAdapter(String str, LocalMedia localMedia, View view) {
            if (PictureExternalPreviewActivity.this.config.isNotPreviewDownload) {
                if (PermissionChecker.isCheckWriteStorage(PictureExternalPreviewActivity.this.getContext())) {
                    String unused = PictureExternalPreviewActivity.this.downloadPath = str;
                    String mimeType = (!PictureMimeType.isHasHttp(str) || !TextUtils.isEmpty(localMedia.getMimeType())) ? localMedia.getMimeType() : PictureMimeType.getImageMimeType(localMedia.getPath());
                    PictureExternalPreviewActivity pictureExternalPreviewActivity = PictureExternalPreviewActivity.this;
                    if (PictureMimeType.isJPG(mimeType)) {
                        mimeType = "image/jpeg";
                    }
                    String unused2 = pictureExternalPreviewActivity.mMimeType = mimeType;
                    PictureExternalPreviewActivity.this.showDownLoadDialog();
                } else {
                    ? r2 = PictureExternalPreviewActivity.this;
                    PermissionChecker.requestPermissions(r2, PermissionConfig.getWritePermissionArray(r2.getContext()), 1);
                }
            }
            return true;
        }

        static /* synthetic */ void lambda$instantiateItem$4(LocalMedia localMedia, String str, ViewGroup viewGroup, View view) {
            if (PictureSelectionConfig.customVideoPlayCallback != null) {
                PictureSelectionConfig.customVideoPlayCallback.startPlayVideo(localMedia);
            } else {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString(PictureConfig.EXTRA_VIDEO_PATH, str);
                intent.putExtras(bundle);
                JumpUtils.startPictureVideoPlayActivity(viewGroup.getContext(), bundle, PictureConfig.PREVIEW_VIDEO_CODE);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    public void displayLongPic(Uri uri, SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.setQuickScaleEnabled(true);
        subsamplingScaleImageView.setZoomEnabled(true);
        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
        subsamplingScaleImageView.setMinimumScaleType(2);
        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
        subsamplingScaleImageView.setImage(ImageSource.uri(uri), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
    }

    /* access modifiers changed from: private */
    public void showDownLoadDialog() {
        if (!isFinishing() && !TextUtils.isEmpty(this.downloadPath)) {
            PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(getContext(), R.layout.picture_wind_base_dialog);
            ((TextView) pictureCustomDialog.findViewById(R.id.tvTitle)).setText(getString(R.string.picture_prompt));
            ((TextView) pictureCustomDialog.findViewById(R.id.tv_content)).setText(getString(R.string.picture_prompt_content));
            ((Button) pictureCustomDialog.findViewById(R.id.btn_cancel)).setOnClickListener(new PictureExternalPreviewActivity$$ExternalSyntheticLambda0(this, pictureCustomDialog));
            ((Button) pictureCustomDialog.findViewById(R.id.btn_commit)).setOnClickListener(new PictureExternalPreviewActivity$$ExternalSyntheticLambda1(this, pictureCustomDialog));
            pictureCustomDialog.show();
        }
    }

    public /* synthetic */ void lambda$showDownLoadDialog$0$PictureExternalPreviewActivity(PictureCustomDialog pictureCustomDialog, View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$showDownLoadDialog$1$PictureExternalPreviewActivity(PictureCustomDialog pictureCustomDialog, View view) {
        boolean isHasHttp = PictureMimeType.isHasHttp(this.downloadPath);
        showPleaseDialog();
        if (isHasHttp) {
            PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<String>() {
                public String doInBackground() {
                    PictureExternalPreviewActivity pictureExternalPreviewActivity = PictureExternalPreviewActivity.this;
                    return pictureExternalPreviewActivity.showLoadingImage(pictureExternalPreviewActivity.downloadPath);
                }

                public void onSuccess(String str) {
                    PictureExternalPreviewActivity.this.onSuccessful(str);
                }
            });
        } else {
            try {
                if (PictureMimeType.isContent(this.downloadPath)) {
                    savePictureAlbumAndroidQ(PictureMimeType.isContent(this.downloadPath) ? Uri.parse(this.downloadPath) : Uri.fromFile(new File(this.downloadPath)));
                } else {
                    savePictureAlbum();
                }
            } catch (Exception e) {
                Context context = getContext();
                ToastUtils.s(context, getString(R.string.picture_save_error) + "\n" + e.getMessage());
                dismissDialog();
                e.printStackTrace();
            }
        }
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void savePictureAlbum() throws Exception {
        File file;
        String str;
        String lastImgSuffix = PictureMimeType.getLastImgSuffix(this.mMimeType);
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("mounted")) {
            file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        } else {
            file = getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        if (SdkVersionUtils.checkedAndroid_Q() || !externalStorageState.equals("mounted")) {
            str = file.getAbsolutePath();
        } else {
            str = file.getAbsolutePath() + File.separator + PictureMimeType.CAMERA + File.separator;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(file2, DateUtils.getCreateFileName("IMG_") + lastImgSuffix);
        PictureFileUtils.copyFile(this.downloadPath, file3.getAbsolutePath());
        onSuccessful(file3.getAbsolutePath());
    }

    /* access modifiers changed from: private */
    public void onSuccessful(String str) {
        dismissDialog();
        if (!TextUtils.isEmpty(str)) {
            try {
                if (!SdkVersionUtils.checkedAndroid_Q()) {
                    File file = new File(str);
                    MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), (String) null);
                    new PictureMediaScannerConnection(getContext(), file.getAbsolutePath(), PictureExternalPreviewActivity$$ExternalSyntheticLambda2.INSTANCE);
                }
                Context context = getContext();
                ToastUtils.s(context, getString(R.string.picture_save_success) + "\n" + str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ToastUtils.s(getContext(), getString(R.string.picture_save_error));
        }
    }

    private void savePictureAlbumAndroidQ(final Uri uri) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        contentValues.put("datetaken", ValueOf.toString(Long.valueOf(System.currentTimeMillis())));
        contentValues.put("mime_type", this.mMimeType);
        contentValues.put("relative_path", PictureMimeType.DCIM);
        final Uri insert = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (insert == null) {
            ToastUtils.s(getContext(), getString(R.string.picture_save_error));
        } else {
            PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<String>() {
                public String doInBackground() {
                    BufferedSource bufferedSource = null;
                    try {
                        InputStream contentResolverOpenInputStream = PictureContentResolver.getContentResolverOpenInputStream(PictureExternalPreviewActivity.this.getContext(), uri);
                        Objects.requireNonNull(contentResolverOpenInputStream);
                        bufferedSource = Okio.buffer(Okio.source(contentResolverOpenInputStream));
                        if (PictureFileUtils.bufferCopy(bufferedSource, PictureContentResolver.getContentResolverOpenOutputStream(PictureExternalPreviewActivity.this.getContext(), insert))) {
                            String path = PictureFileUtils.getPath(PictureExternalPreviewActivity.this.getContext(), insert);
                            if (bufferedSource != null && bufferedSource.isOpen()) {
                                PictureFileUtils.close(bufferedSource);
                            }
                            return path;
                        }
                        if (bufferedSource == null || !bufferedSource.isOpen()) {
                            return "";
                        }
                        PictureFileUtils.close(bufferedSource);
                        return "";
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (bufferedSource == null || !bufferedSource.isOpen()) {
                            return "";
                        }
                    } catch (Throwable th) {
                        if (bufferedSource != null && bufferedSource.isOpen()) {
                            PictureFileUtils.close(bufferedSource);
                        }
                        throw th;
                    }
                }

                public void onSuccess(String str) {
                    PictureThreadUtils.cancel(PictureThreadUtils.getSinglePool());
                    PictureExternalPreviewActivity.this.onSuccessful(str);
                }
            });
        }
    }

    private Uri createOutImageUri() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        contentValues.put("datetaken", ValueOf.toString(Long.valueOf(System.currentTimeMillis())));
        contentValues.put("mime_type", this.mMimeType);
        contentValues.put("relative_path", PictureMimeType.DCIM);
        return getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [android.content.Context, com.luck.picture.lib.PictureExternalPreviewActivity] */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cd, code lost:
        r7 = null;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d4, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d5, code lost:
        r2 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e2, code lost:
        if (com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_Q() != false) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e4, code lost:
        getContentResolver().delete(r0, (java.lang.String) null, (java.lang.String[]) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ec, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d4 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0003] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00de A[SYNTHETIC, Splitter:B:53:0x00de] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String showLoadingImage(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "mounted"
            r1 = 0
            boolean r2 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_Q()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            if (r2 == 0) goto L_0x000f
            android.net.Uri r0 = r6.createOutImageUri()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            goto L_0x0093
        L_0x000f:
            java.lang.String r2 = r6.mMimeType     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r2 = com.luck.picture.lib.config.PictureMimeType.getLastImgSuffix(r2)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r3 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            boolean r4 = r3.equals(r0)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            if (r4 == 0) goto L_0x0026
            java.lang.String r4 = android.os.Environment.DIRECTORY_DCIM     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.io.File r4 = android.os.Environment.getExternalStoragePublicDirectory(r4)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            goto L_0x0030
        L_0x0026:
            android.content.Context r4 = r6.getContext()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r5 = android.os.Environment.DIRECTORY_PICTURES     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.io.File r4 = r4.getExternalFilesDir(r5)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
        L_0x0030:
            if (r4 == 0) goto L_0x0092
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            if (r5 != 0) goto L_0x003b
            r4.mkdirs()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
        L_0x003b:
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            boolean r0 = r3.equals(r0)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            if (r0 != 0) goto L_0x0048
            java.lang.String r0 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            goto L_0x0067
        L_0x0048:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r0.<init>()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r3 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r0.append(r3)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r0.append(r3)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r3 = "Camera"
            r0.append(r3)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r0.append(r3)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
        L_0x0067:
            r5.<init>(r0)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            boolean r0 = r5.exists()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            if (r0 != 0) goto L_0x0073
            r5.mkdirs()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
        L_0x0073:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r0.<init>()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r3 = "IMG_"
            java.lang.String r3 = com.luck.picture.lib.tools.DateUtils.getCreateFileName(r3)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r0.append(r3)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r0.append(r2)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r2.<init>(r5, r0)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            android.net.Uri r0 = android.net.Uri.fromFile(r2)     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            goto L_0x0093
        L_0x0092:
            r0 = r1
        L_0x0093:
            if (r0 == 0) goto L_0x00d0
            android.content.Context r2 = r6.getContext()     // Catch:{ Exception -> 0x00cd, all -> 0x00d4 }
            java.io.OutputStream r2 = com.luck.picture.lib.PictureContentResolver.getContentResolverOpenOutputStream(r2, r0)     // Catch:{ Exception -> 0x00cd, all -> 0x00d4 }
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x00ca, all -> 0x00c7 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x00ca, all -> 0x00c7 }
            java.io.InputStream r7 = r3.openStream()     // Catch:{ Exception -> 0x00ca, all -> 0x00c7 }
            okio.Source r3 = okio.Okio.source(r7)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            okio.BufferedSource r3 = okio.Okio.buffer(r3)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            boolean r4 = com.luck.picture.lib.tools.PictureFileUtils.bufferCopy((okio.BufferedSource) r3, (java.io.OutputStream) r2)     // Catch:{ Exception -> 0x00dc }
            if (r4 == 0) goto L_0x00f9
            java.lang.String r0 = com.luck.picture.lib.tools.PictureFileUtils.getPath(r6, r0)     // Catch:{ Exception -> 0x00dc }
            com.luck.picture.lib.tools.PictureFileUtils.close(r7)
            com.luck.picture.lib.tools.PictureFileUtils.close(r2)
            com.luck.picture.lib.tools.PictureFileUtils.close(r3)
            return r0
        L_0x00c2:
            r0 = move-exception
            r3 = r1
            goto L_0x00ed
        L_0x00c5:
            r3 = r1
            goto L_0x00dc
        L_0x00c7:
            r7 = move-exception
            r3 = r1
            goto L_0x00ef
        L_0x00ca:
            r7 = r1
            r3 = r7
            goto L_0x00dc
        L_0x00cd:
            r7 = r1
            r2 = r7
            goto L_0x00db
        L_0x00d0:
            r7 = r1
            r2 = r7
            r3 = r2
            goto L_0x00f9
        L_0x00d4:
            r7 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x00ef
        L_0x00d8:
            r7 = r1
            r0 = r7
            r2 = r0
        L_0x00db:
            r3 = r2
        L_0x00dc:
            if (r0 == 0) goto L_0x00f9
            boolean r4 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_Q()     // Catch:{ all -> 0x00ec }
            if (r4 == 0) goto L_0x00f9
            android.content.ContentResolver r4 = r6.getContentResolver()     // Catch:{ all -> 0x00ec }
            r4.delete(r0, r1, r1)     // Catch:{ all -> 0x00ec }
            goto L_0x00f9
        L_0x00ec:
            r0 = move-exception
        L_0x00ed:
            r1 = r7
            r7 = r0
        L_0x00ef:
            com.luck.picture.lib.tools.PictureFileUtils.close(r1)
            com.luck.picture.lib.tools.PictureFileUtils.close(r2)
            com.luck.picture.lib.tools.PictureFileUtils.close(r3)
            throw r7
        L_0x00f9:
            com.luck.picture.lib.tools.PictureFileUtils.close(r7)
            com.luck.picture.lib.tools.PictureFileUtils.close(r2)
            com.luck.picture.lib.tools.PictureFileUtils.close(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureExternalPreviewActivity.showLoadingImage(java.lang.String):java.lang.String");
    }

    public void onBackPressed() {
        if (SdkVersionUtils.checkedAndroid_Q()) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        finish();
        exitAnimation();
    }

    /* access modifiers changed from: private */
    public void exitAnimation() {
        overridePendingTransition(R.anim.picture_anim_fade_in, PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation);
    }

    public void finish() {
        super.finish();
        SimpleFragmentAdapter simpleFragmentAdapter = this.adapter;
        if (simpleFragmentAdapter != null) {
            simpleFragmentAdapter.clear();
        }
        PictureSelectionConfig.destroy();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        boolean z = true;
        if (i == 1) {
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (iArr[i2] != 0) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                showDownLoadDialog();
            } else {
                ToastUtils.s(getContext(), getString(R.string.picture_jurisdiction));
            }
        }
    }
}
