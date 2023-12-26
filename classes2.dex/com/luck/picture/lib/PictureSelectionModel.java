package com.luck.picture.lib;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.engine.CacheResourcesEngine;
import com.luck.picture.lib.engine.CompressEngine;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnChooseLimitCallback;
import com.luck.picture.lib.listener.OnCustomCameraInterfaceListener;
import com.luck.picture.lib.listener.OnCustomImagePreviewCallback;
import com.luck.picture.lib.listener.OnPermissionsObtainCallback;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.luck.picture.lib.listener.OnVideoSelectedPlayCallback;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.style.PictureSelectorUIStyle;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.tools.DoubleUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.yalantis.ucrop.UCrop;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class PictureSelectionModel {
    private final PictureSelectionConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionModel(PictureSelector pictureSelector, int i) {
        this.selector = pictureSelector;
        PictureSelectionConfig cleanInstance = PictureSelectionConfig.getCleanInstance();
        this.selectionConfig = cleanInstance;
        cleanInstance.chooseMode = i;
    }

    public PictureSelectionModel(PictureSelector pictureSelector, int i, boolean z) {
        this.selector = pictureSelector;
        PictureSelectionConfig cleanInstance = PictureSelectionConfig.getCleanInstance();
        this.selectionConfig = cleanInstance;
        cleanInstance.camera = z;
        cleanInstance.chooseMode = i;
    }

    public PictureSelectionModel theme(int i) {
        this.selectionConfig.themeStyleId = i;
        return this;
    }

    public PictureSelectionModel setPictureUIStyle(PictureSelectorUIStyle pictureSelectorUIStyle) {
        if (pictureSelectorUIStyle != null) {
            PictureSelectionConfig.uiStyle = pictureSelectorUIStyle;
            if (!this.selectionConfig.isWeChatStyle) {
                this.selectionConfig.isWeChatStyle = PictureSelectionConfig.uiStyle.isNewSelectStyle;
            }
        }
        return this;
    }

    public PictureSelectionModel setLanguage(int i) {
        this.selectionConfig.language = i;
        return this;
    }

    public PictureSelectionModel setRequestedOrientation(int i) {
        this.selectionConfig.requestedOrientation = i;
        return this;
    }

    @Deprecated
    public PictureSelectionModel loadImageEngine(ImageEngine imageEngine) {
        if (PictureSelectionConfig.imageEngine != imageEngine) {
            PictureSelectionConfig.imageEngine = imageEngine;
        }
        return this;
    }

    public PictureSelectionModel imageEngine(ImageEngine imageEngine) {
        if (PictureSelectionConfig.imageEngine != imageEngine) {
            PictureSelectionConfig.imageEngine = imageEngine;
        }
        return this;
    }

    public PictureSelectionModel compressEngine(CompressEngine compressEngine) {
        if (PictureSelectionConfig.compressEngine != compressEngine) {
            PictureSelectionConfig.compressEngine = compressEngine;
        }
        return this;
    }

    @Deprecated
    public PictureSelectionModel loadCacheResourcesCallback(CacheResourcesEngine cacheResourcesEngine) {
        if (SdkVersionUtils.checkedAndroid_Q() && PictureSelectionConfig.cacheResourcesEngine != cacheResourcesEngine) {
            PictureSelectionConfig.cacheResourcesEngine = (CacheResourcesEngine) new WeakReference(cacheResourcesEngine).get();
        }
        return this;
    }

    public PictureSelectionModel selectionMode(int i) {
        this.selectionConfig.selectionMode = i;
        return this;
    }

    public PictureSelectionModel isWeChatStyle(boolean z) {
        this.selectionConfig.isWeChatStyle = z;
        return this;
    }

    public PictureSelectionModel isUseCustomCamera(boolean z) {
        this.selectionConfig.isUseCustomCamera = Build.VERSION.SDK_INT > 19 && z;
        return this;
    }

    public PictureSelectionModel bindCustomPlayVideoCallback(OnVideoSelectedPlayCallback<LocalMedia> onVideoSelectedPlayCallback) {
        PictureSelectionConfig.customVideoPlayCallback = (OnVideoSelectedPlayCallback) new WeakReference(onVideoSelectedPlayCallback).get();
        return this;
    }

    public PictureSelectionModel bindCustomPreviewCallback(OnCustomImagePreviewCallback<LocalMedia> onCustomImagePreviewCallback) {
        PictureSelectionConfig.onCustomImagePreviewCallback = (OnCustomImagePreviewCallback) new WeakReference(onCustomImagePreviewCallback).get();
        return this;
    }

    @Deprecated
    public PictureSelectionModel bindPictureSelectorInterfaceListener(OnCustomCameraInterfaceListener onCustomCameraInterfaceListener) {
        PictureSelectionConfig.onCustomCameraInterfaceListener = (OnCustomCameraInterfaceListener) new WeakReference(onCustomCameraInterfaceListener).get();
        return this;
    }

    public PictureSelectionModel bindCustomCameraInterfaceListener(OnCustomCameraInterfaceListener onCustomCameraInterfaceListener) {
        PictureSelectionConfig.onCustomCameraInterfaceListener = (OnCustomCameraInterfaceListener) new WeakReference(onCustomCameraInterfaceListener).get();
        return this;
    }

    public PictureSelectionModel bindCustomPermissionsObtainListener(OnPermissionsObtainCallback onPermissionsObtainCallback) {
        PictureSelectionConfig.onPermissionsObtainCallback = (OnPermissionsObtainCallback) new WeakReference(onPermissionsObtainCallback).get();
        return this;
    }

    public PictureSelectionModel bindCustomChooseLimitListener(OnChooseLimitCallback onChooseLimitCallback) {
        PictureSelectionConfig.onChooseLimitCallback = (OnChooseLimitCallback) new WeakReference(onChooseLimitCallback).get();
        return this;
    }

    public PictureSelectionModel setButtonFeatures(int i) {
        this.selectionConfig.buttonFeatures = i;
        return this;
    }

    public PictureSelectionModel setCaptureLoadingColor(int i) {
        this.selectionConfig.captureLoadingColor = i;
        return this;
    }

    @Deprecated
    public PictureSelectionModel enableCrop(boolean z) {
        this.selectionConfig.enableCrop = z;
        return this;
    }

    public PictureSelectionModel isEnableCrop(boolean z) {
        this.selectionConfig.enableCrop = z;
        return this;
    }

    public PictureSelectionModel basicUCropConfig(UCrop.Options options) {
        this.selectionConfig.uCropOptions = options;
        return this;
    }

    public PictureSelectionModel isMultipleSkipCrop(boolean z) {
        this.selectionConfig.isMultipleSkipCrop = z;
        return this;
    }

    @Deprecated
    public PictureSelectionModel enablePreviewAudio(boolean z) {
        this.selectionConfig.enablePreviewAudio = z;
        return this;
    }

    public PictureSelectionModel isEnablePreviewAudio(boolean z) {
        this.selectionConfig.enablePreviewAudio = z;
        return this;
    }

    @Deprecated
    public PictureSelectionModel freeStyleCropEnabled(boolean z) {
        this.selectionConfig.freeStyleCropEnabled = z;
        return this;
    }

    public PictureSelectionModel freeStyleCropMode(int i) {
        this.selectionConfig.freeStyleCropMode = i;
        return this;
    }

    public PictureSelectionModel isCropDragSmoothToCenter(boolean z) {
        this.selectionConfig.isDragCenter = z;
        return this;
    }

    public PictureSelectionModel scaleEnabled(boolean z) {
        this.selectionConfig.scaleEnabled = z;
        return this;
    }

    public PictureSelectionModel rotateEnabled(boolean z) {
        this.selectionConfig.rotateEnabled = z;
        return this;
    }

    public PictureSelectionModel circleDimmedLayer(boolean z) {
        this.selectionConfig.circleDimmedLayer = z;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCircleDimmedColor(int i) {
        this.selectionConfig.circleDimmedColor = i;
        return this;
    }

    public PictureSelectionModel setCropDimmedColor(int i) {
        this.selectionConfig.circleDimmedColor = i;
        return this;
    }

    public PictureSelectionModel setCircleDimmedBorderColor(int i) {
        this.selectionConfig.circleDimmedBorderColor = i;
        return this;
    }

    public PictureSelectionModel setCircleStrokeWidth(int i) {
        this.selectionConfig.circleStrokeWidth = i;
        return this;
    }

    public PictureSelectionModel showCropFrame(boolean z) {
        this.selectionConfig.showCropFrame = z;
        return this;
    }

    public PictureSelectionModel showCropGrid(boolean z) {
        this.selectionConfig.showCropGrid = z;
        return this;
    }

    public PictureSelectionModel hideBottomControls(boolean z) {
        this.selectionConfig.hideBottomControls = z;
        return this;
    }

    public PictureSelectionModel withAspectRatio(int i, int i2) {
        this.selectionConfig.aspect_ratio_x = i;
        this.selectionConfig.aspect_ratio_y = i2;
        return this;
    }

    public PictureSelectionModel isWithVideoImage(boolean z) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        boolean z2 = true;
        if (pictureSelectionConfig.selectionMode == 1 || this.selectionConfig.chooseMode != PictureMimeType.ofAll() || !z) {
            z2 = false;
        }
        pictureSelectionConfig.isWithVideoImage = z2;
        return this;
    }

    public PictureSelectionModel isMaxSelectEnabledMask(boolean z) {
        this.selectionConfig.isMaxSelectEnabledMask = z;
        return this;
    }

    public PictureSelectionModel isSyncCover(boolean z) {
        this.selectionConfig.isSyncCover = z;
        return this;
    }

    public PictureSelectionModel maxSelectNum(int i) {
        this.selectionConfig.maxSelectNum = i;
        return this;
    }

    public PictureSelectionModel minSelectNum(int i) {
        this.selectionConfig.minSelectNum = i;
        return this;
    }

    public PictureSelectionModel maxVideoSelectNum(int i) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        if (pictureSelectionConfig.chooseMode == PictureMimeType.ofVideo()) {
            i = 0;
        }
        pictureSelectionConfig.maxVideoSelectNum = i;
        return this;
    }

    public PictureSelectionModel minVideoSelectNum(int i) {
        this.selectionConfig.minVideoSelectNum = i;
        return this;
    }

    @Deprecated
    public PictureSelectionModel closeAndroidQChangeWH(boolean z) {
        this.selectionConfig.isAndroidQChangeWH = z;
        return this;
    }

    @Deprecated
    public PictureSelectionModel closeAndroidQChangeVideoWH(boolean z) {
        this.selectionConfig.isAndroidQChangeVideoWH = z;
        return this;
    }

    public PictureSelectionModel isAutomaticTitleRecyclerTop(boolean z) {
        this.selectionConfig.isAutomaticTitleRecyclerTop = z;
        return this;
    }

    public PictureSelectionModel isSingleDirectReturn(boolean z) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        boolean z2 = false;
        pictureSelectionConfig.isSingleDirectReturn = pictureSelectionConfig.selectionMode == 1 && z;
        PictureSelectionConfig pictureSelectionConfig2 = this.selectionConfig;
        if ((pictureSelectionConfig2.selectionMode != 1 || !z) && this.selectionConfig.isOriginalControl) {
            z2 = true;
        }
        pictureSelectionConfig2.isOriginalControl = z2;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean z, int i) {
        this.selectionConfig.isPageStrategy = z;
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        if (i < 10) {
            i = 60;
        }
        pictureSelectionConfig.pageSize = i;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean z, int i, boolean z2) {
        this.selectionConfig.isPageStrategy = z;
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        if (i < 10) {
            i = 60;
        }
        pictureSelectionConfig.pageSize = i;
        this.selectionConfig.isFilterInvalidFile = z2;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean z) {
        this.selectionConfig.isPageStrategy = z;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean z, boolean z2) {
        this.selectionConfig.isPageStrategy = z;
        this.selectionConfig.isFilterInvalidFile = z2;
        return this;
    }

    public PictureSelectionModel videoQuality(int i) {
        this.selectionConfig.videoQuality = i;
        return this;
    }

    @Deprecated
    public PictureSelectionModel imageFormat(String str) {
        if (SdkVersionUtils.checkedAndroid_Q() || SdkVersionUtils.checkedAndroid_R()) {
            if (TextUtils.equals(str, PictureMimeType.PNG)) {
                str = PictureMimeType.PNG_Q;
            }
            if (TextUtils.equals(str, PictureMimeType.JPG) || TextUtils.equals(str, ".jpeg")) {
                str = "image/jpeg";
            }
            if (TextUtils.equals(str, ".mp4")) {
                str = "video/mp4";
            }
        }
        this.selectionConfig.suffixType = str;
        return this;
    }

    public PictureSelectionModel setCameraImageFormat(String str) {
        if (SdkVersionUtils.checkedAndroid_Q() || SdkVersionUtils.checkedAndroid_R()) {
            if (TextUtils.equals(str, PictureMimeType.PNG)) {
                str = PictureMimeType.PNG_Q;
            }
            if (TextUtils.equals(str, PictureMimeType.JPG) || TextUtils.equals(str, ".jpeg")) {
                str = "image/jpeg";
            }
        }
        this.selectionConfig.cameraImageFormat = str;
        return this;
    }

    public PictureSelectionModel setCameraVideoFormat(String str) {
        if (SdkVersionUtils.checkedAndroid_Q() || SdkVersionUtils.checkedAndroid_R()) {
            if (TextUtils.equals(str, ".mp4")) {
                str = "video/mp4";
            }
            if (TextUtils.equals(str, PictureMimeType.AVI)) {
                str = PictureMimeType.AVI_Q;
            }
        }
        this.selectionConfig.cameraVideoFormat = str;
        return this;
    }

    public PictureSelectionModel setCameraAudioFormat(String str) {
        if (SdkVersionUtils.checkedAndroid_Q() || SdkVersionUtils.checkedAndroid_R()) {
            if (TextUtils.equals(str, ".amr")) {
                str = "audio/amr";
            }
            if (TextUtils.equals(str, PictureMimeType.WAV)) {
                str = PictureMimeType.WAV_Q;
            }
            if (TextUtils.equals(str, PictureMimeType.MP3)) {
                str = "audio/mpeg";
            }
        }
        this.selectionConfig.cameraAudioFormat = str;
        return this;
    }

    @Deprecated
    public PictureSelectionModel cropWH(int i, int i2) {
        this.selectionConfig.cropWidth = i;
        this.selectionConfig.cropHeight = i2;
        return this;
    }

    public PictureSelectionModel cropImageWideHigh(int i, int i2) {
        this.selectionConfig.cropWidth = i;
        this.selectionConfig.cropHeight = i2;
        return this;
    }

    public PictureSelectionModel videoMaxSecond(int i) {
        this.selectionConfig.videoMaxSecond = i * ResultCode.KARAOKE_SUCCESS;
        return this;
    }

    public PictureSelectionModel videoMinSecond(int i) {
        this.selectionConfig.videoMinSecond = i * ResultCode.KARAOKE_SUCCESS;
        return this;
    }

    public PictureSelectionModel recordVideoSecond(int i) {
        this.selectionConfig.recordVideoSecond = i;
        return this;
    }

    public PictureSelectionModel recordVideoMinSecond(int i) {
        this.selectionConfig.recordVideoMinSecond = i;
        return this;
    }

    @Deprecated
    public PictureSelectionModel glideOverride(int i, int i2) {
        this.selectionConfig.overrideWidth = i;
        this.selectionConfig.overrideHeight = i2;
        return this;
    }

    @Deprecated
    public PictureSelectionModel sizeMultiplier(float f) {
        this.selectionConfig.sizeMultiplier = f;
        return this;
    }

    public PictureSelectionModel imageSpanCount(int i) {
        this.selectionConfig.imageSpanCount = i;
        return this;
    }

    public PictureSelectionModel minimumCompressSize(int i) {
        this.selectionConfig.minimumCompressSize = i;
        return this;
    }

    @Deprecated
    public PictureSelectionModel cropCompressQuality(int i) {
        this.selectionConfig.cropCompressQuality = i;
        return this;
    }

    public PictureSelectionModel cutOutQuality(int i) {
        this.selectionConfig.cropCompressQuality = i;
        return this;
    }

    public PictureSelectionModel cutCompressFormat(String str) {
        this.selectionConfig.cropCompressFormat = str;
        return this;
    }

    @Deprecated
    public PictureSelectionModel compress(boolean z) {
        this.selectionConfig.isCompress = z;
        return this;
    }

    public PictureSelectionModel isCompress(boolean z) {
        this.selectionConfig.isCompress = z;
        return this;
    }

    public PictureSelectionModel compressQuality(int i) {
        this.selectionConfig.compressQuality = i;
        return this;
    }

    public PictureSelectionModel isReturnEmpty(boolean z) {
        this.selectionConfig.returnEmpty = z;
        return this;
    }

    public PictureSelectionModel synOrAsy(boolean z) {
        this.selectionConfig.synOrAsy = z;
        return this;
    }

    @Deprecated
    public PictureSelectionModel compressFocusAlpha(boolean z) {
        this.selectionConfig.focusAlpha = z;
        return this;
    }

    public PictureSelectionModel isQuickCapture(boolean z) {
        this.selectionConfig.isQuickCapture = z;
        return this;
    }

    public PictureSelectionModel isOriginalImageControl(boolean z) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.isOriginalControl = !pictureSelectionConfig.camera && this.selectionConfig.chooseMode != PictureMimeType.ofVideo() && this.selectionConfig.chooseMode != PictureMimeType.ofAudio() && z;
        return this;
    }

    public PictureSelectionModel isDisplayOriginalSize(boolean z) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.isDisplayOriginalSize = !pictureSelectionConfig.camera && z;
        return this;
    }

    public PictureSelectionModel isEditorImage(boolean z) {
        this.selectionConfig.isEditorImage = z;
        return this;
    }

    public PictureSelectionModel compressSavePath(String str) {
        this.selectionConfig.compressSavePath = str;
        return this;
    }

    public PictureSelectionModel cameraFileName(String str) {
        this.selectionConfig.cameraFileName = str;
        return this;
    }

    public PictureSelectionModel renameCropFileName(String str) {
        this.selectionConfig.renameCropFileName = str;
        return this;
    }

    public PictureSelectionModel renameCompressFile(String str) {
        this.selectionConfig.renameCompressFileName = str;
        return this;
    }

    public PictureSelectionModel isZoomAnim(boolean z) {
        this.selectionConfig.zoomAnim = z;
        return this;
    }

    @Deprecated
    public PictureSelectionModel previewEggs(boolean z) {
        this.selectionConfig.previewEggs = z;
        return this;
    }

    public PictureSelectionModel isPreviewEggs(boolean z) {
        this.selectionConfig.previewEggs = z;
        return this;
    }

    public PictureSelectionModel isAutoScalePreviewImage(boolean z) {
        this.selectionConfig.isAutoScalePreviewImage = z;
        return this;
    }

    public PictureSelectionModel isCamera(boolean z) {
        this.selectionConfig.isCamera = z;
        return this;
    }

    public PictureSelectionModel setOutputCameraPath(String str) {
        this.selectionConfig.outPutCameraPath = str;
        return this;
    }

    @Deprecated
    public PictureSelectionModel queryFileSize(float f) {
        this.selectionConfig.filterFileSize = f;
        return this;
    }

    @Deprecated
    public PictureSelectionModel queryMaxFileSize(float f) {
        this.selectionConfig.filterFileSize = f;
        return this;
    }

    public PictureSelectionModel filterMaxFileSize(long j) {
        if (j >= PictureConfig.MB) {
            this.selectionConfig.filterMaxFileSize = j;
        } else {
            this.selectionConfig.filterMaxFileSize = j * 1024;
        }
        return this;
    }

    public PictureSelectionModel filterMinFileSize(long j) {
        if (j >= PictureConfig.MB) {
            this.selectionConfig.filterMinFileSize = j;
        } else {
            this.selectionConfig.filterMinFileSize = j * 1024;
        }
        return this;
    }

    public PictureSelectionModel queryMimeTypeConditions(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            this.selectionConfig.queryMimeTypeHashSet = null;
        } else {
            this.selectionConfig.queryMimeTypeHashSet = new HashSet<>(Arrays.asList(strArr));
        }
        return this;
    }

    public PictureSelectionModel isGif(boolean z) {
        this.selectionConfig.isGif = z;
        return this;
    }

    public PictureSelectionModel isWebp(boolean z) {
        this.selectionConfig.isWebp = z;
        return this;
    }

    public PictureSelectionModel isBmp(boolean z) {
        this.selectionConfig.isBmp = z;
        return this;
    }

    @Deprecated
    public PictureSelectionModel previewImage(boolean z) {
        this.selectionConfig.enablePreview = z;
        return this;
    }

    public PictureSelectionModel isPreviewImage(boolean z) {
        this.selectionConfig.enablePreview = z;
        return this;
    }

    @Deprecated
    public PictureSelectionModel previewVideo(boolean z) {
        this.selectionConfig.enPreviewVideo = z;
        return this;
    }

    public PictureSelectionModel isPreviewVideo(boolean z) {
        this.selectionConfig.enPreviewVideo = z;
        return this;
    }

    public PictureSelectionModel isCallbackCloseCamera(boolean z) {
        this.selectionConfig.isCallBackCloseCamera = z;
        return this;
    }

    public PictureSelectionModel isNotPreviewDownload(boolean z) {
        this.selectionConfig.isNotPreviewDownload = z;
        return this;
    }

    @Deprecated
    public PictureSelectionModel querySpecifiedFormatSuffix(String str) {
        this.selectionConfig.specifiedFormat = str;
        return this;
    }

    @Deprecated
    public PictureSelectionModel openClickSound(boolean z) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.openClickSound = !pictureSelectionConfig.camera && z;
        return this;
    }

    public PictureSelectionModel isOpenClickSound(boolean z) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.openClickSound = !pictureSelectionConfig.camera && z;
        return this;
    }

    public PictureSelectionModel isDragFrame(boolean z) {
        this.selectionConfig.isDragFrame = z;
        return this;
    }

    public PictureSelectionModel isMultipleRecyclerAnimation(boolean z) {
        this.selectionConfig.isMultipleRecyclerAnimation = z;
        return this;
    }

    public PictureSelectionModel isCameraAroundState(boolean z) {
        this.selectionConfig.isCameraAroundState = z;
        return this;
    }

    public PictureSelectionModel isCameraRotateImage(boolean z) {
        this.selectionConfig.isCameraRotateImage = z;
        return this;
    }

    public PictureSelectionModel isAutoRotating(boolean z) {
        this.selectionConfig.isAutoRotating = z;
        return this;
    }

    @Deprecated
    public PictureSelectionModel selectionMedia(List<LocalMedia> list) {
        if (this.selectionConfig.selectionMode != 1 || !this.selectionConfig.isSingleDirectReturn) {
            this.selectionConfig.selectionMedias = list;
        } else {
            this.selectionConfig.selectionMedias = null;
        }
        return this;
    }

    public PictureSelectionModel selectionData(List<LocalMedia> list) {
        if (this.selectionConfig.selectionMode != 1 || !this.selectionConfig.isSingleDirectReturn) {
            this.selectionConfig.selectionMedias = list;
        } else {
            this.selectionConfig.selectionMedias = null;
        }
        return this;
    }

    @Deprecated
    public PictureSelectionModel isChangeStatusBarFontColor(boolean z) {
        this.selectionConfig.isChangeStatusBarFontColor = z;
        return this;
    }

    @Deprecated
    public PictureSelectionModel isOpenStyleNumComplete(boolean z) {
        this.selectionConfig.isOpenStyleNumComplete = z;
        return this;
    }

    @Deprecated
    public PictureSelectionModel isOpenStyleCheckNumMode(boolean z) {
        this.selectionConfig.isOpenStyleCheckNumMode = z;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setTitleBarBackgroundColor(int i) {
        this.selectionConfig.titleBarBackgroundColor = i;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setStatusBarColorPrimaryDark(int i) {
        this.selectionConfig.pictureStatusBarColor = i;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCropTitleBarBackgroundColor(int i) {
        this.selectionConfig.cropTitleBarBackgroundColor = i;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCropStatusBarColorPrimaryDark(int i) {
        this.selectionConfig.cropStatusBarColorPrimaryDark = i;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCropTitleColor(int i) {
        this.selectionConfig.cropTitleColor = i;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setUpArrowDrawable(int i) {
        this.selectionConfig.upResId = i;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setDownArrowDrawable(int i) {
        this.selectionConfig.downResId = i;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setPictureCropStyle(PictureCropParameterStyle pictureCropParameterStyle) {
        if (pictureCropParameterStyle != null) {
            PictureSelectionConfig.cropStyle = pictureCropParameterStyle;
        } else {
            PictureSelectionConfig.cropStyle = PictureCropParameterStyle.ofDefaultCropStyle();
        }
        return this;
    }

    @Deprecated
    public PictureSelectionModel setPictureStyle(PictureParameterStyle pictureParameterStyle) {
        if (pictureParameterStyle != null) {
            PictureSelectionConfig.style = pictureParameterStyle;
            if (!this.selectionConfig.isWeChatStyle) {
                this.selectionConfig.isWeChatStyle = pictureParameterStyle.isNewSelectStyle;
            }
        } else {
            PictureSelectionConfig.style = PictureParameterStyle.ofDefaultStyle();
        }
        return this;
    }

    public PictureSelectionModel setPictureWindowAnimationStyle(PictureWindowAnimationStyle pictureWindowAnimationStyle) {
        if (pictureWindowAnimationStyle != null) {
            PictureSelectionConfig.windowAnimationStyle = pictureWindowAnimationStyle;
        } else {
            PictureSelectionConfig.windowAnimationStyle = PictureWindowAnimationStyle.ofDefaultWindowAnimationStyle();
        }
        return this;
    }

    public PictureSelectionModel setRecyclerAnimationMode(int i) {
        this.selectionConfig.animationMode = i;
        return this;
    }

    public PictureSelectionModel isAndroidQTransform(boolean z) {
        this.selectionConfig.isAndroidQTransform = z;
        return this;
    }

    public PictureSelectionModel isFallbackVersion(boolean z) {
        this.selectionConfig.isFallbackVersion = z;
        return this;
    }

    public PictureSelectionModel isFallbackVersion2(boolean z) {
        this.selectionConfig.isFallbackVersion2 = z;
        return this;
    }

    public PictureSelectionModel isFallbackVersion3(boolean z) {
        this.selectionConfig.isFallbackVersion3 = z;
        return this;
    }

    public void forResult(int i) {
        Activity activity;
        PictureSelectionConfig pictureSelectionConfig;
        Intent intent;
        if (!DoubleUtils.isFastDoubleClick() && (activity = this.selector.getActivity()) != null && (pictureSelectionConfig = this.selectionConfig) != null) {
            if (!pictureSelectionConfig.camera || !this.selectionConfig.isUseCustomCamera) {
                intent = new Intent(activity, this.selectionConfig.camera ? PictureSelectorCameraEmptyActivity.class : this.selectionConfig.isWeChatStyle ? PictureSelectorWeChatStyleActivity.class : PictureSelectorActivity.class);
            } else {
                intent = new Intent(activity, PictureCustomCameraActivity.class);
            }
            this.selectionConfig.isCallbackMode = false;
            Fragment fragment = this.selector.getFragment();
            if (fragment != null) {
                fragment.startActivityForResult(intent, i);
            } else {
                activity.startActivityForResult(intent, i);
            }
            activity.overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, R.anim.picture_anim_fade_in);
        }
    }

    @Deprecated
    public void forResult(int i, int i2, int i3) {
        Activity activity;
        if (!DoubleUtils.isFastDoubleClick() && (activity = this.selector.getActivity()) != null) {
            PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
            Intent intent = new Intent(activity, (pictureSelectionConfig == null || !pictureSelectionConfig.camera) ? this.selectionConfig.isWeChatStyle ? PictureSelectorWeChatStyleActivity.class : PictureSelectorActivity.class : PictureSelectorCameraEmptyActivity.class);
            this.selectionConfig.isCallbackMode = false;
            Fragment fragment = this.selector.getFragment();
            if (fragment != null) {
                fragment.startActivityForResult(intent, i);
            } else {
                activity.startActivityForResult(intent, i);
            }
            activity.overridePendingTransition(i2, i3);
        }
    }

    public void forResult(OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        Activity activity;
        Intent intent;
        if (!DoubleUtils.isFastDoubleClick() && (activity = this.selector.getActivity()) != null && this.selectionConfig != null) {
            PictureSelectionConfig.listener = (OnResultCallbackListener) new WeakReference(onResultCallbackListener).get();
            this.selectionConfig.isCallbackMode = true;
            if (!this.selectionConfig.camera || !this.selectionConfig.isUseCustomCamera) {
                intent = new Intent(activity, this.selectionConfig.camera ? PictureSelectorCameraEmptyActivity.class : this.selectionConfig.isWeChatStyle ? PictureSelectorWeChatStyleActivity.class : PictureSelectorActivity.class);
            } else {
                intent = new Intent(activity, PictureCustomCameraActivity.class);
            }
            Fragment fragment = this.selector.getFragment();
            if (fragment != null) {
                fragment.startActivity(intent);
            } else {
                activity.startActivity(intent);
            }
            activity.overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, R.anim.picture_anim_fade_in);
        }
    }

    public void forResult(ActivityResultLauncher<Intent> activityResultLauncher) {
        PictureSelectionConfig pictureSelectionConfig;
        Intent intent;
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            if (activityResultLauncher != null && activity != null && (pictureSelectionConfig = this.selectionConfig) != null) {
                if (!pictureSelectionConfig.camera || !this.selectionConfig.isUseCustomCamera) {
                    intent = new Intent(activity, this.selectionConfig.camera ? PictureSelectorCameraEmptyActivity.class : this.selectionConfig.isWeChatStyle ? PictureSelectorWeChatStyleActivity.class : PictureSelectorActivity.class);
                } else {
                    intent = new Intent(activity, PictureCustomCameraActivity.class);
                }
                this.selectionConfig.isCallbackMode = false;
                activityResultLauncher.launch(intent);
                activity.overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, R.anim.picture_anim_fade_in);
            }
        }
    }

    public void forResult(int i, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        Activity activity;
        Intent intent;
        if (!DoubleUtils.isFastDoubleClick() && (activity = this.selector.getActivity()) != null && this.selectionConfig != null) {
            PictureSelectionConfig.listener = (OnResultCallbackListener) new WeakReference(onResultCallbackListener).get();
            this.selectionConfig.isCallbackMode = true;
            if (!this.selectionConfig.camera || !this.selectionConfig.isUseCustomCamera) {
                intent = new Intent(activity, this.selectionConfig.camera ? PictureSelectorCameraEmptyActivity.class : this.selectionConfig.isWeChatStyle ? PictureSelectorWeChatStyleActivity.class : PictureSelectorActivity.class);
            } else {
                intent = new Intent(activity, PictureCustomCameraActivity.class);
            }
            Fragment fragment = this.selector.getFragment();
            if (fragment != null) {
                fragment.startActivityForResult(intent, i);
            } else {
                activity.startActivityForResult(intent, i);
            }
            activity.overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, R.anim.picture_anim_fade_in);
        }
    }

    public void openExternalPreview(int i, List<LocalMedia> list) {
        PictureSelector pictureSelector = this.selector;
        Objects.requireNonNull(pictureSelector, "This PictureSelector is Null");
        pictureSelector.externalPicturePreview(i, list, PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation);
    }

    @Deprecated
    public void openExternalPreview(int i, String str, List<LocalMedia> list) {
        PictureSelector pictureSelector = this.selector;
        Objects.requireNonNull(pictureSelector, "This PictureSelector is Null");
        pictureSelector.externalPicturePreview(i, str, list, PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation);
    }

    public void externalPictureVideo(String str) {
        PictureSelector pictureSelector = this.selector;
        Objects.requireNonNull(pictureSelector, "This PictureSelector is Null");
        pictureSelector.externalPictureVideo(str);
    }
}
