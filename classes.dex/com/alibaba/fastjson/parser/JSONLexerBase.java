package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

public abstract class JSONLexerBase implements JSONLexer, Closeable {
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    private static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal<>();
    protected static final int[] digits = new int[103];
    protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    protected int bp;
    protected Calendar calendar = null;
    protected char ch;
    protected int eofPos;
    protected int features;
    protected boolean hasSpecial;
    protected Locale locale = JSON.defaultLocale;
    public int matchStat = 0;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue = null;
    protected TimeZone timeZone = JSON.defaultTimeZone;
    protected int token;

    public static boolean isWhitespace(char c) {
        return c <= ' ' && (c == ' ' || c == 10 || c == 13 || c == 9 || c == 12 || c == 8);
    }

    public abstract String addSymbol(int i, int i2, int i3, SymbolTable symbolTable);

    /* access modifiers changed from: protected */
    public abstract void arrayCopy(int i, char[] cArr, int i2, int i3);

    public abstract byte[] bytesValue();

    /* access modifiers changed from: protected */
    public abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i);

    /* access modifiers changed from: protected */
    public abstract void copyTo(int i, int i2, char[] cArr);

    public abstract BigDecimal decimalValue();

    public abstract int indexOf(char c, int i);

    public String info() {
        return "";
    }

    public abstract boolean isEOF();

    public abstract char next();

    public abstract String numberString();

    public abstract String stringVal();

    public abstract String subString(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract char[] sub_chars(int i, int i2);

    /* access modifiers changed from: protected */
    public void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    static {
        for (int i = 48; i <= 57; i++) {
            digits[i] = i - 48;
        }
        for (int i2 = 97; i2 <= 102; i2++) {
            digits[i2] = (i2 - 97) + 10;
        }
        for (int i3 = 65; i3 <= 70; i3++) {
            digits[i3] = (i3 - 65) + 10;
        }
    }

    public JSONLexerBase(int i) {
        this.features = i;
        if ((i & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        char[] cArr = SBUF_LOCAL.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
    }

    public final int matchStat() {
        return this.matchStat;
    }

    public void setToken(int i) {
        this.token = i;
    }

    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            char c = this.ch;
            if (c == '/') {
                skipComment();
            } else if (c == '\"') {
                scanString();
                return;
            } else if (c == ',') {
                next();
                this.token = 16;
                return;
            } else if (c >= '0' && c <= '9') {
                scanNumber();
                return;
            } else if (c == '-') {
                scanNumber();
                return;
            } else {
                switch (c) {
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                        next();
                        break;
                    case '\'':
                        if (isEnabled(Feature.AllowSingleQuotes)) {
                            scanStringSingleQuote();
                            return;
                        }
                        throw new JSONException("Feature.AllowSingleQuotes is false");
                    case '(':
                        next();
                        this.token = 10;
                        return;
                    case ')':
                        next();
                        this.token = 11;
                        return;
                    case '+':
                        next();
                        scanNumber();
                        return;
                    case '.':
                        next();
                        this.token = 25;
                        return;
                    case ':':
                        next();
                        this.token = 17;
                        return;
                    case ';':
                        next();
                        this.token = 24;
                        return;
                    case 'N':
                    case 'S':
                    case 'T':
                    case 'u':
                        scanIdent();
                        return;
                    case '[':
                        next();
                        this.token = 14;
                        return;
                    case ']':
                        next();
                        this.token = 15;
                        return;
                    case 'f':
                        scanFalse();
                        return;
                    case 'n':
                        scanNullOrNew();
                        return;
                    case 't':
                        scanTrue();
                        return;
                    case 'x':
                        scanHex();
                        return;
                    case '{':
                        next();
                        this.token = 12;
                        return;
                    case '}':
                        next();
                        this.token = 13;
                        return;
                    default:
                        if (!isEOF()) {
                            char c2 = this.ch;
                            if (c2 <= 31 || c2 == 127) {
                                next();
                                break;
                            } else {
                                lexError("illegal.char", String.valueOf(c2));
                                next();
                                return;
                            }
                        } else if (this.token != 20) {
                            this.token = 20;
                            int i = this.bp;
                            this.pos = i;
                            this.eofPos = i;
                            return;
                        } else {
                            throw new JSONException("EOF error");
                        }
                }
            }
        }
    }

    public final void nextToken(int i) {
        this.sp = 0;
        while (true) {
            if (i == 2) {
                char c = this.ch;
                if (c >= '0' && c <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 4) {
                char c2 = this.ch;
                if (c2 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c2 >= '0' && c2 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c2 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c2 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 12) {
                char c3 = this.ch;
                if (c3 == '{') {
                    this.token = 12;
                    next();
                    return;
                } else if (c3 == '[') {
                    this.token = 14;
                    next();
                    return;
                }
            } else if (i != 18) {
                if (i != 20) {
                    switch (i) {
                        case 14:
                            char c4 = this.ch;
                            if (c4 == '[') {
                                this.token = 14;
                                next();
                                return;
                            } else if (c4 == '{') {
                                this.token = 12;
                                next();
                                return;
                            }
                            break;
                        case 15:
                            if (this.ch == ']') {
                                this.token = 15;
                                next();
                                return;
                            }
                            break;
                        case 16:
                            char c5 = this.ch;
                            if (c5 == ',') {
                                this.token = 16;
                                next();
                                return;
                            } else if (c5 == '}') {
                                this.token = 13;
                                next();
                                return;
                            } else if (c5 == ']') {
                                this.token = 15;
                                next();
                                return;
                            } else if (c5 == 26) {
                                this.token = 20;
                                return;
                            } else if (c5 == 'n') {
                                scanNullOrNew(false);
                                return;
                            }
                            break;
                    }
                }
                if (this.ch == 26) {
                    this.token = 20;
                    return;
                }
            } else {
                nextIdent();
                return;
            }
            char c6 = this.ch;
            if (c6 == ' ' || c6 == 10 || c6 == 13 || c6 == 9 || c6 == 12 || c6 == 8) {
                next();
            } else {
                nextToken();
                return;
            }
        }
    }

    public final void nextIdent() {
        while (isWhitespace(this.ch)) {
            next();
        }
        char c = this.ch;
        if (c == '_' || c == '$' || Character.isLetter(c)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    public final void nextTokenWithChar(char c) {
        this.sp = 0;
        while (true) {
            char c2 = this.ch;
            if (c2 == c) {
                next();
                nextToken();
                return;
            } else if (c2 == ' ' || c2 == 10 || c2 == 13 || c2 == 9 || c2 == 12 || c2 == 8) {
                next();
            } else {
                throw new JSONException("not match " + c + " - " + this.ch + ", info : " + info());
            }
        }
    }

    public final int token() {
        return this.token;
    }

    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    public final int pos() {
        return this.pos;
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    public final Number integerValue() throws NumberFormatException {
        long j;
        long j2;
        boolean z = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i = this.np;
        int i2 = this.sp + i;
        char c = ' ';
        char charAt = charAt(i2 - 1);
        if (charAt == 'B') {
            i2--;
            c = 'B';
        } else if (charAt == 'L') {
            i2--;
            c = 'L';
        } else if (charAt == 'S') {
            i2--;
            c = 'S';
        }
        if (charAt(this.np) == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        long j3 = MULTMIN_RADIX_TEN;
        if (i < i2) {
            j2 = (long) (-(charAt(i) - '0'));
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i3 = i + 1;
            int charAt2 = charAt(i) - '0';
            if (j2 < j3) {
                return new BigInteger(numberString());
            }
            long j4 = j2 * 10;
            long j5 = (long) charAt2;
            if (j4 < j + j5) {
                return new BigInteger(numberString());
            }
            j2 = j4 - j5;
            i = i3;
            j3 = MULTMIN_RADIX_TEN;
        }
        if (!z) {
            long j6 = -j2;
            if (j6 > 2147483647L || c == 'L') {
                return Long.valueOf(j6);
            }
            if (c == 'S') {
                return Short.valueOf((short) ((int) j6));
            }
            if (c == 'B') {
                return Byte.valueOf((byte) ((int) j6));
            }
            return Integer.valueOf((int) j6);
        } else if (i <= this.np + 1) {
            throw new NumberFormatException(numberString());
        } else if (j2 < -2147483648L || c == 'L') {
            return Long.valueOf(j2);
        } else {
            if (c == 'S') {
                return Short.valueOf((short) ((int) j2));
            }
            if (c == 'B') {
                return Byte.valueOf((byte) ((int) j2));
            }
            return Integer.valueOf((int) j2);
        }
    }

    public final void nextTokenWithColon(int i) {
        nextTokenWithChar(':');
    }

    public float floatValue() {
        char charAt;
        String numberString = numberString();
        float parseFloat = Float.parseFloat(numberString);
        if ((parseFloat != 0.0f && parseFloat != Float.POSITIVE_INFINITY) || (charAt = numberString.charAt(0)) <= '0' || charAt > '9') {
            return parseFloat;
        }
        throw new JSONException("float overflow : " + numberString);
    }

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    public void config(Feature feature, boolean z) {
        int config = Feature.config(this.features, feature, z);
        this.features = config;
        if ((config & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    public final boolean isEnabled(Feature feature) {
        return isEnabled(feature.mask);
    }

    public final boolean isEnabled(int i) {
        return (i & this.features) != 0;
    }

    public final boolean isEnabled(int i, int i2) {
        return ((this.features & i2) == 0 && (i & i2) == 0) ? false : true;
    }

    public final char getCurrent() {
        return this.ch;
    }

    /* access modifiers changed from: protected */
    public void skipComment() {
        char c;
        next();
        char c2 = this.ch;
        if (c2 == '/') {
            do {
                next();
                c = this.ch;
                if (c == 10) {
                    next();
                    return;
                }
            } while (c != 26);
        } else if (c2 == '*') {
            next();
            while (true) {
                char c3 = this.ch;
                if (c3 == 26) {
                    return;
                }
                if (c3 == '*') {
                    next();
                    if (this.ch == '/') {
                        next();
                        return;
                    }
                } else {
                    next();
                }
            }
        } else {
            throw new JSONException("invalid comment");
        }
    }

    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        char c = this.ch;
        if (c == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c == '\'') {
            if (isEnabled(Feature.AllowSingleQuotes)) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
        } else if (c == '}') {
            next();
            this.token = 13;
            return null;
        } else if (c == ',') {
            next();
            this.token = 16;
            return null;
        } else if (c == 26) {
            this.token = 20;
            return null;
        } else if (isEnabled(Feature.AllowUnQuotedFieldNames)) {
            return scanSymbolUnQuoted(symbolTable);
        } else {
            throw new JSONException("syntax error");
        }
    }

    public final String scanSymbol(SymbolTable symbolTable, char c) {
        String str;
        this.np = this.bp;
        this.sp = 0;
        boolean z = false;
        int i = 0;
        while (true) {
            char next = next();
            if (next == c) {
                this.token = 4;
                if (!z) {
                    int i2 = this.np;
                    str = addSymbol(i2 == -1 ? 0 : i2 + 1, this.sp, i, symbolTable);
                } else {
                    str = symbolTable.addSymbol(this.sbuf, 0, this.sp, i);
                }
                this.sp = 0;
                next();
                return str;
            } else if (next == 26) {
                throw new JSONException("unclosed.str");
            } else if (next == '\\') {
                if (!z) {
                    int i3 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i3 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i3 <= length) {
                            i3 = length;
                        }
                        char[] cArr2 = new char[i3];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
                    z = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i = (i * 31) + 34;
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i = (i * 31) + 92;
                            putChar('\\');
                        } else if (next2 == 'b') {
                            i = (i * 31) + 8;
                            putChar(8);
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i = (i * 31) + 10;
                                putChar(10);
                            } else if (next2 == 'r') {
                                i = (i * 31) + 13;
                                putChar(13);
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i = (i * 31) + 47;
                                        putChar('/');
                                        break;
                                    case '0':
                                        i = (i * 31) + next2;
                                        putChar(0);
                                        break;
                                    case '1':
                                        i = (i * 31) + next2;
                                        putChar(1);
                                        break;
                                    case '2':
                                        i = (i * 31) + next2;
                                        putChar(2);
                                        break;
                                    case '3':
                                        i = (i * 31) + next2;
                                        putChar(3);
                                        break;
                                    case '4':
                                        i = (i * 31) + next2;
                                        putChar(4);
                                        break;
                                    case '5':
                                        i = (i * 31) + next2;
                                        putChar(5);
                                        break;
                                    case '6':
                                        i = (i * 31) + next2;
                                        putChar(6);
                                        break;
                                    case '7':
                                        i = (i * 31) + next2;
                                        putChar(7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                i = (i * 31) + 9;
                                                putChar(9);
                                                break;
                                            case 'u':
                                                int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i = (i * 31) + parseInt;
                                                putChar((char) parseInt);
                                                break;
                                            case 'v':
                                                i = (i * 31) + 11;
                                                putChar(11);
                                                break;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                char next3 = next();
                                this.ch = next3;
                                char next4 = next();
                                this.ch = next4;
                                int[] iArr = digits;
                                char c2 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i = (i * 31) + c2;
                                putChar(c2);
                            }
                        }
                    }
                    i = (i * 31) + 12;
                    putChar(12);
                } else {
                    i = (i * 31) + 39;
                    putChar('\'');
                }
            } else {
                i = (i * 31) + next;
                if (!z) {
                    this.sp++;
                } else {
                    int i4 = this.sp;
                    char[] cArr3 = this.sbuf;
                    if (i4 == cArr3.length) {
                        putChar(next);
                    } else {
                        this.sp = i4 + 1;
                        cArr3[i4] = next;
                    }
                }
            }
        }
    }

    public final void resetStringPosition() {
        this.sp = 0;
    }

    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        boolean z = false;
        if (this.token == 1 && this.pos == 0 && this.bp == 1) {
            this.bp = 0;
        }
        boolean[] zArr = IOUtils.firstIdentifierFlags;
        int i = this.ch;
        if (i >= zArr.length || zArr[i]) {
            z = true;
        }
        if (z) {
            boolean[] zArr2 = IOUtils.identifierFlags;
            this.np = this.bp;
            this.sp = 1;
            while (true) {
                char next = next();
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i = (i * 31) + next;
                this.sp++;
            }
            this.ch = charAt(this.bp);
            this.token = 18;
            if (this.sp == 4 && i == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') {
                return null;
            }
            if (symbolTable == null) {
                return subString(this.np, this.sp);
            }
            return addSymbol(this.np, this.sp, i, symbolTable);
        }
        throw new JSONException("illegal identifier : " + this.ch + info());
    }

    public final void scanString() {
        char next;
        char next2;
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next3 = next();
            if (next3 == '\"') {
                this.token = 4;
                this.ch = next();
                return;
            } else if (next3 != 26) {
                boolean z = true;
                if (next3 == '\\') {
                    if (!this.hasSpecial) {
                        this.hasSpecial = true;
                        int i = this.sp;
                        char[] cArr = this.sbuf;
                        if (i >= cArr.length) {
                            int length = cArr.length * 2;
                            if (i <= length) {
                                i = length;
                            }
                            char[] cArr2 = new char[i];
                            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                            this.sbuf = cArr2;
                        }
                        copyTo(this.np + 1, this.sp, this.sbuf);
                    }
                    char next4 = next();
                    if (next4 == '\"') {
                        putChar('\"');
                    } else if (next4 != '\'') {
                        if (next4 != 'F') {
                            if (next4 == '\\') {
                                putChar('\\');
                            } else if (next4 == 'b') {
                                putChar(8);
                            } else if (next4 != 'f') {
                                if (next4 == 'n') {
                                    putChar(10);
                                } else if (next4 == 'r') {
                                    putChar(13);
                                } else if (next4 != 'x') {
                                    switch (next4) {
                                        case '/':
                                            putChar('/');
                                            break;
                                        case '0':
                                            putChar(0);
                                            break;
                                        case '1':
                                            putChar(1);
                                            break;
                                        case '2':
                                            putChar(2);
                                            break;
                                        case '3':
                                            putChar(3);
                                            break;
                                        case '4':
                                            putChar(4);
                                            break;
                                        case '5':
                                            putChar(5);
                                            break;
                                        case '6':
                                            putChar(6);
                                            break;
                                        case '7':
                                            putChar(7);
                                            break;
                                        default:
                                            switch (next4) {
                                                case 't':
                                                    putChar(9);
                                                    break;
                                                case 'u':
                                                    putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                    break;
                                                case 'v':
                                                    putChar(11);
                                                    break;
                                                default:
                                                    this.ch = next4;
                                                    throw new JSONException("unclosed string : " + next4);
                                            }
                                    }
                                } else {
                                    next = next();
                                    next2 = next();
                                    boolean z2 = (next >= '0' && next <= '9') || (next >= 'a' && next <= 'f') || (next >= 'A' && next <= 'F');
                                    if ((next2 < '0' || next2 > '9') && ((next2 < 'a' || next2 > 'f') && (next2 < 'A' || next2 > 'F'))) {
                                        z = false;
                                    }
                                    if (!z2 || !z) {
                                    } else {
                                        int[] iArr = digits;
                                        putChar((char) ((iArr[next] * 16) + iArr[next2]));
                                    }
                                }
                            }
                        }
                        putChar(12);
                    } else {
                        putChar('\'');
                    }
                } else if (!this.hasSpecial) {
                    this.sp++;
                } else {
                    int i2 = this.sp;
                    char[] cArr3 = this.sbuf;
                    if (i2 == cArr3.length) {
                        putChar(next3);
                    } else {
                        this.sp = i2 + 1;
                        cArr3[i2] = next3;
                    }
                }
            } else if (!isEOF()) {
                putChar(JSONLexer.EOI);
            } else {
                throw new JSONException("unclosed string : " + next3);
            }
        }
        throw new JSONException("invalid escape character \\x" + next + next2);
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone2) {
        this.timeZone = timeZone2;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(Locale locale2) {
        this.locale = locale2;
    }

    public final int intValue() {
        boolean z;
        int i;
        int i2;
        int i3 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i4 = this.np;
        int i5 = this.sp + i4;
        if (charAt(i4) == '-') {
            i = Integer.MIN_VALUE;
            i4++;
            z = true;
        } else {
            i = -2147483647;
            z = false;
        }
        if (i4 < i5) {
            i3 = -(charAt(i4) - '0');
            i4++;
        }
        while (true) {
            if (i4 >= i5) {
                break;
            }
            i2 = i4 + 1;
            char charAt = charAt(i4);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i4 = i2;
            } else {
                int i6 = charAt - '0';
                if (((long) i3) >= -214748364) {
                    int i7 = i3 * 10;
                    if (i7 >= i + i6) {
                        i3 = i7 - i6;
                        i4 = i2;
                    } else {
                        throw new NumberFormatException(numberString());
                    }
                } else {
                    throw new NumberFormatException(numberString());
                }
            }
        }
        i4 = i2;
        if (!z) {
            return -i3;
        }
        if (i4 > this.np + 1) {
            return i3;
        }
        throw new NumberFormatException(numberString());
    }

    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8192) {
            SBUF_LOCAL.set(cArr);
        }
        this.sbuf = null;
    }

    public final boolean isRef() {
        if (this.sp == 4 && charAt(this.np + 1) == '$' && charAt(this.np + 2) == 'r' && charAt(this.np + 3) == 'e' && charAt(this.np + 4) == 'f') {
            return true;
        }
        return false;
    }

    public final int scanType(String str) {
        this.matchStat = 0;
        char[] cArr = typeFieldName;
        if (!charArrayCompare(cArr)) {
            return -2;
        }
        int length = this.bp + cArr.length;
        int length2 = str.length();
        for (int i = 0; i < length2; i++) {
            if (str.charAt(i) != charAt(length + i)) {
                return -1;
            }
        }
        int i2 = length + length2;
        if (charAt(i2) != '\"') {
            return -1;
        }
        int i3 = i2 + 1;
        char charAt = charAt(i3);
        this.ch = charAt;
        if (charAt == ',') {
            int i4 = i3 + 1;
            this.ch = charAt(i4);
            this.bp = i4;
            this.token = 16;
            return 3;
        }
        if (charAt == '}') {
            i3++;
            char charAt2 = charAt(i3);
            this.ch = charAt2;
            if (charAt2 == ',') {
                this.token = 16;
                i3++;
                this.ch = charAt(i3);
            } else if (charAt2 == ']') {
                this.token = 15;
                i3++;
                this.ch = charAt(i3);
            } else if (charAt2 == '}') {
                this.token = 13;
                i3++;
                this.ch = charAt(i3);
            } else if (charAt2 != 26) {
                return -1;
            } else {
                this.token = 20;
            }
            this.matchStat = 4;
        }
        this.bp = i3;
        return this.matchStat;
    }

    public final boolean matchField(char[] cArr) {
        while (!charArrayCompare(cArr)) {
            if (!isWhitespace(this.ch)) {
                return false;
            }
            next();
        }
        int length = this.bp + cArr.length;
        this.bp = length;
        char charAt = charAt(length);
        this.ch = charAt;
        if (charAt == '{') {
            next();
            this.token = 12;
        } else if (charAt == '[') {
            next();
            this.token = 14;
        } else if (charAt == 'S' && charAt(this.bp + 1) == 'e' && charAt(this.bp + 2) == 't' && charAt(this.bp + 3) == '[') {
            int i = this.bp + 3;
            this.bp = i;
            this.ch = charAt(i);
            this.token = 21;
        } else {
            nextToken();
        }
        return true;
    }

    public int matchField(long j) {
        throw new UnsupportedOperationException();
    }

    public boolean seekArrayToItem(int i) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToField(long j, boolean z) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToField(long[] jArr) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToFieldDeepScan(long j) {
        throw new UnsupportedOperationException();
    }

    public void skipObject() {
        throw new UnsupportedOperationException();
    }

    public void skipObject(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void skipArray() {
        throw new UnsupportedOperationException();
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', this.bp + cArr.length + 1);
        if (indexOf != -1) {
            int length2 = this.bp + cArr.length + 1;
            String subString = subString(length2, indexOf - length2);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i2 = indexOf - 1;
                    int i3 = 0;
                    while (i2 >= 0 && charAt(i2) == '\\') {
                        i3++;
                        i2--;
                    }
                    if (i3 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int i4 = this.bp;
                int length3 = indexOf - ((cArr.length + i4) + 1);
                subString = readString(sub_chars(i4 + cArr.length + 1, length3), length3);
            }
            int i5 = this.bp;
            int length4 = i + (indexOf - ((cArr.length + i5) + 1)) + 1;
            int i6 = length4 + 1;
            char charAt = charAt(i5 + length4);
            if (charAt == ',') {
                int i7 = this.bp + i6;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return subString;
            } else if (charAt == '}') {
                int i8 = i6 + 1;
                char charAt2 = charAt(this.bp + i6);
                if (charAt2 == ',') {
                    this.token = 16;
                    int i9 = this.bp + i8;
                    this.bp = i9;
                    this.ch = charAt(i9);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i10 = this.bp + i8;
                    this.bp = i10;
                    this.ch = charAt(i10);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i11 = this.bp + i8;
                    this.bp = i11;
                    this.ch = charAt(i11);
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.bp += i8 - 1;
                    this.ch = JSONLexer.EOI;
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
                this.matchStat = 4;
                return subString;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        } else {
            throw new JSONException("unclosed str");
        }
    }

    public String scanString(char c) {
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt != 'n') {
            int i = 1;
            while (charAt != '\"') {
                if (isWhitespace(charAt)) {
                    charAt = charAt(this.bp + i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
            }
            int i2 = this.bp + i;
            int indexOf = indexOf('\"', i2);
            if (indexOf != -1) {
                String subString = subString(this.bp + i, indexOf - i2);
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
                    int i5 = indexOf - i2;
                    subString = readString(sub_chars(this.bp + 1, i5), i5);
                }
                int i6 = i + (indexOf - i2) + 1;
                int i7 = i6 + 1;
                char charAt2 = charAt(this.bp + i6);
                while (charAt2 != c) {
                    if (isWhitespace(charAt2)) {
                        charAt2 = charAt(this.bp + i7);
                        i7++;
                    } else {
                        this.matchStat = -1;
                        return subString;
                    }
                }
                int i8 = this.bp + i7;
                this.bp = i8;
                this.ch = charAt(i8);
                this.matchStat = 3;
                this.token = 16;
                return subString;
            }
            throw new JSONException("unclosed str");
        } else if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 1 + 1) != 'l' || charAt(this.bp + 1 + 2) != 'l') {
            this.matchStat = -1;
            return null;
        } else if (charAt(this.bp + 4) == c) {
            int i9 = this.bp + 5;
            this.bp = i9;
            this.ch = charAt(i9);
            this.matchStat = 3;
            return null;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(this.bp + i);
            if (charAt == '\"') {
                int i3 = i2 + 1;
                char charAt2 = charAt(this.bp + i2);
                if (charAt2 == ',') {
                    int i4 = this.bp + i3;
                    this.bp = i4;
                    this.ch = charAt(i4);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    int i5 = i3 + 1;
                    char charAt3 = charAt(this.bp + i3);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i6 = this.bp + i5;
                        this.bp = i6;
                        this.ch = charAt(i6);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i7 = this.bp + i5;
                        this.bp = i7;
                        this.ch = charAt(i7);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i8 = this.bp + i5;
                        this.bp = i8;
                        this.ch = charAt(i8);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i5 - 1;
                        this.ch = JSONLexer.EOI;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                    this.matchStat = 4;
                    return j;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            } else {
                j = (j ^ ((long) charAt)) * 1099511628211L;
                if (charAt == '\\') {
                    this.matchStat = -1;
                    return 0;
                }
                i = i2;
            }
        }
    }

    public long scanEnumSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(this.bp + i);
            if (charAt == '\"') {
                int i3 = i2 + 1;
                char charAt2 = charAt(this.bp + i2);
                if (charAt2 == ',') {
                    int i4 = this.bp + i3;
                    this.bp = i4;
                    this.ch = charAt(i4);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    int i5 = i3 + 1;
                    char charAt3 = charAt(this.bp + i3);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i6 = this.bp + i5;
                        this.bp = i6;
                        this.ch = charAt(i6);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i7 = this.bp + i5;
                        this.bp = i7;
                        this.ch = charAt(i7);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i8 = this.bp + i5;
                        this.bp = i8;
                        this.ch = charAt(i8);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i5 - 1;
                        this.ch = JSONLexer.EOI;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                    this.matchStat = 4;
                    return j;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            } else {
                j = (j ^ ((long) ((charAt < 'A' || charAt > 'Z') ? charAt : charAt + ' '))) * 1099511628211L;
                if (charAt == '\\') {
                    this.matchStat = -1;
                    return 0;
                }
                i = i2;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Enum<?> scanEnum(java.lang.Class<?> r1, com.alibaba.fastjson.parser.SymbolTable r2, char r3) {
        /*
            r0 = this;
            java.lang.String r2 = r0.scanSymbolWithSeperator(r2, r3)
            if (r2 != 0) goto L_0x0008
            r1 = 0
            return r1
        L_0x0008:
            java.lang.Enum r1 = java.lang.Enum.valueOf(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanEnum(java.lang.Class, com.alibaba.fastjson.parser.SymbolTable, char):java.lang.Enum");
    }

    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c) {
        int i = 0;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 1 + 1) != 'l' || charAt(this.bp + 1 + 2) != 'l') {
                this.matchStat = -1;
                return null;
            } else if (charAt(this.bp + 4) == c) {
                int i2 = this.bp + 5;
                this.bp = i2;
                this.ch = charAt(i2);
                this.matchStat = 3;
                return null;
            } else {
                this.matchStat = -1;
                return null;
            }
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return null;
        } else {
            int i3 = 1;
            while (true) {
                int i4 = i3 + 1;
                char charAt2 = charAt(this.bp + i3);
                if (charAt2 == '\"') {
                    int i5 = this.bp;
                    int i6 = i5 + 0 + 1;
                    String addSymbol = addSymbol(i6, ((i5 + i4) - i6) - 1, i, symbolTable);
                    int i7 = i4 + 1;
                    char charAt3 = charAt(this.bp + i4);
                    while (charAt3 != c) {
                        if (isWhitespace(charAt3)) {
                            charAt3 = charAt(this.bp + i7);
                            i7++;
                        } else {
                            this.matchStat = -1;
                            return addSymbol;
                        }
                    }
                    int i8 = this.bp + i7;
                    this.bp = i8;
                    this.ch = charAt(i8);
                    this.matchStat = 3;
                    return addSymbol;
                }
                i = (i * 31) + charAt2;
                if (charAt2 == '\\') {
                    this.matchStat = -1;
                    return null;
                }
                i3 = i4;
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

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00fa, code lost:
        if (r12 != ',') goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00fc, code lost:
        r12 = r11.bp + r1;
        r11.bp = r12;
        r11.ch = charAt(r12);
        r11.matchStat = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x010a, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010d, code lost:
        if (r12 != '}') goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010f, code lost:
        r6 = r1 + 1;
        r12 = charAt(r11.bp + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0118, code lost:
        if (r12 != ',') goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011a, code lost:
        r11.token = 16;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012a, code lost:
        if (r12 != ']') goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012c, code lost:
        r11.token = 15;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x013c, code lost:
        if (r12 != '}') goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013e, code lost:
        r11.token = 13;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0150, code lost:
        if (r12 != 26) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0152, code lost:
        r11.bp += r6 - 1;
        r11.token = 20;
        r11.ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x015f, code lost:
        r11.matchStat = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0162, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0163, code lost:
        r11.matchStat = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0165, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0166, code lost:
        r11.matchStat = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0168, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0169  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r12, java.lang.Class<?> r13) {
        /*
            r11 = this;
            r0 = 0
            r11.matchStat = r0
            boolean r1 = r11.charArrayCompare(r12)
            r2 = 0
            if (r1 != 0) goto L_0x000e
            r12 = -2
            r11.matchStat = r12
            return r2
        L_0x000e:
            java.util.Collection r13 = r11.newCollectionByType(r13)
            int r12 = r12.length
            int r1 = r11.bp
            int r3 = r12 + 1
            int r1 = r1 + r12
            char r12 = r11.charAt(r1)
            r1 = 91
            r4 = -1
            if (r12 == r1) goto L_0x0024
            r11.matchStat = r4
            return r2
        L_0x0024:
            int r12 = r11.bp
            int r1 = r3 + 1
            int r12 = r12 + r3
            char r12 = r11.charAt(r12)
        L_0x002d:
            r3 = 44
            r5 = 93
            r6 = 34
            if (r12 != r6) goto L_0x0095
            int r12 = r11.bp
            int r12 = r12 + r1
            int r12 = r11.indexOf(r6, r12)
            if (r12 == r4) goto L_0x008d
            int r7 = r11.bp
            int r7 = r7 + r1
            int r8 = r12 - r7
            java.lang.String r7 = r11.subString(r7, r8)
            r8 = 92
            int r9 = r7.indexOf(r8)
            if (r9 == r4) goto L_0x007a
        L_0x004f:
            int r7 = r12 + -1
            r9 = r0
        L_0x0052:
            if (r7 < 0) goto L_0x005f
            char r10 = r11.charAt(r7)
            if (r10 != r8) goto L_0x005f
            int r9 = r9 + 1
            int r7 = r7 + -1
            goto L_0x0052
        L_0x005f:
            int r9 = r9 % 2
            if (r9 != 0) goto L_0x0073
            int r6 = r11.bp
            int r7 = r6 + r1
            int r7 = r12 - r7
            int r6 = r6 + r1
            char[] r6 = r11.sub_chars(r6, r7)
            java.lang.String r7 = readString(r6, r7)
            goto L_0x007a
        L_0x0073:
            int r12 = r12 + 1
            int r12 = r11.indexOf(r6, r12)
            goto L_0x004f
        L_0x007a:
            int r6 = r11.bp
            int r8 = r6 + r1
            int r12 = r12 - r8
            int r12 = r12 + 1
            int r1 = r1 + r12
            int r12 = r1 + 1
            int r6 = r6 + r1
            char r1 = r11.charAt(r6)
            r13.add(r7)
            goto L_0x00cb
        L_0x008d:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            java.lang.String r13 = "unclosed str"
            r12.<init>(r13)
            throw r12
        L_0x0095:
            r6 = 110(0x6e, float:1.54E-43)
            if (r12 != r6) goto L_0x00e8
            int r6 = r11.bp
            int r6 = r6 + r1
            char r6 = r11.charAt(r6)
            r7 = 117(0x75, float:1.64E-43)
            if (r6 != r7) goto L_0x00e8
            int r6 = r11.bp
            int r6 = r6 + r1
            int r6 = r6 + 1
            char r6 = r11.charAt(r6)
            r7 = 108(0x6c, float:1.51E-43)
            if (r6 != r7) goto L_0x00e8
            int r6 = r11.bp
            int r6 = r6 + r1
            int r6 = r6 + 2
            char r6 = r11.charAt(r6)
            if (r6 != r7) goto L_0x00e8
            int r1 = r1 + 3
            int r12 = r11.bp
            int r6 = r1 + 1
            int r12 = r12 + r1
            char r1 = r11.charAt(r12)
            r13.add(r2)
            r12 = r6
        L_0x00cb:
            if (r1 != r3) goto L_0x00d9
            int r1 = r11.bp
            int r3 = r12 + 1
            int r1 = r1 + r12
            char r12 = r11.charAt(r1)
            r1 = r3
            goto L_0x002d
        L_0x00d9:
            if (r1 != r5) goto L_0x00e5
            int r0 = r11.bp
            int r1 = r12 + 1
            int r0 = r0 + r12
            char r12 = r11.charAt(r0)
            goto L_0x00fa
        L_0x00e5:
            r11.matchStat = r4
            return r2
        L_0x00e8:
            if (r12 != r5) goto L_0x0169
            int r12 = r13.size()
            if (r12 != 0) goto L_0x0169
            int r12 = r11.bp
            int r0 = r1 + 1
            int r12 = r12 + r1
            char r12 = r11.charAt(r12)
            r1 = r0
        L_0x00fa:
            if (r12 != r3) goto L_0x010b
            int r12 = r11.bp
            int r12 = r12 + r1
            r11.bp = r12
            char r12 = r11.charAt(r12)
            r11.ch = r12
            r12 = 3
            r11.matchStat = r12
            return r13
        L_0x010b:
            r0 = 125(0x7d, float:1.75E-43)
            if (r12 != r0) goto L_0x0166
            int r12 = r11.bp
            int r6 = r1 + 1
            int r12 = r12 + r1
            char r12 = r11.charAt(r12)
            if (r12 != r3) goto L_0x012a
            r12 = 16
            r11.token = r12
            int r12 = r11.bp
            int r12 = r12 + r6
            r11.bp = r12
            char r12 = r11.charAt(r12)
            r11.ch = r12
            goto L_0x015f
        L_0x012a:
            if (r12 != r5) goto L_0x013c
            r12 = 15
            r11.token = r12
            int r12 = r11.bp
            int r12 = r12 + r6
            r11.bp = r12
            char r12 = r11.charAt(r12)
            r11.ch = r12
            goto L_0x015f
        L_0x013c:
            if (r12 != r0) goto L_0x014e
            r12 = 13
            r11.token = r12
            int r12 = r11.bp
            int r12 = r12 + r6
            r11.bp = r12
            char r12 = r11.charAt(r12)
            r11.ch = r12
            goto L_0x015f
        L_0x014e:
            r0 = 26
            if (r12 != r0) goto L_0x0163
            int r12 = r11.bp
            int r6 = r6 + -1
            int r12 = r12 + r6
            r11.bp = r12
            r12 = 20
            r11.token = r12
            r11.ch = r0
        L_0x015f:
            r12 = 4
            r11.matchStat = r12
            return r13
        L_0x0163:
            r11.matchStat = r4
            return r2
        L_0x0166:
            r11.matchStat = r4
            return r2
        L_0x0169:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            java.lang.String r13 = "illega str"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    public void scanStringArray(Collection<String> collection, char c) {
        int i;
        char c2;
        int i2;
        char c3;
        Collection<String> collection2 = collection;
        char c4 = c;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        char c5 = 'u';
        char c6 = 'n';
        if (charAt == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l' && charAt(this.bp + 1 + 3) == c4) {
            int i3 = this.bp + 5;
            this.bp = i3;
            this.ch = charAt(i3);
            this.matchStat = 5;
        } else if (charAt != '[') {
            this.matchStat = -1;
        } else {
            char charAt2 = charAt(this.bp + 1);
            int i4 = 2;
            while (true) {
                if (charAt2 != c6 || charAt(this.bp + i4) != c5 || charAt(this.bp + i4 + 1) != 'l' || charAt(this.bp + i4 + 2) != 'l') {
                    if (charAt2 == ']' && collection.size() == 0) {
                        i = i4 + 1;
                        c2 = charAt(this.bp + i4);
                        break;
                    } else if (charAt2 != '\"') {
                        this.matchStat = -1;
                        return;
                    } else {
                        int i5 = this.bp + i4;
                        int indexOf = indexOf('\"', i5);
                        if (indexOf != -1) {
                            String subString = subString(this.bp + i4, indexOf - i5);
                            if (subString.indexOf(92) != -1) {
                                while (true) {
                                    int i6 = indexOf - 1;
                                    int i7 = 0;
                                    while (i6 >= 0 && charAt(i6) == '\\') {
                                        i7++;
                                        i6--;
                                    }
                                    if (i7 % 2 == 0) {
                                        break;
                                    }
                                    indexOf = indexOf('\"', indexOf + 1);
                                }
                                int i8 = indexOf - i5;
                                subString = readString(sub_chars(this.bp + i4, i8), i8);
                            }
                            int i9 = this.bp;
                            int i10 = i4 + (indexOf - (i9 + i4)) + 1;
                            i2 = i10 + 1;
                            c3 = charAt(i9 + i10);
                            collection2.add(subString);
                        } else {
                            throw new JSONException("unclosed str");
                        }
                    }
                } else {
                    int i11 = i4 + 3;
                    i2 = i11 + 1;
                    c3 = charAt(this.bp + i11);
                    collection2.add((Object) null);
                }
                if (c3 == ',') {
                    i4 = i2 + 1;
                    charAt2 = charAt(this.bp + i2);
                    c5 = 'u';
                    c6 = 'n';
                } else if (c3 == ']') {
                    i = i2 + 1;
                    c2 = charAt(this.bp + i2);
                } else {
                    this.matchStat = -1;
                    return;
                }
            }
            if (c2 == c4) {
                int i12 = this.bp + i;
                this.bp = i12;
                this.ch = charAt(i12);
                this.matchStat = 3;
                return;
            }
            this.matchStat = -1;
        }
    }

    public int scanFieldInt(char[] cArr) {
        int i;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.bp + length);
        boolean z = charAt2 == '-';
        if (z) {
            charAt2 = charAt(this.bp + i2);
            i2++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i3 = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.bp + i2);
            if (charAt >= '0' && charAt <= '9') {
                i3 = (i3 * 10) + (charAt - '0');
                i2 = i;
            }
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if ((i3 < 0 || i > cArr.length + 14) && !(i3 == Integer.MIN_VALUE && i == 17 && z)) {
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            int i4 = this.bp + i;
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return z ? -i3 : i3;
        } else if (charAt == '}') {
            int i5 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i6 = this.bp + i5;
                this.bp = i6;
                this.ch = charAt(i6);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i7 = this.bp + i5;
                this.bp = i7;
                this.ch = charAt(i7);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i8 = this.bp + i5;
                this.bp = i8;
                this.ch = charAt(i8);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i5 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            return z ? -i3 : i3;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public final int[] scanFieldIntArray(char[] cArr) {
        int i;
        int i2;
        char c;
        boolean z;
        int i3;
        char charAt;
        this.matchStat = 0;
        int[] iArr = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i4 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i5 = i4 + 1;
        char charAt2 = charAt(this.bp + i4);
        int[] iArr2 = new int[16];
        if (charAt2 == ']') {
            i = i5 + 1;
            c = charAt(this.bp + i5);
            i2 = 0;
        } else {
            int i6 = 0;
            while (true) {
                if (charAt2 == '-') {
                    charAt2 = charAt(this.bp + i5);
                    i5++;
                    z = true;
                } else {
                    z = false;
                }
                if (charAt2 < '0' || charAt2 > '9') {
                    int[] iArr3 = iArr;
                    this.matchStat = -1;
                } else {
                    int i7 = charAt2 - '0';
                    while (true) {
                        i3 = i5 + 1;
                        charAt = charAt(this.bp + i5);
                        if (charAt >= '0' && charAt <= '9') {
                            i7 = (i7 * 10) + (charAt - '0');
                            i5 = i3;
                        }
                    }
                    if (i6 >= iArr2.length) {
                        int[] iArr4 = new int[((iArr2.length * 3) / 2)];
                        System.arraycopy(iArr2, 0, iArr4, 0, i6);
                        iArr2 = iArr4;
                    }
                    i2 = i6 + 1;
                    if (z) {
                        i7 = -i7;
                    }
                    iArr2[i6] = i7;
                    if (charAt == ',') {
                        i3++;
                        charAt = charAt(this.bp + i3);
                    } else if (charAt == ']') {
                        i = i3 + 1;
                        c = charAt(this.bp + i3);
                        break;
                    }
                    i6 = i2;
                    iArr = null;
                    charAt2 = charAt;
                    i5 = i3;
                }
            }
            int[] iArr32 = iArr;
            this.matchStat = -1;
            return iArr32;
        }
        if (i2 != iArr2.length) {
            int[] iArr5 = new int[i2];
            System.arraycopy(iArr2, 0, iArr5, 0, i2);
            iArr2 = iArr5;
        }
        if (c == ',') {
            this.bp += i - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr2;
        } else if (c == '}') {
            int i8 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                this.bp += i8 - 1;
                next();
            } else if (charAt3 == ']') {
                this.token = 15;
                this.bp += i8 - 1;
                next();
            } else if (charAt3 == '}') {
                this.token = 13;
                this.bp += i8 - 1;
                next();
            } else if (charAt3 == 26) {
                this.bp += i8 - 1;
                this.token = 20;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return iArr2;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scanBoolean(char r10) {
        /*
            r9 = this;
            r0 = 0
            r9.matchStat = r0
            int r1 = r9.bp
            int r1 = r1 + r0
            char r1 = r9.charAt(r1)
            r2 = 3
            r3 = 5
            r4 = 101(0x65, float:1.42E-43)
            r5 = -1
            r6 = 2
            r7 = 1
            r8 = 116(0x74, float:1.63E-43)
            if (r1 != r8) goto L_0x0042
            int r1 = r9.bp
            int r1 = r1 + r7
            char r1 = r9.charAt(r1)
            r8 = 114(0x72, float:1.6E-43)
            if (r1 != r8) goto L_0x003f
            int r1 = r9.bp
            int r1 = r1 + r7
            int r1 = r1 + r7
            char r1 = r9.charAt(r1)
            r8 = 117(0x75, float:1.64E-43)
            if (r1 != r8) goto L_0x003f
            int r1 = r9.bp
            int r1 = r1 + r7
            int r1 = r1 + r6
            char r1 = r9.charAt(r1)
            if (r1 != r4) goto L_0x003f
            int r0 = r9.bp
            int r0 = r0 + 4
            char r1 = r9.charAt(r0)
            goto L_0x008b
        L_0x003f:
            r9.matchStat = r5
            return r0
        L_0x0042:
            r8 = 102(0x66, float:1.43E-43)
            if (r1 != r8) goto L_0x007f
            int r1 = r9.bp
            int r1 = r1 + r7
            char r1 = r9.charAt(r1)
            r8 = 97
            if (r1 != r8) goto L_0x007c
            int r1 = r9.bp
            int r1 = r1 + r7
            int r1 = r1 + r7
            char r1 = r9.charAt(r1)
            r8 = 108(0x6c, float:1.51E-43)
            if (r1 != r8) goto L_0x007c
            int r1 = r9.bp
            int r1 = r1 + r7
            int r1 = r1 + r6
            char r1 = r9.charAt(r1)
            r6 = 115(0x73, float:1.61E-43)
            if (r1 != r6) goto L_0x007c
            int r1 = r9.bp
            int r1 = r1 + r7
            int r1 = r1 + r2
            char r1 = r9.charAt(r1)
            if (r1 != r4) goto L_0x007c
            int r1 = r9.bp
            r4 = 6
            int r1 = r1 + r3
            char r1 = r9.charAt(r1)
            goto L_0x00ba
        L_0x007c:
            r9.matchStat = r5
            return r0
        L_0x007f:
            r3 = 49
            if (r1 != r3) goto L_0x008d
            int r0 = r9.bp
            int r0 = r0 + r7
            char r1 = r9.charAt(r0)
            r3 = r6
        L_0x008b:
            r0 = r7
            goto L_0x009b
        L_0x008d:
            r3 = 48
            if (r1 != r3) goto L_0x009a
            int r1 = r9.bp
            int r1 = r1 + r7
            char r1 = r9.charAt(r1)
            r3 = r6
            goto L_0x009b
        L_0x009a:
            r3 = r7
        L_0x009b:
            if (r1 != r10) goto L_0x00ab
            int r10 = r9.bp
            int r10 = r10 + r3
            r9.bp = r10
            char r10 = r9.charAt(r10)
            r9.ch = r10
            r9.matchStat = r2
            return r0
        L_0x00ab:
            boolean r1 = isWhitespace(r1)
            if (r1 == 0) goto L_0x00bc
            int r1 = r9.bp
            int r4 = r3 + 1
            int r1 = r1 + r3
            char r1 = r9.charAt(r1)
        L_0x00ba:
            r3 = r4
            goto L_0x009b
        L_0x00bc:
            r9.matchStat = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanBoolean(char):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int scanInt(char r14) {
        /*
            r13 = this;
            r0 = 0
            r13.matchStat = r0
            int r1 = r13.bp
            int r1 = r1 + r0
            char r1 = r13.charAt(r1)
            r2 = 34
            r3 = 1
            if (r1 != r2) goto L_0x0011
            r4 = r3
            goto L_0x0012
        L_0x0011:
            r4 = r0
        L_0x0012:
            r5 = 2
            if (r4 == 0) goto L_0x001e
            int r1 = r13.bp
            int r1 = r1 + r3
            char r1 = r13.charAt(r1)
            r6 = r5
            goto L_0x001f
        L_0x001e:
            r6 = r3
        L_0x001f:
            r7 = 45
            if (r1 != r7) goto L_0x0025
            r7 = r3
            goto L_0x0026
        L_0x0025:
            r7 = r0
        L_0x0026:
            if (r7 == 0) goto L_0x0032
            int r1 = r13.bp
            int r8 = r6 + 1
            int r1 = r1 + r6
            char r1 = r13.charAt(r1)
            r6 = r8
        L_0x0032:
            r8 = 16
            r9 = 3
            r10 = 48
            r11 = -1
            if (r1 < r10) goto L_0x008c
            r12 = 57
            if (r1 > r12) goto L_0x008c
            int r1 = r1 - r10
        L_0x003f:
            int r2 = r13.bp
            int r3 = r6 + 1
            int r2 = r2 + r6
            char r2 = r13.charAt(r2)
            if (r2 < r10) goto L_0x0053
            if (r2 > r12) goto L_0x0053
            int r1 = r1 * 10
            int r2 = r2 + -48
            int r1 = r1 + r2
            r6 = r3
            goto L_0x003f
        L_0x0053:
            r4 = 46
            if (r2 != r4) goto L_0x005a
            r13.matchStat = r11
            return r0
        L_0x005a:
            if (r1 >= 0) goto L_0x005f
            r13.matchStat = r11
            return r0
        L_0x005f:
            if (r2 != r14) goto L_0x0074
            int r14 = r13.bp
            int r14 = r14 + r3
            r13.bp = r14
            char r14 = r13.charAt(r14)
            r13.ch = r14
            r13.matchStat = r9
            r13.token = r8
            if (r7 == 0) goto L_0x0073
            int r1 = -r1
        L_0x0073:
            return r1
        L_0x0074:
            boolean r0 = isWhitespace(r2)
            if (r0 == 0) goto L_0x0086
            int r0 = r13.bp
            int r2 = r3 + 1
            int r0 = r0 + r3
            char r0 = r13.charAt(r0)
            r3 = r2
            r2 = r0
            goto L_0x005f
        L_0x0086:
            r13.matchStat = r11
            if (r7 == 0) goto L_0x008b
            int r1 = -r1
        L_0x008b:
            return r1
        L_0x008c:
            r14 = 110(0x6e, float:1.54E-43)
            if (r1 != r14) goto L_0x0109
            int r14 = r13.bp
            int r14 = r14 + r6
            char r14 = r13.charAt(r14)
            r1 = 117(0x75, float:1.64E-43)
            if (r14 != r1) goto L_0x0109
            int r14 = r13.bp
            int r14 = r14 + r6
            int r14 = r14 + r3
            char r14 = r13.charAt(r14)
            r1 = 108(0x6c, float:1.51E-43)
            if (r14 != r1) goto L_0x0109
            int r14 = r13.bp
            int r14 = r14 + r6
            int r14 = r14 + r5
            char r14 = r13.charAt(r14)
            if (r14 != r1) goto L_0x0109
            r14 = 5
            r13.matchStat = r14
            int r6 = r6 + r9
            int r1 = r13.bp
            int r3 = r6 + 1
            int r1 = r1 + r6
            char r1 = r13.charAt(r1)
            if (r4 == 0) goto L_0x00cc
            if (r1 != r2) goto L_0x00cc
            int r1 = r13.bp
            int r2 = r3 + 1
            int r1 = r1 + r3
            char r1 = r13.charAt(r1)
        L_0x00cb:
            r3 = r2
        L_0x00cc:
            r2 = 44
            if (r1 != r2) goto L_0x00e0
            int r1 = r13.bp
            int r1 = r1 + r3
            r13.bp = r1
            char r1 = r13.charAt(r1)
            r13.ch = r1
            r13.matchStat = r14
            r13.token = r8
            return r0
        L_0x00e0:
            r2 = 93
            if (r1 != r2) goto L_0x00f6
            int r1 = r13.bp
            int r1 = r1 + r3
            r13.bp = r1
            char r1 = r13.charAt(r1)
            r13.ch = r1
            r13.matchStat = r14
            r14 = 15
            r13.token = r14
            return r0
        L_0x00f6:
            boolean r1 = isWhitespace(r1)
            if (r1 == 0) goto L_0x0106
            int r1 = r13.bp
            int r2 = r3 + 1
            int r1 = r1 + r3
            char r1 = r13.charAt(r1)
            goto L_0x00cb
        L_0x0106:
            r13.matchStat = r11
            return r0
        L_0x0109:
            r13.matchStat = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanInt(char):int");
    }

    public boolean scanFieldBoolean(char[] cArr) {
        boolean z;
        int i;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt = charAt(this.bp + length);
        if (charAt == 't') {
            int i3 = i2 + 1;
            if (charAt(this.bp + i2) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i4 = i3 + 1;
            if (charAt(this.bp + i3) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i = i4 + 1;
            if (charAt(this.bp + i4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z = true;
        } else if (charAt == 'f') {
            int i5 = i2 + 1;
            if (charAt(this.bp + i2) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i6 = i5 + 1;
            if (charAt(this.bp + i5) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i7 = i6 + 1;
            if (charAt(this.bp + i6) != 's') {
                this.matchStat = -1;
                return false;
            }
            int i8 = i7 + 1;
            if (charAt(this.bp + i7) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z = false;
            i = i8;
        } else {
            this.matchStat = -1;
            return false;
        }
        int i9 = i + 1;
        char charAt2 = charAt(this.bp + i);
        if (charAt2 == ',') {
            int i10 = this.bp + i9;
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 3;
            this.token = 16;
            return z;
        } else if (charAt2 == '}') {
            int i11 = i9 + 1;
            char charAt3 = charAt(this.bp + i9);
            if (charAt3 == ',') {
                this.token = 16;
                int i12 = this.bp + i11;
                this.bp = i12;
                this.ch = charAt(i12);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i13 = this.bp + i11;
                this.bp = i13;
                this.ch = charAt(i13);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i14 = this.bp + i11;
                this.bp = i14;
                this.ch = charAt(i14);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i11 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return false;
            }
            this.matchStat = 4;
            return z;
        } else {
            this.matchStat = -1;
            return false;
        }
    }

    public long scanFieldLong(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        char[] cArr2 = cArr;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr2.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '-') {
            charAt2 = charAt(this.bp + i2);
            i2++;
            z = true;
        } else {
            z = false;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        long j = (long) (charAt2 - '0');
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.bp + i2);
            if (charAt >= '0' && charAt <= '9') {
                j = (j * 10) + ((long) (charAt - '0'));
                i2 = i;
            }
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (!(i - cArr2.length < 21 && (j >= 0 || (j == Long.MIN_VALUE && z)))) {
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            int i3 = this.bp + i;
            this.bp = i3;
            this.ch = charAt(i3);
            this.matchStat = 3;
            this.token = 16;
            return z ? -j : j;
        } else if (charAt == '}') {
            int i4 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i5 = this.bp + i4;
                this.bp = i5;
                this.ch = charAt(i5);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i6 = this.bp + i4;
                this.bp = i6;
                this.ch = charAt(i6);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i7 = this.bp + i4;
                this.bp = i7;
                this.ch = charAt(i7);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i4 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            return z ? -j : j;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long scanLong(char r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = 0
            r0.matchStat = r1
            int r2 = r0.bp
            int r2 = r2 + r1
            char r2 = r0.charAt(r2)
            r3 = 34
            r4 = 1
            if (r2 != r3) goto L_0x0013
            r5 = r4
            goto L_0x0014
        L_0x0013:
            r5 = r1
        L_0x0014:
            r6 = 2
            if (r5 == 0) goto L_0x0020
            int r2 = r0.bp
            int r2 = r2 + r4
            char r2 = r0.charAt(r2)
            r7 = r6
            goto L_0x0021
        L_0x0020:
            r7 = r4
        L_0x0021:
            r8 = 45
            if (r2 != r8) goto L_0x0027
            r8 = r4
            goto L_0x0028
        L_0x0027:
            r8 = r1
        L_0x0028:
            if (r8 == 0) goto L_0x0034
            int r2 = r0.bp
            int r9 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            r7 = r9
        L_0x0034:
            r9 = 16
            r10 = 3
            r11 = 48
            r12 = -1
            r13 = 0
            if (r2 < r11) goto L_0x00c9
            r15 = 57
            if (r2 > r15) goto L_0x00c9
            int r2 = r2 - r11
            long r1 = (long) r2
        L_0x0044:
            int r6 = r0.bp
            int r17 = r7 + 1
            int r6 = r6 + r7
            char r6 = r0.charAt(r6)
            if (r6 < r11) goto L_0x005c
            if (r6 > r15) goto L_0x005c
            r18 = 10
            long r1 = r1 * r18
            int r6 = r6 + -48
            long r6 = (long) r6
            long r1 = r1 + r6
            r7 = r17
            goto L_0x0044
        L_0x005c:
            r7 = 46
            if (r6 != r7) goto L_0x0063
            r0.matchStat = r12
            return r13
        L_0x0063:
            int r7 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r7 >= 0) goto L_0x0073
            r18 = -9223372036854775808
            int r7 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r7 != 0) goto L_0x0070
            if (r8 == 0) goto L_0x0070
            goto L_0x0073
        L_0x0070:
            r16 = 0
            goto L_0x0075
        L_0x0073:
            r16 = r4
        L_0x0075:
            if (r16 == 0) goto L_0x00bb
            if (r5 == 0) goto L_0x008d
            if (r6 == r3) goto L_0x007e
            r0.matchStat = r12
            return r13
        L_0x007e:
            int r3 = r0.bp
            int r4 = r17 + 1
            int r3 = r3 + r17
            char r6 = r0.charAt(r3)
            r3 = r21
            r17 = r4
            goto L_0x008f
        L_0x008d:
            r3 = r21
        L_0x008f:
            if (r6 != r3) goto L_0x00a5
            int r3 = r0.bp
            int r3 = r3 + r17
            r0.bp = r3
            char r3 = r0.charAt(r3)
            r0.ch = r3
            r0.matchStat = r10
            r0.token = r9
            if (r8 == 0) goto L_0x00a4
            long r1 = -r1
        L_0x00a4:
            return r1
        L_0x00a5:
            boolean r4 = isWhitespace(r6)
            if (r4 == 0) goto L_0x00b8
            int r4 = r0.bp
            int r5 = r17 + 1
            int r4 = r4 + r17
            char r6 = r0.charAt(r4)
            r17 = r5
            goto L_0x008f
        L_0x00b8:
            r0.matchStat = r12
            return r1
        L_0x00bb:
            int r1 = r0.bp
            int r2 = r17 + -1
            java.lang.String r1 = r0.subString(r1, r2)
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            r2.<init>(r1)
            throw r2
        L_0x00c9:
            r1 = 110(0x6e, float:1.54E-43)
            if (r2 != r1) goto L_0x0146
            int r1 = r0.bp
            int r1 = r1 + r7
            char r1 = r0.charAt(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L_0x0146
            int r1 = r0.bp
            int r1 = r1 + r7
            int r1 = r1 + r4
            char r1 = r0.charAt(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L_0x0146
            int r1 = r0.bp
            int r1 = r1 + r7
            int r1 = r1 + r6
            char r1 = r0.charAt(r1)
            if (r1 != r2) goto L_0x0146
            r1 = 5
            r0.matchStat = r1
            int r7 = r7 + r10
            int r2 = r0.bp
            int r4 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            if (r5 == 0) goto L_0x0109
            if (r2 != r3) goto L_0x0109
            int r2 = r0.bp
            int r3 = r4 + 1
            int r2 = r2 + r4
            char r2 = r0.charAt(r2)
        L_0x0108:
            r4 = r3
        L_0x0109:
            r3 = 44
            if (r2 != r3) goto L_0x011d
            int r2 = r0.bp
            int r2 = r2 + r4
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r0.token = r9
            return r13
        L_0x011d:
            r3 = 93
            if (r2 != r3) goto L_0x0133
            int r2 = r0.bp
            int r2 = r2 + r4
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r1 = 15
            r0.token = r1
            return r13
        L_0x0133:
            boolean r2 = isWhitespace(r2)
            if (r2 == 0) goto L_0x0143
            int r2 = r0.bp
            int r3 = r4 + 1
            int r2 = r2 + r4
            char r2 = r0.charAt(r2)
            goto L_0x0108
        L_0x0143:
            r0.matchStat = r12
            return r13
        L_0x0146:
            r0.matchStat = r12
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanLong(char):long");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final float scanFieldFloat(char[] r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = 0
            r0.matchStat = r2
            boolean r3 = r21.charArrayCompare(r22)
            r4 = 0
            if (r3 != 0) goto L_0x0012
            r1 = -2
            r0.matchStat = r1
            return r4
        L_0x0012:
            int r3 = r1.length
            int r5 = r0.bp
            int r6 = r3 + 1
            int r5 = r5 + r3
            char r3 = r0.charAt(r5)
            r5 = 34
            if (r3 != r5) goto L_0x0022
            r8 = 1
            goto L_0x0023
        L_0x0022:
            r8 = r2
        L_0x0023:
            if (r8 == 0) goto L_0x002f
            int r3 = r0.bp
            int r9 = r6 + 1
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            r6 = r9
        L_0x002f:
            r9 = 45
            if (r3 != r9) goto L_0x0035
            r10 = 1
            goto L_0x0036
        L_0x0035:
            r10 = r2
        L_0x0036:
            if (r10 == 0) goto L_0x0042
            int r3 = r0.bp
            int r11 = r6 + 1
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            r6 = r11
        L_0x0042:
            r2 = -1
            r11 = 48
            if (r3 < r11) goto L_0x01a5
            r14 = 57
            if (r3 > r14) goto L_0x01a5
            int r3 = r3 - r11
            long r12 = (long) r3
        L_0x004d:
            int r3 = r0.bp
            int r17 = r6 + 1
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            r18 = 10
            if (r3 < r11) goto L_0x0067
            if (r3 > r14) goto L_0x0067
            long r12 = r12 * r18
            int r3 = r3 + -48
            long r5 = (long) r3
            long r12 = r12 + r5
            r6 = r17
            r5 = 34
            goto L_0x004d
        L_0x0067:
            r5 = 46
            if (r3 != r5) goto L_0x006d
            r5 = 1
            goto L_0x006e
        L_0x006d:
            r5 = 0
        L_0x006e:
            if (r5 == 0) goto L_0x00a4
            int r3 = r0.bp
            int r5 = r17 + 1
            int r3 = r3 + r17
            char r3 = r0.charAt(r3)
            if (r3 < r11) goto L_0x00a1
            if (r3 > r14) goto L_0x00a1
            long r12 = r12 * r18
            int r3 = r3 - r11
            r20 = r8
            long r7 = (long) r3
            long r12 = r12 + r7
            r6 = r18
        L_0x0087:
            int r3 = r0.bp
            int r17 = r5 + 1
            int r3 = r3 + r5
            char r3 = r0.charAt(r3)
            if (r3 < r11) goto L_0x00a8
            if (r3 > r14) goto L_0x00a8
            long r12 = r12 * r18
            int r3 = r3 + -48
            long r14 = (long) r3
            long r12 = r12 + r14
            long r6 = r6 * r18
            r5 = r17
            r14 = 57
            goto L_0x0087
        L_0x00a1:
            r0.matchStat = r2
            return r4
        L_0x00a4:
            r20 = r8
            r6 = 1
        L_0x00a8:
            r14 = 101(0x65, float:1.42E-43)
            if (r3 == r14) goto L_0x00b4
            r14 = 69
            if (r3 != r14) goto L_0x00b1
            goto L_0x00b4
        L_0x00b1:
            r16 = 0
            goto L_0x00b6
        L_0x00b4:
            r16 = 1
        L_0x00b6:
            if (r16 == 0) goto L_0x00e8
            int r3 = r0.bp
            int r14 = r17 + 1
            int r3 = r3 + r17
            char r3 = r0.charAt(r3)
            r15 = 43
            if (r3 == r15) goto L_0x00cc
            if (r3 != r9) goto L_0x00c9
            goto L_0x00cc
        L_0x00c9:
            r17 = r14
            goto L_0x00d7
        L_0x00cc:
            int r3 = r0.bp
            int r9 = r14 + 1
            int r3 = r3 + r14
            char r3 = r0.charAt(r3)
        L_0x00d5:
            r17 = r9
        L_0x00d7:
            if (r3 < r11) goto L_0x00e8
            r8 = 57
            if (r3 > r8) goto L_0x00e8
            int r3 = r0.bp
            int r9 = r17 + 1
            int r3 = r3 + r17
            char r3 = r0.charAt(r3)
            goto L_0x00d5
        L_0x00e8:
            if (r20 == 0) goto L_0x0108
            r8 = 34
            if (r3 == r8) goto L_0x00f1
            r0.matchStat = r2
            return r4
        L_0x00f1:
            int r3 = r0.bp
            int r8 = r17 + 1
            int r3 = r3 + r17
            char r3 = r0.charAt(r3)
            int r9 = r0.bp
            int r1 = r1.length
            int r1 = r1 + r9
            r11 = 1
            int r1 = r1 + r11
            int r9 = r9 + r8
            int r9 = r9 - r1
            int r9 = r9 + -2
            r17 = r8
            goto L_0x0112
        L_0x0108:
            r11 = 1
            int r8 = r0.bp
            int r1 = r1.length
            int r1 = r1 + r8
            int r8 = r8 + r17
            int r8 = r8 - r1
            int r9 = r8 + -1
        L_0x0112:
            if (r16 != 0) goto L_0x0120
            r8 = 17
            if (r9 >= r8) goto L_0x0120
            double r8 = (double) r12
            double r6 = (double) r6
            double r8 = r8 / r6
            float r1 = (float) r8
            if (r10 == 0) goto L_0x0128
            float r1 = -r1
            goto L_0x0128
        L_0x0120:
            java.lang.String r1 = r0.subString(r1, r9)
            float r1 = java.lang.Float.parseFloat(r1)
        L_0x0128:
            r5 = 44
            if (r3 != r5) goto L_0x0140
            int r2 = r0.bp
            int r2 = r2 + r17
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r2 = 3
            r0.matchStat = r2
            r6 = 16
            r0.token = r6
            return r1
        L_0x0140:
            r6 = 16
            r7 = 125(0x7d, float:1.75E-43)
            if (r3 != r7) goto L_0x01a2
            int r3 = r0.bp
            int r7 = r17 + 1
            int r3 = r3 + r17
            char r3 = r0.charAt(r3)
            r5 = 44
            if (r3 != r5) goto L_0x0162
            r0.token = r6
            int r2 = r0.bp
            int r2 = r2 + r7
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            goto L_0x019b
        L_0x0162:
            r5 = 93
            if (r3 != r5) goto L_0x0176
            r2 = 15
            r0.token = r2
            int r2 = r0.bp
            int r2 = r2 + r7
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            goto L_0x019b
        L_0x0176:
            r5 = 125(0x7d, float:1.75E-43)
            if (r3 != r5) goto L_0x018a
            r5 = 13
            r0.token = r5
            int r2 = r0.bp
            int r2 = r2 + r7
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            goto L_0x019b
        L_0x018a:
            r5 = 26
            if (r3 != r5) goto L_0x019f
            int r2 = r0.bp
            r3 = 1
            int r7 = r7 - r3
            int r2 = r2 + r7
            r0.bp = r2
            r2 = 20
            r0.token = r2
            r0.ch = r5
        L_0x019b:
            r2 = 4
            r0.matchStat = r2
            return r1
        L_0x019f:
            r0.matchStat = r2
            return r4
        L_0x01a2:
            r0.matchStat = r2
            return r4
        L_0x01a5:
            r20 = r8
            r1 = 110(0x6e, float:1.54E-43)
            if (r3 != r1) goto L_0x0230
            int r1 = r0.bp
            int r1 = r1 + r6
            char r1 = r0.charAt(r1)
            r3 = 117(0x75, float:1.64E-43)
            if (r1 != r3) goto L_0x0230
            int r1 = r0.bp
            int r1 = r1 + r6
            r3 = 1
            int r1 = r1 + r3
            char r1 = r0.charAt(r1)
            r3 = 108(0x6c, float:1.51E-43)
            if (r1 != r3) goto L_0x0230
            int r1 = r0.bp
            int r1 = r1 + r6
            int r1 = r1 + 2
            char r1 = r0.charAt(r1)
            if (r1 != r3) goto L_0x0230
            r1 = 5
            r0.matchStat = r1
            r3 = 3
            int r6 = r6 + r3
            int r3 = r0.bp
            int r7 = r6 + 1
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            if (r20 == 0) goto L_0x01ec
            r6 = 34
            if (r3 != r6) goto L_0x01ec
            int r3 = r0.bp
            int r6 = r7 + 1
            int r3 = r3 + r7
            char r3 = r0.charAt(r3)
            r7 = r6
        L_0x01ec:
            r5 = 44
        L_0x01ee:
            if (r3 != r5) goto L_0x0202
            int r2 = r0.bp
            int r2 = r2 + r7
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r6 = 16
            r0.token = r6
            return r4
        L_0x0202:
            r6 = 16
            r8 = 125(0x7d, float:1.75E-43)
            if (r3 != r8) goto L_0x021a
            int r2 = r0.bp
            int r2 = r2 + r7
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r9 = 13
            r0.token = r9
            return r4
        L_0x021a:
            r9 = 13
            boolean r3 = isWhitespace(r3)
            if (r3 == 0) goto L_0x022d
            int r3 = r0.bp
            int r10 = r7 + 1
            int r3 = r3 + r7
            char r3 = r0.charAt(r3)
            r7 = r10
            goto L_0x01ee
        L_0x022d:
            r0.matchStat = r2
            return r4
        L_0x0230:
            r0.matchStat = r2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloat(char[]):float");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final float scanFloat(char r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = 0
            r0.matchStat = r1
            int r2 = r0.bp
            int r2 = r2 + r1
            char r2 = r0.charAt(r2)
            r3 = 34
            r4 = 1
            if (r2 != r3) goto L_0x0013
            r5 = r4
            goto L_0x0014
        L_0x0013:
            r5 = r1
        L_0x0014:
            if (r5 == 0) goto L_0x001f
            int r2 = r0.bp
            int r2 = r2 + r4
            char r2 = r0.charAt(r2)
            r7 = 2
            goto L_0x0020
        L_0x001f:
            r7 = r4
        L_0x0020:
            r8 = 45
            if (r2 != r8) goto L_0x0026
            r9 = r4
            goto L_0x0027
        L_0x0026:
            r9 = r1
        L_0x0027:
            if (r9 == 0) goto L_0x0033
            int r2 = r0.bp
            int r10 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            r7 = r10
        L_0x0033:
            r12 = 0
            r13 = -1
            r14 = 48
            if (r2 < r14) goto L_0x0128
            r15 = 57
            if (r2 > r15) goto L_0x0128
            int r2 = r2 - r14
            long r1 = (long) r2
        L_0x003f:
            int r10 = r0.bp
            int r17 = r7 + 1
            int r10 = r10 + r7
            char r7 = r0.charAt(r10)
            r18 = 10
            if (r7 < r14) goto L_0x0057
            if (r7 > r15) goto L_0x0057
            long r1 = r1 * r18
            int r7 = r7 + -48
            long r6 = (long) r7
            long r1 = r1 + r6
            r7 = r17
            goto L_0x003f
        L_0x0057:
            r20 = 1
            r6 = 46
            if (r7 != r6) goto L_0x005f
            r6 = r4
            goto L_0x0060
        L_0x005f:
            r6 = 0
        L_0x0060:
            if (r6 == 0) goto L_0x0092
            int r6 = r0.bp
            int r7 = r17 + 1
            int r6 = r6 + r17
            char r6 = r0.charAt(r6)
            if (r6 < r14) goto L_0x008f
            if (r6 > r15) goto L_0x008f
            long r1 = r1 * r18
            int r6 = r6 - r14
            long r10 = (long) r6
            long r1 = r1 + r10
            r20 = r18
        L_0x0077:
            int r6 = r0.bp
            int r17 = r7 + 1
            int r6 = r6 + r7
            char r7 = r0.charAt(r6)
            if (r7 < r14) goto L_0x0092
            if (r7 > r15) goto L_0x0092
            long r1 = r1 * r18
            int r7 = r7 + -48
            long r6 = (long) r7
            long r1 = r1 + r6
            long r20 = r20 * r18
            r7 = r17
            goto L_0x0077
        L_0x008f:
            r0.matchStat = r13
            return r12
        L_0x0092:
            r10 = r20
            r6 = 101(0x65, float:1.42E-43)
            if (r7 == r6) goto L_0x00a0
            r6 = 69
            if (r7 != r6) goto L_0x009d
            goto L_0x00a0
        L_0x009d:
            r16 = 0
            goto L_0x00a2
        L_0x00a0:
            r16 = r4
        L_0x00a2:
            if (r16 == 0) goto L_0x00d4
            int r6 = r0.bp
            int r7 = r17 + 1
            int r6 = r6 + r17
            char r6 = r0.charAt(r6)
            r4 = 43
            if (r6 == r4) goto L_0x00b9
            if (r6 != r8) goto L_0x00b5
            goto L_0x00b9
        L_0x00b5:
            r17 = r7
            r7 = r6
            goto L_0x00c5
        L_0x00b9:
            int r4 = r0.bp
            int r6 = r7 + 1
            int r4 = r4 + r7
            char r4 = r0.charAt(r4)
            r7 = r4
        L_0x00c3:
            r17 = r6
        L_0x00c5:
            if (r7 < r14) goto L_0x00d4
            if (r7 > r15) goto L_0x00d4
            int r4 = r0.bp
            int r6 = r17 + 1
            int r4 = r4 + r17
            char r7 = r0.charAt(r4)
            goto L_0x00c3
        L_0x00d4:
            if (r5 == 0) goto L_0x00f0
            if (r7 == r3) goto L_0x00db
            r0.matchStat = r13
            return r12
        L_0x00db:
            int r3 = r0.bp
            int r4 = r17 + 1
            int r3 = r3 + r17
            char r7 = r0.charAt(r3)
            int r3 = r0.bp
            int r5 = r3 + 1
            int r3 = r3 + r4
            int r3 = r3 - r5
            r6 = 2
            int r3 = r3 - r6
            r17 = r4
            goto L_0x00f7
        L_0x00f0:
            int r5 = r0.bp
            int r3 = r5 + r17
            int r3 = r3 - r5
            r4 = 1
            int r3 = r3 - r4
        L_0x00f7:
            if (r16 != 0) goto L_0x0105
            r4 = 17
            if (r3 >= r4) goto L_0x0105
            double r1 = (double) r1
            double r3 = (double) r10
            double r1 = r1 / r3
            float r1 = (float) r1
            if (r9 == 0) goto L_0x010d
            float r1 = -r1
            goto L_0x010d
        L_0x0105:
            java.lang.String r1 = r0.subString(r5, r3)
            float r1 = java.lang.Float.parseFloat(r1)
        L_0x010d:
            r2 = r23
            if (r7 != r2) goto L_0x0125
            int r2 = r0.bp
            int r2 = r2 + r17
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r2 = 3
            r0.matchStat = r2
            r2 = 16
            r0.token = r2
            return r1
        L_0x0125:
            r0.matchStat = r13
            return r1
        L_0x0128:
            r1 = 110(0x6e, float:1.54E-43)
            if (r2 != r1) goto L_0x01ad
            int r1 = r0.bp
            int r1 = r1 + r7
            char r1 = r0.charAt(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L_0x01ad
            int r1 = r0.bp
            int r1 = r1 + r7
            r2 = 1
            int r1 = r1 + r2
            char r1 = r0.charAt(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L_0x01ad
            int r1 = r0.bp
            int r1 = r1 + r7
            r4 = 2
            int r1 = r1 + r4
            char r1 = r0.charAt(r1)
            if (r1 != r2) goto L_0x01ad
            r1 = 5
            r0.matchStat = r1
            r2 = 3
            int r7 = r7 + r2
            int r2 = r0.bp
            int r4 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            if (r5 == 0) goto L_0x016b
            if (r2 != r3) goto L_0x016b
            int r2 = r0.bp
            int r3 = r4 + 1
            int r2 = r2 + r4
            char r2 = r0.charAt(r2)
            r4 = r3
        L_0x016b:
            r3 = 44
            if (r2 != r3) goto L_0x0181
            int r2 = r0.bp
            int r2 = r2 + r4
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r3 = 16
            r0.token = r3
            return r12
        L_0x0181:
            r3 = 16
            r5 = 93
            if (r2 != r5) goto L_0x0199
            int r2 = r0.bp
            int r2 = r2 + r4
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r1 = 15
            r0.token = r1
            return r12
        L_0x0199:
            boolean r2 = isWhitespace(r2)
            if (r2 == 0) goto L_0x01aa
            int r2 = r0.bp
            int r5 = r4 + 1
            int r2 = r2 + r4
            char r2 = r0.charAt(r2)
            r4 = r5
            goto L_0x016b
        L_0x01aa:
            r0.matchStat = r13
            return r12
        L_0x01ad:
            r0.matchStat = r13
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFloat(char):float");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public double scanDouble(char r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = 0
            r0.matchStat = r1
            int r2 = r0.bp
            int r2 = r2 + r1
            char r2 = r0.charAt(r2)
            r3 = 34
            r4 = 1
            if (r2 != r3) goto L_0x0013
            r5 = r4
            goto L_0x0014
        L_0x0013:
            r5 = r1
        L_0x0014:
            if (r5 == 0) goto L_0x001f
            int r2 = r0.bp
            int r2 = r2 + r4
            char r2 = r0.charAt(r2)
            r7 = 2
            goto L_0x0020
        L_0x001f:
            r7 = r4
        L_0x0020:
            r8 = 45
            if (r2 != r8) goto L_0x0026
            r9 = r4
            goto L_0x0027
        L_0x0026:
            r9 = r1
        L_0x0027:
            if (r9 == 0) goto L_0x0033
            int r2 = r0.bp
            int r10 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            r7 = r10
        L_0x0033:
            r12 = 0
            r14 = -1
            r15 = 48
            if (r2 < r15) goto L_0x012b
            r1 = 57
            if (r2 > r1) goto L_0x012b
            int r2 = r2 - r15
            long r10 = (long) r2
        L_0x0040:
            int r2 = r0.bp
            int r17 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            r18 = 10
            if (r2 < r15) goto L_0x0058
            if (r2 > r1) goto L_0x0058
            long r10 = r10 * r18
            int r2 = r2 + -48
            long r6 = (long) r2
            long r10 = r10 + r6
            r7 = r17
            goto L_0x0040
        L_0x0058:
            r6 = 46
            if (r2 != r6) goto L_0x005e
            r6 = r4
            goto L_0x005f
        L_0x005e:
            r6 = 0
        L_0x005f:
            if (r6 == 0) goto L_0x0094
            int r2 = r0.bp
            int r6 = r17 + 1
            int r2 = r2 + r17
            char r2 = r0.charAt(r2)
            if (r2 < r15) goto L_0x0091
            if (r2 > r1) goto L_0x0091
            long r10 = r10 * r18
            int r2 = r2 - r15
            long r3 = (long) r2
            long r10 = r10 + r3
            r2 = r18
        L_0x0076:
            int r4 = r0.bp
            int r17 = r6 + 1
            int r4 = r4 + r6
            char r4 = r0.charAt(r4)
            if (r4 < r15) goto L_0x008e
            if (r4 > r1) goto L_0x008e
            long r10 = r10 * r18
            int r4 = r4 + -48
            long r6 = (long) r4
            long r10 = r10 + r6
            long r2 = r2 * r18
            r6 = r17
            goto L_0x0076
        L_0x008e:
            r6 = r2
            r2 = r4
            goto L_0x0096
        L_0x0091:
            r0.matchStat = r14
            return r12
        L_0x0094:
            r6 = 1
        L_0x0096:
            r3 = 101(0x65, float:1.42E-43)
            if (r2 == r3) goto L_0x00a2
            r3 = 69
            if (r2 != r3) goto L_0x009f
            goto L_0x00a2
        L_0x009f:
            r16 = 0
            goto L_0x00a4
        L_0x00a2:
            r16 = 1
        L_0x00a4:
            if (r16 == 0) goto L_0x00d4
            int r2 = r0.bp
            int r3 = r17 + 1
            int r2 = r2 + r17
            char r2 = r0.charAt(r2)
            r4 = 43
            if (r2 == r4) goto L_0x00ba
            if (r2 != r8) goto L_0x00b7
            goto L_0x00ba
        L_0x00b7:
            r17 = r3
            goto L_0x00c5
        L_0x00ba:
            int r2 = r0.bp
            int r4 = r3 + 1
            int r2 = r2 + r3
            char r2 = r0.charAt(r2)
            r17 = r4
        L_0x00c5:
            if (r2 < r15) goto L_0x00d4
            if (r2 > r1) goto L_0x00d4
            int r2 = r0.bp
            int r3 = r17 + 1
            int r2 = r2 + r17
            char r2 = r0.charAt(r2)
            goto L_0x00b7
        L_0x00d4:
            if (r5 == 0) goto L_0x00f3
            r1 = 34
            if (r2 == r1) goto L_0x00dd
            r0.matchStat = r14
            return r12
        L_0x00dd:
            int r1 = r0.bp
            int r2 = r17 + 1
            int r1 = r1 + r17
            char r1 = r0.charAt(r1)
            int r3 = r0.bp
            int r4 = r3 + 1
            int r3 = r3 + r2
            int r3 = r3 - r4
            r5 = 2
            int r3 = r3 - r5
            r17 = r2
            r2 = r1
            goto L_0x00fb
        L_0x00f3:
            int r4 = r0.bp
            int r1 = r4 + r17
            int r1 = r1 - r4
            r3 = 1
            int r3 = r1 + -1
        L_0x00fb:
            if (r16 != 0) goto L_0x0108
            r1 = 17
            if (r3 >= r1) goto L_0x0108
            double r3 = (double) r10
            double r5 = (double) r6
            double r3 = r3 / r5
            if (r9 == 0) goto L_0x0110
            double r3 = -r3
            goto L_0x0110
        L_0x0108:
            java.lang.String r1 = r0.subString(r4, r3)
            double r3 = java.lang.Double.parseDouble(r1)
        L_0x0110:
            r1 = r21
            if (r2 != r1) goto L_0x0128
            int r1 = r0.bp
            int r1 = r1 + r17
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            r1 = 3
            r0.matchStat = r1
            r1 = 16
            r0.token = r1
            return r3
        L_0x0128:
            r0.matchStat = r14
            return r3
        L_0x012b:
            r1 = 110(0x6e, float:1.54E-43)
            if (r2 != r1) goto L_0x01b2
            int r1 = r0.bp
            int r1 = r1 + r7
            char r1 = r0.charAt(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L_0x01b2
            int r1 = r0.bp
            int r1 = r1 + r7
            r2 = 1
            int r1 = r1 + r2
            char r1 = r0.charAt(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L_0x01b2
            int r1 = r0.bp
            int r1 = r1 + r7
            r3 = 2
            int r1 = r1 + r3
            char r1 = r0.charAt(r1)
            if (r1 != r2) goto L_0x01b2
            r1 = 5
            r0.matchStat = r1
            r2 = 3
            int r7 = r7 + r2
            int r2 = r0.bp
            int r3 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            if (r5 == 0) goto L_0x0170
            r4 = 34
            if (r2 != r4) goto L_0x0170
            int r2 = r0.bp
            int r4 = r3 + 1
            int r2 = r2 + r3
            char r2 = r0.charAt(r2)
            r3 = r4
        L_0x0170:
            r4 = 44
            if (r2 != r4) goto L_0x0186
            int r2 = r0.bp
            int r2 = r2 + r3
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r4 = 16
            r0.token = r4
            return r12
        L_0x0186:
            r4 = 16
            r5 = 93
            if (r2 != r5) goto L_0x019e
            int r2 = r0.bp
            int r2 = r2 + r3
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r1 = 15
            r0.token = r1
            return r12
        L_0x019e:
            boolean r2 = isWhitespace(r2)
            if (r2 == 0) goto L_0x01af
            int r2 = r0.bp
            int r5 = r3 + 1
            int r2 = r2 + r3
            char r2 = r0.charAt(r2)
            r3 = r5
            goto L_0x0170
        L_0x01af:
            r0.matchStat = r14
            return r12
        L_0x01b2:
            r0.matchStat = r14
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDouble(char):double");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public java.math.BigDecimal scanDecimal(char r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = 0
            r0.matchStat = r1
            int r2 = r0.bp
            int r2 = r2 + r1
            char r2 = r0.charAt(r2)
            r3 = 34
            r4 = 1
            if (r2 != r3) goto L_0x0013
            r5 = r4
            goto L_0x0014
        L_0x0013:
            r5 = r1
        L_0x0014:
            r6 = 2
            if (r5 == 0) goto L_0x0020
            int r2 = r0.bp
            int r2 = r2 + r4
            char r2 = r0.charAt(r2)
            r7 = r6
            goto L_0x0021
        L_0x0020:
            r7 = r4
        L_0x0021:
            r8 = 45
            if (r2 != r8) goto L_0x0027
            r9 = r4
            goto L_0x0028
        L_0x0027:
            r9 = r1
        L_0x0028:
            if (r9 == 0) goto L_0x0034
            int r2 = r0.bp
            int r9 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            r7 = r9
        L_0x0034:
            r10 = 125(0x7d, float:1.75E-43)
            r11 = 3
            r12 = 16
            r13 = 44
            r14 = 48
            r15 = -1
            r16 = 0
            if (r2 < r14) goto L_0x0157
            r1 = 57
            if (r2 > r1) goto L_0x0157
        L_0x0046:
            int r2 = r0.bp
            int r17 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            if (r2 < r14) goto L_0x0056
            if (r2 > r1) goto L_0x0056
            r7 = r17
            goto L_0x0046
        L_0x0056:
            r7 = 46
            if (r2 != r7) goto L_0x005c
            r7 = r4
            goto L_0x005d
        L_0x005c:
            r7 = 0
        L_0x005d:
            if (r7 == 0) goto L_0x0080
            int r2 = r0.bp
            int r7 = r17 + 1
            int r2 = r2 + r17
            char r2 = r0.charAt(r2)
            if (r2 < r14) goto L_0x007d
            if (r2 > r1) goto L_0x007d
        L_0x006d:
            int r2 = r0.bp
            int r17 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            if (r2 < r14) goto L_0x0080
            if (r2 > r1) goto L_0x0080
            r7 = r17
            goto L_0x006d
        L_0x007d:
            r0.matchStat = r15
            return r16
        L_0x0080:
            r7 = 101(0x65, float:1.42E-43)
            if (r2 == r7) goto L_0x008b
            r7 = 69
            if (r2 != r7) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            r7 = 0
            goto L_0x008c
        L_0x008b:
            r7 = r4
        L_0x008c:
            if (r7 == 0) goto L_0x00bc
            int r2 = r0.bp
            int r7 = r17 + 1
            int r2 = r2 + r17
            char r2 = r0.charAt(r2)
            r9 = 43
            if (r2 == r9) goto L_0x00a2
            if (r2 != r8) goto L_0x009f
            goto L_0x00a2
        L_0x009f:
            r17 = r7
            goto L_0x00ad
        L_0x00a2:
            int r2 = r0.bp
            int r8 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            r17 = r8
        L_0x00ad:
            if (r2 < r14) goto L_0x00bc
            if (r2 > r1) goto L_0x00bc
            int r2 = r0.bp
            int r7 = r17 + 1
            int r2 = r2 + r17
            char r2 = r0.charAt(r2)
            goto L_0x009f
        L_0x00bc:
            if (r5 == 0) goto L_0x00d8
            if (r2 == r3) goto L_0x00c3
            r0.matchStat = r15
            return r16
        L_0x00c3:
            int r1 = r0.bp
            int r2 = r17 + 1
            int r1 = r1 + r17
            char r1 = r0.charAt(r1)
            int r3 = r0.bp
            int r5 = r3 + 1
            int r3 = r3 + r2
            int r3 = r3 - r5
            int r3 = r3 - r6
            r17 = r2
            r2 = r1
            goto L_0x00df
        L_0x00d8:
            int r5 = r0.bp
            int r1 = r5 + r17
            int r1 = r1 - r5
            int r3 = r1 + -1
        L_0x00df:
            char[] r1 = r0.sub_chars(r5, r3)
            java.math.BigDecimal r3 = new java.math.BigDecimal
            r3.<init>(r1)
            if (r2 != r13) goto L_0x00fb
            int r1 = r0.bp
            int r1 = r1 + r17
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            r0.matchStat = r11
            r0.token = r12
            return r3
        L_0x00fb:
            r1 = 93
            if (r2 != r1) goto L_0x0154
            int r2 = r0.bp
            int r5 = r17 + 1
            int r2 = r2 + r17
            char r2 = r0.charAt(r2)
            if (r2 != r13) goto L_0x0119
            r0.token = r12
            int r1 = r0.bp
            int r1 = r1 + r5
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x014d
        L_0x0119:
            if (r2 != r1) goto L_0x012b
            r1 = 15
            r0.token = r1
            int r1 = r0.bp
            int r1 = r1 + r5
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x014d
        L_0x012b:
            if (r2 != r10) goto L_0x013d
            r1 = 13
            r0.token = r1
            int r1 = r0.bp
            int r1 = r1 + r5
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x014d
        L_0x013d:
            r1 = 26
            if (r2 != r1) goto L_0x0151
            r2 = 20
            r0.token = r2
            int r2 = r0.bp
            int r5 = r5 - r4
            int r2 = r2 + r5
            r0.bp = r2
            r0.ch = r1
        L_0x014d:
            r1 = 4
            r0.matchStat = r1
            return r3
        L_0x0151:
            r0.matchStat = r15
            return r16
        L_0x0154:
            r0.matchStat = r15
            return r16
        L_0x0157:
            r1 = 110(0x6e, float:1.54E-43)
            if (r2 != r1) goto L_0x01d3
            int r1 = r0.bp
            int r1 = r1 + r7
            char r1 = r0.charAt(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L_0x01d3
            int r1 = r0.bp
            int r1 = r1 + r7
            int r1 = r1 + r4
            char r1 = r0.charAt(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L_0x01d3
            int r1 = r0.bp
            int r1 = r1 + r7
            int r1 = r1 + r6
            char r1 = r0.charAt(r1)
            if (r1 != r2) goto L_0x01d3
            r1 = 5
            r0.matchStat = r1
            int r7 = r7 + r11
            int r2 = r0.bp
            int r4 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            if (r5 == 0) goto L_0x0197
            if (r2 != r3) goto L_0x0197
            int r2 = r0.bp
            int r3 = r4 + 1
            int r2 = r2 + r4
            char r2 = r0.charAt(r2)
            r4 = r3
        L_0x0197:
            if (r2 != r13) goto L_0x01a9
            int r2 = r0.bp
            int r2 = r2 + r4
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r0.token = r12
            return r16
        L_0x01a9:
            if (r2 != r10) goto L_0x01bd
            int r2 = r0.bp
            int r2 = r2 + r4
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r3 = 13
            r0.token = r3
            return r16
        L_0x01bd:
            r3 = 13
            boolean r2 = isWhitespace(r2)
            if (r2 == 0) goto L_0x01d0
            int r2 = r0.bp
            int r5 = r4 + 1
            int r2 = r2 + r4
            char r2 = r0.charAt(r2)
            r4 = r5
            goto L_0x0197
        L_0x01d0:
            r0.matchStat = r15
            return r16
        L_0x01d3:
            r0.matchStat = r15
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDecimal(char):java.math.BigDecimal");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final float[] scanFieldFloatArray(char[] r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = 0
            r0.matchStat = r1
            boolean r2 = r19.charArrayCompare(r20)
            r3 = -2
            r4 = 0
            if (r2 != 0) goto L_0x0010
            r0.matchStat = r3
            return r4
        L_0x0010:
            r2 = r20
            int r2 = r2.length
            int r5 = r0.bp
            int r6 = r2 + 1
            int r5 = r5 + r2
            char r2 = r0.charAt(r5)
            r5 = 91
            if (r2 == r5) goto L_0x0023
            r0.matchStat = r3
            return r4
        L_0x0023:
            int r2 = r0.bp
            int r3 = r6 + 1
            int r2 = r2 + r6
            char r2 = r0.charAt(r2)
            r5 = 16
            float[] r6 = new float[r5]
            r7 = r1
        L_0x0031:
            int r8 = r0.bp
            int r9 = r8 + r3
            r10 = 1
            int r9 = r9 - r10
            r11 = 45
            if (r2 != r11) goto L_0x003d
            r12 = r10
            goto L_0x003e
        L_0x003d:
            r12 = r1
        L_0x003e:
            if (r12 == 0) goto L_0x004c
            int r2 = r3 + 1
            int r8 = r8 + r3
            char r3 = r0.charAt(r8)
            r18 = r3
            r3 = r2
            r2 = r18
        L_0x004c:
            r8 = -1
            r13 = 48
            if (r2 < r13) goto L_0x01bb
            r14 = 57
            if (r2 > r14) goto L_0x01bb
            int r2 = r2 + -48
        L_0x0057:
            int r15 = r0.bp
            int r16 = r3 + 1
            int r15 = r15 + r3
            char r3 = r0.charAt(r15)
            if (r3 < r13) goto L_0x006c
            if (r3 > r14) goto L_0x006c
            int r2 = r2 * 10
            int r3 = r3 + -48
            int r2 = r2 + r3
            r3 = r16
            goto L_0x0057
        L_0x006c:
            r15 = 46
            if (r3 != r15) goto L_0x0072
            r15 = r10
            goto L_0x0073
        L_0x0072:
            r15 = r1
        L_0x0073:
            r5 = 10
            if (r15 == 0) goto L_0x00ab
            int r3 = r0.bp
            int r15 = r16 + 1
            int r3 = r3 + r16
            char r3 = r0.charAt(r3)
            if (r3 < r13) goto L_0x00a8
            if (r3 > r14) goto L_0x00a8
            int r2 = r2 * 10
            int r3 = r3 + -48
            int r2 = r2 + r3
            r3 = r5
        L_0x008b:
            int r1 = r0.bp
            int r16 = r15 + 1
            int r1 = r1 + r15
            char r1 = r0.charAt(r1)
            if (r1 < r13) goto L_0x00a2
            if (r1 > r14) goto L_0x00a2
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            int r3 = r3 * 10
            r15 = r16
            goto L_0x008b
        L_0x00a2:
            r18 = r3
            r3 = r1
            r1 = r18
            goto L_0x00ac
        L_0x00a8:
            r0.matchStat = r8
            return r4
        L_0x00ab:
            r1 = r10
        L_0x00ac:
            r15 = 101(0x65, float:1.42E-43)
            if (r3 == r15) goto L_0x00b7
            r15 = 69
            if (r3 != r15) goto L_0x00b5
            goto L_0x00b7
        L_0x00b5:
            r15 = 0
            goto L_0x00b8
        L_0x00b7:
            r15 = r10
        L_0x00b8:
            if (r15 == 0) goto L_0x00e9
            int r3 = r0.bp
            int r17 = r16 + 1
            int r3 = r3 + r16
            char r3 = r0.charAt(r3)
            r4 = 43
            if (r3 == r4) goto L_0x00ce
            if (r3 != r11) goto L_0x00cb
            goto L_0x00ce
        L_0x00cb:
            r16 = r17
            goto L_0x00da
        L_0x00ce:
            int r3 = r0.bp
            int r4 = r17 + 1
            int r3 = r3 + r17
            char r3 = r0.charAt(r3)
        L_0x00d8:
            r16 = r4
        L_0x00da:
            if (r3 < r13) goto L_0x00e9
            if (r3 > r14) goto L_0x00e9
            int r3 = r0.bp
            int r4 = r16 + 1
            int r3 = r3 + r16
            char r3 = r0.charAt(r3)
            goto L_0x00d8
        L_0x00e9:
            int r4 = r0.bp
            int r4 = r4 + r16
            int r4 = r4 - r9
            int r4 = r4 - r10
            if (r15 != 0) goto L_0x00fa
            if (r4 >= r5) goto L_0x00fa
            float r2 = (float) r2
            float r1 = (float) r1
            float r2 = r2 / r1
            if (r12 == 0) goto L_0x0102
            float r2 = -r2
            goto L_0x0102
        L_0x00fa:
            java.lang.String r1 = r0.subString(r9, r4)
            float r2 = java.lang.Float.parseFloat(r1)
        L_0x0102:
            int r1 = r6.length
            r4 = 3
            if (r7 < r1) goto L_0x0111
            int r1 = r6.length
            int r1 = r1 * r4
            int r1 = r1 / 2
            float[] r1 = new float[r1]
            r5 = 0
            java.lang.System.arraycopy(r6, r5, r1, r5, r7)
            r6 = r1
        L_0x0111:
            int r5 = r7 + 1
            r6[r7] = r2
            r1 = 44
            if (r3 != r1) goto L_0x012b
            int r1 = r0.bp
            int r2 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.charAt(r1)
            r3 = r2
            r4 = 16
            r11 = 0
            r2 = r1
            r1 = 0
            goto L_0x01b5
        L_0x012b:
            r2 = 93
            if (r3 != r2) goto L_0x01ae
            int r3 = r0.bp
            int r7 = r16 + 1
            int r3 = r3 + r16
            char r3 = r0.charAt(r3)
            int r9 = r6.length
            if (r5 == r9) goto L_0x0143
            float[] r9 = new float[r5]
            r11 = 0
            java.lang.System.arraycopy(r6, r11, r9, r11, r5)
            r6 = r9
        L_0x0143:
            if (r3 != r1) goto L_0x0155
            int r1 = r0.bp
            int r7 = r7 - r10
            int r1 = r1 + r7
            r0.bp = r1
            r19.next()
            r0.matchStat = r4
            r4 = 16
            r0.token = r4
            return r6
        L_0x0155:
            r4 = 16
            r5 = 125(0x7d, float:1.75E-43)
            if (r3 != r5) goto L_0x01aa
            int r3 = r0.bp
            int r9 = r7 + 1
            int r3 = r3 + r7
            char r3 = r0.charAt(r3)
            if (r3 != r1) goto L_0x0172
            r0.token = r4
            int r1 = r0.bp
            int r9 = r9 - r10
            int r1 = r1 + r9
            r0.bp = r1
            r19.next()
            goto L_0x01a2
        L_0x0172:
            if (r3 != r2) goto L_0x0182
            r1 = 15
            r0.token = r1
            int r1 = r0.bp
            int r9 = r9 - r10
            int r1 = r1 + r9
            r0.bp = r1
            r19.next()
            goto L_0x01a2
        L_0x0182:
            if (r3 != r5) goto L_0x0192
            r1 = 13
            r0.token = r1
            int r1 = r0.bp
            int r9 = r9 - r10
            int r1 = r1 + r9
            r0.bp = r1
            r19.next()
            goto L_0x01a2
        L_0x0192:
            r1 = 26
            if (r3 != r1) goto L_0x01a6
            int r2 = r0.bp
            int r9 = r9 - r10
            int r2 = r2 + r9
            r0.bp = r2
            r2 = 20
            r0.token = r2
            r0.ch = r1
        L_0x01a2:
            r1 = 4
            r0.matchStat = r1
            return r6
        L_0x01a6:
            r0.matchStat = r8
            r1 = 0
            return r1
        L_0x01aa:
            r1 = 0
            r0.matchStat = r8
            return r1
        L_0x01ae:
            r1 = 0
            r4 = 16
            r11 = 0
            r2 = r3
            r3 = r16
        L_0x01b5:
            r7 = r5
            r5 = r4
            r4 = r1
            r1 = r11
            goto L_0x0031
        L_0x01bb:
            r1 = r4
            r0.matchStat = r8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray(char[]):float[]");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final float[][] scanFieldFloatArray2(char[] r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = 0
            r0.matchStat = r1
            boolean r2 = r21.charArrayCompare(r22)
            r3 = -2
            r4 = 0
            if (r2 != 0) goto L_0x0012
            r0.matchStat = r3
            float[][] r4 = (float[][]) r4
            return r4
        L_0x0012:
            r2 = r22
            int r2 = r2.length
            int r5 = r0.bp
            int r6 = r2 + 1
            int r5 = r5 + r2
            char r2 = r0.charAt(r5)
            r5 = 91
            if (r2 == r5) goto L_0x0027
            r0.matchStat = r3
            float[][] r4 = (float[][]) r4
            return r4
        L_0x0027:
            int r2 = r0.bp
            int r3 = r6 + 1
            int r2 = r2 + r6
            char r2 = r0.charAt(r2)
            r6 = 16
            float[][] r7 = new float[r6][]
            r8 = r1
        L_0x0035:
            r11 = -1
            r13 = 1
            if (r2 != r5) goto L_0x019e
            int r2 = r0.bp
            int r14 = r3 + 1
            int r2 = r2 + r3
            char r2 = r0.charAt(r2)
            float[] r3 = new float[r6]
            r15 = r1
        L_0x0045:
            int r5 = r0.bp
            int r16 = r5 + r14
            int r6 = r16 + -1
            r9 = 45
            if (r2 != r9) goto L_0x0052
            r17 = r13
            goto L_0x0054
        L_0x0052:
            r17 = r1
        L_0x0054:
            if (r17 == 0) goto L_0x005f
            int r2 = r14 + 1
            int r5 = r5 + r14
            char r5 = r0.charAt(r5)
            r14 = r2
            r2 = r5
        L_0x005f:
            r5 = 48
            if (r2 < r5) goto L_0x0197
            r12 = 57
            if (r2 > r12) goto L_0x0197
            int r2 = r2 + -48
        L_0x0069:
            int r1 = r0.bp
            int r18 = r14 + 1
            int r1 = r1 + r14
            char r1 = r0.charAt(r1)
            if (r1 < r5) goto L_0x007e
            if (r1 > r12) goto L_0x007e
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            r14 = r18
            goto L_0x0069
        L_0x007e:
            r14 = 46
            if (r1 != r14) goto L_0x00ba
            int r1 = r0.bp
            int r14 = r18 + 1
            int r1 = r1 + r18
            char r1 = r0.charAt(r1)
            if (r1 < r5) goto L_0x00b5
            if (r1 > r12) goto L_0x00b5
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            r1 = 10
        L_0x0097:
            int r10 = r0.bp
            int r18 = r14 + 1
            int r10 = r10 + r14
            char r10 = r0.charAt(r10)
            if (r10 < r5) goto L_0x00ae
            if (r10 > r12) goto L_0x00ae
            int r2 = r2 * 10
            int r10 = r10 + -48
            int r2 = r2 + r10
            int r1 = r1 * 10
            r14 = r18
            goto L_0x0097
        L_0x00ae:
            r20 = r2
            r2 = r1
            r1 = r10
            r10 = r20
            goto L_0x00bc
        L_0x00b5:
            r0.matchStat = r11
            float[][] r4 = (float[][]) r4
            return r4
        L_0x00ba:
            r10 = r2
            r2 = r13
        L_0x00bc:
            r14 = 101(0x65, float:1.42E-43)
            if (r1 == r14) goto L_0x00c7
            r14 = 69
            if (r1 != r14) goto L_0x00c5
            goto L_0x00c7
        L_0x00c5:
            r14 = 0
            goto L_0x00c8
        L_0x00c7:
            r14 = r13
        L_0x00c8:
            if (r14 == 0) goto L_0x00f9
            int r1 = r0.bp
            int r19 = r18 + 1
            int r1 = r1 + r18
            char r1 = r0.charAt(r1)
            r4 = 43
            if (r1 == r4) goto L_0x00de
            if (r1 != r9) goto L_0x00db
            goto L_0x00de
        L_0x00db:
            r18 = r19
            goto L_0x00ea
        L_0x00de:
            int r1 = r0.bp
            int r4 = r19 + 1
            int r1 = r1 + r19
            char r1 = r0.charAt(r1)
        L_0x00e8:
            r18 = r4
        L_0x00ea:
            if (r1 < r5) goto L_0x00f9
            if (r1 > r12) goto L_0x00f9
            int r1 = r0.bp
            int r4 = r18 + 1
            int r1 = r1 + r18
            char r1 = r0.charAt(r1)
            goto L_0x00e8
        L_0x00f9:
            int r4 = r0.bp
            int r4 = r4 + r18
            int r4 = r4 - r6
            int r4 = r4 - r13
            if (r14 != 0) goto L_0x010c
            r5 = 10
            if (r4 >= r5) goto L_0x010c
            float r4 = (float) r10
            float r2 = (float) r2
            float r4 = r4 / r2
            if (r17 == 0) goto L_0x0114
            float r4 = -r4
            goto L_0x0114
        L_0x010c:
            java.lang.String r2 = r0.subString(r6, r4)
            float r4 = java.lang.Float.parseFloat(r2)
        L_0x0114:
            int r2 = r3.length
            if (r15 < r2) goto L_0x0123
            int r2 = r3.length
            r5 = 3
            int r2 = r2 * r5
            int r2 = r2 / 2
            float[] r2 = new float[r2]
            r5 = 0
            java.lang.System.arraycopy(r3, r5, r2, r5, r15)
            r3 = r2
        L_0x0123:
            int r2 = r15 + 1
            r3[r15] = r4
            r4 = 44
            if (r1 != r4) goto L_0x0137
            int r1 = r0.bp
            int r4 = r18 + 1
            int r1 = r1 + r18
            char r1 = r0.charAt(r1)
            r14 = r4
            goto L_0x018f
        L_0x0137:
            r4 = 93
            if (r1 != r4) goto L_0x018d
            int r1 = r0.bp
            int r4 = r18 + 1
            int r1 = r1 + r18
            char r1 = r0.charAt(r1)
            int r5 = r3.length
            if (r2 == r5) goto L_0x0150
            float[] r5 = new float[r2]
            r6 = 0
            java.lang.System.arraycopy(r3, r6, r5, r6, r2)
            r3 = r5
            goto L_0x0151
        L_0x0150:
            r6 = 0
        L_0x0151:
            int r5 = r7.length
            if (r8 < r5) goto L_0x015f
            int r5 = r7.length
            r7 = 3
            int r5 = r5 * r7
            int r5 = r5 / 2
            float[][] r5 = new float[r5][]
            java.lang.System.arraycopy(r3, r6, r5, r6, r2)
            r7 = r5
        L_0x015f:
            int r5 = r8 + 1
            r7[r8] = r3
            r2 = 44
            if (r1 != r2) goto L_0x0173
            int r1 = r0.bp
            int r2 = r4 + 1
            int r1 = r1 + r4
            char r1 = r0.charAt(r1)
            r3 = r2
            r2 = r1
            goto L_0x0184
        L_0x0173:
            r2 = 93
            if (r1 != r2) goto L_0x0182
            int r1 = r0.bp
            int r3 = r4 + 1
            int r1 = r1 + r4
            char r2 = r0.charAt(r1)
            r8 = r5
            goto L_0x019e
        L_0x0182:
            r2 = r1
            r3 = r4
        L_0x0184:
            r8 = r5
            r1 = 0
            r4 = 0
            r5 = 91
            r6 = 16
            goto L_0x0035
        L_0x018d:
            r14 = r18
        L_0x018f:
            r15 = r2
            r4 = 0
            r6 = 16
            r2 = r1
            r1 = 0
            goto L_0x0045
        L_0x0197:
            r0.matchStat = r11
            r1 = 0
            r4 = r1
            float[][] r4 = (float[][]) r4
            return r4
        L_0x019e:
            int r1 = r7.length
            if (r8 == r1) goto L_0x01a8
            float[][] r1 = new float[r8][]
            r4 = 0
            java.lang.System.arraycopy(r7, r4, r1, r4, r8)
            r7 = r1
        L_0x01a8:
            r1 = 44
            if (r2 != r1) goto L_0x01bd
            int r1 = r0.bp
            int r3 = r3 - r13
            int r1 = r1 + r3
            r0.bp = r1
            r21.next()
            r1 = 3
            r0.matchStat = r1
            r1 = 16
            r0.token = r1
            return r7
        L_0x01bd:
            r1 = 16
            r4 = 125(0x7d, float:1.75E-43)
            if (r2 != r4) goto L_0x0219
            int r2 = r0.bp
            int r5 = r3 + 1
            int r2 = r2 + r3
            char r2 = r0.charAt(r2)
            r3 = 44
            if (r2 != r3) goto L_0x01dc
            r0.token = r1
            int r1 = r0.bp
            int r5 = r5 - r13
            int r1 = r1 + r5
            r0.bp = r1
            r21.next()
            goto L_0x020e
        L_0x01dc:
            r1 = 93
            if (r2 != r1) goto L_0x01ee
            r1 = 15
            r0.token = r1
            int r1 = r0.bp
            int r5 = r5 - r13
            int r1 = r1 + r5
            r0.bp = r1
            r21.next()
            goto L_0x020e
        L_0x01ee:
            if (r2 != r4) goto L_0x01fe
            r1 = 13
            r0.token = r1
            int r1 = r0.bp
            int r5 = r5 - r13
            int r1 = r1 + r5
            r0.bp = r1
            r21.next()
            goto L_0x020e
        L_0x01fe:
            r1 = 26
            if (r2 != r1) goto L_0x0212
            int r2 = r0.bp
            int r5 = r5 - r13
            int r2 = r2 + r5
            r0.bp = r2
            r2 = 20
            r0.token = r2
            r0.ch = r1
        L_0x020e:
            r1 = 4
            r0.matchStat = r1
            return r7
        L_0x0212:
            r0.matchStat = r11
            r1 = 0
            r4 = r1
            float[][] r4 = (float[][]) r4
            return r4
        L_0x0219:
            r1 = 0
            r0.matchStat = r11
            r4 = r1
            float[][] r4 = (float[][]) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray2(char[]):float[][]");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final double scanFieldDouble(char[] r24) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = 0
            r0.matchStat = r2
            boolean r3 = r23.charArrayCompare(r24)
            r4 = 0
            if (r3 != 0) goto L_0x0013
            r1 = -2
            r0.matchStat = r1
            return r4
        L_0x0013:
            int r3 = r1.length
            int r6 = r0.bp
            int r7 = r3 + 1
            int r6 = r6 + r3
            char r3 = r0.charAt(r6)
            r6 = 34
            if (r3 != r6) goto L_0x0023
            r9 = 1
            goto L_0x0024
        L_0x0023:
            r9 = r2
        L_0x0024:
            if (r9 == 0) goto L_0x0030
            int r3 = r0.bp
            int r10 = r7 + 1
            int r3 = r3 + r7
            char r3 = r0.charAt(r3)
            r7 = r10
        L_0x0030:
            r10 = 45
            if (r3 != r10) goto L_0x0036
            r11 = 1
            goto L_0x0037
        L_0x0036:
            r11 = r2
        L_0x0037:
            if (r11 == 0) goto L_0x0043
            int r3 = r0.bp
            int r12 = r7 + 1
            int r3 = r3 + r7
            char r3 = r0.charAt(r3)
            r7 = r12
        L_0x0043:
            r12 = -1
            r15 = 48
            if (r3 < r15) goto L_0x01a6
            r14 = 57
            if (r3 > r14) goto L_0x01a6
            int r3 = r3 - r15
            long r2 = (long) r3
        L_0x004e:
            int r13 = r0.bp
            int r17 = r7 + 1
            int r13 = r13 + r7
            char r7 = r0.charAt(r13)
            r18 = 10
            if (r7 < r15) goto L_0x0068
            if (r7 > r14) goto L_0x0068
            long r2 = r2 * r18
            int r7 = r7 + -48
            long r6 = (long) r7
            long r2 = r2 + r6
            r7 = r17
            r6 = 34
            goto L_0x004e
        L_0x0068:
            r20 = 1
            r6 = 46
            if (r7 != r6) goto L_0x0070
            r6 = 1
            goto L_0x0071
        L_0x0070:
            r6 = 0
        L_0x0071:
            if (r6 == 0) goto L_0x00a5
            int r6 = r0.bp
            int r7 = r17 + 1
            int r6 = r6 + r17
            char r6 = r0.charAt(r6)
            if (r6 < r15) goto L_0x00a2
            if (r6 > r14) goto L_0x00a2
            long r2 = r2 * r18
            int r6 = r6 - r15
            r22 = r9
            long r8 = (long) r6
            long r2 = r2 + r8
            r20 = r18
        L_0x008a:
            int r6 = r0.bp
            int r17 = r7 + 1
            int r6 = r6 + r7
            char r7 = r0.charAt(r6)
            if (r7 < r15) goto L_0x00a7
            if (r7 > r14) goto L_0x00a7
            long r2 = r2 * r18
            int r7 = r7 + -48
            long r6 = (long) r7
            long r2 = r2 + r6
            long r20 = r20 * r18
            r7 = r17
            goto L_0x008a
        L_0x00a2:
            r0.matchStat = r12
            return r4
        L_0x00a5:
            r22 = r9
        L_0x00a7:
            r8 = r20
            r6 = 101(0x65, float:1.42E-43)
            if (r7 == r6) goto L_0x00b5
            r6 = 69
            if (r7 != r6) goto L_0x00b2
            goto L_0x00b5
        L_0x00b2:
            r16 = 0
            goto L_0x00b7
        L_0x00b5:
            r16 = 1
        L_0x00b7:
            if (r16 == 0) goto L_0x00e9
            int r6 = r0.bp
            int r7 = r17 + 1
            int r6 = r6 + r17
            char r6 = r0.charAt(r6)
            r13 = 43
            if (r6 == r13) goto L_0x00ce
            if (r6 != r10) goto L_0x00ca
            goto L_0x00ce
        L_0x00ca:
            r17 = r7
            r7 = r6
            goto L_0x00da
        L_0x00ce:
            int r6 = r0.bp
            int r10 = r7 + 1
            int r6 = r6 + r7
            char r6 = r0.charAt(r6)
            r7 = r6
            r17 = r10
        L_0x00da:
            if (r7 < r15) goto L_0x00e9
            if (r7 > r14) goto L_0x00e9
            int r6 = r0.bp
            int r7 = r17 + 1
            int r6 = r6 + r17
            char r6 = r0.charAt(r6)
            goto L_0x00ca
        L_0x00e9:
            if (r22 == 0) goto L_0x010a
            r6 = 34
            if (r7 == r6) goto L_0x00f2
            r0.matchStat = r12
            return r4
        L_0x00f2:
            int r6 = r0.bp
            int r7 = r17 + 1
            int r6 = r6 + r17
            char r6 = r0.charAt(r6)
            int r10 = r0.bp
            int r1 = r1.length
            int r1 = r1 + r10
            r13 = 1
            int r1 = r1 + r13
            int r10 = r10 + r7
            int r10 = r10 - r1
            int r10 = r10 + -2
            r17 = r7
            r7 = r6
            goto L_0x0114
        L_0x010a:
            r13 = 1
            int r6 = r0.bp
            int r1 = r1.length
            int r1 = r1 + r6
            int r6 = r6 + r17
            int r6 = r6 - r1
            int r10 = r6 + -1
        L_0x0114:
            if (r16 != 0) goto L_0x0121
            r6 = 17
            if (r10 >= r6) goto L_0x0121
            double r1 = (double) r2
            double r8 = (double) r8
            double r1 = r1 / r8
            if (r11 == 0) goto L_0x0129
            double r1 = -r1
            goto L_0x0129
        L_0x0121:
            java.lang.String r1 = r0.subString(r1, r10)
            double r1 = java.lang.Double.parseDouble(r1)
        L_0x0129:
            r3 = 44
            if (r7 != r3) goto L_0x0141
            int r3 = r0.bp
            int r3 = r3 + r17
            r0.bp = r3
            char r3 = r0.charAt(r3)
            r0.ch = r3
            r3 = 3
            r0.matchStat = r3
            r3 = 16
            r0.token = r3
            return r1
        L_0x0141:
            r3 = 16
            r6 = 125(0x7d, float:1.75E-43)
            if (r7 != r6) goto L_0x01a3
            int r6 = r0.bp
            int r7 = r17 + 1
            int r6 = r6 + r17
            char r6 = r0.charAt(r6)
            r8 = 44
            if (r6 != r8) goto L_0x0163
            r0.token = r3
            int r3 = r0.bp
            int r3 = r3 + r7
            r0.bp = r3
            char r3 = r0.charAt(r3)
            r0.ch = r3
            goto L_0x019c
        L_0x0163:
            r3 = 93
            if (r6 != r3) goto L_0x0177
            r3 = 15
            r0.token = r3
            int r3 = r0.bp
            int r3 = r3 + r7
            r0.bp = r3
            char r3 = r0.charAt(r3)
            r0.ch = r3
            goto L_0x019c
        L_0x0177:
            r3 = 125(0x7d, float:1.75E-43)
            if (r6 != r3) goto L_0x018b
            r3 = 13
            r0.token = r3
            int r3 = r0.bp
            int r3 = r3 + r7
            r0.bp = r3
            char r3 = r0.charAt(r3)
            r0.ch = r3
            goto L_0x019c
        L_0x018b:
            r3 = 26
            if (r6 != r3) goto L_0x01a0
            r4 = 20
            r0.token = r4
            int r4 = r0.bp
            r5 = 1
            int r7 = r7 - r5
            int r4 = r4 + r7
            r0.bp = r4
            r0.ch = r3
        L_0x019c:
            r3 = 4
            r0.matchStat = r3
            return r1
        L_0x01a0:
            r0.matchStat = r12
            return r4
        L_0x01a3:
            r0.matchStat = r12
            return r4
        L_0x01a6:
            r22 = r9
            r1 = 110(0x6e, float:1.54E-43)
            if (r3 != r1) goto L_0x0231
            int r1 = r0.bp
            int r1 = r1 + r7
            char r1 = r0.charAt(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L_0x0231
            int r1 = r0.bp
            int r1 = r1 + r7
            r2 = 1
            int r1 = r1 + r2
            char r1 = r0.charAt(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L_0x0231
            int r1 = r0.bp
            int r1 = r1 + r7
            int r1 = r1 + 2
            char r1 = r0.charAt(r1)
            if (r1 != r2) goto L_0x0231
            r1 = 5
            r0.matchStat = r1
            r2 = 3
            int r7 = r7 + r2
            int r2 = r0.bp
            int r3 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            if (r22 == 0) goto L_0x01ed
            r6 = 34
            if (r2 != r6) goto L_0x01ed
            int r2 = r0.bp
            int r6 = r3 + 1
            int r2 = r2 + r3
            char r2 = r0.charAt(r2)
            r3 = r6
        L_0x01ed:
            r6 = 44
        L_0x01ef:
            if (r2 != r6) goto L_0x0203
            int r2 = r0.bp
            int r2 = r2 + r3
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r7 = 16
            r0.token = r7
            return r4
        L_0x0203:
            r7 = 16
            r8 = 125(0x7d, float:1.75E-43)
            if (r2 != r8) goto L_0x021b
            int r2 = r0.bp
            int r2 = r2 + r3
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r9 = 13
            r0.token = r9
            return r4
        L_0x021b:
            r9 = 13
            boolean r2 = isWhitespace(r2)
            if (r2 == 0) goto L_0x022e
            int r2 = r0.bp
            int r10 = r3 + 1
            int r2 = r2 + r3
            char r2 = r0.charAt(r2)
            r3 = r10
            goto L_0x01ef
        L_0x022e:
            r0.matchStat = r12
            return r4
        L_0x0231:
            r0.matchStat = r12
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDouble(char[]):double");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public java.math.BigDecimal scanFieldDecimal(char[] r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 0
            r0.matchStat = r2
            boolean r3 = r18.charArrayCompare(r19)
            r4 = 0
            if (r3 != 0) goto L_0x0012
            r1 = -2
            r0.matchStat = r1
            return r4
        L_0x0012:
            int r3 = r1.length
            int r5 = r0.bp
            int r6 = r3 + 1
            int r5 = r5 + r3
            char r3 = r0.charAt(r5)
            r5 = 34
            r7 = 1
            if (r3 != r5) goto L_0x0023
            r8 = r7
            goto L_0x0024
        L_0x0023:
            r8 = r2
        L_0x0024:
            if (r8 == 0) goto L_0x0030
            int r3 = r0.bp
            int r9 = r6 + 1
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            r6 = r9
        L_0x0030:
            r9 = 45
            if (r3 != r9) goto L_0x0036
            r10 = r7
            goto L_0x0037
        L_0x0036:
            r10 = r2
        L_0x0037:
            if (r10 == 0) goto L_0x0043
            int r3 = r0.bp
            int r10 = r6 + 1
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            r6 = r10
        L_0x0043:
            r11 = 3
            r12 = 16
            r14 = 44
            r15 = 48
            r2 = -1
            if (r3 < r15) goto L_0x016b
            r10 = 57
            if (r3 > r10) goto L_0x016b
        L_0x0051:
            int r3 = r0.bp
            int r17 = r6 + 1
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            if (r3 < r15) goto L_0x0061
            if (r3 > r10) goto L_0x0061
            r6 = r17
            goto L_0x0051
        L_0x0061:
            r6 = 46
            if (r3 != r6) goto L_0x0067
            r6 = r7
            goto L_0x0068
        L_0x0067:
            r6 = 0
        L_0x0068:
            if (r6 == 0) goto L_0x008b
            int r3 = r0.bp
            int r6 = r17 + 1
            int r3 = r3 + r17
            char r3 = r0.charAt(r3)
            if (r3 < r15) goto L_0x0088
            if (r3 > r10) goto L_0x0088
        L_0x0078:
            int r3 = r0.bp
            int r17 = r6 + 1
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            if (r3 < r15) goto L_0x008b
            if (r3 > r10) goto L_0x008b
            r6 = r17
            goto L_0x0078
        L_0x0088:
            r0.matchStat = r2
            return r4
        L_0x008b:
            r6 = 101(0x65, float:1.42E-43)
            if (r3 == r6) goto L_0x0097
            r6 = 69
            if (r3 != r6) goto L_0x0094
            goto L_0x0097
        L_0x0094:
            r16 = 0
            goto L_0x0099
        L_0x0097:
            r16 = r7
        L_0x0099:
            if (r16 == 0) goto L_0x00c9
            int r3 = r0.bp
            int r6 = r17 + 1
            int r3 = r3 + r17
            char r3 = r0.charAt(r3)
            r13 = 43
            if (r3 == r13) goto L_0x00af
            if (r3 != r9) goto L_0x00ac
            goto L_0x00af
        L_0x00ac:
            r17 = r6
            goto L_0x00ba
        L_0x00af:
            int r3 = r0.bp
            int r9 = r6 + 1
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            r17 = r9
        L_0x00ba:
            if (r3 < r15) goto L_0x00c9
            if (r3 > r10) goto L_0x00c9
            int r3 = r0.bp
            int r6 = r17 + 1
            int r3 = r3 + r17
            char r3 = r0.charAt(r3)
            goto L_0x00ac
        L_0x00c9:
            if (r8 == 0) goto L_0x00e6
            if (r3 == r5) goto L_0x00d0
            r0.matchStat = r2
            return r4
        L_0x00d0:
            int r3 = r0.bp
            int r5 = r17 + 1
            int r3 = r3 + r17
            char r3 = r0.charAt(r3)
            int r6 = r0.bp
            int r1 = r1.length
            int r1 = r1 + r6
            int r1 = r1 + r7
            int r6 = r6 + r5
            int r6 = r6 - r1
            int r6 = r6 + -2
            r17 = r5
            goto L_0x00ef
        L_0x00e6:
            int r5 = r0.bp
            int r1 = r1.length
            int r1 = r1 + r5
            int r5 = r5 + r17
            int r5 = r5 - r1
            int r6 = r5 + -1
        L_0x00ef:
            char[] r1 = r0.sub_chars(r1, r6)
            java.math.BigDecimal r5 = new java.math.BigDecimal
            r5.<init>(r1)
            if (r3 != r14) goto L_0x010b
            int r1 = r0.bp
            int r1 = r1 + r17
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            r0.matchStat = r11
            r0.token = r12
            return r5
        L_0x010b:
            r1 = 125(0x7d, float:1.75E-43)
            if (r3 != r1) goto L_0x0168
            int r1 = r0.bp
            int r3 = r17 + 1
            int r1 = r1 + r17
            char r1 = r0.charAt(r1)
            if (r1 != r14) goto L_0x0129
            r0.token = r12
            int r1 = r0.bp
            int r1 = r1 + r3
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x0161
        L_0x0129:
            r6 = 93
            if (r1 != r6) goto L_0x013d
            r1 = 15
            r0.token = r1
            int r1 = r0.bp
            int r1 = r1 + r3
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x0161
        L_0x013d:
            r6 = 125(0x7d, float:1.75E-43)
            if (r1 != r6) goto L_0x0151
            r6 = 13
            r0.token = r6
            int r1 = r0.bp
            int r1 = r1 + r3
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x0161
        L_0x0151:
            r6 = 26
            if (r1 != r6) goto L_0x0165
            r1 = 20
            r0.token = r1
            int r1 = r0.bp
            int r3 = r3 - r7
            int r1 = r1 + r3
            r0.bp = r1
            r0.ch = r6
        L_0x0161:
            r1 = 4
            r0.matchStat = r1
            return r5
        L_0x0165:
            r0.matchStat = r2
            return r4
        L_0x0168:
            r0.matchStat = r2
            return r4
        L_0x016b:
            r1 = 110(0x6e, float:1.54E-43)
            if (r3 != r1) goto L_0x01ea
            int r1 = r0.bp
            int r1 = r1 + r6
            char r1 = r0.charAt(r1)
            r3 = 117(0x75, float:1.64E-43)
            if (r1 != r3) goto L_0x01ea
            int r1 = r0.bp
            int r1 = r1 + r6
            int r1 = r1 + r7
            char r1 = r0.charAt(r1)
            r3 = 108(0x6c, float:1.51E-43)
            if (r1 != r3) goto L_0x01ea
            int r1 = r0.bp
            int r1 = r1 + r6
            int r1 = r1 + 2
            char r1 = r0.charAt(r1)
            if (r1 != r3) goto L_0x01ea
            r1 = 5
            r0.matchStat = r1
            int r6 = r6 + r11
            int r3 = r0.bp
            int r7 = r6 + 1
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            if (r8 == 0) goto L_0x01ac
            if (r3 != r5) goto L_0x01ac
            int r3 = r0.bp
            int r5 = r7 + 1
            int r3 = r3 + r7
            char r3 = r0.charAt(r3)
            r7 = r5
        L_0x01ac:
            if (r3 != r14) goto L_0x01be
            int r2 = r0.bp
            int r2 = r2 + r7
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r0.token = r12
            return r4
        L_0x01be:
            r5 = 125(0x7d, float:1.75E-43)
            if (r3 != r5) goto L_0x01d4
            int r2 = r0.bp
            int r2 = r2 + r7
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r6 = 13
            r0.token = r6
            return r4
        L_0x01d4:
            r6 = 13
            boolean r3 = isWhitespace(r3)
            if (r3 == 0) goto L_0x01e7
            int r3 = r0.bp
            int r8 = r7 + 1
            int r3 = r3 + r7
            char r3 = r0.charAt(r3)
            r7 = r8
            goto L_0x01ac
        L_0x01e7:
            r0.matchStat = r2
            return r4
        L_0x01ea:
            r0.matchStat = r2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDecimal(char[]):java.math.BigDecimal");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.math.BigInteger scanFieldBigInteger(char[] r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = 0
            r0.matchStat = r2
            boolean r3 = r19.charArrayCompare(r20)
            r4 = 0
            if (r3 != 0) goto L_0x0012
            r1 = -2
            r0.matchStat = r1
            return r4
        L_0x0012:
            int r3 = r1.length
            int r5 = r0.bp
            int r6 = r3 + 1
            int r5 = r5 + r3
            char r3 = r0.charAt(r5)
            r5 = 34
            r7 = 1
            if (r3 != r5) goto L_0x0023
            r8 = r7
            goto L_0x0024
        L_0x0023:
            r8 = r2
        L_0x0024:
            if (r8 == 0) goto L_0x0030
            int r3 = r0.bp
            int r9 = r6 + 1
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            r6 = r9
        L_0x0030:
            r9 = 45
            if (r3 != r9) goto L_0x0035
            r2 = r7
        L_0x0035:
            if (r2 == 0) goto L_0x0041
            int r3 = r0.bp
            int r9 = r6 + 1
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            r6 = r9
        L_0x0041:
            r13 = 44
            r14 = 48
            r15 = -1
            if (r3 < r14) goto L_0x0120
            r9 = 57
            if (r3 > r9) goto L_0x0120
            int r3 = r3 - r14
            long r11 = (long) r3
        L_0x004e:
            int r3 = r0.bp
            int r16 = r6 + 1
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            if (r3 < r14) goto L_0x0068
            if (r3 > r9) goto L_0x0068
            r17 = 10
            long r11 = r11 * r17
            int r3 = r3 + -48
            long r9 = (long) r3
            long r11 = r11 + r9
            r6 = r16
            r9 = 57
            goto L_0x004e
        L_0x0068:
            if (r8 == 0) goto L_0x0085
            if (r3 == r5) goto L_0x006f
            r0.matchStat = r15
            return r4
        L_0x006f:
            int r3 = r0.bp
            int r5 = r16 + 1
            int r3 = r3 + r16
            char r3 = r0.charAt(r3)
            int r6 = r0.bp
            int r1 = r1.length
            int r1 = r1 + r6
            int r1 = r1 + r7
            int r6 = r6 + r5
            int r6 = r6 - r1
            int r6 = r6 + -2
            r16 = r5
            goto L_0x008e
        L_0x0085:
            int r5 = r0.bp
            int r1 = r1.length
            int r1 = r1 + r5
            int r5 = r5 + r16
            int r5 = r5 - r1
            int r6 = r5 + -1
        L_0x008e:
            r5 = 20
            if (r6 < r5) goto L_0x00a3
            if (r2 == 0) goto L_0x0099
            r8 = 21
            if (r6 >= r8) goto L_0x0099
            goto L_0x00a3
        L_0x0099:
            java.lang.String r1 = r0.subString(r1, r6)
            java.math.BigInteger r2 = new java.math.BigInteger
            r2.<init>(r1)
            goto L_0x00aa
        L_0x00a3:
            if (r2 == 0) goto L_0x00a6
            long r11 = -r11
        L_0x00a6:
            java.math.BigInteger r2 = java.math.BigInteger.valueOf(r11)
        L_0x00aa:
            if (r3 != r13) goto L_0x00c0
            int r1 = r0.bp
            int r1 = r1 + r16
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            r1 = 3
            r0.matchStat = r1
            r1 = 16
            r0.token = r1
            return r2
        L_0x00c0:
            r1 = 16
            r6 = 125(0x7d, float:1.75E-43)
            if (r3 != r6) goto L_0x011d
            int r3 = r0.bp
            int r6 = r16 + 1
            int r3 = r3 + r16
            char r3 = r0.charAt(r3)
            if (r3 != r13) goto L_0x00e0
            r0.token = r1
            int r1 = r0.bp
            int r1 = r1 + r6
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x0116
        L_0x00e0:
            r1 = 93
            if (r3 != r1) goto L_0x00f4
            r1 = 15
            r0.token = r1
            int r1 = r0.bp
            int r1 = r1 + r6
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x0116
        L_0x00f4:
            r1 = 125(0x7d, float:1.75E-43)
            if (r3 != r1) goto L_0x0108
            r1 = 13
            r0.token = r1
            int r1 = r0.bp
            int r1 = r1 + r6
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x0116
        L_0x0108:
            r1 = 26
            if (r3 != r1) goto L_0x011a
            r0.token = r5
            int r3 = r0.bp
            int r6 = r6 - r7
            int r3 = r3 + r6
            r0.bp = r3
            r0.ch = r1
        L_0x0116:
            r1 = 4
            r0.matchStat = r1
            return r2
        L_0x011a:
            r0.matchStat = r15
            return r4
        L_0x011d:
            r0.matchStat = r15
            return r4
        L_0x0120:
            r1 = 110(0x6e, float:1.54E-43)
            if (r3 != r1) goto L_0x01a4
            int r1 = r0.bp
            int r1 = r1 + r6
            char r1 = r0.charAt(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L_0x01a4
            int r1 = r0.bp
            int r1 = r1 + r6
            int r1 = r1 + r7
            char r1 = r0.charAt(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L_0x01a4
            int r1 = r0.bp
            int r1 = r1 + r6
            int r1 = r1 + 2
            char r1 = r0.charAt(r1)
            if (r1 != r2) goto L_0x01a4
            r1 = 5
            r0.matchStat = r1
            r2 = 3
            int r6 = r6 + r2
            int r2 = r0.bp
            int r3 = r6 + 1
            int r2 = r2 + r6
            char r2 = r0.charAt(r2)
            if (r8 == 0) goto L_0x0162
            if (r2 != r5) goto L_0x0162
            int r2 = r0.bp
            int r5 = r3 + 1
            int r2 = r2 + r3
            char r2 = r0.charAt(r2)
            r3 = r5
        L_0x0162:
            if (r2 != r13) goto L_0x0176
            int r2 = r0.bp
            int r2 = r2 + r3
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r5 = 16
            r0.token = r5
            return r4
        L_0x0176:
            r5 = 16
            r6 = 125(0x7d, float:1.75E-43)
            if (r2 != r6) goto L_0x018e
            int r2 = r0.bp
            int r2 = r2 + r3
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r7 = 13
            r0.token = r7
            return r4
        L_0x018e:
            r7 = 13
            boolean r2 = isWhitespace(r2)
            if (r2 == 0) goto L_0x01a1
            int r2 = r0.bp
            int r8 = r3 + 1
            int r2 = r2 + r3
            char r2 = r0.charAt(r2)
            r3 = r8
            goto L_0x0162
        L_0x01a1:
            r0.matchStat = r15
            return r4
        L_0x01a4:
            r0.matchStat = r15
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldBigInteger(char[]):java.math.BigInteger");
    }

    public Date scanFieldDate(char[] cArr) {
        Date date;
        int i;
        long j;
        int i2;
        char charAt;
        char[] cArr2 = cArr;
        boolean z = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr2.length;
        int i3 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', this.bp + cArr2.length + 1);
            if (indexOf != -1) {
                int length2 = this.bp + cArr2.length + 1;
                String subString = subString(length2, indexOf - length2);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i4 = indexOf - 1;
                        int i5 = 0;
                        while (i4 >= 0 && charAt(i4) == '\\') {
                            i5++;
                            i4--;
                        }
                        if (i5 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i6 = this.bp;
                    int length3 = indexOf - ((cArr2.length + i6) + 1);
                    subString = readString(sub_chars(i6 + cArr2.length + 1, length3), length3);
                }
                int i7 = this.bp;
                int length4 = i3 + (indexOf - ((cArr2.length + i7) + 1)) + 1;
                i = length4 + 1;
                charAt2 = charAt(i7 + length4);
                JSONScanner jSONScanner = new JSONScanner(subString);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        date = jSONScanner.getCalendar().getTime();
                    } else {
                        this.matchStat = -1;
                        jSONScanner.close();
                        return null;
                    }
                } finally {
                    jSONScanner.close();
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (charAt2 == '-' || (charAt2 >= '0' && charAt2 <= '9')) {
            if (charAt2 == '-') {
                charAt2 = charAt(this.bp + i3);
                i3++;
                z = true;
            }
            if (charAt2 < '0' || charAt2 > '9') {
                i = i3;
                j = 0;
            } else {
                j = (long) (charAt2 - '0');
                while (true) {
                    i2 = i3 + 1;
                    charAt = charAt(this.bp + i3);
                    if (charAt < '0' || charAt > '9') {
                        int i8 = i2;
                        charAt2 = charAt;
                        i = i8;
                    } else {
                        j = (j * 10) + ((long) (charAt - '0'));
                        i3 = i2;
                    }
                }
                int i82 = i2;
                charAt2 = charAt;
                i = i82;
            }
            if (j < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
        } else {
            this.matchStat = -1;
            return null;
        }
        if (charAt2 == ',') {
            int i9 = this.bp + i;
            this.bp = i9;
            this.ch = charAt(i9);
            this.matchStat = 3;
            return date;
        } else if (charAt2 == '}') {
            int i10 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i11 = this.bp + i10;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i12 = this.bp + i10;
                this.bp = i12;
                this.ch = charAt(i12);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i13 = this.bp + i10;
                this.bp = i13;
                this.ch = charAt(i13);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i10 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    public Date scanDate(char c) {
        Date date;
        int i;
        long j;
        boolean z = false;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        int i2 = 5;
        if (charAt == '\"') {
            int indexOf = indexOf('\"', this.bp + 1);
            if (indexOf != -1) {
                int i3 = this.bp + 1;
                String subString = subString(i3, indexOf - i3);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i4 = indexOf - 1;
                        int i5 = 0;
                        while (i4 >= 0 && charAt(i4) == '\\') {
                            i5++;
                            i4--;
                        }
                        if (i5 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i6 = this.bp;
                    int i7 = indexOf - (i6 + 1);
                    subString = readString(sub_chars(i6 + 1, i7), i7);
                }
                int i8 = this.bp;
                int i9 = (indexOf - (i8 + 1)) + 1 + 1;
                int i10 = i9 + 1;
                charAt = charAt(i8 + i9);
                JSONScanner jSONScanner = new JSONScanner(subString);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        date = jSONScanner.getCalendar().getTime();
                        jSONScanner.close();
                        i2 = i10;
                    } else {
                        this.matchStat = -1;
                        jSONScanner.close();
                        return null;
                    }
                } catch (Throwable th) {
                    jSONScanner.close();
                    throw th;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c2 = '9';
            int i11 = 2;
            if (charAt == '-' || (charAt >= '0' && charAt <= '9')) {
                if (charAt == '-') {
                    charAt = charAt(this.bp + 1);
                    z = true;
                } else {
                    i11 = 1;
                }
                if (charAt >= '0' && charAt <= '9') {
                    j = (long) (charAt - '0');
                    while (true) {
                        i = i11 + 1;
                        charAt = charAt(this.bp + i11);
                        if (charAt < '0' || charAt > c2) {
                            break;
                        }
                        j = (j * 10) + ((long) (charAt - '0'));
                        i11 = i;
                        c2 = '9';
                    }
                } else {
                    j = 0;
                    i = i11;
                }
                if (j < 0) {
                    this.matchStat = -1;
                    return null;
                }
                if (z) {
                    j = -j;
                }
                date = new Date(j);
                i2 = i;
            } else if (charAt == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                this.matchStat = 5;
                charAt = charAt(this.bp + 4);
                date = null;
            } else {
                this.matchStat = -1;
                return null;
            }
        }
        if (charAt == ',') {
            int i12 = this.bp + i2;
            this.bp = i12;
            this.ch = charAt(i12);
            this.matchStat = 3;
            this.token = 16;
            return date;
        } else if (charAt == ']') {
            int i13 = i2 + 1;
            char charAt2 = charAt(this.bp + i2);
            if (charAt2 == ',') {
                this.token = 16;
                int i14 = this.bp + i13;
                this.bp = i14;
                this.ch = charAt(i14);
            } else if (charAt2 == ']') {
                this.token = 15;
                int i15 = this.bp + i13;
                this.bp = i15;
                this.ch = charAt(i15);
            } else if (charAt2 == '}') {
                this.token = 13;
                int i16 = this.bp + i13;
                this.bp = i16;
                this.ch = charAt(i16);
            } else if (charAt2 == 26) {
                this.token = 20;
                this.bp += i13 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public UUID scanFieldUUID(char[] cArr) {
        char c;
        UUID uuid;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        char[] cArr2 = cArr;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr2.length;
        int i15 = length + 1;
        char charAt = charAt(this.bp + length);
        char c2 = 4;
        if (charAt == '\"') {
            int indexOf = indexOf('\"', this.bp + cArr2.length + 1);
            if (indexOf != -1) {
                int length2 = this.bp + cArr2.length + 1;
                int i16 = indexOf - length2;
                char c3 = 'F';
                char c4 = 'f';
                char c5 = 'A';
                char c6 = '0';
                if (i16 == 36) {
                    int i17 = 0;
                    long j = 0;
                    while (i17 < 8) {
                        char charAt2 = charAt(length2 + i17);
                        if (charAt2 < '0' || charAt2 > '9') {
                            if (charAt2 >= 'a' && charAt2 <= 'f') {
                                i14 = charAt2 - 'a';
                            } else if (charAt2 < 'A' || charAt2 > c3) {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i14 = charAt2 - 'A';
                            }
                            i13 = i14 + 10;
                        } else {
                            i13 = charAt2 - '0';
                        }
                        j = (j << 4) | ((long) i13);
                        i17++;
                        indexOf = indexOf;
                        c3 = 'F';
                    }
                    int i18 = indexOf;
                    int i19 = 9;
                    int i20 = 13;
                    while (i19 < i20) {
                        char charAt3 = charAt(length2 + i19);
                        if (charAt3 < '0' || charAt3 > '9') {
                            if (charAt3 >= 'a' && charAt3 <= 'f') {
                                i12 = charAt3 - 'a';
                            } else if (charAt3 < c5 || charAt3 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i12 = charAt3 - 'A';
                            }
                            i11 = i12 + 10;
                        } else {
                            i11 = charAt3 - '0';
                        }
                        j = (j << c2) | ((long) i11);
                        i19++;
                        i20 = 13;
                        c5 = 'A';
                        c2 = 4;
                    }
                    long j2 = j;
                    for (int i21 = 14; i21 < 18; i21++) {
                        char charAt4 = charAt(length2 + i21);
                        if (charAt4 < '0' || charAt4 > '9') {
                            if (charAt4 >= 'a' && charAt4 <= 'f') {
                                i9 = charAt4 - 'a';
                            } else if (charAt4 < 'A' || charAt4 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i9 = charAt4 - 'A';
                            }
                            i10 = i9 + 10;
                        } else {
                            i10 = charAt4 - '0';
                        }
                        j2 = (j2 << 4) | ((long) i10);
                    }
                    long j3 = 0;
                    for (int i22 = 19; i22 < 23; i22++) {
                        char charAt5 = charAt(length2 + i22);
                        if (charAt5 < '0' || charAt5 > '9') {
                            if (charAt5 >= 'a' && charAt5 <= 'f') {
                                i7 = charAt5 - 'a';
                            } else if (charAt5 < 'A' || charAt5 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i7 = charAt5 - 'A';
                            }
                            i8 = i7 + 10;
                        } else {
                            i8 = charAt5 - '0';
                        }
                        j3 = (j3 << 4) | ((long) i8);
                    }
                    int i23 = 24;
                    long j4 = j3;
                    int i24 = 36;
                    while (i23 < i24) {
                        char charAt6 = charAt(length2 + i23);
                        if (charAt6 < c6 || charAt6 > '9') {
                            if (charAt6 >= 'a' && charAt6 <= c4) {
                                i5 = charAt6 - 'a';
                            } else if (charAt6 < 'A' || charAt6 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i5 = charAt6 - 'A';
                            }
                            i6 = i5 + 10;
                        } else {
                            i6 = charAt6 - '0';
                        }
                        j4 = (j4 << 4) | ((long) i6);
                        i23++;
                        i15 = i15;
                        i24 = 36;
                        c6 = '0';
                        c4 = 'f';
                    }
                    uuid = new UUID(j2, j4);
                    int i25 = this.bp;
                    int length3 = i15 + (i18 - ((cArr2.length + i25) + 1)) + 1;
                    i = length3 + 1;
                    c = charAt(i25 + length3);
                } else {
                    int i26 = indexOf;
                    int i27 = i15;
                    if (i16 == 32) {
                        long j5 = 0;
                        for (int i28 = 0; i28 < 16; i28++) {
                            char charAt7 = charAt(length2 + i28);
                            if (charAt7 < '0' || charAt7 > '9') {
                                if (charAt7 >= 'a' && charAt7 <= 'f') {
                                    i3 = charAt7 - 'a';
                                } else if (charAt7 < 'A' || charAt7 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i3 = charAt7 - 'A';
                                }
                                i4 = i3 + 10;
                            } else {
                                i4 = charAt7 - '0';
                            }
                            j5 = (j5 << 4) | ((long) i4);
                        }
                        int i29 = 16;
                        long j6 = 0;
                        for (int i30 = 32; i29 < i30; i30 = 32) {
                            char charAt8 = charAt(length2 + i29);
                            if (charAt8 >= '0' && charAt8 <= '9') {
                                i2 = charAt8 - '0';
                            } else if (charAt8 >= 'a' && charAt8 <= 'f') {
                                i2 = (charAt8 - 'a') + 10;
                            } else if (charAt8 < 'A' || charAt8 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i2 = (charAt8 - 'A') + 10;
                                j6 = (j6 << 4) | ((long) i2);
                                i29++;
                            }
                            j6 = (j6 << 4) | ((long) i2);
                            i29++;
                        }
                        uuid = new UUID(j5, j6);
                        int i31 = this.bp;
                        int length4 = i27 + (i26 - ((cArr2.length + i31) + 1)) + 1;
                        i = length4 + 1;
                        c = charAt(i31 + length4);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            int i32 = i15;
            if (charAt == 'n') {
                int i33 = i32 + 1;
                if (charAt(this.bp + i32) == 'u') {
                    int i34 = i33 + 1;
                    if (charAt(this.bp + i33) == 'l') {
                        int i35 = i34 + 1;
                        if (charAt(this.bp + i34) == 'l') {
                            c = charAt(this.bp + i35);
                            i = i35 + 1;
                            uuid = null;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return null;
        }
        if (c == ',') {
            int i36 = this.bp + i;
            this.bp = i36;
            this.ch = charAt(i36);
            this.matchStat = 3;
            return uuid;
        } else if (c == '}') {
            int i37 = i + 1;
            char charAt9 = charAt(this.bp + i);
            if (charAt9 == ',') {
                this.token = 16;
                int i38 = this.bp + i37;
                this.bp = i38;
                this.ch = charAt(i38);
            } else if (charAt9 == ']') {
                this.token = 15;
                int i39 = this.bp + i37;
                this.bp = i39;
                this.ch = charAt(i39);
            } else if (charAt9 == '}') {
                this.token = 13;
                int i40 = this.bp + i37;
                this.bp = i40;
                this.ch = charAt(i40);
            } else if (charAt9 == 26) {
                this.token = 20;
                this.bp += i37 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return uuid;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public UUID scanUUID(char c) {
        char c2;
        int i;
        UUID uuid;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        int i15 = 13;
        char c3 = 4;
        if (charAt == '\"') {
            int indexOf = indexOf('\"', this.bp + 1);
            if (indexOf != -1) {
                int i16 = this.bp + 1;
                int i17 = indexOf - i16;
                char c4 = 'f';
                char c5 = 'A';
                char c6 = 'a';
                if (i17 == 36) {
                    int i18 = 0;
                    long j = 0;
                    while (i18 < 8) {
                        char charAt2 = charAt(i16 + i18);
                        if (charAt2 < '0' || charAt2 > '9') {
                            if (charAt2 >= 'a' && charAt2 <= c4) {
                                i14 = charAt2 - 'a';
                            } else if (charAt2 < 'A' || charAt2 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i14 = charAt2 - 'A';
                            }
                            i13 = i14 + 10;
                        } else {
                            i13 = charAt2 - '0';
                        }
                        j = (j << 4) | ((long) i13);
                        i18++;
                        c4 = 'f';
                    }
                    int i19 = 9;
                    while (i19 < i15) {
                        char charAt3 = charAt(i16 + i19);
                        if (charAt3 < '0' || charAt3 > '9') {
                            if (charAt3 >= 'a' && charAt3 <= 'f') {
                                i12 = charAt3 - 'a';
                            } else if (charAt3 < c5 || charAt3 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i12 = charAt3 - 'A';
                            }
                            i11 = i12 + 10;
                        } else {
                            i11 = charAt3 - '0';
                        }
                        j = (j << 4) | ((long) i11);
                        i19++;
                        i15 = 13;
                        c5 = 'A';
                    }
                    long j2 = j;
                    for (int i20 = 14; i20 < 18; i20++) {
                        char charAt4 = charAt(i16 + i20);
                        if (charAt4 < '0' || charAt4 > '9') {
                            if (charAt4 >= 'a' && charAt4 <= 'f') {
                                i10 = charAt4 - 'a';
                            } else if (charAt4 < 'A' || charAt4 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i10 = charAt4 - 'A';
                            }
                            i9 = i10 + 10;
                        } else {
                            i9 = charAt4 - '0';
                        }
                        j2 = (j2 << 4) | ((long) i9);
                    }
                    int i21 = 19;
                    long j3 = 0;
                    while (i21 < 23) {
                        char charAt5 = charAt(i16 + i21);
                        if (charAt5 < '0' || charAt5 > '9') {
                            if (charAt5 >= c6 && charAt5 <= 'f') {
                                i8 = charAt5 - 'a';
                            } else if (charAt5 < 'A' || charAt5 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i8 = charAt5 - 'A';
                            }
                            i7 = i8 + 10;
                        } else {
                            i7 = charAt5 - '0';
                        }
                        j3 = (j3 << c3) | ((long) i7);
                        i21++;
                        c6 = 'a';
                        c3 = 4;
                    }
                    long j4 = j3;
                    for (int i22 = 24; i22 < 36; i22++) {
                        char charAt6 = charAt(i16 + i22);
                        if (charAt6 < '0' || charAt6 > '9') {
                            if (charAt6 >= 'a' && charAt6 <= 'f') {
                                i5 = charAt6 - 'a';
                            } else if (charAt6 < 'A' || charAt6 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i5 = charAt6 - 'A';
                            }
                            i6 = i5 + 10;
                        } else {
                            i6 = charAt6 - '0';
                        }
                        j4 = (j4 << 4) | ((long) i6);
                    }
                    uuid = new UUID(j2, j4);
                    int i23 = this.bp;
                    int i24 = 1 + (indexOf - (i23 + 1)) + 1;
                    i = i24 + 1;
                    c2 = charAt(i23 + i24);
                } else {
                    if (i17 == 32) {
                        long j5 = 0;
                        for (int i25 = 0; i25 < 16; i25++) {
                            char charAt7 = charAt(i16 + i25);
                            if (charAt7 < '0' || charAt7 > '9') {
                                if (charAt7 >= 'a' && charAt7 <= 'f') {
                                    i3 = charAt7 - 'a';
                                } else if (charAt7 < 'A' || charAt7 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i3 = charAt7 - 'A';
                                }
                                i4 = i3 + 10;
                            } else {
                                i4 = charAt7 - '0';
                            }
                            j5 = (j5 << 4) | ((long) i4);
                        }
                        int i26 = 16;
                        long j6 = 0;
                        for (int i27 = 32; i26 < i27; i27 = 32) {
                            char charAt8 = charAt(i16 + i26);
                            if (charAt8 >= '0' && charAt8 <= '9') {
                                i2 = charAt8 - '0';
                            } else if (charAt8 >= 'a' && charAt8 <= 'f') {
                                i2 = (charAt8 - 'a') + 10;
                            } else if (charAt8 < 'A' || charAt8 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i2 = (charAt8 - 'A') + 10;
                            }
                            j6 = (j6 << 4) | ((long) i2);
                            i26++;
                        }
                        uuid = new UUID(j5, j6);
                        int i28 = this.bp;
                        int i29 = 1 + (indexOf - (i28 + 1)) + 1;
                        i = i29 + 1;
                        c2 = charAt(i28 + i29);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (charAt == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
            i = 5;
            c2 = charAt(this.bp + 4);
            uuid = null;
        } else {
            this.matchStat = -1;
            return null;
        }
        if (c2 == ',') {
            int i30 = this.bp + i;
            this.bp = i30;
            this.ch = charAt(i30);
            this.matchStat = 3;
            return uuid;
        } else if (c2 == ']') {
            int i31 = i + 1;
            char charAt9 = charAt(this.bp + i);
            if (charAt9 == ',') {
                this.token = 16;
                int i32 = this.bp + i31;
                this.bp = i32;
                this.ch = charAt(i32);
            } else if (charAt9 == ']') {
                this.token = 15;
                int i33 = this.bp + i31;
                this.bp = i33;
                this.ch = charAt(i33);
            } else if (charAt9 == '}') {
                this.token = 13;
                int i34 = this.bp + i31;
                this.bp = i34;
                this.ch = charAt(i34);
            } else if (charAt9 == 26) {
                this.token = 20;
                this.bp += i31 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return uuid;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public final void scanTrue() {
        if (this.ch == 't') {
            next();
            if (this.ch == 'r') {
                next();
                if (this.ch == 'u') {
                    next();
                    if (this.ch == 'e') {
                        next();
                        char c = this.ch;
                        if (c == ' ' || c == ',' || c == '}' || c == ']' || c == 10 || c == 13 || c == 9 || c == 26 || c == 12 || c == 8 || c == ':' || c == '/') {
                            this.token = 6;
                            return;
                        }
                        throw new JSONException("scan true error");
                    }
                    throw new JSONException("error parse true");
                }
                throw new JSONException("error parse true");
            }
            throw new JSONException("error parse true");
        }
        throw new JSONException("error parse true");
    }

    public final void scanNullOrNew() {
        scanNullOrNew(true);
    }

    public final void scanNullOrNew(boolean z) {
        if (this.ch == 'n') {
            next();
            char c = this.ch;
            if (c == 'u') {
                next();
                if (this.ch == 'l') {
                    next();
                    if (this.ch == 'l') {
                        next();
                        char c2 = this.ch;
                        if (c2 == ' ' || c2 == ',' || c2 == '}' || c2 == ']' || c2 == 10 || c2 == 13 || c2 == 9 || c2 == 26 || ((c2 == ':' && z) || c2 == 12 || c2 == 8)) {
                            this.token = 8;
                            return;
                        }
                        throw new JSONException("scan null error");
                    }
                    throw new JSONException("error parse null");
                }
                throw new JSONException("error parse null");
            } else if (c == 'e') {
                next();
                if (this.ch == 'w') {
                    next();
                    char c3 = this.ch;
                    if (c3 == ' ' || c3 == ',' || c3 == '}' || c3 == ']' || c3 == 10 || c3 == 13 || c3 == 9 || c3 == 26 || c3 == 12 || c3 == 8) {
                        this.token = 9;
                        return;
                    }
                    throw new JSONException("scan new error");
                }
                throw new JSONException("error parse new");
            } else {
                throw new JSONException("error parse new");
            }
        } else {
            throw new JSONException("error parse null or new");
        }
    }

    public final void scanFalse() {
        if (this.ch == 'f') {
            next();
            if (this.ch == 'a') {
                next();
                if (this.ch == 'l') {
                    next();
                    if (this.ch == 's') {
                        next();
                        if (this.ch == 'e') {
                            next();
                            char c = this.ch;
                            if (c == ' ' || c == ',' || c == '}' || c == ']' || c == 10 || c == 13 || c == 9 || c == 26 || c == 12 || c == 8 || c == ':' || c == '/') {
                                this.token = 7;
                                return;
                            }
                            throw new JSONException("scan false error");
                        }
                        throw new JSONException("error parse false");
                    }
                    throw new JSONException("error parse false");
                }
                throw new JSONException("error parse false");
            }
            throw new JSONException("error parse false");
        }
        throw new JSONException("error parse false");
    }

    public final void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        if ("null".equalsIgnoreCase(stringVal)) {
            this.token = 8;
        } else if ("new".equals(stringVal)) {
            this.token = 9;
        } else if ("true".equals(stringVal)) {
            this.token = 6;
        } else if ("false".equals(stringVal)) {
            this.token = 7;
        } else if ("undefined".equals(stringVal)) {
            this.token = 23;
        } else if ("Set".equals(stringVal)) {
            this.token = 21;
        } else if ("TreeSet".equals(stringVal)) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    public static String readString(char[] cArr, int i) {
        int i2;
        int i3;
        char[] cArr2 = new char[i];
        int i4 = 0;
        int i5 = 0;
        while (i2 < i) {
            char c = cArr[i2];
            if (c != '\\') {
                cArr2[i5] = c;
                i5++;
            } else {
                i2++;
                char c2 = cArr[i2];
                if (c2 == '\"') {
                    i3 = i5 + 1;
                    cArr2[i5] = '\"';
                } else if (c2 != '\'') {
                    if (c2 != 'F') {
                        if (c2 == '\\') {
                            i3 = i5 + 1;
                            cArr2[i5] = '\\';
                        } else if (c2 == 'b') {
                            i3 = i5 + 1;
                            cArr2[i5] = 8;
                        } else if (c2 != 'f') {
                            if (c2 == 'n') {
                                i3 = i5 + 1;
                                cArr2[i5] = 10;
                            } else if (c2 == 'r') {
                                i3 = i5 + 1;
                                cArr2[i5] = 13;
                            } else if (c2 != 'x') {
                                switch (c2) {
                                    case '/':
                                        i3 = i5 + 1;
                                        cArr2[i5] = '/';
                                        break;
                                    case '0':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 0;
                                        break;
                                    case '1':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 1;
                                        break;
                                    case '2':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 2;
                                        break;
                                    case '3':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 3;
                                        break;
                                    case '4':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 4;
                                        break;
                                    case '5':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 5;
                                        break;
                                    case '6':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 6;
                                        break;
                                    case '7':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 7;
                                        break;
                                    default:
                                        switch (c2) {
                                            case 't':
                                                i3 = i5 + 1;
                                                cArr2[i5] = 9;
                                                break;
                                            case 'u':
                                                i3 = i5 + 1;
                                                int i6 = i2 + 1;
                                                int i7 = i6 + 1;
                                                int i8 = i7 + 1;
                                                i2 = i8 + 1;
                                                cArr2[i5] = (char) Integer.parseInt(new String(new char[]{cArr[i6], cArr[i7], cArr[i8], cArr[i2]}), 16);
                                                break;
                                            case 'v':
                                                i3 = i5 + 1;
                                                cArr2[i5] = 11;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i3 = i5 + 1;
                                int[] iArr = digits;
                                int i9 = i2 + 1;
                                i2 = i9 + 1;
                                cArr2[i5] = (char) ((iArr[cArr[i9]] * 16) + iArr[cArr[i2]]);
                            }
                        }
                    }
                    i3 = i5 + 1;
                    cArr2[i5] = 12;
                } else {
                    i3 = i5 + 1;
                    cArr2[i5] = '\'';
                }
                i5 = i3;
            }
            i4 = i2 + 1;
        }
        return new String(cArr2, 0, i5);
    }

    public boolean isBlankInput() {
        int i = 0;
        while (true) {
            char charAt = charAt(i);
            if (charAt == 26) {
                this.token = 20;
                return true;
            } else if (!isWhitespace(charAt)) {
                return false;
            } else {
                i++;
            }
        }
    }

    public final void skipWhitespace() {
        while (true) {
            char c = this.ch;
            if (c > '/') {
                return;
            }
            if (c == ' ' || c == 13 || c == 10 || c == 9 || c == 12 || c == 8) {
                next();
            } else if (c == '/') {
                skipComment();
            } else {
                return;
            }
        }
    }

    private void scanStringSingleQuote() {
        char next;
        char next2;
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next3 = next();
            if (next3 == '\'') {
                this.token = 4;
                next();
                return;
            } else if (next3 != 26) {
                boolean z = true;
                if (next3 == '\\') {
                    if (!this.hasSpecial) {
                        this.hasSpecial = true;
                        int i = this.sp;
                        char[] cArr = this.sbuf;
                        if (i > cArr.length) {
                            char[] cArr2 = new char[(i * 2)];
                            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                            this.sbuf = cArr2;
                        }
                        copyTo(this.np + 1, this.sp, this.sbuf);
                    }
                    char next4 = next();
                    if (next4 == '\"') {
                        putChar('\"');
                    } else if (next4 != '\'') {
                        if (next4 != 'F') {
                            if (next4 == '\\') {
                                putChar('\\');
                            } else if (next4 == 'b') {
                                putChar(8);
                            } else if (next4 != 'f') {
                                if (next4 == 'n') {
                                    putChar(10);
                                } else if (next4 == 'r') {
                                    putChar(13);
                                } else if (next4 != 'x') {
                                    switch (next4) {
                                        case '/':
                                            putChar('/');
                                            break;
                                        case '0':
                                            putChar(0);
                                            break;
                                        case '1':
                                            putChar(1);
                                            break;
                                        case '2':
                                            putChar(2);
                                            break;
                                        case '3':
                                            putChar(3);
                                            break;
                                        case '4':
                                            putChar(4);
                                            break;
                                        case '5':
                                            putChar(5);
                                            break;
                                        case '6':
                                            putChar(6);
                                            break;
                                        case '7':
                                            putChar(7);
                                            break;
                                        default:
                                            switch (next4) {
                                                case 't':
                                                    putChar(9);
                                                    break;
                                                case 'u':
                                                    putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                    break;
                                                case 'v':
                                                    putChar(11);
                                                    break;
                                                default:
                                                    this.ch = next4;
                                                    throw new JSONException("unclosed single-quote string");
                                            }
                                    }
                                } else {
                                    next = next();
                                    next2 = next();
                                    boolean z2 = (next >= '0' && next <= '9') || (next >= 'a' && next <= 'f') || (next >= 'A' && next <= 'F');
                                    if ((next2 < '0' || next2 > '9') && ((next2 < 'a' || next2 > 'f') && (next2 < 'A' || next2 > 'F'))) {
                                        z = false;
                                    }
                                    if (!z2 || !z) {
                                    } else {
                                        int[] iArr = digits;
                                        putChar((char) ((iArr[next] * 16) + iArr[next2]));
                                    }
                                }
                            }
                        }
                        putChar(12);
                    } else {
                        putChar('\'');
                    }
                } else if (!this.hasSpecial) {
                    this.sp++;
                } else {
                    int i2 = this.sp;
                    char[] cArr3 = this.sbuf;
                    if (i2 == cArr3.length) {
                        putChar(next3);
                    } else {
                        this.sp = i2 + 1;
                        cArr3[i2] = next3;
                    }
                }
            } else if (!isEOF()) {
                putChar(JSONLexer.EOI);
            } else {
                throw new JSONException("unclosed single-quote string");
            }
        }
        throw new JSONException("invalid escape character \\x" + next + next2);
    }

    /* access modifiers changed from: protected */
    public final void putChar(char c) {
        int i = this.sp;
        char[] cArr = this.sbuf;
        if (i == cArr.length) {
            char[] cArr2 = new char[(cArr.length * 2)];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.sbuf = cArr2;
        }
        char[] cArr3 = this.sbuf;
        int i2 = this.sp;
        this.sp = i2 + 1;
        cArr3[i2] = c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void scanHex() {
        /*
            r5 = this;
            char r0 = r5.ch
            java.lang.String r1 = "illegal state. "
            r2 = 120(0x78, float:1.68E-43)
            if (r0 != r2) goto L_0x0079
            r5.next()
            char r0 = r5.ch
            r2 = 39
            if (r0 != r2) goto L_0x0062
            int r0 = r5.bp
            r5.np = r0
            r5.next()
            char r0 = r5.ch
            r3 = 26
            if (r0 != r2) goto L_0x0024
            r5.next()
            r5.token = r3
            return
        L_0x0024:
            char r0 = r5.next()
            r4 = 48
            if (r0 < r4) goto L_0x0030
            r4 = 57
            if (r0 <= r4) goto L_0x0038
        L_0x0030:
            r4 = 65
            if (r0 < r4) goto L_0x003f
            r4 = 70
            if (r0 > r4) goto L_0x003f
        L_0x0038:
            int r0 = r5.sp
            int r0 = r0 + 1
            r5.sp = r0
            goto L_0x0024
        L_0x003f:
            if (r0 != r2) goto L_0x004d
            int r0 = r5.sp
            int r0 = r0 + 1
            r5.sp = r0
            r5.next()
            r5.token = r3
            return
        L_0x004d:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x0062:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            char r1 = r5.ch
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0079:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            char r1 = r5.ch
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanHex():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void scanNumber() {
        /*
            r9 = this;
            int r0 = r9.bp
            r9.np = r0
            char r0 = r9.ch
            r1 = 45
            r2 = 1
            if (r0 != r1) goto L_0x0013
            int r0 = r9.sp
            int r0 = r0 + r2
            r9.sp = r0
            r9.next()
        L_0x0013:
            char r0 = r9.ch
            r3 = 57
            r4 = 48
            if (r0 < r4) goto L_0x0026
            if (r0 > r3) goto L_0x0026
            int r0 = r9.sp
            int r0 = r0 + r2
            r9.sp = r0
            r9.next()
            goto L_0x0013
        L_0x0026:
            r5 = 0
            r6 = 46
            if (r0 != r6) goto L_0x0043
            int r0 = r9.sp
            int r0 = r0 + r2
            r9.sp = r0
            r9.next()
        L_0x0033:
            char r0 = r9.ch
            if (r0 < r4) goto L_0x0042
            if (r0 > r3) goto L_0x0042
            int r0 = r9.sp
            int r0 = r0 + r2
            r9.sp = r0
            r9.next()
            goto L_0x0033
        L_0x0042:
            r5 = r2
        L_0x0043:
            char r0 = r9.ch
            r6 = 76
            if (r0 != r6) goto L_0x0052
            int r0 = r9.sp
            int r0 = r0 + r2
            r9.sp = r0
            r9.next()
            goto L_0x008f
        L_0x0052:
            r6 = 83
            if (r0 != r6) goto L_0x005f
            int r0 = r9.sp
            int r0 = r0 + r2
            r9.sp = r0
            r9.next()
            goto L_0x008f
        L_0x005f:
            r6 = 66
            if (r0 != r6) goto L_0x006c
            int r0 = r9.sp
            int r0 = r0 + r2
            r9.sp = r0
            r9.next()
            goto L_0x008f
        L_0x006c:
            r6 = 70
            if (r0 != r6) goto L_0x0079
            int r0 = r9.sp
            int r0 = r0 + r2
            r9.sp = r0
            r9.next()
            goto L_0x00c4
        L_0x0079:
            r7 = 68
            if (r0 != r7) goto L_0x0086
            int r0 = r9.sp
            int r0 = r0 + r2
            r9.sp = r0
            r9.next()
            goto L_0x00c4
        L_0x0086:
            r8 = 101(0x65, float:1.42E-43)
            if (r0 == r8) goto L_0x0091
            r8 = 69
            if (r0 != r8) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r2 = r5
            goto L_0x00c4
        L_0x0091:
            int r0 = r9.sp
            int r0 = r0 + r2
            r9.sp = r0
            r9.next()
            char r0 = r9.ch
            r5 = 43
            if (r0 == r5) goto L_0x00a1
            if (r0 != r1) goto L_0x00a9
        L_0x00a1:
            int r0 = r9.sp
            int r0 = r0 + r2
            r9.sp = r0
            r9.next()
        L_0x00a9:
            char r0 = r9.ch
            if (r0 < r4) goto L_0x00b8
            if (r0 > r3) goto L_0x00b8
            int r0 = r9.sp
            int r0 = r0 + r2
            r9.sp = r0
            r9.next()
            goto L_0x00a9
        L_0x00b8:
            if (r0 == r7) goto L_0x00bc
            if (r0 != r6) goto L_0x00c4
        L_0x00bc:
            int r0 = r9.sp
            int r0 = r0 + r2
            r9.sp = r0
            r9.next()
        L_0x00c4:
            if (r2 == 0) goto L_0x00ca
            r0 = 3
            r9.token = r0
            goto L_0x00cd
        L_0x00ca:
            r0 = 2
            r9.token = r0
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanNumber():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long longValue() throws java.lang.NumberFormatException {
        /*
            r15 = this;
            int r0 = r15.np
            r1 = 0
            r2 = -1
            if (r0 != r2) goto L_0x0008
            r15.np = r1
        L_0x0008:
            int r0 = r15.np
            int r2 = r15.sp
            int r2 = r2 + r0
            char r3 = r15.charAt(r0)
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L_0x001c
            r3 = -9223372036854775808
            int r0 = r0 + 1
            r1 = r5
            goto L_0x0021
        L_0x001c:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0021:
            r6 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            if (r0 >= r2) goto L_0x0034
            int r8 = r0 + 1
            char r0 = r15.charAt(r0)
            int r0 = r0 + -48
            int r0 = -r0
            long r9 = (long) r0
        L_0x0032:
            r0 = r8
            goto L_0x0036
        L_0x0034:
            r9 = 0
        L_0x0036:
            if (r0 >= r2) goto L_0x0072
            int r8 = r0 + 1
            char r0 = r15.charAt(r0)
            r11 = 76
            if (r0 == r11) goto L_0x0071
            r11 = 83
            if (r0 == r11) goto L_0x0071
            r11 = 66
            if (r0 != r11) goto L_0x004b
            goto L_0x0071
        L_0x004b:
            int r0 = r0 + -48
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 < 0) goto L_0x0067
            r11 = 10
            long r9 = r9 * r11
            long r11 = (long) r0
            long r13 = r3 + r11
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 < 0) goto L_0x005d
            long r9 = r9 - r11
            goto L_0x0032
        L_0x005d:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L_0x0067:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L_0x0071:
            r0 = r8
        L_0x0072:
            if (r1 == 0) goto L_0x0084
            int r1 = r15.np
            int r1 = r1 + r5
            if (r0 <= r1) goto L_0x007a
            return r9
        L_0x007a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L_0x0084:
            long r0 = -r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.longValue():long");
    }

    public final Number decimalValue(boolean z) {
        char charAt = charAt((this.np + this.sp) - 1);
        if (charAt == 'F') {
            try {
                return Float.valueOf(Float.parseFloat(numberString()));
            } catch (NumberFormatException e) {
                throw new JSONException(e.getMessage() + ", " + info());
            }
        } else if (charAt == 'D') {
            return Double.valueOf(Double.parseDouble(numberString()));
        } else {
            if (z) {
                return decimalValue();
            }
            return Double.valueOf(doubleValue());
        }
    }

    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        throw new UnsupportedOperationException();
    }

    public boolean matchField2(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    public int getFeatures() {
        return this.features;
    }
}
