package com.wushuangtech.expansion.bean;

import com.yalantis.ucrop.view.CropImageView;
import java.io.Serializable;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLContext;

public class OmniVideoFrame implements Serializable {
    public static final int FORMAT_ABGR = 5;
    public static final int FORMAT_I420 = 1;
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
    public String mDevId;
    public int rotation = 0;
    public int stride = 0;
    public boolean syncMode = false;
    public int textureID = 0;
    public long timeStamp;
    public float[] transform = {1.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, -1.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, -1.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f};

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OmniVideoFrame{format=");
        sb.append(this.format);
        sb.append(", stride=");
        sb.append(this.stride);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", eglContext11=");
        sb.append(this.eglContext11);
        sb.append(", eglContext14=");
        sb.append(this.eglContext14);
        sb.append(", textureID=");
        sb.append(this.textureID);
        sb.append(", syncMode=");
        sb.append(this.syncMode);
        sb.append(", transform=");
        sb.append(Arrays.toString(this.transform));
        sb.append(", buf=");
        byte[] bArr = this.buf;
        sb.append(bArr == null ? "null" : Integer.valueOf(bArr.length));
        sb.append(", cropLeft=");
        sb.append(this.cropLeft);
        sb.append(", cropTop=");
        sb.append(this.cropTop);
        sb.append(", cropRight=");
        sb.append(this.cropRight);
        sb.append(", cropBottom=");
        sb.append(this.cropBottom);
        sb.append(", rotation=");
        sb.append(this.rotation);
        sb.append('}');
        return sb.toString();
    }
}
