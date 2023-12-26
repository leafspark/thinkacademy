package com.tal.app.thinkacademy.live.business.emoji.adapter;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailPackage;

public final /* synthetic */ class EmojiPackageItemAdapter$$ExternalSyntheticLambda0 implements OnItemClickListener {
    public final /* synthetic */ EmojiDetailPackage f$0;
    public final /* synthetic */ EmojiPackageItemAdapter f$1;

    public /* synthetic */ EmojiPackageItemAdapter$$ExternalSyntheticLambda0(EmojiDetailPackage emojiDetailPackage, EmojiPackageItemAdapter emojiPackageItemAdapter) {
        this.f$0 = emojiDetailPackage;
        this.f$1 = emojiPackageItemAdapter;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        EmojiPackageItemAdapter.m219convert$lambda3$lambda2(this.f$0, this.f$1, baseQuickAdapter, view, i);
    }
}
