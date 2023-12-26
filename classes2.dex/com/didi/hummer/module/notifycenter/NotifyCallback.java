package com.didi.hummer.module.notifycenter;

import android.content.Context;
import com.didi.hummer.core.engine.JSContext;
import com.didi.hummer.core.engine.base.ICallback;

public abstract class NotifyCallback implements ICallback {
    private long callbackId = ((long) hashCode());
    private long contextId;

    /* access modifiers changed from: protected */
    public abstract void onNotify(Object obj);

    public NotifyCallback(Context context) {
        this.contextId = (long) context.hashCode();
    }

    public NotifyCallback(JSContext jSContext) {
        this.contextId = jSContext.getIdentify();
    }

    public long getContextId() {
        return this.contextId;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NotifyCallback)) {
            return false;
        }
        NotifyCallback notifyCallback = (NotifyCallback) obj;
        if (notifyCallback.contextId == this.contextId && notifyCallback.callbackId == this.callbackId) {
            return true;
        }
        return false;
    }

    public Object call(Object... objArr) {
        onNotify(objArr.length > 0 ? objArr[0] : null);
        return null;
    }
}
