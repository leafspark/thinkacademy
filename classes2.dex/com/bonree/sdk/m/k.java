package com.bonree.sdk.m;

import android.os.Build;
import android.text.TextUtils;
import com.bonree.sdk.agent.Agent;
import com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean;
import com.bonree.sdk.agent.engine.external.BonreeFlutterBridge;
import com.bonree.sdk.agent.engine.external.OkHttp2Instrumentation;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.i;
import com.bonree.sdk.d.e;
import com.igexin.assist.sdk.AssistPushConsts;
import com.squareup.okhttp.Request;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpUriRequest;
import org.chromium.net.ApiVersion;
import org.chromium.net.ExperimentalUrlRequest;
import retrofit2.Call;

public final class k {
    private static Map<String, List<ConfigResponseBean.RequestHeaderRule>> A = null;
    private static final String a = "00";
    private static final String b = "-";
    private static final String c = "00";
    private static final String d = "okhttp";
    private static final String e = "unknown";
    private static final String f = "bnro=";
    private static final String g = "android";
    private static final String h = "harmonyos";
    private static final String i = "hap";
    private static String j = "/";
    private static final String k = "_";
    private static final String l = "00000000-00000000-00000000-00000000";
    private static final int m = 10;
    private static final int n = 16;
    private static final int o = 200;
    private static final String p = "enableNetworkTrace";
    private static final String q = "bnroPrefix";
    private static final String u = "cronet";
    private static final String v = "HttpURLConnection";
    private static final String w = "HttpClient";
    private static int x = 256;
    private static int y = 512;
    private static String z = "^[A-Za-z0-9_-]{1,256}$";
    /* access modifiers changed from: private */
    public Map r;
    private ConfigResponseBean.NetworkTraceConfig s;
    private boolean t = false;

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;

        static {
            h = new int[]{1, 2, 3, 4, 5, 6, 7};
        }

