package com.tal.app.thinkacademy.business.home.main;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.flyco.roundview.RoundRelativeLayout;
import com.flyco.roundview.RoundTextView;
import com.gyf.immersionbar.ImmersionBar;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.home.R;
import com.tal.app.thinkacademy.business.home.main.api.HomeRepository;
import com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData;
import com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager;
import com.tal.app.thinkacademy.business.home.main.dialog.StoreLowWarnDialog;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.base.tab.XesFragmentTabView;
import com.tal.app.thinkacademy.common.base.tab.XesTabViewAdapter;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.LessonType;
import com.tal.app.thinkacademy.common.flutter.HwFlutterUtil;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.receiver.TimeZoneChangeReceiver;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.CommonUtilsKt;
import com.tal.app.thinkacademy.common.utils.TimeZoneUtil;
import com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo;
import com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomLayout;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 y2\u00020\u0001:\u0002xyB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020+H@ø\u0001\u0000¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020IH\u0002J\u0012\u0010J\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0018\u00010KJ\u0017\u0010L\u001a\u00020I2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010NJ\u0010\u0010O\u001a\u00020\u00122\u0006\u0010P\u001a\u000200H\u0002J(\u0010Q\u001a\u00020I2\u0006\u0010P\u001a\u0002002\u0006\u0010R\u001a\u00020\u00122\u0006\u0010S\u001a\u00020#2\u0006\u0010T\u001a\u00020#H\u0002J\b\u0010U\u001a\u00020IH\u0002J\b\u0010V\u001a\u00020IH\u0002J\b\u0010W\u001a\u00020IH\u0002J\b\u0010X\u001a\u00020IH\u0002J\b\u0010Y\u001a\u00020IH\u0002J\b\u0010Z\u001a\u00020IH\u0002J\u0010\u0010&\u001a\u00020#2\u0006\u0010[\u001a\u00020\bH\u0002J\u0006\u0010\\\u001a\u00020IJ\u000e\u0010]\u001a\u00020I2\u0006\u0010^\u001a\u00020\u0005J\u0006\u0010_\u001a\u00020IJ\b\u0010`\u001a\u00020IH\u0002J\u000e\u0010a\u001a\u00020I2\u0006\u0010[\u001a\u00020\bJ\u0018\u0010a\u001a\u00020I2\u0006\u0010b\u001a\u00020+2\b\u0010c\u001a\u0004\u0018\u00010+J\u0010\u0010d\u001a\u00020I2\b\b\u0002\u0010%\u001a\u00020#J\u001a\u0010e\u001a\u00020I2\u0006\u0010f\u001a\u00020#2\b\u0010P\u001a\u0004\u0018\u000100H\u0002J\u0010\u0010g\u001a\u00020I2\u0006\u0010P\u001a\u000200H\u0002J\u0010\u0010h\u001a\u00020I2\u0006\u0010P\u001a\u000200H\u0002J\b\u0010i\u001a\u00020IH\u0002J\u0014\u0010j\u001a\u00020I2\n\u0010k\u001a\u0006\u0012\u0002\b\u00030!H\u0002J\u0016\u0010l\u001a\u00020I2\u0006\u0010b\u001a\u00020+2\u0006\u0010m\u001a\u00020#J\b\u0010n\u001a\u00020IH\u0002J\u0010\u0010o\u001a\u00020I2\u0006\u0010p\u001a\u00020qH\u0002J\b\u0010r\u001a\u00020IH\u0002J\u0010\u0010s\u001a\u00020I2\u0006\u0010p\u001a\u00020qH\u0002J\u000e\u0010t\u001a\u00020I2\u0006\u0010F\u001a\u00020+J\u0006\u0010u\u001a\u00020IJ\u0006\u0010v\u001a\u00020IJ\b\u0010w\u001a\u00020IH\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030!0 X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006z"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/MainActivityLogic;", "", "activityProvider", "Lcom/tal/app/thinkacademy/business/home/main/MainActivityLogic$ActivityProvider;", "savedInstanceState", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/business/home/main/MainActivityLogic$ActivityProvider;Landroid/os/Bundle;)V", "KGoneStartClass", "", "KShowStartClass", "TAG", "Lcom/tal/app/thinkacademy/business/home/main/Tag;", "currentItemIndex", "getCurrentItemIndex", "()I", "setCurrentItemIndex", "(I)V", "currentStartClassState", "Lcom/tal/app/thinkacademy/business/home/main/StartClassState;", "fragmentTabView", "Lcom/tal/app/thinkacademy/common/base/tab/XesFragmentTabView;", "getFragmentTabView", "()Lcom/tal/app/thinkacademy/common/base/tab/XesFragmentTabView;", "setFragmentTabView", "(Lcom/tal/app/thinkacademy/common/base/tab/XesFragmentTabView;)V", "hiTabBottomLayout", "Lcom/tal/app/thinkacademy/lib/commui/tab/bottom/XesTabBottomLayout;", "getHiTabBottomLayout", "()Lcom/tal/app/thinkacademy/lib/commui/tab/bottom/XesTabBottomLayout;", "setHiTabBottomLayout", "(Lcom/tal/app/thinkacademy/lib/commui/tab/bottom/XesTabBottomLayout;)V", "infoList", "", "Lcom/tal/app/thinkacademy/lib/commui/tab/bottom/XesTabBottomInfo;", "isNewReport", "", "isNewStartClass", "isOnResume", "isStudyTab", "lastStartClassPlanId", "lastStartClassState", "mCurrentTabNameStringId", "mCurrentTimeZone", "", "mHandler", "Landroid/os/Handler;", "mLastReportPlanId", "mLessonReminderData", "Lcom/tal/app/thinkacademy/business/home/main/bean/LessonReminderData;", "mOnCloseClassPlanId", "mOnCloseReportPlanId", "mRemindBgIcon", "Landroid/widget/ImageView;", "mRemindBtnClose", "mRemindBtnEnter", "Lcom/flyco/roundview/RoundTextView;", "mRemindOrder", "mRemindTime", "mRemindTitle", "Landroid/widget/TextView;", "mRemindViewRoot", "Lcom/flyco/roundview/RoundRelativeLayout;", "mainDialogManager", "Lcom/tal/app/thinkacademy/business/home/main/dialog/MainDialogManager;", "repository", "Lcom/tal/app/thinkacademy/business/home/main/api/HomeRepository;", "timeZoneReceiver", "Lcom/tal/app/thinkacademy/common/receiver/TimeZoneChangeReceiver;", "apiTimezoneCheck", "Lcom/tal/app/thinkacademy/common/entity/TimeZoneCheckEntity;", "timeZone", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterClass", "", "getInfoList", "", "getLessonReminder", "currentTabName", "(Ljava/lang/Integer;)V", "getRemindSate", "data", "goToRemind", "state", "isPlanIdClosed", "isLesson", "goneClassesToRemind", "hideRemind", "initFragmentTabView", "initReminderView", "initTabBottom", "initTimeZone", "index", "onDestroy", "onSaveInstanceState", "outState", "registerTimeZoneReceiver", "requestLessonRemind", "selectTab", "tag", "classTab", "setOnResume", "setRemindData", "isSuccess", "setRemindDataLesson", "setRemindDataReport", "setRemindVisible", "setStatusBar", "tab", "setXesTabHintPoint", "show", "showClassesToRemind", "showColorfulImmersion", "activity", "Landroidx/fragment/app/FragmentActivity;", "showReportToRemind", "showWhiteImmersion", "timeZoneCheck", "timeZoneForFlutterCheck", "unRegisterTimeZoneReceiver", "updateStudyLive", "ActivityProvider", "Companion", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MainActivityLogic.kt */
public final class MainActivityLogic {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LESSON_TYPE = "LESSON";
    private static final String REPORT_TYPE = "REPORT";
    /* access modifiers changed from: private */
    public final int KGoneStartClass = 2;
    /* access modifiers changed from: private */
    public final int KShowStartClass = 1;
    /* access modifiers changed from: private */
    public final Tag TAG = Tag.MainActivity;
    /* access modifiers changed from: private */
    public final ActivityProvider activityProvider;
    private int currentItemIndex;
    private StartClassState currentStartClassState = StartClassState.Normal;
    public XesFragmentTabView fragmentTabView;
    public XesTabBottomLayout hiTabBottomLayout;
    private List<XesTabBottomInfo<?>> infoList;
    private boolean isNewReport;
    private boolean isNewStartClass = true;
    private boolean isOnResume;
    private boolean isStudyTab;
    private int lastStartClassPlanId = -1;
    private StartClassState lastStartClassState = StartClassState.Normal;
    /* access modifiers changed from: private */
    public int mCurrentTabNameStringId = -1;
    /* access modifiers changed from: private */
    public String mCurrentTimeZone = TimeZoneUtil.INSTANCE.getTimeZone();
    private Handler mHandler = new MainActivityLogic$mHandler$1(this, Looper.getMainLooper());
    private int mLastReportPlanId = -1;
    /* access modifiers changed from: private */
    public LessonReminderData mLessonReminderData;
    /* access modifiers changed from: private */
    public int mOnCloseClassPlanId = -1;
    /* access modifiers changed from: private */
    public int mOnCloseReportPlanId = -1;
    private ImageView mRemindBgIcon;
    private ImageView mRemindBtnClose;
    private RoundTextView mRemindBtnEnter;
    private RoundTextView mRemindOrder;
    private RoundTextView mRemindTime;
    private TextView mRemindTitle;
    private RoundRelativeLayout mRemindViewRoot;
    /* access modifiers changed from: private */
    public MainDialogManager mainDialogManager;
    /* access modifiers changed from: private */
    public final HomeRepository repository = new HomeRepository();
    private TimeZoneChangeReceiver timeZoneReceiver;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0002H\u0003\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u0006H&¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/MainActivityLogic$ActivityProvider;", "", "findViewById", "T", "Landroid/view/View;", "id", "", "(I)Landroid/view/View;", "getActivity", "Landroid/app/Activity;", "getActivityLifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getActivityResources", "Landroid/content/res/Resources;", "getActivitySupportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getString", "", "resId", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MainActivityLogic.kt */
    public interface ActivityProvider {
        <T extends View> T findViewById(int i);

        Activity getActivity();

        LifecycleCoroutineScope getActivityLifecycleScope();

        Resources getActivityResources();

        FragmentManager getActivitySupportFragmentManager();

        String getString(int i);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MainActivityLogic.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StartClassState.values().length];
            iArr[StartClassState.AfterClass.ordinal()] = 1;
            iArr[StartClassState.NoClasses.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MainActivityLogic(ActivityProvider activityProvider2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activityProvider2, "activityProvider");
        this.activityProvider = activityProvider2;
        if (bundle != null) {
            setCurrentItemIndex(bundle.getInt("SAVED_CURRENT_ID"));
        }
        initTabBottom();
        initReminderView();
        timeZoneForFlutterCheck();
    }

    public final XesTabBottomLayout getHiTabBottomLayout() {
        XesTabBottomLayout xesTabBottomLayout = this.hiTabBottomLayout;
        if (xesTabBottomLayout != null) {
            return xesTabBottomLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hiTabBottomLayout");
        return null;
    }

    public final void setHiTabBottomLayout(XesTabBottomLayout xesTabBottomLayout) {
        Intrinsics.checkNotNullParameter(xesTabBottomLayout, "<set-?>");
        this.hiTabBottomLayout = xesTabBottomLayout;
    }

    public final XesFragmentTabView getFragmentTabView() {
        XesFragmentTabView xesFragmentTabView = this.fragmentTabView;
        if (xesFragmentTabView != null) {
            return xesFragmentTabView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fragmentTabView");
        return null;
    }

    public final void setFragmentTabView(XesFragmentTabView xesFragmentTabView) {
        Intrinsics.checkNotNullParameter(xesFragmentTabView, "<set-?>");
        this.fragmentTabView = xesFragmentTabView;
    }

    public final int getCurrentItemIndex() {
        return this.currentItemIndex;
    }

    public final void setCurrentItemIndex(int i) {
        this.currentItemIndex = i;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/MainActivityLogic$Companion;", "", "()V", "LESSON_TYPE", "", "REPORT_TYPE", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MainActivityLogic.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        bundle.putInt("SAVED_CURRENT_ID", this.currentItemIndex);
    }

    public final List<XesTabBottomInfo<?>> getInfoList() {
        List<XesTabBottomInfo<?>> list = this.infoList;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("infoList");
        return null;
    }

    public final void timeZoneForFlutterCheck() {
        if (!PadAutoUtil.isCloseScreenLandscape()) {
            initTimeZone();
        }
    }

    private final void initTimeZone() {
        CharSequence string = ShareDataManager.getInstance().getString("time_zone", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        boolean z = false;
        if (string == null || StringsKt.isBlank(string)) {
            this.mCurrentTimeZone = TimeZoneUtil.INSTANCE.getTimeZone();
            CharSequence id = TimeZone.getDefault().getID();
            if (id == null || id.length() == 0) {
                z = true;
            }
            if (!z) {
                String id2 = TimeZone.getDefault().getID();
                Intrinsics.checkNotNullExpressionValue(id2, "getDefault().id");
                timeZoneCheck(id2);
                return;
            }
            ShareDataManager.getInstance().put("real_show_time_zone", TimeZoneUtil.INSTANCE.getBranchSchoolTimeZone(), ShareDataManager.SHAREDATA_NOT_CLEAR);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076 A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:19:0x0073, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object apiTimezoneCheck(java.lang.String r9, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.entity.TimeZoneCheckEntity> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.home.main.MainActivityLogic$apiTimezoneCheck$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$apiTimezoneCheck$1 r0 = (com.tal.app.thinkacademy.business.home.main.MainActivityLogic$apiTimezoneCheck$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$apiTimezoneCheck$1 r0 = new com.tal.app.thinkacademy.business.home.main.MainActivityLogic$apiTimezoneCheck$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0076
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0035:
            java.lang.Object r9 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r9 = (com.tal.app.thinkacademy.common.network.NetData) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0068
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.network.NetData r10 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.common.network.CommonApi> r5 = com.tal.app.thinkacademy.common.network.CommonApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.common.network.CommonApi r2 = (com.tal.app.thinkacademy.common.network.CommonApi) r2
            com.tal.app.thinkacademy.business.study.study.entity.request.TimeZoneCheckRequest r5 = new com.tal.app.thinkacademy.business.study.study.entity.request.TimeZoneCheckRequest
            com.tal.app.thinkacademy.business.study.study.entity.request.TimeZoneCheckRequestData r6 = new com.tal.app.thinkacademy.business.study.study.entity.request.TimeZoneCheckRequestData
            r6.<init>(r9)
            r5.<init>(r6)
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r9 = r2.timeZoneCheck(r5, r0)
            if (r9 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0068:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r10 = r9.transform(r10, r0)
            if (r10 != r1) goto L_0x0076
            return r1
        L_0x0076:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.MainActivityLogic.apiTimezoneCheck(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void timeZoneCheck(String str) {
        Intrinsics.checkNotNullParameter(str, "timeZone");
        BuildersKt.launch$default(this.activityProvider.getActivityLifecycleScope(), new HandlerException(new MainActivityLogic$timeZoneCheck$1()), (CoroutineStart) null, new MainActivityLogic$timeZoneCheck$2(this, str, (Continuation<? super MainActivityLogic$timeZoneCheck$2>) null), 2, (Object) null);
    }

    private final void initTabBottom() {
        int i;
        setHiTabBottomLayout(this.activityProvider.findViewById(R.id.tab_bottom_layout));
        getHiTabBottomLayout().setTabAlpha(0.85f);
        this.infoList = new ArrayList();
        int color = this.activityProvider.getActivityResources().getColor(R.color.color_a2aab8);
        int color2 = this.activityProvider.getActivityResources().getColor(R.color.color_ffaa0a);
        List<XesTabBottomInfo<?>> list = null;
        if (!PadUtils.isPad(Utils.getApp())) {
            XesTabBottomInfo xesTabBottomInfo = new XesTabBottomInfo(R.string.tab_mall, R.drawable.icon_shop_selected, R.drawable.icon_shop_normal, Integer.valueOf(color), Integer.valueOf(color2), "TAB_SHOP");
            xesTabBottomInfo.fragment = XesRoute.getSupportFragment("/shop/shop_home_native_fragment");
            List<XesTabBottomInfo<?>> list2 = this.infoList;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("infoList");
                list2 = null;
            }
            list2.add(xesTabBottomInfo);
        }
        XesTabBottomInfo xesTabBottomInfo2 = new XesTabBottomInfo(R.string.tab_class, R.drawable.select_learning, R.drawable.default_learning, Integer.valueOf(color), Integer.valueOf(color2), "TAB_STUDY");
        if (PadAutoUtil.isCloseScreenLandscape()) {
            xesTabBottomInfo2.fragment = XesRoute.getSupportFragment("/study/study_fragment");
        } else if (PadUtils.isPad(Utils.getApp())) {
            xesTabBottomInfo2.fragment = HwFlutterUtil.INSTANCE.getHwFlutterFragment("padHome");
        } else {
            xesTabBottomInfo2.fragment = HwFlutterUtil.INSTANCE.getHwFlutterFragment("phoneHome");
        }
        List<XesTabBottomInfo<?>> list3 = this.infoList;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoList");
            list3 = null;
        }
        list3.add(xesTabBottomInfo2);
        boolean z = false;
        if (!PadUtils.isPad(Utils.getApp())) {
            try {
                String string = ShareDataManager.getInstance().getString("school_code", "0", ShareDataManager.SHAREDATA_NOT_CLEAR);
                Intrinsics.checkNotNullExpressionValue(string, "getInstance()\n          …ager.SHAREDATA_NOT_CLEAR)");
                i = Integer.parseInt(string);
            } catch (Exception unused) {
                i = 0;
            }
            if (SchoolConstants.INSTANCE.isShowStudyData(i)) {
                XesTabBottomInfo xesTabBottomInfo3 = new XesTabBottomInfo(R.string.tab_discover, R.drawable.icon_data_selected, R.drawable.icon_data_default, Integer.valueOf(color), Integer.valueOf(color2), "TAB_DATA");
                xesTabBottomInfo3.fragment = XesRoute.getSupportFragment("/home/data_fragment");
                List<XesTabBottomInfo<?>> list4 = this.infoList;
                if (list4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("infoList");
                    list4 = null;
                }
                list4.add(xesTabBottomInfo3);
            }
        }
        XesTabBottomInfo xesTabBottomInfo4 = new XesTabBottomInfo(R.string.tab_mine, R.drawable.select_my_courses, R.drawable.default_my_courses, Integer.valueOf(color), Integer.valueOf(color2), "TAB_ME");
        xesTabBottomInfo4.fragment = XesRoute.getSupportFragment("/me/me_fragment");
        List<XesTabBottomInfo<?>> list5 = this.infoList;
        if (list5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoList");
            list5 = null;
        }
        list5.add(xesTabBottomInfo4);
        XesTabBottomLayout hiTabBottomLayout2 = getHiTabBottomLayout();
        if (PadUtils.isPad(Utils.getApp()) && !PadAutoUtil.isCloseScreenLandscape()) {
            z = true;
        }
        List<XesTabBottomInfo<?>> list6 = this.infoList;
        if (list6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoList");
            list6 = null;
        }
        hiTabBottomLayout2.inflateInfo(list6, z);
        initFragmentTabView();
        hiTabBottomLayout2.addTabSelectedChangeListener(new MainActivityLogic$$ExternalSyntheticLambda0(this));
        List<XesTabBottomInfo<?>> list7 = this.infoList;
        if (list7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoList");
        } else {
            list = list7;
        }
        hiTabBottomLayout2.defaultSelected((XesTabBottomInfo) list.get(getCurrentItemIndex()));
        hiTabBottomLayout2.getViewTreeObserver().addOnGlobalLayoutListener(new MainActivityLogic$initTabBottom$1$2(hiTabBottomLayout2, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initTabBottom$lambda-2$lambda-1  reason: not valid java name */
    public static final void m35initTabBottom$lambda2$lambda1(MainActivityLogic mainActivityLogic, int i, XesTabBottomInfo xesTabBottomInfo, XesTabBottomInfo xesTabBottomInfo2) {
        Intrinsics.checkNotNullParameter(mainActivityLogic, "this$0");
        Intrinsics.checkNotNullParameter(xesTabBottomInfo2, "nextInfo");
        mainActivityLogic.getFragmentTabView().setCurrentItem(i);
        mainActivityLogic.isStudyTab = mainActivityLogic.isStudyTab(i);
        XesDataBus.with("study_tab_visible").setStickyData(Boolean.valueOf(mainActivityLogic.isStudyTab && mainActivityLogic.isOnResume));
        mainActivityLogic.currentItemIndex = i;
        mainActivityLogic.setStatusBar(xesTabBottomInfo2);
        mainActivityLogic.getLessonReminder(Integer.valueOf(xesTabBottomInfo2.tabNameStringId));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setStatusBar(com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo<?> r5) {
        /*
            r4 = this;
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r0 = r4.activityProvider
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            java.lang.String r5 = r5.tabTag
            r1 = 2
            r2 = 0
            if (r5 == 0) goto L_0x0059
            int r3 = r5.hashCode()
            switch(r3) {
                case -1828029790: goto L_0x004a;
                case -95273420: goto L_0x003e;
                case -94819968: goto L_0x0026;
                case 1355911263: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0059
        L_0x0012:
            java.lang.String r3 = "TAB_STUDY"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L_0x001b
            goto L_0x0059
        L_0x001b:
            r4.showWhiteImmersion(r0)
            java.lang.String r5 = "click_app_learning_tab"
            com.tal.app.thinkacademy.common.utils.LeanplumUtil.commonTrack$default(r5, r2, r1, r2)
            java.lang.String r2 = "课程"
            goto L_0x0061
        L_0x0026:
            java.lang.String r3 = "TAB_SHOP"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L_0x002f
            goto L_0x0059
        L_0x002f:
            r4.showWhiteImmersion(r0)
            com.tal.app.thinkacademy.common.business.browser.cache.HwWebViewCacheManager$Companion r5 = com.tal.app.thinkacademy.common.business.browser.cache.HwWebViewCacheManager.Companion
            com.tal.app.thinkacademy.common.business.browser.cache.HwWebViewCacheManager r5 = r5.getInstance()
            r5.preLoadWeb()
            java.lang.String r2 = "商城"
            goto L_0x0061
        L_0x003e:
            java.lang.String r3 = "TAB_DATA"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L_0x0047
            goto L_0x0059
        L_0x0047:
            java.lang.String r2 = "资料站"
            goto L_0x0061
        L_0x004a:
            java.lang.String r3 = "TAB_ME"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L_0x0053
            goto L_0x0059
        L_0x0053:
            r4.showWhiteImmersion(r0)
            java.lang.String r2 = "个人中心"
            goto L_0x0061
        L_0x0059:
            r4.showColorfulImmersion(r0)
            java.lang.String r5 = "click_app_portal_tab"
            com.tal.app.thinkacademy.common.utils.LeanplumUtil.commonTrack$default(r5, r2, r1, r2)
        L_0x0061:
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x006f
            int r5 = r5.length()
            if (r5 != 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r5 = 0
            goto L_0x0070
        L_0x006f:
            r5 = 1
        L_0x0070:
            if (r5 != 0) goto L_0x0077
            com.tal.app.thinkacademy.business.home.main.LaunchTrack r5 = com.tal.app.thinkacademy.business.home.main.LaunchTrack.INSTANCE
            r5.tabClick(r2)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.MainActivityLogic.setStatusBar(com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo):void");
    }

    private final void showWhiteImmersion(FragmentActivity fragmentActivity) {
        ImmersionBar.with((Activity) fragmentActivity).keyboardEnable(false).statusBarDarkFont(true).navigationBarColor(R.color.white).navigationBarDarkIcon(true).init();
    }

    private final void showColorfulImmersion(FragmentActivity fragmentActivity) {
        ImmersionBar.with((Activity) fragmentActivity).keyboardEnable(false).statusBarDarkFont(false).navigationBarColor(R.color.white).navigationBarDarkIcon(true).init();
    }

    public final void selectTab(int i) {
        XesTabBottomLayout hiTabBottomLayout2 = getHiTabBottomLayout();
        List<XesTabBottomInfo<?>> list = this.infoList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoList");
            list = null;
        }
        hiTabBottomLayout2.defaultSelected((XesTabBottomInfo) list.get(i));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateStudyLive() {
        /*
            r5 = this;
            java.util.List<com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo<?>> r0 = r5.infoList
            r1 = 0
            if (r0 != 0) goto L_0x000b
            java.lang.String r0 = "infoList"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r1
        L_0x000b:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0011:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0029
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo r3 = (com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo) r3
            java.lang.String r3 = r3.tabTag
            java.lang.String r4 = "TAB_STUDY"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0011
            r1 = r2
        L_0x0029:
            com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo r1 = (com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo) r1
            if (r1 != 0) goto L_0x002e
            goto L_0x003c
        L_0x002e:
            java.lang.String r0 = "study_tab_live_update"
            com.tal.app.thinkacademy.lib.utils.StickyLiveData r0 = com.tal.app.thinkacademy.lib.utils.XesDataBus.with(r0)
            r1 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r0.setStickyData(r1)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.MainActivityLogic.updateStudyLive():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void selectTab(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "tag"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.List<com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo<?>> r0 = r4.infoList
            r1 = 0
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "infoList"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r1
        L_0x0010:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0016:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002c
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo r3 = (com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo) r3
            java.lang.String r3 = r3.tabTag
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0016
            r1 = r2
        L_0x002c:
            com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo r1 = (com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo) r1
            if (r1 != 0) goto L_0x0031
            goto L_0x0069
        L_0x0031:
            com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomLayout r0 = r4.getHiTabBottomLayout()
            r0.defaultSelected(r1)
            java.lang.String r0 = "TAB_STUDY"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
            if (r5 == 0) goto L_0x0069
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r5 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r5 = r5.getInstance()
            boolean r5 = r5.isGuest()
            if (r5 != 0) goto L_0x0069
            r5 = r6
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x005a
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            if (r5 == 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r5 = 0
            goto L_0x005b
        L_0x005a:
            r5 = 1
        L_0x005b:
            if (r5 != 0) goto L_0x0069
            java.lang.String r5 = "study_tab_switch"
            com.tal.app.thinkacademy.lib.utils.StickyLiveData r5 = com.tal.app.thinkacademy.lib.utils.XesDataBus.with(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r5.setStickyData(r6)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.MainActivityLogic.selectTab(java.lang.String, java.lang.String):void");
    }

    private final boolean isStudyTab(int i) {
        if (i < 0) {
            return false;
        }
        List<XesTabBottomInfo<?>> list = this.infoList;
        List<XesTabBottomInfo<?>> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoList");
            list = null;
        }
        if (i >= list.size()) {
            return false;
        }
        List<XesTabBottomInfo<?>> list3 = this.infoList;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoList");
        } else {
            list2 = list3;
        }
        return Intrinsics.areEqual((Object) ((XesTabBottomInfo) list2.get(i)).tabTag, (Object) "TAB_STUDY");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setXesTabHintPoint(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            java.lang.String r0 = "tag"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.List<com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo<?>> r0 = r4.infoList
            r1 = 0
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "infoList"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r1
        L_0x0010:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0016:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo r3 = (com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo) r3
            java.lang.String r3 = r3.tabTag
            if (r3 != r5) goto L_0x0029
            r3 = 1
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            if (r3 == 0) goto L_0x0016
            r1 = r2
        L_0x002d:
            com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo r1 = (com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo) r1
            if (r1 != 0) goto L_0x0032
            goto L_0x0040
        L_0x0032:
            com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomLayout r5 = r4.getHiTabBottomLayout()
            com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottom r5 = r5.findTab(r1)
            if (r5 != 0) goto L_0x003d
            goto L_0x0040
        L_0x003d:
            r5.setXesTabHintPoint(r6)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.MainActivityLogic.setXesTabHintPoint(java.lang.String, boolean):void");
    }

    private final void initFragmentTabView() {
        FragmentManager activitySupportFragmentManager = this.activityProvider.getActivitySupportFragmentManager();
        List<XesTabBottomInfo<?>> list = this.infoList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoList");
            list = null;
        }
        XesTabViewAdapter xesTabViewAdapter = new XesTabViewAdapter(activitySupportFragmentManager, list);
        setFragmentTabView(this.activityProvider.findViewById(R.id.fragment_tab_view));
        getFragmentTabView().setAdapter(xesTabViewAdapter);
    }

    public final void onDestroy() {
        MainDialogManager mainDialogManager2 = this.mainDialogManager;
        if (mainDialogManager2 != null) {
            mainDialogManager2.cancelChain();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler = null;
    }

    public static /* synthetic */ void setOnResume$default(MainActivityLogic mainActivityLogic, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        mainActivityLogic.setOnResume(z);
    }

    public final void setOnResume(boolean z) {
        this.isOnResume = z;
        XesDataBus.with("study_tab_visible").setStickyData(Boolean.valueOf(this.isStudyTab && z));
        if (!z) {
            return;
        }
        if (!UserInfoBll.Companion.getInstance().isGuest()) {
            XesLog.i(this.TAG, new Object[]{"已登录，去请求开课提醒接口"});
            getLessonReminder$default(this, (Integer) null, 1, (Object) null);
            return;
        }
        XesLog.i(this.TAG, new Object[]{"未登录，隐藏开课提醒"});
        goneClassesToRemind();
    }

    private final void initReminderView() {
        this.mRemindViewRoot = this.activityProvider.findViewById(R.id.classesToRemind);
        this.mRemindBtnClose = (ImageView) this.activityProvider.findViewById(R.id.ivStartClassClose);
        this.mRemindBtnEnter = this.activityProvider.findViewById(R.id.tvStartClassEnter);
        this.mRemindOrder = this.activityProvider.findViewById(R.id.tvOrder);
        this.mRemindTime = this.activityProvider.findViewById(R.id.tvTime);
        this.mRemindTitle = (TextView) this.activityProvider.findViewById(R.id.tvStartClassTitle);
        this.mRemindBgIcon = (ImageView) this.activityProvider.findViewById(R.id.startClassIvBg);
        ImageView imageView = this.mRemindBtnClose;
        if (imageView != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(imageView, 500, new MainActivityLogic$initReminderView$1(this));
        }
        View view = this.mRemindBtnEnter;
        if (view != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(view, 500, new MainActivityLogic$initReminderView$2(this));
        }
        if (PadUtils.isPad(this.activityProvider.getActivity())) {
            RoundRelativeLayout roundRelativeLayout = this.mRemindViewRoot;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) (roundRelativeLayout == null ? null : roundRelativeLayout.getLayoutParams());
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = 0;
                marginLayoutParams.setMarginStart(SizeUtils.dp2px(49.0f));
            }
        }
    }

    public static /* synthetic */ void getLessonReminder$default(MainActivityLogic mainActivityLogic, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = -1;
        }
        mainActivityLogic.getLessonReminder(num);
    }

    public final void getLessonReminder(Integer num) {
        if (num != null && num.intValue() > 0) {
            this.mCurrentTabNameStringId = num.intValue();
        }
        if (!UserInfoBll.Companion.getInstance().isGuest()) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            requestLessonRemind();
        }
    }

    private final void requestLessonRemind() {
        BuildersKt.launch$default(this.activityProvider.getActivityLifecycleScope(), new HandlerException(new MainActivityLogic$requestLessonRemind$1$1(this)), (CoroutineStart) null, new MainActivityLogic$requestLessonRemind$1$2(this, (Continuation<? super MainActivityLogic$requestLessonRemind$1$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void setRemindData(boolean z, LessonReminderData lessonReminderData) {
        Unit unit;
        if (z) {
            if (lessonReminderData == null) {
                unit = null;
            } else {
                String type = lessonReminderData.getType();
                if (Intrinsics.areEqual((Object) type, (Object) LESSON_TYPE)) {
                    XesLog.i(this.TAG, new Object[]{"setRemindData 课程提醒"});
                    setRemindDataLesson(lessonReminderData);
                } else if (Intrinsics.areEqual((Object) type, (Object) REPORT_TYPE)) {
                    XesLog.i(this.TAG, new Object[]{"setRemindData 课程报告"});
                    setRemindDataReport(lessonReminderData);
                } else {
                    XesLog.i(this.TAG, new Object[]{"setRemindData 不支持的类型"});
                    goneClassesToRemind();
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                MainActivityLogic mainActivityLogic = this;
                goneClassesToRemind();
                XesLog.i(this.TAG, new Object[]{"setRemindData 获取数据失败 data is null"});
                return;
            }
            return;
        }
        goneClassesToRemind();
        XesLog.i(this.TAG, new Object[]{"setRemindData 获取数据失败"});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001f, code lost:
        r2 = r2.getPlanId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setRemindDataLesson(com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData r9) {
        /*
            r8 = this;
            r8.mLessonReminderData = r9
            com.tal.app.thinkacademy.business.home.main.Tag r0 = com.tal.app.thinkacademy.business.home.main.Tag.MainActivity
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "开课提醒，数据获取成功"
            r4 = 0
            r2[r4] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
            com.tal.app.thinkacademy.business.home.main.StartClassState r0 = r8.getRemindSate(r9)
            r8.currentStartClassState = r0
            int r0 = r8.lastStartClassPlanId
            com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData r2 = r8.mLessonReminderData
            if (r2 != 0) goto L_0x001f
        L_0x001d:
            r0 = r4
            goto L_0x002d
        L_0x001f:
            java.lang.Integer r2 = r2.getPlanId()
            if (r2 != 0) goto L_0x0026
            goto L_0x001d
        L_0x0026:
            int r2 = r2.intValue()
            if (r0 != r2) goto L_0x001d
            r0 = r1
        L_0x002d:
            if (r0 != 0) goto L_0x008e
            r8.isNewStartClass = r1
            int r0 = r8.lastStartClassPlanId
            java.lang.String r2 = ",currentPlanId="
            if (r0 <= 0) goto L_0x0064
            com.tal.app.thinkacademy.business.home.main.Tag r0 = r8.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "开课提醒，需要刷新课程列表,不是第一次，上次PlanId跟本次的不一样 lastPlanId="
            r5.append(r6)
            int r6 = r8.lastStartClassPlanId
            r5.append(r6)
            r5.append(r2)
            java.lang.Integer r2 = r9.getPlanId()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r3[r4] = r2
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r3)
            r8.updateStudyLive()
            goto L_0x014d
        L_0x0064:
            com.tal.app.thinkacademy.business.home.main.Tag r0 = r8.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "开课提醒，不需要刷新课程列表,第一次，上次PlanId跟本次的不一样 lastPlanId="
            r5.append(r6)
            int r6 = r8.lastStartClassPlanId
            r5.append(r6)
            r5.append(r2)
            java.lang.Integer r2 = r9.getPlanId()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r3[r4] = r2
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r3)
            goto L_0x014d
        L_0x008e:
            r8.isNewStartClass = r4
            com.tal.app.thinkacademy.business.home.main.StartClassState r0 = r8.lastStartClassState
            com.tal.app.thinkacademy.business.home.main.StartClassState r2 = r8.currentStartClassState
            java.lang.String r3 = ",本次="
            if (r0 == r2) goto L_0x0113
            com.tal.app.thinkacademy.business.home.main.StartClassState r2 = com.tal.app.thinkacademy.business.home.main.StartClassState.Normal
            java.lang.String r5 = ",但是状态不一样,上次="
            if (r0 == r2) goto L_0x00da
            com.tal.app.thinkacademy.business.home.main.Tag r0 = r8.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "开课提醒，需要刷新课程列表，上次PlanId跟本次的一样,currentPlanId="
            r6.append(r7)
            java.lang.Integer r7 = r9.getPlanId()
            r6.append(r7)
            r6.append(r5)
            com.tal.app.thinkacademy.business.home.main.StartClassState r5 = r8.lastStartClassState
            java.lang.String r5 = r5.getStateName()
            r6.append(r5)
            r6.append(r3)
            com.tal.app.thinkacademy.business.home.main.StartClassState r3 = r8.currentStartClassState
            java.lang.String r3 = r3.getStateName()
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            r2[r4] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
            r8.updateStudyLive()
            goto L_0x014d
        L_0x00da:
            com.tal.app.thinkacademy.business.home.main.Tag r0 = r8.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "开课提醒，不需要刷新课程列表，上次是初始状态，上次PlanId跟本次的一样,currentPlanId="
            r6.append(r7)
            java.lang.Integer r7 = r9.getPlanId()
            r6.append(r7)
            r6.append(r5)
            com.tal.app.thinkacademy.business.home.main.StartClassState r5 = r8.lastStartClassState
            java.lang.String r5 = r5.getStateName()
            r6.append(r5)
            r6.append(r3)
            com.tal.app.thinkacademy.business.home.main.StartClassState r3 = r8.currentStartClassState
            java.lang.String r3 = r3.getStateName()
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            r2[r4] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
            goto L_0x014d
        L_0x0113:
            com.tal.app.thinkacademy.business.home.main.Tag r0 = r8.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "开课提醒，不需要刷新课程列表，上次PlanId跟本次的一样,currentPlanId="
            r5.append(r6)
            java.lang.Integer r6 = r9.getPlanId()
            r5.append(r6)
            java.lang.String r6 = ",状态也一样,上次="
            r5.append(r6)
            com.tal.app.thinkacademy.business.home.main.StartClassState r6 = r8.lastStartClassState
            java.lang.String r6 = r6.getStateName()
            r5.append(r6)
            r5.append(r3)
            com.tal.app.thinkacademy.business.home.main.StartClassState r3 = r8.currentStartClassState
            java.lang.String r3 = r3.getStateName()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r2[r4] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
        L_0x014d:
            com.tal.app.thinkacademy.business.home.main.StartClassState r0 = r8.currentStartClassState
            r8.lastStartClassState = r0
            com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData r0 = r8.mLessonReminderData
            r2 = -1
            if (r0 != 0) goto L_0x0157
            goto L_0x0162
        L_0x0157:
            java.lang.Integer r0 = r0.getPlanId()
            if (r0 != 0) goto L_0x015e
            goto L_0x0162
        L_0x015e:
            int r2 = r0.intValue()
        L_0x0162:
            r8.lastStartClassPlanId = r2
            int r0 = r8.mOnCloseClassPlanId
            java.lang.Integer r2 = r9.getPlanId()
            if (r2 != 0) goto L_0x016d
            goto L_0x0181
        L_0x016d:
            int r2 = r2.intValue()
            if (r0 != r2) goto L_0x0181
            com.tal.app.thinkacademy.business.home.main.Tag r0 = com.tal.app.thinkacademy.business.home.main.Tag.MainActivity
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "当前planid的课已经被用户主动关闭"
            r2[r4] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
            r4 = r1
        L_0x0181:
            com.tal.app.thinkacademy.business.home.main.StartClassState r0 = r8.currentStartClassState
            r8.goToRemind(r9, r0, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.MainActivityLogic.setRemindDataLesson(com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001d, code lost:
        r3 = r3.getPlanId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setRemindDataReport(com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData r7) {
        /*
            r6 = this;
            r6.mLessonReminderData = r7
            com.tal.app.thinkacademy.business.home.main.Tag r0 = com.tal.app.thinkacademy.business.home.main.Tag.MainActivity
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "开课提醒，课程报告，数据获取成功"
            r4 = 0
            r2[r4] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
            com.tal.app.thinkacademy.business.home.main.StartClassState r0 = r6.getRemindSate(r7)
            int r2 = r6.mLastReportPlanId
            com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData r3 = r6.mLessonReminderData
            if (r3 != 0) goto L_0x001d
        L_0x001b:
            r2 = r4
            goto L_0x002b
        L_0x001d:
            java.lang.Integer r3 = r3.getPlanId()
            if (r3 != 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            int r3 = r3.intValue()
            if (r2 != r3) goto L_0x001b
            r2 = r1
        L_0x002b:
            r2 = r2 ^ r1
            r6.isNewReport = r2
            java.lang.Integer r2 = r7.getPlanId()
            if (r2 != 0) goto L_0x0036
            r2 = -1
            goto L_0x003a
        L_0x0036:
            int r2 = r2.intValue()
        L_0x003a:
            r6.mLastReportPlanId = r2
            int r2 = r6.mOnCloseReportPlanId
            java.lang.Integer r3 = r7.getPlanId()
            if (r3 != 0) goto L_0x0045
            goto L_0x0059
        L_0x0045:
            int r3 = r3.intValue()
            if (r2 != r3) goto L_0x0059
            com.tal.app.thinkacademy.business.home.main.Tag r2 = com.tal.app.thinkacademy.business.home.main.Tag.MainActivity
            com.tal.app.thinkacademy.lib.logger.XesLogTag r2 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r2
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.String r5 = "当前planid的课程报告已经被用户主动关闭"
            r3[r4] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r2, r3)
            goto L_0x005a
        L_0x0059:
            r1 = r4
        L_0x005a:
            r6.goToRemind(r7, r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.MainActivityLogic.setRemindDataReport(com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData):void");
    }

    private final void goToRemind(LessonReminderData lessonReminderData, StartClassState startClassState, boolean z, boolean z2) {
        int i = WhenMappings.$EnumSwitchMapping$0[startClassState.ordinal()];
        if (i == 1) {
            XesLog.i(Tag.MainActivity, new Object[]{"已经过了进课的最晚时间"});
            goneClassesToRemind();
        } else if (i == 2) {
            XesLog.i(Tag.MainActivity, new Object[]{"课程不到展示开课提醒时间"});
            goneClassesToRemind();
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(this.KShowStartClass, lessonReminderData.getStartShowTime() - lessonReminderData.getServerTime());
            }
        } else if (z) {
            XesLog.i(Tag.MainActivity, new Object[]{"planId=" + lessonReminderData.getPlanId() + "已经被关闭过"});
            goneClassesToRemind();
            Handler handler2 = this.mHandler;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(this.KGoneStartClass, lessonReminderData.getEndShowTime() - lessonReminderData.getServerTime());
            }
        } else if (z2) {
            XesLog.i(Tag.MainActivity, new Object[]{"可以展示开课提醒"});
            showClassesToRemind();
        } else {
            XesLog.i(Tag.MainActivity, new Object[]{"可以展示课程报告提醒"});
            showReportToRemind();
        }
    }

    private final StartClassState getRemindSate(LessonReminderData lessonReminderData) {
        if (lessonReminderData.getServerTime() >= lessonReminderData.getEndShowTime()) {
            return StartClassState.AfterClass;
        }
        if (lessonReminderData.getServerTime() < lessonReminderData.getStartShowTime()) {
            return StartClassState.NoClasses;
        }
        return StartClassState.InTheClass;
    }

    private final void goneClassesToRemind() {
        RoundRelativeLayout roundRelativeLayout = this.mRemindViewRoot;
        if (roundRelativeLayout != null) {
            roundRelativeLayout.setVisibility(8);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void hideRemind() {
        RoundRelativeLayout roundRelativeLayout = this.mRemindViewRoot;
        if (roundRelativeLayout != null) {
            roundRelativeLayout.setVisibility(8);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00cb, code lost:
        if ((r1 != null && r1.getVisibility() == 0) != false) goto L_0x00cd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void showClassesToRemind() {
        /*
            r8 = this;
            com.flyco.roundview.RoundRelativeLayout r0 = r8.mRemindViewRoot
            r1 = 0
            if (r0 != 0) goto L_0x0007
            r0 = r1
            goto L_0x000b
        L_0x0007:
            com.flyco.roundview.RoundViewDelegate r0 = r0.getDelegate()
        L_0x000b:
            if (r0 != 0) goto L_0x000e
            goto L_0x001d
        L_0x000e:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r8.activityProvider
            android.content.res.Resources r2 = r2.getActivityResources()
            int r3 = com.tal.app.thinkacademy.business.home.R.color.color_FFEAC1
            int r2 = r2.getColor(r3, r1)
            r0.setBackgroundColor(r2)
        L_0x001d:
            android.widget.ImageView r0 = r8.mRemindBgIcon
            if (r0 != 0) goto L_0x0022
            goto L_0x0027
        L_0x0022:
            int r2 = com.tal.app.thinkacademy.business.home.R.drawable.live_home_icon_startclass_bg
            r0.setBackgroundResource(r2)
        L_0x0027:
            com.flyco.roundview.RoundTextView r0 = r8.mRemindOrder
            if (r0 != 0) goto L_0x002d
            r0 = r1
            goto L_0x0031
        L_0x002d:
            com.flyco.roundview.RoundViewDelegate r0 = r0.getDelegate()
        L_0x0031:
            if (r0 != 0) goto L_0x0034
            goto L_0x0043
        L_0x0034:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r8.activityProvider
            android.content.res.Resources r2 = r2.getActivityResources()
            int r3 = com.tal.app.thinkacademy.business.home.R.color.color_FF9F0A
            int r2 = r2.getColor(r3, r1)
            r0.setBackgroundColor(r2)
        L_0x0043:
            com.flyco.roundview.RoundTextView r0 = r8.mRemindTime
            if (r0 != 0) goto L_0x0048
            goto L_0x0057
        L_0x0048:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r8.activityProvider
            android.content.res.Resources r2 = r2.getActivityResources()
            int r3 = com.tal.app.thinkacademy.business.home.R.color.color_FF9F0A
            int r2 = r2.getColor(r3, r1)
            r0.setTextColor(r2)
        L_0x0057:
            com.flyco.roundview.RoundTextView r0 = r8.mRemindTime
            if (r0 != 0) goto L_0x005d
            r0 = r1
            goto L_0x0061
        L_0x005d:
            com.flyco.roundview.RoundViewDelegate r0 = r0.getDelegate()
        L_0x0061:
            if (r0 != 0) goto L_0x0064
            goto L_0x0073
        L_0x0064:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r8.activityProvider
            android.content.res.Resources r2 = r2.getActivityResources()
            int r3 = com.tal.app.thinkacademy.business.home.R.color.color_FFA51B
            int r2 = r2.getColor(r3, r1)
            r0.setStrokeColor(r2)
        L_0x0073:
            android.widget.TextView r0 = r8.mRemindTitle
            if (r0 != 0) goto L_0x0078
            goto L_0x0087
        L_0x0078:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r8.activityProvider
            android.content.res.Resources r2 = r2.getActivityResources()
            int r3 = com.tal.app.thinkacademy.business.home.R.color.color_CB6000
            int r2 = r2.getColor(r3, r1)
            r0.setTextColor(r2)
        L_0x0087:
            com.flyco.roundview.RoundTextView r0 = r8.mRemindBtnEnter
            if (r0 != 0) goto L_0x008d
            r0 = r1
            goto L_0x0091
        L_0x008d:
            com.flyco.roundview.RoundViewDelegate r0 = r0.getDelegate()
        L_0x0091:
            if (r0 != 0) goto L_0x0094
            goto L_0x00a3
        L_0x0094:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r8.activityProvider
            android.content.res.Resources r2 = r2.getActivityResources()
            int r3 = com.tal.app.thinkacademy.business.home.R.color.color_FF9F0A
            int r1 = r2.getColor(r3, r1)
            r0.setBackgroundColor(r1)
        L_0x00a3:
            com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData r0 = r8.mLessonReminderData
            if (r0 != 0) goto L_0x00a9
            goto L_0x018d
        L_0x00a9:
            com.flyco.roundview.RoundRelativeLayout r1 = r8.mRemindViewRoot
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x00b1
        L_0x00af:
            r1 = r3
            goto L_0x00b8
        L_0x00b1:
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x00af
            r1 = r2
        L_0x00b8:
            if (r1 == 0) goto L_0x00cd
            boolean r1 = r8.isNewStartClass
            if (r1 == 0) goto L_0x00da
            com.flyco.roundview.RoundRelativeLayout r1 = r8.mRemindViewRoot
            if (r1 != 0) goto L_0x00c4
        L_0x00c2:
            r1 = r3
            goto L_0x00cb
        L_0x00c4:
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x00c2
            r1 = r2
        L_0x00cb:
            if (r1 == 0) goto L_0x00da
        L_0x00cd:
            com.tal.app.thinkacademy.business.home.main.LaunchTrack r1 = com.tal.app.thinkacademy.business.home.main.LaunchTrack.INSTANCE
            java.lang.Integer r4 = r0.getPlanId()
            java.lang.String r5 = r0.getLessonType()
            r1.hw_class_reminder_show(r4, r5)
        L_0x00da:
            com.flyco.roundview.RoundTextView r1 = r8.mRemindOrder
            if (r1 != 0) goto L_0x00df
            goto L_0x0116
        L_0x00df:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r4 = r8.activityProvider
            android.app.Activity r4 = r4.getActivity()
            int r5 = com.tal.app.thinkacademy.business.home.R.string.start_class_lesson
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.Integer r7 = r0.getLessonNum()
            if (r7 != 0) goto L_0x00f0
            goto L_0x00f4
        L_0x00f0:
            int r2 = r7.intValue()
        L_0x00f4:
            r7 = 10
            if (r2 >= r7) goto L_0x0103
            java.lang.Integer r2 = r0.getLessonNum()
            java.lang.String r7 = "0"
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r2)
            goto L_0x010b
        L_0x0103:
            java.lang.Integer r2 = r0.getLessonNum()
            java.lang.String r2 = java.lang.String.valueOf(r2)
        L_0x010b:
            r6[r3] = r2
            java.lang.String r2 = r4.getString(r5, r6)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x0116:
            com.flyco.roundview.RoundTextView r1 = r8.mRemindTime
            if (r1 != 0) goto L_0x011b
            goto L_0x013c
        L_0x011b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r0.getFormattedStartTime()
            r2.append(r3)
            r3 = 45
            r2.append(r3)
            java.lang.String r3 = r0.getFormattedEndTime()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x013c:
            android.widget.TextView r1 = r8.mRemindTitle
            if (r1 != 0) goto L_0x0141
            goto L_0x014a
        L_0x0141:
            java.lang.String r2 = r0.getLessonName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x014a:
            com.flyco.roundview.RoundTextView r1 = r8.mRemindBtnEnter
            if (r1 != 0) goto L_0x014f
            goto L_0x0177
        L_0x014f:
            java.lang.String r2 = r0.getLessonType()
            com.tal.app.thinkacademy.common.entity.LessonType r3 = com.tal.app.thinkacademy.common.entity.LessonType.AUDITION
            java.lang.String r3 = r3.name()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x016a
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r8.activityProvider
            int r3 = com.tal.app.thinkacademy.business.home.R.string.start_auditing
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x0174
        L_0x016a:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r8.activityProvider
            int r3 = com.tal.app.thinkacademy.business.home.R.string.enter
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L_0x0174:
            r1.setText(r2)
        L_0x0177:
            r8.setRemindVisible()
            android.os.Handler r1 = r8.mHandler
            if (r1 != 0) goto L_0x017f
            goto L_0x018d
        L_0x017f:
            int r2 = r8.KGoneStartClass
            long r3 = r0.getEndShowTime()
            long r5 = r0.getServerTime()
            long r3 = r3 - r5
            r1.sendEmptyMessageDelayed(r2, r3)
        L_0x018d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.MainActivityLogic.showClassesToRemind():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00cd, code lost:
        if ((r1 != null && r1.getVisibility() == 0) != false) goto L_0x00cf;
     */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void showReportToRemind() {
        /*
            r10 = this;
            com.flyco.roundview.RoundRelativeLayout r0 = r10.mRemindViewRoot
            r1 = 0
            if (r0 != 0) goto L_0x0007
            r0 = r1
            goto L_0x000b
        L_0x0007:
            com.flyco.roundview.RoundViewDelegate r0 = r0.getDelegate()
        L_0x000b:
            if (r0 != 0) goto L_0x000e
            goto L_0x001d
        L_0x000e:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r10.activityProvider
            android.content.res.Resources r2 = r2.getActivityResources()
            int r3 = com.tal.app.thinkacademy.business.home.R.color.color_FFE9D8
            int r2 = r2.getColor(r3, r1)
            r0.setBackgroundColor(r2)
        L_0x001d:
            android.widget.ImageView r0 = r10.mRemindBgIcon
            if (r0 != 0) goto L_0x0022
            goto L_0x0027
        L_0x0022:
            int r2 = com.tal.app.thinkacademy.business.home.R.drawable.live_home_icon_report_bg
            r0.setBackgroundResource(r2)
        L_0x0027:
            com.flyco.roundview.RoundTextView r0 = r10.mRemindOrder
            if (r0 != 0) goto L_0x002d
            r0 = r1
            goto L_0x0031
        L_0x002d:
            com.flyco.roundview.RoundViewDelegate r0 = r0.getDelegate()
        L_0x0031:
            if (r0 != 0) goto L_0x0034
            goto L_0x0043
        L_0x0034:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r10.activityProvider
            android.content.res.Resources r2 = r2.getActivityResources()
            int r3 = com.tal.app.thinkacademy.business.home.R.color.color_FF740A
            int r2 = r2.getColor(r3, r1)
            r0.setBackgroundColor(r2)
        L_0x0043:
            com.flyco.roundview.RoundTextView r0 = r10.mRemindTime
            if (r0 != 0) goto L_0x0048
            goto L_0x0057
        L_0x0048:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r10.activityProvider
            android.content.res.Resources r2 = r2.getActivityResources()
            int r3 = com.tal.app.thinkacademy.business.home.R.color.color_FF740A
            int r2 = r2.getColor(r3, r1)
            r0.setTextColor(r2)
        L_0x0057:
            com.flyco.roundview.RoundTextView r0 = r10.mRemindTime
            if (r0 != 0) goto L_0x005d
            r0 = r1
            goto L_0x0061
        L_0x005d:
            com.flyco.roundview.RoundViewDelegate r0 = r0.getDelegate()
        L_0x0061:
            if (r0 != 0) goto L_0x0064
            goto L_0x0073
        L_0x0064:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r10.activityProvider
            android.content.res.Resources r2 = r2.getActivityResources()
            int r3 = com.tal.app.thinkacademy.business.home.R.color.color_FF740A
            int r2 = r2.getColor(r3, r1)
            r0.setStrokeColor(r2)
        L_0x0073:
            android.widget.TextView r0 = r10.mRemindTitle
            if (r0 != 0) goto L_0x0078
            goto L_0x0087
        L_0x0078:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r10.activityProvider
            android.content.res.Resources r2 = r2.getActivityResources()
            int r3 = com.tal.app.thinkacademy.business.home.R.color.color_D05C07
            int r2 = r2.getColor(r3, r1)
            r0.setTextColor(r2)
        L_0x0087:
            com.flyco.roundview.RoundTextView r0 = r10.mRemindBtnEnter
            if (r0 != 0) goto L_0x008d
            r0 = r1
            goto L_0x0091
        L_0x008d:
            com.flyco.roundview.RoundViewDelegate r0 = r0.getDelegate()
        L_0x0091:
            if (r0 != 0) goto L_0x0094
            goto L_0x00a3
        L_0x0094:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r10.activityProvider
            android.content.res.Resources r2 = r2.getActivityResources()
            int r3 = com.tal.app.thinkacademy.business.home.R.color.color_FF740A
            int r1 = r2.getColor(r3, r1)
            r0.setBackgroundColor(r1)
        L_0x00a3:
            com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData r0 = r10.mLessonReminderData
            if (r0 != 0) goto L_0x00a9
            goto L_0x019c
        L_0x00a9:
            com.flyco.roundview.RoundRelativeLayout r1 = r10.mRemindViewRoot
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x00b1
        L_0x00af:
            r1 = r3
            goto L_0x00b8
        L_0x00b1:
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x00af
            r1 = r2
        L_0x00b8:
            java.lang.String r4 = "0"
            if (r1 == 0) goto L_0x00cf
            boolean r1 = r10.isNewReport
            if (r1 == 0) goto L_0x00f5
            com.flyco.roundview.RoundRelativeLayout r1 = r10.mRemindViewRoot
            if (r1 != 0) goto L_0x00c6
        L_0x00c4:
            r1 = r3
            goto L_0x00cd
        L_0x00c6:
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x00c4
            r1 = r2
        L_0x00cd:
            if (r1 == 0) goto L_0x00f5
        L_0x00cf:
            com.tal.app.thinkacademy.business.home.main.Tag r1 = r10.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r1 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r1
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.String r6 = "曝光的埋点"
            r5[r3] = r6
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r1, r5)
            com.tal.app.thinkacademy.business.home.main.LaunchTrack r1 = com.tal.app.thinkacademy.business.home.main.LaunchTrack.INSTANCE
            com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData r5 = r10.mLessonReminderData
            if (r5 != 0) goto L_0x00e4
        L_0x00e2:
            r5 = r4
            goto L_0x00f2
        L_0x00e4:
            java.lang.Integer r5 = r5.getPlanId()
            if (r5 != 0) goto L_0x00eb
            goto L_0x00e2
        L_0x00eb:
            java.lang.String r5 = r5.toString()
            if (r5 != 0) goto L_0x00f2
            goto L_0x00e2
        L_0x00f2:
            r1.lesson_report_tips_show(r5)
        L_0x00f5:
            com.flyco.roundview.RoundTextView r1 = r10.mRemindOrder
            if (r1 != 0) goto L_0x00fa
            goto L_0x0130
        L_0x00fa:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r5 = r10.activityProvider
            android.app.Activity r5 = r5.getActivity()
            int r6 = com.tal.app.thinkacademy.business.home.R.string.start_class_lesson
            java.lang.Object[] r7 = new java.lang.Object[r2]
            java.lang.Integer r8 = r0.getLessonNum()
            if (r8 != 0) goto L_0x010c
            r8 = r2
            goto L_0x0110
        L_0x010c:
            int r8 = r8.intValue()
        L_0x0110:
            r9 = 10
            if (r8 >= r9) goto L_0x011d
            java.lang.Integer r8 = r0.getLessonNum()
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r8)
            goto L_0x0125
        L_0x011d:
            java.lang.Integer r4 = r0.getLessonNum()
            java.lang.String r4 = java.lang.String.valueOf(r4)
        L_0x0125:
            r7[r3] = r4
            java.lang.String r4 = r5.getString(r6, r7)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
        L_0x0130:
            com.flyco.roundview.RoundTextView r1 = r10.mRemindTime
            if (r1 != 0) goto L_0x0135
            goto L_0x0156
        L_0x0135:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r0.getFormattedStartTime()
            r4.append(r5)
            r5 = 45
            r4.append(r5)
            java.lang.String r5 = r0.getFormattedEndTime()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
        L_0x0156:
            android.widget.TextView r1 = r10.mRemindTitle
            if (r1 != 0) goto L_0x015b
            goto L_0x0174
        L_0x015b:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r4 = r10.activityProvider
            android.app.Activity r4 = r4.getActivity()
            int r5 = com.tal.app.thinkacademy.business.home.R.string.remind_report_title_format
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r6 = r0.getLessonName()
            r2[r3] = r6
            java.lang.String r2 = r4.getString(r5, r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x0174:
            com.flyco.roundview.RoundTextView r1 = r10.mRemindBtnEnter
            if (r1 != 0) goto L_0x0179
            goto L_0x0186
        L_0x0179:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic$ActivityProvider r2 = r10.activityProvider
            int r3 = com.tal.app.thinkacademy.business.home.R.string.remind_report_view
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x0186:
            r10.setRemindVisible()
            android.os.Handler r1 = r10.mHandler
            if (r1 != 0) goto L_0x018e
            goto L_0x019c
        L_0x018e:
            int r2 = r10.KGoneStartClass
            long r3 = r0.getEndShowTime()
            long r5 = r0.getServerTime()
            long r3 = r3 - r5
            r1.sendEmptyMessageDelayed(r2, r3)
        L_0x019c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.MainActivityLogic.showReportToRemind():void");
    }

    private final void setRemindVisible() {
        if (PadUtils.isPad(Utils.getApp())) {
            RoundRelativeLayout roundRelativeLayout = this.mRemindViewRoot;
            if (roundRelativeLayout != null) {
                roundRelativeLayout.setVisibility(8);
                return;
            }
            return;
        }
        RoundRelativeLayout roundRelativeLayout2 = this.mRemindViewRoot;
        if (roundRelativeLayout2 != null) {
            roundRelativeLayout2.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void enterClass() {
        String str;
        String str2;
        String str3;
        LessonReminderData lessonReminderData = this.mLessonReminderData;
        if (lessonReminderData != null) {
            if (CommonUtilsKt.isFastClick()) {
                XesLog.dt("MainActivity", new Object[]{"onItemChildClick，点击太快了"});
                return;
            }
            long j = (long) 1024;
            if ((FileUtils.getFsAvailableSize(Environment.getDataDirectory().getPath()) / j) / j < 500) {
                new StoreLowWarnDialog(this.activityProvider.getActivity()).show();
                return;
            }
            CharSequence overseaApi = ImConfig.INSTANCE.getOverseaApi();
            String str4 = null;
            if (!(overseaApi == null || StringsKt.isBlank(overseaApi))) {
                Intent intent = new Intent();
                Integer bizId = lessonReminderData.getBizId();
                String str5 = "0";
                if (bizId == null || (str = bizId.toString()) == null) {
                    str = str5;
                }
                intent.putExtra("bizId", str);
                Integer planId = lessonReminderData.getPlanId();
                if (planId == null || (str2 = planId.toString()) == null) {
                    str2 = str5;
                }
                intent.putExtra(LearnMaterialsListActivityKt.PLANID, str2);
                Long classId = lessonReminderData.getClassId();
                if (classId == null || (str3 = classId.toString()) == null) {
                    str3 = str5;
                }
                intent.putExtra("courseId", str3);
                intent.putExtra("editSuccess", str5);
                Integer subPlatformType = lessonReminderData.getSubPlatformType();
                intent.putExtra("subPlatformType", subPlatformType == null ? 0 : subPlatformType.intValue());
                if (Intrinsics.areEqual((Object) lessonReminderData.getLessonType(), (Object) LessonType.TEMPORARY.name())) {
                    str5 = DbParams.GZIP_DATA_EVENT;
                }
                intent.putExtra("isTemp", str5);
                intent.putExtra("lessonType", lessonReminderData.getLessonType());
                intent.putExtra("previousSource", "商城引导页");
                intent.putExtra("isAuditor", StringsKt.equals$default(lessonReminderData.getLessonType(), LessonType.AUDITION.name(), false, 2, (Object) null));
                Integer packageId = lessonReminderData.getPackageId();
                if (packageId != null) {
                    str4 = packageId.toString();
                }
                intent.putExtra("packageId", str4);
                XesRoute.getInstance().navigation("/study/before_class_live", intent.getExtras());
                XesLog.i(Tag.MainActivity, new Object[]{"学生从开课提醒点击了进课按钮"});
                return;
            }
            ImConfig.getHostUrlsConfig$default(ImConfig.INSTANCE, (String) null, 1, (Object) null);
        }
    }

    public final void registerTimeZoneReceiver() {
        if (this.timeZoneReceiver == null) {
            this.timeZoneReceiver = new TimeZoneChangeReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        this.activityProvider.getActivity().registerReceiver(this.timeZoneReceiver, intentFilter);
    }

    public final void unRegisterTimeZoneReceiver() {
        if (this.timeZoneReceiver != null) {
            this.activityProvider.getActivity().unregisterReceiver(this.timeZoneReceiver);
        }
    }
}
