package com.igexin.push.core;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.b.a.c.a.f;
import com.igexin.b.a.c.b;
import com.igexin.push.a.a.c;
import com.igexin.push.config.a;
import com.igexin.push.config.l;
import com.igexin.push.core.a.e;
import com.igexin.push.core.b.i;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.h;
import com.igexin.push.util.g;
import com.igexin.sdk.PushConsts;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public class v {
    private static v a;

    private v() {
    }

    public static v a() {
        if (a == null) {
            a = new v();
        }
        return a;
    }

    public void a(int i, int i2, String str) {
        l.a = i;
        l.b = i2;
        a.a().b();
        c.c().d();
    }

    public void a(int i, String str) {
        l.d = i;
        a.a().c();
        if (d.n) {
            b.a("setHeartbeatInterval heartbeatReq", new Object[0]);
            if (System.currentTimeMillis() - d.Q > 5000) {
                d.Q = System.currentTimeMillis();
                e.a().b();
            }
        }
    }

    public void a(Bundle bundle) {
        String string = bundle.getString("action");
        b.a("PushController|action pushmanager action = " + string, new Object[0]);
        if (!TextUtils.isEmpty(string)) {
            if (string.equals("setTag")) {
                a(bundle.getString("tags"), bundle.getString("sn"));
            } else if (string.equals("setSilentTime")) {
                int i = bundle.getInt("beginHour", 0);
                int i2 = bundle.getInt("duration", 0);
                a(i, i2, d.g.getPackageName());
                AssistPushManager.getInstance().setSilentTime(d.g, i, i2);
            } else if (string.equals("sendMessage")) {
                b.a("PushController onPushManagerMessage recevie action : sendMessage", new Object[0]);
                if (l.g) {
                    String string2 = bundle.getString("taskid");
                    byte[] byteArray = bundle.getByteArray("extraData");
                    b.a("PushController receive broadcast msg data , task id : " + string2 + " ######@##@@@#", new Object[0]);
                    a(string2, byteArray);
                }
            } else if (string.equals("setHeartbeatInterval")) {
                a(bundle.getInt("interval", 0), d.g.getPackageName());
            } else if (string.equals("setSocketTimeout")) {
                b(bundle.getInt("timeout", 0), d.g.getPackageName());
            } else if (string.equals("sendFeedbackMessage")) {
                if (d.ah <= 200) {
                    String string3 = bundle.getString("taskid");
                    String string4 = bundle.getString("messageid");
                    String string5 = bundle.getString("actionid");
                    String str = string3 + ":" + string4 + ":" + string5;
                    if (d.ag.get(str) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        PushTaskBean pushTaskBean = new PushTaskBean();
                        pushTaskBean.setTaskId(string3);
                        pushTaskBean.setMessageId(string4);
                        pushTaskBean.setAppid(d.a);
                        pushTaskBean.setAppKey(d.b);
                        e.a().b(pushTaskBean, string5);
                        d.ah++;
                        d.ag.put(str, Long.valueOf(currentTimeMillis));
                    }
                }
            } else if (string.equals("turnOffPush")) {
                c.a().g();
                AssistPushManager.getInstance().turnOffPush(d.g);
            } else if (string.equals("bindAlias")) {
                String string6 = bundle.getString("alias");
                String string7 = bundle.getString("sn");
                b.a("PushController|onPushManagerMessage bindAlias...", new Object[0]);
                b(string6, string7);
            } else if (string.equals("unbindAlias")) {
                String string8 = bundle.getString("alias");
                String string9 = bundle.getString("sn");
                boolean z = bundle.getBoolean("isSeft");
                b.a("PushController|onPushManagerMessage unbindAlias...", new Object[0]);
                a(string8, string9, z);
            } else if (string.equals("sendApplinkFeedback")) {
                a(bundle.getString("url"));
            } else if (string.equals("setHwBadgeNum")) {
                com.igexin.push.util.b.a(bundle.getInt("badgeNum"), true);
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            f.a().a("sendApplinkFeedback, url is invalid");
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            String queryParameter = parse.getQueryParameter("p");
            if (parse != null && !TextUtils.isEmpty(host)) {
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (!l.z) {
                        b.a("PushController|isApplinkFeedback is false, not feedback", new Object[0]);
                        return;
                    } else if (!com.igexin.push.util.a.c(host)) {
                        b.a("PushController|checkIsWhiteApplinkDomain is false, not feedback", new Object[0]);
                        return;
                    } else {
                        b.a("PushController|isApplinkFeedback is true and checkIsWhiteApplinkDomain is true, to feedback", new Object[0]);
                        PushTaskBean pushTaskBean = new PushTaskBean();
                        pushTaskBean.setTaskId("getuiapplinkup");
                        pushTaskBean.setMessageId(queryParameter);
                        pushTaskBean.setAppid(d.a);
                        pushTaskBean.setAppKey(d.b);
                        e.a().b(pushTaskBean, PushConsts.SEND_MESSAGE_ERROR);
                        return;
                    }
                }
            }
            b.a("PushController|url " + str + " is invalid", new Object[0]);
        } catch (Exception e) {
            b.a("PushController|" + e.toString(), new Object[0]);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:4|5|6|7|8|9|10|(1:12)(1:13)|14|(1:16)(1:17)|18|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x006f */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0073 A[Catch:{ Exception -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0078 A[Catch:{ Exception -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0082 A[Catch:{ Exception -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0084 A[Catch:{ Exception -> 0x00ca }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = com.igexin.push.core.d.u
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0038
            com.igexin.b.a.c.a.f r0 = com.igexin.b.a.c.a.f.a()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "setTag : "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = ", failed, "
            r1.append(r9)
            java.lang.String r9 = "has not get clientid"
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.a((java.lang.String) r9)
            com.igexin.push.core.r r9 = com.igexin.push.core.r.a()
            r0 = 20008(0x4e28, float:2.8037E-41)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r9.a((java.lang.String) r10, (java.lang.String) r0)
            return
        L_0x0038:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00ca }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00ca }
            r0.<init>()     // Catch:{ Exception -> 0x00ca }
            java.lang.String r1 = "action"
            java.lang.String r4 = "set_tag"
            r0.put(r1, r4)     // Catch:{ Exception -> 0x006f }
            java.lang.String r1 = "id"
            java.lang.String r4 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x006f }
            r0.put(r1, r4)     // Catch:{ Exception -> 0x006f }
            java.lang.String r1 = "cid"
            java.lang.String r4 = com.igexin.push.core.d.u     // Catch:{ Exception -> 0x006f }
            r0.put(r1, r4)     // Catch:{ Exception -> 0x006f }
            java.lang.String r1 = "appid"
            java.lang.String r4 = com.igexin.push.core.d.a     // Catch:{ Exception -> 0x006f }
            r0.put(r1, r4)     // Catch:{ Exception -> 0x006f }
            java.lang.String r1 = "tags"
            java.lang.String r4 = "utf-8"
            java.lang.String r9 = java.net.URLEncoder.encode(r9, r4)     // Catch:{ Exception -> 0x006f }
            r0.put(r1, r9)     // Catch:{ Exception -> 0x006f }
            java.lang.String r9 = "sn"
            r0.put(r9, r10)     // Catch:{ Exception -> 0x006f }
        L_0x006f:
            boolean r9 = r0 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x00ca }
            if (r9 != 0) goto L_0x0078
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x00ca }
            goto L_0x007e
        L_0x0078:
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ Exception -> 0x00ca }
            java.lang.String r9 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r0)     // Catch:{ Exception -> 0x00ca }
        L_0x007e:
            boolean r10 = com.igexin.push.core.d.n     // Catch:{ Exception -> 0x00ca }
            if (r10 == 0) goto L_0x0084
            r6 = r2
            goto L_0x0087
        L_0x0084:
            r0 = 0
            r6 = r0
        L_0x0087:
            com.igexin.push.core.b.e r10 = com.igexin.push.core.b.e.a()     // Catch:{ Exception -> 0x00ca }
            com.igexin.push.core.bean.h r0 = new com.igexin.push.core.bean.h     // Catch:{ Exception -> 0x00ca }
            r5 = 2
            r1 = r0
            r4 = r9
            r1.<init>(r2, r4, r5, r6)     // Catch:{ Exception -> 0x00ca }
            r10.a((com.igexin.push.core.bean.h) r0)     // Catch:{ Exception -> 0x00ca }
            com.igexin.push.d.c.b r10 = new com.igexin.push.d.c.b     // Catch:{ Exception -> 0x00ca }
            r10.<init>()     // Catch:{ Exception -> 0x00ca }
            r10.b()     // Catch:{ Exception -> 0x00ca }
            java.lang.String r0 = "17258000"
            r10.d = r0     // Catch:{ Exception -> 0x00ca }
            r10.e = r9     // Catch:{ Exception -> 0x00ca }
            com.igexin.push.core.c r9 = com.igexin.push.core.c.a()     // Catch:{ Exception -> 0x00ca }
            com.igexin.push.e.a r9 = r9.i()     // Catch:{ Exception -> 0x00ca }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ca }
            r0.<init>()     // Catch:{ Exception -> 0x00ca }
            java.lang.String r1 = "C-"
            r0.append(r1)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r1 = com.igexin.push.core.d.u     // Catch:{ Exception -> 0x00ca }
            r0.append(r1)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00ca }
            r9.a(r0, r10)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r9 = "settag"
            r10 = 0
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x00ca }
            com.igexin.b.a.c.b.a((java.lang.String) r9, (java.lang.Object[]) r10)     // Catch:{ Exception -> 0x00ca }
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.v.a(java.lang.String, java.lang.String):void");
    }

    public void a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(d.u)) {
            f a2 = f.a();
            a2.a("unbindAlias : " + str + ", failed, " + "has not get clientid");
            r.a().c(str2, String.valueOf(PushConsts.ALIAS_CID_LOST));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - d.S > 1000) {
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis));
            if (!format.equals(d.R)) {
                i.a().f(format);
                i.a().a(0);
            }
            if (d.T < 100) {
                b.a("start unbindAlias ###", new Object[0]);
                d.S = currentTimeMillis;
                i.a().a(d.T + 1);
                a(str, str2, true, z);
                return;
            }
            b.a("PushController|unbindAlias times exceed", new Object[0]);
            f a3 = f.a();
            a3.a("unbindAlias : " + str + ", failed, " + ", the number of calls per day cannot exceed 100");
            r.a().c(str2, String.valueOf(PushConsts.ALIAS_REQUEST_FILTER));
            return;
        }
        b.a("PushController|unbindAlias frequently called", new Object[0]);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0045 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049 A[Catch:{ Exception -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e A[Catch:{ Exception -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058 A[Catch:{ Exception -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a A[Catch:{ Exception -> 0x00b1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r9, java.lang.String r10, boolean r11, boolean r12) {
        /*
            r8 = this;
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00b1 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b1 }
            r0.<init>()     // Catch:{ Exception -> 0x00b1 }
            if (r11 == 0) goto L_0x000e
            java.lang.String r3 = "unbind_alias"
            goto L_0x0010
        L_0x000e:
            java.lang.String r3 = "bind_alias"
        L_0x0010:
            r7 = r3
            if (r11 == 0) goto L_0x0016
            r3 = 8
            goto L_0x0017
        L_0x0016:
            r3 = 7
        L_0x0017:
            r4 = r3
            java.lang.String r3 = "action"
            r0.put(r3, r7)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r3 = "id"
            java.lang.String r5 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0045 }
            r0.put(r3, r5)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r3 = "cid"
            java.lang.String r5 = com.igexin.push.core.d.u     // Catch:{ Exception -> 0x0045 }
            r0.put(r3, r5)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r3 = "appid"
            java.lang.String r5 = com.igexin.push.core.d.a     // Catch:{ Exception -> 0x0045 }
            r0.put(r3, r5)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r3 = "alias"
            r0.put(r3, r9)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r9 = "sn"
            r0.put(r9, r10)     // Catch:{ Exception -> 0x0045 }
            if (r11 == 0) goto L_0x0045
            java.lang.String r9 = "is_self"
            r0.put(r9, r12)     // Catch:{ Exception -> 0x0045 }
        L_0x0045:
            boolean r9 = r0 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x00b1 }
            if (r9 != 0) goto L_0x004e
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x00b1 }
            goto L_0x0054
        L_0x004e:
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r9 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r0)     // Catch:{ Exception -> 0x00b1 }
        L_0x0054:
            boolean r10 = com.igexin.push.core.d.n     // Catch:{ Exception -> 0x00b1 }
            if (r10 == 0) goto L_0x005a
            r5 = r1
            goto L_0x005d
        L_0x005a:
            r10 = 0
            r5 = r10
        L_0x005d:
            com.igexin.push.core.b.e r10 = com.igexin.push.core.b.e.a()     // Catch:{ Exception -> 0x00b1 }
            com.igexin.push.core.bean.h r11 = new com.igexin.push.core.bean.h     // Catch:{ Exception -> 0x00b1 }
            r0 = r11
            r3 = r9
            r0.<init>(r1, r3, r4, r5)     // Catch:{ Exception -> 0x00b1 }
            r10.a((com.igexin.push.core.bean.h) r11)     // Catch:{ Exception -> 0x00b1 }
            com.igexin.push.d.c.b r10 = new com.igexin.push.d.c.b     // Catch:{ Exception -> 0x00b1 }
            r10.<init>()     // Catch:{ Exception -> 0x00b1 }
            r10.b()     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r11 = "17258000"
            r10.d = r11     // Catch:{ Exception -> 0x00b1 }
            r10.e = r9     // Catch:{ Exception -> 0x00b1 }
            com.igexin.push.core.c r11 = com.igexin.push.core.c.a()     // Catch:{ Exception -> 0x00b1 }
            com.igexin.push.e.a r11 = r11.i()     // Catch:{ Exception -> 0x00b1 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b1 }
            r12.<init>()     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r0 = "C-"
            r12.append(r0)     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r0 = com.igexin.push.core.d.u     // Catch:{ Exception -> 0x00b1 }
            r12.append(r0)     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x00b1 }
            r11.a(r12, r10)     // Catch:{ Exception -> 0x00b1 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b1 }
            r10.<init>()     // Catch:{ Exception -> 0x00b1 }
            r10.append(r7)     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r11 = " = "
            r10.append(r11)     // Catch:{ Exception -> 0x00b1 }
            r10.append(r9)     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x00b1 }
            r10 = 0
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x00b1 }
            com.igexin.b.a.c.b.a((java.lang.String) r9, (java.lang.Object[]) r10)     // Catch:{ Exception -> 0x00b1 }
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.v.a(java.lang.String, java.lang.String, boolean, boolean):void");
    }

    public void a(String str, byte[] bArr) {
        if (d.u != null) {
            JSONObject jSONObject = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject.put("action", "sendmessage");
                jSONObject.put("id", String.valueOf(currentTimeMillis));
                jSONObject.put("cid", d.u);
                jSONObject.put("appid", d.a);
                jSONObject.put("taskid", str);
                jSONObject.put("extraData", g.b(bArr, 0));
                String jSONObject2 = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
                com.igexin.push.core.b.e.a().a(new h(currentTimeMillis, jSONObject2, (byte) 6, currentTimeMillis));
                com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                bVar.b();
                bVar.a = (int) currentTimeMillis;
                bVar.d = d.u;
                bVar.e = jSONObject2;
                bVar.f = bArr;
                bVar.g = d.u;
                com.igexin.push.e.a i = c.a().i();
                i.a("C-" + d.u, bVar);
                if (str != null && str.startsWith("4T5@S_")) {
                    b.a("PushController sending lbs report message : " + jSONObject2, new Object[0]);
                }
            } catch (Throwable th) {
                b.a("PushController|" + th.toString(), new Object[0]);
            }
        }
    }

    public void b(int i, String str) {
        l.e = i;
        a.a().d();
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(d.u)) {
            f a2 = f.a();
            a2.a("bindAlias : " + str + ", failed, " + "has not get clientid");
            r.a().b(str2, String.valueOf(PushConsts.ALIAS_CID_LOST));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - d.S > 1000) {
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis));
            if (!format.equals(d.R)) {
                i.a().f(format);
                i.a().a(0);
            }
            b.a("-> CoreRuntimeInfo.opAliasTimes:" + d.T, new Object[0]);
            if (d.T < 100) {
                b.a("start bindAlias ###", new Object[0]);
                d.S = currentTimeMillis;
                i.a().a(d.T + 1);
                a(str, str2, false, true);
                return;
            }
            b.a("PushController|bindAlias times exceed", new Object[0]);
            f a3 = f.a();
            a3.a("bindAlias : " + str + ", failed, " + ", the number of calls per day cannot exceed 100");
            r.a().b(str2, String.valueOf(PushConsts.ALIAS_REQUEST_FILTER));
            return;
        }
        b.a("PushController|bindAlias frequently called", new Object[0]);
    }
}
