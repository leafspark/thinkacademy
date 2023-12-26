package com.xueersi.lib.graffiti.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import java.util.List;

public class LayerDrawView extends View {
    private BaseDrawLayer drawLayer;
    private DrawableObject tempDrawingObject;

    public void setTempDrawableObj(DrawableObject drawableObject) {
        this.tempDrawingObject = drawableObject;
    }

    public LayerDrawView(Context context, BaseDrawLayer baseDrawLayer) {
        super(context);
        this.drawLayer = baseDrawLayer;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        BaseDrawLayer baseDrawLayer = this.drawLayer;
        if (baseDrawLayer != null) {
            baseDrawLayer.onDraw(canvas);
        }
        DrawableObject drawableObject = this.tempDrawingObject;
        if (drawableObject != null) {
            drawableObject.draw(canvas);
            this.tempDrawingObject = null;
        }
    }

    public void removeAll() {
        BaseDrawLayer baseDrawLayer = this.drawLayer;
        if (baseDrawLayer != null) {
            baseDrawLayer.removeAllObjects();
            invalidate();
        }
    }

    public List<DrawableObject> getAll() {
        BaseDrawLayer baseDrawLayer = this.drawLayer;
        if (baseDrawLayer != null) {
            return baseDrawLayer.getAllObjects();
        }
        return null;
    }

    public void remove(DrawableObject drawableObject) {
        BaseDrawLayer baseDrawLayer = this.drawLayer;
        if (baseDrawLayer != null && baseDrawLayer.removeDrawableObj(drawableObject)) {
            invalidate();
        }
    }

    public void remove(List<DrawableObject> list) {
        if (this.drawLayer != null) {
            boolean z = false;
            for (int i = 0; i < list.size(); i++) {
                if (this.drawLayer.removeDrawableObj(list.get(i))) {
                    z = true;
                }
            }
            if (z) {
                invalidate();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        BaseDrawLayer baseDrawLayer = this.drawLayer;
        if (baseDrawLayer != null) {
            baseDrawLayer.onSizeChanged(i, i2);
        }
    }

    public void add(DrawableObject drawableObject) {
        BaseDrawLayer baseDrawLayer = this.drawLayer;
        if (baseDrawLayer != null) {
            baseDrawLayer.addDrawableObj(drawableObject);
            invalidate();
        }
    }

    public void addAll(List<DrawableObject> list) {
        BaseDrawLayer baseDrawLayer = this.drawLayer;
        if (baseDrawLayer != null) {
            baseDrawLayer.addAllObjects(list);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void update(DrawableObject drawableObject) {
        BaseDrawLayer baseDrawLayer = this.drawLayer;
        if (baseDrawLayer != null) {
            baseDrawLayer.updateDrawableObj(drawableObject);
            invalidate();
        }
    }

    public void update(List<DrawableObject> list) {
        if (this.drawLayer != null && list != null) {
            for (int i = 0; i < list.size(); i++) {
                this.drawLayer.updateDrawableObj(list.get(i));
            }
            invalidate();
        }
    }

    public BaseDrawLayer getDrawLayer() {
        return this.drawLayer;
    }
}
