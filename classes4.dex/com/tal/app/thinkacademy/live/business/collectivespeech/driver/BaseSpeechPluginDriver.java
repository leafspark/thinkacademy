package com.tal.app.thinkacademy.live.business.collectivespeech.driver;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.eaydu.omni.RTCEngine;
import com.tal.app.thinkacademy.common.entity.EmptyBean;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.player.rtcplayer.IRTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProviderUtils;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerEngineEventListener;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.collectivespeech.bean.SpeechChannelBean;
import com.tal.app.thinkacademy.live.business.collectivespeech.view.CollectiveSpeechView;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.RandomSpeechStudent;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.body.SubmitStartSpeechBody;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.body.WhoCanSpeakBody;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020\nH\u0002J\b\u0010?\u001a\u00020=H\u0002J\b\u0010@\u001a\u00020=H\u0016J\u001c\u0010A\u001a\u00020=2\b\u0010B\u001a\u0004\u0018\u00010\u00142\b\u0010C\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010D\u001a\u00020=H\u0002J\u0010\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020*H\u0002J\u0010\u0010G\u001a\u00020=2\u0006\u0010F\u001a\u00020*H\u0002J\b\u0010H\u001a\u00020=H\u0002J\b\u0010I\u001a\u00020=H\u0002J\b\u0010J\u001a\u00020=H\u0002J\b\u0010K\u001a\u00020=H\u0002J\u000e\u0010L\u001a\u00020=2\u0006\u0010M\u001a\u00020\nJ\b\u0010N\u001a\u00020=H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\"\u0010(\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010)j\n\u0012\u0004\u0012\u00020*\u0018\u0001`+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006O"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/collectivespeech/driver/BaseSpeechPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "isHadSentIt", "", "isOnDestroy", "isTimeOut", "isloadPlugin", "kCloseEncourage", "", "kCloseSpeech", "kNoSpeech", "kSpeechResult", "keyTag", "", "mClassId", "getMClassId", "()Ljava/lang/Integer;", "setMClassId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mCollectiveSpeechView", "Lcom/tal/app/thinkacademy/live/business/collectivespeech/view/CollectiveSpeechView;", "mContext", "Landroid/content/Context;", "mCourseInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;", "getMCourseInfo", "()Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;", "setMCourseInfo", "(Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;)V", "mHandler", "Landroid/os/Handler;", "mMaxVolume", "mOtherStudents", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mProvider", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/IRTCEngineProvider;", "mRTCEngineCallback", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/IRTCEngineProvider$RTCEngineCallback;", "mRtcEngine", "Lcom/eaydu/omni/RTCEngine;", "mRtcPlayerEngineEventListener", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayerEngineEventListener;", "mSpeechChannelBean", "Lcom/tal/app/thinkacademy/live/business/collectivespeech/bean/SpeechChannelBean;", "userInfoProxy", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "getUserInfoProxy", "()Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "setUserInfoProxy", "(Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;)V", "initEngine", "", "isHasPermission", "loadPlugin", "onDestroy", "onMessage", "ircTypeKey", "message", "pauseAllAudio", "playingAudioStart", "uid", "playingAudioStop", "pushAudioStart", "removePlugin", "reset", "submitStartSpeech", "updateGroupAudio", "isStart", "whoCanSpeak", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseSpeechPluginDriver.kt */
public class BaseSpeechPluginDriver extends BaseLivePluginDriver {
    /* access modifiers changed from: private */
    public final Tag TAG = Tag.BaseSpeechPluginDriver;
    /* access modifiers changed from: private */
    public boolean isHadSentIt;
    private boolean isOnDestroy;
    /* access modifiers changed from: private */
    public boolean isTimeOut;
    /* access modifiers changed from: private */
    public boolean isloadPlugin;
    /* access modifiers changed from: private */
    public final int kCloseEncourage = 1;
    /* access modifiers changed from: private */
    public final int kCloseSpeech = 2;
    /* access modifiers changed from: private */
    public final int kNoSpeech;
    /* access modifiers changed from: private */
    public final int kSpeechResult = 3;
    private final String keyTag = "BaseLivePluginDriver";
    private Integer mClassId = 0;
    /* access modifiers changed from: private */
    public CollectiveSpeechView mCollectiveSpeechView;
    /* access modifiers changed from: private */
    public Context mContext;
    private CourseInfoProxy mCourseInfo;
    private Handler mHandler = new BaseSpeechPluginDriver$mHandler$1(this, Looper.getMainLooper());
    /* access modifiers changed from: private */
    public int mMaxVolume;
    /* access modifiers changed from: private */
    public ArrayList<Long> mOtherStudents;
    private IRTCEngineProvider mProvider;
    private IRTCEngineProvider.RTCEngineCallback mRTCEngineCallback;
    /* access modifiers changed from: private */
    public RTCEngine mRtcEngine;
    private RtcPlayerEngineEventListener mRtcPlayerEngineEventListener;
    /* access modifiers changed from: private */
    public SpeechChannelBean mSpeechChannelBean;
    private UserInfoProxy userInfoProxy;

