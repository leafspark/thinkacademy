package com.wushuangtech.handler;

import android.util.LongSparseArray;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.api.ExternalAudioModuleImpl;
import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.api.ExternalVideoModuleImpl;
import com.wushuangtech.constants.RtcGlobalServerMessage;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.log.RtcHeartbeatReporter;
import com.wushuangtech.utils.ByteConvertTool;
import com.wushuangtech.utils.NetQualityCONST;
import com.yalantis.ucrop.view.CropImageView;
import java.util.HashMap;
import java.util.List;

public class NetworkQualityHandler {
    private static final int STREAM_ID = 100000;
    private final Object mQualityLock = new Object();
    private HashMap<Long, Integer> mUserUploadQuality;

    public void updateNetQuality() {
        Integer num;
        Integer num2;
        List<RtcHeartbeatReporter> rtcHeartbeatReporterForAll = GlobalHolder.getInstance().getRtcHeartbeatReporterForAll();
        if (rtcHeartbeatReporterForAll != null && rtcHeartbeatReporterForAll.size() > 0) {
            for (RtcHeartbeatReporter next : rtcHeartbeatReporterForAll) {
                if (next.isJoinedChannel()) {
                    String channelName = next.getChannelName();
                    LongSparseArray<ExternalAudioModule.AudioStatistics> audioStatistics = ((ExternalAudioModuleImpl) ExternalAudioModule.getInstance()).getAudioStatistics(channelName);
                    LongSparseArray<ExternalVideoModule.VideoStatistics> videoStatistics = ((ExternalVideoModuleImpl) ExternalVideoModule.getInstance()).getVideoStatistics(channelName);
                    GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.NETWORK_QUALITY, next.getChannelName(), 0L, Integer.valueOf(getUploadQuality(channelName)), Integer.valueOf(getLocalDownloadQuality(audioStatistics, videoStatistics)));
                    if (audioStatistics != null && audioStatistics.size() > 0) {
                        for (int i = 0; i < audioStatistics.size(); i++) {
                            long keyAt = audioStatistics.keyAt(i);
                            int i2 = NetQualityCONST.QUALITY_UNKNOWN;
                            int downloadQuality = getDownloadQuality(audioStatistics, videoStatistics, keyAt);
                            synchronized (this.mQualityLock) {
                                HashMap<Long, Integer> hashMap = this.mUserUploadQuality;
                                if (!(hashMap == null || (num2 = hashMap.get(Long.valueOf(keyAt))) == null)) {
                                    i2 = num2.intValue();
                                }
                            }
                            GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.NETWORK_QUALITY, next.getChannelName(), Long.valueOf(keyAt), Integer.valueOf(i2), Integer.valueOf(downloadQuality));
                        }
                        continue;
                    } else if (videoStatistics != null && videoStatistics.size() > 0) {
                        for (int i3 = 0; i3 < videoStatistics.size(); i3++) {
                            long keyAt2 = videoStatistics.keyAt(i3);
                            int i4 = NetQualityCONST.QUALITY_UNKNOWN;
                            int downloadQuality2 = getDownloadQuality(audioStatistics, videoStatistics, keyAt2);
                            synchronized (this.mQualityLock) {
                                HashMap<Long, Integer> hashMap2 = this.mUserUploadQuality;
                                if (!(hashMap2 == null || (num = hashMap2.get(Long.valueOf(keyAt2))) == null)) {
                                    i4 = num.intValue();
                                }
                            }
                            GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.NETWORK_QUALITY, next.getChannelName(), Long.valueOf(keyAt2), Integer.valueOf(i4), Integer.valueOf(downloadQuality2));
                        }
                        continue;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean parseUploadNetQuality(long j, byte[] bArr) {
        if (bArr == null || bArr.length != 24) {
            return false;
        }
        int length = GlobalConfig.guid.length;
        if (!ByteConvertTool.memcmp(bArr, GlobalConfig.guid, length)) {
            return false;
        }
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        System.arraycopy(bArr, length, bArr2, 0, 4);
        System.arraycopy(bArr, length + 4, bArr3, 0, 4);
        int upQuality = getUpQuality(ByteConvertTool.getInt(bArr2), ByteConvertTool.getFloat(bArr3) * 100.0f);
        synchronized (this.mQualityLock) {
            if (this.mUserUploadQuality == null) {
                this.mUserUploadQuality = new HashMap<>();
            }
            this.mUserUploadQuality.put(Long.valueOf(j), Integer.valueOf(upQuality));
        }
        return true;
    }

    private static int getLocalDownloadQuality(LongSparseArray<ExternalAudioModule.AudioStatistics> longSparseArray, LongSparseArray<ExternalVideoModule.VideoStatistics> longSparseArray2) {
        float f = CropImageView.DEFAULT_ASPECT_RATIO;
        if (longSparseArray != null && longSparseArray.size() > 0) {
            int size = longSparseArray.size();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                long keyAt = longSparseArray.keyAt(i3);
                ExternalAudioModule.AudioStatistics valueAt = longSparseArray.valueAt(i3);
                if (valueAt != null) {
                    i2++;
                    f += (float) valueAt.fractionLost;
                    int i4 = valueAt.bufferDuration > 0 ? valueAt.bufferDuration : 0;
                    if (longSparseArray2 != null && longSparseArray2.size() > 0) {
                        ExternalVideoModule.VideoStatistics videoStatistics = longSparseArray2.get(keyAt);
                        if (videoStatistics != null) {
                            i2++;
                            f += (float) videoStatistics.lostRate;
                            if (videoStatistics.jitter > i4) {
                                i4 = videoStatistics.jitter;
                            }
                        }
                    }
                    i += i4;
                }
            }
            return getDownQuality(i / size, (f / ((float) (i2 * 255))) * 100.0f);
        } else if (longSparseArray2 == null || longSparseArray2.size() <= 0) {
            return NetQualityCONST.QUALITY_UNKNOWN;
        } else {
            int size2 = longSparseArray2.size();
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < size2; i7++) {
                ExternalVideoModule.VideoStatistics valueAt2 = longSparseArray2.valueAt(i7);
                if (valueAt2 != null) {
                    i6++;
                    f += (float) valueAt2.fractionLost;
                    i5 += valueAt2.bufferDuration > 0 ? valueAt2.bufferDuration : 0;
                }
            }
            return getDownQuality(i5 / size2, (f / ((float) (i6 * 255))) * 100.0f);
        }
    }

