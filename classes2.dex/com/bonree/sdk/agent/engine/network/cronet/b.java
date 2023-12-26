package com.bonree.sdk.agent.engine.network.cronet;

import android.text.TextUtils;
import com.bonree.sdk.agent.business.entity.NetworkEventInfoBean;
import com.bonree.sdk.bs.u;
import com.bonree.sdk.m.g;
import com.bonree.sdk.n.a;
import com.bonree.sdk.n.c;
import com.didi.hummer.adapter.http.IHttpAdapter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.chromium.net.CronetException;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

public class b {
    private NetworkEventInfoBean a;
    private long b;
    private int c;

    public b() {
    }

    public static void a(RequestFinishedInfo requestFinishedInfo, a aVar) {
        CronetException exception;
        if (requestFinishedInfo != null && requestFinishedInfo.getUrl() != null && g.a().b()) {
            if (requestFinishedInfo.getResponseInfo() != null) {
                UrlResponseInfo responseInfo = requestFinishedInfo.getResponseInfo();
                RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
                if (responseInfo != null && metrics != null && aVar != null) {
                    if (responseInfo.getNegotiatedProtocol() != null && !responseInfo.getNegotiatedProtocol().equals("unknown")) {
                        aVar.c(responseInfo.getNegotiatedProtocol());
                    }
                    if (!TextUtils.isEmpty(responseInfo.getUrl())) {
                        aVar.a(responseInfo.getUrl());
                    }
                    aVar.a(responseInfo.getHttpStatusCode());
                    aVar.b((int) a(metrics.getDnsEnd(), metrics.getDnsStart()));
                    aVar.c((int) a(metrics.getConnectEnd(), metrics.getConnectStart()));
                    aVar.d((int) a(metrics.getSslEnd(), metrics.getSslStart()));
                    aVar.e((int) a(metrics.getSendingEnd(), metrics.getSendingStart()));
                    aVar.f((int) a(metrics.getResponseStart(), metrics.getSendingEnd()));
                    aVar.g((int) a(metrics.getRequestEnd(), metrics.getResponseStart()));
                    Long sentByteCount = metrics.getSentByteCount();
                    if (sentByteCount != null) {
                        aVar.a(sentByteCount.longValue());
                    }
                    Long receivedByteCount = metrics.getReceivedByteCount();
                    if (receivedByteCount != null) {
                        aVar.b(receivedByteCount.longValue());
                    }
                    String a2 = com.bonree.sdk.ar.a.a(aVar.b());
                    if (!TextUtils.isEmpty(a2)) {
                        aVar.g(a2);
                    }
                    if (responseInfo.getAllHeaders() != null) {
                        aVar.e(responseInfo.getAllHeaders().toString());
                        aVar.b(u.d((Map<String, List<String>>) responseInfo.getAllHeaders()));
                    }
                    aVar.a(responseInfo.wasCached());
                    com.bonree.sdk.be.a.a().c("cronetData data:%s", aVar);
                    g.a().notifyService((c) aVar);
                }
            } else if (requestFinishedInfo.getException() != null && (exception = requestFinishedInfo.getException()) != null && aVar != null) {
                try {
                    Method declaredMethod = exception.getClass().getDeclaredMethod("getErrorCode", new Class[0]);
                    if (declaredMethod != null) {
                        int intValue = ((Integer) declaredMethod.invoke(exception, new Object[0])).intValue();
                        aVar.a(intValue);
                        if (intValue != 1) {
                            switch (intValue) {
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                    aVar.a = 3;
                                    break;
                                case 9:
                                    break;
                            }
                        }
                        aVar.a = 2;
                    }
                } catch (Exception e) {
                    com.bonree.sdk.be.a.a().a("cronetData assmbleExceptionData:%s", (Throwable) e);
                }
                aVar.f(exception.getLocalizedMessage());
                com.bonree.sdk.be.a.a().c("cronetData data:%s", aVar);
                g.a().notifyService((c) aVar);
            }
        }
    }

    public static void a(UrlRequest urlRequest, a aVar) {
        try {
            a(urlRequest, aVar, "mInitialMethod", "mRequestHeaders");
        } catch (Throwable unused) {
        }
    }

