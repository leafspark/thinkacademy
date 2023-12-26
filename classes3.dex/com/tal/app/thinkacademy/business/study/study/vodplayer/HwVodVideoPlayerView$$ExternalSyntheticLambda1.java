package com.tal.app.thinkacademy.business.study.study.vodplayer;

import android.graphics.Bitmap;
import java.io.File;

public final /* synthetic */ class HwVodVideoPlayerView$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ File f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Bitmap f$2;
    public final /* synthetic */ HwVodVideoPlayerView f$3;
    public final /* synthetic */ String f$4;

    public /* synthetic */ HwVodVideoPlayerView$$ExternalSyntheticLambda1(File file, String str, Bitmap bitmap, HwVodVideoPlayerView hwVodVideoPlayerView, String str2) {
        this.f$0 = file;
        this.f$1 = str;
        this.f$2 = bitmap;
        this.f$3 = hwVodVideoPlayerView;
        this.f$4 = str2;
    }

    public final void run() {
        HwVodVideoPlayerView.m494takePhoto$lambda3$lambda2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
