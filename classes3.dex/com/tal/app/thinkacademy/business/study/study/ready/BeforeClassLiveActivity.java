package com.tal.app.thinkacademy.business.study.study.ready;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.study.study.dialog.CheckEnvDialog;
import com.tal.app.thinkacademy.business.study.study.entity.DeviceDetection;
import com.tal.app.thinkacademy.business.study.study.entity.ReadyClassBean;
import com.tal.app.thinkacademy.business.study.study.entity.Sign;
import com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassLiveBinding;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.util.ColorUtils;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tbruyelle.rxpermissions3.Permission;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J$\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\u0012\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0018\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\nH\u0014J\b\u0010-\u001a\u00020\u0019H\u0016J\b\u0010.\u001a\u00020\u0019H\u0016J\u0012\u0010/\u001a\u00020\u00192\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0010H\u0016J\b\u00104\u001a\u00020\u0019H\u0016J\u0012\u00105\u001a\u00020\u00192\b\u00106\u001a\u0004\u0018\u000107H\u0017J\b\u00108\u001a\u00020\u0019H\u0014J\b\u00109\u001a\u00020\u0019H\u0014J\b\u0010:\u001a\u00020\u0019H\u0002J\b\u0010;\u001a\u00020\u0019H\u0016J\b\u0010<\u001a\u00020\u0019H\u0002J\b\u0010=\u001a\u00020\u0019H\u0002J!\u0010>\u001a\u00020\u00192\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\n2\u0006\u0010@\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020\u0019H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006C"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/ready/BeforeClassLiveActivity;", "Lcom/tal/app/thinkacademy/business/study/study/ready/BeforeClassBaseActivity;", "Lcom/tal/app/thinkacademy/business/study/study/ready/ReadyClassLiveVM;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/ActivityBeforeClassLiveBinding;", "Landroid/view/View$OnClickListener;", "Lcom/tal/app/thinkacademy/business/study/study/ready/EnvTestItemView$CheckCallback;", "()V", "coursewareType", "", "hasCheckPermission", "", "isOpenCheckRTC", "mCheckList", "", "Lcom/tal/app/thinkacademy/business/study/study/ready/EnvTestItemView;", "mNetDetecting", "", "mStartTime", "", "mode", "getMode", "()Ljava/lang/String;", "permissionListener", "Lkotlin/Function1;", "Lcom/tbruyelle/rxpermissions3/Permission;", "", "rightCoin", "Ljava/lang/Integer;", "changeName", "newName", "checkPermission", "clickJoinCLass", "createCheckView", "needChangeName", "check", "Lcom/tal/app/thinkacademy/business/study/study/entity/DeviceDetection;", "username", "createDownloadView", "createSignView", "sign", "Lcom/tal/app/thinkacademy/business/study/study/entity/Sign;", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "initViews", "loadData", "onClassDataLoadFailed", "point", "Lcom/tal/app/thinkacademy/lib/download/model/FilePoint;", "onClassDataLoadProgress", "progress", "onClassDataLoadSuccess", "onClick", "v", "Landroid/view/View;", "onDestroy", "onResume", "requestPermission", "retestNet", "scalePad", "showOnline", "showViewToast", "isSuccess", "strRes", "(Ljava/lang/Boolean;I)V", "stopRtcCheck", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BeforeClassLiveActivity.kt */
public final class BeforeClassLiveActivity extends BeforeClassBaseActivity<ReadyClassLiveVM, ActivityBeforeClassLiveBinding> implements View.OnClickListener, EnvTestItemView.CheckCallback {
    /* access modifiers changed from: private */
    public String coursewareType = "local";
    /* access modifiers changed from: private */
    public boolean hasCheckPermission;
    private boolean isOpenCheckRTC = true;
    /* access modifiers changed from: private */
    public final List<EnvTestItemView> mCheckList = new ArrayList();
    private int mNetDetecting = 2;
    private long mStartTime;
    private Function1<? super Permission, Unit> permissionListener = new BeforeClassLiveActivity$permissionListener$1(this);
    /* access modifiers changed from: private */
    public Integer rightCoin = 0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BeforeClassLiveActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public String getMode() {
        return "直播";
    }

    public void retestNet() {
    }

