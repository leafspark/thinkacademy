package com.tal.app.thinkacademy.live.business.photosonthewall.ui;

import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TakePhotoActivity.kt */
final class TakePhotoActivity$setViewValues$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TakePhotoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TakePhotoActivity$setViewValues$3(TakePhotoActivity takePhotoActivity) {
        super(0);
        this.this$0 = takePhotoActivity;
    }

    public final void invoke() {
        String interactId;
        if (this.this$0.mCameraPosition == 0) {
            this.this$0.mCameraPosition = 1;
        } else if (this.this$0.mCameraPosition == 1) {
            this.this$0.mCameraPosition = 0;
        }
        this.this$0.switchCamera();
        DriverTrack driverTrack = DriverTrack.INSTANCE;
        PhotosMaintainData access$getMPhotosMaintainData$p = this.this$0.mPhotosMaintainData;
        String str = "";
        if (!(access$getMPhotosMaintainData$p == null || (interactId = access$getMPhotosMaintainData$p.getInteractId()) == null)) {
            str = interactId;
        }
        driverTrack.classRoomInteractPhotographControl(str, "切换摄像头");
    }
}
