package com.tal.app.thinkacademy.live.business.liveplayback;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.google.gson.JsonObject;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.entity.AddressBean;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.network.utils.NetWorkUtils;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayListener;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer;
import com.tal.app.thinkacademy.lib.player.ijkplayer.MediaErrorInfo;
import com.tal.app.thinkacademy.lib.player.view.PlayerTextureView;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.ImageUtils;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.util.PathUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.liveplayback.dialog.PlayBackSwitchLineDialog;
import com.tal.app.thinkacademy.live.business.liveplayback.event.PlayerEventBus;
import com.tal.app.thinkacademy.live.business.liveplayback.livebackplayer.BaseLivePlayBackPlayerViewCtr;
import com.tal.app.thinkacademy.live.business.liveplayback.livebackplayer.LivePlaybackLagTipsView;
import com.tal.app.thinkacademy.live.business.liveplayback.livebackplayer.TripleScreenPlayBackPlayerViewCtr;
import com.tal.app.thinkacademy.live.business.liveplayback.loadingcontroller.LivePlayBackLoadingViewCtr;
import com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent;
import com.tal.app.thinkacademy.live.core.callback.FrameworkRequestCallback;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.core.utils.LiveTrack;
import com.tal.app.thinkacademy.live.core.utils.LiveTrackData;
import com.xueersi.lib.graffiti.utils.ListUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "直播回放播放插件", ircType = {"mode"}, launchType = "enter", liveType = 1, metaDataKey = {"mode"}, moduleId = "-104", noActiveKey = {"mode"})
@ViewLevels({@ViewLevel(level = 100, name = "video"), @ViewLevel(level = 4, name = "loading"), @ViewLevel(level = 100, name = "loadingLag")})
public class LivePlayBackPluginDriver extends BaseLivePluginDriver implements IJKPlayListener, Observer<PluginEventData>, FrameworkRequestCallback {
    private static final int DEFAULT_SEI_MILLSECOND = 66;
    private static final int ONE_MINUTE = 60000;
    private static final String SP_PLAY_PROGRESS_KEY = "play_progress";
    private static final Tag TAG = Tag.LIVE_PLAY_BACK;
    private static final int WHAT_HIDE_LAG_TIP = 100;
    private ArrayList<VideoPrivateBean> beginTimestamps = new ArrayList<>();
    private boolean isError = false;
    private boolean isFirstOpenSuccess = true;
    private boolean isGetBitmap = true;
    private boolean isMute = false;
    private boolean isStartSei = false;
    private int liveTypeId;
    private Context mContext;
    private float mCurrentPosition;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            super.handleMessage(message);
            if (message.what == 100 && LivePlayBackPluginDriver.this.mLoadingViewCtr != null) {
                LivePlayBackPluginDriver.this.hideLagTipView();
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    };
    private boolean mIsCanToastNetSlow = true;
    private boolean mIsOnPause;
    private LivePlaybackLagTipsView mLagTipsView;
    /* access modifiers changed from: private */
    public LivePlayBackLoadingViewCtr mLoadingViewCtr;
    /* access modifiers changed from: private */
    public Runnable mOneMinuteRunnable = new Runnable() {
        public void run() {
            int i;
            if (LivePlayBackPluginDriver.this.mPlayerViewCtr != null) {
                IJKPlayer player = LivePlayBackPluginDriver.this.mPlayerViewCtr.getPlayer();
                int i2 = 0;
                if (player != null) {
                    long longValue = player.getCurrentPosition().longValue();
                    long longValue2 = player.getDuration().longValue();
                    int i3 = longValue2 > 0 ? (int) ((longValue * 100) / longValue2) : 0;
                    if (!player.isPause()) {
                        i2 = 1;
                    }
                    i = i2;
                    i2 = i3;
                } else {
                    i = 0;
                }
                LiveTrack.hw_student_playback_duration(LivePlayBackPluginDriver.this.mTeacherId, LivePlayBackPluginDriver.this.mTeacherName, i2, i);
            }
            LivePlayBackPluginDriver.this.mHandler.postDelayed(LivePlayBackPluginDriver.this.mOneMinuteRunnable, NetWorkUtils.MINUTE);
        }
    };
    /* access modifiers changed from: private */
    public BaseLivePlayBackPlayerViewCtr mPlayerViewCtr;
    private int mProtocol;
    private Timer mSeiTimer;
    private String mStreamId;
    private String mStreamUrl;
    private List<AddressBean> mStreamUrlList = new ArrayList();
    private PlayBackSwitchLineDialog mSwitchLineDialog = null;
    /* access modifiers changed from: private */
    public String mTeacherId = EnterRoomMuteData.STATUS_UN_MUTE;
    /* access modifiers changed from: private */
    public String mTeacherName = "";
    private String userId = "";

