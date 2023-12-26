package com.bonree.sdk.common.json;

import java.util.Iterator;

public class JSONML {
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0114, code lost:
        r6 = r8.nextToken();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x011a, code lost:
        if ((r6 instanceof java.lang.String) == false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x012c, code lost:
        throw r8.syntaxError("Missing value");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object parse(com.bonree.sdk.common.json.XMLTokener r8, boolean r9, com.bonree.sdk.common.json.JSONArray r10) throws com.bonree.sdk.common.json.JSONException {
        /*
        L_0x0000:
            boolean r0 = r8.more()
            if (r0 == 0) goto L_0x01cc
            java.lang.Object r0 = r8.nextContent()
            java.lang.Character r1 = com.bonree.sdk.common.json.XML.LT
            if (r0 != r1) goto L_0x01bb
            java.lang.Object r0 = r8.nextToken()
            boolean r1 = r0 instanceof java.lang.Character
            java.lang.String r2 = "'."
            java.lang.String r3 = "Misshaped tag"
            if (r1 == 0) goto L_0x00c0
            java.lang.Character r1 = com.bonree.sdk.common.json.XML.SLASH
            if (r0 != r1) goto L_0x004d
            java.lang.Object r9 = r8.nextToken()
            boolean r10 = r9 instanceof java.lang.String
            if (r10 == 0) goto L_0x0036
            java.lang.Object r10 = r8.nextToken()
            java.lang.Character r0 = com.bonree.sdk.common.json.XML.GT
            if (r10 != r0) goto L_0x002f
            return r9
        L_0x002f:
            java.lang.String r9 = "Misshaped close tag"
            com.bonree.sdk.common.json.JSONException r8 = r8.syntaxError(r9)
            throw r8
        L_0x0036:
            com.bonree.sdk.common.json.JSONException r8 = new com.bonree.sdk.common.json.JSONException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "Expected a closing name instead of '"
            r10.<init>(r0)
            r10.append(r9)
            r10.append(r2)
            java.lang.String r9 = r10.toString()
            r8.<init>((java.lang.String) r9)
            throw r8
        L_0x004d:
            java.lang.Character r1 = com.bonree.sdk.common.json.XML.BANG
            if (r0 != r1) goto L_0x00b0
            char r0 = r8.next()
            r1 = 45
            if (r0 != r1) goto L_0x0069
            char r0 = r8.next()
            if (r0 != r1) goto L_0x0065
            java.lang.String r0 = "-->"
            r8.skipPast(r0)
            goto L_0x0000
        L_0x0065:
            r8.back()
            goto L_0x0000
        L_0x0069:
            r1 = 91
            if (r0 != r1) goto L_0x0091
            java.lang.Object r0 = r8.nextToken()
            java.lang.String r2 = "CDATA"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x008a
            char r0 = r8.next()
            if (r0 != r1) goto L_0x008a
            if (r10 == 0) goto L_0x0000
            java.lang.String r0 = r8.nextCDATA()
            r10.put((java.lang.Object) r0)
            goto L_0x0000
        L_0x008a:
            java.lang.String r9 = "Expected 'CDATA['"
            com.bonree.sdk.common.json.JSONException r8 = r8.syntaxError(r9)
            throw r8
        L_0x0091:
            r0 = 1
        L_0x0092:
            java.lang.Object r1 = r8.nextMeta()
            if (r1 == 0) goto L_0x00a9
            java.lang.Character r2 = com.bonree.sdk.common.json.XML.LT
            if (r1 != r2) goto L_0x009f
            int r0 = r0 + 1
            goto L_0x00a5
        L_0x009f:
            java.lang.Character r2 = com.bonree.sdk.common.json.XML.GT
            if (r1 != r2) goto L_0x00a5
            int r0 = r0 + -1
        L_0x00a5:
            if (r0 > 0) goto L_0x0092
            goto L_0x0000
        L_0x00a9:
            java.lang.String r9 = "Missing '>' after '<!'."
            com.bonree.sdk.common.json.JSONException r8 = r8.syntaxError(r9)
            throw r8
        L_0x00b0:
            java.lang.Character r1 = com.bonree.sdk.common.json.XML.QUEST
            if (r0 != r1) goto L_0x00bb
            java.lang.String r0 = "?>"
            r8.skipPast(r0)
            goto L_0x0000
        L_0x00bb:
            com.bonree.sdk.common.json.JSONException r8 = r8.syntaxError(r3)
            throw r8
        L_0x00c0:
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x01a5
            java.lang.String r0 = (java.lang.String) r0
            com.bonree.sdk.common.json.JSONArray r1 = new com.bonree.sdk.common.json.JSONArray
            r1.<init>()
            com.bonree.sdk.common.json.JSONObject r2 = new com.bonree.sdk.common.json.JSONObject
            r2.<init>()
            java.lang.String r4 = "tagName"
            if (r9 == 0) goto L_0x00dd
            r1.put((java.lang.Object) r0)
            if (r10 == 0) goto L_0x00e5
            r10.put((java.lang.Object) r1)
            goto L_0x00e5
        L_0x00dd:
            r2.put((java.lang.String) r4, (java.lang.Object) r0)
            if (r10 == 0) goto L_0x00e5
            r10.put((java.lang.Object) r2)
        L_0x00e5:
            r5 = 0
        L_0x00e6:
            if (r5 != 0) goto L_0x00ec
            java.lang.Object r5 = r8.nextToken()
        L_0x00ec:
            if (r5 == 0) goto L_0x01a0
            boolean r6 = r5 instanceof java.lang.String
            if (r6 == 0) goto L_0x0134
            java.lang.String r5 = (java.lang.String) r5
            if (r9 != 0) goto L_0x010c
            boolean r6 = r4.equals(r5)
            if (r6 != 0) goto L_0x0105
            java.lang.String r6 = "childNode"
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L_0x0105
            goto L_0x010c
        L_0x0105:
            java.lang.String r9 = "Reserved attribute."
            com.bonree.sdk.common.json.JSONException r8 = r8.syntaxError(r9)
            throw r8
        L_0x010c:
            java.lang.Object r6 = r8.nextToken()
            java.lang.Character r7 = com.bonree.sdk.common.json.XML.EQ
            if (r6 != r7) goto L_0x012d
            java.lang.Object r6 = r8.nextToken()
            boolean r7 = r6 instanceof java.lang.String
            if (r7 == 0) goto L_0x0126
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = com.bonree.sdk.common.json.XML.stringToValue(r6)
            r2.accumulate(r5, r6)
            goto L_0x00e5
        L_0x0126:
            java.lang.String r9 = "Missing value"
            com.bonree.sdk.common.json.JSONException r8 = r8.syntaxError(r9)
            throw r8
        L_0x012d:
            java.lang.String r7 = ""
            r2.accumulate(r5, r7)
            r5 = r6
            goto L_0x00e6
        L_0x0134:
            if (r9 == 0) goto L_0x013f
            int r4 = r2.length()
            if (r4 <= 0) goto L_0x013f
            r1.put((java.lang.Object) r2)
        L_0x013f:
            java.lang.Character r4 = com.bonree.sdk.common.json.XML.SLASH
            if (r5 != r4) goto L_0x0156
            java.lang.Object r0 = r8.nextToken()
            java.lang.Character r4 = com.bonree.sdk.common.json.XML.GT
            if (r0 != r4) goto L_0x0151
            if (r10 != 0) goto L_0x0000
            if (r9 == 0) goto L_0x0150
            return r1
        L_0x0150:
            return r2
        L_0x0151:
            com.bonree.sdk.common.json.JSONException r8 = r8.syntaxError(r3)
            throw r8
        L_0x0156:
            java.lang.Character r4 = com.bonree.sdk.common.json.XML.GT
            if (r5 != r4) goto L_0x019b
            java.lang.Object r3 = parse(r8, r9, r1)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x0000
            boolean r4 = r3.equals(r0)
            if (r4 == 0) goto L_0x017b
            if (r9 != 0) goto L_0x0175
            int r0 = r1.length()
            if (r0 <= 0) goto L_0x0175
            java.lang.String r0 = "childNodes"
            r2.put((java.lang.String) r0, (java.lang.Object) r1)
        L_0x0175:
            if (r10 != 0) goto L_0x0000
            if (r9 == 0) goto L_0x017a
            return r1
        L_0x017a:
            return r2
        L_0x017b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Mismatched '"
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = "' and '"
            r9.append(r10)
            r9.append(r3)
            java.lang.String r10 = "'"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.bonree.sdk.common.json.JSONException r8 = r8.syntaxError(r9)
            throw r8
        L_0x019b:
            com.bonree.sdk.common.json.JSONException r8 = r8.syntaxError(r3)
            throw r8
        L_0x01a0:
            com.bonree.sdk.common.json.JSONException r8 = r8.syntaxError(r3)
            throw r8
        L_0x01a5:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Bad tagName '"
            r9.<init>(r10)
            r9.append(r0)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            com.bonree.sdk.common.json.JSONException r8 = r8.syntaxError(r9)
            throw r8
        L_0x01bb:
            if (r10 == 0) goto L_0x0000
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x01c7
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = com.bonree.sdk.common.json.XML.stringToValue(r0)
        L_0x01c7:
            r10.put((java.lang.Object) r0)
            goto L_0x0000
        L_0x01cc:
            java.lang.String r9 = "Bad XML"
            com.bonree.sdk.common.json.JSONException r8 = r8.syntaxError(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.common.json.JSONML.parse(com.bonree.sdk.common.json.XMLTokener, boolean, com.bonree.sdk.common.json.JSONArray):java.lang.Object");
    }

    public static JSONArray toJSONArray(String str) throws JSONException {
        return toJSONArray(new XMLTokener(str));
    }

    public static JSONArray toJSONArray(XMLTokener xMLTokener) throws JSONException {
        return (JSONArray) parse(xMLTokener, true, (JSONArray) null);
    }

    public static JSONObject toJSONObject(XMLTokener xMLTokener) throws JSONException {
        return (JSONObject) parse(xMLTokener, false, (JSONArray) null);
    }

    public static JSONObject toJSONObject(String str) throws JSONException {
        return toJSONObject(new XMLTokener(str));
    }

    public static String toString(JSONArray jSONArray) throws JSONException {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        String string = jSONArray.getString(0);
        XML.noSpace(string);
        String escape = XML.escape(string);
        stringBuffer.append('<');
        stringBuffer.append(escape);
        Object opt = jSONArray.opt(1);
        if (opt instanceof JSONObject) {
            i = 2;
            JSONObject jSONObject = (JSONObject) opt;
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                XML.noSpace(obj);
                String optString = jSONObject.optString(obj);
                if (optString != null) {
                    stringBuffer.append(' ');
                    stringBuffer.append(XML.escape(obj));
                    stringBuffer.append('=');
                    stringBuffer.append('\"');
                    stringBuffer.append(XML.escape(optString));
                    stringBuffer.append('\"');
                }
            }
        } else {
            i = 1;
        }
        int length = jSONArray.length();
        if (i >= length) {
            stringBuffer.append('/');
            stringBuffer.append('>');
        } else {
            stringBuffer.append('>');
            do {
                Object obj2 = jSONArray.get(i);
                i++;
                if (obj2 != null) {
                    if (obj2 instanceof String) {
                        stringBuffer.append(XML.escape(obj2.toString()));
                        continue;
                    } else if (obj2 instanceof JSONObject) {
                        stringBuffer.append(toString((JSONObject) obj2));
                        continue;
                    } else if (obj2 instanceof JSONArray) {
                        stringBuffer.append(toString((JSONArray) obj2));
                        continue;
                    } else {
                        continue;
                    }
                }
            } while (i < length);
            stringBuffer.append('<');
            stringBuffer.append('/');
            stringBuffer.append(escape);
            stringBuffer.append('>');
        }
        return stringBuffer.toString();
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        StringBuffer stringBuffer = new StringBuffer();
        String optString = jSONObject.optString("tagName");
        if (optString == null) {
            return XML.escape(jSONObject.toString());
        }
        XML.noSpace(optString);
        String escape = XML.escape(optString);
        stringBuffer.append('<');
        stringBuffer.append(escape);
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            if (!"tagName".equals(obj) && !"childNodes".equals(obj)) {
                XML.noSpace(obj);
                String optString2 = jSONObject.optString(obj);
                if (optString2 != null) {
                    stringBuffer.append(' ');
                    stringBuffer.append(XML.escape(obj));
                    stringBuffer.append('=');
                    stringBuffer.append('\"');
                    stringBuffer.append(XML.escape(optString2));
                    stringBuffer.append('\"');
                }
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("childNodes");
        if (optJSONArray == null) {
            stringBuffer.append('/');
            stringBuffer.append('>');
        } else {
            stringBuffer.append('>');
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                Object obj2 = optJSONArray.get(i);
                if (obj2 != null) {
                    if (obj2 instanceof String) {
                        stringBuffer.append(XML.escape(obj2.toString()));
                    } else if (obj2 instanceof JSONObject) {
                        stringBuffer.append(toString((JSONObject) obj2));
                    } else if (obj2 instanceof JSONArray) {
                        stringBuffer.append(toString((JSONArray) obj2));
                    } else {
                        stringBuffer.append(obj2.toString());
                    }
                }
            }
            stringBuffer.append('<');
            stringBuffer.append('/');
            stringBuffer.append(escape);
            stringBuffer.append('>');
        }
        return stringBuffer.toString();
    }
}
