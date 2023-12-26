package com.linkedin.android.litr.render;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.linkedin.android.litr.filter.GlFilter;
import com.linkedin.android.litr.filter.GlFrameRenderFilter;
import com.linkedin.android.litr.filter.video.gl.DefaultVideoFrameRenderFilter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0006\u0010!\u001a\u00020\u001aJ\u001c\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010%\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/linkedin/android/litr/render/GlSingleFrameRenderer;", "Lcom/linkedin/android/litr/render/SingleFrameRenderer;", "filters", "", "Lcom/linkedin/android/litr/filter/GlFilter;", "(Ljava/util/List;)V", "bitmapPaint", "Landroid/graphics/Paint;", "destFramebuffer", "Lcom/linkedin/android/litr/render/GlFramebuffer;", "", "hasFilters", "", "inputSize", "Landroid/graphics/Point;", "inputSurface", "Lcom/linkedin/android/litr/render/VideoRenderInputSurface;", "isInitialized", "mvpMatrix", "", "outputSurface", "Lcom/linkedin/android/litr/render/VideoRenderOutputSurface;", "pixelBuffer", "Ljava/nio/ByteBuffer;", "stMatrix", "drawFilters", "", "presentationTimeNs", "", "init", "width", "", "height", "release", "renderFrame", "Landroid/graphics/Bitmap;", "input", "saveTexture", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GlSingleFrameRenderer.kt */
public final class GlSingleFrameRenderer implements SingleFrameRenderer {
    private Paint bitmapPaint;
    private GlFramebuffer destFramebuffer;
    private final List<GlFilter> filters;
    private final boolean hasFilters;
    private Point inputSize;
    private VideoRenderInputSurface inputSurface;
    private boolean isInitialized;
    private final float[] mvpMatrix;
    private VideoRenderOutputSurface outputSurface;
    private ByteBuffer pixelBuffer;
    private final float[] stMatrix;

