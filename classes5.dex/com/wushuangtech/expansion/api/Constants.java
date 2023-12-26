package com.wushuangtech.expansion.api;

public class Constants {
    public static final int AUDIO_CODEC_AAC = 1;
    public static final int AUDIO_CODEC_ISAC = 2;
    public static final int AUDIO_CODEC_OPUS = 4;
    public static final int AUDIO_EFFECT_DELAY = 1;
    public static final int AUDIO_EFFECT_PITCHSHIFT_HI = 3;
    public static final int AUDIO_EFFECT_PITCHSHIFT_LOW = 2;
    public static final int AUDIO_EFFECT_ROBOT = 4;
    public static final int AUDIO_EFFECT_WHISPER = 5;
    public static final int AUDIO_GENERAL_ERROR = 1005;
    public static final int AUDIO_MIXING_DOWNLOAD_ERROR = 160501;
    public static final int AUDIO_MIXING_DOWNLOAD_PLAY_ERROR = 160502;
    public static final int AUDIO_MIX_MODE_FOCUSED = 1;
    public static final int AUDIO_MIX_MODE_RAW = 0;
    public static final int AUDIO_MODE_CALL = 1;
    public static final int AUDIO_MODE_DEFAULT = 0;
    public static final int AUDIO_MODE_MUSIC = 2;
    public static final int AUDIO_PLAY_TRACK_STATS_ERROR = 1109;
    public static final int AUDIO_PROCESS_MODE_FAST_PROCESS = 1;
    public static final int AUDIO_PROCESS_MODE_FAST_RECORDING = 2;
    public static final int AUDIO_PROCESS_MODE_NORMAL = 0;
    public static final int AUDIO_PROFILE_DEFAULT = 0;
    public static final int AUDIO_PROFILE_MUSIC_HIGH_QUALITY = 4;
    public static final int AUDIO_PROFILE_MUSIC_HIGH_QUALITY_STEREO = 5;
    public static final int AUDIO_PROFILE_MUSIC_STANDARD = 2;
    public static final int AUDIO_PROFILE_MUSIC_STANDARD_STEREO = 3;
    public static final int AUDIO_PROFILE_SPEECH_STANDARD = 1;
    public static final int AUDIO_RECORDING_QUALITY_HIGH = 2;
    public static final int AUDIO_RECORDING_QUALITY_LOW = 0;
    public static final int AUDIO_RECORDING_QUALITY_MEDIUM = 1;
    public static final int AUDIO_ROUTE_HEADPHONE = 2;
    public static final int AUDIO_ROUTE_HEADSET = 0;
    public static final int AUDIO_ROUTE_HEADSETBLUETOOTH = 4;
    public static final int AUDIO_ROUTE_HEADSETNOMIC = 3;
    public static final int AUDIO_ROUTE_SPEAKER = 1;
    public static final int AUDIO_SCENARIO_CHATROOM_ENTERTAINMENT = 1;
    public static final int AUDIO_SCENARIO_CHATROOM_GAMING = 5;
    public static final int AUDIO_SCENARIO_DEFAULT = 0;
    public static final int AUDIO_SCENARIO_EDUCATION = 2;
    public static final int AUDIO_SCENARIO_GAME_STREAMING = 3;
    public static final int AUDIO_SCENARIO_SHOWROOM = 4;
    public static final int AUDIO_SCENE_AUTO_CHANGE = 3;
    public static final int AUDIO_SCENE_KTV = 4;
    public static final int AUDIO_SCENE_LIVE = 1;
    public static final int AUDIO_SCENE_STD = 5;
    public static final int AUDIO_SCENE_VOICE_CALL = 2;
    public static final int AUDIO_STUCK_STATE_BEGIN = 0;
    public static final int AUDIO_STUCK_STATE_END = 1;
    public static final int AUDIO_VAD_ACTIVE = 1;
    public static final int AUDIO_VAD_ERROR = -1;
    public static final int AUDIO_VAD_SILENCE = 0;
    public static final int CAMERA_BACK = 160301;
    public static final int CAMERA_EXTERNAL = 160302;
    public static final int CAMERA_FRONT = 160300;
    public static final int CAPTURE_REQUEST_CODE = 8080;
    public static final int CHANNEL_PROFILE_COMMUNICATION = 0;
    public static final int CHANNEL_PROFILE_GAME_FREE_MODE = 2;
    public static final int CHANNEL_PROFILE_LIVE_BROADCASTING = 1;
    public static final int CLIENT_ROLE_AUDIENCE = 2;
    public static final int CLIENT_ROLE_BROADCASTER = 1;
    public static final int CLIENT_ROLE_BROADCASTER2 = 3;
    public static final int CONNECTION_CHANGED_AUDIO_SWITCH_SERVER = 15;
    public static final int CONNECTION_CHANGED_BANNED_BY_SERVER = 3;
    public static final int CONNECTION_CHANGED_CLIENT_IP_ADDRESS_CHANGED = 13;
    public static final int CONNECTION_CHANGED_CONNECTING = 0;
    public static final int CONNECTION_CHANGED_INTERRUPTED = 2;
    public static final int CONNECTION_CHANGED_INVALID_APP_ID = 6;
    public static final int CONNECTION_CHANGED_INVALID_CHANNEL_NAME = 7;
    public static final int CONNECTION_CHANGED_INVALID_TOKEN = 8;
    public static final int CONNECTION_CHANGED_JOIN_FAILED = 4;
    public static final int CONNECTION_CHANGED_JOIN_SUCCESS = 1;
    public static final int CONNECTION_CHANGED_KEEP_ALIVE_TIMEOUT = 14;
    public static final int CONNECTION_CHANGED_LEAVE_CHANNEL = 5;
    public static final int CONNECTION_CHANGED_REJECTED_BY_SERVER = 10;
    public static final int CONNECTION_CHANGED_RENEW_TOKEN = 12;
    public static final int CONNECTION_CHANGED_SETTING_PROXY_SERVER = 11;
    public static final int CONNECTION_CHANGED_TOKEN_EXPIRED = 9;
    public static final int CONNECTION_CHANGED_VIDEO_SWITCH_SERVER = 16;
    public static final int CONNECTION_STATE_CONNECTED = 3;
    public static final int CONNECTION_STATE_CONNECTING = 2;
    public static final int CONNECTION_STATE_DISCONNECTED = 1;
    public static final int CONNECTION_STATE_FAILED = 5;
    public static final int CONNECTION_STATE_RECONNECTING = 4;
    public static final int ERROR_CAMERA_CONNECT_FAILED = 2;
    public static final int ERROR_CAMERA_CONNECT_LOST = 1;
    public static final int ERROR_ENTER_ROOM_BAD_VERSION = 4;
    public static final int ERROR_ENTER_ROOM_CONNECT_FAILED = 5;
    public static final int ERROR_ENTER_ROOM_INVALIDCHANNELNAME = 1;
    public static final int ERROR_ENTER_ROOM_NOEXIST = 6;
    public static final int ERROR_ENTER_ROOM_SERVER_VERIFY_FAILED = 7;
    public static final int ERROR_ENTER_ROOM_TIMEOUT = 2;
    public static final int ERROR_ENTER_ROOM_UNKNOW = 8;
    public static final int ERROR_ENTER_ROOM_VERIFY_FAILED = 3;
    public static final int ERROR_KICK_BY_AUDIO_CAPTURE_FAILED = 213;
    public static final int ERROR_KICK_BY_HOST = 101;
    public static final int ERROR_KICK_BY_MASTER_EXIT = 104;
    public static final int ERROR_KICK_BY_NEWCHAIRENTER = 108;
    public static final int ERROR_KICK_BY_NOAUDIODATA = 106;
    public static final int ERROR_KICK_BY_NOVIDEODATA = 107;
    public static final int ERROR_KICK_BY_PUSHRTMPFAILED = 102;
    public static final int ERROR_KICK_BY_RELOGIN = 105;
    public static final int ERROR_KICK_BY_SERVER = 111;
    public static final int ERROR_KICK_BY_SERVEROVERLOAD = 103;
    public static final int ERROR_RTC_PUSH_ERROR = 150;
    public static final int ERROR_TOKEN_EXPIRED = 109;
    public static final int ERR_INVALID_TOKEN = 110;
    public static final int ERR_TOKEN_EXPIRED = 170001;
    public static final int FRAME_TYPE_RGBA = 2;
    public static final int FRAME_TYPE_YUV420 = 0;
    public static final int FRAME_TYPE_YUV422 = 1;
    public static final int IJK_16_9_FIT_PARENT = 4;
    public static final int IJK_4_3_FIT_PARENT = 5;
    public static final int IJK_FIT_PARENT = 0;
    public static final int IJK_ILL_PARENT = 1;
    public static final int IJK_MATCH_PARENT = 3;
    public static final int IJK_WRAP_CONTENT = 2;
    public static final int LOCAL_AUDIO_STREAM_ERROR_CAPTURE_FAILURE = 4;
    public static final int LOCAL_AUDIO_STREAM_ERROR_DEVICE_BUSY = 3;
    public static final int LOCAL_AUDIO_STREAM_ERROR_DEVICE_NO_PERMISSION = 2;
    public static final int LOCAL_AUDIO_STREAM_ERROR_ENCODE_FAILURE = 5;
    public static final int LOCAL_AUDIO_STREAM_ERROR_FAILURE = 1;
    public static final int LOCAL_AUDIO_STREAM_ERROR_OK = 0;
    public static final int LOCAL_AUDIO_STREAM_STATE_CAPTURING = 1;
    public static final int LOCAL_AUDIO_STREAM_STATE_ENCODING = 2;
    public static final int LOCAL_AUDIO_STREAM_STATE_FAILED = 3;
    public static final int LOCAL_AUDIO_STREAM_STATE_STOPPED = 0;
    public static final int LOCAL_VIDEO_STREAM_ERROR_CAPTURE_FAILURE = 4;
    public static final int LOCAL_VIDEO_STREAM_ERROR_DEVICE_BUSY = 3;
    public static final int LOCAL_VIDEO_STREAM_ERROR_DEVICE_NO_PERMISSION = 2;
    public static final int LOCAL_VIDEO_STREAM_ERROR_ENCODE_FAILURE = 5;
    public static final int LOCAL_VIDEO_STREAM_ERROR_FAILURE = 1;
    public static final int LOCAL_VIDEO_STREAM_ERROR_OK = 0;
    public static final int LOCAL_VIDEO_STREAM_STATE_CAPTURING = 1;
    public static final int LOCAL_VIDEO_STREAM_STATE_ENCODING = 2;
    public static final int LOCAL_VIDEO_STREAM_STATE_FAILED = 3;
    public static final int LOCAL_VIDEO_STREAM_STATE_STOPPED = 0;
    public static final int LOG_FILTER_CRITICAL = 8;
    public static final int LOG_FILTER_DEBUG = 2063;
    public static final int LOG_FILTER_ERROR = 12;
    public static final int LOG_FILTER_INFO = 15;
    public static final int LOG_FILTER_OFF = 0;
    public static final int LOG_FILTER_WARNING = 14;
    public static final int QUALITY_BAD = 4;
    public static final int QUALITY_DETECTING = 8;
    public static final int QUALITY_DOWN = 6;
    public static final int QUALITY_EXCELLENT = 1;
    public static final int QUALITY_GOOD = 2;
    public static final int QUALITY_POOR = 3;
    public static final int QUALITY_UNKNOWN = 0;
    public static final int QUALITY_UNSUPPORTED = 7;
    public static final int QUALITY_VBAD = 5;
    public static final int RAW_AUDIO_FRAME_OP_MODE_READ_ONLY = 0;
    public static final int RAW_AUDIO_FRAME_OP_MODE_READ_WRITE = 2;
    public static final int RAW_AUDIO_FRAME_OP_MODE_WRITE_ONLY = 1;
    public static final int RELAY_ERROR_DEST_TOKEN_EXPIRED = 11;
    public static final int RELAY_ERROR_FAILED_JOIN_DEST = 5;
    public static final int RELAY_ERROR_FAILED_JOIN_SRC = 4;
    public static final int RELAY_ERROR_FAILED_PACKET_RECEIVED_FROM_SRC = 6;
    public static final int RELAY_ERROR_FAILED_PACKET_SENT_TO_DEST = 7;
    public static final int RELAY_ERROR_INTERNAL_ERROR = 9;
    public static final int RELAY_ERROR_NO_RESOURCE_AVAILABLE = 3;
    public static final int RELAY_ERROR_SERVER_CONNECTION_LOST = 8;
    public static final int RELAY_ERROR_SERVER_ERROR_RESPONSE = 1;
    public static final int RELAY_ERROR_SERVER_NO_RESPONSE = 2;
    public static final int RELAY_ERROR_SRC_TOKEN_EXPIRED = 10;
    public static final int RELAY_EVENT_NETWORK_CONNECTED = 1;
    public static final int RELAY_EVENT_NETWORK_DISCONNECTED = 0;
    public static final int RELAY_EVENT_PACKET_JOINED_DEST_CHANNEL = 3;
    public static final int RELAY_EVENT_PACKET_JOINED_SRC_CHANNEL = 2;
    public static final int RELAY_EVENT_PACKET_RECEIVED_AUDIO_FROM_SRC = 6;
    public static final int RELAY_EVENT_PACKET_RECEIVED_VIDEO_FROM_SRC = 5;
    public static final int RELAY_EVENT_PACKET_SENT_TO_DEST_CHANNEL = 4;
    public static final int RELAY_EVENT_PACKET_UPDATE_DEST_CHANNEL = 7;
    public static final int RELAY_EVENT_PACKET_UPDATE_DEST_CHANNEL_IS_NULL = 10;
    public static final int RELAY_EVENT_PACKET_UPDATE_DEST_CHANNEL_NOT_CHANGE = 9;
    public static final int RELAY_EVENT_PACKET_UPDATE_DEST_CHANNEL_REFUSED = 8;
    public static final int RELAY_EVENT_PAUSE_SEND_PACKET_TO_DEST_CHANNEL_FAILED = 13;
    public static final int RELAY_EVENT_PAUSE_SEND_PACKET_TO_DEST_CHANNEL_SUCCESS = 12;
    public static final int RELAY_EVENT_RESUME_SEND_PACKET_TO_DEST_CHANNEL_FAILED = 15;
    public static final int RELAY_EVENT_RESUME_SEND_PACKET_TO_DEST_CHANNEL_SUCCESS = 14;
    public static final int RELAY_EVENT_VIDEO_PROFILE_UPDATE = 11;
    public static final int RELAY_OK = 0;
    public static final int RELAY_STATE_CONNECTING = 1;
    public static final int RELAY_STATE_FAILURE = 3;
    public static final int RELAY_STATE_IDLE = 0;
    public static final int RELAY_STATE_RUNNING = 2;
    public static final int REMOTE_AUDIO_REASON_INTERNAL = 0;
    public static final int REMOTE_AUDIO_REASON_LOCAL_MUTED = 3;
    public static final int REMOTE_AUDIO_REASON_LOCAL_UNMUTED = 4;
    public static final int REMOTE_AUDIO_REASON_NETWORK_CONGESTION = 1;
    public static final int REMOTE_AUDIO_REASON_NETWORK_RECOVERY = 2;
    public static final int REMOTE_AUDIO_REASON_REMOTE_MUTED = 5;
    public static final int REMOTE_AUDIO_REASON_REMOTE_OFFLINE = 7;
    public static final int REMOTE_AUDIO_REASON_REMOTE_UNMUTED = 6;
    public static final int REMOTE_AUDIO_STATE_DECODING = 2;
    public static final int REMOTE_AUDIO_STATE_FAILED = 4;
    public static final int REMOTE_AUDIO_STATE_FROZEN = 3;
    public static final int REMOTE_AUDIO_STATE_STARTING = 1;
    public static final int REMOTE_AUDIO_STATE_STOPPED = 0;
    public static final int REMOTE_VIDEO_STATE_DECODING = 2;
    public static final int REMOTE_VIDEO_STATE_FAILED = 4;
    public static final int REMOTE_VIDEO_STATE_FROZEN = 3;
    public static final int REMOTE_VIDEO_STATE_REASON_AUDIO_FALLBACK = 8;
    public static final int REMOTE_VIDEO_STATE_REASON_AUDIO_FALLBACK_RECOVERY = 9;
    public static final int REMOTE_VIDEO_STATE_REASON_INTERNAL = 0;
    public static final int REMOTE_VIDEO_STATE_REASON_LOCAL_MUTED = 3;
    public static final int REMOTE_VIDEO_STATE_REASON_LOCAL_UNMUTED = 4;
    public static final int REMOTE_VIDEO_STATE_REASON_NETWORK_CONGESTION = 1;
    public static final int REMOTE_VIDEO_STATE_REASON_NETWORK_RECOVERY = 2;
    public static final int REMOTE_VIDEO_STATE_REASON_REMOTE_MUTED = 5;
    public static final int REMOTE_VIDEO_STATE_REASON_REMOTE_OFFLINE = 7;
    public static final int REMOTE_VIDEO_STATE_REASON_REMOTE_UNMUTED = 6;
    public static final int REMOTE_VIDEO_STATE_STARTING = 1;
    public static final int REMOTE_VIDEO_STATE_STOPPED = 0;
    public static final int RENDER_MODE_FILL = 3;
    public static final int RENDER_MODE_FIT = 2;
    public static final int RENDER_MODE_HIDDEN = 1;
    public static final int RTC_VIDEOPROFILE_1080P = 160226;
    public static final int RTC_VIDEOPROFILE_120P = 160220;
    public static final int RTC_VIDEOPROFILE_180P = 160221;
    public static final int RTC_VIDEOPROFILE_240P = 160222;
    public static final int RTC_VIDEOPROFILE_360P = 160223;
    public static final int RTC_VIDEOPROFILE_480P = 160224;
    public static final int RTC_VIDEOPROFILE_640x480 = 160227;
    public static final int RTC_VIDEOPROFILE_720P = 160225;
    public static final int RTC_VIDEOPROFILE_960x540 = 160228;
    public static final int RTC_VIDEOPROFILE_DEFAULT = 160223;
    public static final int RTMP_PUSH_STATE_INITERROR = 0;
    public static final int RTMP_PUSH_STATE_LINKFAILED = 4;
    public static final int RTMP_PUSH_STATE_LINKSUCCESSED = 5;
    public static final int RTMP_PUSH_STATE_OPENERROR = 1;
    public static final int STREAM_FALLBACK_OPTION_AUDIO_ONLY = 2;
    public static final int STREAM_FALLBACK_OPTION_DISABLED = 0;
    public static final int STREAM_FALLBACK_OPTION_VIDEO_STREAM_LOW = 1;
    public static final int USER_OFFLINE_KICK = 203;
    public static final int USER_OFFLINE_LINKCLOSE = 202;
    public static final int USER_OFFLINE_NORMAL = 200;
    public static final int USER_OFFLINE_TIMEOUT = 201;
    public static final int VIDEO_BITRATE_MODE_CBR = 2;
    public static final int VIDEO_BITRATE_MODE_CQ = 0;
    public static final int VIDEO_BITRATE_MODE_VBR = 1;
    public static final int VIDEO_MIRROR_MODE_AUTO = 160200;
    public static final int VIDEO_MIRROR_MODE_DISABLED = 160202;
    public static final int VIDEO_MIRROR_MODE_ENABLED = 160201;
    public static final int VIDEO_SERVER_MIX_MODE_HIGH = 160602;
    public static final int VIDEO_SERVER_MIX_MODE_NORMAL = 160601;
    public static final int VIDEO_STREAM_AUDIO = 2;
    public static final int VIDEO_STREAM_HIGH = 0;
    public static final int VIDEO_STREAM_LOW = 1;
    public static final int VIDEO_TYPE_CAMERA = 4;
    public static final int VIDEO_TYPE_FILE = 2;
    public static final int VIDEO_TYPE_NORMAL = 0;
    public static final int VIDEO_TYPE_SCREEN = 1;
    public static final int VIDEO_TYPE_VIDEOMIXER = 3;

