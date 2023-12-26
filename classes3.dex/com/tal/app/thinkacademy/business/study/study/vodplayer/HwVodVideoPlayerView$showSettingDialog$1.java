package com.tal.app.thinkacademy.business.study.study.vodplayer;

import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.business.study.study.vodplayer.VideoSettingDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "type", "Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VideoSettingDialog$VideoSettingType;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwVodVideoPlayerView.kt */
final class HwVodVideoPlayerView$showSettingDialog$1 extends Lambda implements Function1<VideoSettingDialog.VideoSettingType, Unit> {
    final /* synthetic */ HwVodVideoPlayerView this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwVodVideoPlayerView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoSettingDialog.VideoSettingType.values().length];
            iArr[VideoSettingDialog.VideoSettingType.LINE_SWITCH.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HwVodVideoPlayerView$showSettingDialog$1(HwVodVideoPlayerView hwVodVideoPlayerView) {
        super(1);
        this.this$0 = hwVodVideoPlayerView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VideoSettingDialog.VideoSettingType) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(VideoSettingDialog.VideoSettingType videoSettingType) {
        Intrinsics.checkNotNullParameter(videoSettingType, ClassParamsKt.TYPE);
        if (WhenMappings.$EnumSwitchMapping$0[videoSettingType.ordinal()] == 1) {
            this.this$0.showSwitchLineDialog();
        }
    }
}
