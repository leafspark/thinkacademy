package com.tal.app.thinkacademy.business.login.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tal.app.thinkacademy.business.login.view.item.MyPageRecyclerItem;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/tal/app/thinkacademy/business/login/view/MePageFragment$setRecyclerView$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MePageFragment.kt */
public final class MePageFragment$setRecyclerView$2 extends RecyclerView.ItemDecoration {
    final /* synthetic */ MePageFragment this$0;

    MePageFragment$setRecyclerView$2(MePageFragment mePageFragment) {
        this.this$0 = mePageFragment;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        MePageFragment$setRecyclerView$2.super.getItemOffsets(rect, view, recyclerView, state);
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (childLayoutPosition > 0 && this.this$0.mList.size() > childLayoutPosition && ((MyPageRecyclerItem) this.this$0.mList.get(childLayoutPosition)).getLocal_item_divider()) {
            rect.top = SizeUtils.dp2px(16.0f);
        }
    }
}
