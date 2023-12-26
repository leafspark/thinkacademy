package com.tal.app.thinkacademy.business.home.main.shop.view;

import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001,B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\tH\u0002J(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0002J\b\u0010&\u001a\u00020\u0018H\u0002J\u001e\u0010'\u001a\u00020\u00182\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*\u0018\u00010\rH\u0002J\u0018\u0010+\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/view/GridSectionAverageGapItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "gapHorizontalDp", "", "gapVerticalDp", "sectionEdgeHPaddingDp", "sectionEdgeVPaddingDp", "(FFFF)V", "eachItemHPaddingPx", "", "gapHSizePx", "gapVSizePx", "mAdapter", "Lcom/chad/library/adapter/base/BaseSectionQuickAdapter;", "mDataObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "mSectionList", "", "Lcom/tal/app/thinkacademy/business/home/main/shop/view/GridSectionAverageGapItemDecoration$Section;", "sectionEdgeHPaddingPx", "sectionEdgeVPaddingPx", "findSectionLastItemPos", "curPos", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "isLastRow", "", "visualPos", "spanCount", "sectionItemCount", "markSections", "setUpWithAdapter", "adapter", "Lcom/chad/library/adapter/base/entity/SectionEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "transformGapDefinition", "Section", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GridSectionAverageGapItemDecoration.kt */
public final class GridSectionAverageGapItemDecoration extends RecyclerView.ItemDecoration {
    private int eachItemHPaddingPx;
    private int gapHSizePx = -1;
    private float gapHorizontalDp;
    private int gapVSizePx = -1;
    private float gapVerticalDp;
    private BaseSectionQuickAdapter<?, ?> mAdapter;
    private final RecyclerView.AdapterDataObserver mDataObserver = new GridSectionAverageGapItemDecoration$mDataObserver$1(this);
    private final List<Section> mSectionList = new ArrayList();
    private float sectionEdgeHPaddingDp;
    private int sectionEdgeHPaddingPx;
    private float sectionEdgeVPaddingDp;
    private int sectionEdgeVPaddingPx;

    public GridSectionAverageGapItemDecoration(float f, float f2, float f3, float f4) {
        this.gapHorizontalDp = f;
        this.gapVerticalDp = f2;
        this.sectionEdgeHPaddingDp = f3;
        this.sectionEdgeVPaddingDp = f4;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/view/GridSectionAverageGapItemDecoration$Section;", "", "()V", "count", "", "getCount", "()I", "endPos", "getEndPos", "setEndPos", "(I)V", "startPos", "getStartPos", "setStartPos", "contains", "", "pos", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GridSectionAverageGapItemDecoration.kt */
    private static final class Section {
        private int endPos;
        private int startPos;

        public final int getStartPos() {
            return this.startPos;
        }

        public final void setStartPos(int i) {
            this.startPos = i;
        }

        public final int getEndPos() {
            return this.endPos;
        }

        public final void setEndPos(int i) {
            this.endPos = i;
        }

        public final int getCount() {
            return (this.endPos - this.startPos) + 1;
        }

        public final boolean contains(int i) {
            return i >= this.startPos && i <= this.endPos;
        }

        public String toString() {
            return "Section{startPos=" + this.startPos + ", endPos=" + this.endPos + '}';
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager) || recyclerView.getAdapter() == null || !(recyclerView.getAdapter() instanceof BaseSectionQuickAdapter)) {
            GridSectionAverageGapItemDecoration.super.getItemOffsets(rect, view, recyclerView, state);
            return;
        }
        GridLayoutManager layoutManager = recyclerView.getLayoutManager();
        BaseSectionQuickAdapter<?, ?> baseSectionQuickAdapter = (BaseSectionQuickAdapter) recyclerView.getAdapter();
        if (this.mAdapter != baseSectionQuickAdapter) {
            setUpWithAdapter(baseSectionQuickAdapter);
        }
        Intrinsics.checkNotNull(layoutManager);
        int spanCount = layoutManager.getSpanCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        BaseSectionQuickAdapter<?, ?> baseSectionQuickAdapter2 = this.mAdapter;
        Intrinsics.checkNotNull(baseSectionQuickAdapter2);
        int headerLayoutCount = childAdapterPosition - baseSectionQuickAdapter2.getHeaderLayoutCount();
        BaseSectionQuickAdapter<?, ?> baseSectionQuickAdapter3 = this.mAdapter;
        Intrinsics.checkNotNull(baseSectionQuickAdapter3);
        if (headerLayoutCount >= baseSectionQuickAdapter3.getData().size()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        Intrinsics.checkNotNull(baseSectionQuickAdapter);
        SectionEntity sectionEntity = (SectionEntity) baseSectionQuickAdapter.getItem(headerLayoutCount);
        if (sectionEntity == null || sectionEntity.isHeader()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        Section findSectionLastItemPos = findSectionLastItemPos(headerLayoutCount);
        if (findSectionLastItemPos != null) {
            if (this.gapHSizePx < 0 || this.gapVSizePx < 0) {
                transformGapDefinition(recyclerView, spanCount);
            }
            rect.top = this.gapVSizePx;
            rect.bottom = 0;
            int startPos = (headerLayoutCount + 1) - findSectionLastItemPos.getStartPos();
            int i = startPos % spanCount;
            if (i == 1) {
                rect.left = this.sectionEdgeHPaddingPx;
                rect.right = this.eachItemHPaddingPx - this.sectionEdgeHPaddingPx;
            } else if (i == 0) {
                rect.left = this.eachItemHPaddingPx - this.sectionEdgeHPaddingPx;
                rect.right = this.sectionEdgeHPaddingPx;
            } else {
                rect.left = this.gapHSizePx - (this.eachItemHPaddingPx - this.sectionEdgeHPaddingPx);
                rect.right = this.eachItemHPaddingPx - rect.left;
            }
            if (startPos - spanCount <= 0) {
                rect.top = this.sectionEdgeVPaddingPx;
            }
            if (isLastRow(startPos, spanCount, findSectionLastItemPos.getCount())) {
                rect.bottom = this.sectionEdgeVPaddingPx;
            }
        }
    }

    private final void setUpWithAdapter(BaseSectionQuickAdapter<SectionEntity, BaseViewHolder> baseSectionQuickAdapter) {
        BaseSectionQuickAdapter<?, ?> baseSectionQuickAdapter2 = this.mAdapter;
        if (baseSectionQuickAdapter2 != null) {
            baseSectionQuickAdapter2.unregisterAdapterDataObserver(this.mDataObserver);
        }
        this.mAdapter = baseSectionQuickAdapter;
        if (baseSectionQuickAdapter != null) {
            baseSectionQuickAdapter.registerAdapterDataObserver(this.mDataObserver);
        }
        markSections();
    }

    /* access modifiers changed from: private */
    public final void markSections() {
        BaseSectionQuickAdapter<?, ?> baseSectionQuickAdapter = this.mAdapter;
        if (baseSectionQuickAdapter != null && baseSectionQuickAdapter != null) {
            Objects.requireNonNull(baseSectionQuickAdapter, "null cannot be cast to non-null type com.chad.library.adapter.base.BaseSectionQuickAdapter<com.chad.library.adapter.base.entity.SectionEntity, com.chad.library.adapter.base.viewholder.BaseViewHolder>");
            this.mSectionList.clear();
            Section section = new Section();
            int itemCount = baseSectionQuickAdapter.getItemCount() - baseSectionQuickAdapter.getFooterLayoutCount();
            for (int i = 0; i < itemCount; i++) {
                SectionEntity sectionEntity = (SectionEntity) baseSectionQuickAdapter.getItem(i);
                if (sectionEntity == null || !sectionEntity.isHeader()) {
                    section.setEndPos(i);
                } else {
                    if (i != 0) {
                        section.setEndPos(i - 1);
                        this.mSectionList.add(section);
                    }
                    section = new Section();
                    section.setStartPos(i + 1);
                }
            }
            if (!this.mSectionList.contains(section)) {
                this.mSectionList.add(section);
            }
        }
    }

    private final void transformGapDefinition(RecyclerView recyclerView, int i) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            recyclerView.getDisplay().getMetrics(displayMetrics);
        }
        this.gapHSizePx = (int) TypedValue.applyDimension(1, this.gapHorizontalDp, displayMetrics);
        this.gapVSizePx = (int) TypedValue.applyDimension(1, this.gapVerticalDp, displayMetrics);
        this.sectionEdgeHPaddingPx = (int) TypedValue.applyDimension(1, this.sectionEdgeHPaddingDp, displayMetrics);
        this.sectionEdgeVPaddingPx = (int) TypedValue.applyDimension(1, this.sectionEdgeVPaddingDp, displayMetrics);
        this.eachItemHPaddingPx = ((this.sectionEdgeHPaddingPx * 2) + (this.gapHSizePx * (i - 1))) / i;
    }

    private final Section findSectionLastItemPos(int i) {
        for (Section next : this.mSectionList) {
            if (next.contains(i)) {
                return next;
            }
        }
        return null;
    }

    private final boolean isLastRow(int i, int i2, int i3) {
        int i4 = i3 % i2;
        if (i4 != 0) {
            i2 = i4;
        }
        return i > i3 - i2;
    }
}
