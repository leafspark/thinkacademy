package com.igexin.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.b.a.c.a.c;
import com.igexin.b.a.c.b;
import com.igexin.push.core.g;
import com.igexin.push.core.x;
import com.igexin.push.util.a;
import com.igexin.sdk.a.d;
import com.igexin.sdk.message.BindAliasCmdMessage;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.igexin.sdk.message.UnBindAliasCmdMessage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PushManager {
    private static final ExecutorService a = Executors.newSingleThreadExecutor();
    private long b;
    private long c;
    private long d;
    private byte[] e;
    private Class f;
    private String g;
    private String h;
    /* access modifiers changed from: private */
    public g i;
    private final String j;

    private PushManager() {
        this.j = "[PushManager]";
    }

    /* synthetic */ PushManager(d dVar) {
        this();
    }

    private int a(int i2, String str) {
        return (TextUtils.isEmpty(str) || !str.contains("_")) ? i2 : (i2 == 60001 || i2 == 60002) ? str.startsWith(AssistPushConsts.HW_PREFIX) ? i2 + 18 : str.startsWith(AssistPushConsts.XM_PREFIX) ? i2 + 48 : str.startsWith(AssistPushConsts.OPPO_PREFIX) ? i2 + 28 : str.startsWith(AssistPushConsts.VIVO_PREFIX) ? i2 + 38 : str.startsWith(AssistPushConsts.MZ_PREFIX) ? i2 + 58 : str.startsWith(AssistPushConsts.ST_PREFIX) ? i2 + 78 : str.startsWith(AssistPushConsts.FCM_PREFIX) ? i2 + 98 : i2 : i2;
    }

    private Class a(Context context) {
        Class cls = this.f;
        return cls != null ? cls : x.a().b(context);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "MD5"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch:{ Exception -> 0x003a }
            byte[] r6 = r6.getBytes()     // Catch:{ Exception -> 0x003a }
            r0.update(r6)     // Catch:{ Exception -> 0x003a }
            byte[] r6 = r0.digest()     // Catch:{ Exception -> 0x003a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003a }
            java.lang.String r1 = ""
            r0.<init>(r1)     // Catch:{ Exception -> 0x003a }
            int r1 = r6.length     // Catch:{ Exception -> 0x003a }
            r2 = 0
        L_0x001a:
            if (r2 >= r1) goto L_0x0035
            byte r3 = r6[r2]     // Catch:{ Exception -> 0x003a }
            if (r3 >= 0) goto L_0x0022
            int r3 = r3 + 256
        L_0x0022:
            r4 = 16
            if (r3 >= r4) goto L_0x002b
            java.lang.String r4 = "0"
            r0.append(r4)     // Catch:{ Exception -> 0x003a }
        L_0x002b:
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ Exception -> 0x003a }
            r0.append(r3)     // Catch:{ Exception -> 0x003a }
            int r2 = r2 + 1
            goto L_0x001a
        L_0x0035:
            java.lang.String r6 = r0.toString()     // Catch:{ Exception -> 0x003a }
            return r6
        L_0x003a:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.sdk.PushManager.a(java.lang.String):java.lang.String");
    }

    private void a(Context context, GTCmdMessage gTCmdMessage) {
        try {
            Class c2 = x.a().c(context);
            if (c2 != null) {
                Intent intent = new Intent(context, c2);
                Bundle bundle = new Bundle();
                bundle.putInt("action", 10010);
                bundle.putSerializable(PushConsts.KEY_CMD_MSG, gTCmdMessage);
                intent.putExtras(bundle);
                context.startService(intent);
            }
        } catch (Throwable th) {
            b.a("PushManager|" + th.toString(), new Object[0]);
        }
    }

    private void a(Context context, String str, String str2) {
        a(context, (GTCmdMessage) new BindAliasCmdMessage(str, str2, 10010));
    }

    private boolean a(Context context, Intent intent) {
        return x.a().a(context, intent);
    }

    private void b(Context context) {
        if (this.i == null && Build.VERSION.SDK_INT >= 14) {
            a.execute(new d(this, context));
        }
    }

    private void b(Context context, String str, String str2) {
        a(context, (GTCmdMessage) new UnBindAliasCmdMessage(str, str2, 10011));
    }

    private void c(Context context) {
        if (this.i != null && Build.VERSION.SDK_INT >= 14) {
            a.execute(new e(this, context));
        }
    }

    private void c(Context context, String str, String str2) {
        a(context, (GTCmdMessage) new SetTagCmdMessage(str, str2, PushConsts.SET_TAG_RESULT));
    }

    /* access modifiers changed from: private */
    public Application d(Context context) {
        if (context == null || !e(context)) {
            return null;
        }
        return context instanceof Application ? (Application) context : (Application) context.getApplicationContext();
    }

    private boolean e(Context context) {
        return true;
    }

    private static void f(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
    }

    public static PushManager getInstance() {
        return f.a;
    }

    private <T extends Activity> void registerPushActivity(Context context, Class<T> cls) {
        String str;
        if (cls != null) {
            try {
                Class.forName(cls.getName());
                if (a.a(context, (Class) cls)) {
                    str = cls.getName();
                } else {
                    return;
                }
            } catch (Exception e2) {
                c a2 = c.a();
                a2.a("[PushManager]can't load activity = " + e2.toString());
                b.a("PushManager|registerPushActiviy|" + e2.toString(), new Object[0]);
                return;
            } catch (Throwable th) {
                b.a("PushManager|registerPushActiviy|" + th.toString(), new Object[0]);
                return;
            }
        } else {
            Log.d("PushManager", "call -> registerPushActiviy, parameter [activity] is null");
            str = "";
        }
        this.h = str;
        if (this.f != null) {
            Intent intent = new Intent(context.getApplicationContext(), this.f);
            intent.putExtra("ua", this.h);
            a(context, intent);
        }
    }

    public boolean bindAlias(Context context, String str) {
        return bindAlias(context, str, "bindAlias_" + System.currentTimeMillis());
    }

    public boolean bindAlias(Context context, String str, String str2) {
        c.a().a("[PushManager]call bindAlias");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.d < 1000) {
            c.a().a("[PushManager]call - > bindAlias failed, it be called too frequently");
            a(context, str2, "30001");
            return false;
        }
        this.d = currentTimeMillis;
        Bundle bundle = new Bundle();
        bundle.putString("action", "bindAlias");
        bundle.putString("alias", str);
        bundle.putString("sn", str2);
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }

    public void checkManifest(Context context) {
        a.c(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c A[Catch:{ Exception -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046 A[Catch:{ Exception -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0050 A[Catch:{ Exception -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0091 A[Catch:{ Exception -> 0x0098 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getClientid(android.content.Context r6) {
        /*
            r5 = this;
            byte[] r0 = r5.e
            r1 = 0
            if (r0 != 0) goto L_0x00b3
            android.content.pm.PackageManager r0 = r6.getPackageManager()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r2 = r6.getPackageName()     // Catch:{ Exception -> 0x0098 }
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r2, r3)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x0034
            android.os.Bundle r3 = r0.metaData     // Catch:{ Exception -> 0x0098 }
            if (r3 == 0) goto L_0x0034
            android.os.Bundle r2 = r0.metaData     // Catch:{ Exception -> 0x0098 }
            java.lang.String r3 = "PUSH_APPID"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x0098 }
            android.os.Bundle r3 = r0.metaData     // Catch:{ Exception -> 0x0098 }
            java.lang.String r4 = "PUSH_APPSECRET"
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x0098 }
            android.os.Bundle r0 = r0.metaData     // Catch:{ Exception -> 0x0098 }
            java.lang.String r4 = "PUSH_APPKEY"
            java.lang.String r0 = r0.getString(r4)     // Catch:{ Exception -> 0x0098 }
            goto L_0x0036
        L_0x0034:
            r0 = r2
            r3 = r0
        L_0x0036:
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0098 }
            if (r4 == 0) goto L_0x0040
            java.lang.String r2 = com.igexin.push.core.b.a.a(r6)     // Catch:{ Exception -> 0x0098 }
        L_0x0040:
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0098 }
            if (r4 == 0) goto L_0x004a
            java.lang.String r0 = com.igexin.push.core.b.a.b(r6)     // Catch:{ Exception -> 0x0098 }
        L_0x004a:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0098 }
            if (r4 == 0) goto L_0x0054
            java.lang.String r3 = com.igexin.push.core.b.a.c(r6)     // Catch:{ Exception -> 0x0098 }
        L_0x0054:
            java.lang.String r2 = r2.trim()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0098 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0098 }
            if (r4 != 0) goto L_0x00b3
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0098 }
            if (r4 != 0) goto L_0x00b3
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0098 }
            if (r4 != 0) goto L_0x00b3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0098 }
            r4.<init>()     // Catch:{ Exception -> 0x0098 }
            r4.append(r2)     // Catch:{ Exception -> 0x0098 }
            r4.append(r3)     // Catch:{ Exception -> 0x0098 }
            r4.append(r0)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r0 = r6.getPackageName()     // Catch:{ Exception -> 0x0098 }
            r4.append(r0)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r0 = r5.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0098 }
            if (r0 == 0) goto L_0x00b3
            byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x0098 }
            r5.e = r0     // Catch:{ Exception -> 0x0098 }
            goto L_0x00b3
        L_0x0098:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "PushManager|"
            r2.append(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.Object[] r2 = new java.lang.Object[r1]
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r2)
        L_0x00b3:
            byte[] r0 = r5.e
            if (r0 == 0) goto L_0x00f9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r6 = r6.getFilesDir()
            java.lang.String r6 = r6.getPath()
            r0.append(r6)
            java.lang.String r6 = "/"
            r0.append(r6)
            java.lang.String r6 = "init.pid"
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            byte[] r6 = com.igexin.push.util.c.a((java.lang.String) r6)
            if (r6 == 0) goto L_0x00f9
            byte[] r0 = r5.e
            int r0 = r0.length
            int r2 = r6.length
            if (r0 != r2) goto L_0x00f9
            int r0 = r6.length
            byte[] r2 = new byte[r0]
        L_0x00e4:
            if (r1 >= r0) goto L_0x00f3
            byte[] r3 = r5.e
            byte r3 = r3[r1]
            byte r4 = r6[r1]
            r3 = r3 ^ r4
            byte r3 = (byte) r3
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x00e4
        L_0x00f3:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r2)
            return r6
        L_0x00f9:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.sdk.PushManager.getClientid(android.content.Context):java.lang.String");
    }

    public String getVersion(Context context) {
        return "4.4.3.1";
    }

    public void initialize(Context context) {
        c a2;
        String str;
        c a3;
        String str2;
        try {
            f(context);
            if (TextUtils.isEmpty(this.g)) {
                Class cls = (Class) com.igexin.push.util.b.a(context, GTIntentService.class).second;
                if (cls != null) {
                    this.g = cls.getName();
                    a3 = c.a();
                    str2 = "[PushManager] initialize intentService = " + this.g;
                } else {
                    a3 = c.a();
                    str2 = "[PushManager] initialize intentService = NULL!";
                }
                a3.a(str2);
            }
            if (this.f == null) {
                Class cls2 = (Class) com.igexin.push.util.b.a(context, PushService.class).second;
                this.f = cls2;
                if (cls2 == null) {
                    a2 = c.a();
                    str = "[PushManager] initialize uService = NULL!";
                } else {
                    a2 = c.a();
                    str = "[PushManager] initialize uService = " + this.f.getName();
                }
                a2.a(str);
            }
            initialize(context, this.f);
        } catch (Exception e2) {
            b.a("PushManager|initialize|" + e2.toString(), new Object[0]);
            c.a().a("[PushManager] initialize sdk error = " + e2.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003e, code lost:
        if (r2 != false) goto L_0x0040;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends android.app.Service> void initialize(android.content.Context r6, java.lang.Class<T> r7) {
        /*
            r5 = this;
            r0 = 0
            com.igexin.b.a.c.a.c r1 = com.igexin.b.a.c.a.c.a()     // Catch:{ all -> 0x009a }
            java.lang.String r2 = "[PushManager]Start initializing sdk"
            r1.a((java.lang.String) r2)     // Catch:{ all -> 0x009a }
            android.content.Context r1 = r6.getApplicationContext()     // Catch:{ all -> 0x009a }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x009a }
            java.lang.String r2 = "PushManager"
            boolean r2 = com.igexin.push.util.a.a((java.lang.String) r2, (android.content.Context) r6, r7)     // Catch:{ all -> 0x009a }
            if (r2 != 0) goto L_0x002b
            java.lang.String r6 = "PushManager|init checkServiceSetCorrectly false"
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ all -> 0x009a }
            com.igexin.b.a.c.b.a((java.lang.String) r6, (java.lang.Object[]) r7)     // Catch:{ all -> 0x009a }
            com.igexin.b.a.c.a.c r6 = com.igexin.b.a.c.a.c.a()     // Catch:{ all -> 0x009a }
            java.lang.String r7 = "[PushManager]initialize failed,please check your push service!!"
            r6.a((java.lang.String) r7)     // Catch:{ all -> 0x009a }
            return
        L_0x002b:
            android.content.Context r2 = r6.getApplicationContext()     // Catch:{ all -> 0x009a }
            com.igexin.push.util.a.a((android.content.Context) r2)     // Catch:{ all -> 0x009a }
            if (r7 == 0) goto L_0x0040
            java.lang.String r2 = com.igexin.push.core.CoreConsts.p     // Catch:{ all -> 0x009a }
            java.lang.String r3 = r7.getName()     // Catch:{ all -> 0x009a }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x009a }
            if (r2 == 0) goto L_0x0042
        L_0x0040:
            java.lang.Class<com.igexin.sdk.PushService> r7 = com.igexin.sdk.PushService.class
        L_0x0042:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ all -> 0x009a }
            android.content.Context r3 = r6.getApplicationContext()     // Catch:{ all -> 0x009a }
            r2.<init>(r3, r7)     // Catch:{ all -> 0x009a }
            java.lang.String r3 = "action"
            java.lang.String r4 = com.igexin.sdk.PushConsts.ACTION_SERVICE_INITIALIZE     // Catch:{ all -> 0x009a }
            r2.putExtra(r3, r4)     // Catch:{ all -> 0x009a }
            java.lang.String r3 = "op_app"
            r2.putExtra(r3, r1)     // Catch:{ all -> 0x009a }
            java.lang.String r1 = "us"
            java.lang.String r3 = r7.getName()     // Catch:{ all -> 0x009a }
            r2.putExtra(r1, r3)     // Catch:{ all -> 0x009a }
            java.lang.String r1 = r5.g     // Catch:{ all -> 0x009a }
            if (r1 == 0) goto L_0x0069
            java.lang.String r3 = "uis"
            r2.putExtra(r3, r1)     // Catch:{ all -> 0x009a }
        L_0x0069:
            java.lang.String r1 = r5.h     // Catch:{ all -> 0x009a }
            if (r1 == 0) goto L_0x0072
            java.lang.String r3 = "ua"
            r2.putExtra(r3, r1)     // Catch:{ all -> 0x009a }
        L_0x0072:
            boolean r1 = r5.a((android.content.Context) r6, (android.content.Intent) r2)     // Catch:{ all -> 0x009a }
            if (r1 == 0) goto L_0x0096
            r5.f = r7     // Catch:{ all -> 0x009a }
            com.igexin.b.a.c.a.c r1 = com.igexin.b.a.c.a.c.a()     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r2.<init>()     // Catch:{ all -> 0x009a }
            java.lang.String r3 = "[PushManager]start pushService = "
            r2.append(r3)     // Catch:{ all -> 0x009a }
            java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x009a }
            r2.append(r7)     // Catch:{ all -> 0x009a }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x009a }
            r1.a((java.lang.String) r7)     // Catch:{ all -> 0x009a }
        L_0x0096:
            r5.b(r6)     // Catch:{ all -> 0x009a }
            goto L_0x00d1
        L_0x009a:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "PushManager|initialize|"
            r7.append(r1)
            java.lang.String r1 = r6.toString()
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.igexin.b.a.c.b.a((java.lang.String) r7, (java.lang.Object[]) r0)
            com.igexin.b.a.c.a.c r7 = com.igexin.b.a.c.a.c.a()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "[PushManager]initialize sdk error = "
            r0.append(r1)
            java.lang.String r6 = r6.toString()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.a((java.lang.String) r6)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.sdk.PushManager.initialize(android.content.Context, java.lang.Class):void");
    }

    public boolean isPushTurnedOn(Context context) {
        return new d(context).c();
    }

    @Deprecated
    public <T extends GTIntentService> void registerPushIntentService(Context context, Class<T> cls) {
        String str;
        c.a().a("[PushManager]call registerPushIntentService");
        if (cls != null) {
            try {
                Class.forName(cls.getName());
                if (!a.a(new Intent(context, cls), context)) {
                    c a2 = c.a();
                    a2.a("[PushManager]call - > registerPushIntentService, parameter [userIntentService] is set, but didn't find class \"" + cls.getName() + "\", please check your AndroidManifest");
                    return;
                }
                str = cls.getName();
            } catch (Exception e2) {
                c a3 = c.a();
                a3.a("[PushManager]error, can't load IntentService = " + e2.toString());
                b.a("PushManager|registerPushIntentService|" + e2.toString(), new Object[0]);
                return;
            } catch (Throwable th) {
                b.a("PushManager|registerPushIntentService|" + th.toString(), new Object[0]);
                c a4 = c.a();
                a4.a("[PushManager]registerPushIntentService failed = " + th.toString());
                return;
            }
        } else {
            Log.d("PushManager", "call -> registerPushIntentService, parameter [userIntentService] is null, use default Receiver");
            str = "";
        }
        this.g = str;
        if (this.f != null) {
            Intent intent = new Intent(context.getApplicationContext(), this.f);
            intent.putExtra("uis", this.g);
            a(context, intent);
        }
    }

    public boolean sendApplinkFeedback(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            c.a().a("[PushManager]call - > sendApplinkFeedback failed, parameter is illegal");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("action", "sendApplinkFeedback");
        bundle.putString("url", str);
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }

    public boolean sendFeedbackMessage(Context context, String str, String str2, int i2) {
        boolean z = (i2 >= 60001 && i2 <= 60999) || (i2 >= 90001 && i2 <= 90999);
        if (str == null || str2 == null || !z) {
            c.a().a("[PushManager]call - > sendFeedbackMessage failed, parameter is illegal");
            return false;
        }
        int a2 = a(i2, str2);
        Bundle bundle = new Bundle();
        bundle.putString("action", "sendFeedbackMessage");
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("actionid", String.valueOf(a2));
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }

    public boolean sendMessage(Context context, String str, byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || bArr == null || ((long) bArr.length) > 4096 || currentTimeMillis - this.c < 1000) {
            c.a().a("[PushManager]call - > sendMessage failed, parameter is illegal or it be called too frequently");
            return false;
        }
        this.c = currentTimeMillis;
        Bundle bundle = new Bundle();
        bundle.putString("action", "sendMessage");
        bundle.putString("taskid", str);
        bundle.putByteArray("extraData", bArr);
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }

    public void setDebugLogger(Context context, IUserLoggerInterface iUserLoggerInterface) {
        if (context == null || iUserLoggerInterface == null) {
            throw new IllegalArgumentException("context or loggerInterface can not be null");
        } else if (!a.d(context)) {
            iUserLoggerInterface.log("only run in debug mode");
        } else {
            try {
                if (e(context)) {
                    c.a().a(context, iUserLoggerInterface);
                } else {
                    iUserLoggerInterface.log("setDebugLogger, must be called in main process!");
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean setHeartbeatInterval(Context context, int i2) {
        if (i2 < 0) {
            c.a().a("[PushManager]call -> setHeartbeatInterval failed, parameter [interval] < 0, illegal");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("action", "setHeartbeatInterval");
        bundle.putInt("interval", i2);
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }

    public boolean setHwBadgeNum(Context context, int i2) {
        c.a().a("[PushManager]call - > setHwBadgeNum");
        try {
            Bundle bundle = new Bundle();
            bundle.putString("action", "setHwBadgeNum");
            bundle.putInt("badgeNum", i2);
            Intent intent = new Intent(context.getApplicationContext(), a(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return a(context, intent);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean setSilentTime(Context context, int i2, int i3) {
        if (i2 < 0 || i2 >= 24 || i3 < 0 || i3 > 23) {
            c.a().a("[PushManager]call - > setSilentTime failed, parameter [beginHour] or [duration] value exceeding");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("action", "setSilentTime");
        bundle.putInt("beginHour", i2);
        bundle.putInt("duration", i3);
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }

    public boolean setSocketTimeout(Context context, int i2) {
        if (i2 < 0) {
            c.a().a("[PushManager]call - > setSocketTimeout failed, parameter [timeout] < 0, illegal");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("action", "setSocketTimeout");
        bundle.putInt("timeout", i2);
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }

    public int setTag(Context context, Tag[] tagArr, String str) {
        if (tagArr == null) {
            c.a().a("[PushManager]call -> setTag failed, parameter [tags] is null");
            b.a("PushManager|tags is null", new Object[0]);
            c(context, str, "20006");
            return PushConsts.SETTAG_ERROR_NULL;
        } else if (str == null) {
            c.a().a("[PushManager]call -> setTag failed, parameter [sn] is null");
            b.a("PushManager|sn is null", new Object[0]);
            c(context, str, "20007");
            return PushConsts.SETTAG_SN_NULL;
        } else if (((long) tagArr.length) > 200) {
            c.a().a("[PushManager]call -> setTag failed, parameter [tags] len > 200 is exceeds");
            b.a("PushManager|tags len > 200 is exceeds", new Object[0]);
            c(context, str, PushConsts.SEND_MESSAGE_ERROR_GENERAL);
            return PushConsts.SETTAG_ERROR_COUNT;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.b < 1000) {
                c.a().a("[PushManager]call - > setTag failed, it be called too frequently");
                c(context, str, PushConsts.SEND_MESSAGE_ERROR_TIME_OUT);
                return PushConsts.SETTAG_ERROR_FREQUENCY;
            }
            StringBuilder sb = new StringBuilder();
            for (Tag tag : tagArr) {
                if (!(tag == null || tag.getName() == null)) {
                    if (tag.getName().contains(" ") || tag.getName().contains(",")) {
                        c.a().a("[PushManager]call -> setTag failed, the tag [" + tag.getName() + "]" + " is not illegal");
                        c(context, str, "20011");
                        return PushConsts.SETTAG_TAG_ILLEGAL;
                    }
                    sb.append(tag.getName());
                    sb.append(",");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                c.a().a("[PushManager]call setTag");
                Bundle bundle = new Bundle();
                bundle.putString("action", "setTag");
                bundle.putString("tags", sb.toString());
                bundle.putString("sn", str);
                this.b = currentTimeMillis;
                Intent intent = new Intent(context.getApplicationContext(), a(context));
                intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra("bundle", bundle);
                a(context, intent);
                return 0;
            }
            c(context, str, "20006");
            return PushConsts.SETTAG_ERROR_NULL;
        }
    }

    public void turnOffPush(Context context) {
        c.a().a("[PushManager]call turnOffPush");
        Bundle bundle = new Bundle();
        bundle.putString("action", "turnOffPush");
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        a(context, intent);
        c(context);
    }

    public void turnOnPush(Context context) {
        c.a().a("[PushManager]call turnOnPush");
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra("action", PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE);
        intent.putExtra("op_app", context.getApplicationContext().getPackageName());
        intent.putExtra("isSlave", true);
        a(context, intent);
        b(context);
    }

    public boolean unBindAlias(Context context, String str, boolean z) {
        return unBindAlias(context, str, z, "unBindAlias_" + System.currentTimeMillis());
    }

    public boolean unBindAlias(Context context, String str, boolean z, String str2) {
        c.a().a("[PushManager]call unBindAlias");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.d < 1000) {
            c.a().a("[PushManager]call - > unBindAlias failed, it be called too frequently");
            b(context, str2, "30001");
            return false;
        }
        this.d = currentTimeMillis;
        Bundle bundle = new Bundle();
        bundle.putString("action", "unbindAlias");
        bundle.putString("alias", str);
        bundle.putBoolean("isSeft", z);
        bundle.putString("sn", str2);
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }
}
