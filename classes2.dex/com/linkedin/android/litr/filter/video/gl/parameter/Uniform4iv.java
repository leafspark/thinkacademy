package com.linkedin.android.litr.filter.video.gl.parameter;

import android.opengl.GLES20;
import java.nio.IntBuffer;

public class Uniform4iv extends ShaderParameter {
    private IntBuffer buffer;
    private int count;

    public Uniform4iv(String str, int i, int[] iArr) {
        this(str, i, IntBuffer.wrap(iArr));
    }

    public Uniform4iv(String str, int i, IntBuffer intBuffer) {
        super(0, str);
        this.count = i;
        this.buffer = intBuffer;
    }

    public void apply(int i) {
        GLES20.glUniform4iv(getLocation(i), this.count, this.buffer);
    }
}
