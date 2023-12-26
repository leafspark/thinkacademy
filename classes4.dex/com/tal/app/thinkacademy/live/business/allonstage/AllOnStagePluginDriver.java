package com.tal.app.thinkacademy.live.business.allonstage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
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
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.Type;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.listenbody.AllOnStageListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChatBoxListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxUseScenes;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxInputListener;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxListener;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxInputPluginView;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxPluginView;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.liveplay.bean.TeacherOnStageMsg;
import com.tal.app.thinkacademy.live.business.studentvideo.PermissCameraView;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.business.studentvideo.listen.PermissionListen;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.net.NetWork;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@PluginAnnotation(classType = 1, desc = "全员上台插件", ircType = {"send_emoji", "all_onStage_closed", "allow_open_microphone", "animation_emoji"}, launchType = "initmodule", moduleId = "311")
@ViewLevels({@ViewLevel(level = 140, name = "AllOnStage"), @ViewLevel(level = 140, name = "ChatBoxInputView")})
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001bB\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0018\u00104\u001a\u0002012\u000e\u00105\u001a\n\u0012\u0004\u0012\u000203\u0018\u000106H\u0002J!\u00107\u001a\u0002012\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0002¢\u0006\u0002\u0010<J\u0018\u0010=\u001a\u0002012\u000e\u0010>\u001a\n\u0012\u0004\u0012\u000203\u0018\u000106H\u0002J\u000e\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\fJ\u0010\u0010A\u001a\u0004\u0018\u00010\r2\u0006\u0010@\u001a\u00020\fJ\b\u0010B\u001a\u000201H\u0002J\b\u0010C\u001a\u000201H\u0002J\b\u0010D\u001a\u000201H\u0002J\b\u0010E\u001a\u000201H\u0002J\b\u0010F\u001a\u000201H\u0002J\b\u0010G\u001a\u000201H\u0016J\u0012\u0010H\u001a\u0002012\b\u0010I\u001a\u0004\u0018\u00010;H\u0016J\b\u0010J\u001a\u000209H\u0016J\u0012\u0010K\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u0010L\u001a\u000201H\u0016J\u0012\u0010M\u001a\u0002012\b\u0010I\u001a\u0004\u0018\u00010;H\u0016J\b\u0010N\u001a\u000201H\u0016J\u0012\u0010O\u001a\u0002012\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u001c\u0010R\u001a\u0002012\b\u0010S\u001a\u0004\u0018\u00010;2\b\u0010T\u001a\u0004\u0018\u00010;H\u0016J\b\u0010U\u001a\u000201H\u0016J\b\u0010V\u001a\u000201H\u0002J\b\u0010W\u001a\u000201H\u0016J\u000e\u0010X\u001a\u0002012\u0006\u0010Y\u001a\u00020ZJ\b\u0010[\u001a\u000201H\u0002J\b\u0010\\\u001a\u000201H\u0002J\u0012\u0010]\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0018\u0010^\u001a\u0002012\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u000106H\u0002J\u000e\u0010`\u001a\u0002012\u0006\u0010a\u001a\u00020\u0019R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0010X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/AllOnStagePluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "Lcom/tal/app/thinkacademy/live/business/studentvideo/listen/PermissionListen;", "Lcom/tal/app/thinkacademy/live/business/chatbox/listener/ChatBoxListener;", "Lcom/tal/app/thinkacademy/live/business/chatbox/listener/ChatBoxInputListener;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "mAllStudentMap", "Ljava/util/HashMap;", "", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "Lkotlin/collections/HashMap;", "mAreaObserver", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaContext;", "mChatBoxInputPluginView", "Lcom/tal/app/thinkacademy/live/business/chatbox/widget/ChatBoxInputPluginView;", "mChatBoxView", "Lcom/tal/app/thinkacademy/live/business/chatbox/widget/ChatBoxPluginView;", "mChatBoxViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/ChatBoxViewModel;", "mClassId", "", "mContext", "Landroid/content/Context;", "mCourseInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;", "mHearEachOtherObserver", "Lcom/tal/app/thinkacademy/live/core/plugin/PluginEventData;", "mOnlineStudentList", "Ljava/util/ArrayList;", "getMOnlineStudentList", "()Ljava/util/ArrayList;", "mPermissionView", "Lcom/tal/app/thinkacademy/live/business/studentvideo/PermissCameraView;", "mPlanId", "mPluginView", "Lcom/tal/app/thinkacademy/live/business/allonstage/BaseAllOnStagePluginView;", "mRtcViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "mTeacherInfo", "Lcom/tal/app/thinkacademy/live/business/liveplay/bean/TeacherOnStageMsg;", "mViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/AllOnStageViewModel;", "observerTeacherInfo", "addData", "", "bean", "Lcom/tal/app/thinkacademy/live/business/chatbox/bean/ChatBoxItemBean;", "addHistoryData", "beans", "", "changeChatStatus", "isOpenChat", "", "text", "", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "changeTeacherControlStatus", "list", "findStudentInfo", "uid", "getStudentObj", "initEvent", "initSmallClassStudents", "ircConnectSuccess", "loadView", "observeListener", "onClickCloseBtn", "onClickHotWords", "msg", "onClickQuickMsg", "onClickRetryBtn", "onClickSaySomethingBtn", "onClickSendBtn", "onDestroy", "onInputTextChanged", "s", "", "onMessage", "ircTypeKey", "message", "removePermissView", "removeView", "settingView", "showPermissionWindow", "type", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/Type;", "stopAllStream", "unInitEvent", "updateSendMsgStatus", "updateStudentList", "data", "updateStudentsInfo", "index", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePluginDriver.kt */
public final class AllOnStagePluginDriver extends BaseLivePluginDriver implements PermissionListen, ChatBoxListener, ChatBoxInputListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.ALLONSTAGE;
    public static final String TARGET = "AllOnStagePluginDriver.Observer";
    /* access modifiers changed from: private */
    public final HashMap<Long, StudentVideoBean.ListBean> mAllStudentMap = new HashMap<>();
    private Observer<LiveAreaContext> mAreaObserver;
    private ChatBoxInputPluginView mChatBoxInputPluginView;
    /* access modifiers changed from: private */
    public ChatBoxPluginView mChatBoxView;
    private ChatBoxViewModel mChatBoxViewModel = AbilityPackKt.getAbilityPack().getViewModel(ChatBoxViewModel.class);
    private int mClassId;
    private Context mContext = ((Context) this.mLiveRoomProvider.getWeakRefContext().get());
    private CourseInfoProxy mCourseInfo;
    private final Observer<PluginEventData> mHearEachOtherObserver = new AllOnStagePluginDriver$$ExternalSyntheticLambda1(this);
    private final ArrayList<StudentVideoBean.ListBean> mOnlineStudentList = new ArrayList<>();
    private PermissCameraView mPermissionView;
    private int mPlanId;
    /* access modifiers changed from: private */
    public BaseAllOnStagePluginView<?> mPluginView;
    /* access modifiers changed from: private */
    public RtcViewModel mRtcViewModel = RtcViewModelKt.getRtcViewModel(AbilityPackKt.getAbilityPack());
    /* access modifiers changed from: private */
    public TeacherOnStageMsg mTeacherInfo;
    /* access modifiers changed from: private */
    public AllOnStageViewModel mViewModel = AbilityPackKt.getAbilityPack().getViewModel(AllOnStageViewModel.class);
    private Observer<PluginEventData> observerTeacherInfo = new AllOnStagePluginDriver$$ExternalSyntheticLambda0(this);

    public boolean onClickQuickMsg() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0086, code lost:
        r3 = r3.getRoomData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AllOnStagePluginDriver(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r3, android.os.Bundle r4) {
        /*
            r2 = this;
            java.lang.String r0 = "provider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "bundle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r2.<init>(r3, r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r2.mAllStudentMap = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r2.mOnlineStudentList = r4
            com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver$$ExternalSyntheticLambda0 r4 = new com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver$$ExternalSyntheticLambda0
            r4.<init>(r2)
            r2.observerTeacherInfo = r4
            com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver$$ExternalSyntheticLambda1 r4 = new com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver$$ExternalSyntheticLambda1
            r4.<init>(r2)
            r2.mHearEachOtherObserver = r4
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r4 = r2.mLiveRoomProvider
            java.lang.ref.WeakReference r4 = r4.getWeakRefContext()
            java.lang.Object r4 = r4.get()
            android.content.Context r4 = (android.content.Context) r4
            r2.mContext = r4
            com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack r4 = com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt.getAbilityPack()
            java.lang.Class<com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel> r0 = com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel.class
            com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel r4 = r4.getViewModel(r0)
            com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel r4 = (com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel) r4
            r2.mViewModel = r4
            com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack r4 = com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt.getAbilityPack()
            com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel r4 = com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt.getRtcViewModel(r4)
            r2.mRtcViewModel = r4
            com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack r4 = com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt.getAbilityPack()
            java.lang.Class<com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel> r0 = com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel.class
            com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel r4 = r4.getViewModel(r0)
            com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel r4 = (com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel) r4
            r2.mChatBoxViewModel = r4
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r4 = r2.mLiveRoomProvider
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r4 = r4.getDataStorage()
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r4 = r4.getCourseInfo()
            r2.mCourseInfo = r4
            if (r4 != 0) goto L_0x006c
            goto L_0x0078
        L_0x006c:
            int r0 = r4.getPlanId()
            r2.mPlanId = r0
            int r4 = r4.getClassId()
            r2.mClassId = r4
        L_0x0078:
            com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel r4 = r2.mViewModel
            r0 = 0
            if (r4 != 0) goto L_0x007e
            goto L_0x0094
        L_0x007e:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r3 = r3.getDataStorage()
            if (r3 != 0) goto L_0x0086
        L_0x0084:
            r3 = r0
            goto L_0x0091
        L_0x0086:
            com.tal.app.thinkacademy.live.core.live.datastorage.RoomData r3 = r3.getRoomData()
            if (r3 != 0) goto L_0x008d
            goto L_0x0084
        L_0x008d:
            boolean r3 = r3.isIsOnStage()
        L_0x0091:
            r4.enableOnStage(r3)
        L_0x0094:
            com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel r3 = r2.mViewModel
            r4 = 1
            if (r3 != 0) goto L_0x009b
        L_0x0099:
            r3 = r0
            goto L_0x00a2
        L_0x009b:
            boolean r3 = r3.getMIsOnStage()
            if (r3 != r4) goto L_0x0099
            r3 = r4
        L_0x00a2:
            if (r3 == 0) goto L_0x00bd
            com.tal.app.thinkacademy.live.Tag r3 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r3 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r1 = "开始全员上台"
            r4[r0] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.s(r3, r4)
            r2.loadView()
            r2.observeListener()
            r2.initEvent()
            r2.initSmallClassStudents()
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver.<init>(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider, android.os.Bundle):void");
    }

    public final ArrayList<StudentVideoBean.ListBean> getMOnlineStudentList() {
        return this.mOnlineStudentList;
    }

    /* access modifiers changed from: private */
    /* renamed from: observerTeacherInfo$lambda-1  reason: not valid java name */
    public static final void m156observerTeacherInfo$lambda1(AllOnStagePluginDriver allOnStagePluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(allOnStagePluginDriver, "this$0");
        TeacherOnStageMsg teacherOnStageMsg = (TeacherOnStageMsg) pluginEventData.getObject();
        AllOnStageViewModel allOnStageViewModel = allOnStagePluginDriver.mViewModel;
        boolean z = false;
        if (allOnStageViewModel != null && allOnStageViewModel.getMIsOnStage()) {
            z = true;
        }
        if (z && teacherOnStageMsg != null) {
            allOnStagePluginDriver.mTeacherInfo = teacherOnStageMsg;
            BaseAllOnStagePluginView<?> baseAllOnStagePluginView = allOnStagePluginDriver.mPluginView;
            if (baseAllOnStagePluginView != null) {
                baseAllOnStagePluginView.setTeachInfo(teacherOnStageMsg);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mHearEachOtherObserver$lambda-2  reason: not valid java name */
    public static final void m155mHearEachOtherObserver$lambda2(AllOnStagePluginDriver allOnStagePluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(allOnStagePluginDriver, "this$0");
        boolean areEqual = Intrinsics.areEqual("open", pluginEventData.getData());
        XesLog.i(TAG, Intrinsics.stringPlus("是否开启了互听=", Boolean.valueOf(areEqual)));
        BaseAllOnStagePluginView<?> baseAllOnStagePluginView = allOnStagePluginDriver.mPluginView;
        if (baseAllOnStagePluginView != null) {
            baseAllOnStagePluginView.setHearEachOther(areEqual);
        }
        BaseAllOnStagePluginView<?> baseAllOnStagePluginView2 = allOnStagePluginDriver.mPluginView;
        if (baseAllOnStagePluginView2 != null) {
            baseAllOnStagePluginView2.setRoomStudents(allOnStagePluginDriver.mOnlineStudentList);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/AllOnStagePluginDriver$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "TARGET", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AllOnStagePluginDriver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void observeListener() {
        ListenerData<ChatBoxListenerBody> mListenerBody;
        ListenerData<RtcPlayerListenerBody> mRtcPlayerListener;
        NetWork<List<StudentVideoBean.ListBean>> mNetWork;
        ListenerData<AllOnStageListenerBody> mListenerBody2;
        AllOnStageViewModel allOnStageViewModel = this.mViewModel;
        if (!(allOnStageViewModel == null || (mListenerBody2 = allOnStageViewModel.getMListenerBody()) == null)) {
            mListenerBody2.observeListener((LifecycleOwner) this, false, TARGET, new AllOnStagePluginDriver$observeListener$1(this));
        }
        RtcViewModel rtcViewModel = this.mRtcViewModel;
        if (!(rtcViewModel == null || (mNetWork = rtcViewModel.getMNetWork()) == null)) {
            mNetWork.observeListener((LifecycleOwner) this, false, TARGET, new AllOnStagePluginDriver$observeListener$2(this));
        }
        RtcViewModel rtcViewModel2 = this.mRtcViewModel;
        if (!(rtcViewModel2 == null || (mRtcPlayerListener = rtcViewModel2.getMRtcPlayerListener()) == null)) {
            mRtcPlayerListener.observeListener((LifecycleOwner) this, false, TARGET, new AllOnStagePluginDriver$observeListener$3(this));
        }
        ChatBoxViewModel chatBoxViewModel = this.mChatBoxViewModel;
        if (chatBoxViewModel != null && (mListenerBody = chatBoxViewModel.getMListenerBody()) != null) {
            mListenerBody.observeListener((LifecycleOwner) this, false, TARGET, new AllOnStagePluginDriver$observeListener$4(this));
        }
    }

    /* access modifiers changed from: private */
    public final void updateStudentList(List<? extends StudentVideoBean.ListBean> list) {
        RtcUserState remoteState;
        if (list != null) {
            int size = list.size();
            int i = 0;
            boolean z = false;
            while (i < size) {
                int i2 = i + 1;
                StudentVideoBean.ListBean listBean = (StudentVideoBean.ListBean) list.get(i);
                if (this.mAllStudentMap.get(Long.valueOf(listBean.getUserId())) == null) {
                    this.mAllStudentMap.put(Long.valueOf(listBean.getUserId()), listBean);
                    RtcViewModel rtcViewModel = this.mRtcViewModel;
                    if (!(rtcViewModel == null || (remoteState = rtcViewModel.getRemoteState(listBean.getUserId())) == null || !remoteState.getMIsOnline())) {
                        listBean.setPullStreamState(0);
                        listBean.setOpenMic(remoteState.getMIsOpenMic());
                        listBean.setOpenCamera(remoteState.getMIsOpenCamera());
                        getMOnlineStudentList().add(listBean);
                        z = true;
                    }
                }
                i = i2;
            }
            if (z) {
                XesLog.i(TAG, "班级数据真正更新了");
                BaseAllOnStagePluginView<?> baseAllOnStagePluginView = this.mPluginView;
                if (baseAllOnStagePluginView != null) {
                    baseAllOnStagePluginView.setRoomStudents(getMOnlineStudentList());
                    return;
                }
                return;
            }
            XesLog.i(TAG, "班级数据不需要更新");
        }
    }

    private final void initEvent() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        PluginEventBus.register(lifecycleOwner, DataBusKey.TEACHER_CAME_UP_GET_INFO, this.observerTeacherInfo);
        PluginEventBus.register(lifecycleOwner, DataBusKey.VOICE_DRIVER_IS_HEAR_EACH_OTHER, this.mHearEachOtherObserver);
        PluginEventBus.onEvent(DataBusKey.TEACHER_CAME_UP_STATE, new PluginEventData(AllOnStagePluginDriver.class, DataBusKey.TEACHER_CAME_UP_STATE, EnterRoomMuteData.STATUS_UN_MUTE));
    }

    private final void unInitEvent() {
        PluginEventBus.onEvent(DataBusKey.TEACHER_CAME_UP_STATE, new PluginEventData(AllOnStagePluginDriver.class, DataBusKey.TEACHER_CAME_UP_STATE, "1"));
        PluginEventBus.unregister(DataBusKey.TEACHER_CAME_UP_GET_INFO, this.observerTeacherInfo);
        PluginEventBus.unregister(DataBusKey.VOICE_DRIVER_IS_HEAR_EACH_OTHER, this.mHearEachOtherObserver);
    }

    private final void initSmallClassStudents() {
        boolean isParentAuditLocal = this.mLiveRoomProvider.getDataStorage().getCourseInfo().getIsParentAuditLocal();
        RtcViewModel rtcViewModel = this.mRtcViewModel;
        if (rtcViewModel != null) {
            rtcViewModel.getAllStudents(this.mPlanId, this.mClassId, isParentAuditLocal);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.lang.Boolean} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessage(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel r0 = r6.mViewModel
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0008
        L_0x0006:
            r0 = r1
            goto L_0x000f
        L_0x0008:
            boolean r0 = r0.getMIsOnStage()
            if (r0 != 0) goto L_0x0006
            r0 = r2
        L_0x000f:
            if (r0 == 0) goto L_0x001f
            com.tal.app.thinkacademy.live.Tag r7 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r7 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r7
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.String r0 = "onMessage 全员下台，过滤所有消息"
            r8[r1] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r7, r8)
            return
        L_0x001f:
            if (r7 == 0) goto L_0x0164
            int r0 = r7.hashCode()
            java.lang.String r3 = "pub"
            r4 = 0
            switch(r0) {
                case -1925166133: goto L_0x00ad;
                case -363836502: goto L_0x005f;
                case 814542031: goto L_0x0055;
                case 1933319497: goto L_0x002d;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x0164
        L_0x002d:
            java.lang.String r0 = "allow_open_microphone"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0037
            goto L_0x0164
        L_0x0037:
            if (r8 != 0) goto L_0x003b
            goto L_0x0164
        L_0x003b:
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>(r8)
            java.lang.String r8 = "data"
            org.json.JSONObject r7 = r7.getJSONObject(r8)
            boolean r7 = r7.optBoolean(r3)
            com.tal.app.thinkacademy.live.business.allonstage.BaseAllOnStagePluginView<?> r8 = r6.mPluginView
            if (r8 != 0) goto L_0x0050
            goto L_0x0164
        L_0x0050:
            r8.setAllowOpenMic(r7)
            goto L_0x0164
        L_0x0055:
            java.lang.String r0 = "send_emoji"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00b7
            goto L_0x0164
        L_0x005f:
            java.lang.String r0 = "all_onStage_closed"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0069
            goto L_0x0164
        L_0x0069:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0080 }
            if (r8 != 0) goto L_0x0070
            java.lang.String r5 = ""
            goto L_0x0071
        L_0x0070:
            r5 = r8
        L_0x0071:
            r7.<init>(r5)     // Catch:{ Exception -> 0x0080 }
            org.json.JSONObject r7 = r7.optJSONObject(r0)     // Catch:{ Exception -> 0x0080 }
            if (r7 != 0) goto L_0x007b
            goto L_0x0084
        L_0x007b:
            boolean r7 = r7.optBoolean(r3, r2)     // Catch:{ Exception -> 0x0080 }
            goto L_0x0085
        L_0x0080:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0084:
            r7 = r2
        L_0x0085:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            boolean r0 = r7.booleanValue()
            if (r0 == 0) goto L_0x0090
            r4 = r7
        L_0x0090:
            if (r4 != 0) goto L_0x0094
            goto L_0x0164
        L_0x0094:
            r4.booleanValue()
            com.tal.app.thinkacademy.live.Tag r7 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r7 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r7
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "onMessage:all_onStage_closed 下台 message:"
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r8)
            r0[r1] = r8
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r7, r0)
            r6.removeView()
            goto L_0x0164
        L_0x00ad:
            java.lang.String r0 = "animation_emoji"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00b7
            goto L_0x0164
        L_0x00b7:
            com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver$onMessage$type$1 r7 = new com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver$onMessage$type$1     // Catch:{ Exception -> 0x0160 }
            r7.<init>()     // Catch:{ Exception -> 0x0160 }
            java.lang.reflect.Type r7 = r7.getType()     // Catch:{ Exception -> 0x0160 }
            com.tal.app.thinkacademy.lib.util.GsonUtil r0 = com.tal.app.thinkacademy.lib.util.GsonUtil.getInstance()     // Catch:{ Exception -> 0x0160 }
            java.lang.Object r7 = r0.fromJson((java.lang.String) r8, (java.lang.reflect.Type) r7)     // Catch:{ Exception -> 0x0160 }
            com.tal.app.thinkacademy.live.core.irc.entity.MsgBean r7 = (com.tal.app.thinkacademy.live.core.irc.entity.MsgBean) r7     // Catch:{ Exception -> 0x0160 }
            if (r7 == 0) goto L_0x0164
            java.lang.Object r0 = r7.getData()     // Catch:{ Exception -> 0x0160 }
            if (r0 == 0) goto L_0x0164
            com.tal.app.thinkacademy.live.core.irc.entity.FromUserInfoBean r0 = r7.getFrom()     // Catch:{ Exception -> 0x0160 }
            if (r0 == 0) goto L_0x0164
            com.tal.app.thinkacademy.live.core.irc.entity.FromUserInfoBean r0 = r7.getFrom()     // Catch:{ Exception -> 0x0160 }
            java.lang.String r0 = r0.getUserId()     // Catch:{ Exception -> 0x0160 }
            java.lang.String r1 = "msgBean.from.userId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x0160 }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x0160 }
            java.lang.Object r7 = r7.getData()     // Catch:{ Exception -> 0x0160 }
            com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean r7 = (com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean) r7     // Catch:{ Exception -> 0x0160 }
            int r7 = r7.getType()     // Catch:{ Exception -> 0x0160 }
            if (r7 == r2) goto L_0x013a
            r2 = 2
            if (r7 == r2) goto L_0x011c
            r2 = 3
            if (r7 == r2) goto L_0x00fe
            com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean r4 = (com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean) r4     // Catch:{ Exception -> 0x0160 }
            goto L_0x0157
        L_0x00fe:
            com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver$onMessage$emojiBean$newType$3 r7 = new com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver$onMessage$emojiBean$newType$3     // Catch:{ Exception -> 0x0160 }
            r7.<init>()     // Catch:{ Exception -> 0x0160 }
            java.lang.reflect.Type r7 = r7.getType()     // Catch:{ Exception -> 0x0160 }
            com.tal.app.thinkacademy.lib.util.GsonUtil r2 = com.tal.app.thinkacademy.lib.util.GsonUtil.getInstance()     // Catch:{ Exception -> 0x0160 }
            java.lang.Object r7 = r2.fromJson((java.lang.String) r8, (java.lang.reflect.Type) r7)     // Catch:{ Exception -> 0x0160 }
            com.tal.app.thinkacademy.live.core.irc.entity.MsgBean r7 = (com.tal.app.thinkacademy.live.core.irc.entity.MsgBean) r7     // Catch:{ Exception -> 0x0160 }
            if (r7 != 0) goto L_0x0114
            goto L_0x0157
        L_0x0114:
            java.lang.Object r7 = r7.getData()     // Catch:{ Exception -> 0x0160 }
            r4 = r7
            com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean r4 = (com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean) r4     // Catch:{ Exception -> 0x0160 }
            goto L_0x0157
        L_0x011c:
            com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver$onMessage$emojiBean$newType$2 r7 = new com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver$onMessage$emojiBean$newType$2     // Catch:{ Exception -> 0x0160 }
            r7.<init>()     // Catch:{ Exception -> 0x0160 }
            java.lang.reflect.Type r7 = r7.getType()     // Catch:{ Exception -> 0x0160 }
            com.tal.app.thinkacademy.lib.util.GsonUtil r2 = com.tal.app.thinkacademy.lib.util.GsonUtil.getInstance()     // Catch:{ Exception -> 0x0160 }
            java.lang.Object r7 = r2.fromJson((java.lang.String) r8, (java.lang.reflect.Type) r7)     // Catch:{ Exception -> 0x0160 }
            com.tal.app.thinkacademy.live.core.irc.entity.MsgBean r7 = (com.tal.app.thinkacademy.live.core.irc.entity.MsgBean) r7     // Catch:{ Exception -> 0x0160 }
            if (r7 != 0) goto L_0x0132
            goto L_0x0157
        L_0x0132:
            java.lang.Object r7 = r7.getData()     // Catch:{ Exception -> 0x0160 }
            r4 = r7
            com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean r4 = (com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean) r4     // Catch:{ Exception -> 0x0160 }
            goto L_0x0157
        L_0x013a:
            com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver$onMessage$emojiBean$newType$1 r7 = new com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver$onMessage$emojiBean$newType$1     // Catch:{ Exception -> 0x0160 }
            r7.<init>()     // Catch:{ Exception -> 0x0160 }
            java.lang.reflect.Type r7 = r7.getType()     // Catch:{ Exception -> 0x0160 }
            com.tal.app.thinkacademy.lib.util.GsonUtil r2 = com.tal.app.thinkacademy.lib.util.GsonUtil.getInstance()     // Catch:{ Exception -> 0x0160 }
            java.lang.Object r7 = r2.fromJson((java.lang.String) r8, (java.lang.reflect.Type) r7)     // Catch:{ Exception -> 0x0160 }
            com.tal.app.thinkacademy.live.core.irc.entity.MsgBean r7 = (com.tal.app.thinkacademy.live.core.irc.entity.MsgBean) r7     // Catch:{ Exception -> 0x0160 }
            if (r7 != 0) goto L_0x0150
            goto L_0x0157
        L_0x0150:
            java.lang.Object r7 = r7.getData()     // Catch:{ Exception -> 0x0160 }
            r4 = r7
            com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean r4 = (com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean) r4     // Catch:{ Exception -> 0x0160 }
        L_0x0157:
            com.tal.app.thinkacademy.live.business.allonstage.BaseAllOnStagePluginView<?> r7 = r6.mPluginView     // Catch:{ Exception -> 0x0160 }
            if (r7 != 0) goto L_0x015c
            goto L_0x0164
        L_0x015c:
            r7.showEmoji(r0, r4)     // Catch:{ Exception -> 0x0160 }
            goto L_0x0164
        L_0x0160:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver.onMessage(java.lang.String, java.lang.String):void");
    }

    private final void loadView() {
        Context context;
        RoomData roomData;
        ChatBoxPluginView chatBoxPluginView;
        RoomData roomData2;
        Context context2;
        BaseAllOnStagePluginView<?> baseAllOnStagePluginView;
        if (this.mPluginView == null && (context2 = this.mContext) != null) {
            if (PadUtils.isPad(context2)) {
                ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
                Intrinsics.checkNotNullExpressionValue(iLiveRoomProvider, "mLiveRoomProvider");
                baseAllOnStagePluginView = new AllOnStagePluginViewPad(context2, iLiveRoomProvider);
            } else {
                ILiveRoomProvider iLiveRoomProvider2 = this.mLiveRoomProvider;
                Intrinsics.checkNotNullExpressionValue(iLiveRoomProvider2, "mLiveRoomProvider");
                baseAllOnStagePluginView = new AllOnStagePluginViewPhone(context2, iLiveRoomProvider2);
            }
            this.mPluginView = baseAllOnStagePluginView;
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, (BaseLivePluginView) baseAllOnStagePluginView, this.mPluginConfData.getViewLevel("AllOnStage"), new FrameLayout.LayoutParams(-1, -1));
        }
        BaseAllOnStagePluginView<?> baseAllOnStagePluginView2 = this.mPluginView;
        if (baseAllOnStagePluginView2 != null) {
            baseAllOnStagePluginView2.setDriver(this);
        }
        BaseAllOnStagePluginView<?> baseAllOnStagePluginView3 = this.mPluginView;
        ChatBoxPluginView chatBoxPluginView2 = baseAllOnStagePluginView3 == null ? null : (ChatBoxPluginView) baseAllOnStagePluginView3.findViewById(R.id.all_stage_chat_box_root);
        this.mChatBoxView = chatBoxPluginView2;
        if (chatBoxPluginView2 != null) {
            chatBoxPluginView2.setChatBoxListener(this);
        }
        DataStorage dataStorage = this.mLiveRoomProvider.getDataStorage();
        boolean z = true;
        if (((dataStorage == null || (roomData2 = dataStorage.getRoomData()) == null || roomData2.isHasChatBox()) ? false : true) && (chatBoxPluginView = this.mChatBoxView) != null) {
            chatBoxPluginView.setVisibility(8);
        }
        DataStorage dataStorage2 = this.mLiveRoomProvider.getDataStorage();
        if (dataStorage2 == null || (roomData = dataStorage2.getRoomData()) == null || !roomData.isHasChatBox()) {
            z = false;
        }
        if (z && (context = this.mContext) != null) {
            ChatBoxInputPluginView chatBoxInputPluginView = new ChatBoxInputPluginView(context, ChatBoxUseScenes.ALL_ON_STAGE.name());
            this.mChatBoxInputPluginView = chatBoxInputPluginView;
            chatBoxInputPluginView.setChatBoxInputListener(this);
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mChatBoxInputPluginView, "ChatBoxInputView", new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private final void removeView() {
        ListenerData<ChatBoxListenerBody> mListenerBody;
        ListenerData<RtcPlayerListenerBody> mRtcPlayerListener;
        NetWork<List<StudentVideoBean.ListBean>> mNetWork;
        ListenerData<AllOnStageListenerBody> mListenerBody2;
        ILiveRoomProvider iLiveRoomProvider;
        unInitEvent();
        BaseAllOnStagePluginView<?> baseAllOnStagePluginView = this.mPluginView;
        if (baseAllOnStagePluginView != null) {
            baseAllOnStagePluginView.disMiss();
        }
        BaseAllOnStagePluginView<?> baseAllOnStagePluginView2 = this.mPluginView;
        if (baseAllOnStagePluginView2 != null) {
            this.mLiveRoomProvider.removeView((View) baseAllOnStagePluginView2);
            Observer<LiveAreaContext> observer = this.mAreaObserver;
            if (observer != null) {
                LiveAreaContext.get().layoutObserver.removeObserver(observer);
            }
        }
        ChatBoxInputPluginView chatBoxInputPluginView = this.mChatBoxInputPluginView;
        if (!(chatBoxInputPluginView == null || (iLiveRoomProvider = this.mLiveRoomProvider) == null)) {
            iLiveRoomProvider.removeView((View) chatBoxInputPluginView);
        }
        stopAllStream();
        this.mAllStudentMap.clear();
        this.mOnlineStudentList.clear();
        BaseAllOnStagePluginView<?> baseAllOnStagePluginView3 = this.mPluginView;
        if (baseAllOnStagePluginView3 != null) {
            baseAllOnStagePluginView3.setRoomStudents(this.mOnlineStudentList);
        }
        AllOnStageViewModel allOnStageViewModel = this.mViewModel;
        if (allOnStageViewModel != null) {
            allOnStageViewModel.enableOnStage(false);
        }
        removePermissView();
        AllOnStageViewModel allOnStageViewModel2 = this.mViewModel;
        if (!(allOnStageViewModel2 == null || (mListenerBody2 = allOnStageViewModel2.getMListenerBody()) == null)) {
            mListenerBody2.removeListener(TARGET);
        }
        RtcViewModel rtcViewModel = this.mRtcViewModel;
        if (!(rtcViewModel == null || (mNetWork = rtcViewModel.getMNetWork()) == null)) {
            mNetWork.removeListener(TARGET);
        }
        RtcViewModel rtcViewModel2 = this.mRtcViewModel;
        if (!(rtcViewModel2 == null || (mRtcPlayerListener = rtcViewModel2.getMRtcPlayerListener()) == null)) {
            mRtcPlayerListener.removeListener(TARGET);
        }
        ChatBoxViewModel chatBoxViewModel = this.mChatBoxViewModel;
        if (chatBoxViewModel != null && (mListenerBody = chatBoxViewModel.getMListenerBody()) != null) {
            mListenerBody.removeListener(TARGET);
        }
    }

    /* JADX WARNING: type inference failed for: r4v4, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void stopAllStream() {
        /*
            r8 = this;
            java.util.ArrayList r0 = r8.getMOnlineStudentList()
            int r0 = r0.size()
            r1 = 0
        L_0x0009:
            if (r1 >= r0) goto L_0x005c
            int r2 = r1 + 1
            if (r1 != 0) goto L_0x0010
            goto L_0x005a
        L_0x0010:
            java.util.ArrayList r3 = r8.getMOnlineStudentList()
            java.lang.Object r3 = r3.get(r1)
            java.lang.String r4 = "mOnlineStudentList.get(index)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean$ListBean r3 = (com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean.ListBean) r3
            com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel r4 = r8.mRtcViewModel
            r5 = 0
            if (r4 != 0) goto L_0x0026
            r3 = r5
            goto L_0x002e
        L_0x0026:
            long r6 = r3.getUserId()
            android.view.SurfaceView r3 = r4.getSurfaceView(r6)
        L_0x002e:
            if (r3 != 0) goto L_0x0031
            goto L_0x0044
        L_0x0031:
            android.view.ViewParent r4 = r3.getParent()
            boolean r6 = r4 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x003c
            r5 = r4
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
        L_0x003c:
            if (r5 != 0) goto L_0x003f
            goto L_0x0044
        L_0x003f:
            android.view.View r3 = (android.view.View) r3
            r5.removeView(r3)
        L_0x0044:
            com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel r3 = r8.mRtcViewModel
            if (r3 != 0) goto L_0x0049
            goto L_0x005a
        L_0x0049:
            java.util.ArrayList r4 = r8.getMOnlineStudentList()
            java.lang.Object r1 = r4.get(r1)
            com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean$ListBean r1 = (com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean.ListBean) r1
            long r4 = r1.getUserId()
            r3.stopRemoteVideo(r4)
        L_0x005a:
            r1 = r2
            goto L_0x0009
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver.stopAllStream():void");
    }

    public final int findStudentInfo(long j) {
        StudentVideoBean.ListBean listBean = this.mAllStudentMap.get(Long.valueOf(j));
        if (listBean == null) {
            return -1;
        }
        return getMOnlineStudentList().indexOf(listBean);
    }

    public final void updateStudentsInfo(int i) {
        BaseAllOnStagePluginView<?> baseAllOnStagePluginView = this.mPluginView;
        if (baseAllOnStagePluginView != null) {
            baseAllOnStagePluginView.changeStudent(this.mOnlineStudentList, i);
        }
    }

    public final StudentVideoBean.ListBean getStudentObj(long j) {
        return this.mAllStudentMap.get(Long.valueOf(j));
    }

    public void onDestroy() {
        removeView();
        BaseAllOnStagePluginView<?> baseAllOnStagePluginView = this.mPluginView;
        if (baseAllOnStagePluginView != null) {
            baseAllOnStagePluginView.destroy();
        }
        this.mPluginView = null;
    }

    public final void showPermissionWindow(Type type) {
        PermissCameraView permissCameraView;
        Intrinsics.checkNotNullParameter(type, "type");
        Context context = this.mContext;
        if (context != null) {
            PermissCameraView permissCameraView2 = this.mPermissionView;
            if (permissCameraView2 != null) {
                this.mLiveRoomProvider.removeView((View) permissCameraView2);
            }
            if (this.mPermissionView == null) {
                AllOnStagePluginDriver allOnStagePluginDriver = this;
                PermissCameraView permissCameraView3 = new PermissCameraView(context);
                this.mPermissionView = permissCameraView3;
                permissCameraView3.setDriver(this);
            }
            if (type == Type.RECORD && (permissCameraView = this.mPermissionView) != null) {
                permissCameraView.showMicrophoneTip();
            }
            String viewLevel = this.mPluginConfData.getViewLevel("AllOnStage");
            FrameLayout.LayoutParams newLp = LiveAreaContext.get().getScreenLp().newLp();
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mPermissionView, viewLevel, newLp);
            LiveAreaContext.get().layoutObserver.observe((LifecycleOwner) this, new AllOnStagePluginDriver$$ExternalSyntheticLambda2(this, newLp));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showPermissionWindow$lambda-22$lambda-21  reason: not valid java name */
    public static final void m157showPermissionWindow$lambda22$lambda21(AllOnStagePluginDriver allOnStagePluginDriver, FrameLayout.LayoutParams layoutParams, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(allOnStagePluginDriver, "this$0");
        PermissCameraView permissCameraView = allOnStagePluginDriver.mPermissionView;
        if (permissCameraView != null) {
            ViewGroup.LayoutParams layoutParams2 = permissCameraView.getLayoutParams();
            Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            liveAreaContext.getPptLp().mergeLp(layoutParams);
            permissCameraView.setLayoutParams((FrameLayout.LayoutParams) layoutParams2);
        }
    }

    public void removePermissView() {
        if (this.mPermissionView != null) {
            this.mLiveRoomProvider.removeView((View) this.mPermissionView);
            this.mPermissionView = null;
        }
    }

    public void settingView() {
        if (this.mPermissionView != null) {
            this.mLiveRoomProvider.removeView((View) this.mPermissionView);
            this.mPermissionView = null;
            PluginEventBus.onEvent(DataBusKey.SETTING_PERMISSION, PluginEventData.obtainData(getClass(), ""));
            PermissionUtils.launchAppDetailsSettings();
        }
    }

    public void onClickSaySomethingBtn() {
        ChatBoxViewModel chatBoxViewModel = this.mChatBoxViewModel;
        if (chatBoxViewModel != null) {
            Pair<Boolean, Long> isFrequently = chatBoxViewModel.isFrequently();
            if (((Boolean) isFrequently.getFirst()).booleanValue()) {
                ChatBoxPluginView chatBoxPluginView = this.mChatBoxView;
                if (chatBoxPluginView != null) {
                    chatBoxPluginView.showSendFrequently(((Number) isFrequently.getSecond()).longValue());
                    return;
                }
                return;
            }
        }
        ChatBoxInputPluginView chatBoxInputPluginView = this.mChatBoxInputPluginView;
        if (chatBoxInputPluginView != null) {
            chatBoxInputPluginView.show();
        }
    }

    public void onClickHotWords(String str) {
        if (TextUtils.isEmpty(str)) {
            XesLog.i(TAG, "输入聊天内容为空");
            return;
        }
        ChatBoxViewModel chatBoxViewModel = this.mChatBoxViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.addMyChatMessage(str);
        }
        ChatBoxInputPluginView chatBoxInputPluginView = this.mChatBoxInputPluginView;
        if (chatBoxInputPluginView != null) {
            chatBoxInputPluginView.clearInputContent();
        }
    }

    public void onClickSendBtn(String str) {
        if (TextUtils.isEmpty(str)) {
            XesLog.i(TAG, "输入聊天内容为空");
            return;
        }
        ChatBoxViewModel chatBoxViewModel = this.mChatBoxViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.addMyChatMessage(str);
        }
        ChatBoxInputPluginView chatBoxInputPluginView = this.mChatBoxInputPluginView;
        if (chatBoxInputPluginView != null) {
            chatBoxInputPluginView.clearInputContent();
        }
    }

    public void onClickCloseBtn() {
        ChatBoxPluginView chatBoxPluginView = this.mChatBoxView;
        if (chatBoxPluginView != null) {
            chatBoxPluginView.rootViewIsShow(false);
        }
    }

    public void onClickRetryBtn(ChatBoxItemBean chatBoxItemBean) {
        ChatBoxViewModel chatBoxViewModel;
        if (chatBoxItemBean != null && (chatBoxItemBean instanceof ChatBoxTextMsgBean) && (chatBoxViewModel = this.mChatBoxViewModel) != null) {
            chatBoxViewModel.sendChatMessage((ChatBoxTextMsgBean) chatBoxItemBean);
        }
    }

    public void onInputTextChanged(CharSequence charSequence) {
        ChatBoxPluginView chatBoxPluginView = this.mChatBoxView;
        if (chatBoxPluginView != null) {
            chatBoxPluginView.refreshInputText(charSequence);
        }
    }

    /* access modifiers changed from: private */
    public final void updateSendMsgStatus(ChatBoxItemBean chatBoxItemBean) {
        ChatBoxPluginView chatBoxPluginView;
        if (chatBoxItemBean != null && (chatBoxPluginView = this.mChatBoxView) != null) {
            chatBoxPluginView.refreshSendMsgStatus(chatBoxItemBean);
        }
    }

    /* access modifiers changed from: private */
    public final void addData(ChatBoxItemBean chatBoxItemBean) {
        ChatBoxPluginView chatBoxPluginView;
        if (chatBoxItemBean != null && (chatBoxPluginView = this.mChatBoxView) != null) {
            chatBoxPluginView.addData(chatBoxItemBean);
        }
    }

    /* access modifiers changed from: private */
    public final void addHistoryData(List<? extends ChatBoxItemBean> list) {
        if (list != null && (!list.isEmpty())) {
            for (ChatBoxItemBean chatBoxItemBean : list) {
                if (chatBoxItemBean instanceof ChatBoxTextMsgBean) {
                    ChatBoxViewModel chatBoxViewModel = this.mChatBoxViewModel;
                    if (!Intrinsics.areEqual(chatBoxViewModel == null ? null : Boolean.valueOf(chatBoxViewModel.isNeedFilter(chatBoxItemBean)), true)) {
                        addData(chatBoxItemBean);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void changeTeacherControlStatus(List<? extends ChatBoxItemBean> list) {
        ChatBoxPluginView chatBoxPluginView;
        if (list != null && (chatBoxPluginView = this.mChatBoxView) != null) {
            chatBoxPluginView.setData(list);
        }
    }

    /* access modifiers changed from: private */
    public final void changeChatStatus(Boolean bool, String str) {
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            ChatBoxPluginView chatBoxPluginView = this.mChatBoxView;
            if (chatBoxPluginView != null) {
                chatBoxPluginView.changeChatStatus(booleanValue, str);
            }
            ChatBoxInputPluginView chatBoxInputPluginView = this.mChatBoxInputPluginView;
            if (chatBoxInputPluginView != null && !bool.booleanValue()) {
                chatBoxInputPluginView.hide();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void ircConnectSuccess() {
        ChatBoxPluginView chatBoxPluginView = this.mChatBoxView;
        if (chatBoxPluginView != null) {
            chatBoxPluginView.ircConnectSuccess();
        }
    }
}
