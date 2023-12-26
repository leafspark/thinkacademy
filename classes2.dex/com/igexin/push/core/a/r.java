package com.igexin.push.core.a;

import com.bonree.sdk.agent.engine.external.JSONArrayInstrumentation;
import com.igexin.b.a.b.c;
import com.igexin.b.a.c.b;
import com.igexin.push.c.i;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.k;
import com.igexin.push.core.c.a;
import com.igexin.push.core.d;
import com.igexin.push.f.a.e;
import com.igexin.push.util.EncryptUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class r extends b {
    private static final String a = (k.a + "_RedirectServerAction");

    private void a(String str, JSONArray jSONArray) {
        try {
            b.a(a + "|start fetch idc config, url : " + str, new Object[0]);
            c.b().a(new e(new a(str, jSONArray)), false, true);
        } catch (Exception e) {
            b.a(a + e.toString(), new Object[0]);
        }
    }

    public static String[] a(JSONArray jSONArray) {
        String[] strArr = null;
        try {
            strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = "https://" + jSONArray.getString(i);
            }
        } catch (Exception e) {
            b.a(a + "|parseIDCConfigURL exception" + e.toString(), new Object[0]);
        }
        return strArr;
    }

    public boolean a(Object obj, JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2 = jSONObject;
        b.a(a + "|redirect server resp data : " + jSONObject2, new Object[0]);
        try {
            if (!jSONObject2.has("action") || !jSONObject2.getString("action").equals("redirect_server")) {
                return true;
            }
            long j = 0;
            long optLong = jSONObject2.optLong("delay", 0) * 1000;
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject2.getJSONArray("address_list");
            StringBuilder sb = new StringBuilder();
            sb.append("redirect|");
            sb.append(optLong);
            sb.append("|");
            sb.append(!(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray));
            b.a(sb.toString(), new Object[0]);
            int i = 0;
            while (i < jSONArray.length()) {
                String string = jSONArray.getString(i);
                int indexOf = string.indexOf(44);
                if (indexOf > 0) {
                    String substring = string.substring(0, indexOf);
                    String substring2 = string.substring(indexOf + 1);
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        long parseLong = Long.parseLong(substring2);
                        com.igexin.push.c.e eVar = new com.igexin.push.c.e();
                        eVar.a = "socket://" + substring;
                        Long.signum(parseLong);
                        eVar.b = currentTimeMillis + (parseLong * 1000);
                        arrayList.add(eVar);
                    } catch (NumberFormatException unused) {
                    }
                }
                i++;
                j = 0;
            }
            if (optLong >= j) {
                d.F = optLong;
            }
            if (jSONObject2.has("loc") && jSONObject2.has("conf")) {
                try {
                    SDKUrlConfig.setLocation(jSONObject2.getString("loc"));
                    StringBuilder sb2 = new StringBuilder();
                    String str2 = a;
                    sb2.append(str2);
                    sb2.append(" set group id : ");
                    sb2.append(d.d);
                    b.a(sb2.toString(), new Object[0]);
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("conf");
                    String[] a2 = a(jSONArray2);
                    if (a2 != null && a2.length > 1) {
                        String[] idcConfigUrl = SDKUrlConfig.getIdcConfigUrl();
                        if (idcConfigUrl != null) {
                            if (idcConfigUrl.length <= 1 || a2[1].equals(idcConfigUrl[1])) {
                                b.a(str2 + "|current idc config url == new idc config url, return", new Object[0]);
                            }
                        }
                        if (d.al == 0) {
                            str = a2[1];
                        } else if (System.currentTimeMillis() - d.al > 7200000) {
                            str = a2[1];
                        } else {
                            b.a(str2 + "|get idc cfg last time less than 2 hours return", new Object[0]);
                        }
                        a(str, jSONArray2);
                    }
                } catch (Exception e) {
                    b.a(a + e.toString(), new Object[0]);
                }
            }
            i.a().d().a((List<com.igexin.push.c.e>) arrayList);
            if (!EncryptUtils.isLoadSuccess()) {
                return true;
            }
            b.a(a + "|redirect reInit so ~~~~~", new Object[0]);
            EncryptUtils.reset();
            return true;
        } catch (Exception e2) {
            b.a(a + e2.toString(), new Object[0]);
            return true;
        }
    }
}
