package com.igexin.push.extension.distribution.basic.a;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.igexin.b.a.c.b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.d;
import com.igexin.push.extension.distribution.basic.c.e;
import com.igexin.push.extension.distribution.basic.g.c;
import com.igexin.push.extension.distribution.basic.g.f;
import com.igexin.sdk.PushConsts;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

public class a implements com.igexin.push.core.a.a.a {
    private static final String a = ("EXT-" + a.class.getName());

    private int a() {
        try {
            Field field = Class.forName("com.android.internal.R$id").getField("icon");
            field.setAccessible(true);
            return field.getInt((Object) null);
        } catch (Exception unused) {
            return 0;
        }
    }

    private int a(com.igexin.push.extension.distribution.basic.b.a aVar, boolean z) {
        if (z) {
            int identifier = d.g.getResources().getIdentifier("push_small", "drawable", d.e);
            if (identifier == 0) {
                identifier = d.g.getResources().getIdentifier("push_small", "mipmap", d.e);
            }
            if (identifier != 0) {
                b.a(a + "|push_small.png is set, use default push_small", new Object[0]);
                return identifier;
            }
            b.a(a + "|push_small.png is missing", new Object[0]);
        }
        int identifier2 = d.g.getResources().getIdentifier("push", "drawable", d.e);
        if (identifier2 == 0) {
            identifier2 = d.g.getResources().getIdentifier("push", "mipmap", d.e);
        }
        if (TextUtils.isEmpty(aVar.p())) {
            if (identifier2 != 0) {
                return identifier2;
            }
            return 17301651;
        } else if ("null".equals(aVar.p())) {
            return 17301651;
        } else {
            if (aVar.p().startsWith("@")) {
                String p = aVar.p();
                return p.substring(1, p.length()).endsWith("email") ? 17301647 : 17301651;
            }
            int identifier3 = d.g.getResources().getIdentifier(aVar.p(), "drawable", d.e);
            if (identifier3 == 0) {
                identifier3 = d.g.getResources().getIdentifier(aVar.p(), "mipmap", d.e);
            }
            if (identifier3 != 0) {
                return identifier3;
            }
            if (identifier2 != 0) {
                return identifier2;
            }
            return 17301651;
        }
    }

    private int a(String str) {
        int i = 0;
        for (int i2 = 0; i2 != str.length(); i2++) {
            i = (i * 131) + str.charAt(i2);
        }
        if (i == Integer.MIN_VALUE) {
            i = 1;
        }
        return Math.abs(i);
    }

    private Notification.Builder a(com.igexin.push.extension.distribution.basic.b.a aVar) {
        Notification.Builder builder = new Notification.Builder(d.g);
        NotificationManager notificationManager = (NotificationManager) d.g.getSystemService("notification");
        try {
            Class<?> cls = Class.forName("android.app.NotificationChannel");
            Constructor<?> constructor = cls.getConstructor(new Class[]{String.class, CharSequence.class, Integer.TYPE});
            int d = aVar.g() ? 4 : aVar.d();
            Class<?> cls2 = notificationManager.getClass();
            if (((Parcelable) cls2.getMethod("getNotificationChannel", new Class[]{String.class}).invoke(notificationManager, new Object[]{aVar.b()})) == null) {
                Parcelable parcelable = (Parcelable) constructor.newInstance(new Object[]{aVar.b(), aVar.c(), Integer.valueOf(d)});
                Method method = cls2.getMethod("createNotificationChannel", new Class[]{Class.forName("android.app.NotificationChannel")});
                Method method2 = cls.getMethod("enableVibration", new Class[]{Boolean.TYPE});
                Method method3 = cls.getMethod("setSound", new Class[]{Uri.class, AudioAttributes.class});
                method2.invoke(parcelable, new Object[]{Boolean.valueOf(aVar.x())});
                if (!aVar.y()) {
                    method3.invoke(parcelable, new Object[]{null, null});
                } else if (!TextUtils.isEmpty(aVar.z())) {
                    method3.invoke(parcelable, new Object[]{b(aVar.z()), null});
                }
                method.invoke(notificationManager, new Object[]{parcelable});
            }
            builder.getClass().getMethod("setChannelId", new Class[]{String.class}).invoke(builder, new Object[]{aVar.b()});
        } catch (Exception unused) {
        }
        return builder;
    }

    private Notification a(Notification notification, com.igexin.push.extension.distribution.basic.b.a aVar) {
        notification.defaults = 4;
        notification.ledARGB = -16711936;
        notification.ledOnMS = ResultCode.KARAOKE_SUCCESS;
        notification.ledOffMS = 3000;
        notification.flags = 1;
        if (aVar.y()) {
            if (TextUtils.isEmpty(aVar.z())) {
                notification.defaults |= 1;
            } else {
                notification.sound = b(aVar.z());
            }
        }
        notification.flags = aVar.B() ? notification.flags | 16 : notification.flags | 32;
        if (aVar.x()) {
            notification.defaults |= 2;
        }
        notification.icon = a(aVar, true);
        return notification;
    }

