package com.bonree.sdk.ar;

import android.os.Message;
import android.text.TextUtils;
import com.bonree.sdk.ab.d;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.NetworkCustomEventBean;
import com.bonree.sdk.agent.business.entity.NetworkEventInfoBean;
import com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean;
import com.bonree.sdk.agent.engine.webview.entity.WebViewRouteChangeEvent;
import com.bonree.sdk.agent.engine.webview.f;
import com.bonree.sdk.agent.engine.webview.g;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.m.k;
import com.bonree.sdk.n.b;
import com.bonree.sdk.n.c;
import com.igexin.assist.control.fcm.GTJobService;
import java.util.List;
import java.util.Map;

public final class e extends com.bonree.sdk.ad.a implements f, com.bonree.sdk.m.e {
    private static int g = 256;
    private static final String h = "BR-Network-Thread";
    private final String f;

    /* synthetic */ e(byte b) {
        this();
    }

    private e() {
        super((com.bonree.sdk.d.e) null);
        this.f = "NetWork";
    }

    public final boolean b() {
        a("NetWork", a.d.a);
        if (!this.a) {
            this.a = true;
            a(h);
            a(8, (long) GTJobService.WAIT_TIME);
            g.a().registerService((f) this);
            com.bonree.sdk.m.g.a().registerService((com.bonree.sdk.m.e) this);
            boolean d = b.a().d();
            if (d) {
                com.bonree.sdk.m.g.a().a(d);
                g.a().a(d);
            }
            a("NetWork", a.d.c);
            return true;
        }
        a("NetWork", a.d.b);
        return false;
    }

    public final boolean c() {
        a("NetWork", a.d.d);
        this.a = false;
        b.a().b();
        g.a().unRegisterService((f) this);
        com.bonree.sdk.m.g.a().unRegisterService(this);
        a("NetWork", a.d.e);
        return true;
    }

