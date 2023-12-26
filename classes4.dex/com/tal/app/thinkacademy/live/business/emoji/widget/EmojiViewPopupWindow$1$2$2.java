package com.tal.app.thinkacademy.live.business.emoji.widget;

import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiAssembleBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "bean", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiAssembleBean;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiViewPopupWindow.kt */
final class EmojiViewPopupWindow$1$2$2 extends Lambda implements Function1<EmojiAssembleBean, Unit> {
    final /* synthetic */ EmojiViewPopupWindow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EmojiViewPopupWindow$1$2$2(EmojiViewPopupWindow emojiViewPopupWindow) {
        super(1);
        this.this$0 = emojiViewPopupWindow;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((EmojiAssembleBean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(EmojiAssembleBean emojiAssembleBean) {
        Intrinsics.checkNotNullParameter(emojiAssembleBean, "bean");
        Function1<EmojiAssembleBean, Unit> onEmojiSelected = this.this$0.getOnEmojiSelected();
        if (onEmojiSelected != null) {
            onEmojiSelected.invoke(emojiAssembleBean);
        }
        this.this$0.dismiss();
    }
}
