package com.luck.picture.lib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.MediaExtraInfo;
import com.luck.picture.lib.immersive.ImmersiveManage;
import com.luck.picture.lib.manager.UCropManager;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.ArrayList;

public class PictureSelectorCameraEmptyActivity extends PictureBaseActivity {
    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorCameraEmptyActivity, androidx.appcompat.app.AppCompatActivity] */
    public void immersive() {
        ImmersiveManage.immersiveAboveAPI23(this, ContextCompat.getColor(this, R.color.picture_color_transparent), ContextCompat.getColor(this, R.color.picture_color_transparent), this.openWhiteStatusBar);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorCameraEmptyActivity, android.app.Activity, com.luck.picture.lib.PictureBaseActivity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.config == null) {
            exit();
        } else if (!this.config.isUseCustomCamera) {
            setActivitySize();
            if (bundle != null) {
                return;
            }
            if (!PermissionChecker.isCheckWriteStorage(this)) {
                PermissionChecker.requestPermissions(this, PermissionConfig.getWritePermissionArray(this), 1);
            } else if (PictureSelectionConfig.onCustomCameraInterfaceListener == null) {
                onTakePhoto();
            } else if (this.config.chooseMode == 2) {
                PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(getContext(), this.config, 2);
            } else {
                PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(getContext(), this.config, 1);
            }
        }
    }

    private void setActivitySize() {
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
    }

    public int getResourceId() {
        return R.layout.picture_empty;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorCameraEmptyActivity, android.app.Activity] */
    private void onTakePhoto() {
        if (PermissionChecker.checkSelfPermission((Context) this, "android.permission.CAMERA")) {
            boolean z = true;
            if (this.config != null && this.config.isUseCustomCamera) {
                z = PermissionChecker.checkSelfPermission((Context) this, "android.permission.RECORD_AUDIO");
            }
            if (z) {
                startCamera();
            } else {
                PermissionChecker.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 4);
            }
        } else {
            PermissionChecker.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 2);
        }
    }

    private void startCamera() {
        int i = this.config.chooseMode;
        if (i == 0 || i == 1) {
            startOpenCameraImage();
        } else if (i == 2) {
            startOpenCameraVideo();
        } else if (i == 3) {
            startOpenCameraAudio();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorCameraEmptyActivity, com.luck.picture.lib.PictureBaseActivity] */
    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Throwable th;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 69) {
                singleCropHandleResult(intent);
            } else if (i == 909) {
                dispatchHandleCamera(intent);
            }
        } else if (i2 == 0) {
            if (PictureSelectionConfig.listener != null) {
                PictureSelectionConfig.listener.onCancel();
            }
            if (i == 909) {
                MediaUtils.deleteCamera(this, this.config.cameraPath);
            }
            exit();
        } else if (i2 == 96 && intent != null && (th = (Throwable) intent.getSerializableExtra("com.yalantis.ucrop.Error")) != null) {
            ToastUtils.s(getContext(), th.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void singleCropHandleResult(Intent intent) {
        if (intent != null) {
            ArrayList arrayList = new ArrayList();
            Uri output = UCrop.getOutput(intent);
            if (output != null) {
                String path = output.getPath();
                boolean isEmpty = TextUtils.isEmpty(path);
                LocalMedia localMedia = new LocalMedia(this.config.cameraPath, 0, false, this.config.isCamera ? 1 : 0, 0, this.config.chooseMode);
                if (SdkVersionUtils.checkedAndroid_Q()) {
                    int lastIndexOf = this.config.cameraPath.lastIndexOf("/") + 1;
                    localMedia.setId(lastIndexOf > 0 ? ValueOf.toLong(this.config.cameraPath.substring(lastIndexOf)) : -1);
                    localMedia.setAndroidQToPath(path);
                } else {
                    localMedia.setId(System.currentTimeMillis());
                }
                localMedia.setCut(!isEmpty);
                localMedia.setCutPath(path);
                localMedia.setMimeType(PictureMimeType.getImageMimeType(path));
                if (PictureMimeType.isContent(localMedia.getPath())) {
                    localMedia.setRealPath(PictureFileUtils.getPath(getContext(), Uri.parse(localMedia.getPath())));
                    if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                        MediaExtraInfo videoSize = MediaUtils.getVideoSize(getContext(), localMedia.getPath());
                        localMedia.setWidth(videoSize.getWidth());
                        localMedia.setHeight(videoSize.getHeight());
                    } else if (PictureMimeType.isHasImage(localMedia.getMimeType())) {
                        MediaExtraInfo imageSize = MediaUtils.getImageSize(getContext(), localMedia.getPath());
                        localMedia.setWidth(imageSize.getWidth());
                        localMedia.setHeight(imageSize.getHeight());
                    }
                } else {
                    localMedia.setRealPath(localMedia.getPath());
                    if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                        MediaExtraInfo videoSize2 = MediaUtils.getVideoSize(getContext(), localMedia.getPath());
                        localMedia.setWidth(videoSize2.getWidth());
                        localMedia.setHeight(videoSize2.getHeight());
                    } else if (PictureMimeType.isHasImage(localMedia.getMimeType())) {
                        MediaExtraInfo imageSize2 = MediaUtils.getImageSize(getContext(), localMedia.getPath());
                        localMedia.setWidth(imageSize2.getWidth());
                        localMedia.setHeight(imageSize2.getHeight());
                    }
                }
                File file = new File(localMedia.getRealPath());
                localMedia.setSize(file.length());
                localMedia.setFileName(file.getName());
                arrayList.add(localMedia);
                handlerResult(arrayList);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorCameraEmptyActivity] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
        if (r1.isOpen() != false) goto L_0x007d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a9 A[Catch:{ Exception -> 0x02e5 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00aa A[Catch:{ Exception -> 0x02e5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchHandleCamera(android.content.Intent r8) {
        /*
            r7 = this;
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r7.config     // Catch:{ Exception -> 0x02e5 }
            int r0 = r0.chooseMode     // Catch:{ Exception -> 0x02e5 }
            int r1 = com.luck.picture.lib.config.PictureMimeType.ofAudio()     // Catch:{ Exception -> 0x02e5 }
            r2 = 0
            if (r0 != r1) goto L_0x009f
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r7.config     // Catch:{ Exception -> 0x02e5 }
            int r1 = com.luck.picture.lib.config.PictureMimeType.ofAudio()     // Catch:{ Exception -> 0x02e5 }
            r0.cameraMimeType = r1     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r1 = r7.getAudioPath(r8)     // Catch:{ Exception -> 0x02e5 }
            r0.cameraPath = r1     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r0 = r0.cameraPath     // Catch:{ Exception -> 0x02e5 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x02e5 }
            if (r0 == 0) goto L_0x0026
            return
        L_0x0026:
            boolean r0 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_R()     // Catch:{ Exception -> 0x02e5 }
            if (r0 == 0) goto L_0x009f
            android.content.Context r0 = r7.getContext()     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            java.lang.String r1 = r1.cameraAudioFormat     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            if (r1 == 0) goto L_0x003f
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            java.lang.String r1 = r1.suffixType     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            goto L_0x0043
        L_0x003f:
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            java.lang.String r1 = r1.cameraAudioFormat     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
        L_0x0043:
            android.net.Uri r0 = com.luck.picture.lib.tools.MediaUtils.createAudioUri(r0, r1)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            if (r0 == 0) goto L_0x0074
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            java.lang.String r1 = r1.cameraPath     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            java.io.InputStream r1 = com.luck.picture.lib.PictureContentResolver.getContentResolverOpenInputStream(r7, r1)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            java.util.Objects.requireNonNull(r1)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            okio.Source r1 = okio.Okio.source(r1)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            okio.BufferedSource r1 = okio.Okio.buffer(r1)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            java.io.OutputStream r3 = com.luck.picture.lib.PictureContentResolver.getContentResolverOpenOutputStream(r7, r0)     // Catch:{ Exception -> 0x0072 }
            com.luck.picture.lib.tools.PictureFileUtils.bufferCopy((okio.BufferedSource) r1, (java.io.OutputStream) r3)     // Catch:{ Exception -> 0x0072 }
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r7.config     // Catch:{ Exception -> 0x0072 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0072 }
            r3.cameraPath = r0     // Catch:{ Exception -> 0x0072 }
            goto L_0x0075
        L_0x0072:
            r0 = move-exception
            goto L_0x0085
        L_0x0074:
            r1 = r2
        L_0x0075:
            if (r1 == 0) goto L_0x009f
            boolean r0 = r1.isOpen()     // Catch:{ Exception -> 0x02e5 }
            if (r0 == 0) goto L_0x009f
        L_0x007d:
            com.luck.picture.lib.tools.PictureFileUtils.close(r1)     // Catch:{ Exception -> 0x02e5 }
            goto L_0x009f
        L_0x0081:
            r8 = move-exception
            goto L_0x0093
        L_0x0083:
            r0 = move-exception
            r1 = r2
        L_0x0085:
            r0.printStackTrace()     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x009f
            boolean r0 = r1.isOpen()     // Catch:{ Exception -> 0x02e5 }
            if (r0 == 0) goto L_0x009f
            goto L_0x007d
        L_0x0091:
            r8 = move-exception
            r2 = r1
        L_0x0093:
            if (r2 == 0) goto L_0x009e
            boolean r0 = r2.isOpen()     // Catch:{ Exception -> 0x02e5 }
            if (r0 == 0) goto L_0x009e
            com.luck.picture.lib.tools.PictureFileUtils.close(r2)     // Catch:{ Exception -> 0x02e5 }
        L_0x009e:
            throw r8     // Catch:{ Exception -> 0x02e5 }
        L_0x009f:
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r0 = r0.cameraPath     // Catch:{ Exception -> 0x02e5 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x02e5 }
            if (r0 == 0) goto L_0x00aa
            return
        L_0x00aa:
            com.luck.picture.lib.entity.LocalMedia r0 = new com.luck.picture.lib.entity.LocalMedia     // Catch:{ Exception -> 0x02e5 }
            r0.<init>()     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r1 = r1.cameraPath     // Catch:{ Exception -> 0x02e5 }
            boolean r1 = com.luck.picture.lib.config.PictureMimeType.isContent(r1)     // Catch:{ Exception -> 0x02e5 }
            if (r1 == 0) goto L_0x0176
            android.content.Context r1 = r7.getContext()     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r3 = r3.cameraPath     // Catch:{ Exception -> 0x02e5 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r1 = com.luck.picture.lib.tools.PictureFileUtils.getPath(r1, r3)     // Catch:{ Exception -> 0x02e5 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x02e5 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r4 = r7.config     // Catch:{ Exception -> 0x02e5 }
            int r4 = r4.cameraMimeType     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r4 = com.luck.picture.lib.config.PictureMimeType.getImageMimeType(r1, r4)     // Catch:{ Exception -> 0x02e5 }
            long r5 = r3.length()     // Catch:{ Exception -> 0x02e5 }
            r0.setSize(r5)     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x02e5 }
            r0.setFileName(r3)     // Catch:{ Exception -> 0x02e5 }
            boolean r3 = com.luck.picture.lib.config.PictureMimeType.isHasImage(r4)     // Catch:{ Exception -> 0x02e5 }
            if (r3 == 0) goto L_0x0105
            android.content.Context r3 = r7.getContext()     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r5 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r5 = r5.cameraPath     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.entity.MediaExtraInfo r3 = com.luck.picture.lib.tools.MediaUtils.getImageSize(r3, r5)     // Catch:{ Exception -> 0x02e5 }
            int r5 = r3.getWidth()     // Catch:{ Exception -> 0x02e5 }
            r0.setWidth(r5)     // Catch:{ Exception -> 0x02e5 }
            int r3 = r3.getHeight()     // Catch:{ Exception -> 0x02e5 }
            r0.setHeight(r3)     // Catch:{ Exception -> 0x02e5 }
            goto L_0x0146
        L_0x0105:
            boolean r3 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r4)     // Catch:{ Exception -> 0x02e5 }
            if (r3 == 0) goto L_0x012d
            android.content.Context r3 = r7.getContext()     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r5 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r5 = r5.cameraPath     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.entity.MediaExtraInfo r3 = com.luck.picture.lib.tools.MediaUtils.getVideoSize(r3, r5)     // Catch:{ Exception -> 0x02e5 }
            int r5 = r3.getWidth()     // Catch:{ Exception -> 0x02e5 }
            r0.setWidth(r5)     // Catch:{ Exception -> 0x02e5 }
            int r5 = r3.getHeight()     // Catch:{ Exception -> 0x02e5 }
            r0.setHeight(r5)     // Catch:{ Exception -> 0x02e5 }
            long r5 = r3.getDuration()     // Catch:{ Exception -> 0x02e5 }
            r0.setDuration(r5)     // Catch:{ Exception -> 0x02e5 }
            goto L_0x0146
        L_0x012d:
            boolean r3 = com.luck.picture.lib.config.PictureMimeType.isHasAudio(r4)     // Catch:{ Exception -> 0x02e5 }
            if (r3 == 0) goto L_0x0146
            android.content.Context r3 = r7.getContext()     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r5 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r5 = r5.cameraPath     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.entity.MediaExtraInfo r3 = com.luck.picture.lib.tools.MediaUtils.getAudioSize(r3, r5)     // Catch:{ Exception -> 0x02e5 }
            long r5 = r3.getDuration()     // Catch:{ Exception -> 0x02e5 }
            r0.setDuration(r5)     // Catch:{ Exception -> 0x02e5 }
        L_0x0146:
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r3 = r3.cameraPath     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r5 = "/"
            int r3 = r3.lastIndexOf(r5)     // Catch:{ Exception -> 0x02e5 }
            int r3 = r3 + 1
            if (r3 <= 0) goto L_0x0161
            com.luck.picture.lib.config.PictureSelectionConfig r5 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r5 = r5.cameraPath     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r3 = r5.substring(r3)     // Catch:{ Exception -> 0x02e5 }
            long r5 = com.luck.picture.lib.tools.ValueOf.toLong(r3)     // Catch:{ Exception -> 0x02e5 }
            goto L_0x0163
        L_0x0161:
            r5 = -1
        L_0x0163:
            r0.setId(r5)     // Catch:{ Exception -> 0x02e5 }
            r0.setRealPath(r1)     // Catch:{ Exception -> 0x02e5 }
            if (r8 == 0) goto L_0x0171
            java.lang.String r1 = "mediaPath"
            java.lang.String r2 = r8.getStringExtra(r1)     // Catch:{ Exception -> 0x02e5 }
        L_0x0171:
            r0.setAndroidQToPath(r2)     // Catch:{ Exception -> 0x02e5 }
            goto L_0x0218
        L_0x0176:
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r1 = r1.cameraPath     // Catch:{ Exception -> 0x02e5 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r1 = r1.cameraPath     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r2 = r7.config     // Catch:{ Exception -> 0x02e5 }
            int r2 = r2.cameraMimeType     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r4 = com.luck.picture.lib.config.PictureMimeType.getImageMimeType(r1, r2)     // Catch:{ Exception -> 0x02e5 }
            long r1 = r8.length()     // Catch:{ Exception -> 0x02e5 }
            r0.setSize(r1)     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r8 = r8.getName()     // Catch:{ Exception -> 0x02e5 }
            r0.setFileName(r8)     // Catch:{ Exception -> 0x02e5 }
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isHasImage(r4)     // Catch:{ Exception -> 0x02e5 }
            if (r8 == 0) goto L_0x01c9
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x02e5 }
            boolean r1 = r1.isCameraRotateImage     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r2 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r2 = r2.cameraPath     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.tools.BitmapUtils.rotateImage(r8, r1, r2)     // Catch:{ Exception -> 0x02e5 }
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r1 = r1.cameraPath     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.entity.MediaExtraInfo r8 = com.luck.picture.lib.tools.MediaUtils.getImageSize(r8, r1)     // Catch:{ Exception -> 0x02e5 }
            int r1 = r8.getWidth()     // Catch:{ Exception -> 0x02e5 }
            r0.setWidth(r1)     // Catch:{ Exception -> 0x02e5 }
            int r8 = r8.getHeight()     // Catch:{ Exception -> 0x02e5 }
            r0.setHeight(r8)     // Catch:{ Exception -> 0x02e5 }
            goto L_0x020a
        L_0x01c9:
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r4)     // Catch:{ Exception -> 0x02e5 }
            if (r8 == 0) goto L_0x01f1
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r1 = r1.cameraPath     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.entity.MediaExtraInfo r8 = com.luck.picture.lib.tools.MediaUtils.getVideoSize(r8, r1)     // Catch:{ Exception -> 0x02e5 }
            int r1 = r8.getWidth()     // Catch:{ Exception -> 0x02e5 }
            r0.setWidth(r1)     // Catch:{ Exception -> 0x02e5 }
            int r1 = r8.getHeight()     // Catch:{ Exception -> 0x02e5 }
            r0.setHeight(r1)     // Catch:{ Exception -> 0x02e5 }
            long r1 = r8.getDuration()     // Catch:{ Exception -> 0x02e5 }
            r0.setDuration(r1)     // Catch:{ Exception -> 0x02e5 }
            goto L_0x020a
        L_0x01f1:
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isHasAudio(r4)     // Catch:{ Exception -> 0x02e5 }
            if (r8 == 0) goto L_0x020a
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r1 = r1.cameraPath     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.entity.MediaExtraInfo r8 = com.luck.picture.lib.tools.MediaUtils.getAudioSize(r8, r1)     // Catch:{ Exception -> 0x02e5 }
            long r1 = r8.getDuration()     // Catch:{ Exception -> 0x02e5 }
            r0.setDuration(r1)     // Catch:{ Exception -> 0x02e5 }
        L_0x020a:
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02e5 }
            r0.setId(r1)     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r8 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r8 = r8.cameraPath     // Catch:{ Exception -> 0x02e5 }
            r0.setRealPath(r8)     // Catch:{ Exception -> 0x02e5 }
        L_0x0218:
            com.luck.picture.lib.config.PictureSelectionConfig r8 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r8 = r8.cameraPath     // Catch:{ Exception -> 0x02e5 }
            r0.setPath(r8)     // Catch:{ Exception -> 0x02e5 }
            r0.setMimeType(r4)     // Catch:{ Exception -> 0x02e5 }
            boolean r8 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_Q()     // Catch:{ Exception -> 0x02e5 }
            if (r8 == 0) goto L_0x0238
            java.lang.String r8 = r0.getMimeType()     // Catch:{ Exception -> 0x02e5 }
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r8)     // Catch:{ Exception -> 0x02e5 }
            if (r8 == 0) goto L_0x0238
            java.lang.String r8 = android.os.Environment.DIRECTORY_MOVIES     // Catch:{ Exception -> 0x02e5 }
            r0.setParentFolderName(r8)     // Catch:{ Exception -> 0x02e5 }
            goto L_0x023d
        L_0x0238:
            java.lang.String r8 = "Camera"
            r0.setParentFolderName(r8)     // Catch:{ Exception -> 0x02e5 }
        L_0x023d:
            com.luck.picture.lib.config.PictureSelectionConfig r8 = r7.config     // Catch:{ Exception -> 0x02e5 }
            int r8 = r8.chooseMode     // Catch:{ Exception -> 0x02e5 }
            r0.setChooseModel(r8)     // Catch:{ Exception -> 0x02e5 }
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x02e5 }
            long r1 = com.luck.picture.lib.tools.MediaUtils.getCameraFirstBucketId(r8)     // Catch:{ Exception -> 0x02e5 }
            r0.setBucketId(r1)     // Catch:{ Exception -> 0x02e5 }
            long r1 = com.luck.picture.lib.tools.DateUtils.getCurrentTimeMillis()     // Catch:{ Exception -> 0x02e5 }
            r0.setDateAddedTime(r1)     // Catch:{ Exception -> 0x02e5 }
            r7.dispatchCameraHandleResult(r0)     // Catch:{ Exception -> 0x02e5 }
            boolean r8 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_Q()     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r1 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            if (r8 == 0) goto L_0x029f
            java.lang.String r8 = r0.getMimeType()     // Catch:{ Exception -> 0x02e5 }
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r8)     // Catch:{ Exception -> 0x02e5 }
            if (r8 == 0) goto L_0x02e9
            com.luck.picture.lib.config.PictureSelectionConfig r8 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r8 = r8.cameraPath     // Catch:{ Exception -> 0x02e5 }
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isContent(r8)     // Catch:{ Exception -> 0x02e5 }
            if (r8 == 0) goto L_0x02e9
            com.luck.picture.lib.config.PictureSelectionConfig r8 = r7.config     // Catch:{ Exception -> 0x02e5 }
            boolean r8 = r8.isFallbackVersion3     // Catch:{ Exception -> 0x02e5 }
            if (r8 == 0) goto L_0x0289
            com.luck.picture.lib.PictureMediaScannerConnection r8 = new com.luck.picture.lib.PictureMediaScannerConnection     // Catch:{ Exception -> 0x02e5 }
            android.content.Context r1 = r7.getContext()     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r0 = r0.getRealPath()     // Catch:{ Exception -> 0x02e5 }
            r8.<init>(r1, r0)     // Catch:{ Exception -> 0x02e5 }
            goto L_0x02e9
        L_0x0289:
            android.content.Intent r8 = new android.content.Intent     // Catch:{ Exception -> 0x02e5 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r0 = r0.getRealPath()     // Catch:{ Exception -> 0x02e5 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x02e5 }
            android.net.Uri r0 = android.net.Uri.fromFile(r2)     // Catch:{ Exception -> 0x02e5 }
            r8.<init>(r1, r0)     // Catch:{ Exception -> 0x02e5 }
            r7.sendBroadcast(r8)     // Catch:{ Exception -> 0x02e5 }
            goto L_0x02e9
        L_0x029f:
            com.luck.picture.lib.config.PictureSelectionConfig r8 = r7.config     // Catch:{ Exception -> 0x02e5 }
            boolean r8 = r8.isFallbackVersion3     // Catch:{ Exception -> 0x02e5 }
            if (r8 == 0) goto L_0x02b3
            com.luck.picture.lib.PictureMediaScannerConnection r8 = new com.luck.picture.lib.PictureMediaScannerConnection     // Catch:{ Exception -> 0x02e5 }
            android.content.Context r1 = r7.getContext()     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r2 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r2 = r2.cameraPath     // Catch:{ Exception -> 0x02e5 }
            r8.<init>(r1, r2)     // Catch:{ Exception -> 0x02e5 }
            goto L_0x02c8
        L_0x02b3:
            android.content.Intent r8 = new android.content.Intent     // Catch:{ Exception -> 0x02e5 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r7.config     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r3 = r3.cameraPath     // Catch:{ Exception -> 0x02e5 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x02e5 }
            android.net.Uri r2 = android.net.Uri.fromFile(r2)     // Catch:{ Exception -> 0x02e5 }
            r8.<init>(r1, r2)     // Catch:{ Exception -> 0x02e5 }
            r7.sendBroadcast(r8)     // Catch:{ Exception -> 0x02e5 }
        L_0x02c8:
            java.lang.String r8 = r0.getMimeType()     // Catch:{ Exception -> 0x02e5 }
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isHasImage(r8)     // Catch:{ Exception -> 0x02e5 }
            if (r8 == 0) goto L_0x02e9
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x02e5 }
            int r8 = com.luck.picture.lib.tools.MediaUtils.getDCIMLastImageId(r8)     // Catch:{ Exception -> 0x02e5 }
            r0 = -1
            if (r8 == r0) goto L_0x02e9
            android.content.Context r0 = r7.getContext()     // Catch:{ Exception -> 0x02e5 }
            com.luck.picture.lib.tools.MediaUtils.removeMedia(r0, r8)     // Catch:{ Exception -> 0x02e5 }
            goto L_0x02e9
        L_0x02e5:
            r8 = move-exception
            r8.printStackTrace()
        L_0x02e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorCameraEmptyActivity.dispatchHandleCamera(android.content.Intent):void");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.luck.picture.lib.PictureSelectorCameraEmptyActivity, android.app.Activity] */
    private void dispatchCameraHandleResult(LocalMedia localMedia) {
        boolean isHasImage = PictureMimeType.isHasImage(localMedia.getMimeType());
        if (this.config.enableCrop && !this.config.isCheckOriginalImage && isHasImage) {
            this.config.originalPath = this.config.cameraPath;
            UCropManager.ofCrop(this, this.config.cameraPath, localMedia.getMimeType());
        } else if (!this.config.isCompress || !isHasImage) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(localMedia);
            onResult(arrayList);
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(localMedia);
            compressImage(arrayList2);
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.luck.picture.lib.PictureSelectorCameraEmptyActivity, android.app.Activity, com.luck.picture.lib.PictureBaseActivity] */
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
                PermissionChecker.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 2);
                return;
            }
            ToastUtils.s(getContext(), getString(R.string.picture_jurisdiction));
            exit();
        } else if (i != 2) {
            if (i == 4) {
                if (iArr.length <= 0 || iArr[0] != 0) {
                    exit();
                    ToastUtils.s(getContext(), getString(R.string.picture_audio));
                    return;
                }
                onTakePhoto();
            }
        } else if (iArr.length <= 0 || iArr[0] != 0) {
            exit();
            ToastUtils.s(getContext(), getString(R.string.picture_camera));
        } else {
            onTakePhoto();
        }
    }

    public void onBackPressed() {
        if (SdkVersionUtils.checkedAndroid_Q()) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        exit();
    }
}
