package com.wushuangtech.utils;

import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import io.agora.rtc.Constants;

public class SntpClient {
    public static final int DEF_TIMEOUT_MILLIS = 1000;
    private static final int NTP_MODE_CLIENT = 3;
    private static final int NTP_PACKET_SIZE = 48;
    private static final int NTP_PORT = 123;
    private static final int NTP_VERSION = 3;
    private static final long OFFSET_1900_TO_1970 = 2208988800L;
    private static final int ORIGINATE_TIME_OFFSET = 24;
    private static final int RECEIVE_TIME_OFFSET = 32;
    private static final int REFERENCE_TIME_OFFSET = 16;
    private static final String TAG = "SntpClient";
    private static final int TRANSMIT_TIME_OFFSET = 40;
    private long mNtpTime;
    private long mNtpTimeReference;
    private long mRoundTripTime;

    public interface CallBack {
        void onRequestComplete(boolean z, long j, long j2, long j3);
    }

    public static void asyncRequestTime(final String str, final int i, final CallBack callBack) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                SntpClient sntpClient = new SntpClient();
                callBack.onRequestComplete(sntpClient.requestTime(str, i), sntpClient.getNtpTime(), sntpClient.getNtpTimeReference(), sntpClient.getRoundTripTime());
            }
        });
        if (!(thread instanceof Thread)) {
            thread.start();
        } else {
            AsynchronousInstrumentation.threadStart(thread);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean requestTime(java.lang.String r20, int r21) {
        /*
            r19 = this;
            r1 = r19
            r2 = 0
            r3 = 0
            java.net.DatagramSocket r4 = new java.net.DatagramSocket     // Catch:{ Exception -> 0x006e }
            r4.<init>()     // Catch:{ Exception -> 0x006e }
            r0 = r21
            r4.setSoTimeout(r0)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            java.net.InetAddress r0 = java.net.InetAddress.getByName(r20)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r3 = 48
            byte[] r5 = new byte[r3]     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            java.net.DatagramPacket r6 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r7 = 123(0x7b, float:1.72E-43)
            r6.<init>(r5, r3, r0, r7)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r0 = 27
            r5[r2] = r0     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r0 = 40
            r1.writeTimeStamp(r5, r0, r7)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r4.send(r6)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            java.net.DatagramPacket r6 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r6.<init>(r5, r3)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r4.receive(r6)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            long r9 = r11 - r9
            long r7 = r7 + r9
            r3 = 24
            long r13 = r1.readTimeStamp(r5, r3)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r3 = 32
            long r15 = r1.readTimeStamp(r5, r3)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            long r5 = r1.readTimeStamp(r5, r0)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            long r17 = r5 - r15
            long r9 = r9 - r17
            long r15 = r15 - r13
            long r5 = r5 - r7
            long r15 = r15 + r5
            r5 = 2
            long r15 = r15 / r5
            long r7 = r7 + r15
            r1.mNtpTime = r7     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r1.mNtpTimeReference = r11     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r1.mRoundTripTime = r9     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r4.close()
            r0 = 1
            return r0
        L_0x0066:
            r0 = move-exception
            r3 = r4
            goto L_0x008b
        L_0x0069:
            r0 = move-exception
            r3 = r4
            goto L_0x006f
        L_0x006c:
            r0 = move-exception
            goto L_0x008b
        L_0x006e:
            r0 = move-exception
        L_0x006f:
            java.lang.String r4 = "SntpClient"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r5.<init>()     // Catch:{ all -> 0x006c }
            java.lang.String r6 = "request time failed: "
            r5.append(r6)     // Catch:{ all -> 0x006c }
            r5.append(r0)     // Catch:{ all -> 0x006c }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x006c }
            com.wushuangtech.utils.OmniLog.d(r4, r0)     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x008a
            r3.close()
        L_0x008a:
            return r2
        L_0x008b:
            if (r3 == 0) goto L_0x0090
            r3.close()
        L_0x0090:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.utils.SntpClient.requestTime(java.lang.String, int):boolean");
    }

    /* access modifiers changed from: private */
    public long getNtpTime() {
        return this.mNtpTime;
    }

    /* access modifiers changed from: private */
    public long getNtpTimeReference() {
        return this.mNtpTimeReference;
    }

    /* access modifiers changed from: private */
    public long getRoundTripTime() {
        return this.mRoundTripTime;
    }

    private long read32(byte[] bArr, int i) {
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        byte b4 = bArr[i + 3];
        byte b5 = b & true;
        int i2 = b;
        if (b5 == true) {
            i2 = (b & Byte.MAX_VALUE) + 128;
        }
        byte b6 = b2 & true;
        int i3 = b2;
        if (b6 == true) {
            i3 = (b2 & Byte.MAX_VALUE) + 128;
        }
        byte b7 = b3 & true;
        int i4 = b3;
        if (b7 == true) {
            i4 = (b3 & Byte.MAX_VALUE) + 128;
        }
        byte b8 = b4 & true;
        int i5 = b4;
        if (b8 == true) {
            i5 = (b4 & Byte.MAX_VALUE) + Constants.ERR_WATERMARK_ARGB;
        }
        return (((long) i2) << 24) + (((long) i3) << 16) + (((long) i4) << 8) + ((long) i5);
    }

    private long readTimeStamp(byte[] bArr, int i) {
        return ((read32(bArr, i) - OFFSET_1900_TO_1970) * 1000) + ((read32(bArr, i + 4) * 1000) / 4294967296L);
    }

    private void writeTimeStamp(byte[] bArr, int i, long j) {
        long j2 = j / 1000;
        long j3 = j - (j2 * 1000);
        long j4 = j2 + OFFSET_1900_TO_1970;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) (j4 >> 24));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) (j4 >> 16));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) (j4 >> 8));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) (j4 >> 0));
        long j5 = (j3 * 4294967296L) / 1000;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) (j5 >> 24));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) (j5 >> 16));
        bArr[i7] = (byte) ((int) (j5 >> 8));
        bArr[i7 + 1] = (byte) ((int) (Math.random() * 255.0d));
    }
}
