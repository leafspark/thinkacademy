package com.tal.app.thinkacademy.live.business.mediacontroller.live.delegate;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import com.tal.app.thinkacademy.live.business.exam.api.ExamApi;
import com.tal.app.thinkacademy.live.business.exam.bean.ExamInfo;
import com.tal.app.thinkacademy.live.business.exam.bean.ExamInfoBody;
import com.tal.app.thinkacademy.live.business.homework.api.HomeworkApi;
import com.tal.app.thinkacademy.live.business.homework.entity.PhotoBoxMessage;
import com.tal.app.thinkacademy.live.business.homework.entity.body.PlanIdBody;
import com.tal.app.thinkacademy.live.business.mediacontroller.EnableState;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.BaseMediaControlView;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlLiveDriver;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlSmallLiveViewPad;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u0013H\u0002J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0013H\u0002J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000b0\u000b0\nX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/mediacontroller/live/delegate/PadSmallClassBarDelegate;", "Lcom/tal/app/thinkacademy/live/business/mediacontroller/live/delegate/BaseClassRoomTitleBarDelegate;", "()V", "isAudition", "", "mRtcViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "mediaViewSmall", "Lcom/tal/app/thinkacademy/live/business/mediacontroller/live/MediaControlSmallLiveViewPad;", "observerHomework", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/live/core/plugin/PluginEventData;", "observerTakePhoto", "", "observerVideoCall", "kotlin.jvm.PlatformType", "getMediaView", "Lcom/tal/app/thinkacademy/live/business/mediacontroller/base/BaseMediaControlView;", "init", "", "context", "Landroid/content/Context;", "driver", "Lcom/tal/app/thinkacademy/live/business/mediacontroller/live/MediaControlLiveDriver;", "dataStorage", "Lcom/tal/app/thinkacademy/live/core/live/datastorage/DataStorage;", "isPad", "onDestroy", "onMessage", "ircTypeKey", "", "message", "registerEvent", "requestExamReport", "isShow", "requestNewMessage", "setSwitchEnable", "enable", "state", "Lcom/tal/app/thinkacademy/live/business/mediacontroller/EnableState;", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PadSmallClassBarDelegate.kt */
public final class PadSmallClassBarDelegate extends BaseClassRoomTitleBarDelegate {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXAM_INFO = "/api/hub/classroom/exam/examInfo";
    private static final String READ_NEW_MESSAGE_URL = "/classroom-hub/wall/student/readNewMessage";
    private boolean isAudition;
    private RtcViewModel mRtcViewModel;
    /* access modifiers changed from: private */
    public MediaControlSmallLiveViewPad mediaViewSmall;
    private Observer<PluginEventData> observerHomework = new PadSmallClassBarDelegate$$ExternalSyntheticLambda1(this);
    private Observer<Object> observerTakePhoto = new PadSmallClassBarDelegate$$ExternalSyntheticLambda2(this);
    private Observer<PluginEventData> observerVideoCall = new PadSmallClassBarDelegate$$ExternalSyntheticLambda0(this);

