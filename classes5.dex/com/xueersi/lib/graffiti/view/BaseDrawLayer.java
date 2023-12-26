package com.xueersi.lib.graffiti.view;

import android.graphics.Canvas;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public abstract class BaseDrawLayer {
    private String TAG = getClass().getSimpleName();
    protected LinkedHashSet<DrawableObject> mDrawingDrawableObjects = new LinkedHashSet<>();

    public abstract void onDraw(Canvas canvas);

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2) {
    }

    public void addDrawableObj(DrawableObject drawableObject) {
        updateDrawableObj(drawableObject);
    }

    public void updateDrawableObj(DrawableObject drawableObject) {
        if (!this.mDrawingDrawableObjects.contains(drawableObject)) {
            this.mDrawingDrawableObjects.add(drawableObject);
        }
    }

    public boolean removeDrawableObj(DrawableObject drawableObject) {
        return this.mDrawingDrawableObjects.remove(drawableObject);
    }

    public void drawAllObjects(Canvas canvas) {
        Iterator it = this.mDrawingDrawableObjects.iterator();
        while (it.hasNext()) {
            ((DrawableObject) it.next()).draw(canvas);
        }
    }

    public void addAllObjects(List<DrawableObject> list) {
        if (list != null) {
            this.mDrawingDrawableObjects.addAll(list);
        }
    }

    public List<DrawableObject> getAllObjects() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.mDrawingDrawableObjects.iterator();
        while (it.hasNext()) {
            arrayList.add((DrawableObject) it.next());
        }
        return arrayList;
    }

    public void removeAllObjects() {
        this.mDrawingDrawableObjects.clear();
    }

    public boolean contains(DrawableObject drawableObject) {
        return this.mDrawingDrawableObjects.contains(drawableObject);
    }

    public int getObjectSize() {
        return this.mDrawingDrawableObjects.size();
    }
}
