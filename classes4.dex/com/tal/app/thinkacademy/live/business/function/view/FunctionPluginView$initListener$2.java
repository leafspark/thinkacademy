package com.tal.app.thinkacademy.live.business.function.view;

import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver;
import com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FunctionPluginView.kt */
final class FunctionPluginView$initListener$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FunctionPluginView this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FunctionPluginView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FunctionPluginView.ButtonState.values().length];
            iArr[FunctionPluginView.ButtonState.NORMAL.ordinal()] = 1;
            iArr[FunctionPluginView.ButtonState.SELECTED.ordinal()] = 2;
            iArr[FunctionPluginView.ButtonState.DISABLE.ordinal()] = 3;
            iArr[FunctionPluginView.ButtonState.COOL_DOWN.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FunctionPluginView$initListener$2(FunctionPluginView functionPluginView) {
        super(0);
        this.this$0 = functionPluginView;
    }

    public final void invoke() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.this$0.mEmojiState.ordinal()];
        if (i == 1 || i == 2) {
            this.this$0.setEmojiState(FunctionPluginView.ButtonState.SELECTED);
            this.this$0.showEmojiPopupWindow();
            if (this.this$0.mBinding.liveBusinessFunctionVChatbox.isSelected()) {
                this.this$0.getDriver().switchChatBox(false);
                this.this$0.resetChatBoxStatus(false);
            }
        } else if (i == 3) {
            FunctionPluginDriver driver = this.this$0.getDriver();
            String string = this.this$0.getResources().getString(R.string.emoji_closed_tips);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.emoji_closed_tips)");
            FunctionPluginDriver.showTips$default(driver, string, this.this$0.getEmojiTop(), 0, 4, (Object) null);
        } else if (i == 4) {
            FunctionPluginView.EmojiHandler access$getEmojiHandler$p = this.this$0.emojiHandler;
            int progress = 3000 - (access$getEmojiHandler$p == null ? 0 : access$getEmojiHandler$p.getProgress());
            String string2 = this.this$0.getResources().getString(R.string.emoji_too_many_sends);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.emoji_too_many_sends)");
            long j = progress > 300 ? 3000 : ((long) progress) * 10;
            FunctionPluginDriver driver2 = this.this$0.getDriver();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(progress / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            driver2.showTips(format, this.this$0.getEmojiTop(), j);
        }
    }
}
