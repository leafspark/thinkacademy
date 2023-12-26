package com.tal.app.thinkacademy.lib.network.logging;

import java.util.HashMap;
import java.util.Map;

public class ResponseLoggingBean {
    public int code;
    public String responseBody;
    public HashMap<String, String> responseHeaderMaps = new HashMap<>();
    public String time;
    public String uri;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("response ");
        sb.append(this.code);
        sb.append(" ");
        sb.append(this.uri);
        sb.append(" ");
        sb.append(this.time);
        sb.append(System.lineSeparator());
        try {
            for (Map.Entry next : this.responseHeaderMaps.entrySet()) {
                sb.append((String) next.getKey());
                sb.append("：");
                sb.append((String) next.getValue());
                sb.append(System.lineSeparator());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }
}
