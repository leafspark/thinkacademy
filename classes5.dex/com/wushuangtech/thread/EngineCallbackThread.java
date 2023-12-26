package com.wushuangtech.thread;

import android.os.Message;
import com.wushuangtech.api.RtcEngineEventReporter;
import com.wushuangtech.bean.DelayMessageBean;
import com.wushuangtech.expansion.inter.OmniRtcEngineEventInter;
import com.wushuangtech.jni.callback.RtcEngineSignalDispatcher;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EngineCallbackThread extends BaseThread {
    public static final int CALLBACK_ON_AUDIO_LOCAL_STATE_CHANGED = 93;
    public static final int CALLBACK_ON_VIDEO_LOCAL_STATE_CHANGED = 94;
    public static final int ENGINE_CALL_TAKE_REMOTE_SNAPSHOT = 101;
    public static final int JNI_CALL_BACK_AUDIO_ROUTE_CHANGE = 19;
    public static final int JNI_CALL_BACK_AUDIO_VOLUME_INDICATION = 17;
    public static final int JNI_CALL_BACK_CAMERA_CONNECT_ERROR = 70;
    public static final int JNI_CALL_BACK_CAMERA_READY = 14;
    public static final int JNI_CALL_BACK_CONNECT_LOST = 11;
    public static final int JNI_CALL_BACK_ENTER_PULL_ROOM = 40;
    public static final int JNI_CALL_BACK_ENTER_ROOM = 5;
    public static final int JNI_CALL_BACK_LEAVE_CHANNEL = 16;
    public static final int JNI_CALL_BACK_LOCAL_AUDIO_SATAUS = 21;
    public static final int JNI_CALL_BACK_LOCAL_VIDEO_FIRST_FRAME = 10;
    public static final int JNI_CALL_BACK_LOCAL_VIDEO_SATAUS = 12;
    public static final int JNI_CALL_BACK_NET_QUALITY = 50;
    public static final int JNI_CALL_BACK_ON_AKAMAI_SERVER_ID = 52;
    public static final int JNI_CALL_BACK_ON_AUDIO_BUFFERING_STATE_CHANGED = 95;
    public static final int JNI_CALL_BACK_ON_AUDIO_FIRST_DECODE = 57;
    public static final int JNI_CALL_BACK_ON_AUDIO_FIRST_FRAME_RECV = 77;
    public static final int JNI_CALL_BACK_ON_AUDIO_FIRST_SENT = 72;
    public static final int JNI_CALL_BACK_ON_AUDIO_MIXING_FINISH = 51;
    public static final int JNI_CALL_BACK_ON_AUDIO_MUTE = 32;
    public static final int JNI_CALL_BACK_ON_AUDIO_PLAY_EFFECT_FINISH = 58;
    public static final int JNI_CALL_BACK_ON_AUDIO_PUBLISH_STATE_CHANGED = 103;
    public static final int JNI_CALL_BACK_ON_AUDIO_RECORD_FINISH = 64;
    public static final int JNI_CALL_BACK_ON_AUDIO_REMOTE_STATE_CHANGED = 79;
    public static final int JNI_CALL_BACK_ON_AUDIO_SUBSCRIBE_STATE_CHANGED = 105;
    public static final int JNI_CALL_BACK_ON_CAPTURE_SIZE_CHANGED = 99;
    public static final int JNI_CALL_BACK_ON_CHANNEL_MEDIA_RELAY_EVENT = 98;
    public static final int JNI_CALL_BACK_ON_CHANNEL_MEDIA_RELAY_STATE_CHANGED = 97;
    public static final int JNI_CALL_BACK_ON_CONNECT_STATE_CHANGED = 76;
    public static final int JNI_CALL_BACK_ON_CREATE_VIDEO_MIXER = 54;
    public static final int JNI_CALL_BACK_ON_DATA_STREAM_RECV = 75;
    public static final int JNI_CALL_BACK_ON_DUAL_MODE_ENABLE = 56;
    public static final int JNI_CALL_BACK_ON_ERROR = 6;
    public static final int JNI_CALL_BACK_ON_IJK_H264_SEI = 41;
    public static final int JNI_CALL_BACK_ON_MULTI_REMOTE_VIDEO_FIRST_DECODE = 60;
    public static final int JNI_CALL_BACK_ON_MULTI_REMOTE_VIDEO_FIRST_FRAME = 61;
    public static final int JNI_CALL_BACK_ON_MULTI_USER_MUTE_VIDEO = 59;
    public static final int JNI_CALL_BACK_ON_MULTI_VIDEO_TYPE_USER_MUTE_VIDEO = 69;
    public static final int JNI_CALL_BACK_ON_RECEIVE_LYRIC = 68;
    public static final int JNI_CALL_BACK_ON_RECEIVE_SEI_DATA = 34;
    public static final int JNI_CALL_BACK_ON_RECONNECT_SUCCESS = 53;
    public static final int JNI_CALL_BACK_ON_RECONNECT_TIMEOUT = 42;
    public static final int JNI_CALL_BACK_ON_REJOIN_CHANNEL_SUCCESS = 91;
    public static final int JNI_CALL_BACK_ON_REMOTE_STREAM_SUBSCRIBE_ADVICE = 100;
    public static final int JNI_CALL_BACK_ON_REQUEST_TOKEN = 90;
    public static final int JNI_CALL_BACK_ON_RTC_PUSH_ERROR = 71;
    public static final int JNI_CALL_BACK_ON_RTC_PUSH_STATUS = 63;
    public static final int JNI_CALL_BACK_ON_RTMP_STATUS = 35;
    public static final int JNI_CALL_BACK_ON_SEI = 20;
    public static final int JNI_CALL_BACK_ON_SPEAK_MUTE = 46;
    public static final int JNI_CALL_BACK_ON_USER_KICKED = 55;
    public static final int JNI_CALL_BACK_ON_USER_ROLE_CHANGED = 30;
    public static final int JNI_CALL_BACK_ON_VIDEO_BUFFERING_STATE_CHANGED = 92;
    public static final int JNI_CALL_BACK_ON_VIDEO_FIRST_SENT = 73;
    public static final int JNI_CALL_BACK_ON_VIDEO_PUBLISH_STATE_CHANGED = 102;
    public static final int JNI_CALL_BACK_ON_VIDEO_REMOTE_DECODED_DATA = 96;
    public static final int JNI_CALL_BACK_ON_VIDEO_REMOTE_STATE_CHANGED = 78;
    public static final int JNI_CALL_BACK_ON_VIDEO_STREAM_MUTED = 74;
    public static final int JNI_CALL_BACK_ON_VIDEO_SUBSCRIBE_STATE_CHANGED = 104;
    public static final int JNI_CALL_BACK_REMOTE_AUDIO_SATAUS = 22;
    public static final int JNI_CALL_BACK_REMOTE_VIDEO_FIRST_DECODE = 23;
    public static final int JNI_CALL_BACK_REMOTE_VIDEO_FIRST_FRAME = 9;
    public static final int JNI_CALL_BACK_REMOTE_VIDEO_SATAUS = 13;
    public static final int JNI_CALL_BACK_REQUEST_CHANNEL_KEY = 24;
    public static final int JNI_CALL_BACK_RTC_STATUS = 18;
    public static final int JNI_CALL_BACK_USER_EXIT = 8;
    public static final int JNI_CALL_BACK_USER_JOIN = 7;
    public static final int JNI_CALL_BACK_USER_MUTE_VIDEO = 15;
    public static final int NETWORK_QUALITY = 106;
    private List<DelayMessageBean> mDelayMessage = new ArrayList();
    private final RtcEngineSignalDispatcher mRtcEngineSignalDispatcher = new RtcEngineSignalDispatcher();

    /* access modifiers changed from: protected */
    public void receiveEvent(BaseThread baseThread, Message message) {
        try {
            handleReportEvent(this.mDelayMessage, message);
        } catch (Exception e) {
            e.printStackTrace();
            String str = this.TAG;
            OmniLog.e(str, "Report signal event failed! Exception hanppend! : " + e.getLocalizedMessage());
        }
    }

    public void clearDelayMessages() {
        this.mDelayMessage.clear();
        this.mDelayMessage = new ArrayList();
    }

    public void handleReportEvent(List<DelayMessageBean> list, Message message) {
        CopyOnWriteArrayList<WeakReference<OmniRtcEngineEventInter>> receivers;
        RtcEngineEventReporter rtcEngineEventReporter = GlobalHolder.getInstance().getRtcEngineEventReporter();
        if (rtcEngineEventReporter != null && (receivers = rtcEngineEventReporter.getReceivers()) != null && receivers.size() > 0) {
            this.mRtcEngineSignalDispatcher.receiveCallBackEvent(receivers, list, message);
        }
    }
}
