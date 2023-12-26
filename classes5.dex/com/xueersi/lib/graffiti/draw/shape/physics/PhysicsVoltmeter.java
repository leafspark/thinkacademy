package com.xueersi.lib.graffiti.draw.shape.physics;

import android.graphics.Canvas;
import com.xueersi.lib.graffiti.draw.DrawableObject;

public class PhysicsVoltmeter extends PhysicsCenterCircle {
    /* access modifiers changed from: package-private */
    public void drawText(Canvas canvas, float f, float f2, float f3, float f4) {
        canvas.drawLine(f + this.mCirclePadding, f2 + this.mCirclePadding, (float) this.mCenterX, f4 - this.mCirclePadding, this.mPaint);
        canvas.drawLine(f3 - this.mCirclePadding, f2 + this.mCirclePadding, (float) this.mCenterX, f4 - this.mCirclePadding, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new PhysicsVoltmeter();
        }
    }
}
