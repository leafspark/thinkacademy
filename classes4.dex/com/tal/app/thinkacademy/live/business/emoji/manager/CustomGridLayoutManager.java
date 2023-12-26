package com.tal.app.thinkacademy.live.business.emoji.manager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eR\u001a\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/emoji/manager/CustomGridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "orientation", "reverseLayout", "", "(Landroid/content/Context;IIZ)V", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "canScrollHorizontally", "canScrollVertically", "", "flag", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomGridLayoutManager.kt */
public final class CustomGridLayoutManager extends GridLayoutManager {
    private boolean isScrollEnabled = true;

    public final boolean isScrollEnabled() {
        return this.isScrollEnabled;
    }

    public final void setScrollEnabled(boolean z) {
        this.isScrollEnabled = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomGridLayoutManager(Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomGridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i, i2, z);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void isScrollEnabled(boolean z) {
        this.isScrollEnabled = z;
    }

    public boolean canScrollHorizontally() {
        return this.isScrollEnabled && CustomGridLayoutManager.super.canScrollHorizontally();
    }

    public boolean canScrollVertically() {
        return this.isScrollEnabled && CustomGridLayoutManager.super.canScrollVertically();
    }
}
