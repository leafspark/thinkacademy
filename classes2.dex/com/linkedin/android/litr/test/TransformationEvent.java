package com.linkedin.android.litr.test;

public class TransformationEvent {
    public static final int TYPE_CANCELLED = 4;
    public static final int TYPE_COMPLETED = 2;
    public static final int TYPE_ERROR = 3;
    public static final int TYPE_PROGRESS = 1;
    public static final int TYPE_START = 0;
    public final Throwable cause;
    public final String id;
    public final float progress;
    public final int type;

    public TransformationEvent(String str, int i, float f, Throwable th) {
        this.id = str;
        this.type = i;
        this.progress = f;
        this.cause = th;
    }
}
