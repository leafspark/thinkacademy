package com.xueersi.lib.graffiti.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.SystemClock;
import android.view.View;
import com.xueersi.lib.graffiti.LocalCanvasSize;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.entity.DrawActionParams;
import com.xueersi.lib.graffiti.utils.ListUtil;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;

public class NormalGraffitiView extends View {
    private static final String TAG = "NormalGraffitiView";
    private Bitmap mBitmap;
    private Paint mBitmapPaint;
    private Canvas mCanvas;

    public NormalGraffitiView(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.mBitmapPaint = new Paint();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this.mBitmapPaint);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int width = LocalCanvasSize.sdkInner().getWidth();
        int height = LocalCanvasSize.sdkInner().getHeight();
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return;
        }
        if (bitmap.getWidth() != width || this.mBitmap.getHeight() != height) {
            if (width <= 0) {
                width = i;
            }
            if (height <= 0) {
                height = i2;
            }
            this.mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            this.mCanvas = new Canvas(this.mBitmap);
            XesLog.d("涂鸦：尺寸变化清空画布:" + i + "*" + i2 + " >>" + Integer.toHexString(hashCode()));
        }
    }

    public void addAction(DrawActionParams drawActionParams) {
        checkCanvasNoNull();
        long uptimeMillis = SystemClock.uptimeMillis();
        drawIntoBitmap(drawActionParams);
        if (XesLog.isEnabled()) {
            XesLog.d("涂鸦：增量绘制一次耗时:" + (SystemClock.uptimeMillis() - uptimeMillis) + " >>" + Integer.toHexString(hashCode()));
        }
        invalidate();
    }

    private void checkCanvasNoNull() {
        if (this.mCanvas == null) {
            this.mBitmap = Bitmap.createBitmap(LocalCanvasSize.sdkInner().getWidth(), LocalCanvasSize.sdkInner().getHeight(), Bitmap.Config.ARGB_8888);
            this.mCanvas = new Canvas(this.mBitmap);
        }
    }

    public void resetActions(List<DrawActionParams> list) {
        checkCanvasNoNull();
        Canvas canvas = this.mCanvas;
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        addActions(list);
    }

    public void addActions(List<DrawActionParams> list) {
        checkCanvasNoNull();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (list != null) {
            for (DrawActionParams drawIntoBitmap : list) {
                drawIntoBitmap(drawIntoBitmap);
            }
        }
        if (XesLog.isEnabled()) {
            XesLog.d("涂鸦：批量绘制" + ListUtil.size(list) + "个线条耗时:" + (SystemClock.uptimeMillis() - uptimeMillis) + " >>" + Integer.toHexString(hashCode()));
        }
        invalidate();
    }

    private void drawIntoBitmap(DrawActionParams drawActionParams) {
        if (drawActionParams != null && drawActionParams.getDrawableObject() != null && drawActionParams.getLastAction() != null) {
            if (ListUtil.isNotEmpty(drawActionParams.getActionList())) {
                for (WXWBAction next : drawActionParams.getActionList()) {
                    if (next != null) {
                        drawActionParams.getDrawableObject().incrementDraw(this.mCanvas, next);
                    }
                }
                return;
            }
            drawActionParams.getDrawableObject().incrementDraw(this.mCanvas, drawActionParams.getLastAction());
        }
    }

    public void clear() {
        Canvas canvas = this.mCanvas;
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        invalidate();
    }
}