    public void initViews() {
        String cloudKeyValue = HwCloudControlHelper.Companion.get().getCloudKeyValue("hw_prepare_class_net_check");
        BeforeClassBaseActivity.log$default(this, Intrinsics.stringPlus("云控rtc检测开关 ", cloudKeyValue), (Boolean) null, 2, (Object) null);
        this.isOpenCheckRTC = !Intrinsics.areEqual((Object) "false", (Object) cloudKeyValue);
        setMTvDownload(getBinding().titleDownload);
        getBinding().progressDownload.setEnabled(false);
        getBinding().progressDownload.setClickable(false);
        getBinding().progressDownload.setFocusable(false);
        View.OnClickListener onClickListener = this;
        getBinding().btnCheckIn.setOnClickListener(onClickListener);
        getBinding().btnJoinClassCover.setOnClickListener(onClickListener);
        getBinding().btnBack.setOnClickListener(onClickListener);
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = getBinding().btnJoinClass;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.btnJoinClass");
        rxUnDoubleUtil.setOnUnDoubleClickListener(textView, 500, new BeforeClassLiveActivity$initViews$1(this));
        RxUnDoubleUtil rxUnDoubleUtil2 = RxUnDoubleUtil.INSTANCE;
        View view = getBinding().btnJoinClassCover;
        Intrinsics.checkNotNullExpressionValue(view, "binding.btnJoinClassCover");
        rxUnDoubleUtil2.setOnCountClickListener(view, 3000, 10, new BeforeClassLiveActivity$initViews$2(this), new BeforeClassLiveActivity$initViews$3(this));
    }

    public void loadData() {
        showLoading();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getMReadyClassBean().observe(lifecycleOwner, new BeforeClassLiveActivity$$ExternalSyntheticLambda0(this));
        getMViewModel().getMNetTestState().observerSticky(lifecycleOwner, false, new BeforeClassLiveActivity$$ExternalSyntheticLambda1(this));
        getMViewModel().requestPrepareData(getMPlanId(), getMCourseId());
    }

