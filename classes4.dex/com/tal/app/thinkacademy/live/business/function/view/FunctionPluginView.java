package com.tal.app.thinkacademy.live.business.function.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesDisplayUtil;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessFunctionPluginLayoutBinding;
import com.tal.app.thinkacademy.live.business.emoji.widget.EmojiViewPopupWindow;
import com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver;
import com.tal.app.thinkacademy.live.business.function.TeacherControlView;
import com.tal.app.thinkacademy.live.business.function.TeacherNotAllowView;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.function.view.AbsFunctionPluginView;
import com.tal.app.thinkacademy.live.business.livemessage.LiveMsgPrivateRemindView;
import com.tal.app.thinkacademy.live.business.raisehand.RaiseHandUtil;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailPackage;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import com.tal.app.thinkcademy.lib.commui.widget.CircleProgressView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002>?B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J\b\u0010'\u001a\u00020\u0017H\u0016J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020 H\u0016J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020 H\u0016J\u0012\u0010,\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u0017H\u0016J\u0010\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020 H\u0016J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u0012H\u0002J\u0010\u00104\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u0012H\u0002J\u0010\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020 H\u0016J\b\u00107\u001a\u00020\u0017H\u0002J\u0010\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020 H\u0016J\b\u0010:\u001a\u00020\u0017H\u0016J\b\u0010;\u001a\u00020\u0017H\u0016J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/view/FunctionPluginView;", "Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessFunctionPluginLayoutBinding;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "driver", "Lcom/tal/app/thinkacademy/live/business/function/FunctionPluginDriver;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/business/function/FunctionPluginDriver;)V", "COOL_DOWN_COUNT", "", "COOL_DOWN_TIME", "currentIndex", "emojiHandler", "Lcom/tal/app/thinkacademy/live/business/function/view/FunctionPluginView$EmojiHandler;", "mEmojiPopWindow", "Lcom/tal/app/thinkacademy/live/business/emoji/widget/EmojiViewPopupWindow;", "mEmojiState", "Lcom/tal/app/thinkacademy/live/business/function/view/FunctionPluginView$ButtonState;", "mHandUpState", "sendTime", "", "createEmojiPopWindow", "", "entity", "Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiDetailEntity;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "emojiControls", "pub", "emojiCountDown", "getEmojiTop", "hideChatBoxView", "initListener", "initViews", "isEnableHand", "enable", "muteMic", "mute", "onClick", "v", "Landroid/view/View;", "onDestroy", "resetChatBoxStatus", "isSelected", "setEmojiState", "state", "setHandUpState", "showChatBoxRedDotView", "isShow", "showEmojiPopupWindow", "showNotAllowMicPopUpWindow", "isActionOpen", "showOpenCameraPopUpWindow", "showOpenMicPopUpWindow", "updateMic", "mic", "ButtonState", "EmojiHandler", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FunctionPluginView.kt */
public class FunctionPluginView extends AbsFunctionPluginView<LiveBusinessFunctionPluginLayoutBinding> implements View.OnClickListener {
    /* access modifiers changed from: private */
    public final int COOL_DOWN_COUNT = 3;
    /* access modifiers changed from: private */
    public final int COOL_DOWN_TIME = 30000;
    /* access modifiers changed from: private */
    public int currentIndex = -1;
    /* access modifiers changed from: private */
    public EmojiHandler emojiHandler;
    private EmojiViewPopupWindow mEmojiPopWindow;
    /* access modifiers changed from: private */
    public ButtonState mEmojiState = ButtonState.NORMAL;
    private ButtonState mHandUpState = ButtonState.NORMAL;
    /* access modifiers changed from: private */
    public long[] sendTime = new long[3];

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/view/FunctionPluginView$ButtonState;", "", "(Ljava/lang/String;I)V", "NORMAL", "DISABLE", "SELECTED", "COOL_DOWN", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FunctionPluginView.kt */
    public enum ButtonState {
        NORMAL,
        DISABLE,
        SELECTED,
        COOL_DOWN
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FunctionPluginView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonState.values().length];
            iArr[ButtonState.NORMAL.ordinal()] = 1;
            iArr[ButtonState.DISABLE.ordinal()] = 2;
            iArr[ButtonState.COOL_DOWN.ordinal()] = 3;
            iArr[ButtonState.SELECTED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionPluginView(Context context, FunctionPluginDriver functionPluginDriver) {
        super(context, functionPluginDriver);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(functionPluginDriver, "driver");
    }

    /* access modifiers changed from: protected */
    public LiveBusinessFunctionPluginLayoutBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessFunctionPluginLayoutBinding inflate = LiveBusinessFunctionPluginLayoutBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }

