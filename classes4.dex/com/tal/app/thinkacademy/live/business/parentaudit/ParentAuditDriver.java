package com.tal.app.thinkacademy.live.business.parentaudit;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcUserState;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.irc.entity.MsgBean;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(classType = 10086, desc = "家长旁听自己孩子反显", ircType = {"raise_hand", "send_emoji"}, launchType = "initmodule", moduleId = "3009")
@ViewLevels({@ViewLevel(level = 101, name = "ParentAudit")})
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020!H\u0016J\u001c\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\b2\b\u0010.\u001a\u0004\u0018\u00010\bH\u0016J\u001e\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u00102\f\u00101\u001a\b\u0012\u0002\b\u0003\u0018\u000102H\u0002J\u0010\u00103\u001a\u00020!2\u0006\u00100\u001a\u00020\u0010H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/parentaudit/ParentAuditDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "mClassType", "", "mContext", "Landroid/content/Context;", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mIsPad", "", "mMyChildInfo", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "mPluginView", "Lcom/tal/app/thinkacademy/live/business/parentaudit/BaseParentAuditPluginView;", "mRtcViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "mUserInfoProxy", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "getMUserInfoProxy", "()Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "setMUserInfoProxy", "(Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;)V", "observerOtherUserLevel", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/live/core/plugin/PluginEventData;", "bindSurfaceView", "", "bean", "getMyChildInfo", "getViewLayoutParam", "Landroid/widget/FrameLayout$LayoutParams;", "isChildStudent", "uid", "", "loadView", "observeListener", "onDestroy", "onMessage", "ircTypeKey", "message", "showEmoji", "show", "emojiBean", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiBean;", "showRaiseHand", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ParentAuditDriver.kt */
public final class ParentAuditDriver extends BaseLivePluginDriver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long EMOJI_DELAY_TIME = 3000;
    private static final int EMOJI_HIDE = 101;
    private static final long RAISE_HAND_DELAY_TIME = 10000;
    private static final int RAISE_HAND_HIDE = 100;
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.PARENT_AUDITOR;
    private static final String TARGET = "ParentAuditDriver.Observer";
    private String mClassType = EnterRoomMuteData.STATUS_UN_MUTE;
    private Context mContext;
    private final Handler mHandler = new ParentAuditDriver$mHandler$1(this, Looper.getMainLooper());
    private boolean mIsPad;
    /* access modifiers changed from: private */
    public final StudentVideoBean.ListBean mMyChildInfo;
    /* access modifiers changed from: private */
    public BaseParentAuditPluginView mPluginView;
    private RtcViewModel mRtcViewModel;
    private UserInfoProxy mUserInfoProxy;
    private Observer<PluginEventData> observerOtherUserLevel = new ParentAuditDriver$$ExternalSyntheticLambda1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ParentAuditDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        StudentVideoBean.ListBean listBean = new StudentVideoBean.ListBean();
        this.mMyChildInfo = listBean;
        Context context = (Context) this.mLiveRoomProvider.getWeakRefContext().get();
        this.mContext = context;
        if (context != null) {
            this.mIsPad = PadUtils.isPad(context);
        }
        String classType = this.mLiveRoomProvider.getClassType();
        Intrinsics.checkNotNullExpressionValue(classType, "mLiveRoomProvider.classType");
        this.mClassType = classType;
        this.mRtcViewModel = RtcViewModelKt.getRtcViewModel(AbilityPackKt.getAbilityPack());
        DataStorage dataStorage = iLiveRoomProvider.getDataStorage();
        SurfaceView surfaceView = null;
        this.mUserInfoProxy = dataStorage == null ? null : dataStorage.getUserInfo();
        getMyChildInfo();
        observeListener();
        loadView();
        PluginEventBus.register((LifecycleOwner) this, DataBusKey.SHOW_OTHER_LEVEL_KEY, this.observerOtherUserLevel);
        if (isChildStudent(listBean.getUserId())) {
            RtcViewModel rtcViewModel = this.mRtcViewModel;
            if (rtcViewModel != null) {
                rtcViewModel.startRemoteVideo(listBean.getUserId());
            }
            RtcViewModel rtcViewModel2 = this.mRtcViewModel;
            if (rtcViewModel2 != null) {
                rtcViewModel2.startRemoteAudio(listBean.getUserId());
            }
            BaseParentAuditPluginView baseParentAuditPluginView = this.mPluginView;
            if (baseParentAuditPluginView != null) {
                RtcViewModel rtcViewModel3 = this.mRtcViewModel;
                baseParentAuditPluginView.setMSurfaceView(rtcViewModel3 != null ? rtcViewModel3.getSurfaceView(listBean.getUserId()) : surfaceView);
            }
        }
        BaseParentAuditPluginView baseParentAuditPluginView2 = this.mPluginView;
        if (baseParentAuditPluginView2 != null) {
            baseParentAuditPluginView2.showChildInfo(listBean);
        }
        XesLog.s(TAG, "开始家长旁听");
    }

    public final UserInfoProxy getMUserInfoProxy() {
        return this.mUserInfoProxy;
    }

    public final void setMUserInfoProxy(UserInfoProxy userInfoProxy) {
        this.mUserInfoProxy = userInfoProxy;
    }

    public final Handler getMHandler() {
        return this.mHandler;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/parentaudit/ParentAuditDriver$Companion;", "", "()V", "EMOJI_DELAY_TIME", "", "EMOJI_HIDE", "", "RAISE_HAND_DELAY_TIME", "RAISE_HAND_HIDE", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "TARGET", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ParentAuditDriver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observerOtherUserLevel$lambda-1  reason: not valid java name */
    public static final void m352observerOtherUserLevel$lambda1(ParentAuditDriver parentAuditDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(parentAuditDriver, "this$0");
        if (pluginEventData != null) {
            try {
                JSONObject jSONObject = new JSONObject(pluginEventData.getData());
                String optString = jSONObject.optString("userId");
                String optString2 = jSONObject.optString("level");
                StudentVideoBean.ListBean listBean = new StudentVideoBean.ListBean();
                Intrinsics.checkNotNullExpressionValue(optString, "userId");
                listBean.setUserId(Long.parseLong(optString));
                if (parentAuditDriver.isChildStudent(listBean.getUserId())) {
                    try {
                        Intrinsics.checkNotNullExpressionValue(optString2, "level");
                        parentAuditDriver.mMyChildInfo.setLevel(Integer.parseInt(optString2));
                        BaseParentAuditPluginView baseParentAuditPluginView = parentAuditDriver.mPluginView;
                        if (baseParentAuditPluginView != null) {
                            baseParentAuditPluginView.showChildInfo(parentAuditDriver.mMyChildInfo);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private final void getMyChildInfo() {
        RtcUserState remoteState;
        UserInfoProxy userInfoProxy = this.mUserInfoProxy;
        if (userInfoProxy != null) {
            this.mMyChildInfo.setNickName(userInfoProxy.getNickName());
            this.mMyChildInfo.setAvatar(userInfoProxy.getAvatar());
            this.mMyChildInfo.setLevel(userInfoProxy.getLevel());
            StudentVideoBean.ListBean listBean = this.mMyChildInfo;
            String id = userInfoProxy.getId();
            Intrinsics.checkNotNullExpressionValue(id, "it.id");
            listBean.setUserId(Util.toLongOrDefault(id, 0));
        }
        RtcViewModel rtcViewModel = this.mRtcViewModel;
        if (rtcViewModel != null && (remoteState = rtcViewModel.getRemoteState(this.mMyChildInfo.getUserId())) != null) {
            this.mMyChildInfo.setStudentOnline(remoteState.getMIsOnline());
            this.mMyChildInfo.setOpenMic(remoteState.getMIsOpenMic());
            this.mMyChildInfo.setOpenCamera(remoteState.getMIsOpenCamera());
        }
    }

    /* access modifiers changed from: private */
    public final boolean isChildStudent(long j) {
        return j != 0 && j == this.mMyChildInfo.getUserId();
    }

    private final void observeListener() {
        ListenerData<RtcPlayerListenerBody> mRtcPlayerListener;
        RtcViewModel rtcViewModel = this.mRtcViewModel;
        if (rtcViewModel != null && (mRtcPlayerListener = rtcViewModel.getMRtcPlayerListener()) != null) {
            mRtcPlayerListener.observeListener((LifecycleOwner) this, false, TARGET, new ParentAuditDriver$observeListener$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void bindSurfaceView(StudentVideoBean.ListBean listBean) {
        SurfaceView mSurfaceView;
        RtcViewModel rtcViewModel;
        BaseParentAuditPluginView baseParentAuditPluginView;
        BaseParentAuditPluginView baseParentAuditPluginView2 = this.mPluginView;
        SurfaceView surfaceView = null;
        if ((baseParentAuditPluginView2 == null ? null : baseParentAuditPluginView2.getMSurfaceView()) == null && (baseParentAuditPluginView = this.mPluginView) != null) {
            RtcViewModel rtcViewModel2 = this.mRtcViewModel;
            if (rtcViewModel2 != null) {
                surfaceView = rtcViewModel2.getSurfaceView(listBean.getUserId());
            }
            baseParentAuditPluginView.setMSurfaceView(surfaceView);
        }
        BaseParentAuditPluginView baseParentAuditPluginView3 = this.mPluginView;
        if (baseParentAuditPluginView3 != null && (mSurfaceView = baseParentAuditPluginView3.getMSurfaceView()) != null && (rtcViewModel = this.mRtcViewModel) != null) {
            rtcViewModel.setUpRemoteVideo(mSurfaceView, listBean.getUserId());
        }
    }

    private final FrameLayout.LayoutParams getViewLayoutParam() {
        FrameLayout.LayoutParams newLp = LiveAreaContext.get().getHeadLp().newLp();
        String str = this.mClassType;
        if (Intrinsics.areEqual(str, "1")) {
            newLp = LiveAreaContext.get().getMsgLp().newLp();
            if (this.mIsPad) {
                newLp.height = SizeUtils.dp2px(95.0f);
                newLp.width /= 2;
            } else {
                newLp.height = (newLp.width * 3) / 4;
            }
        } else if (!Intrinsics.areEqual(str, "2")) {
            newLp = LiveAreaContext.get().getMsgLp().newLp();
            if (this.mIsPad) {
                newLp.height = SizeUtils.dp2px(95.0f);
                newLp.width /= 2;
            } else {
                newLp.height = (newLp.width * 3) / 4;
            }
        } else if (this.mIsPad) {
            newLp.setMarginStart(newLp.getMarginStart() + ((newLp.height * 4) / 3));
            newLp.height -= newLp.height / 76;
            newLp.width = (int) (((float) newLp.height) * LiveAreaCompat.getStudentStreamRate());
        } else {
            newLp.topMargin += newLp.height / 2;
            newLp.height /= 2;
        }
        Intrinsics.checkNotNullExpressionValue(newLp, "params");
        return newLp;
    }

    private final void loadView() {
        BaseParentAuditPluginView baseParentAuditPluginView;
        Context context = this.mContext;
        if (context != null) {
            String str = this.mClassType;
            if (Intrinsics.areEqual(str, "1")) {
                if (this.mIsPad) {
                    ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
                    Intrinsics.checkNotNullExpressionValue(iLiveRoomProvider, "mLiveRoomProvider");
                    baseParentAuditPluginView = new FalseSmallPadParentAuditView(context, iLiveRoomProvider);
                } else {
                    ILiveRoomProvider iLiveRoomProvider2 = this.mLiveRoomProvider;
                    Intrinsics.checkNotNullExpressionValue(iLiveRoomProvider2, "mLiveRoomProvider");
                    baseParentAuditPluginView = new SmallPhoneParentAuditView(context, iLiveRoomProvider2);
                }
            } else if (Intrinsics.areEqual(str, "2")) {
                if (this.mIsPad) {
                    ILiveRoomProvider iLiveRoomProvider3 = this.mLiveRoomProvider;
                    Intrinsics.checkNotNullExpressionValue(iLiveRoomProvider3, "mLiveRoomProvider");
                    baseParentAuditPluginView = new SmallPadParentAuditPluginView(context, iLiveRoomProvider3);
                } else {
                    ILiveRoomProvider iLiveRoomProvider4 = this.mLiveRoomProvider;
                    Intrinsics.checkNotNullExpressionValue(iLiveRoomProvider4, "mLiveRoomProvider");
                    baseParentAuditPluginView = new SmallPhoneParentAuditView(context, iLiveRoomProvider4);
                }
            } else if (this.mIsPad) {
                ILiveRoomProvider iLiveRoomProvider5 = this.mLiveRoomProvider;
                Intrinsics.checkNotNullExpressionValue(iLiveRoomProvider5, "mLiveRoomProvider");
                baseParentAuditPluginView = new BigPadParentAuditView(context, iLiveRoomProvider5);
            } else {
                ILiveRoomProvider iLiveRoomProvider6 = this.mLiveRoomProvider;
                Intrinsics.checkNotNullExpressionValue(iLiveRoomProvider6, "mLiveRoomProvider");
                baseParentAuditPluginView = new SmallPhoneParentAuditView(context, iLiveRoomProvider6);
            }
            this.mPluginView = baseParentAuditPluginView;
        }
        BaseLivePluginView baseLivePluginView = this.mPluginView;
        if (baseLivePluginView != null) {
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, baseLivePluginView, this.mPluginConfData.getViewLevel("ParentAudit"), getViewLayoutParam());
        }
        LiveAreaContext.get().layoutObserver.observe((LifecycleOwner) this, new ParentAuditDriver$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: loadView$lambda-9  reason: not valid java name */
    public static final void m351loadView$lambda9(ParentAuditDriver parentAuditDriver, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(parentAuditDriver, "this$0");
        BaseParentAuditPluginView baseParentAuditPluginView = parentAuditDriver.mPluginView;
        if (baseParentAuditPluginView != null) {
            baseParentAuditPluginView.setLayoutParams(parentAuditDriver.getViewLayoutParam());
        }
    }

    public void onMessage(String str, String str2) {
        long j = 0;
        MsgBean msgBean = null;
        if (Intrinsics.areEqual(DataBusKey.RAISE_HAND, str)) {
            try {
                msgBean = (MsgBean) GsonUtil.getInstance().fromJson(str2, new ParentAuditDriver$onMessage$type$1().getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (msgBean != null && msgBean.getFrom() != null) {
                Message.obtain();
                try {
                    String userId = msgBean.getFrom().getUserId();
                    Intrinsics.checkNotNullExpressionValue(userId, "msgBean.from.userId");
                    j = Long.parseLong(userId);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                if (isChildStudent(j)) {
                    showRaiseHand(true);
                }
            }
        } else if (Intrinsics.areEqual(DataBusKey.SEND_EMOJI, str)) {
            try {
                msgBean = (MsgBean) GsonUtil.getInstance().fromJson(str2, new ParentAuditDriver$onMessage$type$2().getType());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (msgBean != null && msgBean.getData() != null && msgBean.getFrom() != null) {
                try {
                    String userId2 = msgBean.getFrom().getUserId();
                    Intrinsics.checkNotNullExpressionValue(userId2, "msgBean.from.userId");
                    j = Long.parseLong(userId2);
                } catch (NumberFormatException e4) {
                    e4.printStackTrace();
                }
                if (isChildStudent(j)) {
                    showEmoji(true, (EmojiBean) msgBean.getData());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showRaiseHand(boolean z) {
        this.mHandler.removeMessages(100);
        this.mMyChildInfo.setRaiseHandUp(z);
        BaseParentAuditPluginView baseParentAuditPluginView = this.mPluginView;
        if (baseParentAuditPluginView != null) {
            baseParentAuditPluginView.showChildInfo(this.mMyChildInfo);
        }
        if (z) {
            this.mHandler.sendEmptyMessageDelayed(100, 10000);
        }
    }

    /* access modifiers changed from: private */
    public final void showEmoji(boolean z, EmojiBean<?> emojiBean) {
        this.mHandler.removeMessages(101);
        this.mMyChildInfo.setShowEmoji(z);
        this.mMyChildInfo.setEmojiBean(emojiBean);
        BaseParentAuditPluginView baseParentAuditPluginView = this.mPluginView;
        if (baseParentAuditPluginView != null) {
            baseParentAuditPluginView.showChildInfo(this.mMyChildInfo);
        }
        if (z) {
            this.mHandler.sendEmptyMessageDelayed(101, EMOJI_DELAY_TIME);
        }
    }

    public void onDestroy() {
        PluginEventBus.unregister(DataBusKey.SHOW_OTHER_LEVEL_KEY, this.observerOtherUserLevel);
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }
}
