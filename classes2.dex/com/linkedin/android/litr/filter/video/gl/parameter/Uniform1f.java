package com.linkedin.android.litr.filter.video.gl.parameter;

import android.opengl.GLES20;

public class Uniform1f extends ShaderParameter {
    private float value;

    public Uniform1f(String str, float f) {
        super(0, str);
        this.value = f;
    }

    public void apply(int i) {
        GLES20.glUniform1f(getLocation(i), this.value);
    }
}
