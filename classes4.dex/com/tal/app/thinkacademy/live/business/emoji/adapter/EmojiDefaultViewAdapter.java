package com.tal.app.thinkacademy.live.business.emoji.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiViewEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0014R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/emoji/adapter/EmojiDefaultViewAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiViewEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "list", "", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "setList", "convert", "", "holder", "item", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiDefaultViewAdapter.kt */
public final class EmojiDefaultViewAdapter extends BaseQuickAdapter<EmojiViewEntity, BaseViewHolder> {
    private List<EmojiViewEntity> list;

    public final List<EmojiViewEntity> getList() {
        return this.list;
    }

    public final void setList(List<EmojiViewEntity> list2) {
        this.list = list2;
    }

    public EmojiDefaultViewAdapter(List<EmojiViewEntity> list2) {
        super(R.layout.live_business_item_emoji_default, list2);
        this.list = list2;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, EmojiViewEntity emojiViewEntity) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(emojiViewEntity, "item");
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.ivEmoji);
        Integer resId = emojiViewEntity.getResId();
        imageView.setImageResource(resId == null ? R.drawable.live_business_icon_emoji_normal : resId.intValue());
    }
}
