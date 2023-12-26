package com.tal100.chatsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tal100.chatsdk.PMDefs;
import com.tal100.chatsdk.utils.GsonUtils;

public class TMPushManager {
    private static final String TAG = "TMPushManager";
    private static volatile TMPushManager mInstance;
    private Context mContext = null;
    private TMPushListener mListener = new TMPushListener();
    private int mSmallIconResId = 0;

    /* access modifiers changed from: package-private */
    public native String nativeGetRegisterId();

    /* access modifiers changed from: package-private */
    public native int nativeRegisterTalPush(String str);

    /* access modifiers changed from: package-private */
    public native int nativeUnregisterTalPush();

    static {
        System.loadLibrary("chat-native-lib");
    }

    protected static TMPushManager getInstance() {
        if (mInstance == null) {
            synchronized (TMPushManager.class) {
                if (mInstance == null) {
                    mInstance = new TMPushManager();
                }
            }
        }
        return mInstance;
    }

    private TMPushManager() {
    }

    public int sendPushMessage(String str, String str2, String str3, int i) {
        PMDefs.TMPushRawMessage tMPushRawMessage = new PMDefs.TMPushRawMessage();
        tMPushRawMessage.msgId = "msgId";
        tMPushRawMessage.msgContent = "{\n    \"msgType\":1,\n    \"taskId\":\"任务id\",\n    \"metadata\":\"额外数据 元数据，不做处理\",\n    \"notification\":{\n        \"title\":\"通知标题\",\n        \"content\":\"通知内容\",\n        \"payload\":\"透传内容\",\n        \"channelId\":\"default_channel\",\n        \"clickAction\":{\n            \"type\":1,\n            \"intent\":\"\",\n            \"url\":\"\"\n        }\n     }\n }";
        onRecvTalPushMessageNotice(tMPushRawMessage);
        return 0;
    }

    public int registerTalPush(Context context, String str, int i) {
        String str2 = TAG;
        Log.i(str2, "start talpush");
        if (context == null || i < 0 || TextUtils.isEmpty(str)) {
            Log.i(str2, "invalid param!");
            return 1;
        }
        this.mContext = context;
        this.mSmallIconResId = i;
        return nativeRegisterTalPush(str);
    }

    public int unregisterTalPush() {
        Log.i(TAG, "stop talpush ");
        return nativeUnregisterTalPush();
    }

    public String getRegisterId() {
        return nativeGetRegisterId();
    }

    public int getmSmallIconResId() {
        return this.mSmallIconResId;
    }

    private static void onRecvTalPushMessageNotice(PMDefs.TMPushRawMessage tMPushRawMessage) {
        if (tMPushRawMessage == null) {
            Log.e(TAG, "recv tal push message is null!");
            return;
        }
        String str = tMPushRawMessage.msgId;
        String str2 = tMPushRawMessage.msgContent;
        if (TextUtils.isEmpty(str2)) {
            Log.e(TAG, "recv tal push message, but content is empty!");
            return;
        }
        InternalPushMessage internalPushMessage = (InternalPushMessage) GsonUtils.fromJsonToObject(str2, InternalPushMessage.class);
        if (internalPushMessage == null) {
            Log.e(TAG, "recv tal push message, but content can not convert message entity!");
            return;
        }
        InternalPushMessage.Notification notification = internalPushMessage.getNotification();
        if (notification == null) {
            Log.e(TAG, "recv tal push message, but notification entity is null!");
            return;
        }
        PMDefs.TMPushMsgEntity tMPushMsgEntity = new PMDefs.TMPushMsgEntity();
        tMPushMsgEntity.setMsgType(internalPushMessage.msgType);
        tMPushMsgEntity.setMsgId("");
        tMPushMsgEntity.setTitle(notification.getTitle());
        tMPushMsgEntity.setDescription(notification.getContent());
        tMPushMsgEntity.setPayload(notification.getPayload());
        tMPushMsgEntity.setChannelId(notification.getChannelId());
        tMPushMsgEntity.setExtra(internalPushMessage.getMetadata());
        TMPushManager instance = getInstance();
        instance.mListener.onReceivedPushMessage(instance.mContext, tMPushMsgEntity);
    }

    private static void onRecvRegisterId(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "recv register id is null!");
            return;
        }
        String str2 = TAG;
        Log.i(str2, "onRecvRegisterId" + str);
        TMPushManager instance = getInstance();
        instance.mListener.onReceivedRegisterId(instance.mContext, str);
    }

    private static class InternalPushMessage {
        public String metadata;
        public int msgType;
        public Notification notification;
        public String taskId;

        private InternalPushMessage() {
        }

        public int getMsgType() {
            return this.msgType;
        }

        public void setMsgType(int i) {
            this.msgType = i;
        }

        public String getTaskId() {
            return this.taskId;
        }

        public void setTaskId(String str) {
            this.taskId = str;
        }

        public String getMetadata() {
            return this.metadata;
        }

        public void setMetadata(String str) {
            this.metadata = str;
        }

        public Notification getNotification() {
            return this.notification;
        }

        public void setNotification(Notification notification2) {
            this.notification = notification2;
        }

        private static class Notification {
            public String channelId;
            public ActionType clickAction;
            public String content;
            public String payload;
            public String title;

            private Notification() {
            }

            public String getTitle() {
                return this.title;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public String getContent() {
                return this.content;
            }

            public void setContent(String str) {
                this.content = str;
            }

            public String getPayload() {
                return this.payload;
            }

            public void setPayload(String str) {
                this.payload = str;
            }

            public String getChannelId() {
                return this.channelId;
            }

            public void setChannelId(String str) {
                this.channelId = str;
            }

            public ActionType getClickAction() {
                return this.clickAction;
            }

            public void setClickAction(ActionType actionType) {
                this.clickAction = actionType;
            }
        }

        private static class ActionType {
            public String intent;
            public int type;
            public String url;

            private ActionType() {
            }

            public int getType() {
                return this.type;
            }

            public void setType(int i) {
                this.type = i;
            }

            public String getIntent() {
                return this.intent;
            }

            public void setIntent(String str) {
                this.intent = str;
            }

            public String getUrl() {
                return this.url;
            }

            public void setUrl(String str) {
                this.url = str;
            }
        }
    }
}
