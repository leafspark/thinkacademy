package com.eaydu.omni;

import com.eaydu.omni.RTCEngine;

public class EngineConfig {
    public static final String AGORA_VERSION = "3.4.5.190";
    public static final int[] EXPORT_SO_ENGINES = new int[0];
    public static int LogLevelConfig = 3;
    public static final String OMNI_VERSION = "3.6.140";
    public static final String POST_SERVER = "http://rtclog.weclassroom.com/stream.gif";
    public static final String SDK_VERSION = "3.26.1102";
    public static final byte[] SEI_IRC_UUID = {-106, -75, 71, -106, -97, 112, 73, Byte.MAX_VALUE, -107, -8, -50, 15, 85, 112, 33, 31};
    public static final byte[] SEI_TS_UUID = {-88, 95, -28, -23, 27, 105, 17, -24, -123, -126, 0, 80, -62, 73, 0, 72};
    public static final int[] SUPPORT_ENGINES = {1, 7};
    public static final String TRTC_VERSION = "10.3.0.11248";
    public static final String VOLC_VERSION = "3.46.102";
    public static final String XES_VERSION = "1.0.0";

    public static class LogLevel {
        public static final int ERROR = 3;
        public static final int INFO = 1;
        public static final int NONE = 4;
        public static final int VERBOSE = 0;
        public static final int WARNING = 2;
    }

    /* renamed from: com.eaydu.omni.EngineConfig$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$eaydu$omni$RTCEngine$EngineType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.eaydu.omni.RTCEngine$EngineType[] r0 = com.eaydu.omni.RTCEngine.EngineType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$eaydu$omni$RTCEngine$EngineType = r0
                com.eaydu.omni.RTCEngine$EngineType r1 = com.eaydu.omni.RTCEngine.EngineType.Tencent     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$eaydu$omni$RTCEngine$EngineType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.eaydu.omni.RTCEngine$EngineType r1 = com.eaydu.omni.RTCEngine.EngineType.OMNI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$eaydu$omni$RTCEngine$EngineType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.eaydu.omni.RTCEngine$EngineType r1 = com.eaydu.omni.RTCEngine.EngineType.Agora     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$eaydu$omni$RTCEngine$EngineType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.eaydu.omni.RTCEngine$EngineType r1 = com.eaydu.omni.RTCEngine.EngineType.VOLC     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.EngineConfig.AnonymousClass1.<clinit>():void");
        }
    }

    public static String getEngineReportName(RTCEngine.EngineType engineType) {
        int i = AnonymousClass1.$SwitchMap$com$eaydu$omni$RTCEngine$EngineType[engineType.ordinal()];
        if (i == 1) {
            return "TRTC_Android_V10.3.0.11248";
        }
        if (i == 2) {
            return "CoreRTC_Android_V3.6.140";
        }
        if (i != 3) {
            return i != 4 ? "unknown" : "volc_3.46.102";
        }
        return "agora_3.4.5.190";
    }
}
