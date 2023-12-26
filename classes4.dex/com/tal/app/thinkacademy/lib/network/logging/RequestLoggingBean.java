package com.tal.app.thinkacademy.lib.network.logging;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class RequestLoggingBean {
    public String http_version;
    public String method;
    public String requestBody;
    public HashMap<String, String> requestHeaderMaps = new HashMap<>();
    public String uri;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("request ");
        sb.append(this.method);
        sb.append(" ");
        sb.append(this.uri);
        sb.append(" ");
        sb.append(this.http_version);
        sb.append(System.lineSeparator());
        try {
            for (Map.Entry next : this.requestHeaderMaps.entrySet()) {
                sb.append((String) next.getKey());
                sb.append("：");
                sb.append((String) next.getValue());
                sb.append(System.lineSeparator());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.requestBody)) {
            sb.append(this.requestBody);
        }
        return sb.toString();
    }
}
