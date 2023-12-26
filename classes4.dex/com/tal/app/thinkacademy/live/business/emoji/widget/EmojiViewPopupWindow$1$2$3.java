package com.tal.app.thinkacademy.live.business.emoji.widget;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/live/business/emoji/widget/EmojiViewPopupWindow$1$2$3", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiViewPopupWindow.kt */
public final class EmojiViewPopupWindow$1$2$3 extends RecyclerView.OnScrollListener {
    final /* synthetic */ EmojiViewPopupWindow this$0;

    EmojiViewPopupWindow$1$2$3(EmojiViewPopupWindow emojiViewPopupWindow) {
        this.this$0 = emojiViewPopupWindow;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        EmojiViewPopupWindow$1$2$3.super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            LinearLayoutManager access$getMEmojiPackageItemLayoutManager$p = this.this$0.mEmojiPackageItemLayoutManager;
            int findFirstVisibleItemPosition = access$getMEmojiPackageItemLayoutManager$p == null ? 0 : access$getMEmojiPackageItemLayoutManager$p.findFirstVisibleItemPosition();
            LinearLayoutManager access$getMEmojiPackageListLayoutManager$p = this.this$0.mEmojiPackageListLayoutManager;
            if (access$getMEmojiPackageListLayoutManager$p != null) {
                access$getMEmojiPackageListLayoutManager$p.scrollToPositionWithOffset(findFirstVisibleItemPosition, 0);
            }
            EmojiViewPopupWindow emojiViewPopupWindow = this.this$0;
            ArrayList list = emojiViewPopupWindow.getBean().getList();
            Intrinsics.checkNotNull(list);
            emojiViewPopupWindow.updateEmojiPackageSelected(list, findFirstVisibleItemPosition);
        }
    }
}
