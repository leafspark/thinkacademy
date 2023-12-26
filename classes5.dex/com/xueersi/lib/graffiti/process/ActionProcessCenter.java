package com.xueersi.lib.graffiti.process;

import android.text.TextUtils;
import com.xueersi.lib.graffiti.ActionDispatcher;
import com.xueersi.lib.graffiti.EngineViewInterface;
import com.xueersi.lib.graffiti.LocalCanvasSize;
import com.xueersi.lib.graffiti.WXTGraffitiEngine;
import com.xueersi.lib.graffiti.WXTGraffitiEngineImpl;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.point.PointDrawableObj;
import com.xueersi.lib.graffiti.draw.shape.BaseShape;
import com.xueersi.lib.graffiti.entity.DrawActionParams;
import com.xueersi.lib.graffiti.entity.RestoreSceneEntity;
import com.xueersi.lib.graffiti.process.ActionParser;
import com.xueersi.lib.graffiti.process.HistoryStackManager;
import com.xueersi.lib.graffiti.utils.ListUtil;
import com.xueersi.lib.graffiti.utils.XesLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionProcessCenter implements ActionDispatcher.CallBack {
    private static final Object PRESENT = new Object();
    private final ActionParser actionParser;
    private final Map<String, Object> consumeActions = new HashMap();
    /* access modifiers changed from: private */
    public final WXTGraffitiEngineImpl engine;

    public ActionProcessCenter(WXTGraffitiEngineImpl wXTGraffitiEngineImpl) {
        ActionParser actionParser2 = new ActionParser();
        this.actionParser = actionParser2;
        this.engine = wXTGraffitiEngineImpl;
        actionParser2.setCallback(new ActionParserListener());
        actionParser2.setEngine(wXTGraffitiEngineImpl);
    }

    public void onActionClean() {
        EngineViewInterface engineView = this.engine.getEngineView();
        if (engineView != null) {
            engineView.clear();
        }
        this.actionParser.clear();
        this.consumeActions.clear();
    }

    public void onActionArrived(WXWBAction wXWBAction) {
        if (isCurrentPageActionData(wXWBAction)) {
            String uniqueKey = wXWBAction.getUniqueKey();
            if (!this.consumeActions.containsKey(uniqueKey)) {
                this.consumeActions.put(uniqueKey, PRESENT);
                this.actionParser.addAction(wXWBAction);
            } else if (XesLog.isEnabled()) {
                XesLog.d("指令已经被消费" + uniqueKey);
            }
        } else {
            XesLog.d("消息不属于当前页:msgId" + wXWBAction.getMsgId() + " currentPageKey:" + this.engine.getPageKey() + " msgPageKey:" + wXWBAction.getPageKey());
        }
    }

    public void onActionArrived(List<WXWBAction> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (WXWBAction next : list) {
            if (isCurrentPageActionData(next)) {
                String uniqueKey = next.getUniqueKey();
                if (!this.consumeActions.containsKey(uniqueKey)) {
                    this.consumeActions.put(uniqueKey, PRESENT);
                    arrayList.add(next);
                } else if (XesLog.isEnabled()) {
                    XesLog.d("指令已经被消费:" + uniqueKey);
                }
            } else {
                XesLog.d("消息不属于当前页:msgId" + next.getMsgId() + " currentPageKey:" + this.engine.getPageKey() + " msgPageKey:" + next.getPageKey());
            }
        }
        this.actionParser.addAction(arrayList, z);
    }

    public long getLestCancelLineIndex(int i) {
        HistoryStackManager graffitiHistoryStack;
        HistoryStackManager.Entry leastCancelEntry;
        if (this.engine == null || (graffitiHistoryStack = this.actionParser.getGraffitiHistoryStack(i)) == null || (leastCancelEntry = graffitiHistoryStack.getLeastCancelEntry(getUid())) == null) {
            return -1;
        }
        return leastCancelEntry.lineIndex;
    }

    public long getLestAddLineIndex(int i) {
        HistoryStackManager graffitiHistoryStack;
        HistoryStackManager.Entry leastAddEntry;
        if (this.engine == null || (graffitiHistoryStack = this.actionParser.getGraffitiHistoryStack(i)) == null || (leastAddEntry = graffitiHistoryStack.getLeastAddEntry(getUid())) == null) {
            return -1;
        }
        return leastAddEntry.lineIndex;
    }

    private class ActionParserListener implements ActionParser.Callback {
        public ActionParserListener() {
        }

        private WXTGraffitiEngine.CustomUI.DrawableDesc getPenDrawable(WXWBAction wXWBAction, int i) {
            if (i == 0) {
                return ActionProcessCenter.this.engine.getCustomUI().getPenPointDrawable();
            }
            if (i == 1 || i == 1002) {
                return ActionProcessCenter.this.engine.getCustomUI().getErasePointDrawable();
            }
            if (i == 10) {
                return ActionProcessCenter.this.engine.getCustomUI().getPointDrawable();
            }
            if (i == 21) {
                return ActionProcessCenter.this.engine.getCustomUI().getLaserPointerDrawable();
            }
            if (wXWBAction.getSelectAreaConfig() == null || wXWBAction.getSelectAreaConfig().getLineIndexs() == null) {
                return ActionProcessCenter.this.engine.getCustomUI().getShapeCursorDrawable();
            }
            return ActionProcessCenter.this.engine.getCustomUI().getPointDrawable();
        }

        /* JADX WARNING: Removed duplicated region for block: B:37:0x00c3  */
        /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onTempDraw(com.xueersi.lib.graffiti.entity.DrawActionParams r7) {
            /*
                r6 = this;
                r0 = 0
                if (r7 == 0) goto L_0x00b4
                com.xueersi.lib.graffiti.draw.DrawableObject r1 = r7.getDrawableObject()
                if (r1 == 0) goto L_0x00b4
                com.xueersi.lib.graffiti.WXWBAction r1 = r7.getLastAction()
                if (r1 == 0) goto L_0x00b4
                int r2 = r1.getPointType()
                int r3 = r1.getMessageType()
                r4 = 10
                r5 = 1
                if (r3 != r4) goto L_0x008a
                com.xueersi.lib.graffiti.draw.DrawableObject r3 = r7.getDrawableObject()
                boolean r3 = r3 instanceof com.xueersi.lib.graffiti.draw.point.PointDrawableObj
                if (r3 == 0) goto L_0x004e
                com.xueersi.lib.graffiti.WXTGraffitiEngine$CustomUI$DrawableDesc r1 = r6.getPenDrawable(r1, r2)
                if (r1 == 0) goto L_0x00b4
                android.graphics.drawable.Drawable r2 = r1.drawable
                if (r2 == 0) goto L_0x00b4
                android.graphics.drawable.Drawable r2 = r1.drawable
                android.graphics.Rect r2 = r2.getBounds()
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x00b4
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r5)
                com.xueersi.lib.graffiti.draw.DrawableObject r3 = r7.getDrawableObject()
                com.xueersi.lib.graffiti.draw.point.PointDrawableObj r3 = (com.xueersi.lib.graffiti.draw.point.PointDrawableObj) r3
                android.graphics.drawable.Drawable r4 = r1.drawable
                float r5 = r1.offsetX
                float r1 = r1.offsetY
                r3.setDrawable(r4, r5, r1)
                goto L_0x00b5
            L_0x004e:
                com.xueersi.lib.graffiti.draw.DrawableObject r1 = r7.getDrawableObject()
                boolean r1 = r1 instanceof com.xueersi.lib.graffiti.draw.smooth.LaserPointerDrawableObj
                if (r1 == 0) goto L_0x00b4
                com.xueersi.lib.graffiti.process.ActionProcessCenter r1 = com.xueersi.lib.graffiti.process.ActionProcessCenter.this
                com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r1 = r1.engine
                com.xueersi.lib.graffiti.WXTGraffitiEngine$CustomUI r1 = r1.getCustomUI()
                com.xueersi.lib.graffiti.WXTGraffitiEngine$CustomUI$DrawableDesc r1 = r1.getLaserPointerDrawable()
                if (r1 == 0) goto L_0x00b4
                android.graphics.drawable.Drawable r2 = r1.drawable
                if (r2 == 0) goto L_0x00b4
                android.graphics.drawable.Drawable r2 = r1.drawable
                android.graphics.Rect r2 = r2.getBounds()
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x00b4
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r5)
                com.xueersi.lib.graffiti.draw.DrawableObject r3 = r7.getDrawableObject()
                com.xueersi.lib.graffiti.draw.smooth.LaserPointerDrawableObj r3 = (com.xueersi.lib.graffiti.draw.smooth.LaserPointerDrawableObj) r3
                android.graphics.drawable.Drawable r4 = r1.drawable
                float r5 = r1.offsetX
                float r1 = r1.offsetY
                r3.setDrawable(r4, r5, r1)
                goto L_0x00b5
            L_0x008a:
                com.xueersi.lib.graffiti.WXTGraffitiEngine$CustomUI$DrawableDesc r1 = r6.getPenDrawable(r1, r2)
                if (r1 == 0) goto L_0x00b4
                android.graphics.drawable.Drawable r2 = r1.drawable
                if (r2 == 0) goto L_0x00b4
                android.graphics.drawable.Drawable r2 = r1.drawable
                android.graphics.Rect r2 = r2.getBounds()
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x00b4
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r5)
                com.xueersi.lib.graffiti.draw.DrawableObject r3 = r7.getDrawableObject()
                com.xueersi.lib.graffiti.draw.point.PointDrawableObj r3 = (com.xueersi.lib.graffiti.draw.point.PointDrawableObj) r3
                android.graphics.drawable.Drawable r4 = r1.drawable
                float r5 = r1.offsetX
                float r1 = r1.offsetY
                r3.setDrawable(r4, r5, r1)
                goto L_0x00b5
            L_0x00b4:
                r2 = r0
            L_0x00b5:
                if (r2 == 0) goto L_0x00ca
                com.xueersi.lib.graffiti.process.ActionProcessCenter r1 = com.xueersi.lib.graffiti.process.ActionProcessCenter.this
                com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r1 = r1.engine
                com.xueersi.lib.graffiti.EngineViewInterface r1 = r1.getEngineView()
                if (r1 == 0) goto L_0x00ca
                boolean r2 = r2.booleanValue()
                r1.drawTemp(r0, r7, r2)
            L_0x00ca:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xueersi.lib.graffiti.process.ActionProcessCenter.ActionParserListener.onTempDraw(com.xueersi.lib.graffiti.entity.DrawActionParams):void");
        }

        public void onGraffitiUpdate(DrawActionParams drawActionParams) {
            EngineViewInterface engineView = ActionProcessCenter.this.engine.getEngineView();
            if (engineView != null) {
                engineView.drawGraffiti((String) null, drawActionParams);
            }
            if (drawActionParams.getLastAction() != null && TextUtils.equals(drawActionParams.getLastAction().getUid(), ActionProcessCenter.this.getUid())) {
                ActionProcessCenter.this.updateGraffitiStackState(0);
            }
        }

        public void onGraffitiReset(Map<Integer, List<DrawActionParams>> map) {
            EngineViewInterface engineView = ActionProcessCenter.this.engine.getEngineView();
            if (engineView != null) {
                engineView.resetGraffiti((String) null, map);
            }
            ActionProcessCenter.this.updateGraffitiStackState(0);
        }

        public void onShapeUpdate(DrawActionParams drawActionParams, int i) {
            EngineViewInterface engineView = ActionProcessCenter.this.engine.getEngineView();
            if (engineView != null) {
                engineView.drawShape((String) null, drawActionParams, i);
            }
            PointDrawableObj pointDrawableObj = new PointDrawableObj();
            pointDrawableObj.setLocalCanvasSize(LocalCanvasSize.sdkInner());
            pointDrawableObj.setActionData(drawActionParams.getLastAction());
            onTempDraw(new DrawActionParams(pointDrawableObj, drawActionParams.getLastAction()));
        }

        public void onShapeUpdate(List<DrawActionParams> list, int i) {
            EngineViewInterface engineView = ActionProcessCenter.this.engine.getEngineView();
            if (engineView != null) {
                engineView.drawShape((String) null, list, i);
            }
        }

        private void setShapeCursorDrawable(DrawActionParams drawActionParams) {
            WXTGraffitiEngine.CustomUI.DrawableDesc shapeCursorDrawable;
            if (drawActionParams != null) {
                DrawableObject drawableObject = drawActionParams.getDrawableObject();
                if ((drawableObject instanceof BaseShape) && (shapeCursorDrawable = ActionProcessCenter.this.engine.getCustomUI().getShapeCursorDrawable()) != null && shapeCursorDrawable.drawable != null && !shapeCursorDrawable.drawable.getBounds().isEmpty()) {
                    ((BaseShape) drawableObject).setCursorDrawable(shapeCursorDrawable.drawable);
                }
            }
        }

        public void onCanvasClear(int i) {
            EngineViewInterface engineView = ActionProcessCenter.this.engine.getEngineView();
            if (engineView != null) {
                engineView.clearToCanvas(i);
            }
            ActionProcessCenter.this.updateGraffitiStackState(0);
        }

        public void onRestoreScene(RestoreSceneEntity restoreSceneEntity) {
            EngineViewInterface engineView = ActionProcessCenter.this.engine.getEngineView();
            if (engineView != null) {
                engineView.restoreScene((String) null, restoreSceneEntity);
            }
            ActionProcessCenter.this.updateGraffitiStackState(0);
        }

        public void onUnSupportActions(List<WXWBAction> list, boolean z) {
            WXTGraffitiEngine.Listener listener = ActionProcessCenter.this.engine.getListener();
            if (listener != null && ListUtil.isNotEmpty(list) && ActionProcessCenter.this.isCurrentPageActionData(list.get(0))) {
                listener.onUnSupportActionList(list, z);
            }
        }

        public void onSubCanvasUpdate(WXWBAction wXWBAction, int i) {
            EngineViewInterface engineView = ActionProcessCenter.this.engine.getEngineView();
            if (engineView != null) {
                engineView.updateSubCanvas((String) null, wXWBAction, i);
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateGraffitiStackState(int i) {
        HistoryStackManager graffitiHistoryStack;
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl = this.engine;
        if (wXTGraffitiEngineImpl != null && wXTGraffitiEngineImpl.getSetting().isTouchable() && (graffitiHistoryStack = this.actionParser.getGraffitiHistoryStack(i)) != null) {
            boolean z = true;
            boolean z2 = graffitiHistoryStack.getLeastAddEntry(getUid()) != null;
            if (graffitiHistoryStack.getLeastCancelEntry(getUid()) == null) {
                z = false;
            }
            if (this.engine.getListener() != null) {
                this.engine.getListener().onGraffitiStackUpdate(z2, z);
            }
        }
    }

    /* access modifiers changed from: private */
    public String getUid() {
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl = this.engine;
        return wXTGraffitiEngineImpl != null ? wXTGraffitiEngineImpl.getUid() : "";
    }

    /* access modifiers changed from: package-private */
    public boolean isCurrentPageActionData(WXWBAction wXWBAction) {
        return wXWBAction != null && TextUtils.equals(this.engine.getPageKey(), wXWBAction.getPageKey());
    }

    public void clear() {
        this.actionParser.clearAndTurnPage();
        this.consumeActions.clear();
    }
}
