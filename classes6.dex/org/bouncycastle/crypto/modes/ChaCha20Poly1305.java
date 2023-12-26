package org.bouncycastle.crypto.modes;

import java.util.Objects;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.engines.ChaCha7539Engine;
import org.bouncycastle.crypto.macs.Poly1305;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class ChaCha20Poly1305 implements AEADCipher {
    private static final long AAD_LIMIT = -1;
    private static final int BUF_SIZE = 64;
    private static final long DATA_LIMIT = 274877906880L;
    private static final int KEY_SIZE = 32;
    private static final int MAC_SIZE = 16;
    private static final int NONCE_SIZE = 12;
    private static final byte[] ZEROES = new byte[15];
    private long aadCount;
    private final byte[] buf;
    private int bufPos;
    private final ChaCha7539Engine chacha20;
    private long dataCount;
    private byte[] initialAAD;
    private final byte[] key;
    private final byte[] mac;
    private final byte[] nonce;
    private final Mac poly1305;
    private int state;

    private static final class State {
        static final int DEC_AAD = 6;
        static final int DEC_DATA = 7;
        static final int DEC_FINAL = 8;
        static final int DEC_INIT = 5;
        static final int ENC_AAD = 2;
        static final int ENC_DATA = 3;
        static final int ENC_FINAL = 4;
        static final int ENC_INIT = 1;
        static final int UNINITIALIZED = 0;

        private State() {
        }
    }

    public ChaCha20Poly1305() {
        this(new Poly1305());
    }

    public ChaCha20Poly1305(Mac mac2) {
        this.key = new byte[32];
        this.nonce = new byte[12];
        this.buf = new byte[80];
        this.mac = new byte[16];
        this.state = 0;
        Objects.requireNonNull(mac2, "'poly1305' cannot be null");
        if (16 == mac2.getMacSize()) {
            this.chacha20 = new ChaCha7539Engine();
            this.poly1305 = mac2;
            return;
        }
        throw new IllegalArgumentException("'poly1305' must be a 128-bit MAC");
    }

    private void checkAAD() {
        int i = this.state;
        int i2 = 2;
        if (i != 1) {
            if (i == 2) {
                return;
            }
            if (i != 4) {
                i2 = 6;
                if (i != 5) {
                    if (i != 6) {
                        throw new IllegalStateException();
                    }
                    return;
                }
            } else {
                throw new IllegalStateException("ChaCha20Poly1305 cannot be reused for encryption");
            }
        }
        this.state = i2;
    }

    private void checkData() {
        int i;
        switch (this.state) {
            case 1:
            case 2:
                i = 3;
                break;
            case 3:
            case 7:
                return;
            case 4:
                throw new IllegalStateException("ChaCha20Poly1305 cannot be reused for encryption");
            case 5:
            case 6:
                i = 7;
                break;
            default:
                throw new IllegalStateException();
        }
        finishAAD(i);
    }

    private void finishAAD(int i) {
        padMAC(this.aadCount);
        this.state = i;
    }

    private void finishData(int i) {
        padMAC(this.dataCount);
        byte[] bArr = new byte[16];
        Pack.longToLittleEndian(this.aadCount, bArr, 0);
        Pack.longToLittleEndian(this.dataCount, bArr, 8);
        this.poly1305.update(bArr, 0, 16);
        this.poly1305.doFinal(this.mac, 0);
        this.state = i;
    }

    private long incrementCount(long j, int i, long j2) {
        long j3 = (long) i;
        if (j - Long.MIN_VALUE <= (j2 - j3) - Long.MIN_VALUE) {
            return j + j3;
        }
        throw new IllegalStateException("Limit exceeded");
    }

    private void initMAC() {
        byte[] bArr = new byte[64];
        try {
            this.chacha20.processBytes(bArr, 0, 64, bArr, 0);
            this.poly1305.init(new KeyParameter(bArr, 0, 32));
        } finally {
            Arrays.clear(bArr);
        }
    }

    private void padMAC(long j) {
        int i = ((int) j) & 15;
        if (i != 0) {
            this.poly1305.update(ZEROES, 0, 16 - i);
        }
    }

    private void processData(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i3 <= bArr2.length - i2) {
            this.chacha20.processBytes(bArr, i, i2, bArr2, i3);
            this.dataCount = incrementCount(this.dataCount, i2, DATA_LIMIT);
            return;
        }
        throw new OutputLengthException("Output buffer too short");
    }

    private void reset(boolean z, boolean z2) {
        Arrays.clear(this.buf);
        if (z) {
            Arrays.clear(this.mac);
        }
        this.aadCount = 0;
        this.dataCount = 0;
        this.bufPos = 0;
        switch (this.state) {
            case 1:
            case 5:
                break;
            case 2:
            case 3:
            case 4:
                this.state = 4;
                return;
            case 6:
            case 7:
            case 8:
                this.state = 5;
                break;
            default:
                throw new IllegalStateException();
        }
        if (z2) {
            this.chacha20.reset();
        }
        initMAC();
        byte[] bArr = this.initialAAD;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }

    public int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException {
        int i2;
        Objects.requireNonNull(bArr, "'out' cannot be null");
        if (i >= 0) {
            checkData();
            Arrays.clear(this.mac);
            int i3 = this.state;
            if (i3 == 3) {
                int i4 = this.bufPos;
                i2 = i4 + 16;
                if (i <= bArr.length - i2) {
                    if (i4 > 0) {
                        processData(this.buf, 0, i4, bArr, i);
                        this.poly1305.update(bArr, i, this.bufPos);
                    }
                    finishData(4);
                    System.arraycopy(this.mac, 0, bArr, i + this.bufPos, 16);
                } else {
                    throw new OutputLengthException("Output buffer too short");
                }
            } else if (i3 == 7) {
                int i5 = this.bufPos;
                if (i5 >= 16) {
                    i2 = i5 - 16;
                    if (i <= bArr.length - i2) {
                        if (i2 > 0) {
                            this.poly1305.update(this.buf, 0, i2);
                            processData(this.buf, 0, i2, bArr, i);
                        }
                        finishData(8);
                        if (!Arrays.constantTimeAreEqual(16, this.mac, 0, this.buf, i2)) {
                            throw new InvalidCipherTextException("mac check in ChaCha20Poly1305 failed");
                        }
                    } else {
                        throw new OutputLengthException("Output buffer too short");
                    }
                } else {
                    throw new InvalidCipherTextException("data too short");
                }
            } else {
                throw new IllegalStateException();
            }
            reset(false, true);
            return i2;
        }
        throw new IllegalArgumentException("'outOff' cannot be negative");
    }

    public String getAlgorithmName() {
        return "ChaCha20Poly1305";
    }

    public byte[] getMac() {
        return Arrays.clone(this.mac);
    }

    public int getOutputSize(int i) {
        int max = Math.max(0, i) + this.bufPos;
        int i2 = this.state;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return max + 16;
        }
        if (i2 == 5 || i2 == 6 || i2 == 7) {
            return Math.max(0, max - 16);
        }
        throw new IllegalStateException();
    }

    public int getUpdateOutputSize(int i) {
        int max = Math.max(0, i) + this.bufPos;
        int i2 = this.state;
        if (!(i2 == 1 || i2 == 2 || i2 == 3)) {
            if (i2 == 5 || i2 == 6 || i2 == 7) {
                max = Math.max(0, max - 16);
            } else {
                throw new IllegalStateException();
            }
        }
        return max - (max % 64);
    }

    /* JADX WARNING: type inference failed for: r8v9, types: [org.bouncycastle.crypto.CipherParameters] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(boolean r7, org.bouncycastle.crypto.CipherParameters r8) throws java.lang.IllegalArgumentException {
        /*
            r6 = this;
            boolean r0 = r8 instanceof org.bouncycastle.crypto.params.AEADParameters
            if (r0 == 0) goto L_0x0039
            org.bouncycastle.crypto.params.AEADParameters r8 = (org.bouncycastle.crypto.params.AEADParameters) r8
            int r0 = r8.getMacSize()
            r1 = 128(0x80, float:1.794E-43)
            if (r1 != r0) goto L_0x0022
            org.bouncycastle.crypto.params.KeyParameter r0 = r8.getKey()
            byte[] r1 = r8.getNonce()
            org.bouncycastle.crypto.params.ParametersWithIV r2 = new org.bouncycastle.crypto.params.ParametersWithIV
            r2.<init>(r0, r1)
            byte[] r8 = r8.getAssociatedText()
            r6.initialAAD = r8
            goto L_0x004e
        L_0x0022:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "Invalid value for MAC size: "
            r8.append(r1)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0039:
            boolean r0 = r8 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r0 == 0) goto L_0x00c4
            r2 = r8
            org.bouncycastle.crypto.params.ParametersWithIV r2 = (org.bouncycastle.crypto.params.ParametersWithIV) r2
            org.bouncycastle.crypto.CipherParameters r8 = r2.getParameters()
            r0 = r8
            org.bouncycastle.crypto.params.KeyParameter r0 = (org.bouncycastle.crypto.params.KeyParameter) r0
            byte[] r1 = r2.getIV()
            r8 = 0
            r6.initialAAD = r8
        L_0x004e:
            r8 = 32
            if (r0 != 0) goto L_0x005f
            int r3 = r6.state
            if (r3 == 0) goto L_0x0057
            goto L_0x0066
        L_0x0057:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Key must be specified in initial init"
            r7.<init>(r8)
            throw r7
        L_0x005f:
            byte[] r3 = r0.getKey()
            int r3 = r3.length
            if (r8 != r3) goto L_0x00bc
        L_0x0066:
            if (r1 == 0) goto L_0x00b4
            int r3 = r1.length
            r4 = 12
            if (r4 != r3) goto L_0x00b4
            int r3 = r6.state
            if (r3 == 0) goto L_0x0092
            if (r7 == 0) goto L_0x0092
            byte[] r3 = r6.nonce
            boolean r3 = org.bouncycastle.util.Arrays.areEqual((byte[]) r3, (byte[]) r1)
            if (r3 == 0) goto L_0x0092
            if (r0 == 0) goto L_0x008a
            byte[] r3 = r6.key
            byte[] r5 = r0.getKey()
            boolean r3 = org.bouncycastle.util.Arrays.areEqual((byte[]) r3, (byte[]) r5)
            if (r3 != 0) goto L_0x008a
            goto L_0x0092
        L_0x008a:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "cannot reuse nonce for ChaCha20Poly1305 encryption"
            r7.<init>(r8)
            throw r7
        L_0x0092:
            r3 = 0
            if (r0 == 0) goto L_0x009e
            byte[] r0 = r0.getKey()
            byte[] r5 = r6.key
            java.lang.System.arraycopy(r0, r3, r5, r3, r8)
        L_0x009e:
            byte[] r8 = r6.nonce
            java.lang.System.arraycopy(r1, r3, r8, r3, r4)
            org.bouncycastle.crypto.engines.ChaCha7539Engine r8 = r6.chacha20
            r0 = 1
            r8.init(r0, r2)
            if (r7 == 0) goto L_0x00ad
            r7 = r0
            goto L_0x00ae
        L_0x00ad:
            r7 = 5
        L_0x00ae:
            r6.state = r7
            r6.reset(r0, r3)
            return
        L_0x00b4:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Nonce must be 96 bits"
            r7.<init>(r8)
            throw r7
        L_0x00bc:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Key must be 256 bits"
            r7.<init>(r8)
            throw r7
        L_0x00c4:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "invalid parameters passed to ChaCha20Poly1305"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.modes.ChaCha20Poly1305.init(boolean, org.bouncycastle.crypto.CipherParameters):void");
    }

    public void processAADByte(byte b) {
        checkAAD();
        this.aadCount = incrementCount(this.aadCount, 1, -1);
        this.poly1305.update(b);
    }

    public void processAADBytes(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "'in' cannot be null");
        if (i < 0) {
            throw new IllegalArgumentException("'inOff' cannot be negative");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("'len' cannot be negative");
        } else if (i <= bArr.length - i2) {
            checkAAD();
            if (i2 > 0) {
                this.aadCount = incrementCount(this.aadCount, i2, -1);
                this.poly1305.update(bArr, i, i2);
            }
        } else {
            throw new DataLengthException("Input buffer too short");
        }
    }

    public int processByte(byte b, byte[] bArr, int i) throws DataLengthException {
        checkData();
        int i2 = this.state;
        if (i2 == 3) {
            byte[] bArr2 = this.buf;
            int i3 = this.bufPos;
            bArr2[i3] = b;
            int i4 = i3 + 1;
            this.bufPos = i4;
            if (i4 != 64) {
                return 0;
            }
            processData(bArr2, 0, 64, bArr, i);
            this.poly1305.update(bArr, i, 64);
            this.bufPos = 0;
            return 64;
        } else if (i2 == 7) {
            byte[] bArr3 = this.buf;
            int i5 = this.bufPos;
            bArr3[i5] = b;
            int i6 = i5 + 1;
            this.bufPos = i6;
            if (i6 != bArr3.length) {
                return 0;
            }
            this.poly1305.update(bArr3, 0, 64);
            processData(this.buf, 0, 64, bArr, i);
            byte[] bArr4 = this.buf;
            System.arraycopy(bArr4, 64, bArr4, 0, 16);
            this.bufPos = 16;
            return 64;
        } else {
            throw new IllegalStateException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0098 A[LOOP:2: B:26:0x0096->B:27:0x0098, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int processBytes(byte[] r17, int r18, int r19, byte[] r20, int r21) throws org.bouncycastle.crypto.DataLengthException {
        /*
            r16 = this;
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            java.lang.String r0 = "'in' cannot be null"
            java.util.Objects.requireNonNull(r7, r0)
            if (r8 < 0) goto L_0x00d5
            if (r9 < 0) goto L_0x00cd
            int r0 = r7.length
            int r0 = r0 - r9
            if (r8 > r0) goto L_0x00c5
            if (r11 < 0) goto L_0x00bd
            r16.checkData()
            int r0 = r6.state
            r1 = 3
            r12 = 0
            r13 = 64
            if (r0 == r1) goto L_0x0065
            r1 = 7
            if (r0 != r1) goto L_0x005f
            r14 = r12
            r15 = r14
        L_0x002b:
            if (r14 >= r9) goto L_0x00bc
            byte[] r0 = r6.buf
            int r1 = r6.bufPos
            int r2 = r8 + r14
            byte r2 = r7[r2]
            r0[r1] = r2
            int r1 = r1 + 1
            r6.bufPos = r1
            int r2 = r0.length
            if (r1 != r2) goto L_0x005c
            org.bouncycastle.crypto.Mac r1 = r6.poly1305
            r1.update(r0, r12, r13)
            byte[] r1 = r6.buf
            r2 = 0
            r3 = 64
            int r5 = r11 + r15
            r0 = r16
            r4 = r20
            r0.processData(r1, r2, r3, r4, r5)
            byte[] r0 = r6.buf
            r1 = 16
            java.lang.System.arraycopy(r0, r13, r0, r12, r1)
            r6.bufPos = r1
            int r15 = r15 + 64
        L_0x005c:
            int r14 = r14 + 1
            goto L_0x002b
        L_0x005f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x0065:
            int r0 = r6.bufPos
            if (r0 == 0) goto L_0x0095
        L_0x0069:
            if (r9 <= 0) goto L_0x0095
            int r9 = r9 + -1
            byte[] r1 = r6.buf
            int r0 = r6.bufPos
            int r14 = r8 + 1
            byte r2 = r7[r8]
            r1[r0] = r2
            int r0 = r0 + 1
            r6.bufPos = r0
            if (r0 != r13) goto L_0x0093
            r2 = 0
            r3 = 64
            r0 = r16
            r4 = r20
            r5 = r21
            r0.processData(r1, r2, r3, r4, r5)
            org.bouncycastle.crypto.Mac r0 = r6.poly1305
            r0.update(r10, r11, r13)
            r6.bufPos = r12
            r15 = r13
            r8 = r14
            goto L_0x0096
        L_0x0093:
            r8 = r14
            goto L_0x0069
        L_0x0095:
            r15 = r12
        L_0x0096:
            if (r9 < r13) goto L_0x00b3
            r3 = 64
            int r14 = r11 + r15
            r0 = r16
            r1 = r17
            r2 = r8
            r4 = r20
            r5 = r14
            r0.processData(r1, r2, r3, r4, r5)
            org.bouncycastle.crypto.Mac r0 = r6.poly1305
            r0.update(r10, r14, r13)
            int r8 = r8 + 64
            int r9 = r9 + -64
            int r15 = r15 + 64
            goto L_0x0096
        L_0x00b3:
            if (r9 <= 0) goto L_0x00bc
            byte[] r0 = r6.buf
            java.lang.System.arraycopy(r7, r8, r0, r12, r9)
            r6.bufPos = r9
        L_0x00bc:
            return r15
        L_0x00bd:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "'outOff' cannot be negative"
            r0.<init>(r1)
            throw r0
        L_0x00c5:
            org.bouncycastle.crypto.DataLengthException r0 = new org.bouncycastle.crypto.DataLengthException
            java.lang.String r1 = "Input buffer too short"
            r0.<init>(r1)
            throw r0
        L_0x00cd:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "'len' cannot be negative"
            r0.<init>(r1)
            throw r0
        L_0x00d5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "'inOff' cannot be negative"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.modes.ChaCha20Poly1305.processBytes(byte[], int, int, byte[], int):int");
    }

    public void reset() {
        reset(true, true);
    }
}
