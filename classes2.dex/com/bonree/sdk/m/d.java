package com.bonree.sdk.m;

import android.text.TextUtils;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.json.HTTP;
import com.bonree.sdk.m.g;
import com.bonree.sdk.n.b;
import com.bonree.sdk.n.c;
import java.util.LinkedHashMap;
import java.util.Map;

public final class d {
    private static final String a = "FlutterNetwork";
    private f b = com.bonree.sdk.be.a.a();

    d() {
    }

    public final void a(String str, long j, int i, String str2, String str3, int i2, int i3, int i4, String str4, Map<String, String> map, Map<String, String> map2) {
        String str5;
        String str6;
        String str7 = str;
        long j2 = j;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        Map<String, String> map3 = map;
        Map<String, String> map4 = map2;
        this.b.c("FlutterNetwork reportNetwork requestUrl:%s, startTimeMs:%d, responseDataSize:%d, method:%s, resourceType:%s, connectTimeMs:%d, errorCode:%d, responseTimeMs:%d, errorMessage:%s", str7, Long.valueOf(j), Integer.valueOf(i), str8, str9, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str10);
        this.b.c("FlutterNetwork reportNetwork httpRequestHeader:%s", ad.c(map));
        this.b.c("FlutterNetwork reportNetwork httpResponseHeader:%s", ad.c(map2));
        if (!TextUtils.isEmpty(str)) {
            b bVar = new b();
            bVar.c(str7);
            bVar.j(str8);
            long j3 = 0;
            int i5 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i5 > 0) {
                j3 = j2;
            }
            bVar.k(j3);
            bVar.i(i5 > 0 ? -j2 : 0);
            bVar.d(Math.max(i2, 0));
            if (map3 != null) {
                StringBuilder sb = new StringBuilder();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (String next : map.keySet()) {
                    if (!TextUtils.isEmpty(next) && (str6 = map3.get(next)) != null) {
                        if (TextUtils.equals("traceparent", next)) {
                            bVar.l(str6);
                        }
                        linkedHashMap.put(next, str6);
                        sb.append(next);
                        sb.append(" : ");
                        sb.append(str6);
                        sb.append(HTTP.CRLF);
                    }
                }
                bVar.a((Map<String, String>) linkedHashMap);
                bVar.h(sb.toString());
            }
            bVar.g(Math.max(i4, 0));
            bVar.f(str9);
            bVar.c((long) Math.max(i, 0));
            bVar.b(map4);
            if (map4 != null) {
                StringBuilder sb2 = new StringBuilder();
                for (String next2 : map2.keySet()) {
                    if (!TextUtils.isEmpty(next2) && (str5 = map4.get(next2)) != null) {
                        sb2.append(next2);
                        sb2.append(":");
                        sb2.append(str5);
                        sb2.append(HTTP.CRLF);
                    }
                }
                bVar.b(sb2.toString());
            }
            bVar.d(str10);
            bVar.a(Math.max(i3, 0));
            bVar.i(1);
            f fVar = this.b;
            fVar.c("FlutterNetwork reportNetwork: " + bVar, new Object[0]);
            g.a.a.notifyService((c) bVar);
        }
    }

    public static d a() {
        return a.a;
    }

    static class a {
        /* access modifiers changed from: private */
        public static final d a = new d();

        private a() {
        }
    }
}
