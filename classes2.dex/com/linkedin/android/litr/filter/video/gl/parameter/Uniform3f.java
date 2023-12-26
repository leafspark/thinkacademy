package com.linkedin.android.litr.filter.video.gl.parameter;

import android.opengl.GLES20;

public class Uniform3f extends ShaderParameter {
    private float value1;
    private float value2;
    private float value3;

    public Uniform3f(String str, float f, float f2, float f3) {
        super(0, str);
        this.value1 = f;
        this.value2 = f2;
        this.value3 = f3;
    }

    public void apply(int i) {
        GLES20.glUniform3f(getLocation(i), this.value1, this.value2, this.value3);
    }
}
