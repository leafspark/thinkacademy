package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;

public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if (c >= '0' && c <= '9' && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
            if (c5 == '0') {
                if (c6 < '1' || c6 > '9') {
                    return false;
                }
            } else if (!(c5 == '1' && (c6 == '0' || c6 == '1' || c6 == '2'))) {
                return false;
            }
            return i == 48 ? i2 >= 49 && i2 <= 57 : (i == 49 || i == 50) ? i2 >= 48 && i2 <= 57 : i == 51 && (i2 == 48 || i2 == 49);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r6 <= '4') goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkTime(char r5, char r6, char r7, char r8, char r9, char r10) {
        /*
            r4 = this;
            r0 = 57
            r1 = 0
            r2 = 48
            if (r5 != r2) goto L_0x000c
            if (r6 < r2) goto L_0x000b
            if (r6 <= r0) goto L_0x0020
        L_0x000b:
            return r1
        L_0x000c:
            r3 = 49
            if (r5 != r3) goto L_0x0015
            if (r6 < r2) goto L_0x0014
            if (r6 <= r0) goto L_0x0020
        L_0x0014:
            return r1
        L_0x0015:
            r3 = 50
            if (r5 != r3) goto L_0x0042
            if (r6 < r2) goto L_0x0042
            r5 = 52
            if (r6 <= r5) goto L_0x0020
            goto L_0x0042
        L_0x0020:
            r5 = 53
            r6 = 54
            if (r7 < r2) goto L_0x002d
            if (r7 > r5) goto L_0x002d
            if (r8 < r2) goto L_0x002c
            if (r8 <= r0) goto L_0x0032
        L_0x002c:
            return r1
        L_0x002d:
            if (r7 != r6) goto L_0x0042
            if (r8 == r2) goto L_0x0032
            return r1
        L_0x0032:
            if (r9 < r2) goto L_0x003b
            if (r9 > r5) goto L_0x003b
            if (r10 < r2) goto L_0x003a
            if (r10 <= r0) goto L_0x0040
        L_0x003a:
            return r1
        L_0x003b:
            if (r9 != r6) goto L_0x0042
            if (r10 == r2) goto L_0x0040
            return r1
        L_0x0040:
            r5 = 1
            return r5
        L_0x0042:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.checkTime(char, char, char, char, char, char):boolean");
    }

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(String str, int i) {
        super(i);
        this.text = str;
        this.len = str.length();
        this.bp = -1;
        next();
        if (this.ch == 65279) {
            next();
        }
    }

    public final char charAt(int i) {
        if (i >= this.len) {
            return JSONLexer.EOI;
        }
        return this.text.charAt(i);
    }

    public final char next() {
        char c;
        int i = this.bp + 1;
        this.bp = i;
        if (i >= this.len) {
            c = JSONLexer.EOI;
        } else {
            c = this.text.charAt(i);
        }
        this.ch = c;
        return c;
    }

    public JSONScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    /* access modifiers changed from: protected */
    public final void copyTo(int i, int i2, char[] cArr) {
        this.text.getChars(i, i2 + i, cArr, 0);
    }

    static boolean charArrayCompare(String str, int i, char[] cArr) {
        int length = cArr.length;
        if (length + i > str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (cArr[i2] != str.charAt(i + i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.bp, cArr);
    }

    public final int indexOf(char c, int i) {
        return this.text.indexOf(c, i);
    }

    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i, i2, i3);
    }

    public byte[] bytesValue() {
        if (this.token == 26) {
            int i = this.np + 1;
            int i2 = this.sp;
            if (i2 % 2 == 0) {
                int i3 = i2 / 2;
                byte[] bArr = new byte[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = (i4 * 2) + i;
                    char charAt = this.text.charAt(i5);
                    char charAt2 = this.text.charAt(i5 + 1);
                    char c = '0';
                    int i6 = charAt - (charAt <= '9' ? '0' : '7');
                    if (charAt2 > '9') {
                        c = '7';
                    }
                    bArr[i4] = (byte) ((i6 << 4) | (charAt2 - c));
                }
                return bArr;
            }
            throw new JSONException("illegal state. " + i2);
        } else if (!this.hasSpecial) {
            return IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
        } else {
            return IOUtils.decodeBase64(new String(this.sbuf, 0, this.sp));
        }
    }

    public final String stringVal() {
        if (!this.hasSpecial) {
            return subString(this.np + 1, this.sp);
        }
        return new String(this.sbuf, 0, this.sp);
    }

    public final String subString(int i, int i2) {
        if (!ASMUtils.IS_ANDROID) {
            return this.text.substring(i, i2 + i);
        }
        if (i2 < this.sbuf.length) {
            this.text.getChars(i, i + i2, this.sbuf, 0);
            return new String(this.sbuf, 0, i2);
        }
        char[] cArr = new char[i2];
        this.text.getChars(i, i2 + i, cArr, 0);
        return new String(cArr);
    }

    public final char[] sub_chars(int i, int i2) {
        if (!ASMUtils.IS_ANDROID || i2 >= this.sbuf.length) {
            char[] cArr = new char[i2];
            this.text.getChars(i, i2 + i, cArr, 0);
            return cArr;
        }
        this.text.getChars(i, i2 + i, this.sbuf, 0);
        return this.sbuf;
    }

    public final String numberString() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        return subString(this.np, i);
    }

    public final BigDecimal decimalValue() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        int i2 = this.np;
        if (i < this.sbuf.length) {
            this.text.getChars(i2, i2 + i, this.sbuf, 0);
            return new BigDecimal(this.sbuf, 0, i);
        }
        char[] cArr = new char[i];
        this.text.getChars(i2, i + i2, cArr, 0);
        return new BigDecimal(cArr);
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        return scanISO8601DateIfMatch(z, this.len - this.bp);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e7, code lost:
        if (r6 != ' ') goto L_0x00e9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x021c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0583 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0584  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean scanISO8601DateIfMatch(boolean r35, int r36) {
        /*
            r34 = this;
            r9 = r34
            r10 = r36
            r11 = 8
            r12 = 0
            if (r10 >= r11) goto L_0x000a
            return r12
        L_0x000a:
            int r0 = r9.bp
            char r13 = r9.charAt(r0)
            int r0 = r9.bp
            r14 = 1
            int r0 = r0 + r14
            char r15 = r9.charAt(r0)
            int r0 = r9.bp
            r8 = 2
            int r0 = r0 + r8
            char r0 = r9.charAt(r0)
            int r1 = r9.bp
            r16 = 3
            int r1 = r1 + 3
            char r7 = r9.charAt(r1)
            int r1 = r9.bp
            int r1 = r1 + 4
            char r1 = r9.charAt(r1)
            int r2 = r9.bp
            r6 = 5
            int r2 = r2 + r6
            char r2 = r9.charAt(r2)
            int r3 = r9.bp
            r17 = 6
            int r3 = r3 + 6
            char r3 = r9.charAt(r3)
            int r4 = r9.bp
            int r4 = r4 + 7
            char r4 = r9.charAt(r4)
            r5 = 13
            r11 = 57
            r6 = 48
            if (r35 != 0) goto L_0x00c8
            if (r10 <= r5) goto L_0x00c8
            int r5 = r9.bp
            int r5 = r5 + r10
            int r5 = r5 - r14
            char r5 = r9.charAt(r5)
            int r14 = r9.bp
            int r14 = r14 + r10
            int r14 = r14 - r8
            char r14 = r9.charAt(r14)
            r8 = 47
            if (r13 != r8) goto L_0x00c8
            r8 = 68
            if (r15 != r8) goto L_0x00c8
            r8 = 97
            if (r0 != r8) goto L_0x00c8
            r8 = 116(0x74, float:1.63E-43)
            if (r7 != r8) goto L_0x00c8
            r8 = 101(0x65, float:1.42E-43)
            if (r1 != r8) goto L_0x00c8
            r8 = 40
            if (r2 != r8) goto L_0x00c8
            r8 = 47
            if (r5 != r8) goto L_0x00c8
            r5 = 41
            if (r14 != r5) goto L_0x00c8
            r0 = -1
            r1 = r17
        L_0x0089:
            if (r1 >= r10) goto L_0x00a0
            int r2 = r9.bp
            int r2 = r2 + r1
            char r2 = r9.charAt(r2)
            r3 = 43
            if (r2 != r3) goto L_0x0098
            r0 = r1
            goto L_0x009d
        L_0x0098:
            if (r2 < r6) goto L_0x00a0
            if (r2 <= r11) goto L_0x009d
            goto L_0x00a0
        L_0x009d:
            int r1 = r1 + 1
            goto L_0x0089
        L_0x00a0:
            r1 = -1
            if (r0 != r1) goto L_0x00a4
            return r12
        L_0x00a4:
            int r1 = r9.bp
            int r1 = r1 + 6
            int r2 = r9.bp
            int r2 = r2 + r0
            int r2 = r2 - r1
            java.lang.String r0 = r9.subString(r1, r2)
            long r0 = java.lang.Long.parseLong(r0)
            java.util.TimeZone r2 = r9.timeZone
            java.util.Locale r3 = r9.locale
            java.util.Calendar r2 = java.util.Calendar.getInstance(r2, r3)
            r9.calendar = r2
            java.util.Calendar r2 = r9.calendar
            r2.setTimeInMillis(r0)
            r8 = 5
            r9.token = r8
        L_0x00c6:
            r0 = 1
            return r0
        L_0x00c8:
            r8 = 5
            r5 = 16
            r11 = 84
            r12 = 14
            r14 = 45
            r21 = 10
            r6 = 8
            if (r10 == r6) goto L_0x057b
            if (r10 == r12) goto L_0x057b
            if (r10 != r5) goto L_0x00e9
            int r6 = r9.bp
            int r6 = r6 + 10
            char r6 = r9.charAt(r6)
            if (r6 == r11) goto L_0x057b
            r5 = 32
            if (r6 == r5) goto L_0x00f7
        L_0x00e9:
            r5 = 17
            if (r10 != r5) goto L_0x0100
            int r5 = r9.bp
            int r5 = r5 + 6
            char r5 = r9.charAt(r5)
            if (r5 == r14) goto L_0x0100
        L_0x00f7:
            r5 = 0
            r8 = 48
            r12 = 13
            r14 = 16
            goto L_0x0581
        L_0x0100:
            r5 = 9
            if (r10 >= r5) goto L_0x0106
            r6 = 0
            return r6
        L_0x0106:
            int r6 = r9.bp
            r18 = 8
            int r6 = r6 + 8
            char r6 = r9.charAt(r6)
            int r8 = r9.bp
            int r8 = r8 + r5
            char r5 = r9.charAt(r8)
            r12 = 26085(0x65e5, float:3.6553E-41)
            if (r1 != r14) goto L_0x011d
            if (r4 == r14) goto L_0x0125
        L_0x011d:
            r8 = 47
            if (r1 != r8) goto L_0x0137
            r8 = 47
            if (r4 != r8) goto L_0x0137
        L_0x0125:
            r4 = r7
            r1 = r13
            r13 = r21
            r8 = 51068(0xc77c, float:7.1562E-41)
        L_0x012c:
            r7 = r6
            r6 = r3
            r3 = r0
            r32 = r5
            r5 = r2
            r2 = r15
            r15 = r32
            goto L_0x0206
        L_0x0137:
            if (r1 != r14) goto L_0x0166
            if (r3 != r14) goto L_0x0166
            r8 = 32
            if (r6 != r8) goto L_0x0150
            r3 = r0
            r6 = r2
            r1 = r13
            r2 = r15
            r5 = 48
            r8 = 51068(0xc77c, float:7.1562E-41)
            r13 = 8
        L_0x014a:
            r15 = r4
            r4 = r7
            r7 = 48
            goto L_0x0206
        L_0x0150:
            r3 = r0
            r1 = r13
            r5 = 48
            r8 = 51068(0xc77c, float:7.1562E-41)
            r13 = 9
        L_0x0159:
            r32 = r6
            r6 = r2
            r2 = r15
            r15 = r32
            r33 = r7
            r7 = r4
            r4 = r33
            goto L_0x0206
        L_0x0166:
            r8 = 46
            if (r0 != r8) goto L_0x016e
            r8 = 46
            if (r2 == r8) goto L_0x0172
        L_0x016e:
            if (r0 != r14) goto L_0x0183
            if (r2 != r14) goto L_0x0183
        L_0x0172:
            r2 = r4
            r4 = r5
            r5 = r7
            r7 = r13
            r13 = r21
            r8 = 51068(0xc77c, float:7.1562E-41)
            r32 = r6
            r6 = r1
            r1 = r3
            r3 = r32
            goto L_0x0206
        L_0x0183:
            if (r6 != r11) goto L_0x0194
            r5 = r1
            r6 = r2
            r1 = r13
            r2 = r15
            r8 = 51068(0xc77c, float:7.1562E-41)
            r13 = 8
            r15 = r4
            r4 = r7
            r7 = r3
        L_0x0191:
            r3 = r0
            goto L_0x0206
        L_0x0194:
            r8 = 24180(0x5e74, float:3.3883E-41)
            if (r1 == r8) goto L_0x01a0
            r8 = 45380(0xb144, float:6.3591E-41)
            if (r1 != r8) goto L_0x019e
            goto L_0x01a0
        L_0x019e:
            r1 = 0
            return r1
        L_0x01a0:
            r1 = 26376(0x6708, float:3.696E-41)
            if (r4 == r1) goto L_0x01d6
            r1 = 50900(0xc6d4, float:7.1326E-41)
            if (r4 != r1) goto L_0x01aa
            goto L_0x01d6
        L_0x01aa:
            r1 = 26376(0x6708, float:3.696E-41)
            if (r3 == r1) goto L_0x01b6
            r1 = 50900(0xc6d4, float:7.1326E-41)
            if (r3 != r1) goto L_0x01b4
            goto L_0x01b6
        L_0x01b4:
            r1 = 0
            return r1
        L_0x01b6:
            r1 = 0
            r8 = 51068(0xc77c, float:7.1562E-41)
            if (r6 == r12) goto L_0x01cc
            if (r6 != r8) goto L_0x01bf
            goto L_0x01cc
        L_0x01bf:
            if (r5 == r12) goto L_0x01c5
            if (r5 != r8) goto L_0x01c4
            goto L_0x01c5
        L_0x01c4:
            return r1
        L_0x01c5:
            r3 = r0
            r1 = r13
            r13 = r21
            r5 = 48
            goto L_0x0159
        L_0x01cc:
            r3 = r0
            r6 = r2
            r1 = r13
            r2 = r15
            r13 = r21
            r5 = 48
            goto L_0x014a
        L_0x01d6:
            r8 = 51068(0xc77c, float:7.1562E-41)
            if (r5 == r12) goto L_0x01fb
            if (r5 != r8) goto L_0x01de
            goto L_0x01fb
        L_0x01de:
            int r1 = r9.bp
            int r1 = r1 + 10
            char r1 = r9.charAt(r1)
            if (r1 == r12) goto L_0x01f5
            int r1 = r9.bp
            int r1 = r1 + 10
            char r1 = r9.charAt(r1)
            if (r1 != r8) goto L_0x01f3
            goto L_0x01f5
        L_0x01f3:
            r1 = 0
            return r1
        L_0x01f5:
            r4 = r7
            r1 = r13
            r13 = 11
            goto L_0x012c
        L_0x01fb:
            r5 = r2
            r4 = r7
            r1 = r13
            r2 = r15
            r13 = r21
            r7 = 48
            r15 = r6
            r6 = r3
            goto L_0x0191
        L_0x0206:
            r24 = r1
            r25 = r2
            r26 = r3
            r27 = r4
            r28 = r5
            r29 = r6
            r30 = r7
            r31 = r15
            boolean r0 = checkDate(r24, r25, r26, r27, r28, r29, r30, r31)
            if (r0 != 0) goto L_0x021e
            r0 = 0
            return r0
        L_0x021e:
            r0 = r34
            r14 = 16
            r12 = 5
            r12 = 2
            r8 = r15
            r0.setCalendar(r1, r2, r3, r4, r5, r6, r7, r8)
            int r0 = r9.bp
            int r0 = r0 + r13
            char r7 = r9.charAt(r0)
            if (r7 != r11) goto L_0x02be
            if (r10 != r14) goto L_0x02be
            r0 = 8
            if (r13 != r0) goto L_0x02be
            int r0 = r9.bp
            int r0 = r0 + 15
            char r0 = r9.charAt(r0)
            r1 = 90
            if (r0 != r1) goto L_0x02be
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 1
            int r0 = r0 + r1
            char r7 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + r12
            char r8 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 3
            char r10 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 4
            char r11 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 5
            int r0 = r0 + r1
            char r12 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 6
            char r13 = r9.charAt(r0)
            r0 = r34
            r1 = r7
            r2 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            boolean r0 = r0.checkTime(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0288
            r14 = 0
            return r14
        L_0x0288:
            r14 = 0
            r0 = r34
            r1 = r7
            r2 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r0.setTime(r1, r2, r3, r4, r5, r6)
            java.util.Calendar r0 = r9.calendar
            r1 = 14
            r0.set(r1, r14)
            java.util.Calendar r0 = r9.calendar
            java.util.TimeZone r0 = r0.getTimeZone()
            int r0 = r0.getRawOffset()
            if (r0 == 0) goto L_0x02b9
            java.lang.String[] r0 = java.util.TimeZone.getAvailableIDs(r14)
            int r1 = r0.length
            if (r1 <= 0) goto L_0x02b9
            r0 = r0[r14]
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r0)
            java.util.Calendar r1 = r9.calendar
            r1.setTimeZone(r0)
        L_0x02b9:
            r0 = 5
            r9.token = r0
            goto L_0x00c6
        L_0x02be:
            if (r7 == r11) goto L_0x0370
            r0 = 32
            if (r7 != r0) goto L_0x02c8
            if (r35 != 0) goto L_0x02c8
            goto L_0x0370
        L_0x02c8:
            r0 = 34
            if (r7 == r0) goto L_0x0343
            r0 = 26
            if (r7 == r0) goto L_0x0343
            r0 = 26085(0x65e5, float:3.6553E-41)
            if (r7 == r0) goto L_0x0343
            r0 = 51068(0xc77c, float:7.1562E-41)
            if (r7 != r0) goto L_0x02da
            goto L_0x0343
        L_0x02da:
            r0 = 43
            if (r7 == r0) goto L_0x02e5
            r0 = 45
            if (r7 != r0) goto L_0x02e3
            goto L_0x02e5
        L_0x02e3:
            r0 = 0
            return r0
        L_0x02e5:
            int r0 = r9.len
            int r1 = r13 + 6
            if (r0 != r1) goto L_0x0341
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 3
            char r0 = r9.charAt(r0)
            r1 = 58
            if (r0 != r1) goto L_0x033f
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 4
            char r0 = r9.charAt(r0)
            r8 = 48
            if (r0 != r8) goto L_0x033f
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 5
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            if (r0 == r8) goto L_0x0311
            goto L_0x033f
        L_0x0311:
            r1 = 48
            r2 = 48
            r3 = 48
            r4 = 48
            r5 = 48
            r6 = 48
            r0 = r34
            r0.setTime(r1, r2, r3, r4, r5, r6)
            java.util.Calendar r0 = r9.calendar
            r1 = 14
            r2 = 0
            r0.set(r1, r2)
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 1
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            int r2 = r9.bp
            int r2 = r2 + r13
            int r2 = r2 + r12
            char r2 = r9.charAt(r2)
            r9.setTimeZone(r7, r0, r2)
            return r1
        L_0x033f:
            r0 = 0
            return r0
        L_0x0341:
            r0 = 0
            return r0
        L_0x0343:
            r0 = 0
            java.util.Calendar r1 = r9.calendar
            r2 = 11
            r1.set(r2, r0)
            java.util.Calendar r1 = r9.calendar
            r2 = 12
            r1.set(r2, r0)
            java.util.Calendar r1 = r9.calendar
            r12 = 13
            r1.set(r12, r0)
            java.util.Calendar r1 = r9.calendar
            r2 = 14
            r1.set(r2, r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            r9.bp = r0
            char r0 = r9.charAt(r0)
            r9.ch = r0
            r0 = 5
            r9.token = r0
            goto L_0x00c6
        L_0x0370:
            r8 = 48
            int r0 = r13 + 9
            if (r10 >= r0) goto L_0x0378
            r0 = 0
            return r0
        L_0x0378:
            r0 = 0
            int r1 = r9.bp
            int r1 = r1 + r13
            int r1 = r1 + 3
            char r1 = r9.charAt(r1)
            r2 = 58
            if (r1 == r2) goto L_0x0387
            return r0
        L_0x0387:
            int r1 = r9.bp
            int r1 = r1 + r13
            int r1 = r1 + 6
            char r1 = r9.charAt(r1)
            if (r1 == r2) goto L_0x0393
            return r0
        L_0x0393:
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 1
            int r0 = r0 + r1
            char r7 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + r12
            char r11 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 4
            char r14 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 5
            int r0 = r0 + r1
            char r15 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 7
            char r20 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 8
            int r0 = r0 + r1
            char r18 = r9.charAt(r0)
            r0 = r34
            r1 = r7
            r2 = r11
            r3 = r14
            r4 = r15
            r5 = r20
            r6 = r18
            boolean r0 = r0.checkTime(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x03db
            r0 = 0
            return r0
        L_0x03db:
            r0 = r34
            r1 = r7
            r2 = r11
            r3 = r14
            r4 = r15
            r5 = r20
            r6 = r18
            r0.setTime(r1, r2, r3, r4, r5, r6)
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 9
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            r1 = -1
            r2 = 46
            if (r0 != r2) goto L_0x0446
            int r0 = r13 + 11
            if (r10 >= r0) goto L_0x03fd
            r1 = 0
            return r1
        L_0x03fd:
            int r1 = r9.bp
            int r1 = r1 + r13
            int r1 = r1 + 10
            char r1 = r9.charAt(r1)
            if (r1 < r8) goto L_0x0444
            r2 = 57
            if (r1 <= r2) goto L_0x040d
            goto L_0x0444
        L_0x040d:
            int r1 = r1 - r8
            if (r10 <= r0) goto L_0x0424
            int r0 = r9.bp
            int r0 = r0 + r13
            r3 = 11
            int r0 = r0 + r3
            char r0 = r9.charAt(r0)
            if (r0 < r8) goto L_0x0424
            if (r0 > r2) goto L_0x0424
            int r1 = r1 * 10
            int r0 = r0 - r8
            int r1 = r1 + r0
            r0 = r12
            goto L_0x0425
        L_0x0424:
            r0 = 1
        L_0x0425:
            if (r0 != r12) goto L_0x043e
            int r2 = r9.bp
            int r2 = r2 + r13
            int r2 = r2 + 12
            char r2 = r9.charAt(r2)
            if (r2 < r8) goto L_0x043e
            r3 = 57
            if (r2 > r3) goto L_0x043e
            int r1 = r1 * 10
            int r2 = r2 - r8
            int r0 = r1 + r2
            r1 = r16
            goto L_0x0447
        L_0x043e:
            r32 = r1
            r1 = r0
            r0 = r32
            goto L_0x0447
        L_0x0444:
            r0 = 0
            return r0
        L_0x0446:
            r0 = 0
        L_0x0447:
            java.util.Calendar r2 = r9.calendar
            r3 = 14
            r2.set(r3, r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            r2 = 32
            if (r0 != r2) goto L_0x0468
            int r1 = r1 + 1
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
        L_0x0468:
            r6 = r1
            r1 = r0
            r0 = 43
            if (r1 == r0) goto L_0x049e
            r0 = 45
            if (r1 != r0) goto L_0x0473
            goto L_0x049e
        L_0x0473:
            r0 = 90
            if (r1 != r0) goto L_0x049a
            java.util.Calendar r0 = r9.calendar
            java.util.TimeZone r0 = r0.getTimeZone()
            int r0 = r0.getRawOffset()
            if (r0 == 0) goto L_0x0496
            r0 = 0
            java.lang.String[] r1 = java.util.TimeZone.getAvailableIDs(r0)
            int r2 = r1.length
            if (r2 <= 0) goto L_0x0496
            r1 = r1[r0]
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r1)
            java.util.Calendar r1 = r9.calendar
            r1.setTimeZone(r0)
        L_0x0496:
            r16 = 1
            goto L_0x0551
        L_0x049a:
            r16 = 0
            goto L_0x0551
        L_0x049e:
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r6
            r2 = 1
            int r0 = r0 + r2
            char r2 = r9.charAt(r0)
            if (r2 < r8) goto L_0x0579
            r0 = 49
            if (r2 <= r0) goto L_0x04b2
            goto L_0x0579
        L_0x04b2:
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r6
            int r0 = r0 + r12
            char r3 = r9.charAt(r0)
            if (r3 < r8) goto L_0x0577
            r0 = 57
            if (r3 <= r0) goto L_0x04c5
            goto L_0x0577
        L_0x04c5:
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r6
            int r0 = r0 + 3
            char r0 = r9.charAt(r0)
            r4 = 58
            if (r0 != r4) goto L_0x04fd
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r6
            int r0 = r0 + 4
            char r0 = r9.charAt(r0)
            if (r0 == r8) goto L_0x04e9
            r4 = 51
            if (r0 == r4) goto L_0x04e9
            r4 = 0
            return r4
        L_0x04e9:
            r4 = 0
            int r5 = r9.bp
            int r5 = r5 + r13
            int r5 = r5 + 10
            int r5 = r5 + r6
            r7 = 5
            int r5 = r5 + r7
            char r5 = r9.charAt(r5)
            if (r5 == r8) goto L_0x04f9
            return r4
        L_0x04f9:
            r4 = r0
            r16 = r17
            goto L_0x054c
        L_0x04fd:
            if (r0 != r8) goto L_0x0518
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r6
            int r0 = r0 + 4
            char r0 = r9.charAt(r0)
            if (r0 == r8) goto L_0x0513
            r4 = 51
            if (r0 == r4) goto L_0x0513
            r4 = 0
            return r4
        L_0x0513:
            r4 = r0
            r5 = r8
            r16 = 5
            goto L_0x054c
        L_0x0518:
            r4 = 51
            if (r0 != r4) goto L_0x052d
            int r4 = r9.bp
            int r4 = r4 + r13
            int r4 = r4 + 10
            int r4 = r4 + r6
            int r4 = r4 + 4
            char r4 = r9.charAt(r4)
            if (r4 != r8) goto L_0x052d
            r0 = 51
            goto L_0x0513
        L_0x052d:
            r4 = 52
            if (r0 != r4) goto L_0x054a
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r6
            int r0 = r0 + 4
            char r0 = r9.charAt(r0)
            r4 = 53
            if (r0 != r4) goto L_0x054a
            r0 = 52
            r4 = 53
            r5 = r4
            r16 = 5
            r4 = r0
            goto L_0x054c
        L_0x054a:
            r4 = r8
            r5 = r4
        L_0x054c:
            r0 = r34
            r0.setTimeZone(r1, r2, r3, r4, r5)
        L_0x0551:
            int r0 = r9.bp
            int r13 = r13 + 10
            int r13 = r13 + r6
            int r13 = r13 + r16
            int r0 = r0 + r13
            char r0 = r9.charAt(r0)
            r1 = 26
            if (r0 == r1) goto L_0x0567
            r1 = 34
            if (r0 == r1) goto L_0x0567
            r5 = 0
            return r5
        L_0x0567:
            int r0 = r9.bp
            int r0 = r0 + r13
            r9.bp = r0
            char r0 = r9.charAt(r0)
            r9.ch = r0
            r0 = 5
            r9.token = r0
            goto L_0x00c6
        L_0x0577:
            r5 = 0
            return r5
        L_0x0579:
            r5 = 0
            return r5
        L_0x057b:
            r14 = r5
            r5 = 0
            r8 = 48
            r12 = 13
        L_0x0581:
            if (r35 == 0) goto L_0x0584
            return r5
        L_0x0584:
            int r5 = r9.bp
            r6 = 8
            int r5 = r5 + r6
            char r16 = r9.charAt(r5)
            r5 = 45
            if (r1 != r5) goto L_0x0595
            if (r4 != r5) goto L_0x0595
            r5 = 1
            goto L_0x0596
        L_0x0595:
            r5 = 0
        L_0x0596:
            if (r5 == 0) goto L_0x059d
            if (r10 != r14) goto L_0x059d
            r17 = 1
            goto L_0x059f
        L_0x059d:
            r17 = 0
        L_0x059f:
            if (r5 == 0) goto L_0x05a8
            r5 = 17
            if (r10 != r5) goto L_0x05a8
            r20 = 1
            goto L_0x05aa
        L_0x05a8:
            r20 = 0
        L_0x05aa:
            if (r20 != 0) goto L_0x05c7
            if (r17 == 0) goto L_0x05af
            goto L_0x05c7
        L_0x05af:
            r5 = 45
            if (r1 != r5) goto L_0x05be
            if (r3 != r5) goto L_0x05be
            r22 = r2
            r24 = r4
            r19 = r8
            r23 = r19
            goto L_0x05d8
        L_0x05be:
            r19 = r1
            r22 = r2
            r23 = r3
            r24 = r4
            goto L_0x05d8
        L_0x05c7:
            int r1 = r9.bp
            r4 = 9
            int r1 = r1 + r4
            char r1 = r9.charAt(r1)
            r24 = r1
            r19 = r2
            r22 = r3
            r23 = r16
        L_0x05d8:
            r1 = r13
            r2 = r15
            r3 = r0
            r4 = r7
            r5 = r19
            r6 = r22
            r25 = r7
            r7 = r23
            r8 = r24
            boolean r1 = checkDate(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r1 != 0) goto L_0x05ee
            r1 = 0
            return r1
        L_0x05ee:
            r3 = r0
            r0 = r34
            r1 = r13
            r2 = r15
            r4 = r25
            r5 = r19
            r6 = r22
            r7 = r23
            r8 = r24
            r0.setCalendar(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 8
            if (r10 == r0) goto L_0x06da
            int r0 = r9.bp
            r1 = 9
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            int r1 = r9.bp
            int r1 = r1 + 10
            char r1 = r9.charAt(r1)
            int r2 = r9.bp
            r3 = 11
            int r2 = r2 + r3
            char r2 = r9.charAt(r2)
            int r3 = r9.bp
            int r3 = r3 + 12
            char r6 = r9.charAt(r3)
            int r3 = r9.bp
            int r3 = r3 + r12
            char r3 = r9.charAt(r3)
            if (r20 == 0) goto L_0x0640
            if (r1 != r11) goto L_0x0640
            r4 = 58
            if (r3 != r4) goto L_0x0640
            int r4 = r9.bp
            int r4 = r4 + r14
            char r4 = r9.charAt(r4)
            r5 = 90
            if (r4 == r5) goto L_0x064c
        L_0x0640:
            if (r17 == 0) goto L_0x0667
            r4 = 32
            if (r1 == r4) goto L_0x0648
            if (r1 != r11) goto L_0x0667
        L_0x0648:
            r4 = 58
            if (r3 != r4) goto L_0x0667
        L_0x064c:
            int r0 = r9.bp
            r1 = 14
            int r0 = r0 + r1
            char r1 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + 15
            char r0 = r9.charAt(r0)
            r11 = r0
            r8 = r1
            r16 = r2
            r7 = r6
            r13 = 48
            r15 = 48
            goto L_0x066c
        L_0x0667:
            r7 = r0
            r8 = r1
            r11 = r2
            r15 = r3
            r13 = r6
        L_0x066c:
            r0 = r34
            r1 = r16
            r2 = r7
            r3 = r8
            r4 = r11
            r5 = r13
            r6 = r15
            boolean r0 = r0.checkTime(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x067d
            r0 = 0
            return r0
        L_0x067d:
            r0 = 17
            if (r10 != r0) goto L_0x06be
            if (r20 != 0) goto L_0x06be
            int r0 = r9.bp
            r1 = 14
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            int r1 = r9.bp
            int r1 = r1 + 15
            char r1 = r9.charAt(r1)
            int r2 = r9.bp
            int r2 = r2 + r14
            char r2 = r9.charAt(r2)
            r3 = 48
            if (r0 < r3) goto L_0x06bc
            r4 = 57
            if (r0 <= r4) goto L_0x06a4
            goto L_0x06bc
        L_0x06a4:
            if (r1 < r3) goto L_0x06ba
            if (r1 <= r4) goto L_0x06a9
            goto L_0x06ba
        L_0x06a9:
            if (r2 < r3) goto L_0x06b8
            if (r2 <= r4) goto L_0x06ae
            goto L_0x06b8
        L_0x06ae:
            int r0 = r0 - r3
            int r0 = r0 * 100
            int r1 = r1 - r3
            int r1 = r1 * 10
            int r0 = r0 + r1
            int r2 = r2 - r3
            int r0 = r0 + r2
            goto L_0x06c1
        L_0x06b8:
            r0 = 0
            return r0
        L_0x06ba:
            r0 = 0
            return r0
        L_0x06bc:
            r0 = 0
            return r0
        L_0x06be:
            r0 = 0
            r3 = 48
        L_0x06c1:
            int r16 = r16 + -48
            int r16 = r16 * 10
            int r7 = r7 - r3
            int r1 = r16 + r7
            int r8 = r8 - r3
            int r8 = r8 * 10
            int r11 = r11 - r3
            int r2 = r8 + r11
            int r13 = r13 - r3
            int r13 = r13 * 10
            int r15 = r15 - r3
            int r3 = r13 + r15
            r32 = r1
            r1 = r0
            r0 = r32
            goto L_0x06de
        L_0x06da:
            r0 = 0
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x06de:
            java.util.Calendar r4 = r9.calendar
            r5 = 11
            r4.set(r5, r0)
            java.util.Calendar r0 = r9.calendar
            r4 = 12
            r0.set(r4, r2)
            java.util.Calendar r0 = r9.calendar
            r0.set(r12, r3)
            java.util.Calendar r0 = r9.calendar
            r2 = 14
            r0.set(r2, r1)
            r0 = 5
            r9.token = r0
            goto L_0x00c6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanISO8601DateIfMatch(boolean, int):boolean");
    }

    /* access modifiers changed from: protected */
    public void setTime(char c, char c2, char c3, char c4, char c5, char c6) {
        this.calendar.set(11, ((c - '0') * 10) + (c2 - '0'));
        this.calendar.set(12, ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(13, ((c5 - '0') * 10) + (c6 - '0'));
    }

    /* access modifiers changed from: protected */
    public void setTimeZone(char c, char c2, char c3) {
        setTimeZone(c, c2, c3, '0', '0');
    }

    /* access modifiers changed from: protected */
    public void setTimeZone(char c, char c2, char c3, char c4, char c5) {
        int i = ((((c2 - '0') * 10) + (c3 - '0')) * 3600 * 1000) + ((((c4 - '0') * 10) + (c5 - '0')) * 60 * 1000);
        if (c == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            String[] availableIDs = TimeZone.getAvailableIDs(i);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        this.calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.calendar.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    public boolean isEOF() {
        if (this.bp != this.len) {
            return this.ch == 26 && this.bp + 1 >= this.len;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int scanFieldInt(char[] r15) {
        /*
            r14 = this;
            r0 = 0
            r14.matchStat = r0
            int r1 = r14.bp
            char r2 = r14.ch
            java.lang.String r3 = r14.text
            int r4 = r14.bp
            boolean r3 = charArrayCompare(r3, r4, r15)
            if (r3 != 0) goto L_0x0015
            r15 = -2
            r14.matchStat = r15
            return r0
        L_0x0015:
            int r3 = r14.bp
            int r15 = r15.length
            int r3 = r3 + r15
            int r15 = r3 + 1
            char r3 = r14.charAt(r3)
            r4 = 34
            r5 = 1
            if (r3 != r4) goto L_0x0026
            r6 = r5
            goto L_0x0027
        L_0x0026:
            r6 = r0
        L_0x0027:
            if (r6 == 0) goto L_0x0032
            int r3 = r15 + 1
            char r15 = r14.charAt(r15)
            r13 = r3
            r3 = r15
            r15 = r13
        L_0x0032:
            r7 = 45
            if (r3 != r7) goto L_0x0038
            r7 = r5
            goto L_0x0039
        L_0x0038:
            r7 = r0
        L_0x0039:
            if (r7 == 0) goto L_0x0044
            int r3 = r15 + 1
            char r15 = r14.charAt(r15)
            r13 = r3
            r3 = r15
            r15 = r13
        L_0x0044:
            r8 = 48
            r9 = -1
            if (r3 < r8) goto L_0x011e
            r10 = 57
            if (r3 > r10) goto L_0x011e
            int r3 = r3 - r8
        L_0x004e:
            int r11 = r15 + 1
            char r15 = r14.charAt(r15)
            if (r15 < r8) goto L_0x0065
            if (r15 > r10) goto L_0x0065
            int r12 = r3 * 10
            if (r12 >= r3) goto L_0x005f
            r14.matchStat = r9
            return r0
        L_0x005f:
            int r15 = r15 + -48
            int r3 = r12 + r15
            r15 = r11
            goto L_0x004e
        L_0x0065:
            r8 = 46
            if (r15 != r8) goto L_0x006c
            r14.matchStat = r9
            return r0
        L_0x006c:
            if (r3 >= 0) goto L_0x0071
            r14.matchStat = r9
            return r0
        L_0x0071:
            if (r6 == 0) goto L_0x0080
            if (r15 == r4) goto L_0x0078
            r14.matchStat = r9
            return r0
        L_0x0078:
            int r15 = r11 + 1
            char r4 = r14.charAt(r11)
        L_0x007e:
            r11 = r15
            r15 = r4
        L_0x0080:
            r4 = 125(0x7d, float:1.75E-43)
            r6 = 44
            if (r15 == r6) goto L_0x0099
            if (r15 != r4) goto L_0x0089
            goto L_0x0099
        L_0x0089:
            boolean r15 = isWhitespace(r15)
            if (r15 == 0) goto L_0x0096
            int r15 = r11 + 1
            char r4 = r14.charAt(r11)
            goto L_0x007e
        L_0x0096:
            r14.matchStat = r9
            return r0
        L_0x0099:
            int r11 = r11 - r5
            r14.bp = r11
            r8 = 16
            if (r15 != r6) goto L_0x00b4
            int r15 = r14.bp
            int r15 = r15 + r5
            r14.bp = r15
            char r15 = r14.charAt(r15)
            r14.ch = r15
            r15 = 3
            r14.matchStat = r15
            r14.token = r8
            if (r7 == 0) goto L_0x00b3
            int r3 = -r3
        L_0x00b3:
            return r3
        L_0x00b4:
            if (r15 != r4) goto L_0x011a
            r14.bp = r11
            int r15 = r14.bp
            int r15 = r15 + r5
            r14.bp = r15
            char r15 = r14.charAt(r15)
        L_0x00c1:
            if (r15 != r6) goto L_0x00d1
            r14.token = r8
            int r15 = r14.bp
            int r15 = r15 + r5
            r14.bp = r15
            char r15 = r14.charAt(r15)
            r14.ch = r15
            goto L_0x00ff
        L_0x00d1:
            r10 = 93
            if (r15 != r10) goto L_0x00e5
            r15 = 15
            r14.token = r15
            int r15 = r14.bp
            int r15 = r15 + r5
            r14.bp = r15
            char r15 = r14.charAt(r15)
            r14.ch = r15
            goto L_0x00ff
        L_0x00e5:
            if (r15 != r4) goto L_0x00f7
            r15 = 13
            r14.token = r15
            int r15 = r14.bp
            int r15 = r15 + r5
            r14.bp = r15
            char r15 = r14.charAt(r15)
            r14.ch = r15
            goto L_0x00ff
        L_0x00f7:
            r10 = 26
            if (r15 != r10) goto L_0x0103
            r15 = 20
            r14.token = r15
        L_0x00ff:
            r15 = 4
            r14.matchStat = r15
            goto L_0x011a
        L_0x0103:
            boolean r15 = isWhitespace(r15)
            if (r15 == 0) goto L_0x0113
            int r15 = r14.bp
            int r15 = r15 + r5
            r14.bp = r15
            char r15 = r14.charAt(r15)
            goto L_0x00c1
        L_0x0113:
            r14.bp = r1
            r14.ch = r2
            r14.matchStat = r9
            return r0
        L_0x011a:
            if (r7 == 0) goto L_0x011d
            int r3 = -r3
        L_0x011d:
            return r3
        L_0x011e:
            r14.matchStat = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldInt(char[]):int");
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i = this.bp;
        char c = this.ch;
        while (!charArrayCompare(this.text, this.bp, cArr)) {
            if (isWhitespace(this.ch)) {
                next();
            } else {
                this.matchStat = -2;
                return stringDefaultValue();
            }
        }
        int length = this.bp + cArr.length;
        int i2 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', i2);
        if (indexOf != -1) {
            String subString = subString(i2, indexOf - i2);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i3 = indexOf - 1;
                    int i4 = 0;
                    while (i3 >= 0 && charAt(i3) == '\\') {
                        i4++;
                        i3--;
                    }
                    if (i4 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int length2 = indexOf - ((this.bp + cArr.length) + 1);
                subString = readString(sub_chars(this.bp + cArr.length + 1, length2), length2);
            }
            char charAt = charAt(indexOf + 1);
            while (charAt != ',' && charAt != '}') {
                if (isWhitespace(charAt)) {
                    indexOf++;
                    charAt = charAt(indexOf + 1);
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
            }
            this.bp = indexOf + 1;
            this.ch = charAt;
            if (charAt == ',') {
                int i5 = this.bp + 1;
                this.bp = i5;
                this.ch = charAt(i5);
                this.matchStat = 3;
                return subString;
            }
            int i6 = this.bp + 1;
            this.bp = i6;
            char charAt2 = charAt(i6);
            if (charAt2 == ',') {
                this.token = 16;
                int i7 = this.bp + 1;
                this.bp = i7;
                this.ch = charAt(i7);
            } else if (charAt2 == ']') {
                this.token = 15;
                int i8 = this.bp + 1;
                this.bp = i8;
                this.ch = charAt(i8);
            } else if (charAt2 == '}') {
                this.token = 13;
                int i9 = this.bp + 1;
                this.bp = i9;
                this.ch = charAt(i9);
            } else if (charAt2 == 26) {
                this.token = 20;
            } else {
                this.bp = i;
                this.ch = c;
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.matchStat = 4;
            return subString;
        }
        throw new JSONException("unclosed str");
    }

    public Date scanFieldDate(char[] cArr) {
        char c;
        Date date;
        long j;
        char c2;
        int i;
        char[] cArr2 = cArr;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.bp;
        char c3 = this.ch;
        if (!charArrayCompare(this.text, this.bp, cArr2)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.bp + cArr2.length;
        int i3 = length + 1;
        char charAt = charAt(length);
        if (charAt == '\"') {
            int indexOf = indexOf('\"', i3);
            if (indexOf != -1) {
                this.bp = i3;
                if (scanISO8601DateIfMatch(false, indexOf - i3)) {
                    date = this.calendar.getTime();
                    c = charAt(indexOf + 1);
                    this.bp = i2;
                    while (c != ',' && c != '}') {
                        if (isWhitespace(c)) {
                            indexOf++;
                            c = charAt(indexOf + 1);
                        } else {
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    this.bp = indexOf + 1;
                    this.ch = c;
                } else {
                    this.bp = i2;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c4 = '9';
            char c5 = '0';
            if (charAt == '-' || (charAt >= '0' && charAt <= '9')) {
                if (charAt == '-') {
                    charAt = charAt(i3);
                    i3++;
                    z = true;
                }
                if (charAt < '0' || charAt > '9') {
                    c2 = charAt;
                    j = 0;
                } else {
                    j = (long) (charAt - '0');
                    while (true) {
                        i = i3 + 1;
                        c2 = charAt(i3);
                        if (c2 >= c5 && c2 <= c4) {
                            j = (j * 10) + ((long) (c2 - '0'));
                            i3 = i;
                            c4 = '9';
                            c5 = '0';
                        } else if (c2 == ',' || c2 == '}') {
                            this.bp = i - 1;
                        }
                    }
                    this.bp = i - 1;
                }
                if (j < 0) {
                    this.matchStat = -1;
                    return null;
                }
                if (z) {
                    j = -j;
                }
                c = c2;
                date = new Date(j);
            } else {
                this.matchStat = -1;
                return null;
            }
        }
        if (c == ',') {
            int i4 = this.bp + 1;
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        int i5 = this.bp + 1;
        this.bp = i5;
        char charAt2 = charAt(i5);
        if (charAt2 == ',') {
            this.token = 16;
            int i6 = this.bp + 1;
            this.bp = i6;
            this.ch = charAt(i6);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
        } else if (charAt2 == 26) {
            this.token = 20;
        } else {
            this.bp = i2;
            this.ch = c3;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return 0;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(i);
            if (charAt == '\"') {
                this.bp = i2;
                char charAt2 = charAt(this.bp);
                this.ch = charAt2;
                while (charAt2 != ',') {
                    if (charAt2 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i3 = this.bp + 1;
                            this.bp = i3;
                            this.ch = charAt(i3);
                        } else if (current == ']') {
                            this.token = 15;
                            int i4 = this.bp + 1;
                            this.bp = i4;
                            this.ch = charAt(i4);
                        } else if (current == '}') {
                            this.token = 13;
                            int i5 = this.bp + 1;
                            this.bp = i5;
                            this.ch = charAt(i5);
                        } else if (current == 26) {
                            this.token = 20;
                        } else {
                            this.matchStat = -1;
                            return 0;
                        }
                        this.matchStat = 4;
                        return j;
                    } else if (isWhitespace(charAt2)) {
                        int i6 = this.bp + 1;
                        this.bp = i6;
                        charAt2 = charAt(i6);
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                }
                int i7 = this.bp + 1;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return j;
            } else if (i2 > this.len) {
                this.matchStat = -1;
                return 0;
            } else {
                j = (j ^ ((long) charAt)) * 1099511628211L;
                i = i2;
            }
        }
    }

    public Collection<String> newCollectionByType(Class<?> cls) {
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public Collection<String> scanFieldStringArray(char[] cArr, Class<?> cls) {
        char c;
        Collection<String> collection;
        char c2;
        int i;
        int i2;
        boolean z;
        char c3;
        int i3;
        char c4;
        char[] cArr2 = cArr;
        this.matchStat = 0;
        while (true) {
            if (this.ch != 10 && this.ch != ' ') {
                break;
            }
            Class<?> cls2 = cls;
            int i4 = this.bp + 1;
            this.bp = i4;
            if (i4 >= this.len) {
                c = 26;
            } else {
                c = this.text.charAt(i4);
            }
            this.ch = c;
        }
        if (!charArrayCompare(this.text, this.bp, cArr2)) {
            this.matchStat = -2;
            return null;
        }
        Collection<String> newCollectionByType = newCollectionByType(cls);
        int i5 = this.bp;
        char c5 = this.ch;
        int length = this.bp + cArr2.length;
        int i6 = length + 1;
        int i7 = -1;
        if (charAt(length) == '[') {
            int i8 = i6 + 1;
            char charAt = charAt(i6);
            while (true) {
                if (charAt == '\"') {
                    int indexOf = indexOf('\"', i8);
                    if (indexOf != i7) {
                        String subString = subString(i8, indexOf - i8);
                        if (subString.indexOf(92) != i7) {
                            while (true) {
                                int i9 = indexOf - 1;
                                int i10 = 0;
                                while (i9 >= 0 && charAt(i9) == '\\') {
                                    i10++;
                                    i9--;
                                }
                                if (i10 % 2 == 0) {
                                    break;
                                }
                                indexOf = indexOf('\"', indexOf + 1);
                            }
                            int i11 = indexOf - i8;
                            subString = readString(sub_chars(i8, i11), i11);
                        }
                        int i12 = indexOf + 1;
                        i3 = i12 + 1;
                        c4 = charAt(i12);
                        newCollectionByType.add(subString);
                    } else {
                        throw new JSONException("unclosed str");
                    }
                } else if (charAt == 'n' && this.text.startsWith("ull", i8)) {
                    int i13 = i8 + 3;
                    i3 = i13 + 1;
                    c4 = charAt(i13);
                    newCollectionByType.add((Object) null);
                } else if (charAt == ']' && newCollectionByType.size() == 0) {
                    i2 = i8 + 1;
                    c3 = charAt(i8);
                } else {
                    this.matchStat = -1;
                    return null;
                }
                if (c4 == ',') {
                    i8 = i3 + 1;
                    charAt = charAt(i3);
                    i7 = -1;
                } else if (c4 == ']') {
                    i2 = i3 + 1;
                    c3 = charAt(i3);
                    while (isWhitespace(c3)) {
                        c3 = charAt(i2);
                        i2++;
                    }
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            collection = newCollectionByType;
            c2 = c3;
            i = 3;
        } else if (this.text.startsWith("ull", i6)) {
            i = 3;
            int i14 = i6 + 3;
            collection = null;
            c2 = charAt(i14);
            i2 = i14 + 1;
        } else {
            this.matchStat = -1;
            return null;
        }
        this.bp = i2;
        if (c2 == ',') {
            this.ch = charAt(this.bp);
            this.matchStat = i;
            return collection;
        } else if (c2 == '}') {
            char charAt2 = charAt(this.bp);
            do {
                if (charAt2 == ',') {
                    this.token = 16;
                    int i15 = this.bp + 1;
                    this.bp = i15;
                    this.ch = charAt(i15);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i16 = this.bp + 1;
                    this.bp = i16;
                    this.ch = charAt(i16);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i17 = this.bp + 1;
                    this.bp = i17;
                    this.ch = charAt(i17);
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.ch = charAt2;
                } else {
                    z = false;
                    while (isWhitespace(charAt2)) {
                        int i18 = i2 + 1;
                        char charAt3 = charAt(i2);
                        this.bp = i18;
                        z = true;
                        int i19 = i18;
                        charAt2 = charAt3;
                        i2 = i19;
                    }
                }
                this.matchStat = 4;
                return collection;
            } while (z);
            this.matchStat = -1;
            return null;
        } else {
            this.ch = c5;
            this.bp = i5;
            this.matchStat = -1;
            return null;
        }
    }

    public long scanFieldLong(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        char[] cArr2 = cArr;
        this.matchStat = 0;
        int i2 = this.bp;
        char c = this.ch;
        if (!charArrayCompare(this.text, this.bp, cArr2)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr2.length;
        int i3 = length + 1;
        char charAt2 = charAt(length);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            charAt2 = charAt(i3);
            i3++;
        }
        if (charAt2 == '-') {
            z = true;
            charAt2 = charAt(i3);
            i3++;
        } else {
            z = false;
        }
        if (charAt2 >= '0') {
            char c2 = '9';
            if (charAt2 <= '9') {
                int i4 = i2;
                long j = (long) (charAt2 - '0');
                while (true) {
                    i = i3 + 1;
                    charAt = charAt(i3);
                    if (charAt >= '0' && charAt <= c2) {
                        j = (j * 10) + ((long) (charAt - '0'));
                        i3 = i;
                        c2 = '9';
                    }
                }
                if (charAt == '.') {
                    this.matchStat = -1;
                    return 0;
                }
                if (z2) {
                    if (charAt != '\"') {
                        this.matchStat = -1;
                        return 0;
                    }
                    char charAt3 = charAt(i);
                    i++;
                    charAt = charAt3;
                }
                if (charAt == ',' || charAt == '}') {
                    this.bp = i - 1;
                }
                if (!(j >= 0 || (j == Long.MIN_VALUE && z))) {
                    this.bp = i4;
                    this.ch = c;
                    this.matchStat = -1;
                    return 0;
                }
                int i5 = i4;
                while (charAt != ',') {
                    if (charAt == '}') {
                        int i6 = this.bp + 1;
                        this.bp = i6;
                        char charAt4 = charAt(i6);
                        while (true) {
                            if (charAt4 == ',') {
                                this.token = 16;
                                int i7 = this.bp + 1;
                                this.bp = i7;
                                this.ch = charAt(i7);
                                break;
                            } else if (charAt4 == ']') {
                                this.token = 15;
                                int i8 = this.bp + 1;
                                this.bp = i8;
                                this.ch = charAt(i8);
                                break;
                            } else if (charAt4 == '}') {
                                this.token = 13;
                                int i9 = this.bp + 1;
                                this.bp = i9;
                                this.ch = charAt(i9);
                                break;
                            } else if (charAt4 == 26) {
                                this.token = 20;
                                break;
                            } else if (isWhitespace(charAt4)) {
                                int i10 = this.bp + 1;
                                this.bp = i10;
                                charAt4 = charAt(i10);
                            } else {
                                this.bp = i5;
                                this.ch = c;
                                this.matchStat = -1;
                                return 0;
                            }
                        }
                        this.matchStat = 4;
                        return z ? -j : j;
                    } else if (isWhitespace(charAt)) {
                        this.bp = i;
                        char charAt5 = charAt(i);
                        i++;
                        charAt = charAt5;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                }
                int i11 = this.bp + 1;
                this.bp = i11;
                this.ch = charAt(i11);
                this.matchStat = 3;
                this.token = 16;
                return z ? -j : j;
            }
        }
        this.bp = i2;
        this.ch = c;
        this.matchStat = -1;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x00fd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scanFieldBoolean(char[] r11) {
        /*
            r10 = this;
            r0 = 0
            r10.matchStat = r0
            java.lang.String r1 = r10.text
            int r2 = r10.bp
            boolean r1 = charArrayCompare(r1, r2, r11)
            if (r1 != 0) goto L_0x0011
            r11 = -2
            r10.matchStat = r11
            return r0
        L_0x0011:
            int r1 = r10.bp
            int r2 = r10.bp
            int r11 = r11.length
            int r2 = r2 + r11
            int r11 = r2 + 1
            char r2 = r10.charAt(r2)
            r3 = 34
            r4 = 1
            if (r2 != r3) goto L_0x0024
            r5 = r4
            goto L_0x0025
        L_0x0024:
            r5 = r0
        L_0x0025:
            if (r5 == 0) goto L_0x0030
            int r2 = r11 + 1
            char r11 = r10.charAt(r11)
            r9 = r2
            r2 = r11
            r11 = r9
        L_0x0030:
            r6 = 116(0x74, float:1.63E-43)
            r7 = 101(0x65, float:1.42E-43)
            r8 = -1
            if (r2 != r6) goto L_0x0073
            int r2 = r11 + 1
            char r11 = r10.charAt(r11)
            r6 = 114(0x72, float:1.6E-43)
            if (r11 == r6) goto L_0x0044
            r10.matchStat = r8
            return r0
        L_0x0044:
            int r11 = r2 + 1
            char r2 = r10.charAt(r2)
            r6 = 117(0x75, float:1.64E-43)
            if (r2 == r6) goto L_0x0051
            r10.matchStat = r8
            return r0
        L_0x0051:
            int r2 = r11 + 1
            char r11 = r10.charAt(r11)
            if (r11 == r7) goto L_0x005c
            r10.matchStat = r8
            return r0
        L_0x005c:
            if (r5 == 0) goto L_0x006a
            int r11 = r2 + 1
            char r2 = r10.charAt(r2)
            if (r2 == r3) goto L_0x0069
            r10.matchStat = r8
            return r0
        L_0x0069:
            r2 = r11
        L_0x006a:
            r10.bp = r2
            int r11 = r10.bp
            char r11 = r10.charAt(r11)
            goto L_0x00da
        L_0x0073:
            r6 = 102(0x66, float:1.43E-43)
            if (r2 != r6) goto L_0x00c0
            int r2 = r11 + 1
            char r11 = r10.charAt(r11)
            r6 = 97
            if (r11 == r6) goto L_0x0084
            r10.matchStat = r8
            return r0
        L_0x0084:
            int r11 = r2 + 1
            char r2 = r10.charAt(r2)
            r6 = 108(0x6c, float:1.51E-43)
            if (r2 == r6) goto L_0x0091
            r10.matchStat = r8
            return r0
        L_0x0091:
            int r2 = r11 + 1
            char r11 = r10.charAt(r11)
            r6 = 115(0x73, float:1.61E-43)
            if (r11 == r6) goto L_0x009e
            r10.matchStat = r8
            return r0
        L_0x009e:
            int r11 = r2 + 1
            char r2 = r10.charAt(r2)
            if (r2 == r7) goto L_0x00a9
            r10.matchStat = r8
            return r0
        L_0x00a9:
            if (r5 == 0) goto L_0x00b7
            int r2 = r11 + 1
            char r11 = r10.charAt(r11)
            if (r11 == r3) goto L_0x00b6
            r10.matchStat = r8
            return r0
        L_0x00b6:
            r11 = r2
        L_0x00b7:
            r10.bp = r11
            int r11 = r10.bp
            char r11 = r10.charAt(r11)
            goto L_0x00f6
        L_0x00c0:
            r6 = 49
            if (r2 != r6) goto L_0x00dc
            if (r5 == 0) goto L_0x00d2
            int r2 = r11 + 1
            char r11 = r10.charAt(r11)
            if (r11 == r3) goto L_0x00d1
            r10.matchStat = r8
            return r0
        L_0x00d1:
            r11 = r2
        L_0x00d2:
            r10.bp = r11
            int r11 = r10.bp
            char r11 = r10.charAt(r11)
        L_0x00da:
            r2 = r4
            goto L_0x00f7
        L_0x00dc:
            r6 = 48
            if (r2 != r6) goto L_0x018b
            if (r5 == 0) goto L_0x00ee
            int r2 = r11 + 1
            char r11 = r10.charAt(r11)
            if (r11 == r3) goto L_0x00ed
            r10.matchStat = r8
            return r0
        L_0x00ed:
            r11 = r2
        L_0x00ee:
            r10.bp = r11
            int r11 = r10.bp
            char r11 = r10.charAt(r11)
        L_0x00f6:
            r2 = r0
        L_0x00f7:
            r3 = 16
            r5 = 44
            if (r11 != r5) goto L_0x010e
            int r11 = r10.bp
            int r11 = r11 + r4
            r10.bp = r11
            char r11 = r10.charAt(r11)
            r10.ch = r11
            r11 = 3
            r10.matchStat = r11
            r10.token = r3
            goto L_0x015c
        L_0x010e:
            r6 = 125(0x7d, float:1.75E-43)
            if (r11 != r6) goto L_0x0170
            int r11 = r10.bp
            int r11 = r11 + r4
            r10.bp = r11
            char r11 = r10.charAt(r11)
        L_0x011b:
            if (r11 != r5) goto L_0x012b
            r10.token = r3
            int r11 = r10.bp
            int r11 = r11 + r4
            r10.bp = r11
            char r11 = r10.charAt(r11)
            r10.ch = r11
            goto L_0x0159
        L_0x012b:
            r1 = 93
            if (r11 != r1) goto L_0x013f
            r11 = 15
            r10.token = r11
            int r11 = r10.bp
            int r11 = r11 + r4
            r10.bp = r11
            char r11 = r10.charAt(r11)
            r10.ch = r11
            goto L_0x0159
        L_0x013f:
            if (r11 != r6) goto L_0x0151
            r11 = 13
            r10.token = r11
            int r11 = r10.bp
            int r11 = r11 + r4
            r10.bp = r11
            char r11 = r10.charAt(r11)
            r10.ch = r11
            goto L_0x0159
        L_0x0151:
            r1 = 26
            if (r11 != r1) goto L_0x015d
            r11 = 20
            r10.token = r11
        L_0x0159:
            r11 = 4
            r10.matchStat = r11
        L_0x015c:
            return r2
        L_0x015d:
            boolean r11 = isWhitespace(r11)
            if (r11 == 0) goto L_0x016d
            int r11 = r10.bp
            int r11 = r11 + r4
            r10.bp = r11
            char r11 = r10.charAt(r11)
            goto L_0x011b
        L_0x016d:
            r10.matchStat = r8
            return r0
        L_0x0170:
            boolean r11 = isWhitespace(r11)
            if (r11 == 0) goto L_0x0181
            int r11 = r10.bp
            int r11 = r11 + r4
            r10.bp = r11
            char r11 = r10.charAt(r11)
            goto L_0x00f7
        L_0x0181:
            r10.bp = r1
            int r11 = r10.bp
            r10.charAt(r11)
            r10.matchStat = r8
            return r0
        L_0x018b:
            r10.matchStat = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldBoolean(char[]):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int scanInt(char r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = 0
            r0.matchStat = r1
            int r2 = r0.bp
            int r3 = r0.bp
            int r4 = r3 + 1
            char r3 = r0.charAt(r3)
        L_0x000f:
            boolean r5 = isWhitespace(r3)
            if (r5 == 0) goto L_0x001f
            int r3 = r4 + 1
            char r4 = r0.charAt(r4)
            r15 = r4
            r4 = r3
            r3 = r15
            goto L_0x000f
        L_0x001f:
            r5 = 34
            r6 = 1
            if (r3 != r5) goto L_0x0026
            r7 = r6
            goto L_0x0027
        L_0x0026:
            r7 = r1
        L_0x0027:
            if (r7 == 0) goto L_0x0032
            int r3 = r4 + 1
            char r4 = r0.charAt(r4)
            r15 = r4
            r4 = r3
            r3 = r15
        L_0x0032:
            r8 = 45
            if (r3 != r8) goto L_0x0038
            r8 = r6
            goto L_0x0039
        L_0x0038:
            r8 = r1
        L_0x0039:
            if (r8 == 0) goto L_0x0044
            int r3 = r4 + 1
            char r4 = r0.charAt(r4)
            r15 = r4
            r4 = r3
            r3 = r15
        L_0x0044:
            r9 = 16
            r10 = 48
            r11 = -1
            if (r3 < r10) goto L_0x00c5
            r12 = 57
            if (r3 > r12) goto L_0x00c5
            int r3 = r3 - r10
        L_0x0050:
            int r13 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r10) goto L_0x0080
            if (r4 > r12) goto L_0x0080
            int r14 = r3 * 10
            if (r14 < r3) goto L_0x0064
            int r4 = r4 + -48
            int r3 = r14 + r4
            r4 = r13
            goto L_0x0050
        L_0x0064:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "parseInt error : "
            r3.append(r4)
            int r13 = r13 - r6
            java.lang.String r2 = r0.subString(r2, r13)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x0080:
            r2 = 46
            if (r4 != r2) goto L_0x0087
            r0.matchStat = r11
            return r1
        L_0x0087:
            if (r7 == 0) goto L_0x0095
            if (r4 == r5) goto L_0x008e
            r0.matchStat = r11
            return r1
        L_0x008e:
            int r2 = r13 + 1
            char r4 = r0.charAt(r13)
            r13 = r2
        L_0x0095:
            if (r3 >= 0) goto L_0x009a
            r0.matchStat = r11
            return r1
        L_0x009a:
            r1 = r17
        L_0x009c:
            if (r4 != r1) goto L_0x00b1
            r0.bp = r13
            int r1 = r0.bp
            char r1 = r0.charAt(r1)
            r0.ch = r1
            r1 = 3
            r0.matchStat = r1
            r0.token = r9
            if (r8 == 0) goto L_0x00b0
            int r3 = -r3
        L_0x00b0:
            return r3
        L_0x00b1:
            boolean r2 = isWhitespace(r4)
            if (r2 == 0) goto L_0x00bf
            int r2 = r13 + 1
            char r4 = r0.charAt(r13)
            r13 = r2
            goto L_0x009c
        L_0x00bf:
            r0.matchStat = r11
            if (r8 == 0) goto L_0x00c4
            int r3 = -r3
        L_0x00c4:
            return r3
        L_0x00c5:
            r2 = 110(0x6e, float:1.54E-43)
            if (r3 != r2) goto L_0x0133
            int r2 = r4 + 1
            char r3 = r0.charAt(r4)
            r4 = 117(0x75, float:1.64E-43)
            if (r3 != r4) goto L_0x0133
            int r3 = r2 + 1
            char r2 = r0.charAt(r2)
            r4 = 108(0x6c, float:1.51E-43)
            if (r2 != r4) goto L_0x0133
            int r2 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 != r4) goto L_0x0133
            r3 = 5
            r0.matchStat = r3
            int r4 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r7 == 0) goto L_0x00fb
            if (r2 != r5) goto L_0x00fb
            int r2 = r4 + 1
            char r4 = r0.charAt(r4)
        L_0x00f8:
            r15 = r4
            r4 = r2
            r2 = r15
        L_0x00fb:
            r5 = 44
            if (r2 != r5) goto L_0x010e
            r0.bp = r4
            int r2 = r0.bp
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r3
            r0.token = r9
            return r1
        L_0x010e:
            r5 = 93
            if (r2 != r5) goto L_0x0123
            r0.bp = r4
            int r2 = r0.bp
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r3
            r2 = 15
            r0.token = r2
            return r1
        L_0x0123:
            boolean r2 = isWhitespace(r2)
            if (r2 == 0) goto L_0x0130
            int r2 = r4 + 1
            char r4 = r0.charAt(r4)
            goto L_0x00f8
        L_0x0130:
            r0.matchStat = r11
            return r1
        L_0x0133:
            r0.matchStat = r11
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanInt(char):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public double scanDouble(char r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = 0
            r0.matchStat = r1
            int r2 = r0.bp
            int r3 = r2 + 1
            char r2 = r0.charAt(r2)
            r4 = 34
            if (r2 != r4) goto L_0x0013
            r6 = 1
            goto L_0x0014
        L_0x0013:
            r6 = r1
        L_0x0014:
            if (r6 == 0) goto L_0x0021
            int r2 = r3 + 1
            char r3 = r0.charAt(r3)
            r20 = r3
            r3 = r2
            r2 = r20
        L_0x0021:
            r7 = 45
            if (r2 != r7) goto L_0x0027
            r8 = 1
            goto L_0x0028
        L_0x0027:
            r8 = r1
        L_0x0028:
            if (r8 == 0) goto L_0x0035
            int r2 = r3 + 1
            char r3 = r0.charAt(r3)
            r20 = r3
            r3 = r2
            r2 = r20
        L_0x0035:
            r9 = 16
            r10 = 0
            r12 = -1
            r13 = 48
            if (r2 < r13) goto L_0x0118
            r14 = 57
            if (r2 > r14) goto L_0x0118
            int r2 = r2 - r13
            long r1 = (long) r2
        L_0x0044:
            int r15 = r3 + 1
            char r3 = r0.charAt(r3)
            r17 = 10
            if (r3 < r13) goto L_0x005a
            if (r3 > r14) goto L_0x005a
            long r1 = r1 * r17
            int r3 = r3 + -48
            long r4 = (long) r3
            long r1 = r1 + r4
            r3 = r15
            r4 = 34
            goto L_0x0044
        L_0x005a:
            r4 = 46
            if (r3 != r4) goto L_0x0060
            r4 = 1
            goto L_0x0061
        L_0x0060:
            r4 = 0
        L_0x0061:
            if (r4 == 0) goto L_0x0095
            int r3 = r15 + 1
            char r4 = r0.charAt(r15)
            if (r4 < r13) goto L_0x0092
            if (r4 > r14) goto L_0x0092
            long r1 = r1 * r17
            int r4 = r4 - r13
            long r4 = (long) r4
            long r1 = r1 + r4
            r4 = r17
        L_0x0074:
            int r15 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r13) goto L_0x008d
            if (r3 > r14) goto L_0x008d
            long r1 = r1 * r17
            int r3 = r3 + -48
            r19 = r15
            long r14 = (long) r3
            long r1 = r1 + r14
            long r4 = r4 * r17
            r3 = r19
            r14 = 57
            goto L_0x0074
        L_0x008d:
            r19 = r15
            r15 = r19
            goto L_0x0097
        L_0x0092:
            r0.matchStat = r12
            return r10
        L_0x0095:
            r4 = 1
        L_0x0097:
            r14 = 101(0x65, float:1.42E-43)
            if (r3 == r14) goto L_0x00a3
            r14 = 69
            if (r3 != r14) goto L_0x00a0
            goto L_0x00a3
        L_0x00a0:
            r16 = 0
            goto L_0x00a5
        L_0x00a3:
            r16 = 1
        L_0x00a5:
            if (r16 == 0) goto L_0x00cb
            int r3 = r15 + 1
            char r14 = r0.charAt(r15)
            r15 = 43
            if (r14 == r15) goto L_0x00b7
            if (r14 != r7) goto L_0x00b4
            goto L_0x00b7
        L_0x00b4:
            r15 = r3
            r3 = r14
            goto L_0x00be
        L_0x00b7:
            int r7 = r3 + 1
            char r3 = r0.charAt(r3)
            r15 = r7
        L_0x00be:
            if (r3 < r13) goto L_0x00cb
            r7 = 57
            if (r3 > r7) goto L_0x00cb
            int r3 = r15 + 1
            char r14 = r0.charAt(r15)
            goto L_0x00b4
        L_0x00cb:
            if (r6 == 0) goto L_0x00e5
            r6 = 34
            if (r3 == r6) goto L_0x00d4
            r0.matchStat = r12
            return r10
        L_0x00d4:
            int r3 = r15 + 1
            char r6 = r0.charAt(r15)
            int r7 = r0.bp
            r10 = 1
            int r7 = r7 + r10
            int r10 = r3 - r7
            int r10 = r10 + -2
            r15 = r3
            r3 = r6
            goto L_0x00ec
        L_0x00e5:
            r10 = 1
            int r7 = r0.bp
            int r6 = r15 - r7
            int r10 = r6 + -1
        L_0x00ec:
            if (r16 != 0) goto L_0x00f9
            r6 = 18
            if (r10 >= r6) goto L_0x00f9
            double r1 = (double) r1
            double r4 = (double) r4
            double r1 = r1 / r4
            if (r8 == 0) goto L_0x0101
            double r1 = -r1
            goto L_0x0101
        L_0x00f9:
            java.lang.String r1 = r0.subString(r7, r10)
            double r1 = java.lang.Double.parseDouble(r1)
        L_0x0101:
            r4 = r22
            if (r3 != r4) goto L_0x0115
            r0.bp = r15
            int r3 = r0.bp
            char r3 = r0.charAt(r3)
            r0.ch = r3
            r3 = 3
            r0.matchStat = r3
            r0.token = r9
            return r1
        L_0x0115:
            r0.matchStat = r12
            return r1
        L_0x0118:
            r1 = 110(0x6e, float:1.54E-43)
            if (r2 != r1) goto L_0x018a
            int r1 = r3 + 1
            char r2 = r0.charAt(r3)
            r3 = 117(0x75, float:1.64E-43)
            if (r2 != r3) goto L_0x018a
            int r2 = r1 + 1
            char r1 = r0.charAt(r1)
            r3 = 108(0x6c, float:1.51E-43)
            if (r1 != r3) goto L_0x018a
            int r1 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 != r3) goto L_0x018a
            r2 = 5
            r0.matchStat = r2
            int r3 = r1 + 1
            char r1 = r0.charAt(r1)
            if (r6 == 0) goto L_0x0152
            r4 = 34
            if (r1 != r4) goto L_0x0152
            int r1 = r3 + 1
            char r3 = r0.charAt(r3)
        L_0x014d:
            r20 = r3
            r3 = r1
            r1 = r20
        L_0x0152:
            r4 = 44
            if (r1 != r4) goto L_0x0165
            r0.bp = r3
            int r1 = r0.bp
            char r1 = r0.charAt(r1)
            r0.ch = r1
            r0.matchStat = r2
            r0.token = r9
            return r10
        L_0x0165:
            r4 = 93
            if (r1 != r4) goto L_0x017a
            r0.bp = r3
            int r1 = r0.bp
            char r1 = r0.charAt(r1)
            r0.ch = r1
            r0.matchStat = r2
            r1 = 15
            r0.token = r1
            return r10
        L_0x017a:
            boolean r1 = isWhitespace(r1)
            if (r1 == 0) goto L_0x0187
            int r1 = r3 + 1
            char r3 = r0.charAt(r3)
            goto L_0x014d
        L_0x0187:
            r0.matchStat = r12
            return r10
        L_0x018a:
            r0.matchStat = r12
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanDouble(char):double");
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long scanLong(char r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = 0
            r0.matchStat = r1
            int r2 = r0.bp
            int r3 = r2 + 1
            char r2 = r0.charAt(r2)
            r4 = 34
            r5 = 1
            if (r2 != r4) goto L_0x0014
            r6 = r5
            goto L_0x0015
        L_0x0014:
            r6 = r1
        L_0x0015:
            if (r6 == 0) goto L_0x0022
            int r2 = r3 + 1
            char r3 = r0.charAt(r3)
            r18 = r3
            r3 = r2
            r2 = r18
        L_0x0022:
            r7 = 45
            if (r2 != r7) goto L_0x0028
            r7 = r5
            goto L_0x0029
        L_0x0028:
            r7 = r1
        L_0x0029:
            if (r7 == 0) goto L_0x0036
            int r2 = r3 + 1
            char r3 = r0.charAt(r3)
            r18 = r3
            r3 = r2
            r2 = r18
        L_0x0036:
            r9 = 48
            r10 = -1
            r11 = 0
            if (r2 < r9) goto L_0x00b2
            r13 = 57
            if (r2 > r13) goto L_0x00b2
            int r2 = r2 - r9
            long r14 = (long) r2
        L_0x0043:
            int r2 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r9) goto L_0x0059
            if (r3 > r13) goto L_0x0059
            r16 = 10
            long r14 = r14 * r16
            int r3 = r3 + -48
            long r8 = (long) r3
            long r14 = r14 + r8
            r3 = r2
            r9 = 48
            goto L_0x0043
        L_0x0059:
            r8 = 46
            if (r3 != r8) goto L_0x0060
            r0.matchStat = r10
            return r11
        L_0x0060:
            if (r6 == 0) goto L_0x0072
            if (r3 == r4) goto L_0x0067
            r0.matchStat = r10
            return r11
        L_0x0067:
            int r3 = r2 + 1
            char r2 = r0.charAt(r2)
            r18 = r3
            r3 = r2
            r2 = r18
        L_0x0072:
            int r4 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r4 >= 0) goto L_0x007e
            r8 = -9223372036854775808
            int r4 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x007f
            if (r7 == 0) goto L_0x007f
        L_0x007e:
            r1 = r5
        L_0x007f:
            if (r1 != 0) goto L_0x0084
            r0.matchStat = r10
            return r11
        L_0x0084:
            r1 = r20
        L_0x0086:
            if (r3 != r1) goto L_0x009d
            r0.bp = r2
            int r1 = r0.bp
            char r1 = r0.charAt(r1)
            r0.ch = r1
            r1 = 3
            r0.matchStat = r1
            r1 = 16
            r0.token = r1
            if (r7 == 0) goto L_0x009c
            long r14 = -r14
        L_0x009c:
            return r14
        L_0x009d:
            boolean r3 = isWhitespace(r3)
            if (r3 == 0) goto L_0x00af
            int r3 = r2 + 1
            char r2 = r0.charAt(r2)
            r18 = r3
            r3 = r2
            r2 = r18
            goto L_0x0086
        L_0x00af:
            r0.matchStat = r10
            return r14
        L_0x00b2:
            r1 = 110(0x6e, float:1.54E-43)
            if (r2 != r1) goto L_0x0126
            int r1 = r3 + 1
            char r2 = r0.charAt(r3)
            r3 = 117(0x75, float:1.64E-43)
            if (r2 != r3) goto L_0x0126
            int r2 = r1 + 1
            char r1 = r0.charAt(r1)
            r3 = 108(0x6c, float:1.51E-43)
            if (r1 != r3) goto L_0x0126
            int r1 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 != r3) goto L_0x0126
            r2 = 5
            r0.matchStat = r2
            int r3 = r1 + 1
            char r1 = r0.charAt(r1)
            if (r6 == 0) goto L_0x00ea
            if (r1 != r4) goto L_0x00ea
            int r1 = r3 + 1
            char r3 = r0.charAt(r3)
        L_0x00e5:
            r18 = r3
            r3 = r1
            r1 = r18
        L_0x00ea:
            r4 = 44
            if (r1 != r4) goto L_0x00ff
            r0.bp = r3
            int r1 = r0.bp
            char r1 = r0.charAt(r1)
            r0.ch = r1
            r0.matchStat = r2
            r4 = 16
            r0.token = r4
            return r11
        L_0x00ff:
            r4 = 16
            r5 = 93
            if (r1 != r5) goto L_0x0116
            r0.bp = r3
            int r1 = r0.bp
            char r1 = r0.charAt(r1)
            r0.ch = r1
            r0.matchStat = r2
            r1 = 15
            r0.token = r1
            return r11
        L_0x0116:
            boolean r1 = isWhitespace(r1)
            if (r1 == 0) goto L_0x0123
            int r1 = r3 + 1
            char r3 = r0.charAt(r3)
            goto L_0x00e5
        L_0x0123:
            r0.matchStat = r10
            return r11
        L_0x0126:
            r0.matchStat = r10
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanLong(char):long");
    }

    public Date scanDate(char c) {
        char c2;
        Date date;
        long j;
        char c3;
        int i;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.bp;
        char c4 = this.ch;
        int i3 = this.bp;
        int i4 = i3 + 1;
        char charAt = charAt(i3);
        if (charAt == '\"') {
            int indexOf = indexOf('\"', i4);
            if (indexOf != -1) {
                this.bp = i4;
                if (scanISO8601DateIfMatch(false, indexOf - i4)) {
                    date = this.calendar.getTime();
                    c2 = charAt(indexOf + 1);
                    this.bp = i2;
                    while (c2 != ',' && c2 != ']') {
                        if (isWhitespace(c2)) {
                            indexOf++;
                            c2 = charAt(indexOf + 1);
                        } else {
                            this.bp = i2;
                            this.ch = c4;
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    this.bp = indexOf + 1;
                    this.ch = c2;
                } else {
                    this.bp = i2;
                    this.ch = c4;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c5 = '9';
            char c6 = '0';
            if (charAt == '-' || (charAt >= '0' && charAt <= '9')) {
                if (charAt == '-') {
                    charAt = charAt(i4);
                    i4++;
                    z = true;
                }
                if (charAt < '0' || charAt > '9') {
                    c3 = charAt;
                    j = 0;
                } else {
                    j = (long) (charAt - '0');
                    while (true) {
                        i = i4 + 1;
                        c3 = charAt(i4);
                        if (c3 >= c6 && c3 <= c5) {
                            j = (j * 10) + ((long) (c3 - '0'));
                            i4 = i;
                            c5 = '9';
                            c6 = '0';
                        } else if (c3 == ',' || c3 == ']') {
                            this.bp = i - 1;
                        }
                    }
                    this.bp = i - 1;
                }
                if (j < 0) {
                    this.bp = i2;
                    this.ch = c4;
                    this.matchStat = -1;
                    return null;
                }
                if (z) {
                    j = -j;
                }
                date = new Date(j);
            } else {
                if (charAt == 'n') {
                    int i5 = i4 + 1;
                    if (charAt(i4) == 'u') {
                        int i6 = i5 + 1;
                        if (charAt(i5) == 'l') {
                            int i7 = i6 + 1;
                            if (charAt(i6) == 'l') {
                                c2 = charAt(i7);
                                this.bp = i7;
                                date = null;
                            }
                        }
                    }
                }
                this.bp = i2;
                this.ch = c4;
                this.matchStat = -1;
                return null;
            }
        }
        if (c2 == ',') {
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
            this.matchStat = 3;
            return date;
        }
        int i9 = this.bp + 1;
        this.bp = i9;
        char charAt2 = charAt(i9);
        if (charAt2 == ',') {
            this.token = 16;
            int i10 = this.bp + 1;
            this.bp = i10;
            this.ch = charAt(i10);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i11 = this.bp + 1;
            this.bp = i11;
            this.ch = charAt(i11);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i12 = this.bp + 1;
            this.bp = i12;
            this.ch = charAt(i12);
        } else if (charAt2 == 26) {
            this.ch = JSONLexer.EOI;
            this.token = 20;
        } else {
            this.bp = i2;
            this.ch = c4;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    /* access modifiers changed from: protected */
    public final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        this.text.getChars(i, i3 + i, cArr, i2);
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i < this.bp) {
            if (this.text.charAt(i) == 10) {
                i2++;
                i3 = 1;
            }
            i++;
            i3++;
        }
        sb.append("pos ");
        sb.append(this.bp);
        sb.append(", line ");
        sb.append(i2);
        sb.append(", column ");
        sb.append(i3);
        if (this.text.length() < 65535) {
            sb.append(this.text);
        } else {
            sb.append(this.text.substring(0, 65535));
        }
        return sb.toString();
    }

    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        char c;
        int i2;
        int i3 = this.bp;
        char c2 = this.ch;
        while (isWhitespace(this.ch)) {
            next();
        }
        if (cArr != null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = this.bp + cArr.length;
            int i4 = length + 1;
            char charAt = this.text.charAt(length);
            while (isWhitespace(charAt)) {
                charAt = this.text.charAt(i4);
                i4++;
            }
            if (charAt == ':') {
                i2 = i4 + 1;
                c = this.text.charAt(i4);
                while (isWhitespace(c)) {
                    c = this.text.charAt(i2);
                    i2++;
                }
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            i2 = this.bp + 1;
            c = this.ch;
        }
        if (c == '[') {
            this.bp = i2;
            this.ch = this.text.charAt(this.bp);
            String[] strArr = i >= 0 ? new String[i] : new String[4];
            int i5 = 0;
            while (true) {
                if (isWhitespace(this.ch)) {
                    next();
                } else if (this.ch != '\"') {
                    this.bp = i3;
                    this.ch = c2;
                    this.matchStat = -1;
                    return null;
                } else {
                    String scanSymbol = scanSymbol(symbolTable, '\"');
                    if (i5 == strArr.length) {
                        String[] strArr2 = new String[(strArr.length + (strArr.length >> 1) + 1)];
                        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                        strArr = strArr2;
                    }
                    int i6 = i5 + 1;
                    strArr[i5] = scanSymbol;
                    while (isWhitespace(this.ch)) {
                        next();
                    }
                    if (this.ch == ',') {
                        next();
                        i5 = i6;
                    } else {
                        if (strArr.length != i6) {
                            String[] strArr3 = new String[i6];
                            System.arraycopy(strArr, 0, strArr3, 0, i6);
                            strArr = strArr3;
                        }
                        while (isWhitespace(this.ch)) {
                            next();
                        }
                        if (this.ch == ']') {
                            next();
                            return strArr;
                        }
                        this.bp = i3;
                        this.ch = c2;
                        this.matchStat = -1;
                        return null;
                    }
                }
            }
        } else if (c != 'n' || !this.text.startsWith("ull", this.bp + 1)) {
            this.matchStat = -1;
            return null;
        } else {
            this.bp += 4;
            this.ch = this.text.charAt(this.bp);
            return null;
        }
    }

    public boolean matchField2(char[] cArr) {
        while (isWhitespace(this.ch)) {
            next();
        }
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        char charAt = this.text.charAt(length);
        while (isWhitespace(charAt)) {
            charAt = this.text.charAt(i);
            i++;
        }
        if (charAt == ':') {
            this.bp = i;
            this.ch = charAt(this.bp);
            return true;
        }
        this.matchStat = -2;
        return false;
    }

    public final void skipObject() {
        skipObject(false);
    }

    public final void skipObject(boolean z) {
        int i = this.bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char charAt = this.text.charAt(i);
            if (charAt == '\\') {
                if (i < this.len - 1) {
                    i++;
                } else {
                    this.ch = charAt;
                    this.bp = i;
                    throw new JSONException("illegal str, " + info());
                }
            } else if (charAt == '\"') {
                z2 = !z2;
            } else if (charAt == '{') {
                if (!z2) {
                    i2++;
                }
            } else if (charAt == '}' && !z2 && i2 - 1 == -1) {
                this.bp = i + 1;
                int i3 = this.bp;
                int length = this.text.length();
                char c = JSONLexer.EOI;
                if (i3 == length) {
                    this.ch = JSONLexer.EOI;
                    this.token = 20;
                    return;
                }
                this.ch = this.text.charAt(this.bp);
                if (this.ch == ',') {
                    this.token = 16;
                    int i4 = this.bp + 1;
                    this.bp = i4;
                    if (i4 < this.text.length()) {
                        c = this.text.charAt(i4);
                    }
                    this.ch = c;
                    return;
                } else if (this.ch == '}') {
                    this.token = 13;
                    next();
                    return;
                } else if (this.ch == ']') {
                    this.token = 15;
                    next();
                    return;
                } else {
                    nextToken(16);
                    return;
                }
            }
            i++;
        }
        if (i == this.text.length()) {
            throw new JSONException("illegal str, " + info());
        }
    }

    public final void skipArray() {
        skipArray(false);
    }

    public final void skipArray(boolean z) {
        int i = this.bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char charAt = this.text.charAt(i);
            if (charAt == '\\') {
                if (i < this.len - 1) {
                    i++;
                } else {
                    this.ch = charAt;
                    this.bp = i;
                    throw new JSONException("illegal str, " + info());
                }
            } else if (charAt == '\"') {
                z2 = !z2;
            } else if (charAt != '[') {
                char c = JSONLexer.EOI;
                if (charAt == '{' && z) {
                    int i3 = this.bp + 1;
                    this.bp = i3;
                    if (i3 < this.text.length()) {
                        c = this.text.charAt(i3);
                    }
                    this.ch = c;
                    skipObject(z);
                } else if (charAt == ']' && !z2 && i2 - 1 == -1) {
                    this.bp = i + 1;
                    if (this.bp == this.text.length()) {
                        this.ch = JSONLexer.EOI;
                        this.token = 20;
                        return;
                    }
                    this.ch = this.text.charAt(this.bp);
                    nextToken(16);
                    return;
                }
            } else if (!z2) {
                i2++;
            }
            i++;
        }
        if (i == this.text.length()) {
            throw new JSONException("illegal str, " + info());
        }
    }

    public final void skipString() {
        if (this.ch == '\"') {
            int i = this.bp;
            while (true) {
                i++;
                if (i < this.text.length()) {
                    char charAt = this.text.charAt(i);
                    if (charAt == '\\') {
                        if (i < this.len - 1) {
                            i++;
                        }
                    } else if (charAt == '\"') {
                        String str = this.text;
                        int i2 = i + 1;
                        this.bp = i2;
                        this.ch = str.charAt(i2);
                        return;
                    }
                } else {
                    throw new JSONException("unclosed str");
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean seekArrayToItem(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index must > 0, but " + i);
        } else if (this.token == 20) {
            return false;
        } else {
            if (this.token == 14) {
                int i2 = 0;
                while (true) {
                    boolean z = true;
                    if (i2 < i) {
                        skipWhitespace();
                        if (this.ch == '\"' || this.ch == '\'') {
                            skipString();
                            if (this.ch == ',') {
                                next();
                            } else if (this.ch == ']') {
                                next();
                                nextToken(16);
                                return false;
                            } else {
                                throw new JSONException("illegal json.");
                            }
                        } else {
                            if (this.ch == '{') {
                                next();
                                this.token = 12;
                                skipObject(false);
                            } else if (this.ch == '[') {
                                next();
                                this.token = 14;
                                skipArray(false);
                            } else {
                                int i3 = this.bp + 1;
                                while (true) {
                                    if (i3 >= this.text.length()) {
                                        z = false;
                                        break;
                                    }
                                    char charAt = this.text.charAt(i3);
                                    if (charAt == ',') {
                                        this.bp = i3 + 1;
                                        this.ch = charAt(this.bp);
                                        break;
                                    } else if (charAt == ']') {
                                        this.bp = i3 + 1;
                                        this.ch = charAt(this.bp);
                                        nextToken();
                                        return false;
                                    } else {
                                        i3++;
                                    }
                                }
                                if (!z) {
                                    throw new JSONException("illegal json.");
                                }
                            }
                            if (this.token != 16) {
                                if (this.token == 15) {
                                    return false;
                                }
                                throw new UnsupportedOperationException();
                            }
                        }
                        i2++;
                    } else {
                        nextToken();
                        return true;
                    }
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    public int seekObjectToField(long j, boolean z) {
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        int i = -1;
        if (this.token == 20) {
            return -1;
        }
        if (this.token != 13) {
            int i2 = 15;
            if (this.token != 15) {
                int i3 = 16;
                if (this.token == 12 || this.token == 16) {
                    while (this.ch != '}') {
                        if (this.ch == 26) {
                            return i;
                        }
                        if (this.ch != '\"') {
                            skipWhitespace();
                        }
                        if (this.ch == '\"') {
                            long j2 = -3750763034362895579L;
                            int i4 = this.bp + 1;
                            while (true) {
                                if (i4 >= this.text.length()) {
                                    break;
                                }
                                char charAt = this.text.charAt(i4);
                                if (charAt == '\\') {
                                    i4++;
                                    if (i4 != this.text.length()) {
                                        charAt = this.text.charAt(i4);
                                    } else {
                                        throw new JSONException("unclosed str, " + info());
                                    }
                                }
                                if (charAt == '\"') {
                                    this.bp = i4 + 1;
                                    if (this.bp >= this.text.length()) {
                                        c7 = 26;
                                    } else {
                                        c7 = this.text.charAt(this.bp);
                                    }
                                    this.ch = c7;
                                } else {
                                    j2 = (j2 ^ ((long) charAt)) * 1099511628211L;
                                    i4++;
                                }
                            }
                            if (j2 == j) {
                                if (this.ch != ':') {
                                    skipWhitespace();
                                }
                                if (this.ch != ':') {
                                    return 3;
                                }
                                int i5 = this.bp + 1;
                                this.bp = i5;
                                if (i5 >= this.text.length()) {
                                    c = JSONLexer.EOI;
                                } else {
                                    c = this.text.charAt(i5);
                                }
                                this.ch = c;
                                if (this.ch == ',') {
                                    int i6 = this.bp + 1;
                                    this.bp = i6;
                                    if (i6 >= this.text.length()) {
                                        c4 = JSONLexer.EOI;
                                    } else {
                                        c4 = this.text.charAt(i6);
                                    }
                                    this.ch = c4;
                                    this.token = i3;
                                    return 3;
                                } else if (this.ch == ']') {
                                    int i7 = this.bp + 1;
                                    this.bp = i7;
                                    if (i7 >= this.text.length()) {
                                        c3 = JSONLexer.EOI;
                                    } else {
                                        c3 = this.text.charAt(i7);
                                    }
                                    this.ch = c3;
                                    this.token = i2;
                                    return 3;
                                } else if (this.ch == '}') {
                                    int i8 = this.bp + 1;
                                    this.bp = i8;
                                    if (i8 >= this.text.length()) {
                                        c2 = JSONLexer.EOI;
                                    } else {
                                        c2 = this.text.charAt(i8);
                                    }
                                    this.ch = c2;
                                    this.token = 13;
                                    return 3;
                                } else if (this.ch < '0' || this.ch > '9') {
                                    nextToken(2);
                                    return 3;
                                } else {
                                    this.sp = 0;
                                    this.pos = this.bp;
                                    scanNumber();
                                    return 3;
                                }
                            } else {
                                if (this.ch != ':') {
                                    skipWhitespace();
                                }
                                if (this.ch == ':') {
                                    int i9 = this.bp + 1;
                                    this.bp = i9;
                                    if (i9 >= this.text.length()) {
                                        c5 = JSONLexer.EOI;
                                    } else {
                                        c5 = this.text.charAt(i9);
                                    }
                                    this.ch = c5;
                                    if (!(this.ch == '\"' || this.ch == '\'' || this.ch == '{' || this.ch == '[' || this.ch == '0' || this.ch == '1' || this.ch == '2' || this.ch == '3' || this.ch == '4' || this.ch == '5' || this.ch == '6' || this.ch == '7' || this.ch == '8' || this.ch == '9' || this.ch == '+' || this.ch == '-')) {
                                        skipWhitespace();
                                    }
                                    if (this.ch == '-' || this.ch == '+' || (this.ch >= '0' && this.ch <= '9')) {
                                        next();
                                        while (this.ch >= '0' && this.ch <= '9') {
                                            next();
                                        }
                                        if (this.ch == '.') {
                                            next();
                                            while (this.ch >= '0' && this.ch <= '9') {
                                                next();
                                            }
                                        }
                                        if (this.ch == 'E' || this.ch == 'e') {
                                            next();
                                            if (this.ch == '-' || this.ch == '+') {
                                                next();
                                            }
                                            while (this.ch >= '0' && this.ch <= '9') {
                                                next();
                                            }
                                        }
                                        if (this.ch != ',') {
                                            skipWhitespace();
                                        }
                                        if (this.ch == ',') {
                                            next();
                                        }
                                    } else if (this.ch == '\"') {
                                        skipString();
                                        if (!(this.ch == ',' || this.ch == '}')) {
                                            skipWhitespace();
                                        }
                                        if (this.ch == ',') {
                                            next();
                                        }
                                    } else if (this.ch == 't') {
                                        next();
                                        if (this.ch == 'r') {
                                            next();
                                            if (this.ch == 'u') {
                                                next();
                                                if (this.ch == 'e') {
                                                    next();
                                                }
                                            }
                                        }
                                        if (!(this.ch == ',' || this.ch == '}')) {
                                            skipWhitespace();
                                        }
                                        if (this.ch == ',') {
                                            next();
                                        }
                                    } else if (this.ch == 'n') {
                                        next();
                                        if (this.ch == 'u') {
                                            next();
                                            if (this.ch == 'l') {
                                                next();
                                                if (this.ch == 'l') {
                                                    next();
                                                }
                                            }
                                        }
                                        if (!(this.ch == ',' || this.ch == '}')) {
                                            skipWhitespace();
                                        }
                                        if (this.ch == ',') {
                                            next();
                                        }
                                    } else if (this.ch == 'f') {
                                        next();
                                        if (this.ch == 'a') {
                                            next();
                                            if (this.ch == 'l') {
                                                next();
                                                if (this.ch == 's') {
                                                    next();
                                                    if (this.ch == 'e') {
                                                        next();
                                                    }
                                                }
                                            }
                                        }
                                        if (!(this.ch == ',' || this.ch == '}')) {
                                            skipWhitespace();
                                        }
                                        if (this.ch == ',') {
                                            next();
                                        }
                                    } else if (this.ch == '{') {
                                        int i10 = this.bp + 1;
                                        this.bp = i10;
                                        if (i10 >= this.text.length()) {
                                            c6 = JSONLexer.EOI;
                                        } else {
                                            c6 = this.text.charAt(i10);
                                        }
                                        this.ch = c6;
                                        if (z) {
                                            this.token = 12;
                                            return 1;
                                        }
                                        skipObject(false);
                                        if (this.token == 13) {
                                            return -1;
                                        }
                                    } else if (this.ch == '[') {
                                        next();
                                        if (z) {
                                            this.token = 14;
                                            return 2;
                                        }
                                        skipArray(false);
                                        if (this.token == 13) {
                                            return -1;
                                        }
                                    } else {
                                        throw new UnsupportedOperationException();
                                    }
                                    i = -1;
                                    i2 = 15;
                                    i3 = 16;
                                } else {
                                    throw new JSONException("illegal json, " + info());
                                }
                            }
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    }
                    next();
                    nextToken();
                    return i;
                }
                throw new UnsupportedOperationException(JSONToken.name(this.token));
            }
        }
        nextToken();
        return -1;
    }

    public int seekObjectToField(long[] jArr) {
        char c;
        char c2;
        char c3;
        if (this.token == 12 || this.token == 16) {
            while (this.ch != '}') {
                char c4 = this.ch;
                char c5 = JSONLexer.EOI;
                if (c4 == 26) {
                    this.matchStat = -1;
                    return -1;
                }
                if (this.ch != '\"') {
                    skipWhitespace();
                }
                if (this.ch == '\"') {
                    long j = -3750763034362895579L;
                    int i = this.bp;
                    while (true) {
                        i++;
                        if (i >= this.text.length()) {
                            break;
                        }
                        char charAt = this.text.charAt(i);
                        if (charAt == '\\') {
                            i++;
                            if (i != this.text.length()) {
                                charAt = this.text.charAt(i);
                            } else {
                                throw new JSONException("unclosed str, " + info());
                            }
                        }
                        if (charAt == '\"') {
                            this.bp = i + 1;
                            if (this.bp >= this.text.length()) {
                                c3 = 26;
                            } else {
                                c3 = this.text.charAt(this.bp);
                            }
                            this.ch = c3;
                        } else {
                            j = (j ^ ((long) charAt)) * 1099511628211L;
                        }
                    }
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jArr.length) {
                            i2 = -1;
                            break;
                        } else if (j == jArr[i2]) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 != -1) {
                        if (this.ch != ':') {
                            skipWhitespace();
                        }
                        if (this.ch == ':') {
                            int i3 = this.bp + 1;
                            this.bp = i3;
                            if (i3 >= this.text.length()) {
                                c = 26;
                            } else {
                                c = this.text.charAt(i3);
                            }
                            this.ch = c;
                            if (this.ch == ',') {
                                int i4 = this.bp + 1;
                                this.bp = i4;
                                if (i4 < this.text.length()) {
                                    c5 = this.text.charAt(i4);
                                }
                                this.ch = c5;
                                this.token = 16;
                            } else if (this.ch == ']') {
                                int i5 = this.bp + 1;
                                this.bp = i5;
                                if (i5 < this.text.length()) {
                                    c5 = this.text.charAt(i5);
                                }
                                this.ch = c5;
                                this.token = 15;
                            } else if (this.ch == '}') {
                                int i6 = this.bp + 1;
                                this.bp = i6;
                                if (i6 < this.text.length()) {
                                    c5 = this.text.charAt(i6);
                                }
                                this.ch = c5;
                                this.token = 13;
                            } else if (this.ch < '0' || this.ch > '9') {
                                nextToken(2);
                            } else {
                                this.sp = 0;
                                this.pos = this.bp;
                                scanNumber();
                            }
                        }
                        this.matchStat = 3;
                        return i2;
                    }
                    if (this.ch != ':') {
                        skipWhitespace();
                    }
                    if (this.ch == ':') {
                        int i7 = this.bp + 1;
                        this.bp = i7;
                        if (i7 >= this.text.length()) {
                            c2 = 26;
                        } else {
                            c2 = this.text.charAt(i7);
                        }
                        this.ch = c2;
                        if (!(this.ch == '\"' || this.ch == '\'' || this.ch == '{' || this.ch == '[' || this.ch == '0' || this.ch == '1' || this.ch == '2' || this.ch == '3' || this.ch == '4' || this.ch == '5' || this.ch == '6' || this.ch == '7' || this.ch == '8' || this.ch == '9' || this.ch == '+' || this.ch == '-')) {
                            skipWhitespace();
                        }
                        if (this.ch == '-' || this.ch == '+' || (this.ch >= '0' && this.ch <= '9')) {
                            next();
                            while (this.ch >= '0' && this.ch <= '9') {
                                next();
                            }
                            if (this.ch == '.') {
                                next();
                                while (this.ch >= '0' && this.ch <= '9') {
                                    next();
                                }
                            }
                            if (this.ch == 'E' || this.ch == 'e') {
                                next();
                                if (this.ch == '-' || this.ch == '+') {
                                    next();
                                }
                                while (this.ch >= '0' && this.ch <= '9') {
                                    next();
                                }
                            }
                            if (this.ch != ',') {
                                skipWhitespace();
                            }
                            if (this.ch == ',') {
                                next();
                            }
                        } else if (this.ch == '\"') {
                            skipString();
                            if (!(this.ch == ',' || this.ch == '}')) {
                                skipWhitespace();
                            }
                            if (this.ch == ',') {
                                next();
                            }
                        } else if (this.ch == '{') {
                            int i8 = this.bp + 1;
                            this.bp = i8;
                            if (i8 < this.text.length()) {
                                c5 = this.text.charAt(i8);
                            }
                            this.ch = c5;
                            skipObject(false);
                        } else if (this.ch == '[') {
                            next();
                            skipArray(false);
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    } else {
                        throw new JSONException("illegal json, " + info());
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            }
            next();
            nextToken();
            this.matchStat = -1;
            return -1;
        }
        throw new UnsupportedOperationException();
    }
}
