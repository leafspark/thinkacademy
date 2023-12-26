package com.tal.app.thinkacademy.business.shop.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J0\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J0\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0002¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/widget/view/AutoLineFeedLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getDesiredHeight", "width", "layoutHorizontal", "", "onLayout", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setChildFrame", "child", "Landroid/view/View;", "left", "top", "height", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AutoLineFeedLayout.kt */
public final class AutoLineFeedLayout extends ViewGroup {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AutoLineFeedLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AutoLineFeedLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutoLineFeedLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoLineFeedLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            measureChild(getChildAt(i3), i, i2);
        }
        if (mode == Integer.MIN_VALUE || mode == 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getDesiredHeight(View.MeasureSpec.getSize(i)), 1073741824));
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layoutHorizontal();
    }

    private final int getDesiredHeight(int i) {
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childCount = getChildCount();
        int i2 = paddingLeft;
        int i3 = 0;
        int i4 = 0;
        while (i3 < childCount) {
            int i5 = i3 + 1;
            View childAt = getChildAt(i3);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i2 < measuredWidth) {
                paddingTop += i4;
                i2 = paddingLeft;
                i4 = 0;
            }
            i2 -= measuredWidth;
            i4 = RangesKt.coerceAtLeast(measuredHeight, i4);
            i3 = i5;
        }
        return paddingTop + i4;
    }

    private final void layoutHorizontal() {
        int childCount = getChildCount();
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int i = measuredWidth;
        int i2 = 0;
        int i3 = 0;
        while (i2 < childCount) {
            int i4 = i2 + 1;
            View childAt = getChildAt(i2);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                int measuredWidth2 = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i < measuredWidth2) {
                    paddingTop += i3;
                    paddingLeft = getPaddingLeft();
                    i = measuredWidth;
                    i3 = 0;
                }
                setChildFrame(childAt, paddingLeft, paddingTop, measuredWidth2, measuredHeight);
                paddingLeft += measuredWidth2;
                i -= measuredWidth2;
                i3 = RangesKt.coerceAtLeast(i3, measuredHeight);
            }
            i2 = i4;
        }
    }

    private final void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }
}
