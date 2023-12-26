package com.linkedin.android.litr.filter.video.gl.parameter;

import android.opengl.GLES20;

public class Uniform2i extends ShaderParameter {
    private int value1;
    private int value2;

    public Uniform2i(String str, int i, int i2) {
        super(0, str);
        this.value1 = i;
        this.value2 = i2;
    }

    public void apply(int i) {
        GLES20.glUniform2i(getLocation(i), this.value1, this.value2);
    }
}
