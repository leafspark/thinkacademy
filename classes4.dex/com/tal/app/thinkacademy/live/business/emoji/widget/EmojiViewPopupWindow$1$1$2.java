package com.tal.app.thinkacademy.live.business.emoji.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/tal/app/thinkacademy/live/business/emoji/widget/EmojiViewPopupWindow$1$1$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiViewPopupWindow.kt */
public final class EmojiViewPopupWindow$1$1$2 extends RecyclerView.ItemDecoration {
    final /* synthetic */ EmojiViewPopupWindow this$0;

    EmojiViewPopupWindow$1$1$2(EmojiViewPopupWindow emojiViewPopupWindow) {
        this.this$0 = emojiViewPopupWindow;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        EmojiViewPopupWindow$1$1$2.super.getItemOffsets(rect, view, recyclerView, state);
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (childLayoutPosition == 0) {
            rect.right = SizeUtils.dp2px(3.0f);
            return;
        }
        ArrayList list = this.this$0.getBean().getList();
        boolean z = false;
        if (list != null && childLayoutPosition == list.size() - 1) {
            z = true;
        }
        if (z) {
            rect.left = SizeUtils.dp2px(3.0f);
            return;
        }
        rect.left = SizeUtils.dp2px(3.0f);
        rect.right = SizeUtils.dp2px(3.0f);
    }
}
