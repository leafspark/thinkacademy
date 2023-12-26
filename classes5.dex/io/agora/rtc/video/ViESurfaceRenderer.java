package io.agora.rtc.video;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Process;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.yalantis.ucrop.view.CropImageView;
import io.agora.rtc.internal.Logging;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ViESurfaceRenderer implements SurfaceHolder.Callback {
    private static final String TAG = "ViESurfaceRenderer";
    private Bitmap bitmap = null;
    private float bottomScale = 1.0f;
    private ByteBuffer byteBuffer = null;
    private Rect dest = new Rect();
    private float leftScale = CropImageView.DEFAULT_ASPECT_RATIO;
    private float rightScale = 1.0f;
    private Rect source = new Rect();
    private SurfaceHolder surfaceHolder;
    private float topScale = CropImageView.DEFAULT_ASPECT_RATIO;

    public ViESurfaceRenderer(SurfaceView surfaceView) {
        Logging.i(TAG, "surface view " + surfaceView);
        SurfaceHolder holder = surfaceView.getHolder();
        this.surfaceHolder = holder;
        if (holder != null) {
            holder.addCallback(this);
            surfaceCreated(this.surfaceHolder);
        }
    }

    private void changeDestRect(int i, int i2) {
        Rect rect = this.dest;
        rect.right = (int) (((float) rect.left) + (Math.abs(this.leftScale - this.rightScale) * ((float) i)));
        Rect rect2 = this.dest;
        rect2.bottom = (int) (((float) rect2.top) + (Math.abs(this.topScale - this.bottomScale) * ((float) i2)));
        Logging.i(TAG, "ViESurfaceRender::surfaceChanged in_width:" + i + " in_height:" + i2 + " source.left:" + this.source.left + " source.top:" + this.source.top + " source.dest:" + this.source.right + " source.bottom:" + this.source.bottom + " dest.left:" + this.dest.left + " dest.top:" + this.dest.top + " dest.dest:" + this.dest.right + " dest.bottom:" + this.dest.bottom + " dest scale " + this.rightScale + " bottom scale " + this.bottomScale);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder2, int i, int i2, int i3) {
        changeDestRect(i2, i3);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder2) {
        Canvas lockCanvas = this.surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            Rect surfaceFrame = this.surfaceHolder.getSurfaceFrame();
            if (surfaceFrame != null) {
                changeDestRect(surfaceFrame.right - surfaceFrame.left, surfaceFrame.bottom - surfaceFrame.top);
                Logging.i(TAG, "ViESurfaceRender::surfaceCreated dst.left:" + surfaceFrame.left + " dst.top:" + surfaceFrame.top + " dst.dest:" + surfaceFrame.right + " dst.bottom:" + surfaceFrame.bottom + " source.left:" + this.source.left + " source.top:" + this.source.top + " source.dest:" + this.source.right + " source.bottom:" + this.source.bottom + " dest.left:" + this.dest.left + " dest.top:" + this.dest.top + " dest.dest:" + this.dest.right + " dest.bottom:" + this.dest.bottom);
            }
            this.surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder2) {
        Logging.d(TAG, "ViESurfaceRenderer::surfaceDestroyed");
        this.bitmap = null;
        this.byteBuffer = null;
    }

    public Bitmap CreateBitmap(int i, int i2) {
        Logging.d(TAG, "CreateByteBitmap " + i + ":" + i2);
        if (this.bitmap == null) {
            try {
                Process.setThreadPriority(-4);
            } catch (Exception unused) {
            }
        }
        this.bitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
        this.source.left = 0;
        this.source.top = 0;
        this.source.bottom = i2;
        this.source.right = i;
        return this.bitmap;
    }

    public ByteBuffer CreateByteBuffer(int i, int i2) {
        Logging.i(TAG, "CreateByteBuffer " + i + " * " + i2);
        this.bitmap = CreateBitmap(i, i2);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * i2 * 2);
        this.byteBuffer = allocateDirect;
        return allocateDirect;
    }

    public void SetCoordinates(float f, float f2, float f3, float f4) {
        Logging.i(TAG, "SetCoordinates " + f + "," + f2 + " : " + f3 + "," + f4);
        this.leftScale = f;
        this.topScale = f2;
        this.rightScale = f3;
        this.bottomScale = f4;
    }

    private void saveBitmapToJPEG(int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(String.format("/sdcard/render_%d.jpg", new Object[]{Long.valueOf(System.currentTimeMillis())}));
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
            Logging.i(TAG, "saved jpg " + fileOutputStream.toString());
        } catch (IOException e) {
            Logging.e(TAG, "save jpg failed", e);
        }
    }

    public void DrawByteBuffer() {
        ByteBuffer byteBuffer2 = this.byteBuffer;
        if (byteBuffer2 == null) {
            Logging.w(TAG, "DrawByteBuffer null");
            return;
        }
        byteBuffer2.rewind();
        this.bitmap.copyPixelsFromBuffer(this.byteBuffer);
        DrawBitmap();
    }

    public void DrawBitmap() {
        Canvas lockCanvas;
        if (this.bitmap != null && (lockCanvas = this.surfaceHolder.lockCanvas()) != null) {
            lockCanvas.drawBitmap(this.bitmap, this.source, this.dest, (Paint) null);
            this.surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }
}
