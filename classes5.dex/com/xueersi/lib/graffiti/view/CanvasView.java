package com.xueersi.lib.graffiti.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.xueersi.lib.graffiti.R;
import com.xueersi.lib.graffiti.WXTGraffitiEngineImpl;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.WorkExecutor;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.point.PointDrawableObj;
import com.xueersi.lib.graffiti.draw.smooth.LaserPointerDrawableObj;
import com.xueersi.lib.graffiti.entity.DrawActionParams;
import com.xueersi.lib.graffiti.entity.RestoreSceneEntity;
import com.xueersi.lib.graffiti.utils.ListUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CanvasView extends FrameLayout {
    private WorkExecutor drawingExecutor;
    protected WXTGraffitiEngineImpl engine;
    private BaseAsyncGraffitiView graffitiView;
    protected LayerDrawView realTimeView;
    private LayerDrawView shapeView;
    protected TouchGesture touchGesture;

    public int canvasId() {
        return 0;
    }

    public void deleteSubCanvas(String str, WXWBAction wXWBAction) {
    }

    public void resetGraffiti(String str, Map<Integer, List<DrawActionParams>> map) {
    }

    public void updateSubCanvas(String str, WXWBAction wXWBAction) {
    }

    public CanvasView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setEngine(WXTGraffitiEngineImpl wXTGraffitiEngineImpl) {
        if (wXTGraffitiEngineImpl != null) {
            this.engine = wXTGraffitiEngineImpl;
            this.drawingExecutor = wXTGraffitiEngineImpl.getDrawingExecutorGroup().getExecutorByCanvasId(canvasId());
        }
    }

    public void setDrawingExecutor(WorkExecutor workExecutor) {
        this.drawingExecutor = workExecutor;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeAllViews();
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl = this.engine;
        boolean z = true;
        boolean z2 = wXTGraffitiEngineImpl != null && wXTGraffitiEngineImpl.getSetting().isUseTextureView();
        BaseAsyncGraffitiView create = GraffitiViewFactory.create(getContext(), z2 && isHardwareAccelerated());
        this.graffitiView = create;
        View drawView = create.getDrawView();
        WorkExecutor workExecutor = this.drawingExecutor;
        if (workExecutor != null) {
            this.graffitiView.setDrawingExecutor(workExecutor);
        }
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl2 = this.engine;
        if (wXTGraffitiEngineImpl2 != null) {
            BaseAsyncGraffitiView baseAsyncGraffitiView = this.graffitiView;
            if (!wXTGraffitiEngineImpl2.getSetting().isKeepFps() || z2) {
                z = false;
            }
            baseAsyncGraffitiView.setKeepFps(z);
        }
        drawView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(drawView, Layer.GRAFFITI);
    }

    public void setTouchGesture(TouchGesture touchGesture2) {
        this.touchGesture = touchGesture2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        TouchGesture touchGesture2 = this.touchGesture;
        if (touchGesture2 != null) {
            return touchGesture2.onTouchEvent(canvasId(), this, motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    private void checkShapeViewAdd() {
        if (this.shapeView == null) {
            LayerDrawView layerDrawView = new LayerDrawView(getContext(), new RealTimeDrawLayer());
            this.shapeView = layerDrawView;
            layerDrawView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.shapeView, Layer.SHAPE);
        }
    }

    private void checkRealTimeViewAdd() {
        if (this.realTimeView == null) {
            LayerDrawView layerDrawView = new LayerDrawView(getContext(), (BaseDrawLayer) null);
            this.realTimeView = layerDrawView;
            layerDrawView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.realTimeView, Layer.REALTIME);
        }
    }

    public void clearAll() {
        clear("");
    }

    public void clear(String str) {
        BaseAsyncGraffitiView baseAsyncGraffitiView = this.graffitiView;
        if (baseAsyncGraffitiView != null) {
            baseAsyncGraffitiView.clear();
        }
        LayerDrawView layerDrawView = this.shapeView;
        if (layerDrawView != null) {
            layerDrawView.removeAll();
        }
        LayerDrawView layerDrawView2 = this.realTimeView;
        if (layerDrawView2 != null) {
            layerDrawView2.invalidate();
        }
    }

    public void clearCanvas(int i) {
        clear("");
    }

    public void updateGraffiti(String str, int i, DrawActionParams drawActionParams) {
        BaseAsyncGraffitiView baseAsyncGraffitiView = this.graffitiView;
        if (baseAsyncGraffitiView != null) {
            baseAsyncGraffitiView.addAction(drawActionParams);
        }
    }

    public void clearGraffiti(String str) {
        BaseAsyncGraffitiView baseAsyncGraffitiView = this.graffitiView;
        if (baseAsyncGraffitiView != null) {
            baseAsyncGraffitiView.clear();
        }
    }

    public void clearGraffiti(String str, int i) {
        BaseAsyncGraffitiView baseAsyncGraffitiView = this.graffitiView;
        if (baseAsyncGraffitiView != null && i == 0) {
            baseAsyncGraffitiView.clear();
        }
    }

    public void deleteShape(String str, int i, DrawActionParams drawActionParams) {
        if (drawActionParams != null && drawActionParams.getDrawableObject() != null) {
            checkShapeViewAdd();
            this.shapeView.remove(drawActionParams.getDrawableObject());
        }
    }

    public void deleteShape(String str, List<DrawActionParams> list) {
        if (list != null && !list.isEmpty()) {
            checkShapeViewAdd();
            this.shapeView.remove(getDrawObjectFromDrawActionParams(list));
        }
    }

    public void updateShape(String str, int i, DrawActionParams drawActionParams) {
        if (drawActionParams != null && drawActionParams.getDrawableObject() != null) {
            checkShapeViewAdd();
            this.shapeView.update(drawActionParams.getDrawableObject());
        }
    }

    public void updateShape(String str, List<DrawActionParams> list) {
        if (list != null && !list.isEmpty()) {
            checkShapeViewAdd();
            this.shapeView.update(getDrawObjectFromDrawActionParams(list));
        }
    }

    private List<DrawableObject> getDrawObjectFromDrawActionParams(List<DrawActionParams> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            DrawActionParams drawActionParams = list.get(i);
            if (!(drawActionParams == null || drawActionParams.getDrawableObject() == null)) {
                arrayList.add(drawActionParams.getDrawableObject());
            }
        }
        return arrayList;
    }

    public void resetAllGraphics(String str, List<DrawActionParams> list, List<DrawActionParams> list2) {
        if (this.graffitiView != null && ListUtil.isNotEmpty(list)) {
            this.graffitiView.resetActions(list);
        }
        if (ListUtil.isNotEmpty(list2)) {
            checkShapeViewAdd();
            this.shapeView.removeAll();
            ArrayList arrayList = new ArrayList();
            for (DrawActionParams next : list2) {
                if (!(next == null || next.getDrawableObject() == null)) {
                    arrayList.add(next.getDrawableObject());
                }
            }
            this.shapeView.addAll(arrayList);
        }
    }

    public void restoreScene(String str, RestoreSceneEntity restoreSceneEntity) {
        if (restoreSceneEntity != null) {
            if (!(this.graffitiView == null || restoreSceneEntity.getGraffitiMap() == null)) {
                this.graffitiView.resetActions(restoreSceneEntity.getGraffitiMap().get(0));
            }
            if (restoreSceneEntity.getShapeMap() != null && ListUtil.isNotEmpty(restoreSceneEntity.getShapeMap().get(0))) {
                checkShapeViewAdd();
                resetAllGraphics(str, (List<DrawActionParams>) null, restoreSceneEntity.getShapeMap().get(0));
            }
            LayerDrawView layerDrawView = this.realTimeView;
            if (layerDrawView != null) {
                layerDrawView.invalidate();
            }
        }
    }

    public void addView(View view) {
        super.addView(view);
    }

    protected enum Layer {
        SHAPE(1),
        GRAFFITI(2),
        REALTIME(3),
        SUBCANVAS(4),
        GLOBAL_TOP(100);
        
        int level;

        private Layer(int i) {
            this.level = i;
        }
    }

    /* access modifiers changed from: protected */
    public void addView(View view, Layer layer) {
        if (view != null) {
            int childCount = getChildCount();
            if (childCount == 0) {
                addView(view);
            } else {
                int i = 0;
                int i2 = childCount - 1;
                while (true) {
                    if (i2 >= 0) {
                        Integer num = (Integer) getChildAt(i2).getTag(R.id.level_canvas_view_child);
                        if (num != null && layer.level >= num.intValue()) {
                            i = i2 + 1;
                            break;
                        }
                        i2--;
                    } else {
                        break;
                    }
                }
                addView(view, i);
            }
            view.setTag(R.id.level_canvas_view_child, Integer.valueOf(layer.level));
        }
    }

    public void drawTempPoint(String str, DrawActionParams drawActionParams, boolean z) {
        if (drawActionParams != null && drawActionParams.getLastAction() != null) {
            DrawableObject drawableObject = drawActionParams.getDrawableObject();
            if (drawableObject instanceof PointDrawableObj) {
                checkRealTimeViewAdd();
                drawTemp(this.realTimeView, drawableObject);
            } else if (drawableObject instanceof LaserPointerDrawableObj) {
                checkRealTimeViewAdd();
                drawTempLaserPointer(this.realTimeView, (LaserPointerDrawableObj) drawableObject);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawTemp(LayerDrawView layerDrawView, DrawableObject drawableObject) {
        if (layerDrawView != null && drawableObject != null) {
            layerDrawView.setTempDrawableObj(drawableObject);
            layerDrawView.invalidate();
            if (((PointDrawableObj) drawableObject).hasEnd()) {
                layerDrawView.setTempDrawableObj((DrawableObject) null);
                layerDrawView.postInvalidate();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawTempLaserPointer(LayerDrawView layerDrawView, LaserPointerDrawableObj laserPointerDrawableObj) {
        if (layerDrawView != null && laserPointerDrawableObj != null) {
            layerDrawView.setTempDrawableObj(laserPointerDrawableObj);
            layerDrawView.invalidate();
            if (laserPointerDrawableObj.hasEnd()) {
                layerDrawView.setTempDrawableObj((DrawableObject) null);
                layerDrawView.postInvalidate();
            }
        }
    }

    public void invalidateShapeLayer(int i) {
        if (this.shapeView != null && i == canvasId()) {
            this.shapeView.postInvalidate();
        }
    }

    public void destroy() {
        BaseAsyncGraffitiView baseAsyncGraffitiView = this.graffitiView;
        if (baseAsyncGraffitiView != null) {
            baseAsyncGraffitiView.destroy();
        }
    }
}