    public void onHWRenderFailed() {
    }

    public void onMessage(String str, String str2) {
    }

    public void serverList(int i, int i2, List<String> list) {
    }

    public LivePlayBackPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        String str;
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        EnterConfigProxy enterConfig = iLiveRoomProvider.getDataStorage().getEnterConfig();
        this.liveTypeId = ParseUtils.tryParseInt(enterConfig.getLiveTypeId(), 0);
        UserInfoProxy userInfo = iLiveRoomProvider.getDataStorage().getUserInfo();
        String appId = enterConfig.getAppId();
        String appKey = enterConfig.getAppKey();
        if (userInfo != null) {
            this.userId = userInfo.getId();
            str = userInfo.getName();
        } else {
            str = "";
        }
        try {
            this.mTeacherId = iLiveRoomProvider.getDataStorage().getTeacherInfo().getId();
            this.mTeacherName = iLiveRoomProvider.getDataStorage().getTeacherInfo().getName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mPlayerViewCtr = new TripleScreenPlayBackPlayerViewCtr(this.mContext, appId, appKey, this.userId, this.liveTypeId);
        LivePlayBackLoadingViewCtr livePlayBackLoadingViewCtr = new LivePlayBackLoadingViewCtr(this.mContext);
        this.mLoadingViewCtr = livePlayBackLoadingViewCtr;
        livePlayBackLoadingViewCtr.setPlayBackPlayerCtr(this.mPlayerViewCtr);
        this.mLoadingViewCtr.setPlaybackLoadingListen(new LivePlayBackPluginDriver$$ExternalSyntheticLambda1(this));
        iLiveRoomProvider.addFrameworkRequestCallBack(this);
        LivePlaybackLagTipsView livePlaybackLagTipsView = new LivePlaybackLagTipsView(this.mContext);
        this.mLagTipsView = livePlaybackLagTipsView;
        livePlaybackLagTipsView.setTipsClickListen(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, LivePlayBackPluginDriver.class);
                LivePlayBackPluginDriver.this.hideLagTipView();
                LivePlayBackPluginDriver.this.lambda$new$0$LivePlayBackPluginDriver();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.mLagTipsView.setVisibility(8);
        this.mPlayerViewCtr.initView(this, iLiveRoomProvider, this.mPluginConfData.getViewLevel("video"));
        this.mLoadingViewCtr.initView(this, iLiveRoomProvider, this.mPluginConfData.getViewLevel("loading"));
        iLiveRoomProvider.addView(this, this.mLagTipsView, this.mPluginConfData.getViewLevel("loadingLag"), LiveAreaContext.get().getScreenLp().newLp());
        PluginEventBus.register(this, "video_shot", this);
        PluginEventBus.register(this, "media_player", this);
        PluginEventBus.register(this, DataBusKey.SHOW_PLAYBACK_SWITCH_LINE, this);
        this.mStreamId = iLiveRoomProvider.getDataStorage().getEnterConfig().getFileId();
        if (iLiveRoomProvider.getDataStorage().getPlaybackUrlResp() != null) {
            this.mStreamUrlList = iLiveRoomProvider.getDataStorage().getPlaybackUrlResp().list;
        }
        List<AddressBean> list = this.mStreamUrlList;
        if (list == null || list.isEmpty()) {
            this.mStreamUrl = "";
        } else {
            this.mStreamUrl = this.mStreamUrlList.get(0).address;
        }
        this.mProtocol = iLiveRoomProvider.getDataStorage().getEnterConfig().getProtocol();
        ShareDataManager instance = ShareDataManager.getInstance();
        this.mCurrentPosition = instance.getFloat(SP_PLAY_PROGRESS_KEY + this.mStreamId, 0.0f, ShareDataManager.SHAREDATA_USER);
        this.mPlayerViewCtr.setUserInfo(str, this.userId);
        startPlay();
        this.mHandler.postDelayed(this.mOneMinuteRunnable, NetWorkUtils.MINUTE);
    }

