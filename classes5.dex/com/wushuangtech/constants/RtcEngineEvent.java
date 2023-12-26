package com.wushuangtech.constants;

public class RtcEngineEvent {

    public static class AudioEvent {
        public static final int EVENT_AUDIO_LOCAL_DATA = 5001;
        public static final int EVENT_AUDIO_MIX_DATA = 5003;
        public static final int EVENT_AUDIO_REMOTE_DATA = 5002;
        public static final int EVENT_AUDIO_START_POINT = 5000;
    }

    public static class ChannelEvent {
        public static final int EVENT_CHANNEL_LOG_REPORT = 1;
        public static final int EVENT_CHANNEL_START_POINT = 0;
    }

    public static class VideoEvent {
        public static final int EVENT_VIDEO_LOCAL_RAW_FRAME = 15002;
        public static final int EVENT_VIDEO_PRE_ENCODE_SNAPSHOT = 15004;
        public static final int EVENT_VIDEO_REMOTE_FRAME = 15003;
        public static final int EVENT_VIDEO_START_POINT = 15000;
    }
}
