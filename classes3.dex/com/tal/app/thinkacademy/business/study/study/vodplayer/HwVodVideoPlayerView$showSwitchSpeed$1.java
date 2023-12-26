package com.tal.app.thinkacademy.business.study.study.vodplayer;

import com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.VodVideoPlayerViewBinding;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "index", "", "desc", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwVodVideoPlayerView.kt */
final class HwVodVideoPlayerView$showSwitchSpeed$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ HwVodVideoPlayerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HwVodVideoPlayerView$showSwitchSpeed$1(HwVodVideoPlayerView hwVodVideoPlayerView) {
        super(2);
        this.this$0 = hwVodVideoPlayerView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, String str) {
        float f;
        Intrinsics.checkNotNullParameter(str, "desc");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.this$0.getContext().getString(R.string.speed_switch_btn_str);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.speed_switch_btn_str)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        VodVideoPlayerViewBinding access$getBinding$p = this.this$0.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.switchSpeedBtn.setText(format);
        try {
            f = Float.parseFloat(str);
        } catch (Exception unused) {
            f = 1.0f;
        }
        HwVodVideoPlayerView.VodPlayerListen access$getMVodPlayerListen$p = this.this$0.mVodPlayerListen;
        if (access$getMVodPlayerListen$p != null) {
            access$getMVodPlayerListen$p.onSwitchSpeed(str);
        }
        this.this$0.mCurrentSpeed = f;
        IJKPlayer access$getMPlayer$p = this.this$0.mPlayer;
        if (access$getMPlayer$p != null) {
            access$getMPlayer$p.setSpeed(this.this$0.mCurrentSpeed);
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string2 = this.this$0.getContext().getString(R.string.speed_switch_success);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.speed_switch_success)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        ToastUtils.showLong(format2, new Object[0]);
    }
}
