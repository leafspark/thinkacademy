package com.tal.app.thinkacademy.business.study.study.vodplayer;

import com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/tal/app/thinkacademy/business/study/study/vodplayer/HwCommonPlayerActivity$onCreate$1", "Lcom/tal/app/thinkacademy/business/study/study/vodplayer/HwVodVideoPlayerView$VodPlayerListen;", "isShowNextVideoButton", "", "onExit", "", "onSwitchSpeed", "speed", "", "onTakePhoto", "playComplete", "reportData", "minute", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwCommonPlayerActivity.kt */
public final class HwCommonPlayerActivity$onCreate$1 implements HwVodVideoPlayerView.VodPlayerListen {
    final /* synthetic */ HwCommonPlayerActivity this$0;

    public boolean isShowNextVideoButton() {
        return false;
    }

    public void onSwitchSpeed(String str) {
        Intrinsics.checkNotNullParameter(str, "speed");
    }

    public void onTakePhoto() {
    }

    public void reportData(int i) {
    }

    HwCommonPlayerActivity$onCreate$1(HwCommonPlayerActivity hwCommonPlayerActivity) {
        this.this$0 = hwCommonPlayerActivity;
    }

    public void onNextVideoButtonClick() {
        HwVodVideoPlayerView.VodPlayerListen.DefaultImpls.onNextVideoButtonClick(this);
    }

    public void onExit() {
        this.this$0.onExitPlayer();
    }

    public void playComplete() {
        this.this$0.saveStartPosition(true);
    }
}
