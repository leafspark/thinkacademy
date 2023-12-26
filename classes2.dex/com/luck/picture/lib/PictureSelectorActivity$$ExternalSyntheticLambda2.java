package com.luck.picture.lib;

import android.view.View;
import com.luck.picture.lib.dialog.PictureCustomDialog;

public final /* synthetic */ class PictureSelectorActivity$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ PictureSelectorActivity f$0;
    public final /* synthetic */ PictureCustomDialog f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ PictureSelectorActivity$$ExternalSyntheticLambda2(PictureSelectorActivity pictureSelectorActivity, PictureCustomDialog pictureCustomDialog, boolean z) {
        this.f$0 = pictureSelectorActivity;
        this.f$1 = pictureCustomDialog;
        this.f$2 = z;
    }

    public final void onClick(View view) {
        this.f$0.lambda$showPermissionsDialog$6$PictureSelectorActivity(this.f$1, this.f$2, view);
    }
}
