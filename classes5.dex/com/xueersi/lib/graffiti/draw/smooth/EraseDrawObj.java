package com.xueersi.lib.graffiti.draw.smooth;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.xueersi.lib.graffiti.draw.DrawableObject;

public class EraseDrawObj extends SmoothCurveDrawObj {
    public EraseDrawObj() {
        this.mDebugPaint = null;
        if (this.mPaint != null) {
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new EraseDrawObj();
        }
    }
}
