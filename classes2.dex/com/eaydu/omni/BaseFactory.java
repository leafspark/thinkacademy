package com.eaydu.omni;

import android.content.Context;
import com.eaydu.omni.AgoraEngine;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.log.LogReport;
import com.wushuangtech.api.ExternalLoadHelper;

public class BaseFactory {
    public static int externalSoLoad(RTCEngine.EngineType engineType, String str) {
        if (engineType == RTCEngine.EngineType.OMNI) {
            return ExternalLoadHelper.load(str);
        }
        if (engineType != RTCEngine.EngineType.Tencent && engineType == RTCEngine.EngineType.Agora) {
            return AgoraEngine.AgoraUtils.loadExportSo(str);
        }
        return 0;
    }

    public static class Builder {
        private String mAppid;
        private Context mContext;
        private RTCEngine.IRtcEngineEventListener mListener;
        private String mPlanId;
        private String mRoomid;
        private String mSourceToken;
        private String mToken;
        private RTCEngine.EngineType mType;
        private long mUserid;
        private LogReport mlogReport;

        public Builder setMlogReport(LogReport logReport) {
            this.mlogReport = logReport;
            return this;
        }

        public Builder setmSourceToken(String str) {
            this.mSourceToken = str;
            return this;
        }

        public Builder setToken(String str) {
            this.mToken = str;
            return this;
        }

        public Builder setUserid(long j) {
            this.mUserid = j;
            return this;
        }

        public Builder setAppid(String str) {
            this.mAppid = str;
            return this;
        }

        public Builder setRoomid(String str) {
            this.mRoomid = str;
            return this;
        }

        public Builder setContext(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder setType(RTCEngine.EngineType engineType) {
            this.mType = engineType;
            return this;
        }

        public Builder setListener(RTCEngine.IRtcEngineEventListener iRtcEngineEventListener) {
            this.mListener = iRtcEngineEventListener;
            return this;
        }

        public Builder setPlanId(String str) {
            this.mPlanId = str;
            return this;
        }

        public BaseRtcEngine crteateEngine() {
            int i = AnonymousClass1.$SwitchMap$com$eaydu$omni$RTCEngine$EngineType[this.mType.ordinal()];
            if (i == 2) {
                return new OMNIEngine(this.mContext, this.mAppid, this.mListener, this.mToken, this.mRoomid, this.mUserid, this.mlogReport, this.mPlanId);
            } else if (i != 3) {
                return null;
            } else {
                return new AgoraEngine(this.mContext, this.mAppid, this.mListener, this.mToken, this.mRoomid, this.mUserid, this.mlogReport);
            }
        }
    }

    /* renamed from: com.eaydu.omni.BaseFactory$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.BaseFactory.AnonymousClass1.<clinit>():void");
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
