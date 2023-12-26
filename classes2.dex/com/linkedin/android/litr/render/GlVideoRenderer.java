package com.linkedin.android.litr.render;

import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.view.Surface;
import com.linkedin.android.litr.codec.Frame;
import com.linkedin.android.litr.filter.GlFilter;
import com.linkedin.android.litr.filter.GlFrameRenderFilter;
import com.linkedin.android.litr.filter.video.gl.DefaultVideoFrameRenderFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GlVideoRenderer implements Renderer {
    protected static final String KEY_ROTATION = "rotation-degrees";
    private List<GlFilter> filters = new ArrayList();
    private final boolean hasFilters;
    private VideoRenderInputSurface inputSurface;
    private boolean inputSurfaceTextureInitialized;
    private float[] mvpMatrix = new float[16];
    private VideoRenderOutputSurface outputSurface;

    public void onMediaFormatChanged(MediaFormat mediaFormat, MediaFormat mediaFormat2) {
    }

    static {
        int i = Build.VERSION.SDK_INT;
    }

    public GlVideoRenderer(List<GlFilter> list) {
        boolean z = true;
        this.hasFilters = list != null && !list.isEmpty();
        if (list == null) {
            this.filters.add(new DefaultVideoFrameRenderFilter());
            return;
        }
        Iterator<GlFilter> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next() instanceof GlFrameRenderFilter) {
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            this.filters.add(new DefaultVideoFrameRenderFilter());
        }
        this.filters.addAll(list);
    }

    public void init(Surface surface, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        int i;
        if (surface == null) {
            throw new IllegalArgumentException("GlVideoRenderer requires an output surface");
        } else if (mediaFormat2 != null) {
            String str = KEY_ROTATION;
            if (mediaFormat2.containsKey(str)) {
                i = mediaFormat2.getInteger(str);
            } else {
                i = (mediaFormat == null || !mediaFormat.containsKey(str)) ? 0 : mediaFormat.getInteger(str);
            }
            float f = 1.0f;
            if (mediaFormat2.containsKey("width") && mediaFormat2.containsKey("height")) {
                f = ((float) mediaFormat2.getInteger("width")) / ((float) mediaFormat2.getInteger("height"));
            }
            this.outputSurface = new VideoRenderOutputSurface(surface);
            this.inputSurface = new VideoRenderInputSurface();
            initMvpMatrix(i, f);
            for (GlFilter next : this.filters) {
                next.init();
                float[] fArr = this.mvpMatrix;
                next.setVpMatrix(Arrays.copyOf(fArr, fArr.length), 0);
            }
        } else {
            throw new IllegalArgumentException("GlVideoRenderer requires target media format");
        }
    }

    public Surface getInputSurface() {
        VideoRenderInputSurface videoRenderInputSurface = this.inputSurface;
        if (videoRenderInputSurface != null) {
            return videoRenderInputSurface.getSurface();
        }
        return null;
    }

    public void renderFrame(Frame frame, long j) {
        this.inputSurface.awaitNewImage();
        drawFrame(j);
        this.outputSurface.setPresentationTime(j);
        this.outputSurface.swapBuffers();
    }

    public void release() {
        for (GlFilter release : this.filters) {
            release.release();
        }
        this.inputSurface.release();
        this.outputSurface.release();
    }

    public boolean hasFilters() {
        return this.hasFilters;
    }

    private void drawFrame(long j) {
        initInputSurfaceTexture();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        for (GlFilter apply : this.filters) {
            apply.apply(j);
        }
        GLES20.glFinish();
    }

    private void initMvpMatrix(int i, float f) {
        float f2;
        float f3;
        int i2 = i;
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        float f4 = f;
        Matrix.orthoM(fArr, 0, -f4, f4, -1.0f, 1.0f, -1.0f, 1.0f);
        float[] fArr2 = new float[16];
        Matrix.setIdentityM(fArr2, 0);
        if (i2 != 0) {
            if (i2 == 90) {
                f3 = 1.0f;
            } else if (i2 == 180) {
                f2 = -1.0f;
            } else if (i2 != 270) {
                double d = ((double) (i2 / 180)) * 3.141592653589793d;
                f2 = (float) Math.cos(d);
                f3 = (float) Math.sin(d);
                Matrix.setLookAtM(fArr2, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, f3, f2, 0.0f);
                Matrix.setIdentityM(this.mvpMatrix, 0);
                Matrix.multiplyMM(this.mvpMatrix, 0, fArr, 0, fArr2, 0);
            } else {
                f3 = -1.0f;
            }
            f2 = 0.0f;
            Matrix.setLookAtM(fArr2, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, f3, f2, 0.0f);
            Matrix.setIdentityM(this.mvpMatrix, 0);
            Matrix.multiplyMM(this.mvpMatrix, 0, fArr, 0, fArr2, 0);
        }
        f2 = 1.0f;
        f3 = 0.0f;
        Matrix.setLookAtM(fArr2, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, f3, f2, 0.0f);
        Matrix.setIdentityM(this.mvpMatrix, 0);
        Matrix.multiplyMM(this.mvpMatrix, 0, fArr, 0, fArr2, 0);
    }

    private void initInputSurfaceTexture() {
        if (!this.inputSurfaceTextureInitialized) {
            for (GlFilter next : this.filters) {
                if (next instanceof GlFrameRenderFilter) {
                    ((GlFrameRenderFilter) next).initInputFrameTexture(this.inputSurface.getTextureId(), this.inputSurface.getTransformMatrix());
                }
            }
            this.inputSurfaceTextureInitialized = true;
        }
    }
}
