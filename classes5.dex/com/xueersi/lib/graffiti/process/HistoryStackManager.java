package com.xueersi.lib.graffiti.process;

import android.text.TextUtils;
import com.xueersi.lib.graffiti.LocalCanvasSize;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.entity.DrawActionParams;
import com.xueersi.lib.graffiti.utils.ListUtil;
import com.xueersi.lib.graffiti.utils.XesLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HistoryStackManager {
    private final List<Entry> canceledGraphicsList = new ArrayList();
    private List<LineIndexRecord> drawingList = new ArrayList();
    private final List<Entry> graphicsPainterList = new ArrayList();
    private final LinkedHashMap<String, Entry> historyGraphics = new LinkedHashMap<>();

    public static class LineIndexRecord {
        private List<WXWBAction> actionList;
        private final DrawableObject drawableObject;
        private final String key;
        private WXWBAction lastAction;
        private final long lineIndex;
        /* access modifiers changed from: private */
        public final String uid;

        public DrawActionParams toDrawEntity() {
            return new DrawActionParams(this.actionList, this.drawableObject, this.lastAction);
        }

        public LineIndexRecord(String str, String str2, long j, DrawableObject drawableObject2) {
            this.uid = str2;
            this.drawableObject = drawableObject2;
            this.key = str;
            this.lineIndex = j;
        }

        public void addAction(WXWBAction wXWBAction) {
            this.lastAction = wXWBAction;
            if (this.actionList == null) {
                this.actionList = new ArrayList();
            }
            this.actionList.add(wXWBAction);
        }

        public DrawableObject getDrawableObject() {
            return this.drawableObject;
        }

        public String getKey() {
            return this.key;
        }

        public long getLineIndex() {
            return this.lineIndex;
        }

        public List<WXWBAction> getActionList() {
            return this.actionList;
        }

        public WXWBAction getLastAction() {
            return this.lastAction;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return TextUtils.equals(this.key, ((LineIndexRecord) obj).key);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.key});
        }
    }

    public static class Entry {
        static int ACTION_CLEAR = 2;
        static int ACTION_DELETE = 3;
        static int ACTION_GRAPHICS = 1;
        static int ACTION_LASSO_DELETE = 5;
        static int ACTION_LASSO_MOVE = 4;
        public int action = ACTION_GRAPHICS;
        public LineIndexRecord actionRecord;
        public List<LineIndexRecord> drawingList;
        public String key;
        public HashMap<LineIndexRecord, List<WXWBAction.Offset>> lassoData;
        public HashSet<LineIndexRecord> lassoDeleteShapeData;
        public long lineIndex;
        public String uid;

        public boolean isGraphics() {
            return this.action == ACTION_GRAPHICS && this.actionRecord != null;
        }

        public boolean isClear() {
            return this.action == ACTION_CLEAR;
        }

        public boolean isDelete() {
            return this.action == ACTION_DELETE;
        }

        public boolean isLassoMove() {
            return this.action == ACTION_LASSO_MOVE;
        }

        public boolean isLassoDelete() {
            return this.action == ACTION_LASSO_DELETE;
        }
    }

    public static String getActionKey(WXWBAction wXWBAction) {
        if (wXWBAction == null) {
            return null;
        }
        return (wXWBAction.getUid() + "_" + wXWBAction.getLineIndex()).intern();
    }

    public LineIndexRecord record(WXWBAction wXWBAction, boolean[] zArr, LocalCanvasSize localCanvasSize, DrawableOBJFactory drawableOBJFactory) {
        LineIndexRecord lineIndexRecord;
        if (wXWBAction == null) {
            return null;
        }
        String actionKey = getActionKey(wXWBAction);
        Entry entry = this.historyGraphics.get(actionKey);
        if (entry == null) {
            entry = new Entry();
            entry.key = actionKey;
            entry.lineIndex = wXWBAction.getLineIndex();
            entry.uid = wXWBAction.getUid();
            this.historyGraphics.put(actionKey, entry);
            this.graphicsPainterList.add(entry);
            lineIndexRecord = null;
        } else {
            lineIndexRecord = entry.actionRecord;
        }
        Entry entry2 = entry;
        if (lineIndexRecord != null || drawableOBJFactory == null) {
            zArr[0] = false;
        } else {
            DrawableObject onFactory = drawableOBJFactory.onFactory(wXWBAction.getPointType());
            if (onFactory == null) {
                if (XesLog.isEnabled()) {
                    XesLog.d("涂鸦线条类型不支持:" + wXWBAction.toString());
                }
                return null;
            }
            LineIndexRecord lineIndexRecord2 = new LineIndexRecord(actionKey, wXWBAction.getUid(), wXWBAction.getLineIndex(), onFactory);
            entry2.actionRecord = lineIndexRecord2;
            this.drawingList.add(lineIndexRecord2);
            zArr[0] = true;
            onFactory.setLocalCanvasSize(localCanvasSize);
            lineIndexRecord = lineIndexRecord2;
        }
        lineIndexRecord.addAction(wXWBAction);
        return lineIndexRecord;
    }

    public Entry cancelClearAction(WXWBAction wXWBAction) {
        Entry entry;
        if (wXWBAction.getLineIndex() == 0 || (entry = this.historyGraphics.get(getActionKey(wXWBAction))) == null || !entry.isClear()) {
            return null;
        }
        return cancel(wXWBAction);
    }

    public Entry getRecord(WXWBAction wXWBAction) {
        return this.historyGraphics.get(getActionKey(wXWBAction));
    }

    public Entry cancel(WXWBAction wXWBAction) {
        if (wXWBAction.getLineIndex() == 0) {
            XesLog.d("撤回数据异常，默认选最近一条");
            return cancelRecent();
        }
        Entry entry = this.historyGraphics.get(getActionKey(wXWBAction));
        if (entry != null) {
            if (this.graphicsPainterList.remove(entry)) {
                this.canceledGraphicsList.add(entry);
            }
            if (entry.isGraphics()) {
                this.drawingList.remove(entry.actionRecord);
            } else if (entry.isClear()) {
                if (entry.drawingList != null) {
                    this.drawingList.addAll(0, entry.drawingList);
                }
            } else if (entry.isDelete() || entry.isLassoDelete()) {
                if (entry.drawingList != null) {
                    this.drawingList.addAll(entry.drawingList);
                    sortByLineIndex(this.drawingList);
                }
            } else if (entry.isLassoMove()) {
                updateOffsetWhenRecoverOrCancel(entry.lassoData, true);
            }
        }
        return entry;
    }

    private void sortByLineIndex(List<LineIndexRecord> list) {
        if (list != null && list.size() != 0) {
            Collections.sort(list, new Comparator<LineIndexRecord>() {
                public int compare(LineIndexRecord lineIndexRecord, LineIndexRecord lineIndexRecord2) {
                    int i = ((lineIndexRecord.getLineIndex() - lineIndexRecord2.getLineIndex()) > 0 ? 1 : ((lineIndexRecord.getLineIndex() - lineIndexRecord2.getLineIndex()) == 0 ? 0 : -1));
                    if (i > 0) {
                        return 1;
                    }
                    return i < 0 ? -1 : 0;
                }
            });
        }
    }

    public Entry recover(WXWBAction wXWBAction) {
        if (wXWBAction.getLineIndex() == 0) {
            XesLog.d("恢复数据异常，默认恢复最近一条");
            return recoverRecent();
        }
        Entry entry = this.historyGraphics.get(getActionKey(wXWBAction));
        if (entry != null && this.canceledGraphicsList.remove(entry)) {
            this.graphicsPainterList.add(entry);
            if (entry.isGraphics()) {
                this.drawingList.add(entry.actionRecord);
            } else if (entry.isClear()) {
                if (entry.drawingList != null) {
                    entry.drawingList.clear();
                    entry.drawingList.addAll(this.drawingList);
                }
                this.drawingList.clear();
            } else {
                if (entry.isDelete() || entry.isLassoDelete()) {
                    List<LineIndexRecord> list = entry.drawingList;
                    for (int i = 0; i < ListUtil.size(list); i++) {
                        LineIndexRecord lineIndexRecord = list.get(i);
                        if (lineIndexRecord != null) {
                            this.drawingList.remove(lineIndexRecord);
                        }
                    }
                } else if (entry.isLassoMove()) {
                    updateOffsetWhenRecoverOrCancel(entry.lassoData, false);
                }
            }
        }
        return entry;
    }

    private Entry cancelRecent() {
        if (this.graphicsPainterList.size() <= 0) {
            return null;
        }
        List<Entry> list = this.graphicsPainterList;
        Entry remove = list.remove(list.size() - 1);
        this.canceledGraphicsList.add(remove);
        if (remove.isGraphics()) {
            this.drawingList.remove(remove.actionRecord);
        } else if (remove.isClear()) {
            if (remove.drawingList != null) {
                this.drawingList.addAll(0, remove.drawingList);
            }
        } else if (remove.isDelete()) {
            return null;
        }
        return remove;
    }

    private Entry recoverRecent() {
        if (this.canceledGraphicsList.size() <= 0) {
            return null;
        }
        List<Entry> list = this.canceledGraphicsList;
        Entry remove = list.remove(list.size() - 1);
        this.graphicsPainterList.add(remove);
        if (remove.isGraphics()) {
            this.drawingList.add(remove.actionRecord);
        } else if (remove.isClear()) {
            if (remove.drawingList != null) {
                remove.drawingList.clear();
                remove.drawingList.addAll(this.drawingList);
            }
            this.drawingList.clear();
        } else if (remove.isDelete()) {
            return null;
        }
        return remove;
    }

    public Entry remove(WXWBAction wXWBAction) {
        Entry entry = null;
        if (wXWBAction != null) {
            if (wXWBAction.getLineIndex() == 0) {
                return null;
            }
            entry = this.historyGraphics.get(getActionKey(wXWBAction));
            if (entry != null) {
                this.historyGraphics.remove(getActionKey(wXWBAction));
                this.graphicsPainterList.remove(entry);
                this.canceledGraphicsList.remove(entry);
                if (entry.isGraphics()) {
                    this.drawingList.remove(entry.actionRecord);
                }
            }
        }
        return entry;
    }

    public void clearAndSave(WXWBAction wXWBAction, boolean z) {
        if (z) {
            Entry entry = new Entry();
            entry.key = getActionKey(wXWBAction);
            entry.lineIndex = wXWBAction.getLineIndex();
            entry.uid = wXWBAction.getUid();
            entry.action = Entry.ACTION_CLEAR;
            entry.drawingList = new ArrayList(this.drawingList);
            this.historyGraphics.put(entry.key, entry);
            this.graphicsPainterList.add(entry);
            this.canceledGraphicsList.clear();
            this.drawingList.clear();
            return;
        }
        clear();
    }

    public Entry getLeastAddEntry(String str) {
        if (ListUtil.isEmpty(this.graphicsPainterList)) {
            return null;
        }
        List<Entry> list = this.graphicsPainterList;
        Entry entry = list.get(list.size() - 1);
        if (entry != null) {
            if (TextUtils.equals(entry.uid, str)) {
                return entry;
            }
            if (entry.isClear()) {
                return null;
            }
        }
        for (int size = this.graphicsPainterList.size() - 1; size >= 0; size--) {
            Entry entry2 = this.graphicsPainterList.get(size);
            if (entry2 != null && TextUtils.equals(entry2.uid, str)) {
                return entry2;
            }
        }
        return null;
    }

    public Entry getLeastCancelEntry(String str) {
        if (ListUtil.isEmpty(this.canceledGraphicsList)) {
            return null;
        }
        List<Entry> list = this.canceledGraphicsList;
        Entry entry = list.get(list.size() - 1);
        if (entry != null) {
            if (TextUtils.equals(entry.uid, str)) {
                return entry;
            }
            if (entry.isClear()) {
                return null;
            }
        }
        for (int size = this.canceledGraphicsList.size() - 1; size >= 0; size--) {
            Entry entry2 = this.canceledGraphicsList.get(size);
            if (entry2 != null && TextUtils.equals(entry2.uid, str)) {
                return entry2;
            }
        }
        return null;
    }

    public void clear() {
        this.drawingList.clear();
        this.graphicsPainterList.clear();
        this.canceledGraphicsList.clear();
        this.historyGraphics.clear();
    }

    public void deleteSelectAndSave(WXWBAction wXWBAction) {
        String actionKey = getActionKey(wXWBAction);
        if (actionKey != null) {
            Entry entry = this.historyGraphics.get(actionKey);
            if (entry == null) {
                entry = new Entry();
                entry.key = actionKey;
                entry.lineIndex = wXWBAction.getLineIndex();
                entry.uid = wXWBAction.getUid();
                entry.action = Entry.ACTION_DELETE;
                this.historyGraphics.put(actionKey, entry);
                this.graphicsPainterList.add(entry);
            }
            if (wXWBAction.getSelectAreaConfig() != null && wXWBAction.getSelectAreaConfig().getLineIndexs() != null) {
                ArrayList arrayList = new ArrayList();
                for (long j : wXWBAction.getSelectAreaConfig().getLineIndexs()) {
                    Iterator<LineIndexRecord> it = this.drawingList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            LineIndexRecord next = it.next();
                            if (next != null && j == next.getLineIndex() && TextUtils.equals(next.uid, wXWBAction.getUid())) {
                                it.remove();
                                arrayList.add(next);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (entry.drawingList == null) {
                    entry.drawingList = arrayList;
                } else {
                    entry.drawingList.addAll(arrayList);
                }
            }
        }
    }

    public List<LineIndexRecord> getGraphicsPainterList() {
        return this.drawingList;
    }

    public LinkedHashMap<String, Entry> getHistoryGraphics() {
        return this.historyGraphics;
    }

    public void lassoMove(WXWBAction wXWBAction, Map<Long, WXWBAction.Offset> map) {
        if (wXWBAction != null && map != null && !map.isEmpty()) {
            String actionKey = getActionKey(wXWBAction);
            Entry entry = this.historyGraphics.get(actionKey);
            if (entry == null) {
                Entry entry2 = new Entry();
                entry2.key = actionKey;
                entry2.action = Entry.ACTION_LASSO_MOVE;
                entry2.lineIndex = wXWBAction.getLineIndex();
                entry2.uid = wXWBAction.getUid();
                entry2.lassoData = new HashMap<>();
                recordStartOrEndOffsetWhenLassoMove(entry2.lassoData, wXWBAction.getUid(), map);
                this.historyGraphics.put(actionKey, entry2);
                this.graphicsPainterList.add(entry2);
                return;
            }
            recordStartOrEndOffsetWhenLassoMove(entry.lassoData, wXWBAction.getUid(), map);
        }
    }

    private void recordStartOrEndOffsetWhenLassoMove(HashMap<LineIndexRecord, List<WXWBAction.Offset>> hashMap, String str, Map<Long, WXWBAction.Offset> map) {
        List list;
        for (Map.Entry next : map.entrySet()) {
            Entry entry = this.historyGraphics.get((str + "_" + next.getKey()).intern());
            if (!(entry == null || entry.actionRecord == null || entry.actionRecord.getDrawableObject() == null)) {
                if (hashMap.get(entry.actionRecord) == null) {
                    list = new ArrayList();
                    hashMap.put(entry.actionRecord, list);
                } else {
                    list = hashMap.get(entry.actionRecord);
                }
                list.add(next.getValue());
            }
        }
    }

    private void updateOffsetWhenRecoverOrCancel(HashMap<LineIndexRecord, List<WXWBAction.Offset>> hashMap, boolean z) {
        int i;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry next : hashMap.entrySet()) {
                LineIndexRecord lineIndexRecord = (LineIndexRecord) next.getKey();
                List list = (List) next.getValue();
                if (lineIndexRecord.getDrawableObject() != null && !ListUtil.isEmpty(list)) {
                    if (z) {
                        i = 0;
                    } else {
                        i = list.size() - 1;
                    }
                    WXWBAction.Offset offset = (WXWBAction.Offset) list.get(i);
                    lineIndexRecord.getDrawableObject().setOffset(offset.getOffsetX(), offset.getOffsetY());
                }
            }
        }
    }

    public void shapeDeleteSelectAndSave(WXWBAction wXWBAction) {
        String actionKey = getActionKey(wXWBAction);
        if (actionKey != null) {
            Entry entry = this.historyGraphics.get(actionKey);
            if (entry == null) {
                entry = new Entry();
                entry.key = actionKey;
                entry.lineIndex = wXWBAction.getLineIndex();
                entry.uid = wXWBAction.getUid();
                entry.action = Entry.ACTION_LASSO_DELETE;
                this.historyGraphics.put(actionKey, entry);
                this.graphicsPainterList.add(entry);
            }
            if (wXWBAction.getSelectAreaConfig() != null && wXWBAction.getSelectAreaConfig().getShapeIndexs() != null) {
                ArrayList arrayList = new ArrayList();
                entry.lassoDeleteShapeData = new HashSet<>();
                for (long j : wXWBAction.getSelectAreaConfig().getShapeIndexs()) {
                    Iterator<LineIndexRecord> it = this.drawingList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            LineIndexRecord next = it.next();
                            if (next != null && j == next.getLineIndex() && TextUtils.equals(next.uid, wXWBAction.getUid())) {
                                it.remove();
                                arrayList.add(next);
                                entry.lassoDeleteShapeData.add(next);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (entry.drawingList == null) {
                    entry.drawingList = arrayList;
                } else {
                    entry.drawingList.addAll(arrayList);
                }
            }
        }
    }
}
