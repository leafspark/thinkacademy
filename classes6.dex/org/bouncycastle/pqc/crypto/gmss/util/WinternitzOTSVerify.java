package org.bouncycastle.pqc.crypto.gmss.util;

import org.bouncycastle.crypto.Digest;

public class WinternitzOTSVerify {
    private int mdsize;
    private Digest messDigestOTS;
    private int w;

    public WinternitzOTSVerify(Digest digest, int i) {
        this.w = i;
        this.messDigestOTS = digest;
        this.mdsize = digest.getDigestSize();
    }

    private void hashSignatureBlock(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i2 < 1) {
            System.arraycopy(bArr, i, bArr2, i3, this.mdsize);
            return;
        }
        this.messDigestOTS.update(bArr, i, this.mdsize);
        while (true) {
            this.messDigestOTS.doFinal(bArr2, i3);
            i2--;
            if (i2 > 0) {
                this.messDigestOTS.update(bArr2, i3, this.mdsize);
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v46, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] Verify(byte[] r29, byte[] r30) {
        /*
            r28 = this;
            r6 = r28
            r0 = r29
            r7 = r30
            int r8 = r6.mdsize
            byte[] r9 = new byte[r8]
            org.bouncycastle.crypto.Digest r1 = r6.messDigestOTS
            int r2 = r0.length
            r10 = 0
            r1.update(r0, r10, r2)
            org.bouncycastle.crypto.Digest r0 = r6.messDigestOTS
            r0.doFinal(r9, r10)
            int r0 = r6.mdsize
            int r0 = r0 << 3
            int r1 = r6.w
            int r2 = r1 + -1
            int r0 = r0 + r2
            int r11 = r0 / r1
            int r0 = r11 << r1
            r12 = 1
            int r0 = r0 + r12
            int r13 = r6.getLog(r0)
            int r0 = r6.w
            int r1 = r13 + r0
            int r1 = r1 - r12
            int r1 = r1 / r0
            int r1 = r1 + r11
            int r2 = r6.mdsize
            int r14 = r2 * r1
            int r1 = r7.length
            if (r14 == r1) goto L_0x0039
            r0 = 0
            return r0
        L_0x0039:
            byte[] r15 = new byte[r14]
            r5 = 8
            int r1 = r5 % r0
            if (r1 != 0) goto L_0x00b3
            int r5 = r5 / r0
            int r0 = r12 << r0
            int r16 = r0 + -1
            r0 = r10
            r1 = r0
            r4 = r1
        L_0x0049:
            if (r4 >= r8) goto L_0x008c
            r17 = r1
            r3 = r10
        L_0x004e:
            if (r3 >= r5) goto L_0x0083
            byte r1 = r9[r4]
            r1 = r1 & r16
            int r18 = r0 + r1
            int r0 = r6.mdsize
            int r2 = r17 * r0
            int r19 = r16 - r1
            int r20 = r17 * r0
            r0 = r28
            r1 = r30
            r21 = r3
            r3 = r19
            r19 = r4
            r4 = r15
            r22 = r5
            r5 = r20
            r0.hashSignatureBlock(r1, r2, r3, r4, r5)
            byte r0 = r9[r19]
            int r1 = r6.w
            int r0 = r0 >>> r1
            byte r0 = (byte) r0
            r9[r19] = r0
            int r17 = r17 + 1
            int r3 = r21 + 1
            r0 = r18
            r4 = r19
            r5 = r22
            goto L_0x004e
        L_0x0083:
            r19 = r4
            r22 = r5
            int r4 = r19 + 1
            r1 = r17
            goto L_0x0049
        L_0x008c:
            int r2 = r6.w
            int r2 = r11 << r2
            int r2 = r2 - r0
            r8 = r1
            r9 = r2
            r11 = r10
        L_0x0094:
            if (r11 >= r13) goto L_0x00ae
            r0 = r9 & r16
            int r1 = r6.mdsize
            int r2 = r8 * r1
            int r3 = r16 - r0
            int r5 = r8 * r1
            r0 = r28
            r1 = r30
            r4 = r15
            r0.hashSignatureBlock(r1, r2, r3, r4, r5)
            int r0 = r6.w
            int r9 = r9 >>> r0
            int r8 = r8 + r12
            int r11 = r11 + r0
            goto L_0x0094
        L_0x00ae:
            r11 = r10
            r24 = r14
            goto L_0x0290
        L_0x00b3:
            r16 = 0
            if (r0 >= r5) goto L_0x0192
            int r8 = r2 / r0
            int r0 = r12 << r0
            int r4 = r0 + -1
            r0 = r10
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x00c1:
            if (r3 >= r8) goto L_0x012a
            r18 = r0
            r0 = r10
            r19 = r16
        L_0x00c8:
            int r10 = r6.w
            if (r0 >= r10) goto L_0x00e1
            byte r10 = r9[r18]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r22 = r0 << 3
            int r10 = r10 << r22
            r22 = r13
            long r12 = (long) r10
            long r19 = r19 ^ r12
            int r18 = r18 + 1
            int r0 = r0 + 1
            r13 = r22
            r12 = 1
            goto L_0x00c8
        L_0x00e1:
            r22 = r13
            r10 = r2
            r12 = 0
        L_0x00e5:
            if (r12 >= r5) goto L_0x011b
            long r5 = (long) r4
            long r5 = r19 & r5
            int r0 = (int) r5
            int r6 = r1 + r0
            r5 = r28
            int r1 = r5.mdsize
            int r2 = r10 * r1
            int r23 = r4 - r0
            int r24 = r10 * r1
            r0 = r28
            r1 = r30
            r25 = r3
            r3 = r23
            r13 = r4
            r4 = r15
            r26 = r6
            r23 = 8
            r6 = r5
            r5 = r24
            r0.hashSignatureBlock(r1, r2, r3, r4, r5)
            int r0 = r6.w
            long r19 = r19 >>> r0
            int r10 = r10 + 1
            int r12 = r12 + 1
            r4 = r13
            r5 = r23
            r3 = r25
            r1 = r26
            goto L_0x00e5
        L_0x011b:
            r25 = r3
            r13 = r4
            r23 = r5
            int r3 = r25 + 1
            r2 = r10
            r0 = r18
            r13 = r22
            r10 = 0
            r12 = 1
            goto L_0x00c1
        L_0x012a:
            r22 = r13
            r13 = r4
            int r3 = r6.mdsize
            int r4 = r6.w
            int r3 = r3 % r4
            r4 = 0
        L_0x0133:
            if (r4 >= r3) goto L_0x0148
            byte r5 = r9[r0]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r8 = r4 << 3
            int r5 = r5 << r8
            r8 = r1
            r10 = r2
            long r1 = (long) r5
            long r16 = r16 ^ r1
            r1 = 1
            int r0 = r0 + r1
            int r4 = r4 + 1
            r1 = r8
            r2 = r10
            goto L_0x0133
        L_0x0148:
            r8 = r1
            r10 = r2
            int r9 = r3 << 3
            r8 = 0
        L_0x014d:
            if (r8 >= r9) goto L_0x016e
            long r2 = (long) r13
            long r2 = r16 & r2
            int r0 = (int) r2
            int r12 = r1 + r0
            int r1 = r6.mdsize
            int r2 = r10 * r1
            int r3 = r13 - r0
            int r5 = r10 * r1
            r0 = r28
            r1 = r30
            r4 = r15
            r0.hashSignatureBlock(r1, r2, r3, r4, r5)
            int r0 = r6.w
            long r16 = r16 >>> r0
            int r10 = r10 + 1
            int r8 = r8 + r0
            r1 = r12
            goto L_0x014d
        L_0x016e:
            int r0 = r6.w
            int r0 = r11 << r0
            int r0 = r0 - r1
            r8 = r0
            r12 = r22
            r9 = 0
        L_0x0177:
            if (r9 >= r12) goto L_0x028d
            r0 = r8 & r13
            int r1 = r6.mdsize
            int r2 = r10 * r1
            int r3 = r13 - r0
            int r5 = r10 * r1
            r0 = r28
            r1 = r30
            r4 = r15
            r0.hashSignatureBlock(r1, r2, r3, r4, r5)
            int r0 = r6.w
            int r8 = r8 >>> r0
            r1 = 1
            int r10 = r10 + r1
            int r9 = r9 + r0
            goto L_0x0177
        L_0x0192:
            r23 = r5
            r1 = r12
            r12 = r13
            r3 = 57
            if (r0 >= r3) goto L_0x028d
            int r3 = r2 << 3
            int r3 = r3 - r0
            int r0 = r1 << r0
            int r0 = r0 - r1
            byte[] r1 = new byte[r2]
            r4 = 0
            r5 = 0
            r8 = 0
        L_0x01a5:
            r18 = 1
            if (r4 > r3) goto L_0x0210
            int r10 = r4 >>> 3
            int r13 = r4 % 8
            r20 = r3
            int r3 = r6.w
            int r4 = r4 + r3
            int r3 = r4 + 7
            int r3 = r3 >>> 3
            r24 = r16
            r22 = 0
        L_0x01ba:
            if (r10 >= r3) goto L_0x01d5
            r26 = r3
            byte r3 = r9[r10]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r27 = r22 << 3
            int r3 = r3 << r27
            r27 = r4
            long r3 = (long) r3
            long r24 = r24 ^ r3
            r3 = 1
            int r22 = r22 + 1
            int r10 = r10 + 1
            r3 = r26
            r4 = r27
            goto L_0x01ba
        L_0x01d5:
            r27 = r4
            long r3 = r24 >>> r13
            r10 = r14
            long r13 = (long) r0
            long r3 = r3 & r13
            r24 = r10
            r22 = r11
            long r10 = (long) r5
            long r10 = r10 + r3
            int r5 = (int) r10
            int r10 = r6.mdsize
            int r11 = r8 * r10
            r25 = r3
            r3 = 0
            java.lang.System.arraycopy(r7, r11, r1, r3, r10)
        L_0x01ed:
            int r4 = (r25 > r13 ? 1 : (r25 == r13 ? 0 : -1))
            if (r4 >= 0) goto L_0x01fe
            org.bouncycastle.crypto.Digest r4 = r6.messDigestOTS
            r4.update(r1, r3, r2)
            org.bouncycastle.crypto.Digest r4 = r6.messDigestOTS
            r4.doFinal(r1, r3)
            long r25 = r25 + r18
            goto L_0x01ed
        L_0x01fe:
            int r4 = r6.mdsize
            int r10 = r8 * r4
            java.lang.System.arraycopy(r1, r3, r15, r10, r4)
            int r8 = r8 + 1
            r3 = r20
            r11 = r22
            r14 = r24
            r4 = r27
            goto L_0x01a5
        L_0x0210:
            r22 = r11
            r24 = r14
            int r3 = r4 >>> 3
            int r10 = r6.mdsize
            if (r3 >= r10) goto L_0x0257
            int r4 = r4 % 8
            r10 = 0
        L_0x021d:
            int r11 = r6.mdsize
            if (r3 >= r11) goto L_0x0230
            byte r11 = r9[r3]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r13 = r10 << 3
            int r11 = r11 << r13
            long r13 = (long) r11
            long r16 = r16 ^ r13
            r13 = 1
            int r10 = r10 + r13
            int r3 = r3 + 1
            goto L_0x021d
        L_0x0230:
            long r3 = r16 >>> r4
            long r9 = (long) r0
            long r3 = r3 & r9
            long r13 = (long) r5
            long r13 = r13 + r3
            int r5 = (int) r13
            int r13 = r8 * r11
            r14 = 0
            java.lang.System.arraycopy(r7, r13, r1, r14, r11)
        L_0x023d:
            int r11 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x024e
            org.bouncycastle.crypto.Digest r11 = r6.messDigestOTS
            r11.update(r1, r14, r2)
            org.bouncycastle.crypto.Digest r11 = r6.messDigestOTS
            r11.doFinal(r1, r14)
            long r3 = r3 + r18
            goto L_0x023d
        L_0x024e:
            int r3 = r6.mdsize
            int r4 = r8 * r3
            java.lang.System.arraycopy(r1, r14, r15, r4, r3)
            int r8 = r8 + 1
        L_0x0257:
            int r3 = r6.w
            int r3 = r22 << r3
            int r3 = r3 - r5
            r4 = r3
            r3 = 0
        L_0x025e:
            if (r3 >= r12) goto L_0x028f
            r5 = r4 & r0
            long r9 = (long) r5
            int r5 = r6.mdsize
            int r11 = r8 * r5
            r13 = 0
            java.lang.System.arraycopy(r7, r11, r1, r13, r5)
        L_0x026b:
            long r13 = (long) r0
            int r5 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x027e
            org.bouncycastle.crypto.Digest r5 = r6.messDigestOTS
            r11 = 0
            r5.update(r1, r11, r2)
            org.bouncycastle.crypto.Digest r5 = r6.messDigestOTS
            r5.doFinal(r1, r11)
            long r9 = r9 + r18
            goto L_0x026b
        L_0x027e:
            r11 = 0
            int r5 = r6.mdsize
            int r9 = r8 * r5
            java.lang.System.arraycopy(r1, r11, r15, r9, r5)
            int r5 = r6.w
            int r4 = r4 >>> r5
            int r8 = r8 + 1
            int r3 = r3 + r5
            goto L_0x025e
        L_0x028d:
            r24 = r14
        L_0x028f:
            r11 = 0
        L_0x0290:
            org.bouncycastle.crypto.Digest r0 = r6.messDigestOTS
            r2 = r24
            r0.update(r15, r11, r2)
            int r0 = r6.mdsize
            byte[] r0 = new byte[r0]
            org.bouncycastle.crypto.Digest r1 = r6.messDigestOTS
            r1.doFinal(r0, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSVerify.Verify(byte[], byte[]):byte[]");
    }

    public int getLog(int i) {
        int i2 = 1;
        int i3 = 2;
        while (i3 < i) {
            i3 <<= 1;
            i2++;
        }
        return i2;
    }

    public int getSignatureLength() {
        int digestSize = this.messDigestOTS.getDigestSize();
        int i = this.w;
        int i2 = ((digestSize << 3) + (i - 1)) / i;
        int log = getLog((i2 << i) + 1);
        int i3 = this.w;
        return digestSize * (i2 + (((log + i3) - 1) / i3));
    }
}
