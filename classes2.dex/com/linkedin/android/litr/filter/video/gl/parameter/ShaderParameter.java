package com.linkedin.android.litr.filter.video.gl.parameter;

import android.opengl.GLES20;

public abstract class ShaderParameter {
    public static final int TYPE_ATTRIBUTE = 1;
    public static final int TYPE_UNIFORM = 0;
    public String name;
    public int type;

    public abstract void apply(int i);

    protected ShaderParameter(int i, String str) {
        this.type = i;
        this.name = str;
    }

    /* access modifiers changed from: protected */
    public int getLocation(int i) {
        int i2 = this.type;
        if (i2 == 0) {
            return GLES20.glGetUniformLocation(i, this.name);
        }
        if (i2 != 1) {
            return -1;
        }
        return GLES20.glGetAttribLocation(i, this.name);
    }
}
