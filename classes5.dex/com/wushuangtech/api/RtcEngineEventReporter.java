package com.wushuangtech.api;

import com.wushuangtech.constants.RtcEngineEvent;
import com.wushuangtech.expansion.inter.OmniRtcEngineEventInter;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.video.VideoStatistical;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.utils.YuvToBitmap;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class RtcEngineEventReporter {
    private static final String TAG = "RtcEngineEventReporter";
    private final CopyOnWriteArrayList<WeakReference<OmniRtcEngineEventInter>> mEventReceivers = new CopyOnWriteArrayList<>();
    private final AtomicBoolean mLocalJpeg = new AtomicBoolean(false);
    private final AtomicBoolean mTakeLocalBitmap = new AtomicBoolean(false);

    private void handleAudioEvent(OmniRtcEngineEventInter omniRtcEngineEventInter, int i, Object[] objArr) {
    }

    private void handleChannelEvent(OmniRtcEngineEventInter omniRtcEngineEventInter, int i, Object[] objArr) {
    }

    private Object handleChannelEventBySync(OmniRtcEngineEventInter omniRtcEngineEventInter, int i, Object[] objArr) {
        return null;
    }

    private void handleVideoEvent(OmniRtcEngineEventInter omniRtcEngineEventInter, int i, Object[] objArr) {
    }

    public void addEventReceiver(OmniRtcEngineEventInter omniRtcEngineEventInter) {
        if (omniRtcEngineEventInter != null) {
            Iterator<WeakReference<OmniRtcEngineEventInter>> it = this.mEventReceivers.iterator();
            while (it.hasNext()) {
                OmniRtcEngineEventInter omniRtcEngineEventInter2 = (OmniRtcEngineEventInter) it.next().get();
                if (omniRtcEngineEventInter2 != null && omniRtcEngineEventInter2 == omniRtcEngineEventInter) {
                    return;
                }
            }
            this.mEventReceivers.add(new WeakReference(omniRtcEngineEventInter));
            String str = TAG;
            OmniLog.i(str, "Add a new rtc engine event receiver, size = " + this.mEventReceivers.size());
        }
    }

    public void removeEventReceiver(OmniRtcEngineEventInter omniRtcEngineEventInter) {
        Iterator<WeakReference<OmniRtcEngineEventInter>> it = this.mEventReceivers.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            OmniRtcEngineEventInter omniRtcEngineEventInter2 = (OmniRtcEngineEventInter) it.next().get();
            if (omniRtcEngineEventInter2 != null) {
                if (omniRtcEngineEventInter2 == omniRtcEngineEventInter) {
                    break;
                }
                i++;
            }
        }
        if (i != -1) {
            this.mEventReceivers.remove(i);
            OmniLog.i(TAG, "Remove a rtc engine event receiver, size = " + this.mEventReceivers.size());
        }
    }

    public void clearReceiver() {
        this.mEventReceivers.clear();
    }

    public void clearResource() {
        this.mTakeLocalBitmap.compareAndSet(true, false);
        this.mLocalJpeg.compareAndSet(true, false);
    }

    public CopyOnWriteArrayList<WeakReference<OmniRtcEngineEventInter>> getReceivers() {
        return this.mEventReceivers;
    }

    public Object receiveEvent(boolean z, int i, Object... objArr) {
        OmniRtcEngineEventInter omniRtcEngineEventInter;
        OmniRtcEngineEventInter omniRtcEngineEventInter2;
        Object obj = null;
        if (checkNullValue(i, objArr) || this.mEventReceivers.size() <= 0) {
            return null;
        }
        if (1 == i) {
            Iterator<WeakReference<OmniRtcEngineEventInter>> it = this.mEventReceivers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference next = it.next();
                if (next != null && (omniRtcEngineEventInter2 = (OmniRtcEngineEventInter) next.get()) != null) {
                    reportChannelLogReport(omniRtcEngineEventInter2, objArr);
                    break;
                }
            }
            return null;
        }
        Iterator<WeakReference<OmniRtcEngineEventInter>> it2 = this.mEventReceivers.iterator();
        while (it2.hasNext()) {
            WeakReference next2 = it2.next();
            if (!(next2 == null || (omniRtcEngineEventInter = (OmniRtcEngineEventInter) next2.get()) == null)) {
                if (z) {
                    if (i > 0 && i < 5000) {
                        obj = handleChannelEventBySync(omniRtcEngineEventInter, i, objArr);
                    } else if (i > 5000 && i < 15000) {
                        obj = handleAudioEventBySync(omniRtcEngineEventInter, i, objArr);
                    } else if (i > 15000) {
                        obj = handleVideoEventBySync(omniRtcEngineEventInter, i, objArr);
                    }
                } else if (i > 0 && i < 5000) {
                    handleChannelEvent(omniRtcEngineEventInter, i, objArr);
                } else if (i > 5000 && i < 15000) {
                    handleAudioEvent(omniRtcEngineEventInter, i, objArr);
                } else if (i > 15000) {
                    handleVideoEvent(omniRtcEngineEventInter, i, objArr);
                }
            }
        }
        return obj;
    }

    private Object handleAudioEventBySync(OmniRtcEngineEventInter omniRtcEngineEventInter, int i, Object[] objArr) {
        switch (i) {
            case RtcEngineEvent.AudioEvent.EVENT_AUDIO_LOCAL_DATA /*5001*/:
                return omniRtcEngineEventInter.onLocalAudioDataReport(objArr[0], objArr[1].intValue(), objArr[2].intValue(), objArr[3].intValue());
            case RtcEngineEvent.AudioEvent.EVENT_AUDIO_REMOTE_DATA /*5002*/:
                return omniRtcEngineEventInter.onRemoteAudioDataReport(objArr[0], objArr[1].intValue(), objArr[2].intValue(), objArr[3].intValue());
            case RtcEngineEvent.AudioEvent.EVENT_AUDIO_MIX_DATA /*5003*/:
                return omniRtcEngineEventInter.onMixedAudioFrame(objArr[0], objArr[1].intValue(), objArr[2].intValue(), objArr[3].intValue());
            default:
                return null;
        }
    }

    private Object handleVideoEventBySync(OmniRtcEngineEventInter omniRtcEngineEventInter, int i, Object[] objArr) {
        switch (i) {
            case RtcEngineEvent.VideoEvent.EVENT_VIDEO_LOCAL_RAW_FRAME /*15002*/:
            case RtcEngineEvent.VideoEvent.EVENT_VIDEO_PRE_ENCODE_SNAPSHOT /*15004*/:
                executingVideoLocalData(omniRtcEngineEventInter, objArr);
                return null;
            case RtcEngineEvent.VideoEvent.EVENT_VIDEO_REMOTE_FRAME /*15003*/:
                executingVideoRemoteData(omniRtcEngineEventInter, objArr);
                return null;
            default:
                return null;
        }
    }

    private void reportChannelLogReport(OmniRtcEngineEventInter omniRtcEngineEventInter, Object... objArr) {
        int i = 0;
        int intValue = objArr[0].intValue();
        if (intValue == 4) {
            i = 1;
        } else if (!(intValue == 5 || intValue == 6)) {
            i = intValue == 3 ? 2 : (intValue == 2 || intValue == 1) ? 3 : 4;
        }
        omniRtcEngineEventInter.onRtcLogReport(i, objArr[1]);
    }

    private void executingVideoLocalData(OmniRtcEngineEventInter omniRtcEngineEventInter, Object[] objArr) {
        OmniRtcEngineEventInter omniRtcEngineEventInter2 = omniRtcEngineEventInter;
        byte[] bArr = objArr[0];
        int intValue = objArr[1].intValue();
        int intValue2 = objArr[2].intValue();
        int intValue3 = objArr[3].intValue();
        int intValue4 = objArr[4].intValue();
        int intValue5 = objArr[5].intValue();
        int intValue6 = objArr[6].intValue();
        int intValue7 = objArr[7].intValue();
        int intValue8 = objArr[8].intValue();
        int i = intValue8;
        omniRtcEngineEventInter.onCaptureVideoFrame(bArr, intValue, intValue2, intValue3, intValue4, intValue5, intValue6, intValue7, intValue8 == 270 ? 90 : intValue8, objArr[9].longValue());
        VideoStatistical globalVideoStatistical = GlobalHolder.getInstance().getGlobalVideoStatistical();
        if (globalVideoStatistical != null) {
            globalVideoStatistical.updateVideoLocalRawDataReport();
        }
        if (this.mTakeLocalBitmap.compareAndSet(true, false)) {
            try {
                omniRtcEngineEventInter2.onTakeLocalViewSnapshot(YuvToBitmap.getLocalBitmap(new YuvToBitmap.VideoFrame(intValue2, intValue3, bArr, intValue5, intValue6, intValue7, i)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.mLocalJpeg.compareAndSet(true, false)) {
            try {
                YuvToBitmap.VideoFrame videoFrame = new YuvToBitmap.VideoFrame(intValue2, intValue3, bArr, intValue5, intValue6, intValue7, i);
                int i2 = GlobalConfig.mJpgQuality;
                if (i2 < 0 || i2 > 100) {
                    i2 = 100;
                }
                byte[] Yuv420ToJpegConvert = YuvToBitmap.Yuv420ToJpegConvert(videoFrame, i2);
                if (Yuv420ToJpegConvert != null) {
                    omniRtcEngineEventInter2.onTakePreEncodeSnapshot(Yuv420ToJpegConvert);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void executingVideoRemoteData(OmniRtcEngineEventInter omniRtcEngineEventInter, Object[] objArr) {
        String str = objArr[0];
        long longValue = objArr[1].longValue();
        int intValue = objArr[3].intValue();
        int intValue2 = objArr[4].intValue();
        int intValue3 = objArr[5].intValue();
        int intValue4 = objArr[6].intValue();
        int intValue5 = objArr[7].intValue();
        OmniRtcEngineEventInter omniRtcEngineEventInter2 = omniRtcEngineEventInter;
        long j = longValue;
        long j2 = longValue;
        omniRtcEngineEventInter2.onRenderVideoFrame(j, objArr[2], 0, intValue, intValue2, (intValue3 + intValue4 + intValue5) * intValue2, intValue3, intValue4, intValue5, 0, objArr[8].longValue());
        VideoStatistical globalVideoStatistical = GlobalHolder.getInstance().getGlobalVideoStatistical();
        if (globalVideoStatistical != null) {
            globalVideoStatistical.updateVideoRemoteRawDataReport(j2);
        }
    }

    private boolean checkNullValue(int i, Object... objArr) {
        if (objArr == null) {
            return true;
        }
        int i2 = 0;
        for (Object obj : objArr) {
            if (obj == null) {
                OmniLog.e(TAG, "Check args failed, event type : " + i + "| index : " + i2);
                return true;
            }
            i2++;
        }
        return false;
    }

    public void takeLocalViewSnapshot() {
        this.mTakeLocalBitmap.compareAndSet(false, true);
    }

    public void takePreEncodeSnapshot() {
        this.mLocalJpeg.compareAndSet(false, true);
    }
}
