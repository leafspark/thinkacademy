package com.tal.app.thinkacademy.live.business.photosonthewall.ui;

import android.hardware.Camera;

public final /* synthetic */ class TakePhotoActivity$$ExternalSyntheticLambda0 implements Camera.ErrorCallback {
    public final /* synthetic */ TakePhotoActivity f$0;

    public /* synthetic */ TakePhotoActivity$$ExternalSyntheticLambda0(TakePhotoActivity takePhotoActivity) {
        this.f$0 = takePhotoActivity;
    }

    public final void onError(int i, Camera camera) {
        TakePhotoActivity.m376startPreview$lambda11(this.f$0, i, camera);
    }
}
