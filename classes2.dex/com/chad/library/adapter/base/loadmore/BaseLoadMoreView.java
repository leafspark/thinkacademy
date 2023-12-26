package com.chad.library.adapter.base.loadmore;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0014\u0010\u0013\u001a\u00020\u0004*\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016"}, d2 = {"Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "", "()V", "convert", "", "holder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "position", "", "loadMoreStatus", "Lcom/chad/library/adapter/base/loadmore/LoadMoreStatus;", "getLoadComplete", "Landroid/view/View;", "getLoadEndView", "getLoadFailView", "getLoadingView", "getRootView", "parent", "Landroid/view/ViewGroup;", "isVisible", "visible", "", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseLoadMoreView.kt */
public abstract class BaseLoadMoreView {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadMoreStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LoadMoreStatus.Complete.ordinal()] = 1;
            iArr[LoadMoreStatus.Loading.ordinal()] = 2;
            iArr[LoadMoreStatus.Fail.ordinal()] = 3;
            iArr[LoadMoreStatus.End.ordinal()] = 4;
        }
    }

    public abstract View getLoadComplete(BaseViewHolder baseViewHolder);

    public abstract View getLoadEndView(BaseViewHolder baseViewHolder);

    public abstract View getLoadFailView(BaseViewHolder baseViewHolder);

    public abstract View getLoadingView(BaseViewHolder baseViewHolder);

    public abstract View getRootView(ViewGroup viewGroup);

    public void convert(BaseViewHolder baseViewHolder, int i, LoadMoreStatus loadMoreStatus) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        Intrinsics.checkParameterIsNotNull(loadMoreStatus, "loadMoreStatus");
        int i2 = WhenMappings.$EnumSwitchMapping$0[loadMoreStatus.ordinal()];
        if (i2 == 1) {
            isVisible(getLoadingView(baseViewHolder), false);
            isVisible(getLoadComplete(baseViewHolder), true);
            isVisible(getLoadFailView(baseViewHolder), false);
            isVisible(getLoadEndView(baseViewHolder), false);
        } else if (i2 == 2) {
            isVisible(getLoadingView(baseViewHolder), true);
            isVisible(getLoadComplete(baseViewHolder), false);
            isVisible(getLoadFailView(baseViewHolder), false);
            isVisible(getLoadEndView(baseViewHolder), false);
        } else if (i2 == 3) {
            isVisible(getLoadingView(baseViewHolder), false);
            isVisible(getLoadComplete(baseViewHolder), false);
            isVisible(getLoadFailView(baseViewHolder), true);
            isVisible(getLoadEndView(baseViewHolder), false);
        } else if (i2 == 4) {
            isVisible(getLoadingView(baseViewHolder), false);
            isVisible(getLoadComplete(baseViewHolder), false);
            isVisible(getLoadFailView(baseViewHolder), false);
            isVisible(getLoadEndView(baseViewHolder), true);
        }
    }

    private final void isVisible(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }
}
