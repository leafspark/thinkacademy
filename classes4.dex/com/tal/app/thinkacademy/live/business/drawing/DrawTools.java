package com.tal.app.thinkacademy.live.business.drawing;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/drawing/DrawTools;", "", "penStyle", "", "strokeColor", "", "(ILjava/lang/String;)V", "getPenStyle", "()I", "getStrokeColor", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DrawTools.kt */
public final class DrawTools {
    private final int penStyle;
    private final String strokeColor;

    public static /* synthetic */ DrawTools copy$default(DrawTools drawTools, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = drawTools.penStyle;
        }
        if ((i2 & 2) != 0) {
            str = drawTools.strokeColor;
        }
        return drawTools.copy(i, str);
    }

    public final int component1() {
        return this.penStyle;
    }

    public final String component2() {
        return this.strokeColor;
    }

    public final DrawTools copy(int i, String str) {
        return new DrawTools(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawTools)) {
            return false;
        }
        DrawTools drawTools = (DrawTools) obj;
        return this.penStyle == drawTools.penStyle && Intrinsics.areEqual(this.strokeColor, drawTools.strokeColor);
    }

    public int hashCode() {
        int i = this.penStyle * 31;
        String str = this.strokeColor;
        return i + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DrawTools(penStyle=" + this.penStyle + ", strokeColor=" + this.strokeColor + ')';
    }

    public DrawTools(int i, String str) {
        this.penStyle = i;
        this.strokeColor = str;
    }

    public final int getPenStyle() {
        return this.penStyle;
    }

    public final String getStrokeColor() {
        return this.strokeColor;
    }
}
