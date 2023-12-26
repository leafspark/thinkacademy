package com.luck.picture.lib;

import android.widget.ImageView;
import com.luck.picture.lib.camera.listener.ImageCallbackListener;
import java.io.File;

public final /* synthetic */ class PictureCustomCameraActivity$$ExternalSyntheticLambda2 implements ImageCallbackListener {
    public final /* synthetic */ PictureCustomCameraActivity f$0;

    public /* synthetic */ PictureCustomCameraActivity$$ExternalSyntheticLambda2(PictureCustomCameraActivity pictureCustomCameraActivity) {
        this.f$0 = pictureCustomCameraActivity;
    }

    public final void onLoadImage(File file, ImageView imageView) {
        this.f$0.lambda$initView$0$PictureCustomCameraActivity(file, imageView);
    }
}
