package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001b¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/ScreenInfo;", "", "orientation", "", "width", "height", "xdpi", "", "ydpi", "inch", "", "(IIIFFD)V", "getHeight", "()I", "setHeight", "(I)V", "getInch", "()D", "setInch", "(D)V", "getOrientation", "setOrientation", "getWidth", "setWidth", "getXdpi", "()F", "setXdpi", "(F)V", "getYdpi", "setYdpi", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenInfo.kt */
public final class ScreenInfo {
    private int height;
    private double inch;
    private int orientation;
    private int width;
    private float xdpi;
    private float ydpi;

    public ScreenInfo() {
        this(0, 0, 0, 0.0f, 0.0f, 0.0d, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ScreenInfo copy$default(ScreenInfo screenInfo, int i, int i2, int i3, float f, float f2, double d, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = screenInfo.orientation;
        }
        if ((i4 & 2) != 0) {
            i2 = screenInfo.width;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = screenInfo.height;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            f = screenInfo.xdpi;
        }
        float f3 = f;
        if ((i4 & 16) != 0) {
            f2 = screenInfo.ydpi;
        }
        float f4 = f2;
        if ((i4 & 32) != 0) {
            d = screenInfo.inch;
        }
        return screenInfo.copy(i, i5, i6, f3, f4, d);
    }

    public final int component1() {
        return this.orientation;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final float component4() {
        return this.xdpi;
    }

    public final float component5() {
        return this.ydpi;
    }

    public final double component6() {
        return this.inch;
    }

    public final ScreenInfo copy(int i, int i2, int i3, float f, float f2, double d) {
        return new ScreenInfo(i, i2, i3, f, f2, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScreenInfo)) {
            return false;
        }
        ScreenInfo screenInfo = (ScreenInfo) obj;
        return this.orientation == screenInfo.orientation && this.width == screenInfo.width && this.height == screenInfo.height && Intrinsics.areEqual(Float.valueOf(this.xdpi), Float.valueOf(screenInfo.xdpi)) && Intrinsics.areEqual(Float.valueOf(this.ydpi), Float.valueOf(screenInfo.ydpi)) && Intrinsics.areEqual(Double.valueOf(this.inch), Double.valueOf(screenInfo.inch));
    }

    public int hashCode() {
        return (((((((((this.orientation * 31) + this.width) * 31) + this.height) * 31) + Float.floatToIntBits(this.xdpi)) * 31) + Float.floatToIntBits(this.ydpi)) * 31) + Double.doubleToLongBits(this.inch);
    }

    public String toString() {
        return "ScreenInfo(orientation=" + this.orientation + ", width=" + this.width + ", height=" + this.height + ", xdpi=" + this.xdpi + ", ydpi=" + this.ydpi + ", inch=" + this.inch + ')';
    }

    public ScreenInfo(int i, int i2, int i3, float f, float f2, double d) {
        this.orientation = i;
        this.width = i2;
        this.height = i3;
        this.xdpi = f;
        this.ydpi = f2;
        this.inch = d;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ScreenInfo(int r5, int r6, int r7, float r8, float r9, double r10, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r4 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r5
        L_0x0008:
            r5 = r12 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r12 & 4
            if (r5 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = r7
        L_0x0015:
            r5 = r12 & 8
            r6 = 0
            if (r5 == 0) goto L_0x001c
            r2 = r6
            goto L_0x001d
        L_0x001c:
            r2 = r8
        L_0x001d:
            r5 = r12 & 16
            if (r5 == 0) goto L_0x0023
            r3 = r6
            goto L_0x0024
        L_0x0023:
            r3 = r9
        L_0x0024:
            r5 = r12 & 32
            if (r5 == 0) goto L_0x002a
            r10 = 0
        L_0x002a:
            r11 = r10
            r5 = r4
            r6 = r13
            r7 = r1
            r8 = r0
            r9 = r2
            r10 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.entity.ScreenInfo.<init>(int, int, int, float, float, double, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(int i) {
        this.orientation = i;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final float getXdpi() {
        return this.xdpi;
    }

    public final void setXdpi(float f) {
        this.xdpi = f;
    }

    public final float getYdpi() {
        return this.ydpi;
    }

    public final void setYdpi(float f) {
        this.ydpi = f;
    }

    public final double getInch() {
        return this.inch;
    }

    public final void setInch(double d) {
        this.inch = d;
    }
}
