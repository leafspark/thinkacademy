package com.xueersi.lib.graffiti.draw.smooth;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.xueersi.lib.graffiti.draw.DrawableObject;

public class EraseDrawObjV2 extends SmoothCurveDrawObjV2 {
    public EraseDrawObjV2() {
        if (this.mPaint != null) {
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new EraseDrawObjV2();
        }
    }

    /* access modifiers changed from: protected */
    public float getLineWidth(float f) {
        return relativePixel(f);
    }
}