    public enum AudioProfile {
        DEFAULT(0),
        SPEECH_STANDARD(1),
        MUSIC_STANDARD(2),
        MUSIC_STANDARD_STEREO(3),
        MUSIC_HIGH_QUALITY(4),
        MUSIC_HIGH_QUALITY_STEREO(5);
        
        private int value;

        private AudioProfile(int i) {
            this.value = i;
        }

        public static int getValue(AudioProfile audioProfile) {
            return audioProfile.value;
        }

        public static AudioProfile fromInt(int i) {
            if (i == 1) {
                return SPEECH_STANDARD;
            }
            if (i == 2) {
                return MUSIC_STANDARD_STEREO;
            }
            if (i == 3) {
                return MUSIC_HIGH_QUALITY;
            }
            if (i != 4) {
                return DEFAULT;
            }
            return MUSIC_HIGH_QUALITY_STEREO;
        }
    }

    public enum AudioScenario {
        DEFAULT(0),
        CHATROOM_ENTERTAINMENT(1),
        EDUCATION(2),
        GAME_STREAMING(3),
        SHOWROOM(4),
        CHATROOM_GAMING(5);
        
        private int value;

        private AudioScenario(int i) {
            this.value = i;
        }

        public static int getValue(AudioScenario audioScenario) {
            return audioScenario.value;
        }

        public static AudioScenario fromInt(int i) {
            if (i == 1) {
                return CHATROOM_ENTERTAINMENT;
            }
            if (i == 2) {
                return EDUCATION;
            }
            if (i == 3) {
                return GAME_STREAMING;
            }
            if (i == 4) {
                return SHOWROOM;
            }
            if (i != 5) {
                return DEFAULT;
            }
            return CHATROOM_GAMING;
        }
    }
}
