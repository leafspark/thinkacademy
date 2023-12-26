package com.bonree.sdk.common.json;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.igexin.assist.sdk.AssistPushConsts;
import java.util.Iterator;

public class XML {
    public static final Character AMP = '&';
    public static final Character APOS = '\'';
    public static final Character BANG = '!';
    public static final Character EQ = '=';
    public static final Character GT = '>';
    public static final Character LT = '<';
    public static final Character QUEST = '?';
    public static final Character QUOT = '\"';
    public static final Character SLASH = '/';

    public static String escape(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                stringBuffer.append("&quot;");
            } else if (charAt == '<') {
                stringBuffer.append("&lt;");
            } else if (charAt == '>') {
                stringBuffer.append("&gt;");
            } else if (charAt == '&') {
                stringBuffer.append("&amp;");
            } else if (charAt != '\'') {
                stringBuffer.append(charAt);
            } else {
                stringBuffer.append("&apos;");
            }
        }
        return stringBuffer.toString();
    }

    public static void noSpace(String str) throws JSONException {
        int length = str.length();
        if (length != 0) {
            int i = 0;
            while (i < length) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    i++;
                } else {
                    throw new JSONException("'" + str + "' contains a space character.");
                }
            }
            return;
        }
        throw new JSONException("Empty string.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e9, code lost:
        r7 = r10.nextToken();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ef, code lost:
        if ((r7 instanceof java.lang.String) == false) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0101, code lost:
        throw r10.syntaxError("Missing value");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean parse(com.bonree.sdk.common.json.XMLTokener r10, com.bonree.sdk.common.json.JSONObject r11, java.lang.String r12) throws com.bonree.sdk.common.json.JSONException {
        /*
            java.lang.Object r0 = r10.nextToken()
            java.lang.Character r1 = BANG
            java.lang.String r2 = "content"
            r3 = 1
            r4 = 0
            if (r0 != r1) goto L_0x006c
            char r12 = r10.next()
            r0 = 45
            if (r12 != r0) goto L_0x0024
            char r11 = r10.next()
            if (r11 != r0) goto L_0x0020
            java.lang.String r11 = "-->"
            r10.skipPast(r11)
            return r4
        L_0x0020:
            r10.back()
            goto L_0x004f
        L_0x0024:
            r0 = 91
            if (r12 != r0) goto L_0x004f
            java.lang.Object r12 = r10.nextToken()
            java.lang.String r1 = "CDATA"
            boolean r12 = r1.equals(r12)
            if (r12 == 0) goto L_0x0048
            char r12 = r10.next()
            if (r12 != r0) goto L_0x0048
            java.lang.String r10 = r10.nextCDATA()
            int r12 = r10.length()
            if (r12 <= 0) goto L_0x0047
            r11.accumulate(r2, r10)
        L_0x0047:
            return r4
        L_0x0048:
            java.lang.String r11 = "Expected 'CDATA['"
            com.bonree.sdk.common.json.JSONException r10 = r10.syntaxError(r11)
            throw r10
        L_0x004f:
            java.lang.Object r11 = r10.nextMeta()
            if (r11 == 0) goto L_0x0065
            java.lang.Character r12 = LT
            if (r11 != r12) goto L_0x005c
            int r3 = r3 + 1
            goto L_0x0062
        L_0x005c:
            java.lang.Character r12 = GT
            if (r11 != r12) goto L_0x0062
            int r3 = r3 + -1
        L_0x0062:
            if (r3 > 0) goto L_0x004f
            return r4
        L_0x0065:
            java.lang.String r11 = "Missing '>' after '<!'."
            com.bonree.sdk.common.json.JSONException r10 = r10.syntaxError(r11)
            throw r10
        L_0x006c:
            java.lang.Character r1 = QUEST
            if (r0 != r1) goto L_0x0076
            java.lang.String r11 = "?>"
            r10.skipPast(r11)
            return r4
        L_0x0076:
            java.lang.Character r1 = SLASH
            if (r0 != r1) goto L_0x00c4
            java.lang.Object r11 = r10.nextToken()
            if (r12 == 0) goto L_0x00b1
            boolean r0 = r11.equals(r12)
            if (r0 == 0) goto L_0x0096
            java.lang.Object r11 = r10.nextToken()
            java.lang.Character r12 = GT
            if (r11 != r12) goto L_0x008f
            return r3
        L_0x008f:
            java.lang.String r11 = "Misshaped close tag"
            com.bonree.sdk.common.json.JSONException r10 = r10.syntaxError(r11)
            throw r10
        L_0x0096:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Mismatched "
            r0.<init>(r1)
            r0.append(r12)
            java.lang.String r12 = " and "
            r0.append(r12)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            com.bonree.sdk.common.json.JSONException r10 = r10.syntaxError(r11)
            throw r10
        L_0x00b1:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Mismatched close tag "
            r12.<init>(r0)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            com.bonree.sdk.common.json.JSONException r10 = r10.syntaxError(r11)
            throw r10
        L_0x00c4:
            boolean r12 = r0 instanceof java.lang.Character
            java.lang.String r1 = "Misshaped tag"
            if (r12 != 0) goto L_0x018b
            java.lang.String r0 = (java.lang.String) r0
            com.bonree.sdk.common.json.JSONObject r12 = new com.bonree.sdk.common.json.JSONObject
            r12.<init>()
            r5 = 0
        L_0x00d2:
            r6 = r5
        L_0x00d3:
            if (r6 != 0) goto L_0x00d9
            java.lang.Object r6 = r10.nextToken()
        L_0x00d9:
            boolean r7 = r6 instanceof java.lang.String
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x0107
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r10.nextToken()
            java.lang.Character r9 = EQ
            if (r7 != r9) goto L_0x0102
            java.lang.Object r7 = r10.nextToken()
            boolean r8 = r7 instanceof java.lang.String
            if (r8 == 0) goto L_0x00fb
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = stringToValue(r7)
            r12.accumulate(r6, r7)
            goto L_0x00d2
        L_0x00fb:
            java.lang.String r11 = "Missing value"
            com.bonree.sdk.common.json.JSONException r10 = r10.syntaxError(r11)
            throw r10
        L_0x0102:
            r12.accumulate(r6, r8)
            r6 = r7
            goto L_0x00d3
        L_0x0107:
            java.lang.Character r5 = SLASH
            if (r6 != r5) goto L_0x0126
            java.lang.Object r2 = r10.nextToken()
            java.lang.Character r3 = GT
            if (r2 != r3) goto L_0x0121
            int r10 = r12.length()
            if (r10 <= 0) goto L_0x011d
            r11.accumulate(r0, r12)
            goto L_0x0120
        L_0x011d:
            r11.accumulate(r0, r8)
        L_0x0120:
            return r4
        L_0x0121:
            com.bonree.sdk.common.json.JSONException r10 = r10.syntaxError(r1)
            throw r10
        L_0x0126:
            java.lang.Character r5 = GT
            if (r6 != r5) goto L_0x0186
        L_0x012a:
            java.lang.Object r1 = r10.nextContent()
            if (r1 != 0) goto L_0x0146
            if (r0 != 0) goto L_0x0133
            return r4
        L_0x0133:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "Unclosed tag "
            r11.<init>(r12)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.bonree.sdk.common.json.JSONException r10 = r10.syntaxError(r11)
            throw r10
        L_0x0146:
            boolean r5 = r1 instanceof java.lang.String
            if (r5 == 0) goto L_0x015a
            java.lang.String r1 = (java.lang.String) r1
            int r5 = r1.length()
            if (r5 <= 0) goto L_0x012a
            java.lang.Object r1 = stringToValue(r1)
            r12.accumulate(r2, r1)
            goto L_0x012a
        L_0x015a:
            java.lang.Character r5 = LT
            if (r1 != r5) goto L_0x012a
            boolean r1 = parse(r10, r12, r0)
            if (r1 == 0) goto L_0x012a
            int r10 = r12.length()
            if (r10 != 0) goto L_0x016e
            r11.accumulate(r0, r8)
            goto L_0x0185
        L_0x016e:
            int r10 = r12.length()
            if (r10 != r3) goto L_0x0182
            java.lang.Object r10 = r12.opt(r2)
            if (r10 == 0) goto L_0x0182
            java.lang.Object r10 = r12.opt(r2)
            r11.accumulate(r0, r10)
            goto L_0x0185
        L_0x0182:
            r11.accumulate(r0, r12)
        L_0x0185:
            return r4
        L_0x0186:
            com.bonree.sdk.common.json.JSONException r10 = r10.syntaxError(r1)
            throw r10
        L_0x018b:
            com.bonree.sdk.common.json.JSONException r10 = r10.syntaxError(r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.common.json.XML.parse(com.bonree.sdk.common.json.XMLTokener, com.bonree.sdk.common.json.JSONObject, java.lang.String):boolean");
    }

    public static Object stringToValue(String str) {
        if ("".equals(str)) {
            return str;
        }
        if ("true".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        if ("null".equalsIgnoreCase(str)) {
            return JSONObject.NULL;
        }
        boolean z = false;
        if (AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE.equals(str)) {
            return 0;
        }
        try {
            char charAt = str.charAt(0);
            int i = 1;
            if (charAt == '-') {
                charAt = str.charAt(1);
                z = true;
            }
            if (charAt == '0') {
                if (z) {
                    i = 2;
                }
                if (str.charAt(i) == '0') {
                    return str;
                }
            }
            if (charAt >= '0' && charAt <= '9') {
                if (str.indexOf(46) >= 0) {
                    return Double.valueOf(str);
                }
                if (str.indexOf(101) < 0 && str.indexOf(69) < 0) {
                    Long l = new Long(str);
                    return l.longValue() == ((long) l.intValue()) ? new Integer(l.intValue()) : l;
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public static JSONObject toJSONObject(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        XMLTokener xMLTokener = new XMLTokener(str);
        while (xMLTokener.more() && xMLTokener.skipPast("<")) {
            parse(xMLTokener, jSONObject, (String) null);
        }
        return jSONObject;
    }

    public static String toString(Object obj) throws JSONException {
        return toString(obj, (String) null);
    }

    public static String toString(Object obj, String str) throws JSONException {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        if (obj instanceof JSONObject) {
            if (str != null) {
                stringBuffer.append('<');
                stringBuffer.append(str);
                stringBuffer.append('>');
            }
            JSONObject jSONObject = (JSONObject) obj;
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj2 = keys.next().toString();
                Object opt = jSONObject.opt(obj2);
                if (opt == null) {
                    opt = "";
                }
                if (FirebaseAnalytics.Param.CONTENT.equals(obj2)) {
                    if (opt instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) opt;
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            if (i > 0) {
                                stringBuffer.append(10);
                            }
                            stringBuffer.append(escape(jSONArray.get(i).toString()));
                        }
                    } else {
                        stringBuffer.append(escape(opt.toString()));
                    }
                } else if (opt instanceof JSONArray) {
                    JSONArray jSONArray2 = (JSONArray) opt;
                    int length2 = jSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        Object obj3 = jSONArray2.get(i2);
                        if (obj3 instanceof JSONArray) {
                            stringBuffer.append('<');
                            stringBuffer.append(obj2);
                            stringBuffer.append('>');
                            stringBuffer.append(toString(obj3));
                            stringBuffer.append("</");
                            stringBuffer.append(obj2);
                            stringBuffer.append('>');
                        } else {
                            stringBuffer.append(toString(obj3, obj2));
                        }
                    }
                } else if ("".equals(opt)) {
                    stringBuffer.append('<');
                    stringBuffer.append(obj2);
                    stringBuffer.append("/>");
                } else {
                    stringBuffer.append(toString(opt, obj2));
                }
            }
            if (str != null) {
                stringBuffer.append("</");
                stringBuffer.append(str);
                stringBuffer.append('>');
            }
            return stringBuffer.toString();
        }
        if (obj.getClass().isArray()) {
            obj = new JSONArray(obj);
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray3 = (JSONArray) obj;
            int length3 = jSONArray3.length();
            for (int i3 = 0; i3 < length3; i3++) {
                stringBuffer.append(toString(jSONArray3.opt(i3), str == null ? "array" : str));
            }
            return stringBuffer.toString();
        }
        if (obj == null) {
            str2 = "null";
        } else {
            str2 = escape(obj.toString());
        }
        if (str == null) {
            return "\"" + str2 + "\"";
        } else if (str2.length() == 0) {
            return "<" + str + "/>";
        } else {
            return "<" + str + ">" + str2 + "</" + str + ">";
        }
    }
}
