package com.tal.app.thinkacademy.live.business.allonstage;

import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiBean;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePluginViewPhone.kt */
final class AllOnStagePluginViewPhone$showEmojiView$1$1 extends Lambda implements Function1<EmojiBean<?>, Unit> {
    final /* synthetic */ AllOnStagePluginViewPhone this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AllOnStagePluginViewPhone$showEmojiView$1$1(AllOnStagePluginViewPhone allOnStagePluginViewPhone) {
        super(1);
        this.this$0 = allOnStagePluginViewPhone;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((EmojiBean<?>) (EmojiBean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(EmojiBean<?> emojiBean) {
        Intrinsics.checkNotNullParameter(emojiBean, "it");
        AllOnStageViewModel mViewModel = this.this$0.getMViewModel();
        if (mViewModel != null) {
            mViewModel.sendPhoneEmojiMsg(emojiBean);
        }
        HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
        String name = emojiBean.getName();
        Intrinsics.checkNotNullExpressionValue(name, "it.name");
        hWEventTracking.ostaCbSendMsg("group", "emoji", name);
        this.this$0.showEmoji(0, emojiBean);
    }
}
