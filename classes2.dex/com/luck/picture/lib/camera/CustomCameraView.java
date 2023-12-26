package com.luck.picture.lib.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.VideoCaptureConfig;
import androidx.camera.view.LifecycleCameraController;
import androidx.camera.view.PreviewView;
import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileOptions;
import androidx.camera.view.video.OutputFileResults;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.luck.picture.lib.PictureMediaScannerConnection;
import com.luck.picture.lib.R;
import com.luck.picture.lib.camera.listener.CameraListener;
import com.luck.picture.lib.camera.listener.CaptureListener;
import com.luck.picture.lib.camera.listener.ClickListener;
import com.luck.picture.lib.camera.listener.ImageCallbackListener;
import com.luck.picture.lib.camera.listener.TypeListener;
import com.luck.picture.lib.camera.view.CaptureLayout;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AndroidQTransformUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Formatter;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class CustomCameraView extends RelativeLayout {
    public static final int BUTTON_STATE_BOTH = 259;
    public static final int BUTTON_STATE_ONLY_CAPTURE = 257;
    public static final int BUTTON_STATE_ONLY_RECORDER = 258;
    public static final int DEFAULT_MIN_RECORD_VIDEO = 1500;
    private static final int TYPE_FLASH_AUTO = 33;
    private static final int TYPE_FLASH_OFF = 35;
    private static final int TYPE_FLASH_ON = 34;
    /* access modifiers changed from: private */
    public LifecycleCameraController mCameraController;
    /* access modifiers changed from: private */
    public CameraListener mCameraListener;
    /* access modifiers changed from: private */
    public PreviewView mCameraPreviewView;
    /* access modifiers changed from: private */
    public CaptureLayout mCaptureLayout;
    /* access modifiers changed from: private */
    public PictureSelectionConfig mConfig;
    /* access modifiers changed from: private */
    public TextView mCountDownTimeView;
    /* access modifiers changed from: private */
    public ImageView mFlashLamp;
    /* access modifiers changed from: private */
    public ImageCallbackListener mImageCallbackListener;
    /* access modifiers changed from: private */
    public ImageView mImagePreview;
    private MediaPlayer mMediaPlayer;
    /* access modifiers changed from: private */
    public ClickListener mOnClickListener;
    /* access modifiers changed from: private */
    public File mOutMediaFile;
    /* access modifiers changed from: private */
    public long mRecordDuration = 0;
    /* access modifiers changed from: private */
    public ImageView mSwitchCamera;
    /* access modifiers changed from: private */
    public TextureView mTextureView;
    /* access modifiers changed from: private */
    public long recordTime = 0;
    /* access modifiers changed from: private */
    public final TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() {
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            CustomCameraView customCameraView = CustomCameraView.this;
            customCameraView.startVideoPlay(customCameraView.mOutMediaFile);
        }
    };
    private int type_flash = 35;

    public CustomCameraView(Context context) {
        super(context);
        initView();
    }

    public CustomCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public CustomCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public void initView() {
        inflate(getContext(), R.layout.picture_camera_view, this);
        setBackgroundColor(ContextCompat.getColor(getContext(), R.color.picture_color_black));
        this.mCountDownTimeView = (TextView) findViewById(R.id.displayTime);
        this.mCameraPreviewView = findViewById(R.id.cameraPreviewView);
        this.mTextureView = (TextureView) findViewById(R.id.video_play_preview);
        this.mImagePreview = (ImageView) findViewById(R.id.image_preview);
        this.mSwitchCamera = (ImageView) findViewById(R.id.image_switch);
        this.mFlashLamp = (ImageView) findViewById(R.id.image_flash);
        this.mCaptureLayout = (CaptureLayout) findViewById(R.id.capture_layout);
        this.mSwitchCamera.setImageResource(R.drawable.picture_ic_camera);
        this.mFlashLamp.setOnClickListener(new CustomCameraView$$ExternalSyntheticLambda1(this));
        this.mCaptureLayout.setDuration(15000);
        this.mRecordDuration = 15000;
        this.mSwitchCamera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, CustomCameraView.class);
                CustomCameraView.this.toggleCamera();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.mCaptureLayout.setCaptureListener(new CaptureListener() {
            public void recordZoom(float f) {
            }

            public void takePictures() {
                CustomCameraView customCameraView = CustomCameraView.this;
                File unused = customCameraView.mOutMediaFile = customCameraView.createImageFile();
                CustomCameraView.this.mCaptureLayout.setButtonCaptureEnabled(false);
                CustomCameraView.this.mSwitchCamera.setVisibility(4);
                CustomCameraView.this.mFlashLamp.setVisibility(4);
                CustomCameraView.this.mCameraController.setEnabledUseCases(1);
                CustomCameraView.this.mCameraController.takePicture(new ImageCapture.OutputFileOptions.Builder(CustomCameraView.this.mOutMediaFile).build(), ContextCompat.getMainExecutor(CustomCameraView.this.getContext()), new MyImageResultCallback(CustomCameraView.this.mOutMediaFile, CustomCameraView.this.mImagePreview, CustomCameraView.this.mCaptureLayout, CustomCameraView.this.mImageCallbackListener, CustomCameraView.this.mCameraListener));
            }

            public void recordStart() {
                CustomCameraView customCameraView = CustomCameraView.this;
                File unused = customCameraView.mOutMediaFile = customCameraView.createVideoFile();
                CustomCameraView.this.mSwitchCamera.setVisibility(4);
                CustomCameraView.this.mFlashLamp.setVisibility(4);
                CustomCameraView.this.setRecordParameter();
                CustomCameraView.this.mCameraController.setEnabledUseCases(4);
                OutputFileOptions build = OutputFileOptions.builder(CustomCameraView.this.mOutMediaFile).build();
                CustomCameraView.this.printRecordParamter();
                CustomCameraView.this.mCameraController.startRecording(build, ContextCompat.getMainExecutor(CustomCameraView.this.getContext()), new OnVideoSavedCallback() {
                    public void onVideoSaved(OutputFileResults outputFileResults) {
                        if (CustomCameraView.this.recordTime >= (CustomCameraView.this.mConfig.recordVideoMinSecond <= 0 ? 1500 : (long) (CustomCameraView.this.mConfig.recordVideoMinSecond * ResultCode.KARAOKE_SUCCESS)) || !CustomCameraView.this.mOutMediaFile.exists() || !CustomCameraView.this.mOutMediaFile.delete()) {
                            CustomCameraView.this.mTextureView.setVisibility(0);
                            CustomCameraView.this.mCameraPreviewView.setVisibility(4);
                            if (CustomCameraView.this.mTextureView.isAvailable()) {
                                CustomCameraView.this.startVideoPlay(CustomCameraView.this.mOutMediaFile);
                            } else {
                                CustomCameraView.this.mTextureView.setSurfaceTextureListener(CustomCameraView.this.surfaceTextureListener);
                            }
                        }
                    }

                    public void onError(int i, String str, Throwable th) {
                        if (CustomCameraView.this.mCameraListener != null) {
                            CustomCameraView.this.mCameraListener.onError(i, str, th);
                        }
                    }
                });
                CustomCameraView.this.mCountDownTimeView.setVisibility(0);
                CustomCameraView.this.showCurrentRecordTime(0);
            }

            public void recordShort(long j) {
                long unused = CustomCameraView.this.recordTime = j;
                CustomCameraView.this.mSwitchCamera.setVisibility(0);
                CustomCameraView.this.mFlashLamp.setVisibility(0);
                CustomCameraView.this.mCaptureLayout.resetCaptureLayout();
                CustomCameraView.this.mCaptureLayout.setTextWithAnimation(CustomCameraView.this.getContext().getString(R.string.picture_recording_time_is_short));
                CustomCameraView.this.mCameraController.stopRecording();
                CustomCameraView.this.mCountDownTimeView.setVisibility(8);
            }

            public void recordEnd(long j) {
                long unused = CustomCameraView.this.recordTime = j;
                CustomCameraView.this.mCameraController.stopRecording();
                CustomCameraView.this.mCountDownTimeView.setVisibility(8);
            }

            public void recordError() {
                if (CustomCameraView.this.mCameraListener != null) {
                    CustomCameraView.this.mCameraListener.onError(0, "An unknown error", (Throwable) null);
                }
                CustomCameraView.this.mCountDownTimeView.setVisibility(8);
            }

            public void recordUpdateTime(long j) {
                long access$1800 = CustomCameraView.this.mRecordDuration - j;
                if (access$1800 < 0) {
                    access$1800 = 0;
                }
                CustomCameraView.this.showCurrentRecordTime(access$1800);
            }
        });
        this.mCaptureLayout.setTypeListener(new TypeListener() {
            public void cancel() {
                CustomCameraView.this.stopVideoPlay();
                CustomCameraView.this.resetState();
            }

            public void confirm() {
                if (CustomCameraView.this.mOutMediaFile != null && CustomCameraView.this.mOutMediaFile.exists()) {
                    if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(CustomCameraView.this.mConfig.cameraPath)) {
                        PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<Boolean>() {
                            public Boolean doInBackground() {
                                return Boolean.valueOf(AndroidQTransformUtils.copyPathToDCIM(CustomCameraView.this.getContext(), CustomCameraView.this.mOutMediaFile, Uri.parse(CustomCameraView.this.mConfig.cameraPath)));
                            }

                            public void onSuccess(Boolean bool) {
                                if (CustomCameraView.this.mCameraController.isImageCaptureEnabled()) {
                                    CustomCameraView.this.mImagePreview.setVisibility(4);
                                    if (CustomCameraView.this.mCameraListener != null) {
                                        CustomCameraView.this.mCameraListener.onPictureSuccess(CustomCameraView.this.mOutMediaFile);
                                        return;
                                    }
                                    return;
                                }
                                CustomCameraView.this.stopVideoPlay();
                                if (CustomCameraView.this.mCameraListener != null || !CustomCameraView.this.mOutMediaFile.exists()) {
                                    CustomCameraView.this.mCameraListener.onRecordSuccess(CustomCameraView.this.mOutMediaFile);
                                }
                            }
                        });
                    } else if (CustomCameraView.this.mCameraController.isImageCaptureEnabled()) {
                        CustomCameraView.this.mImagePreview.setVisibility(4);
                        if (CustomCameraView.this.mCameraListener != null) {
                            CustomCameraView.this.mCameraListener.onPictureSuccess(CustomCameraView.this.mOutMediaFile);
                        }
                    } else {
                        CustomCameraView.this.stopVideoPlay();
                        if (CustomCameraView.this.mCameraListener != null || !CustomCameraView.this.mOutMediaFile.exists()) {
                            CustomCameraView.this.mCameraListener.onRecordSuccess(CustomCameraView.this.mOutMediaFile);
                        }
                    }
                }
            }
        });
        this.mCaptureLayout.setLeftClickListener(new ClickListener() {
            public void onClick() {
                if (CustomCameraView.this.mOnClickListener != null) {
                    CustomCameraView.this.mOnClickListener.onClick();
                }
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$CustomCameraView(View view) {
        int i = this.type_flash + 1;
        this.type_flash = i;
        if (i > 35) {
            this.type_flash = 33;
        }
        setFlashRes();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private Object getReflectPrivateObj(Object obj, String str, boolean z) {
        Field field;
        if (z) {
            try {
                field = obj.getClass().getSuperclass().getDeclaredField(str);
            } catch (Exception e) {
                Log.e("录制参数", "getReflectPrivateObj name = " + str + ",e=" + e);
                return null;
            }
        } else {
            field = obj.getClass().getDeclaredField(str);
        }
        field.setAccessible(true);
        return field.get(obj);
    }

    public <ValueT> ValueT getOptionValue(Config.Option<ValueT> option, TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> treeMap) {
        try {
            Map map = treeMap.get(option);
            if (map != null) {
                return map.get((Config.OptionPriority) Collections.min(map.keySet()));
            }
            throw new IllegalArgumentException("Option does not exist: " + option);
        } catch (Exception e) {
            Log.e("录制参数", "getOptionValue error = " + e);
            return null;
        }
    }

    private <ValueT> void setOptionValue(Config.Option<ValueT> option, TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> treeMap, ValueT valuet) {
        try {
            Map map = treeMap.get(option);
            Config.OptionPriority optionPriority = Config.OptionPriority.OPTIONAL;
            if (map == null) {
                ArrayMap arrayMap = new ArrayMap();
                treeMap.put(option, arrayMap);
                arrayMap.put(optionPriority, valuet);
                return;
            }
            Config.OptionPriority optionPriority2 = (Config.OptionPriority) Collections.min(map.keySet());
            if (!map.get(optionPriority2).equals(valuet)) {
                if (Config.-CC.hasConflict(optionPriority2, optionPriority)) {
                    throw new IllegalArgumentException("Option values conflicts: " + option.getId() + ", existing value (" + optionPriority2 + ")=" + map.get(optionPriority2) + ", conflicting (" + optionPriority + ")=" + valuet);
                }
            }
            map.put(optionPriority, valuet);
            Log.e("录制参数", "setOptionValue value = " + valuet);
        } catch (Exception e) {
            Log.e("录制参数", "setOptionValue error = " + e);
        }
    }

    /* access modifiers changed from: private */
    public void setRecordParameter() {
        Log.e("录制参数", "开始 setRecordParameter");
        LifecycleCameraController lifecycleCameraController = this.mCameraController;
        if (lifecycleCameraController != null) {
            try {
                Object reflectPrivateObj = getReflectPrivateObj(lifecycleCameraController, "mVideoCapture", true);
                if (reflectPrivateObj instanceof VideoCapture) {
                    Log.e("录制参数", "获取 VideoCapture 成功");
                    Object reflectPrivateObj2 = getReflectPrivateObj((VideoCapture) reflectPrivateObj, "mCurrentConfig", true);
                    if (reflectPrivateObj2 instanceof VideoCaptureConfig) {
                        Log.e("录制参数", "获取 VideoCaptureConfig 成功");
                        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) reflectPrivateObj2;
                        try {
                            Log.e("录制参数", "获取视频码率=" + videoCaptureConfig.getBitRate());
                            Log.e("录制参数", "获取视频帧率=" + videoCaptureConfig.getVideoFrameRate());
                        } catch (Exception e) {
                            Log.e("录制参数", "获取 VideoCaptureConfig 信息失败 = " + e);
                        }
                        Object reflectPrivateObj3 = getReflectPrivateObj(videoCaptureConfig, "mConfig", false);
                        if (reflectPrivateObj3 instanceof OptionsBundle) {
                            Log.e("录制参数", "获取 OptionsBundle 成功");
                            Object reflectPrivateObj4 = getReflectPrivateObj(reflectPrivateObj3, "mOptions", false);
                            if (reflectPrivateObj4 instanceof TreeMap) {
                                Log.e("录制参数", "获取 mOptions 成功,开始设置");
                                TreeMap treeMap = (TreeMap) reflectPrivateObj4;
                                setOptionValue(VideoCaptureConfig.OPTION_BIT_RATE, treeMap, 3145728);
                                setOptionValue(VideoCaptureConfig.OPTION_VIDEO_FRAME_RATE, treeMap, 25);
                                return;
                            }
                            Log.e("录制参数", "获取 mOptions 失败");
                            return;
                        }
                        Log.e("录制参数", "获取 OptionsBundle 失败");
                        return;
                    }
                    Log.e("录制参数", "获取 VideoCaptureConfig 失败");
                    return;
                }
                Log.e("录制参数", "获取 VideoCapture 失败");
            } catch (Exception e2) {
                Log.e("录制参数", "setRecordParameter 失败=" + e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void printRecordParamter() {
        Log.e("录制参数", "开始打印，录制参数");
        LifecycleCameraController lifecycleCameraController = this.mCameraController;
        if (lifecycleCameraController != null) {
            try {
                Object reflectPrivateObj = getReflectPrivateObj(lifecycleCameraController, "mVideoCapture", true);
                if (reflectPrivateObj instanceof VideoCapture) {
                    Log.e("录制参数", "printRecordParamter 获取 VideoCapture 成功");
                    Object reflectPrivateObj2 = getReflectPrivateObj((VideoCapture) reflectPrivateObj, "mCurrentConfig", true);
                    if (reflectPrivateObj2 instanceof VideoCaptureConfig) {
                        Log.e("录制参数", "printRecordParamter 获取 VideoCaptureConfig 成功");
                        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) reflectPrivateObj2;
                        try {
                            Log.e("录制参数", "开始录制，视频码率=" + videoCaptureConfig.getBitRate());
                            Log.e("录制参数", "开始录制，获取视频帧率=" + videoCaptureConfig.getVideoFrameRate());
                        } catch (Exception e) {
                            Log.e("录制参数", "printRecordParamter 获取 VideoCaptureConfig 信息失败 = " + e);
                        }
                    } else {
                        Log.e("录制参数", "printRecordParamter 获取 VideoCaptureConfig 失败");
                    }
                } else {
                    Log.e("录制参数", "printRecordParamter获取 VideoCapture 失败");
                }
            } catch (Exception e2) {
                Log.e("录制参数", "printRecordParamter setRecordParameter 失败=" + e2);
            }
        }
    }

    public void initCamera(PictureSelectionConfig pictureSelectionConfig) {
        this.mConfig = pictureSelectionConfig;
        if (ActivityCompat.checkSelfPermission(getContext(), "android.permission.CAMERA") == 0) {
            this.mCameraController = new LifecycleCameraController(getContext());
            setRecordParameter();
            this.mCameraController.bindToLifecycle(getContext());
            this.mCameraController.setCameraSelector(this.mConfig.isCameraAroundState ? CameraSelector.DEFAULT_FRONT_CAMERA : CameraSelector.DEFAULT_BACK_CAMERA);
            this.mCameraPreviewView.setController(this.mCameraController);
        }
        setFlashRes();
    }

    private static class MyImageResultCallback implements ImageCapture.OnImageSavedCallback {
        private final WeakReference<CameraListener> mCameraListenerReference;
        private final WeakReference<CaptureLayout> mCaptureLayoutReference;
        private final WeakReference<File> mFileReference;
        private final WeakReference<ImageCallbackListener> mImageCallbackListenerReference;
        private final WeakReference<ImageView> mImagePreviewReference;

        public MyImageResultCallback(File file, ImageView imageView, CaptureLayout captureLayout, ImageCallbackListener imageCallbackListener, CameraListener cameraListener) {
            this.mFileReference = new WeakReference<>(file);
            this.mImagePreviewReference = new WeakReference<>(imageView);
            this.mCaptureLayoutReference = new WeakReference<>(captureLayout);
            this.mImageCallbackListenerReference = new WeakReference<>(imageCallbackListener);
            this.mCameraListenerReference = new WeakReference<>(cameraListener);
        }

        public void onImageSaved(ImageCapture.OutputFileResults outputFileResults) {
            if (this.mCaptureLayoutReference.get() != null) {
                ((CaptureLayout) this.mCaptureLayoutReference.get()).setButtonCaptureEnabled(true);
            }
            if (!(this.mImageCallbackListenerReference.get() == null || this.mFileReference.get() == null || this.mImagePreviewReference.get() == null)) {
                ((ImageCallbackListener) this.mImageCallbackListenerReference.get()).onLoadImage((File) this.mFileReference.get(), (ImageView) this.mImagePreviewReference.get());
            }
            if (this.mImagePreviewReference.get() != null) {
                ((ImageView) this.mImagePreviewReference.get()).setVisibility(0);
            }
            if (this.mCaptureLayoutReference.get() != null) {
                ((CaptureLayout) this.mCaptureLayoutReference.get()).startTypeBtnAnimator();
            }
        }

        public void onError(ImageCaptureException imageCaptureException) {
            if (this.mCaptureLayoutReference.get() != null) {
                ((CaptureLayout) this.mCaptureLayoutReference.get()).setButtonCaptureEnabled(true);
            }
            if (this.mCameraListenerReference.get() != null) {
                ((CameraListener) this.mCameraListenerReference.get()).onError(imageCaptureException.getImageCaptureError(), imageCaptureException.getMessage(), imageCaptureException.getCause());
            }
        }
    }

    public File createImageFile() {
        String str;
        String str2;
        boolean checkedAndroid_Q = SdkVersionUtils.checkedAndroid_Q();
        String str3 = PictureMimeType.JPG;
        if (checkedAndroid_Q) {
            File file = new File(PictureFileUtils.getDiskCacheDir(getContext()));
            if (!file.exists()) {
                file.mkdirs();
            }
            boolean isEmpty = TextUtils.isEmpty(this.mConfig.cameraFileName);
            if (TextUtils.isEmpty(this.mConfig.cameraImageFormat)) {
                if (this.mConfig.suffixType.startsWith("image/")) {
                    str3 = this.mConfig.suffixType.replaceAll("image/", ".");
                }
            } else if (this.mConfig.cameraImageFormat.startsWith("image/")) {
                str3 = this.mConfig.cameraImageFormat.replaceAll("image/", ".");
            } else {
                str3 = this.mConfig.cameraImageFormat;
            }
            if (isEmpty) {
                str2 = DateUtils.getCreateFileName("IMG_") + str3;
            } else {
                str2 = this.mConfig.cameraFileName;
            }
            File file2 = new File(file, str2);
            Uri outUri = getOutUri(PictureMimeType.ofImage());
            if (outUri != null) {
                this.mConfig.cameraPath = outUri.toString();
            }
            return file2;
        }
        if (!TextUtils.isEmpty(this.mConfig.cameraFileName)) {
            boolean isSuffixOfImage = PictureMimeType.isSuffixOfImage(this.mConfig.cameraFileName);
            PictureSelectionConfig pictureSelectionConfig = this.mConfig;
            pictureSelectionConfig.cameraFileName = !isSuffixOfImage ? StringUtils.renameSuffix(pictureSelectionConfig.cameraFileName, str3) : pictureSelectionConfig.cameraFileName;
            str = this.mConfig.camera ? this.mConfig.cameraFileName : StringUtils.rename(this.mConfig.cameraFileName);
        } else {
            str = "";
        }
        File createCameraFile = PictureFileUtils.createCameraFile(getContext(), PictureMimeType.ofImage(), str, TextUtils.isEmpty(this.mConfig.cameraImageFormat) ? this.mConfig.suffixType : this.mConfig.cameraImageFormat, this.mConfig.outPutCameraPath);
        this.mConfig.cameraPath = createCameraFile.getAbsolutePath();
        return createCameraFile;
    }

    public File createVideoFile() {
        String str;
        String str2;
        String str3 = ".mp4";
        if (SdkVersionUtils.checkedAndroid_Q()) {
            File file = new File(PictureFileUtils.getVideoDiskCacheDir(getContext()));
            if (!file.exists()) {
                file.mkdirs();
            }
            boolean isEmpty = TextUtils.isEmpty(this.mConfig.cameraFileName);
            if (TextUtils.isEmpty(this.mConfig.cameraVideoFormat)) {
                if (this.mConfig.suffixType.startsWith("video/")) {
                    str3 = this.mConfig.suffixType.replaceAll("video/", ".");
                }
            } else if (this.mConfig.cameraVideoFormat.startsWith("video/")) {
                str3 = this.mConfig.cameraVideoFormat.replaceAll("video/", ".");
            } else {
                str3 = this.mConfig.cameraVideoFormat;
            }
            if (isEmpty) {
                str2 = DateUtils.getCreateFileName("VID_") + str3;
            } else {
                str2 = this.mConfig.cameraFileName;
            }
            File file2 = new File(file, str2);
            Uri outUri = getOutUri(PictureMimeType.ofVideo());
            if (outUri != null) {
                this.mConfig.cameraPath = outUri.toString();
            }
            return file2;
        }
        if (!TextUtils.isEmpty(this.mConfig.cameraFileName)) {
            boolean isSuffixOfImage = PictureMimeType.isSuffixOfImage(this.mConfig.cameraFileName);
            PictureSelectionConfig pictureSelectionConfig = this.mConfig;
            pictureSelectionConfig.cameraFileName = !isSuffixOfImage ? StringUtils.renameSuffix(pictureSelectionConfig.cameraFileName, str3) : pictureSelectionConfig.cameraFileName;
            str = this.mConfig.camera ? this.mConfig.cameraFileName : StringUtils.rename(this.mConfig.cameraFileName);
        } else {
            str = "";
        }
        File createCameraFile = PictureFileUtils.createCameraFile(getContext(), PictureMimeType.ofVideo(), str, TextUtils.isEmpty(this.mConfig.cameraVideoFormat) ? this.mConfig.suffixType : this.mConfig.cameraVideoFormat, this.mConfig.outPutCameraPath);
        this.mConfig.cameraPath = createCameraFile.getAbsolutePath();
        return createCameraFile;
    }

    private Uri getOutUri(int i) {
        if (i == PictureMimeType.ofVideo()) {
            return MediaUtils.createVideoUri(getContext(), this.mConfig.cameraFileName, TextUtils.isEmpty(this.mConfig.cameraVideoFormat) ? this.mConfig.suffixType : this.mConfig.cameraVideoFormat);
        }
        return MediaUtils.createImageUri(getContext(), this.mConfig.cameraFileName, TextUtils.isEmpty(this.mConfig.cameraImageFormat) ? this.mConfig.suffixType : this.mConfig.cameraImageFormat);
    }

    public void setCameraListener(CameraListener cameraListener) {
        this.mCameraListener = cameraListener;
    }

    public void setRecordVideoMaxTime(int i) {
        this.mRecordDuration = ((long) i) * 1000;
        this.mCaptureLayout.setDuration(i * ResultCode.KARAOKE_SUCCESS);
    }

    public void setRecordVideoMinTime(int i) {
        this.mCaptureLayout.setMinDuration(i * ResultCode.KARAOKE_SUCCESS);
    }

    public void setCaptureLoadingColor(int i) {
        this.mCaptureLayout.setCaptureLoadingColor(i);
    }

    public void toggleCamera() {
        if (this.mCameraController.getCameraSelector() == CameraSelector.DEFAULT_BACK_CAMERA && this.mCameraController.hasCamera(CameraSelector.DEFAULT_FRONT_CAMERA)) {
            this.mCameraController.setCameraSelector(CameraSelector.DEFAULT_FRONT_CAMERA);
        } else if (this.mCameraController.getCameraSelector() == CameraSelector.DEFAULT_FRONT_CAMERA && this.mCameraController.hasCamera(CameraSelector.DEFAULT_BACK_CAMERA)) {
            this.mCameraController.setCameraSelector(CameraSelector.DEFAULT_BACK_CAMERA);
        }
    }

    public void setOnClickListener(ClickListener clickListener) {
        this.mOnClickListener = clickListener;
    }

    public void setImageCallbackListener(ImageCallbackListener imageCallbackListener) {
        this.mImageCallbackListener = imageCallbackListener;
    }

    private void setFlashRes() {
        switch (this.type_flash) {
            case 33:
                this.mFlashLamp.setImageResource(R.drawable.picture_ic_flash_auto);
                this.mCameraController.setImageCaptureFlashMode(0);
                return;
            case 34:
                this.mFlashLamp.setImageResource(R.drawable.picture_ic_flash_on);
                this.mCameraController.setImageCaptureFlashMode(1);
                return;
            case 35:
                this.mFlashLamp.setImageResource(R.drawable.picture_ic_flash_off);
                this.mCameraController.setImageCaptureFlashMode(2);
                return;
            default:
                return;
        }
    }

    public CaptureLayout getCaptureLayout() {
        return this.mCaptureLayout;
    }

    /* access modifiers changed from: private */
    public void resetState() {
        if (this.mCameraController.isImageCaptureEnabled()) {
            this.mImagePreview.setVisibility(4);
        } else if (this.mCameraController.isRecording()) {
            this.mCameraController.stopRecording();
        }
        File file = this.mOutMediaFile;
        if (file != null && file.exists()) {
            this.mOutMediaFile.delete();
            if (SdkVersionUtils.checkedAndroid_Q()) {
                MediaUtils.deleteCamera(getContext(), this.mConfig.cameraPath);
            } else {
                new PictureMediaScannerConnection(getContext(), this.mOutMediaFile.getAbsolutePath());
            }
        }
        this.mSwitchCamera.setVisibility(0);
        this.mFlashLamp.setVisibility(0);
        this.mCameraPreviewView.setVisibility(0);
        this.mCaptureLayout.resetCaptureLayout();
    }

    /* access modifiers changed from: private */
    public void startVideoPlay(File file) {
        try {
            if (this.mMediaPlayer == null) {
                this.mMediaPlayer = new MediaPlayer();
            }
            this.mMediaPlayer.setDataSource(file.getAbsolutePath());
            this.mMediaPlayer.setSurface(new Surface(this.mTextureView.getSurfaceTexture()));
            this.mMediaPlayer.setLooping(true);
            this.mMediaPlayer.setOnPreparedListener(new CustomCameraView$$ExternalSyntheticLambda0(this));
            this.mMediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$startVideoPlay$1$CustomCameraView(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
        float videoWidth = (((float) mediaPlayer.getVideoWidth()) * 1.0f) / ((float) mediaPlayer.getVideoHeight());
        int width = this.mTextureView.getWidth();
        ViewGroup.LayoutParams layoutParams = this.mTextureView.getLayoutParams();
        layoutParams.height = (int) (((float) width) / videoWidth);
        this.mTextureView.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public void stopVideoPlay() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        this.mTextureView.setVisibility(8);
    }

    public void unbindCameraController() {
        LifecycleCameraController lifecycleCameraController = this.mCameraController;
        if (lifecycleCameraController != null) {
            lifecycleCameraController.unbind();
        }
    }

    private String stringForTime(long j) {
        if (j <= 0 || j >= 86400000) {
            return "00:00";
        }
        int i = (int) (j / 1000);
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        if (i4 > 0) {
            return formatter.format("%d:%02d:%02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)}).toString();
        }
        return formatter.format("%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)}).toString();
    }

    /* access modifiers changed from: private */
    public void showCurrentRecordTime(long j) {
        long j2 = this.mRecordDuration;
        if (j > j2) {
            j = j2;
        }
        this.mCountDownTimeView.setText(String.format("%s / %s", new Object[]{stringForTime(j), stringForTime(this.mRecordDuration)}));
    }
}