    private static void a(UrlRequest urlRequest, a aVar, String str, String str2) throws Exception {
        Class<?> cls = urlRequest.getClass();
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        String str3 = (String) declaredField.get(urlRequest);
        if (str3 != null) {
            aVar.b(str3);
        } else {
            aVar.b(IHttpAdapter.METHOD_GET);
        }
        Field declaredField2 = cls.getDeclaredField(str2);
        declaredField2.setAccessible(true);
        Object obj = declaredField2.get(urlRequest);
        if (obj != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (obj instanceof ArrayList) {
                int i = 0;
                while (i < ((ArrayList) obj).size()) {
                    try {
                        Object obj2 = ((ArrayList) obj).get(i);
                        if (obj2 instanceof Map.Entry) {
                            Map.Entry entry = (Map.Entry) obj2;
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                        i++;
                    } catch (Throwable unused) {
                    }
                }
                aVar.a((Map<String, String>) linkedHashMap);
            }
            String replace = obj.toString().replace("]", "").replace("[", "");
            if (replace.toString().length() > 0) {
                aVar.d(replace.toString());
            }
        }
    }

    private static void a(UrlResponseInfo urlResponseInfo, RequestFinishedInfo.Metrics metrics, a aVar) {
        if (urlResponseInfo != null && metrics != null && aVar != null) {
            if (urlResponseInfo.getNegotiatedProtocol() != null && !urlResponseInfo.getNegotiatedProtocol().equals("unknown")) {
                aVar.c(urlResponseInfo.getNegotiatedProtocol());
            }
            if (!TextUtils.isEmpty(urlResponseInfo.getUrl())) {
                aVar.a(urlResponseInfo.getUrl());
            }
            aVar.a(urlResponseInfo.getHttpStatusCode());
            aVar.b((int) a(metrics.getDnsEnd(), metrics.getDnsStart()));
            aVar.c((int) a(metrics.getConnectEnd(), metrics.getConnectStart()));
            aVar.d((int) a(metrics.getSslEnd(), metrics.getSslStart()));
            aVar.e((int) a(metrics.getSendingEnd(), metrics.getSendingStart()));
            aVar.f((int) a(metrics.getResponseStart(), metrics.getSendingEnd()));
            aVar.g((int) a(metrics.getRequestEnd(), metrics.getResponseStart()));
            Long sentByteCount = metrics.getSentByteCount();
            if (sentByteCount != null) {
                aVar.a(sentByteCount.longValue());
            }
            Long receivedByteCount = metrics.getReceivedByteCount();
            if (receivedByteCount != null) {
                aVar.b(receivedByteCount.longValue());
            }
            String a2 = com.bonree.sdk.ar.a.a(aVar.b());
            if (!TextUtils.isEmpty(a2)) {
                aVar.g(a2);
            }
            if (urlResponseInfo.getAllHeaders() != null) {
                aVar.e(urlResponseInfo.getAllHeaders().toString());
                aVar.b(u.d((Map<String, List<String>>) urlResponseInfo.getAllHeaders()));
            }
            aVar.a(urlResponseInfo.wasCached());
            com.bonree.sdk.be.a.a().c("cronetData data:%s", aVar);
            g.a().notifyService((c) aVar);
        }
    }

    private static long a(Date date, Date date2) {
        if (date2 == null || date == null) {
            return 0;
        }
        long time = date.getTime() - date2.getTime();
        if (time < 0) {
            return 0;
        }
        return time;
    }

    private static void a(CronetException cronetException, a aVar) {
        if (cronetException != null && aVar != null) {
            try {
                Method declaredMethod = cronetException.getClass().getDeclaredMethod("getErrorCode", new Class[0]);
                if (declaredMethod != null) {
                    int intValue = ((Integer) declaredMethod.invoke(cronetException, new Object[0])).intValue();
                    aVar.a(intValue);
                    a(intValue, aVar);
                }
            } catch (Exception e) {
                com.bonree.sdk.be.a.a().a("cronetData assmbleExceptionData:%s", (Throwable) e);
            }
            aVar.f(cronetException.getLocalizedMessage());
            com.bonree.sdk.be.a.a().c("cronetData data:%s", aVar);
            g.a().notifyService((c) aVar);
        }
    }

    private static void a(int i, a aVar) {
        if (i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    aVar.a = 3;
                    return;
                case 9:
                    break;
                default:
                    return;
            }
        }
        aVar.a = 2;
    }

    public b(NetworkEventInfoBean networkEventInfoBean, int i) {
        this.a = networkEventInfoBean;
        this.c = i;
        this.b = com.bonree.sdk.d.a.b();
    }

    public NetworkEventInfoBean a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }
}
