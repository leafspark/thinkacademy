package com.tal.app.thinkacademy.lib.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.ArrayList;
import java.util.List;

public final class UiMessageUtils implements Handler.Callback {
    private static final boolean DEBUG = UtilsBridge.isAppDebug();
    private static final String TAG = "UiMessageUtils";
    private final List<UiMessageCallback> mDefensiveCopyList;
    private final Handler mHandler;
    private final SparseArray<List<UiMessageCallback>> mListenersSpecific;
    private final List<UiMessageCallback> mListenersUniversal;
    private final UiMessage mMessage;

    public interface UiMessageCallback {
        void handleMessage(UiMessage uiMessage);
    }

    public static UiMessageUtils getInstance() {
        return LazyHolder.INSTANCE;
    }

    private UiMessageUtils() {
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mMessage = new UiMessage((Message) null);
        this.mListenersSpecific = new SparseArray<>();
        this.mListenersUniversal = new ArrayList();
        this.mDefensiveCopyList = new ArrayList();
    }

    public final void send(int i) {
        Handler handler = this.mHandler;
        if (!(handler instanceof Handler)) {
            handler.sendEmptyMessage(i);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(handler, i);
        }
    }

    public final void send(int i, Object obj) {
        Handler handler = this.mHandler;
        Message obtainMessage = handler.obtainMessage(i, obj);
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtainMessage);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtainMessage);
        }
    }

    public void addListener(int i, UiMessageCallback uiMessageCallback) {
        synchronized (this.mListenersSpecific) {
            List list = this.mListenersSpecific.get(i);
            if (list == null) {
                list = new ArrayList();
                this.mListenersSpecific.put(i, list);
            }
            if (!list.contains(uiMessageCallback)) {
                list.add(uiMessageCallback);
            }
        }
    }

    public void addListener(UiMessageCallback uiMessageCallback) {
        synchronized (this.mListenersUniversal) {
            if (!this.mListenersUniversal.contains(uiMessageCallback)) {
                this.mListenersUniversal.add(uiMessageCallback);
            } else if (DEBUG) {
                Log.w(TAG, "Listener is already added. " + uiMessageCallback.toString());
            }
        }
    }

    public void removeListener(UiMessageCallback uiMessageCallback) {
        synchronized (this.mListenersUniversal) {
            if (DEBUG && !this.mListenersUniversal.contains(uiMessageCallback)) {
                Log.w(TAG, "Trying to remove a listener that is not registered. " + uiMessageCallback.toString());
            }
            this.mListenersUniversal.remove(uiMessageCallback);
        }
    }

    public void removeListeners(int i) {
        List list;
        if (DEBUG && ((list = this.mListenersSpecific.get(i)) == null || list.size() == 0)) {
            Log.w(TAG, "Trying to remove specific listeners that are not registered. ID " + i);
        }
        synchronized (this.mListenersSpecific) {
            this.mListenersSpecific.delete(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeListener(int r5, com.tal.app.thinkacademy.lib.util.UiMessageUtils.UiMessageCallback r6) {
        /*
            r4 = this;
            android.util.SparseArray<java.util.List<com.tal.app.thinkacademy.lib.util.UiMessageUtils$UiMessageCallback>> r0 = r4.mListenersSpecific
            monitor-enter(r0)
            android.util.SparseArray<java.util.List<com.tal.app.thinkacademy.lib.util.UiMessageUtils$UiMessageCallback>> r1 = r4.mListenersSpecific     // Catch:{ all -> 0x0065 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0065 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0041
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x0041
            boolean r2 = DEBUG     // Catch:{ all -> 0x0065 }
            if (r2 == 0) goto L_0x003d
            boolean r2 = r1.contains(r6)     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x003d
            java.lang.String r1 = "UiMessageUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r2.<init>()     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = "Trying to remove specific listener that is not registered. ID "
            r2.append(r3)     // Catch:{ all -> 0x0065 }
            r2.append(r5)     // Catch:{ all -> 0x0065 }
            java.lang.String r5 = ", "
            r2.append(r5)     // Catch:{ all -> 0x0065 }
            r2.append(r6)     // Catch:{ all -> 0x0065 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0065 }
            android.util.Log.w(r1, r5)     // Catch:{ all -> 0x0065 }
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            return
        L_0x003d:
            r1.remove(r6)     // Catch:{ all -> 0x0065 }
            goto L_0x0063
        L_0x0041:
            boolean r1 = DEBUG     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0063
            java.lang.String r1 = "UiMessageUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r2.<init>()     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = "Trying to remove specific listener that is not registered. ID "
            r2.append(r3)     // Catch:{ all -> 0x0065 }
            r2.append(r5)     // Catch:{ all -> 0x0065 }
            java.lang.String r5 = ", "
            r2.append(r5)     // Catch:{ all -> 0x0065 }
            r2.append(r6)     // Catch:{ all -> 0x0065 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0065 }
            android.util.Log.w(r1, r5)     // Catch:{ all -> 0x0065 }
        L_0x0063:
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            return
        L_0x0065:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.util.UiMessageUtils.removeListener(int, com.tal.app.thinkacademy.lib.util.UiMessageUtils$UiMessageCallback):void");
    }

    public boolean handleMessage(Message message) {
        this.mMessage.setMessage(message);
        if (DEBUG) {
            logMessageHandling(this.mMessage);
        }
        synchronized (this.mListenersSpecific) {
            List list = this.mListenersSpecific.get(message.what);
            if (list != null) {
                if (list.size() == 0) {
                    this.mListenersSpecific.remove(message.what);
                } else {
                    this.mDefensiveCopyList.addAll(list);
                    for (UiMessageCallback handleMessage : this.mDefensiveCopyList) {
                        handleMessage.handleMessage(this.mMessage);
                    }
                    this.mDefensiveCopyList.clear();
                }
            }
        }
        synchronized (this.mListenersUniversal) {
            if (this.mListenersUniversal.size() > 0) {
                this.mDefensiveCopyList.addAll(this.mListenersUniversal);
                for (UiMessageCallback handleMessage2 : this.mDefensiveCopyList) {
                    handleMessage2.handleMessage(this.mMessage);
                }
                this.mDefensiveCopyList.clear();
            }
        }
        this.mMessage.setMessage((Message) null);
        return true;
    }

    private void logMessageHandling(UiMessage uiMessage) {
        List list = this.mListenersSpecific.get(uiMessage.getId());
        if ((list == null || list.size() == 0) && this.mListenersUniversal.size() == 0) {
            Log.w(TAG, "Delivering FAILED for message ID " + uiMessage.getId() + ". No listeners. " + uiMessage.toString());
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Delivering message ID ");
        sb.append(uiMessage.getId());
        sb.append(", Specific listeners: ");
        if (list == null || list.size() == 0) {
            sb.append(0);
        } else {
            sb.append(list.size());
            sb.append(" [");
            for (int i = 0; i < list.size(); i++) {
                sb.append(((UiMessageCallback) list.get(i)).getClass().getSimpleName());
                if (i < list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
        }
        sb.append(", Universal listeners: ");
        synchronized (this.mListenersUniversal) {
            if (this.mListenersUniversal.size() == 0) {
                sb.append(0);
            } else {
                sb.append(this.mListenersUniversal.size());
                sb.append(" [");
                for (int i2 = 0; i2 < this.mListenersUniversal.size(); i2++) {
                    sb.append(this.mListenersUniversal.get(i2).getClass().getSimpleName());
                    if (i2 < this.mListenersUniversal.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append("], Message: ");
            }
        }
        sb.append(uiMessage.toString());
        Log.v(TAG, sb.toString());
    }

    public static final class UiMessage {
        private Message mMessage;

        private UiMessage(Message message) {
            this.mMessage = message;
        }

        /* access modifiers changed from: private */
        public void setMessage(Message message) {
            this.mMessage = message;
        }

        public int getId() {
            return this.mMessage.what;
        }

        public Object getObject() {
            return this.mMessage.obj;
        }

        public String toString() {
            return "{ id=" + getId() + ", obj=" + getObject() + " }";
        }
    }

    private static final class LazyHolder {
        /* access modifiers changed from: private */
        public static final UiMessageUtils INSTANCE = new UiMessageUtils();

        private LazyHolder() {
        }
    }
}
