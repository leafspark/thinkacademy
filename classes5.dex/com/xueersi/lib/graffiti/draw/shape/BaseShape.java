package com.xueersi.lib.graffiti.draw.shape;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;

public abstract class BaseShape extends DrawableObject {
    public static final String TAG = "BaseShape";
    private Drawable cursorDrawable;
    protected int fillColor;
    protected int mLineType;
    protected float mLineWidth;
    private WXWBAction originPointData;
    private float rotateCenterX = -999.0f;
    private float rotateCenterY = -999.0f;
    protected float rotateDegrees;
    protected int strokeColor;

    /* access modifiers changed from: protected */
    public int[] tryGetCtrlPointPosWhenOffset(List<WXWBAction.PointData> list) {
        return new int[0];
    }

    public void setCursorDrawable(Drawable drawable) {
        this.cursorDrawable = drawable;
    }

    /* access modifiers changed from: protected */
    public void setRotateCenter(float f, float f2) {
        this.rotateCenterX = f;
        this.rotateCenterY = f2;
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        float f = this.rotateCenterX;
        if ((f == -999.0f || f == -999.0f) ? false : true) {
            canvas.save();
            canvas.rotate(this.rotateDegrees, this.rotateCenterX, this.rotateCenterY);
            onDraw(canvas);
            drawCursorPoint(canvas);
            canvas.restore();
            return;
        }
        onDraw(canvas);
        drawCursorPoint(canvas);
    }

    private void drawCursorPoint(Canvas canvas) {
        WXWBAction wXWBAction = this.originPointData;
        if (wXWBAction != null) {
            WXWBAction.PointData cursorPosition = wXWBAction.getCursorPosition();
            Drawable drawable = this.cursorDrawable;
            if (drawable != null && !drawable.getBounds().isEmpty() && cursorPosition != null && cursorPosition.getPointAction() == 1) {
                float relativeX = relativeX(cursorPosition.getX());
                float relativeY = relativeY(cursorPosition.getY());
                canvas.save();
                Rect bounds = this.cursorDrawable.getBounds();
                canvas.translate(relativeX - (((float) bounds.width()) / 2.0f), relativeY - (((float) bounds.height()) / 2.0f));
                canvas.clipRect(this.cursorDrawable.getBounds());
                this.cursorDrawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    public void setOffset(float f, float f2) {
        super.setOffset(f, f2);
        if (f != CropImageView.DEFAULT_ASPECT_RATIO || f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
            List<WXWBAction.PointData> pointList = this.originPointData.getPointList();
            if (pointList.size() >= 2) {
                WXWBAction.PointData pointData = pointList.get(0);
                WXWBAction.PointData pointData2 = pointList.get(1);
                float x = f - (((pointData2.getX() - pointData.getX()) / 2.0f) + pointData.getX());
                float y = f2 - (((pointData2.getY() - pointData.getY()) / 2.0f) + pointData.getY());
                pointData.setX(pointData.getX() + x);
                pointData.setY(pointData.getY() + y);
                pointData2.setX(pointData2.getX() + x);
                pointData2.setY(pointData2.getY() + y);
                int[] tryGetCtrlPointPosWhenOffset = tryGetCtrlPointPosWhenOffset(pointList);
                if (tryGetCtrlPointPosWhenOffset != null) {
                    for (int i : tryGetCtrlPointPosWhenOffset) {
                        if (i < pointList.size()) {
                            WXWBAction.PointData pointData3 = pointList.get(i);
                            pointData3.setX(pointData3.getX() + x);
                            pointData3.setY(pointData3.getY() + y);
                        }
                    }
                }
                updateActionData(this.originPointData);
            }
        }
    }

    public final synchronized void setActionData(WXWBAction wXWBAction) {
        super.setActionData(wXWBAction);
        if (wXWBAction != null) {
            this.fillColor = wXWBAction.getFillColor();
            this.mLineType = wXWBAction.getLineType();
            this.rotateDegrees = (float) (((double) (wXWBAction.getRotation() * 180.0f)) / 3.141592653589793d);
            this.mLineWidth = relativePixel(wXWBAction.getLineWidth());
            this.strokeColor = wXWBAction.getStrokeColor();
            updateActionData(wXWBAction);
            this.originPointData = wXWBAction;
        }
    }

    /* access modifiers changed from: protected */
    public void enableLineEffect(Paint paint) {
        int i = this.mLineType;
        if (i == 2) {
            paint.setPathEffect(new DashPathEffect(new float[]{1.0f, this.mLineWidth * 2.0f}, CropImageView.DEFAULT_ASPECT_RATIO));
        } else if (i == 1) {
            float f = this.mLineWidth;
            paint.setPathEffect(new DashPathEffect(new float[]{f * 2.0f, f * 2.0f}, CropImageView.DEFAULT_ASPECT_RATIO));
        } else {
            paint.setPathEffect((PathEffect) null);
        }
    }

    /* access modifiers changed from: protected */
    public void disableLineEffect(Paint paint) {
        paint.setPathEffect((PathEffect) null);
    }

    public synchronized void onCanvasSizeChanged(int i, int i2) {
        super.onCanvasSizeChanged(i, i2);
        WXWBAction wXWBAction = this.originPointData;
        if (wXWBAction != null) {
            this.mLineWidth = relativePixel(wXWBAction.getLineWidth());
            updateActionData(this.originPointData);
        }
    }

    /* access modifiers changed from: protected */
    public boolean arrowCircleCenter() {
        return this.config == null || !this.config.isHideShapeCenterDot();
    }
}
