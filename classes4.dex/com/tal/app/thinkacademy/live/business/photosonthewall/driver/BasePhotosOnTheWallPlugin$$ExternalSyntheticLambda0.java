package com.tal.app.thinkacademy.live.business.photosonthewall.driver;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotoSubmitResult;

public final /* synthetic */ class BasePhotosOnTheWallPlugin$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ BasePhotosOnTheWallPlugin f$0;

    public /* synthetic */ BasePhotosOnTheWallPlugin$$ExternalSyntheticLambda0(BasePhotosOnTheWallPlugin basePhotosOnTheWallPlugin) {
        this.f$0 = basePhotosOnTheWallPlugin;
    }

    public final void onChanged(Object obj) {
        BasePhotosOnTheWallPlugin.m359mPhotoSubmissionResult$lambda0(this.f$0, (PhotoSubmitResult) obj);
    }
}
