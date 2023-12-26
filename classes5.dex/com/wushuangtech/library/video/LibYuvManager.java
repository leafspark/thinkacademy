package com.wushuangtech.library.video;

import java.nio.ByteBuffer;

public class LibYuvManager {
    private final Object mLock;
    private long mPointer;
    private ByteBuffer mYuvData;

    private native boolean convertToI420(long j, byte[] bArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    private native byte[] nativeCommonRotateOperator(long j, int i, byte[] bArr, int i2, int i3, int i4, int i5, boolean z);

    private native byte[] nativeCommonToI420(long j, byte[] bArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    private native byte[] nativeCommonToI420NotOther(long j, int i, byte[] bArr, int i2, int i3, int i4, int i5, boolean z);

    private native byte[] nativeCommonToNV12(long j, byte[] bArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    private native long nativeInitialize(LibYuvManager libYuvManager);

    private native void nativeUnInitialize(long j);

    private native void setCacheDirectBufferAddress(long j, ByteBuffer byteBuffer);

    public LibYuvManager() {
        Object obj = new Object();
        this.mLock = obj;
        synchronized (obj) {
            this.mPointer = nativeInitialize(this);
        }
    }

    public void clearResource() {
        synchronized (this.mLock) {
            long j = this.mPointer;
            if (j != 0) {
                nativeUnInitialize(j);
                this.mYuvData = null;
                this.mPointer = 0;
            }
        }
    }

    public byte[] commonRotateYuv(int i, byte[] bArr, int i2, int i3, int i4, boolean z) {
        long j = this.mPointer;
        synchronized (this.mLock) {
            if (j == 0) {
                return null;
            }
            return nativeCommonRotateOperator(j, i, bArr, i2, i3, 0, i4, z);
        }
    }

    public byte[] commonToI420(int i, byte[] bArr, int i2, int i3, int i4, boolean z) {
        long j = this.mPointer;
        synchronized (this.mLock) {
            if (j == 0) {
                return null;
            }
            return nativeCommonToI420NotOther(j, i, bArr, i2, i3, 0, i4, z);
        }
    }

    public byte[] transNV21ToI420(byte[] bArr, int i, int i2, boolean z, int i3) {
        return transToI420(bArr, 1, i, i2, z, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r0.capacity() == (((r19 * r20) * 3) / 2)) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r0 = java.nio.ByteBuffer.allocateDirect(((r19 * r20) * 3) / 2).order(java.nio.ByteOrder.nativeOrder());
        r15.mYuvData = r0;
        setCacheDirectBufferAddress(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        r15.mYuvData.position(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005b, code lost:
        if (convertToI420(r2, r18, r21, 1, r19, r20, 0, 0, r19, r20, r19, r20, r22) == false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        r2 = r17;
        r1 = r2.mYuvData.arrayOffset();
        r3 = new byte[r2.mYuvData.capacity()];
        java.lang.System.arraycopy(r2.mYuvData.array(), r1, r3, 0, r2.mYuvData.capacity());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007d, code lost:
        r2 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r0 = r15.mYuvData;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r0 == null) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] transNV21ToI420DirectBuffer(byte[] r18, int r19, int r20, boolean r21, int r22) {
        /*
            r17 = this;
            r15 = r17
            long r2 = r15.mPointer
            java.lang.Object r1 = r15.mLock
            monitor-enter(r1)
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r16 = 0
            if (r0 != 0) goto L_0x0011
            monitor-exit(r1)     // Catch:{ all -> 0x0080 }
            return r16
        L_0x0011:
            monitor-exit(r1)     // Catch:{ all -> 0x0080 }
            java.nio.ByteBuffer r0 = r15.mYuvData
            if (r0 == 0) goto L_0x0022
            int r0 = r0.capacity()
            int r1 = r19 * r20
            int r1 = r1 * 3
            int r1 = r1 / 2
            if (r0 == r1) goto L_0x0039
        L_0x0022:
            int r0 = r19 * r20
            int r0 = r0 * 3
            int r0 = r0 / 2
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocateDirect(r0)
            java.nio.ByteOrder r1 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r0 = r0.order(r1)
            r15.mYuvData = r0
            r15.setCacheDirectBufferAddress(r2, r0)
        L_0x0039:
            java.nio.ByteBuffer r0 = r15.mYuvData
            r14 = 0
            r0.position(r14)
            r6 = 1
            r9 = 0
            r10 = 0
            r1 = r17
            r4 = r18
            r5 = r21
            r7 = r19
            r8 = r20
            r11 = r19
            r12 = r20
            r13 = r19
            r0 = r14
            r14 = r20
            r15 = r22
            boolean r1 = r1.convertToI420(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            if (r1 == 0) goto L_0x007d
            r2 = r17
            java.nio.ByteBuffer r1 = r2.mYuvData
            int r1 = r1.arrayOffset()
            java.nio.ByteBuffer r3 = r2.mYuvData
            int r3 = r3.capacity()
            byte[] r3 = new byte[r3]
            java.nio.ByteBuffer r4 = r2.mYuvData
            byte[] r4 = r4.array()
            java.nio.ByteBuffer r5 = r2.mYuvData
            int r5 = r5.capacity()
            java.lang.System.arraycopy(r4, r1, r3, r0, r5)
            return r3
        L_0x007d:
            r2 = r17
            return r16
        L_0x0080:
            r0 = move-exception
            r2 = r15
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x0084 }
            throw r0
        L_0x0084:
            r0 = move-exception
            goto L_0x0082
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.video.LibYuvManager.transNV21ToI420DirectBuffer(byte[], int, int, boolean, int):byte[]");
    }

    public byte[] transARGBToI420(byte[] bArr, int i, int i2, boolean z, int i3) {
        return transToI420(bArr, 4, i, i2, z, i3);
    }

    public byte[] transToI420(byte[] bArr, int i, int i2, int i3, boolean z, int i4) {
        long j = this.mPointer;
        synchronized (this.mLock) {
            if (j == 0) {
                return null;
            }
            return nativeCommonToI420(j, bArr, z, i, i2, i3, 0, 0, i2, i3, i2, i3, i4);
        }
    }

    public byte[] transToNV12(byte[] bArr, int i, int i2, int i3, boolean z, int i4) {
        long j = this.mPointer;
        synchronized (this.mLock) {
            if (j == 0) {
                return null;
            }
            return nativeCommonToNV12(j, bArr, z, i, i2, i3, 0, 0, i2, i3, i2, i3, i4);
        }
    }

    public byte[] getI420YFrame(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        return bArr2;
    }

    public byte[] getI420UFrame(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = i3 / 4;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i3, bArr2, 0, i4);
        return bArr2;
    }

    public byte[] getI420VFrame(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = i3 / 4;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i3 + i4, bArr2, 0, i4);
        return bArr2;
    }
}
