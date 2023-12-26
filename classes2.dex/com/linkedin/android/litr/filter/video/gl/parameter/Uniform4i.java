package com.linkedin.android.litr.filter.video.gl.parameter;

import android.opengl.GLES20;

public class Uniform4i extends ShaderParameter {
    private int value1;
    private int value2;
    private int value3;
    private int value4;

    public Uniform4i(String str, int i, int i2, int i3, int i4) {
        super(0, str);
        this.value1 = i;
        this.value2 = i2;
        this.value3 = i3;
        this.value4 = i4;
    }

    public void apply(int i) {
        GLES20.glUniform4i(getLocation(i), this.value1, this.value2, this.value3, this.value4);
    }
}
