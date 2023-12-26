package com.bonree.sdk.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.business.entity.transfer.HeartbeatRequestBean;
import com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean;
import com.bonree.sdk.agent.business.entity.transfer.OnlineTrackingInfo;
import com.bonree.sdk.agent.business.util.c;
import com.bonree.sdk.ao.d;
import com.bonree.sdk.d.a;
import com.bonree.sdk.e.b;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public final class a extends Handler {
    private int a;
    private int b;
    private OnlineTrackingInfo c;
    private long d;
    private HeartbeatRequestBean e;
    private c f;

    private a(Looper looper) {
        super(looper);
        this.a = 1;
        this.b = 2;
    }

    private a(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.a = 1;
        this.b = 2;
    }

    public a(Looper looper, OnlineTrackingInfo onlineTrackingInfo) throws MalformedURLException {
        this(looper);
        this.c = onlineTrackingInfo;
        this.d = com.bonree.sdk.d.a.b();
        this.f = new c(this.c.getHeartbeatUrl());
        HeartbeatRequestBean heartbeatRequestBean = new HeartbeatRequestBean();
        this.e = heartbeatRequestBean;
        heartbeatRequestBean.setSession(this.c.getSession());
        this.e.setStatus(HeartbeatRequestBean.HeartStatus.DEFAULT.ordinal());
        this.e.setTrackID(this.c.getTrackID());
    }

    public final void handleMessage(Message message) {
        int i;
        long b2 = com.bonree.sdk.d.a.b();
        long heartbeatTime = this.c.getHeartbeatTime();
        if (b2 - this.d > TimeUnit.HOURS.toMillis(12)) {
            try {
                this.e.setStatus(HeartbeatRequestBean.HeartStatus.TIMEOUT.ordinal());
                this.f.a(this.e, b2, heartbeatTime);
            } catch (Exception unused) {
            }
            b.a.a.c();
        } else if (message.what == 1) {
            HeartbeatRequestBean heartbeatRequestBean = this.e;
            if (com.bonree.sdk.d.a.g == a.C0019a.d) {
                i = a.C0019a.a;
            } else {
                i = com.bonree.sdk.d.a.g;
            }
            heartbeatRequestBean.setAuthorizeCode(i - 1);
            HeartbeatResponseDataBean a2 = this.f.a(this.e, b2, heartbeatTime);
            if (a2 == null) {
                com.bonree.sdk.be.a.a().e("heartbeat response is null , online executor stop!", new Object[0]);
                b.a.a.c();
                return;
            }
            if (a2.getStatus() == HeartbeatResponseDataBean.ResponseStatus.SHUTDOWN.ordinal()) {
                com.bonree.sdk.be.a.a().e("heartbeat response status is SHUTDOWN,  online executor stop!", new Object[0]);
                b.a.a.c();
            } else if (a2.getStatus() == HeartbeatResponseDataBean.ResponseStatus.REQUEST.ordinal()) {
                if (com.bonree.sdk.d.a.g == a.C0019a.a) {
                    com.bonree.sdk.d.a.g();
                }
            } else if (a2.getStatus() == HeartbeatResponseDataBean.ResponseStatus.TASK.ordinal()) {
                d.g().a(a2.getTaskList(), com.bonree.sdk.d.a.g == a.C0019a.c);
            }
            com.bonree.sdk.be.a.a().a("next heartbeat send interval: %d ms", Long.valueOf(heartbeatTime));
            sendEmptyMessageDelayed(1, heartbeatTime);
        } else if (message.what == 2) {
            this.e.setStatus(HeartbeatRequestBean.HeartStatus.SESSION_CLOSE.ordinal());
            this.f.a(this.e, b2, heartbeatTime);
        }
    }
}
