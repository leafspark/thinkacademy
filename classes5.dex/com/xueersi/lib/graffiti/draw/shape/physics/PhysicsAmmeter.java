package com.xueersi.lib.graffiti.draw.shape.physics;

import android.graphics.Canvas;
import com.xueersi.lib.graffiti.draw.DrawableObject;

public class PhysicsAmmeter extends PhysicsCenterCircle {
    /* access modifiers changed from: package-private */
    public void drawText(Canvas canvas, float f, float f2, float f3, float f4) {
        float f5 = f + this.mCirclePadding;
        Canvas canvas2 = canvas;
        float f6 = f5;
        canvas2.drawLine((float) this.mCenterX, ((float) this.mCenterY) - this.mCirclePadding, f6, f4 - this.mCirclePadding, this.mPaint);
        canvas2.drawLine((float) this.mCenterX, ((float) this.mCenterY) - this.mCirclePadding, f3 - this.mCirclePadding, f4 - this.mCirclePadding, this.mPaint);
        float f7 = (((float) this.mCenterX) - f5) / 2.0f;
        canvas2.drawLine(((float) this.mCenterX) - f7, (float) this.mCenterY, ((float) this.mCenterX) + f7, (float) this.mCenterY, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new PhysicsAmmeter();
        }
    }
}
