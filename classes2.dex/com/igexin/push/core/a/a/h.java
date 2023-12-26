package com.igexin.push.core.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.igexin.push.core.a;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.i;
import org.json.JSONException;
import org.json.JSONObject;

public class h implements a {
    private static final String a = "com.igexin.push.core.a.a.h";

    private static void a(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo next = context.getPackageManager().queryIntentActivities(intent, 0).iterator().next();
            if (next != null) {
                String str2 = next.activityInfo.packageName;
                String str3 = next.activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setFlags(270532608);
                intent2.setComponent(new ComponentName(str2, str3));
                context.startActivity(intent2);
            }
        } catch (Exception unused) {
        }
    }

    public a a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return a.a;
    }

    public BaseAction a(JSONObject jSONObject) {
        try {
            i iVar = new i();
            iVar.setType("startapp");
            iVar.setActionId(jSONObject.getString("actionid"));
            iVar.setDoActionId(jSONObject.getString("do"));
            if (jSONObject.has("appstartupid")) {
                iVar.a(jSONObject.getJSONObject("appstartupid").getString("android"));
            }
            if (jSONObject.has("is_autostart")) {
                iVar.d(jSONObject.getString("is_autostart"));
            }
            if (jSONObject.has("appid")) {
                iVar.b(jSONObject.getString("appid"));
            }
            if (jSONObject.has("noinstall_action")) {
                iVar.c(jSONObject.getString("noinstall_action"));
            }
            return iVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a A[SYNTHETIC, Splitter:B:12:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0086 A[Catch:{ Exception -> 0x00e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b7 A[Catch:{ Exception -> 0x00e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ca A[Catch:{ Exception -> 0x00e1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(com.igexin.push.core.bean.PushTaskBean r10, com.igexin.push.core.bean.BaseAction r11) {
        /*
            r9 = this;
            r0 = 1
            if (r10 == 0) goto L_0x00e1
            if (r11 == 0) goto L_0x00e1
            r1 = r11
            com.igexin.push.core.bean.i r1 = (com.igexin.push.core.bean.i) r1
            java.lang.String r2 = r1.b()
            java.lang.String r3 = ""
            boolean r3 = r2.equals(r3)
            r4 = 0
            if (r3 == 0) goto L_0x0019
            java.lang.String r2 = com.igexin.push.core.d.a
        L_0x0017:
            r3 = r0
            goto L_0x0027
        L_0x0019:
            java.lang.String r3 = com.igexin.push.core.d.a
            java.lang.String r5 = r1.b()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0026
            goto L_0x0017
        L_0x0026:
            r3 = r4
        L_0x0027:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "doStartApp|"
            r5.append(r6)
            r5.append(r3)
            java.lang.String r6 = "|"
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            com.igexin.b.a.c.b.a((java.lang.String) r5, (java.lang.Object[]) r6)
            java.lang.String r5 = "true"
            r6 = 0
            if (r3 == 0) goto L_0x0086
            com.igexin.push.core.r r3 = com.igexin.push.core.r.a()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r4 = r10.getTaskId()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r7 = r10.getMessageId()     // Catch:{ Exception -> 0x00e1 }
            r3.a((java.lang.String) r4, (java.lang.String) r7, (java.lang.String) r2, (java.lang.String) r6)     // Catch:{ Exception -> 0x00e1 }
            com.igexin.push.core.bean.i r11 = (com.igexin.push.core.bean.i) r11     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r11 = r11.d()     // Catch:{ Exception -> 0x00e1 }
            boolean r11 = r11.equals(r5)     // Catch:{ Exception -> 0x00e1 }
            if (r11 == 0) goto L_0x006c
            android.content.Context r11 = com.igexin.push.core.d.g     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = com.igexin.push.core.d.e     // Catch:{ Exception -> 0x00e1 }
            a((android.content.Context) r11, (java.lang.String) r2)     // Catch:{ Exception -> 0x00e1 }
        L_0x006c:
            java.lang.String r11 = r1.getDoActionId()     // Catch:{ Exception -> 0x00e1 }
            if (r11 == 0) goto L_0x00e1
            com.igexin.push.core.a.e r11 = com.igexin.push.core.a.e.a()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = r10.getTaskId()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r10 = r10.getMessageId()     // Catch:{ Exception -> 0x00e1 }
        L_0x007e:
            java.lang.String r1 = r1.getDoActionId()     // Catch:{ Exception -> 0x00e1 }
        L_0x0082:
            r11.a((java.lang.String) r2, (java.lang.String) r10, (java.lang.String) r1)     // Catch:{ Exception -> 0x00e1 }
            goto L_0x00e1
        L_0x0086:
            com.igexin.push.core.r r3 = com.igexin.push.core.r.a()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r7 = r10.getTaskId()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r8 = r10.getMessageId()     // Catch:{ Exception -> 0x00e1 }
            r3.a((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r2, (java.lang.String) r6)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = r1.d()     // Catch:{ Exception -> 0x00e1 }
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x00e1 }
            if (r2 == 0) goto L_0x00b4
            java.lang.String r2 = r1.a()     // Catch:{ Exception -> 0x00e1 }
            boolean r2 = com.igexin.push.util.a.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00e1 }
            if (r2 == 0) goto L_0x00b5
            android.content.Context r2 = com.igexin.push.core.d.g     // Catch:{ Exception -> 0x00e1 }
            com.igexin.push.core.bean.i r11 = (com.igexin.push.core.bean.i) r11     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r11 = r11.a()     // Catch:{ Exception -> 0x00e1 }
            a((android.content.Context) r2, (java.lang.String) r11)     // Catch:{ Exception -> 0x00e1 }
        L_0x00b4:
            r4 = r0
        L_0x00b5:
            if (r4 == 0) goto L_0x00ca
            java.lang.String r11 = r1.getDoActionId()     // Catch:{ Exception -> 0x00e1 }
            if (r11 == 0) goto L_0x00e1
            com.igexin.push.core.a.e r11 = com.igexin.push.core.a.e.a()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = r10.getTaskId()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r10 = r10.getMessageId()     // Catch:{ Exception -> 0x00e1 }
            goto L_0x007e
        L_0x00ca:
            java.lang.String r11 = r1.c()     // Catch:{ Exception -> 0x00e1 }
            if (r11 == 0) goto L_0x00e1
            com.igexin.push.core.a.e r11 = com.igexin.push.core.a.e.a()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = r10.getTaskId()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r10 = r10.getMessageId()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x00e1 }
            goto L_0x0082
        L_0x00e1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.h.b(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):boolean");
    }
}
