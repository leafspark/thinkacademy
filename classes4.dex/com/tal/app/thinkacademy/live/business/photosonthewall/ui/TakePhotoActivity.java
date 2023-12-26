package com.tal.app.thinkacademy.live.business.photosonthewall.ui;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.base.BaseBindActivity;
import com.tal.app.thinkacademy.lib.commui.widget.pad.NotPadAutoScreen;
import com.tal.app.thinkacademy.lib.entity.AppNetWorkConfigRemoteInfo;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessActivityTakePhotoBinding;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData;
import com.tal.app.thinkacademy.live.business.photosonthewall.util.TakePhotoStateUtil;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import top.zibin.luban.Luban;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0019\b\u0007\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\tH\u0014J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0016J\u001a\u0010&\u001a\u00020'2\u0010\u0010(\u001a\f\u0012\b\u0012\u00060*R\u00020\r0)H\u0002J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\tH\u0002J \u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0012H\u0002J\b\u00105\u001a\u00020$H\u0016J\u0012\u00106\u001a\u00020$2\b\u00107\u001a\u0004\u0018\u000108H\u0014J\b\u00109\u001a\u00020$H\u0014J\b\u0010:\u001a\u00020$H\u0014J\b\u0010;\u001a\u00020$H\u0014J\u0016\u0010<\u001a\u00020$2\u0006\u00102\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0012J\b\u0010=\u001a\u00020$H\u0002J\u0010\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020\u000bH\u0002J\b\u0010@\u001a\u00020$H\u0002J\b\u0010A\u001a\u00020$H\u0002J\b\u0010B\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/ui/TakePhotoActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseBindActivity;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessActivityTakePhotoBinding;", "()V", "KCreateFile", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "isOnDestroy", "", "mBeginTime", "", "mCamera", "Landroid/hardware/Camera;", "mCameraPosition", "mCountDownTimer", "Landroid/os/CountDownTimer;", "mFileName", "", "mHandler", "Landroid/os/Handler;", "mIsSufaceCreated", "mPhotosMaintainData", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotosMaintainData;", "mSurfaceCallback", "com/tal/app/thinkacademy/live/business/photosonthewall/ui/TakePhotoActivity$mSurfaceCallback$1", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/ui/TakePhotoActivity$mSurfaceCallback$1;", "mSurfaceHolder", "Landroid/view/SurfaceHolder;", "mTotalTime", "safeToTakePicture", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "endCountdown", "", "finish", "getAppropriateSize", "", "sizes", "", "Landroid/hardware/Camera$Size;", "getApproximate", "", "key", "keys", "", "isHasPermission", "luban", "path", "cacheDir", "fileName", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "refreshAlbum", "setViewValues", "startCountdown", "millisDuration", "startPreview", "stopPreview", "switchCamera", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@NotPadAutoScreen
/* compiled from: TakePhotoActivity.kt */
public final class TakePhotoActivity extends BaseBindActivity<LiveBusinessActivityTakePhotoBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int WHAT_TAKE_PHOTO_TIMEOUT = 100;
    /* access modifiers changed from: private */
    public final int KCreateFile;
    /* access modifiers changed from: private */
    public final Tag TAG = Tag.TakePhotoActivity;
    private boolean isOnDestroy;
    /* access modifiers changed from: private */
    public long mBeginTime;
    /* access modifiers changed from: private */
    public Camera mCamera;
    /* access modifiers changed from: private */
    public int mCameraPosition;
    private CountDownTimer mCountDownTimer;
    /* access modifiers changed from: private */
    public String mFileName = "";
    /* access modifiers changed from: private */
    public Handler mHandler = new TakePhotoActivity$mHandler$1(this, Looper.getMainLooper());
    /* access modifiers changed from: private */
    public boolean mIsSufaceCreated;
    /* access modifiers changed from: private */
    public PhotosMaintainData mPhotosMaintainData;
    private final TakePhotoActivity$mSurfaceCallback$1 mSurfaceCallback = new TakePhotoActivity$mSurfaceCallback$1(this);
    private SurfaceHolder mSurfaceHolder;
    /* access modifiers changed from: private */
    public long mTotalTime;
    /* access modifiers changed from: private */
    public boolean safeToTakePicture = true;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/ui/TakePhotoActivity$Companion;", "", "()V", "WHAT_TAKE_PHOTO_TIMEOUT", "", "startActivity", "", "context", "Landroid/content/Context;", "data", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotosMaintainData;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TakePhotoActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startActivity(Context context, PhotosMaintainData photosMaintainData) {
            TakePhotoStateUtil.startTakePhoto();
            new Handler(Looper.getMainLooper()).postDelayed(new TakePhotoActivity$Companion$$ExternalSyntheticLambda0(context, photosMaintainData), 1000);
        }

        /* access modifiers changed from: private */
        /* renamed from: startActivity$lambda-1  reason: not valid java name */
        public static final void m377startActivity$lambda1(Context context, PhotosMaintainData photosMaintainData) {
            if (context != null) {
                Intent intent = new Intent(context, TakePhotoActivity.class);
                intent.putExtra(TakePhotoActivityKt.PhotosMaintainData, photosMaintainData);
                context.startActivity(intent);
            }
        }
    }

    /* access modifiers changed from: protected */
    public LiveBusinessActivityTakePhotoBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessActivityTakePhotoBinding inflate = LiveBusinessActivityTakePhotoBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        long j;
        Long beginTime;
        Long totalTime;
        requestWindowFeature(1);
        Window window = getWindow();
        View decorView = window == null ? null : window.getDecorView();
        if (decorView != null) {
            decorView.setSystemUiVisibility(2564);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setFlags(1024, 1024);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.addFlags(LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP);
        }
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            PhotosMaintainData photosMaintainData = (PhotosMaintainData) intent.getParcelableExtra(TakePhotoActivityKt.PhotosMaintainData);
            this.mPhotosMaintainData = photosMaintainData;
            long j2 = 0;
            if (photosMaintainData == null || (totalTime = photosMaintainData.getTotalTime()) == null) {
                j = 0;
            } else {
                j = totalTime.longValue();
            }
            this.mTotalTime = j;
            PhotosMaintainData photosMaintainData2 = this.mPhotosMaintainData;
            if (!(photosMaintainData2 == null || (beginTime = photosMaintainData2.getBeginTime()) == null)) {
                j2 = beginTime.longValue();
            }
            this.mBeginTime = j2;
            if (isHasPermission()) {
                XesLog.i(this.TAG, "isHasPermission ---> true");
                setViewValues();
                return;
            }
            XesLog.i(this.TAG, "isHasPermission ---> false");
            ToastUtils.showShort(R.string.camera_access_settings);
        }
    }

    /* access modifiers changed from: private */
    public final void switchCamera() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.stopPreview();
            camera.release();
        }
        this.mCamera = null;
        startPreview();
    }

    private final void setViewValues() {
        PhotosMaintainData photosMaintainData = this.mPhotosMaintainData;
        if (!(photosMaintainData == null ? false : Intrinsics.areEqual(photosMaintainData.isCorrection(), true))) {
            getBinding().llCountdown.setVisibility(0);
            startCountdown(this.mTotalTime - (System.currentTimeMillis() - this.mBeginTime));
        } else {
            getBinding().llCountdown.setVisibility(8);
        }
        SurfaceHolder holder = getBinding().cameraPreview.getHolder();
        if (holder == null) {
            holder = null;
        } else {
            holder.addCallback(this.mSurfaceCallback);
            holder.setType(3);
        }
        this.mSurfaceHolder = holder;
        getBinding().ivBack.setOnClickListener(new TakePhotoActivity$$ExternalSyntheticLambda1(this));
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        ImageView imageView = getBinding().ivSwitch;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivSwitch");
        rxUnDoubleUtil.setOnUnDoubleClickListener(imageView, 500, new TakePhotoActivity$setViewValues$3(this));
        RxUnDoubleUtil rxUnDoubleUtil2 = RxUnDoubleUtil.INSTANCE;
        ImageView imageView2 = getBinding().ivTakePhoto;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivTakePhoto");
        rxUnDoubleUtil2.setOnUnDoubleClickListener(imageView2, 1500, new TakePhotoActivity$setViewValues$4(this));
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with(DataBusKey.PHOTO_ON_THE_WALL_CLOSE).observe(lifecycleOwner, new TakePhotoActivity$$ExternalSyntheticLambda3(this));
        XesDataBus.with(DataBusKey.PHOTO_ON_THE_WALL_CLOSE_ALL).observe(lifecycleOwner, new TakePhotoActivity$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setViewValues$lambda-3  reason: not valid java name */
    public static final void m373setViewValues$lambda3(TakePhotoActivity takePhotoActivity, View view) {
        Intrinsics.checkNotNullParameter(takePhotoActivity, "this$0");
        takePhotoActivity.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: setViewValues$lambda-4  reason: not valid java name */
    public static final void m374setViewValues$lambda4(TakePhotoActivity takePhotoActivity, Object obj) {
        Intrinsics.checkNotNullParameter(takePhotoActivity, "this$0");
        if (!takePhotoActivity.isOnDestroy) {
            PhotosMaintainData photosMaintainData = takePhotoActivity.mPhotosMaintainData;
            if (!(photosMaintainData == null ? false : Intrinsics.areEqual(photosMaintainData.isCorrection(), true))) {
                takePhotoActivity.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setViewValues$lambda-5  reason: not valid java name */
    public static final void m375setViewValues$lambda5(TakePhotoActivity takePhotoActivity, Object obj) {
        Intrinsics.checkNotNullParameter(takePhotoActivity, "this$0");
        if (!takePhotoActivity.isOnDestroy) {
            PhotosMaintainData photosMaintainData = takePhotoActivity.mPhotosMaintainData;
            if (photosMaintainData == null ? false : Intrinsics.areEqual(photosMaintainData.isCorrection(), true)) {
                takePhotoActivity.showToast(takePhotoActivity.getString(R.string.interaction_ended));
            }
            takePhotoActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public final void startPreview() {
        XesLog.i(this.TAG, Intrinsics.stringPlus("startPreview ---> mIsSufaceCreated = ", Boolean.valueOf(this.mIsSufaceCreated)));
        if (this.mCamera == null && this.mIsSufaceCreated) {
            try {
                Camera open = Camera.open(this.mCameraPosition);
                this.mCamera = open;
                if (this.mCameraPosition == 1) {
                    if (open != null) {
                        open.setDisplayOrientation(0);
                    }
                } else if (open != null) {
                    open.setDisplayOrientation(0);
                }
                Camera camera = this.mCamera;
                if (camera != null) {
                    Camera.Parameters parameters = null;
                    if (camera != null) {
                        Camera.Parameters parameters2 = camera.getParameters();
                        if (parameters2 != null) {
                            List<Camera.Size> supportedPreviewSizes = parameters2.getSupportedPreviewSizes();
                            if (supportedPreviewSizes != null) {
                                if (!supportedPreviewSizes.isEmpty()) {
                                    int[] appropriateSize = getAppropriateSize(supportedPreviewSizes);
                                    parameters2.setPreviewSize(appropriateSize[0], appropriateSize[1]);
                                }
                            }
                            List<Camera.Size> supportedPictureSizes = parameters2.getSupportedPictureSizes();
                            if (supportedPictureSizes != null) {
                                if (!supportedPictureSizes.isEmpty()) {
                                    int[] appropriateSize2 = getAppropriateSize(supportedPictureSizes);
                                    parameters2.setPictureSize(appropriateSize2[0], appropriateSize2[1]);
                                }
                            }
                            if (this.mCameraPosition == 1) {
                                parameters2.setRotation(0);
                            } else {
                                parameters2.setRotation(0);
                                List<String> supportedFocusModes = parameters2.getSupportedFocusModes();
                                if (supportedFocusModes != null) {
                                    if (!supportedFocusModes.isEmpty() && supportedFocusModes.contains("continuous-picture")) {
                                        parameters2.setFocusMode("continuous-picture");
                                    }
                                }
                                List<String> supportedFlashModes = parameters2.getSupportedFlashModes();
                                if (supportedFlashModes != null) {
                                    if (!supportedFlashModes.isEmpty() && supportedFlashModes.contains("auto")) {
                                        parameters2.setFlashMode("auto");
                                    }
                                }
                            }
                            parameters = parameters2;
                        }
                    }
                    camera.setParameters(parameters);
                }
                try {
                    Camera camera2 = this.mCamera;
                    if (camera2 != null) {
                        camera2.setErrorCallback(new TakePhotoActivity$$ExternalSyntheticLambda0(this));
                    }
                    Camera camera3 = this.mCamera;
                    if (camera3 != null) {
                        camera3.setPreviewDisplay(this.mSurfaceHolder);
                    }
                    Camera camera4 = this.mCamera;
                    if (camera4 != null) {
                        camera4.startPreview();
                    }
                } catch (Exception e) {
                    XesLog.i(this.TAG, Intrinsics.stringPlus("startPreview finally error ---> ", e.getMessage()));
                }
            } catch (Exception e2) {
                XesLog.i(this.TAG, Intrinsics.stringPlus("startPreview error ---> ", e2.getMessage()));
                try {
                    Camera camera5 = this.mCamera;
                    if (camera5 != null) {
                        camera5.setErrorCallback(new TakePhotoActivity$$ExternalSyntheticLambda0(this));
                    }
                    Camera camera6 = this.mCamera;
                    if (camera6 != null) {
                        camera6.setPreviewDisplay(this.mSurfaceHolder);
                    }
                    Camera camera7 = this.mCamera;
                    if (camera7 != null) {
                        camera7.startPreview();
                    }
                } catch (Exception e3) {
                    XesLog.i(this.TAG, Intrinsics.stringPlus("startPreview finally error ---> ", e3.getMessage()));
                }
            } catch (Throwable th) {
                try {
                    Camera camera8 = this.mCamera;
                    if (camera8 != null) {
                        camera8.setErrorCallback(new TakePhotoActivity$$ExternalSyntheticLambda0(this));
                    }
                    Camera camera9 = this.mCamera;
                    if (camera9 != null) {
                        camera9.setPreviewDisplay(this.mSurfaceHolder);
                    }
                    Camera camera10 = this.mCamera;
                    if (camera10 != null) {
                        camera10.startPreview();
                    }
                } catch (Exception e4) {
                    XesLog.i(this.TAG, Intrinsics.stringPlus("startPreview finally error ---> ", e4.getMessage()));
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startPreview$lambda-11  reason: not valid java name */
    public static final void m376startPreview$lambda11(TakePhotoActivity takePhotoActivity, int i, Camera camera) {
        Intrinsics.checkNotNullParameter(takePhotoActivity, "this$0");
        XesLog.i(takePhotoActivity.TAG, Intrinsics.stringPlus("onError = ", Integer.valueOf(i)));
        if (i == 2) {
            ToastUtils.showShort(R.string.camera_was_disconnected_due_to_use_by_higher_priority_user);
            XesLog.i(takePhotoActivity.TAG, "onError = " + i + " ---> 相机被更高优先级的用户占用");
        }
    }

    private final void stopPreview() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.setPreviewDisplay((SurfaceHolder) null);
            } catch (Exception e) {
                XesLog.e(this.TAG, Intrinsics.stringPlus("stopPreview,setPreviewDisplay出错,错误信息=", e));
            }
            try {
                camera.stopPreview();
            } catch (Exception e2) {
                XesLog.e(this.TAG, Intrinsics.stringPlus("stopPreview,停止预览出错,错误信息=", e2));
            }
            try {
                camera.release();
            } catch (Exception e3) {
                XesLog.e(this.TAG, Intrinsics.stringPlus("stopPreview,释放出错,错误信息=", e3));
            }
        }
        this.mCamera = null;
        return;
    }

    private final int[] getAppropriateSize(List<? extends Camera.Size> list) {
        List<Camera.Size> sortedWith = CollectionsKt.sortedWith(list, new TakePhotoActivity$getAppropriateSize$$inlined$sortedByDescending$1());
        HashMap hashMap = new HashMap();
        for (Camera.Size size : sortedWith) {
            if (size.width > size.height) {
                double d = ((double) size.width) / ((double) size.height);
                if (!hashMap.keySet().contains(Double.valueOf(d))) {
                    hashMap.put(Double.valueOf(d), size);
                }
            } else {
                double d2 = ((double) size.width) / ((double) size.height);
                if (!hashMap.keySet().contains(Double.valueOf(d2))) {
                    hashMap.put(Double.valueOf(d2), size);
                }
            }
        }
        Set keySet = hashMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "map.keys");
        double approximate = getApproximate(1.3333333333333333d, CollectionsKt.toDoubleArray(keySet));
        Object obj = hashMap.get(Double.valueOf(approximate));
        Intrinsics.checkNotNull(obj);
        Object obj2 = hashMap.get(Double.valueOf(approximate));
        Intrinsics.checkNotNull(obj2);
        return new int[]{((Camera.Size) obj).width, ((Camera.Size) obj2).height};
    }

    private final double getApproximate(double d, double[] dArr) {
        double abs = Math.abs(dArr[0] - d);
        int length = dArr.length;
        double d2 = abs;
        int i = 0;
        int i2 = 1;
        double d3 = d2;
        while (i2 < length) {
            int i3 = i2 + 1;
            double abs2 = Math.abs(dArr[i2] - d);
            if (abs2 < d3) {
                i = i2;
                i2 = i3;
                d3 = abs2;
            } else {
                i2 = i3;
            }
        }
        return dArr[i];
    }

    private final void startCountdown(long j) {
        CountDownTimer takePhotoActivity$startCountdown$1 = new TakePhotoActivity$startCountdown$1(RangesKt.coerceAtLeast(j, 0), this);
        this.mCountDownTimer = takePhotoActivity$startCountdown$1;
        takePhotoActivity$startCountdown$1.start();
    }

    private final void endCountdown() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mCountDownTimer = null;
    }

    /* access modifiers changed from: private */
    public final void luban(String str, String str2, String str3) {
        Luban.with((Context) this).load(str).ignoreBy(AppNetWorkConfigRemoteInfo.MAX_TIME_OUT).setTargetDir(str2).setCompressListener(new TakePhotoActivity$luban$1(this, str2)).launch();
    }

    public final void refreshAlbum(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(str2, "fileName");
        if (FileUtils.isFileExists(str)) {
            try {
                MediaStore.Images.Media.insertImage(getContentResolver(), str, str2, str2);
            } catch (Exception unused) {
            }
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(new File(str)));
            sendBroadcast(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        try {
            Camera camera = this.mCamera;
            if (camera != null) {
                camera.startPreview();
            }
        } catch (Exception e) {
            XesLog.i(this.TAG, Intrinsics.stringPlus("startPreview error onResume ---> ", e.getMessage()));
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        stopPreview();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.isOnDestroy = true;
        endCountdown();
        stopPreview();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler = null;
    }

    public void onBackPressed() {
        finish();
    }

    public void finish() {
        TakePhotoStateUtil.finishTakePhoto();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new TakePhotoActivity$$ExternalSyntheticLambda4(this), 1000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: finish$lambda-15  reason: not valid java name */
    public static final void m372finish$lambda15(TakePhotoActivity takePhotoActivity) {
        Intrinsics.checkNotNullParameter(takePhotoActivity, "this$0");
        super.finish();
    }

    private final boolean isHasPermission() {
        return PermissionUtils.isGranted("android.permission.CAMERA");
    }
}
