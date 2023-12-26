package io.agora.rtc.video;

import javax.microedition.khronos.egl.EGLContext;

public class AgoraVideoFrame {
    public static final int BUFFER_TYPE_ARRAY = 2;
    public static final int BUFFER_TYPE_BUFFER = 1;
    public static final int BUFFER_TYPE_NONE = -1;
    public static final int BUFFER_TYPE_TEXTURE = 3;
    public static final int FORMAT_ARGB = 7;
    public static final int FORMAT_BGRA = 2;
    public static final int FORMAT_I420 = 1;
    public static final int FORMAT_I422 = 16;
    public static final int FORMAT_IMC2 = 5;
    public static final int FORMAT_NONE = -1;
    public static final int FORMAT_NV12 = 8;
    public static final int FORMAT_NV21 = 3;
    public static final int FORMAT_RGBA = 4;
    public static final int FORMAT_TEXTURE_2D = 10;
    public static final int FORMAT_TEXTURE_OES = 11;
    public byte[] buf = null;
    public int cropBottom = 0;
    public int cropLeft = 0;
    public int cropRight = 0;
    public int cropTop = 0;
    public EGLContext eglContext11 = null;
    public android.opengl.EGLContext eglContext14 = null;
    public int format = 10;
    public int height = 0;
    public int rotation = 0;
    public int stride = 0;
    public boolean syncMode = true;
    public int textureID = 0;
    public long timeStamp = 0;
    public float[] transform = null;
}
