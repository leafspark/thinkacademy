package com.linkedin.android.litr.render;

import android.opengl.GLES20;
import java.nio.Buffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B;\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/linkedin/android/litr/render/GlTexture;", "", "unit", "", "target", "id", "width", "height", "(IILjava/lang/Integer;II)V", "getHeight", "()I", "getTarget", "texName", "getTexName", "getUnit", "getWidth", "bind", "", "delete", "unbind", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GlTexture.kt */
public final class GlTexture {
    private final int height;
    private final int target;
    private final int texName;
    private final int unit;
    private final int width;

    public GlTexture() {
        this(0, 0, (Integer) null, 0, 0, 31, (DefaultConstructorMarker) null);
    }

    public GlTexture(int i) {
        this(i, 0, (Integer) null, 0, 0, 30, (DefaultConstructorMarker) null);
    }

    public GlTexture(int i, int i2) {
        this(i, i2, (Integer) null, 0, 0, 28, (DefaultConstructorMarker) null);
    }

    public GlTexture(int i, int i2, Integer num) {
        this(i, i2, num, 0, 0, 24, (DefaultConstructorMarker) null);
    }

    public GlTexture(int i, int i2, Integer num, int i3) {
        this(i, i2, num, i3, 0, 16, (DefaultConstructorMarker) null);
    }

    public GlTexture(int i, int i2, Integer num, int i3, int i4) {
        int i5;
        this.unit = i;
        this.target = i2;
        this.width = i3;
        this.height = i4;
        if (num == null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            i5 = iArr[0];
        } else {
            i5 = num.intValue();
        }
        this.texName = i5;
        GLES20.glBindTexture(i2, i5);
        GlRenderUtils.checkGlError("glBindTexture GlTexture");
        if (i3 > 0 && i4 > 0) {
            GLES20.glTexImage2D(3553, 0, 6408, i3, i4, 0, 6408, 5121, (Buffer) null);
            GlRenderUtils.checkGlError("glTexImage2D GlTexture");
        }
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GlRenderUtils.checkGlError("glTexParameter GlTexture");
        GLES20.glBindTexture(i2, 0);
    }

    public final int getUnit() {
        return this.unit;
    }

    public final int getTarget() {
        return this.target;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GlTexture(int r4, int r5, java.lang.Integer r6, int r7, int r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0007
            r4 = 33984(0x84c0, float:4.7622E-41)
        L_0x0007:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000d
            r5 = 3553(0xde1, float:4.979E-42)
        L_0x000d:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0016
            r5 = 0
            r6 = r5
            java.lang.Integer r6 = (java.lang.Integer) r6
        L_0x0016:
            r0 = r6
            r5 = r9 & 8
            r6 = 0
            if (r5 == 0) goto L_0x001e
            r1 = r6
            goto L_0x001f
        L_0x001e:
            r1 = r7
        L_0x001f:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0025
            r2 = r6
            goto L_0x0026
        L_0x0025:
            r2 = r8
        L_0x0026:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.linkedin.android.litr.render.GlTexture.<init>(int, int, java.lang.Integer, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getTexName() {
        return this.texName;
    }

    public final void bind() {
        GLES20.glActiveTexture(this.unit);
        GLES20.glBindTexture(this.target, this.texName);
        GlRenderUtils.checkGlError("glBindTexture GlTexture");
    }

    public final void unbind() {
        GLES20.glBindTexture(this.target, 0);
        GLES20.glActiveTexture(33984);
    }

    public final void delete() {
        GLES20.glDeleteTextures(1, new int[]{this.texName}, 0);
    }
}
