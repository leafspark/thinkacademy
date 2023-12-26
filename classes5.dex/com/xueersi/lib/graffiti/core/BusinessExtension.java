package com.xueersi.lib.graffiti.core;

import android.os.Looper;
import com.google.protobuf.MessageLite;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.core.ActionEvent;
import com.xueersi.lib.graffiti.utils.MainHandler;
import com.xueersi.lib.graffiti.utils.XesLog;
import java.lang.reflect.ParameterizedType;

public abstract class BusinessExtension<T extends MessageLite> extends Extension {
    private Class<T> cachedClass;
    private WXWBAction mTempSignalAction;
    protected MainHandler mainHandler = new MainHandler(Looper.getMainLooper());

    /* access modifiers changed from: protected */
    public void onSyncRender(T t) {
    }

    /* access modifiers changed from: protected */
    public void onTruePage() {
    }

    public void actionPerformed(ActionEvent actionEvent) {
        ActionEvent.Action action = actionEvent.getAction();
        if (action == ActionEvent.Action.SIGNAL) {
            WXWBAction signalData = actionEvent.getSignalData();
            if (actionEvent.isSyncRender()) {
                MessageLite parseBusinessData = parseBusinessData(signalData);
                if (parseBusinessData != null) {
                    onSyncRender(parseBusinessData);
                } else {
                    XesLog.e("actionPerformed:解析数据为空1");
                }
            } else {
                this.mTempSignalAction = signalData;
            }
        } else if (action == ActionEvent.Action.NOTIFICATION) {
            ActionEvent.Notification notification = actionEvent.getNotification();
            if (notification == ActionEvent.Notification.TURN_PAGE) {
                onTruePage();
            } else if (notification == ActionEvent.Notification.SYNC_RENDER) {
                MessageLite parseBusinessData2 = parseBusinessData(this.mTempSignalAction);
                if (parseBusinessData2 != null) {
                    onSyncRender(parseBusinessData2);
                } else {
                    XesLog.e("actionPerformed:解析数据为空2");
                }
                this.mTempSignalAction = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public T parseBusinessData(WXWBAction wXWBAction) {
        if (wXWBAction == null) {
            return null;
        }
        try {
            return wXWBAction.getBusiness(getSuperclassTypeParameter(getClass()));
        } catch (Exception e) {
            e.printStackTrace();
            XesLog.e("解析子pb异常" + getClass().getSimpleName(), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Class<T> getSuperclassTypeParameter(Class<?> cls) {
        if (this.cachedClass == null) {
            this.cachedClass = (Class) ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return this.cachedClass;
    }
}
