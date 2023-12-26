package com.alibaba.fastjson.util;

import java.lang.reflect.Array;
import java.math.BigInteger;

public final class RyuDouble {
    private static final int[][] POW5_INV_SPLIT;
    private static final int[][] POW5_SPLIT;

    static {
        int i;
        Class<int> cls = int.class;
        POW5_SPLIT = (int[][]) Array.newInstance(cls, new int[]{326, 4});
        POW5_INV_SPLIT = (int[][]) Array.newInstance(cls, new int[]{291, 4});
        BigInteger subtract = BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE);
        BigInteger subtract2 = BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE);
        int i2 = 0;
        while (i2 < 326) {
            BigInteger pow = BigInteger.valueOf(5).pow(i2);
            int bitLength = pow.bitLength();
            if (i2 == 0) {
                i = 1;
            } else {
                i = (int) ((((((long) i2) * 23219280) + 10000000) - 1) / 10000000);
            }
            if (i == bitLength) {
                if (i2 < POW5_SPLIT.length) {
                    for (int i3 = 0; i3 < 4; i3++) {
                        POW5_SPLIT[i2][i3] = pow.shiftRight((bitLength - 121) + ((3 - i3) * 31)).and(subtract).intValue();
                    }
                }
                if (i2 < POW5_INV_SPLIT.length) {
                    BigInteger add = BigInteger.ONE.shiftLeft(bitLength + 121).divide(pow).add(BigInteger.ONE);
                    for (int i4 = 0; i4 < 4; i4++) {
                        if (i4 == 0) {
                            POW5_INV_SPLIT[i2][i4] = add.shiftRight((3 - i4) * 31).intValue();
                        } else {
                            POW5_INV_SPLIT[i2][i4] = add.shiftRight((3 - i4) * 31).and(subtract2).intValue();
                        }
                    }
                }
                i2++;
            } else {
                throw new IllegalStateException(bitLength + " != " + i);
            }
        }
    }

    public static String toString(double d) {
        char[] cArr = new char[24];
        return new String(cArr, 0, toString(d, cArr, 0));
    }

    /* JADX WARNING: Removed duplicated region for block: B:237:0x05a8  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x05aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int toString(double r41, char[] r43, int r44) {
        /*
            boolean r0 = java.lang.Double.isNaN(r41)
            if (r0 == 0) goto L_0x001b
            int r0 = r44 + 1
            r1 = 78
            r43[r44] = r1
            int r1 = r0 + 1
            r2 = 97
            r43[r0] = r2
            int r0 = r1 + 1
            r2 = 78
            r43[r1] = r2
        L_0x0018:
            int r0 = r0 - r44
            return r0
        L_0x001b:
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            int r0 = (r41 > r0 ? 1 : (r41 == r0 ? 0 : -1))
            r1 = 105(0x69, float:1.47E-43)
            r2 = 110(0x6e, float:1.54E-43)
            if (r0 != 0) goto L_0x0050
            int r0 = r44 + 1
            r3 = 73
            r43[r44] = r3
            int r3 = r0 + 1
            r43[r0] = r2
            int r0 = r3 + 1
            r4 = 102(0x66, float:1.43E-43)
            r43[r3] = r4
            int r3 = r0 + 1
            r43[r0] = r1
            int r0 = r3 + 1
            r43[r3] = r2
            int r2 = r0 + 1
            r43[r0] = r1
            int r0 = r2 + 1
            r1 = 116(0x74, float:1.63E-43)
            r43[r2] = r1
            int r1 = r0 + 1
            r2 = 121(0x79, float:1.7E-43)
            r43[r0] = r2
        L_0x004d:
            int r1 = r1 - r44
            return r1
        L_0x0050:
            r3 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            int r0 = (r41 > r3 ? 1 : (r41 == r3 ? 0 : -1))
            r3 = 45
            if (r0 != 0) goto L_0x0085
            int r0 = r44 + 1
            r43[r44] = r3
            int r3 = r0 + 1
            r4 = 73
            r43[r0] = r4
            int r0 = r3 + 1
            r43[r3] = r2
            int r3 = r0 + 1
            r4 = 102(0x66, float:1.43E-43)
            r43[r0] = r4
            int r0 = r3 + 1
            r43[r3] = r1
            int r3 = r0 + 1
            r43[r0] = r2
            int r0 = r3 + 1
            r43[r3] = r1
            int r1 = r0 + 1
            r2 = 116(0x74, float:1.63E-43)
            r43[r0] = r2
            int r0 = r1 + 1
            r2 = 121(0x79, float:1.7E-43)
            r43[r1] = r2
            goto L_0x0018
        L_0x0085:
            long r0 = java.lang.Double.doubleToLongBits(r41)
            r4 = 0
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            r6 = 46
            r7 = 48
            if (r2 != 0) goto L_0x00a1
            int r0 = r44 + 1
            r43[r44] = r7
            int r1 = r0 + 1
            r43[r0] = r6
            int r0 = r1 + 1
            r43[r1] = r7
            goto L_0x0018
        L_0x00a1:
            r8 = -9223372036854775808
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x00b8
            int r0 = r44 + 1
            r43[r44] = r3
            int r1 = r0 + 1
            r43[r0] = r7
            int r0 = r1 + 1
            r43[r1] = r6
            int r1 = r0 + 1
            r43[r0] = r7
            goto L_0x004d
        L_0x00b8:
            r8 = 52
            long r8 = r0 >>> r8
            r10 = 2047(0x7ff, double:1.0114E-320)
            long r8 = r8 & r10
            int r8 = (int) r8
            r9 = 4503599627370495(0xfffffffffffff, double:2.225073858507201E-308)
            long r0 = r0 & r9
            if (r8 != 0) goto L_0x00cb
            r9 = -1074(0xfffffffffffffbce, float:NaN)
            goto L_0x00d2
        L_0x00cb:
            int r9 = r8 + -1023
            int r9 = r9 + -52
            r10 = 4503599627370496(0x10000000000000, double:2.2250738585072014E-308)
            long r0 = r0 | r10
        L_0x00d2:
            r10 = 0
            r11 = 1
            if (r2 >= 0) goto L_0x00d8
            r2 = r11
            goto L_0x00d9
        L_0x00d8:
            r2 = r10
        L_0x00d9:
            r12 = 1
            long r14 = r0 & r12
            int r14 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r14 != 0) goto L_0x00e3
            r14 = r11
            goto L_0x00e4
        L_0x00e3:
            r14 = r10
        L_0x00e4:
            r15 = 4
            long r15 = r15 * r0
            r17 = 2
            long r17 = r15 + r17
            r19 = 4503599627370496(0x10000000000000, double:2.2250738585072014E-308)
            int r0 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r0 != 0) goto L_0x00f6
            if (r8 > r11) goto L_0x00f4
            goto L_0x00f6
        L_0x00f4:
            r0 = r10
            goto L_0x00f7
        L_0x00f6:
            r0 = r11
        L_0x00f7:
            long r19 = r15 - r12
            long r6 = (long) r0
            long r19 = r19 - r6
            int r9 = r9 + -2
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            r21 = 10000000(0x989680, double:4.9406565E-317)
            r8 = 21
            r23 = 3
            r24 = 2
            r25 = 31
            if (r9 < 0) goto L_0x030e
            long r3 = (long) r9
            r26 = 3010299(0x2deefb, double:1.4872853E-317)
            long r3 = r3 * r26
            long r3 = r3 / r21
            int r0 = (int) r3
            int r0 = r0 - r11
            int r0 = java.lang.Math.max(r10, r0)
            if (r0 != 0) goto L_0x0120
            r3 = r11
            goto L_0x012c
        L_0x0120:
            long r3 = (long) r0
            r26 = 23219280(0x1624c50, double:1.14718486E-316)
            long r3 = r3 * r26
            long r3 = r3 + r21
            long r3 = r3 - r12
            long r3 = r3 / r21
            int r3 = (int) r3
        L_0x012c:
            int r3 = r3 + 122
            int r3 = r3 - r11
            int r4 = -r9
            int r4 = r4 + r0
            int r4 = r4 + r3
            int r4 = r4 + -93
            int r4 = r4 - r8
            if (r4 < 0) goto L_0x02f7
            int[][] r3 = POW5_INV_SPLIT
            r3 = r3[r0]
            long r26 = r15 >>> r25
            long r28 = r15 & r6
            r9 = r3[r10]
            long r12 = (long) r9
            long r12 = r12 * r26
            r9 = r3[r10]
            long r5 = (long) r9
            long r5 = r5 * r28
            r9 = r3[r11]
            r32 = r2
            long r1 = (long) r9
            long r1 = r1 * r26
            r9 = r3[r11]
            long r10 = (long) r9
            long r10 = r10 * r28
            r9 = r3[r24]
            long r7 = (long) r9
            long r7 = r7 * r26
            r9 = r3[r24]
            r34 = r14
            r35 = r15
            long r14 = (long) r9
            long r14 = r14 * r28
            r9 = r3[r23]
            r37 = r12
            long r12 = (long) r9
            long r26 = r26 * r12
            r9 = r3[r23]
            long r12 = (long) r9
            long r28 = r28 * r12
            long r12 = r28 >>> r25
            long r12 = r12 + r14
            long r12 = r12 + r26
            long r12 = r12 >>> r25
            long r12 = r12 + r10
            long r12 = r12 + r7
            long r7 = r12 >>> r25
            long r7 = r7 + r5
            long r7 = r7 + r1
            r1 = 21
            long r5 = r7 >>> r1
            r1 = 10
            long r7 = r37 << r1
            long r5 = r5 + r7
            long r1 = r5 >>> r4
            long r5 = r17 >>> r25
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r9 = r17 & r7
            r7 = 0
            r8 = r3[r7]
            long r11 = (long) r8
            long r11 = r11 * r5
            r8 = r3[r7]
            long r7 = (long) r8
            long r7 = r7 * r9
            r13 = 1
            r14 = r3[r13]
            long r14 = (long) r14
            long r14 = r14 * r5
            r26 = r1
            r1 = r3[r13]
            long r1 = (long) r1
            long r1 = r1 * r9
            r13 = r3[r24]
            r28 = r11
            long r11 = (long) r13
            long r11 = r11 * r5
            r13 = r3[r24]
            r37 = r14
            long r13 = (long) r13
            long r13 = r13 * r9
            r15 = r3[r23]
            r39 = r7
            long r7 = (long) r15
            long r5 = r5 * r7
            r7 = r3[r23]
            long r7 = (long) r7
            long r9 = r9 * r7
            long r7 = r9 >>> r25
            long r7 = r7 + r13
            long r7 = r7 + r5
            long r5 = r7 >>> r25
            long r5 = r5 + r1
            long r5 = r5 + r11
            long r1 = r5 >>> r25
            long r1 = r1 + r39
            long r1 = r1 + r37
            r5 = 21
            long r1 = r1 >>> r5
            r5 = 10
            long r6 = r28 << r5
            long r1 = r1 + r6
            long r1 = r1 >>> r4
            long r5 = r19 >>> r25
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r7 = r19 & r7
            r9 = 0
            r10 = r3[r9]
            long r10 = (long) r10
            long r10 = r10 * r5
            r12 = r3[r9]
            long r12 = (long) r12
            long r12 = r12 * r7
            r9 = 1
            r14 = r3[r9]
            long r14 = (long) r14
            long r14 = r14 * r5
            r28 = r1
            r1 = r3[r9]
            long r1 = (long) r1
            long r1 = r1 * r7
            r9 = r3[r24]
            r30 = r10
            long r9 = (long) r9
            long r9 = r9 * r5
            r11 = r3[r24]
            r37 = r14
            long r14 = (long) r11
            long r14 = r14 * r7
            r11 = r3[r23]
            r39 = r12
            long r11 = (long) r11
            long r5 = r5 * r11
            r3 = r3[r23]
            long r11 = (long) r3
            long r7 = r7 * r11
            long r7 = r7 >>> r25
            long r7 = r7 + r14
            long r7 = r7 + r5
            long r5 = r7 >>> r25
            long r5 = r5 + r1
            long r5 = r5 + r9
            long r1 = r5 >>> r25
            long r1 = r1 + r39
            long r1 = r1 + r37
            r3 = 21
            long r1 = r1 >>> r3
            r5 = 10
            long r6 = r30 << r5
            long r1 = r1 + r6
            long r1 = r1 >>> r4
            if (r0 > r3) goto L_0x02ec
            r3 = 5
            long r15 = r35 % r3
            r5 = 0
            int r7 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            r8 = 625(0x271, double:3.09E-321)
            if (r7 != 0) goto L_0x0260
            if (r7 == 0) goto L_0x0229
            r7 = 0
            goto L_0x025b
        L_0x0229:
            r10 = 25
            long r15 = r35 % r10
            int r7 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0233
            r7 = 1
            goto L_0x025b
        L_0x0233:
            r10 = 125(0x7d, double:6.2E-322)
            long r15 = r35 % r10
            int r7 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x023e
            r7 = r24
            goto L_0x025b
        L_0x023e:
            long r15 = r35 % r8
            int r7 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0247
            r7 = r23
            goto L_0x025b
        L_0x0247:
            long r15 = r35 / r8
            r7 = 4
        L_0x024a:
            int r8 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r8 <= 0) goto L_0x025b
            long r8 = r15 % r3
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x0255
            goto L_0x025b
        L_0x0255:
            long r15 = r15 / r3
            int r7 = r7 + 1
            r5 = 0
            goto L_0x024a
        L_0x025b:
            if (r7 < r0) goto L_0x02ec
            r3 = 1
            goto L_0x02ed
        L_0x0260:
            if (r34 == 0) goto L_0x02a7
            long r5 = r19 % r3
            r10 = 0
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x026c
            r5 = 0
            goto L_0x029f
        L_0x026c:
            r5 = 25
            long r5 = r19 % r5
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0276
            r5 = 1
            goto L_0x029f
        L_0x0276:
            r5 = 125(0x7d, double:6.2E-322)
            long r5 = r19 % r5
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0281
            r5 = r24
            goto L_0x029f
        L_0x0281:
            long r5 = r19 % r8
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x028a
            r5 = r23
            goto L_0x029f
        L_0x028a:
            long r19 = r19 / r8
            r5 = 4
        L_0x028d:
            int r6 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x029f
            long r6 = r19 % r3
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0298
            goto L_0x029f
        L_0x0298:
            long r19 = r19 / r3
            int r5 = r5 + 1
            r10 = 0
            goto L_0x028d
        L_0x029f:
            if (r5 < r0) goto L_0x02a3
            r3 = 1
            goto L_0x02a4
        L_0x02a3:
            r3 = 0
        L_0x02a4:
            r4 = r3
            r3 = 0
            goto L_0x02ee
        L_0x02a7:
            long r5 = r17 % r3
            r10 = 0
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x02b1
            r5 = 0
            goto L_0x02e4
        L_0x02b1:
            r5 = 25
            long r5 = r17 % r5
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x02bb
            r5 = 1
            goto L_0x02e4
        L_0x02bb:
            r5 = 125(0x7d, double:6.2E-322)
            long r5 = r17 % r5
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x02c6
            r5 = r24
            goto L_0x02e4
        L_0x02c6:
            long r5 = r17 % r8
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x02cf
            r5 = r23
            goto L_0x02e4
        L_0x02cf:
            long r17 = r17 / r8
            r5 = 4
        L_0x02d2:
            int r6 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x02e4
            long r6 = r17 % r3
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02dd
            goto L_0x02e4
        L_0x02dd:
            long r17 = r17 / r3
            int r5 = r5 + 1
            r10 = 0
            goto L_0x02d2
        L_0x02e4:
            if (r5 < r0) goto L_0x02ec
            r3 = 1
            long r3 = r28 - r3
            r28 = r3
        L_0x02ec:
            r3 = 0
        L_0x02ed:
            r4 = 0
        L_0x02ee:
            r6 = r3
            r7 = r4
            r3 = r0
            r4 = r1
            r1 = r26
            r0 = 0
            goto L_0x0462
        L_0x02f7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ""
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x030e:
            r32 = r2
            r34 = r14
            r35 = r15
            int r1 = -r9
            long r2 = (long) r1
            r4 = 6989700(0x6aa784, double:3.4533706E-317)
            long r2 = r2 * r4
            long r2 = r2 / r21
            int r2 = (int) r2
            r3 = 1
            int r2 = r2 - r3
            r3 = 0
            int r2 = java.lang.Math.max(r3, r2)
            int r1 = r1 - r2
            if (r1 != 0) goto L_0x0329
            r3 = 1
            goto L_0x0336
        L_0x0329:
            long r3 = (long) r1
            r5 = 23219280(0x1624c50, double:1.14718486E-316)
            long r3 = r3 * r5
            long r3 = r3 + r21
            r5 = 1
            long r3 = r3 - r5
            long r3 = r3 / r21
            int r3 = (int) r3
        L_0x0336:
            int r3 = r3 + -121
            int r3 = r2 - r3
            int r3 = r3 + -93
            r4 = 21
            int r3 = r3 - r4
            if (r3 < 0) goto L_0x06f1
            int[][] r4 = POW5_SPLIT
            r1 = r4[r1]
            long r4 = r35 >>> r25
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r10 = r35 & r6
            r6 = 0
            r7 = r1[r6]
            long r7 = (long) r7
            long r7 = r7 * r4
            r12 = r1[r6]
            long r12 = (long) r12
            long r12 = r12 * r10
            r6 = 1
            r14 = r1[r6]
            long r14 = (long) r14
            long r14 = r14 * r4
            r16 = r0
            r0 = r1[r6]
            r6 = r2
            r26 = r3
            long r2 = (long) r0
            long r2 = r2 * r10
            r0 = r1[r24]
            r27 = r7
            r8 = r6
            long r6 = (long) r0
            long r6 = r6 * r4
            r0 = r1[r24]
            r37 = r8
            r29 = r9
            long r8 = (long) r0
            long r8 = r8 * r10
            r0 = r1[r23]
            r38 = r14
            long r14 = (long) r0
            long r4 = r4 * r14
            r0 = r1[r23]
            long r14 = (long) r0
            long r10 = r10 * r14
            long r10 = r10 >>> r25
            long r10 = r10 + r8
            long r10 = r10 + r4
            long r4 = r10 >>> r25
            long r4 = r4 + r2
            long r4 = r4 + r6
            long r2 = r4 >>> r25
            long r2 = r2 + r12
            long r2 = r2 + r38
            r0 = 21
            long r2 = r2 >>> r0
            r0 = 10
            long r4 = r27 << r0
            long r2 = r2 + r4
            long r2 = r2 >>> r26
            long r4 = r17 >>> r25
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r8 = r17 & r6
            r0 = 0
            r6 = r1[r0]
            long r6 = (long) r6
            long r6 = r6 * r4
            r10 = r1[r0]
            long r10 = (long) r10
            long r10 = r10 * r8
            r0 = 1
            r12 = r1[r0]
            long r12 = (long) r12
            long r12 = r12 * r4
            r14 = r1[r0]
            long r14 = (long) r14
            long r14 = r14 * r8
            r0 = r1[r24]
            r17 = r2
            long r2 = (long) r0
            long r2 = r2 * r4
            r0 = r1[r24]
            r27 = r6
            long r6 = (long) r0
            long r6 = r6 * r8
            r0 = r1[r23]
            r38 = r12
            long r12 = (long) r0
            long r4 = r4 * r12
            r0 = r1[r23]
            long r12 = (long) r0
            long r8 = r8 * r12
            long r8 = r8 >>> r25
            long r8 = r8 + r6
            long r8 = r8 + r4
            long r4 = r8 >>> r25
            long r4 = r4 + r14
            long r4 = r4 + r2
            long r2 = r4 >>> r25
            long r2 = r2 + r10
            long r2 = r2 + r38
            r0 = 21
            long r2 = r2 >>> r0
            r0 = 10
            long r4 = r27 << r0
            long r2 = r2 + r4
            long r2 = r2 >>> r26
            long r4 = r19 >>> r25
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r6 = r19 & r6
            r0 = 0
            r8 = r1[r0]
            long r8 = (long) r8
            long r8 = r8 * r4
            r10 = r1[r0]
            long r10 = (long) r10
            long r10 = r10 * r6
            r12 = 1
            r13 = r1[r12]
            long r13 = (long) r13
            long r13 = r13 * r4
            r15 = r1[r12]
            r19 = r2
            long r2 = (long) r15
            long r2 = r2 * r6
            r12 = r1[r24]
            r27 = r8
            long r8 = (long) r12
            long r8 = r8 * r4
            r12 = r1[r24]
            r30 = r13
            long r12 = (long) r12
            long r12 = r12 * r6
            r14 = r1[r23]
            long r14 = (long) r14
            long r4 = r4 * r14
            r1 = r1[r23]
            long r14 = (long) r1
            long r6 = r6 * r14
            long r6 = r6 >>> r25
            long r6 = r6 + r12
            long r6 = r6 + r4
            long r4 = r6 >>> r25
            long r4 = r4 + r2
            long r4 = r4 + r8
            long r1 = r4 >>> r25
            long r1 = r1 + r10
            long r1 = r1 + r30
            r3 = 21
            long r1 = r1 >>> r3
            r3 = 10
            long r4 = r27 << r3
            long r1 = r1 + r4
            long r1 = r1 >>> r26
            int r3 = r37 + r29
            r5 = r37
            r4 = 1
            if (r5 > r4) goto L_0x0441
            if (r34 == 0) goto L_0x0437
            r10 = r16
            if (r10 != r4) goto L_0x042f
            r33 = r4
            goto L_0x0431
        L_0x042f:
            r33 = r0
        L_0x0431:
            r6 = r4
            r28 = r19
            r7 = r33
            goto L_0x043d
        L_0x0437:
            r6 = 1
            long r28 = r19 - r6
            r7 = r0
            r6 = r4
        L_0x043d:
            r4 = r1
            r1 = r17
            goto L_0x0462
        L_0x0441:
            r6 = 1
            r8 = 63
            if (r5 >= r8) goto L_0x045b
            int r5 = r5 - r4
            long r4 = r6 << r5
            long r4 = r4 - r6
            long r4 = r35 & r4
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x0455
            r4 = 1
            goto L_0x0456
        L_0x0455:
            r4 = r0
        L_0x0456:
            r7 = r0
            r6 = r4
            r28 = r19
            goto L_0x043d
        L_0x045b:
            r6 = r0
            r7 = r6
            r4 = r1
            r1 = r17
            r28 = r19
        L_0x0462:
            r8 = 1000000000000000000(0xde0b6b3a7640000, double:7.832953389245686E-242)
            int r8 = (r28 > r8 ? 1 : (r28 == r8 ? 0 : -1))
            r9 = 5
            r10 = 100
            r12 = 10
            if (r8 < 0) goto L_0x0474
            r23 = 19
            goto L_0x0529
        L_0x0474:
            r14 = 100000000000000000(0x16345785d8a0000, double:5.620395787888205E-302)
            int r8 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x0481
            r23 = 18
            goto L_0x0529
        L_0x0481:
            r14 = 10000000000000000(0x2386f26fc10000, double:5.431165199810528E-308)
            int r8 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x048e
            r23 = 17
            goto L_0x0529
        L_0x048e:
            r14 = 1000000000000000(0x38d7ea4c68000, double:4.940656458412465E-309)
            int r8 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x049b
            r23 = 16
            goto L_0x0529
        L_0x049b:
            r14 = 100000000000000(0x5af3107a4000, double:4.94065645841247E-310)
            int r8 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x04a8
            r23 = 15
            goto L_0x0529
        L_0x04a8:
            r14 = 10000000000000(0x9184e72a000, double:4.9406564584125E-311)
            int r8 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x04b5
            r23 = 14
            goto L_0x0529
        L_0x04b5:
            r14 = 1000000000000(0xe8d4a51000, double:4.94065645841E-312)
            int r8 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x04c2
            r23 = 13
            goto L_0x0529
        L_0x04c2:
            r14 = 100000000000(0x174876e800, double:4.9406564584E-313)
            int r8 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x04ce
            r23 = 12
            goto L_0x0529
        L_0x04ce:
            r14 = 10000000000(0x2540be400, double:4.9406564584E-314)
            int r8 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x04da
            r23 = 11
            goto L_0x0529
        L_0x04da:
            r14 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            int r8 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x04e4
            r23 = 10
            goto L_0x0529
        L_0x04e4:
            r14 = 100000000(0x5f5e100, double:4.94065646E-316)
            int r8 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x04ee
            r23 = 9
            goto L_0x0529
        L_0x04ee:
            int r8 = (r28 > r21 ? 1 : (r28 == r21 ? 0 : -1))
            if (r8 < 0) goto L_0x04f5
            r23 = 8
            goto L_0x0529
        L_0x04f5:
            r14 = 1000000(0xf4240, double:4.940656E-318)
            int r8 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x04ff
            r23 = 7
            goto L_0x0529
        L_0x04ff:
            r14 = 100000(0x186a0, double:4.94066E-319)
            int r8 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x0509
            r23 = 6
            goto L_0x0529
        L_0x0509:
            r14 = 10000(0x2710, double:4.9407E-320)
            int r8 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x0512
            r23 = r9
            goto L_0x0529
        L_0x0512:
            r14 = 1000(0x3e8, double:4.94E-321)
            int r8 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x051b
            r23 = 4
            goto L_0x0529
        L_0x051b:
            int r8 = (r28 > r10 ? 1 : (r28 == r10 ? 0 : -1))
            if (r8 < 0) goto L_0x0520
            goto L_0x0529
        L_0x0520:
            int r8 = (r28 > r12 ? 1 : (r28 == r12 ? 0 : -1))
            if (r8 < 0) goto L_0x0527
            r23 = r24
            goto L_0x0529
        L_0x0527:
            r23 = 1
        L_0x0529:
            int r3 = r3 + r23
            r8 = 1
            int r3 = r3 - r8
            r8 = -3
            if (r3 < r8) goto L_0x0536
            r8 = 7
            if (r3 < r8) goto L_0x0534
            goto L_0x0536
        L_0x0534:
            r8 = r0
            goto L_0x0537
        L_0x0536:
            r8 = 1
        L_0x0537:
            if (r7 != 0) goto L_0x0566
            if (r6 == 0) goto L_0x053c
            goto L_0x0566
        L_0x053c:
            r6 = r0
            r7 = r6
        L_0x053e:
            long r14 = r28 / r12
            long r16 = r4 / r12
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 <= 0) goto L_0x0558
            int r18 = (r28 > r10 ? 1 : (r28 == r10 ? 0 : -1))
            if (r18 >= 0) goto L_0x054d
            if (r8 == 0) goto L_0x054d
            goto L_0x0558
        L_0x054d:
            long r4 = r1 % r12
            int r6 = (int) r4
            long r1 = r1 / r12
            int r7 = r7 + 1
            r28 = r14
            r4 = r16
            goto L_0x053e
        L_0x0558:
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0561
            if (r6 < r9) goto L_0x055f
            goto L_0x0561
        L_0x055f:
            r4 = r0
            goto L_0x0562
        L_0x0561:
            r4 = 1
        L_0x0562:
            long r4 = (long) r4
            long r1 = r1 + r4
            goto L_0x05d7
        L_0x0566:
            r14 = r0
            r15 = r14
        L_0x0568:
            long r16 = r28 / r12
            long r18 = r4 / r12
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 <= 0) goto L_0x0593
            int r20 = (r28 > r10 ? 1 : (r28 == r10 ? 0 : -1))
            if (r20 >= 0) goto L_0x0577
            if (r8 == 0) goto L_0x0577
            goto L_0x0593
        L_0x0577:
            long r4 = r4 % r12
            r20 = 0
            int r4 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            if (r4 != 0) goto L_0x0580
            r4 = 1
            goto L_0x0581
        L_0x0580:
            r4 = r0
        L_0x0581:
            r7 = r7 & r4
            if (r14 != 0) goto L_0x0586
            r4 = 1
            goto L_0x0587
        L_0x0586:
            r4 = r0
        L_0x0587:
            r6 = r6 & r4
            long r4 = r1 % r12
            int r14 = (int) r4
            long r1 = r1 / r12
            int r15 = r15 + 1
            r28 = r16
            r4 = r18
            goto L_0x0568
        L_0x0593:
            if (r7 == 0) goto L_0x05b8
            if (r34 == 0) goto L_0x05b8
        L_0x0597:
            long r16 = r4 % r12
            r18 = 0
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 != 0) goto L_0x05b8
            int r16 = (r28 > r10 ? 1 : (r28 == r10 ? 0 : -1))
            if (r16 >= 0) goto L_0x05a6
            if (r8 == 0) goto L_0x05a6
            goto L_0x05b8
        L_0x05a6:
            if (r14 != 0) goto L_0x05aa
            r14 = 1
            goto L_0x05ab
        L_0x05aa:
            r14 = r0
        L_0x05ab:
            r6 = r6 & r14
            long r10 = r1 % r12
            int r14 = (int) r10
            long r28 = r28 / r12
            long r1 = r1 / r12
            long r4 = r4 / r12
            int r15 = r15 + 1
            r10 = 100
            goto L_0x0597
        L_0x05b8:
            if (r6 == 0) goto L_0x05c7
            if (r14 != r9) goto L_0x05c7
            r10 = 2
            long r10 = r1 % r10
            r16 = 0
            int r6 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r6 != 0) goto L_0x05c7
            r14 = 4
        L_0x05c7:
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x05cf
            if (r7 == 0) goto L_0x05d1
            if (r34 == 0) goto L_0x05d1
        L_0x05cf:
            if (r14 < r9) goto L_0x05d3
        L_0x05d1:
            r4 = 1
            goto L_0x05d4
        L_0x05d3:
            r4 = r0
        L_0x05d4:
            long r4 = (long) r4
            long r1 = r1 + r4
            r7 = r15
        L_0x05d7:
            int r4 = r23 - r7
            if (r32 == 0) goto L_0x05e2
            int r6 = r44 + 1
            r5 = 45
            r43[r44] = r5
            goto L_0x05e4
        L_0x05e2:
            r6 = r44
        L_0x05e4:
            if (r8 == 0) goto L_0x0659
            r10 = r0
        L_0x05e7:
            int r0 = r4 + -1
            if (r10 >= r0) goto L_0x05fb
            long r7 = r1 % r12
            int r0 = (int) r7
            long r1 = r1 / r12
            int r7 = r6 + r4
            int r7 = r7 - r10
            r8 = 48
            int r0 = r0 + r8
            char r0 = (char) r0
            r43[r7] = r0
            int r10 = r10 + 1
            goto L_0x05e7
        L_0x05fb:
            r7 = 48
            long r1 = r1 % r12
            long r1 = r1 + r7
            int r0 = (int) r1
            char r0 = (char) r0
            r43[r6] = r0
            int r0 = r6 + 1
            r1 = 46
            r43[r0] = r1
            int r0 = r4 + 1
            int r6 = r6 + r0
            r0 = 1
            if (r4 != r0) goto L_0x0616
            int r0 = r6 + 1
            r1 = 48
            r43[r6] = r1
            r6 = r0
        L_0x0616:
            int r0 = r6 + 1
            r1 = 69
            r43[r6] = r1
            if (r3 >= 0) goto L_0x0626
            int r1 = r0 + 1
            r2 = 45
            r43[r0] = r2
            int r3 = -r3
            r0 = r1
        L_0x0626:
            r1 = 100
            if (r3 < r1) goto L_0x063f
            int r1 = r0 + 1
            int r2 = r3 / 100
            r5 = 48
            int r2 = r2 + r5
            char r2 = (char) r2
            r43[r0] = r2
            int r3 = r3 % 100
            int r0 = r1 + 1
            int r2 = r3 / 10
            int r2 = r2 + r5
            char r2 = (char) r2
            r43[r1] = r2
            goto L_0x064e
        L_0x063f:
            r1 = 10
            r5 = 48
            if (r3 < r1) goto L_0x064e
            int r1 = r0 + 1
            int r2 = r3 / 10
            int r2 = r2 + r5
            char r2 = (char) r2
            r43[r0] = r2
            r0 = r1
        L_0x064e:
            int r1 = r0 + 1
            r2 = 10
            int r3 = r3 % r2
            int r3 = r3 + r5
            char r2 = (char) r3
            r43[r0] = r2
            goto L_0x004d
        L_0x0659:
            r5 = 48
            if (r3 >= 0) goto L_0x068c
            int r7 = r6 + 1
            r43[r6] = r5
            int r6 = r7 + 1
            r8 = 46
            r43[r7] = r8
            r7 = -1
        L_0x0668:
            if (r7 <= r3) goto L_0x0674
            int r8 = r6 + 1
            r43[r6] = r5
            int r7 = r7 + -1
            r6 = r8
            r5 = 48
            goto L_0x0668
        L_0x0674:
            r10 = r0
            r0 = r6
        L_0x0676:
            if (r10 >= r4) goto L_0x06ee
            int r3 = r6 + r4
            int r3 = r3 - r10
            r5 = 1
            int r3 = r3 - r5
            r7 = 48
            long r14 = r1 % r12
            long r14 = r14 + r7
            int r5 = (int) r14
            char r5 = (char) r5
            r43[r3] = r5
            long r1 = r1 / r12
            int r0 = r0 + 1
            int r10 = r10 + 1
            goto L_0x0676
        L_0x068c:
            int r5 = r3 + 1
            if (r5 < r4) goto L_0x06c0
            r10 = r0
        L_0x0691:
            if (r10 >= r4) goto L_0x06a5
            int r0 = r6 + r4
            int r0 = r0 - r10
            r3 = 1
            int r0 = r0 - r3
            r7 = 48
            long r14 = r1 % r12
            long r14 = r14 + r7
            int r3 = (int) r14
            char r3 = (char) r3
            r43[r0] = r3
            long r1 = r1 / r12
            int r10 = r10 + 1
            goto L_0x0691
        L_0x06a5:
            int r6 = r6 + r4
        L_0x06a6:
            if (r4 >= r5) goto L_0x06b2
            int r0 = r6 + 1
            r1 = 48
            r43[r6] = r1
            int r4 = r4 + 1
            r6 = r0
            goto L_0x06a6
        L_0x06b2:
            r1 = 48
            int r0 = r6 + 1
            r2 = 46
            r43[r6] = r2
            int r2 = r0 + 1
            r43[r0] = r1
            r0 = r2
            goto L_0x06ee
        L_0x06c0:
            int r5 = r6 + 1
            r10 = r0
        L_0x06c3:
            if (r10 >= r4) goto L_0x06ea
            int r0 = r4 - r10
            r7 = 1
            int r0 = r0 - r7
            if (r0 != r3) goto L_0x06d6
            int r0 = r5 + r4
            int r0 = r0 - r10
            int r0 = r0 - r7
            r8 = 46
            r43[r0] = r8
            int r5 = r5 + -1
            goto L_0x06d8
        L_0x06d6:
            r8 = 46
        L_0x06d8:
            int r0 = r5 + r4
            int r0 = r0 - r10
            int r0 = r0 - r7
            r14 = 48
            long r16 = r1 % r12
            long r14 = r16 + r14
            int r9 = (int) r14
            char r9 = (char) r9
            r43[r0] = r9
            long r1 = r1 / r12
            int r10 = r10 + 1
            goto L_0x06c3
        L_0x06ea:
            r7 = 1
            int r4 = r4 + r7
            int r0 = r6 + r4
        L_0x06ee:
            int r0 = r0 - r44
            return r0
        L_0x06f1:
            r26 = r3
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ""
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.RyuDouble.toString(double, char[], int):int");
    }
}