    private static int getUploadQuality(String str) {
        ExternalVideoModule.LocalVideoStatistics localVideoStatistics = ((ExternalVideoModuleImpl) ExternalVideoModule.getInstance()).getLocalVideoStatistics();
        ExternalAudioModule.LocalAudioStatistics localAudioStatistics = ((ExternalAudioModuleImpl) ExternalAudioModule.getInstance()).getLocalAudioStatistics();
        int i = (localAudioStatistics.rttMs + localVideoStatistics.V_RTT) / 2;
        float f = (float) (((double) (((float) (localAudioStatistics.fractionLost + localVideoStatistics.V_SENDFRACTIONLOST)) * 1.0f)) / 510.0d);
        byte[] bArr = new byte[24];
        int length = GlobalConfig.guid.length;
        System.arraycopy(GlobalConfig.guid, 0, bArr, 0, length);
        System.arraycopy(ByteConvertTool.getBytes(i), 0, bArr, length, 4);
        System.arraycopy(ByteConvertTool.getBytes(f), 0, bArr, length + 4, 4);
        RoomJni.getInstance().SendCustomizedAudioMsg(str, 100000, bArr);
        return getUpQuality(i, f * 100.0f);
    }

    private static int getDownloadQuality(LongSparseArray<ExternalAudioModule.AudioStatistics> longSparseArray, LongSparseArray<ExternalVideoModule.VideoStatistics> longSparseArray2, long j) {
        int i;
        ExternalVideoModule.VideoStatistics videoStatistics;
        ExternalAudioModule.AudioStatistics audioStatistics;
        int i2 = 0;
        float f = CropImageView.DEFAULT_ASPECT_RATIO;
        if (longSparseArray == null || longSparseArray.size() <= 0 || (audioStatistics = longSparseArray.get(j)) == null) {
            i = 0;
        } else {
            if (audioStatistics.bufferDuration > 0) {
                i2 = audioStatistics.bufferDuration;
            }
            f = CropImageView.DEFAULT_ASPECT_RATIO + ((float) audioStatistics.fractionLost);
            i = 1;
        }
        if (!(longSparseArray2 == null || longSparseArray2.size() <= 0 || (videoStatistics = longSparseArray2.get(j)) == null)) {
            if (videoStatistics.jitter > i2) {
                i2 = videoStatistics.jitter;
            }
            f += (float) videoStatistics.fractionLost;
            i++;
        }
        if (i <= 0) {
            return NetQualityCONST.QUALITY_UNKNOWN;
        }
        return getDownQuality(i2, (f / (((float) i) * 255.0f)) * 100.0f);
    }

    private static int getUpQuality(int i, float f) {
        if (f > 95.0f) {
            return NetQualityCONST.QUALITY_DOWN;
        }
        if (f > 50.0f) {
            return NetQualityCONST.QUALITY_VBAD;
        }
        if (f > 30.0f) {
            return NetQualityCONST.QUALITY_BAD;
        }
        if (i > 400) {
            return NetQualityCONST.QUALITY_POOR;
        }
        if (i > 250) {
            return NetQualityCONST.QUALITY_GOOD;
        }
        return NetQualityCONST.QUALITY_EXCELLENT;
    }

    private static int getDownQuality(int i, float f) {
        if (f > 50.0f) {
            return NetQualityCONST.QUALITY_VBAD;
        }
        if (f > 30.0f) {
            return i > 2000 ? NetQualityCONST.QUALITY_VBAD : NetQualityCONST.QUALITY_BAD;
        }
        if (f > 20.0f) {
            if (i > 2000) {
                return NetQualityCONST.QUALITY_VBAD;
            }
            if (i > 1000) {
                return NetQualityCONST.QUALITY_BAD;
            }
            return NetQualityCONST.QUALITY_POOR;
        } else if (f > 10.0f) {
            if (i > 2000) {
                return NetQualityCONST.QUALITY_VBAD;
            }
            if (i > 1000) {
                return NetQualityCONST.QUALITY_BAD;
            }
            if (i > 600) {
                return NetQualityCONST.QUALITY_POOR;
            }
            return NetQualityCONST.QUALITY_GOOD;
        } else if (i > 2000) {
            return NetQualityCONST.QUALITY_VBAD;
        } else {
            if (i > 1000) {
                return NetQualityCONST.QUALITY_BAD;
            }
            if (i > 600) {
                return NetQualityCONST.QUALITY_POOR;
            }
            return NetQualityCONST.QUALITY_EXCELLENT;
        }
    }
}
