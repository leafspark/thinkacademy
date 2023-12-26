package com.luck.picture.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.luck.picture.lib.app.PictureAppMaster;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.compress.OnCompressListener;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.dialog.PictureCustomDialog;
import com.luck.picture.lib.dialog.PictureLoadingDialog;
import com.luck.picture.lib.engine.PictureSelectorEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.immersive.ImmersiveManage;
import com.luck.picture.lib.immersive.NavBarUtils;
import com.luck.picture.lib.language.PictureLanguageUtils;
import com.luck.picture.lib.listener.OnCallbackListener;
import com.luck.picture.lib.model.LocalMediaPageLoader;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.VoiceUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class PictureBaseActivity extends AppCompatActivity {
    protected int colorPrimary;
    protected int colorPrimaryDark;
    protected PictureSelectionConfig config;
    protected View container;
    protected boolean isHasMore = true;
    protected boolean isOnSaveInstanceState;
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    protected PictureLoadingDialog mLoadingDialog;
    protected int mPage = 1;
    protected boolean numComplete;
    protected boolean openWhiteStatusBar;
    protected List<LocalMedia> selectionMedias = new ArrayList();

    public void finish() {
        PictureBaseActivity.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [android.content.Context, com.luck.picture.lib.PictureBaseActivity] */
    /* access modifiers changed from: protected */
    public Context getContext() {
        return this;
    }

    public abstract int getResourceId();

    /* access modifiers changed from: protected */
    public void initCompleteText(int i) {
    }

    /* access modifiers changed from: protected */
    public void initCompleteText(List<LocalMedia> list) {
    }

    /* access modifiers changed from: protected */
    public void initPictureSelectorStyle() {
    }

    /* access modifiers changed from: protected */
    public void initWidgets() {
    }

    public boolean isImmersive() {
        return true;
    }

    public boolean isRequestedOrientation() {
        return true;
    }

    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        PictureBaseActivity.super.onPause();
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        PictureBaseActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        PictureBaseActivity.super.onResume();
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        PictureBaseActivity.super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void onStop() {
        PictureBaseActivity.super.onStop();
        ActivityInfo.stopActivity();
    }

    /* access modifiers changed from: protected */
    public void showPermissionsDialog(boolean z, String[] strArr, String str) {
    }

    public void immersive() {
        ImmersiveManage.immersiveAboveAPI23(this, this.colorPrimaryDark, this.colorPrimary, this.openWhiteStatusBar);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, androidx.appcompat.app.AppCompatActivity, android.app.Activity, com.luck.picture.lib.PictureBaseActivity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        this.config = PictureSelectionConfig.getInstance();
        PictureLanguageUtils.setAppLanguage(getContext(), this.config.language);
        setTheme(this.config.themeStyleId == 0 ? R.style.picture_default_style : this.config.themeStyleId);
        PictureBaseActivity.super.onCreate(bundle);
        newCreateEngine();
        newCreateResultCallbackListener();
        if (isRequestedOrientation()) {
            setNewRequestedOrientation();
        }
        initConfig();
        if (isImmersive()) {
            immersive();
        }
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_navBarColor != 0) {
                NavBarUtils.setNavBarColor((Activity) this, PictureSelectionConfig.uiStyle.picture_navBarColor);
            }
        } else if (!(PictureSelectionConfig.style == null || PictureSelectionConfig.style.pictureNavBarColor == 0)) {
            NavBarUtils.setNavBarColor((Activity) this, PictureSelectionConfig.style.pictureNavBarColor);
        }
        int resourceId = getResourceId();
        if (resourceId != 0) {
            setContentView(resourceId);
        }
        initWidgets();
        initPictureSelectorStyle();
        this.isOnSaveInstanceState = false;
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    private void newCreateEngine() {
        PictureSelectorEngine pictureSelectorEngine;
        if (PictureSelectionConfig.imageEngine == null && (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
            PictureSelectionConfig.imageEngine = pictureSelectorEngine.createEngine();
        }
    }

    private void newCreateResultCallbackListener() {
        PictureSelectorEngine pictureSelectorEngine;
        if (this.config.isCallbackMode && PictureSelectionConfig.listener == null && (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
            PictureSelectionConfig.listener = pictureSelectorEngine.getResultCallbackListener();
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig == null) {
            PictureBaseActivity.super.attachBaseContext(context);
        } else {
            PictureBaseActivity.super.attachBaseContext(PictureContextWrapper.wrap(context, pictureSelectionConfig.language));
        }
    }

    /* access modifiers changed from: protected */
    public void setNewRequestedOrientation() {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig != null && !pictureSelectionConfig.camera) {
            setRequestedOrientation(this.config.requestedOrientation);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, com.luck.picture.lib.PictureBaseActivity] */
    private void initConfig() {
        if (this.config.selectionMedias != null) {
            this.selectionMedias.clear();
            this.selectionMedias.addAll(this.config.selectionMedias);
        }
        if (PictureSelectionConfig.uiStyle != null) {
            this.openWhiteStatusBar = PictureSelectionConfig.uiStyle.picture_statusBarChangeTextColor;
            if (PictureSelectionConfig.uiStyle.picture_top_titleBarBackgroundColor != 0) {
                this.colorPrimary = PictureSelectionConfig.uiStyle.picture_top_titleBarBackgroundColor;
            }
            if (PictureSelectionConfig.uiStyle.picture_statusBarBackgroundColor != 0) {
                this.colorPrimaryDark = PictureSelectionConfig.uiStyle.picture_statusBarBackgroundColor;
            }
            this.numComplete = PictureSelectionConfig.uiStyle.picture_switchSelectTotalStyle;
            this.config.checkNumMode = PictureSelectionConfig.uiStyle.picture_switchSelectNumberStyle;
        } else if (PictureSelectionConfig.style != null) {
            this.openWhiteStatusBar = PictureSelectionConfig.style.isChangeStatusBarFontColor;
            if (PictureSelectionConfig.style.pictureTitleBarBackgroundColor != 0) {
                this.colorPrimary = PictureSelectionConfig.style.pictureTitleBarBackgroundColor;
            }
            if (PictureSelectionConfig.style.pictureStatusBarColor != 0) {
                this.colorPrimaryDark = PictureSelectionConfig.style.pictureStatusBarColor;
            }
            this.numComplete = PictureSelectionConfig.style.isOpenCompletedNumStyle;
            this.config.checkNumMode = PictureSelectionConfig.style.isOpenCheckNumStyle;
        } else {
            boolean z = this.config.isChangeStatusBarFontColor;
            this.openWhiteStatusBar = z;
            if (!z) {
                this.openWhiteStatusBar = AttrsUtils.getTypeValueBoolean(this, R.attr.picture_statusFontColor);
            }
            boolean z2 = this.config.isOpenStyleNumComplete;
            this.numComplete = z2;
            if (!z2) {
                this.numComplete = AttrsUtils.getTypeValueBoolean(this, R.attr.picture_style_numComplete);
            }
            PictureSelectionConfig pictureSelectionConfig = this.config;
            pictureSelectionConfig.checkNumMode = pictureSelectionConfig.isOpenStyleCheckNumMode;
            if (!this.config.checkNumMode) {
                this.config.checkNumMode = AttrsUtils.getTypeValueBoolean(this, R.attr.picture_style_checkNumMode);
            }
            if (this.config.titleBarBackgroundColor != 0) {
                this.colorPrimary = this.config.titleBarBackgroundColor;
            } else {
                this.colorPrimary = AttrsUtils.getTypeValueColor(this, R.attr.colorPrimary);
            }
            if (this.config.pictureStatusBarColor != 0) {
                this.colorPrimaryDark = this.config.pictureStatusBarColor;
            } else {
                this.colorPrimaryDark = AttrsUtils.getTypeValueColor(this, R.attr.colorPrimaryDark);
            }
        }
        if (this.config.openClickSound) {
            VoiceUtils.getInstance().init(getContext());
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        PictureBaseActivity.super.onSaveInstanceState(bundle);
        this.isOnSaveInstanceState = true;
        bundle.putParcelable(PictureConfig.EXTRA_CONFIG, this.config);
    }

    /* access modifiers changed from: protected */
    public void showPleaseDialog() {
        try {
            if (!isFinishing()) {
                if (this.mLoadingDialog == null) {
                    this.mLoadingDialog = new PictureLoadingDialog(getContext());
                }
                if (this.mLoadingDialog.isShowing()) {
                    this.mLoadingDialog.dismiss();
                }
                this.mLoadingDialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void dismissDialog() {
        if (!isFinishing()) {
            try {
                PictureLoadingDialog pictureLoadingDialog = this.mLoadingDialog;
                if (pictureLoadingDialog != null && pictureLoadingDialog.isShowing()) {
                    this.mLoadingDialog.dismiss();
                }
            } catch (Exception e) {
                this.mLoadingDialog = null;
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void compressImage(List<LocalMedia> list) {
        if (PictureSelectionConfig.compressEngine != null) {
            PictureSelectionConfig.compressEngine.onCompress(getContext(), list, new OnCallbackListener<List<LocalMedia>>() {
                public void onCall(List<LocalMedia> list) {
                    PictureBaseActivity.this.onResult(list);
                }
            });
            return;
        }
        showPleaseDialog();
        compressToLuban(list);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, com.luck.picture.lib.PictureBaseActivity] */
    private void compressToLuban(final List<LocalMedia> list) {
        if (this.config.synOrAsy) {
            PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<List<LocalMedia>>() {
                public List<LocalMedia> doInBackground() throws Exception {
                    return Luban.with(PictureBaseActivity.this.getContext()).loadMediaData(list).isCamera(PictureBaseActivity.this.config.camera).setTargetDir(PictureBaseActivity.this.config.compressSavePath).setCompressQuality(PictureBaseActivity.this.config.compressQuality).isAutoRotating(PictureBaseActivity.this.config.isAutoRotating).setFocusAlpha(PictureBaseActivity.this.config.focusAlpha).setNewCompressFileName(PictureBaseActivity.this.config.renameCompressFileName).ignoreBy(PictureBaseActivity.this.config.minimumCompressSize).get();
                }

                public void onSuccess(List<LocalMedia> list) {
                    PictureBaseActivity.this.onResult(list);
                }
            });
        } else {
            Luban.with(this).loadMediaData(list).ignoreBy(this.config.minimumCompressSize).isCamera(this.config.camera).setCompressQuality(this.config.compressQuality).setTargetDir(this.config.compressSavePath).isAutoRotating(this.config.isAutoRotating).setFocusAlpha(this.config.focusAlpha).setNewCompressFileName(this.config.renameCompressFileName).setCompressListener(new OnCompressListener() {
                public void onStart() {
                }

                public void onSuccess(List<LocalMedia> list) {
                    PictureBaseActivity.this.onResult(list);
                }

                public void onError(Throwable th) {
                    PictureBaseActivity.this.onResult(list);
                }
            }).launch();
        }
    }

    /* access modifiers changed from: protected */
    public void handlerResult(List<LocalMedia> list) {
        if (this.config.isCompress) {
            compressImage(list);
        } else {
            onResult(list);
        }
    }

    /* access modifiers changed from: protected */
    public void createNewFolder(List<LocalMediaFolder> list) {
        int i;
        if (list.size() == 0) {
            LocalMediaFolder localMediaFolder = new LocalMediaFolder();
            if (this.config.chooseMode == PictureMimeType.ofAudio()) {
                i = R.string.picture_all_audio;
            } else {
                i = R.string.picture_camera_roll;
            }
            localMediaFolder.setName(getString(i));
            localMediaFolder.setFirstImagePath("");
            localMediaFolder.setCameraFolder(true);
            localMediaFolder.setBucketId(-1);
            localMediaFolder.setChecked(true);
            list.add(localMediaFolder);
        }
    }

    /* access modifiers changed from: protected */
    public LocalMediaFolder getImageFolder(String str, String str2, String str3, List<LocalMediaFolder> list) {
        if (!PictureMimeType.isContent(str)) {
            str2 = str;
        }
        File parentFile = new File(str2).getParentFile();
        for (LocalMediaFolder next : list) {
            if (parentFile != null && next.getName().equals(parentFile.getName())) {
                return next;
            }
        }
        LocalMediaFolder localMediaFolder = new LocalMediaFolder();
        localMediaFolder.setName(parentFile != null ? parentFile.getName() : "");
        localMediaFolder.setFirstImagePath(str);
        localMediaFolder.setFirstMimeType(str3);
        list.add(localMediaFolder);
        return localMediaFolder;
    }

    /* access modifiers changed from: protected */
    public void onResult(List<LocalMedia> list) {
        if (!SdkVersionUtils.checkedAndroid_Q() || !this.config.isAndroidQTransform) {
            dismissDialog();
            if (this.config.camera && this.config.selectionMode == 2) {
                list.addAll(list.size() > 0 ? list.size() - 1 : 0, this.selectionMedias);
            }
            if (this.config.isCheckOriginalImage) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    LocalMedia localMedia = list.get(i);
                    localMedia.setOriginal(true);
                    localMedia.setOriginalPath(localMedia.getPath());
                }
            }
            if (PictureSelectionConfig.listener != null) {
                PictureSelectionConfig.listener.onResult(list);
            } else {
                setResult(-1, PictureSelector.putIntentResult(list));
            }
            exit();
            return;
        }
        onResultToAndroidAsy(list);
    }

    private void onResultToAndroidAsy(List<LocalMedia> list) {
        int size = list.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            LocalMedia localMedia = list.get(i);
            if (localMedia == null || TextUtils.isEmpty(localMedia.getPath()) || (!this.config.isCheckOriginalImage && (localMedia.isCut() || localMedia.isCompressed() || !TextUtils.isEmpty(localMedia.getAndroidQToPath())))) {
                i++;
            }
        }
        z = true;
        if (z) {
            startThreadCopySandbox(list);
        } else {
            normalResult(list);
        }
    }

    private void normalResult(List<LocalMedia> list) {
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            LocalMedia localMedia = list.get(i2);
            if (localMedia != null && !TextUtils.isEmpty(localMedia.getPath())) {
                if (localMedia.isCut() && localMedia.isCompressed()) {
                    localMedia.setAndroidQToPath(localMedia.getCompressPath());
                }
                if (this.config.isCheckOriginalImage) {
                    localMedia.setOriginal(true);
                    localMedia.setOriginalPath(localMedia.getAndroidQToPath());
                }
            }
        }
        if (this.config.camera && this.config.selectionMode == 2) {
            if (list.size() > 0) {
                i = list.size() - 1;
            }
            list.addAll(i, this.selectionMedias);
        }
        if (PictureSelectionConfig.listener != null) {
            PictureSelectionConfig.listener.onResult(list);
        } else {
            setResult(-1, PictureSelector.putIntentResult(list));
        }
        exit();
    }

    private void startThreadCopySandbox(final List<LocalMedia> list) {
        showPleaseDialog();
        PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<List<LocalMedia>>() {
            /* JADX WARNING: Removed duplicated region for block: B:28:0x0095  */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x00c9 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<com.luck.picture.lib.entity.LocalMedia> doInBackground() {
                /*
                    r14 = this;
                    java.util.List r0 = r2
                    int r0 = r0.size()
                    r1 = 0
                    r2 = r1
                L_0x0008:
                    if (r2 >= r0) goto L_0x00cd
                    java.util.List r3 = r2
                    java.lang.Object r3 = r3.get(r2)
                    com.luck.picture.lib.entity.LocalMedia r3 = (com.luck.picture.lib.entity.LocalMedia) r3
                    if (r3 == 0) goto L_0x00c9
                    java.lang.String r4 = r3.getPath()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 == 0) goto L_0x0020
                    goto L_0x00c9
                L_0x0020:
                    boolean r4 = r3.isCut()
                    r5 = 1
                    if (r4 != 0) goto L_0x0039
                    boolean r4 = r3.isCompressed()
                    if (r4 != 0) goto L_0x0039
                    java.lang.String r4 = r3.getAndroidQToPath()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 == 0) goto L_0x0039
                    r4 = r5
                    goto L_0x003a
                L_0x0039:
                    r4 = r1
                L_0x003a:
                    if (r4 == 0) goto L_0x0079
                    java.lang.String r4 = r3.getPath()
                    boolean r4 = com.luck.picture.lib.config.PictureMimeType.isContent(r4)
                    if (r4 == 0) goto L_0x0079
                    java.lang.String r4 = r3.getPath()
                    boolean r4 = com.luck.picture.lib.config.PictureMimeType.isHasHttp(r4)
                    if (r4 != 0) goto L_0x008c
                    com.luck.picture.lib.PictureBaseActivity r4 = com.luck.picture.lib.PictureBaseActivity.this
                    android.content.Context r6 = r4.getContext()
                    long r7 = r3.getId()
                    java.lang.String r9 = r3.getPath()
                    int r10 = r3.getWidth()
                    int r11 = r3.getHeight()
                    java.lang.String r12 = r3.getMimeType()
                    com.luck.picture.lib.PictureBaseActivity r4 = com.luck.picture.lib.PictureBaseActivity.this
                    com.luck.picture.lib.config.PictureSelectionConfig r4 = r4.config
                    java.lang.String r13 = r4.cameraFileName
                    java.lang.String r4 = com.luck.picture.lib.tools.AndroidQTransformUtils.copyPathToAndroidQ(r6, r7, r9, r10, r11, r12, r13)
                    r3.setAndroidQToPath(r4)
                    r4 = r5
                    goto L_0x008d
                L_0x0079:
                    boolean r4 = r3.isCut()
                    if (r4 == 0) goto L_0x008c
                    boolean r4 = r3.isCompressed()
                    if (r4 == 0) goto L_0x008c
                    java.lang.String r4 = r3.getCompressPath()
                    r3.setAndroidQToPath(r4)
                L_0x008c:
                    r4 = r1
                L_0x008d:
                    com.luck.picture.lib.PictureBaseActivity r6 = com.luck.picture.lib.PictureBaseActivity.this
                    com.luck.picture.lib.config.PictureSelectionConfig r6 = r6.config
                    boolean r6 = r6.isCheckOriginalImage
                    if (r6 == 0) goto L_0x00c9
                    r3.setOriginal(r5)
                    if (r4 == 0) goto L_0x00a2
                    java.lang.String r4 = r3.getAndroidQToPath()
                    r3.setOriginalPath(r4)
                    goto L_0x00c9
                L_0x00a2:
                    com.luck.picture.lib.PictureBaseActivity r4 = com.luck.picture.lib.PictureBaseActivity.this
                    android.content.Context r5 = r4.getContext()
                    long r6 = r3.getId()
                    java.lang.String r8 = r3.getPath()
                    int r9 = r3.getWidth()
                    int r10 = r3.getHeight()
                    java.lang.String r11 = r3.getMimeType()
                    com.luck.picture.lib.PictureBaseActivity r4 = com.luck.picture.lib.PictureBaseActivity.this
                    com.luck.picture.lib.config.PictureSelectionConfig r4 = r4.config
                    java.lang.String r12 = r4.cameraFileName
                    java.lang.String r4 = com.luck.picture.lib.tools.AndroidQTransformUtils.copyPathToAndroidQ(r5, r6, r8, r9, r10, r11, r12)
                    r3.setOriginalPath(r4)
                L_0x00c9:
                    int r2 = r2 + 1
                    goto L_0x0008
                L_0x00cd:
                    java.util.List r0 = r2
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureBaseActivity.AnonymousClass4.doInBackground():java.util.List");
            }

            public void onSuccess(List<LocalMedia> list) {
                PictureBaseActivity.this.dismissDialog();
                if (list != null) {
                    if (PictureBaseActivity.this.config.camera && PictureBaseActivity.this.config.selectionMode == 2) {
                        list.addAll(list.size() > 0 ? list.size() - 1 : 0, PictureBaseActivity.this.selectionMedias);
                    }
                    if (PictureSelectionConfig.listener != null) {
                        PictureSelectionConfig.listener.onResult(list);
                    } else {
                        PictureBaseActivity.this.setResult(-1, PictureSelector.putIntentResult(list));
                    }
                    PictureBaseActivity.this.exit();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void exit() {
        finish();
        if (this.config.camera) {
            overridePendingTransition(0, R.anim.picture_anim_fade_out);
            if ((getContext() instanceof PictureSelectorCameraEmptyActivity) || (getContext() instanceof PictureCustomCameraActivity)) {
                releaseResultListener();
                return;
            }
            return;
        }
        overridePendingTransition(0, PictureSelectionConfig.windowAnimationStyle.activityExitAnimation);
        if (getContext() instanceof PictureSelectorActivity) {
            releaseResultListener();
            if (this.config.openClickSound) {
                VoiceUtils.getInstance().releaseSoundPool();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        PictureLoadingDialog pictureLoadingDialog = this.mLoadingDialog;
        if (pictureLoadingDialog != null) {
            pictureLoadingDialog.dismiss();
            this.mLoadingDialog = null;
        }
        PictureBaseActivity.super.onDestroy();
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: protected */
    public String getAudioPath(Intent intent) {
        try {
            Uri data = intent.getData();
            if (data == null) {
                return "";
            }
            if (PictureMimeType.isContent(data.toString())) {
                return data.toString();
            }
            return data.getPath();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [android.content.Context, com.luck.picture.lib.PictureBaseActivity] */
    /* access modifiers changed from: protected */
    public void startOpenCameraImage() {
        Uri uri;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            String str = null;
            String str2 = TextUtils.isEmpty(this.config.cameraImageFormat) ? this.config.suffixType : this.config.cameraImageFormat;
            int i = this.config.chooseMode == 0 ? 1 : this.config.chooseMode;
            if (!TextUtils.isEmpty(this.config.cameraFileName)) {
                boolean isSuffixOfImage = PictureMimeType.isSuffixOfImage(this.config.cameraFileName);
                PictureSelectionConfig pictureSelectionConfig = this.config;
                pictureSelectionConfig.cameraFileName = !isSuffixOfImage ? StringUtils.renameSuffix(pictureSelectionConfig.cameraFileName, PictureMimeType.JPG) : pictureSelectionConfig.cameraFileName;
                str = this.config.camera ? this.config.cameraFileName : StringUtils.rename(this.config.cameraFileName);
            }
            if (SdkVersionUtils.checkedAndroid_Q()) {
                if (TextUtils.isEmpty(this.config.outPutCameraPath)) {
                    uri = MediaUtils.createImageUri(this, this.config.cameraFileName, str2);
                } else {
                    File createCameraFile = PictureFileUtils.createCameraFile(this, i, str, str2, this.config.outPutCameraPath);
                    this.config.cameraPath = createCameraFile.getAbsolutePath();
                    uri = PictureFileUtils.parUri(this, createCameraFile);
                }
                if (uri != null) {
                    this.config.cameraPath = uri.toString();
                }
            } else {
                File createCameraFile2 = PictureFileUtils.createCameraFile(this, i, str, str2, this.config.outPutCameraPath);
                this.config.cameraPath = createCameraFile2.getAbsolutePath();
                uri = PictureFileUtils.parUri(this, createCameraFile2);
            }
            if (uri == null) {
                ToastUtils.s(getContext(), "open is camera error，the uri is empty ");
                if (this.config.camera) {
                    exit();
                    return;
                }
                return;
            }
            this.config.cameraMimeType = PictureMimeType.ofImage();
            if (this.config.isCameraAroundState) {
                intent.putExtra(PictureConfig.CAMERA_FACING, 1);
            }
            intent.putExtra("output", uri);
            startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [android.content.Context, com.luck.picture.lib.PictureBaseActivity] */
    /* access modifiers changed from: protected */
    public void startOpenCameraVideo() {
        Uri uri;
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            String str = null;
            String str2 = TextUtils.isEmpty(this.config.cameraVideoFormat) ? this.config.suffixType : this.config.cameraVideoFormat;
            int i = this.config.chooseMode == 0 ? 2 : this.config.chooseMode;
            if (!TextUtils.isEmpty(this.config.cameraFileName)) {
                boolean isSuffixOfImage = PictureMimeType.isSuffixOfImage(this.config.cameraFileName);
                PictureSelectionConfig pictureSelectionConfig = this.config;
                pictureSelectionConfig.cameraFileName = isSuffixOfImage ? StringUtils.renameSuffix(pictureSelectionConfig.cameraFileName, ".mp4") : pictureSelectionConfig.cameraFileName;
                str = this.config.camera ? this.config.cameraFileName : StringUtils.rename(this.config.cameraFileName);
            }
            if (SdkVersionUtils.checkedAndroid_Q()) {
                if (TextUtils.isEmpty(this.config.outPutCameraPath)) {
                    uri = MediaUtils.createVideoUri(this, this.config.cameraFileName, str2);
                } else {
                    File createCameraFile = PictureFileUtils.createCameraFile(this, i, str, str2, this.config.outPutCameraPath);
                    this.config.cameraPath = createCameraFile.getAbsolutePath();
                    uri = PictureFileUtils.parUri(this, createCameraFile);
                }
                if (uri != null) {
                    this.config.cameraPath = uri.toString();
                }
            } else {
                File createCameraFile2 = PictureFileUtils.createCameraFile(this, i, str, str2, this.config.outPutCameraPath);
                this.config.cameraPath = createCameraFile2.getAbsolutePath();
                uri = PictureFileUtils.parUri(this, createCameraFile2);
            }
            if (uri == null) {
                ToastUtils.s(getContext(), "open is camera error，the uri is empty ");
                if (this.config.camera) {
                    exit();
                    return;
                }
                return;
            }
            this.config.cameraMimeType = PictureMimeType.ofVideo();
            intent.putExtra("output", uri);
            if (this.config.isCameraAroundState) {
                intent.putExtra(PictureConfig.CAMERA_FACING, 1);
            }
            intent.putExtra(PictureConfig.EXTRA_QUICK_CAPTURE, this.config.isQuickCapture);
            intent.putExtra("android.intent.extra.durationLimit", this.config.recordVideoSecond);
            intent.putExtra("android.intent.extra.videoQuality", this.config.videoQuality);
            startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, android.app.Activity, com.luck.picture.lib.PictureBaseActivity] */
    public void startOpenCameraAudio() {
        try {
            if (PermissionChecker.checkSelfPermission((Context) this, "android.permission.RECORD_AUDIO")) {
                Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    this.config.cameraMimeType = PictureMimeType.ofAudio();
                    String str = TextUtils.isEmpty(this.config.cameraAudioFormat) ? this.config.suffixType : this.config.cameraAudioFormat;
                    if (SdkVersionUtils.checkedAndroid_Q()) {
                        Uri createAudioUri = MediaUtils.createAudioUri(this, str);
                        if (createAudioUri == null) {
                            ToastUtils.s(getContext(), "open is audio error，the uri is empty ");
                            if (this.config.camera) {
                                exit();
                                return;
                            }
                            return;
                        }
                        this.config.cameraPath = createAudioUri.toString();
                        intent.putExtra("output", createAudioUri);
                    }
                    startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
                    return;
                }
                ToastUtils.s(getContext(), "System recording is not supported");
                return;
            }
            PermissionChecker.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 3);
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtils.s(getContext(), e.getMessage());
        }
    }

    private void releaseResultListener() {
        if (this.config != null) {
            PictureSelectionConfig.destroy();
            LocalMediaPageLoader.setInstanceNull();
            PictureThreadUtils.cancel(PictureThreadUtils.getSinglePool());
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        PictureBaseActivity.super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 3) {
            return;
        }
        if (iArr[0] == 0) {
            Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
                return;
            }
            return;
        }
        ToastUtils.s(getContext(), getString(R.string.picture_audio));
    }

    /* access modifiers changed from: protected */
    public void showPromptDialog(String str) {
        if (isFinishing()) {
            return;
        }
        if (PictureSelectionConfig.onChooseLimitCallback != null) {
            PictureSelectionConfig.onChooseLimitCallback.onChooseLimit(getContext(), str);
            return;
        }
        final PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(getContext(), R.layout.picture_prompt_dialog);
        ((TextView) pictureCustomDialog.findViewById(R.id.tv_content)).setText(str);
        ((TextView) pictureCustomDialog.findViewById(R.id.btnOk)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, PictureBaseActivity.class);
                if (!PictureBaseActivity.this.isFinishing()) {
                    pictureCustomDialog.dismiss();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        pictureCustomDialog.show();
    }

    /* access modifiers changed from: protected */
    public void sortFolder(List<LocalMediaFolder> list) {
        Collections.sort(list, PictureBaseActivity$$ExternalSyntheticLambda0.INSTANCE);
    }

    static /* synthetic */ int lambda$sortFolder$0(LocalMediaFolder localMediaFolder, LocalMediaFolder localMediaFolder2) {
        if (localMediaFolder.getData() == null || localMediaFolder2.getData() == null) {
            return 0;
        }
        return Integer.compare(localMediaFolder2.getImageNum(), localMediaFolder.getImageNum());
    }
}
