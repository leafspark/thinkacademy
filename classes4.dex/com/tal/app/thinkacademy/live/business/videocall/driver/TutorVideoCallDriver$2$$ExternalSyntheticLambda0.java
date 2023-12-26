package com.tal.app.thinkacademy.live.business.videocall.driver;

import com.tal.app.thinkacademy.live.business.videocall.driver.TutorVideoCallDriver;

public final /* synthetic */ class TutorVideoCallDriver$2$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ TutorVideoCallDriver.AnonymousClass2 f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ long f$3;

    public /* synthetic */ TutorVideoCallDriver$2$$ExternalSyntheticLambda0(TutorVideoCallDriver.AnonymousClass2 r1, int i, String str, long j) {
        this.f$0 = r1;
        this.f$1 = i;
        this.f$2 = str;
        this.f$3 = j;
    }

    public final void run() {
        this.f$0.lambda$onRemoteVideoStateChanged$4$TutorVideoCallDriver$2(this.f$1, this.f$2, this.f$3);
    }
}
