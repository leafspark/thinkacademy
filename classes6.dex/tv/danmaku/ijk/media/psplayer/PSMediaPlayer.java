package tv.danmaku.ijk.media.psplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.io.IOUtils;
import tv.danmaku.ijk.media.psplayer.IjkMediaMeta;
import tv.danmaku.ijk.media.psplayer.misc.IAndroidIO;
import tv.danmaku.ijk.media.psplayer.misc.IMediaDataSource;
import tv.danmaku.ijk.media.psplayer.misc.IjkTrackInfo;
import tv.danmaku.ijk.media.psplayer.pragma.DebugLog;

public class PSMediaPlayer extends AbstractMediaPlayer {
    public static final int BID_ATTAINMENT_VOD = 10;
    public static final int BID_COACH_3V3 = 18;
    public static final int BID_COACH_LIVE = 1;
    public static final int BID_COURSE_LIVE = 3;
    public static final int BID_COURSE_VOD = 7;
    public static final int BID_EXCELLENT_LIVE = 4;
    public static final int BID_EXCELLENT_VOD = 9;
    public static final int BID_FAKE_LIVE_3V3 = 200;
    public static final int BID_GLO = 6;
    public static final int BID_LECTURE_LIVE = 2;
    public static final int BID_LECTURE_VOD = 8;
    public static final int BID_LIGHTWEIGHT_LIVE = 12;
    private static final int BID_OLD = 1000;
    public static final int BID_ONEVONE_LIVE = 5;
    public static final int BID_PEIYOU_LIVE = 14;
    public static final int BID_UNKNOWN = 0;
    public static final int BID_WEILAIHAO_VOD = 11;
    public static final int BID_XIAOHOU_LIVE = 17;
    public static final int BID_XIAOHOU_VOD = 16;
    public static final int BID_ZHIKANG_LIVE = 15;
    public static final int ERR_IN_PLAYING_STATE = -1;
    public static final int ERR_OK = 0;
    public static final int FFP_PROPV_DECODER_AVCODEC = 1;
    public static final int FFP_PROPV_DECODER_MEDIACODEC = 2;
    private static final int FFP_PROPV_DECODER_UNKNOWN = 0;
    private static final int FFP_PROPV_DECODER_VIDEOTOOLBOX = 3;
    private static final int FFP_PROP_FLOAT_DROP_FRAME_RATE = 10007;
    private static final int FFP_PROP_FLOAT_PLAYBACK_RATE = 10003;
    private static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS = 20201;
    private static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY = 20203;
    private static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS = 20202;
    private static final int FFP_PROP_INT64_AUDIO_CACHED_BYTES = 20008;
    private static final int FFP_PROP_INT64_AUDIO_CACHED_DURATION = 20006;
    private static final int FFP_PROP_INT64_AUDIO_CACHED_PACKETS = 20010;
    private static final int FFP_PROP_INT64_AUDIO_DECODER = 20004;
    private static final int FFP_PROP_INT64_BIT_RATE = 20100;
    private static final int FFP_PROP_INT64_CACHE_STATISTIC_COUNT_BYTES = 20208;
    private static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_FORWARDS = 20206;
    private static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_POS = 20207;
    private static final int FFP_PROP_INT64_CACHE_STATISTIC_PHYSICAL_POS = 20205;
    private static final int FFP_PROP_INT64_DECODER_FRAME_PTS = 20214;
    private static final int FFP_PROP_INT64_IMMEDIATE_RECONNECT = 20211;
    private static final int FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION = 20300;
    private static final int FFP_PROP_INT64_LOGICAL_FILE_SIZE = 20209;
    private static final int FFP_PROP_INT64_SELECTED_AUDIO_STREAM = 20002;
    private static final int FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM = 20011;
    private static final int FFP_PROP_INT64_SELECTED_VIDEO_STREAM = 20001;
    private static final int FFP_PROP_INT64_SHARE_CACHE_DATA = 20210;
    private static final int FFP_PROP_INT64_TCP_SPEED = 20200;
    private static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT = 20204;
    private static final int FFP_PROP_INT64_VIDEO_CACHED_BYTES = 20007;
    private static final int FFP_PROP_INT64_VIDEO_CACHED_DURATION = 20005;
    private static final int FFP_PROP_INT64_VIDEO_CACHED_PACKETS = 20009;
    private static final int FFP_PROP_INT64_VIDEO_DECODER = 20003;
    public static final int IJK_LOG_DEBUG = 3;
    public static final int IJK_LOG_DEFAULT = 1;
    public static final int IJK_LOG_ERROR = 6;
    public static final int IJK_LOG_FATAL = 7;
    public static final int IJK_LOG_INFO = 4;
    public static final int IJK_LOG_SILENT = 8;
    public static final int IJK_LOG_UNKNOWN = 0;
    public static final int IJK_LOG_VERBOSE = 2;
    public static final int IJK_LOG_WARN = 5;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_ERROR = 100;
    private static final int MEDIA_ERROR_Dispatch = -18000;
    private static final int MEDIA_ERROR_Dispatch_FAILED_NET = -18001;
    private static final int MEDIA_ERROR_Dispatch_FAILED_SERVER = -18002;
    private static final int MEDIA_ERROR_IJK_PLAYER = -10000;
    private static final int MEDIA_ERROR_IO = -1004;
    private static final int MEDIA_ERROR_MALFORMED = -1007;
    private static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    private static final int MEDIA_ERROR_SERVER_DIED = 100;
    private static final int MEDIA_ERROR_SYNC = -18003;
    private static final int MEDIA_ERROR_TIMED_OUT = -110;
    private static final int MEDIA_ERROR_UNKNOWN = 1;
    private static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    private static final int MEDIA_INFO = 200;
    private static final int MEDIA_INFO_AUDIO_DECODED_START = 10003;
    private static final int MEDIA_INFO_AUDIO_RENDERING_START = 10002;
    private static final int MEDIA_INFO_AUDIO_SEEK_RENDERING_START = 10009;
    private static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    private static final int MEDIA_INFO_BUFFERING_END = 702;
    private static final int MEDIA_INFO_BUFFERING_START = 701;
    private static final int MEDIA_INFO_COMPONENT_OPEN = 10007;
    private static final int MEDIA_INFO_DECODE_STUCK_END = 10102;
    private static final int MEDIA_INFO_DECODE_STUCK_START = 10101;
    private static final int MEDIA_INFO_FIND_STREAM_INFO = 10006;
    private static final int MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE = 10100;
    private static final int MEDIA_INFO_METADATA_UPDATE = 802;
    private static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
    private static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    private static final int MEDIA_INFO_OPEN_INPUT = 10005;
    private static final int MEDIA_INFO_SERVERLIST_UPDATE = 350;
    private static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
    private static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
    private static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    private static final int MEDIA_INFO_TRING = 401;
    private static final int MEDIA_INFO_TRY_ALL_SERVER = 400;
    private static final int MEDIA_INFO_UNKNOWN = 1;
    private static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    private static final int MEDIA_INFO_VIDEO_DECODED_START = 10004;
    private static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    private static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
    private static final int MEDIA_INFO_VIDEO_SEEK_RENDERING_START = 10008;
    private static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    private static final int MEDIA_MESSAGE_RTC = 20001;
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_PLAYBACK_STATE_CHANGED = 700;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_RTC = 108;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    private static final int MEDIA_SEI_TEXT = 300;
    private static final int MEDIA_SET_VIDEO_SAR = 10001;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_TIMED_TEXT = 99;
    public static final int OPT_CATEGORY_CODEC = 2;
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final int OPT_CATEGORY_PLAYER = 4;
    public static final int OPT_CATEGORY_SWS = 3;
    private static final int PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND = 10001;
    private static final int PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND = 10002;
    public static final int PROTOCOL_AUTO = 0;
    public static final int PROTOCOL_FLV_LIVE = 2;
    public static final int PROTOCOL_HLS_LIVE = 3;
    public static final int PROTOCOL_HLS_VOD = 6;
    public static final int PROTOCOL_MP4 = 5;
    public static final int PROTOCOL_RTMP = 1;
    private static final int PS_CONTENT_MODE_MAX = 2;
    private static final int PS_CONTENT_MODE_MIN = 0;
    public static final int PS_CONTENT_MODE_RESIZE_ASPECT_FILL = 2;
    public static final int PS_CONTENT_MODE_RESIZE_ASPECT_FIT = 1;
    public static final int PS_CONTENT_MODE_RESIZE_TO_FILL = 0;
    public static final int RUNNING_BACKGROUND = 1;
    public static final int RUNNING_FOREGROUND = 0;
    public static final int SDL_FCC_RV16 = 909203026;
    public static final int SDL_FCC_RV32 = 842225234;
    public static final int SDL_FCC_YV12 = 842094169;
    public static final int SDL_FCC__GLES2 = 844318047;
    /* access modifiers changed from: private */
    public static final String TAG = "tv.danmaku.ijk.media.psplayer.PSMediaPlayer";
    private static BackupIP backupIPInfo = null;
    private static String currAPPID = "";
    private static String currAppKey = "";
    private static String currPSID = "";
    private static String currPassword = "";
    private static String currUDID = "";
    private static String currUserId = null;
    private static String currUserName = null;
    private static boolean enableGLES2 = isSupportGLES2();
    private static HttpDnsCallback httpDnsCallback = null;
    private static boolean is_login = false;
    private static Lock login_lock = new ReentrantLock();
    private static volatile Context mContext = null;
    private static volatile boolean mIsLibLoaded = false;
    private static volatile boolean mIsNativeInitialized = false;
    /* access modifiers changed from: private */
    public static int mLastErrCode = 0;
    /* access modifiers changed from: private */
    public static String mLastErrMsg = new String();
    /* access modifiers changed from: private */
    public static int mLastErrno = 0;
    private static PreloadListener mPreloadListener;
    private static final IjkLibLoader sLocalLibLoader = new IjkLibLoader() {
        public void loadLibrary(String str) throws UnsatisfiedLinkError, SecurityException {
            System.loadLibrary(str);
        }
    };
    private AudioPCMCallback audioPCMleCallback;
    private boolean isSurfaceHolder;
    private int mContentMode;
    private int mCurrLineIndex;
    private String mDataSource;
    /* access modifiers changed from: private */
    public OnDecodeStuckListener mDecodeStuckListener;
    private EventHandler mEventHandler;
    private boolean mIsLive;
    private boolean mIsStart;
    private int mListenerContext;
    private long mNativeAndroidIO;
    private long mNativeMediaDataSource;
    /* access modifiers changed from: private */
    public long mNativeMediaPlayer;
    private int mNativeSurfaceTexture;
    private AudioInfoListener mOnAudioInfoListener;
    @Deprecated
    private OnControlMessageListener mOnControlMessageListener;
    private OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    @Deprecated
    private OnNativeInvokeListener mOnNativeInvokeListener;
    private PlayerStateListener mOnPlayerStateListener;
    private SeverListListener mOnSeverListListener;
    private UserDataListener mOnUserDataListener;
    private VideoInfoListener mOnVideoInfoListener;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private String mStreamId;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    /* access modifiers changed from: private */
    public int mVideoHeight;
    /* access modifiers changed from: private */
    public int mVideoSarDen;
    /* access modifiers changed from: private */
    public int mVideoSarNum;
    /* access modifiers changed from: private */
    public int mVideoWidth;
    private PowerManager.WakeLock mWakeLock;
    /* access modifiers changed from: private */
    public PlayerInfo playerInfo;
    private Lock stop_lock;
    private SurfaceHolder.Callback surfaceCallback;
    private String uri;

