package com.tal.app.thinkacademy.live.business.videocall.driver;

import com.eaydu.omni.listener.RTCConnectionStateType;
import com.tal.app.thinkacademy.live.business.videocall.driver.TutorVideoCallDriver;

public final /* synthetic */ class TutorVideoCallDriver$2$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ TutorVideoCallDriver.AnonymousClass2 f$0;
    public final /* synthetic */ RTCConnectionStateType f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ TutorVideoCallDriver$2$$ExternalSyntheticLambda4(TutorVideoCallDriver.AnonymousClass2 r1, RTCConnectionStateType rTCConnectionStateType, String str, String str2) {
        this.f$0 = r1;
        this.f$1 = rTCConnectionStateType;
        this.f$2 = str;
        this.f$3 = str2;
    }

    public final void run() {
        this.f$0.lambda$dispatchConnectionState$1$TutorVideoCallDriver$2(this.f$1, this.f$2, this.f$3);
    }
}
