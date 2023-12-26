package com.wushuangtech.wstechapi.internal;

import android.content.Context;
import com.wushuangtech.audiocore.MyAudioApi;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.wstechapi.OmniRtcEngine;
import com.wushuangtech.wstechapi.OmniRtcEngineExtend;
import com.wushuangtech.wstechapi.bean.OmniLocalModuleConfig;
import com.wushuangtech.wstechapi.bean.VideoBitrateMode;
import com.wushuangtech.wstechapi.inter.OmniInterSyncHelper;

public class OmniRtcEngineExtendImpl implements OmniRtcEngineExtend {
    private final OmniInterSyncHelperImpl mOmniInterSyncHelperImpl;

    OmniRtcEngineExtendImpl(OmniInterSyncHelperImpl omniInterSyncHelperImpl) {
        this.mOmniInterSyncHelperImpl = omniInterSyncHelperImpl;
    }

    public int muteRtmpPublishAudioStream(final boolean z) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("muteRtmpPublishAudioStream muted : " + z, new OmniInterSyncHelper() {
            public int run() {
                MyAudioApi.getInstance((Context) null).muteLocal(z);
                return 0;
            }
        });
    }

    public int forceVideoEncodeSoftware(final boolean z) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("forceVideoEncodeSoftware softEncode : " + z, new OmniInterSyncHelper() {
            public int run() {
                if (GlobalConfig.mIsInRoom.get()) {
                    return -3;
                }
                GlobalConfig.mForceVideoSoftEncoder = z;
                return 0;
            }
        });
    }

    public int forceVideoDecodeSoftware(final boolean z) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("forceVideoDecodeSoftware softDecode : " + z, new OmniInterSyncHelper() {
            public int run() {
                if (GlobalConfig.mIsInRoom.get()) {
                    return -3;
                }
                GlobalConfig.mForceVideoSoftDecoder = z;
                return 0;
            }
        });
    }

    public int setVideoEncoderBitrateMode(final VideoBitrateMode videoBitrateMode) {
        final OmniRtcEngineImpl omniRtcEngineImpl = (OmniRtcEngineImpl) OmniRtcEngine.getInstance();
        String invokedMethodName = omniRtcEngineImpl.getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "videoBitrateMode : " + videoBitrateMode, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                omniRtcEngineImpl.handleVideoModule(new OmniLocalModuleConfig(29, new Object[]{videoBitrateMode}));
                return 0;
            }
        });
    }

    public int setExternalVideoProfile(int i, int i2, int i3, int i4) {
        final OmniRtcEngineImpl omniRtcEngineImpl = (OmniRtcEngineImpl) OmniRtcEngine.getInstance();
        String invokedMethodName = omniRtcEngineImpl.getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "width : " + i + " | height : " + i2 + " | frameRate : " + i3 + " | bitRate : " + i4, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                omniRtcEngineImpl.handleVideoModule(new OmniLocalModuleConfig(17, new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}));
                return 0;
            }
        });
    }

    public int setHardwareDecoderSize(final int i) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("setHardwareDecoderSize size : " + i, new OmniInterSyncHelper() {
            public int run() {
                GlobalConfig.mVideoDecoderHardwareSize = i;
                return 0;
            }
        });
    }

    public boolean resetRecordScreenSize(boolean z) {
        OmniRtcEngine instance = OmniRtcEngine.getInstance();
        if (instance == null) {
            return false;
        }
        OmniRtcEngineImpl omniRtcEngineImpl = (OmniRtcEngineImpl) instance;
        omniRtcEngineImpl.mRecorderLock.lock();
        try {
            OmniLog.screen_d("TTTRtcEngine", "resetRecordScreenSize invoked! landscapeMode : " + z);
            return omniRtcEngineImpl.mScreenCapture.resizeScreenCapture(z);
        } finally {
            omniRtcEngineImpl.mRecorderLock.unlock();
        }
    }

    private byte[] checkFrame(byte[] bArr, byte[] bArr2) {
        OmniRtcEngine instance = OmniRtcEngine.getInstance();
        if (instance == null) {
            return null;
        }
        Object handleVideoModule = ((OmniRtcEngineImpl) instance).handleVideoModule(new OmniLocalModuleConfig(23, new Object[]{bArr, bArr2}));
        if (handleVideoModule != null) {
            return (byte[]) handleVideoModule;
        }
        return null;
    }
}
