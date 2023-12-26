package com.tal.app.thinkacademy.live.business.photosonthewall.driver;

import androidx.lifecycle.Observer;

public final /* synthetic */ class BasePhotosOnTheWallPlugin$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ BasePhotosOnTheWallPlugin f$0;

    public /* synthetic */ BasePhotosOnTheWallPlugin$$ExternalSyntheticLambda1(BasePhotosOnTheWallPlugin basePhotosOnTheWallPlugin) {
        this.f$0 = basePhotosOnTheWallPlugin;
    }

    public final void onChanged(Object obj) {
        BasePhotosOnTheWallPlugin.m360registerTakePhotoStateBus$lambda9(this.f$0, obj);
    }
}
