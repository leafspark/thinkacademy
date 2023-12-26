package com.tal.app.thinkacademy.live.business.homework.entity;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEmpty;", "", "anchor", "Landroid/view/View;", "offsetX", "", "offsetY", "gravity", "source", "Lcom/tal/app/thinkacademy/live/business/homework/entity/EmptySource;", "(Landroid/view/View;IIILcom/tal/app/thinkacademy/live/business/homework/entity/EmptySource;)V", "getAnchor", "()Landroid/view/View;", "getGravity", "()I", "getOffsetX", "getOffsetY", "getSource", "()Lcom/tal/app/thinkacademy/live/business/homework/entity/EmptySource;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeworkDetailMsg.kt */
public final class HomeworkEmpty {
    private final View anchor;
    private final int gravity;
    private final int offsetX;
    private final int offsetY;
    private final EmptySource source;

    public static /* synthetic */ HomeworkEmpty copy$default(HomeworkEmpty homeworkEmpty, View view, int i, int i2, int i3, EmptySource emptySource, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            view = homeworkEmpty.anchor;
        }
        if ((i4 & 2) != 0) {
            i = homeworkEmpty.offsetX;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = homeworkEmpty.offsetY;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            i3 = homeworkEmpty.gravity;
        }
        int i7 = i3;
        if ((i4 & 16) != 0) {
            emptySource = homeworkEmpty.source;
        }
        return homeworkEmpty.copy(view, i5, i6, i7, emptySource);
    }

    public final View component1() {
        return this.anchor;
    }

    public final int component2() {
        return this.offsetX;
    }

    public final int component3() {
        return this.offsetY;
    }

    public final int component4() {
        return this.gravity;
    }

    public final EmptySource component5() {
        return this.source;
    }

    public final HomeworkEmpty copy(View view, int i, int i2, int i3, EmptySource emptySource) {
        Intrinsics.checkNotNullParameter(view, "anchor");
        Intrinsics.checkNotNullParameter(emptySource, "source");
        return new HomeworkEmpty(view, i, i2, i3, emptySource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeworkEmpty)) {
            return false;
        }
        HomeworkEmpty homeworkEmpty = (HomeworkEmpty) obj;
        return Intrinsics.areEqual(this.anchor, homeworkEmpty.anchor) && this.offsetX == homeworkEmpty.offsetX && this.offsetY == homeworkEmpty.offsetY && this.gravity == homeworkEmpty.gravity && this.source == homeworkEmpty.source;
    }

    public int hashCode() {
        return (((((((this.anchor.hashCode() * 31) + this.offsetX) * 31) + this.offsetY) * 31) + this.gravity) * 31) + this.source.hashCode();
    }

    public String toString() {
        return "HomeworkEmpty(anchor=" + this.anchor + ", offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ", gravity=" + this.gravity + ", source=" + this.source + ')';
    }

    public HomeworkEmpty(View view, int i, int i2, int i3, EmptySource emptySource) {
        Intrinsics.checkNotNullParameter(view, "anchor");
        Intrinsics.checkNotNullParameter(emptySource, "source");
        this.anchor = view;
        this.offsetX = i;
        this.offsetY = i2;
        this.gravity = i3;
        this.source = emptySource;
    }

    public final View getAnchor() {
        return this.anchor;
    }

    public final int getOffsetX() {
        return this.offsetX;
    }

    public final int getOffsetY() {
        return this.offsetY;
    }

    public final int getGravity() {
        return this.gravity;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeworkEmpty(View view, int i, int i2, int i3, EmptySource emptySource, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, i, i2, i3, (i4 & 16) != 0 ? EmptySource.FUN : emptySource);
    }

    public final EmptySource getSource() {
        return this.source;
    }
}
