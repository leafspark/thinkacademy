package com.bonree.sdk.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.bonree.sdk.ag.c;
import com.bonree.sdk.agent.business.entity.DataFusionInfo;
import com.bonree.sdk.agent.business.entity.transfer.OnlineTrackingInfo;
import com.bonree.sdk.agent.business.entity.transfer.UploadDataResponseBean;
import com.bonree.sdk.agent.engine.crash.NativeCrashEngine;
import com.bonree.sdk.agent.engine.crash.b;
import com.bonree.sdk.agent.engine.state.i;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.d.e;
import com.bonree.sdk.f.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class a implements c.a, b, com.bonree.sdk.agent.engine.crash.c, i {
    private static final String c = "BR_SDKCommManager";
    private static final String f = "br_app_session.txt";
    public e a;
    public f b;
    private com.bonree.sdk.c.a d;
    private d e;

    public a(e eVar) {
        this.a = eVar;
        this.b = com.bonree.sdk.be.a.a();
    }

    public final int a() {
        if (this.d == null) {
            this.d = new com.bonree.sdk.c.a(this.a);
        }
        com.bonree.sdk.d.a.f();
        j().c().f();
        int a2 = this.d.a();
        com.bonree.sdk.d.a.f();
        return a2;
    }

    public final int a(int i) {
        UploadDataResponseBean uploadDataResponseBean;
        try {
            uploadDataResponseBean = b().a(i);
        } catch (Throwable unused) {
            uploadDataResponseBean = null;
        }
        if (uploadDataResponseBean != null) {
            return uploadDataResponseBean.getResponseCode();
        }
        return -1;
    }

    public final synchronized d b() {
        if (this.e == null) {
            if (this.d == null) {
                this.d = new com.bonree.sdk.c.a(this.a);
            }
            this.e = new d(this.a, this.d);
        }
        return this.e;
    }

    public final boolean c() {
        this.b.c("SDKComm started...%s", ad.a());
        e eVar = this.a;
        if (eVar == null || eVar.w() == null) {
            return false;
        }
        File externalCacheDir = this.a.c().getExternalCacheDir();
        if (externalCacheDir != null) {
            File file = new File(externalCacheDir.getPath() + File.separator + f);
            if (file.exists()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    fileInputStream.close();
                    String stringBuffer2 = stringBuffer.toString();
                    if (!TextUtils.isEmpty(stringBuffer2)) {
                        com.bonree.sdk.d.a.k().a(new DataFusionInfo(stringBuffer2));
                        this.b.c("checkSessionFile: %s", stringBuffer2);
                    }
                } catch (Exception unused) {
                }
            }
        }
        this.a.w().sendEmptyMessage(1);
        com.bonree.sdk.agent.engine.state.f.getEngine().registerService((i) this);
        com.bonree.sdk.agent.engine.crash.d.a().registerService(this);
        NativeCrashEngine.getInstance().registerService((com.bonree.sdk.agent.engine.crash.c) this);
        this.a.k().a((c.a) this);
        return true;
    }

    public final boolean d() {
        com.bonree.sdk.agent.engine.state.f.getEngine().unRegisterService((i) this);
        e eVar = this.a;
        if (!(eVar == null || eVar.w() == null)) {
            this.a.w().removeCallbacksAndMessages((Object) null);
        }
        com.bonree.sdk.agent.engine.crash.d.a().unRegisterService(this);
        NativeCrashEngine.getInstance().unRegisterService(this);
        if (this.a.k() != null) {
            this.a.k().b((c.a) this);
        }
        this.b.c("SDKComm stopped...", new Object[0]);
        return true;
    }

    private void i() {
        File externalCacheDir = this.a.c().getExternalCacheDir();
        if (externalCacheDir != null) {
            File file = new File(externalCacheDir.getPath() + File.separator + f);
            if (file.exists()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    fileInputStream.close();
                    String stringBuffer2 = stringBuffer.toString();
                    if (!TextUtils.isEmpty(stringBuffer2)) {
                        com.bonree.sdk.d.a.k().a(new DataFusionInfo(stringBuffer2));
                        this.b.c("checkSessionFile: %s", stringBuffer2);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final boolean e() {
        com.bonree.sdk.c.a aVar = this.d;
        if (aVar != null) {
            if (aVar.c() != null ? aVar.c().e() : false) {
                return true;
            }
        }
        return false;
    }

    public final long f() {
        OnlineTrackingInfo a2 = com.bonree.sdk.e.b.b().a();
        if (a2 != null) {
            return a2.getInstantCycleTimeUpload();
        }
        long d2 = this.d.c().d();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        if (d2 <= 5) {
            d2 = 15;
        }
        return timeUnit.toMillis(d2);
    }

    private com.bonree.sdk.c.a j() {
        if (this.d == null) {
            this.d = new com.bonree.sdk.c.a(this.a);
        }
        return this.d;
    }

    public final com.bonree.sdk.c.b g() {
        return j().c();
    }

    private void l() {
        e eVar = this.a;
        if (eVar != null && eVar.w() != null) {
            this.a.w().removeMessages(4);
            this.a.w().sendEmptyMessage(4);
        }
    }

    private void m() {
        Boolean bool;
        Handler w = this.a.w();
        HandlerThread t = this.a.t();
        if (w == null || t == null || !t.isAlive()) {
            StringBuilder sb = new StringBuilder("send upload message fail:agent handler:");
            sb.append(w);
            sb.append(", agent handler thread is dead:");
            if (t == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(!t.isAlive());
            }
            sb.append(bool);
            String sb2 = sb.toString();
            this.b.d(sb2, new Object[0]);
            com.bonree.sdk.d.a.a.a(sb2);
            return;
        }
        w.removeMessages(2);
        w.removeMessages(3);
        if (!w.sendEmptyMessage(2)) {
            f fVar = this.b;
            StringBuilder sb3 = new StringBuilder("send upload failed , agentHandlerThread isDead:");
            sb3.append(!t.isAlive());
            fVar.e(sb3.toString(), new Object[0]);
        }
    }

    public final void a(com.bonree.sdk.agent.engine.state.e eVar) {
        Boolean bool;
        if (eVar != null) {
            if (eVar == com.bonree.sdk.agent.engine.state.e.FOREGROUND) {
                com.bonree.sdk.d.a.k().f(true);
                e eVar2 = this.a;
                if (eVar2 != null && eVar2.w() != null) {
                    this.a.w().removeMessages(4);
                    this.a.w().sendEmptyMessage(4);
                }
            } else if (eVar == com.bonree.sdk.agent.engine.state.e.BACKGROUND) {
                com.bonree.sdk.d.a.k().f(false);
                Handler w = this.a.w();
                HandlerThread t = this.a.t();
                if (w == null || t == null || !t.isAlive()) {
                    StringBuilder sb = new StringBuilder("send upload message fail:agent handler:");
                    sb.append(w);
                    sb.append(", agent handler thread is dead:");
                    if (t == null) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(!t.isAlive());
                    }
                    sb.append(bool);
                    String sb2 = sb.toString();
                    this.b.d(sb2, new Object[0]);
                    com.bonree.sdk.d.a.a.a(sb2);
                    return;
                }
                w.removeMessages(2);
                w.removeMessages(3);
                if (!w.sendEmptyMessage(2)) {
                    f fVar = this.b;
                    fVar.e("send upload failed , agentHandlerThread isDead:" + (true ^ t.isAlive()), new Object[0]);
                }
            }
        }
    }

    private void b(int i) {
        this.a.y().a(i);
    }

    public final void a(com.bonree.sdk.ah.b bVar) {
        b(5);
    }

    public final void a(com.bonree.sdk.ah.c cVar) {
        b(7);
    }

    public final void h() {
        b(5);
    }

    private void k() {
        e eVar = this.a;
        if (eVar != null && eVar.w() != null) {
            this.a.w().removeMessages(4);
            this.a.w().sendEmptyMessage(4);
        }
    }

    public a() {
    }

    private static long a(String str) {
        if (str == null) {
            return -1;
        }
        try {
            if (str.length() == 0) {
                return -1;
            }
            byte[] b2 = b(str);
            return (long) (((b2[0] << 24) & -16777216) | (b2[3] & 255) | ((b2[2] << 8) & 65280) | ((b2[1] << 16) & 16711680));
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static long a(byte[] bArr) {
        return (long) (((bArr[0] << 24) & -16777216) | (bArr[3] & 255) | ((bArr[2] << 8) & 65280) | ((bArr[1] << 16) & 16711680));
    }

    private static byte[] b(String str) {
        try {
            return InetAddress.getByName(str).getAddress();
        } catch (Throwable unused) {
            throw new IllegalArgumentException(str + " is invalid IP");
        }
    }
}
