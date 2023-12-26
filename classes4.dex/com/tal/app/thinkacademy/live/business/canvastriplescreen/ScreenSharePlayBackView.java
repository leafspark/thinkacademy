package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.tal.app.thinkacademy.common.entity.AddressBean;
import com.tal.app.thinkacademy.common.entity.PlaybackUrlEntity;
import com.tal.app.thinkacademy.common.entity.ShareAddressBean;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayListener;
import com.tal.app.thinkacademy.lib.player.ijkplayer.MediaErrorInfo;
import com.tal.app.thinkacademy.lib.player.ijkplayer.config.MediaPlayer;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.liveplayback.livebackplayer.ScreenSharePlayerViewCtr;
import com.tal.app.thinkacademy.live.core.callback.PlayerTimeCallBack;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ScreenSharePlayBackView extends BaseScreenShareView implements LifecycleObserver, LifecycleOwner, Observer<PluginEventData> {
    private static final long PROGRESS_ALIGNMENT_RANGE = 3000;
    private static final long SYNC_FREQUENCY = 500;
    /* access modifiers changed from: private */
    public static final XesLogTag TAG = Tag.SCREEN_SHARE;
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        public DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }
    };
    private IJKPlayListener listener = new IJKPlayListener() {
        public void onHWRenderFailed() {
            XesLog.i(ScreenSharePlayBackView.TAG, "屏幕共享视频硬解码失败");
        }

        public void onVideoSizeChanged(int i, int i2) {
            XesLogTag access$000 = ScreenSharePlayBackView.TAG;
            XesLog.i(access$000, "屏幕共享视频>>>onVideoSizeChanged>>>width=" + i + ",height" + i2);
        }

        public void onOpenStart() {
            XesLog.i(ScreenSharePlayBackView.TAG, "屏幕共享视频开始准备播放");
        }

        public void onOpenSuccess() {
            XesLog.i(ScreenSharePlayBackView.TAG, "屏幕共享视频打开成功");
            if (ScreenSharePlayBackView.this.mIsOnPause && ScreenSharePlayBackView.this.mPlayerViewCtr != null) {
                ScreenSharePlayBackView.this.mPlayerViewCtr.pausePlay();
            }
            if (ScreenSharePlayBackView.this.mPlayerViewCtr != null) {
                ScreenSharePlayBackView screenSharePlayBackView = ScreenSharePlayBackView.this;
                long unused = screenSharePlayBackView.mVideoDuration = screenSharePlayBackView.mPlayerViewCtr.getDuration();
                XesLogTag access$000 = ScreenSharePlayBackView.TAG;
                XesLog.i(access$000, "屏幕分享视频时长:" + ScreenSharePlayBackView.this.mVideoDuration);
            }
            boolean unused2 = ScreenSharePlayBackView.this.mIsOpenSuccess = true;
        }

        public void onOpenFailed(MediaErrorInfo mediaErrorInfo) {
            if (mediaErrorInfo != null) {
                XesLogTag access$000 = ScreenSharePlayBackView.TAG;
                XesLog.i(access$000, "屏幕共享视频打开失败>>>mErrorCode=" + mediaErrorInfo.getMErrorCode() + "，mPlayerErrorCode=" + mediaErrorInfo.getMPlayerErrorCode() + "，mErrorMsg=" + mediaErrorInfo.getMErrorMsg());
            } else {
                XesLog.i(ScreenSharePlayBackView.TAG, "屏幕共享视频打开失败");
            }
            ScreenSharePlayBackView.this.stopPlay();
            ScreenSharePlayBackView.this.startPlay();
        }

        public void onPaused() {
            XesLog.i(ScreenSharePlayBackView.TAG, "屏幕共享视频暂停");
        }

        public void onBufferStart() {
            XesLog.i(ScreenSharePlayBackView.TAG, "屏幕共享视频开始缓冲");
            boolean unused = ScreenSharePlayBackView.this.mIsLoading = true;
        }

        public void onBufferComplete() {
            XesLog.i(ScreenSharePlayBackView.TAG, "屏幕共享视频缓冲完成");
            boolean unused = ScreenSharePlayBackView.this.mIsLoading = false;
        }

        public void onPlaybackComplete() {
            XesLog.i(ScreenSharePlayBackView.TAG, "屏幕共享视频播放完成");
        }

        public void onCloseStart() {
            XesLog.i(ScreenSharePlayBackView.TAG, "屏幕共享视频开始退出播放器");
        }

        public void onCloseComplete() {
            XesLog.i(ScreenSharePlayBackView.TAG, "屏幕共享视频播放器退出完毕");
        }

        public void onPlaying(long j, long j2) {
            long unused = ScreenSharePlayBackView.this.mCurrentPosition = j;
        }

        public void onPlayError() {
            XesLog.i(ScreenSharePlayBackView.TAG, "屏幕共享视频播放错误");
            ScreenSharePlayBackView.this.stopPlay();
            ScreenSharePlayBackView.this.startPlay();
        }

        public void serverList(int i, int i2, List<String> list) {
            XesLogTag access$000 = ScreenSharePlayBackView.TAG;
            XesLog.i(access$000, "屏幕共享视频调度完成回调>>>cur=" + i + ",total=" + i2 + ",addressList" + GsonUtil.getInstance().objToJson(list));
        }
    };
    /* access modifiers changed from: private */
    public long mBeginTimestamp;
    private Context mContext;
    private CourseWareBean mCourseWareBean;
    /* access modifiers changed from: private */
    public long mCurrentPosition;
    private boolean mIsBack = false;
    /* access modifiers changed from: private */
    public boolean mIsLoading = false;
    /* access modifiers changed from: private */
    public boolean mIsOnPause = false;
    /* access modifiers changed from: private */
    public boolean mIsOpenSuccess = false;
    /* access modifiers changed from: private */
    public boolean mIsSeek = false;
    /* access modifiers changed from: private */
    public long mLastSyncTime;
    private ILiveRoomProvider mLiveRoomProvider;
    private PlaybackUrlEntity mPlaybackEntity;
    /* access modifiers changed from: private */
    public ScreenSharePlayerViewCtr mPlayerViewCtr;
    private int mProtocol;
    private String mStreamUrl;
    private List<AddressBean> mStreamUrlList;
    /* access modifiers changed from: private */
    public long mTeacherCurrentPosition;
    /* access modifiers changed from: private */
    public long mVideoDuration;
    private PlayerTimeCallBack playerTimeCallBack = new PlayerTimeCallBack() {
        public void onPlaying(long j, long j2) {
            long unused = ScreenSharePlayBackView.this.mTeacherCurrentPosition = j;
        }

        public void onSeiCurrent(long j) {
            if (ScreenSharePlayBackView.this.mIsOpenSuccess && !ScreenSharePlayBackView.this.mIsLoading) {
                if (SystemClock.elapsedRealtime() - ScreenSharePlayBackView.this.mLastSyncTime >= ScreenSharePlayBackView.SYNC_FREQUENCY || ScreenSharePlayBackView.this.mIsSeek) {
                    boolean unused = ScreenSharePlayBackView.this.mIsSeek = false;
                    long unused2 = ScreenSharePlayBackView.this.mLastSyncTime = SystemClock.elapsedRealtime();
                    if (j > ScreenSharePlayBackView.this.mBeginTimestamp + ScreenSharePlayBackView.this.mCurrentPosition + ScreenSharePlayBackView.PROGRESS_ALIGNMENT_RANGE || j < (ScreenSharePlayBackView.this.mBeginTimestamp + ScreenSharePlayBackView.this.mCurrentPosition) - ScreenSharePlayBackView.PROGRESS_ALIGNMENT_RANGE) {
                        long j2 = 0;
                        if (j - ScreenSharePlayBackView.this.mBeginTimestamp > ScreenSharePlayBackView.this.mVideoDuration) {
                            j2 = ScreenSharePlayBackView.this.mVideoDuration;
                        } else if (j - ScreenSharePlayBackView.this.mBeginTimestamp >= 0) {
                            j2 = j - ScreenSharePlayBackView.this.mBeginTimestamp;
                        }
                        if (ScreenSharePlayBackView.this.mPlayerViewCtr != null) {
                            ScreenSharePlayBackView.this.mPlayerViewCtr.seekTo(j2, false);
                        }
                        XesLogTag access$000 = ScreenSharePlayBackView.TAG;
                        XesLog.i(access$000, "进度不一致，对齐进度快进或快退：" + (j2 - ScreenSharePlayBackView.this.mCurrentPosition));
                    }
                }
            }
        }
    };

    public ScreenSharePlayBackView(Context context, ILiveRoomProvider iLiveRoomProvider, CourseWareBean courseWareBean) {
        super(context);
        this.mContext = context;
        this.mLiveRoomProvider = iLiveRoomProvider;
        this.mCourseWareBean = courseWareBean;
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "屏幕共享加载>>>" + GsonUtil.getInstance().objToJson(this.mCourseWareBean));
    }

    public void initView() {
        CourseWareBean courseWareBean;
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "初始化");
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null && iLiveRoomProvider.getDataStorage() != null && (courseWareBean = this.mCourseWareBean) != null && !TextUtils.isEmpty(courseWareBean.pageId)) {
            this.mBeginTimestamp = this.mCourseWareBean.timestamp;
            XesLog.i(xesLogTag, "屏幕分享开始时间:" + df.get().format(Long.valueOf(this.mBeginTimestamp)) + ",时间戳:" + this.mBeginTimestamp);
            EnterConfigProxy enterConfig = this.mLiveRoomProvider.getDataStorage().getEnterConfig();
            UserInfoProxy userInfo = this.mLiveRoomProvider.getDataStorage().getUserInfo();
            PlaybackUrlEntity playbackUrlResp = this.mLiveRoomProvider.getDataStorage().getPlaybackUrlResp();
            this.mPlaybackEntity = playbackUrlResp;
            if (playbackUrlResp != null) {
                XesLog.i(xesLogTag, "视频地址>>>" + GsonUtil.getInstance().objToJson(this.mPlaybackEntity));
                List<ShareAddressBean> list = this.mPlaybackEntity.share;
                if (list != null && list.size() > 0) {
                    for (ShareAddressBean next : list) {
                        if (next.pageId.equals(this.mCourseWareBean.pageId)) {
                            this.mStreamUrl = next.address;
                        }
                    }
                }
            }
            if (enterConfig != null && userInfo != null) {
                XesLogTag xesLogTag2 = TAG;
                XesLog.i(xesLogTag2, "初始化PlayerViewCtr");
                if (getLifecycle() != null) {
                    getLifecycle().addObserver(this);
                }
                this.mLiveRoomProvider.registerPlayerTimeCallback(this.playerTimeCallBack);
                ScreenSharePlayerViewCtr screenSharePlayerViewCtr = new ScreenSharePlayerViewCtr(this.mContext, enterConfig.getAppId(), enterConfig.getAppKey(), userInfo.getId(), ParseUtils.tryParseInt(enterConfig.getLiveTypeId(), 0));
                this.mPlayerViewCtr = screenSharePlayerViewCtr;
                screenSharePlayerViewCtr.initView(this);
                this.mPlayerViewCtr.setContentMode(MediaPlayer.Companion.getPS_CONTENT_MODE_RESIZE_ASPECT_FIT());
                PluginEventBus.register(this, "media_player", this);
                this.mPlayerViewCtr.setUserInfo(userInfo.getName(), userInfo.getId());
                this.mProtocol = enterConfig.getProtocol();
                if (!TextUtils.isEmpty(this.mStreamUrl)) {
                    List<AddressBean> list2 = this.mStreamUrlList;
                    if (list2 == null) {
                        this.mStreamUrlList = new ArrayList();
                    } else {
                        list2.clear();
                    }
                    AddressBean addressBean = new AddressBean();
                    addressBean.address = this.mStreamUrl;
                    this.mStreamUrlList.add(addressBean);
                    startPlay();
                    return;
                }
                XesLog.e(xesLogTag2, "initView,启播失败，地址为空");
            }
        }
    }

    /* access modifiers changed from: private */
    public void startPlay() {
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "startPlay");
        XesLog.i(xesLogTag, "播放地址>>>" + this.mStreamUrl);
        ScreenSharePlayerViewCtr screenSharePlayerViewCtr = this.mPlayerViewCtr;
        if (screenSharePlayerViewCtr != null) {
            screenSharePlayerViewCtr.initPlayer(this.listener);
            this.mPlayerViewCtr.startPlay(this.mCourseWareBean.pageId, this.mProtocol, 0.0f, this.mStreamUrl, this.mStreamUrlList);
            return;
        }
        XesLog.e(xesLogTag, "startPlay,播放视频失败，mPlayerViewCtr为空");
    }

    /* access modifiers changed from: private */
    public void stopPlay() {
        XesLog.i(TAG, "stopPlay");
        this.mIsOpenSuccess = false;
        this.mIsLoading = false;
        this.mCurrentPosition = 0;
        ScreenSharePlayerViewCtr screenSharePlayerViewCtr = this.mPlayerViewCtr;
        if (screenSharePlayerViewCtr != null) {
            screenSharePlayerViewCtr.stopPlay();
        }
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onLifecycleResume(LifecycleOwner lifecycleOwner) {
        XesLog.i(TAG, "onResume");
        ScreenSharePlayerViewCtr screenSharePlayerViewCtr = this.mPlayerViewCtr;
        if (screenSharePlayerViewCtr != null) {
            screenSharePlayerViewCtr.onResume();
        }
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onLifecyclePause(LifecycleOwner lifecycleOwner) {
        XesLog.i(TAG, "onPause");
        this.mIsOnPause = true;
        ScreenSharePlayerViewCtr screenSharePlayerViewCtr = this.mPlayerViewCtr;
        if (screenSharePlayerViewCtr != null) {
            screenSharePlayerViewCtr.onPause(true);
        }
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onLifecycleDestroy(LifecycleOwner lifecycleOwner) {
        XesLog.i(TAG, "onDestroy");
        release();
    }

    public void release() {
        XesLog.i(TAG, "释放");
        if (getLifecycle() != null) {
            getLifecycle().removeObserver(this);
        }
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null) {
            iLiveRoomProvider.unregisterPlayerTimeCallback(this.playerTimeCallBack);
        }
        PluginEventBus.unregister("media_player", this);
        ScreenSharePlayerViewCtr screenSharePlayerViewCtr = this.mPlayerViewCtr;
        if (screenSharePlayerViewCtr != null) {
            screenSharePlayerViewCtr.onDestroy();
        }
        this.mPlayerViewCtr = null;
        removeAllViews();
    }

    public void onChanged(PluginEventData pluginEventData) {
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "onChanged>>>" + GsonUtil.getInstance().objToJson(pluginEventData));
        if (this.mPlayerViewCtr != null) {
            String operation = pluginEventData.getOperation();
            XesLog.i(xesLogTag, "onChanged>>>operation=" + operation);
            operation.hashCode();
            char c = 65535;
            switch (operation.hashCode()) {
                case -1780607874:
                    if (operation.equals("player_change_progress")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1466478990:
                    if (operation.equals("player_toggle")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1337706602:
                    if (operation.equals("player_change_speed")) {
                        c = 2;
                        break;
                    }
                    break;
                case 87144216:
                    if (operation.equals("player_pause")) {
                        c = 3;
                        break;
                    }
                    break;
                case 557010386:
                    if (operation.equals("player_play")) {
                        c = 4;
                        break;
                    }
                    break;
                case 557107872:
                    if (operation.equals("player_stop")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    XesLog.i(xesLogTag, "主讲视频跳转进度");
                    long j = 0;
                    try {
                        j = new JSONObject(pluginEventData.getData()).optLong("position");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (j < this.mTeacherCurrentPosition) {
                        XesLog.i(TAG, "主动后退主讲播放进度");
                        this.mIsBack = true;
                    }
                    this.mIsSeek = true;
                    return;
                case 1:
                    XesLog.i(xesLogTag, "主讲视频切换播放/暂停状态");
                    if (this.mPlayerViewCtr.isPlaying()) {
                        this.mPlayerViewCtr.pausePlay();
                        return;
                    } else if (this.mIsOpenSuccess) {
                        this.mPlayerViewCtr.reStartPlay();
                        return;
                    } else {
                        return;
                    }
                case 2:
                    XesLog.i(xesLogTag, "主讲视频调整倍速");
                    float f = 1.0f;
                    try {
                        f = (float) new JSONObject(pluginEventData.getData()).optDouble("speed");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.mPlayerViewCtr.setSpeed(f);
                    return;
                case 3:
                    XesLog.i(xesLogTag, "主讲视频暂停");
                    this.mPlayerViewCtr.pausePlay();
                    return;
                case 4:
                    XesLog.i(xesLogTag, "主讲视频恢复播放");
                    if (this.mIsOpenSuccess) {
                        this.mPlayerViewCtr.reStartPlay();
                        return;
                    }
                    return;
                case 5:
                    XesLog.i(xesLogTag, "主讲视频停止视频");
                    this.mPlayerViewCtr.pausePlay();
                    return;
                default:
                    return;
            }
        }
    }

    public Lifecycle getLifecycle() {
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null) {
            return iLiveRoomProvider.getLifecycleOwner();
        }
        return null;
    }

    public void notifyDataChange(CourseWareBean courseWareBean) {
        List<ShareAddressBean> list;
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "屏幕共享刷新>>>" + GsonUtil.getInstance().objToJson(this.mCourseWareBean));
        stopPlay();
        if (courseWareBean != null) {
            this.mCourseWareBean = courseWareBean;
            this.mVideoDuration = 0;
            this.mBeginTimestamp = courseWareBean.timestamp;
            XesLog.i(xesLogTag, "屏幕共享开始时间:" + df.get().format(Long.valueOf(this.mBeginTimestamp)) + ",时间戳:" + this.mBeginTimestamp);
            PlaybackUrlEntity playbackUrlEntity = this.mPlaybackEntity;
            if (!(playbackUrlEntity == null || (list = playbackUrlEntity.share) == null || list.size() <= 0)) {
                for (ShareAddressBean next : list) {
                    if (next.pageId.equals(this.mCourseWareBean.pageId)) {
                        this.mStreamUrl = next.address;
                    }
                }
            }
            if (!TextUtils.isEmpty(this.mStreamUrl)) {
                List<AddressBean> list2 = this.mStreamUrlList;
                if (list2 == null) {
                    this.mStreamUrlList = new ArrayList();
                } else {
                    list2.clear();
                }
                AddressBean addressBean = new AddressBean();
                addressBean.address = this.mStreamUrl;
                this.mStreamUrlList.add(addressBean);
                startPlay();
                return;
            }
            XesLog.e(TAG, "屏幕共享刷新失败，地址为空");
        }
    }
}
