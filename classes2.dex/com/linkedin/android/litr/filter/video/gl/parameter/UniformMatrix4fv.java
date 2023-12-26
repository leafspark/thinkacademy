package com.linkedin.android.litr.filter.video.gl.parameter;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class UniformMatrix4fv extends ShaderParameter {
    private FloatBuffer buffer;
    private int count;
    private float[] matrix;
    private int offset;
    private boolean transpose;

    public UniformMatrix4fv(String str, int i, boolean z, float[] fArr, int i2) {
        super(0, str);
        this.count = i;
        this.transpose = z;
        this.matrix = fArr;
        this.offset = i2;
    }

    public UniformMatrix4fv(String str, int i, boolean z, FloatBuffer floatBuffer) {
        super(0, str);
        this.count = i;
        this.transpose = z;
        this.buffer = floatBuffer;
    }

    public void apply(int i) {
        if (this.buffer != null) {
            GLES20.glUniformMatrix4fv(getLocation(i), this.count, this.transpose, this.buffer);
        } else {
            GLES20.glUniformMatrix4fv(getLocation(i), this.count, this.transpose, this.matrix, this.offset);
        }
    }
}
