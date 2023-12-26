package com.bonree.sdk.ac;

import com.bonree.sdk.agent.business.entity.ActionEventInfoBean;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.engine.webview.entity.WebviewActionEvent;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.gson.Gson;
import com.bonree.sdk.v.g;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class e {
    private static final String c = "0123456789ABCDEF";
    private final b a;
    private final Gson b;

    private static int a(int i) {
        if (i != 0) {
            return i != 1 ? 0 : 4;
        }
        return 1;
    }

    e(b bVar) {
        this.b = new Gson();
        this.a = bVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(g gVar) {
        WebviewActionEvent webviewActionEvent;
        if (gVar != null) {
            try {
                if (gVar.a() != null && (webviewActionEvent = (WebviewActionEvent) this.b.fromJson(gVar.a(), WebviewActionEvent.class)) != null) {
                    EventBean eventBean = new EventBean();
                    eventBean.mEventType = "action";
                    eventBean.mEventTime = this.a.a(-ad.a(webviewActionEvent.mEventTime));
                    eventBean.mStateIndex = eventBean.getStateIndex();
                    ActionEventInfoBean actionEventInfoBean = new ActionEventInfoBean();
                    int i = webviewActionEvent.mType;
                    actionEventInfoBean.mType = i != 0 ? i != 1 ? 0 : 4 : 1;
                    actionEventInfoBean.mSourceAction = 1;
                    actionEventInfoBean.mName = webviewActionEvent.mName;
                    actionEventInfoBean.mViewName = webviewActionEvent.mViewName;
                    if (webviewActionEvent.mInfo != null) {
                        actionEventInfoBean.mInfo = "xpath=" + webviewActionEvent.mInfo.mXPath + ", outerHTML=" + webviewActionEvent.mInfo.mOuterHtml;
                    }
                    actionEventInfoBean.isCustom = false;
                    actionEventInfoBean.isSlow = Boolean.FALSE;
                    actionEventInfoBean.mLoadTime = ad.a((long) webviewActionEvent.mLoadTime);
                    eventBean.mEventInfo = actionEventInfoBean;
                    eventBean.uploadStateKey();
                    this.a.b(eventBean);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(WebviewActionEvent webviewActionEvent) {
        if (webviewActionEvent != null) {
            EventBean eventBean = new EventBean();
            eventBean.mEventType = "action";
            eventBean.mEventTime = this.a.a(-ad.a(webviewActionEvent.mEventTime));
            eventBean.mStateIndex = eventBean.getStateIndex();
            ActionEventInfoBean actionEventInfoBean = new ActionEventInfoBean();
            actionEventInfoBean.mType = a(webviewActionEvent.mType);
            actionEventInfoBean.mSourceAction = 1;
            actionEventInfoBean.mName = webviewActionEvent.mName;
            actionEventInfoBean.mViewName = webviewActionEvent.mViewName;
            if (webviewActionEvent.mInfo != null) {
                actionEventInfoBean.mInfo = "xpath=" + webviewActionEvent.mInfo.mXPath + ", outerHTML=" + webviewActionEvent.mInfo.mOuterHtml;
            }
            actionEventInfoBean.isCustom = false;
            actionEventInfoBean.isSlow = Boolean.FALSE;
            actionEventInfoBean.mLoadTime = ad.a((long) webviewActionEvent.mLoadTime);
            eventBean.mEventInfo = actionEventInfoBean;
            eventBean.uploadStateKey();
            this.a.b(eventBean);
        }
    }

    private e() {
    }

    public static String a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b2 : bArr) {
            short s = (short) (b2 & 255);
            byteArrayOutputStream.write(c.charAt((byte) (s >> 4)));
            byteArrayOutputStream.write(c.charAt((byte) (s & 15)));
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    public static byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (!Character.isWhitespace((char) bytes[i])) {
                byteArrayOutputStream.write(bytes[i]);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length % 2 != 0) {
            return null;
        }
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i2 = 0; i2 < byteArray.length; i2 += 2) {
            try {
                dataOutputStream.writeByte((((byte) c.indexOf(Character.toUpperCase((char) byteArray[i2]))) << 4) + ((byte) c.indexOf(Character.toUpperCase((char) byteArray[i2 + 1]))));
            } catch (IOException unused) {
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
