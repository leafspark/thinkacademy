package com.xueersi.lib.graffiti.process;

import android.os.SystemClock;
import android.util.ArrayMap;
import com.xueersi.lib.graffiti.LocalCanvasSize;
import com.xueersi.lib.graffiti.WXTGraffitiEngine;
import com.xueersi.lib.graffiti.WXTGraffitiEngineImpl;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.core.ActionEvent;
import com.xueersi.lib.graffiti.core.Configuration;
import com.xueersi.lib.graffiti.core.DataServer;
import com.xueersi.lib.graffiti.core.Extension;
import com.xueersi.lib.graffiti.core.RenderServer;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.BaseShape;
import com.xueersi.lib.graffiti.draw.smooth.LaserPointerDrawableObj;
import com.xueersi.lib.graffiti.entity.DrawActionParams;
import com.xueersi.lib.graffiti.entity.RestoreSceneEntity;
import com.xueersi.lib.graffiti.process.HistoryStackManager;
import com.xueersi.lib.graffiti.utils.ListUtil;
import com.xueersi.lib.graffiti.utils.XesLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ActionParser {
    Callback callback;
    DrawableOBJFactory drawableOBJFactory;
    WXTGraffitiEngineImpl engine;
    private final Map<Integer, ExtensionLoader> extensionLoaderMap = new ArrayMap();
    private final Map<Integer, HistoryStackManager> graffitiGraphicManagerMap = new ArrayMap();
    private final List<WXWBAction> historyData = new ArrayList();
    LaserPointerDrawableObj laserPointerDrawableObject;
    private final LocalCanvasSize localCanvasSize = LocalCanvasSize.sdkInner();
    private long mLastExecuteTime = -1;
    private final Map<Integer, HistoryStackManager> shapeGraphicManagerMap = new ArrayMap();
    boolean[] tempIsNew = new boolean[1];
    private final List<WXWBAction> tempUnSupportList = new ArrayList();

    public interface Callback extends DrawCallback {
        void onUnSupportActions(List<WXWBAction> list, boolean z);
    }

    public interface DrawCallback {
        public static final int TYPE_CREATE = 1;
        public static final int TYPE_DELETE = 3;
        public static final int TYPE_SUB_CANVAS_CREATE = 20;
        public static final int TYPE_SUB_CANVAS_DELETE = 12;
        public static final int TYPE_SUB_CANVAS_UPDATE = 21;
        public static final int TYPE_UPDATE = 2;

        void onCanvasClear(int i);

        void onGraffitiReset(Map<Integer, List<DrawActionParams>> map);

        void onGraffitiUpdate(DrawActionParams drawActionParams);

        void onRestoreScene(RestoreSceneEntity restoreSceneEntity);

        void onShapeUpdate(DrawActionParams drawActionParams, int i);

        void onShapeUpdate(List<DrawActionParams> list, int i);

        void onSubCanvasUpdate(WXWBAction wXWBAction, int i);

        void onTempDraw(DrawActionParams drawActionParams);
    }

    public void addAction(WXWBAction wXWBAction) {
        this.tempUnSupportList.clear();
        this.historyData.add(wXWBAction);
        onAddAction(wXWBAction, this.callback, this.tempUnSupportList, (Map<Integer, WXWBAction>) null);
    }

    public void addAction(List<WXWBAction> list, boolean z) {
        Callback callback2;
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean isEmpty = ListUtil.isEmpty(this.historyData);
        this.historyData.addAll(list);
        XesLog.d("批量加载指令集合开始 restoreScene:" + isEmpty + " Thread:" + Thread.currentThread().getName());
        this.tempUnSupportList.clear();
        ArrayMap arrayMap = isEmpty ? new ArrayMap() : null;
        for (WXWBAction next : list) {
            if (next != null) {
                if (isEmpty) {
                    callback2 = null;
                } else {
                    callback2 = this.callback;
                }
                onAddAction(next, callback2, z ? null : this.tempUnSupportList, arrayMap);
            }
        }
        if (isEmpty && this.callback != null) {
            this.callback.onRestoreScene(new RestoreSceneEntity(arrayMap, getAllDrawableRecord(this.graffitiGraphicManagerMap), getAllDrawableRecord(this.shapeGraphicManagerMap)));
            if (!z && this.tempUnSupportList.size() > 0) {
                this.callback.onUnSupportActions(new ArrayList(this.tempUnSupportList), true);
            }
            if (!z) {
                notifyExtensionNotification(ActionEvent.Notification.SYNC_RENDER);
            }
        }
        XesLog.d("批量加载指令集合结束：个数：" + ListUtil.size(list) + " 耗时:" + (SystemClock.uptimeMillis() - uptimeMillis));
    }

    public void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    public void setEngine(WXTGraffitiEngineImpl wXTGraffitiEngineImpl) {
        this.engine = wXTGraffitiEngineImpl;
        this.drawableOBJFactory = wXTGraffitiEngineImpl.getDrawableOBJFactory();
    }

    /* JADX WARNING: Removed duplicated region for block: B:232:0x04e4  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x04f9  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x04fe  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0503  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onAddAction(com.xueersi.lib.graffiti.WXWBAction r12, com.xueersi.lib.graffiti.process.ActionParser.Callback r13, java.util.List<com.xueersi.lib.graffiti.WXWBAction> r14, java.util.Map<java.lang.Integer, com.xueersi.lib.graffiti.WXWBAction> r15) {
        /*
            r11 = this;
            int r0 = r12.getMessageType()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 0
            if (r0 != 0) goto L_0x00a6
            int r15 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r15 = r11.getGraffitiHistoryStack(r15)
            com.xueersi.lib.graffiti.process.HistoryStackManager$Entry r15 = r15.recover(r12)
            if (r15 == 0) goto L_0x0055
            boolean r0 = r15.isGraphics()
            if (r0 == 0) goto L_0x002c
            com.xueersi.lib.graffiti.process.HistoryStackManager$LineIndexRecord r15 = r15.actionRecord
            if (r13 == 0) goto L_0x0056
            if (r15 == 0) goto L_0x0056
            com.xueersi.lib.graffiti.entity.DrawActionParams r0 = r15.toDrawEntity()
            r13.onGraffitiUpdate(r0)
            goto L_0x0056
        L_0x002c:
            boolean r0 = r15.isClear()
            if (r0 == 0) goto L_0x0038
            if (r13 == 0) goto L_0x0055
            r13.onCanvasClear(r4)
            goto L_0x0055
        L_0x0038:
            boolean r0 = r15.isDelete()
            if (r0 == 0) goto L_0x0042
            r11.executeGraffitiReset(r12, r13)
            goto L_0x0055
        L_0x0042:
            boolean r0 = r15.isLassoMove()
            if (r0 == 0) goto L_0x004c
            r11.executeGraffitiReset(r12, r13)
            goto L_0x0055
        L_0x004c:
            boolean r15 = r15.isLassoDelete()
            if (r15 == 0) goto L_0x0055
            r11.executeGraffitiReset(r12, r13)
        L_0x0055:
            r15 = r1
        L_0x0056:
            int r0 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r0 = r11.getShapeHistoryStack(r0)
            com.xueersi.lib.graffiti.process.HistoryStackManager$Entry r0 = r0.getRecord(r12)
            if (r0 == 0) goto L_0x055e
            int r5 = r0.action
            int r6 = com.xueersi.lib.graffiti.process.HistoryStackManager.Entry.ACTION_LASSO_MOVE
            if (r5 != r6) goto L_0x0086
            int r2 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r2 = r11.getShapeHistoryStack(r2)
            r2.recover(r12)
            java.util.HashMap<com.xueersi.lib.graffiti.process.HistoryStackManager$LineIndexRecord, java.util.List<com.xueersi.lib.graffiti.WXWBAction$Offset>> r0 = r0.lassoData
            java.util.List r0 = r11.getMoveLineIndexRecordFromEntry(r0)
            boolean r2 = com.xueersi.lib.graffiti.utils.ListUtil.isEmpty(r0)
            if (r2 != 0) goto L_0x055e
            r11.executeShapeUpdate(r0, r3, r13)
            goto L_0x055e
        L_0x0086:
            int r3 = r0.action
            int r5 = com.xueersi.lib.graffiti.process.HistoryStackManager.Entry.ACTION_LASSO_DELETE
            if (r3 != r5) goto L_0x055e
            int r3 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r3 = r11.getShapeHistoryStack(r3)
            r3.recover(r12)
            java.util.List r0 = r11.getDeleteLineIndexRecordFromEntry(r0)
            boolean r3 = com.xueersi.lib.graffiti.utils.ListUtil.isEmpty(r0)
            if (r3 != 0) goto L_0x055e
            r11.executeShapeUpdate(r0, r2, r13)
            goto L_0x055e
        L_0x00a6:
            int r0 = r12.getMessageType()
            r5 = 1
            if (r0 != r5) goto L_0x016e
            int r15 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r15 = r11.getGraffitiHistoryStack(r15)
            com.xueersi.lib.graffiti.process.HistoryStackManager$Entry r15 = r15.cancel(r12)
            if (r15 == 0) goto L_0x00be
            r11.executeGraffitiReset(r12, r13)
        L_0x00be:
            int r15 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r15 = r11.getShapeHistoryStack(r15)
            com.xueersi.lib.graffiti.process.HistoryStackManager$Entry r15 = r15.getRecord(r12)
            if (r15 == 0) goto L_0x055a
            int r0 = r15.action
            int r2 = com.xueersi.lib.graffiti.process.HistoryStackManager.Entry.ACTION_LASSO_MOVE
            if (r0 != r2) goto L_0x00ee
            int r0 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r0 = r11.getShapeHistoryStack(r0)
            r0.cancel(r12)
            java.util.HashMap<com.xueersi.lib.graffiti.process.HistoryStackManager$LineIndexRecord, java.util.List<com.xueersi.lib.graffiti.WXWBAction$Offset>> r15 = r15.lassoData
            java.util.List r15 = r11.getMoveLineIndexRecordFromEntry(r15)
            boolean r0 = com.xueersi.lib.graffiti.utils.ListUtil.isEmpty(r15)
            if (r0 != 0) goto L_0x055a
            r11.executeShapeUpdate(r15, r3, r13)
            goto L_0x055a
        L_0x00ee:
            int r0 = r15.action
            int r2 = com.xueersi.lib.graffiti.process.HistoryStackManager.Entry.ACTION_LASSO_DELETE
            if (r0 != r2) goto L_0x010e
            int r0 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r0 = r11.getShapeHistoryStack(r0)
            r0.cancel(r12)
            java.util.List r15 = r11.getDeleteLineIndexRecordFromEntry(r15)
            boolean r0 = com.xueersi.lib.graffiti.utils.ListUtil.isEmpty(r15)
            if (r0 != 0) goto L_0x055a
            r11.executeShapeUpdate(r15, r3, r13)
            goto L_0x055a
        L_0x010e:
            int r15 = r15.action
            int r0 = com.xueersi.lib.graffiti.process.HistoryStackManager.Entry.ACTION_CLEAR
            if (r15 != r0) goto L_0x055a
            int r15 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r15 = r11.getShapeHistoryStack(r15)
            r15.cancel(r12)
            int r15 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r15 = r11.getShapeHistoryStack(r15)
            java.util.List r15 = r15.getGraphicsPainterList()
            if (r13 == 0) goto L_0x055a
            boolean r0 = com.xueersi.lib.graffiti.utils.ListUtil.isNotEmpty(r15)
            if (r0 == 0) goto L_0x055a
            java.util.Iterator r15 = r15.iterator()
        L_0x0137:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x055a
            java.lang.Object r0 = r15.next()
            com.xueersi.lib.graffiti.process.HistoryStackManager$LineIndexRecord r0 = (com.xueersi.lib.graffiti.process.HistoryStackManager.LineIndexRecord) r0
            java.util.List r2 = r0.getActionList()
            boolean r3 = com.xueersi.lib.graffiti.utils.ListUtil.isNotEmpty(r2)
            if (r3 == 0) goto L_0x0137
            java.util.Iterator r2 = r2.iterator()
        L_0x0151:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0137
            java.lang.Object r3 = r2.next()
            com.xueersi.lib.graffiti.WXWBAction r3 = (com.xueersi.lib.graffiti.WXWBAction) r3
            com.xueersi.lib.graffiti.entity.DrawActionParams r5 = new com.xueersi.lib.graffiti.entity.DrawActionParams
            com.xueersi.lib.graffiti.draw.DrawableObject r6 = r0.getDrawableObject()
            r5.<init>(r6, r3)
            int r3 = r3.getMessageType()
            r13.onShapeUpdate((com.xueersi.lib.graffiti.entity.DrawActionParams) r5, (int) r3)
            goto L_0x0151
        L_0x016e:
            int r0 = r12.getMessageType()
            r6 = 5
            r7 = 0
            if (r0 != r6) goto L_0x01d9
            int r15 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r15 = r11.getGraffitiHistoryStack(r15)
            long r2 = r12.getLineIndex()
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x0189
            r0 = r5
            goto L_0x018a
        L_0x0189:
            r0 = r4
        L_0x018a:
            r15.clearAndSave(r12, r0)
            int r15 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r15 = r11.getShapeHistoryStack(r15)
            long r2 = r12.getLineIndex()
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x019e
            goto L_0x019f
        L_0x019e:
            r5 = r4
        L_0x019f:
            r15.clearAndSave(r12, r5)
            if (r13 == 0) goto L_0x01ab
            int r15 = r12.getCanvasId()
            r13.onCanvasClear(r15)
        L_0x01ab:
            long r2 = r12.getLineIndex()
            int r15 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r15 <= 0) goto L_0x01c6
            com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r15 = r11.engine
            com.xueersi.lib.graffiti.img.LoadImageManager r15 = r15.getLoadImageManager()
            if (r15 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r15 = r11.engine
            com.xueersi.lib.graffiti.img.LoadImageManager r15 = r15.getLoadImageManager()
            r15.recycleAll()
            goto L_0x055a
        L_0x01c6:
            com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r15 = r11.engine
            com.xueersi.lib.graffiti.img.LoadImageManager r15 = r15.getLoadImageManager()
            if (r15 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r15 = r11.engine
            com.xueersi.lib.graffiti.img.LoadImageManager r15 = r15.getLoadImageManager()
            r15.clearAll()
            goto L_0x055a
        L_0x01d9:
            int r0 = r12.getMessageType()
            r6 = 4
            if (r0 != r6) goto L_0x022d
            int r15 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r15 = r11.getShapeHistoryStack(r15)
            com.xueersi.lib.graffiti.process.HistoryStackManager$Entry r15 = r15.remove(r12)
            if (r15 == 0) goto L_0x0204
            boolean r0 = r15.isGraphics()
            if (r0 == 0) goto L_0x0204
            if (r13 == 0) goto L_0x0204
            com.xueersi.lib.graffiti.entity.DrawActionParams r0 = new com.xueersi.lib.graffiti.entity.DrawActionParams
            com.xueersi.lib.graffiti.process.HistoryStackManager$LineIndexRecord r3 = r15.actionRecord
            com.xueersi.lib.graffiti.draw.DrawableObject r3 = r3.getDrawableObject()
            r0.<init>(r3, r12)
            r13.onShapeUpdate((com.xueersi.lib.graffiti.entity.DrawActionParams) r0, (int) r2)
        L_0x0204:
            if (r15 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.process.HistoryStackManager$LineIndexRecord r0 = r15.actionRecord
            if (r0 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.process.HistoryStackManager$LineIndexRecord r0 = r15.actionRecord
            com.xueersi.lib.graffiti.draw.DrawableObject r0 = r0.getDrawableObject()
            boolean r0 = r0 instanceof com.xueersi.lib.graffiti.draw.shape.basic.ImageShape
            if (r0 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r0 = r11.engine
            com.xueersi.lib.graffiti.img.LoadImageManager r0 = r0.getLoadImageManager()
            if (r0 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r0 = r11.engine
            com.xueersi.lib.graffiti.img.LoadImageManager r0 = r0.getLoadImageManager()
            com.xueersi.lib.graffiti.process.HistoryStackManager$LineIndexRecord r15 = r15.actionRecord
            com.xueersi.lib.graffiti.WXWBAction r15 = r15.getLastAction()
            r0.clear(r15)
            goto L_0x055a
        L_0x022d:
            int r0 = r12.getMessageType()
            r6 = 7
            if (r0 != r6) goto L_0x0285
            int r15 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r15 = r11.getShapeHistoryStack(r15)
            boolean[] r0 = r11.tempIsNew
            com.xueersi.lib.graffiti.LocalCanvasSize r2 = r11.localCanvasSize
            com.xueersi.lib.graffiti.process.DrawableOBJFactory r3 = r11.drawableOBJFactory
            com.xueersi.lib.graffiti.process.HistoryStackManager$LineIndexRecord r15 = r15.record(r12, r0, r2, r3)
            if (r15 == 0) goto L_0x0257
            if (r13 == 0) goto L_0x0257
            com.xueersi.lib.graffiti.entity.DrawActionParams r0 = new com.xueersi.lib.graffiti.entity.DrawActionParams
            com.xueersi.lib.graffiti.draw.DrawableObject r2 = r15.getDrawableObject()
            r0.<init>(r2, r12)
            r13.onShapeUpdate((com.xueersi.lib.graffiti.entity.DrawActionParams) r0, (int) r5)
            goto L_0x025a
        L_0x0257:
            if (r15 != 0) goto L_0x025a
            r1 = r12
        L_0x025a:
            boolean[] r0 = r11.tempIsNew
            boolean r0 = r0[r4]
            if (r0 == 0) goto L_0x055e
            if (r15 == 0) goto L_0x055e
            com.xueersi.lib.graffiti.draw.DrawableObject r0 = r15.getDrawableObject()
            if (r0 == 0) goto L_0x055e
            com.xueersi.lib.graffiti.draw.DrawableObject r0 = r15.getDrawableObject()
            boolean r0 = r0 instanceof com.xueersi.lib.graffiti.draw.shape.basic.ImageShape
            if (r0 == 0) goto L_0x055e
            com.xueersi.lib.graffiti.draw.DrawableObject r0 = r15.getDrawableObject()
            com.xueersi.lib.graffiti.draw.shape.basic.ImageShape r0 = (com.xueersi.lib.graffiti.draw.shape.basic.ImageShape) r0
            com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r2 = r11.engine
            com.xueersi.lib.graffiti.img.LoadImageManager r2 = r2.getLoadImageManager()
            com.xueersi.lib.graffiti.img.LoadImageManager$Fetcher r2 = r2.getFetcherByAction(r12)
            r0.setImageFetcher(r2)
            goto L_0x055e
        L_0x0285:
            int r0 = r12.getMessageType()
            if (r0 != r3) goto L_0x02d8
            int r15 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r15 = r11.getShapeHistoryStack(r15)
            boolean[] r0 = r11.tempIsNew
            com.xueersi.lib.graffiti.LocalCanvasSize r2 = r11.localCanvasSize
            com.xueersi.lib.graffiti.process.DrawableOBJFactory r5 = r11.drawableOBJFactory
            com.xueersi.lib.graffiti.process.HistoryStackManager$LineIndexRecord r15 = r15.record(r12, r0, r2, r5)
            if (r15 == 0) goto L_0x02ad
            if (r13 == 0) goto L_0x02ad
            com.xueersi.lib.graffiti.entity.DrawActionParams r0 = new com.xueersi.lib.graffiti.entity.DrawActionParams
            com.xueersi.lib.graffiti.draw.DrawableObject r2 = r15.getDrawableObject()
            r0.<init>(r2, r12)
            r13.onShapeUpdate((com.xueersi.lib.graffiti.entity.DrawActionParams) r0, (int) r3)
        L_0x02ad:
            boolean[] r0 = r11.tempIsNew
            boolean r0 = r0[r4]
            if (r0 == 0) goto L_0x055e
            if (r15 == 0) goto L_0x055e
            com.xueersi.lib.graffiti.draw.DrawableObject r0 = r15.getDrawableObject()
            if (r0 == 0) goto L_0x055e
            com.xueersi.lib.graffiti.draw.DrawableObject r0 = r15.getDrawableObject()
            boolean r0 = r0 instanceof com.xueersi.lib.graffiti.draw.shape.basic.ImageShape
            if (r0 == 0) goto L_0x055e
            com.xueersi.lib.graffiti.draw.DrawableObject r0 = r15.getDrawableObject()
            com.xueersi.lib.graffiti.draw.shape.basic.ImageShape r0 = (com.xueersi.lib.graffiti.draw.shape.basic.ImageShape) r0
            com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r2 = r11.engine
            com.xueersi.lib.graffiti.img.LoadImageManager r2 = r2.getLoadImageManager()
            com.xueersi.lib.graffiti.img.LoadImageManager$Fetcher r2 = r2.getFetcherByAction(r12)
            r0.setImageFetcher(r2)
            goto L_0x055e
        L_0x02d8:
            int r0 = r12.getMessageType()
            if (r0 != r2) goto L_0x033b
            int r15 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r15 = r11.getGraffitiHistoryStack(r15)
            boolean[] r0 = r11.tempIsNew
            com.xueersi.lib.graffiti.LocalCanvasSize r2 = r11.localCanvasSize
            com.xueersi.lib.graffiti.process.DrawableOBJFactory r3 = r11.drawableOBJFactory
            com.xueersi.lib.graffiti.process.HistoryStackManager$LineIndexRecord r15 = r15.record(r12, r0, r2, r3)
            if (r15 == 0) goto L_0x0301
            if (r13 == 0) goto L_0x0301
            com.xueersi.lib.graffiti.entity.DrawActionParams r0 = new com.xueersi.lib.graffiti.entity.DrawActionParams
            com.xueersi.lib.graffiti.draw.DrawableObject r2 = r15.getDrawableObject()
            r0.<init>(r2, r12)
            r13.onGraffitiUpdate(r0)
            goto L_0x0304
        L_0x0301:
            if (r15 != 0) goto L_0x0304
            r1 = r12
        L_0x0304:
            java.lang.String r0 = r12.getUid()
            com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r2 = r11.engine
            java.lang.String r2 = r2.getTeacherId()
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L_0x031a
            int r0 = r12.getPointType()
            if (r0 == 0) goto L_0x0320
        L_0x031a:
            int r0 = r12.getPointType()
            if (r0 != r5) goto L_0x055e
        L_0x0320:
            if (r13 == 0) goto L_0x055e
            com.xueersi.lib.graffiti.draw.point.PointDrawableObj r0 = new com.xueersi.lib.graffiti.draw.point.PointDrawableObj
            r0.<init>()
            com.xueersi.lib.graffiti.LocalCanvasSize r2 = com.xueersi.lib.graffiti.LocalCanvasSize.sdkInner()
            r0.setLocalCanvasSize(r2)
            r0.setActionData(r12)
            com.xueersi.lib.graffiti.entity.DrawActionParams r2 = new com.xueersi.lib.graffiti.entity.DrawActionParams
            r2.<init>(r0, r12)
            r13.onTempDraw(r2)
            goto L_0x055e
        L_0x033b:
            int r0 = r12.getMessageType()
            r6 = 15
            if (r0 != r6) goto L_0x035b
            if (r13 == 0) goto L_0x034c
            r15 = 20
            r13.onSubCanvasUpdate(r12, r15)
            goto L_0x055a
        L_0x034c:
            if (r15 == 0) goto L_0x055a
            int r0 = r12.getCanvasId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r15.put(r0, r12)
            goto L_0x055a
        L_0x035b:
            int r0 = r12.getMessageType()
            r6 = 14
            r9 = 21
            if (r0 != r6) goto L_0x037b
            if (r13 == 0) goto L_0x036c
            r13.onSubCanvasUpdate(r12, r9)
            goto L_0x055a
        L_0x036c:
            if (r15 == 0) goto L_0x055a
            int r0 = r12.getCanvasId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r15.put(r0, r12)
            goto L_0x055a
        L_0x037b:
            int r0 = r12.getMessageType()
            r6 = 16
            if (r0 != r6) goto L_0x039b
            if (r13 == 0) goto L_0x038c
            r15 = 12
            r13.onSubCanvasUpdate(r12, r15)
            goto L_0x055a
        L_0x038c:
            if (r15 == 0) goto L_0x055a
            int r0 = r12.getCanvasId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r15.remove(r0)
            goto L_0x055a
        L_0x039b:
            int r15 = r12.getMessageType()
            r0 = 10
            if (r15 != r0) goto L_0x0414
            int r15 = r12.getPointType()
            if (r15 != r9) goto L_0x03f2
            if (r13 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.process.DrawableOBJFactory r15 = r11.drawableOBJFactory
            if (r15 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r15 = r11.engine
            if (r15 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.WXTGraffitiEngine$CustomUI r15 = r15.getCustomUI()
            if (r15 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.draw.smooth.LaserPointerDrawableObj r15 = r11.laserPointerDrawableObject
            if (r15 != 0) goto L_0x03d8
            com.xueersi.lib.graffiti.process.DrawableOBJFactory r15 = r11.drawableOBJFactory
            int r0 = r12.getPointType()
            com.xueersi.lib.graffiti.draw.DrawableObject r15 = r15.onFactory(r0)
            com.xueersi.lib.graffiti.draw.smooth.LaserPointerDrawableObj r15 = (com.xueersi.lib.graffiti.draw.smooth.LaserPointerDrawableObj) r15
            r11.laserPointerDrawableObject = r15
            com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r0 = r11.engine
            com.xueersi.lib.graffiti.WXTGraffitiEngine$CustomUI r0 = r0.getCustomUI()
            int r0 = r0.getLaserPointerColor()
            r15.initLaserPointerSetting(r0)
        L_0x03d8:
            com.xueersi.lib.graffiti.draw.smooth.LaserPointerDrawableObj r15 = r11.laserPointerDrawableObject
            if (r15 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.LocalCanvasSize r0 = r11.localCanvasSize
            r15.setLocalCanvasSize(r0)
            com.xueersi.lib.graffiti.draw.smooth.LaserPointerDrawableObj r15 = r11.laserPointerDrawableObject
            r15.setActionData(r12)
            com.xueersi.lib.graffiti.entity.DrawActionParams r15 = new com.xueersi.lib.graffiti.entity.DrawActionParams
            com.xueersi.lib.graffiti.draw.smooth.LaserPointerDrawableObj r0 = r11.laserPointerDrawableObject
            r15.<init>(r0, r12)
            r13.onTempDraw(r15)
            goto L_0x055a
        L_0x03f2:
            if (r13 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.process.DrawableOBJFactory r15 = r11.drawableOBJFactory
            if (r15 == 0) goto L_0x055a
            int r0 = r12.getMessageType()
            com.xueersi.lib.graffiti.draw.DrawableObject r15 = r15.onFactoryByMessageType(r0)
            if (r15 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.LocalCanvasSize r0 = r11.localCanvasSize
            r15.setLocalCanvasSize(r0)
            r15.setActionData(r12)
            com.xueersi.lib.graffiti.entity.DrawActionParams r0 = new com.xueersi.lib.graffiti.entity.DrawActionParams
            r0.<init>(r15, r12)
            r13.onTempDraw(r0)
            goto L_0x055a
        L_0x0414:
            int r15 = r12.getMessageType()
            r0 = 18
            if (r15 != r0) goto L_0x050a
            int r15 = r12.getPointType()
            r0 = 1002(0x3ea, float:1.404E-42)
            if (r15 != r0) goto L_0x0472
            com.xueersi.lib.graffiti.WXWBAction$SelectAreaConfig r15 = r12.getSelectAreaConfig()
            if (r15 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.WXWBAction$SelectAreaConfig r15 = r12.getSelectAreaConfig()
            long[] r15 = r15.getLineIndexs()
            if (r15 == 0) goto L_0x0445
            int r15 = r15.length
            if (r15 <= 0) goto L_0x0445
            int r15 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r15 = r11.getGraffitiHistoryStack(r15)
            r15.deleteSelectAndSave(r12)
            r11.executeGraffitiReset(r12, r13)
        L_0x0445:
            com.xueersi.lib.graffiti.WXWBAction$SelectAreaConfig r15 = r12.getSelectAreaConfig()
            long[] r15 = r15.getShapeIndexs()
            if (r15 == 0) goto L_0x055a
            int r0 = r15.length
            if (r0 <= 0) goto L_0x055a
            java.lang.String r0 = r12.getUid()
            int r3 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r3 = r11.getShapeHistoryStack(r3)
            java.util.List r15 = r11.getDeleteLineIndexRecord(r0, r15, r3)
            int r0 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r0 = r11.getShapeHistoryStack(r0)
            r0.shapeDeleteSelectAndSave(r12)
            r11.executeShapeUpdate(r15, r2, r13)
            goto L_0x055a
        L_0x0472:
            int r15 = r12.getPointType()
            r0 = 1001(0x3e9, float:1.403E-42)
            if (r15 != r0) goto L_0x055a
            long r9 = r12.getLineIndex()
            int r15 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r15 <= 0) goto L_0x055a
            com.xueersi.lib.graffiti.WXWBAction$SelectAreaConfig r15 = r12.getSelectAreaConfig()
            if (r15 == 0) goto L_0x055a
            com.xueersi.lib.graffiti.WXWBAction$SelectAreaConfig r15 = r12.getSelectAreaConfig()
            java.util.Map r15 = r15.getLineOffsetMap()
            boolean r0 = r11.canExecuteGraffitiAndShape()
            if (r0 != 0) goto L_0x049f
            boolean r0 = com.xueersi.lib.graffiti.utils.PointDataUtils.existActionEndPoint(r12)
            if (r0 == 0) goto L_0x049d
            goto L_0x049f
        L_0x049d:
            r0 = r4
            goto L_0x04a0
        L_0x049f:
            r0 = r5
        L_0x04a0:
            if (r15 == 0) goto L_0x04c6
            boolean r2 = r15.isEmpty()
            if (r2 != 0) goto L_0x04c6
            int r2 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r2 = r11.getGraffitiHistoryStack(r2)
            r2.lassoMove(r12, r15)
            if (r0 == 0) goto L_0x04c6
            java.lang.String r2 = r12.getUid()
            int r6 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r6 = r11.getGraffitiHistoryStack(r6)
            r11.updateOffsetWhenLassoMove(r15, r2, r6)
            r15 = r5
            goto L_0x04c7
        L_0x04c6:
            r15 = r4
        L_0x04c7:
            com.xueersi.lib.graffiti.WXWBAction$SelectAreaConfig r2 = r12.getSelectAreaConfig()
            java.util.Map r2 = r2.getLayerOffsetMap()
            if (r2 == 0) goto L_0x04f5
            boolean r6 = r2.isEmpty()
            if (r6 != 0) goto L_0x04f5
            int r6 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r6 = r11.getShapeHistoryStack(r6)
            r6.lassoMove(r12, r2)
            if (r0 == 0) goto L_0x04f5
            java.lang.String r6 = r12.getUid()
            int r7 = r12.getCanvasId()
            com.xueersi.lib.graffiti.process.HistoryStackManager r7 = r11.getShapeHistoryStack(r7)
            java.util.List r2 = r11.updateOffsetWhenLassoMove(r2, r6, r7)
            goto L_0x04f7
        L_0x04f5:
            r2 = r1
            r5 = r4
        L_0x04f7:
            if (r15 == 0) goto L_0x04fc
            r11.executeGraffitiReset(r12, r13)
        L_0x04fc:
            if (r5 == 0) goto L_0x0501
            r11.executeShapeUpdate(r2, r3, r13)
        L_0x0501:
            if (r0 == 0) goto L_0x055a
            long r2 = java.lang.System.currentTimeMillis()
            r11.mLastExecuteTime = r2
            goto L_0x055a
        L_0x050a:
            com.xueersi.lib.graffiti.core.Extension r15 = r11.getExtension(r12)
            if (r15 == 0) goto L_0x055c
            boolean r0 = com.xueersi.lib.graffiti.utils.XesLog.isEnabled()
            if (r0 == 0) goto L_0x0532
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "数据解析命中扩展:"
            r0.append(r2)
            java.lang.Class r2 = r15.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.xueersi.lib.graffiti.utils.XesLog.i(r0)
        L_0x0532:
            if (r13 == 0) goto L_0x0535
            goto L_0x0536
        L_0x0535:
            r5 = r4
        L_0x0536:
            com.xueersi.lib.graffiti.core.ActionEvent r0 = com.xueersi.lib.graffiti.core.ActionEvent.newSignalEvent(r12, r5)     // Catch:{ Exception -> 0x053e }
            r15.actionPerformed(r0)     // Catch:{ Exception -> 0x053e }
            goto L_0x055a
        L_0x053e:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "扩展内部发生异常:"
            r2.append(r3)
            java.lang.Class r15 = r15.getClass()
            r2.append(r15)
            java.lang.String r15 = r2.toString()
            com.xueersi.lib.graffiti.utils.XesLog.e(r15, r0)
            r0.printStackTrace()
        L_0x055a:
            r15 = r1
            goto L_0x055e
        L_0x055c:
            r15 = r1
            r1 = r12
        L_0x055e:
            if (r1 == 0) goto L_0x056f
            if (r14 == 0) goto L_0x056f
            r14.add(r1)
            if (r13 == 0) goto L_0x056f
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r14)
            r13.onUnSupportActions(r0, r4)
        L_0x056f:
            if (r15 == 0) goto L_0x057e
            com.xueersi.lib.graffiti.draw.DrawableObject r13 = r15.getDrawableObject()
            if (r13 == 0) goto L_0x057e
            com.xueersi.lib.graffiti.draw.DrawableObject r13 = r15.getDrawableObject()
            r13.setActionData(r12)
        L_0x057e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xueersi.lib.graffiti.process.ActionParser.onAddAction(com.xueersi.lib.graffiti.WXWBAction, com.xueersi.lib.graffiti.process.ActionParser$Callback, java.util.List, java.util.Map):void");
    }

    private void setShapeCursorDrawable(DrawActionParams drawActionParams) {
        WXTGraffitiEngine.CustomUI.DrawableDesc shapeCursorDrawable;
        if (drawActionParams != null) {
            DrawableObject drawableObject = drawActionParams.getDrawableObject();
            if ((drawableObject instanceof BaseShape) && (shapeCursorDrawable = this.engine.getCustomUI().getShapeCursorDrawable()) != null && shapeCursorDrawable.drawable != null && !shapeCursorDrawable.drawable.getBounds().isEmpty()) {
                ((BaseShape) drawableObject).setCursorDrawable(shapeCursorDrawable.drawable);
            }
        }
    }

    public HistoryStackManager getGraffitiHistoryStack(int i) {
        HistoryStackManager historyStackManager = this.graffitiGraphicManagerMap.get(Integer.valueOf(i));
        if (historyStackManager != null) {
            return historyStackManager;
        }
        HistoryStackManager historyStackManager2 = new HistoryStackManager();
        this.graffitiGraphicManagerMap.put(Integer.valueOf(i), historyStackManager2);
        return historyStackManager2;
    }

    private HistoryStackManager getShapeHistoryStack(int i) {
        HistoryStackManager historyStackManager = this.shapeGraphicManagerMap.get(Integer.valueOf(i));
        if (historyStackManager != null) {
            return historyStackManager;
        }
        HistoryStackManager historyStackManager2 = new HistoryStackManager();
        this.shapeGraphicManagerMap.put(Integer.valueOf(i), historyStackManager2);
        return historyStackManager2;
    }

    private void clearGraphicManagerMap(Map<Integer, HistoryStackManager> map) {
        if (map != null && map.size() > 0) {
            for (Map.Entry<Integer, HistoryStackManager> value : map.entrySet()) {
                HistoryStackManager historyStackManager = (HistoryStackManager) value.getValue();
                if (historyStackManager != null) {
                    historyStackManager.clear();
                }
            }
        }
    }

    private Map<Integer, List<DrawActionParams>> getAllDrawableRecord(Map<Integer, HistoryStackManager> map) {
        List<HistoryStackManager.LineIndexRecord> graphicsPainterList;
        ArrayMap arrayMap = new ArrayMap();
        if (map != null && map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                HistoryStackManager historyStackManager = (HistoryStackManager) next.getValue();
                if (!(historyStackManager == null || (graphicsPainterList = historyStackManager.getGraphicsPainterList()) == null || graphicsPainterList.size() <= 0)) {
                    ArrayList arrayList = new ArrayList();
                    for (HistoryStackManager.LineIndexRecord next2 : graphicsPainterList) {
                        if (next2 != null) {
                            arrayList.add(next2.toDrawEntity());
                        }
                    }
                    arrayMap.put(next.getKey(), arrayList);
                }
            }
        }
        return arrayMap;
    }

    public Extension getExtension(WXWBAction wXWBAction) {
        int canvasId = wXWBAction.getCanvasId();
        if (canvasId > 0) {
            return null;
        }
        ExtensionLoader extensionLoader = this.extensionLoaderMap.get(Integer.valueOf(canvasId));
        if (extensionLoader == null) {
            extensionLoader = new ExtensionLoader(this.engine);
            extensionLoader.init((RenderServer) this.engine.getEngineView(), (DataServer) null, (Configuration) null);
            this.extensionLoaderMap.put(Integer.valueOf(canvasId), extensionLoader);
        }
        return extensionLoader.load(wXWBAction);
    }

    public Map<Integer, ExtensionLoader> getExtensionLoaderMap() {
        return this.extensionLoaderMap;
    }

    public void clear() {
        if (XesLog.isEnabled()) {
            XesLog.d("指令全部清除");
        }
        this.historyData.clear();
        clearGraphicManagerMap(this.graffitiGraphicManagerMap);
        clearGraphicManagerMap(this.shapeGraphicManagerMap);
        this.tempUnSupportList.clear();
    }

    public void clearAndTurnPage() {
        clear();
        notifyExtensionNotification(ActionEvent.Notification.TURN_PAGE);
    }

    private void notifyExtensionNotification(ActionEvent.Notification notification) {
        List<Extension> allExtensions;
        Map<Integer, ExtensionLoader> map = this.extensionLoaderMap;
        if (map != null && map.size() > 0) {
            for (Map.Entry<Integer, ExtensionLoader> value : this.extensionLoaderMap.entrySet()) {
                ExtensionLoader extensionLoader = (ExtensionLoader) value.getValue();
                if (!(extensionLoader == null || (allExtensions = extensionLoader.getAllExtensions()) == null)) {
                    for (Extension actionPerformed : allExtensions) {
                        actionPerformed.actionPerformed(ActionEvent.newNotificationEvent(notification));
                    }
                }
            }
        }
    }

    private List<HistoryStackManager.LineIndexRecord> getDeleteLineIndexRecord(String str, long[] jArr, HistoryStackManager historyStackManager) {
        ArrayList arrayList = null;
        if (!(jArr == null || jArr.length == 0)) {
            LinkedHashMap<String, HistoryStackManager.Entry> historyGraphics = historyStackManager.getHistoryGraphics();
            if (historyGraphics == null) {
                return null;
            }
            arrayList = new ArrayList();
            for (long j : jArr) {
                HistoryStackManager.Entry entry = historyGraphics.get((str + "_" + j).intern());
                if (!(entry == null || entry.actionRecord == null)) {
                    arrayList.add(entry.actionRecord);
                }
            }
        }
        return arrayList;
    }

    private List<HistoryStackManager.LineIndexRecord> updateOffsetWhenLassoMove(Map<Long, WXWBAction.Offset> map, String str, HistoryStackManager historyStackManager) {
        ArrayList arrayList = null;
        if (map != null && !map.isEmpty()) {
            LinkedHashMap<String, HistoryStackManager.Entry> historyGraphics = historyStackManager.getHistoryGraphics();
            if (historyGraphics == null) {
                return null;
            }
            arrayList = new ArrayList();
            for (Map.Entry next : map.entrySet()) {
                Long l = (Long) next.getKey();
                if (l != null) {
                    HistoryStackManager.Entry entry = historyGraphics.get((str + "_" + l).intern());
                    if (!(entry == null || entry.actionRecord == null)) {
                        arrayList.add(entry.actionRecord);
                        entry.actionRecord.getDrawableObject().setOffset(((WXWBAction.Offset) next.getValue()).getOffsetX(), ((WXWBAction.Offset) next.getValue()).getOffsetY());
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean canExecuteGraffitiAndShape() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mLastExecuteTime;
        return j == -1 || currentTimeMillis - j > 300;
    }

    private void executeGraffitiReset(WXWBAction wXWBAction, Callback callback2) {
        if (callback2 != null) {
            ArrayMap arrayMap = new ArrayMap();
            List<HistoryStackManager.LineIndexRecord> graphicsPainterList = getGraffitiHistoryStack(wXWBAction.getCanvasId()).getGraphicsPainterList();
            if (ListUtil.isNotEmpty(graphicsPainterList)) {
                ArrayList arrayList = new ArrayList();
                for (HistoryStackManager.LineIndexRecord next : graphicsPainterList) {
                    if (next != null) {
                        arrayList.add(next.toDrawEntity());
                    }
                }
                arrayMap.put(Integer.valueOf(wXWBAction.getCanvasId()), arrayList);
            } else {
                arrayMap.put(Integer.valueOf(wXWBAction.getCanvasId()), new ArrayList());
            }
            callback2.onGraffitiReset(arrayMap);
        }
    }

    private void executeShapeUpdate(List<HistoryStackManager.LineIndexRecord> list, int i, Callback callback2) {
        if (callback2 != null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtil.isEmpty(list)) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    arrayList.add(list.get(i2).toDrawEntity());
                }
            }
            callback2.onShapeUpdate((List<DrawActionParams>) arrayList, i);
        }
    }

    private List<HistoryStackManager.LineIndexRecord> getDeleteLineIndexRecordFromEntry(HistoryStackManager.Entry entry) {
        ArrayList arrayList = new ArrayList();
        if (entry.lassoDeleteShapeData != null && !entry.lassoDeleteShapeData.isEmpty()) {
            Iterator<HistoryStackManager.LineIndexRecord> it = entry.lassoDeleteShapeData.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }

    private List<HistoryStackManager.LineIndexRecord> getMoveLineIndexRecordFromEntry(HashMap<HistoryStackManager.LineIndexRecord, List<WXWBAction.Offset>> hashMap) {
        if (hashMap == null || hashMap.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<HistoryStackManager.LineIndexRecord, List<WXWBAction.Offset>> key : hashMap.entrySet()) {
            arrayList.add(key.getKey());
        }
        return arrayList;
    }
}