    private void startPlay() {
        Tag tag = TAG;
        XesLog.i(tag, "播放地址：mStreamUrl=" + this.mStreamUrl + "，mStreamUrlList=" + GsonUtil.getInstance().objToJson(this.mStreamUrlList));
        this.mPlayerViewCtr.initPlayer(this);
        this.mPlayerViewCtr.startPlay(this.mStreamId, this.mProtocol, this.mCurrentPosition, this.mStreamUrl, this.mStreamUrlList);
        PlayerEventBus.playerOnStart(LivePlayBackPluginDriver.class);
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    public void onVideoSizeChanged(int i, int i2) {
        Tag tag = TAG;
        XesLog.i(tag, "onVideoSizeChanged width = " + i + " height = " + i2);
    }

    public void onOpenStart() {
        Tag tag = TAG;
        XesLog.i(tag, "onOpenStart");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("onOpenStart", "");
        XesLog.ut((XesLogTag) tag, jsonObject);
        this.mLoadingViewCtr.onOpenStart();
    }

    public void onOpenSuccess() {
        Tag tag = TAG;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("onOpenSuccess 当前静音状态:");
        sb.append(this.isMute ? "开启静音" : "关闭静音");
        objArr[0] = sb.toString();
        XesLog.i(tag, objArr);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("onOpenSuccess", "");
        XesLog.ut((XesLogTag) tag, jsonObject);
        this.isError = false;
        this.mPlayerViewCtr.setVolume(this.isMute ? 0.0f : 1.0f);
        this.mLoadingViewCtr.onPlaySuccess();
        this.mLiveRoomProvider.showActivityLoading(false);
        if (this.mIsOnPause) {
            this.mPlayerViewCtr.pausePlay();
        }
        startListenSei();
        this.mLiveRoomProvider.doPlaying(this.mPlayerViewCtr.getCurrentPosition(), this.mPlayerViewCtr.getDuration());
        LeanplumUtil.commonTrack(LeanplumUtil.success_video_playback, LeanplumUtil.trackMap());
        long currentTimeMillis = System.currentTimeMillis() - ShareDataManager.getInstance().getLong(ShareDataKey.PLAYBACK_START_TIME, 0, ShareDataManager.SHAREDATA_USER);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("streamUrl", this.mStreamUrl);
        jsonObject2.addProperty("playbackStatus", "1");
        jsonObject2.addProperty("playbackLoadTotalTime", Long.valueOf(currentTimeMillis / 1000));
        XesLog.ut("playbackLoad", jsonObject2);
        if (this.isFirstOpenSuccess) {
            LiveTrack.playbackLoadDuration(System.currentTimeMillis() - LiveTrackData.mEnterTime);
        }
    }

    public void onOpenFailed(MediaErrorInfo mediaErrorInfo) {
        Class<LivePlayBackPluginDriver> cls = LivePlayBackPluginDriver.class;
        Tag tag = TAG;
        XesLog.i(tag, "onOpenFailed error info = " + mediaErrorInfo.getMPlayerErrorCode() + " msg = " + mediaErrorInfo.getMErrorMsg());
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("onOpenFailed", "onOpenFailed error info = " + mediaErrorInfo.getMPlayerErrorCode() + " msg = " + mediaErrorInfo.getMErrorMsg());
        XesLog.ut((XesLogTag) tag, jsonObject);
        this.isFirstOpenSuccess = false;
        ShareDataManager instance = ShareDataManager.getInstance();
        instance.put(SP_PLAY_PROGRESS_KEY + this.mStreamId, this.mCurrentPosition, ShareDataManager.SHAREDATA_USER);
        this.mLiveRoomProvider.showActivityLoading(false);
        this.mLoadingViewCtr.onPlayFail(mediaErrorInfo);
        this.isError = true;
        PlayerEventBus.playerOnPause(cls);
        PlayerEventBus.playerOnError(cls);
        LeanplumUtil.commonTrack(LeanplumUtil.failed_video_playback, LeanplumUtil.trackMap());
        long currentTimeMillis = System.currentTimeMillis() - ShareDataManager.getInstance().getLong(ShareDataKey.PLAYBACK_START_TIME, 0, ShareDataManager.SHAREDATA_USER);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("streamUrl", this.mStreamUrl);
        jsonObject2.addProperty("playbackStatus", EnterRoomMuteData.STATUS_UN_MUTE);
        jsonObject2.addProperty("playbackLoadTotalTime", Long.valueOf(currentTimeMillis / 1000));
        XesLog.ut("playbackLoad", jsonObject2);
        this.mIsCanToastNetSlow = true;
    }

    public void onBufferStart() {
        Tag tag = TAG;
        XesLog.i(tag, "onBufferStart");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("onBufferStart", "");
        XesLog.ut((XesLogTag) tag, jsonObject);
        this.isError = false;
        this.mLoadingViewCtr.onBufferStart();
    }

    public void onBufferComplete() {
        Tag tag = TAG;
        XesLog.i(tag, "onBufferComplete");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("onBufferComplete", "");
        XesLog.ut((XesLogTag) tag, jsonObject);
        this.mLoadingViewCtr.onBufferComplete();
        this.mIsCanToastNetSlow = true;
    }

    public void onPlaybackComplete() {
        Tag tag = TAG;
        XesLog.i(tag, "onPlaybackComplete");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("onPlaybackComplete", "");
        XesLog.ut((XesLogTag) tag, jsonObject);
        ShareDataManager instance = ShareDataManager.getInstance();
        instance.put(SP_PLAY_PROGRESS_KEY + this.mStreamId, 0, ShareDataManager.SHAREDATA_USER);
        this.mCurrentPosition = 0.0f;
        this.mLoadingViewCtr.onComplete();
        this.mLiveRoomProvider.doPlaying(this.mPlayerViewCtr.getDuration(), this.mPlayerViewCtr.getDuration());
        PlayerEventBus.playerOnComplete(LivePlayBackPluginDriver.class);
        this.mIsCanToastNetSlow = true;
    }

    public void onCloseStart() {
        Tag tag = TAG;
        XesLog.i(tag, "onCloseStart");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("onCloseStart", "");
        XesLog.ut((XesLogTag) tag, jsonObject);
        if (this.isStartSei) {
            stopListenSei();
        }
    }

    public void onCloseComplete() {
        Tag tag = TAG;
        XesLog.i(tag, "onCloseComplete");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("onCloseComplete", "");
        XesLog.ut((XesLogTag) tag, jsonObject);
        ShareDataManager instance = ShareDataManager.getInstance();
        instance.put(SP_PLAY_PROGRESS_KEY + this.mStreamId, this.mCurrentPosition, ShareDataManager.SHAREDATA_USER);
        PlayerEventBus.playerOnStop(LivePlayBackPluginDriver.class);
    }

    public void onPlaying(long j, long j2) {
        this.mLiveRoomProvider.doPlaying(j, j2);
        this.mCurrentPosition = (float) j;
        startListenSei();
        BaseLivePlayBackPlayerViewCtr baseLivePlayBackPlayerViewCtr = this.mPlayerViewCtr;
        if (baseLivePlayBackPlayerViewCtr != null && this.mIsCanToastNetSlow) {
            long hasBufferingTime = baseLivePlayBackPlayerViewCtr.getHasBufferingTime();
            if (this.mPlayerViewCtr.isCanShowLoadingTips() && hasBufferingTime > this.mPlayerViewCtr.getTipsTimeoutMax()) {
                this.mIsCanToastNetSlow = false;
                XesLog.i(TAG, "当前已经卡顿5秒了");
                showLagTips();
            }
        }
    }

    public void onPlayError() {
        Tag tag = TAG;
        XesLog.i(tag, "onPlayError");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("onPlayError", "");
        XesLog.ut((XesLogTag) tag, jsonObject);
        this.isFirstOpenSuccess = false;
        this.mLoadingViewCtr.onPlayError();
        ShareDataManager instance = ShareDataManager.getInstance();
        instance.put(SP_PLAY_PROGRESS_KEY + this.mStreamId, this.mCurrentPosition, ShareDataManager.SHAREDATA_USER);
        stopListenSei();
        this.isError = true;
        PlayerEventBus.playerOnPause(LivePlayBackPluginDriver.class);
    }

    public void onPaused() {
        XesLog.i(TAG, "onPaused");
        stopListenSei();
        PlayerEventBus.playerOnPause(LivePlayBackPluginDriver.class);
    }

    private synchronized void startListenSei() {
        if (!this.isStartSei) {
            this.isStartSei = true;
            Timer timer = new Timer();
            this.mSeiTimer = timer;
            timer.schedule(new TimerTask() {
                public void run() {
                    if (LivePlayBackPluginDriver.this.mPlayerViewCtr.getCurrentSeiTimetamp() != -1) {
                        LivePlayBackPluginDriver.this.mLiveRoomProvider.doSeiCurrent(LivePlayBackPluginDriver.this.mPlayerViewCtr.getCurrentSeiTimetamp());
                        LivePlayBackPluginDriver livePlayBackPluginDriver = LivePlayBackPluginDriver.this;
                        livePlayBackPluginDriver.findMutePoint(livePlayBackPluginDriver.mPlayerViewCtr.getCurrentSeiTimetamp());
                    }
                }
            }, 0, 66);
        }
    }

    /* access modifiers changed from: private */
    public void findMutePoint(long j) {
        if (!this.beginTimestamps.isEmpty()) {
            boolean z = true;
            int size = this.beginTimestamps.size() - 1;
            while (true) {
                if (size < 0) {
                    size = -1;
                    break;
                } else if (j > this.beginTimestamps.get(size).timestamp.longValue()) {
                    break;
                } else {
                    size--;
                }
            }
            if (size > -1) {
                VideoPrivateBean videoPrivateBean = this.beginTimestamps.get(size);
                if (TextUtils.equals(videoPrivateBean.userId, this.userId)) {
                    setMute(false);
                } else if (videoPrivateBean.pub.booleanValue()) {
                    if (j - videoPrivateBean.timestamp.longValue() >= 3000) {
                        z = false;
                    }
                    setMute(Boolean.valueOf(z));
                } else {
                    setMute(false);
                }
            } else {
                setMute(false);
            }
        }
    }

    private void setMute(Boolean bool) {
        if (this.isMute != bool.booleanValue()) {
            this.isMute = bool.booleanValue();
            Tag tag = TAG;
            Object[] objArr = new Object[1];
            objArr[0] = bool.booleanValue() ? "开启静音" : "关闭静音";
            XesLog.i(tag, objArr);
            ThreadUtils.runOnUiThread(new LivePlayBackPluginDriver$$ExternalSyntheticLambda2(this, bool));
        }
    }

    public /* synthetic */ void lambda$setMute$1$LivePlayBackPluginDriver(Boolean bool) {
        BaseLivePlayBackPlayerViewCtr baseLivePlayBackPlayerViewCtr = this.mPlayerViewCtr;
        if (baseLivePlayBackPlayerViewCtr != null) {
            baseLivePlayBackPlayerViewCtr.setVolume(bool.booleanValue() ? 0.0f : 1.0f);
            this.mPlayerViewCtr.showHelpTitle(bool.booleanValue());
        }
    }

    private synchronized void stopListenSei() {
        if (this.isStartSei) {
            this.isStartSei = false;
            Timer timer = this.mSeiTimer;
            if (timer != null) {
                timer.cancel();
                this.mSeiTimer.purge();
                this.mSeiTimer = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLifecycleResume(LifecycleOwner lifecycleOwner) {
        LivePlayBackPluginDriver.super.onLifecycleResume(lifecycleOwner);
        this.mIsOnPause = false;
        BaseLivePlayBackPlayerViewCtr baseLivePlayBackPlayerViewCtr = this.mPlayerViewCtr;
        if (baseLivePlayBackPlayerViewCtr != null) {
            baseLivePlayBackPlayerViewCtr.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onLifecyclePause(LifecycleOwner lifecycleOwner) {
        LivePlayBackPluginDriver.super.onLifecyclePause(lifecycleOwner);
        this.mIsOnPause = true;
        BaseLivePlayBackPlayerViewCtr baseLivePlayBackPlayerViewCtr = this.mPlayerViewCtr;
        if (baseLivePlayBackPlayerViewCtr != null) {
            baseLivePlayBackPlayerViewCtr.onPause(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onLifecycleDestroy(LifecycleOwner lifecycleOwner) {
        LivePlayBackPluginDriver.super.onLifecycleDestroy(lifecycleOwner);
        ShareDataManager instance = ShareDataManager.getInstance();
        instance.put(SP_PLAY_PROGRESS_KEY + this.mStreamId, this.mCurrentPosition, ShareDataManager.SHAREDATA_USER);
        BaseLivePlayBackPlayerViewCtr baseLivePlayBackPlayerViewCtr = this.mPlayerViewCtr;
        if (baseLivePlayBackPlayerViewCtr != null) {
            baseLivePlayBackPlayerViewCtr.onDestroy();
        }
        PluginEventBus.unregister("video_shot", this);
        PluginEventBus.unregister("media_player", this);
        PluginEventBus.unregister(DataBusKey.SHOW_PLAYBACK_SWITCH_LINE, this);
    }

    public void onChanged(PluginEventData pluginEventData) {
        Class<LivePlayBackPluginDriver> cls = LivePlayBackPluginDriver.class;
        if (this.mPlayerViewCtr != null) {
            String operation = pluginEventData.getOperation();
            operation.hashCode();
            char c = 65535;
            switch (operation.hashCode()) {
                case -1780607874:
                    if (operation.equals("player_change_progress")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1571166723:
                    if (operation.equals(DataBusKey.SHOW_PLAYBACK_SWITCH_LINE)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1466478990:
                    if (operation.equals("player_toggle")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1337706602:
                    if (operation.equals("player_change_speed")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1013162892:
                    if (operation.equals("player_change_mode")) {
                        c = 4;
                        break;
                    }
                    break;
                case 87144216:
                    if (operation.equals("player_pause")) {
                        c = 5;
                        break;
                    }
                    break;
                case 369569446:
                    if (operation.equals("video_shot_operation")) {
                        c = 6;
                        break;
                    }
                    break;
                case 557010386:
                    if (operation.equals("player_play")) {
                        c = 7;
                        break;
                    }
                    break;
                case 557107872:
                    if (operation.equals("player_stop")) {
                        c = 8;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    long j = 0;
                    try {
                        j = new JSONObject(pluginEventData.getData()).optLong("position");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (!this.isError) {
                        this.mPlayerViewCtr.seekTo(j, true);
                        return;
                    } else {
                        this.mLiveRoomProvider.doPlaying((long) this.mCurrentPosition, this.mPlayerViewCtr.getDuration());
                        return;
                    }
                case 1:
                    XesLog.i(TAG, "收到点击顶部切换回放线路按钮的消息");
                    lambda$new$0$LivePlayBackPluginDriver();
                    return;
                case 2:
                    if (this.mPlayerViewCtr.isPlaying()) {
                        this.mPlayerViewCtr.pausePlay();
                        return;
                    } else if (!this.isError) {
                        this.mPlayerViewCtr.reStartPlay();
                        return;
                    } else {
                        PlayerEventBus.playerOnPause(cls);
                        return;
                    }
                case 3:
                    float f = 1.0f;
                    try {
                        f = (float) new JSONObject(pluginEventData.getData()).optDouble("speed");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.mPlayerViewCtr.setSpeed(f);
                    ToastUtils.showLong((CharSequence) String.format(this.mContext.getResources().getString(R.string.play_speed), new Object[]{"" + f}));
                    return;
                case 4:
                    String str = this.mStreamId;
                    int i = this.mProtocol;
                    try {
                        JSONObject jSONObject = new JSONObject(pluginEventData.getData());
                        str = jSONObject.optString("streamId", this.mStreamId);
                        i = jSONObject.optInt("protocol", this.mProtocol);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    String str2 = this.mStreamId;
                    if (str2 != null && !str2.equals(str)) {
                        this.mPlayerViewCtr.changeMode(str, i, ShareDataManager.getInstance().getFloat(SP_PLAY_PROGRESS_KEY + str, 0.0f, ShareDataManager.SHAREDATA_USER));
                        this.mStreamId = str;
                        this.mProtocol = i;
                        return;
                    }
                    return;
                case 5:
                    this.mPlayerViewCtr.pausePlay();
                    return;
                case 6:
                    if (this.isGetBitmap) {
                        this.isGetBitmap = false;
                        getVideoBitmap();
                        return;
                    }
                    return;
                case 7:
                    if (!this.isError) {
                        this.mPlayerViewCtr.reStartPlay();
                        return;
                    } else {
                        PlayerEventBus.playerOnPause(cls);
                        return;
                    }
                case 8:
                    this.mPlayerViewCtr.stopPlay();
                    return;
                default:
                    return;
            }
        }
    }

    private void getVideoBitmap() {
        BaseLivePlayBackPlayerViewCtr baseLivePlayBackPlayerViewCtr = this.mPlayerViewCtr;
        if (baseLivePlayBackPlayerViewCtr != null && baseLivePlayBackPlayerViewCtr.getTextureView() != null) {
            PlayerTextureView textureView = this.mPlayerViewCtr.getTextureView();
            if (!this.isGetBitmap && textureView != null) {
                saveAndSendBitmap(textureView.getBitmap());
                this.isGetBitmap = true;
            }
        }
    }

    public void onMetaDataRequestSuccess() {
        List<MetaDataEvent> event = this.mLiveRoomProvider.getDataStorage().getMetadataResp().getEvent();
        Tag tag = TAG;
        XesLog.i(tag, "metaData event " + event.size());
        buildCourseWarePoints(event);
    }

    private void buildCourseWarePoints(List<MetaDataEvent> list) {
        if (!ListUtil.isEmpty(list)) {
            for (MetaDataEvent next : list) {
                String ircType = next.getIrcType();
                try {
                    if ("graffiti_board_video".equals(ircType)) {
                        JSONObject jSONObject = new JSONObject(new JSONObject(next.getProperties()).optString(ircType));
                        VideoPrivateBean videoPrivateBean = (VideoPrivateBean) GsonUtil.getInstance().fromJson(jSONObject.optString(ircType), VideoPrivateBean.class);
                        videoPrivateBean.timestamp = Long.valueOf(jSONObject.optLong("endTime", 0));
                        this.beginTimestamps.add(videoPrivateBean);
                    }
                } catch (JSONException e) {
                    Tag tag = TAG;
                    XesLog.e(tag, "视频私聊metadata 解析失败==" + e.getMessage());
                    e.printStackTrace();
                }
            }
            Tag tag2 = TAG;
            XesLog.s(tag2, "视频私聊metadata数据 装载成功== " + this.beginTimestamps.size());
        }
    }

    private void saveAndSendBitmap(Bitmap bitmap) {
        File file = new File(PathUtils.getCachePathExternalFirst(), "xueersi/screenshots");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "xueersi" + System.currentTimeMillis() + ".jpg");
        ImageUtils.save(bitmap, file2, Bitmap.CompressFormat.JPEG);
        sendEvent(file2);
        bitmap.recycle();
    }

    private void sendEvent(File file) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (file != null) {
                jSONObject.put("path", file.getAbsolutePath());
            } else {
                jSONObject.put("path", "");
            }
            jSONObject.put("left", LiveAreaContext.get().getHeadLp().left);
            jSONObject.put("top", LiveAreaContext.get().getHeadLp().top);
            jSONObject.put("right", ((LiveAreaContext.get().getHeadLp().height * 4) / 3) + LiveAreaContext.get().getHeadLp().left);
            jSONObject.put("bottom", LiveAreaContext.get().getHeadLp().top + LiveAreaContext.get().getHeadLp().height);
            PluginEventBus.onEvent("video_bitmap", new PluginEventData(LivePlayBackPluginDriver.class, "video_bitmap_operation", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showSwitchLineDialog */
    public void lambda$new$0$LivePlayBackPluginDriver() {
        if (this.mSwitchLineDialog == null && this.mContext != null) {
            PlayBackSwitchLineDialog playBackSwitchLineDialog = new PlayBackSwitchLineDialog(this.mContext);
            this.mSwitchLineDialog = playBackSwitchLineDialog;
            playBackSwitchLineDialog.setOnSwitchListen(new LivePlayBackPluginDriver$$ExternalSyntheticLambda0(this));
        }
        BaseLivePlayBackPlayerViewCtr baseLivePlayBackPlayerViewCtr = this.mPlayerViewCtr;
        int currentUrlIndex = baseLivePlayBackPlayerViewCtr != null ? baseLivePlayBackPlayerViewCtr.getCurrentUrlIndex() : 0;
        if (this.mSwitchLineDialog != null) {
            List<AddressBean> list = this.mStreamUrlList;
            if (list == null) {
                XesLog.e(TAG, "切换线路失败，线路列表为空");
            } else if (list.size() > 0) {
                this.mSwitchLineDialog.setData(this.mStreamUrlList, currentUrlIndex);
                this.mSwitchLineDialog.show();
            } else {
                XesLog.e(TAG, "切换线路失败，线路列表长度为0");
            }
        }
    }

    public /* synthetic */ void lambda$showSwitchLineDialog$2$LivePlayBackPluginDriver(int i) {
        BaseLivePlayBackPlayerViewCtr baseLivePlayBackPlayerViewCtr = this.mPlayerViewCtr;
        if (baseLivePlayBackPlayerViewCtr == null) {
            return;
        }
        if (baseLivePlayBackPlayerViewCtr.getCurrentUrlIndex() == i) {
            XesLog.i(TAG, "相同线路无需切换");
            return;
        }
        this.mPlayerViewCtr.switchPlayUrl(i, this.mCurrentPosition);
    }

    private void showLagTips() {
        this.mHandler.removeMessages(100);
        this.mLagTipsView.setVisibility(0);
        this.mHandler.sendEmptyMessageDelayed(100, 4000);
    }

    /* access modifiers changed from: private */
    public void hideLagTipView() {
        this.mLagTipsView.setVisibility(8);
    }
}
