package com.luck.picture.lib;

import android.content.DialogInterface;

public final /* synthetic */ class PictureSelectorActivity$$ExternalSyntheticLambda0 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ PictureSelectorActivity f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ PictureSelectorActivity$$ExternalSyntheticLambda0(PictureSelectorActivity pictureSelectorActivity, String str) {
        this.f$0 = pictureSelectorActivity;
        this.f$1 = str;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f$0.lambda$startPlayAudioDialog$4$PictureSelectorActivity(this.f$1, dialogInterface);
    }
}
