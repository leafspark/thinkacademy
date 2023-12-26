package com.tal.app.thinkacademy.business.shop.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tal.app.thinkacademy.business.shop.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0007H\u0014J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/widget/view/StateTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hasDataAttr", "", "mHasDataState", "", "hasData", "onCreateDrawableState", "extraSpace", "setHasData", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StateTextView.kt */
public final class StateTextView extends AppCompatTextView {
    private final int[] hasDataAttr;
    private boolean mHasDataState;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StateTextView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StateTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StateTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StateTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.hasDataAttr = new int[]{R.attr.has_data};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StateTextView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr….styleable.StateTextView)");
        this.mHasDataState = obtainStyledAttributes.getBoolean(obtainStyledAttributes.getIndex(R.styleable.StateTextView_has_data), false);
        obtainStyledAttributes.recycle();
    }

    public final void setHasData(boolean z) {
        if (this.mHasDataState != z) {
            this.mHasDataState = z;
            refreshDrawableState();
        }
    }

    public final boolean hasData() {
        return this.mHasDataState;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        if (this.mHasDataState) {
            int[] onCreateDrawableState = StateTextView.super.onCreateDrawableState(i + 1);
            AppCompatTextView.mergeDrawableStates(onCreateDrawableState, this.hasDataAttr);
            Intrinsics.checkNotNullExpressionValue(onCreateDrawableState, "state");
            return onCreateDrawableState;
        }
        int[] onCreateDrawableState2 = StateTextView.super.onCreateDrawableState(i);
        Intrinsics.checkNotNullExpressionValue(onCreateDrawableState2, "super.onCreateDrawableState(extraSpace)");
        return onCreateDrawableState2;
    }
}
