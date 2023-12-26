package com.bonree.sdk.agent.engine.webview;

import com.bonree.sdk.ab.d;
import com.bonree.sdk.ab.i;
import com.bonree.sdk.ab.j;
import com.bonree.sdk.agent.engine.webview.entity.WebviewInfo;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.m.o;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g extends com.bonree.sdk.g.a<d, f> {
    private static final int f = 100;
    private boolean a;
    private Queue<String> b;
    private f c;
    private final Map<Integer, WebviewInfo> d;
    private volatile boolean e;

    private static int a(int i) {
        if (i == -11) {
            return 1;
        }
        if (i != -2) {
            return (i == -8 || i == -7 || i == -6 || i == -5 || i == -4) ? 3 : 4;
        }
        return 2;
    }

    /* synthetic */ g(byte b2) {
        this();
    }

    private g() {
        this.a = false;
        this.d = Collections.synchronizedMap(new HashMap());
        this.e = false;
        this.b = new ConcurrentLinkedQueue();
        this.c = com.bonree.sdk.be.a.a();
    }

    static class a {
        /* access modifiers changed from: private */
        public static final g a = new g((byte) 0);

        private a() {
        }
    }

    public static g a() {
        return a.a;
    }

    private void c() {
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
    }

    private boolean d() {
        return this.e;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final void a(com.bonree.sdk.w.a aVar) {
        if (aVar.g() > 0) {
            int g = aVar.g();
            WebviewInfo webviewInfo = this.d.get(Integer.valueOf(g));
            if (webviewInfo != null) {
                if (webviewInfo.getReferenceCount() == 0) {
                    webviewInfo.addReference();
                    if (webviewInfo.getAdditionalHttpHeaders() != null) {
                        aVar.a(webviewInfo.getAdditionalHttpHeaders());
                    } else if (webviewInfo.getPostData() != null) {
                        try {
                            aVar.b(new String(webviewInfo.getPostData()));
                        } catch (Throwable unused) {
                        }
                    }
                    String url = webviewInfo.getUrl();
                    if (url != null) {
                        aVar.c(url);
                    }
                } else {
                    this.d.remove(Integer.valueOf(g));
                }
            }
        }
        notifyService(new d(aVar));
    }

    public final void a(o oVar) {
        notifyService(new d(oVar));
    }

    public final void a(String str) {
        d dVar = new d();
        dVar.a(str);
        notifyService(dVar);
    }

    public final void a(String str, int i) {
        d dVar = new d();
        com.bonree.sdk.agent.engine.network.websocket.a aVar = new com.bonree.sdk.agent.engine.network.websocket.a(str);
        dVar.a(aVar);
        WebviewInfo webviewInfo = this.d.get(Integer.valueOf(i));
        if (webviewInfo != null) {
            if (webviewInfo.getAdditionalHttpHeaders() != null) {
                aVar.a(webviewInfo.getAdditionalHttpHeaders());
            } else if (webviewInfo.getPostData() != null) {
                try {
                    aVar.b(new String(webviewInfo.getPostData()));
                } catch (Throwable unused) {
                }
            }
            String url = webviewInfo.getUrl();
            if (url != null) {
                aVar.c(url);
            }
        }
        notifyService(dVar);
    }

    public final void b(String str) {
        d dVar = new d();
        dVar.a(new com.bonree.sdk.v.g(str));
        notifyService(dVar);
    }

    public final void c(String str) {
        d dVar = new d();
        dVar.a(new i(str));
        notifyService(dVar);
    }

    public final void a(j jVar) {
        notifyService(new d(jVar));
    }

    public final void a(String str, String str2, int i, String str3, String str4) {
        f fVar = this.c;
        fVar.e("WebviewEngine  handleReceivedError5 " + str + "  message: " + str2, new Object[0]);
        a(new com.bonree.sdk.ab.f(str, i, str2, a(i), str3, str4));
    }

    public final void a(Object obj, String str, byte[] bArr) {
        if (obj != null) {
            f fVar = this.c;
            fVar.c("WebviewEngine  handlePostUrl " + obj.hashCode() + "  url: " + str, new Object[0]);
            if (this.e && bArr != null) {
                if (this.d.size() > 100) {
                    Iterator<Map.Entry<Integer, WebviewInfo>> it = this.d.entrySet().iterator();
                    if (it.hasNext()) {
                        it.remove();
                    }
                }
                this.d.put(Integer.valueOf(obj.hashCode()), new WebviewInfo(bArr, str));
            }
        }
    }

    public final void a(Object obj, String str, Map<String, String> map) {
        if (obj != null) {
            f fVar = this.c;
            fVar.c("WebviewEngine  LoadUrl " + obj.hashCode() + "  url: " + str, new Object[0]);
            if (map != null) {
                if (this.d.size() >= 100) {
                    Iterator<Map.Entry<Integer, WebviewInfo>> it = this.d.entrySet().iterator();
                    if (it.hasNext()) {
                        it.remove();
                    }
                }
                this.d.put(Integer.valueOf(obj.hashCode()), new WebviewInfo(map, str));
            }
        }
    }

    public final void b(String str, String str2, int i, String str3, String str4) {
        f fVar = this.c;
        fVar.e("WebviewEngine  handleReceivedError6 " + str + "  message: " + str2, new Object[0]);
        a(new com.bonree.sdk.ab.f(str, i, str2, i, str3, str4));
    }

    public final void a(String str, int i, String str2, String str3, String str4, String str5) {
        f fVar = this.c;
        StringBuilder sb = new StringBuilder("WebviewEngine  handleReceivedError ");
        String str6 = str;
        sb.append(str);
        sb.append("  message: ");
        sb.append(str3);
        sb.append(" errorCode:");
        int i2 = i;
        sb.append(i);
        fVar.e(sb.toString(), new Object[0]);
        a(new com.bonree.sdk.ab.f(str, i, str2, !ad.a(str2) ? str2.getBytes().length : 0, str3, a(i), str4, str5));
    }

    public final void a(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7) {
        f fVar = this.c;
        fVar.e("WebviewEngine  handleReceivedHttpError " + str + "  message: " + str5, new Object[0]);
        a(new com.bonree.sdk.ab.f(str, i, str2, !ad.a(str2) ? str2.getBytes().length : 0, str3, !ad.a(str3) ? str3.getBytes().length : 0, str4, str5, a(i), str6, str7));
    }

    /* renamed from: a */
    public final void registerService(f fVar) {
        super.registerService(fVar);
        this.c.c("webview engine register add", new Object[0]);
        this.a = true;
    }

    private void a(com.bonree.sdk.ab.f fVar) {
        f fVar2 = this.c;
        fVar2.e("WebviewEngine  handleWebviewReceivedError " + fVar.toString(), new Object[0]);
        notifyService(new d(fVar));
    }

    /* renamed from: b */
    public final void unRegisterService(f fVar) {
        super.unRegisterService(fVar);
        if (this.services.isEmpty()) {
            this.c.c("webview engine stop", new Object[0]);
            this.a = false;
            this.e = false;
        }
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
    }

    public final boolean b() {
        return this.a;
    }

    /* renamed from: a */
    public final void notifyService(d dVar) {
        this.readWriteLock.readLock().lock();
        if (dVar != null) {
            try {
                for (f a2 : this.services) {
                    a2.a(dVar);
                }
            } catch (Throwable th) {
                this.readWriteLock.readLock().unlock();
                throw th;
            }
        }
        this.readWriteLock.readLock().unlock();
    }
}
