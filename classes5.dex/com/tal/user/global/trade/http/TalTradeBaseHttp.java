package com.tal.user.global.trade.http;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tal.user.global.trade.R;
import com.tal.user.global.trade.api.TalTradeSdk;
import com.tal.user.global.trade.util.TalTradeAES;
import com.tal.user.global.trade.util.TalTradeLogger;
import com.tal.user.global.trade.util.TalTradeLoggerFactory;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.yanzhenjie.andserver.util.HttpHeaders;
import com.yanzhenjie.andserver.util.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class TalTradeBaseHttp {
    static final String CHARSET = "utf-8";
    int CONNECT_TIME = 10000;
    private final String TAL_NEED_DECRYPT = "Tal-Need-Decrypt";
    int WRITE_READ_TIME = 10000;
    private String lastHost;
    private HostnameVerifier mHostnameVerifier;
    private SSLSocketFactory mSSLSocketFactory;
    protected boolean useIp;

    public String getHost(String str) {
        return "47.103.176.3";
    }

    public TalHttpResponse realUpload(String str, TalHttpRequestParams talHttpRequestParams) throws Exception {
        String uuid = UUID.randomUUID().toString();
        HttpURLConnection conn = getConn(new URL(str), false);
        conn.setReadTimeout(this.WRITE_READ_TIME);
        conn.setConnectTimeout(this.CONNECT_TIME);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Charset", CHARSET);
        conn.setRequestProperty("connection", "keep-alive");
        conn.setRequestProperty(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE + ";boundary=" + uuid);
        if (talHttpRequestParams.getHeaderParam() != null && !talHttpRequestParams.getHeaderParam().isEmpty()) {
            for (Map.Entry next : talHttpRequestParams.getHeaderParam().entrySet()) {
                conn.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
        DataOutputStream dataOutputStream = new DataOutputStream(conn.getOutputStream());
        if (talHttpRequestParams.getBodyParam() != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next2 : talHttpRequestParams.getBodyParam().entrySet()) {
                sb.append("--");
                sb.append(uuid);
                sb.append("\r\n");
                sb.append("Content-Disposition: form-data; name=\"" + ((String) next2.getKey()) + "\"" + "\r\n");
                sb.append("Content-Type: text/plain; charset=utf-8\r\n");
                sb.append("Content-Transfer-Encoding: 8bit\r\n");
                sb.append("\r\n");
                sb.append((String) next2.getValue());
                sb.append("\r\n");
            }
            dataOutputStream.write(sb.toString().getBytes());
        }
        for (Map.Entry next3 : talHttpRequestParams.getFileParam().entrySet()) {
            if (next3.getValue() == null || !new File((String) next3.getValue()).exists()) {
                return new TalHttpResponse(13202, "param error");
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("--");
            stringBuffer.append(uuid);
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"" + ((String) next3.getKey()) + "\"; filename=\"" + ((String) next3.getValue()) + "\"" + "\r\n");
            stringBuffer.append("\r\n");
            dataOutputStream.write(stringBuffer.toString().getBytes());
            FileInputStream fileInputStream = new FileInputStream((String) next3.getValue());
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                dataOutputStream.write(bArr, 0, read);
            }
            dataOutputStream.write("\r\n".getBytes());
            fileInputStream.close();
        }
        dataOutputStream.write(("--" + uuid + "--" + "\r\n").getBytes());
        dataOutputStream.flush();
        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            return new TalHttpResponse(responseCode, dealResponseResult(conn.getInputStream()));
        }
        return new TalHttpResponse(responseCode, TalTradeSdk.getInstance().getApplication().getResources().getString(R.string.tal_trade_net_error));
    }

    public TalHttpResponse sendPost(String str, TalHttpRequestParams talHttpRequestParams) throws Exception {
        return sendPost(str, talHttpRequestParams, true);
    }

    public TalHttpResponse sendPost(String str, TalHttpRequestParams talHttpRequestParams, boolean z) throws Exception {
        byte[] bytes = getRequestData(talHttpRequestParams.getBodyParam()).getBytes();
        URL url = new URL(str);
        HttpURLConnection conn = getConn(url, z);
        if (talHttpRequestParams.getConnectTime() == 0) {
            talHttpRequestParams.setConnectTime(this.CONNECT_TIME);
            if (this.useIp && talHttpRequestParams.getConnectTime() > 5) {
                talHttpRequestParams.setConnectTime(talHttpRequestParams.getConnectTime() / 2);
            }
        }
        if (talHttpRequestParams.getReadTime() == 0) {
            talHttpRequestParams.setReadTime(this.WRITE_READ_TIME);
            if (this.useIp && talHttpRequestParams.getReadTime() > 5) {
                talHttpRequestParams.setReadTime(talHttpRequestParams.getReadTime() / 2);
            }
        }
        conn.setConnectTimeout(talHttpRequestParams.getConnectTime());
        conn.setReadTimeout(talHttpRequestParams.getReadTime());
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setUseCaches(false);
        if (talHttpRequestParams.getHeaderParam() != null && !talHttpRequestParams.getHeaderParam().isEmpty()) {
            for (Map.Entry next : talHttpRequestParams.getHeaderParam().entrySet()) {
                conn.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
        conn.setRequestProperty(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        conn.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(bytes.length));
        conn.getOutputStream().write(bytes);
        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            TalHttpResponse talHttpResponse = new TalHttpResponse(responseCode, dealResponseResult(conn.getInputStream()));
            Map headerFields = conn.getHeaderFields();
            for (String str2 : headerFields.keySet()) {
                if (str2 != null && TextUtils.equals("Tal-Need-Decrypt", str2.trim())) {
                    List list = (List) headerFields.get(str2);
                    if (list == null || list.size() <= 0 || !TextUtils.equals("1", (String) list.get(0))) {
                        return talHttpResponse;
                    }
                    talHttpResponse.setResult(TalTradeAES.aesDecode(talHttpResponse.getResult()));
                    return talHttpResponse;
                }
            }
            return talHttpResponse;
        } else if (responseCode < 300 || responseCode >= 400) {
            return new TalHttpResponse(responseCode, TalTradeSdk.getInstance().getApplication().getResources().getString(R.string.tal_trade_server_error));
        } else {
            String headerField = conn.getHeaderField(HttpHeaders.LOCATION);
            if (!TextUtils.isEmpty(headerField) && !url.equals(headerField)) {
                return sendPost(headerField, talHttpRequestParams, false);
            }
            return new TalHttpResponse(responseCode, "net error,redirect:" + headerField);
        }
    }

    private String getRequestData(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Map.Entry<String, String> key : map.entrySet()) {
                arrayList.add(key.getKey());
            }
            Collections.sort(arrayList);
            for (String str : arrayList) {
                String str2 = map.get(str);
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                jSONObject.put(str, str2);
            }
        } catch (Exception e) {
            TalTradeLogger logger = TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG);
            logger.i("getReqData:" + e);
        }
        return jSONObject.toJSONString();
    }

    private String dealResponseResult(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                TalTradeLogger logger = TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG);
                logger.i("readResponse:" + e);
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    private HostnameVerifier getHostnameVerifier(final String str) {
        if (this.mHostnameVerifier == null || !TextUtils.equals(this.lastHost, str)) {
            this.lastHost = str;
            this.mHostnameVerifier = new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    if ("trade.100tal.com".equals(str) || "test-trade.100tal.com".equals(str) || TextUtils.equals(str, str)) {
                        return true;
                    }
                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                }
            };
        }
        return this.mHostnameVerifier;
    }

    /* JADX WARNING: type inference failed for: r7v5, types: [java.net.URLConnection] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.net.HttpURLConnection getConn(java.net.URL r6, boolean r7) throws java.lang.Exception {
        /*
            r5 = this;
            r0 = 1
            javax.net.ssl.TrustManager[] r0 = new javax.net.ssl.TrustManager[r0]
            com.tal.user.global.trade.http.TalTradeBaseHttp$TrustAllTrustManager r1 = new com.tal.user.global.trade.http.TalTradeBaseHttp$TrustAllTrustManager
            r1.<init>()
            r2 = 0
            r0[r2] = r1
            java.lang.String r1 = "SSL"
            javax.net.ssl.SSLContext r1 = javax.net.ssl.SSLContext.getInstance(r1)
            javax.net.ssl.SSLSessionContext r3 = r1.getServerSessionContext()
            r3.setSessionTimeout(r2)
            r2 = 0
            r1.init(r2, r0, r2)
            if (r7 != 0) goto L_0x0027
            java.lang.String r7 = r6.getHost()
            java.lang.String r7 = r5.getHost(r7)
            goto L_0x0029
        L_0x0027:
            java.lang.String r7 = ""
        L_0x0029:
            boolean r0 = r5.useIp
            java.lang.String r2 = "https"
            if (r0 == 0) goto L_0x0081
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L_0x0081
            java.net.URL r0 = new java.net.URL
            java.lang.String r3 = r6.toString()
            java.lang.String r4 = r6.getHost()
            java.lang.String r3 = r3.replaceFirst(r4, r7)
            r0.<init>(r3)
            java.lang.String r3 = r0.getProtocol()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x006c
            java.net.URLConnection r0 = r0.openConnection()
            java.net.URLConnection r0 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r0)
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0
            r2 = r0
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2
            javax.net.ssl.SSLSocketFactory r1 = r1.getSocketFactory()
            r2.setSSLSocketFactory(r1)
            javax.net.ssl.HostnameVerifier r7 = r5.getHostnameVerifier(r7)
            r2.setHostnameVerifier(r7)
            goto L_0x0077
        L_0x006c:
            java.net.URLConnection r7 = r0.openConnection()
            java.net.URLConnection r7 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r7)
            r0 = r7
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
        L_0x0077:
            java.lang.String r6 = r6.getHost()
            java.lang.String r7 = "Host"
            r0.setRequestProperty(r7, r6)
            goto L_0x00c5
        L_0x0081:
            java.lang.String r0 = r6.getProtocol()
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00ba
            java.net.URLConnection r6 = r6.openConnection()
            java.net.URLConnection r6 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r6)
            r0 = r6
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0
            r6 = r0
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6
            javax.net.ssl.SSLSocketFactory r2 = r1.getSocketFactory()
            r6.setSSLSocketFactory(r2)
            java.io.PrintStream r2 = java.lang.System.out
            javax.net.ssl.SSLSocketFactory r3 = r6.getSSLSocketFactory()
            r2.println(r3)
            java.io.PrintStream r2 = java.lang.System.out
            javax.net.ssl.SSLSocketFactory r1 = r1.getSocketFactory()
            r2.println(r1)
            javax.net.ssl.HostnameVerifier r7 = r5.getHostnameVerifier(r7)
            r6.setHostnameVerifier(r7)
            goto L_0x00c5
        L_0x00ba:
            java.net.URLConnection r6 = r6.openConnection()
            java.net.URLConnection r6 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r6)
            r0 = r6
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
        L_0x00c5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.http.TalTradeBaseHttp.getConn(java.net.URL, boolean):java.net.HttpURLConnection");
    }

    class TrustAllTrustManager implements TrustManager, X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isClientTrusted(X509Certificate[] x509CertificateArr) {
            return true;
        }

        public boolean isServerTrusted(X509Certificate[] x509CertificateArr) {
            return true;
        }

        TrustAllTrustManager() {
        }
    }
}
