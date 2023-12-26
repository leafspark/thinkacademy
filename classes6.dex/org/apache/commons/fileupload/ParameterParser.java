package org.apache.commons.fileupload;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.fileupload.util.mime.MimeUtility;

public class ParameterParser {
    private char[] chars = null;
    private int i1 = 0;
    private int i2 = 0;
    private int len = 0;
    private boolean lowerCaseNames = false;
    private int pos = 0;

    private boolean hasChar() {
        return this.pos < this.len;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getToken(boolean r5) {
        /*
            r4 = this;
        L_0x0000:
            int r0 = r4.i1
            int r1 = r4.i2
            if (r0 >= r1) goto L_0x0017
            char[] r1 = r4.chars
            char r0 = r1[r0]
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 == 0) goto L_0x0017
            int r0 = r4.i1
            int r0 = r0 + 1
            r4.i1 = r0
            goto L_0x0000
        L_0x0017:
            int r0 = r4.i2
            int r1 = r4.i1
            if (r0 <= r1) goto L_0x0030
            char[] r1 = r4.chars
            int r0 = r0 + -1
            char r0 = r1[r0]
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 == 0) goto L_0x0030
            int r0 = r4.i2
            int r0 = r0 + -1
            r4.i2 = r0
            goto L_0x0017
        L_0x0030:
            if (r5 == 0) goto L_0x0051
            int r5 = r4.i2
            int r0 = r4.i1
            int r1 = r5 - r0
            r2 = 2
            if (r1 < r2) goto L_0x0051
            char[] r1 = r4.chars
            char r2 = r1[r0]
            r3 = 34
            if (r2 != r3) goto L_0x0051
            int r2 = r5 + -1
            char r1 = r1[r2]
            if (r1 != r3) goto L_0x0051
            int r0 = r0 + 1
            r4.i1 = r0
            int r5 = r5 + -1
            r4.i2 = r5
        L_0x0051:
            r5 = 0
            int r0 = r4.i2
            int r1 = r4.i1
            if (r0 <= r1) goto L_0x0060
            java.lang.String r5 = new java.lang.String
            char[] r2 = r4.chars
            int r0 = r0 - r1
            r5.<init>(r2, r1, r0)
        L_0x0060:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.fileupload.ParameterParser.getToken(boolean):java.lang.String");
    }

    private boolean isOneOf(char c, char[] cArr) {
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    private String parseToken(char[] cArr) {
        int i = this.pos;
        this.i1 = i;
        this.i2 = i;
        while (hasChar() && !isOneOf(this.chars[this.pos], cArr)) {
            this.i2++;
            this.pos++;
        }
        return getToken(false);
    }

    private String parseQuotedToken(char[] cArr) {
        int i = this.pos;
        this.i1 = i;
        this.i2 = i;
        boolean z = false;
        boolean z2 = false;
        while (hasChar()) {
            char c = this.chars[this.pos];
            if (!z && isOneOf(c, cArr)) {
                break;
            }
            if (!z2 && c == '\"') {
                z = !z;
            }
            z2 = !z2 && c == '\\';
            this.i2++;
            this.pos++;
        }
        return getToken(true);
    }

    public boolean isLowerCaseNames() {
        return this.lowerCaseNames;
    }

    public void setLowerCaseNames(boolean z) {
        this.lowerCaseNames = z;
    }

    public Map<String, String> parse(String str, char[] cArr) {
        if (cArr == null || cArr.length == 0) {
            return new HashMap();
        }
        char c = cArr[0];
        if (str != null) {
            int length = str.length();
            for (char c2 : cArr) {
                int indexOf = str.indexOf(c2);
                if (indexOf != -1 && indexOf < length) {
                    c = c2;
                    length = indexOf;
                }
            }
        }
        return parse(str, c);
    }

    public Map<String, String> parse(String str, char c) {
        if (str == null) {
            return new HashMap();
        }
        return parse(str.toCharArray(), c);
    }

    public Map<String, String> parse(char[] cArr, char c) {
        if (cArr == null) {
            return new HashMap();
        }
        return parse(cArr, 0, cArr.length, c);
    }

    public Map<String, String> parse(char[] cArr, int i, int i3, char c) {
        if (cArr == null) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        this.chars = cArr;
        this.pos = i;
        this.len = i3;
        while (hasChar()) {
            String parseToken = parseToken(new char[]{'=', c});
            String str = null;
            if (hasChar()) {
                int i4 = this.pos;
                if (cArr[i4] == '=') {
                    this.pos = i4 + 1;
                    str = parseQuotedToken(new char[]{c});
                    if (str != null) {
                        try {
                            str = MimeUtility.decodeText(str);
                        } catch (UnsupportedEncodingException unused) {
                        }
                    }
                }
            }
            if (hasChar()) {
                int i5 = this.pos;
                if (cArr[i5] == c) {
                    this.pos = i5 + 1;
                }
            }
            if (parseToken != null && parseToken.length() > 0) {
                if (this.lowerCaseNames) {
                    parseToken = parseToken.toLowerCase(Locale.ENGLISH);
                }
                hashMap.put(parseToken, str);
            }
        }
        return hashMap;
    }
}
