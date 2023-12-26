package com.luck.picture.lib;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.luck.picture.lib.camera.CustomCameraView;
import com.luck.picture.lib.camera.listener.CameraListener;
import com.luck.picture.lib.camera.listener.ClickListener;
import com.luck.picture.lib.camera.view.CaptureLayout;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.dialog.PictureCustomDialog;
import com.luck.picture.lib.listener.OnPermissionDialogOptionCallback;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.io.File;

public class PictureCustomCameraActivity extends PictureSelectorCameraEmptyActivity {
    /* access modifiers changed from: private */
    public static final String TAG = "PictureCustomCameraActivity";
    protected boolean isEnterSetting;
    private CustomCameraView mCameraView;

    public boolean isImmersive() {
        return false;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorCameraEmptyActivity, com.luck.picture.lib.PictureCustomCameraActivity, android.app.Activity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getWindow().setFlags(PictureFileUtils.KB, PictureFileUtils.KB);
        getWindow().setFlags(67108864, 67108864);
        getWindow().setFlags(134217728, 134217728);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        getWindow().addFlags(128);
        super.onCreate(bundle);
        if (!PermissionChecker.isCheckWriteStorage(this)) {
            PermissionChecker.requestPermissions(this, PermissionConfig.getWritePermissionArray(this), 1);
        } else if (!PermissionChecker.checkSelfPermission((Context) this, "android.permission.CAMERA")) {
            PermissionChecker.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 2);
        } else if (PermissionChecker.checkSelfPermission((Context) this, "android.permission.RECORD_AUDIO")) {
            createCameraView();
        } else {
            PermissionChecker.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 4);
        }
    }

    private void createCameraView() {
        if (this.mCameraView == null) {
            CustomCameraView customCameraView = new CustomCameraView(getContext());
            this.mCameraView = customCameraView;
            setContentView(customCameraView);
            initView();
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorCameraEmptyActivity, com.luck.picture.lib.PictureCustomCameraActivity] */
    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.isEnterSetting) {
            if (!PermissionChecker.isCheckWriteStorage(this)) {
                showPermissionsDialog(false, PermissionConfig.getWritePermissionArray(this), getString(R.string.picture_jurisdiction));
            } else if (!PermissionChecker.checkSelfPermission((Context) this, "android.permission.CAMERA")) {
                showPermissionsDialog(false, new String[]{"android.permission.CAMERA"}, getString(R.string.picture_camera));
            } else if (PermissionChecker.checkSelfPermission((Context) this, "android.permission.RECORD_AUDIO")) {
                createCameraView();
            } else {
                showPermissionsDialog(false, new String[]{"android.permission.RECORD_AUDIO"}, getString(R.string.picture_audio));
            }
            this.isEnterSetting = false;
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.mCameraView.initCamera(this.config);
        if (this.config.recordVideoSecond > 0) {
            this.mCameraView.setRecordVideoMaxTime(this.config.recordVideoSecond);
        }
        if (this.config.recordVideoMinSecond > 0) {
            this.mCameraView.setRecordVideoMinTime(this.config.recordVideoMinSecond);
        }
        if (this.config.captureLoadingColor != 0) {
            this.mCameraView.setCaptureLoadingColor(this.config.captureLoadingColor);
        }
        CaptureLayout captureLayout = this.mCameraView.getCaptureLayout();
        if (captureLayout != null) {
            captureLayout.setButtonFeatures(this.config.buttonFeatures);
        }
        this.mCameraView.setImageCallbackListener(new PictureCustomCameraActivity$$ExternalSyntheticLambda2(this));
        this.mCameraView.setCameraListener(new CameraListener() {
            public void onPictureSuccess(File file) {
                PictureCustomCameraActivity.this.config.cameraMimeType = PictureMimeType.ofImage();
                Intent intent = new Intent();
                intent.putExtra(PictureConfig.EXTRA_MEDIA_PATH, file.getAbsolutePath());
                intent.putExtra(PictureConfig.EXTRA_CONFIG, PictureCustomCameraActivity.this.config);
                if (PictureCustomCameraActivity.this.config.camera) {
                    PictureCustomCameraActivity.this.checkCloseCamera();
                    PictureCustomCameraActivity.this.dispatchHandleCamera(intent);
                    return;
                }
                PictureCustomCameraActivity.this.setResult(-1, intent);
                PictureCustomCameraActivity.this.onBackPressed();
            }

            public void onRecordSuccess(File file) {
                PictureCustomCameraActivity.this.config.cameraMimeType = PictureMimeType.ofVideo();
                Intent intent = new Intent();
                intent.putExtra(PictureConfig.EXTRA_MEDIA_PATH, file.getAbsolutePath());
                intent.putExtra(PictureConfig.EXTRA_CONFIG, PictureCustomCameraActivity.this.config);
                if (PictureCustomCameraActivity.this.config.camera) {
                    PictureCustomCameraActivity.this.dispatchHandleCamera(intent);
                    return;
                }
                PictureCustomCameraActivity.this.setResult(-1, intent);
                PictureCustomCameraActivity.this.onBackPressed();
            }

            public void onError(int i, String str, Throwable th) {
                String access$100 = PictureCustomCameraActivity.TAG;
                Log.i(access$100, "onError: " + str);
            }
        });
        this.mCameraView.setOnClickListener(new ClickListener() {
            public void onClick() {
                PictureCustomCameraActivity.this.onBackPressed();
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$PictureCustomCameraActivity(File file, ImageView imageView) {
        if (this.config != null && PictureSelectionConfig.imageEngine != null && file != null) {
            PictureSelectionConfig.imageEngine.loadImage(getContext(), file.getAbsolutePath(), imageView);
        }
    }

    public void onBackPressed() {
        if (!(this.config == null || !this.config.camera || PictureSelectionConfig.listener == null)) {
            checkCloseCamera();
            PictureSelectionConfig.listener.onCancel();
        }
        exit();
    }

    /* access modifiers changed from: private */
    public void checkCloseCamera() {
        if (this.config == null || !this.config.isCallBackCloseCamera) {
            Log.i(TAG, "回调前不结束摄像头");
            return;
        }
        Log.i(TAG, "回调前结束摄像头");
        CustomCameraView customCameraView = this.mCameraView;
        if (customCameraView != null) {
            customCameraView.unbindCameraController();
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.Context, com.luck.picture.lib.PictureCustomCameraActivity, android.app.Activity] */
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z = false;
        if (i == 1) {
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = true;
                    break;
                } else if (iArr[i2] != 0) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                PermissionChecker.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 2);
            } else {
                showPermissionsDialog(true, PermissionConfig.getWritePermissionArray(this), getString(R.string.picture_jurisdiction));
            }
        } else if (i != 2) {
            if (i == 4) {
                if (iArr.length <= 0 || iArr[0] != 0) {
                    showPermissionsDialog(false, new String[]{"android.permission.RECORD_AUDIO"}, getString(R.string.picture_audio));
                } else {
                    createCameraView();
                }
            }
        } else if (iArr.length <= 0 || iArr[0] != 0) {
            showPermissionsDialog(true, new String[]{"android.permission.CAMERA"}, getString(R.string.picture_camera));
        } else if (PermissionChecker.checkSelfPermission((Context) this, "android.permission.RECORD_AUDIO")) {
            createCameraView();
        } else {
            PermissionChecker.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 4);
        }
    }

    /* access modifiers changed from: protected */
    public void showPermissionsDialog(boolean z, String[] strArr, String str) {
        if (!isFinishing()) {
            if (PictureSelectionConfig.onPermissionsObtainCallback != null) {
                PictureSelectionConfig.onPermissionsObtainCallback.onPermissionsIntercept(getContext(), z, strArr, str, new OnPermissionDialogOptionCallback() {
                    public void onCancel() {
                        if (PictureSelectionConfig.listener != null) {
                            PictureCustomCameraActivity.this.checkCloseCamera();
                            PictureSelectionConfig.listener.onCancel();
                        }
                        PictureCustomCameraActivity.this.exit();
                    }

                    public void onSetting() {
                        PictureCustomCameraActivity.this.isEnterSetting = true;
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
            ((Button) pictureCustomDialog.findViewById(R.id.btn_cancel)).setOnClickListener(new PictureCustomCameraActivity$$ExternalSyntheticLambda0(this, pictureCustomDialog));
            button.setOnClickListener(new PictureCustomCameraActivity$$ExternalSyntheticLambda1(this, pictureCustomDialog));
            pictureCustomDialog.show();
        }
    }

    public /* synthetic */ void lambda$showPermissionsDialog$1$PictureCustomCameraActivity(PictureCustomDialog pictureCustomDialog, View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        if (PictureSelectionConfig.listener != null) {
            checkCloseCamera();
            PictureSelectionConfig.listener.onCancel();
        }
        exit();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$showPermissionsDialog$2$PictureCustomCameraActivity(PictureCustomDialog pictureCustomDialog, View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        PermissionChecker.launchAppDetailsSettings(getContext());
        this.isEnterSetting = true;
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        CustomCameraView customCameraView = this.mCameraView;
        if (customCameraView != null) {
            customCameraView.unbindCameraController();
        }
        super.onDestroy();
    }
}
