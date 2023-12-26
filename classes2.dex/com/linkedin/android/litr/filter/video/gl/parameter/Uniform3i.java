package com.linkedin.android.litr.filter.video.gl.parameter;

import android.opengl.GLES20;

public class Uniform3i extends ShaderParameter {
    private int value1;
    private int value2;
    private int value3;

    public Uniform3i(String str, int i, int i2, int i3) {
        super(0, str);
        this.value1 = i;
        this.value2 = i2;
        this.value3 = i3;
    }

    public void apply(int i) {
        GLES20.glUniform3i(getLocation(i), this.value1, this.value2, this.value3);
    }
}
