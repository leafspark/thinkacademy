package com.tal.app.thinkacademy.live.business.emoji.adapter;

import android.view.View;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiViewEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/emoji/adapter/EmojiPayViewAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiViewEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "list", "", "column", "", "lineCount", "(Ljava/util/List;II)V", "getColumn", "()I", "setColumn", "(I)V", "getLineCount", "setLineCount", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "convert", "", "holder", "item", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiPayViewAdapter.kt */
public final class EmojiPayViewAdapter extends BaseQuickAdapter<EmojiViewEntity, BaseViewHolder> {
    private int column;
    private int lineCount;
    private List<EmojiViewEntity> list;

    public final List<EmojiViewEntity> getList() {
        return this.list;
    }

    public final void setList(List<EmojiViewEntity> list2) {
        this.list = list2;
    }

    public final int getColumn() {
        return this.column;
    }

    public final void setColumn(int i) {
        this.column = i;
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final void setLineCount(int i) {
        this.lineCount = i;
    }

    public EmojiPayViewAdapter(List<EmojiViewEntity> list2, int i, int i2) {
        super(R.layout.live_business_item_emoji_pay, list2);
        this.list = list2;
        this.column = i;
        this.lineCount = i2;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, EmojiViewEntity emojiViewEntity) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(emojiViewEntity, "item");
        XesImageLoader.loadRoundCornerImage$default(XesImageLoader.INSTANCE, (ImageView) baseViewHolder.getView(R.id.ivEmoji), getContext(), emojiViewEntity.getEmojiPicture(), 0, 0, R.drawable.live_business_icon_emoji_placeholder, (RoundedCornersTransformation.CornerType) null, 40, (Object) null);
        View view = baseViewHolder.getView(R.id.rightDiv);
        View view2 = baseViewHolder.getView(R.id.bottomDiv);
        int itemPosition = getItemPosition(emojiViewEntity);
        if ((itemPosition + 1) % this.column == 0) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
        if (itemPosition >= this.column * (this.lineCount - 1)) {
            view2.setVisibility(8);
        } else {
            view2.setVisibility(0);
        }
    }
}
