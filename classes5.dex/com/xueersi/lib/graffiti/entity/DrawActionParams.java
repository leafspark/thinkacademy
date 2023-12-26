package com.xueersi.lib.graffiti.entity;

import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import java.util.ArrayList;
import java.util.List;

public class DrawActionParams {
    private List<WXWBAction> actionList;
    private DrawableObject drawableObject;
    private boolean incrementDraw;
    private WXWBAction lastAction;

    public boolean isIncrementDraw() {
        return this.incrementDraw;
    }

    public void setIncrementDraw(boolean z) {
        this.incrementDraw = z;
    }

    public DrawActionParams(DrawableObject drawableObject2, WXWBAction wXWBAction) {
        this((List<WXWBAction>) null, drawableObject2, wXWBAction);
    }

    public DrawActionParams(List<WXWBAction> list, DrawableObject drawableObject2, WXWBAction wXWBAction) {
        if (list != null && list.size() > 0) {
            this.actionList = new ArrayList(list);
        }
        this.drawableObject = drawableObject2;
        this.lastAction = wXWBAction;
        if (wXWBAction != null) {
            boolean z = true;
            if (!(wXWBAction.getPointType() == 0 || wXWBAction.getPointType() == 1 || wXWBAction.getPointType() == 1000)) {
                z = false;
            }
            setIncrementDraw(z);
        }
    }

    public List<WXWBAction> getActionList() {
        return this.actionList;
    }

    public DrawableObject getDrawableObject() {
        return this.drawableObject;
    }

    public WXWBAction getLastAction() {
        return this.lastAction;
    }
}
