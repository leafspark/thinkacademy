package com.tal.app.thinkacademy.live.business.allonstage.adapter;

import android.widget.ImageView;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePhoneAdapter.kt */
final class AllOnStagePhoneAdapter$convert$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ImageView $emojiBg;
    final /* synthetic */ EmojiView $emojiView;
    final /* synthetic */ StudentVideoBean.ListBean $item;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AllOnStagePhoneAdapter$convert$1(EmojiView emojiView, ImageView imageView, StudentVideoBean.ListBean listBean) {
        super(0);
        this.$emojiView = emojiView;
        this.$emojiBg = imageView;
        this.$item = listBean;
    }

    public final void invoke() {
        this.$emojiView.setVisibility(8);
        this.$emojiBg.setVisibility(8);
        this.$item.setShowEmoji(false);
    }
}
