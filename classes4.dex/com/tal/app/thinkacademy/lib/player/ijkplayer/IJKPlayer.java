package com.tal.app.thinkacademy.lib.player.ijkplayer;

import android.content.Context;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.player.Tag;
import com.tal.app.thinkacademy.lib.player.ijkplayer.config.MediaPlayer;
import com.tal.app.thinkacademy.lib.player.ijkplayer.entity.PsIjkParameter;
import com.tal.app.thinkacademy.lib.player.track.IjkTrackUtil;
import com.tal.app.thinkacademy.lib.player.track.VideoActionType;
import com.tal.app.thinkacademy.lib.player.track.VideoPlayFailType;
import com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType;
import com.tal.app.thinkacademy.lib.player.utils.AssetsFileUtils;
import com.tal.app.thinkacademy.lib.util.DeviceUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.PathUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.psplayer.ErrorInfo;
import tv.danmaku.ijk.media.psplayer.IMediaPlayer;
import tv.danmaku.ijk.media.psplayer.PSMediaPlayer;
import tv.danmaku.ijk.media.psplayer.PlayerInfo;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B9\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\b\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020GH\u0016J\u0010\u0010I\u001a\u00020G2\b\u0010J\u001a\u0004\u0018\u00010KJ\u0006\u0010L\u001a\u00020GJ\r\u0010M\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010NJ\r\u0010O\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010NJ\r\u0010P\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010NJ\u0006\u0010Q\u001a\u00020\u0013J\r\u0010R\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010NJ\u0006\u0010S\u001a\u00020\u0013J\b\u0010T\u001a\u0004\u0018\u00010\u0018J\u0006\u0010U\u001a\u00020VJ\b\u0010W\u001a\u0004\u0018\u00010XJ\u001a\u0010Y\u001a\u00020G2\b\u0010Z\u001a\u0004\u0018\u00010\u00052\u0006\u0010[\u001a\u00020\u0013H\u0002J\u0006\u0010\\\u001a\u000202J\u0006\u0010]\u001a\u000202J\r\u0010^\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010NJ\u0006\u0010_\u001a\u00020\u0016J\u0006\u0010`\u001a\u00020\u0016J\u000e\u0010a\u001a\u00020\u00112\u0006\u0010b\u001a\u00020\"J\u0006\u0010\f\u001a\u00020\u0011J\b\u0010c\u001a\u00020\u0011H\u0016J\b\u0010d\u001a\u00020\u0011H\u0016J\b\u0010e\u001a\u00020\u0011H\u0016J\u0006\u0010f\u001a\u00020\u0011J\u0010\u0010g\u001a\u00020G2\u0006\u0010h\u001a\u00020\u0016H\u0002J\b\u0010i\u001a\u00020GH\u0016J0\u0010j\u001a\u00020G2\b\u0010k\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010[\u001a\u0002022\b\b\u0002\u0010l\u001a\u00020\u00162\b\u0010m\u001a\u0004\u0018\u00010,H\u0007J(\u0010n\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u00052\u0006\u0010o\u001a\u00020\u00162\u0006\u0010l\u001a\u00020\u00162\b\b\u0002\u0010[\u001a\u000202J\b\u0010p\u001a\u00020GH\u0002J\u0006\u0010q\u001a\u00020GJ\u0018\u0010r\u001a\u00020G2\u0006\u0010s\u001a\u00020\u00132\u0006\u0010t\u001a\u00020\u0011H\u0016J\u0006\u0010u\u001a\u00020GJ\u0010\u0010v\u001a\u00020G2\b\b\u0002\u0010w\u001a\u00020\u0013J\u000e\u0010x\u001a\u00020G2\u0006\u0010y\u001a\u00020\u0016J\u000e\u0010z\u001a\u00020G2\u0006\u0010{\u001a\u00020\u0011J\b\u0010|\u001a\u00020GH\u0002J\b\u0010}\u001a\u00020GH\u0002J\u0010\u0010~\u001a\u00020G2\u0006\u0010\u001a\u000202H\u0016J\u000f\u0010\u0001\u001a\u00020G2\u0006\u0010h\u001a\u00020\u0016J\u0011\u0010\u0001\u001a\u00020G2\b\u0010\u0001\u001a\u00030\u0001J\u0010\u0010\u0001\u001a\u00020G2\u0007\u0010\u0001\u001a\u000208J\u0019\u0010\u0001\u001a\u00020G2\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0005J\u0012\u0010\u0001\u001a\u00020G2\u0007\u0010\u0001\u001a\u000202H\u0016J\u001b\u0010\u0001\u001a\u00020G2\u0007\u0010\u0001\u001a\u0002022\u0007\u0010\u0001\u001a\u000202H\u0016J\t\u0010\u0001\u001a\u00020GH\u0002J\t\u0010\u0001\u001a\u00020GH\u0016J\u0007\u0010\u0001\u001a\u00020GJ\t\u0010\u0001\u001a\u00020GH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u00105R\u0012\u00106\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u00105R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010C\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bD\u0010E¨\u0006\u0001"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IJKPlayer;", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IIJKMediaPlayer;", "context", "Landroid/content/Context;", "appID", "", "applicationKey", "psId", "password", "schoolCode", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/content/Context;)V", "isBuffering", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCreate", "isPreparing", "isStoping", "", "mBufferingStartTime", "", "mContext", "mCurrentState", "", "mIjkPlayerInfo", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IjkPlayerInfo;", "mInitialized", "mIsEnableHlsCache", "mIsFirstPlay", "mIsManualSeek", "mIsOtherLine", "mIsRealHitCache", "mPhoneListener", "Landroid/telephony/PhoneStateListener;", "mPlayListener", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IJKPlayListener;", "getMPlayListener", "()Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IJKPlayListener;", "setMPlayListener", "(Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IJKPlayListener;)V", "mPlayTimeEventReport", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/PlayTimeEventReport;", "mPlayer", "Ltv/danmaku/ijk/media/psplayer/PSMediaPlayer;", "mPlayerScene", "Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayerSceneType;", "mPositionTimer", "Ljava/util/Timer;", "mPreStartAlreadyCachePosition", "mProtocol", "mSpeed", "", "mStartPos", "mStartSeekTime", "Ljava/lang/Long;", "mStartTime", "mSurfaceHolder", "Landroid/view/SurfaceHolder;", "mTelephonyManager", "Landroid/telephony/TelephonyManager;", "mVideoObservers", "", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IVideoObserver;", "mVideoUrl", "playerLock", "", "playerStatus", "streamId", "videoPhoneState", "getVideoPhoneState", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "addListener", "", "destroyPlayer", "enableAutoSpeedPlay", "psIjkParameter", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/entity/PsIjkParameter;", "enableHLSCache", "getBufferProgress", "()Ljava/lang/Long;", "getCurrentPosition", "getCurrentSeiTimetamp", "getDisCacheDuration", "getDuration", "getHasBufferingTime", "getIjkPlayerInfo", "getMediaErrorInfo", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/MediaErrorInfo;", "getPlayerInfo", "Ltv/danmaku/ijk/media/psplayer/PlayerInfo;", "getPreStartCachePosition", "url", "startPos", "getSpeed", "getVideoAspectRatio", "getVideoCachedDuration", "getVideoHeight", "getVideoWidth", "initPlayer", "listener", "isInit", "isPause", "isPlaying", "needResume", "onPlayState", "state", "pausePlay", "playFile", "path", "liveTypeId", "playerScene", "playPSVideo", "protocol", "registerTelephonyListener", "releaseSurface", "seekTo", "position", "isManual", "seekToAccurate", "setBuffer", "bufSize", "setContentMode", "contentMode", "setIsOtherLine", "boolean", "setLogPath", "setOptions", "setSpeed", "speed", "setState", "setSurface", "surface", "Landroid/view/Surface;", "setSurfaceHolder", "setUserInfo", "userName", "userId", "setVolume", "volume", "left", "right", "startListenPlaying", "startPlay", "stopListenPlaying", "stopPlay", "Companion", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IJKPlayer.kt */
public class IJKPlayer implements IIJKMediaPlayer {
    /* access modifiers changed from: private */
    public static int COUNT = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DEFAULT_PLAYING_SECOND = 1000;
    /* access modifiers changed from: private */
    public static final String SCHOOL_CODE_SG = "6501";
    private static final String SCHOOL_CODE_UK = "4401";
    private static final String SCHOOL_CODE_US = "415";
    private static final XesLogTag TAG = Tag.VIDEO_PLAY;
    private final AtomicBoolean isBuffering;
    private final AtomicBoolean isCreate;
    private final AtomicBoolean isPreparing;
    private boolean isStoping;
    private long mBufferingStartTime;
    private Context mContext;
    private int mCurrentState;
    private final IjkPlayerInfo mIjkPlayerInfo;
    private boolean mInitialized;
    private boolean mIsEnableHlsCache;
    private boolean mIsFirstPlay;
    private boolean mIsManualSeek;
    private boolean mIsOtherLine;
    private boolean mIsRealHitCache;
    private final PhoneStateListener mPhoneListener;
    private IJKPlayListener mPlayListener;
    private PlayTimeEventReport mPlayTimeEventReport;
    private PSMediaPlayer mPlayer;
    private VideoPlayerSceneType mPlayerScene;
    private Timer mPositionTimer;
    private long mPreStartAlreadyCachePosition;
    private int mProtocol;
    private float mSpeed;
    private float mStartPos;
    private Long mStartSeekTime;
    private Long mStartTime;
    private SurfaceHolder mSurfaceHolder;
    private TelephonyManager mTelephonyManager;
    private List<IVideoObserver> mVideoObservers;
    private String mVideoUrl;
    private final Object playerLock;
    private int playerStatus;
    private final String streamId;
    private final AtomicBoolean videoPhoneState;

    @JvmStatic
    public static final void login(String str, String str2, String str3, String str4, String str5) {
        Companion.login(str, str2, str3, str4, str5);
    }

    public final long getDisCacheDuration() {
        return 0;
    }

    public final void playFile(String str, float f, VideoPlayerSceneType videoPlayerSceneType) {
        playFile$default(this, str, f, 0, videoPlayerSceneType, 4, (Object) null);
    }

    public final void playFile(String str, VideoPlayerSceneType videoPlayerSceneType) {
        playFile$default(this, str, 0.0f, 0, videoPlayerSceneType, 6, (Object) null);
    }

    public IJKPlayer(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        this.mIjkPlayerInfo = new IjkPlayerInfo(0, false, 0, 7, (DefaultConstructorMarker) null);
        this.mVideoObservers = new ArrayList();
        this.playerLock = new Object();
        this.isPreparing = new AtomicBoolean(false);
        this.isCreate = new AtomicBoolean(false);
        this.isBuffering = new AtomicBoolean(false);
        this.mSpeed = 1.0f;
        this.videoPhoneState = new AtomicBoolean(false);
        this.mIsFirstPlay = true;
        this.mPlayTimeEventReport = new PlayTimeEventReport();
        this.mPhoneListener = new IJKPlayer$mPhoneListener$1(this);
    }

    public final IJKPlayListener getMPlayListener() {
        return this.mPlayListener;
    }

    public final void setMPlayListener(IJKPlayListener iJKPlayListener) {
        this.mPlayListener = iJKPlayListener;
    }

    public final AtomicBoolean getVideoPhoneState() {
        return this.videoPhoneState;
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nJ8\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0007J\u0016\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"J!\u0010#\u001a\u00020\u00122\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\u0004¢\u0006\u0002\u0010(J\u0016\u0010#\u001a\u00020\u00122\u0006\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004J\u0006\u0010*\u001a\u00020\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IJKPlayer$Companion;", "", "()V", "COUNT", "", "getCOUNT", "()I", "setCOUNT", "(I)V", "DEFAULT_PLAYING_SECOND", "", "SCHOOL_CODE_SG", "", "SCHOOL_CODE_UK", "SCHOOL_CODE_US", "TAG", "Lcom/tal/app/thinkacademy/lib/logger/XesLogTag;", "cleanCacheData", "", "path", "getCacheInfo", "Ltv/danmaku/ijk/media/psplayer/PSMediaPlayer$CacheInfo;", "url", "position", "login", "ijkId", "applicationKey", "psId", "password", "schoolCode", "setCachePath", "sizeMB", "setPreListen", "listener", "Ltv/danmaku/ijk/media/psplayer/PSMediaPlayer$PreloadListener;", "startPreload", "items", "", "Ltv/danmaku/ijk/media/psplayer/PSMediaPlayer$CacheItem;", "mode", "([Ltv/danmaku/ijk/media/psplayer/PSMediaPlayer$CacheItem;I)V", "item", "stopPreload", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IJKPlayer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getCOUNT() {
            return IJKPlayer.COUNT;
        }

        public final void setCOUNT(int i) {
            IJKPlayer.COUNT = i;
        }

        public final void startPreload(PSMediaPlayer.CacheItem cacheItem, int i) {
            Intrinsics.checkNotNullParameter(cacheItem, "item");
            PSMediaPlayer.preloadStart(cacheItem, i);
        }

        public final void startPreload(PSMediaPlayer.CacheItem[] cacheItemArr, int i) {
            Intrinsics.checkNotNullParameter(cacheItemArr, "items");
            PSMediaPlayer.preloadStart(cacheItemArr, i);
        }

        public final void stopPreload() {
            PSMediaPlayer.preloadStop();
        }

        public final void setCachePath(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "path");
            PSMediaPlayer.setCacheConfig(str, i);
        }

        public final void setPreListen(PSMediaPlayer.PreloadListener preloadListener) {
            PSMediaPlayer.setPreloadListener(preloadListener);
        }

        public final PSMediaPlayer.CacheInfo getCacheInfo(String str, long j) {
            Intrinsics.checkNotNullParameter(str, "url");
            return PSMediaPlayer.getCacheInfo(str, j);
        }

        public final void cleanCacheData(String str) {
            Intrinsics.checkNotNullParameter(str, "path");
            PSMediaPlayer.cleanCacheData(str);
        }

        public static /* synthetic */ void login$default(Companion companion, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "hw20001";
            }
            String str6 = str;
            if ((i & 2) != 0) {
                str2 = "";
            }
            companion.login(str6, str2, (i & 4) != 0 ? "visitor" : str3, (i & 8) != 0 ? "visitor" : str4, str5);
        }

        @JvmStatic
        public final void login(String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "ijkId");
            Intrinsics.checkNotNullParameter(str2, "applicationKey");
            Intrinsics.checkNotNullParameter(str3, "psId");
            Intrinsics.checkNotNullParameter(str4, "password");
            Intrinsics.checkNotNullParameter(str5, "schoolCode");
            String uniqueDeviceId = DeviceUtils.getUniqueDeviceId();
            String str6 = "us_host_config.json";
            if (IJKPlayer.SCHOOL_CODE_US.equals(str5)) {
                str6 = "us_host_config.json";
            } else if (IJKPlayer.SCHOOL_CODE_UK.equals(str5)) {
                str6 = "uk_host_config.json";
            } else if (IJKPlayer.SCHOOL_CODE_SG.equals(str5)) {
                str6 = "sg_host_config.json";
            }
            String loadAssetsString = AssetsFileUtils.loadAssetsString(Utils.getApp(), str6);
            if (loadAssetsString == null) {
                loadAssetsString = "";
            }
            PSMediaPlayer.setHostConfig(loadAssetsString);
            synchronized (IJKPlayer.Companion.getClass()) {
                if (IJKPlayer.Companion.getCOUNT() == 0) {
                    try {
                        PSMediaPlayer.login(Utils.getApp().getApplicationContext(), "hw20001", str2, str3, str4, uniqueDeviceId, new IJKPlayer$Companion$login$1$1());
                    } catch (Exception e) {
                        XesLog.e(Tag.VIDEO_MONITOR, Intrinsics.stringPlus("磐石播放器登录报错=", e));
                    }
                }
                Companion companion = IJKPlayer.Companion;
                companion.setCOUNT(companion.getCOUNT() + 1);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IJKPlayer(Context context, String str, String str2, String str3, String str4, String str5) {
        this(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appID");
        Intrinsics.checkNotNullParameter(str2, "applicationKey");
        Intrinsics.checkNotNullParameter(str3, "psId");
        Intrinsics.checkNotNullParameter(str4, "password");
        Intrinsics.checkNotNullParameter(str5, "schoolCode");
        Companion.login(str, str2, str3, str4, str5);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IJKPlayer(Context context, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, str3, str4, (i & 32) != 0 ? SCHOOL_CODE_US : str5);
    }

    public final boolean initPlayer(IJKPlayListener iJKPlayListener) {
        PSMediaPlayer pSMediaPlayer;
        Intrinsics.checkNotNullParameter(iJKPlayListener, "listener");
        this.mPlayListener = iJKPlayListener;
        if (this.mPlayer == null) {
            try {
                synchronized (this.playerLock) {
                    this.mPlayer = new PSMediaPlayer();
                    Unit unit = Unit.INSTANCE;
                }
                setLogPath();
                addListener();
                registerTelephonyListener();
                XesLog.i(TAG, Intrinsics.stringPlus("是否打开缓存=", Boolean.valueOf(this.mIsEnableHlsCache)));
                if (this.mIsEnableHlsCache && (pSMediaPlayer = this.mPlayer) != null) {
                    pSMediaPlayer.enableHLSCache();
                }
            } catch (UnsatisfiedLinkError unused) {
                iJKPlayListener.onPlayError();
                return false;
            }
        }
        return true;
    }

    private final void getPreStartCachePosition(String str, long j) {
        boolean z;
        PSMediaPlayer.CacheInfo cacheInfo;
        this.mPreStartAlreadyCachePosition = 0;
        this.mIsRealHitCache = false;
        if (str == null || (cacheInfo = Companion.getCacheInfo(str, j)) == null) {
            z = false;
        } else {
            long j2 = cacheInfo.cacheDuration;
            this.mPreStartAlreadyCachePosition = j2;
            this.mIsRealHitCache = j2 > 0;
            z = true;
        }
        this.mPlayTimeEventReport.setMIsPlayStartHitCache(this.mIsRealHitCache);
        XesLog.i(TAG, "是否获取到缓存信息=" + z + ",播放起始点=" + this.mStartPos + ",当前进度起缓存了多少=" + this.mPreStartAlreadyCachePosition + "，启播是否真正命中缓存=" + this.mIsRealHitCache);
    }

    public static /* synthetic */ void playFile$default(IJKPlayer iJKPlayer, String str, float f, int i, VideoPlayerSceneType videoPlayerSceneType, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            iJKPlayer.playFile(str, f, i, videoPlayerSceneType);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playFile");
    }

    public final void playFile(String str, float f, int i, VideoPlayerSceneType videoPlayerSceneType) {
        String str2 = str;
        float f2 = f;
        synchronized (this.playerLock) {
            if (this.mPlayer != null) {
                XesLogTag xesLogTag = TAG;
                Object[] objArr = new Object[1];
                objArr[0] = Intrinsics.stringPlus("是否是默认线路=", Boolean.valueOf(!this.mIsOtherLine));
                XesLog.i(xesLogTag, objArr);
                this.mStartPos = f2;
                PSMediaPlayer pSMediaPlayer = this.mPlayer;
                if (pSMediaPlayer != null) {
                    pSMediaPlayer.setScreenOnWhilePlaying(true);
                }
                SurfaceHolder surfaceHolder = this.mSurfaceHolder;
                if ((surfaceHolder == null ? null : surfaceHolder.getSurface()) != null) {
                    PSMediaPlayer pSMediaPlayer2 = this.mPlayer;
                    if (pSMediaPlayer2 != null) {
                        pSMediaPlayer2.setDisplay(this.mSurfaceHolder);
                    }
                }
                PSMediaPlayer pSMediaPlayer3 = this.mPlayer;
                if (pSMediaPlayer3 != null) {
                    pSMediaPlayer3.setOption(1, "dns_cache_clear", 1);
                }
                PSMediaPlayer pSMediaPlayer4 = this.mPlayer;
                if (pSMediaPlayer4 != null) {
                    pSMediaPlayer4.setOption(1, "allowed_extensions", "ALL");
                }
                this.mPlayerScene = videoPlayerSceneType;
                this.mVideoUrl = str2;
                this.mStartTime = Long.valueOf(SystemClock.elapsedRealtime());
                this.mIsFirstPlay = true;
                getPreStartCachePosition(this.mVideoUrl, (long) this.mStartPos);
                this.mPlayTimeEventReport.playFile(this.mVideoUrl, this.mPlayerScene, this.mIsEnableHlsCache, this.mIsOtherLine);
                XesLogTag xesLogTag2 = Tag.VIDEO_MONITOR;
                Object[] objArr2 = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("开始调用playFile接口，使用场景=");
                VideoPlayerSceneType videoPlayerSceneType2 = this.mPlayerScene;
                sb.append(videoPlayerSceneType2 == null ? null : videoPlayerSceneType2.getValue());
                sb.append("，播放地址=");
                sb.append(this.mVideoUrl);
                objArr2[0] = sb.toString();
                XesLog.i(xesLogTag2, objArr2);
                IjkTrackUtil.INSTANCE.trackStartPlayEvent(this.mPlayerScene, this.mVideoUrl, VideoActionType.START, this.mIsEnableHlsCache, (long) this.mStartPos, this.mPreStartAlreadyCachePosition, this.mIsRealHitCache, this.mIsOtherLine);
                if (TextUtils.isEmpty(str2)) {
                    XesLogTag xesLogTag3 = Tag.VIDEO_MONITOR;
                    Object[] objArr3 = new Object[1];
                    VideoPlayerSceneType videoPlayerSceneType3 = this.mPlayerScene;
                    objArr3[0] = Intrinsics.stringPlus("视频起播失败，播放地址为空，使用场景=", videoPlayerSceneType3 == null ? null : videoPlayerSceneType3.getValue());
                    XesLog.e(xesLogTag3, objArr3);
                    IjkTrackUtil.INSTANCE.trackPlayFailEvent(this.mPlayerScene, this.mVideoUrl, VideoPlayFailType.VIDEO_URL_EMPTY, "播放地址为空", VideoActionType.START, this.mIsEnableHlsCache, (long) this.mStartPos, this.mPreStartAlreadyCachePosition, this.mIsRealHitCache, this.mIsOtherLine);
                } else {
                    PSMediaPlayer pSMediaPlayer5 = this.mPlayer;
                    Integer valueOf = pSMediaPlayer5 == null ? null : Integer.valueOf(pSMediaPlayer5.playFile(str2, f2 / 1000.0f, i));
                    if (valueOf != null) {
                        if (valueOf.intValue() == 0) {
                            XesLogTag xesLogTag4 = Tag.VIDEO_MONITOR;
                            Object[] objArr4 = new Object[1];
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("调用播放接口成功(只是API调用成功，视频是否真正播放成功查看视频起播日志)，使用场景=");
                            VideoPlayerSceneType videoPlayerSceneType4 = this.mPlayerScene;
                            sb2.append(videoPlayerSceneType4 == null ? null : videoPlayerSceneType4.getValue());
                            sb2.append("，播放地址=");
                            sb2.append(this.mVideoUrl);
                            objArr4[0] = sb2.toString();
                            XesLog.s(xesLogTag4, objArr4);
                        }
                    }
                    XesLogTag xesLogTag5 = Tag.VIDEO_MONITOR;
                    Object[] objArr5 = new Object[1];
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("视频起播失败，调用播放接口失败，使用场景=");
                    VideoPlayerSceneType videoPlayerSceneType5 = this.mPlayerScene;
                    sb3.append(videoPlayerSceneType5 == null ? null : videoPlayerSceneType5.getValue());
                    sb3.append("，播放地址=");
                    sb3.append(this.mVideoUrl);
                    sb3.append("，错误码=");
                    sb3.append(valueOf);
                    objArr5[0] = sb3.toString();
                    XesLog.e(xesLogTag5, objArr5);
                    IjkTrackUtil.INSTANCE.trackPlayFailEvent(this.mPlayerScene, this.mVideoUrl, VideoPlayFailType.CALL_PLAY_METHOD_FAIL, Intrinsics.stringPlus("调用播放接口失败，错误码=", valueOf), VideoActionType.START, this.mIsEnableHlsCache, (long) this.mStartPos, this.mPreStartAlreadyCachePosition, this.mIsRealHitCache, this.mIsOtherLine);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ boolean playPSVideo$default(IJKPlayer iJKPlayer, String str, int i, int i2, float f, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 8) != 0) {
                f = 0.0f;
            }
            return iJKPlayer.playPSVideo(str, i, i2, f);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playPSVideo");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008c, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x009a, code lost:
        return r2;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x007b=Splitter:B:40:0x007b, B:48:0x008d=Splitter:B:48:0x008d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean playPSVideo(java.lang.String r6, int r7, int r8, float r9) {
        /*
            r5 = this;
            java.lang.String r0 = "streamId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Object r0 = r5.playerLock
            monitor-enter(r0)
            r5.mProtocol = r7     // Catch:{ all -> 0x009b }
            r5.mStartPos = r9     // Catch:{ all -> 0x009b }
            android.view.SurfaceHolder r1 = r5.mSurfaceHolder     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x0042
            r2 = 0
            if (r1 != 0) goto L_0x0015
            r1 = r2
            goto L_0x0019
        L_0x0015:
            android.view.Surface r1 = r1.getSurface()     // Catch:{ all -> 0x009b }
        L_0x0019:
            if (r1 == 0) goto L_0x0042
            android.view.SurfaceHolder r1 = r5.mSurfaceHolder     // Catch:{ all -> 0x009b }
            if (r1 != 0) goto L_0x0020
            goto L_0x002f
        L_0x0020:
            android.view.Surface r1 = r1.getSurface()     // Catch:{ all -> 0x009b }
            if (r1 != 0) goto L_0x0027
            goto L_0x002f
        L_0x0027:
            boolean r1 = r1.isValid()     // Catch:{ all -> 0x009b }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x009b }
        L_0x002f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x009b }
            boolean r1 = r2.booleanValue()     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x0042
            tv.danmaku.ijk.media.psplayer.PSMediaPlayer r1 = r5.mPlayer     // Catch:{ all -> 0x009b }
            if (r1 != 0) goto L_0x003d
            goto L_0x0042
        L_0x003d:
            android.view.SurfaceHolder r2 = r5.mSurfaceHolder     // Catch:{ all -> 0x009b }
            r1.setDisplay(r2)     // Catch:{ all -> 0x009b }
        L_0x0042:
            tv.danmaku.ijk.media.psplayer.PSMediaPlayer r1 = r5.mPlayer     // Catch:{ all -> 0x009b }
            r2 = 1
            if (r1 != 0) goto L_0x0048
            goto L_0x004b
        L_0x0048:
            r1.setScreenOnWhilePlaying(r2)     // Catch:{ all -> 0x009b }
        L_0x004b:
            r5.setOptions()     // Catch:{ all -> 0x009b }
            com.tal.app.thinkacademy.lib.player.ijkplayer.config.MediaPlayer$Companion r1 = com.tal.app.thinkacademy.lib.player.ijkplayer.config.MediaPlayer.Companion     // Catch:{ all -> 0x009b }
            int r1 = r1.getVIDEO_PROTOCOL_RTMP()     // Catch:{ all -> 0x009b }
            r3 = 0
            if (r7 == r1) goto L_0x008d
            com.tal.app.thinkacademy.lib.player.ijkplayer.config.MediaPlayer$Companion r1 = com.tal.app.thinkacademy.lib.player.ijkplayer.config.MediaPlayer.Companion     // Catch:{ all -> 0x009b }
            int r1 = r1.getVIDEO_PROTOCOL_FLV()     // Catch:{ all -> 0x009b }
            if (r7 == r1) goto L_0x008d
            com.tal.app.thinkacademy.lib.player.ijkplayer.config.MediaPlayer$Companion r1 = com.tal.app.thinkacademy.lib.player.ijkplayer.config.MediaPlayer.Companion     // Catch:{ all -> 0x009b }
            int r1 = r1.getVIDEO_PROTOCOL_HLS()     // Catch:{ all -> 0x009b }
            if (r7 != r1) goto L_0x0068
            goto L_0x008d
        L_0x0068:
            com.tal.app.thinkacademy.lib.player.ijkplayer.config.MediaPlayer$Companion r1 = com.tal.app.thinkacademy.lib.player.ijkplayer.config.MediaPlayer.Companion     // Catch:{ all -> 0x009b }
            int r1 = r1.getVIDEO_PROTOCOL_MP4()     // Catch:{ all -> 0x009b }
            if (r7 == r1) goto L_0x007b
            com.tal.app.thinkacademy.lib.player.ijkplayer.config.MediaPlayer$Companion r1 = com.tal.app.thinkacademy.lib.player.ijkplayer.config.MediaPlayer.Companion     // Catch:{ all -> 0x009b }
            int r1 = r1.getVIDEO_PROTOCOL_M3U8()     // Catch:{ all -> 0x009b }
            if (r7 != r1) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            monitor-exit(r0)
            return r3
        L_0x007b:
            tv.danmaku.ijk.media.psplayer.PSMediaPlayer r1 = r5.mPlayer     // Catch:{ all -> 0x009b }
            if (r1 != 0) goto L_0x0081
        L_0x007f:
            r2 = r3
            goto L_0x008b
        L_0x0081:
            r4 = 1000(0x3e8, float:1.401E-42)
            float r4 = (float) r4     // Catch:{ all -> 0x009b }
            float r9 = r9 / r4
            int r6 = r1.playVod(r6, r9, r7, r8)     // Catch:{ all -> 0x009b }
            if (r6 != 0) goto L_0x007f
        L_0x008b:
            monitor-exit(r0)
            return r2
        L_0x008d:
            tv.danmaku.ijk.media.psplayer.PSMediaPlayer r9 = r5.mPlayer     // Catch:{ all -> 0x009b }
            if (r9 != 0) goto L_0x0093
        L_0x0091:
            r2 = r3
            goto L_0x0099
        L_0x0093:
            int r6 = r9.playLive(r6, r7, r8)     // Catch:{ all -> 0x009b }
            if (r6 != 0) goto L_0x0091
        L_0x0099:
            monitor-exit(r0)
            return r2
        L_0x009b:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer.playPSVideo(java.lang.String, int, int, float):boolean");
    }

    private final void setOptions() {
        PSMediaPlayer pSMediaPlayer = this.mPlayer;
        if (pSMediaPlayer != null) {
            pSMediaPlayer.setOption(1, "allowed_extensions", "ALL");
        }
        PSMediaPlayer pSMediaPlayer2 = this.mPlayer;
        if (pSMediaPlayer2 != null) {
            pSMediaPlayer2.setOption(4, "soundtouch", 1);
        }
    }

    private final void setLogPath() {
        try {
            String str = PathUtils.getExternalAppDataPath() + File.separator + "ijklog";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            PSMediaPlayer pSMediaPlayer = this.mPlayer;
            if (pSMediaPlayer != null) {
                pSMediaPlayer.setOption(4, "logpath", str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void addListener() {
        PSMediaPlayer pSMediaPlayer = this.mPlayer;
        if (pSMediaPlayer != null) {
            pSMediaPlayer.setSeverListListener(new IJKPlayer$$ExternalSyntheticLambda1(this));
        }
        PSMediaPlayer pSMediaPlayer2 = this.mPlayer;
        if (pSMediaPlayer2 != null) {
            pSMediaPlayer2.setPlayerStateListener(new IJKPlayer$$ExternalSyntheticLambda0(this));
        }
        PSMediaPlayer pSMediaPlayer3 = this.mPlayer;
        if (pSMediaPlayer3 != null) {
            pSMediaPlayer3.setVideoInfoListener(new IJKPlayer$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addListener$lambda-5  reason: not valid java name */
    public static final void m94addListener$lambda5(IJKPlayer iJKPlayer, IMediaPlayer iMediaPlayer, String str) {
        Intrinsics.checkNotNullParameter(iJKPlayer, "this$0");
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("cur");
            int optInt2 = jSONObject.optInt("total");
            JSONArray optJSONArray = jSONObject.optJSONArray("addrs");
            Intrinsics.checkNotNullExpressionValue(optJSONArray, "jsonObject.optJSONArray(\"addrs\")");
            List arrayList = new ArrayList();
            int i = 0;
            int length = optJSONArray.length();
            while (i < length) {
                int i2 = i + 1;
                String optString = optJSONArray.optString(i);
                Intrinsics.checkNotNullExpressionValue(optString, "jsonArray.optString(i)");
                arrayList.add(optString);
                i = i2;
            }
            IJKPlayListener iJKPlayListener = iJKPlayer.mPlayListener;
            if (iJKPlayListener != null) {
                iJKPlayListener.onOpenStart();
            }
            IJKPlayListener iJKPlayListener2 = iJKPlayer.mPlayListener;
            if (iJKPlayListener2 != null) {
                iJKPlayListener2.serverList(optInt, optInt2, arrayList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addListener$lambda-6  reason: not valid java name */
    public static final void m95addListener$lambda6(IJKPlayer iJKPlayer, IMediaPlayer iMediaPlayer, int i) {
        Intrinsics.checkNotNullParameter(iJKPlayer, "this$0");
        iJKPlayer.onPlayState(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: addListener$lambda-7  reason: not valid java name */
    public static final void m96addListener$lambda7(IJKPlayer iJKPlayer, IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        IJKPlayListener iJKPlayListener;
        Intrinsics.checkNotNullParameter(iJKPlayer, "this$0");
        if (i != -1 && i2 != -1 && (iJKPlayListener = iJKPlayer.mPlayListener) != null) {
            iJKPlayListener.onVideoSizeChanged(i, i2);
        }
    }

    private final void onPlayState(int i) {
        String str;
        int i2 = i;
        this.mPlayTimeEventReport.onPlayState(i2);
        this.playerStatus = i2;
        XesLog.i(Tag.VIDEO_MONITOR, "当前播放状态=" + i2 + "，状态描述，0：未初始化 1：准备中 2：开始播放 3：暂停状态 4：加载状态 5：播放完成状态 6：重试状态 7：频道不存在 -1：错误状态");
        switch (i2) {
            case -1:
                if (!this.mIsManualSeek && !this.mIsFirstPlay) {
                    XesLogTag xesLogTag = Tag.VIDEO_MONITOR;
                    Object[] objArr = new Object[1];
                    StringBuilder sb = new StringBuilder();
                    sb.append("播放错误，使用场景=");
                    VideoPlayerSceneType videoPlayerSceneType = this.mPlayerScene;
                    sb.append(videoPlayerSceneType == null ? null : videoPlayerSceneType.getValue());
                    sb.append("，播放地址=");
                    sb.append(this.mVideoUrl);
                    objArr[0] = sb.toString();
                    XesLog.e(xesLogTag, objArr);
                    IjkTrackUtil ijkTrackUtil = IjkTrackUtil.INSTANCE;
                    VideoPlayerSceneType videoPlayerSceneType2 = this.mPlayerScene;
                    String str2 = this.mVideoUrl;
                    VideoPlayFailType videoPlayFailType = VideoPlayFailType.PLAY_ERROR;
                    GsonUtil instance = GsonUtil.getInstance();
                    PSMediaPlayer pSMediaPlayer = this.mPlayer;
                    ijkTrackUtil.trackPlayFailEvent(videoPlayerSceneType2, str2, videoPlayFailType, Intrinsics.stringPlus("错误信息=", instance.objToJson(pSMediaPlayer == null ? null : pSMediaPlayer.getErrorInfo())), VideoActionType.OTHER, this.mIsEnableHlsCache, (long) this.mStartPos, this.mPreStartAlreadyCachePosition, this.mIsRealHitCache, this.mIsOtherLine);
                }
                if (this.mIsFirstPlay) {
                    this.mIsFirstPlay = false;
                    XesLogTag xesLogTag2 = Tag.VIDEO_MONITOR;
                    Object[] objArr2 = new Object[1];
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("视频起播失败，播放错误，使用场景=");
                    VideoPlayerSceneType videoPlayerSceneType3 = this.mPlayerScene;
                    sb2.append(videoPlayerSceneType3 == null ? null : videoPlayerSceneType3.getValue());
                    sb2.append("，播放地址=");
                    sb2.append(this.mVideoUrl);
                    sb2.append("，错误信息=");
                    GsonUtil instance2 = GsonUtil.getInstance();
                    PSMediaPlayer pSMediaPlayer2 = this.mPlayer;
                    sb2.append(instance2.objToJson(pSMediaPlayer2 == null ? null : pSMediaPlayer2.getErrorInfo()));
                    objArr2[0] = sb2.toString();
                    XesLog.e(xesLogTag2, objArr2);
                    IjkTrackUtil ijkTrackUtil2 = IjkTrackUtil.INSTANCE;
                    VideoPlayerSceneType videoPlayerSceneType4 = this.mPlayerScene;
                    String str3 = this.mVideoUrl;
                    VideoPlayFailType videoPlayFailType2 = VideoPlayFailType.PLAY_ERROR;
                    GsonUtil instance3 = GsonUtil.getInstance();
                    PSMediaPlayer pSMediaPlayer3 = this.mPlayer;
                    ijkTrackUtil2.trackPlayFailEvent(videoPlayerSceneType4, str3, videoPlayFailType2, Intrinsics.stringPlus("错误信息=", instance3.objToJson(pSMediaPlayer3 == null ? null : pSMediaPlayer3.getErrorInfo())), VideoActionType.START, this.mIsEnableHlsCache, (long) this.mStartPos, this.mPreStartAlreadyCachePosition, this.mIsRealHitCache, this.mIsOtherLine);
                }
                if (this.mIsManualSeek) {
                    this.mIsManualSeek = false;
                    XesLogTag xesLogTag3 = Tag.VIDEO_MONITOR;
                    Object[] objArr3 = new Object[1];
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Seek失败，播放错误，使用场景=");
                    VideoPlayerSceneType videoPlayerSceneType5 = this.mPlayerScene;
                    sb3.append(videoPlayerSceneType5 == null ? null : videoPlayerSceneType5.getValue());
                    sb3.append("，播放地址=");
                    sb3.append(this.mVideoUrl);
                    objArr3[0] = sb3.toString();
                    XesLog.e(xesLogTag3, objArr3);
                    IjkTrackUtil ijkTrackUtil3 = IjkTrackUtil.INSTANCE;
                    VideoPlayerSceneType videoPlayerSceneType6 = this.mPlayerScene;
                    String str4 = this.mVideoUrl;
                    VideoPlayFailType videoPlayFailType3 = VideoPlayFailType.PLAY_ERROR;
                    GsonUtil instance4 = GsonUtil.getInstance();
                    PSMediaPlayer pSMediaPlayer4 = this.mPlayer;
                    ijkTrackUtil3.trackPlayFailEvent(videoPlayerSceneType6, str4, videoPlayFailType3, Intrinsics.stringPlus("错误信息=", instance4.objToJson(pSMediaPlayer4 == null ? null : pSMediaPlayer4.getErrorInfo())), VideoActionType.SEEK, this.mIsEnableHlsCache, (long) this.mStartPos, this.mPreStartAlreadyCachePosition, this.mIsRealHitCache, this.mIsOtherLine);
                }
                XesLog.e(TAG, "PSError");
                stopListenPlaying();
                IJKPlayListener iJKPlayListener = this.mPlayListener;
                if (iJKPlayListener != null) {
                    iJKPlayListener.onOpenFailed(getMediaErrorInfo());
                    return;
                }
                return;
            case 0:
                XesLog.i(TAG, "回调：播放器创建");
                return;
            case 1:
                XesLog.i(TAG, "回调：准备中");
                this.isPreparing.set(true);
                this.isCreate.set(true);
                return;
            case 2:
                XesLogTag xesLogTag4 = TAG;
                XesLog.i(xesLogTag4, "回调：开始播放");
                if (this.mIsFirstPlay) {
                    this.mIsFirstPlay = false;
                    Long l = this.mStartTime;
                    Long valueOf = l == null ? null : Long.valueOf(SystemClock.elapsedRealtime() - l.longValue());
                    XesLogTag xesLogTag5 = Tag.VIDEO_MONITOR;
                    Object[] objArr4 = new Object[1];
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("视频起播成功，使用场景=");
                    VideoPlayerSceneType videoPlayerSceneType7 = this.mPlayerScene;
                    sb4.append(videoPlayerSceneType7 == null ? null : videoPlayerSceneType7.getValue());
                    sb4.append("，播放地址=");
                    sb4.append(this.mVideoUrl);
                    sb4.append("，起播耗时=");
                    sb4.append(valueOf);
                    sb4.append("毫秒");
                    objArr4[0] = sb4.toString();
                    XesLog.s(xesLogTag5, objArr4);
                    str = "Seek完成，使用场景=";
                    IjkTrackUtil.INSTANCE.trackPlaySuccessEvent(this.mPlayerScene, this.mVideoUrl, valueOf, VideoActionType.START, this.mIsEnableHlsCache, (long) this.mStartPos, this.mPreStartAlreadyCachePosition, this.mIsRealHitCache, this.mIsOtherLine);
                } else {
                    str = "Seek完成，使用场景=";
                }
                if (this.mIsManualSeek) {
                    this.mIsManualSeek = false;
                    Long l2 = this.mStartSeekTime;
                    Long valueOf2 = l2 == null ? null : Long.valueOf(SystemClock.elapsedRealtime() - l2.longValue());
                    XesLogTag xesLogTag6 = Tag.VIDEO_MONITOR;
                    Object[] objArr5 = new Object[1];
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    VideoPlayerSceneType videoPlayerSceneType8 = this.mPlayerScene;
                    sb5.append(videoPlayerSceneType8 == null ? null : videoPlayerSceneType8.getValue());
                    sb5.append("，播放地址=");
                    sb5.append(this.mVideoUrl);
                    sb5.append("，Seek耗时=");
                    sb5.append(valueOf2);
                    sb5.append("毫秒");
                    objArr5[0] = sb5.toString();
                    XesLog.s(xesLogTag6, objArr5);
                    IjkTrackUtil.INSTANCE.trackPlaySuccessEvent(this.mPlayerScene, this.mVideoUrl, valueOf2, VideoActionType.SEEK, this.mIsEnableHlsCache, (long) this.mStartPos, this.mPreStartAlreadyCachePosition, this.mIsRealHitCache, this.mIsOtherLine);
                }
                if (this.isBuffering.get()) {
                    XesLog.i(xesLogTag4, "结束loading...");
                    this.isBuffering.set(false);
                    IJKPlayListener iJKPlayListener2 = this.mPlayListener;
                    if (iJKPlayListener2 != null) {
                        iJKPlayListener2.onBufferComplete();
                    }
                }
                if (this.isPreparing.get() && !this.isStoping) {
                    this.isPreparing.set(false);
                    this.mInitialized = true;
                    XesLog.s(xesLogTag4, "准备成功");
                    IJKPlayListener iJKPlayListener3 = this.mPlayListener;
                    if (iJKPlayListener3 != null) {
                        iJKPlayListener3.onOpenSuccess();
                    }
                    setBuffer$default(this, 0, 1, (Object) null);
                    startListenPlaying();
                    return;
                }
                return;
            case 3:
                XesLogTag xesLogTag7 = TAG;
                XesLog.i(xesLogTag7, "回调：暂停");
                if (this.mIsManualSeek) {
                    this.mIsManualSeek = false;
                    Long l3 = this.mStartSeekTime;
                    Long valueOf3 = l3 == null ? null : Long.valueOf(SystemClock.elapsedRealtime() - l3.longValue());
                    XesLogTag xesLogTag8 = Tag.VIDEO_MONITOR;
                    Object[] objArr6 = new Object[1];
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Seek完成，使用场景=");
                    VideoPlayerSceneType videoPlayerSceneType9 = this.mPlayerScene;
                    sb6.append(videoPlayerSceneType9 == null ? null : videoPlayerSceneType9.getValue());
                    sb6.append("，播放地址=");
                    sb6.append(this.mVideoUrl);
                    sb6.append("，Seek耗时=");
                    sb6.append(valueOf3);
                    sb6.append("毫秒");
                    objArr6[0] = sb6.toString();
                    XesLog.s(xesLogTag8, objArr6);
                    IjkTrackUtil.INSTANCE.trackPlaySuccessEvent(this.mPlayerScene, this.mVideoUrl, valueOf3, VideoActionType.SEEK, this.mIsEnableHlsCache, (long) this.mStartPos, this.mPreStartAlreadyCachePosition, this.mIsRealHitCache, this.mIsOtherLine);
                }
                IJKPlayListener iJKPlayListener4 = this.mPlayListener;
                if (iJKPlayListener4 != null) {
                    iJKPlayListener4.onPaused();
                }
                if (this.isBuffering.get()) {
                    XesLog.i(xesLogTag7, "结束loading...");
                    this.isBuffering.set(false);
                    IJKPlayListener iJKPlayListener5 = this.mPlayListener;
                    if (iJKPlayListener5 != null) {
                        iJKPlayListener5.onBufferComplete();
                        return;
                    }
                    return;
                }
                return;
            case 4:
                XesLog.i(TAG, "开始loading...");
                if (this.isCreate.get()) {
                    IJKPlayListener iJKPlayListener6 = this.mPlayListener;
                    if (iJKPlayListener6 != null) {
                        iJKPlayListener6.onBufferStart();
                    }
                    this.isBuffering.set(true);
                    this.mBufferingStartTime = SystemClock.elapsedRealtime();
                    return;
                }
                return;
            case 5:
                XesLog.i(TAG, "播放完成");
                stopListenPlaying();
                IJKPlayListener iJKPlayListener7 = this.mPlayListener;
                if (iJKPlayListener7 != null) {
                    iJKPlayListener7.onPlaybackComplete();
                    return;
                }
                return;
            case 6:
                XesLog.i(TAG, "PSTring");
                this.isPreparing.set(true);
                return;
            case 7:
                if (!this.mIsManualSeek && !this.mIsFirstPlay) {
                    XesLogTag xesLogTag9 = Tag.VIDEO_MONITOR;
                    Object[] objArr7 = new Object[1];
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("播放失败，频道不存在，使用场景=");
                    VideoPlayerSceneType videoPlayerSceneType10 = this.mPlayerScene;
                    sb7.append(videoPlayerSceneType10 == null ? null : videoPlayerSceneType10.getValue());
                    sb7.append("，播放地址=");
                    sb7.append(this.mVideoUrl);
                    objArr7[0] = sb7.toString();
                    XesLog.e(xesLogTag9, objArr7);
                    IjkTrackUtil.INSTANCE.trackPlayFailEvent(this.mPlayerScene, this.mVideoUrl, VideoPlayFailType.PLAY_CHANNEL_NOT_EXIST, "播放失败，频道不存在", VideoActionType.OTHER, this.mIsEnableHlsCache, (long) this.mStartPos, this.mPreStartAlreadyCachePosition, this.mIsRealHitCache, this.mIsOtherLine);
                }
                if (this.mIsFirstPlay) {
                    this.mIsFirstPlay = false;
                    XesLogTag xesLogTag10 = Tag.VIDEO_MONITOR;
                    Object[] objArr8 = new Object[1];
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("视频起播失败，频道不存在，使用场景=");
                    VideoPlayerSceneType videoPlayerSceneType11 = this.mPlayerScene;
                    sb8.append(videoPlayerSceneType11 == null ? null : videoPlayerSceneType11.getValue());
                    sb8.append("，播放地址=");
                    sb8.append(this.mVideoUrl);
                    objArr8[0] = sb8.toString();
                    XesLog.e(xesLogTag10, objArr8);
                    IjkTrackUtil.INSTANCE.trackPlayFailEvent(this.mPlayerScene, this.mVideoUrl, VideoPlayFailType.PLAY_CHANNEL_NOT_EXIST, "视频起播失败，频道不存在", VideoActionType.START, this.mIsEnableHlsCache, (long) this.mStartPos, this.mPreStartAlreadyCachePosition, this.mIsRealHitCache, this.mIsOtherLine);
                }
                if (this.mIsManualSeek) {
                    this.mIsManualSeek = false;
                    XesLogTag xesLogTag11 = Tag.VIDEO_MONITOR;
                    Object[] objArr9 = new Object[1];
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("Seek失败，频道不存在，使用场景=");
                    VideoPlayerSceneType videoPlayerSceneType12 = this.mPlayerScene;
                    sb9.append(videoPlayerSceneType12 == null ? null : videoPlayerSceneType12.getValue());
                    sb9.append("，播放地址=");
                    sb9.append(this.mVideoUrl);
                    objArr9[0] = sb9.toString();
                    XesLog.e(xesLogTag11, objArr9);
                    IjkTrackUtil.INSTANCE.trackPlayFailEvent(this.mPlayerScene, this.mVideoUrl, VideoPlayFailType.PLAY_CHANNEL_NOT_EXIST, "Seek失败，频道不存在", VideoActionType.SEEK, this.mIsEnableHlsCache, (long) this.mStartPos, this.mPreStartAlreadyCachePosition, this.mIsRealHitCache, this.mIsOtherLine);
                }
                XesLog.i(TAG, "PSChannelNotExist");
                PSMediaPlayer pSMediaPlayer5 = this.mPlayer;
                ErrorInfo errorInfo = pSMediaPlayer5 == null ? null : pSMediaPlayer5.getErrorInfo();
                if (errorInfo == null) {
                    errorInfo = new ErrorInfo();
                }
                errorInfo.mErrorCode = 7;
                IJKPlayListener iJKPlayListener8 = this.mPlayListener;
                if (iJKPlayListener8 != null) {
                    iJKPlayListener8.onOpenFailed(getMediaErrorInfo());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void startListenPlaying() {
        if (this.mPositionTimer == null) {
            Timer timer = new Timer();
            this.mPositionTimer = timer;
            timer.schedule(new IJKPlayer$startListenPlaying$$inlined$timerTask$1(this), 0, 1000);
        }
    }

    public final void stopListenPlaying() {
        Timer timer = this.mPositionTimer;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = this.mPositionTimer;
        if (timer2 != null) {
            timer2.purge();
        }
        this.mPositionTimer = null;
    }

    private final void registerTelephonyListener() {
        this.mInitialized = false;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.mTelephonyManager = telephonyManager;
            if (telephonyManager != null) {
                telephonyManager.listen(this.mPhoneListener, 32);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startPlay() {
        if (isInit()) {
            try {
                startListenPlaying();
                PSMediaPlayer pSMediaPlayer = this.mPlayer;
                if (pSMediaPlayer != null) {
                    pSMediaPlayer.start();
                }
                setState(MediaPlayer.Companion.getSTATE_PLAYING());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            XesLog.e(TAG, "播放器未初始化");
        }
    }

    public void pausePlay() {
        synchronized (this.playerLock) {
            if (!(!isInit() || this.mProtocol == MediaPlayer.Companion.getVIDEO_PROTOCOL_RTMP() || this.mProtocol == MediaPlayer.Companion.getVIDEO_PROTOCOL_FLV() || this.mProtocol == MediaPlayer.Companion.getVIDEO_PROTOCOL_HLS())) {
                try {
                    PSMediaPlayer pSMediaPlayer = this.mPlayer;
                    if (pSMediaPlayer != null) {
                        pSMediaPlayer.pause();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                setState(MediaPlayer.Companion.getSTATE_NEED_RESUME());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void stopPlay() {
        System.currentTimeMillis();
        this.isStoping = true;
        stopListenPlaying();
        if (this.mPlayer != null) {
            synchronized (this.playerLock) {
                if (this.mPlayer != null) {
                    this.mInitialized = false;
                    IJKPlayListener mPlayListener2 = getMPlayListener();
                    if (mPlayListener2 != null) {
                        mPlayListener2.onCloseStart();
                    }
                    System.currentTimeMillis();
                    PSMediaPlayer pSMediaPlayer = this.mPlayer;
                    if (pSMediaPlayer != null) {
                        pSMediaPlayer.stop();
                    }
                    IJKPlayListener mPlayListener3 = getMPlayListener();
                    if (mPlayListener3 != null) {
                        mPlayListener3.onCloseComplete();
                    }
                    setState(MediaPlayer.Companion.getSTATE_STOPPED());
                    System.currentTimeMillis();
                    setMPlayListener((IJKPlayListener) null);
                    this.mPlayer = null;
                }
                Unit unit = Unit.INSTANCE;
            }
            System.currentTimeMillis();
        }
        this.isStoping = false;
    }

    public void destroyPlayer() {
        stopListenPlaying();
        if (this.mPlayer != null) {
            synchronized (this.playerLock) {
                if (this.mPlayer != null) {
                    this.mInitialized = false;
                    IJKPlayListener mPlayListener2 = getMPlayListener();
                    if (mPlayListener2 != null) {
                        mPlayListener2.onCloseStart();
                    }
                    System.currentTimeMillis();
                    PSMediaPlayer pSMediaPlayer = this.mPlayer;
                    if (pSMediaPlayer != null) {
                        pSMediaPlayer.stop();
                    }
                    IJKPlayListener mPlayListener3 = getMPlayListener();
                    if (mPlayListener3 != null) {
                        mPlayListener3.onCloseComplete();
                    }
                    System.currentTimeMillis();
                    setMPlayListener((IJKPlayListener) null);
                    this.mPlayer = null;
                }
                Unit unit = Unit.INSTANCE;
            }
            System.currentTimeMillis();
        }
        setState(MediaPlayer.Companion.getSTATE_STOPPED());
        TelephonyManager telephonyManager = this.mTelephonyManager;
        if (telephonyManager != null) {
            telephonyManager.listen(this.mPhoneListener, 0);
        }
        this.mPlayTimeEventReport.destroy();
    }

    public boolean isInit() {
        return this.mInitialized && this.mPlayer != null;
    }

    public boolean isPause() {
        return !isPlaying();
    }

    public boolean isPlaying() {
        if (isInit()) {
            PlayerInfo playerInfo = getPlayerInfo();
            Boolean valueOf = playerInfo == null ? null : Boolean.valueOf(playerInfo.mIsPlaying);
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public void setVolume(float f) {
        setVolume(f, f);
    }

    public void setVolume(float f, float f2) {
        PSMediaPlayer pSMediaPlayer = this.mPlayer;
        if (pSMediaPlayer != null) {
            pSMediaPlayer.setVolume(f, f2);
        }
    }

    public Long getDuration() {
        if (!isInit()) {
            return 0L;
        }
        PSMediaPlayer pSMediaPlayer = this.mPlayer;
        Long valueOf = pSMediaPlayer == null ? null : Long.valueOf(pSMediaPlayer.getDuration());
        Intrinsics.checkNotNull(valueOf);
        return valueOf;
    }

    public Long getCurrentPosition() {
        if (!isInit()) {
            return 0L;
        }
        PSMediaPlayer pSMediaPlayer = this.mPlayer;
        Long valueOf = pSMediaPlayer == null ? null : Long.valueOf(pSMediaPlayer.getCurrentPosition());
        Intrinsics.checkNotNull(valueOf);
        return valueOf;
    }

    public void seekTo(long j, boolean z) {
        boolean z2 = z;
        if (isInit()) {
            boolean z3 = false;
            if (z2) {
                this.mIsManualSeek = true;
                this.mStartSeekTime = Long.valueOf(SystemClock.elapsedRealtime());
                XesLog.i(Tag.VIDEO_MONITOR, Intrinsics.stringPlus("开始seek，seek到进度=", Long.valueOf(j)));
                IjkTrackUtil.INSTANCE.trackStartPlayEvent(this.mPlayerScene, this.mVideoUrl, VideoActionType.SEEK, this.mIsEnableHlsCache, (long) this.mStartPos, this.mPreStartAlreadyCachePosition, this.mIsRealHitCache, this.mIsOtherLine);
            }
            this.mPlayTimeEventReport.seek(z2);
            long longValue = getDuration().longValue();
            if (1 <= longValue && longValue < j) {
                z3 = true;
            }
            if (!z3) {
                longValue = j;
            }
            PSMediaPlayer pSMediaPlayer = this.mPlayer;
            if (pSMediaPlayer != null) {
                pSMediaPlayer.seekTo(longValue);
            }
        }
    }

    public void setSpeed(float f) {
        if (isInit()) {
            this.mSpeed = f;
            PSMediaPlayer pSMediaPlayer = this.mPlayer;
            if (pSMediaPlayer != null) {
                pSMediaPlayer.setSpeed(f);
            }
        }
    }

    public final float getSpeed() {
        return this.mSpeed;
    }

    public final void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "surface");
        this.mSurfaceHolder = surfaceHolder;
        synchronized (this.playerLock) {
            PSMediaPlayer pSMediaPlayer = this.mPlayer;
            if (pSMediaPlayer != null) {
                if (pSMediaPlayer != null) {
                    pSMediaPlayer.setDisplay(surfaceHolder);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setSurface(Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        synchronized (this.playerLock) {
            PSMediaPlayer pSMediaPlayer = this.mPlayer;
            if (pSMediaPlayer != null) {
                if (pSMediaPlayer != null) {
                    pSMediaPlayer.setSurface(surface);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setUserInfo(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "userName");
        Intrinsics.checkNotNullParameter(str2, "userId");
        PSMediaPlayer.setUserInfo(str, str2);
    }

    public final void releaseSurface() {
        if (isInit()) {
            PSMediaPlayer pSMediaPlayer = this.mPlayer;
            if (pSMediaPlayer != null) {
                pSMediaPlayer.setDisplay((SurfaceHolder) null);
            }
            PSMediaPlayer pSMediaPlayer2 = this.mPlayer;
            if (pSMediaPlayer2 != null) {
                pSMediaPlayer2.setSurface((Surface) null);
            }
        }
    }

    public final void setState(int i) {
        this.mCurrentState = i;
        this.mPlayTimeEventReport.setPlayerState(i);
    }

    public final void setContentMode(int i) {
        PSMediaPlayer pSMediaPlayer = this.mPlayer;
        if (pSMediaPlayer != null) {
            Intrinsics.checkNotNull(pSMediaPlayer);
            pSMediaPlayer.setContentMode(i);
        }
    }

    public final void enableAutoSpeedPlay(PsIjkParameter psIjkParameter) {
        if (this.mPlayer != null) {
            synchronized (this.playerLock) {
                if (psIjkParameter != null) {
                    PSMediaPlayer pSMediaPlayer = this.mPlayer;
                    if (pSMediaPlayer != null) {
                        pSMediaPlayer.enableAutoSpeedPlay(psIjkParameter.getMinWaterMark(), psIjkParameter.getMaxWaterMark(), psIjkParameter.getDuration());
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final boolean needResume() {
        return this.mInitialized && (this.mCurrentState == MediaPlayer.Companion.getSTATE_NEED_RESUME() || this.mCurrentState == MediaPlayer.Companion.getSTATE_PREPARED());
    }

    public final boolean isBuffering() {
        return this.isBuffering.get();
    }

    public final long getHasBufferingTime() {
        if (this.isBuffering.get()) {
            return SystemClock.elapsedRealtime() - this.mBufferingStartTime;
        }
        return 0;
    }

    public static /* synthetic */ void setBuffer$default(IJKPlayer iJKPlayer, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = MediaPlayer.Companion.getDEFAULT_BUF_SIZE();
            }
            iJKPlayer.setBuffer(j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBuffer");
    }

    public final void setBuffer(long j) {
        try {
            PSMediaPlayer pSMediaPlayer = this.mPlayer;
            if (pSMediaPlayer != null) {
                pSMediaPlayer.setOption(4, "max-buffer-size", j * ((long) 10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final int getVideoWidth() {
        try {
            if (!isInit()) {
                return 0;
            }
            PlayerInfo playerInfo = getPlayerInfo();
            Integer valueOf = playerInfo == null ? null : Integer.valueOf(playerInfo.mVideoWidth);
            Intrinsics.checkNotNull(valueOf);
            return valueOf.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final int getVideoHeight() {
        try {
            if (!isInit()) {
                return 0;
            }
            PlayerInfo playerInfo = getPlayerInfo();
            Integer valueOf = playerInfo == null ? null : Integer.valueOf(playerInfo.mVideoHeight);
            Intrinsics.checkNotNull(valueOf);
            return valueOf.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final float getVideoAspectRatio() {
        if (getVideoHeight() == 0) {
            return 0.0f;
        }
        return (((float) getVideoWidth()) * 1.0f) / ((float) getVideoHeight());
    }

    public final Long getCurrentSeiTimetamp() {
        if (!isInit()) {
            return 0L;
        }
        PSMediaPlayer pSMediaPlayer = this.mPlayer;
        if (pSMediaPlayer == null) {
            return null;
        }
        return Long.valueOf(pSMediaPlayer.getCurrentSeiTimetamp());
    }

    public final void seekToAccurate() {
        PSMediaPlayer pSMediaPlayer = this.mPlayer;
        if (pSMediaPlayer != null) {
            pSMediaPlayer.setOption(4, "enable-accurate-seek", 1);
        }
    }

    public final Long getBufferProgress() {
        if (!isInit()) {
            return 0L;
        }
        PlayerInfo playerInfo = getPlayerInfo();
        if (playerInfo == null) {
            return null;
        }
        return Long.valueOf(playerInfo.mBufferingPercent);
    }

    public final Long getVideoCachedDuration() {
        try {
            if (!isInit()) {
                return 0L;
            }
            PlayerInfo playerInfo = getPlayerInfo();
            if (playerInfo == null) {
                return null;
            }
            return Long.valueOf(playerInfo.mVideoCacheDuration);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final IjkPlayerInfo getIjkPlayerInfo() {
        try {
            if (!isInit()) {
                return null;
            }
            PlayerInfo playerInfo = getPlayerInfo();
            if (playerInfo != null) {
                this.mIjkPlayerInfo.setMIsPlaying(playerInfo.mIsPlaying);
                this.mIjkPlayerInfo.setMTcpSpeed(playerInfo.mTcpSpeed);
                this.mIjkPlayerInfo.setMBufferingPercent(playerInfo.mBufferingPercent);
            }
            return this.mIjkPlayerInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void enableHLSCache() {
        this.mIsEnableHlsCache = true;
    }

    public final PlayerInfo getPlayerInfo() {
        PSMediaPlayer pSMediaPlayer;
        if (!isInit() || (pSMediaPlayer = this.mPlayer) == null) {
            return null;
        }
        return pSMediaPlayer.getPlayerInfo();
    }

    public final MediaErrorInfo getMediaErrorInfo() {
        Integer num;
        String str;
        PSMediaPlayer pSMediaPlayer = this.mPlayer;
        Integer num2 = null;
        ErrorInfo errorInfo = pSMediaPlayer == null ? null : pSMediaPlayer.getErrorInfo();
        MediaErrorInfo mediaErrorInfo = new MediaErrorInfo();
        if (this.playerStatus != 7) {
            if (errorInfo == null) {
                num = null;
            } else {
                num = Integer.valueOf(errorInfo.mErrorCode);
            }
            Intrinsics.checkNotNull(num);
            mediaErrorInfo.setMErrorCode(num.intValue());
            if (errorInfo == null) {
                str = null;
            } else {
                str = errorInfo.mErrorMsg;
            }
            mediaErrorInfo.setMErrorMsg(str);
            if (errorInfo != null) {
                num2 = Integer.valueOf(errorInfo.mPlayerErrorCode);
            }
            mediaErrorInfo.setMPlayerErrorCode(num2.intValue());
        } else {
            mediaErrorInfo.setMErrorCode(7);
            mediaErrorInfo.setMErrorMsg("PSChannelNotExist");
            mediaErrorInfo.setMPlayerErrorCode(7);
        }
        return mediaErrorInfo;
    }

    public final void setIsOtherLine(boolean z) {
        this.mIsOtherLine = z;
    }
}
