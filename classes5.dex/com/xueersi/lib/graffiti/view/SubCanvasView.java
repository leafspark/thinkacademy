package com.xueersi.lib.graffiti.view;

import android.content.Context;
import android.util.AttributeSet;
import com.xueersi.lib.graffiti.WXWBAction;

public class SubCanvasView extends CanvasView {
    private WXWBAction.CanvasInfo canvasInfo;

    public void setCanvasInfo(WXWBAction.CanvasInfo canvasInfo2) {
        this.canvasInfo = canvasInfo2;
    }

    public WXWBAction.CanvasInfo getCanvasInfo() {
        return this.canvasInfo;
    }

    public SubCanvasView(Context context) {
        super(context);
    }

    public SubCanvasView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SubCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean needUpdateBackground(WXWBAction.CanvasInfo canvasInfo2) {
        if (canvasInfo2 == null) {
            return false;
        }
        if (this.canvasInfo == null) {
            return true;
        }
        if (canvasInfo2.getFillColor() == this.canvasInfo.getFillColor() && canvasInfo2.getStrokeColor() == this.canvasInfo.getStrokeColor() && canvasInfo2.getLineWidth() == this.canvasInfo.getLineWidth()) {
            return false;
        }
        return true;
    }
}
