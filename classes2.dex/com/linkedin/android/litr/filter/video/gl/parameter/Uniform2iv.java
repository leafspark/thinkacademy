package com.linkedin.android.litr.filter.video.gl.parameter;

import android.opengl.GLES20;
import java.nio.IntBuffer;

public class Uniform2iv extends ShaderParameter {
    private IntBuffer buffer;
    private int count;

    public Uniform2iv(String str, int i, int[] iArr) {
        this(str, i, IntBuffer.wrap(iArr));
    }

    public Uniform2iv(String str, int i, IntBuffer intBuffer) {
        super(0, str);
        this.count = i;
        this.buffer = intBuffer;
    }

    public void apply(int i) {
        GLES20.glUniform2iv(getLocation(i), this.count, this.buffer);
    }
}