    public interface AudioInfoListener {
        void onAudioInfo(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4);
    }

    public interface AudioListener {
        void onAudio(IMediaPlayer iMediaPlayer, byte[] bArr);
    }

    public interface AudioPCMCallback {
        int onPCM(PSMediaPlayer pSMediaPlayer, byte[] bArr, int i, int i2, int i3);
    }

    public static class CacheInfo {
        public long cacheDuration;
        public boolean isCache;
        public boolean isFinish;
        public long pos;
    }

    public static class CacheItem {
        public int bid;
        public int duration;
        public int pos;
        public String url;
    }

    private static class DispatchIPInfo {
        public String mDomain = new String();
        public ArrayList<String> mIPList = new ArrayList<>();
        public int mIndex;
        public int type;
    }

    public interface LoginCallback {
        void onError(int i, String str);

        void onSuccess();
    }

    public interface LogoutCallback {
        void onError(int i, String str);

        void onSuccess();
    }

    @Deprecated
    public interface OnControlMessageListener {
        String onControlResolveSegmentUrl(int i);
    }

    private interface OnMediaCodecSelectListener {
        String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2);
    }

    @Deprecated
    public interface OnNativeInvokeListener {
        public static final String ARG_ERROR = "error";
        public static final String ARG_FAMILIY = "family";
        public static final String ARG_FD = "fd";
        public static final String ARG_FILE_SIZE = "file_size";
        public static final String ARG_HTTP_CODE = "http_code";
        public static final String ARG_IP = "ip";
        public static final String ARG_OFFSET = "offset";
        public static final String ARG_PORT = "port";
        public static final String ARG_RETRY_COUNTER = "retry_counter";
        public static final String ARG_SEGMENT_INDEX = "segment_index";
        public static final String ARG_URL = "url";
        public static final int CTRL_DID_TCP_OPEN = 131074;
        public static final int CTRL_WILL_CONCAT_RESOLVE_SEGMENT = 131079;
        public static final int CTRL_WILL_HTTP_OPEN = 131075;
        public static final int CTRL_WILL_LIVE_OPEN = 131077;
        public static final int CTRL_WILL_TCP_OPEN = 131073;
        public static final int EVENT_DID_HTTP_OPEN = 2;
        public static final int EVENT_DID_HTTP_SEEK = 4;
        public static final int EVENT_WILL_HTTP_OPEN = 1;
        public static final int EVENT_WILL_HTTP_SEEK = 3;

        boolean onNativeInvoke(int i, Bundle bundle);
    }

    public interface PlayerStateListener {
        void onPlayerState(IMediaPlayer iMediaPlayer, int i);
    }

    public interface PreloadListener {
        void preloadFail(String str, int i);

        void preloadProgress(String str, int i);

        void preloadSuccess(String str);
    }

    public interface SeverListListener {
        void onServerList(IMediaPlayer iMediaPlayer, String str);
    }

    public interface UserDataListener {
        void onUserData(IMediaPlayer iMediaPlayer, String str);
    }

    public interface VideoInfoListener {
        void onVideoInfo(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4, int i5, int i6, int i7);
    }

    public interface VideoListener {
        void onVideo(IMediaPlayer iMediaPlayer, byte[] bArr);
    }

    /* access modifiers changed from: private */
    public int SwitchServer() throws IllegalStateException {
        return 0;
    }

    private static native void _cleanPSCacheData(String str) throws IllegalStateException;

    private native void _enableAudioPCMCallback(boolean z);

    private native void _enableAutoSpeedPlay(long j, long j2, long j3) throws IllegalArgumentException, IllegalStateException;

    private native void _enableHLSCache();

    private native String _getAudioCodecInfo();

    private static native Object _getCacheInfo(String str, long j);

    private static native String _getColorFormatName(int i);

    private native long _getCurrentPosition();

    private native long _getCurrentSeiTimetamp();

    private native long _getDuration();

    private native int _getLoopCount();

    /* access modifiers changed from: private */
    public native Bundle _getMediaMeta();

    private native boolean _getPreparedWaitBuffer();

    private native float _getPropertyFloat(int i, float f);

    private native long _getPropertyLong(int i, long j);

    private native String _getVideoCodecInfo();

    private static native void _login(String str, String str2, String str3, String str4, String str5) throws IllegalStateException;

    private static native void _logout() throws IllegalStateException;

    private native void _pause() throws IllegalStateException;

    private static native int _pre_dispatch_list(List<PSDispatchData> list);

    private static native void _preloadStart(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3, int i);

    private static native void _preloadStop();

    private native void _prepareAsync() throws IllegalStateException;

    private native void _release();

    private native void _reset();

    private native void _seekTo(long j) throws IllegalStateException;

    private native void _setAndroidIOCallback(IAndroidIO iAndroidIO) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private static native void _setBackupIP(String str, int i, int i2);

    private native void _setContentMode(int i);

    private native void _setDataSource(String str, String[] strArr, String[] strArr2) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSourceFd(int i) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setFrameAtTime(String str, long j, long j2, int i, int i2) throws IllegalArgumentException, IllegalStateException;

    private static native int _setHlsCache(String str, int i);

    private static native void _setHostConfig(String str);

    private native void _setLoopCount(int i);

    private native void _setOption(int i, String str, long j);

    private native void _setOption(int i, String str, String str2);

    private native void _setPropertyFloat(int i, float f);

    private native void _setPropertyLong(int i, long j);

    private native void _setStreamSelected(int i, boolean z);

    /* access modifiers changed from: private */
    public native void _setSurfaceValid(boolean z);

    private static native void _setSysInfo(String str, String str2) throws IllegalStateException;

    private static native void _setUserFolder(String str) throws IllegalStateException;

    private native void _setVideoSurface(Surface surface);

    private native void _setVolume(float f, float f2);

    private static native int _set_user_info(String str, String str2);

    private native void _start() throws IllegalStateException;

    private native void _startPlay(String str, int i, int i2, String str2);

    private native void _startWithVideoPosition(long j, long j2) throws IllegalStateException;

    private native void _stop() throws IllegalStateException;

    private native int getAudioSessionId();

    /* access modifiers changed from: private */
    public native boolean isPlaying();

    private native void native_finalize();

    private static native void native_init();

    private native void native_message_loop(Object obj);

    public static native void native_profileBegin(String str);

    public static native void native_profileEnd();

    private static native void native_setLogLevel(int i);

    private native void native_set_running_state(int i);

    private native void native_setup(Object obj);

    public void changePlayLine(int i) throws IllegalArgumentException, IllegalStateException {
    }

    public void notifyPlayerMessage(String str, String str2) {
    }

    public int tryPlayLive() throws IllegalStateException {
        return 0;
    }

    public int tryPlayVod() throws IllegalStateException {
        return 0;
    }

    private static class BackupIP {
        public ArrayList<DispatchIPInfo> mDiapatchAdds;
        public ArrayList<String> mLogAdds = new ArrayList<>();

        public BackupIP() {
            ArrayList<DispatchIPInfo> arrayList = new ArrayList<>();
            this.mDiapatchAdds = arrayList;
            arrayList.clear();
        }
    }

    public void setVideoInfoListener(VideoInfoListener videoInfoListener) {
        this.mOnVideoInfoListener = videoInfoListener;
    }

    public void setAudioInfoListener(AudioInfoListener audioInfoListener) {
        this.mOnAudioInfoListener = audioInfoListener;
    }

    public void setSeverListListener(SeverListListener severListListener) {
        this.mOnSeverListListener = severListListener;
    }

    public void setPlayerStateListener(PlayerStateListener playerStateListener) {
        this.mOnPlayerStateListener = playerStateListener;
    }

    public void setUserDataListener(UserDataListener userDataListener) {
        this.mOnUserDataListener = userDataListener;
    }

    public void resetListeners() {
        this.mOnVideoInfoListener = null;
        this.mOnAudioInfoListener = null;
        this.mOnSeverListListener = null;
        this.mOnPlayerStateListener = null;
        this.mOnUserDataListener = null;
    }

    /* access modifiers changed from: private */
    public void notifyOnPlayerState(int i) {
        String str = TAG;
        DebugLog.ifmt(str, "notifyOnPlayerState %d", Integer.valueOf(i));
        DebugLog.ifmt(str, "notifyOnPlayerState isPlaying %b", Boolean.valueOf(isPlaying()));
        PlayerStateListener playerStateListener = this.mOnPlayerStateListener;
        if (playerStateListener != null) {
            playerStateListener.onPlayerState(this, i);
        }
    }

    /* access modifiers changed from: private */
    public void notifyOnServerList(String str) {
        DebugLog.ifmt(TAG, "notifyOnServerList %s", str);
        SeverListListener severListListener = this.mOnSeverListListener;
        if (severListListener != null) {
            severListListener.onServerList(this, str);
        }
    }

    /* access modifiers changed from: private */
    public void notifyOnUserData(String str) {
        DebugLog.ifmt(TAG, "notifyOnUserData %s", str);
        UserDataListener userDataListener = this.mOnUserDataListener;
        if (userDataListener != null) {
            userDataListener.onUserData(this, str);
        }
    }

    private void notifyOnAudioInfo(int i, int i2, int i3, int i4) {
        DebugLog.ifmt(TAG, "notifyOnVideoInfo numOfSamples %d, bytesPerSample %d, channels %d, samplesPerSec %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AudioInfoListener audioInfoListener = this.mOnAudioInfoListener;
        if (audioInfoListener != null) {
            audioInfoListener.onAudioInfo(this, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: private */
    public void notifyOnVideoInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        DebugLog.vfmt(TAG, "notifyOnVideoInfo %dx%d, %d - %d, %d°, (%d, %d)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
        VideoInfoListener videoInfoListener = this.mOnVideoInfoListener;
        if (videoInfoListener != null) {
            videoInfoListener.onVideoInfo(this, i, i2, i3, i4, i5, i6, i7);
        }
        PlayerInfo playerInfo2 = this.playerInfo;
        if (playerInfo2 != null) {
            if (i8 != -1) {
                playerInfo2.mVideoWidth = i8;
            }
            if (i9 != -1) {
                this.playerInfo.mVideoHeight = i9;
            }
            if (i10 != -1) {
                this.playerInfo.mVideoSarNum = i10;
            }
            if (i11 != -1) {
                this.playerInfo.mVideoSarDen = i11;
            }
            if (i12 != -1) {
                this.playerInfo.mVideoRotation = i12;
            }
        }
    }

    private void setOnMediaCodecSelectListener(OnMediaCodecSelectListener onMediaCodecSelectListener) {
        this.mOnMediaCodecSelectListener = onMediaCodecSelectListener;
    }

    private static void loadLibrariesOnce(IjkLibLoader ijkLibLoader) {
        synchronized (PSMediaPlayer.class) {
            if (!mIsLibLoaded) {
                if (ijkLibLoader == null) {
                    ijkLibLoader = sLocalLibLoader;
                }
                ijkLibLoader.loadLibrary("psffmpeg");
                ijkLibLoader.loadLibrary("pssdl");
                ijkLibLoader.loadLibrary("psplayer");
                mIsLibLoaded = true;
            }
        }
    }

    private static void initNativeOnce() {
        synchronized (PSMediaPlayer.class) {
            if (!mIsNativeInitialized) {
                enableLog(false);
                native_init();
                mIsNativeInitialized = true;
            }
        }
    }

    public PSMediaPlayer() {
        this(sLocalLibLoader);
    }

    private PSMediaPlayer(IjkLibLoader ijkLibLoader) {
        this.stop_lock = new ReentrantLock();
        this.playerInfo = null;
        this.mWakeLock = null;
        this.mIsLive = false;
        this.mIsStart = false;
        this.surfaceCallback = new SurfaceHolder.Callback() {
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                DebugLog.i(PSMediaPlayer.TAG, "SurfaceHolder.Callback surfaceCreated");
                if (surfaceHolder != null) {
                    surfaceHolder.getSurface();
                }
                try {
                    PSMediaPlayer.this._setSurfaceValid(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                DebugLog.i(PSMediaPlayer.TAG, "SurfaceHolder.Callback surfaceChanged");
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                DebugLog.i(PSMediaPlayer.TAG, "SurfaceHolder.Callback surfaceDestroyed");
                try {
                    PSMediaPlayer.this._setSurfaceValid(false);
                } catch (Exception e) {
                    DebugLog.e(PSMediaPlayer.TAG, "surfaceDestroyed _setVideoSurface", e);
                }
            }
        };
        this.uri = null;
        initPlayer(ijkLibLoader);
    }

    private void initPlayer(IjkLibLoader ijkLibLoader) {
        loadLibrariesOnce(ijkLibLoader);
        initNativeOnce();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new EventHandler(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        this.playerInfo = new PlayerInfo();
        this.mIsStart = false;
        native_setup(new WeakReference(this));
        this.mContentMode = 1;
        _setContentMode(1);
        initDefaultOption();
    }

    private static boolean isSupportGLES2() {
        String str = Build.MODEL;
        if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase("S3 Pro") && !str.equalsIgnoreCase("S3 Prow") && !str.equalsIgnoreCase("S1 PRO") && !str.equalsIgnoreCase("S1A") && !str.equalsIgnoreCase("H20") && !str.equalsIgnoreCase("S1W") && !str.equals("H9A")) {
            return true;
        }
        enableGLES2 = false;
        DebugLog.w(TAG, "This model doesn't support GLES2");
        return true;
    }

    private void initDefaultOption() {
        if (enableGLES2) {
            setOption(4, "overlay-format", 844318047);
        }
        setOption(4, "mediacodec", 1);
        setOption(4, "egl-new", 1);
        setOption(1, "reconnect", 1);
    }

    public synchronized void setDisplay(SurfaceHolder surfaceHolder) {
        DebugLog.ifmt(TAG, "setDisplay %s", surfaceHolder);
        if (this.mSurfaceHolder != surfaceHolder) {
            Surface surface = null;
            if (!(this.mSurface == null || surfaceHolder == null)) {
                setSurface((Surface) null);
            }
            SurfaceHolder surfaceHolder2 = this.mSurfaceHolder;
            if (surfaceHolder2 != null) {
                surfaceHolder2.removeCallback(this.surfaceCallback);
            }
            this.mSurfaceHolder = surfaceHolder;
            if (surfaceHolder != null) {
                surface = surfaceHolder.getSurface();
                surfaceHolder.addCallback(this.surfaceCallback);
            }
            _setVideoSurface(surface);
            if (surface == null || !surface.isValid()) {
                _setSurfaceValid(false);
            } else {
                _setSurfaceValid(true);
            }
            updateSurfaceScreenOn();
        }
    }

    public void setSurface(Surface surface) {
        String str = TAG;
        DebugLog.ifmt(str, "setSurface %s", surface);
        if (this.mScreenOnWhilePlaying && surface != null) {
            DebugLog.w(str, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        if (this.mSurface != surface) {
            if (!(this.mSurfaceHolder == null || surface == null)) {
                setDisplay((SurfaceHolder) null);
            }
            try {
                setOption(4, "support_rtc", 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mSurface = surface;
            _setVideoSurface(surface);
            if (surface == null) {
                _setSurfaceValid(false);
            } else {
                _setSurfaceValid(true);
            }
            updateSurfaceScreenOn();
        }
    }

    public void setContentMode(int i) {
        String str = TAG;
        DebugLog.ifmt(str, "setContentMode " + i, new Object[0]);
        if (i >= 0 && i <= 2) {
            this.mContentMode = i;
            _setContentMode(i);
        }
    }

    private void setDataSource(Context context, Uri uri2) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri2, (Map<String, String>) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007a, code lost:
        if (r0 == null) goto L_0x007f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setDataSource(android.content.Context r6, android.net.Uri r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException {
        /*
            r5 = this;
            java.lang.String r0 = r7.getScheme()
            java.lang.String r1 = "file"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0014
            java.lang.String r6 = r7.getPath()
            r5.setDataSource((java.lang.String) r6)
            return
        L_0x0014:
            java.lang.String r1 = "content"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r7.getAuthority()
            java.lang.String r1 = "settings"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x003b
            int r7 = android.media.RingtoneManager.getDefaultType(r7)
            android.net.Uri r7 = android.media.RingtoneManager.getActualDefaultRingtoneUri(r6, r7)
            if (r7 == 0) goto L_0x0033
            goto L_0x003b
        L_0x0033:
            java.io.FileNotFoundException r6 = new java.io.FileNotFoundException
            java.lang.String r7 = "Failed to resolve default ringtone"
            r6.<init>(r7)
            throw r6
        L_0x003b:
            r0 = 0
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ SecurityException -> 0x0072, IOException -> 0x0067 }
            java.lang.String r1 = "r"
            android.content.res.AssetFileDescriptor r0 = r6.openAssetFileDescriptor(r7, r1)     // Catch:{ SecurityException -> 0x0072, IOException -> 0x0067 }
            if (r0 != 0) goto L_0x004e
            if (r0 == 0) goto L_0x004d
            r0.close()
        L_0x004d:
            return
        L_0x004e:
            long r1 = r0.getDeclaredLength()     // Catch:{ SecurityException -> 0x0072, IOException -> 0x0067 }
            r3 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x005f
            java.io.FileDescriptor r6 = r0.getFileDescriptor()     // Catch:{ SecurityException -> 0x0072, IOException -> 0x0067 }
            r5.setDataSource((java.io.FileDescriptor) r6)     // Catch:{ SecurityException -> 0x0072, IOException -> 0x0067 }
        L_0x005f:
            if (r0 == 0) goto L_0x0064
            r0.close()
        L_0x0064:
            return
        L_0x0065:
            r6 = move-exception
            goto L_0x0087
        L_0x0067:
            r6 = move-exception
            java.lang.String r1 = TAG     // Catch:{ all -> 0x0065 }
            java.lang.String r2 = "IOException"
            tv.danmaku.ijk.media.psplayer.pragma.DebugLog.e(r1, r2, r6)     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x007f
            goto L_0x007c
        L_0x0072:
            r6 = move-exception
            java.lang.String r1 = TAG     // Catch:{ all -> 0x0065 }
            java.lang.String r2 = "SecurityException"
            tv.danmaku.ijk.media.psplayer.pragma.DebugLog.e(r1, r2, r6)     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x007f
        L_0x007c:
            r0.close()
        L_0x007f:
            java.lang.String r6 = r7.toString()
            r5.setDataSource((java.lang.String) r6, (java.util.Map<java.lang.String, java.lang.String>) r8)
            return
        L_0x0087:
            if (r0 == 0) goto L_0x008c
            r0.close()
        L_0x008c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.psplayer.PSMediaPlayer.setDataSource(android.content.Context, android.net.Uri, java.util.Map):void");
    }

    private void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mDataSource = str;
        _setDataSource(str, (String[]) null, (String[]) null);
    }

    private void setDataSource(String str, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next : map.entrySet()) {
                sb.append((String) next.getKey());
                sb.append(":");
                if (!TextUtils.isEmpty((String) next.getValue())) {
                    sb.append((String) next.getValue());
                }
                sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                setOption(1, "headers", sb.toString());
                setOption(1, "protocol_whitelist", "async,cache,crypto,file,http,https,ijkhttphook,ijkinject,ijklivehook,ijklongurl,ijksegment,ijktcphook,pipe,rtp,tcp,tls,udp,ijkurlhook,data");
            }
        }
        setDataSource(str);
    }

    private void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        if (Build.VERSION.SDK_INT < 12) {
            try {
                Field declaredField = fileDescriptor.getClass().getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                _setDataSourceFd(declaredField.getInt(fileDescriptor));
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
            try {
                _setDataSourceFd(dup.getFd());
            } finally {
                dup.close();
            }
        }
    }

    private void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setDataSource(iMediaDataSource);
    }

    private String getProtocol(int i) {
        new String();
        if (i == 1) {
            return "1";
        }
        if (i == 2) {
            return "2";
        }
        if (i == 3) {
            return "3";
        }
        if (i != 5) {
            return i != 6 ? "auto" : "4";
        }
        return "1";
    }

    public int playLive(String str, int i, int i2) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (!is_login) {
            throw new IllegalStateException("Not Login");
        } else if (this.mIsStart) {
            return -1;
        } else {
            this.mStreamId = str;
            setOption(4, "streamid", str);
            setOption(4, "protocol", getProtocol(i));
            setOption(4, "islive", 1);
            setOption(4, "bid", String.valueOf(i2));
            setOption(4, "low-delay", "1");
            this.mIsLive = true;
            if (mContext != null) {
                setOption(4, "logpath", mContext.getFilesDir().getPath().toString());
            }
            this.uri = str;
            _startPlay(str, 1, i2, getProtocol(i));
            notifyOnPlayerState(1);
            return 0;
        }
    }

    @Deprecated
    public int playLive(String str, int i) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        return playLive(str, i, 1000);
    }

    public int playVod(String str, float f, int i, int i2) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (!is_login) {
            throw new IllegalStateException("Not Login");
        } else if (this.mIsStart) {
            return -1;
        } else {
            setOption(4, "streamid", str);
            setOption(4, "protocol", getProtocol(i));
            setOption(4, "islive", 0);
            try {
                if (Build.VERSION.SDK_INT >= 9) {
                    setOption(4, "soundtouch", 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (f > 0.0f) {
                setOption(4, "seek-at-start", (long) (f * 1000.0f));
            }
            setOption(4, "bid", String.valueOf(i2));
            this.mIsLive = false;
            if (mContext != null) {
                setOption(4, "logpath", mContext.getFilesDir().getPath().toString());
            }
            this.uri = str;
            _startPlay(str, 2, i2, getProtocol(i));
            notifyOnPlayerState(1);
            return 0;
        }
    }

    public int playFakeLive(String str, int i, int i2, long j, long j2) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setOption(4, "start-server-time", j);
        setOption(4, "curr-server-time", j2);
        playVod(str, 0.0f, i, i2);
        return 0;
    }

    public int playFakeLive(String str, int i, int i2, long j, long j2, long j3) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setOption(4, "start-server-time", j);
        setOption(4, "curr-server-time", j2);
        setOption(4, "video-position", j3);
        playVod(str, 0.0f, i, i2);
        return 0;
    }

    @Deprecated
    public int playVod(String str, float f, int i) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        return playVod(str, f, i, 1000);
    }

    public int playFile(String str, float f, int i) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (!is_login) {
            throw new IllegalStateException("Not Login");
        } else if (this.mIsStart) {
            return -1;
        } else {
            try {
                if (Build.VERSION.SDK_INT >= 9) {
                    setOption(4, "soundtouch", 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (f > 0.0f) {
                setOption(4, "seek-at-start", (long) (f * 1000.0f));
            }
            setOption(4, "bid", String.valueOf(i));
            this.mIsLive = false;
            this.uri = str;
            _startPlay(str, 3, i, getProtocol(0));
            notifyOnPlayerState(1);
            return 0;
        }
    }

    @Deprecated
    public int playFile(String str, float f) throws IOException, IllegalArgumentException, IllegalStateException {
        return playFile(str, f, 1000);
    }

    private void setAndroidIOCallback(IAndroidIO iAndroidIO) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setAndroidIOCallback(iAndroidIO);
    }

    private String getDataSource() {
        return this.mDataSource;
    }

    public void start() throws IllegalStateException {
        DebugLog.i(TAG, "start");
        if (is_login) {
            stayAwake(true);
            try {
                _start();
            } catch (Exception e) {
                DebugLog.e(TAG, "Exception", e);
            }
            this.mIsStart = true;
            return;
        }
        throw new IllegalStateException("Not Login");
    }

    public void enableHLSCache() {
        _enableHLSCache();
    }

    @Deprecated
    public void start(long j, long j2) throws IllegalStateException {
        DebugLog.i(TAG, "start");
        if (is_login) {
            stayAwake(true);
            try {
                _startWithVideoPosition(j, j2);
            } catch (Exception e) {
                DebugLog.e(TAG, "Exception", e);
            }
            this.mIsStart = true;
            return;
        }
        throw new IllegalStateException("Not Login");
    }

    public void stop() throws IllegalStateException {
        this.stop_lock.lock();
        setDisplay((SurfaceHolder) null);
        stayAwake(false);
        try {
            this.mIsStart = false;
            this.mEventHandler.removeCallbacksAndMessages((Object) null);
            _stop();
            release();
            notifyOnPlayerState(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.stop_lock.unlock();
        return;
    }

    public void pause() throws IllegalStateException {
        stayAwake(false);
        _pause();
    }

    public static void login(String str, String str2, String str3, String str4, LoginCallback loginCallback) throws IllegalStateException, IllegalArgumentException {
        login(str, str2, str3, str4, (String) null, loginCallback);
    }

    public static void login(Context context, String str, String str2, String str3, String str4, String str5, LoginCallback loginCallback) throws IllegalStateException, IllegalArgumentException {
        File file;
        Objects.requireNonNull(context, "Context is null.");
        login(str, "", str3, "", str5, loginCallback);
        mContext = context.getApplicationContext();
        if (is_login) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                file = mContext.getExternalCacheDir();
            } else {
                file = mContext.getCacheDir();
            }
            if (file != null) {
                String str6 = file.getAbsolutePath() + File.separator + "psplayer";
                File file2 = new File(str6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                _setUserFolder(str6);
            }
        }
    }

    public static void login(String str, String str2, String str3, String str4, String str5, LoginCallback loginCallback) throws IllegalStateException, IllegalArgumentException {
        String str6;
        loadLibrariesOnce(sLocalLibLoader);
        initNativeOnce();
        if (login_lock.tryLock()) {
            login_lock.lock();
            try {
                if (is_login && (((str6 = currPSID) == null && str3 != null) || (str6 != null && !str6.equals(str3)))) {
                    logout((LogoutCallback) null);
                }
                if (!is_login) {
                    _setSysInfo(Build.MODEL, Build.VERSION.RELEASE);
                    currAPPID = str;
                    currAppKey = str2;
                    currPSID = str3;
                    currPassword = str4;
                    currUDID = str5;
                    _login(str3, str4, str, str2, str5);
                    if (loginCallback != null) {
                        loginCallback.onSuccess();
                    }
                    is_login = true;
                }
            } catch (Throwable th) {
                login_lock.unlock();
                throw th;
            }
            login_lock.unlock();
        }
    }

    public static void logout(LogoutCallback logoutCallback) throws IllegalStateException {
        login_lock.lock();
        try {
            if (is_login) {
                _logout();
                currAPPID = null;
                currAppKey = null;
                currPSID = null;
                currPassword = null;
                currUserId = null;
                is_login = false;
                if (logoutCallback != null) {
                    logoutCallback.onSuccess();
                }
            }
        } catch (Throwable th) {
            login_lock.unlock();
            throw th;
        }
        login_lock.unlock();
    }

    @Deprecated
    public void setWakeMode(Context context, int i) {
        boolean z;
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                z = true;
                this.mWakeLock.release();
            } else {
                z = false;
            }
            this.mWakeLock = null;
        } else {
            z = false;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i | 536870912, PSMediaPlayer.class.getName());
        this.mWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        if (z) {
            this.mWakeLock.acquire();
        }
    }

    @Deprecated
    public void setScreenOnWhilePlaying(boolean z) {
        if (this.mScreenOnWhilePlaying != z) {
            if (z && this.mSurfaceHolder == null) {
                DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z;
            updateSurfaceScreenOn();
        }
    }

    /* access modifiers changed from: private */
    public void stayAwake(boolean z) {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
        updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
        }
    }

    public IjkTrackInfo[] getTrackInfo() {
        IjkMediaMeta parse;
        Bundle mediaMeta = getMediaMeta();
        if (mediaMeta == null || (parse = IjkMediaMeta.parse(mediaMeta)) == null || parse.mStreams == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<IjkMediaMeta.IjkStreamMeta> it = parse.mStreams.iterator();
        while (it.hasNext()) {
            IjkMediaMeta.IjkStreamMeta next = it.next();
            IjkTrackInfo ijkTrackInfo = new IjkTrackInfo(next);
            if (next.mType.equalsIgnoreCase("video")) {
                ijkTrackInfo.setTrackType(1);
            } else if (next.mType.equalsIgnoreCase("audio")) {
                ijkTrackInfo.setTrackType(2);
            } else if (next.mType.equalsIgnoreCase("timedtext")) {
                ijkTrackInfo.setTrackType(3);
            }
            arrayList.add(ijkTrackInfo);
        }
        return (IjkTrackInfo[]) arrayList.toArray(new IjkTrackInfo[arrayList.size()]);
    }

    private int getSelectedTrack(int i) {
        long _getPropertyLong;
        if (i == 1) {
            _getPropertyLong = _getPropertyLong(20001, -1);
        } else if (i == 2) {
            _getPropertyLong = _getPropertyLong(FFP_PROP_INT64_SELECTED_AUDIO_STREAM, -1);
        } else if (i != 3) {
            return -1;
        } else {
            _getPropertyLong = _getPropertyLong(FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM, -1);
        }
        return (int) _getPropertyLong;
    }

    private void selectTrack(int i) {
        _setStreamSelected(i, true);
    }

    private void deselectTrack(int i) {
        _setStreamSelected(i, false);
    }

    private int getVideoWidth() {
        return this.mVideoWidth;
    }

    private int getVideoHeight() {
        return this.mVideoHeight;
    }

    private int getVideoSarNum() {
        return this.mVideoSarNum;
    }

    private int getVideoSarDen() {
        return this.mVideoSarDen;
    }

    public void seekTo(long j) throws IllegalStateException {
        _seekTo(j);
    }

    public long getCurrentPosition() {
        return _getCurrentPosition();
    }

    public long getCurrentSeiTimetamp() {
        return _getCurrentSeiTimetamp();
    }

    public long getDuration() {
        return _getDuration();
    }

    private void release() {
        stayAwake(false);
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.surfaceCallback);
        }
        updateSurfaceScreenOn();
        resetListeners();
        _release();
    }

    private void reset() {
        stayAwake(false);
        _reset();
        this.mEventHandler.removeCallbacksAndMessages((Object) null);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    public void setSpeed(float f) {
        if (f > 0.0f && f < 100.0f) {
            _setPropertyFloat(10003, f);
        }
    }

    private float getSpeed(float f) {
        return _getPropertyFloat(10003, 0.0f);
    }

    private int getVideoDecoder() {
        return (int) _getPropertyLong(FFP_PROP_INT64_VIDEO_DECODER, 0);
    }

    private float getVideoOutputFramesPerSecond() {
        return _getPropertyFloat(10002, 0.0f);
    }

    private float getVideoDecodeFramesPerSecond() {
        return _getPropertyFloat(10001, 0.0f);
    }

    private long getVideoCachedDuration() {
        return _getPropertyLong(FFP_PROP_INT64_VIDEO_CACHED_DURATION, 0);
    }

    private long getAudioCachedDuration() {
        return _getPropertyLong(FFP_PROP_INT64_AUDIO_CACHED_DURATION, 0);
    }

    private long getVideoCachedBytes() {
        return _getPropertyLong(FFP_PROP_INT64_VIDEO_CACHED_BYTES, 0);
    }

    private long getAudioCachedBytes() {
        return _getPropertyLong(FFP_PROP_INT64_AUDIO_CACHED_BYTES, 0);
    }

    private long getVideoCachedPackets() {
        return _getPropertyLong(FFP_PROP_INT64_VIDEO_CACHED_PACKETS, 0);
    }

    private long getAudioCachedPackets() {
        return _getPropertyLong(FFP_PROP_INT64_AUDIO_CACHED_PACKETS, 0);
    }

    private long getAsyncStatisticBufBackwards() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS, 0);
    }

    private long getAsyncStatisticBufForwards() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS, 0);
    }

    private long getAsyncStatisticBufCapacity() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY, 0);
    }

    private long getTrafficStatisticByteCount() {
        return _getPropertyLong(FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT, 0);
    }

    private long getCacheStatisticPhysicalPos() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_PHYSICAL_POS, 0);
    }

    private long getCacheStatisticFileForwards() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_FILE_FORWARDS, 0);
    }

    private long getCacheStatisticFilePos() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_FILE_POS, 0);
    }

    private long getCacheStatisticCountBytes() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_COUNT_BYTES, 0);
    }

    private long getFileSize() {
        return _getPropertyLong(FFP_PROP_INT64_LOGICAL_FILE_SIZE, 0);
    }

    private long getBitRate() {
        return _getPropertyLong(FFP_PROP_INT64_BIT_RATE, 0);
    }

    private long getTcpSpeed() {
        return _getPropertyLong(FFP_PROP_INT64_TCP_SPEED, 0);
    }

    private long getSeekLoadDuration() {
        return _getPropertyLong(FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION, 0);
    }

    public static void setUserInfo(String str, String str2) {
        String str3;
        if (is_login) {
            if (TextUtils.isEmpty(currPSID) && (((str3 = currUserId) == null && str2 != null) || (str3 != null && !str3.equals(str2)))) {
                Context context = mContext;
                String str4 = currAPPID;
                String str5 = currAppKey;
                String str6 = currPSID;
                String str7 = currPassword;
                String str8 = currUDID;
                logout((LogoutCallback) null);
                login(context, str4, str5, str6, str7, str8, (LoginCallback) null);
            }
            currUserName = str;
            currUserId = str2;
            _set_user_info(str, str2);
        }
    }

    public static int preDispatchList(List<PSDispatchData> list) {
        return _pre_dispatch_list(list);
    }

    public ErrorInfo getErrorInfo() {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.mErrorCode = mLastErrno;
        errorInfo.mErrorMsg = mLastErrMsg;
        if (mLastErrno == -100) {
            errorInfo.mPlayerErrorCode = mLastErrCode;
        } else {
            errorInfo.mPlayerErrorCode = 0;
        }
        return errorInfo;
    }

    private float getDropFrameRate() {
        return _getPropertyFloat(10007, 0.0f);
    }

    public void setVolume(float f, float f2) {
        _setVolume(f, f2);
    }

    public PlayerInfo getPlayerInfo() {
        this.stop_lock.lock();
        try {
            this.playerInfo.mMeta = IjkMediaMeta.parse(_getMediaMeta());
            this.playerInfo.mAudioCacheDuration = getAudioCachedDuration();
            this.playerInfo.mVideoCacheDuration = getVideoCachedDuration();
            DebugLog.dfmt(TAG, "getPlayerInfo mVideoCacheDuration %d", Long.valueOf(this.playerInfo.mVideoCacheDuration));
            this.playerInfo.mDecoderfps = getVideoDecodeFramesPerSecond();
            this.playerInfo.mRenderfps = getVideoOutputFramesPerSecond();
            this.playerInfo.mTcpSpeed = getTcpSpeed();
            this.playerInfo.mSeekLoadDuration = getSeekLoadDuration();
            this.playerInfo.mCurrentPosition = getCurrentPosition();
            this.playerInfo.mIsPlaying = isPlaying();
            this.playerInfo.mVideoDecodePts = _getPropertyLong(FFP_PROP_INT64_DECODER_FRAME_PTS, 0);
        } catch (Throwable th) {
            this.stop_lock.unlock();
            throw th;
        }
        this.stop_lock.unlock();
        return this.playerInfo;
    }

    public void enableAutoSpeedPlay(long j, long j2, long j3) throws IllegalArgumentException, IllegalStateException {
        if (!is_login) {
            throw new IllegalStateException("Not Login");
        } else if (j3 == 0) {
            _enableAutoSpeedPlay(j, j2, 10000);
        } else {
            _enableAutoSpeedPlay(j, j2, j3);
        }
    }

    public void setOption(int i, String str, String str2) {
        try {
            _setOption(i, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOption(int i, String str, long j) {
        try {
            _setOption(i, str, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bundle getMediaMeta() {
        return _getMediaMeta();
    }

    private static String getColorFormatName(int i) {
        return _getColorFormatName(i);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        String str = TAG;
        Log.d(str, "finalize " + toString());
        native_finalize();
    }

    @Deprecated
    public void httphookReconnect() {
        _setPropertyLong(FFP_PROP_INT64_IMMEDIATE_RECONNECT, 1);
    }

    private void setCacheShare(int i) {
        _setPropertyLong(FFP_PROP_INT64_SHARE_CACHE_DATA, (long) i);
    }

    /* access modifiers changed from: private */
    public void updateBufferingPercent(long j) {
        this.playerInfo.mBufferingPercent = j;
    }

    private static class EventHandler extends Handler {
        private final WeakReference<PSMediaPlayer> mWeakPlayer;

        public EventHandler(PSMediaPlayer pSMediaPlayer, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(pSMediaPlayer);
        }

        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            PSMediaPlayer pSMediaPlayer = (PSMediaPlayer) this.mWeakPlayer.get();
            if (pSMediaPlayer != null) {
                long j = 0;
                if (pSMediaPlayer.mNativeMediaPlayer != 0) {
                    DebugLog.ifmt(PSMediaPlayer.TAG, "PSMediaPlayer handleMessage %d : %d", Integer.valueOf(message.what), Integer.valueOf(message.arg1));
                    int i = message.what;
                    if (i != 0) {
                        if (i == 1) {
                            pSMediaPlayer.playerInfo.mMeta = IjkMediaMeta.parse(pSMediaPlayer._getMediaMeta());
                            pSMediaPlayer.notifyOnPlayerState(2);
                            AsynchronousInstrumentation.handlerMessageEnd();
                            return;
                        } else if (i == 2) {
                            pSMediaPlayer.stayAwake(false);
                            DebugLog.ifmt(PSMediaPlayer.TAG, "PSMediaPlayer handleMessage MEDIA_PLAYBACK_COMPLETE %d / %d ", Long.valueOf(pSMediaPlayer.getCurrentPosition()), Long.valueOf(pSMediaPlayer.getDuration()));
                            if (pSMediaPlayer.getCurrentPosition() + 5000 < pSMediaPlayer.getDuration()) {
                                pSMediaPlayer.notifyOnPlayerState(-1);
                            } else {
                                pSMediaPlayer.notifyOnPlayerState(5);
                            }
                            AsynchronousInstrumentation.handlerMessageEnd();
                            return;
                        } else if (i == 3) {
                            long j2 = (long) message.arg1;
                            if (j2 < 0) {
                                j2 = 0;
                            }
                            long duration = pSMediaPlayer.getDuration();
                            long j3 = 100;
                            if (duration > 0) {
                                j = (j2 * 100) / duration;
                            }
                            if (j < 100) {
                                j3 = j;
                            }
                            pSMediaPlayer.updateBufferingPercent(j3);
                            AsynchronousInstrumentation.handlerMessageEnd();
                            return;
                        } else if (i == 4) {
                            AsynchronousInstrumentation.handlerMessageEnd();
                            return;
                        } else if (i == 5) {
                            int unused = pSMediaPlayer.mVideoWidth = message.arg1;
                            int unused2 = pSMediaPlayer.mVideoHeight = message.arg2;
                            pSMediaPlayer.notifyOnVideoInfo(pSMediaPlayer.mVideoWidth, pSMediaPlayer.mVideoHeight, -1, -1, -1, -1, -1);
                            AsynchronousInstrumentation.handlerMessageEnd();
                            return;
                        } else if (i == PSMediaPlayer.MEDIA_TIMED_TEXT) {
                            AsynchronousInstrumentation.handlerMessageEnd();
                            return;
                        } else if (i == 100) {
                            DebugLog.e(PSMediaPlayer.TAG, "Error (" + message.arg1 + "," + message.arg2 + ")");
                            if (message.arg1 == PSMediaPlayer.MEDIA_ERROR_Dispatch) {
                                if (message.arg2 == 16) {
                                    pSMediaPlayer.notifyOnPlayerState(7);
                                    AsynchronousInstrumentation.handlerMessageEnd();
                                    return;
                                }
                                int unused3 = PSMediaPlayer.mLastErrno = PSMediaPlayer.mLastErrCode = IMediaPlayer.PSDispatchFailed;
                                String unused4 = PSMediaPlayer.mLastErrMsg = "Dispatch failed";
                            } else if (message.arg1 == PSMediaPlayer.MEDIA_ERROR_Dispatch_FAILED_NET) {
                                int unused5 = PSMediaPlayer.mLastErrno = PSMediaPlayer.mLastErrCode = IMediaPlayer.PSDispatchServerConnFailed;
                                String unused6 = PSMediaPlayer.mLastErrMsg = "Can't connect dispatch server";
                            } else if (message.arg1 == PSMediaPlayer.MEDIA_ERROR_Dispatch_FAILED_SERVER) {
                                if (message.arg2 == 15) {
                                    int unused7 = PSMediaPlayer.mLastErrno = PSMediaPlayer.mLastErrCode = IMediaPlayer.PSDispatchServerConnFailed;
                                    String unused8 = PSMediaPlayer.mLastErrMsg = "Connect dispatch server time out";
                                } else if (message.arg2 == 18 || message.arg2 == 20) {
                                    int unused9 = PSMediaPlayer.mLastErrno = PSMediaPlayer.mLastErrCode = -105;
                                    String unused10 = PSMediaPlayer.mLastErrMsg = "Dispatch with no valid play line";
                                } else if (message.arg2 == 17) {
                                    int unused11 = PSMediaPlayer.mLastErrno = PSMediaPlayer.mLastErrCode = IMediaPlayer.PSDispatchServerError;
                                    String unused12 = PSMediaPlayer.mLastErrMsg = "Dispatch Server Error";
                                } else {
                                    int unused13 = PSMediaPlayer.mLastErrno = PSMediaPlayer.mLastErrCode = IMediaPlayer.PSDispatchFailed;
                                    String unused14 = PSMediaPlayer.mLastErrMsg = "Dispatch failed";
                                }
                            } else if (message.arg1 == PSMediaPlayer.MEDIA_ERROR_IJK_PLAYER) {
                                int unused15 = PSMediaPlayer.mLastErrno = -100;
                                int unused16 = PSMediaPlayer.mLastErrCode = message.arg2;
                                String unused17 = PSMediaPlayer.mLastErrMsg = "Player error";
                            } else if (message.arg1 == PSMediaPlayer.MEDIA_ERROR_SYNC) {
                                int unused18 = PSMediaPlayer.mLastErrno = PSMediaPlayer.MEDIA_ERROR_SYNC;
                                if (message.arg2 == 1) {
                                    int unused19 = PSMediaPlayer.mLastErrCode = message.arg2;
                                    String unused20 = PSMediaPlayer.mLastErrMsg = "Already Finish";
                                } else if (message.arg2 == 2) {
                                    int unused21 = PSMediaPlayer.mLastErrCode = message.arg2;
                                    String unused22 = PSMediaPlayer.mLastErrMsg = "Not Start";
                                } else {
                                    int unused23 = PSMediaPlayer.mLastErrCode = message.arg2;
                                    String unused24 = PSMediaPlayer.mLastErrMsg = "Time Error";
                                }
                            }
                            pSMediaPlayer.notifyOnPlayerState(-1);
                            pSMediaPlayer.stayAwake(false);
                            AsynchronousInstrumentation.handlerMessageEnd();
                            return;
                        } else if (i == PSMediaPlayer.MEDIA_RTC) {
                            AsynchronousInstrumentation.handlerMessageEnd();
                            return;
                        } else if (i == 200) {
                            int i2 = message.arg1;
                            if (i2 == 3) {
                                DebugLog.i(PSMediaPlayer.TAG, "MEDIA_INFO_VIDEO_RENDERING_START");
                            } else if (i2 == 10001) {
                                pSMediaPlayer.notifyOnVideoInfo(-1, -1, -1, -1, message.arg2, -1, -1);
                            } else if (i2 == 400) {
                                int unused25 = PSMediaPlayer.mLastErrno = -100;
                                String unused26 = PSMediaPlayer.mLastErrMsg = "TRY ALL SERVER";
                                DebugLog.w(PSMediaPlayer.TAG, "MEDIA_INFO_TRY_ALL_SERVER");
                                pSMediaPlayer.notifyOnPlayerState(-1);
                            } else if (i2 == 401) {
                                try {
                                    if (pSMediaPlayer.SwitchServer() == 0) {
                                        pSMediaPlayer.notifyOnPlayerState(6);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else if (i2 == PSMediaPlayer.MEDIA_INFO_BUFFERING_START) {
                                pSMediaPlayer.notifyOnPlayerState(4);
                            } else if (i2 != PSMediaPlayer.MEDIA_INFO_BUFFERING_END) {
                                if (i2 != PSMediaPlayer.MEDIA_INFO_DECODE_STUCK_START) {
                                    if (i2 == PSMediaPlayer.MEDIA_INFO_DECODE_STUCK_END && pSMediaPlayer.mDecodeStuckListener != null) {
                                        pSMediaPlayer.mDecodeStuckListener.onDecodeStuckEnd(pSMediaPlayer);
                                    }
                                } else if (pSMediaPlayer.mDecodeStuckListener != null) {
                                    pSMediaPlayer.mDecodeStuckListener.onDecodeStuckStart(pSMediaPlayer);
                                }
                            } else if (pSMediaPlayer.isPlaying()) {
                                pSMediaPlayer.notifyOnPlayerState(2);
                            } else {
                                pSMediaPlayer.notifyOnPlayerState(3);
                            }
                            AsynchronousInstrumentation.handlerMessageEnd();
                            return;
                        } else if (i == 300) {
                            if (message.obj == null) {
                                pSMediaPlayer.notifyOnUserData((String) null);
                            } else {
                                pSMediaPlayer.notifyOnUserData((String) message.obj);
                            }
                            AsynchronousInstrumentation.handlerMessageEnd();
                            return;
                        } else if (i == PSMediaPlayer.MEDIA_INFO_SERVERLIST_UPDATE) {
                            if (message.obj == null) {
                                pSMediaPlayer.notifyOnServerList((String) null);
                                DebugLog.e(PSMediaPlayer.TAG, "serverlist is null");
                            } else {
                                pSMediaPlayer.notifyOnServerList((String) message.obj);
                            }
                            AsynchronousInstrumentation.handlerMessageEnd();
                            return;
                        } else if (i == 700) {
                            int i3 = message.arg1;
                            if (i3 == 5) {
                                pSMediaPlayer.notifyOnPlayerState(3);
                            } else if (i3 == 4) {
                                pSMediaPlayer.notifyOnPlayerState(2);
                            }
                        } else if (i != 10001) {
                            DebugLog.efmt(PSMediaPlayer.TAG, "Unknown message type %d", Integer.valueOf(message.what));
                        } else {
                            int unused27 = pSMediaPlayer.mVideoSarNum = message.arg1;
                            int unused28 = pSMediaPlayer.mVideoSarDen = message.arg2;
                            pSMediaPlayer.notifyOnVideoInfo(-1, -1, pSMediaPlayer.mVideoSarNum, pSMediaPlayer.mVideoSarDen, -1, -1, -1);
                        }
                    }
                    AsynchronousInstrumentation.handlerMessageEnd();
                    return;
                }
            }
            DebugLog.e(PSMediaPlayer.TAG, "PSMediaPlayer went away with unhandled events");
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        WeakReference weakReference;
        PSMediaPlayer pSMediaPlayer;
        if (obj != null && (weakReference = (WeakReference) obj) != null && (pSMediaPlayer = (PSMediaPlayer) weakReference.get()) != null) {
            if (i == 200 && i2 == 2) {
                pSMediaPlayer.start();
            }
            EventHandler eventHandler = pSMediaPlayer.mEventHandler;
            if (eventHandler != null) {
                pSMediaPlayer.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, i3, obj2));
            }
        }
    }

    @Deprecated
    public void setOnControlMessageListener(OnControlMessageListener onControlMessageListener) {
        this.mOnControlMessageListener = onControlMessageListener;
    }

    @Deprecated
    public void setOnNativeInvokeListener(OnNativeInvokeListener onNativeInvokeListener) {
        this.mOnNativeInvokeListener = onNativeInvokeListener;
    }

    private static boolean onNativeInvoke(Object obj, int i, Bundle bundle) {
        OnControlMessageListener onControlMessageListener;
        DebugLog.ifmt(TAG, "onNativeInvoke %d", Integer.valueOf(i));
        if (obj == null || !(obj instanceof WeakReference)) {
            throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
        }
        PSMediaPlayer pSMediaPlayer = (PSMediaPlayer) ((WeakReference) obj).get();
        if (pSMediaPlayer != null) {
            OnNativeInvokeListener onNativeInvokeListener = pSMediaPlayer.mOnNativeInvokeListener;
            if (onNativeInvokeListener != null && onNativeInvokeListener.onNativeInvoke(i, bundle)) {
                return true;
            }
            if (i != 131079 || (onControlMessageListener = pSMediaPlayer.mOnControlMessageListener) == null) {
                return false;
            }
            int i2 = bundle.getInt(OnNativeInvokeListener.ARG_SEGMENT_INDEX, -1);
            if (i2 >= 0) {
                String onControlResolveSegmentUrl = onControlMessageListener.onControlResolveSegmentUrl(i2);
                if (onControlResolveSegmentUrl != null) {
                    bundle.putString(OnNativeInvokeListener.ARG_URL, onControlResolveSegmentUrl);
                    return true;
                }
                throw new RuntimeException(new IOException("onNativeInvoke() = <NULL newUrl>"));
            }
            throw new InvalidParameterException("onNativeInvoke(invalid segment index)");
        }
        throw new IllegalStateException("<null weakPlayer>.onNativeInvoke()");
    }

    private static String onSelectCodec(Object obj, String str, int i, int i2) {
        PSMediaPlayer pSMediaPlayer;
        if (obj == null || !(obj instanceof WeakReference) || (pSMediaPlayer = (PSMediaPlayer) ((WeakReference) obj).get()) == null) {
            return null;
        }
        OnMediaCodecSelectListener onMediaCodecSelectListener = pSMediaPlayer.mOnMediaCodecSelectListener;
        if (onMediaCodecSelectListener == null) {
            onMediaCodecSelectListener = DefaultMediaCodecSelector.sInstance;
        }
        return onMediaCodecSelectListener.onMediaCodecSelect(pSMediaPlayer, str, i, i2);
    }

    private static class DefaultMediaCodecSelector implements OnMediaCodecSelectListener {
        public static final DefaultMediaCodecSelector sInstance = new DefaultMediaCodecSelector();

        private DefaultMediaCodecSelector() {
        }

        public String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2) {
            String str2 = null;
            if (Build.VERSION.SDK_INT < 16) {
                return null;
            }
            if (TextUtils.isEmpty(str)) {
                DebugLog.e(PSMediaPlayer.TAG, "mimiType is empty!");
                return null;
            }
            DebugLog.ifmt(PSMediaPlayer.TAG, "onMediaCodecSelect onSelectCodec: mime=%s, profile=%d, level=%d", str, Integer.valueOf(i), Integer.valueOf(i2));
            if (Build.VERSION.SDK_INT >= 21) {
                str2 = HardwareCodecUtils.getSupportHardwareDecodeName(str, (String) null, i, i2);
            }
            DebugLog.ifmt(PSMediaPlayer.TAG, "onMediaCodecSelect selected codec: %s rank=%d", str2, 0);
            return str2;
        }
    }

    public void setOnDecodeStuckListener(OnDecodeStuckListener onDecodeStuckListener) {
        this.mDecodeStuckListener = onDecodeStuckListener;
    }

    public static void enableLog(boolean z) {
        if (!z) {
            DebugLog.setLevel(5);
            native_setLogLevel(5);
            return;
        }
        DebugLog.setLevel(2);
        native_setLogLevel(1);
    }

    public static void setHttpDnsCallback(HttpDnsCallback httpDnsCallback2) {
        httpDnsCallback = httpDnsCallback2;
    }

    private static String[] getIpsByHost(String str) {
        String str2 = TAG;
        DebugLog.vfmt(str2, "HTTPDNS getIpsByHost %s", str);
        HttpDnsCallback httpDnsCallback2 = httpDnsCallback;
        if (httpDnsCallback2 == null) {
            return null;
        }
        List<String> lookup = httpDnsCallback2.lookup(str);
        DebugLog.vfmt(str2, "HTTPDNS getIpsByHost %s", lookup);
        if (lookup == null) {
            return null;
        }
        String[] strArr = new String[lookup.size()];
        lookup.toArray(strArr);
        return strArr;
    }

    public void setLongConnectionInfo(String str, String[] strArr) {
        _setOption(4, "nickname", str);
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                stringBuffer.append(strArr[i]);
                if (i != strArr.length - 1) {
                    stringBuffer.append(",");
                }
            }
        }
        _setOption(4, "roomId", stringBuffer.toString());
    }

    public void setRunningState(int i) {
        native_set_running_state(i);
    }

    public static void setHostConfig(String str) {
        loadLibrariesOnce(sLocalLibLoader);
        initNativeOnce();
        _setHostConfig(str);
    }

    public void addAudioPCMCallback(AudioPCMCallback audioPCMCallback) {
        this.audioPCMleCallback = audioPCMCallback;
        if (audioPCMCallback == null) {
            _enableAudioPCMCallback(false);
        } else {
            _enableAudioPCMCallback(true);
        }
    }

    private static int postPCMFromNative(Object obj, byte[] bArr, int i, int i2, int i3) {
        AudioPCMCallback audioPCMCallback;
        String str = TAG;
        DebugLog.v(str, "postPCMFromNative length: " + bArr.length + ", rate: " + i + ", channels: " + i2 + ", format: " + i3);
        PSMediaPlayer pSMediaPlayer = (PSMediaPlayer) ((WeakReference) obj).get();
        if (pSMediaPlayer == null || (audioPCMCallback = pSMediaPlayer.audioPCMleCallback) == null) {
            return 0;
        }
        return audioPCMCallback.onPCM(pSMediaPlayer, bArr, i, i2, i3);
    }

    public long getNativeMediaPlayer() {
        return this.mNativeMediaPlayer;
    }

    public static int setCacheConfig(String str, int i) {
        if (!is_login) {
            return -1;
        }
        return _setHlsCache(str, i);
    }

    public static void cleanCacheData(String str) {
        if (is_login && !TextUtils.isEmpty(str)) {
            _cleanPSCacheData(str);
        }
    }

    public static void preloadStart(CacheItem[] cacheItemArr, int i) {
        if (is_login && cacheItemArr != null && cacheItemArr.length != 0) {
            String[] strArr = new String[cacheItemArr.length];
            int[] iArr = new int[cacheItemArr.length];
            int[] iArr2 = new int[cacheItemArr.length];
            int[] iArr3 = new int[cacheItemArr.length];
            for (int i2 = 0; i2 < cacheItemArr.length; i2++) {
                strArr[i2] = cacheItemArr[i2].url;
                iArr[i2] = cacheItemArr[i2].bid;
                iArr2[i2] = cacheItemArr[i2].pos;
                iArr3[i2] = cacheItemArr[i2].duration;
            }
            _preloadStart(strArr, iArr, iArr2, iArr3, i);
        }
    }

    public static void preloadStart(CacheItem cacheItem, int i) {
        preloadStart(new CacheItem[]{cacheItem}, i);
    }

    public static void preloadStop() {
        if (is_login) {
            _preloadStop();
        }
    }

    public static CacheInfo getCacheInfo(String str, long j) {
        if (is_login && !TextUtils.isEmpty(str)) {
            return (CacheInfo) _getCacheInfo(str, j);
        }
        return null;
    }

    public static void setPreloadListener(PreloadListener preloadListener) {
        mPreloadListener = preloadListener;
    }

    private static void notifyPreloadEvent(String str, int i, int i2) {
        PreloadListener preloadListener = mPreloadListener;
        if (preloadListener != null) {
            if (i == 0) {
                preloadListener.preloadSuccess(str);
            } else if (i == 1) {
                preloadListener.preloadFail(str, i2);
            } else if (i != 3) {
                String str2 = TAG;
                DebugLog.w(str2, "Preload unknown " + i);
            } else {
                preloadListener.preloadProgress(str, i2);
            }
        }
    }

    public long getCachedPosition() {
        long currentPosition = getCurrentPosition() + getPlayerInfo().mVideoCacheDuration;
        CacheInfo cacheInfo = getCacheInfo(this.uri, currentPosition);
        return cacheInfo != null ? currentPosition + cacheInfo.cacheDuration : currentPosition;
    }
}
