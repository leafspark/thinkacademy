package com.bonree.sdk.common.json;

import java.util.Iterator;

public class HTTP {
    public static final String CRLF = "\r\n";

    public static JSONObject toJSONObject(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        HTTPTokener hTTPTokener = new HTTPTokener(str);
        String nextToken = hTTPTokener.nextToken();
        if (nextToken.toUpperCase().startsWith("HTTP")) {
            jSONObject.put("HTTP-Version", (Object) nextToken);
            jSONObject.put("Status-Code", (Object) hTTPTokener.nextToken());
            jSONObject.put("Reason-Phrase", (Object) hTTPTokener.nextTo(0));
            hTTPTokener.next();
        } else {
            jSONObject.put("Method", (Object) nextToken);
            jSONObject.put("Request-URI", (Object) hTTPTokener.nextToken());
            jSONObject.put("HTTP-Version", (Object) hTTPTokener.nextToken());
        }
        while (hTTPTokener.more()) {
            String nextTo = hTTPTokener.nextTo(':');
            hTTPTokener.next(':');
            jSONObject.put(nextTo, (Object) hTTPTokener.nextTo(0));
            hTTPTokener.next();
        }
        return jSONObject;
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        Iterator keys = jSONObject.keys();
        StringBuffer stringBuffer = new StringBuffer();
        if (jSONObject.has("Status-Code") && jSONObject.has("Reason-Phrase")) {
            stringBuffer.append(jSONObject.getString("HTTP-Version"));
            stringBuffer.append(' ');
            stringBuffer.append(jSONObject.getString("Status-Code"));
            stringBuffer.append(' ');
            stringBuffer.append(jSONObject.getString("Reason-Phrase"));
        } else if (!jSONObject.has("Method") || !jSONObject.has("Request-URI")) {
            throw new JSONException("Not enough material for an HTTP header.");
        } else {
            stringBuffer.append(jSONObject.getString("Method"));
            stringBuffer.append(' ');
            stringBuffer.append('\"');
            stringBuffer.append(jSONObject.getString("Request-URI"));
            stringBuffer.append('\"');
            stringBuffer.append(' ');
            stringBuffer.append(jSONObject.getString("HTTP-Version"));
        }
        stringBuffer.append(CRLF);
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            if (!"HTTP-Version".equals(obj) && !"Status-Code".equals(obj) && !"Reason-Phrase".equals(obj) && !"Method".equals(obj) && !"Request-URI".equals(obj) && !jSONObject.isNull(obj)) {
                stringBuffer.append(obj);
                stringBuffer.append(": ");
                stringBuffer.append(jSONObject.getString(obj));
                stringBuffer.append(CRLF);
            }
        }
        stringBuffer.append(CRLF);
        return stringBuffer.toString();
    }
}
