package com.luck.picture.lib.manager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.DoubleUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.ArrayList;

public class UCropManager {
    public static void ofEditorImage(Activity activity, String str, String str2) {
        String str3;
        if (!DoubleUtils.isFastDoubleClick()) {
            if (TextUtils.isEmpty(str)) {
                ToastUtils.s(activity.getApplicationContext(), activity.getString(R.string.picture_not_crop_data));
                return;
            }
            PictureSelectionConfig instance = PictureSelectionConfig.getInstance();
            boolean isHasHttp = PictureMimeType.isHasHttp(str);
            String replace = str2.replace("image/", ".");
            String diskCacheDir = PictureFileUtils.getDiskCacheDir(activity.getApplicationContext());
            if (TextUtils.isEmpty(instance.renameCropFileName)) {
                str3 = DateUtils.getCreateFileName("IMG_CROP_") + replace;
            } else {
                str3 = instance.renameCropFileName;
            }
            File file = new File(diskCacheDir, str3);
            Uri parse = (isHasHttp || PictureMimeType.isContent(str)) ? Uri.parse(str) : Uri.fromFile(new File(str));
            UCrop.Options basicOptions = basicOptions(activity);
            basicOptions.setHideBottomControls(false);
            basicOptions.setEditorImage(true);
            basicOptions.setToolbarTitle(activity.getString(R.string.picture_editor));
            UCrop.of(parse, Uri.fromFile(file)).withOptions(basicOptions).startAnimationActivity(activity, PictureSelectionConfig.windowAnimationStyle.activityCropEnterAnimation);
        }
    }

    public static void ofCrop(Activity activity, String str, String str2) {
        String str3;
        if (!DoubleUtils.isFastDoubleClick()) {
            if (TextUtils.isEmpty(str)) {
                ToastUtils.s(activity.getApplicationContext(), activity.getString(R.string.picture_not_crop_data));
                return;
            }
            PictureSelectionConfig instance = PictureSelectionConfig.getInstance();
            boolean isHasHttp = PictureMimeType.isHasHttp(str);
            String replace = str2.replace("image/", ".");
            String diskCacheDir = PictureFileUtils.getDiskCacheDir(activity.getApplicationContext());
            if (TextUtils.isEmpty(instance.renameCropFileName)) {
                str3 = DateUtils.getCreateFileName("IMG_CROP_") + replace;
            } else {
                str3 = instance.renameCropFileName;
            }
            UCrop.of((isHasHttp || PictureMimeType.isContent(str)) ? Uri.parse(str) : Uri.fromFile(new File(str)), Uri.fromFile(new File(diskCacheDir, str3))).withOptions(basicOptions(activity)).startAnimationActivity(activity, PictureSelectionConfig.windowAnimationStyle.activityCropEnterAnimation);
        }
    }

