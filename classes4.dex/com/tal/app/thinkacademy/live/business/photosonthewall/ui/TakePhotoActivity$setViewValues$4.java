package com.tal.app.thinkacademy.live.business.photosonthewall.ui;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TakePhotoActivity.kt */
final class TakePhotoActivity$setViewValues$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TakePhotoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TakePhotoActivity$setViewValues$4(TakePhotoActivity takePhotoActivity) {
        super(0);
        this.this$0 = takePhotoActivity;
    }

    public final void invoke() {
        String interactId;
        if (this.this$0.safeToTakePicture) {
            XesLog.i(this.this$0.TAG, "点击拍照按钮");
            SoundPoolUtils.play((Context) this.this$0, R.raw.live_business_interact_button_click, 0);
            this.this$0.safeToTakePicture = false;
            Handler access$getMHandler$p = this.this$0.mHandler;
            if (access$getMHandler$p != null) {
                access$getMHandler$p.sendEmptyMessageDelayed(100, 5000);
            }
            try {
                Camera access$getMCamera$p = this.this$0.mCamera;
                if (access$getMCamera$p != null) {
                    access$getMCamera$p.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, new TakePhotoActivity$setViewValues$4$$ExternalSyntheticLambda0(this.this$0));
                }
            } catch (Exception e) {
                Handler access$getMHandler$p2 = this.this$0.mHandler;
                if (access$getMHandler$p2 != null) {
                    access$getMHandler$p2.removeMessages(100);
                }
                XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("拍照异常 = ", e));
                this.this$0.safeToTakePicture = true;
            }
            DriverTrack driverTrack = DriverTrack.INSTANCE;
            PhotosMaintainData access$getMPhotosMaintainData$p = this.this$0.mPhotosMaintainData;
            String str = "";
            if (!(access$getMPhotosMaintainData$p == null || (interactId = access$getMPhotosMaintainData$p.getInteractId()) == null)) {
                str = interactId;
            }
            driverTrack.classRoomInteractPhotographControl(str, "拍照");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m379invoke$lambda1(TakePhotoActivity takePhotoActivity, byte[] bArr, Camera camera) {
        Intrinsics.checkNotNullParameter(takePhotoActivity, "this$0");
        Handler access$getMHandler$p = takePhotoActivity.mHandler;
        if (access$getMHandler$p != null) {
            access$getMHandler$p.removeMessages(100);
        }
        XesLog.i(takePhotoActivity.TAG, "拍照成功，调用takePicture获取data");
        takePhotoActivity.safeToTakePicture = true;
        Handler access$getMHandler$p2 = takePhotoActivity.mHandler;
        if (access$getMHandler$p2 != null) {
            Message message = new Message();
            message.what = takePhotoActivity.KCreateFile;
            message.obj = bArr;
            access$getMHandler$p2.sendMessageDelayed(message, 0);
        }
    }
}
