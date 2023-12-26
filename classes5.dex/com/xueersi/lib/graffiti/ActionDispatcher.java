package com.xueersi.lib.graffiti;

import com.xueersi.lib.graffiti.db.DBOperator;
import com.xueersi.lib.graffiti.utils.ListUtil;
import com.xueersi.lib.graffiti.utils.XesLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class ActionDispatcher {
    private CallBackDispatcher callBack = new CallBackDispatcher();
    private volatile boolean enableAlignTimeStamp = false;
    private final List<WXWBAction> historyArrivedActions = new Vector();
    private volatile boolean mBlocking = false;
    private DBOperator mDBOperator;
    private volatile boolean mDisableSaveDB = false;
    protected volatile String mPageId;
    /* access modifiers changed from: private */
    public volatile boolean mReady = false;
    private final List<WXWBAction> mTempSaveHistory = new Vector();
    private WorkExecutor mWorkExecutor;
    private final TimeStampDataBuffer packageDataBuffer;

    public interface CallBack {
        void onActionArrived(WXWBAction wXWBAction);

        void onActionArrived(List<WXWBAction> list, boolean z);

        void onActionClean();
    }

    public WXWBAction getLastAction() {
        if (!ListUtil.isNotEmpty(this.historyArrivedActions)) {
            return null;
        }
        List<WXWBAction> list = this.historyArrivedActions;
        return list.get(list.size() - 1);
    }

    public int getActionCount() {
        return ListUtil.size(this.historyArrivedActions);
    }

    public ActionDispatcher(WorkExecutor workExecutor, DBOperator dBOperator) {
        TimeStampDataBuffer timeStampDataBuffer = new TimeStampDataBuffer();
        this.packageDataBuffer = timeStampDataBuffer;
        this.mWorkExecutor = workExecutor;
        this.mDBOperator = dBOperator;
        timeStampDataBuffer.setOnActionDataUpdate(new TimeStampDataBuffer.OnActionDataUpdate() {
            public void onNewActionArrived(List<WXWBAction> list, boolean z) {
                ActionDispatcher.this.onNewActionArrived(list, z);
            }
        });
    }

    public void enableAlignTimeStamp(boolean z) {
        this.enableAlignTimeStamp = z;
    }

    public void disableSaveDB() {
        this.mDisableSaveDB = true;
    }

    public void enableSaveDB() {
        this.mDisableSaveDB = false;
    }

    private void stopBlockAndResume() {
        if (this.mBlocking && ListUtil.isNotEmpty(this.mTempSaveHistory)) {
            ArrayList arrayList = new ArrayList(this.mTempSaveHistory);
            sortByTimeStamp(arrayList);
            saveActionToDB((List<WXWBAction>) new ArrayList(arrayList));
            if (this.enableAlignTimeStamp) {
                this.packageDataBuffer.addAll(arrayList);
            } else {
                onNewActionArrived(arrayList, false);
            }
            this.mTempSaveHistory.clear();
        }
        this.mBlocking = false;
    }

    public void addActionData(WXWBAction wXWBAction, int i) {
        if (this.mBlocking) {
            if (!(wXWBAction == null || wXWBAction.getMessageType() == 10)) {
                this.mTempSaveHistory.add(wXWBAction);
            }
            if (i == 4) {
                stopBlockAndResume();
                return;
            }
            return;
        }
        if (this.enableAlignTimeStamp) {
            if (wXWBAction != null) {
                this.packageDataBuffer.add(wXWBAction);
            }
        } else if (wXWBAction != null) {
            onNewActionArrived(wXWBAction);
        }
        if (i != 2 && wXWBAction != null && wXWBAction.getMessageType() != 10) {
            saveActionToDB(wXWBAction);
        }
    }

    public void addActionDataList(List<WXWBAction> list, int i) {
        if (list == null) {
            addActionData((WXWBAction) null, i);
        } else if (!this.mBlocking) {
            if (i != 2) {
                sortByTimeStamp(list);
                saveActionToDB((List<WXWBAction>) new ArrayList(list));
            }
            if (this.enableAlignTimeStamp) {
                this.packageDataBuffer.addAll(list);
            } else {
                onNewActionArrived(list, false);
            }
        } else if (i != 2 || this.enableAlignTimeStamp) {
            this.mTempSaveHistory.addAll(list);
            if (i == 4) {
                stopBlockAndResume();
            }
        } else {
            onNewActionArrived(list, false);
        }
    }

    private void sortByTimeStamp(List<WXWBAction> list) {
        if (list != null && list.size() != 0) {
            Collections.sort(list, new Comparator<WXWBAction>() {
                public int compare(WXWBAction wXWBAction, WXWBAction wXWBAction2) {
                    int i = ((wXWBAction.getTimestamp() - wXWBAction2.getTimestamp()) > 0 ? 1 : ((wXWBAction.getTimestamp() - wXWBAction2.getTimestamp()) == 0 ? 0 : -1));
                    if (i > 0) {
                        return 1;
                    }
                    return i < 0 ? -1 : 0;
                }
            });
        }
    }

    private void saveActionToDB(List<WXWBAction> list) {
        if (this.mDBOperator != null && !this.mDisableSaveDB) {
            this.mDBOperator.insertToDb(list);
        }
    }

    private void saveActionToDB(WXWBAction wXWBAction) {
        if (this.mDBOperator != null && !this.mDisableSaveDB) {
            this.mDBOperator.insertToDb(wXWBAction);
        }
    }

    public void alignTimeStamp(long j) {
        this.packageDataBuffer.alignTimeStamp(j);
    }

    public void clear() {
        this.packageDataBuffer.clear();
        this.mTempSaveHistory.clear();
        this.historyArrivedActions.clear();
    }

    public void destroy() {
        clear();
    }

    /* access modifiers changed from: private */
    public void onNewActionArrived(List<WXWBAction> list, boolean z) {
        if (z || list == null) {
            this.callBack.onActionClean();
            this.historyArrivedActions.clear();
        }
        if (list != null && list.size() > 0) {
            if (list.size() != 1 || z) {
                this.callBack.onActionArrived(list, false);
            } else {
                this.callBack.onActionArrived(list.get(0));
            }
        }
        if (ListUtil.isNotEmpty(list)) {
            this.historyArrivedActions.addAll(list);
        }
    }

    private void onNewActionArrived(WXWBAction wXWBAction) {
        this.callBack.onActionArrived(wXWBAction);
        this.historyArrivedActions.add(wXWBAction);
    }

    /* access modifiers changed from: protected */
    public void setCallBack(CallBack callBack2) {
        this.callBack.setCallBack(callBack2);
    }

    public void setCurrentPage(String str, int i) {
        this.mPageId = str;
        this.mBlocking = i == 2;
        this.mTempSaveHistory.clear();
    }

    public void setReady(boolean z) {
        boolean z2 = this.mReady;
        this.mReady = z;
        if (z && !ListUtil.isEmpty(this.historyArrivedActions)) {
            reSendAction(z2);
        }
    }

    public void reSendAction(boolean z) {
        this.callBack.onActionClean();
        if (!ListUtil.isEmpty(this.historyArrivedActions)) {
            this.callBack.onActionArrived(this.historyArrivedActions, z);
        }
    }

    private class CallBackDispatcher implements CallBack {
        private CallBack callBack;

        private CallBackDispatcher() {
        }

        public void setCallBack(CallBack callBack2) {
            this.callBack = callBack2;
        }

        public void onActionClean() {
            if (this.callBack != null && ActionDispatcher.this.mReady) {
                this.callBack.onActionClean();
            }
        }

        public void onActionArrived(WXWBAction wXWBAction) {
            if (this.callBack != null && ActionDispatcher.this.mReady) {
                this.callBack.onActionArrived(wXWBAction);
            }
            if (!ActionDispatcher.this.mReady && XesLog.isEnabled()) {
                XesLog.d("控件没有Ready，消息暂不分发");
            }
        }

        public void onActionArrived(List<WXWBAction> list, boolean z) {
            if (this.callBack != null && ActionDispatcher.this.mReady) {
                this.callBack.onActionArrived(list, z);
            }
            if (!ActionDispatcher.this.mReady) {
                XesLog.d("控件没有Ready，消息暂停分发");
            }
        }
    }

    private static class TimeStampDataBuffer {
        private long alignTimeStamp;
        private long lastAddedTimeStamp;
        private int lastRightIndex;
        private OnActionDataUpdate onActionDataUpdate;
        private List<WXWBAction> packageData;

        public interface OnActionDataUpdate {
            void onNewActionArrived(List<WXWBAction> list, boolean z);
        }

        private TimeStampDataBuffer() {
            this.packageData = new ArrayList();
            this.alignTimeStamp = 0;
            this.lastAddedTimeStamp = 0;
            this.lastRightIndex = -1;
        }

        public void setOnActionDataUpdate(OnActionDataUpdate onActionDataUpdate2) {
            this.onActionDataUpdate = onActionDataUpdate2;
        }

        public void alignTimeStamp(long j) {
            if (j > 0) {
                boolean z = j < this.alignTimeStamp;
                this.alignTimeStamp = j;
                XesLog.d("alignTimeStamp:" + j);
                updateNewArrived(z);
            }
        }

        public void clear() {
            this.packageData.clear();
            this.lastRightIndex = -1;
        }

        public void addAll(List<WXWBAction> list) {
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    WXWBAction wXWBAction = list.get(i);
                    if (wXWBAction != null) {
                        onAdd(wXWBAction);
                    }
                }
            }
        }

        public void add(WXWBAction wXWBAction) {
            onAdd(wXWBAction);
        }

        private void onAdd(WXWBAction wXWBAction) {
            if (wXWBAction != null) {
                long timestamp = wXWBAction.getTimestamp();
                if (timestamp > 0) {
                    this.packageData.add(wXWBAction);
                }
                if (timestamp > this.lastAddedTimeStamp) {
                    this.lastAddedTimeStamp = timestamp;
                }
            }
        }

        private void updateNewArrived(boolean z) {
            OnActionDataUpdate onActionDataUpdate2;
            if (this.alignTimeStamp > 0 && this.packageData.size() > 0) {
                int i = this.lastRightIndex + 1;
                if (z) {
                    i = 0;
                }
                if (i < this.packageData.size()) {
                    if (this.alignTimeStamp < this.packageData.get(0).getTimestamp()) {
                        OnActionDataUpdate onActionDataUpdate3 = this.onActionDataUpdate;
                        if (onActionDataUpdate3 != null && z) {
                            onActionDataUpdate3.onNewActionArrived((List<WXWBAction>) null, true);
                            XesLog.d("时间戳判断执行清空");
                            this.lastRightIndex = -1;
                            return;
                        }
                        return;
                    }
                    int i2 = i;
                    int i3 = -1;
                    while (i2 < this.packageData.size() && this.packageData.get(i2).getTimestamp() <= this.alignTimeStamp) {
                        i3 = i2;
                        i2++;
                    }
                    if (i3 != -1 && i3 < this.packageData.size() && (onActionDataUpdate2 = this.onActionDataUpdate) != null) {
                        onActionDataUpdate2.onNewActionArrived(this.packageData.subList(i, i3 + 1), z);
                        if (XesLog.isEnabled()) {
                            XesLog.d("时间戳判断执行：start:" + this.packageData.get(i).getMsgId() + " end:" + this.packageData.get(i3).getMsgId());
                        }
                        this.lastRightIndex = i3;
                    }
                }
            }
        }
    }
}
