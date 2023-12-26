package com.xueersi.lib.graffiti.draw.smooth;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.utils.ListUtil;
import com.xueersi.lib.graffiti.utils.PointDataUtils;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class LaserPointerDrawableObj extends DrawableObject {
    private static final boolean DEBUG_FLAG = false;
    private static final int DEFAULT_LASER_POINTER_COLOR = Color.parseColor("#1890FF");
    private static final int DEFAULT_LASER_POINTER_STROKE_WIDTH = 12;
    private static final String TAG = "LaserPointerDrawableObj";
    private float drawOffsetX;
    private float drawOffsetY;
    private Drawable drawable;
    private float drawableX = -1.0f;
    private float drawableY = -1.0f;
    protected volatile AtomicBoolean hasEnd = new AtomicBoolean(false);
    private Paint mPaint;
    private ConcurrentLinkedQueue<WXWBAction> mPointQueue = new ConcurrentLinkedQueue<>();
    protected float mSegmentStartX = -2.14748365E9f;
    protected float mSegmentStartY = -2.14748365E9f;
    protected float mX = -2.14748365E9f;
    protected float mY = -2.14748365E9f;
    private final ArrayList<Path> pathList = new ArrayList<>();

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
    }

    public LaserPointerDrawableObj() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.BUTT);
        this.mPaint.setColor(DEFAULT_LASER_POINTER_COLOR);
        this.mPaint.setStrokeWidth(12.0f);
    }

    public void setActionData(WXWBAction wXWBAction) {
        super.setActionData(wXWBAction);
        updateActionData(wXWBAction);
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
        this.pathList.clear();
        this.mSegmentStartY = -2.14748365E9f;
        this.mSegmentStartX = -2.14748365E9f;
        this.mY = -2.14748365E9f;
        this.mX = -2.14748365E9f;
        this.drawableY = -1.0f;
        this.drawableX = -1.0f;
        List<WXWBAction> addWXWBAction = addWXWBAction(wXWBAction);
        if (!ListUtil.isEmpty(addWXWBAction)) {
            int i = 0;
            while (i < addWXWBAction.size()) {
                List<WXWBAction.PointData> pointList = addWXWBAction.get(i).getPointList();
                if (pointList == null || pointList.size() == 0) {
                    XesLog.d("涂鸦画笔绘制pointList为空");
                } else {
                    int i2 = 0;
                    while (i2 < pointList.size()) {
                        WXWBAction.PointData pointData = pointList.get(i2);
                        if (pointData != null) {
                            boolean z = i == addWXWBAction.size() - 1 && i2 == pointList.size() - 1;
                            int pointAction = pointData.getPointAction();
                            if (pointAction == 0) {
                                this.hasEnd.set(false);
                                onActionDown(pointData);
                            } else if (pointAction == 1) {
                                onActionMove(pointData, z);
                            } else if (pointAction == 2) {
                                this.pathList.clear();
                                this.hasEnd.set(true);
                            }
                        }
                        i2++;
                    }
                }
                i++;
            }
        }
    }

    private void onActionDown(WXWBAction.PointData pointData) {
        if (pointData != null) {
            float relativeX = relativeX(pointData.getX());
            float relativeY = relativeY(pointData.getY());
            this.mX = relativeX;
            this.mY = relativeY;
            this.mSegmentStartX = relativeX;
            this.mSegmentStartY = relativeY;
        }
    }

    private void onActionMove(WXWBAction.PointData pointData, boolean z) {
        quadToAction(pointData, z);
    }

    private void quadToAction(WXWBAction.PointData pointData, boolean z) {
        float relativeX = relativeX(pointData.getX());
        float relativeY = relativeY(pointData.getY());
        float f = this.mX;
        if (f == -2.14748365E9f || this.mY == -2.14748365E9f) {
            onActionDown(pointData);
            return;
        }
        float abs = Math.abs(relativeX - f);
        float abs2 = Math.abs(relativeY - this.mY);
        if (abs > CropImageView.DEFAULT_ASPECT_RATIO || abs2 > CropImageView.DEFAULT_ASPECT_RATIO) {
            Path path = new Path();
            path.moveTo(this.mSegmentStartX, this.mSegmentStartY);
            float f2 = this.mX;
            float f3 = this.mY;
            path.quadTo(f2, f3, (relativeX + f2) / 2.0f, (relativeY + f3) / 2.0f);
            if (z) {
                this.drawableX = (this.mX + relativeX) / 2.0f;
                this.drawableY = (this.mY + relativeY) / 2.0f;
            }
            this.pathList.add(path);
            this.mSegmentStartX = (this.mX + relativeX) / 2.0f;
            this.mSegmentStartY = (this.mY + relativeY) / 2.0f;
        }
        this.mX = relativeX;
        this.mY = relativeY;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.pathList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (this.config.isHideLaserTail()) {
                this.mPaint.setAlpha(0);
            } else {
                this.mPaint.setAlpha((int) (((((float) i) * 1.0f) / ((float) arrayList.size())) * 255.0f));
            }
            Path path = (Path) arrayList.get(i);
            if (path != null) {
                canvas.drawPath(path, this.mPaint);
            }
        }
        Drawable drawable2 = this.drawable;
        if (drawable2 != null && !drawable2.getBounds().isEmpty() && this.drawableX >= CropImageView.DEFAULT_ASPECT_RATIO && this.drawableY >= CropImageView.DEFAULT_ASPECT_RATIO) {
            canvas.save();
            Rect bounds = this.drawable.getBounds();
            canvas.translate(this.drawableX - (((float) bounds.width()) * this.drawOffsetX), this.drawableY - (((float) bounds.height()) * this.drawOffsetY));
            canvas.clipRect(this.drawable.getBounds());
            this.drawable.draw(canvas);
            canvas.restore();
        }
    }

    public boolean hasEnd() {
        return this.hasEnd.get();
    }

    public void initLaserPointerSetting(int i) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    private void removeOutOfData(WXWBAction wXWBAction) {
        WXWBAction peek;
        long timestamp = wXWBAction.getTimestamp();
        if (!this.mPointQueue.isEmpty() && (peek = this.mPointQueue.peek()) != null && timestamp - peek.getTimestamp() >= 350) {
            this.mPointQueue.poll();
            removeOutOfData(wXWBAction);
        }
    }

    public List<WXWBAction> addWXWBAction(WXWBAction wXWBAction) {
        if (PointDataUtils.existActionEndPoint(wXWBAction)) {
            this.mPointQueue.clear();
            return null;
        }
        removeOutOfData(wXWBAction);
        this.mPointQueue.add(wXWBAction);
        ArrayList arrayList = new ArrayList();
        Iterator<WXWBAction> it = this.mPointQueue.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public void setDrawable(Drawable drawable2, float f, float f2) {
        int width;
        this.drawOffsetX = f;
        this.drawOffsetY = f2;
        this.drawable = drawable2;
        if (drawable2 != null && this.mPaint != null && (width = drawable2.getBounds().width() / 2) > 0) {
            float f3 = (float) width;
            if (this.mPaint.getStrokeWidth() != f3) {
                this.mPaint.setStrokeWidth(f3);
            }
        }
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new LaserPointerDrawableObj();
        }
    }
}
