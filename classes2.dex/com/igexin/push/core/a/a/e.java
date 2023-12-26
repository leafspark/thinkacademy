package com.igexin.push.core.a.a;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.igexin.b.a.c.b;
import com.igexin.push.config.k;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.core.a;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.g;
import com.igexin.push.core.d;
import com.igexin.push.core.r;
import com.igexin.push.core.x;
import com.igexin.push.util.m;
import com.igexin.sdk.GetuiActivity;
import com.igexin.sdk.PushConsts;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

public class e implements a {
    private static final String a = k.a;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(com.igexin.push.core.bean.g r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "push_small"
            java.lang.String r1 = "mipmap"
            java.lang.String r2 = "drawable"
            if (r8 == 0) goto L_0x0062
            r8 = 0
            android.content.Context r3 = com.igexin.push.core.d.g     // Catch:{ all -> 0x0026 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ all -> 0x0026 }
            java.lang.String r4 = com.igexin.push.core.d.e     // Catch:{ all -> 0x0026 }
            int r3 = r3.getIdentifier(r0, r2, r4)     // Catch:{ all -> 0x0026 }
            if (r3 != 0) goto L_0x0047
            android.content.Context r4 = com.igexin.push.core.d.g     // Catch:{ all -> 0x0024 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0024 }
            java.lang.String r5 = com.igexin.push.core.d.e     // Catch:{ all -> 0x0024 }
            int r3 = r4.getIdentifier(r0, r1, r5)     // Catch:{ all -> 0x0024 }
            goto L_0x0047
        L_0x0024:
            r0 = move-exception
            goto L_0x0028
        L_0x0026:
            r0 = move-exception
            r3 = r8
        L_0x0028:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = a
            r4.append(r5)
            java.lang.String r5 = "|"
            r4.append(r5)
            java.lang.String r0 = r0.toString()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.Object[] r4 = new java.lang.Object[r8]
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r4)
        L_0x0047:
            if (r3 == 0) goto L_0x004a
            return r3
        L_0x004a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = a
            r0.append(r3)
            java.lang.String r3 = "|push_small.png is missing"
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r8 = new java.lang.Object[r8]
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r8)
        L_0x0062:
            android.content.Context r8 = com.igexin.push.core.d.g
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r0 = com.igexin.push.core.d.e
            java.lang.String r3 = "push"
            int r8 = r8.getIdentifier(r3, r2, r0)
            if (r8 != 0) goto L_0x007e
            android.content.Context r8 = com.igexin.push.core.d.g
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r0 = com.igexin.push.core.d.e
            int r8 = r8.getIdentifier(r3, r1, r0)
        L_0x007e:
            java.lang.String r0 = r7.g()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r3 = 17301651(0x1080093, float:2.4979667E-38)
            if (r0 == 0) goto L_0x0090
            if (r8 == 0) goto L_0x008e
            goto L_0x008f
        L_0x008e:
            r8 = r3
        L_0x008f:
            return r8
        L_0x0090:
            java.lang.String r0 = r7.g()
            java.lang.String r4 = "null"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x009d
            return r3
        L_0x009d:
            java.lang.String r0 = r7.g()
            java.lang.String r4 = "@"
            boolean r0 = r0.startsWith(r4)
            if (r0 == 0) goto L_0x00c2
            java.lang.String r7 = r7.g()
            r8 = 1
            int r0 = r7.length()
            java.lang.String r7 = r7.substring(r8, r0)
            java.lang.String r8 = "email"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00c1
            r3 = 17301647(0x108008f, float:2.4979656E-38)
        L_0x00c1:
            return r3
        L_0x00c2:
            android.content.Context r0 = com.igexin.push.core.d.g
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r4 = r7.g()
            java.lang.String r5 = com.igexin.push.core.d.e
            int r0 = r0.getIdentifier(r4, r2, r5)
            if (r0 != 0) goto L_0x00e4
            android.content.Context r0 = com.igexin.push.core.d.g
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r7 = r7.g()
            java.lang.String r2 = com.igexin.push.core.d.e
            int r0 = r0.getIdentifier(r7, r1, r2)
        L_0x00e4:
            if (r0 == 0) goto L_0x00e7
            return r0
        L_0x00e7:
            if (r8 == 0) goto L_0x00ea
            return r8
        L_0x00ea:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.e.a(com.igexin.push.core.bean.g, boolean):int");
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

    private Notification.Builder a(g gVar) {
        Notification.Builder builder = new Notification.Builder(d.g);
        NotificationManager notificationManager = (NotificationManager) d.g.getSystemService("notification");
        try {
            Class<?> cls = Class.forName("android.app.NotificationChannel");
            Constructor<?> constructor = cls.getConstructor(new Class[]{String.class, CharSequence.class, Integer.TYPE});
            if (constructor != null) {
                Class<?> cls2 = notificationManager.getClass();
                if (((Parcelable) cls2.getMethod("getNotificationChannel", new Class[]{String.class}).invoke(notificationManager, new Object[]{gVar.k()})) == null) {
                    Parcelable parcelable = (Parcelable) constructor.newInstance(new Object[]{gVar.k(), gVar.l(), Integer.valueOf(gVar.m())});
                    Method method = cls2.getMethod("createNotificationChannel", new Class[]{Class.forName("android.app.NotificationChannel")});
                    Method method2 = cls.getMethod("enableVibration", new Class[]{Boolean.TYPE});
                    Method method3 = cls.getMethod("setSound", new Class[]{Uri.class, AudioAttributes.class});
                    method2.invoke(parcelable, new Object[]{Boolean.valueOf(gVar.e())});
                    if (!gVar.f()) {
                        method3.invoke(parcelable, new Object[]{null, null});
                    } else if (!TextUtils.isEmpty(gVar.p())) {
                        method3.invoke(parcelable, new Object[]{b(gVar.p()), null});
                    }
                    method.invoke(notificationManager, new Object[]{parcelable});
                }
                builder.getClass().getMethod("setChannelId", new Class[]{String.class}).invoke(builder, new Object[]{gVar.k()});
            }
        } catch (Throwable unused) {
        }
        return builder;
    }

    private PendingIntent a(Intent intent) {
        return PendingIntent.getService(d.g, new Random().nextInt(ResultCode.KARAOKE_SUCCESS), intent, (m.a(d.g) < 31 || Build.VERSION.SDK_INT < 30) ? 134217728 : 67108864);
    }

    private PendingIntent a(String str, String str2, String str3, int i, g gVar, boolean z) {
        try {
            Intent intent = new Intent(d.g, x.a().b(d.g));
            intent.putExtra("taskid", str2);
            intent.putExtra("messageid", str3);
            intent.putExtra("appid", d.a);
            intent.putExtra("appkey", str);
            intent.putExtra("actionid", gVar.getDoActionId());
            intent.putExtra("feedbackid", gVar.getActionId().substring(gVar.getActionId().length() - 1));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_NOTIFICATION_DELETE);
            return a(intent);
        } catch (Exception e) {
            b.a(a + "|getDelPendingIntent err：" + e.toString(), new Object[0]);
            return null;
        }
    }

    private PendingIntent a(String str, String str2, String str3, int i, String str4, String str5) {
        Intent intent = new Intent(CoreConsts.b);
        intent.putExtra("taskid", str);
        intent.putExtra("messageid", str2);
        if (str4 == null) {
            str4 = "";
        }
        intent.putExtra("title", str4);
        if (str5 == null) {
            str5 = "";
        }
        intent.putExtra(FirebaseAnalytics.Param.CONTENT, str5);
        intent.putExtra("appid", d.a);
        intent.putExtra("actionid", str3);
        intent.putExtra("accesstoken", d.ak);
        intent.putExtra("notifID", i);
        if (m.a(d.g) < 31 || Build.VERSION.SDK_INT < 30) {
            Intent intent2 = new Intent(d.g, x.a().b(d.g));
            intent2.putExtra("action", PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK);
            intent2.putExtra("broadcast_intent", intent);
            return a(intent2);
        }
        Intent intent3 = new Intent(d.g, GetuiActivity.class);
        intent3.setFlags(268435456);
        intent3.putExtra("action", PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK);
        intent3.putExtra("broadcast_intent", intent);
        return PendingIntent.getActivity(d.g, new Random().nextInt(ResultCode.KARAOKE_SUCCESS), intent3, 67108864);
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

    public a a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return a.a;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:74|75|76|77) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009f, code lost:
        if (r1.lastIndexOf(".jpeg") != -1) goto L_0x00a1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:76:0x0183 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.igexin.push.core.bean.BaseAction a(org.json.JSONObject r22) {
        /*
            r21 = this;
            r0 = r22
            java.lang.String r1 = "channelLevel"
            java.lang.String r2 = "channelName"
            java.lang.String r3 = "channel"
            java.lang.String r4 = "banner_url"
            java.lang.String r5 = "logo_url"
            java.lang.String r6 = "is_chklayout"
            java.lang.String r7 = "ringName"
            java.lang.String r8 = "badgeAddNum"
            java.lang.String r9 = ".png"
            java.lang.String r10 = "is_noring"
            java.lang.String r11 = "is_novibrate"
            java.lang.String r12 = "is_noclear"
            java.lang.String r13 = "notifyid"
            java.lang.String r14 = ""
            java.lang.String r15 = "logo"
            r16 = 0
            r17 = r13
            com.igexin.push.core.bean.g r13 = new com.igexin.push.core.bean.g     // Catch:{ JSONException -> 0x01b5 }
            r13.<init>()     // Catch:{ JSONException -> 0x01b5 }
            r18 = r1
            java.lang.String r1 = "notification"
            r13.setType(r1)     // Catch:{ JSONException -> 0x01b5 }
            java.lang.String r1 = "actionid"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ JSONException -> 0x01b5 }
            r13.setActionId(r1)     // Catch:{ JSONException -> 0x01b5 }
            java.lang.String r1 = "do"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ JSONException -> 0x01b5 }
            r13.setDoActionId(r1)     // Catch:{ JSONException -> 0x01b5 }
            java.lang.String r1 = "title"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ JSONException -> 0x01b5 }
            r19 = r2
            java.lang.String r2 = "text"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x01b5 }
            r13.a((java.lang.String) r1)     // Catch:{ JSONException -> 0x01b5 }
            r13.b((java.lang.String) r2)     // Catch:{ JSONException -> 0x01b5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x01b5 }
            r20 = r3
            r3 = 0
            if (r1 == 0) goto L_0x007e
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x01b5 }
            if (r1 == 0) goto L_0x007e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01b5 }
            r0.<init>()     // Catch:{ JSONException -> 0x01b5 }
            java.lang.String r1 = a     // Catch:{ JSONException -> 0x01b5 }
            r0.append(r1)     // Catch:{ JSONException -> 0x01b5 }
            java.lang.String r1 = " title & content = null"
            r0.append(r1)     // Catch:{ JSONException -> 0x01b5 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x01b5 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ JSONException -> 0x01b5 }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ JSONException -> 0x01b5 }
            return r16
        L_0x007e:
            boolean r1 = r0.has(r15)     // Catch:{ JSONException -> 0x01b5 }
            if (r1 == 0) goto L_0x00c7
            java.lang.String r1 = r0.getString(r15)     // Catch:{ JSONException -> 0x01b5 }
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x01b5 }
            if (r1 != 0) goto L_0x00c7
            java.lang.String r1 = r0.getString(r15)     // Catch:{ JSONException -> 0x01b5 }
            int r2 = r1.lastIndexOf(r9)     // Catch:{ JSONException -> 0x01b5 }
            java.lang.String r15 = ".jpeg"
            r3 = -1
            if (r2 != r3) goto L_0x00a1
            int r2 = r1.lastIndexOf(r15)     // Catch:{ JSONException -> 0x01b5 }
            if (r2 == r3) goto L_0x00c4
        L_0x00a1:
            int r2 = r1.indexOf(r9)     // Catch:{ JSONException -> 0x01b5 }
            if (r2 != r3) goto L_0x00ab
            int r2 = r1.indexOf(r15)     // Catch:{ JSONException -> 0x01b5 }
        L_0x00ab:
            if (r2 == r3) goto L_0x00c3
            r3 = 0
            java.lang.String r1 = r1.substring(r3, r2)     // Catch:{ JSONException -> 0x01b5 }
            java.lang.String r2 = "^\\d+$"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)     // Catch:{ JSONException -> 0x01b5 }
            java.util.regex.Matcher r2 = r2.matcher(r1)     // Catch:{ JSONException -> 0x01b5 }
            boolean r2 = r2.matches()     // Catch:{ JSONException -> 0x01b5 }
            if (r2 == 0) goto L_0x00c3
            goto L_0x00c4
        L_0x00c3:
            r14 = r1
        L_0x00c4:
            r13.c((java.lang.String) r14)     // Catch:{ JSONException -> 0x01b5 }
        L_0x00c7:
            boolean r1 = r0.has(r12)     // Catch:{ JSONException -> 0x01b5 }
            r3 = 1
            if (r1 == 0) goto L_0x00da
            boolean r1 = r0.getBoolean(r12)     // Catch:{ JSONException -> 0x01b5 }
            if (r1 != 0) goto L_0x00d6
            r1 = r3
            goto L_0x00d7
        L_0x00d6:
            r1 = 0
        L_0x00d7:
            r13.b((boolean) r1)     // Catch:{ JSONException -> 0x01b5 }
        L_0x00da:
            boolean r1 = r0.has(r11)     // Catch:{ JSONException -> 0x01b5 }
            if (r1 == 0) goto L_0x00ec
            boolean r1 = r0.getBoolean(r11)     // Catch:{ JSONException -> 0x01b5 }
            if (r1 != 0) goto L_0x00e8
            r1 = r3
            goto L_0x00e9
        L_0x00e8:
            r1 = 0
        L_0x00e9:
            r13.c((boolean) r1)     // Catch:{ JSONException -> 0x01b5 }
        L_0x00ec:
            boolean r1 = r0.has(r10)     // Catch:{ JSONException -> 0x01b5 }
            if (r1 == 0) goto L_0x00fe
            boolean r1 = r0.getBoolean(r10)     // Catch:{ JSONException -> 0x01b5 }
            if (r1 != 0) goto L_0x00fa
            r1 = r3
            goto L_0x00fb
        L_0x00fa:
            r1 = 0
        L_0x00fb:
            r13.d((boolean) r1)     // Catch:{ JSONException -> 0x01b5 }
        L_0x00fe:
            boolean r1 = r0.has(r8)     // Catch:{ JSONException -> 0x01b5 }
            if (r1 == 0) goto L_0x010b
            int r1 = r0.optInt(r8)     // Catch:{ JSONException -> 0x01b5 }
            r13.c((int) r1)     // Catch:{ JSONException -> 0x01b5 }
        L_0x010b:
            boolean r1 = r0.has(r7)     // Catch:{ JSONException -> 0x01b5 }
            if (r1 == 0) goto L_0x0118
            java.lang.String r1 = r0.getString(r7)     // Catch:{ JSONException -> 0x01b5 }
            r13.h(r1)     // Catch:{ JSONException -> 0x01b5 }
        L_0x0118:
            boolean r1 = r0.has(r6)     // Catch:{ JSONException -> 0x01b5 }
            if (r1 == 0) goto L_0x0125
            boolean r1 = r0.getBoolean(r6)     // Catch:{ JSONException -> 0x01b5 }
            r13.e((boolean) r1)     // Catch:{ JSONException -> 0x01b5 }
        L_0x0125:
            boolean r1 = r0.has(r5)     // Catch:{ JSONException -> 0x01b5 }
            if (r1 == 0) goto L_0x0132
            java.lang.String r1 = r0.getString(r5)     // Catch:{ JSONException -> 0x01b5 }
            r13.d((java.lang.String) r1)     // Catch:{ JSONException -> 0x01b5 }
        L_0x0132:
            boolean r1 = r0.has(r4)     // Catch:{ JSONException -> 0x01b5 }
            if (r1 == 0) goto L_0x013f
            java.lang.String r1 = r0.getString(r4)     // Catch:{ JSONException -> 0x01b5 }
            r13.e((java.lang.String) r1)     // Catch:{ JSONException -> 0x01b5 }
        L_0x013f:
            r1 = r20
            boolean r2 = r0.has(r1)     // Catch:{ JSONException -> 0x01b5 }
            if (r2 == 0) goto L_0x014e
            java.lang.String r1 = r0.getString(r1)     // Catch:{ JSONException -> 0x01b5 }
            r13.f(r1)     // Catch:{ JSONException -> 0x01b5 }
        L_0x014e:
            r1 = r19
            boolean r2 = r0.has(r1)     // Catch:{ JSONException -> 0x01b5 }
            if (r2 == 0) goto L_0x015d
            java.lang.String r1 = r0.getString(r1)     // Catch:{ JSONException -> 0x01b5 }
            r13.g(r1)     // Catch:{ JSONException -> 0x01b5 }
        L_0x015d:
            r1 = r18
            boolean r2 = r0.has(r1)     // Catch:{ JSONException -> 0x01b5 }
            if (r2 == 0) goto L_0x016c
            int r1 = r0.getInt(r1)     // Catch:{ JSONException -> 0x01b5 }
            r13.a((int) r1)     // Catch:{ JSONException -> 0x01b5 }
        L_0x016c:
            r1 = r17
            boolean r2 = r0.has(r1)     // Catch:{ JSONException -> 0x01b5 }
            if (r2 == 0) goto L_0x01b4
            java.lang.String r2 = r0.optString(r1)     // Catch:{ NumberFormatException -> 0x0183 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0183 }
            r13.b((int) r2)     // Catch:{ NumberFormatException -> 0x0183 }
            r13.a((boolean) r3)     // Catch:{ NumberFormatException -> 0x0183 }
            goto L_0x01b4
        L_0x0183:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01b5 }
            r2.<init>()     // Catch:{ JSONException -> 0x01b5 }
            java.lang.String r3 = " NotificationAction.parseAction() : "
            r2.append(r3)     // Catch:{ JSONException -> 0x01b5 }
            java.lang.String r0 = r0.optString(r1)     // Catch:{ JSONException -> 0x01b5 }
            r2.append(r0)     // Catch:{ JSONException -> 0x01b5 }
            java.lang.String r0 = "_"
            r2.append(r0)     // Catch:{ JSONException -> 0x01b5 }
            java.lang.String r0 = r2.toString()     // Catch:{ JSONException -> 0x01b5 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01b5 }
            r1.<init>()     // Catch:{ JSONException -> 0x01b5 }
            java.lang.String r2 = a     // Catch:{ JSONException -> 0x01b5 }
            r1.append(r2)     // Catch:{ JSONException -> 0x01b5 }
            r1.append(r0)     // Catch:{ JSONException -> 0x01b5 }
            java.lang.String r0 = r1.toString()     // Catch:{ JSONException -> 0x01b5 }
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ JSONException -> 0x01b5 }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ JSONException -> 0x01b5 }
        L_0x01b4:
            return r13
        L_0x01b5:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.e.a(org.json.JSONObject):com.igexin.push.core.bean.BaseAction");
    }

    public void a(String str, String str2, String str3, g gVar) {
        Notification notification;
        String str4 = str2;
        g gVar2 = gVar;
        int a2 = !gVar.a() ? a(str4) : gVar.n();
        d.af.put(str4, Integer.valueOf(a2));
        int i = a2;
        PendingIntent a3 = a(str2, str3, gVar.getDoActionId(), i, gVar.b(), gVar.c());
        PendingIntent a4 = a(str, str2, str3, i, gVar, false);
        NotificationManager notificationManager = (NotificationManager) d.g.getSystemService("notification");
        int a5 = a(gVar2, false);
        if (Build.VERSION.SDK_INT < 11) {
            notification = new Notification();
            notification.icon = a5;
            notification.deleteIntent = a4;
            try {
                Method method = Class.forName("android.app.Notification").getMethod("setLatestEventInfo", new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class});
                method.setAccessible(true);
                method.invoke(notification, new Object[]{d.g, gVar.b(), gVar.c(), a3});
            } catch (Exception unused) {
                b.a(a + "reflect invoke setLatestEventInfo failed!", new Object[0]);
                return;
            }
        } else {
            Notification.Builder a6 = Build.VERSION.SDK_INT >= 26 ? a(gVar2) : new Notification.Builder(d.g);
            int a7 = a(gVar2, true);
            if (!TextUtils.isEmpty(gVar.b())) {
                a6.setContentTitle(gVar.b());
            }
            if (!TextUtils.isEmpty(gVar.c())) {
                a6.setContentText(gVar.c());
            }
            notification = a6.setSmallIcon(a7).setLargeIcon(BitmapFactoryInstrumentation.decodeResource(d.g.getResources(), a5)).setContentIntent(a3).setDeleteIntent(a4).getNotification();
            if (com.igexin.push.util.a.g() && Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 24) {
                try {
                    Field field = Class.forName("com.android.internal.R$id").getField("right_icon");
                    field.setAccessible(true);
                    int i2 = field.getInt((Object) null);
                    if (!(notification.contentView == null || i2 == 0)) {
                        notification.contentView.setViewVisibility(i2, 8);
                    }
                } catch (Exception unused2) {
                }
            }
        }
        notification.tickerText = gVar.c();
        notification.defaults = 4;
        notification.ledARGB = -16711936;
        notification.ledOnMS = ResultCode.KARAOKE_SUCCESS;
        notification.ledOffMS = 3000;
        notification.flags = 1;
        notification.flags = gVar.d() ? notification.flags | 16 : notification.flags | 32;
        if (gVar.f()) {
            if (TextUtils.isEmpty(gVar.p())) {
                notification.defaults |= 1;
            } else {
                notification.sound = b(gVar.p());
            }
        }
        if (gVar.e()) {
            notification.defaults |= 2;
        }
        if ((gVar.i() == null && gVar.h() == null) || !gVar.j()) {
            if (gVar.o() > 0) {
                com.igexin.push.util.b.a(gVar.o(), false);
                com.igexin.push.util.b.a(gVar.o(), notification);
            }
            notificationManager.notify(a2, notification);
            r a8 = r.a();
            String str5 = "";
            String b = gVar.b() == null ? str5 : gVar.b();
            if (gVar.c() != null) {
                str5 = gVar.c();
            }
            a8.b(str4, str3, b, str5);
        }
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (pushTaskBean == null || !(baseAction instanceof g)) {
            return true;
        }
        try {
            a(pushTaskBean.getAppKey(), pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), (g) baseAction);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}