    /* access modifiers changed from: private */
    /* renamed from: observerVideoCall$lambda-0  reason: not valid java name */
    public static final void m340observerVideoCall$lambda0(PadSmallClassBarDelegate padSmallClassBarDelegate, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(padSmallClassBarDelegate, "this$0");
        Intrinsics.checkNotNullParameter(pluginEventData, "pluginEventData");
        String data = pluginEventData.getData();
        if (Intrinsics.areEqual(data, "videoCallStart") ? true : Intrinsics.areEqual(data, "videoCallOn")) {
            padSmallClassBarDelegate.setSwitchEnable(false, EnableState.TEACHER_LINK);
        } else {
            padSmallClassBarDelegate.setSwitchEnable(true, EnableState.TEACHER_LINK);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observerTakePhoto$lambda-1  reason: not valid java name */
    public static final void m339observerTakePhoto$lambda1(PadSmallClassBarDelegate padSmallClassBarDelegate, Object obj) {
        Intrinsics.checkNotNullParameter(padSmallClassBarDelegate, "this$0");
        if (obj == null) {
            return;
        }
        if (Intrinsics.areEqual("end", (String) obj)) {
            padSmallClassBarDelegate.setSwitchEnable(true, EnableState.CAMERA);
        } else {
            padSmallClassBarDelegate.setSwitchEnable(false, EnableState.CAMERA);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observerHomework$lambda-2  reason: not valid java name */
    public static final void m338observerHomework$lambda2(PadSmallClassBarDelegate padSmallClassBarDelegate, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(padSmallClassBarDelegate, "this$0");
        MediaControlSmallLiveViewPad mediaControlSmallLiveViewPad = padSmallClassBarDelegate.mediaViewSmall;
        if (mediaControlSmallLiveViewPad != null) {
            Intrinsics.checkNotNull(mediaControlSmallLiveViewPad);
            mediaControlSmallLiveViewPad.showHomeworkButton();
            padSmallClassBarDelegate.requestNewMessage();
        }
    }

    public void init(Context context, MediaControlLiveDriver mediaControlLiveDriver, DataStorage dataStorage, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaControlLiveDriver, "driver");
        Intrinsics.checkNotNullParameter(dataStorage, "dataStorage");
        super.init(context, mediaControlLiveDriver, dataStorage, z);
        this.mRtcViewModel = RtcViewModelKt.getRtcViewModel(AbilityPackKt.getAbilityPack());
        CourseInfoProxy courseInfo = dataStorage.getCourseInfo();
        boolean z2 = false;
        if (courseInfo != null && (courseInfo.getIsParentAuditLocal() || courseInfo.getIsAudition() == CourseInfo.ROLE_AUDITION)) {
            z2 = true;
        }
        this.isAudition = z2;
        if (!z2) {
            requestExamReport(true);
        }
        registerEvent();
    }

    private final void registerEvent() {
        ListenerData<RtcPlayerListenerBody> mRtcPlayerListener;
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        PluginEventBus.register(lifecycleOwner, DataBusKey.LIVE_MEDIA_SCREEN_SHOT, this.mDriver.observerScreenShot);
        PluginEventBus.register(lifecycleOwner, DataBusKey.VIDEO_CALL_STATUS, this.observerVideoCall);
        XesDataBus.with(DataBusKey.TAKE_PHOTO_STATE).observe(lifecycleOwner, this.observerTakePhoto);
        RtcViewModel rtcViewModel = this.mRtcViewModel;
        if (!(rtcViewModel == null || (mRtcPlayerListener = rtcViewModel.getMRtcPlayerListener()) == null)) {
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            mRtcPlayerListener.observeListener(lifecycleOwner, false, simpleName, new PadSmallClassBarDelegate$registerEvent$1(this));
        }
        PluginEventBus.register(lifecycleOwner, DataBusKey.SHOW_HOMEWORK_KEY, this.observerHomework);
    }

    public BaseMediaControlView getMediaView() {
        if (this.mediaViewSmall == null) {
            MediaControlSmallLiveViewPad mediaControlSmallLiveViewPad = new MediaControlSmallLiveViewPad(this.mContext, this.mDataStorage);
            this.mediaViewSmall = mediaControlSmallLiveViewPad;
            Intrinsics.checkNotNull(mediaControlSmallLiveViewPad);
            mediaControlSmallLiveViewPad.setIsAudition(this.isAudition);
            MediaControlSmallLiveViewPad mediaControlSmallLiveViewPad2 = this.mediaViewSmall;
            Intrinsics.checkNotNull(mediaControlSmallLiveViewPad2);
            mediaControlSmallLiveViewPad2.setDriver(this.mDriver);
        }
        MediaControlSmallLiveViewPad mediaControlSmallLiveViewPad3 = this.mediaViewSmall;
        Intrinsics.checkNotNull(mediaControlSmallLiveViewPad3);
        return mediaControlSmallLiveViewPad3;
    }

    public void onMessage(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "ircTypeKey");
        Intrinsics.checkNotNullParameter(str2, "message");
        if (TextUtils.equals(str, "auto_feedback")) {
            this.teacherFeedbackHelper.receiveIrcMessage(str2);
        }
    }

    private final void setSwitchEnable(boolean z, EnableState enableState) {
        MediaControlSmallLiveViewPad mediaControlSmallLiveViewPad = this.mediaViewSmall;
        if (mediaControlSmallLiveViewPad != null) {
            Intrinsics.checkNotNull(mediaControlSmallLiveViewPad);
            mediaControlSmallLiveViewPad.setStudentSwitchEnable(z, enableState);
        }
    }

    private final void requestNewMessage() {
        int tryParseInt = ParseUtils.tryParseInt(this.mDataStorage.getPlanInfo().getId(), 0);
        Call<HiResponse<PhotoBoxMessage>> newMessage = ((HomeworkApi) Api.create(HomeworkApi.class)).getNewMessage(Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), READ_NEW_MESSAGE_URL), new PlanIdBody(tryParseInt));
        Callback padSmallClassBarDelegate$requestNewMessage$1 = new PadSmallClassBarDelegate$requestNewMessage$1(this, new PadSmallClassBarDelegate$requestNewMessage$2());
        if (!(newMessage instanceof Call)) {
            newMessage.enqueue(padSmallClassBarDelegate$requestNewMessage$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) newMessage, padSmallClassBarDelegate$requestNewMessage$1);
        }
    }

    public void requestExamReport(boolean z) {
        int tryParseInt = ParseUtils.tryParseInt(this.mDataStorage.getPlanInfo().getId(), 0);
        Call<HiResponse<ExamInfo>> examInfo = ((ExamApi) Api.create(ExamApi.class)).getExamInfo(Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), EXAM_INFO), new ExamInfoBody(tryParseInt));
        Callback padSmallClassBarDelegate$requestExamReport$1 = new PadSmallClassBarDelegate$requestExamReport$1(z, this, new PadSmallClassBarDelegate$requestExamReport$2());
        if (!(examInfo instanceof Call)) {
            examInfo.enqueue(padSmallClassBarDelegate$requestExamReport$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) examInfo, padSmallClassBarDelegate$requestExamReport$1);
        }
    }

    public void onDestroy() {
        ListenerData<RtcPlayerListenerBody> mRtcPlayerListener;
        super.onDestroy();
        MediaControlSmallLiveViewPad mediaControlSmallLiveViewPad = this.mediaViewSmall;
        if (mediaControlSmallLiveViewPad != null) {
            Intrinsics.checkNotNull(mediaControlSmallLiveViewPad);
            mediaControlSmallLiveViewPad.onDestroy();
            this.mediaViewSmall = null;
        }
        PluginEventBus.unregister(DataBusKey.LIVE_MEDIA_SCREEN_SHOT, this.mDriver.observerScreenShot);
        PluginEventBus.unregister(DataBusKey.VIDEO_CALL_STATUS, this.observerVideoCall);
        XesDataBus.with(DataBusKey.TAKE_PHOTO_STATE).removeObserver(this.observerTakePhoto);
        RtcViewModel rtcViewModel = this.mRtcViewModel;
        if (!(rtcViewModel == null || (mRtcPlayerListener = rtcViewModel.getMRtcPlayerListener()) == null)) {
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            mRtcPlayerListener.removeListener(simpleName);
        }
        PluginEventBus.unregister(DataBusKey.SHOW_HOMEWORK_KEY, this.observerHomework);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/mediacontroller/live/delegate/PadSmallClassBarDelegate$Companion;", "", "()V", "EXAM_INFO", "", "READ_NEW_MESSAGE_URL", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PadSmallClassBarDelegate.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