        public static int[] a() {
            return (int[]) h.clone();
        }
    }

    public final void a(boolean z2, ConfigResponseBean.NetworkTraceConfig networkTraceConfig) {
        A = new HashMap();
        this.t = z2;
        this.s = networkTraceConfig;
        if (networkTraceConfig != null) {
            if (networkTraceConfig.mUrlWhiteList != null && this.s.mUrlWhiteList.size() > o) {
                ConfigResponseBean.NetworkTraceConfig networkTraceConfig2 = this.s;
                networkTraceConfig2.mUrlWhiteList = networkTraceConfig2.mUrlWhiteList.subList(0, o);
            }
            if (this.s.mUrlBlackList != null && this.s.mUrlBlackList.size() > o) {
                ConfigResponseBean.NetworkTraceConfig networkTraceConfig3 = this.s;
                networkTraceConfig3.mUrlBlackList = networkTraceConfig3.mUrlBlackList.subList(0, o);
            }
            if (this.s.mUrlTotalList != null && this.s.mUrlTotalList.size() > o) {
                ConfigResponseBean.NetworkTraceConfig networkTraceConfig4 = this.s;
                networkTraceConfig4.mUrlTotalList = networkTraceConfig4.mUrlTotalList.subList(0, o);
            }
        }
        Class<?> isImportFlutterPlugin = BonreeFlutterBridge.isImportFlutterPlugin();
        if (isImportFlutterPlugin != null) {
            Map map = ConfigResponseBean.NetworkTraceConfig.toMap(networkTraceConfig);
            this.r = map;
            if (map != null) {
                map.put(p, Boolean.valueOf(z2));
                this.r.put(q, e());
                com.bonree.sdk.bs.a.b().post(new l(this, isImportFlutterPlugin));
            }
        }
    }

    public final Map a() {
        return this.r;
    }

    private String c() {
        return a(UUID.randomUUID().toString());
    }

    private String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append(b);
        if (str.equals(l)) {
            str = d();
        }
        sb.append(str.replaceAll(b, ""));
        sb.append(b);
        sb.append(d().replaceAll(b, "").substring(16));
        sb.append(b);
        sb.append("00");
        return sb.toString();
    }

    private static String d() {
        String uuid = UUID.randomUUID().toString();
        if (!uuid.equals(l)) {
            return uuid;
        }
        for (int i2 = 0; i2 < 10; i2++) {
            String uuid2 = UUID.randomUUID().toString();
            if (!uuid2.equals(l)) {
                return uuid2;
            }
        }
        for (int i3 = 0; i3 < 10; i3++) {
            String uuid3 = UUID.nameUUIDFromBytes(String.valueOf(System.currentTimeMillis()).getBytes(StandardCharsets.UTF_8)).toString();
            if (!uuid3.equals(l)) {
                return uuid3;
            }
        }
        return UUID.randomUUID().toString();
    }

    private static String e() {
        StringBuilder sb = new StringBuilder();
        if (com.bonree.sdk.d.a.K()) {
            sb.append(h);
            sb.append("/");
            sb.append(ad.e());
        } else {
            sb.append(g);
            sb.append("/");
            sb.append(Build.VERSION.RELEASE);
        }
        return sb.toString();
    }

    private String b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(f);
        sb.append(e());
        sb.append(k);
        if (com.bonree.sdk.d.a.L()) {
            sb.append(i);
        } else {
            sb.append(g);
        }
        sb.append("/");
        sb.append(Agent.getAgentVersion());
        sb.append(k);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        } else {
            sb.append(e);
        }
        return sb.toString();
    }

    private String c(String str) {
        if (!str.contains(d)) {
            str = "okhttp/" + str;
        }
        return b(str);
    }

    private boolean d(String str) {
        if (this.t && this.s != null) {
            TextUtils.isEmpty(str);
        }
        return false;
    }

    public final <T> void a(String str, String str2, String str3, T t2, int i2) {
        if (this.t && this.s != null && !TextUtils.isEmpty(str)) {
            Map<String, List<ConfigResponseBean.RequestHeaderRule>> map = A;
            if (map == null || !map.containsKey(str)) {
                ArrayList arrayList = new ArrayList();
                if (this.s.mUrlTotalList != null && this.s.mUrlTotalList.size() > 0) {
                    arrayList.addAll(this.s.mUrlTotalList);
                }
                if (this.s.mUrlWhiteList != null && this.s.mUrlWhiteList.size() > 0) {
                    List<ConfigResponseBean.RequestHeaderRule> a2 = a(str, this.s.mUrlWhiteList);
                    if (a2.size() > 0) {
                        arrayList.addAll(a2);
                    }
                }
                if (this.s.mUrlBlackList != null && this.s.mUrlBlackList.size() > 0) {
                    List<ConfigResponseBean.RequestHeaderRule> b2 = b(str, this.s.mUrlBlackList);
                    if (b2.size() > 0) {
                        arrayList.addAll(b2);
                    }
                }
                if (arrayList.size() != 0) {
                    A.put(str, arrayList);
                    a(str, str2, str3, t2, i2, arrayList);
                    return;
                }
                return;
            }
            a(str, str2, str3, t2, i2, A.get(str));
        }
    }

    private <T> void a(String str, String str2, String str3, T t2, int i2, List<ConfigResponseBean.RequestHeaderRule> list) {
        if (list != null && list.size() != 0) {
            HashMap hashMap = new HashMap();
            for (ConfigResponseBean.RequestHeaderRule next : list) {
                if (next != null) {
                    String str4 = "";
                    switch (next.reqHeaderType) {
                        case 1:
                            str4 = next.reqHeaderValue;
                            break;
                        case 2:
                            str4 = d().replaceAll(b, str4).substring(16);
                            break;
                        case 3:
                            str4 = d().replaceAll(b, str4);
                            break;
                        case 4:
                            str4 = a(str, str2);
                            break;
                        case 5:
                            if (a.a != i2) {
                                str4 = a(str3);
                                break;
                            } else {
                                str4 = c();
                                break;
                            }
                        case 6:
                            str4 = a(i2);
                            break;
                    }
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(next.reqHeaderKey) && ad.b("^[A-Za-z0-9_-]{1,256}$", next.reqHeaderKey) && !ad.d(next.reqHeaderKey) && str4.length() <= 512) {
                        hashMap.put(next.reqHeaderKey, str4);
                    }
                }
            }
            a(t2, i2, hashMap);
        }
    }

    private static String a(int i2) {
        switch (m.a[i2 - 1]) {
            case 1:
                k a2 = b.a;
                return a2.b("cronet/" + ApiVersion.getCronetVersion());
            case 2:
                return b.a.b(v);
            case 3:
                return b.a.b(w);
            case 4:
                return b.a.b(w);
            case 5:
                return b.a.c(OkHttp2Instrumentation.getVersion());
            case 6:
                return b.a.b(Retrofit2Instrumentation.getVersion());
            case 7:
                return b.a.c(o.a());
            default:
                return "";
        }
    }

    private static <T> void a(T t2, int i2, Map<String, String> map) {
        if (map.size() != 0) {
            for (String next : map.keySet()) {
                String str = map.get(next);
                if (!TextUtils.isEmpty(str)) {
                    switch (m.a[i2 - 1]) {
                        case 1:
                            ((ExperimentalUrlRequest.Builder) t2).addHeader(next, str);
                            break;
                        case 2:
                            ((URLConnection) t2).addRequestProperty(next, str);
                            break;
                        case 3:
                            ((HttpUriRequest) t2).addHeader(next, str);
                            break;
                        case 4:
                            ((HttpRequest) t2).addHeader(next, str);
                            break;
                        case 5:
                            n.a((Request) t2, next, str);
                            break;
                        case 6:
                            o.a(((Call) t2).request(), next, str);
                            break;
                        case 7:
                            o.a((okhttp3.Request) t2, next, str);
                            break;
                    }
                }
            }
        }
    }

    private static String a(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        if (str == null) {
            str = "";
        }
        String replace = i.b(UUID.randomUUID().toString().toLowerCase().getBytes(), 0).trim().replace("\n", "");
        String replace2 = i.b(UUID.randomUUID().toString().toLowerCase().getBytes(), 0).trim().replace("\n", "");
        String replace3 = i.b(e.d().c().getPackageName().getBytes(), 0).trim().replace("\n", "");
        String replace4 = i.b(e.d().b().getBytes(), 0).trim().replace("\n", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = "/";
        }
        String replace5 = i.b(str2.getBytes(), 0).trim().replace("\n", "");
        String replace6 = i.b(str.getBytes(), 0).trim().replace("\n", "");
        return "1" + b + replace + b + replace2 + b + AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE + b + replace3 + b + replace4 + b + replace5 + b + replace6;
    }

    private static List<ConfigResponseBean.RequestHeaderRule> a(String str, List<ConfigResponseBean.HostRule> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            ConfigResponseBean.HostRule hostRule = list.get(i2);
            if (!(hostRule.mReqHeaderRuleList == null || hostRule.mRule == null)) {
                if (hostRule.mType == 0) {
                    if (str.equals(hostRule.mRule)) {
                        arrayList.addAll(hostRule.mReqHeaderRuleList);
                    }
                } else if (hostRule.mType == 1) {
                    if (str.startsWith(hostRule.mRule)) {
                        arrayList.addAll(hostRule.mReqHeaderRuleList);
                    }
                } else if (hostRule.mType == 2) {
                    if (str.endsWith(hostRule.mRule)) {
                        arrayList.addAll(hostRule.mReqHeaderRuleList);
                    }
                } else if (hostRule.mType == 3) {
                    if (Pattern.compile(hostRule.mRule).matcher(str).matches()) {
                        arrayList.addAll(hostRule.mReqHeaderRuleList);
                    }
                } else if (hostRule.mType == 4 && str.contains(hostRule.mRule)) {
                    arrayList.addAll(hostRule.mReqHeaderRuleList);
                }
            }
        }
        return arrayList;
    }

    private static List<ConfigResponseBean.RequestHeaderRule> b(String str, List<ConfigResponseBean.HostRule> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            ConfigResponseBean.HostRule hostRule = list.get(i2);
            if (!(hostRule.mReqHeaderRuleList == null || hostRule.mRule == null)) {
                if (hostRule.mType == 0) {
                    if (!str.equals(hostRule.mRule)) {
                        arrayList.addAll(hostRule.mReqHeaderRuleList);
                    }
                } else if (hostRule.mType == 1) {
                    if (!str.startsWith(hostRule.mRule)) {
                        arrayList.addAll(hostRule.mReqHeaderRuleList);
                    }
                } else if (hostRule.mType == 2) {
                    if (!str.endsWith(hostRule.mRule)) {
                        arrayList.addAll(hostRule.mReqHeaderRuleList);
                    }
                } else if (hostRule.mType == 3) {
                    if (!Pattern.compile(hostRule.mRule).matcher(str).matches()) {
                        arrayList.addAll(hostRule.mReqHeaderRuleList);
                    }
                } else if (hostRule.mType == 4 && !str.contains(hostRule.mRule)) {
                    arrayList.addAll(hostRule.mReqHeaderRuleList);
                }
            }
        }
        return arrayList;
    }

    public static k b() {
        return b.a;
    }

    static class b {
        /* access modifiers changed from: private */
        public static final k a = new k();

        private b() {
        }
    }
}
