package com.tal.app.thinkacademy.live.business.groupvideocall.view;

import android.widget.LinearLayout;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DDStudentVideoWindow.kt */
final class DDStudentVideoWindow$showFace$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DDStudentVideoWindow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DDStudentVideoWindow$showFace$1(DDStudentVideoWindow dDStudentVideoWindow) {
        super(0);
        this.this$0 = dDStudentVideoWindow;
    }

    public final void invoke() {
        EmojiView emojiView = this.this$0.mViewBinding.emojiView;
        if (emojiView != null) {
            emojiView.setVisibility(8);
        }
        LinearLayout linearLayout = this.this$0.mViewBinding.emojiViewBg;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }
}
