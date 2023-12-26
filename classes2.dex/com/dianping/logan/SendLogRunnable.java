package com.dianping.logan;

import android.text.TextUtils;
import java.io.File;

public abstract class SendLogRunnable implements Runnable {
    public static final int FINISH = 10002;
    public static final int SENDING = 10001;
    private OnSendLogCallBackListener mCallBackListener;
    private SendAction mSendAction;

    interface OnSendLogCallBackListener {
        void onCallBack(int i);
    }

    public abstract void sendLog(File file);

    /* access modifiers changed from: package-private */
    public void setSendAction(SendAction sendAction) {
        this.mSendAction = sendAction;
    }

    public void run() {
        SendAction sendAction = this.mSendAction;
        if (sendAction == null || TextUtils.isEmpty(sendAction.name)) {
            finish();
        } else if (TextUtils.isEmpty(this.mSendAction.uploadPath)) {
            finish();
        } else {
            sendLog(new File(this.mSendAction.uploadPath));
        }
    }

    /* access modifiers changed from: package-private */
    public void setCallBackListener(OnSendLogCallBackListener onSendLogCallBackListener) {
        this.mCallBackListener = onSendLogCallBackListener;
    }

    /* access modifiers changed from: protected */
    public void finish() {
        OnSendLogCallBackListener onSendLogCallBackListener = this.mCallBackListener;
        if (onSendLogCallBackListener != null) {
            onSendLogCallBackListener.onCallBack(10002);
        }
    }
}
