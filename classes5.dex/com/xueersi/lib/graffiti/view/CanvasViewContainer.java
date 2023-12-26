package com.xueersi.lib.graffiti.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.xueersi.lib.graffiti.LocalCanvasSize;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.point.PointDrawableObj;
import com.xueersi.lib.graffiti.draw.smooth.LaserPointerDrawableObj;
import com.xueersi.lib.graffiti.entity.DrawActionParams;
import com.xueersi.lib.graffiti.entity.RestoreSceneEntity;
import com.xueersi.lib.graffiti.utils.ListUtil;
import com.xueersi.lib.graffiti.view.CanvasView;
import java.util.List;
import java.util.Map;

public class CanvasViewContainer extends CanvasView {
    private LayerDrawView globalTopDrawView;
    private Map<Integer, CanvasView> subCanvasViewMap;

    public CanvasViewContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public CanvasViewContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.subCanvasViewMap = new ArrayMap();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    private void checkGlobalTopDrawViewAdd() {
        if (this.globalTopDrawView == null) {
            LayerDrawView layerDrawView = new LayerDrawView(getContext(), new RealTimeDrawLayer());
            this.globalTopDrawView = layerDrawView;
            layerDrawView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.globalTopDrawView, CanvasView.Layer.GLOBAL_TOP);
        }
    }

    private void createOrUpdateSubCanvasView(WXWBAction.CanvasInfo canvasInfo, SubCanvasView subCanvasView) {
        float min = Math.min(canvasInfo.getX(), 1.0f);
        float min2 = Math.min(canvasInfo.getY(), 1.0f);
        float min3 = Math.min(canvasInfo.getWidth(), 1.0f);
        float min4 = Math.min(canvasInfo.getHeight(), 1.0f);
        if (subCanvasView != null) {
            int measuredWidth = (int) (min3 * ((float) getMeasuredWidth()));
            int measuredHeight = (int) (min4 * ((float) getMeasuredHeight()));
            int measuredWidth2 = (int) (((float) getMeasuredWidth()) * min);
            int measuredHeight2 = (int) (((float) getMeasuredHeight()) * min2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) subCanvasView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(measuredWidth, measuredHeight);
                subCanvasView.setLayoutParams(layoutParams);
            }
            if (!(measuredWidth == layoutParams.width && measuredHeight == layoutParams.height)) {
                layoutParams.width = measuredWidth;
                layoutParams.height = measuredHeight;
                subCanvasView.requestLayout();
            }
            float translationX = subCanvasView.getTranslationX();
            float translationY = subCanvasView.getTranslationY();
            float f = (float) measuredWidth2;
            if (!(translationX == f && translationY == ((float) measuredHeight2))) {
                subCanvasView.setTranslationX(f);
                subCanvasView.setTranslationY((float) measuredHeight2);
            }
            if (subCanvasView.needUpdateBackground(canvasInfo)) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setStroke((int) LocalCanvasSize.sdkInner().getValue(canvasInfo.getLineWidth()), canvasInfo.getStrokeColor());
                gradientDrawable.setColor(0);
                subCanvasView.setForeground(gradientDrawable);
                subCanvasView.setBackgroundColor(canvasInfo.getFillColor());
            }
            subCanvasView.setCanvasInfo(canvasInfo);
        }
    }

    private CanvasView getCanvasViewById(final int i, WXWBAction wXWBAction) {
        if (i == 0) {
            return this;
        }
        CanvasView canvasView = this.subCanvasViewMap.get(Integer.valueOf(i));
        if (canvasView != null || wXWBAction == null || wXWBAction.getCanvasInfo() == null) {
            return canvasView;
        }
        AnonymousClass1 r0 = new SubCanvasView(getContext()) {
            public int canvasId() {
                return i;
            }
        };
        r0.setEngine(this.engine);
        r0.setTouchGesture(this.touchGesture);
        this.subCanvasViewMap.put(Integer.valueOf(i), r0);
        createOrUpdateSubCanvasView(wXWBAction.getCanvasInfo(), r0);
        addView(r0, CanvasView.Layer.SUBCANVAS);
        return r0;
    }

    public void clear(String str) {
        super.clear(str);
    }

    public void clearCanvas(int i) {
        if (i == 0) {
            super.clearCanvas(i);
            return;
        }
        CanvasView canvasViewById = getCanvasViewById(i, (WXWBAction) null);
        if (canvasViewById != null) {
            canvasViewById.clearAll();
        }
    }

    public void clearAll() {
        super.clearAll();
        for (Map.Entry<Integer, CanvasView> value : this.subCanvasViewMap.entrySet()) {
            CanvasView canvasView = (CanvasView) value.getValue();
            if (canvasView != null) {
                canvasView.clear("");
                removeView(canvasView);
            }
        }
        this.subCanvasViewMap.clear();
    }

    public void updateGraffiti(String str, int i, DrawActionParams drawActionParams) {
        if (i > 0) {
            CanvasView canvasViewById = getCanvasViewById(i, drawActionParams.getLastAction());
            if (canvasViewById != null) {
                canvasViewById.updateGraffiti(str, i, drawActionParams);
                return;
            }
            return;
        }
        super.updateGraffiti(str, i, drawActionParams);
    }

    public void clearGraffiti(String str, int i) {
        CanvasView canvasViewById;
        super.clearGraffiti(str, i);
        if (i > 0 && (canvasViewById = getCanvasViewById(i, (WXWBAction) null)) != null) {
            canvasViewById.clearGraffiti(str);
        }
    }

    public void deleteShape(String str, int i, DrawActionParams drawActionParams) {
        if (i > 0) {
            CanvasView canvasViewById = getCanvasViewById(i, drawActionParams.getLastAction());
            if (canvasViewById != null) {
                canvasViewById.deleteShape(str, i, drawActionParams);
                return;
            }
            return;
        }
        super.deleteShape(str, i, drawActionParams);
    }

    public void deleteShape(String str, List<DrawActionParams> list) {
        if (!ListUtil.isEmpty(list)) {
            int i = 0;
            DrawActionParams drawActionParams = list.get(0);
            if (drawActionParams != null) {
                i = drawActionParams.getLastAction().getCanvasId();
            }
            if (i > 0) {
                CanvasView canvasViewById = getCanvasViewById(i, drawActionParams.getLastAction());
                if (canvasViewById != null) {
                    canvasViewById.deleteShape(str, list);
                    return;
                }
                return;
            }
            super.deleteShape(str, list);
        }
    }

    public void updateShape(String str, int i, DrawActionParams drawActionParams) {
        if (i > 0) {
            CanvasView canvasViewById = getCanvasViewById(i, drawActionParams.getLastAction());
            if (canvasViewById != null) {
                canvasViewById.updateShape(str, i, drawActionParams);
                return;
            }
            return;
        }
        super.updateShape(str, i, drawActionParams);
    }

    public void updateShape(String str, List<DrawActionParams> list) {
        if (!ListUtil.isEmpty(list)) {
            int i = 0;
            DrawActionParams drawActionParams = list.get(0);
            if (drawActionParams != null) {
                i = drawActionParams.getLastAction().getCanvasId();
            }
            if (i > 0) {
                CanvasView canvasViewById = getCanvasViewById(i, drawActionParams.getLastAction());
                if (canvasViewById != null) {
                    canvasViewById.updateShape(str, list);
                    return;
                }
                return;
            }
            super.updateShape(str, list);
        }
    }

    public void updateSubCanvas(String str, WXWBAction wXWBAction) {
        CanvasView canvasViewById;
        super.updateSubCanvas(str, wXWBAction);
        WXWBAction.CanvasInfo canvasInfo = wXWBAction.getCanvasInfo();
        if (canvasInfo != null && canvasInfo.getCanvasId() > 0 && (canvasViewById = getCanvasViewById(canvasInfo.getCanvasId(), wXWBAction)) != null) {
            createOrUpdateSubCanvasView(wXWBAction.getCanvasInfo(), (SubCanvasView) canvasViewById);
            canvasViewById.setVisibility(0);
        }
    }

    public void deleteSubCanvas(String str, WXWBAction wXWBAction) {
        CanvasView canvasViewById;
        super.deleteSubCanvas(str, wXWBAction);
        if (wXWBAction.getCanvasId() > 0 && (canvasViewById = getCanvasViewById(wXWBAction.getCanvasId(), (WXWBAction) null)) != null) {
            canvasViewById.setVisibility(8);
        }
    }

    public void resetGraffiti(String str, Map<Integer, List<DrawActionParams>> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                List list = (List) next.getValue();
                Integer num = (Integer) next.getKey();
                if (list != null) {
                    if (list.size() > 0) {
                        CanvasView canvasViewById = getCanvasViewById(num.intValue(), ((DrawActionParams) list.get(0)).getLastAction());
                        if (canvasViewById != null) {
                            canvasViewById.resetAllGraphics(str, list, (List<DrawActionParams>) null);
                        }
                    } else {
                        CanvasView canvasViewById2 = getCanvasViewById(num.intValue(), (WXWBAction) null);
                        if (canvasViewById2 != null) {
                            canvasViewById2.clearGraffiti(str);
                        }
                    }
                }
            }
        }
        if (this.realTimeView != null) {
            this.realTimeView.invalidate();
        }
        LayerDrawView layerDrawView = this.globalTopDrawView;
        if (layerDrawView != null) {
            layerDrawView.invalidate();
        }
    }

    public void restoreScene(String str, RestoreSceneEntity restoreSceneEntity) {
        CanvasView canvasViewById;
        CanvasView canvasViewById2;
        if (restoreSceneEntity != null) {
            Map<Integer, WXWBAction> canvasInfoMap = restoreSceneEntity.getCanvasInfoMap();
            if (canvasInfoMap != null) {
                for (Map.Entry next : canvasInfoMap.entrySet()) {
                    if (((Integer) next.getKey()).intValue() > 0) {
                        updateSubCanvas(str, (WXWBAction) next.getValue());
                    }
                }
            }
            Map<Integer, List<DrawActionParams>> graffitiMap = restoreSceneEntity.getGraffitiMap();
            if (graffitiMap != null) {
                for (Map.Entry next2 : graffitiMap.entrySet()) {
                    List list = (List) next2.getValue();
                    Integer num = (Integer) next2.getKey();
                    if (!(list == null || list.size() <= 0 || (canvasViewById2 = getCanvasViewById(num.intValue(), ((DrawActionParams) list.get(0)).getLastAction())) == null)) {
                        canvasViewById2.resetAllGraphics(str, list, (List<DrawActionParams>) null);
                    }
                }
            }
            Map<Integer, List<DrawActionParams>> shapeMap = restoreSceneEntity.getShapeMap();
            if (shapeMap != null) {
                for (Map.Entry next3 : shapeMap.entrySet()) {
                    List list2 = (List) next3.getValue();
                    Integer num2 = (Integer) next3.getKey();
                    if (!(list2 == null || list2.size() <= 0 || (canvasViewById = getCanvasViewById(num2.intValue(), ((DrawActionParams) list2.get(0)).getLastAction())) == null)) {
                        canvasViewById.resetAllGraphics(str, (List<DrawActionParams>) null, list2);
                    }
                }
            }
            if (this.realTimeView != null) {
                this.realTimeView.invalidate();
            }
            LayerDrawView layerDrawView = this.globalTopDrawView;
            if (layerDrawView != null) {
                layerDrawView.invalidate();
            }
        }
    }

    public void drawTempPoint(String str, DrawActionParams drawActionParams, boolean z) {
        if (drawActionParams != null && drawActionParams.getLastAction() != null) {
            int canvasId = drawActionParams.getLastAction().getCanvasId();
            if (z) {
                checkGlobalTopDrawViewAdd();
                if (this.globalTopDrawView == null) {
                    return;
                }
                if (drawActionParams.getDrawableObject() instanceof PointDrawableObj) {
                    drawTemp(this.globalTopDrawView, drawActionParams.getDrawableObject());
                } else if (drawActionParams.getDrawableObject() instanceof LaserPointerDrawableObj) {
                    drawTempLaserPointer(this.globalTopDrawView, (LaserPointerDrawableObj) drawActionParams.getDrawableObject());
                }
            } else if (canvasId == 0) {
                super.drawTempPoint(str, drawActionParams, false);
            } else {
                CanvasView canvasViewById = getCanvasViewById(canvasId, (WXWBAction) null);
                if (canvasViewById != null) {
                    canvasViewById.drawTempPoint(str, drawActionParams, false);
                }
            }
        }
    }

    public void invalidateShapeLayer(int i) {
        CanvasView canvasViewById;
        if (i > 0 && (canvasViewById = getCanvasViewById(i, (WXWBAction) null)) != null) {
            canvasViewById.postInvalidate();
        }
        super.invalidateShapeLayer(i);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void destroy() {
        super.destroy();
        if (!this.subCanvasViewMap.isEmpty()) {
            for (Map.Entry<Integer, CanvasView> value : this.subCanvasViewMap.entrySet()) {
                CanvasView canvasView = (CanvasView) value.getValue();
                if (canvasView != null) {
                    canvasView.destroy();
                }
            }
        }
    }
}