    public BaseSpeechPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        UserInfoProxy userInfoProxy2;
        CourseInfoProxy courseInfoProxy;
        DataStorage dataStorage;
        DataStorage dataStorage2;
        Integer num = null;
        if (iLiveRoomProvider != null) {
            WeakReference<Context> weakRefContext = iLiveRoomProvider.getWeakRefContext();
            this.mContext = weakRefContext == null ? null : (Context) weakRefContext.get();
        }
        if (iLiveRoomProvider == null || (dataStorage2 = iLiveRoomProvider.getDataStorage()) == null) {
            userInfoProxy2 = null;
        } else {
            userInfoProxy2 = dataStorage2.getUserInfo();
        }
        this.userInfoProxy = userInfoProxy2;
        if (iLiveRoomProvider == null || (dataStorage = iLiveRoomProvider.getDataStorage()) == null) {
            courseInfoProxy = null;
        } else {
            courseInfoProxy = dataStorage.getCourseInfo();
        }
        this.mCourseInfo = courseInfoProxy;
        this.mClassId = courseInfoProxy != null ? Integer.valueOf(courseInfoProxy.getClassId()) : num;
        initEngine();
    }

    /* access modifiers changed from: protected */
    public final UserInfoProxy getUserInfoProxy() {
        return this.userInfoProxy;
    }

    /* access modifiers changed from: protected */
    public final void setUserInfoProxy(UserInfoProxy userInfoProxy2) {
        this.userInfoProxy = userInfoProxy2;
    }

    /* access modifiers changed from: protected */
    public final CourseInfoProxy getMCourseInfo() {
        return this.mCourseInfo;
    }

    /* access modifiers changed from: protected */
    public final void setMCourseInfo(CourseInfoProxy courseInfoProxy) {
        this.mCourseInfo = courseInfoProxy;
    }

    /* access modifiers changed from: protected */
    public final Integer getMClassId() {
        return this.mClassId;
    }

    /* access modifiers changed from: protected */
    public final void setMClassId(Integer num) {
        this.mClassId = num;
    }

    private final void initEngine() {
        IRTCEngineProvider iRTCEngineProvider = RTCEngineProviderUtils.getInstance().get("Live");
        this.mProvider = iRTCEngineProvider;
        XesLog.i(this.TAG, Intrinsics.stringPlus("initEngine is : ", iRTCEngineProvider));
        this.mRTCEngineCallback = new BaseSpeechPluginDriver$initEngine$1(this);
        this.mRtcPlayerEngineEventListener = new BaseSpeechPluginDriver$initEngine$2(this);
        IRTCEngineProvider iRTCEngineProvider2 = this.mProvider;
        if (iRTCEngineProvider2 != null) {
            iRTCEngineProvider2.provide(BaseSpeechPluginDriverKt.SpeechPluginKey, this.mRTCEngineCallback);
        }
    }

    public void onMessage(String str, String str2) {
        CharSequence charSequence = str2;
        if (!(charSequence == null || StringsKt.isBlank(charSequence)) && Intrinsics.areEqual(BaseSpeechPluginDriverKt.SpeechPluginKey, str)) {
            XesLog.i(this.TAG, Intrinsics.stringPlus("ircTypeKey = ", str2));
            try {
                Intrinsics.checkNotNull(str2);
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject(str);
                if (optJSONObject != null) {
                    SpeechChannelBean speechChannelBean = (SpeechChannelBean) GsonUtils.fromJson(!(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject), SpeechChannelBean.class);
                    this.mSpeechChannelBean = speechChannelBean;
                    if (speechChannelBean != null) {
                        String str3 = null;
                        if (Intrinsics.areEqual(speechChannelBean.getPub(), true)) {
                            SpeechChannelBean speechChannelBean2 = this.mSpeechChannelBean;
                            if (speechChannelBean2 != null) {
                                str3 = speechChannelBean2.getInteractId();
                            }
                            InteractReportKt.XesLogReport$default("start", "Groupaudio", str3, (Integer) null, (String) null, 24, (Object) null);
                            reset();
                            String interactId = speechChannelBean.getInteractId();
                            String planId = speechChannelBean.getPlanId();
                            int parseInt = planId == null ? 0 : Integer.parseInt(planId);
                            Integer mClassId2 = getMClassId();
                            InteractLogReport.uploadLog(interactId, parseInt, mClassId2 == null ? 0 : mClassId2.intValue());
                            loadPlugin();
                            return;
                        }
                        SpeechChannelBean speechChannelBean3 = this.mSpeechChannelBean;
                        if (speechChannelBean3 != null) {
                            str3 = speechChannelBean3.getInteractId();
                        }
                        InteractReportKt.XesLogReport$default("end", "Groupaudio", str3, (Integer) null, (String) null, 24, (Object) null);
                        removePlugin();
                    }
                }
            } catch (Exception e) {
                XesLog.e(this.TAG, Intrinsics.stringPlus("mSpeechChannelBean --> ", e.getMessage()));
                onDestroy();
            }
        }
    }

    private final void reset() {
        IRTCEngineProvider iRTCEngineProvider = this.mProvider;
        if (iRTCEngineProvider != null) {
            iRTCEngineProvider.removeRtcEngineEventListener(this.keyTag);
        }
        CollectiveSpeechView collectiveSpeechView = this.mCollectiveSpeechView;
        if (collectiveSpeechView != null) {
            collectiveSpeechView.reset();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mMaxVolume = 0;
        this.isTimeOut = false;
        this.isHadSentIt = false;
    }

    private final void loadPlugin() {
        SpeechChannelBean speechChannelBean;
        Context context = this.mContext;
        if (context != null && (speechChannelBean = this.mSpeechChannelBean) != null) {
            this.isloadPlugin = true;
            if (this.mCollectiveSpeechView == null) {
                this.mCollectiveSpeechView = new CollectiveSpeechView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mCollectiveSpeechView, this.mPluginConfData.getViewLevel(BaseSpeechPluginDriverKt.SpeechPluginKey), LiveAreaContext.get().getPptLp().newLp());
            }
            XesLog.i(this.TAG, "loadPlugin ---> 加载成功");
            SoundPoolUtils.play(context, R.raw.live_business_speech_sound_start, 0);
            IRTCEngineProvider iRTCEngineProvider = this.mProvider;
            if (iRTCEngineProvider != null) {
                iRTCEngineProvider.addEtcEngineEventListener(this.keyTag, this.mRtcPlayerEngineEventListener);
            }
            pushAudioStart();
            whoCanSpeak();
            if (isHasPermission()) {
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(this.kNoSpeech, 3000);
                }
                CollectiveSpeechView collectiveSpeechView = this.mCollectiveSpeechView;
                if (collectiveSpeechView != null) {
                    collectiveSpeechView.loadView(true);
                }
                XesLog.i(this.TAG, "loadPlugin ---> 有权限");
            } else {
                CollectiveSpeechView collectiveSpeechView2 = this.mCollectiveSpeechView;
                if (collectiveSpeechView2 != null) {
                    collectiveSpeechView2.loadView(false);
                }
                XesLog.i(this.TAG, "loadPlugin ---> 没有权限");
            }
            LeanplumUtil.javaTrack(LeanplumUtil.show_speaktogether, Intrinsics.stringPlus("class_id=", getMClassId()), Intrinsics.stringPlus("interaction_id=", speechChannelBean.getInteractId()), Intrinsics.stringPlus("microphone_isopen=", Boolean.valueOf(isHasPermission())), Intrinsics.stringPlus("time=", Long.valueOf(System.currentTimeMillis())));
        }
    }

    private final void removePlugin() {
        String[] strArr = new String[3];
        strArr[0] = Intrinsics.stringPlus("class_id=", this.mClassId);
        SpeechChannelBean speechChannelBean = this.mSpeechChannelBean;
        strArr[1] = Intrinsics.stringPlus("interaction_id=", speechChannelBean == null ? null : speechChannelBean.getInteractId());
        strArr[2] = Intrinsics.stringPlus("time=", Long.valueOf(System.currentTimeMillis()));
        LeanplumUtil.javaTrack(LeanplumUtil.end_speaktogether, strArr);
        XesLog.i(this.TAG, "removePlugin ---> 移除插件");
        updateGroupAudio(false);
        pauseAllAudio();
        CollectiveSpeechView collectiveSpeechView = this.mCollectiveSpeechView;
        if (collectiveSpeechView != null) {
            collectiveSpeechView.removePlugin();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(this.kCloseSpeech, 0);
        }
    }

    private final void whoCanSpeak() {
        SpeechChannelBean speechChannelBean = this.mSpeechChannelBean;
        if (speechChannelBean != null) {
            GameApi gameApi = (GameApi) Api.create(GameApi.class);
            String stringPlus = Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/speech/student/whoCanSpeak");
            String planId = speechChannelBean.getPlanId();
            Long l = null;
            Long valueOf = planId == null ? null : Long.valueOf(Long.parseLong(planId));
            Integer mClassId2 = getMClassId();
            if (mClassId2 != null) {
                l = Long.valueOf((long) mClassId2.intValue());
            }
            Call<HiResponse<RandomSpeechStudent>> whoCanSpeak = gameApi.whoCanSpeak(stringPlus, new WhoCanSpeakBody(valueOf, l));
            Callback baseSpeechPluginDriver$whoCanSpeak$1$1 = new BaseSpeechPluginDriver$whoCanSpeak$1$1(this);
            if (!(whoCanSpeak instanceof Call)) {
                whoCanSpeak.enqueue(baseSpeechPluginDriver$whoCanSpeak$1$1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) whoCanSpeak, baseSpeechPluginDriver$whoCanSpeak$1$1);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void submitStartSpeech() {
        SpeechChannelBean speechChannelBean = this.mSpeechChannelBean;
        if (speechChannelBean != null) {
            GameApi gameApi = (GameApi) Api.create(GameApi.class);
            String stringPlus = Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/speech/student/submit");
            String planId = speechChannelBean.getPlanId();
            Long l = null;
            Long valueOf = planId == null ? null : Long.valueOf(Long.parseLong(planId));
            String interactId = speechChannelBean.getInteractId();
            Integer mClassId2 = getMClassId();
            if (mClassId2 != null) {
                l = Long.valueOf((long) mClassId2.intValue());
            }
            Call<HiResponse<EmptyBean>> submitStartSpeech = gameApi.submitStartSpeech(stringPlus, new SubmitStartSpeechBody(valueOf, interactId, l));
            Callback baseSpeechPluginDriver$submitStartSpeech$1$1 = new BaseSpeechPluginDriver$submitStartSpeech$1$1();
            if (!(submitStartSpeech instanceof Call)) {
                submitStartSpeech.enqueue(baseSpeechPluginDriver$submitStartSpeech$1$1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) submitStartSpeech, baseSpeechPluginDriver$submitStartSpeech$1$1);
            }
        }
    }

    public final void updateGroupAudio(boolean z) {
        PluginEventBus.onEvent(DataBusKey.UPDATE_GROUP_AUDIO, new PluginEventData(BaseSpeechPluginDriver.class, DataBusKey.UPDATE_GROUP_AUDIO, z ? "1" : EnterRoomMuteData.STATUS_UN_MUTE));
    }

    public void onDestroy() {
        this.isloadPlugin = false;
        this.isOnDestroy = true;
        this.mSpeechChannelBean = null;
        pauseAllAudio();
        CollectiveSpeechView collectiveSpeechView = this.mCollectiveSpeechView;
        if (collectiveSpeechView != null) {
            collectiveSpeechView.onDestroy();
        }
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null) {
            iLiveRoomProvider.removeView((View) this.mCollectiveSpeechView);
        }
        this.mCollectiveSpeechView = null;
        Handler handler = this.mHandler;
        if (handler != null) {
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            this.mHandler = null;
        }
        this.mMaxVolume = 0;
        this.isTimeOut = false;
        this.isHadSentIt = false;
        IRTCEngineProvider iRTCEngineProvider = this.mProvider;
        if (iRTCEngineProvider != null) {
            iRTCEngineProvider.removeRtcEngineEventListener(this.keyTag);
        }
        this.mRtcPlayerEngineEventListener = null;
        this.mRTCEngineCallback = null;
        this.mRtcEngine = null;
        this.mProvider = null;
        ILiveRoomProvider iLiveRoomProvider2 = this.mLiveRoomProvider;
        if (iLiveRoomProvider2 != null) {
            iLiveRoomProvider2.destroyPlugin((BaseLivePluginDriver) this);
        }
        this.mContext = null;
    }

    private final boolean isHasPermission() {
        return PermissionUtils.isGranted("android.permission.RECORD_AUDIO");
    }

    private final void pushAudioStart() {
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.muteLocalAudio(false);
        }
    }

    /* access modifiers changed from: private */
    public final void playingAudioStart(long j) {
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.muteRemoteAudio(j, false);
        }
    }

    private final void playingAudioStop(long j) {
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.muteRemoteAudio(j, true);
        }
    }

    private final void pauseAllAudio() {
        ArrayList<Long> arrayList = this.mOtherStudents;
        if (arrayList != null) {
            int i = 0;
            for (Object next : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                playingAudioStop(((Number) next).longValue());
                i = i2;
            }
        }
        ArrayList<Long> arrayList2 = this.mOtherStudents;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        this.mOtherStudents = null;
    }
}
