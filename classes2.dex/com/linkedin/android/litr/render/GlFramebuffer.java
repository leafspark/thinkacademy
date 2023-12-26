package com.linkedin.android.litr.render;

import android.opengl.GLES20;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0007J\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/linkedin/android/litr/render/GlFramebuffer;", "", "()V", "id", "", "getId", "()I", "attachTexture", "", "textureId", "texTarget", "attachment", "level", "bind", "delete", "unbind", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GlFramebuffer.kt */
public final class GlFramebuffer {
    private final int id;

    public final void attachTexture(int i) {
        attachTexture$default(this, i, 0, 0, 0, 14, (Object) null);
    }

    public final void attachTexture(int i, int i2) {
        attachTexture$default(this, i, i2, 0, 0, 12, (Object) null);
    }

    public final void attachTexture(int i, int i2, int i3) {
        attachTexture$default(this, i, i2, i3, 0, 8, (Object) null);
    }

    public GlFramebuffer() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GlRenderUtils.checkGlError("glGenFramebuffers GlFramebuffer");
        this.id = iArr[0];
    }

    public final int getId() {
        return this.id;
    }

    public static /* synthetic */ void attachTexture$default(GlFramebuffer glFramebuffer, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 3553;
        }
        if ((i5 & 4) != 0) {
            i3 = 36064;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        glFramebuffer.attachTexture(i, i2, i3, i4);
    }

    public final void attachTexture(int i, int i2, int i3, int i4) {
        GLES20.glFramebufferTexture2D(36160, i3, i2, i, i4);
        GlRenderUtils.checkGlError("glFramebufferTexture2D GlFramebuffer");
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            throw new RuntimeException("Bad status glCheckFramebufferStatus: " + glCheckFramebufferStatus);
        }
    }

    public final void bind() {
        GLES20.glBindFramebuffer(36160, this.id);
    }

    public final void unbind() {
        GLES20.glBindFramebuffer(36160, 0);
    }

    public final void delete() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.id}, 0);
    }
}