    /* access modifiers changed from: private */
    /* renamed from: loadData$lambda-1  reason: not valid java name */
    public static final void m447loadData$lambda1(BeforeClassLiveActivity beforeClassLiveActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(beforeClassLiveActivity, "this$0");
        beforeClassLiveActivity.hideLoading();
        int screenHeight = ScreenUtils.getScreenHeight() / 7;
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            beforeClassLiveActivity.getBinding().layoutError.layoutError.setVisibility(8);
            ReadyClassBean readyClassBean = (ReadyClassBean) stateData.getData();
            if (readyClassBean != null) {
                beforeClassLiveActivity.mStartTime = readyClassBean.getStartTime();
                beforeClassLiveActivity.saveCourseware(beforeClassLiveActivity.getMPlanId(), readyClassBean.getCourseware());
                beforeClassLiveActivity.setMFollowCoursewareRatio(readyClassBean.getFollowCoursewareRatio());
                beforeClassLiveActivity.download(readyClassBean.getCourseware());
                beforeClassLiveActivity.createSignView(readyClassBean.getSign());
                beforeClassLiveActivity.createCheckView(Intrinsics.areEqual((Object) readyClassBean.getNeedModifyNickname(), (Object) true), readyClassBean.getDeviceDetection(), readyClassBean.getUsername());
                beforeClassLiveActivity.createDownloadView();
                beforeClassLiveActivity.scalePad();
                return;
            }
            return;
        }
        beforeClassLiveActivity.getBinding().layoutError.btnRetry.setEnabled(true);
        beforeClassLiveActivity.getBinding().layoutError.layoutError.setPadding(0, screenHeight, 0, 0);
        beforeClassLiveActivity.getBinding().layoutError.layoutError.setVisibility(0);
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = beforeClassLiveActivity.getBinding().layoutError.btnRetry;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.layoutError.btnRetry");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil, textView, 0, new BeforeClassLiveActivity$loadData$1$2(beforeClassLiveActivity), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadData$lambda-4  reason: not valid java name */
    public static final void m448loadData$lambda4(BeforeClassLiveActivity beforeClassLiveActivity, Integer num) {
        int i;
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(beforeClassLiveActivity, "this$0");
        Iterator it = beforeClassLiveActivity.mCheckList.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((EnvTestItemView) obj).getMType() == 3) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        EnvTestItemView envTestItemView = (EnvTestItemView) obj;
        if (envTestItemView != null) {
            if (((num != null && num.intValue() == 1) || (num != null && num.intValue() == 2)) || (num != null && num.intValue() == 3)) {
                envTestItemView.setStatus(2);
            } else {
                if (((num != null && num.intValue() == 4) || (num != null && num.intValue() == 5)) || (num != null && num.intValue() == 6)) {
                    i = 1;
                }
                if (i != 0) {
                    envTestItemView.setStatus(3);
                    i = 1;
                } else {
                    envTestItemView.setStatus(1);
                    i = 2;
                }
            }
            beforeClassLiveActivity.mNetDetecting = i;
        }
    }

    private final void scalePad() {
        if (PadUtils.isPad((Context) this)) {
            RelativeLayout relativeLayout = getBinding().layoutDownload;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.layoutDownload");
            scale(relativeLayout, 1.5f, ScreenUtils.getScreenWidth() / 2, dp2px(80));
            getBinding().layoutDownloadBg.setScaleY(1.5f);
            getBinding().layoutDownloadBg.setPivotY((float) dp2px(80));
            getBinding().signLottie.setScaleRatio(1.5f);
            View view = getBinding().layoutSign;
            Intrinsics.checkNotNullExpressionValue(view, "binding.layoutSign");
            scale(view, 1.5f, dp2px(466) / 2, 0);
            View view2 = getBinding().layoutEnvTest;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.layoutEnvTest");
            scale(view2, 1.5f);
            LinearLayout root = getBinding().layoutError.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.layoutError.root");
            scale(root, 1.5f);
        }
    }

    private final void createDownloadView() {
        getBinding().layoutDownload.setVisibility(0);
        getBinding().layoutDownloadBg.setVisibility(0);
    }

    private final void createSignView(Sign sign) {
        String rightCoin2;
        if (Intrinsics.areEqual((Object) sign == null ? null : sign.getStatus(), (Object) DbParams.GZIP_DATA_EVENT) && !isAuditor() && !isParentAudit()) {
            getBinding().layoutSign.setVisibility(0);
            getBinding().layoutSign.animate().translationYBy((float) dp2px(70)).setDuration(300).start();
            getBinding().signLottie.setCoinImageResource(R.drawable.icon_coins_66);
            getBinding().signLottie.setCoinLayoutParams(Integer.valueOf(dp2px(20)), Integer.valueOf(dp2px(20)), Integer.valueOf(dp2px(26)), Integer.valueOf(dp2px(26)));
            getBinding().signLottie.setToView(getBinding().btnCheckIn);
            if (!TextUtils.isEmpty(sign.getRightCoin()) && !TextUtils.equals(sign.getRightCoin(), "0") && (rightCoin2 = sign.getRightCoin()) != null) {
                getBinding().tvCheckInCoin.setText(Intrinsics.stringPlus("+", rightCoin2));
                this.rightCoin = StringsKt.toIntOrNull(rightCoin2);
            }
        }
    }

    private final void createCheckView(boolean z, DeviceDetection deviceDetection, String str) {
        String str2;
        List<Number> mutableListOf = CollectionsKt.mutableListOf(1, 2);
        if (this.isOpenCheckRTC) {
            mutableListOf.add(3);
            ReadyClassLiveVM mViewModel = getMViewModel();
            if (deviceDetection == null) {
                str2 = null;
            } else {
                str2 = deviceDetection.getRtcToken();
            }
            mViewModel.startRtcCheck(str2);
        }
        if (z && !isAuditor() && !isParentAudit()) {
            mutableListOf.add(4);
        }
        for (Number intValue : mutableListOf) {
            EnvTestItemView envTestItemView = new EnvTestItemView((Context) this, intValue.intValue());
            envTestItemView.setStatus(1);
            envTestItemView.setCallback(this);
            getBinding().layoutEnvTest.addView(envTestItemView.getItemView(), new LinearLayout.LayoutParams(-1, dp2px(48)));
            if (4 == envTestItemView.getMType()) {
                envTestItemView.setUsername(str);
                envTestItemView.setStatus(3);
            }
            this.mCheckList.add(envTestItemView);
        }
        requestPermission();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.hasCheckPermission && this.mCheckList.size() > 1) {
            checkPermission();
        }
    }

    private final void checkPermission() {
        String[] strArr = {"android.permission.RECORD_AUDIO", "android.permission.CAMERA"};
        Iterator it = new IntRange(0, 1).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            if (isGranted(strArr[nextInt])) {
                this.mCheckList.get(nextInt).setStatus(2);
            } else {
                this.mCheckList.get(nextInt).setStatus(3);
            }
        }
    }

    private final void requestPermission() {
        request(new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, this.permissionListener);
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, BeforeClassLiveActivity.class);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.btn_back;
        if (valueOf != null && valueOf.intValue() == i) {
            finish();
        } else {
            int i2 = R.id.btn_check_in;
            if (valueOf != null && valueOf.intValue() == i2) {
                int i3 = 0;
                getBinding().btnCheckIn.setEnabled(false);
                HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
                String mPlanId = getMPlanId();
                if (mPlanId == null) {
                    mPlanId = "";
                }
                Integer num = this.rightCoin;
                if (num != null) {
                    i3 = num.intValue();
                }
                hWEventTracking.ostaSignIn(mPlanId, Integer.valueOf(i3), Long.valueOf(getMViewModel().getServerTime()));
                getMViewModel().requestCheckIn(getMPlanId(), getMCourseId(), new BeforeClassLiveActivity$onClick$1(this));
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    static /* synthetic */ void showViewToast$default(BeforeClassLiveActivity beforeClassLiveActivity, Boolean bool, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = null;
        }
        beforeClassLiveActivity.showViewToast(bool, i);
    }

    /* access modifiers changed from: private */
    public final void showViewToast(Boolean bool, int i) {
        int i2;
        LayoutInflater from = LayoutInflater.from((Context) this);
        int i3 = R.layout.layout_prepare_sign_result;
        Unit unit = null;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i3, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i3, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tv_sign_result)).setText(getString(i));
        if (bool != null) {
            bool.booleanValue();
            if (bool.booleanValue()) {
                i2 = R.drawable.icon_study_ready_success;
            } else {
                i2 = R.drawable.icon_study_ready_fail;
            }
            ((ImageView) inflate.findViewById(R.id.img_sign_result)).setImageResource(i2);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            BeforeClassLiveActivity beforeClassLiveActivity = this;
            ((ImageView) inflate.findViewById(R.id.img_sign_result)).setVisibility(8);
        }
        ToastUtils.setGravity(17, 0, 0);
        ToastUtils.showCustomShort(inflate);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clickJoinCLass() {
        /*
            r21 = this;
            r0 = r21
            java.util.List<com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView> r1 = r0.mCheckList
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x000a:
            boolean r2 = r1.hasNext()
            r3 = 3
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0026
            java.lang.Object r2 = r1.next()
            r7 = r2
            com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView r7 = (com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView) r7
            int r7 = r7.getMType()
            if (r7 != r3) goto L_0x0022
            r7 = r6
            goto L_0x0023
        L_0x0022:
            r7 = r5
        L_0x0023:
            if (r7 == 0) goto L_0x000a
            goto L_0x0027
        L_0x0026:
            r2 = 0
        L_0x0027:
            com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView r2 = (com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView) r2
            java.lang.String r1 = "unknown"
            r7 = 2
            if (r2 != 0) goto L_0x0031
        L_0x002e:
            r16 = r1
            goto L_0x0045
        L_0x0031:
            int r2 = r2.getMStatus()
            if (r2 == r7) goto L_0x003e
            if (r2 == r3) goto L_0x003b
            r2 = 0
            goto L_0x0040
        L_0x003b:
            java.lang.String r2 = "pool"
            goto L_0x0040
        L_0x003e:
            java.lang.String r2 = "good"
        L_0x0040:
            if (r2 != 0) goto L_0x0043
            goto L_0x002e
        L_0x0043:
            r16 = r2
        L_0x0045:
            com.tal.app.thinkacademy.common.appmonitor.HWEventTracking$Companion r1 = com.tal.app.thinkacademy.common.appmonitor.HWEventTracking.Companion
            com.tal.app.thinkacademy.common.appmonitor.HWEventTracking r8 = r1.get()
            com.tal.app.thinkacademy.common.base.BaseViewModel r1 = r21.getMViewModel()
            com.tal.app.thinkacademy.business.study.study.ready.ReadyClassLiveVM r1 = (com.tal.app.thinkacademy.business.study.study.ready.ReadyClassLiveVM) r1
            long r1 = r1.getServerTime()
            r9 = 1000(0x3e8, float:1.401E-42)
            long r9 = (long) r9
            long r1 = r1 * r9
            long r11 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r11
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.Number r1 = (java.lang.Number) r1
            java.lang.String r2 = r21.getMPlanId()
            java.lang.String r11 = ""
            if (r2 != 0) goto L_0x006d
            r2 = r11
        L_0x006d:
            java.lang.Integer r12 = r21.getSubPlatformType()
            if (r12 != 0) goto L_0x0074
            goto L_0x007d
        L_0x0074:
            int r12 = r12.intValue()
            if (r12 != r7) goto L_0x007d
            java.lang.String r12 = "small"
            goto L_0x007f
        L_0x007d:
            java.lang.String r12 = "dual"
        L_0x007f:
            java.lang.String r13 = r21.getMCourseId()
            if (r13 != 0) goto L_0x0086
            r13 = r11
        L_0x0086:
            boolean r14 = r21.isParentAudit()
            java.util.List<com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView> r11 = r0.mCheckList
            java.lang.Object r11 = r11.get(r5)
            com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView r11 = (com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView) r11
            int r11 = r11.getMStatus()
            if (r11 != r7) goto L_0x009a
            r15 = r6
            goto L_0x009b
        L_0x009a:
            r15 = r5
        L_0x009b:
            java.util.List<com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView> r11 = r0.mCheckList
            java.lang.Object r11 = r11.get(r6)
            com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView r11 = (com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView) r11
            int r11 = r11.getMStatus()
            if (r11 != r7) goto L_0x00ab
            r7 = r6
            goto L_0x00ac
        L_0x00ab:
            r7 = r5
        L_0x00ac:
            boolean r17 = r21.getMCoursewareDownloadFinished()
            long r18 = r21.getMCoursewareNeedDownloadSize()
            r11 = 1024(0x400, float:1.435E-42)
            long r3 = (long) r11
            long r18 = r18 / r3
            java.lang.Long r3 = java.lang.Long.valueOf(r18)
            r18 = r3
            java.lang.Number r18 = (java.lang.Number) r18
            long r3 = r21.getMCoursewareDownloadTime()
            long r3 = r3 / r9
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r19 = r3
            java.lang.Number r19 = (java.lang.Number) r19
            com.tal.app.thinkacademy.common.base.BaseViewModel r3 = r21.getMViewModel()
            com.tal.app.thinkacademy.business.study.study.ready.ReadyClassLiveVM r3 = (com.tal.app.thinkacademy.business.study.study.ready.ReadyClassLiveVM) r3
            long r3 = r3.getServerTime()
            long r9 = r0.mStartTime
            long r3 = r3 - r9
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r20 = r3
            java.lang.Number r20 = (java.lang.Number) r20
            r9 = r1
            r10 = r2
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r7
            r8.ostaEnterClassroom(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r21.stopRtcCheck()
            r1 = r0
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity r1 = (com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity) r1
            r2 = 0
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity.enterClassRoom$default(r1, r2, r6, r2)
            java.util.List<com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView> r1 = r0.mCheckList
            int r1 = r1.size()
            if (r1 <= r6) goto L_0x0123
            java.util.List<com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView> r1 = r0.mCheckList
            java.lang.Object r1 = r1.get(r5)
            com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView r1 = (com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView) r1
            int r1 = r1.getMStatus()
            r2 = 3
            if (r1 != r2) goto L_0x0110
            r1 = r6
            goto L_0x0111
        L_0x0110:
            r1 = r5
        L_0x0111:
            java.util.List<com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView> r3 = r0.mCheckList
            java.lang.Object r3 = r3.get(r6)
            com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView r3 = (com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView) r3
            int r3 = r3.getMStatus()
            if (r3 != r2) goto L_0x0120
            goto L_0x0121
        L_0x0120:
            r6 = r5
        L_0x0121:
            r5 = r1
            goto L_0x0124
        L_0x0123:
            r6 = r5
        L_0x0124:
            com.tal.app.thinkacademy.business.study.study.StudyTrack r1 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            int r2 = r0.mNetDetecting
            r1.PreparePageDetecting(r5, r6, r2)
            com.tal.app.thinkacademy.business.study.study.StudyTrack r1 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            java.lang.String r2 = r21.getMPlanId()
            java.lang.String r3 = r0.coursewareType
            r1.useCoursewareType(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.ready.BeforeClassLiveActivity.clickJoinCLass():void");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        stopRtcCheck();
    }

    private final void stopRtcCheck() {
        if (this.isOpenCheckRTC) {
            BeforeClassBaseActivity.log$default(this, "停止RTC检测并释放RTC", (Boolean) null, 2, (Object) null);
            this.isOpenCheckRTC = false;
            getMViewModel().stopRtcCheck();
        }
    }

    /* access modifiers changed from: protected */
    public ActivityBeforeClassLiveBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityBeforeClassLiveBinding inflate = ActivityBeforeClassLiveBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void changeName(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "newName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0067
            r0 = r6
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity r0 = (com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "修改昵称 <"
            r1.append(r2)
            r1.append(r7)
            r2 = 62
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 2
            r3 = 0
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity.log$default(r0, r1, r3, r2, r3)
            java.util.List<com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView> r0 = r6.mCheckList
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0034:
            boolean r1 = r0.hasNext()
            r2 = 1
            if (r1 == 0) goto L_0x004f
            java.lang.Object r1 = r0.next()
            r4 = r1
            com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView r4 = (com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView) r4
            int r4 = r4.getMType()
            r5 = 4
            if (r4 != r5) goto L_0x004b
            r4 = r2
            goto L_0x004c
        L_0x004b:
            r4 = 0
        L_0x004c:
            if (r4 == 0) goto L_0x0034
            r3 = r1
        L_0x004f:
            com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView r3 = (com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView) r3
            if (r3 != 0) goto L_0x0054
            goto L_0x0057
        L_0x0054:
            r3.setStatus(r2)
        L_0x0057:
            com.tal.app.thinkacademy.common.base.BaseViewModel r0 = r6.getMViewModel()
            com.tal.app.thinkacademy.business.study.study.ready.ReadyClassLiveVM r0 = (com.tal.app.thinkacademy.business.study.study.ready.ReadyClassLiveVM) r0
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassLiveActivity$changeName$1 r1 = new com.tal.app.thinkacademy.business.study.study.ready.BeforeClassLiveActivity$changeName$1
            r1.<init>(r3, r7, r6)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r0.modifyDisplayName(r7, r1)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.ready.BeforeClassLiveActivity.changeName(java.lang.String):void");
    }

    public void onClassDataLoadSuccess() {
        BeforeClassBaseActivity.log$default(this, "资源下载完成，进课按钮点亮", (Boolean) null, 2, (Object) null);
        getBinding().titleDownload.setText(getString(R.string.courseware_download_complete));
        getBinding().progressDownload.setProgress(100);
        getBinding().btnJoinClassCover.setVisibility(8);
        this.coursewareType = "local";
    }

    public void onClassDataLoadFailed(FilePoint filePoint) {
        getBinding().titleDownload.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_study_ready_fail, 0, 0, 0);
        getBinding().titleDownload.setCompoundDrawablePadding(dp2px(3));
        getBinding().titleDownload.setText(getString(R.string.courseware_download_failed));
        getBinding().titleDownload.setTextColor(ColorUtils.getColor(R.color.color_FF503F));
        CheckEnvDialog confirmButton = new CheckEnvDialog((Context) this).setTitleText(R.string.courseware_download_failed).setMessageText(R.string.check_network_and_again).setCancelButton(R.string.use_online_courseware, new BeforeClassLiveActivity$onClassDataLoadFailed$dialog$1(this)).setConfirmButton(R.string.prepare_class_redownload, new BeforeClassLiveActivity$onClassDataLoadFailed$dialog$2(this));
        if (!isFinishing() && !isDestroyed()) {
            confirmButton.show();
        }
    }

    /* access modifiers changed from: private */
    public final void showOnline() {
        CheckEnvDialog.setCancelButton$default(new CheckEnvDialog((Context) this).setTitleText(R.string.use_online_courseware).setMessageText(R.string.online_courseware_info), R.string.tv_cancel, (Function0) null, 2, (Object) null).setConfirmButton(R.string.confirm_use, new BeforeClassLiveActivity$showOnline$1(this)).show();
    }

    public void onClassDataLoadProgress(int i) {
        getBinding().progressDownload.setProgress(i);
    }
}
