package tv.danmaku.ijk.media.psplayer;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class HardwareCodecUtils {
    private static final String TAG = "HardwareCodecUtils";
    private static final String[] VIDEO_MINE_TYPES = {"video/avc"};
    private static HashMap<String, MediaCodecInfo.CodecCapabilities> decoderCapabilitiesMap = new HashMap<>();
    private static HashMap<String, MediaCodecInfo.CodecCapabilities> encoderCapabilitiesMap = new HashMap<>();
    private static final String[] supportedH264HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.MTK.", "OMX.hisi.", "OMX.IMG.", "OMX.k3.", "OMX.TI.", "OMX.rk.", "OMX.amlogic.", "OMX.Intel.", "OMX.Nvidia.", "OMX.allwinner.", "OMX.MS.", "OMX.realtek.", "OMX.Freescale.", "OMX.sprd."};

    static {
        synchronized (TAG) {
            init();
        }
    }

    public static String getHardwareCodecName(String str) {
        String str2 = TAG;
        Log.d(str2, "getHardwareCodecName mineType " + str);
        synchronized (str2) {
            for (Map.Entry next : decoderCapabilitiesMap.entrySet()) {
                String str3 = (String) next.getKey();
                MediaCodecInfo.CodecCapabilities codecCapabilities = (MediaCodecInfo.CodecCapabilities) next.getValue();
                if (Build.VERSION.SDK_INT >= 21 && codecCapabilities.getMimeType().equalsIgnoreCase(str)) {
                    String str4 = TAG;
                    Log.d(str4, "getHardwareCodecName codeName " + str3);
                    return str3;
                }
            }
            String str5 = TAG;
            Log.d(str5, "getHardwareCodecName codeName " + null);
            return null;
        }
    }

    public static boolean isSupportHardwareDecode(String str) {
        return !TextUtils.isEmpty(getHardwareCodecName(str));
    }

    private static MediaCodecInfo.CodecCapabilities getCodecCapabilities(String str) {
        for (Map.Entry next : decoderCapabilitiesMap.entrySet()) {
            String str2 = (String) next.getKey();
            MediaCodecInfo.CodecCapabilities codecCapabilities = (MediaCodecInfo.CodecCapabilities) next.getValue();
            if (Build.VERSION.SDK_INT >= 21 && codecCapabilities.getMimeType().equalsIgnoreCase(str)) {
                return codecCapabilities;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a4, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isSupportHardwareDecode(java.lang.String r8, int r9, int r10, int r11, int r12, int r13, int r14) {
        /*
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getHardwareCodecName mineType "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, android.media.MediaCodecInfo$CodecCapabilities> r1 = decoderCapabilitiesMap     // Catch:{ all -> 0x00a6 }
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x00a6 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00a6 }
            r2 = 0
            r3 = r2
        L_0x0023:
            boolean r4 = r1.hasNext()     // Catch:{ all -> 0x00a6 }
            r5 = 21
            if (r4 == 0) goto L_0x0061
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x00a6 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x00a6 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x00a6 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00a6 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x00a6 }
            android.media.MediaCodecInfo$CodecCapabilities r3 = (android.media.MediaCodecInfo.CodecCapabilities) r3     // Catch:{ all -> 0x00a6 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00a6 }
            if (r6 < r5) goto L_0x0023
            java.lang.String r6 = r3.getMimeType()     // Catch:{ all -> 0x00a6 }
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ all -> 0x00a6 }
            if (r6 == 0) goto L_0x0023
            java.lang.String r1 = TAG     // Catch:{ all -> 0x00a6 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r6.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r7 = "getHardwareCodecName codeName "
            r6.append(r7)     // Catch:{ all -> 0x00a6 }
            r6.append(r4)     // Catch:{ all -> 0x00a6 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x00a6 }
            android.util.Log.d(r1, r4)     // Catch:{ all -> 0x00a6 }
        L_0x0061:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x00a6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r4.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r6 = "getHardwareCodecName codeName "
            r4.append(r6)     // Catch:{ all -> 0x00a6 }
            r4.append(r2)     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x00a6 }
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x00a6 }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00a6 }
            if (r1 < r5) goto L_0x00a3
            if (r3 == 0) goto L_0x00a3
            android.media.MediaFormat r8 = android.media.MediaFormat.createVideoFormat(r8, r9, r10)     // Catch:{ all -> 0x00a6 }
            if (r11 < 0) goto L_0x0088
            java.lang.String r9 = "profile"
            r8.setInteger(r9, r11)     // Catch:{ all -> 0x00a6 }
        L_0x0088:
            if (r12 < 0) goto L_0x008f
            java.lang.String r9 = "level"
            r8.setInteger(r9, r12)     // Catch:{ all -> 0x00a6 }
        L_0x008f:
            if (r14 < 0) goto L_0x0096
            java.lang.String r9 = "frame-rate"
            r8.setInteger(r9, r14)     // Catch:{ all -> 0x00a6 }
        L_0x0096:
            if (r13 <= 0) goto L_0x009d
            java.lang.String r9 = "bitrate"
            r8.setInteger(r9, r13)     // Catch:{ all -> 0x00a6 }
        L_0x009d:
            boolean r8 = r3.isFormatSupported(r8)     // Catch:{ all -> 0x00a6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            return r8
        L_0x00a3:
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            r8 = 0
            return r8
        L_0x00a6:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.psplayer.HardwareCodecUtils.isSupportHardwareDecode(java.lang.String, int, int, int, int, int, int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a3, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getSupportHardwareDecodeName(java.lang.String r6, java.lang.String r7, int r8, int r9) {
        /*
            java.lang.String r7 = TAG
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getHardwareCodecName mineType "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r7, r0)
            monitor-enter(r7)
            java.util.HashMap<java.lang.String, android.media.MediaCodecInfo$CodecCapabilities> r0 = decoderCapabilitiesMap     // Catch:{ all -> 0x00a4 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x00a4 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00a4 }
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0024:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x00a4 }
            if (r4 == 0) goto L_0x005c
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00a4 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00a4 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00a4 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00a4 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00a4 }
            android.media.MediaCodecInfo$CodecCapabilities r2 = (android.media.MediaCodecInfo.CodecCapabilities) r2     // Catch:{ all -> 0x00a4 }
            java.lang.String r4 = r2.getMimeType()     // Catch:{ all -> 0x00a4 }
            boolean r4 = r4.equalsIgnoreCase(r6)     // Catch:{ all -> 0x00a4 }
            if (r4 == 0) goto L_0x0024
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r4.<init>()     // Catch:{ all -> 0x00a4 }
            java.lang.String r5 = "getHardwareCodecName codeName "
            r4.append(r5)     // Catch:{ all -> 0x00a4 }
            r4.append(r3)     // Catch:{ all -> 0x00a4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00a4 }
            android.util.Log.d(r0, r4)     // Catch:{ all -> 0x00a4 }
        L_0x005c:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r4.<init>()     // Catch:{ all -> 0x00a4 }
            java.lang.String r5 = "getHardwareCodecName codeName "
            r4.append(r5)     // Catch:{ all -> 0x00a4 }
            r4.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00a4 }
            android.util.Log.d(r0, r4)     // Catch:{ all -> 0x00a4 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00a4 }
            r4 = 21
            if (r0 < r4) goto L_0x00a2
            if (r2 == 0) goto L_0x00a2
            android.media.MediaFormat r0 = new android.media.MediaFormat     // Catch:{ all -> 0x00a4 }
            r0.<init>()     // Catch:{ all -> 0x00a4 }
            java.lang.String r4 = "mime"
            r0.setString(r4, r6)     // Catch:{ all -> 0x00a4 }
            if (r8 < 0) goto L_0x008f
            java.lang.String r4 = "profile"
            int r8 = changeToMediaCodecProfile(r6, r8)     // Catch:{ all -> 0x00a4 }
            r0.setInteger(r4, r8)     // Catch:{ all -> 0x00a4 }
        L_0x008f:
            if (r9 < 0) goto L_0x009a
            java.lang.String r8 = "level"
            int r6 = changeToMediaCodecLevel(r6, r9)     // Catch:{ all -> 0x00a4 }
            r0.setInteger(r8, r6)     // Catch:{ all -> 0x00a4 }
        L_0x009a:
            boolean r6 = r2.isFormatSupported(r0)     // Catch:{ all -> 0x00a4 }
            if (r6 == 0) goto L_0x00a2
            monitor-exit(r7)     // Catch:{ all -> 0x00a4 }
            return r3
        L_0x00a2:
            monitor-exit(r7)     // Catch:{ all -> 0x00a4 }
            return r1
        L_0x00a4:
            r6 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00a4 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.psplayer.HardwareCodecUtils.getSupportHardwareDecodeName(java.lang.String, java.lang.String, int, int):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r5 != 3) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int changeToMediaCodecProfile(java.lang.String r4, int r5) {
        /*
            java.lang.String r0 = "video/avc"
            boolean r0 = r4.equalsIgnoreCase(r0)
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0020
            switch(r5) {
                case 66: goto L_0x0030;
                case 77: goto L_0x0033;
                case 88: goto L_0x001e;
                case 100: goto L_0x001b;
                case 110: goto L_0x0018;
                case 122: goto L_0x0015;
                case 144: goto L_0x0012;
                case 244: goto L_0x0012;
                case 578: goto L_0x000f;
                case 2158: goto L_0x0018;
                case 2170: goto L_0x0015;
                case 2192: goto L_0x0012;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0032
        L_0x000f:
            r1 = 65536(0x10000, float:9.18355E-41)
            goto L_0x0033
        L_0x0012:
            r1 = 64
            goto L_0x0033
        L_0x0015:
            r1 = 32
            goto L_0x0033
        L_0x0018:
            r1 = 16
            goto L_0x0033
        L_0x001b:
            r1 = 8
            goto L_0x0033
        L_0x001e:
            r1 = 4
            goto L_0x0033
        L_0x0020:
            java.lang.String r0 = "video/hevc"
            boolean r4 = r4.equalsIgnoreCase(r0)
            if (r4 == 0) goto L_0x0032
            if (r5 == r2) goto L_0x0030
            if (r5 == r1) goto L_0x0033
            r4 = 3
            if (r5 == r4) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r1 = r2
            goto L_0x0033
        L_0x0032:
            r1 = r3
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.psplayer.HardwareCodecUtils.changeToMediaCodecProfile(java.lang.String, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return okhttp3.internal.http2.Http2.INITIAL_MAX_FRAME_SIZE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return okio.internal._BufferKt.SEGMENTING_THRESHOLD;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return 1024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return 256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return 64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int changeToMediaCodecLevel(java.lang.String r13, int r14) {
        /*
            java.lang.String r0 = "video/avc"
            boolean r0 = r13.equalsIgnoreCase(r0)
            r1 = 262144(0x40000, float:3.67342E-40)
            r2 = 65536(0x10000, float:9.18355E-41)
            r3 = 16384(0x4000, float:2.2959E-41)
            r4 = 4096(0x1000, float:5.74E-42)
            r5 = 1024(0x400, float:1.435E-42)
            r6 = 256(0x100, float:3.59E-43)
            r7 = 64
            r8 = 16
            r9 = 4
            r10 = 1
            r11 = 29
            r12 = 0
            if (r0 == 0) goto L_0x005e
            switch(r14) {
                case 9: goto L_0x005b;
                case 10: goto L_0x008f;
                case 11: goto L_0x008d;
                case 12: goto L_0x0058;
                case 13: goto L_0x008b;
                default: goto L_0x0020;
            }
        L_0x0020:
            switch(r14) {
                case 20: goto L_0x0055;
                case 21: goto L_0x0089;
                case 22: goto L_0x0052;
                default: goto L_0x0023;
            }
        L_0x0023:
            switch(r14) {
                case 30: goto L_0x0087;
                case 31: goto L_0x004f;
                case 32: goto L_0x0085;
                default: goto L_0x0026;
            }
        L_0x0026:
            switch(r14) {
                case 40: goto L_0x004c;
                case 41: goto L_0x0083;
                case 42: goto L_0x0049;
                default: goto L_0x0029;
            }
        L_0x0029:
            switch(r14) {
                case 50: goto L_0x0081;
                case 51: goto L_0x0045;
                case 52: goto L_0x007f;
                default: goto L_0x002c;
            }
        L_0x002c:
            switch(r14) {
                case 60: goto L_0x003e;
                case 61: goto L_0x0038;
                case 62: goto L_0x0031;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x0091
        L_0x0031:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r11) goto L_0x0091
            r13 = 524288(0x80000, float:7.34684E-40)
            goto L_0x005c
        L_0x0038:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r11) goto L_0x0091
            goto L_0x0092
        L_0x003e:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r11) goto L_0x0091
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x005c
        L_0x0045:
            r13 = 32768(0x8000, float:4.5918E-41)
            goto L_0x005c
        L_0x0049:
            r13 = 8192(0x2000, float:1.14794E-41)
            goto L_0x005c
        L_0x004c:
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x005c
        L_0x004f:
            r13 = 512(0x200, float:7.175E-43)
            goto L_0x005c
        L_0x0052:
            r13 = 128(0x80, float:1.794E-43)
            goto L_0x005c
        L_0x0055:
            r13 = 32
            goto L_0x005c
        L_0x0058:
            r13 = 8
            goto L_0x005c
        L_0x005b:
            r13 = 2
        L_0x005c:
            r1 = r13
            goto L_0x0092
        L_0x005e:
            java.lang.String r0 = "video/hevc"
            boolean r13 = r13.equalsIgnoreCase(r0)
            if (r13 == 0) goto L_0x0091
            switch(r14) {
                case 30: goto L_0x008f;
                case 60: goto L_0x008d;
                case 63: goto L_0x008b;
                case 90: goto L_0x0089;
                case 93: goto L_0x0087;
                case 120: goto L_0x0085;
                case 123: goto L_0x0083;
                case 150: goto L_0x0081;
                case 153: goto L_0x007f;
                case 156: goto L_0x0092;
                case 180: goto L_0x0078;
                case 183: goto L_0x0071;
                case 186: goto L_0x006a;
                default: goto L_0x0069;
            }
        L_0x0069:
            goto L_0x0091
        L_0x006a:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r11) goto L_0x0091
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            goto L_0x0092
        L_0x0071:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r11) goto L_0x0091
            r1 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x0092
        L_0x0078:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r11) goto L_0x0091
            r1 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0092
        L_0x007f:
            r1 = r2
            goto L_0x0092
        L_0x0081:
            r1 = r3
            goto L_0x0092
        L_0x0083:
            r1 = r4
            goto L_0x0092
        L_0x0085:
            r1 = r5
            goto L_0x0092
        L_0x0087:
            r1 = r6
            goto L_0x0092
        L_0x0089:
            r1 = r7
            goto L_0x0092
        L_0x008b:
            r1 = r8
            goto L_0x0092
        L_0x008d:
            r1 = r9
            goto L_0x0092
        L_0x008f:
            r1 = r10
            goto L_0x0092
        L_0x0091:
            r1 = r12
        L_0x0092:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.psplayer.HardwareCodecUtils.changeToMediaCodecLevel(java.lang.String, int):int");
    }

    public static void init() {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        Log.d(TAG, "init start");
        if (Build.VERSION.SDK_INT >= 21) {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
                for (String str : VIDEO_MINE_TYPES) {
                    MediaCodecInfo.CodecCapabilities codecCapabilities = null;
                    try {
                        codecCapabilities = mediaCodecInfo.getCapabilitiesForType(str);
                    } catch (IllegalArgumentException unused) {
                    }
                    if (codecCapabilities != null) {
                        String name = mediaCodecInfo.getName();
                        if (isHardwareCodec(str, name)) {
                            if (mediaCodecInfo.isEncoder() && !encoderCapabilitiesMap.containsKey(str)) {
                                encoderCapabilitiesMap.put(name, codecCapabilities);
                            } else if (!encoderCapabilitiesMap.containsKey(str)) {
                                decoderCapabilitiesMap.put(name, codecCapabilities);
                            }
                        }
                    }
                }
            }
        } else {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                String[] strArr = VIDEO_MINE_TYPES;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    String str2 = strArr[i2];
                    if (encoderCapabilitiesMap.containsKey(str2) || !isHardwareCodec(str2, codecInfoAt.getName()) || (capabilitiesForType = codecInfoAt.getCapabilitiesForType(str2)) == null) {
                        i2++;
                    } else if (codecInfoAt.isEncoder()) {
                        encoderCapabilitiesMap.put(str2, capabilitiesForType);
                    } else {
                        decoderCapabilitiesMap.put(str2, capabilitiesForType);
                    }
                }
            }
        }
        Log.d(TAG, "init end");
    }

    private static boolean isHardwareCodec(String str, String str2) {
        for (int i = 0; i < VIDEO_MINE_TYPES.length; i++) {
        }
        for (String startsWith : supportedH264HwCodecPrefixes) {
            if (str2.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }
}
