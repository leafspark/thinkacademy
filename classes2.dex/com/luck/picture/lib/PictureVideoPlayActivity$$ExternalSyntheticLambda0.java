package com.luck.picture.lib;

import android.media.MediaPlayer;

public final /* synthetic */ class PictureVideoPlayActivity$$ExternalSyntheticLambda0 implements MediaPlayer.OnInfoListener {
    public final /* synthetic */ PictureVideoPlayActivity f$0;

    public /* synthetic */ PictureVideoPlayActivity$$ExternalSyntheticLambda0(PictureVideoPlayActivity pictureVideoPlayActivity) {
        this.f$0 = pictureVideoPlayActivity;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        return this.f$0.lambda$onPrepared$0$PictureVideoPlayActivity(mediaPlayer, i, i2);
    }
}
