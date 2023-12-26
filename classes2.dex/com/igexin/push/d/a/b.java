package com.igexin.push.d.a;

import com.igexin.b.a.b.a.a.o;
import com.igexin.b.a.b.c;
import com.igexin.b.a.b.d;
import com.igexin.push.d.c.a;
import com.igexin.push.d.c.e;
import com.igexin.push.d.c.f;
import com.igexin.push.util.EncryptUtils;

public class b extends com.igexin.b.a.b.b {
    public static final String a = "com.igexin.push.d.a.b";
    public static int b = -1;
    private byte[] g;

    b(String str) {
        super(str, true);
    }

    private byte a(o oVar) {
        return (byte) b(oVar, 1);
    }

    public static com.igexin.b.a.b.b a() {
        b bVar = new b("socketProtocol");
        new a("command", bVar);
        return bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b3, code lost:
        if (r11.g == 0) goto L_0x00b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.igexin.b.a.d.a.e a(com.igexin.b.a.b.d r9, com.igexin.b.a.b.a.a.o r10, com.igexin.push.d.c.e r11) {
        /*
            r8 = this;
            byte r0 = r11.h
            r1 = 0
            r2 = 48
            if (r0 != r2) goto L_0x0008
            return r1
        L_0x0008:
            byte r0 = r8.a((com.igexin.b.a.b.a.a.o) r10)
            if (r0 <= 0) goto L_0x0011
            r8.a((com.igexin.b.a.b.a.a.o) r10, (int) r0)
        L_0x0011:
            byte r0 = r8.a((com.igexin.b.a.b.a.a.o) r10)
            r11.f = r0
            byte r0 = r8.a((com.igexin.b.a.b.a.a.o) r10)
            r11.o = r0
            int r0 = r11.o
            if (r0 <= 0) goto L_0x0029
            int r0 = r11.o
            byte[] r0 = r8.a((com.igexin.b.a.b.a.a.o) r10, (int) r0)
            r11.n = r0
        L_0x0029:
            int r0 = r11.e
            if (r0 != 0) goto L_0x0041
            com.igexin.b.a.b.c r9 = com.igexin.b.a.b.c.b()
            com.igexin.push.d.c.f r10 = new com.igexin.push.d.c.f
            r10.<init>()
            r9.a((java.lang.Object) r10)
            com.igexin.b.a.b.c r9 = com.igexin.b.a.b.c.b()
            r9.c()
            return r1
        L_0x0041:
            r0 = 11
            byte[] r0 = r8.a((com.igexin.b.a.b.a.a.o) r10, (int) r0)
            r2 = 0
            int r3 = com.igexin.b.a.b.e.d(r0, r2)
            int r4 = b
            if (r3 <= r4) goto L_0x0116
            b = r3
            r4 = 4
            int r4 = com.igexin.b.a.b.e.d(r0, r4)
            r5 = 8
            short r5 = com.igexin.b.a.b.e.b(r0, r5)
            r6 = 10
            int r0 = com.igexin.b.a.b.e.a((byte[]) r0, (int) r6)
            com.igexin.push.d.c.a r6 = new com.igexin.push.d.c.a
            r6.<init>()
            r6.a = r5
            byte r7 = (byte) r0
            r6.b = r7
            int r7 = r11.c
            r6.f = r7
            byte r7 = r11.h
            r6.g = r7
            if (r5 <= 0) goto L_0x00e0
            byte[] r10 = r8.a((com.igexin.b.a.b.a.a.o) r10, (int) r5)
            byte r5 = r11.h
            r7 = 16
            if (r5 != r7) goto L_0x008e
            byte[] r0 = com.igexin.b.a.b.e.b((int) r4)
            byte[] r0 = com.igexin.push.util.EncryptUtils.getIV(r0)
            byte[] r10 = com.igexin.push.util.EncryptUtils.aesDecSocket(r10, r0)
            goto L_0x00a6
        L_0x008e:
            byte r5 = r11.h
            r7 = 32
            if (r5 != r7) goto L_0x00a2
            r5 = 26
            if (r0 == r5) goto L_0x0099
            return r1
        L_0x0099:
            byte[] r0 = com.igexin.b.a.b.e.b((int) r4)
            byte[] r10 = com.igexin.push.util.EncryptUtils.altAesDecSocket(r10, r0)
            goto L_0x00a6
        L_0x00a2:
            byte r0 = r11.h
            if (r0 != 0) goto L_0x00dd
        L_0x00a6:
            byte r0 = r11.g
            r5 = -128(0xffffffffffffff80, float:NaN)
            if (r0 != r5) goto L_0x00b1
            byte[] r10 = com.igexin.b.a.b.e.d(r10)
            goto L_0x00b5
        L_0x00b1:
            byte r0 = r11.g
            if (r0 != 0) goto L_0x00dc
        L_0x00b5:
            r6.a(r10)
            byte[] r10 = r11.n
            byte[] r11 = com.igexin.push.util.EncryptUtils.getSocketSignature(r6, r3, r4)
            boolean r10 = java.util.Arrays.equals(r10, r11)
            if (r10 != 0) goto L_0x00fd
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = a
            r9.append(r10)
            java.lang.String r10 = "|decode signature error!!!!"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.Object[] r10 = new java.lang.Object[r2]
            com.igexin.b.a.c.b.a((java.lang.String) r9, (java.lang.Object[]) r10)
        L_0x00dc:
            return r1
        L_0x00dd:
            byte r9 = r11.h
            return r1
        L_0x00e0:
            int r10 = r6.a
            if (r10 >= 0) goto L_0x00fd
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = a
            r9.append(r10)
            java.lang.String r10 = "|data len < 0, error"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.Object[] r10 = new java.lang.Object[r2]
            com.igexin.b.a.c.b.a((java.lang.String) r9, (java.lang.Object[]) r10)
            return r1
        L_0x00fd:
            com.igexin.b.a.b.b r10 = r8.d
            if (r10 == 0) goto L_0x010e
            com.igexin.b.a.b.c r10 = com.igexin.b.a.b.c.b()
            com.igexin.b.a.b.b r11 = r8.d
            java.lang.Object r9 = r11.c(r9, r6)
            r10.a((java.lang.Object) r9)
        L_0x010e:
            com.igexin.b.a.b.c r9 = com.igexin.b.a.b.c.b()
            r9.c()
            return r1
        L_0x0116:
            r9 = -1
            b = r9
            java.lang.Exception r9 = new java.lang.Exception
            java.lang.String r10 = "server packetId can't be less than previous"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.a.b.a(com.igexin.b.a.b.d, com.igexin.b.a.b.a.a.o, com.igexin.push.d.c.e):com.igexin.b.a.d.a.e");
    }

    static e a(a aVar) {
        e eVar = new e();
        eVar.a = 1944742139;
        eVar.a(aVar.c);
        eVar.e = aVar.b > 0 ? 1 : 0;
        eVar.c = 7;
        eVar.b = 11;
        eVar.f = aVar.d;
        eVar.b += EncryptUtils.getRSAKeyId().length;
        if (aVar.a > 0) {
            eVar.p = EncryptUtils.getPacketId();
            eVar.q = (int) (System.currentTimeMillis() / 1000);
            eVar.n = EncryptUtils.getSocketSignature(aVar, eVar.p, eVar.q);
            eVar.o = eVar.n.length;
        } else {
            if (eVar.h == 0) {
                eVar.o = 0;
            }
            c.d();
            return eVar;
        }
        eVar.b += eVar.o;
        c.d();
        return eVar;
    }

    private byte[] a(o oVar, int i) {
        byte[] bArr = new byte[i];
        oVar.a(bArr);
        return bArr;
    }

    private int b(o oVar, int i) {
        byte[] a2 = a(oVar, i);
        if (i == 1) {
            return com.igexin.b.a.b.e.a(a2, 0);
        }
        if (i == 2) {
            return com.igexin.b.a.b.e.b(a2, 0);
        }
        if (i == 4) {
            return com.igexin.b.a.b.e.d(a2, 0);
        }
        return 0;
    }

    private com.igexin.b.a.d.a.e b(d dVar, o oVar, e eVar) {
        byte a2;
        if (eVar.h == 48 && (a2 = a(oVar)) > 0) {
            this.g = a(oVar, (int) a2);
        }
        if (eVar.e == 0) {
            c.b().a((Object) new f());
        } else {
            byte[] a3 = a(oVar, 3);
            short b2 = com.igexin.b.a.b.e.b(a3, 0);
            int a4 = com.igexin.b.a.b.e.a(a3, 2);
            a aVar = new a();
            aVar.a = b2;
            aVar.b = (byte) a4;
            aVar.f = eVar.c;
            if (a4 != 26) {
                return null;
            }
            if (aVar.a > 0) {
                byte[] a5 = a(oVar, (int) b2);
                if (eVar.h == 48) {
                    byte[] bArr = this.g;
                    a5 = com.igexin.b.a.a.a.a(a5, bArr == null ? c.b().a() : com.igexin.b.b.a.a(bArr));
                } else {
                    byte b3 = eVar.h;
                }
                if (eVar.g == Byte.MIN_VALUE) {
                    a5 = com.igexin.b.a.b.e.d(a5);
                } else if (eVar.g != 0) {
                    return null;
                }
                aVar.a(a5);
            }
            if (this.d != null) {
                c.b().a(this.d.c(dVar, aVar));
            }
        }
        c.b().c();
        return null;
    }

    public Object a(d dVar, Object obj) {
        int i;
        byte[] bArr = null;
        if (obj instanceof a) {
            a aVar = (a) obj;
            e a2 = a(aVar);
            if (aVar.b > 0 && aVar.a > 0) {
                if ((a2.g & 192) == 128) {
                    aVar.a(com.igexin.b.a.b.e.c(aVar.e));
                }
                if ((a2.h & 48) == 16) {
                    byte[] iv = EncryptUtils.getIV(com.igexin.b.a.b.e.b(a2.q));
                    if ((a2.f & 16) != 16) {
                        aVar.a(EncryptUtils.aesEncSocket(aVar.e, iv));
                    }
                } else if ((a2.h & 48) != 0) {
                    if ((a2.h & 48) == 48) {
                        com.igexin.b.a.c.b.a(a + "|encry type = 0x30 not support", new Object[0]);
                        return null;
                    } else if ((a2.h & 48) == 32) {
                        com.igexin.b.a.c.b.a(a + "|encry type = 0x20 reserved", new Object[0]);
                    } else {
                        com.igexin.b.a.c.b.a(a + "|encry type = " + (a2.h & 48) + " not support", new Object[0]);
                        return null;
                    }
                }
            }
            bArr = new byte[(a2.b + (aVar.b > 0 ? aVar.a + 11 : 0))];
            int a3 = com.igexin.b.a.b.e.a(1944742139, bArr, 0);
            int c = a3 + com.igexin.b.a.b.e.c(a2.b, bArr, a3);
            int c2 = c + com.igexin.b.a.b.e.c(a2.c, bArr, c);
            int c3 = c2 + com.igexin.b.a.b.e.c(a2.a(), bArr, c2);
            int c4 = c3 + com.igexin.b.a.b.e.c(a2.e, bArr, c3);
            byte[] rSAKeyId = EncryptUtils.getRSAKeyId();
            int c5 = c4 + com.igexin.b.a.b.e.c(rSAKeyId.length, bArr, c4);
            int a4 = c5 + com.igexin.b.a.b.e.a(rSAKeyId, 0, bArr, c5, rSAKeyId.length);
            int c6 = a4 + com.igexin.b.a.b.e.c(a2.b(), bArr, a4);
            if (aVar.a > 0) {
                c6 += com.igexin.b.a.b.e.c(a2.o, bArr, c6);
                i = com.igexin.b.a.b.e.a(a2.n, 0, bArr, c6, a2.o);
            } else {
                i = com.igexin.b.a.b.e.c(0, bArr, c6);
            }
            int i2 = c6 + i;
            if (aVar.b > 0) {
                int a5 = i2 + com.igexin.b.a.b.e.a(a2.p, bArr, i2);
                int a6 = a5 + com.igexin.b.a.b.e.a(a2.q, bArr, a5);
                int b2 = a6 + com.igexin.b.a.b.e.b(aVar.a, bArr, a6);
                int c7 = b2 + com.igexin.b.a.b.e.c(aVar.b, bArr, b2);
                if (aVar.a > 0) {
                    com.igexin.b.a.b.e.a(aVar.e, 0, bArr, c7, aVar.a);
                }
            }
        }
        return bArr;
    }

    /* renamed from: b */
    public com.igexin.b.a.d.a.e c(d dVar, Object obj) {
        o oVar = obj instanceof o ? (o) obj : null;
        if (oVar == null) {
            com.igexin.b.a.c.b.a(a + "|syncIns is null", new Object[0]);
            return null;
        }
        byte[] a2 = a(oVar, 8);
        if (com.igexin.b.a.b.e.d(a2, 0) != 1944742139) {
            return null;
        }
        e eVar = new e();
        eVar.b = a2[4] & 255;
        eVar.c = a2[5] & 255;
        eVar.a(a2[6]);
        eVar.e = a2[7] & 255;
        if (eVar.c == 7) {
            return a(dVar, oVar, eVar);
        }
        if (eVar.c == 1) {
            return b(dVar, oVar, eVar);
        }
        com.igexin.b.a.c.b.a(a + "|server socket resp version = " + eVar.c + ", not support !!!", new Object[0]);
        return null;
    }
}
