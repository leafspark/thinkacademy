package com.linkedin.android.litr.filter.video.gl.parameter;

import android.opengl.GLES20;

public class Uniform1i extends ShaderParameter {
    private int value;

    public Uniform1i(String str, int i) {
        super(0, str);
        this.value = i;
    }

    public void apply(int i) {
        GLES20.glUniform1i(getLocation(i), this.value);
    }
}
