package com.bonree.sdk.common.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

public class JSONTokener {
    private long character;
    private boolean eof;
    private long index;
    private long line;
    private char previous;
    private Reader reader;
    private boolean usePrevious;

    public static int dehexchar(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        if (c < 'a' || c > 'f') {
            return -1;
        }
        return c - 'W';
    }

    public JSONTokener(Reader reader2) {
        this.reader = !reader2.markSupported() ? new BufferedReader(reader2) : reader2;
        this.eof = false;
        this.usePrevious = false;
        this.previous = 0;
        this.index = 0;
        this.character = 1;
        this.line = 1;
    }

    public JSONTokener(InputStream inputStream) throws JSONException {
        this((Reader) new InputStreamReader(inputStream));
    }

    public JSONTokener(String str) {
        this((Reader) new StringReader(str));
    }

    public void back() throws JSONException {
        if (!this.usePrevious) {
            long j = this.index;
            if (j > 0) {
                this.index = j - 1;
                this.character--;
                this.usePrevious = true;
                this.eof = false;
                return;
            }
        }
        throw new JSONException("Stepping back two steps is not supported");
    }

    public boolean end() {
        return this.eof && !this.usePrevious;
    }

    public boolean more() throws JSONException {
        next();
        if (end()) {
            return false;
        }
        back();
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: char} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public char next() throws com.bonree.sdk.common.json.JSONException {
        /*
            r10 = this;
            boolean r0 = r10.usePrevious
            r1 = 0
            if (r0 == 0) goto L_0x000a
            r10.usePrevious = r1
            char r1 = r10.previous
            goto L_0x0017
        L_0x000a:
            java.io.Reader r0 = r10.reader     // Catch:{ IOException -> 0x0046 }
            int r0 = r0.read()     // Catch:{ IOException -> 0x0046 }
            if (r0 > 0) goto L_0x0016
            r0 = 1
            r10.eof = r0
            goto L_0x0017
        L_0x0016:
            r1 = r0
        L_0x0017:
            long r2 = r10.index
            r4 = 1
            long r2 = r2 + r4
            r10.index = r2
            char r0 = r10.previous
            r2 = 13
            r6 = 0
            r3 = 10
            if (r0 != r2) goto L_0x0033
            long r8 = r10.line
            long r8 = r8 + r4
            r10.line = r8
            if (r1 != r3) goto L_0x0030
            r4 = r6
        L_0x0030:
            r10.character = r4
            goto L_0x0042
        L_0x0033:
            if (r1 != r3) goto L_0x003d
            long r2 = r10.line
            long r2 = r2 + r4
            r10.line = r2
            r10.character = r6
            goto L_0x0042
        L_0x003d:
            long r2 = r10.character
            long r2 = r2 + r4
            r10.character = r2
        L_0x0042:
            char r0 = (char) r1
            r10.previous = r0
            return r0
        L_0x0046:
            r0 = move-exception
            com.bonree.sdk.common.json.JSONException r1 = new com.bonree.sdk.common.json.JSONException
            r1.<init>((java.lang.Throwable) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.common.json.JSONTokener.next():char");
    }

    public char next(char c) throws JSONException {
        char next = next();
        if (next == c) {
            return next;
        }
        throw syntaxError("Expected '" + c + "' and instead saw '" + next + "'");
    }

    public String next(int i) throws JSONException {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        int i2 = 0;
        while (i2 < i) {
            cArr[i2] = next();
            if (!end()) {
                i2++;
            } else {
                throw syntaxError("Substring bounds error");
            }
        }
        return new String(cArr);
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public char nextClean() throws com.bonree.sdk.common.json.JSONException {
        /*
            r2 = this;
        L_0x0000:
            char r0 = r2.next()
            if (r0 == 0) goto L_0x000a
            r1 = 32
            if (r0 <= r1) goto L_0x0000
        L_0x000a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.common.json.JSONTokener.nextClean():char");
    }

    public String nextString(char c) throws JSONException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            char next = next();
            if (next != 0 && next != 10 && next != 13) {
                if (next == '\\') {
                    char next2 = next();
                    if (next2 == '\"' || next2 == '\'' || next2 == '/' || next2 == '\\') {
                        stringBuffer.append(next2);
                    } else if (next2 == 'b') {
                        stringBuffer.append(8);
                    } else if (next2 == 'f') {
                        stringBuffer.append(12);
                    } else if (next2 == 'n') {
                        stringBuffer.append(10);
                    } else if (next2 == 'r') {
                        stringBuffer.append(13);
                    } else if (next2 == 't') {
                        stringBuffer.append(9);
                    } else if (next2 == 'u') {
                        stringBuffer.append((char) Integer.parseInt(next(4), 16));
                    } else {
                        throw syntaxError("Illegal escape.");
                    }
                } else if (next == c) {
                    return stringBuffer.toString();
                } else {
                    stringBuffer.append(next);
                }
            }
        }
        throw syntaxError("Unterminated string");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String nextTo(char r4) throws com.bonree.sdk.common.json.JSONException {
        /*
            r3 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
        L_0x0005:
            char r1 = r3.next()
            if (r1 == r4) goto L_0x001a
            if (r1 == 0) goto L_0x001a
            r2 = 10
            if (r1 == r2) goto L_0x001a
            r2 = 13
            if (r1 != r2) goto L_0x0016
            goto L_0x001a
        L_0x0016:
            r0.append(r1)
            goto L_0x0005
        L_0x001a:
            if (r1 == 0) goto L_0x001f
            r3.back()
        L_0x001f:
            java.lang.String r4 = r0.toString()
            java.lang.String r4 = r4.trim()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.common.json.JSONTokener.nextTo(char):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String nextTo(java.lang.String r4) throws com.bonree.sdk.common.json.JSONException {
        /*
            r3 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
        L_0x0005:
            char r1 = r3.next()
            int r2 = r4.indexOf(r1)
            if (r2 >= 0) goto L_0x001e
            if (r1 == 0) goto L_0x001e
            r2 = 10
            if (r1 == r2) goto L_0x001e
            r2 = 13
            if (r1 != r2) goto L_0x001a
            goto L_0x001e
        L_0x001a:
            r0.append(r1)
            goto L_0x0005
        L_0x001e:
            if (r1 == 0) goto L_0x0023
            r3.back()
        L_0x0023:
            java.lang.String r4 = r0.toString()
            java.lang.String r4 = r4.trim()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.common.json.JSONTokener.nextTo(java.lang.String):java.lang.String");
    }

    public Object nextValue() throws JSONException {
        char nextClean = nextClean();
        if (nextClean == '\"' || nextClean == '\'') {
            return nextString(nextClean);
        }
        if (nextClean == '[') {
            back();
            return new JSONArray(this);
        } else if (nextClean != '{') {
            StringBuffer stringBuffer = new StringBuffer();
            while (nextClean >= ' ' && ",:]}/\\\"[{;=#".indexOf(nextClean) < 0) {
                stringBuffer.append(nextClean);
                nextClean = next();
            }
            back();
            String trim = stringBuffer.toString().trim();
            if (!"".equals(trim)) {
                return JSONObject.stringToValue(trim);
            }
            throw syntaxError("Missing value");
        } else {
            back();
            return new JSONObject(this);
        }
    }

    public char skipTo(char c) throws JSONException {
        char next;
        try {
            long j = this.index;
            long j2 = this.character;
            long j3 = this.line;
            this.reader.mark(1000000);
            do {
                next = next();
                if (next == 0) {
                    this.reader.reset();
                    this.index = j;
                    this.character = j2;
                    this.line = j3;
                    return next;
                }
            } while (next != c);
            back();
            return next;
        } catch (IOException e) {
            throw new JSONException((Throwable) e);
        }
    }

    public JSONException syntaxError(String str) {
        return new JSONException(str + toString());
    }

    public String toString() {
        return " at " + this.index + " [character " + this.character + " line " + this.line + "]";
    }
}
