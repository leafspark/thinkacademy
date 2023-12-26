package com.xueersi.lib.graffiti.draw.smooth;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.utils.DrawUtil;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class SmoothCurveDrawObj extends DrawableObject {
    private LinkedHashSet<WXWBAction> actionPackagePointDataList = new LinkedHashSet<>();
    protected volatile RectF bounds = new RectF();
    protected volatile Rect boundsInt = new Rect();
    boolean hasEnd = false;
    protected Paint mDebugPaint;
    protected float mLineWidth;
    protected Paint mPaint = new Paint();
    protected volatile Path mPath = new Path();
    protected float mX = -2.14748365E9f;
    protected float mY = -2.14748365E9f;
    protected int strokeColor;

    public SmoothCurveDrawObj() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public synchronized void onDraw(Canvas canvas) {
        canvas.save();
        canvas.clipRect(this.boundsInt);
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.restore();
    }

    public synchronized RectF getBounds() {
        return this.bounds;
    }

    public synchronized Rect getBoundsInt() {
        return this.boundsInt;
    }

    private void quadToAction(WXWBAction.PointData pointData) {
        float relativeX = relativeX(pointData.getX());
        float relativeY = relativeY(pointData.getY());
        float f = this.mX;
        if (f == -2.14748365E9f || this.mY == -2.14748365E9f) {
            onActionDown(pointData);
        } else {
            float abs = Math.abs(relativeX - f);
            float abs2 = Math.abs(relativeY - this.mY);
            if (abs > CropImageView.DEFAULT_ASPECT_RATIO || abs2 > CropImageView.DEFAULT_ASPECT_RATIO) {
                Path path = this.mPath;
                float f2 = this.mX;
                float f3 = this.mY;
                path.quadTo(f2, f3, (relativeX + f2) / 2.0f, (relativeY + f3) / 2.0f);
                this.mX = relativeX;
                this.mY = relativeY;
            }
        }
        DrawUtil.computePathBounds(this.mPath, this.bounds, this.boundsInt, this.mLineWidth);
    }

    private void onActionDown(WXWBAction.PointData pointData) {
        if (pointData != null) {
            float relativeX = relativeX(pointData.getX());
            float relativeY = relativeY(pointData.getY());
            this.mPaint.setStrokeWidth(this.mLineWidth);
            this.mPaint.setColor(this.strokeColor);
            this.mPath.reset();
            this.mPath.moveTo(relativeX, relativeY);
            this.mX = relativeX;
            this.mY = relativeY;
        }
    }

    private void onActionMove(WXWBAction.PointData pointData) {
        quadToAction(pointData);
    }

    private void onActionUp(WXWBAction.PointData pointData) {
        quadToAction(pointData);
        if (this.mX == relativeX(pointData.getX()) && this.mY == relativeY(pointData.getY())) {
            this.mPath.lineTo(this.mX, this.mY);
        }
        DrawUtil.computePathBounds(this.mPath, this.bounds, this.boundsInt, this.mLineWidth);
        this.hasEnd = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        onDraw(canvas);
    }

    public synchronized void setActionData(WXWBAction wXWBAction) {
        super.setActionData(wXWBAction);
        if (wXWBAction != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mLineWidth = relativePixel(wXWBAction.getLineWidth());
            this.strokeColor = wXWBAction.getStrokeColor();
            updateActionData(wXWBAction);
            this.actionPackagePointDataList.add(wXWBAction);
            XesLog.d("产生一个点的时间：" + (SystemClock.uptimeMillis() - uptimeMillis));
        }
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
        List<WXWBAction.PointData> pointList;
        if (wXWBAction != null && (pointList = wXWBAction.getPointList()) != null && pointList.size() != 0) {
            for (WXWBAction.PointData next : pointList) {
                int pointAction = next.getPointAction();
                if (pointAction == 0) {
                    onActionDown(next);
                } else if (pointAction == 1) {
                    onActionMove(next);
                } else if (pointAction == 2) {
                    onActionUp(next);
                }
            }
        }
    }

    public synchronized boolean hasEnd() {
        return this.hasEnd;
    }

    public synchronized void onCanvasSizeChanged(int i, int i2) {
        super.onCanvasSizeChanged(i, i2);
        Iterator it = this.actionPackagePointDataList.iterator();
        while (it.hasNext()) {
            WXWBAction wXWBAction = (WXWBAction) it.next();
            this.mLineWidth = relativePixel(wXWBAction.getLineWidth());
            updateActionData(wXWBAction);
        }
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new SmoothCurveDrawObj();
        }
    }
}
