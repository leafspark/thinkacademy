package com.xueersi.lib.graffiti.draw.point;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.yalantis.ucrop.view.CropImageView;
import java.util.concurrent.atomic.AtomicBoolean;

public class PointDrawableObj extends DrawableObject {
    private float drawOffsetX;
    private float drawOffsetY;
    private Drawable drawable;
    volatile AtomicBoolean hasEnd = new AtomicBoolean(false);
    private float x = -1.0f;
    private float y = -1.0f;

    public void setDrawable(Drawable drawable2, float f, float f2) {
        this.drawOffsetX = f;
        this.drawOffsetY = f2;
        this.drawable = drawable2;
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
        WXWBAction.PointData cursorPosition;
        if (wXWBAction != null && (cursorPosition = wXWBAction.getCursorPosition()) != null) {
            this.x = relativeX(cursorPosition.getX());
            this.y = relativeY(cursorPosition.getY());
            if (cursorPosition.getPointAction() == 2) {
                this.hasEnd.set(true);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        onDraw(canvas);
    }

    public boolean hasEnd() {
        return this.hasEnd.get();
    }

    public void setActionData(WXWBAction wXWBAction) {
        super.setActionData(wXWBAction);
        updateActionData(wXWBAction);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable2;
        if ((this.x > CropImageView.DEFAULT_ASPECT_RATIO || this.y > CropImageView.DEFAULT_ASPECT_RATIO) && (drawable2 = this.drawable) != null && !drawable2.getBounds().isEmpty()) {
            canvas.save();
            Rect bounds = this.drawable.getBounds();
            canvas.translate(this.x - (((float) bounds.width()) * this.drawOffsetX), this.y - (((float) bounds.height()) * this.drawOffsetY));
            canvas.clipRect(this.drawable.getBounds());
            this.drawable.draw(canvas);
            canvas.restore();
        }
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new PointDrawableObj();
        }
    }
}
