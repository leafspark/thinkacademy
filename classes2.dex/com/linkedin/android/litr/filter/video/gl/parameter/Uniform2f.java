package com.linkedin.android.litr.filter.video.gl.parameter;

import android.opengl.GLES20;

public class Uniform2f extends ShaderParameter {
    private float value1;
    private float value2;

    public Uniform2f(String str, float f, float f2) {
        super(0, str);
        this.value1 = f;
        this.value2 = f2;
    }

    public void apply(int i) {
        GLES20.glUniform2f(getLocation(i), this.value1, this.value2);
    }
}
