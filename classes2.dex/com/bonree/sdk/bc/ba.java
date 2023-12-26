package com.bonree.sdk.bc;

import android.util.Log;
import com.bonree.sdk.bc.dd;
import com.bonree.sdk.bc.u;
import com.bonree.sdk.bc.w;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ba {
    private bn a;
    private File b;
    private ca c;
    private long d;
    private ba e;
    private dd f;
    private int g;
    private int h;
    private long i;
    private boolean j;
    private u.a k;
    private List l;
    private boolean m;

    private ba(File file, bn bnVar, long j2) throws IOException {
        this.c = null;
        this.e = null;
        if (bnVar == null || bnVar.b()) {
            this.b = file;
            this.f = new dd(file);
            this.a = bnVar;
            this.d = j2;
            return;
        }
        throw new w.d(bnVar);
    }

    private ba(String str, bn bnVar, long j2) throws IOException {
        this(new File(str), bnVar, j2);
    }

    public ba(String str, bn bnVar) throws IOException {
        this(new File(str), bnVar, -1);
    }

    public ba(String str) throws IOException {
        this(new File(str), (bn) null, -1);
    }

    private ba(InputStream inputStream, bn bnVar, long j2) {
        this.c = null;
        this.e = null;
        if (bnVar == null || bnVar.b()) {
            this.f = new dd(inputStream);
            this.a = bnVar;
            this.d = -1;
            return;
        }
        throw new w.d(bnVar);
    }

    private ba(InputStream inputStream, bn bnVar) {
        this(inputStream, bnVar, -1);
    }

    private ba(InputStream inputStream) {
        this(inputStream, (bn) null, -1);
    }

    private bn a(String str, bn bnVar) throws dc {
        try {
            return bn.a(str, bnVar);
        } catch (dc e2) {
            throw this.f.a(e2.getMessage());
        }
    }

    private void b() throws IOException {
        boolean z;
        String c2 = this.f.c();
        int a2 = p.a(c2);
        this.h = a2;
        if (a2 >= 0) {
            c2 = this.f.c();
            z = true;
        } else {
            z = false;
        }
        this.i = -1;
        try {
            this.i = e.a(c2, true);
            c2 = this.f.c();
        } catch (NumberFormatException unused) {
            long j2 = this.d;
            if (j2 >= 0) {
                this.i = j2;
            } else {
                ca caVar = this.c;
                if (caVar != null) {
                    this.i = caVar.s();
                }
            }
        }
        if (!z) {
            int a3 = p.a(c2);
            this.h = a3;
            if (a3 >= 0) {
                c2 = this.f.c();
            } else {
                this.h = 1;
            }
        }
        int a4 = df.a(c2);
        this.g = a4;
        if (a4 < 0) {
            throw this.f.a("Invalid type '" + c2 + "'");
        } else if (this.i >= 0) {
        } else {
            if (a4 == 6) {
                this.j = true;
                this.i = 0;
                return;
            }
            throw this.f.a("missing TTL");
        }
    }

    private static long a(String str) {
        if (!Character.isDigit(str.charAt(0))) {
            return -1;
        }
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong < 0 || parseLong > 4294967295L) {
                return -1;
            }
            return parseLong;
        } catch (NumberFormatException unused) {
        }
    }

    private void c() throws IOException {
        String d2 = this.f.d();
        int indexOf = d2.indexOf("-");
        if (indexOf >= 0) {
            String substring = d2.substring(0, indexOf);
            String substring2 = d2.substring(indexOf + 1);
            String str = null;
            int indexOf2 = substring2.indexOf("/");
            if (indexOf2 >= 0) {
                str = substring2.substring(indexOf2 + 1);
                substring2 = substring2.substring(0, indexOf2);
            }
            long a2 = a(substring);
            long a3 = a(substring2);
            long a4 = str != null ? a(str) : 1;
            if (a2 < 0 || a3 < 0 || a2 > a3 || a4 <= 0) {
                dd ddVar = this.f;
                throw ddVar.a("Invalid $GENERATE range specifier: " + d2);
            }
            String d3 = this.f.d();
            b();
            if (u.a.a(this.g)) {
                String d4 = this.f.d();
                this.f.k();
                this.f.b();
                this.k = new u.a(a2, a3, a4, d3, this.g, this.h, this.i, d4, this.a);
                if (this.l == null) {
                    this.l = new ArrayList(1);
                }
                this.l.add(this.k);
                return;
            }
            dd ddVar2 = this.f;
            throw ddVar2.a("$GENERATE does not support " + df.b(this.g) + " records");
        }
        dd ddVar3 = this.f;
        throw ddVar3.a("Invalid $GENERATE range specifier: " + d2);
    }

    private void d() throws IOException {
        this.f.k();
        this.k = null;
    }

    private ca e() throws IOException {
        try {
            return this.k.a();
        } catch (dd.b e2) {
            dd ddVar = this.f;
            throw ddVar.a("Parsing $GENERATE: " + e2.a);
        } catch (dc e3) {
            dd ddVar2 = this.f;
            throw ddVar2.a("Parsing $GENERATE: " + e3.getMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009c, code lost:
        if (r3.equalsIgnoreCase("$INCLUDE") == false) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009e, code lost:
        r2 = r1.f.c();
        r3 = r1.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a6, code lost:
        if (r3 == null) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a8, code lost:
        r4 = new java.io.File(r3.getParent(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b2, code lost:
        r4 = new java.io.File(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b7, code lost:
        r2 = r1.a;
        r3 = r1.f.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c3, code lost:
        if (r3.a() == false) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c5, code lost:
        r2 = r1.a(r3.b, com.bonree.sdk.bc.bn.a);
        r1.f.k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d2, code lost:
        r1.e = new com.bonree.sdk.bc.ba(r4, r2, r1.d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00df, code lost:
        return r1.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e6, code lost:
        if (r3.equalsIgnoreCase("$GENERATE") == false) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ea, code lost:
        if (r1.k != null) goto L_0x01de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ec, code lost:
        r3 = r1.f.d();
        r6 = r3.indexOf("-");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00fa, code lost:
        if (r6 < 0) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fc, code lost:
        r8 = r3.substring(0, r6);
        r6 = r3.substring(r6 + 1);
        r9 = r6.indexOf("/");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010c, code lost:
        if (r9 < 0) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x010e, code lost:
        r10 = r6.substring(r9 + 1);
        r6 = r6.substring(0, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0119, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011a, code lost:
        r12 = a(r8);
        r14 = a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0122, code lost:
        if (r10 == null) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0124, code lost:
        r5 = a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0129, code lost:
        r5 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x012b, code lost:
        r16 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0131, code lost:
        if (r12 < 0) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0135, code lost:
        if (r14 < 0) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0139, code lost:
        if (r12 > r14) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x013d, code lost:
        if (r16 <= 0) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x013f, code lost:
        r18 = r1.f.d();
        r1.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x014e, code lost:
        if (com.bonree.sdk.bc.u.a.a(r1.g) == false) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0150, code lost:
        r23 = r1.f.d();
        r1.f.k();
        r1.f.b();
        r1.k = new com.bonree.sdk.bc.u.a(r12, r14, r16, r18, r1.g, r1.h, r1.i, r23, r1.a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x017a, code lost:
        if (r1.l != null) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x017c, code lost:
        r1.l = new java.util.ArrayList(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0183, code lost:
        r1.l.add(r1.k);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018c, code lost:
        if (r1.m != false) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0192, code lost:
        return r1.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b7, code lost:
        throw r1.f.a("$GENERATE does not support " + com.bonree.sdk.bc.df.b(r1.g) + " records");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01ca, code lost:
        throw r1.f.a("Invalid $GENERATE range specifier: " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01dd, code lost:
        throw r1.f.a("Invalid $GENERATE range specifier: " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e5, code lost:
        throw new java.lang.IllegalStateException("cannot nest $GENERATE");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01fa, code lost:
        throw r1.f.a("Invalid directive: " + r3);
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x022f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bonree.sdk.bc.ca f() throws java.io.IOException {
        /*
            r25 = this;
            r0 = r25
            com.bonree.sdk.bc.ba r1 = r0.e
            r2 = 0
            if (r1 == 0) goto L_0x0010
            com.bonree.sdk.bc.ca r1 = r1.a()
            if (r1 == 0) goto L_0x000e
            return r1
        L_0x000e:
            r0.e = r2
        L_0x0010:
            com.bonree.sdk.bc.u$a r1 = r0.k
            if (r1 == 0) goto L_0x001e
            com.bonree.sdk.bc.ca r1 = r25.e()
            if (r1 == 0) goto L_0x001b
            return r1
        L_0x001b:
            r1 = r0
            goto L_0x0193
        L_0x001e:
            r1 = r0
        L_0x001f:
            com.bonree.sdk.bc.dd r3 = r1.f
            r4 = 1
            r5 = 0
            com.bonree.sdk.bc.dd$a r3 = r3.a(r4, r5)
            int r6 = r3.a
            r7 = 2
            if (r6 != r7) goto L_0x0053
            com.bonree.sdk.bc.dd r3 = r1.f
            com.bonree.sdk.bc.dd$a r3 = r3.a()
            int r6 = r3.a
            if (r6 == r4) goto L_0x001f
            int r3 = r3.a
            if (r3 != 0) goto L_0x003b
            return r2
        L_0x003b:
            com.bonree.sdk.bc.dd r2 = r1.f
            r2.b()
            com.bonree.sdk.bc.ca r2 = r1.c
            if (r2 == 0) goto L_0x004a
            com.bonree.sdk.bc.bn r2 = r2.o()
            goto L_0x0217
        L_0x004a:
            com.bonree.sdk.bc.dd r1 = r1.f
            java.lang.String r2 = "no owner"
            com.bonree.sdk.bc.dc r1 = r1.a((java.lang.String) r2)
            throw r1
        L_0x0053:
            int r6 = r3.a
            if (r6 == r4) goto L_0x001f
            int r6 = r3.a
            if (r6 != 0) goto L_0x005c
            return r2
        L_0x005c:
            java.lang.String r6 = r3.b
            char r6 = r6.charAt(r5)
            r7 = 36
            if (r6 != r7) goto L_0x01fb
            java.lang.String r3 = r3.b
            java.lang.String r6 = "$ORIGIN"
            boolean r6 = r3.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0080
            com.bonree.sdk.bc.dd r3 = r1.f
            com.bonree.sdk.bc.bn r4 = com.bonree.sdk.bc.bn.a
            com.bonree.sdk.bc.bn r3 = r3.a((com.bonree.sdk.bc.bn) r4)
            r1.a = r3
            com.bonree.sdk.bc.dd r3 = r1.f
            r3.k()
            goto L_0x001f
        L_0x0080:
            java.lang.String r6 = "$TTL"
            boolean r6 = r3.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0096
            com.bonree.sdk.bc.dd r3 = r1.f
            long r3 = r3.i()
            r1.d = r3
            com.bonree.sdk.bc.dd r3 = r1.f
            r3.k()
            goto L_0x001f
        L_0x0096:
            java.lang.String r6 = "$INCLUDE"
            boolean r6 = r3.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x00e0
            com.bonree.sdk.bc.dd r2 = r1.f
            java.lang.String r2 = r2.c()
            java.io.File r3 = r1.b
            if (r3 == 0) goto L_0x00b2
            java.lang.String r3 = r3.getParent()
            java.io.File r4 = new java.io.File
            r4.<init>(r3, r2)
            goto L_0x00b7
        L_0x00b2:
            java.io.File r4 = new java.io.File
            r4.<init>(r2)
        L_0x00b7:
            com.bonree.sdk.bc.bn r2 = r1.a
            com.bonree.sdk.bc.dd r3 = r1.f
            com.bonree.sdk.bc.dd$a r3 = r3.a()
            boolean r5 = r3.a()
            if (r5 == 0) goto L_0x00d2
            java.lang.String r2 = r3.b
            com.bonree.sdk.bc.bn r3 = com.bonree.sdk.bc.bn.a
            com.bonree.sdk.bc.bn r2 = r1.a((java.lang.String) r2, (com.bonree.sdk.bc.bn) r3)
            com.bonree.sdk.bc.dd r3 = r1.f
            r3.k()
        L_0x00d2:
            com.bonree.sdk.bc.ba r3 = new com.bonree.sdk.bc.ba
            long r5 = r1.d
            r3.<init>((java.io.File) r4, (com.bonree.sdk.bc.bn) r2, (long) r5)
            r1.e = r3
            com.bonree.sdk.bc.ca r1 = r1.a()
            return r1
        L_0x00e0:
            java.lang.String r6 = "$GENERATE"
            boolean r6 = r3.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x01e6
            com.bonree.sdk.bc.u$a r3 = r1.k
            if (r3 != 0) goto L_0x01de
            com.bonree.sdk.bc.dd r3 = r1.f
            java.lang.String r3 = r3.d()
            java.lang.String r6 = "-"
            int r6 = r3.indexOf(r6)
            java.lang.String r7 = "Invalid $GENERATE range specifier: "
            if (r6 < 0) goto L_0x01cb
            java.lang.String r8 = r3.substring(r5, r6)
            int r6 = r6 + 1
            java.lang.String r6 = r3.substring(r6)
            java.lang.String r9 = "/"
            int r9 = r6.indexOf(r9)
            if (r9 < 0) goto L_0x0119
            int r10 = r9 + 1
            java.lang.String r10 = r6.substring(r10)
            java.lang.String r6 = r6.substring(r5, r9)
            goto L_0x011a
        L_0x0119:
            r10 = r2
        L_0x011a:
            long r12 = a((java.lang.String) r8)
            long r14 = a((java.lang.String) r6)
            if (r10 == 0) goto L_0x0129
            long r5 = a((java.lang.String) r10)
            goto L_0x012b
        L_0x0129:
            r5 = 1
        L_0x012b:
            r16 = r5
            r5 = 0
            int r8 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r8 < 0) goto L_0x01b8
            int r8 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r8 < 0) goto L_0x01b8
            int r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r8 > 0) goto L_0x01b8
            int r5 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x01b8
            com.bonree.sdk.bc.dd r3 = r1.f
            java.lang.String r18 = r3.d()
            r1.b()
            int r3 = r1.g
            boolean r3 = com.bonree.sdk.bc.u.a.a(r3)
            if (r3 == 0) goto L_0x0198
            com.bonree.sdk.bc.dd r3 = r1.f
            java.lang.String r23 = r3.d()
            com.bonree.sdk.bc.dd r3 = r1.f
            r3.k()
            com.bonree.sdk.bc.dd r3 = r1.f
            r3.b()
            com.bonree.sdk.bc.u$a r3 = new com.bonree.sdk.bc.u$a
            int r5 = r1.g
            int r6 = r1.h
            long r7 = r1.i
            com.bonree.sdk.bc.bn r9 = r1.a
            r11 = r3
            r19 = r5
            r20 = r6
            r21 = r7
            r24 = r9
            r11.<init>(r12, r14, r16, r18, r19, r20, r21, r23, r24)
            r1.k = r3
            java.util.List r3 = r1.l
            if (r3 != 0) goto L_0x0183
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r4)
            r1.l = r3
        L_0x0183:
            java.util.List r3 = r1.l
            com.bonree.sdk.bc.u$a r4 = r1.k
            r3.add(r4)
            boolean r3 = r1.m
            if (r3 != 0) goto L_0x0193
            com.bonree.sdk.bc.ca r1 = r1.e()
            return r1
        L_0x0193:
            r1.d()
            goto L_0x001f
        L_0x0198:
            com.bonree.sdk.bc.dd r2 = r1.f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "$GENERATE does not support "
            r3.<init>(r4)
            int r1 = r1.g
            java.lang.String r1 = com.bonree.sdk.bc.df.b(r1)
            r3.append(r1)
            java.lang.String r1 = " records"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.bonree.sdk.bc.dc r1 = r2.a((java.lang.String) r1)
            throw r1
        L_0x01b8:
            com.bonree.sdk.bc.dd r1 = r1.f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r7)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.bonree.sdk.bc.dc r1 = r1.a((java.lang.String) r2)
            throw r1
        L_0x01cb:
            com.bonree.sdk.bc.dd r1 = r1.f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r7)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.bonree.sdk.bc.dc r1 = r1.a((java.lang.String) r2)
            throw r1
        L_0x01de:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "cannot nest $GENERATE"
            r1.<init>(r2)
            throw r1
        L_0x01e6:
            com.bonree.sdk.bc.dd r1 = r1.f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Invalid directive: "
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.bonree.sdk.bc.dc r1 = r1.a((java.lang.String) r2)
            throw r1
        L_0x01fb:
            java.lang.String r2 = r3.b
            com.bonree.sdk.bc.bn r3 = r1.a
            com.bonree.sdk.bc.bn r2 = r1.a((java.lang.String) r2, (com.bonree.sdk.bc.bn) r3)
            com.bonree.sdk.bc.ca r3 = r1.c
            if (r3 == 0) goto L_0x0217
            com.bonree.sdk.bc.bn r3 = r3.o()
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0217
            com.bonree.sdk.bc.ca r2 = r1.c
            com.bonree.sdk.bc.bn r2 = r2.o()
        L_0x0217:
            r6 = r2
            r1.b()
            int r7 = r1.g
            int r8 = r1.h
            long r9 = r1.i
            com.bonree.sdk.bc.dd r11 = r1.f
            com.bonree.sdk.bc.bn r12 = r1.a
            com.bonree.sdk.bc.ca r2 = com.bonree.sdk.bc.ca.a((com.bonree.sdk.bc.bn) r6, (int) r7, (int) r8, (long) r9, (com.bonree.sdk.bc.dd) r11, (com.bonree.sdk.bc.bn) r12)
            r1.c = r2
            boolean r3 = r1.j
            if (r3 == 0) goto L_0x023e
            com.bonree.sdk.bc.ck r2 = (com.bonree.sdk.bc.ck) r2
            long r2 = r2.e()
            com.bonree.sdk.bc.ca r4 = r1.c
            r4.a((long) r2)
            r1.d = r2
            r1.j = r5
        L_0x023e:
            com.bonree.sdk.bc.ca r1 = r1.c
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.ba.f():com.bonree.sdk.bc.ca");
    }

    private void a(boolean z) {
        this.m = !z;
    }

    private Iterator g() {
        List list = this.l;
        if (list != null) {
            return Collections.unmodifiableList(list).iterator();
        }
        return Collections.EMPTY_LIST.iterator();
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        dd ddVar = this.f;
        if (ddVar != null) {
            ddVar.o();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0238, code lost:
        r6 = ((com.bonree.sdk.bc.ck) r2).e();
        r0.c.a(r6);
        r0.d = r6;
        r0.j = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0247, code lost:
        r2 = r0.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a3, code lost:
        if (r4.equalsIgnoreCase("$INCLUDE") == false) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a5, code lost:
        r2 = r0.f.c();
        r4 = r0.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ad, code lost:
        if (r4 == null) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00af, code lost:
        r5 = new java.io.File(r4.getParent(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b9, code lost:
        r5 = new java.io.File(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00be, code lost:
        r2 = r0.a;
        r4 = r0.f.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ca, code lost:
        if (r4.a() == false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cc, code lost:
        r2 = r0.a(r4.b, com.bonree.sdk.bc.bn.a);
        r0.f.k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d9, code lost:
        r0.e = new com.bonree.sdk.bc.ba(r5, r2, r0.d);
        r2 = r0.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ee, code lost:
        if (r4.equalsIgnoreCase("$GENERATE") == false) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f2, code lost:
        if (r0.k != null) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f4, code lost:
        r4 = r0.f.d();
        r7 = r4.indexOf("-");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0102, code lost:
        if (r7 < 0) goto L_0x01d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r9 = r4.substring(0, r7);
        r7 = r4.substring(r7 + 1);
        r10 = r7.indexOf("/");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0114, code lost:
        if (r10 < 0) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0116, code lost:
        r11 = r7.substring(r10 + 1);
        r7 = r7.substring(0, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0121, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0122, code lost:
        r13 = a(r9);
        r15 = a(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x012a, code lost:
        if (r11 == null) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x012c, code lost:
        r9 = a(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0131, code lost:
        r9 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0133, code lost:
        r17 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0139, code lost:
        if (r13 < 0) goto L_0x01c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x013d, code lost:
        if (r15 < 0) goto L_0x01c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0141, code lost:
        if (r13 > r15) goto L_0x01c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0145, code lost:
        if (r17 <= 0) goto L_0x01c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0147, code lost:
        r19 = r0.f.d();
        r0.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0156, code lost:
        if (com.bonree.sdk.bc.u.a.a(r0.g) == false) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0158, code lost:
        r24 = r0.f.d();
        r0.f.k();
        r0.f.b();
        r0.k = new com.bonree.sdk.bc.u.a(r13, r15, r17, r19, r0.g, r0.h, r0.i, r24, r0.a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0182, code lost:
        if (r0.l != null) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0184, code lost:
        r0.l = new java.util.ArrayList(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x018b, code lost:
        r0.l.add(r0.k);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0194, code lost:
        if (r0.m != false) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0196, code lost:
        r2 = r0.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c0, code lost:
        throw r0.f.a("$GENERATE does not support " + com.bonree.sdk.bc.df.b(r0.g) + " records");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01d3, code lost:
        throw r0.f.a("Invalid $GENERATE range specifier: " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e6, code lost:
        throw r0.f.a("Invalid $GENERATE range specifier: " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01ee, code lost:
        throw new java.lang.IllegalStateException("cannot nest $GENERATE");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0203, code lost:
        throw r0.f.a("Invalid directive: " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0220, code lost:
        r0.b();
        r2 = com.bonree.sdk.bc.ca.a(r2, r0.g, r0.h, r0.i, r0.f, r0.a);
        r0.c = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0236, code lost:
        if (r0.j == false) goto L_0x0247;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031 A[Catch:{ all -> 0x0251 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059 A[Catch:{ all -> 0x0251 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bonree.sdk.bc.ca a() throws java.io.IOException {
        /*
            r26 = this;
            r1 = r26
            com.bonree.sdk.bc.ba r0 = r1.e     // Catch:{ all -> 0x0253 }
            r2 = 0
            if (r0 == 0) goto L_0x0013
            com.bonree.sdk.bc.ca r0 = r0.a()     // Catch:{ all -> 0x0253 }
            if (r0 == 0) goto L_0x0011
        L_0x000d:
            r2 = r0
            r3 = r1
            goto L_0x0249
        L_0x0011:
            r1.e = r2     // Catch:{ all -> 0x0253 }
        L_0x0013:
            com.bonree.sdk.bc.u$a r0 = r1.k     // Catch:{ all -> 0x0253 }
            if (r0 == 0) goto L_0x0022
            com.bonree.sdk.bc.ca r0 = r26.e()     // Catch:{ all -> 0x0253 }
            if (r0 == 0) goto L_0x001e
            goto L_0x000d
        L_0x001e:
            r0 = r1
            r3 = r0
            goto L_0x019c
        L_0x0022:
            r0 = r1
            r3 = r0
        L_0x0024:
            com.bonree.sdk.bc.dd r4 = r0.f     // Catch:{ all -> 0x0251 }
            r5 = 0
            r6 = 1
            com.bonree.sdk.bc.dd$a r4 = r4.a(r6, r5)     // Catch:{ all -> 0x0251 }
            int r7 = r4.a     // Catch:{ all -> 0x0251 }
            r8 = 2
            if (r7 != r8) goto L_0x0059
            com.bonree.sdk.bc.dd r4 = r0.f     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.dd$a r4 = r4.a()     // Catch:{ all -> 0x0251 }
            int r7 = r4.a     // Catch:{ all -> 0x0251 }
            if (r7 == r6) goto L_0x0024
            int r4 = r4.a     // Catch:{ all -> 0x0251 }
            if (r4 != 0) goto L_0x0041
            goto L_0x0249
        L_0x0041:
            com.bonree.sdk.bc.dd r2 = r0.f     // Catch:{ all -> 0x0251 }
            r2.b()     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.ca r2 = r0.c     // Catch:{ all -> 0x0251 }
            if (r2 == 0) goto L_0x0050
            com.bonree.sdk.bc.bn r2 = r2.o()     // Catch:{ all -> 0x0251 }
            goto L_0x0220
        L_0x0050:
            com.bonree.sdk.bc.dd r0 = r0.f     // Catch:{ all -> 0x0251 }
            java.lang.String r2 = "no owner"
            com.bonree.sdk.bc.dc r0 = r0.a((java.lang.String) r2)     // Catch:{ all -> 0x0251 }
            throw r0     // Catch:{ all -> 0x0251 }
        L_0x0059:
            int r7 = r4.a     // Catch:{ all -> 0x0251 }
            if (r7 == r6) goto L_0x0024
            int r7 = r4.a     // Catch:{ all -> 0x0251 }
            if (r7 != 0) goto L_0x0063
            goto L_0x0249
        L_0x0063:
            java.lang.String r7 = r4.b     // Catch:{ all -> 0x0251 }
            char r7 = r7.charAt(r5)     // Catch:{ all -> 0x0251 }
            r8 = 36
            if (r7 != r8) goto L_0x0204
            java.lang.String r4 = r4.b     // Catch:{ all -> 0x0251 }
            java.lang.String r7 = "$ORIGIN"
            boolean r7 = r4.equalsIgnoreCase(r7)     // Catch:{ all -> 0x0251 }
            if (r7 == 0) goto L_0x0087
            com.bonree.sdk.bc.dd r4 = r0.f     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.bn r5 = com.bonree.sdk.bc.bn.a     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.bn r4 = r4.a((com.bonree.sdk.bc.bn) r5)     // Catch:{ all -> 0x0251 }
            r0.a = r4     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.dd r4 = r0.f     // Catch:{ all -> 0x0251 }
            r4.k()     // Catch:{ all -> 0x0251 }
            goto L_0x0024
        L_0x0087:
            java.lang.String r7 = "$TTL"
            boolean r7 = r4.equalsIgnoreCase(r7)     // Catch:{ all -> 0x0251 }
            if (r7 == 0) goto L_0x009d
            com.bonree.sdk.bc.dd r4 = r0.f     // Catch:{ all -> 0x0251 }
            long r4 = r4.i()     // Catch:{ all -> 0x0251 }
            r0.d = r4     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.dd r4 = r0.f     // Catch:{ all -> 0x0251 }
            r4.k()     // Catch:{ all -> 0x0251 }
            goto L_0x0024
        L_0x009d:
            java.lang.String r7 = "$INCLUDE"
            boolean r7 = r4.equalsIgnoreCase(r7)     // Catch:{ all -> 0x0251 }
            if (r7 == 0) goto L_0x00e8
            com.bonree.sdk.bc.dd r2 = r0.f     // Catch:{ all -> 0x0251 }
            java.lang.String r2 = r2.c()     // Catch:{ all -> 0x0251 }
            java.io.File r4 = r0.b     // Catch:{ all -> 0x0251 }
            if (r4 == 0) goto L_0x00b9
            java.lang.String r4 = r4.getParent()     // Catch:{ all -> 0x0251 }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0251 }
            r5.<init>(r4, r2)     // Catch:{ all -> 0x0251 }
            goto L_0x00be
        L_0x00b9:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0251 }
            r5.<init>(r2)     // Catch:{ all -> 0x0251 }
        L_0x00be:
            com.bonree.sdk.bc.bn r2 = r0.a     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.dd r4 = r0.f     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.dd$a r4 = r4.a()     // Catch:{ all -> 0x0251 }
            boolean r6 = r4.a()     // Catch:{ all -> 0x0251 }
            if (r6 == 0) goto L_0x00d9
            java.lang.String r2 = r4.b     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.bn r4 = com.bonree.sdk.bc.bn.a     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.bn r2 = r0.a((java.lang.String) r2, (com.bonree.sdk.bc.bn) r4)     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.dd r4 = r0.f     // Catch:{ all -> 0x0251 }
            r4.k()     // Catch:{ all -> 0x0251 }
        L_0x00d9:
            com.bonree.sdk.bc.ba r4 = new com.bonree.sdk.bc.ba     // Catch:{ all -> 0x0251 }
            long r6 = r0.d     // Catch:{ all -> 0x0251 }
            r4.<init>((java.io.File) r5, (com.bonree.sdk.bc.bn) r2, (long) r6)     // Catch:{ all -> 0x0251 }
            r0.e = r4     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.ca r2 = r0.a()     // Catch:{ all -> 0x0251 }
            goto L_0x0249
        L_0x00e8:
            java.lang.String r7 = "$GENERATE"
            boolean r7 = r4.equalsIgnoreCase(r7)     // Catch:{ all -> 0x0251 }
            if (r7 == 0) goto L_0x01ef
            com.bonree.sdk.bc.u$a r4 = r0.k     // Catch:{ all -> 0x0251 }
            if (r4 != 0) goto L_0x01e7
            com.bonree.sdk.bc.dd r4 = r0.f     // Catch:{ all -> 0x0251 }
            java.lang.String r4 = r4.d()     // Catch:{ all -> 0x0251 }
            java.lang.String r7 = "-"
            int r7 = r4.indexOf(r7)     // Catch:{ all -> 0x0251 }
            java.lang.String r8 = "Invalid $GENERATE range specifier: "
            if (r7 < 0) goto L_0x01d4
            java.lang.String r9 = r4.substring(r5, r7)     // Catch:{ all -> 0x0251 }
            int r7 = r7 + 1
            java.lang.String r7 = r4.substring(r7)     // Catch:{ all -> 0x0251 }
            java.lang.String r10 = "/"
            int r10 = r7.indexOf(r10)     // Catch:{ all -> 0x0251 }
            if (r10 < 0) goto L_0x0121
            int r11 = r10 + 1
            java.lang.String r11 = r7.substring(r11)     // Catch:{ all -> 0x0251 }
            java.lang.String r7 = r7.substring(r5, r10)     // Catch:{ all -> 0x0251 }
            goto L_0x0122
        L_0x0121:
            r11 = r2
        L_0x0122:
            long r13 = a((java.lang.String) r9)     // Catch:{ all -> 0x0251 }
            long r15 = a((java.lang.String) r7)     // Catch:{ all -> 0x0251 }
            if (r11 == 0) goto L_0x0131
            long r9 = a((java.lang.String) r11)     // Catch:{ all -> 0x0251 }
            goto L_0x0133
        L_0x0131:
            r9 = 1
        L_0x0133:
            r17 = r9
            r9 = 0
            int r5 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r5 < 0) goto L_0x01c1
            int r5 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r5 < 0) goto L_0x01c1
            int r5 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r5 > 0) goto L_0x01c1
            int r5 = (r17 > r9 ? 1 : (r17 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x01c1
            com.bonree.sdk.bc.dd r4 = r0.f     // Catch:{ all -> 0x0251 }
            java.lang.String r19 = r4.d()     // Catch:{ all -> 0x0251 }
            r0.b()     // Catch:{ all -> 0x0251 }
            int r4 = r0.g     // Catch:{ all -> 0x0251 }
            boolean r4 = com.bonree.sdk.bc.u.a.a(r4)     // Catch:{ all -> 0x0251 }
            if (r4 == 0) goto L_0x01a1
            com.bonree.sdk.bc.dd r4 = r0.f     // Catch:{ all -> 0x0251 }
            java.lang.String r24 = r4.d()     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.dd r4 = r0.f     // Catch:{ all -> 0x0251 }
            r4.k()     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.dd r4 = r0.f     // Catch:{ all -> 0x0251 }
            r4.b()     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.u$a r4 = new com.bonree.sdk.bc.u$a     // Catch:{ all -> 0x0251 }
            int r5 = r0.g     // Catch:{ all -> 0x0251 }
            int r7 = r0.h     // Catch:{ all -> 0x0251 }
            long r8 = r0.i     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.bn r10 = r0.a     // Catch:{ all -> 0x0251 }
            r12 = r4
            r20 = r5
            r21 = r7
            r22 = r8
            r25 = r10
            r12.<init>(r13, r15, r17, r19, r20, r21, r22, r24, r25)     // Catch:{ all -> 0x0251 }
            r0.k = r4     // Catch:{ all -> 0x0251 }
            java.util.List r4 = r0.l     // Catch:{ all -> 0x0251 }
            if (r4 != 0) goto L_0x018b
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0251 }
            r4.<init>(r6)     // Catch:{ all -> 0x0251 }
            r0.l = r4     // Catch:{ all -> 0x0251 }
        L_0x018b:
            java.util.List r4 = r0.l     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.u$a r5 = r0.k     // Catch:{ all -> 0x0251 }
            r4.add(r5)     // Catch:{ all -> 0x0251 }
            boolean r4 = r0.m     // Catch:{ all -> 0x0251 }
            if (r4 != 0) goto L_0x019c
            com.bonree.sdk.bc.ca r2 = r0.e()     // Catch:{ all -> 0x0251 }
            goto L_0x0249
        L_0x019c:
            r0.d()     // Catch:{ all -> 0x0251 }
            goto L_0x0024
        L_0x01a1:
            com.bonree.sdk.bc.dd r2 = r0.f     // Catch:{ all -> 0x0251 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0251 }
            java.lang.String r5 = "$GENERATE does not support "
            r4.<init>(r5)     // Catch:{ all -> 0x0251 }
            int r0 = r0.g     // Catch:{ all -> 0x0251 }
            java.lang.String r0 = com.bonree.sdk.bc.df.b(r0)     // Catch:{ all -> 0x0251 }
            r4.append(r0)     // Catch:{ all -> 0x0251 }
            java.lang.String r0 = " records"
            r4.append(r0)     // Catch:{ all -> 0x0251 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.dc r0 = r2.a((java.lang.String) r0)     // Catch:{ all -> 0x0251 }
            throw r0     // Catch:{ all -> 0x0251 }
        L_0x01c1:
            com.bonree.sdk.bc.dd r0 = r0.f     // Catch:{ all -> 0x0251 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0251 }
            r2.<init>(r8)     // Catch:{ all -> 0x0251 }
            r2.append(r4)     // Catch:{ all -> 0x0251 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.dc r0 = r0.a((java.lang.String) r2)     // Catch:{ all -> 0x0251 }
            throw r0     // Catch:{ all -> 0x0251 }
        L_0x01d4:
            com.bonree.sdk.bc.dd r0 = r0.f     // Catch:{ all -> 0x0251 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0251 }
            r2.<init>(r8)     // Catch:{ all -> 0x0251 }
            r2.append(r4)     // Catch:{ all -> 0x0251 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.dc r0 = r0.a((java.lang.String) r2)     // Catch:{ all -> 0x0251 }
            throw r0     // Catch:{ all -> 0x0251 }
        L_0x01e7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0251 }
            java.lang.String r2 = "cannot nest $GENERATE"
            r0.<init>(r2)     // Catch:{ all -> 0x0251 }
            throw r0     // Catch:{ all -> 0x0251 }
        L_0x01ef:
            com.bonree.sdk.bc.dd r0 = r0.f     // Catch:{ all -> 0x0251 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0251 }
            java.lang.String r5 = "Invalid directive: "
            r2.<init>(r5)     // Catch:{ all -> 0x0251 }
            r2.append(r4)     // Catch:{ all -> 0x0251 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.dc r0 = r0.a((java.lang.String) r2)     // Catch:{ all -> 0x0251 }
            throw r0     // Catch:{ all -> 0x0251 }
        L_0x0204:
            java.lang.String r2 = r4.b     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.bn r4 = r0.a     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.bn r2 = r0.a((java.lang.String) r2, (com.bonree.sdk.bc.bn) r4)     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.ca r4 = r0.c     // Catch:{ all -> 0x0251 }
            if (r4 == 0) goto L_0x0220
            com.bonree.sdk.bc.bn r4 = r4.o()     // Catch:{ all -> 0x0251 }
            boolean r4 = r2.equals(r4)     // Catch:{ all -> 0x0251 }
            if (r4 == 0) goto L_0x0220
            com.bonree.sdk.bc.ca r2 = r0.c     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.bn r2 = r2.o()     // Catch:{ all -> 0x0251 }
        L_0x0220:
            r6 = r2
            r0.b()     // Catch:{ all -> 0x0251 }
            int r7 = r0.g     // Catch:{ all -> 0x0251 }
            int r8 = r0.h     // Catch:{ all -> 0x0251 }
            long r9 = r0.i     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.dd r11 = r0.f     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.bn r12 = r0.a     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.ca r2 = com.bonree.sdk.bc.ca.a((com.bonree.sdk.bc.bn) r6, (int) r7, (int) r8, (long) r9, (com.bonree.sdk.bc.dd) r11, (com.bonree.sdk.bc.bn) r12)     // Catch:{ all -> 0x0251 }
            r0.c = r2     // Catch:{ all -> 0x0251 }
            boolean r4 = r0.j     // Catch:{ all -> 0x0251 }
            if (r4 == 0) goto L_0x0247
            com.bonree.sdk.bc.ck r2 = (com.bonree.sdk.bc.ck) r2     // Catch:{ all -> 0x0251 }
            long r6 = r2.e()     // Catch:{ all -> 0x0251 }
            com.bonree.sdk.bc.ca r2 = r0.c     // Catch:{ all -> 0x0251 }
            r2.a((long) r6)     // Catch:{ all -> 0x0251 }
            r0.d = r6     // Catch:{ all -> 0x0251 }
            r0.j = r5     // Catch:{ all -> 0x0251 }
        L_0x0247:
            com.bonree.sdk.bc.ca r2 = r0.c     // Catch:{ all -> 0x0251 }
        L_0x0249:
            if (r2 != 0) goto L_0x0250
            com.bonree.sdk.bc.dd r0 = r3.f
            r0.o()
        L_0x0250:
            return r2
        L_0x0251:
            r0 = move-exception
            goto L_0x0255
        L_0x0253:
            r0 = move-exception
            r3 = r1
        L_0x0255:
            com.bonree.sdk.bc.dd r2 = r3.f
            r2.o()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.ba.a():com.bonree.sdk.bc.ca");
    }

    public ba() {
    }

    private static void a(String str, String str2) {
        int length = str2.length();
        int i2 = 2000;
        int i3 = 0;
        int i4 = 0;
        while (i3 < 100) {
            if (length > i2) {
                Log.w(str + i3, str2.substring(i4, i2));
                i3++;
                i4 = i2;
                i2 += 2000;
            } else {
                Log.w(str, str2.substring(i4, length));
                return;
            }
        }
    }
}
