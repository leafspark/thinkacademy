package com.xueersi.lib.graffiti.draw.shape.physics;

import android.graphics.Canvas;
import android.graphics.Path;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;

public class PhysicsElectromotor extends PhysicsCenterCircle {
    protected Path mPath = new Path();

    /* access modifiers changed from: package-private */
    public void drawText(Canvas canvas, float f, float f2, float f3, float f4) {
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        createElectromotorPath(f, f2, f3, f4);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
        super.updateActionData(wXWBAction);
    }

    private void createElectromotorPath(float f, float f2, float f3, float f4) {
        float f5 = this.mCirclePadding + f;
        float f6 = this.mCirclePadding + f2;
        float f7 = f3 - this.mCirclePadding;
        float f8 = f4 - this.mCirclePadding;
        float f9 = f3 - this.mCirclePadding;
        float f10 = f2 + this.mCirclePadding;
        float f11 = f + this.mCirclePadding;
        float f12 = f4 - this.mCirclePadding;
        float f13 = f4 - this.mCirclePadding;
        this.mPath.reset();
        this.mPath.moveTo(f11, f12);
        this.mPath.lineTo(f5, f6);
        this.mPath.lineTo((float) this.mCenterX, f13);
        this.mPath.lineTo(f9, f10);
        this.mPath.lineTo(f7, f8);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new PhysicsElectromotor();
        }
    }
}