    private PendingIntent a(Intent intent) {
        return PendingIntent.getService(d.g, new Random().nextInt(ResultCode.KARAOKE_SUCCESS), intent, (com.igexin.push.extension.distribution.basic.g.d.a(d.g) < 31 || Build.VERSION.SDK_INT < 30) ? 134217728 : 67108864);
    }

    private PendingIntent a(String str, String str2, int i, com.igexin.push.extension.distribution.basic.b.a aVar, boolean z) {
        Intent intent = new Intent(com.igexin.push.extension.distribution.basic.c.b.a);
        intent.putExtra("taskid", str);
        intent.putExtra("messageid", str2);
        intent.putExtra("appid", d.a);
        intent.putExtra("actionid", aVar.getDoActionId());
        intent.putExtra("accesstoken", e.d);
        intent.putExtra("notifID", i);
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.u());
        String str3 = "";
        sb.append(str3);
        intent.putExtra("notifyStyle", sb.toString());
        intent.putExtra("id", aVar.f() + str3);
        intent.putExtra("bigStyle", aVar.i() + str3);
        intent.putExtra("isFloat", z);
        intent.putExtra("checkpackage", d.g.getPackageName());
        intent.putExtra("feedbackid", aVar.getActionId().substring(aVar.getActionId().length() + -1));
        String n = aVar.n();
        if (n == null) {
            n = str3;
        }
        intent.putExtra("title", n);
        String o = aVar.o();
        if (o != null) {
            str3 = o;
        }
        intent.putExtra(FirebaseAnalytics.Param.CONTENT, str3);
        if (c.a("4.4.3.1", "2.11.0.0") < 0) {
            return PendingIntent.getBroadcast(d.g, new Random().nextInt(ResultCode.KARAOKE_SUCCESS), intent, 134217728);
        }
        if (com.igexin.push.extension.distribution.basic.g.d.a(d.g) < 31 || Build.VERSION.SDK_INT < 30) {
            try {
                Intent intent2 = new Intent(d.g, Class.forName(com.igexin.push.extension.distribution.basic.g.e.a(e.a)));
                intent2.putExtra("action", PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK);
                intent2.putExtra("broadcast_intent", intent);
                return a(intent2);
            } catch (Throwable unused) {
                return PendingIntent.getBroadcast(d.g, new Random().nextInt(ResultCode.KARAOKE_SUCCESS), intent, 134217728);
            }
        } else {
            try {
                Intent intent3 = new Intent(d.g, Class.forName("com.igexin.sdk.GetuiActivity"));
                intent3.setFlags(268435456);
                intent3.putExtra("action", PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK);
                intent3.putExtra("broadcast_intent", intent);
                return PendingIntent.getActivity(d.g, new Random().nextInt(ResultCode.KARAOKE_SUCCESS), intent3, 67108864);
            } catch (ClassNotFoundException unused2) {
                return PendingIntent.getBroadcast(d.g, new Random().nextInt(ResultCode.KARAOKE_SUCCESS), intent, 67108864);
            }
        }
    }

    private PendingIntent a(String str, String str2, String str3, int i, com.igexin.push.extension.distribution.basic.b.a aVar, boolean z) {
        try {
            Intent intent = new Intent(d.g, Class.forName(com.igexin.push.extension.distribution.basic.g.e.a(e.a)));
            intent.putExtra("taskid", str2);
            intent.putExtra("messageid", str3);
            intent.putExtra("appid", d.a);
            intent.putExtra("appkey", str);
            intent.putExtra("actionid", aVar.getDoActionId());
            intent.putExtra("notifyStyle", aVar.u() + "");
            intent.putExtra("id", aVar.f() + "");
            intent.putExtra("feedbackid", aVar.getActionId().substring(aVar.getActionId().length() + -1));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_NOTIFICATION_DELETE);
            return a(intent);
        } catch (Exception e) {
            b.a(a + "|getDelPendingIntent err：" + e.toString(), new Object[0]);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17) {
        /*
            r13 = this;
            r1 = r13
            java.lang.String r2 = "4.4.3.1"
            android.content.Context r0 = com.igexin.push.core.d.g
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            r3 = 0
            r4 = 1902131808(0x71603a60, float:1.1103234E30)
            r5 = 0
            android.content.Context r0 = com.igexin.push.core.d.g     // Catch:{ all -> 0x00a7 }
            java.lang.Class r0 = r13.b((android.content.Context) r0)     // Catch:{ all -> 0x00a7 }
            if (r0 == 0) goto L_0x00dc
            java.lang.String r6 = com.igexin.push.core.d.a     // Catch:{ all -> 0x00a7 }
            if (r6 == 0) goto L_0x00dc
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x00a7 }
            android.content.Context r7 = com.igexin.push.core.d.g     // Catch:{ all -> 0x00a7 }
            r6.<init>(r7, r0)     // Catch:{ all -> 0x00a7 }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x00a4 }
            r0.<init>()     // Catch:{ all -> 0x00a4 }
            java.lang.String r3 = "action"
            r7 = 10011(0x271b, float:1.4028E-41)
            r0.putInt(r3, r7)     // Catch:{ all -> 0x00a4 }
            java.lang.String r3 = "com.igexin.sdk.message.GTNotificationMessage"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x00a4 }
            java.lang.String r7 = "2.12.0.0"
            int r7 = com.igexin.push.extension.distribution.basic.g.c.a(r2, r7)     // Catch:{ all -> 0x00a4 }
            r8 = 1
            r9 = 2
            if (r7 != 0) goto L_0x005c
            java.lang.Class[] r7 = new java.lang.Class[r9]     // Catch:{ all -> 0x00a4 }
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            r7[r5] = r10     // Catch:{ all -> 0x00a4 }
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            r7[r8] = r10     // Catch:{ all -> 0x00a4 }
            java.lang.reflect.Constructor r3 = r3.getConstructor(r7)     // Catch:{ all -> 0x00a4 }
            java.lang.String r7 = "notification_arrive"
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x00a4 }
            r9[r5] = r14     // Catch:{ all -> 0x00a4 }
            r9[r8] = r15     // Catch:{ all -> 0x00a4 }
            java.lang.Object r3 = r3.newInstance(r9)     // Catch:{ all -> 0x00a4 }
            java.io.Serializable r3 = (java.io.Serializable) r3     // Catch:{ all -> 0x00a4 }
            r0.putSerializable(r7, r3)     // Catch:{ all -> 0x00a4 }
            goto L_0x0089
        L_0x005c:
            r7 = 4
            java.lang.Class[] r10 = new java.lang.Class[r7]     // Catch:{ all -> 0x00a4 }
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            r10[r5] = r11     // Catch:{ all -> 0x00a4 }
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            r10[r8] = r11     // Catch:{ all -> 0x00a4 }
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            r10[r9] = r11     // Catch:{ all -> 0x00a4 }
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            r12 = 3
            r10[r12] = r11     // Catch:{ all -> 0x00a4 }
            java.lang.reflect.Constructor r3 = r3.getConstructor(r10)     // Catch:{ all -> 0x00a4 }
            java.lang.String r10 = "notification_arrived"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x00a4 }
            r7[r5] = r14     // Catch:{ all -> 0x00a4 }
            r7[r8] = r15     // Catch:{ all -> 0x00a4 }
            r7[r9] = r16     // Catch:{ all -> 0x00a4 }
            r7[r12] = r17     // Catch:{ all -> 0x00a4 }
            java.lang.Object r3 = r3.newInstance(r7)     // Catch:{ all -> 0x00a4 }
            java.io.Serializable r3 = (java.io.Serializable) r3     // Catch:{ all -> 0x00a4 }
            r0.putSerializable(r10, r3)     // Catch:{ all -> 0x00a4 }
        L_0x0089:
            r6.putExtras(r0)     // Catch:{ all -> 0x00a4 }
            android.content.Context r0 = com.igexin.push.core.d.g     // Catch:{ all -> 0x00a4 }
            boolean r0 = r13.a((android.content.Context) r0)     // Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x009e
            com.igexin.push.extension.distribution.basic.c.a r0 = com.igexin.push.extension.distribution.basic.c.a.a()     // Catch:{ all -> 0x00a4 }
            android.content.Context r3 = com.igexin.push.core.d.g     // Catch:{ all -> 0x00a4 }
            r0.a(r3, r6, r4)     // Catch:{ all -> 0x00a4 }
            goto L_0x00dc
        L_0x009e:
            android.content.Context r0 = com.igexin.push.core.d.g     // Catch:{ all -> 0x00a4 }
            r0.startService(r6)     // Catch:{ all -> 0x00a4 }
            goto L_0x00dc
        L_0x00a4:
            r0 = move-exception
            r3 = r6
            goto L_0x00a8
        L_0x00a7:
            r0 = move-exception
        L_0x00a8:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = a
            r6.append(r7)
            java.lang.String r7 = "|"
            r6.append(r7)
            java.lang.String r7 = r0.toString()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            com.igexin.b.a.c.b.a((java.lang.String) r6, (java.lang.Object[]) r5)
            boolean r0 = r0 instanceof java.lang.IllegalStateException
            if (r0 == 0) goto L_0x00dc
            java.lang.String r0 = "2.13.1.0"
            int r0 = com.igexin.push.extension.distribution.basic.g.c.a(r2, r0)
            if (r0 < 0) goto L_0x00dc
            com.igexin.push.extension.distribution.basic.c.a r0 = com.igexin.push.extension.distribution.basic.c.a.a()
            android.content.Context r2 = com.igexin.push.core.d.g
            r0.a(r2, r3, r4)
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.a.a.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private boolean a(Context context) {
        return c.a("4.4.3.1", "2.13.1.0") >= 0 && com.igexin.push.extension.distribution.basic.g.b.b();
    }

    private Uri b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Uri.parse("android.resource://" + d.g.getPackageName() + "/raw/" + str.toLowerCase());
        } catch (Throwable unused) {
            return null;
        }
    }

    private Class b(Context context) {
        try {
            com.igexin.push.extension.distribution.basic.d.a.a();
            String c = com.igexin.push.extension.distribution.basic.d.a.c();
            if (!TextUtils.isEmpty(c)) {
                return Class.forName(c);
            }
            return null;
        } catch (Throwable th) {
            b.a(a + "|" + th.toString(), new Object[0]);
            return null;
        }
    }

    private Bitmap c(String str) {
        if (str != null) {
            try {
                Bitmap decodeFile = BitmapFactoryInstrumentation.decodeFile(str);
                if (decodeFile != null) {
                    return decodeFile;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.igexin.push.core.a a(com.igexin.push.core.bean.PushTaskBean r11, com.igexin.push.core.bean.BaseAction r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.igexin.push.extension.distribution.basic.b.a
            if (r0 == 0) goto L_0x006e
            r0 = r12
            com.igexin.push.extension.distribution.basic.b.a r0 = (com.igexin.push.extension.distribution.basic.b.a) r0
            java.lang.String r2 = r0.q()
            java.lang.String r7 = r0.m()
            java.lang.String r8 = r11.getTaskId()
            java.lang.String r11 = r11.getMessageId()
            r1 = 1
            java.lang.String r3 = ""
            r4 = 0
            if (r7 == 0) goto L_0x0033
            com.igexin.push.extension.distribution.basic.c.c r5 = com.igexin.push.extension.distribution.basic.c.c.a()
            java.lang.String r5 = r5.a((java.lang.String) r7)
            boolean r6 = r5.equals(r3)
            if (r6 == 0) goto L_0x0030
            r0.c((boolean) r4)
            r9 = r1
            goto L_0x0034
        L_0x0030:
            r0.e((java.lang.String) r5)
        L_0x0033:
            r9 = r4
        L_0x0034:
            if (r2 == 0) goto L_0x004b
            com.igexin.push.extension.distribution.basic.c.c r5 = com.igexin.push.extension.distribution.basic.c.c.a()
            java.lang.String r5 = r5.a((java.lang.String) r2)
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0048
            r0.d((boolean) r4)
            goto L_0x004c
        L_0x0048:
            r0.k(r5)
        L_0x004b:
            r1 = r4
        L_0x004c:
            if (r1 != 0) goto L_0x0054
            if (r9 == 0) goto L_0x0051
            goto L_0x0054
        L_0x0051:
            com.igexin.push.core.a r11 = com.igexin.push.core.a.a
            return r11
        L_0x0054:
            if (r1 == 0) goto L_0x005e
            r6 = 2
            r1 = r10
            r3 = r8
            r4 = r11
            r5 = r12
            r1.a((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (com.igexin.push.core.bean.BaseAction) r5, (int) r6)
        L_0x005e:
            if (r9 == 0) goto L_0x006b
            r0 = 8
            r3 = r10
            r4 = r7
            r5 = r8
            r6 = r11
            r7 = r12
            r8 = r0
            r3.a((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (com.igexin.push.core.bean.BaseAction) r7, (int) r8)
        L_0x006b:
            com.igexin.push.core.a r11 = com.igexin.push.core.a.wait
            return r11
        L_0x006e:
            com.igexin.push.core.a r11 = com.igexin.push.core.a.stop
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.a.a.a(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):com.igexin.push.core.a");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00dc, code lost:
        if (r5 >= 1) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r15.b(0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:146:0x0294 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0160 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0051 A[Catch:{ Exception -> 0x02c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005e A[Catch:{ Exception -> 0x02c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b A[Catch:{ Exception -> 0x02c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a5 A[Catch:{ Exception -> 0x02c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c2 A[Catch:{ Exception -> 0x02c5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.igexin.push.core.bean.BaseAction a(org.json.JSONObject r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "is_noclear"
            java.lang.String r2 = ".png"
            java.lang.String r3 = "isFloat"
            java.lang.String r4 = "priority"
            java.lang.String r5 = "bigStyle"
            java.lang.String r6 = "text"
            java.lang.String r7 = "title"
            java.lang.String r8 = "id"
            java.lang.String r9 = "notifyStyle"
            java.lang.String r10 = "notifyid"
            java.lang.String r11 = "big_text"
            java.lang.String r12 = "big_image_url"
            java.lang.String r13 = "logo"
            java.lang.String r14 = "logo_url"
            com.igexin.push.extension.distribution.basic.b.a r15 = new com.igexin.push.extension.distribution.basic.b.a     // Catch:{ Exception -> 0x02c5 }
            r15.<init>()     // Catch:{ Exception -> 0x02c5 }
            r16 = r10
            java.lang.String r10 = "notification"
            r15.setType(r10)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r10 = "actionid"
            java.lang.String r10 = r0.getString(r10)     // Catch:{ Exception -> 0x02c5 }
            r15.setActionId(r10)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r10 = "do"
            java.lang.String r10 = r0.getString(r10)     // Catch:{ Exception -> 0x02c5 }
            r15.setDoActionId(r10)     // Catch:{ Exception -> 0x02c5 }
            boolean r10 = r0.has(r9)     // Catch:{ Exception -> 0x02c5 }
            r17 = r1
            r1 = 0
            if (r10 == 0) goto L_0x004a
            int r9 = r0.getInt(r9)     // Catch:{ Exception -> 0x004a }
            goto L_0x004b
        L_0x004a:
            r9 = r1
        L_0x004b:
            boolean r10 = r0.has(r8)     // Catch:{ Exception -> 0x02c5 }
            if (r10 == 0) goto L_0x0058
            java.lang.String r8 = r0.getString(r8)     // Catch:{ Exception -> 0x02c5 }
            r15.c((java.lang.String) r8)     // Catch:{ Exception -> 0x02c5 }
        L_0x0058:
            boolean r8 = r0.has(r7)     // Catch:{ Exception -> 0x02c5 }
            if (r8 == 0) goto L_0x0065
            java.lang.String r7 = r0.getString(r7)     // Catch:{ Exception -> 0x02c5 }
            r15.g((java.lang.String) r7)     // Catch:{ Exception -> 0x02c5 }
        L_0x0065:
            boolean r7 = r0.has(r6)     // Catch:{ Exception -> 0x02c5 }
            if (r7 == 0) goto L_0x0072
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x02c5 }
            r15.h((java.lang.String) r6)     // Catch:{ Exception -> 0x02c5 }
        L_0x0072:
            java.lang.String r6 = r15.n()     // Catch:{ Exception -> 0x02c5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x02c5 }
            r7 = 4
            if (r6 == 0) goto L_0x00a3
            java.lang.String r6 = r15.o()     // Catch:{ Exception -> 0x02c5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x02c5 }
            if (r6 == 0) goto L_0x00a3
            if (r9 == r7) goto L_0x00a3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c5 }
            r0.<init>()     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r2 = a     // Catch:{ Exception -> 0x02c5 }
            r0.append(r2)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r2 = "|title and content is empty, not support"
            r0.append(r2)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02c5 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x02c5 }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x02c5 }
            r0 = 0
            return r0
        L_0x00a3:
            if (r9 != r7) goto L_0x00c2
            r15.f((int) r7)     // Catch:{ Exception -> 0x02c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c5 }
            r0.<init>()     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r2 = a     // Catch:{ Exception -> 0x02c5 }
            r0.append(r2)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r2 = "Do not support notifyStyle4"
            r0.append(r2)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02c5 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x02c5 }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x02c5 }
            r0 = 0
            return r0
        L_0x00c2:
            java.lang.String r6 = a     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r8 = "parse notify style 0"
            com.igexin.b.a.c.b.a((java.lang.String) r6, (java.lang.String) r8)     // Catch:{ Exception -> 0x02c5 }
            r15.f((int) r1)     // Catch:{ Exception -> 0x02c5 }
            boolean r6 = r0.has(r5)     // Catch:{ Exception -> 0x02c5 }
            r8 = 3
            r9 = 1
            if (r6 == 0) goto L_0x00de
            int r5 = r0.getInt(r5)     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00da
        L_0x00d9:
            r5 = r1
        L_0x00da:
            if (r5 > r8) goto L_0x00de
            if (r5 >= r9) goto L_0x00df
        L_0x00de:
            r5 = r1
        L_0x00df:
            r15.c((int) r5)     // Catch:{ Exception -> 0x02c5 }
            boolean r6 = r0.has(r14)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r10 = "http"
            if (r6 == 0) goto L_0x00fb
            java.lang.String r6 = r0.getString(r14)     // Catch:{ Exception -> 0x02c5 }
            boolean r6 = r6.startsWith(r10)     // Catch:{ Exception -> 0x02c5 }
            if (r6 == 0) goto L_0x00fb
            java.lang.String r6 = r0.getString(r14)     // Catch:{ Exception -> 0x02c5 }
            r15.j(r6)     // Catch:{ Exception -> 0x02c5 }
        L_0x00fb:
            boolean r6 = r0.has(r13)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r14 = ""
            if (r6 == 0) goto L_0x0149
            java.lang.String r6 = r0.getString(r13)     // Catch:{ Exception -> 0x02c5 }
            boolean r6 = r14.equals(r6)     // Catch:{ Exception -> 0x02c5 }
            if (r6 != 0) goto L_0x0149
            java.lang.String r6 = r0.getString(r13)     // Catch:{ Exception -> 0x02c5 }
            int r13 = r6.lastIndexOf(r2)     // Catch:{ Exception -> 0x02c5 }
            r7 = -1
            if (r13 != r7) goto L_0x0123
            java.lang.String r13 = ".jpeg"
            int r13 = r6.lastIndexOf(r13)     // Catch:{ Exception -> 0x02c5 }
            if (r13 == r7) goto L_0x0121
            goto L_0x0123
        L_0x0121:
            r6 = r14
            goto L_0x0146
        L_0x0123:
            int r2 = r6.indexOf(r2)     // Catch:{ Exception -> 0x02c5 }
            if (r2 != r7) goto L_0x012f
            java.lang.String r2 = ".jpeg"
            int r2 = r6.indexOf(r2)     // Catch:{ Exception -> 0x02c5 }
        L_0x012f:
            if (r2 == r7) goto L_0x0146
            java.lang.String r6 = r6.substring(r1, r2)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r2 = "^\\d+$"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)     // Catch:{ Exception -> 0x02c5 }
            java.util.regex.Matcher r2 = r2.matcher(r6)     // Catch:{ Exception -> 0x02c5 }
            boolean r2 = r2.matches()     // Catch:{ Exception -> 0x02c5 }
            if (r2 == 0) goto L_0x0146
            goto L_0x0121
        L_0x0146:
            r15.i(r6)     // Catch:{ Exception -> 0x02c5 }
        L_0x0149:
            boolean r2 = r0.has(r4)     // Catch:{ Exception -> 0x0160 }
            if (r2 == 0) goto L_0x0163
            int r2 = r0.getInt(r4)     // Catch:{ Exception -> 0x0160 }
            r4 = -3
            if (r2 <= r4) goto L_0x015c
            if (r2 >= r8) goto L_0x015c
            r15.b((int) r2)     // Catch:{ Exception -> 0x0160 }
            goto L_0x0163
        L_0x015c:
            r15.b((int) r1)     // Catch:{ Exception -> 0x0160 }
            goto L_0x0163
        L_0x0160:
            r15.b((int) r1)     // Catch:{ Exception -> 0x02c5 }
        L_0x0163:
            if (r5 != r9) goto L_0x017d
            boolean r2 = r0.has(r12)     // Catch:{ Exception -> 0x02c5 }
            if (r2 == 0) goto L_0x017d
            java.lang.String r2 = r0.getString(r12)     // Catch:{ Exception -> 0x02c5 }
            boolean r2 = r2.startsWith(r10)     // Catch:{ Exception -> 0x02c5 }
            if (r2 == 0) goto L_0x017d
            java.lang.String r2 = r0.getString(r12)     // Catch:{ Exception -> 0x02c5 }
            r15.f((java.lang.String) r2)     // Catch:{ Exception -> 0x02c5 }
            goto L_0x01b4
        L_0x017d:
            r2 = 2
            if (r5 != r2) goto L_0x0198
            boolean r2 = r0.has(r11)     // Catch:{ Exception -> 0x02c5 }
            if (r2 == 0) goto L_0x0198
            java.lang.String r2 = r0.getString(r11)     // Catch:{ Exception -> 0x02c5 }
            boolean r2 = r2.equals(r14)     // Catch:{ Exception -> 0x02c5 }
            if (r2 != 0) goto L_0x0198
            java.lang.String r2 = r0.getString(r11)     // Catch:{ Exception -> 0x02c5 }
            r15.d((java.lang.String) r2)     // Catch:{ Exception -> 0x02c5 }
            goto L_0x01b4
        L_0x0198:
            if (r5 != r8) goto L_0x01b4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c5 }
            r0.<init>()     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r2 = a     // Catch:{ Exception -> 0x02c5 }
            r0.append(r2)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r2 = "big style = 3 doesn't support"
            r0.append(r2)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02c5 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x02c5 }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x02c5 }
            r0 = 0
            return r0
        L_0x01b4:
            boolean r2 = r0.has(r3)     // Catch:{ Exception -> 0x02c5 }
            if (r2 == 0) goto L_0x01c7
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x02c5 }
            r4 = 11
            if (r2 < r4) goto L_0x01c7
            boolean r2 = r0.getBoolean(r3)     // Catch:{ Exception -> 0x02c5 }
            r15.b((boolean) r2)     // Catch:{ Exception -> 0x02c5 }
        L_0x01c7:
            r2 = r17
            boolean r3 = r0.has(r2)     // Catch:{ Exception -> 0x02c5 }
            if (r3 == 0) goto L_0x01db
            boolean r2 = r0.getBoolean(r2)     // Catch:{ Exception -> 0x02c5 }
            if (r2 != 0) goto L_0x01d7
            r2 = r9
            goto L_0x01d8
        L_0x01d7:
            r2 = r1
        L_0x01d8:
            r15.g((boolean) r2)     // Catch:{ Exception -> 0x02c5 }
        L_0x01db:
            java.lang.String r2 = "is_novibrate"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02c5 }
            if (r2 == 0) goto L_0x01f1
            java.lang.String r2 = "is_novibrate"
            boolean r2 = r0.getBoolean(r2)     // Catch:{ Exception -> 0x02c5 }
            if (r2 != 0) goto L_0x01ed
            r2 = r9
            goto L_0x01ee
        L_0x01ed:
            r2 = r1
        L_0x01ee:
            r15.e((boolean) r2)     // Catch:{ Exception -> 0x02c5 }
        L_0x01f1:
            java.lang.String r2 = "is_noring"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02c5 }
            if (r2 == 0) goto L_0x0207
            java.lang.String r2 = "is_noring"
            boolean r2 = r0.getBoolean(r2)     // Catch:{ Exception -> 0x02c5 }
            if (r2 != 0) goto L_0x0203
            r2 = r9
            goto L_0x0204
        L_0x0203:
            r2 = r1
        L_0x0204:
            r15.f((boolean) r2)     // Catch:{ Exception -> 0x02c5 }
        L_0x0207:
            java.lang.String r2 = "color"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02c5 }
            if (r2 == 0) goto L_0x0218
            java.lang.String r2 = "color"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x02c5 }
            r15.l(r2)     // Catch:{ Exception -> 0x02c5 }
        L_0x0218:
            java.lang.String r2 = "channel"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02c5 }
            if (r2 == 0) goto L_0x0229
            java.lang.String r2 = "channel"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x02c5 }
            r15.a((java.lang.String) r2)     // Catch:{ Exception -> 0x02c5 }
        L_0x0229:
            java.lang.String r2 = "channelName"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02c5 }
            if (r2 == 0) goto L_0x023a
            java.lang.String r2 = "channelName"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x02c5 }
            r15.b((java.lang.String) r2)     // Catch:{ Exception -> 0x02c5 }
        L_0x023a:
            java.lang.String r2 = "channelLevel"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02c5 }
            if (r2 == 0) goto L_0x024b
            java.lang.String r2 = "channelLevel"
            int r2 = r0.getInt(r2)     // Catch:{ Exception -> 0x02c5 }
            r15.a((int) r2)     // Catch:{ Exception -> 0x02c5 }
        L_0x024b:
            java.lang.String r2 = "badgeAddNum"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02c5 }
            if (r2 == 0) goto L_0x025c
            java.lang.String r2 = "badgeAddNum"
            int r2 = r0.optInt(r2)     // Catch:{ Exception -> 0x02c5 }
            r15.h((int) r2)     // Catch:{ Exception -> 0x02c5 }
        L_0x025c:
            java.lang.String r2 = "ringName"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02c5 }
            if (r2 == 0) goto L_0x026d
            java.lang.String r2 = "ringName"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x02c5 }
            r15.m(r2)     // Catch:{ Exception -> 0x02c5 }
        L_0x026d:
            int r2 = r15.d()     // Catch:{ Exception -> 0x02c5 }
            r3 = 4
            if (r2 > r3) goto L_0x027a
            int r2 = r15.d()     // Catch:{ Exception -> 0x02c5 }
            if (r2 >= 0) goto L_0x027d
        L_0x027a:
            r15.a((int) r8)     // Catch:{ Exception -> 0x02c5 }
        L_0x027d:
            r2 = r16
            boolean r3 = r0.has(r2)     // Catch:{ Exception -> 0x02c5 }
            if (r3 == 0) goto L_0x02c4
            java.lang.String r3 = r0.optString(r2)     // Catch:{ NumberFormatException -> 0x0294 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0294 }
            r15.g((int) r3)     // Catch:{ NumberFormatException -> 0x0294 }
            r15.a((boolean) r9)     // Catch:{ NumberFormatException -> 0x0294 }
            goto L_0x02c4
        L_0x0294:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c5 }
            r3.<init>()     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r4 = " NotificationAction.parseAction() : "
            r3.append(r4)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r0 = r0.optString(r2)     // Catch:{ Exception -> 0x02c5 }
            r3.append(r0)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r0 = "_"
            r3.append(r0)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x02c5 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c5 }
            r2.<init>()     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r3 = a     // Catch:{ Exception -> 0x02c5 }
            r2.append(r3)     // Catch:{ Exception -> 0x02c5 }
            r2.append(r0)     // Catch:{ Exception -> 0x02c5 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x02c5 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x02c5 }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x02c5 }
        L_0x02c4:
            return r15
        L_0x02c5:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.a.a.a(org.json.JSONObject):com.igexin.push.core.bean.BaseAction");
    }

    public void a(String str, String str2, String str3, BaseAction baseAction, int i) {
        String str4;
        String str5;
        String str6 = str;
        int i2 = i;
        String str7 = "width=" + e.c + "&height=" + e.b;
        if (!str.contains(str7)) {
            if (str.indexOf("?") > 0) {
                str5 = str + "&" + str7;
            } else {
                str5 = str + "?" + str7;
            }
            str4 = str5;
        } else {
            str4 = str6;
        }
        String str8 = str2;
        com.igexin.push.extension.distribution.basic.f.c cVar = new com.igexin.push.extension.distribution.basic.f.c(str4, str, str8, baseAction, i, new b(this, baseAction, str8, str3, str, i));
        if (i2 == 2) {
            com.igexin.push.extension.distribution.basic.b.a aVar = (com.igexin.push.extension.distribution.basic.b.a) baseAction;
            aVar.e(aVar.t() + 1);
        } else if (i2 == 8) {
            com.igexin.push.extension.distribution.basic.b.a aVar2 = (com.igexin.push.extension.distribution.basic.b.a) baseAction;
            aVar2.d(aVar2.l() + 1);
        }
        com.igexin.b.a.b.c.b().a(new com.igexin.push.extension.distribution.basic.f.a(cVar), false, true);
    }

    public void a(String str, String str2, String str3, com.igexin.push.extension.distribution.basic.b.a aVar, int i) {
        Bitmap bitmap;
        int a2;
        Notification.Style style;
        Bitmap c;
        String str4 = str2;
        com.igexin.push.extension.distribution.basic.b.a aVar2 = aVar;
        d.af.put(str4, Integer.valueOf(i));
        PendingIntent a3 = a(str2, str3, i, aVar, false);
        PendingIntent a4 = a(str, str2, str3, i, aVar, false);
        NotificationManager notificationManager = (NotificationManager) d.g.getSystemService("notification");
        String r = aVar.r();
        String n = aVar.n();
        String o = aVar.o();
        if (r == null || "".equals(r)) {
            bitmap = null;
        } else {
            bitmap = c(r);
            StringBuilder sb = new StringBuilder();
            sb.append(a);
            sb.append("|use net logo bitmap is null = ");
            sb.append(bitmap == null);
            b.a(sb.toString(), new Object[0]);
        }
        if (bitmap == null) {
            bitmap = BitmapFactoryInstrumentation.decodeResource(e.a.getResources(), a(aVar2, false));
        }
        Notification notification = new Notification();
        if (Build.VERSION.SDK_INT >= 11) {
            Notification.Builder builder = new Notification.Builder(d.g);
            if (Build.VERSION.SDK_INT >= 26) {
                builder = a(aVar2);
            }
            int a5 = a(aVar2, true);
            if (a5 == 0 || d.g.getResources().getDrawable(a5) != null) {
                if (!TextUtils.isEmpty(n)) {
                    builder.setContentTitle(n);
                }
                if (!TextUtils.isEmpty(o)) {
                    builder.setContentText(o);
                }
                builder.setSmallIcon(a5).setTicker(aVar.o()).setWhen(System.currentTimeMillis()).setLargeIcon(bitmap).setContentIntent(a3).setDeleteIntent(a4);
                if (Build.VERSION.SDK_INT >= 24 && !TextUtils.isEmpty(aVar.v())) {
                    try {
                        builder.setColor(Color.parseColor(aVar.v()));
                    } catch (Throwable unused) {
                    }
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    if (aVar.i() == c.BIG_IMAGE.a()) {
                        String j = aVar.j();
                        if (!TextUtils.isEmpty(j) && (c = c(j)) != null) {
                            builder.setPriority(aVar.e());
                            style = new Notification.BigPictureStyle().bigPicture(c);
                        }
                    } else if (aVar.i() == c.LONG_TEXT.a()) {
                        String h = aVar.h();
                        if (!TextUtils.isEmpty(h)) {
                            builder.setPriority(aVar.e());
                            style = new Notification.BigTextStyle().bigText(h);
                        }
                    }
                    builder.setStyle(style);
                }
                if (aVar.g() && Build.VERSION.SDK_INT >= 21 && (aVar.x() || aVar.y())) {
                    builder.setPriority(2);
                }
                notification = builder.getNotification();
                a(notification, aVar2);
            } else {
                b.a(a + "|showNotification smallIconId: " + a5 + " couldn't find resource", new Object[0]);
                return;
            }
        } else {
            try {
                if (!(notification.contentView == null || bitmap == null || (a2 = a()) <= 0)) {
                    notification.contentView.setImageViewBitmap(a2, bitmap);
                }
                notification.deleteIntent = a4;
                Method method = Class.forName("android.app.Notification").getMethod("setLatestEventInfo", new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class});
                method.setAccessible(true);
                method.invoke(notification, new Object[]{d.g, n, o, a3});
            } catch (Exception unused2) {
                b.a(a + "reflect invoke setLatestEventInfo failed!", new Object[0]);
                return;
            }
        }
        f.a(notificationManager, i, notification, 0, aVar2);
        if (c.a("4.4.3.1", "2.12.0.0") >= 0) {
            a(str4, str3, n, o);
        }
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (pushTaskBean != null && (baseAction instanceof com.igexin.push.extension.distribution.basic.b.a)) {
            com.igexin.push.extension.distribution.basic.b.a aVar = (com.igexin.push.extension.distribution.basic.b.a) baseAction;
            int a2 = !aVar.a() ? a(pushTaskBean.getTaskId()) : aVar.w();
            int i = 0;
            try {
                i = Integer.parseInt(aVar.getActionId().substring(aVar.getActionId().length() - 1)) + 30000;
            } catch (Exception unused) {
            }
            a(pushTaskBean.getAppKey(), pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), aVar, a2);
            if (i != 0) {
                com.igexin.push.core.a.e.a().a(pushTaskBean, i + "", "notifyStyle:" + aVar.u());
            }
            pushTaskBean.setPerActionid(Integer.parseInt(aVar.getActionId()));
            pushTaskBean.setCurrentActionid(Integer.parseInt(aVar.getDoActionId()));
        }
        return true;
    }
}