    public static void ofCrop(Activity activity, ArrayList<LocalMedia> arrayList) {
        Uri uri;
        String str;
        if (!DoubleUtils.isFastDoubleClick()) {
            if (arrayList == null || arrayList.size() == 0) {
                ToastUtils.s(activity.getApplicationContext(), activity.getString(R.string.picture_not_crop_data));
                return;
            }
            PictureSelectionConfig instance = PictureSelectionConfig.getInstance();
            UCrop.Options basicOptions = basicOptions(activity);
            basicOptions.setCutListData(arrayList);
            int size = arrayList.size();
            int i = 0;
            if (instance.chooseMode == PictureMimeType.ofAll() && instance.isWithVideoImage) {
                if (PictureMimeType.isHasVideo(size > 0 ? arrayList.get(0).getMimeType() : "")) {
                    int i2 = 0;
                    while (true) {
                        if (i2 < size) {
                            LocalMedia localMedia = arrayList.get(i2);
                            if (localMedia != null && PictureMimeType.isHasImage(localMedia.getMimeType())) {
                                i = i2;
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (i < size) {
                LocalMedia localMedia2 = arrayList.get(i);
                boolean isHasHttp = PictureMimeType.isHasHttp(localMedia2.getPath());
                if (TextUtils.isEmpty(localMedia2.getAndroidQToPath())) {
                    uri = (isHasHttp || PictureMimeType.isContent(localMedia2.getPath())) ? Uri.parse(localMedia2.getPath()) : Uri.fromFile(new File(localMedia2.getPath()));
                } else {
                    uri = Uri.fromFile(new File(localMedia2.getAndroidQToPath()));
                }
                String replace = localMedia2.getMimeType().replace("image/", ".");
                String diskCacheDir = PictureFileUtils.getDiskCacheDir(activity);
                if (TextUtils.isEmpty(instance.renameCropFileName)) {
                    str = DateUtils.getCreateFileName("IMG_CROP_") + replace;
                } else {
                    str = (instance.camera || size == 1) ? instance.renameCropFileName : StringUtils.rename(instance.renameCropFileName);
                }
                UCrop.of(uri, Uri.fromFile(new File(diskCacheDir, str))).withOptions(basicOptions).startAnimationMultipleCropActivity(activity, PictureSelectionConfig.windowAnimationStyle.activityCropEnterAnimation);
            }
        }
    }

    public static UCrop.Options basicOptions(Context context) {
        int i;
        int i2;
        int i3;
        boolean z;
        UCrop.Options options;
        int i4;
        int typeValueColor;
        int typeValueColor2;
        PictureSelectionConfig instance = PictureSelectionConfig.getInstance();
        int i5 = 0;
        if (PictureSelectionConfig.uiStyle != null) {
            i = PictureSelectionConfig.uiStyle.picture_navBarColor;
            z = PictureSelectionConfig.uiStyle.picture_statusBarChangeTextColor;
            i3 = PictureSelectionConfig.uiStyle.picture_top_titleBarBackgroundColor != 0 ? PictureSelectionConfig.uiStyle.picture_top_titleBarBackgroundColor : 0;
            i2 = PictureSelectionConfig.uiStyle.picture_statusBarBackgroundColor != 0 ? PictureSelectionConfig.uiStyle.picture_statusBarBackgroundColor : 0;
            if (PictureSelectionConfig.uiStyle.picture_top_titleTextColor != 0) {
                i5 = PictureSelectionConfig.uiStyle.picture_top_titleTextColor;
            }
        } else if (PictureSelectionConfig.cropStyle != null) {
            i = PictureSelectionConfig.cropStyle.cropNavBarColor;
            z = PictureSelectionConfig.cropStyle.isChangeStatusBarFontColor;
            i3 = PictureSelectionConfig.cropStyle.cropTitleBarBackgroundColor != 0 ? PictureSelectionConfig.cropStyle.cropTitleBarBackgroundColor : 0;
            i2 = PictureSelectionConfig.cropStyle.cropStatusBarColorPrimaryDark != 0 ? PictureSelectionConfig.cropStyle.cropStatusBarColorPrimaryDark : 0;
            if (PictureSelectionConfig.cropStyle.cropTitleColor != 0) {
                i5 = PictureSelectionConfig.cropStyle.cropTitleColor;
            }
        } else {
            z = instance.isChangeStatusBarFontColor;
            if (!z) {
                z = AttrsUtils.getTypeValueBoolean(context, R.attr.picture_statusFontColor);
            }
            if (instance.cropTitleBarBackgroundColor != 0) {
                typeValueColor2 = instance.cropTitleBarBackgroundColor;
            } else {
                typeValueColor2 = AttrsUtils.getTypeValueColor(context, R.attr.picture_crop_toolbar_bg);
            }
            if (instance.cropStatusBarColorPrimaryDark != 0) {
                typeValueColor = instance.cropStatusBarColorPrimaryDark;
            } else {
                typeValueColor = AttrsUtils.getTypeValueColor(context, R.attr.picture_crop_status_color);
            }
            if (instance.cropTitleColor != 0) {
                i4 = instance.cropTitleColor;
            } else {
                i4 = AttrsUtils.getTypeValueColor(context, R.attr.picture_crop_title_color);
            }
            i5 = i4;
            i = 0;
        }
        if (instance.uCropOptions != null) {
            options = instance.uCropOptions;
        } else {
            options = new UCrop.Options();
            options.setCircleDimmedLayer(instance.circleDimmedLayer);
            options.setDimmedLayerColor(instance.circleDimmedColor);
            options.setShowCropFrame(instance.showCropFrame);
            options.setShowCropGrid(instance.showCropGrid);
            options.setHideBottomControls(instance.hideBottomControls);
            options.setCompressionQuality(instance.cropCompressQuality);
            options.setFreeStyleCropEnabled(instance.freeStyleCropEnabled);
            options.withAspectRatio((float) instance.aspect_ratio_x, (float) instance.aspect_ratio_y);
            if (instance.cropWidth > 0 && instance.cropHeight > 0) {
                options.withMaxResultSize(instance.cropWidth, instance.cropHeight);
            }
        }
        options.isOpenWhiteStatusBar(z);
        options.setToolbarColor(i3);
        options.setStatusBarColor(i2);
        options.setToolbarWidgetColor(i5);
        options.setRenameCropFileName(instance.renameCropFileName);
        options.setRequestedOrientation(instance.requestedOrientation);
        options.isCamera(instance.camera);
        options.isWithVideoImage(instance.isWithVideoImage);
        options.isMultipleRecyclerAnimation(instance.isMultipleRecyclerAnimation);
        options.setNavBarColor(i);
        options.setDimmedLayerBorderColor(instance.circleDimmedBorderColor);
        options.setCircleStrokeWidth(instance.circleStrokeWidth);
        options.setDragFrameEnabled(instance.isDragFrame);
        options.setScaleEnabled(instance.scaleEnabled);
        options.setRotateEnabled(instance.rotateEnabled);
        options.setFreestyleCropMode(instance.freeStyleCropMode);
        options.setCropDragSmoothToCenter(instance.isDragCenter);
        options.isMultipleSkipCrop(instance.isMultipleSkipCrop);
        options.setCropExitAnimation(PictureSelectionConfig.windowAnimationStyle.activityCropExitAnimation);
        if (!TextUtils.isEmpty(instance.cropCompressFormat)) {
            options.setCompressionFormat(Bitmap.CompressFormat.valueOf(instance.cropCompressFormat));
        }
        return options;
    }
}