    public final void a(d dVar) {
        if (dVar != null) {
            long j = 0;
            try {
                Message obtain = Message.obtain();
                if (dVar.e() != null && !dVar.e().f()) {
                    obtain.what = 0;
                    obtain.obj = dVar.e();
                } else if (dVar.f() != null) {
                    obtain.what = 1;
                    obtain.obj = dVar.f();
                } else if (dVar.d() != null) {
                    obtain.what = 2;
                    obtain.obj = dVar.d();
                    j = 10000;
                }
                a(obtain, j);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Message message) {
        super.a(message);
        b.a().a(message);
    }

    public final void a(c cVar) {
        if (this.a && cVar != null) {
            try {
                Message obtain = Message.obtain();
                obtain.obj = cVar;
                long j = 0;
                if (cVar instanceof b) {
                    if (((b) cVar).U() == 1) {
                        obtain.what = 10;
                    } else {
                        obtain.what = 3;
                        j = 10000;
                    }
                } else if (cVar instanceof com.bonree.sdk.n.f) {
                    obtain.what = 4;
                } else if (cVar instanceof com.bonree.sdk.n.e) {
                    obtain.what = 6;
                } else if (cVar instanceof com.bonree.sdk.n.a) {
                    obtain.what = 7;
                }
                a(obtain, j);
            } catch (Exception unused) {
            }
        }
    }

    public static List<EventBean> a() {
        return b.a().c();
    }

    public static void a(boolean z) {
        b.a().a(z);
    }

    public static void a(boolean z, ConfigResponseBean.NetworkTraceConfig networkTraceConfig) {
        k.b().a(z, networkTraceConfig);
    }

    public static void b(int i) {
        b.a().a(i);
    }

    public static void a(String[] strArr) {
        b.a().a(strArr);
    }

    public static void b(String[] strArr) {
        b.a().b(strArr);
    }

    public static void c(String[] strArr) {
        b.a().c(strArr);
    }

    public static void d(String[] strArr) {
        b.a().d(strArr);
    }

    public static void e(String[] strArr) {
        b.a().e(strArr);
    }

    public final void a(NetworkCustomEventBean networkCustomEventBean) {
        if (this.a) {
            NetworkEventInfoBean networkEventInfoBean = new NetworkEventInfoBean();
            if (networkCustomEventBean != null) {
                try {
                    if (networkCustomEventBean.getmMethod() != null && b(networkCustomEventBean.getmMethod().value())) {
                        networkEventInfoBean.mMethod = networkCustomEventBean.getmMethod().value();
                    }
                    if (b(networkCustomEventBean.getmTargetIp())) {
                        networkEventInfoBean.mTargetIp = networkCustomEventBean.getmTargetIp();
                    }
                    if (a((Map<?, ?>) networkCustomEventBean.getmRequestHeader())) {
                        networkEventInfoBean.mRequestHeader = ad.c(networkCustomEventBean.getmRequestHeader());
                    }
                    if (a((Map<?, ?>) networkCustomEventBean.getmResponseHeader())) {
                        networkEventInfoBean.mResponseHeader = ad.c(networkCustomEventBean.getmResponseHeader());
                    }
                    if (b(networkCustomEventBean.getmErrorMsg())) {
                        networkEventInfoBean.mErrorMsg = networkCustomEventBean.getmErrorMsg();
                    }
                    if (b(networkCustomEventBean.getmResourceType())) {
                        networkEventInfoBean.mResourceType = networkCustomEventBean.getmResourceType();
                    }
                    if (networkCustomEventBean.getmCNameArray() != null && networkCustomEventBean.getmCNameArray().size() <= 64) {
                        networkEventInfoBean.mCNameArray = networkCustomEventBean.getmCNameArray();
                    }
                    networkEventInfoBean.mRequestUrl = networkCustomEventBean.getmRequestUrl();
                    networkEventInfoBean.mTargetPort = networkCustomEventBean.getmTargetPort();
                    networkEventInfoBean.mDnsTimeUs = networkCustomEventBean.getmDnsTimeUs();
                    networkEventInfoBean.mConnectTimeUs = networkCustomEventBean.getmConnectTimeUs();
                    networkEventInfoBean.mSslTimeUs = networkCustomEventBean.getmSslTimeUs();
                    networkEventInfoBean.mRequestTimeUs = networkCustomEventBean.getmRequestTimeUs();
                    networkEventInfoBean.mResponseTimeUs = networkCustomEventBean.getmResponseTimeUs();
                    networkEventInfoBean.mDownloadTimeUs = networkCustomEventBean.getmDownloadTimeUs();
                    networkEventInfoBean.mdownloadSizeByte = networkCustomEventBean.getmDownloadSizeByte();
                    if (networkCustomEventBean.getmProtocolType() != null) {
                        networkEventInfoBean.mProtocolType = networkCustomEventBean.getmProtocolType().value();
                    }
                    if (networkCustomEventBean.getmErrorOccurrentProcess() != null) {
                        networkEventInfoBean.mErrorOccurrentProcess = Integer.valueOf(networkCustomEventBean.getmErrorOccurrentProcess().value());
                    }
                    networkEventInfoBean.mErrorCode = networkCustomEventBean.getmErrorCode();
                    networkEventInfoBean.mRequestDataSize = networkCustomEventBean.getmRequestDataSize();
                    a(9, (Object) networkEventInfoBean);
                } catch (Exception unused) {
                }
            }
        }
    }

    private static boolean a(Map<?, ?> map) {
        return map != null && map.size() <= 64;
    }

    private static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 256;
    }

    private static boolean e() {
        return b.a().d();
    }

    public static e d() {
        return a.a;
    }

    static class a {
        /* access modifiers changed from: private */
        public static final e a = new e((byte) 0);

        private a() {
        }
    }

    public static void a(String str, String str2, String str3) {
        if ((a.a == null || a.a.a) && b(str) && b(str2)) {
            if (!TextUtils.isEmpty(str3) && str3.length() > 256) {
                str3 = str3.substring(0, WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT);
            }
            b.a().a(str, str2, str3);
        }
    }
}
