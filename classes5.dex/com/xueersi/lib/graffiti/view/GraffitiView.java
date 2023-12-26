package com.xueersi.lib.graffiti.view;

import android.content.Context;
import android.graphics.Paint;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.smooth.EraseDrawObj;
import com.xueersi.lib.graffiti.draw.smooth.SmoothCurveDrawObj;
import com.xueersi.lib.graffiti.utils.DrawUtil;
import com.xueersi.lib.graffiti.utils.XesLog;
import java.util.List;

@Deprecated
public class GraffitiView extends FrameLayout {
    private LayerDrawView bitmapDrawView;
    private boolean canUserSoftwareLayer;
    private LayerDrawView realTimeDrawView;

    public GraffitiView(Context context) {
        super(context);
        LayerDrawView layerDrawView = new LayerDrawView(context, new SyncBitmapDrawLayer());
        this.bitmapDrawView = layerDrawView;
        addView(layerDrawView, new ViewGroup.LayoutParams(-1, -1));
        LayerDrawView layerDrawView2 = new LayerDrawView(context, new RealTimeDrawLayer());
        this.realTimeDrawView = layerDrawView2;
        addView(layerDrawView2, new ViewGroup.LayoutParams(-1, -1));
        this.realTimeDrawView.bringToFront();
    }

    public LayerDrawView getBitmapDrawView() {
        return this.bitmapDrawView;
    }

    public LayerDrawView getRealTimeDrawView() {
        return this.realTimeDrawView;
    }

    private void setRealTimeViewSoftware() {
        if (this.canUserSoftwareLayer && this.realTimeDrawView.getLayerType() != 1) {
            this.realTimeDrawView.setLayerType(1, (Paint) null);
        }
    }

    private void closeRealTimeViewSoftware() {
        if (this.realTimeDrawView.getLayerType() != 0) {
            this.realTimeDrawView.setLayerType(0, (Paint) null);
        }
    }

    public void updateDrawableObj(DrawableObject drawableObject, boolean z) {
        if (drawableObject == null) {
            XesLog.d("graphicsPainter == null");
        } else if (z) {
            if (drawableObject instanceof EraseDrawObj) {
                this.bitmapDrawView.add(drawableObject);
                return;
            }
            setRealTimeViewSoftware();
            moveAllRealTimeToDrew();
            this.realTimeDrawView.add(drawableObject);
        } else if (!(drawableObject instanceof SmoothCurveDrawObj)) {
        } else {
            if (drawableObject instanceof EraseDrawObj) {
                moveAllRealTimeToDrew();
                this.bitmapDrawView.update(drawableObject);
            } else if (((SmoothCurveDrawObj) drawableObject).hasEnd()) {
                this.bitmapDrawView.add(drawableObject);
                this.realTimeDrawView.remove(drawableObject);
                closeRealTimeViewSoftware();
                XesLog.d("线条结束，移到bitmap层");
            } else {
                this.realTimeDrawView.update(drawableObject);
            }
        }
    }

    private void moveAllRealTimeToDrew() {
        List<DrawableObject> all = this.realTimeDrawView.getAll();
        if (all != null && all.size() > 0) {
            this.bitmapDrawView.addAll(all);
            this.realTimeDrawView.removeAll();
        }
    }

    public boolean cancel(DrawableObject drawableObject) {
        if (drawableObject == null) {
            return false;
        }
        moveAllRealTimeToDrew();
        this.bitmapDrawView.remove(drawableObject);
        this.realTimeDrawView.remove(drawableObject);
        return true;
    }

    public boolean recover(DrawableObject drawableObject) {
        if (drawableObject == null) {
            return false;
        }
        moveAllRealTimeToDrew();
        this.bitmapDrawView.add(drawableObject);
        return true;
    }

    public void clear() {
        LayerDrawView layerDrawView = this.bitmapDrawView;
        if (layerDrawView != null) {
            layerDrawView.removeAll();
        }
        LayerDrawView layerDrawView2 = this.realTimeDrawView;
        if (layerDrawView2 != null) {
            layerDrawView2.removeAll();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!DrawUtil.canSoftwareDraw(getContext(), i, i2)) {
            LayerDrawView layerDrawView = this.realTimeDrawView;
            if (layerDrawView != null) {
                layerDrawView.setLayerType(0, (Paint) null);
            }
            this.canUserSoftwareLayer = false;
            return;
        }
        this.canUserSoftwareLayer = true;
    }

    public void resetAll(List<DrawableObject> list) {
        clear();
        this.bitmapDrawView.addAll(list);
    }
}