    public void initViews() {
        super.initViews();
        CircleProgressView circleProgressView = this.mBinding.liveBusinessFunctionVHandUp;
        circleProgressView.setProgressColor(Color.parseColor("#FFB013"));
        circleProgressView.setBackColor(0);
        circleProgressView.setBgColor(0);
        circleProgressView.setProgressWidth(SizeUtils.dp2px(2.0f));
        circleProgressView.setBackWidth(SizeUtils.dp2px(2.0f));
        circleProgressView.setRevertMode(true);
        circleProgressView.setProgressCallback(new FunctionPluginView$initViews$1$1(this));
    }

    public void initListener() {
        View.OnClickListener onClickListener = this;
        this.mBinding.liveBusinessFunctionVHandUp.setOnClickListener(onClickListener);
        this.mBinding.liveBusinessFunctionVChatbox.setOnClickListener(onClickListener);
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        ImageView imageView = this.mBinding.liveBusinessFunctionVMic;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.liveBusinessFunctionVMic");
        rxUnDoubleUtil.setOnUnDoubleClickListener(imageView, 500, new FunctionPluginView$initListener$1(this));
        RxUnDoubleUtil rxUnDoubleUtil2 = RxUnDoubleUtil.INSTANCE;
        ImageView imageView2 = this.mBinding.liveBusinessFunctionVEmoji;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.liveBusinessFunctionVEmoji");
        rxUnDoubleUtil2.setOnUnDoubleClickListener(imageView2, 500, new FunctionPluginView$initListener$2(this));
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, FunctionPluginView.class);
        if (Intrinsics.areEqual(view, this.mBinding.liveBusinessFunctionVHandUp)) {
            if (this.mHandUpState == ButtonState.COOL_DOWN || this.mHandUpState == ButtonState.DISABLE) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
                return;
            }
            setHandUpState(ButtonState.COOL_DOWN);
            this.mBinding.liveBusinessFunctionVHandUp.startProgress(100, LiveMsgPrivateRemindView.REMIND_SHOW_TIME);
            RaiseHandUtil.sendRaiseHandMsg(getDriver().getProvider(), getTutorIrcNickName(), getUserName(), getHandJson());
            HWEventTracking.Companion.get().ostaRaiseHand();
        } else if (Intrinsics.areEqual(view, this.mBinding.liveBusinessFunctionVChatbox)) {
            boolean isSelected = this.mBinding.liveBusinessFunctionVChatbox.isSelected();
            getDriver().switchChatBox(!isSelected);
            if (!isSelected) {
                showChatBoxRedDotView(false);
            }
            resetChatBoxStatus(!isSelected);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void muteMic(boolean z) {
        setMicOff(z);
        this.mBinding.liveBusinessFunctionVMic.setSelected(z);
    }

    public void resetChatBoxStatus(boolean z) {
        int i;
        this.mBinding.liveBusinessFunctionVChatbox.setSelected(z);
        ImageView imageView = this.mBinding.liveBusinessFunctionVChatbox;
        if (z) {
            i = R.drawable.live_business_function_icon_chatbox_small_pad_yellow;
        } else {
            i = R.drawable.live_business_function_icon_chatbox_small_pad;
        }
        imageView.setImageResource(i);
    }

    public void showChatBoxRedDotView(boolean z) {
        if (!z) {
            this.mBinding.liveBusinessFunctionVChatboxDot.setVisibility(8);
        } else if (!this.mBinding.liveBusinessFunctionVChatbox.isSelected()) {
            this.mBinding.liveBusinessFunctionVChatboxDot.setVisibility(0);
        }
    }

    public void hideChatBoxView() {
        this.mBinding.liveBusinessFunctionVChatbox.setVisibility(8);
        this.mBinding.liveBusinessFunctionVChatboxDot.setVisibility(8);
    }

    public void updateMic(int i) {
        if (!this.mBinding.liveBusinessFunctionVMic.isSelected()) {
            this.mBinding.liveBusinessFunctionVMic.getDrawable().setLevel((i * 10000) / 255);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
        r1 = r1.getDataStorage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showEmojiPopupWindow() {
        /*
            r21 = this;
            r0 = r21
            com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver r1 = r21.getDriver()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r1 = r1.getLiveRoomProvider()
            r2 = 0
            if (r1 != 0) goto L_0x000f
        L_0x000d:
            r1 = r2
            goto L_0x001a
        L_0x000f:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r1 = r1.getDataStorage()
            if (r1 != 0) goto L_0x0016
            goto L_0x000d
        L_0x0016:
            com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailEntity r1 = r1.getEmojiDetailEntity()
        L_0x001a:
            if (r1 != 0) goto L_0x001e
            goto L_0x0106
        L_0x001e:
            com.tal.app.thinkacademy.live.business.emoji.widget.EmojiViewPopupWindow r3 = r0.mEmojiPopWindow
            if (r3 == 0) goto L_0x0031
            java.lang.Boolean r3 = r1.isUpdate()
            r4 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 == 0) goto L_0x0034
        L_0x0031:
            r0.createEmojiPopWindow(r1)
        L_0x0034:
            com.tal.app.thinkacademy.live.business.emoji.widget.EmojiViewPopupWindow r1 = r0.mEmojiPopWindow
            if (r1 != 0) goto L_0x003a
            goto L_0x0106
        L_0x003a:
            boolean r3 = r1.isShowing()
            if (r3 != 0) goto L_0x0106
            r1.initWindow()
            androidx.viewbinding.ViewBinding r3 = r0.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessFunctionPluginLayoutBinding r3 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessFunctionPluginLayoutBinding) r3
            androidx.constraintlayout.widget.ConstraintLayout r3 = r3.liveBusinessFunctionRoot
            android.view.View r3 = (android.view.View) r3
            r4 = 81
            r5 = 0
            r1.showAtLocation(r3, r4, r5, r5)
            com.tal.app.thinkacademy.live.util.DriverTrack r6 = com.tal.app.thinkacademy.live.util.DriverTrack.INSTANCE
            com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver r1 = r21.getDriver()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r1 = r1.getLiveRoomProvider()
            if (r1 != 0) goto L_0x005f
        L_0x005d:
            r8 = r2
            goto L_0x007a
        L_0x005f:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r1 = r1.getDataStorage()
            if (r1 != 0) goto L_0x0066
            goto L_0x005d
        L_0x0066:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r1 = r1.getCourseInfo()
            if (r1 != 0) goto L_0x006d
            goto L_0x005d
        L_0x006d:
            int r1 = r1.getPlanId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r1 = r1.toString()
            r8 = r1
        L_0x007a:
            com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver r1 = r21.getDriver()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r1 = r1.getLiveRoomProvider()
            if (r1 != 0) goto L_0x0086
        L_0x0084:
            r9 = r2
            goto L_0x00a1
        L_0x0086:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r1 = r1.getDataStorage()
            if (r1 != 0) goto L_0x008d
            goto L_0x0084
        L_0x008d:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r1 = r1.getCourseInfo()
            if (r1 != 0) goto L_0x0094
            goto L_0x0084
        L_0x0094:
            int r1 = r1.getClassId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r1 = r1.toString()
            r9 = r1
        L_0x00a1:
            com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver r1 = r21.getDriver()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r1 = r1.getLiveRoomProvider()
            if (r1 != 0) goto L_0x00ad
            r1 = r2
            goto L_0x00b1
        L_0x00ad:
            java.lang.String r1 = r1.getClassType()
        L_0x00b1:
            java.lang.String r3 = "0"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r3 == 0) goto L_0x00bd
            java.lang.String r1 = "大班"
        L_0x00bb:
            r10 = r1
            goto L_0x00cb
        L_0x00bd:
            java.lang.String r3 = "1"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L_0x00c8
            java.lang.String r1 = "伪小班"
            goto L_0x00bb
        L_0x00c8:
            java.lang.String r1 = "小班"
            goto L_0x00bb
        L_0x00cb:
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver r1 = r21.getDriver()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r1 = r1.getLiveRoomProvider()
            if (r1 != 0) goto L_0x00e0
        L_0x00dd:
            r18 = r2
            goto L_0x00fb
        L_0x00e0:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r1 = r1.getDataStorage()
            if (r1 != 0) goto L_0x00e7
            goto L_0x00dd
        L_0x00e7:
            com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy r1 = r1.getPlanInfo()
            if (r1 != 0) goto L_0x00ee
            goto L_0x00dd
        L_0x00ee:
            long r1 = r1.getPackageId()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = r1.toString()
            goto L_0x00dd
        L_0x00fb:
            r19 = 2000(0x7d0, float:2.803E-42)
            r20 = 0
            java.lang.String r7 = "hw_classroom_emoji_icon_click"
            java.lang.String r12 = "课中"
            com.tal.app.thinkacademy.live.util.DriverTrack.emojiRelated$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
        L_0x0106:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView.showEmojiPopupWindow():void");
    }

    private final void createEmojiPopWindow(EmojiDetailEntity emojiDetailEntity) {
        DataStorage dataStorage;
        EmojiViewPopupWindow emojiViewPopupWindow = this.mEmojiPopWindow;
        if (!(emojiViewPopupWindow == null || emojiViewPopupWindow == null)) {
            emojiViewPopupWindow.dismiss();
        }
        EmojiDetailEntity emojiDetailEntity2 = null;
        this.mEmojiPopWindow = null;
        ILiveRoomProvider liveRoomProvider = getDriver().getLiveRoomProvider();
        if (!(liveRoomProvider == null || (dataStorage = liveRoomProvider.getDataStorage()) == null)) {
            emojiDetailEntity2 = dataStorage.getEmojiDetailEntity();
        }
        if (emojiDetailEntity2 != null) {
            emojiDetailEntity2.setUpdate(false);
        }
        Context context = this.mContext;
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        EmojiViewPopupWindow emojiViewPopupWindow2 = new EmojiViewPopupWindow(context, emojiDetailEntity, LiveAreaCompat.pptCenterLp().width, (Integer) null, (Integer) null, (Integer) null, new FunctionPluginView$createEmojiPopWindow$window$1(this), 56, (DefaultConstructorMarker) null);
        this.mEmojiPopWindow = emojiViewPopupWindow2;
        EmojiViewPopupWindow emojiViewPopupWindow3 = (EmojiViewPopupWindow) emojiViewPopupWindow2.setOnDismissListener(new FunctionPluginView$$ExternalSyntheticLambda0(this));
        LiveAreaContext.get().layoutObserver.observe(getDriver(), new FunctionPluginView$$ExternalSyntheticLambda1(this));
        ArrayList arrayList = new ArrayList();
        if (Intrinsics.areEqual(emojiDetailEntity.isReportedOverdue(), false)) {
            ArrayList<EmojiDetailPackage> list = emojiDetailEntity.getList();
            if (list != null) {
                for (EmojiDetailPackage emojiDetailPackage : list) {
                    if (Intrinsics.areEqual(emojiDetailPackage.isOver(), true)) {
                        String orderId = emojiDetailPackage.getOrderId();
                        if (orderId == null) {
                            orderId = EnterRoomMuteData.STATUS_UN_MUTE;
                        }
                        arrayList.add(Integer.valueOf(Integer.parseInt(orderId)));
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                InteractReportKt.updateEmojiOverHide(arrayList, new FunctionPluginView$createEmojiPopWindow$4(arrayList, this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: createEmojiPopWindow$lambda-3  reason: not valid java name */
    public static final void m255createEmojiPopWindow$lambda3(FunctionPluginView functionPluginView) {
        Intrinsics.checkNotNullParameter(functionPluginView, "this$0");
        if (functionPluginView.mEmojiState != ButtonState.COOL_DOWN && functionPluginView.mEmojiState != ButtonState.DISABLE) {
            functionPluginView.setEmojiState(ButtonState.NORMAL);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: createEmojiPopWindow$lambda-4  reason: not valid java name */
    public static final void m256createEmojiPopWindow$lambda4(FunctionPluginView functionPluginView, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(functionPluginView, "this$0");
        EmojiViewPopupWindow emojiViewPopupWindow = functionPluginView.mEmojiPopWindow;
        if (emojiViewPopupWindow != null) {
            emojiViewPopupWindow.dismiss();
        }
        EmojiViewPopupWindow emojiViewPopupWindow2 = functionPluginView.mEmojiPopWindow;
        if (emojiViewPopupWindow2 != null) {
            emojiViewPopupWindow2.setWidth(LiveAreaCompat.pptCenterLp().width);
        }
        EmojiViewPopupWindow emojiViewPopupWindow3 = functionPluginView.mEmojiPopWindow;
        if (emojiViewPopupWindow3 != null) {
            EmojiViewPopupWindow emojiViewPopupWindow4 = (EmojiViewPopupWindow) emojiViewPopupWindow3.setWidth(LiveAreaCompat.pptCenterLp().width);
        }
        EmojiViewPopupWindow emojiViewPopupWindow5 = functionPluginView.mEmojiPopWindow;
        PopupWindow popupWindow = emojiViewPopupWindow5 == null ? null : emojiViewPopupWindow5.getPopupWindow();
        if (popupWindow != null) {
            popupWindow.setWidth(LiveAreaCompat.pptCenterLp().width);
        }
    }

    /* access modifiers changed from: private */
    public final void emojiCountDown() {
        EmojiHandler emojiHandler2;
        XesLog.it("功能区", "表情进入倒计时状态");
        setEmojiState(ButtonState.COOL_DOWN);
        FunctionPluginView functionPluginView = (FunctionPluginView) new SoftReference(this).get();
        if (functionPluginView == null) {
            emojiHandler2 = null;
        } else {
            Looper mainLooper = Looper.getMainLooper();
            Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper()");
            emojiHandler2 = new EmojiHandler(mainLooper, functionPluginView);
        }
        this.emojiHandler = emojiHandler2;
        if (emojiHandler2 != null) {
            emojiHandler2.sendEmptyMessage(1);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/view/FunctionPluginView$EmojiHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "pluginView", "Lcom/tal/app/thinkacademy/live/business/function/view/FunctionPluginView;", "(Landroid/os/Looper;Lcom/tal/app/thinkacademy/live/business/function/view/FunctionPluginView;)V", "getPluginView", "()Lcom/tal/app/thinkacademy/live/business/function/view/FunctionPluginView;", "setPluginView", "(Lcom/tal/app/thinkacademy/live/business/function/view/FunctionPluginView;)V", "progress", "", "getProgress", "()I", "setProgress", "(I)V", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FunctionPluginView.kt */
    public static final class EmojiHandler extends Handler {
        private FunctionPluginView pluginView;
        private int progress;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EmojiHandler(Looper looper, FunctionPluginView functionPluginView) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.pluginView = functionPluginView;
        }

        public final FunctionPluginView getPluginView() {
            return this.pluginView;
        }

        public final void setPluginView(FunctionPluginView functionPluginView) {
            this.pluginView = functionPluginView;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final void setProgress(int i) {
            this.progress = i;
        }

        public void handleMessage(Message message) {
            FunctionPluginView functionPluginView;
            int i;
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            Intrinsics.checkNotNullParameter(message, "msg");
            super.handleMessage(message);
            if (message.what != 1 || (i = this.progress) >= 3000) {
                XesLog.it("功能区", "表情倒计时结束");
                FunctionPluginView functionPluginView2 = this.pluginView;
                if (!((functionPluginView2 == null ? null : functionPluginView2.mEmojiState) == ButtonState.DISABLE || (functionPluginView = this.pluginView) == null)) {
                    functionPluginView.setEmojiState(ButtonState.NORMAL);
                }
            } else {
                this.progress = i + 1;
                sendEmptyMessageDelayed(1, 10);
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }

    /* access modifiers changed from: private */
    public final int getEmojiTop() {
        return this.mBinding.liveBusinessFunctionVEmoji.getTop();
    }

    public void showNotAllowMicPopUpWindow(boolean z) {
        AbsFunctionPluginView.AudioControlHandler audioControlHandler;
        boolean z2 = false;
        if (getTeacherNotAllowPopup() == null) {
            FunctionPluginView functionPluginView = this;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AbsFunctionPluginView absFunctionPluginView = this;
            setMTeacherNotAllMicView(new TeacherNotAllowView(context, new AbsFunctionPluginView.TeacherNotAllowMic(absFunctionPluginView, absFunctionPluginView)));
            EasyPopup easyPopup = new EasyPopup(this.mContext);
            easyPopup.setContentView((View) getMTeacherNotAllMicView()).setWidth(XesDisplayUtil.dp2px(320.0f)).setHeight(XesDisplayUtil.dp2px(132.0f)).setFocusAndOutsideEnable(false).createPopup();
            setTeacherNotAllowPopup(easyPopup);
        }
        if (z) {
            TeacherNotAllowView mTeacherNotAllMicView = getMTeacherNotAllMicView();
            if (mTeacherNotAllMicView != null) {
                mTeacherNotAllMicView.setIconRes(R.drawable.icon_microphone_turnoff);
            }
            TeacherNotAllowView mTeacherNotAllMicView2 = getMTeacherNotAllMicView();
            if (mTeacherNotAllMicView2 != null) {
                mTeacherNotAllMicView2.setMsg(R.string.teacher_does_not_allow);
            }
        } else {
            TeacherNotAllowView mTeacherNotAllMicView3 = getMTeacherNotAllMicView();
            if (mTeacherNotAllMicView3 != null) {
                mTeacherNotAllMicView3.setIconRes(R.drawable.icon_microphone_turn_on);
            }
            TeacherNotAllowView mTeacherNotAllMicView4 = getMTeacherNotAllMicView();
            if (mTeacherNotAllMicView4 != null) {
                mTeacherNotAllMicView4.setMsg(R.string.teacher_not_allow_mute_mic);
            }
        }
        EasyPopup teacherNotAllowPopup = getTeacherNotAllowPopup();
        if (teacherNotAllowPopup != null && !teacherNotAllowPopup.isShowing()) {
            z2 = true;
        }
        if (z2) {
            EasyPopup teacherNotAllowPopup2 = getTeacherNotAllowPopup();
            if (teacherNotAllowPopup2 != null) {
                teacherNotAllowPopup2.showAsDropDown(this.mBinding.getRoot(), -SizeUtils.dp2px(330.0f), -SizeUtils.dp2px(142.0f), 8388611);
            }
            if (getAudioControlHandler() == null) {
                FunctionPluginView functionPluginView2 = this;
                FunctionPluginView functionPluginView3 = (FunctionPluginView) new SoftReference(this).get();
                if (functionPluginView3 == null) {
                    audioControlHandler = null;
                } else {
                    Looper mainLooper = Looper.getMainLooper();
                    Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper()");
                    audioControlHandler = new AbsFunctionPluginView.AudioControlHandler(mainLooper, functionPluginView3);
                }
                setAudioControlHandler(audioControlHandler);
            }
            AbsFunctionPluginView.AudioControlHandler audioControlHandler2 = getAudioControlHandler();
            if (audioControlHandler2 != null) {
                audioControlHandler2.sendEmptyMessageDelayed(2, 5000);
            }
        }
    }

    public void showOpenMicPopUpWindow() {
        AbsFunctionPluginView.AudioControlHandler audioControlHandler;
        if (isMicOff()) {
            boolean z = false;
            if (getTeacherControlPopup() == null) {
                FunctionPluginView functionPluginView = this;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String string = getContext().getString(R.string.teacher_control_microphone);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…acher_control_microphone)");
                AbsFunctionPluginView absFunctionPluginView = this;
                TeacherControlView teacherControlView = new TeacherControlView(context, string, R.drawable.icon_microphone, R.color.color_A2AAB8, R.color.white, new AbsFunctionPluginView.TeacherControlMic(absFunctionPluginView, absFunctionPluginView));
                EasyPopup easyPopup = new EasyPopup(this.mContext);
                easyPopup.setContentView((View) teacherControlView).setWidth(XesDisplayUtil.dp2px(320.0f)).setHeight(XesDisplayUtil.dp2px(132.0f)).setFocusAndOutsideEnable(false).createPopup();
                setTeacherControlPopup(easyPopup);
            }
            EasyPopup teacherControlPopup = getTeacherControlPopup();
            if (teacherControlPopup != null && !teacherControlPopup.isShowing()) {
                z = true;
            }
            if (z) {
                EasyPopup teacherControlPopup2 = getTeacherControlPopup();
                if (teacherControlPopup2 != null) {
                    teacherControlPopup2.showAsDropDown(this.mBinding.getRoot(), -SizeUtils.dp2px(330.0f), -SizeUtils.dp2px(142.0f), 8388611);
                }
                if (getAudioControlHandler() == null) {
                    FunctionPluginView functionPluginView2 = this;
                    FunctionPluginView functionPluginView3 = (FunctionPluginView) new SoftReference(this).get();
                    if (functionPluginView3 == null) {
                        audioControlHandler = null;
                    } else {
                        Looper mainLooper = Looper.getMainLooper();
                        Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper()");
                        audioControlHandler = new AbsFunctionPluginView.AudioControlHandler(mainLooper, functionPluginView3);
                    }
                    setAudioControlHandler(audioControlHandler);
                }
                AbsFunctionPluginView.AudioControlHandler audioControlHandler2 = getAudioControlHandler();
                if (audioControlHandler2 != null) {
                    audioControlHandler2.sendEmptyMessageDelayed(1, LiveMsgPrivateRemindView.REMIND_SHOW_TIME);
                }
            }
        }
    }

    public void showOpenCameraPopUpWindow() {
        AbsFunctionPluginView.AudioControlCameraHandler audioControlCameraHandler;
        if (!isCameraOn()) {
            boolean z = false;
            if (getTeacherControlCameraPopup() == null) {
                FunctionPluginView functionPluginView = this;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String string = getContext().getString(R.string.teacher_control_camera);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.teacher_control_camera)");
                AbsFunctionPluginView absFunctionPluginView = this;
                TeacherControlView teacherControlView = new TeacherControlView(context, string, R.drawable.icon_camera, R.color.color_A2AAB8, R.color.white, new AbsFunctionPluginView.TeacherControlCamera(absFunctionPluginView, absFunctionPluginView));
                EasyPopup easyPopup = new EasyPopup(this.mContext);
                easyPopup.setContentView((View) teacherControlView).setWidth(XesDisplayUtil.dp2px(320.0f)).setHeight(XesDisplayUtil.dp2px(132.0f)).setFocusAndOutsideEnable(false).createPopup();
                setTeacherControlCameraPopup(easyPopup);
            }
            EasyPopup teacherControlCameraPopup = getTeacherControlCameraPopup();
            if (teacherControlCameraPopup != null && !teacherControlCameraPopup.isShowing()) {
                z = true;
            }
            if (z) {
                EasyPopup teacherControlCameraPopup2 = getTeacherControlCameraPopup();
                if (teacherControlCameraPopup2 != null) {
                    teacherControlCameraPopup2.showAsDropDown(this.mBinding.getRoot(), -SizeUtils.dp2px(330.0f), -SizeUtils.dp2px(142.0f), 8388611);
                }
                if (getAudioControlCameraHandler() == null) {
                    FunctionPluginView functionPluginView2 = this;
                    FunctionPluginView functionPluginView3 = (FunctionPluginView) new SoftReference(this).get();
                    if (functionPluginView3 == null) {
                        audioControlCameraHandler = null;
                    } else {
                        Looper mainLooper = Looper.getMainLooper();
                        Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper()");
                        audioControlCameraHandler = new AbsFunctionPluginView.AudioControlCameraHandler(mainLooper, functionPluginView3);
                    }
                    setAudioControlCameraHandler(audioControlCameraHandler);
                }
                AbsFunctionPluginView.AudioControlCameraHandler audioControlCameraHandler2 = getAudioControlCameraHandler();
                if (audioControlCameraHandler2 != null) {
                    audioControlCameraHandler2.sendEmptyMessageDelayed(1, LiveMsgPrivateRemindView.REMIND_SHOW_TIME);
                }
            }
        }
    }

    public void isEnableHand(boolean z) {
        if (!z) {
            this.mBinding.liveBusinessFunctionVHandUp.reset();
        }
        setHandUpState(z ? ButtonState.NORMAL : ButtonState.DISABLE);
    }

    public void emojiControls(boolean z) {
        if (z) {
            setEmojiState(ButtonState.NORMAL);
            return;
        }
        setEmojiState(ButtonState.DISABLE);
        EmojiViewPopupWindow emojiViewPopupWindow = this.mEmojiPopWindow;
        if (emojiViewPopupWindow != null) {
            emojiViewPopupWindow.dismiss();
        }
        this.currentIndex = -1;
        int length = this.sendTime.length;
        for (int i = 0; i < length; i++) {
            this.sendTime[i] = 0;
        }
        EmojiHandler emojiHandler2 = this.emojiHandler;
        if (emojiHandler2 != null) {
            emojiHandler2.setProgress(3001);
        }
        EmojiHandler emojiHandler3 = this.emojiHandler;
        if (emojiHandler3 != null) {
            emojiHandler3.sendEmptyMessage(1);
        }
    }

    /* access modifiers changed from: private */
    public final void setHandUpState(ButtonState buttonState) {
        this.mHandUpState = buttonState;
        int i = WhenMappings.$EnumSwitchMapping$0[buttonState.ordinal()];
        if (i == 1) {
            this.mBinding.liveBusinessFunctionVHandUp.setBackgroundResource(R.drawable.live_business_function_icon_raisehand_small_pad);
        } else if (i == 2) {
            this.mBinding.liveBusinessFunctionVHandUp.setBackgroundResource(R.drawable.live_business_function_icon_raisehand_small_pad_gray);
        } else if (i == 3) {
            this.mBinding.liveBusinessFunctionVHandUp.setBackgroundResource(R.drawable.live_business_function_icon_raisehand_small_pad_yellow);
        }
    }

    /* access modifiers changed from: private */
    public final void setEmojiState(ButtonState buttonState) {
        this.mEmojiState = buttonState;
        int i = WhenMappings.$EnumSwitchMapping$0[buttonState.ordinal()];
        if (i == 1) {
            this.mBinding.liveBusinessFunctionVEmoji.setImageResource(R.drawable.live_business_function_icon_emoji_small_pad);
        } else if (i == 2) {
            this.mBinding.liveBusinessFunctionVEmoji.setImageResource(R.drawable.live_business_function_icon_emoji_small_pad_close);
        } else if (i == 3) {
            this.mBinding.liveBusinessFunctionVEmoji.setImageResource(R.drawable.live_business_function_icon_emoji_small_pad_gray);
        } else if (i == 4) {
            this.mBinding.liveBusinessFunctionVEmoji.setImageResource(R.drawable.live_business_function_icon_emoji_small_pad_yellow);
        }
    }

    public void onDestroy() {
        LiveAreaContext.get().layoutObserver.removeObservers(getDriver());
        EmojiHandler emojiHandler2 = this.emojiHandler;
        if (emojiHandler2 != null) {
            emojiHandler2.removeCallbacksAndMessages((Object) null);
        }
        this.emojiHandler = null;
    }
}
