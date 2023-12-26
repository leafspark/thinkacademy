package com.bonree.sdk.c;

import android.content.Context;
import android.os.Process;
import com.bonree.sdk.agent.Agent;
import com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.aa;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.d.a;
import com.bonree.sdk.d.e;
import java.util.UUID;

public class b {
    private static String b = "network";
    private static String c = "crash";
    private static String d = "h5";
    private static String e = "view";
    private static String f = "coollaunch";
    private static String g = "hotlaunch";
    private static String h = "action";
    private static String i = "statechange";
    private static String j = "customlog";
    private static String k = "customevent";
    private static String l = "custommetric";
    private static String m = "routechange";
    private static String n = "anr";
    private static String o = "lagfps";
    private static String p = "lagstuck";
    private static String q = "lag";
    private static String r = "battery";
    public int a;
    private String s;
    private long t;
    private int u;
    private boolean v;
    private final f w;
    private final e x;
    private ConfigResponseBean y;

    private static byte[] a(int i2) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) i2;
        bArr[2] = (byte) (i2 >> 8);
        bArr[1] = (byte) (i2 >> 16);
        bArr[0] = (byte) (i2 >>> 24);
        return bArr;
    }

    public b(e eVar) {
        this.a = 0;
        this.s = "br:" + UUID.randomUUID();
        this.t = a.y();
        this.u = 15;
        this.v = false;
        this.w = com.bonree.sdk.be.a.a();
        this.x = eVar;
    }

    private void g() {
        f fVar = a.a;
        fVar.c("response code==" + this.a + "(" + this.v + ") ", Integer.valueOf(Process.myPid()));
        String str = !this.v ? "服务器返回不抓数据\n" : "Config连接成功\n";
        a.a.c("BRAgent connect server success, %s", Integer.valueOf(Process.myPid()));
        this.w.c("BRAgent connect server success, %s", Integer.valueOf(Process.myPid()));
        ad.g(str + "appkey为:" + a.k().v() + "\nconfig地址为:" + a.k().M() + "\nsdk版本号为:" + Agent.getAgentVersion() + "/" + Agent.getClassRewriterVersion() + "\n(config返回状态码为：" + this.a + ")");
    }

    public final void a(ConfigResponseBean configResponseBean, String str) {
        if (configResponseBean == null) {
            try {
                this.w.e("Server Error, ConfigResponseBean is null!!!", new Object[0]);
                a.a.c("Server Error, ConfigResponse is null!!!", new Object[0]);
            } catch (Throwable th) {
                this.w.a("parse configResponse exception:", th);
            }
        } else {
            int i2 = configResponseBean.mResponseCode;
            this.a = i2;
            this.v = i2 >= 0 && i2 <= 10000 && configResponseBean.mModuleConfiguration != null && configResponseBean.mModuleConfiguration.size() > 0;
            this.t = configResponseBean.mServerTime;
            f fVar = a.a;
            fVar.c("response code==" + this.a + "(" + this.v + ") ", Integer.valueOf(Process.myPid()));
            String str2 = "Config连接成功\n";
            if (!this.v) {
                str2 = "服务器返回不抓数据\n";
            }
            a.a.c("BRAgent connect server success, %s", Integer.valueOf(Process.myPid()));
            this.w.c("BRAgent connect server success, %s", Integer.valueOf(Process.myPid()));
            ad.g(str2 + "appkey为:" + a.k().v() + "\nconfig地址为:" + a.k().M() + "\nsdk版本号为:" + Agent.getAgentVersion() + "/" + Agent.getClassRewriterVersion() + "\n(config返回状态码为：" + this.a + ")");
            if (!this.v) {
                a.a.e("No need to trace from Config !!! SDK Stop! ", new Object[0]);
                this.w.e("sdk is about to stop... cause: No need to trace from Config !!! SDK Stop!! ", new Object[0]);
                this.x.w().removeCallbacksAndMessages((Object) null);
                this.x.w().sendEmptyMessage(10);
                return;
            }
            com.bonree.sdk.az.b.h().e();
            Context c2 = this.x.c();
            aa.a(c2, "configuration", "config_resp", str);
            aa.a(c2, "configuration", "startTime", System.currentTimeMillis());
            aa.a(c2, "configuration", "rateOfLaunchValidTime", configResponseBean.mStartProbabilityTime);
            aa.a(c2, "configuration", "rateOfLaunch", configResponseBean.mStartProbability);
            this.t = configResponseBean.mServerTime;
            this.u = configResponseBean.mRecoveryCycleTime;
            this.s = configResponseBean.mSession;
            this.y = configResponseBean;
            a.k();
            a.b(this.t);
            this.x.z().a(configResponseBean);
            this.x.a(configResponseBean, false);
            a.a.a("CR OK");
        }
    }

    private static void a(ConfigResponseBean configResponseBean, Context context, String str) {
        aa.a(context, "configuration", "config_resp", str);
        aa.a(context, "configuration", "startTime", System.currentTimeMillis());
        aa.a(context, "configuration", "rateOfLaunchValidTime", configResponseBean.mStartProbabilityTime);
        aa.a(context, "configuration", "rateOfLaunch", configResponseBean.mStartProbability);
    }

    private ConfigResponseBean h() {
        return this.y;
    }

    private void a(ConfigResponseBean configResponseBean) {
        this.t = configResponseBean.mServerTime;
        this.u = configResponseBean.mRecoveryCycleTime;
        this.s = configResponseBean.mSession;
        this.y = configResponseBean;
        a.k();
        a.b(this.t);
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.s;
    }

    public final long c() {
        return this.t;
    }

    public final long d() {
        return (long) this.u;
    }

    public final boolean e() {
        return this.v;
    }

    public final String toString() {
        return "ConfigResponseParse { responseCode='" + this.a + "', statMainId='" + this.s + "', monitorTime='" + this.t + "', resultAddress='', recoveryCycle='" + this.u + "', needTrace='" + this.v + "' }";
    }

    public final void a(boolean z) {
        this.v = false;
    }

    public final void f() {
        this.s = "br:" + UUID.randomUUID();
    }

    public b() {
    }

    private static int a(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        int length = bArr.length - 1;
        int i2 = 3;
        while (i2 >= 0) {
            if (length >= 0) {
                bArr2[i2] = bArr[length];
            } else {
                bArr2[i2] = 0;
            }
            i2--;
            length--;
        }
        return ((bArr2[0] & 255) << 24) + ((bArr2[1] & 255) << 16) + ((bArr2[2] & 255) << 8) + (bArr2[3] & 255);
    }

    private static byte[] a(long j2) {
        byte[] bArr = new byte[8];
        int i2 = 0;
        while (i2 < 8) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((int) ((j2 >> (64 - (i3 << 3))) & 255));
            i2 = i3;
        }
        return bArr;
    }

    private static long b(byte[] bArr) {
        if (bArr == null || bArr.length < 8) {
            a.a.a("b == null || b.length < 8", new Object[0]);
            return -1;
        }
        long j2 = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            j2 = (j2 << 8) | ((long) (bArr[i2] & 255));
        }
        return j2;
    }
}
