package com.linkedin.android.litr.filter;

public interface GlFilter {
    void apply(long j);

    void init();

    void release();

    void setVpMatrix(float[] fArr, int i);
}
