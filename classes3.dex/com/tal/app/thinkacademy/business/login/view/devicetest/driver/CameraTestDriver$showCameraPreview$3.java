package com.tal.app.thinkacademy.business.login.view.devicetest.driver;

import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/SurfaceView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CameraTestDriver.kt */
final class CameraTestDriver$showCameraPreview$3 extends Lambda implements Function1<SurfaceView, Unit> {
    final /* synthetic */ CameraTestDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraTestDriver$showCameraPreview$3(CameraTestDriver cameraTestDriver) {
        super(1);
        this.this$0 = cameraTestDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SurfaceView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SurfaceView surfaceView) {
        if (surfaceView != null) {
            CameraTestDriver cameraTestDriver = this.this$0;
            XesLog.it(CameraTestDriver.TAG, new Object[]{"摄像头预览，RTC图像回调"});
            ViewParent parent = surfaceView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(surfaceView);
            }
            FrameLayout access$getMLayoutCameraContainer$p = cameraTestDriver.mLayoutCameraContainer;
            if (access$getMLayoutCameraContainer$p != null) {
                access$getMLayoutCameraContainer$p.removeAllViews();
            }
            FrameLayout access$getMLayoutCameraContainer$p2 = cameraTestDriver.mLayoutCameraContainer;
            if (access$getMLayoutCameraContainer$p2 != null) {
                access$getMLayoutCameraContainer$p2.addView(surfaceView);
            }
        }
    }
}
