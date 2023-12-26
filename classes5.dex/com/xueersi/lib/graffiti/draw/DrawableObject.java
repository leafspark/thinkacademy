package com.xueersi.lib.graffiti.draw;

import android.graphics.Canvas;
import com.xueersi.lib.graffiti.LocalCanvasSize;
import com.xueersi.lib.graffiti.WXWBAction;
import com.yalantis.ucrop.view.CropImageView;

public abstract class DrawableObject {
    private WXWBAction actionData;
    protected int canvasHeight;
    protected int canvasWidth;
    protected Config config;
    private LocalCanvasSize localCanvasSize;
    protected float offsetX;
    protected float offsetY;

    public static abstract class Factory {
        public abstract DrawableObject create();
    }

    /* access modifiers changed from: protected */
    public abstract void onDraw(Canvas canvas);

    /* access modifiers changed from: protected */
    public void onIncrementDraw(Canvas canvas, WXWBAction wXWBAction) {
    }

    /* access modifiers changed from: protected */
    public abstract void updateActionData(WXWBAction wXWBAction);

    /* access modifiers changed from: protected */
    public float relativePixel(float f) {
        return ((float) this.canvasWidth) * f;
    }

    /* access modifiers changed from: protected */
    public float relativeX(float f) {
        return ((float) this.canvasWidth) * f;
    }

    /* access modifiers changed from: protected */
    public float relativeY(float f) {
        return ((float) this.canvasHeight) * f;
    }

    public void onCanvasSizeChanged(int i, int i2) {
        this.canvasWidth = i;
        this.canvasHeight = i2;
    }

    public void setConfig(Config config2) {
        this.config = config2;
    }

    public void setLocalCanvasSize(LocalCanvasSize localCanvasSize2) {
        this.localCanvasSize = localCanvasSize2;
    }

    public void setActionData(WXWBAction wXWBAction) {
        this.actionData = wXWBAction;
        checkCanvasSizeChanged();
    }

    public WXWBAction getActionData() {
        return this.actionData;
    }

    public void draw(Canvas canvas) {
        checkCanvasSizeChanged();
    }

    public final void incrementDraw(Canvas canvas, WXWBAction wXWBAction) {
        boolean z;
        checkCanvasSizeChanged();
        if (this.offsetX == CropImageView.DEFAULT_ASPECT_RATIO && this.offsetY == CropImageView.DEFAULT_ASPECT_RATIO) {
            z = false;
        } else {
            z = true;
            canvas.save();
            canvas.translate(relativeX(this.offsetX), relativeY(this.offsetY));
        }
        onIncrementDraw(canvas, wXWBAction);
        if (z) {
            canvas.restore();
        }
    }

    private void checkCanvasSizeChanged() {
        LocalCanvasSize localCanvasSize2 = this.localCanvasSize;
        if (localCanvasSize2 != null) {
            int width = localCanvasSize2.getWidth();
            int height = this.localCanvasSize.getHeight();
            if ((this.canvasWidth != width && width > 0) || (this.canvasHeight != height && height > 0)) {
                onCanvasSizeChanged(width, height);
            }
        }
    }

    public void setOffset(float f, float f2) {
        this.offsetX = f;
        this.offsetY = f2;
    }

    public float getOffsetX() {
        return this.offsetX;
    }

    public float getOffsetY() {
        return this.offsetY;
    }

    public static class Config {
        private boolean hideLaserTail;
        private boolean hideShapeCenterDot;
        private String mTeacherId;

        public void setHideShapeCenterDot(boolean z) {
            this.hideShapeCenterDot = z;
        }

        public boolean isHideShapeCenterDot() {
            return this.hideShapeCenterDot;
        }

        public boolean isHideLaserTail() {
            return this.hideLaserTail;
        }

        public void setHideLaserTail(boolean z) {
            this.hideLaserTail = z;
        }

        public String getTeacherId() {
            return this.mTeacherId;
        }

        public void setTeacherId(String str) {
            this.mTeacherId = str;
        }
    }
}
