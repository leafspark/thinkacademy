package com.luck.picture.lib;

import android.view.View;
import com.luck.picture.lib.dialog.PictureCustomDialog;

public final /* synthetic */ class PictureCustomCameraActivity$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ PictureCustomCameraActivity f$0;
    public final /* synthetic */ PictureCustomDialog f$1;

    public /* synthetic */ PictureCustomCameraActivity$$ExternalSyntheticLambda1(PictureCustomCameraActivity pictureCustomCameraActivity, PictureCustomDialog pictureCustomDialog) {
        this.f$0 = pictureCustomCameraActivity;
        this.f$1 = pictureCustomDialog;
    }

    public final void onClick(View view) {
        this.f$0.lambda$showPermissionsDialog$2$PictureCustomCameraActivity(this.f$1, view);
    }
}