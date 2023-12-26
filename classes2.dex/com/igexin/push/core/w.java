package com.igexin.push.core;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.config.l;
import com.igexin.push.core.a.a.a;
import com.igexin.push.core.a.a.b;
import com.igexin.push.core.a.a.c;
import com.igexin.push.core.a.a.d;
import com.igexin.push.core.a.a.e;
import com.igexin.push.core.a.a.f;
import com.igexin.push.core.a.a.g;
import com.igexin.push.core.a.a.h;
import com.igexin.push.core.a.a.i;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.sdk.PushBuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class w {
    private static w a;
    private static Map<String, a> b;
    private static Set<String> c;

    private w() {
        c = new HashSet();
        b = new HashMap();
        c.add("goto");
        c.add("notification");
        c.add("terminatetask");
        c.add("startmyactivity");
        c.add("startapp");
        c.add("null");
        c.add("startweb");
        c.add("checkapp");
    }

    private a a(String str) {
        Map<String, a> map;
        Object bVar;
        if (TextUtils.isEmpty(str) || !c.contains(str)) {
            return null;
        }
        a aVar = b.get(str);
        if (aVar != null) {
            return aVar;
        }
        String str2 = "goto";
        if (str.equals(str2)) {
            map = b;
            bVar = new d();
        } else {
            str2 = "notification";
            if (str.equals(str2)) {
                map = b;
                bVar = new e();
            } else {
                str2 = "terminatetask";
                if (str.equals(str2)) {
                    map = b;
                    bVar = new i();
                } else {
                    str2 = "startmyactivity";
                    if (str.equals(str2)) {
                        map = b;
                        bVar = new f();
                    } else {
                        str2 = "startapp";
                        if (str.equals(str2)) {
                            map = b;
                            bVar = new h();
                        } else {
                            str2 = "null";
                            if (str.equals(str2)) {
                                map = b;
                                bVar = new c();
                            } else {
                                str2 = "startweb";
                                if (str.equals(str2)) {
                                    map = b;
                                    bVar = new g();
                                } else {
                                    str2 = "checkapp";
                                    if (str.equals(str2)) {
                                        map = b;
                                        bVar = new b();
                                    }
                                    return b.get(str);
                                }
                            }
                        }
                    }
                }
            }
        }
        map.put(str2, bVar);
        return b.get(str);
    }

    public static w a() {
        if (a == null) {
            a = new w();
        }
        return a;
    }

    private void a(int i, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(i));
        n.a().b(str, contentValues);
    }

    private boolean a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("condition");
            return !jSONObject2.has("wifi") && !jSONObject2.has("screenOn") && !jSONObject2.has("duration") && !jSONObject2.has("netConnected");
        } catch (Exception unused) {
            return true;
        }
    }

    private void b(JSONObject jSONObject, PushTaskBean pushTaskBean) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("condition");
            HashMap hashMap = new HashMap();
            if (jSONObject2.has("wifi")) {
                hashMap.put("wifi", jSONObject2.getString("wifi"));
            }
            if (jSONObject2.has("screenOn")) {
                hashMap.put("screenOn", jSONObject2.getString("screenOn"));
            }
            if (jSONObject2.has("duration")) {
                String string = jSONObject2.getString("duration");
                if (string.contains("-")) {
                    int indexOf = string.indexOf("-");
                    String substring = string.substring(0, indexOf);
                    String substring2 = string.substring(indexOf + 1, string.length());
                    hashMap.put("startTime", substring);
                    hashMap.put("endTime", substring2);
                }
            }
            if (jSONObject2.has("netConnected")) {
                hashMap.put("netConnected", jSONObject2.getString("netConnected"));
            }
            if (jSONObject2.has("expiredTime")) {
                String string2 = jSONObject2.getString("expiredTime");
                if (!TextUtils.isEmpty(string2) && TextUtils.isDigitsOnly(string2)) {
                    hashMap.put("expiredTime", string2);
                }
            }
            pushTaskBean.setConditionMap(hashMap);
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ed, code lost:
        if (r2 != null) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x010b, code lost:
        if (r2 == null) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x010d, code lost:
        r2.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean h() {
        /*
            r13 = this;
            java.lang.String r0 = "status"
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r1 = com.igexin.push.core.d.ae
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0118
            boolean r1 = com.igexin.push.core.d.p
            if (r1 == 0) goto L_0x0118
            r1 = 0
            r2 = 0
            com.igexin.push.core.c r3 = com.igexin.push.core.c.a()     // Catch:{ all -> 0x00f0 }
            com.igexin.push.b.b r4 = r3.k()     // Catch:{ all -> 0x00f0 }
            java.lang.String r5 = "message"
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch:{ all -> 0x00f0 }
            java.lang.String r3 = "0"
            java.lang.String[] r7 = new java.lang.String[]{r3}     // Catch:{ all -> 0x00f0 }
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r4.a(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00f0 }
            if (r2 == 0) goto L_0x00eb
        L_0x002c:
            boolean r3 = r2.moveToNext()     // Catch:{ all -> 0x00f0 }
            if (r3 == 0) goto L_0x00eb
            java.lang.String r3 = "msgextra"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ all -> 0x00f0 }
            byte[] r3 = r2.getBlob(r3)     // Catch:{ all -> 0x00f0 }
            java.lang.String r4 = "info"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ all -> 0x00f0 }
            byte[] r4 = r2.getBlob(r4)     // Catch:{ all -> 0x00f0 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x002c }
            java.lang.String r6 = new java.lang.String     // Catch:{ JSONException -> 0x002c }
            byte[] r4 = com.igexin.b.b.a.c(r4)     // Catch:{ JSONException -> 0x002c }
            r6.<init>(r4)     // Catch:{ JSONException -> 0x002c }
            r5.<init>(r6)     // Catch:{ JSONException -> 0x002c }
            java.lang.String r4 = "id"
            java.lang.String r4 = r5.getString(r4)     // Catch:{ JSONException -> 0x002c }
            java.lang.String r6 = "appid"
            java.lang.String r6 = r5.getString(r6)     // Catch:{ JSONException -> 0x002c }
            java.lang.String r7 = "messageid"
            java.lang.String r7 = r5.getString(r7)     // Catch:{ JSONException -> 0x002c }
            java.lang.String r8 = "taskid"
            java.lang.String r8 = r5.getString(r8)     // Catch:{ JSONException -> 0x002c }
            java.lang.String r9 = "appkey"
            java.lang.String r9 = r5.getString(r9)     // Catch:{ JSONException -> 0x002c }
            java.lang.String r10 = "action_chains"
            org.json.JSONArray r10 = r5.getJSONArray(r10)     // Catch:{ JSONException -> 0x002c }
            com.igexin.push.core.a.e r11 = com.igexin.push.core.a.e.a()     // Catch:{ JSONException -> 0x002c }
            java.lang.String r11 = r11.a((java.lang.String) r8, (java.lang.String) r7)     // Catch:{ JSONException -> 0x002c }
            com.igexin.push.core.bean.PushTaskBean r12 = new com.igexin.push.core.bean.PushTaskBean     // Catch:{ JSONException -> 0x002c }
            r12.<init>()     // Catch:{ JSONException -> 0x002c }
            r12.setAppid(r6)     // Catch:{ JSONException -> 0x002c }
            r12.setMessageId(r7)     // Catch:{ JSONException -> 0x002c }
            r12.setTaskId(r8)     // Catch:{ JSONException -> 0x002c }
            r12.setId(r4)     // Catch:{ JSONException -> 0x002c }
            r12.setAppKey(r9)     // Catch:{ JSONException -> 0x002c }
            r4 = 1
            r12.setCurrentActionid(r4)     // Catch:{ JSONException -> 0x002c }
            int r4 = r2.getColumnIndex(r0)     // Catch:{ JSONException -> 0x002c }
            int r4 = r2.getInt(r4)     // Catch:{ JSONException -> 0x002c }
            r12.setStatus(r4)     // Catch:{ JSONException -> 0x002c }
            if (r3 == 0) goto L_0x00a8
            r12.setMsgExtra(r3)     // Catch:{ JSONException -> 0x002c }
        L_0x00a8:
            java.lang.String r3 = "condition"
            boolean r3 = r5.has(r3)     // Catch:{ JSONException -> 0x002c }
            if (r3 == 0) goto L_0x00b3
            r13.b((org.json.JSONObject) r5, (com.igexin.push.core.bean.PushTaskBean) r12)     // Catch:{ JSONException -> 0x002c }
        L_0x00b3:
            int r3 = r10.length()     // Catch:{ JSONException -> 0x002c }
            if (r3 <= 0) goto L_0x00e4
            boolean r3 = r13.a((org.json.JSONObject) r5, (com.igexin.push.core.bean.PushTaskBean) r12)     // Catch:{ JSONException -> 0x002c }
            if (r3 != 0) goto L_0x00e4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x002c }
            r3.<init>()     // Catch:{ JSONException -> 0x002c }
            java.lang.String r4 = "PushMessageExecutor|load task from db parseActionChains result = false ####### "
            r3.append(r4)     // Catch:{ JSONException -> 0x002c }
            boolean r4 = r5 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x002c }
            if (r4 != 0) goto L_0x00d2
            java.lang.String r4 = r5.toString()     // Catch:{ JSONException -> 0x002c }
            goto L_0x00d8
        L_0x00d2:
            org.json.JSONObject r5 = (org.json.JSONObject) r5     // Catch:{ JSONException -> 0x002c }
            java.lang.String r4 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r5)     // Catch:{ JSONException -> 0x002c }
        L_0x00d8:
            r3.append(r4)     // Catch:{ JSONException -> 0x002c }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x002c }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ JSONException -> 0x002c }
            com.igexin.b.a.c.b.a((java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ JSONException -> 0x002c }
        L_0x00e4:
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r3 = com.igexin.push.core.d.ae     // Catch:{ JSONException -> 0x002c }
            r3.put(r11, r12)     // Catch:{ JSONException -> 0x002c }
            goto L_0x002c
        L_0x00eb:
            com.igexin.push.core.d.p = r1     // Catch:{ all -> 0x00f0 }
            if (r2 == 0) goto L_0x0118
            goto L_0x010d
        L_0x00f0:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0111 }
            r3.<init>()     // Catch:{ all -> 0x0111 }
            java.lang.String r4 = "PushMessageExecutor|checkPushMessageMapValue error:"
            r3.append(r4)     // Catch:{ all -> 0x0111 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0111 }
            r3.append(r0)     // Catch:{ all -> 0x0111 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0111 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0111 }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x0111 }
            if (r2 == 0) goto L_0x0118
        L_0x010d:
            r2.close()
            goto L_0x0118
        L_0x0111:
            r0 = move-exception
            if (r2 == 0) goto L_0x0117
            r2.close()
        L_0x0117:
            throw r0
        L_0x0118:
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r0 = com.igexin.push.core.d.ae
            boolean r0 = r0.isEmpty()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.w.h():boolean");
    }

    public void a(ContentValues contentValues) {
        try {
            if (d.av < 1000) {
                n.a().a(contentValues.getAsString("taskid"), contentValues);
            } else {
                int a2 = c.a().k().a("message", "id IN (SELECT id from message where status IS NULL or status=1 or status=2 order by id asc limit 250)");
                d.av -= a2;
                if (a2 < 250) {
                    d.av -= c.a().k().a("message", "id IN (SELECT id from message where status=0 order by id asc limit " + (250 - a2) + ")");
                }
                n.a().a(contentValues.getAsString("taskid"), contentValues);
            }
            d.av++;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Intent r9) {
        /*
            r8 = this;
            java.lang.String r0 = "taskid"
            java.lang.String r0 = r9.getStringExtra(r0)
            java.lang.String r1 = "messageid"
            java.lang.String r1 = r9.getStringExtra(r1)
            java.lang.String r2 = "actionid"
            java.lang.String r2 = r9.getStringExtra(r2)
            java.lang.String r3 = "accesstoken"
            java.lang.String r3 = r9.getStringExtra(r3)
            java.lang.String r4 = "title"
            boolean r5 = r9.hasExtra(r4)
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x0027
            java.lang.String r4 = r9.getStringExtra(r4)
            goto L_0x0028
        L_0x0027:
            r4 = r6
        L_0x0028:
            java.lang.String r5 = "content"
            boolean r7 = r9.hasExtra(r5)
            if (r7 == 0) goto L_0x0034
            java.lang.String r6 = r9.getStringExtra(r5)
        L_0x0034:
            r5 = 0
            java.lang.String r7 = "notifID"
            int r9 = r9.getIntExtra(r7, r5)
            android.content.Context r5 = com.igexin.push.core.d.g
            java.lang.String r7 = "notification"
            java.lang.Object r5 = r5.getSystemService(r7)
            android.app.NotificationManager r5 = (android.app.NotificationManager) r5
            if (r9 == 0) goto L_0x004b
        L_0x0047:
            r5.cancel(r9)
            goto L_0x0060
        L_0x004b:
            java.util.Map<java.lang.String, java.lang.Integer> r9 = com.igexin.push.core.d.af
            boolean r9 = r9.containsKey(r0)
            if (r9 == 0) goto L_0x0060
            java.util.Map<java.lang.String, java.lang.Integer> r9 = com.igexin.push.core.d.af
            java.lang.Object r9 = r9.get(r0)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            goto L_0x0047
        L_0x0060:
            java.util.Map<java.lang.String, java.lang.Integer> r9 = com.igexin.push.core.d.af
            r9.remove(r0)
            java.lang.String r9 = com.igexin.push.core.d.ak
            boolean r9 = r3.equals(r9)
            if (r9 != 0) goto L_0x006e
            goto L_0x0078
        L_0x006e:
            com.igexin.push.core.r r9 = com.igexin.push.core.r.a()
            r9.c(r0, r1, r4, r6)
            r8.b(r0, r1, r2)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.w.a(android.content.Intent):void");
    }

    public void a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        Message obtain = Message.obtain();
        obtain.what = CoreConsts.h;
        obtain.obj = bundle;
        c.a().a(obtain);
    }

    public boolean a(String str, String str2, String str3) {
        if (Thread.currentThread().getId() == c.a().e()) {
            b(str, str2, str3);
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("actionid", str3);
        Message obtain = Message.obtain();
        obtain.what = CoreConsts.i;
        obtain.obj = bundle;
        return c.a().a(obtain);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b6 A[Catch:{ all -> 0x011d }, LOOP:3: B:24:0x00b6->B:27:0x00c6, LOOP_START, PHI: r8 
      PHI: (r8v3 com.igexin.push.core.bean.BaseAction) = (r8v2 com.igexin.push.core.bean.BaseAction), (r8v9 com.igexin.push.core.bean.BaseAction) binds: [B:23:0x0089, B:27:0x00c6] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(org.json.JSONObject r11, com.igexin.push.core.bean.PushTaskBean r12) {
        /*
            r10 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "PushMessageExecutor------parse pushmessage actionchain json start-------"
            com.igexin.b.a.c.b.a((java.lang.String) r2, (java.lang.Object[]) r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 1
            java.lang.String r3 = "action_chains"
            org.json.JSONArray r11 = r11.getJSONArray(r3)     // Catch:{ all -> 0x011d }
            r3 = r0
        L_0x0015:
            int r4 = r11.length()     // Catch:{ all -> 0x011d }
            java.lang.String r5 = "type"
            if (r3 >= r4) goto L_0x0082
            java.lang.Object r4 = r11.get(r3)     // Catch:{ all -> 0x011d }
            org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ all -> 0x011d }
            java.lang.String r4 = r4.getString(r5)     // Catch:{ all -> 0x011d }
            com.igexin.push.extension.a r5 = com.igexin.push.extension.a.a()     // Catch:{ all -> 0x011d }
            java.util.List r5 = r5.b()     // Catch:{ all -> 0x011d }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x011d }
        L_0x0033:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x011d }
            if (r6 == 0) goto L_0x0047
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x011d }
            com.igexin.push.extension.stub.IPushExtension r6 = (com.igexin.push.extension.stub.IPushExtension) r6     // Catch:{ all -> 0x011d }
            boolean r6 = r6.isActionSupported(r4)     // Catch:{ all -> 0x011d }
            if (r6 == 0) goto L_0x0033
            r5 = r2
            goto L_0x0048
        L_0x0047:
            r5 = r0
        L_0x0048:
            if (r5 != 0) goto L_0x007f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
            r5.<init>()     // Catch:{ all -> 0x011d }
            java.lang.String r6 = "PushMessageExecutor|extension not suport type = "
            r5.append(r6)     // Catch:{ all -> 0x011d }
            r5.append(r4)     // Catch:{ all -> 0x011d }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x011d }
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ all -> 0x011d }
            com.igexin.b.a.c.b.a((java.lang.String) r5, (java.lang.Object[]) r6)     // Catch:{ all -> 0x011d }
            java.util.Set<java.lang.String> r5 = c     // Catch:{ all -> 0x011d }
            boolean r5 = r5.contains(r4)     // Catch:{ all -> 0x011d }
            if (r5 != 0) goto L_0x007f
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
            r11.<init>()     // Catch:{ all -> 0x011d }
            java.lang.String r3 = "PushMessageExecutor|action cannot be supported! --"
            r11.append(r3)     // Catch:{ all -> 0x011d }
            r11.append(r4)     // Catch:{ all -> 0x011d }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x011d }
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ all -> 0x011d }
            com.igexin.b.a.c.b.a((java.lang.String) r11, (java.lang.Object[]) r3)     // Catch:{ all -> 0x011d }
            return r0
        L_0x007f:
            int r3 = r3 + 1
            goto L_0x0015
        L_0x0082:
            r3 = r0
        L_0x0083:
            int r4 = r11.length()     // Catch:{ all -> 0x011d }
            if (r3 >= r4) goto L_0x0138
            java.lang.Object r4 = r11.get(r3)     // Catch:{ all -> 0x011d }
            org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ all -> 0x011d }
            java.lang.String r6 = r4.getString(r5)     // Catch:{ all -> 0x011d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
            r7.<init>()     // Catch:{ all -> 0x011d }
            java.lang.String r8 = "PushMessageExecutor|start parse type = "
            r7.append(r8)     // Catch:{ all -> 0x011d }
            r7.append(r6)     // Catch:{ all -> 0x011d }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x011d }
            java.lang.Object[] r8 = new java.lang.Object[r0]     // Catch:{ all -> 0x011d }
            com.igexin.b.a.c.b.a((java.lang.String) r7, (java.lang.Object[]) r8)     // Catch:{ all -> 0x011d }
            com.igexin.push.extension.a r7 = com.igexin.push.extension.a.a()     // Catch:{ all -> 0x011d }
            java.util.List r7 = r7.b()     // Catch:{ all -> 0x011d }
            r8 = 0
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x011d }
        L_0x00b6:
            boolean r9 = r7.hasNext()     // Catch:{ all -> 0x011d }
            if (r9 == 0) goto L_0x00c8
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x011d }
            com.igexin.push.extension.stub.IPushExtension r8 = (com.igexin.push.extension.stub.IPushExtension) r8     // Catch:{ all -> 0x011d }
            com.igexin.push.core.bean.BaseAction r8 = r8.parseAction(r4)     // Catch:{ all -> 0x011d }
            if (r8 == 0) goto L_0x00b6
        L_0x00c8:
            if (r8 != 0) goto L_0x00f1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
            r7.<init>()     // Catch:{ all -> 0x011d }
            java.lang.String r9 = "PushMessageExecutor|extension can't process type = "
            r7.append(r9)     // Catch:{ all -> 0x011d }
            r7.append(r6)     // Catch:{ all -> 0x011d }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x011d }
            java.lang.Object[] r9 = new java.lang.Object[r0]     // Catch:{ all -> 0x011d }
            com.igexin.b.a.c.b.a((java.lang.String) r7, (java.lang.Object[]) r9)     // Catch:{ all -> 0x011d }
            com.igexin.push.core.a.a.a r6 = r10.a((java.lang.String) r6)     // Catch:{ all -> 0x011d }
            if (r6 == 0) goto L_0x010c
            com.igexin.push.core.bean.BaseAction r4 = r6.a(r4)     // Catch:{ all -> 0x011d }
            if (r4 == 0) goto L_0x00ef
            r4.setSupportExt(r0)     // Catch:{ all -> 0x011d }
        L_0x00ef:
            r8 = r4
            goto L_0x010c
        L_0x00f1:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
            r4.<init>()     // Catch:{ all -> 0x011d }
            java.lang.String r7 = "PushMessageExecutor|extension process type = "
            r4.append(r7)     // Catch:{ all -> 0x011d }
            r4.append(r6)     // Catch:{ all -> 0x011d }
            java.lang.String r6 = " success"
            r4.append(r6)     // Catch:{ all -> 0x011d }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x011d }
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ all -> 0x011d }
            com.igexin.b.a.c.b.a((java.lang.String) r4, (java.lang.Object[]) r6)     // Catch:{ all -> 0x011d }
        L_0x010c:
            if (r8 != 0) goto L_0x0116
            java.lang.String r11 = "PushMessageExecutor|action chains can't parse, throw ++++++"
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ all -> 0x011d }
            com.igexin.b.a.c.b.a((java.lang.String) r11, (java.lang.Object[]) r3)     // Catch:{ all -> 0x011d }
            return r0
        L_0x0116:
            r1.add(r8)     // Catch:{ all -> 0x011d }
            int r3 = r3 + 1
            goto L_0x0083
        L_0x011d:
            r11 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "PushMessageExecutor|"
            r3.append(r4)
            java.lang.String r11 = r11.toString()
            r3.append(r11)
            java.lang.String r11 = r3.toString()
            java.lang.Object[] r3 = new java.lang.Object[r0]
            com.igexin.b.a.c.b.a((java.lang.String) r11, (java.lang.Object[]) r3)
        L_0x0138:
            r12.setActionChains(r1)
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r12 = "PushMessageExecutor------parse pushmessage actionchain json end-------"
            com.igexin.b.a.c.b.a((java.lang.String) r12, (java.lang.Object[]) r11)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.w.a(org.json.JSONObject, com.igexin.push.core.bean.PushTaskBean):boolean");
    }

    public boolean a(JSONObject jSONObject, byte[] bArr, boolean z) {
        int i;
        JSONObject jSONObject2 = jSONObject;
        byte[] bArr2 = bArr;
        boolean z2 = z;
        try {
            if (!jSONObject2.has("action") || !jSONObject2.getString("action").equals("pushmessage")) {
                return true;
            }
            String string = jSONObject2.getString("id");
            String string2 = jSONObject2.getString("appid");
            String string3 = jSONObject2.getString("messageid");
            String string4 = jSONObject2.getString("taskid");
            String string5 = jSONObject2.getString("appkey");
            JSONArray jSONArray = jSONObject2.getJSONArray("action_chains");
            com.igexin.b.a.c.b.a("pushmessage|" + string4 + "|" + string3 + "|" + string2 + "|" + z2, new Object[0]);
            if (string2.equals(d.a)) {
                PushTaskBean pushTaskBean = new PushTaskBean();
                pushTaskBean.setAppid(string2);
                pushTaskBean.setMessageId(string3);
                pushTaskBean.setTaskId(string4);
                pushTaskBean.setId(string);
                pushTaskBean.setAppKey(string5);
                pushTaskBean.setCurrentActionid(1);
                String a2 = com.igexin.push.core.a.e.a().a(string4, string3);
                if (z2) {
                    com.igexin.push.core.a.e.a().c(pushTaskBean, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE);
                    if (com.igexin.push.util.a.b(string4)) {
                        com.igexin.b.a.c.b.a("PushMessageExecutor|" + string4 + " in blacklist ###", new Object[0]);
                        return true;
                    } else if (com.igexin.push.util.a.a(System.currentTimeMillis())) {
                        return true;
                    } else {
                        if (com.igexin.push.util.a.a(jSONObject)) {
                            com.igexin.b.a.c.b.a("PushMessageExecutor|message have loop", new Object[0]);
                            return true;
                        }
                    }
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("messageid", string3);
                contentValues.put("taskid", string4);
                contentValues.put("appid", string2);
                contentValues.put("key", "CACHE_" + a2);
                contentValues.put("info", com.igexin.b.b.a.b((!(jSONObject2 instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject2)).getBytes()));
                contentValues.put("createtime", Long.valueOf(System.currentTimeMillis()));
                if (bArr2 != null) {
                    contentValues.put("msgextra", bArr2);
                    pushTaskBean.setMsgExtra(bArr2);
                }
                if (jSONArray.length() > 0 && !a(jSONObject2, pushTaskBean)) {
                    com.igexin.b.a.c.b.a("PushMessageExecutor parseActionChains result = false #######", new Object[0]);
                    return true;
                } else if (z2) {
                    try {
                        if (n.a().a(string4)) {
                            return true;
                        }
                        if (jSONObject2.has("condition")) {
                            b(jSONObject2, pushTaskBean);
                            pushTaskBean.setStatus(CoreConsts.m);
                            i = CoreConsts.m;
                        } else {
                            pushTaskBean.setStatus(CoreConsts.n);
                            i = CoreConsts.n;
                        }
                        contentValues.put("status", Integer.valueOf(i));
                        a(contentValues);
                        d.ae.put(a2, pushTaskBean);
                        if (jSONObject2.has("condition")) {
                            f();
                            return true;
                        }
                        a(string4, string3);
                        return true;
                    } catch (Exception unused) {
                        return true;
                    }
                } else {
                    if (jSONObject2.has("condition")) {
                        b(jSONObject2, pushTaskBean);
                    }
                    pushTaskBean.setStatus(CoreConsts.n);
                    d.ae.put(a2, pushTaskBean);
                    return true;
                }
            } else {
                com.igexin.b.a.c.b.a("PushMessageExecutor receieve error pushmessage", new Object[0]);
                return true;
            }
        } catch (Exception e) {
            com.igexin.b.a.c.b.a("PushMessageExecutor " + e.toString(), new Object[0]);
            return true;
        }
    }

    public void b(String str, String str2) {
        com.igexin.b.a.c.b.a("PushMessageExecutor do processActionExecute", new Object[0]);
        if (str2 != null && str != null) {
            try {
                if (c.a() != null && c(str, str2) == a.a) {
                    a(str, str2, "1");
                }
            } catch (Throwable th) {
                com.igexin.b.a.c.b.a("PushMessageExecutor|" + th.toString(), new Object[0]);
            }
        }
    }

    public boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (d.K <= 0) {
            d.K = currentTimeMillis - 60000;
            return true;
        } else if (currentTimeMillis - d.K <= 60000) {
            return false;
        } else {
            d.K = currentTimeMillis;
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009a, code lost:
        if (r8 != null) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x009c, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bf, code lost:
        if (r8 == null) goto L_0x00c9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            com.igexin.push.core.a.e r3 = com.igexin.push.core.a.e.a()
            java.lang.String r3 = r3.a((java.lang.String) r0, (java.lang.String) r1)
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r4 = com.igexin.push.core.d.ae
            java.lang.Object r4 = r4.get(r3)
            com.igexin.push.core.bean.PushTaskBean r4 = (com.igexin.push.core.bean.PushTaskBean) r4
            java.lang.String r5 = "PushMessageExecutor|"
            r6 = 1
            r7 = 0
            if (r4 != 0) goto L_0x00c9
            r8 = 0
            com.igexin.push.core.c r9 = com.igexin.push.core.c.a()     // Catch:{ all -> 0x00a6 }
            com.igexin.push.b.b r10 = r9.k()     // Catch:{ all -> 0x00a6 }
            java.lang.String r11 = "message"
            java.lang.String r9 = "taskid"
            java.lang.String r12 = "messageid"
            java.lang.String[] r12 = new java.lang.String[]{r9, r12}     // Catch:{ all -> 0x00a6 }
            r9 = 2
            java.lang.String[] r13 = new java.lang.String[r9]     // Catch:{ all -> 0x00a6 }
            r13[r7] = r0     // Catch:{ all -> 0x00a6 }
            r13[r6] = r1     // Catch:{ all -> 0x00a6 }
            r14 = 0
            r15 = 0
            android.database.Cursor r8 = r10.a(r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00a6 }
            if (r8 == 0) goto L_0x00a0
            int r9 = r8.getCount()     // Catch:{ all -> 0x00a6 }
            if (r9 > 0) goto L_0x0045
            goto L_0x00a0
        L_0x0045:
            boolean r9 = r8.moveToNext()     // Catch:{ all -> 0x00a6 }
            if (r9 == 0) goto L_0x009a
            java.lang.String r9 = "info"
            int r9 = r8.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x00a6 }
            byte[] r9 = r8.getBlob(r9)     // Catch:{ all -> 0x00a6 }
            java.lang.String r10 = "msgextra"
            int r10 = r8.getColumnIndexOrThrow(r10)     // Catch:{ all -> 0x00a6 }
            byte[] r10 = r8.getBlob(r10)     // Catch:{ all -> 0x00a6 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x00a6 }
            byte[] r9 = com.igexin.b.b.a.c(r9)     // Catch:{ all -> 0x00a6 }
            r11.<init>(r9)     // Catch:{ all -> 0x00a6 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ all -> 0x00a6 }
            r9.<init>(r11)     // Catch:{ all -> 0x00a6 }
            com.igexin.push.core.w r11 = a()     // Catch:{ all -> 0x00a6 }
            r11.a((org.json.JSONObject) r9, (byte[]) r10, (boolean) r7)     // Catch:{ all -> 0x00a6 }
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r9 = com.igexin.push.core.d.ae     // Catch:{ all -> 0x00a6 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r10.<init>()     // Catch:{ all -> 0x00a6 }
            r10.append(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r11 = ":"
            r10.append(r11)     // Catch:{ all -> 0x00a6 }
            r10.append(r1)     // Catch:{ all -> 0x00a6 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00a6 }
            java.lang.Object r9 = r9.get(r10)     // Catch:{ all -> 0x00a6 }
            com.igexin.push.core.bean.PushTaskBean r9 = (com.igexin.push.core.bean.PushTaskBean) r9     // Catch:{ all -> 0x00a6 }
            if (r9 != 0) goto L_0x0098
            if (r8 == 0) goto L_0x0097
            r8.close()
        L_0x0097:
            return r7
        L_0x0098:
            r4 = r9
            goto L_0x0045
        L_0x009a:
            if (r8 == 0) goto L_0x00c9
        L_0x009c:
            r8.close()
            goto L_0x00c9
        L_0x00a0:
            if (r8 == 0) goto L_0x00a5
            r8.close()
        L_0x00a5:
            return r7
        L_0x00a6:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c2 }
            r1.<init>()     // Catch:{ all -> 0x00c2 }
            r1.append(r5)     // Catch:{ all -> 0x00c2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c2 }
            r1.append(r0)     // Catch:{ all -> 0x00c2 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00c2 }
            java.lang.Object[] r1 = new java.lang.Object[r7]     // Catch:{ all -> 0x00c2 }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x00c2 }
            if (r8 == 0) goto L_0x00c9
            goto L_0x009c
        L_0x00c2:
            r0 = move-exception
            if (r8 == 0) goto L_0x00c8
            r8.close()
        L_0x00c8:
            throw r0
        L_0x00c9:
            int r0 = r4.getExecuteTimes()
            r1 = 50
            if (r0 < r1) goto L_0x00f1
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r0 = com.igexin.push.core.d.ae     // Catch:{ Exception -> 0x00d7 }
            r0.remove(r3)     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00f0
        L_0x00d7:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            java.lang.String r0 = r0.toString()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.Object[] r1 = new java.lang.Object[r7]
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)
        L_0x00f0:
            return r6
        L_0x00f1:
            int r0 = r0 + r6
            r4.setExecuteTimes(r0)
            com.igexin.push.core.a.e r0 = com.igexin.push.core.a.e.a()
            r0.c(r4, r2)
            com.igexin.push.core.bean.BaseAction r0 = r4.getBaseAction(r2)     // Catch:{ all -> 0x0143 }
            if (r0 != 0) goto L_0x0103
            return r7
        L_0x0103:
            boolean r1 = r0.isSupportExt()     // Catch:{ all -> 0x0143 }
            if (r1 == 0) goto L_0x0128
            com.igexin.push.extension.a r1 = com.igexin.push.extension.a.a()     // Catch:{ all -> 0x0143 }
            java.util.List r1 = r1.b()     // Catch:{ all -> 0x0143 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0143 }
        L_0x0115:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0143 }
            if (r2 == 0) goto L_0x0128
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0143 }
            com.igexin.push.extension.stub.IPushExtension r2 = (com.igexin.push.extension.stub.IPushExtension) r2     // Catch:{ all -> 0x0143 }
            boolean r2 = r2.executeAction(r4, r0)     // Catch:{ all -> 0x0143 }
            if (r2 == 0) goto L_0x0115
            return r6
        L_0x0128:
            java.lang.String r1 = r0.getType()     // Catch:{ all -> 0x0143 }
            r2 = r16
            com.igexin.push.core.a.a.a r1 = r2.a((java.lang.String) r1)     // Catch:{ all -> 0x0141 }
            if (r1 == 0) goto L_0x0140
            boolean r3 = r4.isStop()     // Catch:{ all -> 0x0141 }
            if (r3 == 0) goto L_0x013b
            goto L_0x0140
        L_0x013b:
            boolean r0 = r1.b(r4, r0)     // Catch:{ all -> 0x0141 }
            return r0
        L_0x0140:
            return r7
        L_0x0141:
            r0 = move-exception
            goto L_0x0146
        L_0x0143:
            r0 = move-exception
            r2 = r16
        L_0x0146:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            java.lang.String r0 = r0.toString()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.Object[] r1 = new java.lang.Object[r7]
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.w.b(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d A[LOOP:1: B:11:0x003d->B:14:0x004f, LOOP_START, PHI: r4 
      PHI: (r4v1 com.igexin.push.core.a) = (r4v0 com.igexin.push.core.a), (r4v7 com.igexin.push.core.a) binds: [B:10:0x0031, B:14:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.igexin.push.core.a c(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            com.igexin.push.core.a r0 = com.igexin.push.core.a.a
            com.igexin.push.core.a.e r1 = com.igexin.push.core.a.e.a()
            java.lang.String r9 = r1.a((java.lang.String) r8, (java.lang.String) r9)
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r1 = com.igexin.push.core.d.ae
            java.lang.Object r9 = r1.get(r9)
            com.igexin.push.core.bean.PushTaskBean r9 = (com.igexin.push.core.bean.PushTaskBean) r9
            if (r9 != 0) goto L_0x0017
            com.igexin.push.core.a r8 = com.igexin.push.core.a.stop
            return r8
        L_0x0017:
            java.util.List r1 = r9.getActionChains()
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
        L_0x0020:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0075
            java.lang.Object r3 = r1.next()
            com.igexin.push.core.bean.BaseAction r3 = (com.igexin.push.core.bean.BaseAction) r3
            com.igexin.push.core.a r4 = com.igexin.push.core.a.stop
            if (r3 != 0) goto L_0x0031
            return r4
        L_0x0031:
            com.igexin.push.extension.a r5 = com.igexin.push.extension.a.a()
            java.util.List r5 = r5.b()
            java.util.Iterator r5 = r5.iterator()
        L_0x003d:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0051
            java.lang.Object r4 = r5.next()
            com.igexin.push.extension.stub.IPushExtension r4 = (com.igexin.push.extension.stub.IPushExtension) r4
            com.igexin.push.core.a r4 = r4.prepareExecuteAction(r9, r3)
            com.igexin.push.core.a r6 = com.igexin.push.core.a.stop
            if (r4 == r6) goto L_0x003d
        L_0x0051:
            com.igexin.push.core.a r5 = com.igexin.push.core.a.stop
            if (r4 != r5) goto L_0x0069
            java.lang.String r5 = r3.getType()
            com.igexin.push.core.a.a.a r5 = r7.a((java.lang.String) r5)
            if (r5 != 0) goto L_0x0060
            return r4
        L_0x0060:
            com.igexin.push.core.a r4 = r5.a(r9, r3)
            com.igexin.push.core.a r3 = com.igexin.push.core.a.stop
            if (r4 != r3) goto L_0x0069
            return r4
        L_0x0069:
            com.igexin.push.core.a r3 = com.igexin.push.core.a.a
            if (r0 != r3) goto L_0x006e
            r0 = r4
        L_0x006e:
            com.igexin.push.core.a r3 = com.igexin.push.core.a.wait
            if (r4 != r3) goto L_0x0020
            int r2 = r2 + 1
            goto L_0x0020
        L_0x0075:
            if (r2 == 0) goto L_0x0084
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            r1 = 1
            boolean r8 = com.igexin.push.core.d.a(r8, r9, r1)
            if (r8 != 0) goto L_0x0084
            com.igexin.push.core.a r0 = com.igexin.push.core.a.a
        L_0x0084:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.w.c(java.lang.String, java.lang.String):com.igexin.push.core.a");
    }

    public void c() {
        com.igexin.push.b.b k = c.a().k();
        k.a("message", "createtime <= " + (System.currentTimeMillis() - 604800000));
    }

    public void d() {
        com.igexin.push.b.b k = c.a().k();
        k.a("at", "create_time <= " + (System.currentTimeMillis() - 604800000));
    }

    public void e() {
        try {
            if (TextUtils.isEmpty(l.y)) {
                return;
            }
            if (!PushBuildConfig.sdk_conf_debug_level.equals(l.y)) {
                List<String> asList = Arrays.asList(l.y.split(","));
                if (!asList.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Map.Entry<String, PushTaskBean>> it = d.ae.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry next = it.next();
                        String str = (String) next.getKey();
                        PushTaskBean pushTaskBean = (PushTaskBean) next.getValue();
                        if (!TextUtils.isEmpty(str)) {
                            for (String str2 : asList) {
                                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                                    arrayList.add(pushTaskBean.getTaskId());
                                    it.remove();
                                }
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        String[] strArr = new String[arrayList.size()];
                        for (int i = 0; i < arrayList.size(); i++) {
                            strArr[i] = (String) arrayList.get(i);
                        }
                        c.a().k().a("message", new String[]{"taskid"}, strArr);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void f() {
        int i;
        try {
            if (!h()) {
                for (Map.Entry next : d.ae.entrySet()) {
                    try {
                        String str = (String) next.getKey();
                        PushTaskBean pushTaskBean = (PushTaskBean) next.getValue();
                        if (pushTaskBean != null) {
                            if (pushTaskBean.getStatus() == CoreConsts.m) {
                                String taskId = pushTaskBean.getTaskId();
                                Map<String, String> conditionMap = pushTaskBean.getConditionMap();
                                if (conditionMap != null) {
                                    if (com.igexin.push.util.a.b(taskId)) {
                                        a(CoreConsts.o, taskId, str);
                                        i = CoreConsts.n;
                                    } else {
                                        if (conditionMap.size() > 0) {
                                            if (conditionMap.containsKey("expiredTime") && Long.parseLong(conditionMap.get("expiredTime")) < System.currentTimeMillis()) {
                                                a(CoreConsts.o, taskId, str);
                                                i = CoreConsts.n;
                                            } else if (!conditionMap.containsKey("endTime") || Long.parseLong(conditionMap.get("endTime")) >= System.currentTimeMillis()) {
                                                if (conditionMap.containsKey("wifi")) {
                                                    int parseInt = Integer.parseInt(conditionMap.get("wifi"));
                                                    com.igexin.push.util.a.d();
                                                    if (parseInt != d.r) {
                                                    }
                                                }
                                                if (conditionMap.containsKey("screenOn")) {
                                                    int parseInt2 = Integer.parseInt(conditionMap.get("screenOn"));
                                                    com.igexin.push.util.a.e();
                                                    if (parseInt2 != d.s) {
                                                    }
                                                }
                                                if (!conditionMap.containsKey("startTime") || Long.parseLong(conditionMap.get("startTime")) <= System.currentTimeMillis()) {
                                                    if (conditionMap.containsKey("netConnected")) {
                                                        try {
                                                            if (Integer.parseInt(conditionMap.get("netConnected")) != com.igexin.push.util.a.h()) {
                                                            }
                                                        } catch (Exception unused) {
                                                        }
                                                    }
                                                }
                                            } else {
                                                a(CoreConsts.o, taskId, str);
                                                i = CoreConsts.n;
                                            }
                                        }
                                        a(taskId, pushTaskBean.getMessageId());
                                        a(CoreConsts.n, taskId, str);
                                        i = CoreConsts.n;
                                    }
                                    pushTaskBean.setStatus(i);
                                } else {
                                    return;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            return;
                        }
                    } catch (Exception e) {
                        com.igexin.b.a.c.b.a("PushMessageExecutor|" + e.toString(), new Object[0]);
                    }
                }
            }
        } catch (Exception e2) {
            com.igexin.b.a.c.b.a("PushMessageExecutor|" + e2.toString(), new Object[0]);
        }
    }

    public void g() {
        Cursor cursor = null;
        try {
            com.igexin.push.b.b k = c.a().k();
            cursor = k.a("message", new String[]{"status"}, new String[]{AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE}, (String[]) null, (String) null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    byte[] blob = cursor.getBlob(cursor.getColumnIndex("info"));
                    long j = cursor.getLong(cursor.getColumnIndex("createtime"));
                    JSONObject jSONObject = new JSONObject(new String(com.igexin.b.b.a.c(blob)));
                    String string = jSONObject.getString("taskid");
                    if (jSONObject.has("condition") && !a(jSONObject) && System.currentTimeMillis() - j > 259200000) {
                        com.igexin.b.a.c.b.a("PushMessageExecutor|del condition taskid = " + string, new Object[0]);
                        k.a("message", new String[]{"taskid"}, new String[]{string});
                    }
                }
            }
            if (cursor == null) {
            }
        } catch (Throwable th) {
            try {
                com.igexin.b.a.c.b.a("PushMessageExecutor|del condition" + th.toString(), new Object[0]);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }
}