    public GlSingleFrameRenderer(List<? extends GlFilter> list) {
        boolean z = true;
        this.hasFilters = list != null && (list.isEmpty() ^ true);
        this.stMatrix = new float[16];
        this.mvpMatrix = new float[16];
        List<GlFilter> arrayList = new ArrayList<>();
        this.filters = arrayList;
        if (list == null) {
            arrayList.add(new DefaultVideoFrameRenderFilter());
            return;
        }
        Iterable iterable = list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((GlFilter) it.next()) instanceof GlFrameRenderFilter) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            this.filters.add(new DefaultVideoFrameRenderFilter());
        }
        this.filters.addAll(list);
    }

    private final Bitmap saveTexture(int i, int i2) {
        ByteBuffer byteBuffer = this.pixelBuffer;
        if (byteBuffer != null) {
            byteBuffer.rewind();
        }
        GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, this.pixelBuffer);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(this.pixelBuffer);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "destBitmap");
        return createBitmap;
    }

    private final void init(int i, int i2) {
        this.inputSize = new Point(i, i2);
        this.bitmapPaint = new Paint();
        this.pixelBuffer = ByteBuffer.allocate(i * i2 * 4);
        Matrix.setIdentityM(this.stMatrix, 0);
        Matrix.setIdentityM(this.mvpMatrix, 0);
        VideoRenderInputSurface videoRenderInputSurface = new VideoRenderInputSurface();
        SurfaceTexture surfaceTexture = videoRenderInputSurface.getSurfaceTexture();
        Point point = this.inputSize;
        if (point == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputSize");
        }
        int i3 = point.x;
        Point point2 = this.inputSize;
        if (point2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputSize");
        }
        surfaceTexture.setDefaultBufferSize(i3, point2.y);
        Unit unit = Unit.INSTANCE;
        this.inputSurface = videoRenderInputSurface;
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(0);
        Point point3 = this.inputSize;
        if (point3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputSize");
        }
        int i4 = point3.x;
        Point point4 = this.inputSize;
        if (point4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputSize");
        }
        surfaceTexture2.setDefaultBufferSize(i4, point4.y);
        this.outputSurface = new VideoRenderOutputSurface(new Surface(surfaceTexture2));
        surfaceTexture2.release();
        Matrix.scaleM(this.mvpMatrix, 0, 1.0f, -1.0f, 1.0f);
        for (GlFilter glFilter : this.filters) {
            glFilter.init();
            glFilter.setVpMatrix(this.mvpMatrix, 0);
        }
        Point point5 = this.inputSize;
        if (point5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputSize");
        }
        int i5 = point5.x;
        Point point6 = this.inputSize;
        if (point6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputSize");
        }
        GlTexture glTexture = new GlTexture(33984, 3553, (Integer) null, i5, point6.y);
        glTexture.bind();
        GlFramebuffer glFramebuffer = new GlFramebuffer();
        this.destFramebuffer = glFramebuffer;
        glFramebuffer.bind();
        GlFramebuffer glFramebuffer2 = this.destFramebuffer;
        if (glFramebuffer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destFramebuffer");
        }
        GlFramebuffer.attachTexture$default(glFramebuffer2, glTexture.getTexName(), 0, 0, 0, 14, (Object) null);
        GlFramebuffer glFramebuffer3 = this.destFramebuffer;
        if (glFramebuffer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destFramebuffer");
        }
        glFramebuffer3.unbind();
        glTexture.unbind();
    }

    public Bitmap renderFrame(Bitmap bitmap, long j) {
        if (this.hasFilters && bitmap != null) {
            if (!this.isInitialized) {
                init(bitmap.getWidth(), bitmap.getHeight());
                this.isInitialized = true;
            }
            VideoRenderInputSurface videoRenderInputSurface = this.inputSurface;
            if (videoRenderInputSurface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputSurface");
            }
            Canvas lockCanvas = videoRenderInputSurface.getSurface().lockCanvas((Rect) null);
            Paint paint = this.bitmapPaint;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bitmapPaint");
            }
            lockCanvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            VideoRenderInputSurface videoRenderInputSurface2 = this.inputSurface;
            if (videoRenderInputSurface2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputSurface");
            }
            videoRenderInputSurface2.getSurface().unlockCanvasAndPost(lockCanvas);
            VideoRenderInputSurface videoRenderInputSurface3 = this.inputSurface;
            if (videoRenderInputSurface3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputSurface");
            }
            videoRenderInputSurface3.awaitNewImage();
            GlFramebuffer glFramebuffer = this.destFramebuffer;
            if (glFramebuffer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("destFramebuffer");
            }
            glFramebuffer.bind();
            drawFilters(j);
            Point point = this.inputSize;
            if (point == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputSize");
            }
            int i = point.x;
            Point point2 = this.inputSize;
            if (point2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputSize");
            }
            bitmap = saveTexture(i, point2.y);
            GlFramebuffer glFramebuffer2 = this.destFramebuffer;
            if (glFramebuffer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("destFramebuffer");
            }
            glFramebuffer2.unbind();
        }
        return bitmap;
    }

    private final void drawFilters(long j) {
        VideoRenderInputSurface videoRenderInputSurface = this.inputSurface;
        if (videoRenderInputSurface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputSurface");
        }
        videoRenderInputSurface.getTransformMatrix(this.stMatrix);
        Collection arrayList = new ArrayList();
        for (GlFilter glFilter : this.filters) {
            if (!(glFilter instanceof GlFrameRenderFilter)) {
                glFilter = null;
            }
            GlFrameRenderFilter glFrameRenderFilter = (GlFrameRenderFilter) glFilter;
            if (glFrameRenderFilter != null) {
                arrayList.add(glFrameRenderFilter);
            }
        }
        for (GlFrameRenderFilter glFrameRenderFilter2 : (List) arrayList) {
            VideoRenderInputSurface videoRenderInputSurface2 = this.inputSurface;
            if (videoRenderInputSurface2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputSurface");
            }
            glFrameRenderFilter2.initInputFrameTexture(videoRenderInputSurface2.getTextureId(), this.stMatrix);
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        for (GlFilter apply : this.filters) {
            apply.apply(j);
        }
        GLES20.glFinish();
    }

    public final void release() {
        for (GlFilter release : this.filters) {
            release.release();
        }
        VideoRenderInputSurface videoRenderInputSurface = this.inputSurface;
        if (videoRenderInputSurface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputSurface");
        }
        videoRenderInputSurface.release();
        VideoRenderOutputSurface videoRenderOutputSurface = this.outputSurface;
        if (videoRenderOutputSurface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outputSurface");
        }
        videoRenderOutputSurface.release();
        GlFramebuffer glFramebuffer = this.destFramebuffer;
        if (glFramebuffer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destFramebuffer");
        }
        glFramebuffer.delete();
    }

    public final boolean hasFilters() {
        return this.hasFilters;
    }
}
