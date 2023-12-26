package com.tal.app.thinkacademy.business.login.view.devicetest.driver;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.entity.NetTestBean;
import com.tal.app.thinkacademy.business.login.entity.NetTestType;
import com.tal.app.thinkacademy.business.login.view.customview.CountdownTextView;
import com.tal.app.thinkacademy.business.login.view.customview.DeviceNetStateProgress;
import com.tal.app.thinkacademy.business.login.view.devicetest.DeviceNetHintDialog;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u00014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020!H\u0002J$\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020\bH\u0002J\u0012\u0010)\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010*\u001a\u00020!H\u0002J\u0010\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u001cH\u0002J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/H\u0017J\b\u00100\u001a\u00020!H\u0016J\b\u00101\u001a\u00020!H\u0002J\b\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020!H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/NetTestDriver;", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/BaseTestDriver;", "owner", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;", "(Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;)V", "mBottomSuccessNext", "Lcom/tal/app/thinkacademy/business/login/view/customview/CountdownTextView;", "mDownloadResult", "", "mIrcResult", "mIvNetDownload", "Landroid/widget/ImageView;", "mIvNetIrc", "mIvNetRtc", "mIvNetServer", "mLayoutNetError", "Landroid/view/View;", "mLayoutNetLoading", "mLayoutNetSuccess", "mNetErrorHintDialog", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/DeviceNetHintDialog;", "mNetStateProgress", "Lcom/tal/app/thinkacademy/business/login/view/customview/DeviceNetStateProgress;", "mObjAnimator", "Landroid/animation/ObjectAnimator;", "mRtcResult", "mServerResult", "mTvNetDownload", "Landroid/widget/TextView;", "mTvNetIrc", "mTvNetRtc", "mTvNetServer", "bottomViewState", "", "state", "", "cancelStateAnimator", "changeResultState", "text", "image", "result", "changeStartState", "checkFinish", "initNetErrorHint", "view", "load", "group", "Landroid/view/ViewGroup;", "release", "reload", "resetState", "startCheck", "Companion", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetTestDriver.kt */
public final class NetTestDriver extends BaseTestDriver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "DeviceTest_NetTest";
    /* access modifiers changed from: private */
    public CountdownTextView mBottomSuccessNext;
    /* access modifiers changed from: private */
    public boolean mDownloadResult;
    /* access modifiers changed from: private */
    public boolean mIrcResult;
    /* access modifiers changed from: private */
    public ImageView mIvNetDownload;
    /* access modifiers changed from: private */
    public ImageView mIvNetIrc;
    /* access modifiers changed from: private */
    public ImageView mIvNetRtc;
    /* access modifiers changed from: private */
    public ImageView mIvNetServer;
    private View mLayoutNetError;
    private View mLayoutNetLoading;
    private View mLayoutNetSuccess;
    /* access modifiers changed from: private */
    public DeviceNetHintDialog mNetErrorHintDialog;
    private DeviceNetStateProgress mNetStateProgress;
    private ObjectAnimator mObjAnimator;
    /* access modifiers changed from: private */
    public boolean mRtcResult;
    /* access modifiers changed from: private */
    public boolean mServerResult;
    /* access modifiers changed from: private */
    public TextView mTvNetDownload;
    /* access modifiers changed from: private */
    public TextView mTvNetIrc;
    /* access modifiers changed from: private */
    public TextView mTvNetRtc;
    /* access modifiers changed from: private */
    public TextView mTvNetServer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetTestDriver(DeviceTestDriverOwner deviceTestDriverOwner) {
        super(deviceTestDriverOwner);
        Intrinsics.checkNotNullParameter(deviceTestDriverOwner, "owner");
        getMDriverOwner().addNetCallback(new Function1<NetTestBean, Unit>(this) {
            final /* synthetic */ NetTestDriver this$0;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: com.tal.app.thinkacademy.business.login.view.devicetest.driver.NetTestDriver$1$WhenMappings */
            /* compiled from: NetTestDriver.kt */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[NetTestType.values().length];
                    iArr[NetTestType.RTC.ordinal()] = 1;
                    iArr[NetTestType.IRC.ordinal()] = 2;
                    iArr[NetTestType.SERVER.ordinal()] = 3;
                    iArr[NetTestType.DOWNLOAD.ordinal()] = 4;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((NetTestBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(NetTestBean netTestBean) {
                Intrinsics.checkNotNullParameter(netTestBean, "it");
                XesLog.it(NetTestDriver.TAG, new Object[]{netTestBean.toString()});
                int i = WhenMappings.$EnumSwitchMapping$0[netTestBean.getType().ordinal()];
                if (i == 1) {
                    this.this$0.mRtcResult = netTestBean.getResult();
                    NetTestDriver netTestDriver = this.this$0;
                    netTestDriver.changeResultState(netTestDriver.mTvNetRtc, this.this$0.mIvNetRtc, netTestBean.getResult());
                    this.this$0.getMDriverOwner().checkIrcNet();
                    NetTestDriver netTestDriver2 = this.this$0;
                    netTestDriver2.changeStartState(netTestDriver2.mIvNetIrc);
                } else if (i == 2) {
                    this.this$0.mIrcResult = netTestBean.getResult();
                    NetTestDriver netTestDriver3 = this.this$0;
                    netTestDriver3.changeResultState(netTestDriver3.mTvNetIrc, this.this$0.mIvNetIrc, netTestBean.getResult());
                    this.this$0.getMDriverOwner().checkServerNet();
                    NetTestDriver netTestDriver4 = this.this$0;
                    netTestDriver4.changeStartState(netTestDriver4.mIvNetServer);
                } else if (i == 3) {
                    this.this$0.mServerResult = netTestBean.getResult();
                    NetTestDriver netTestDriver5 = this.this$0;
                    netTestDriver5.changeResultState(netTestDriver5.mTvNetServer, this.this$0.mIvNetServer, netTestBean.getResult());
                    this.this$0.getMDriverOwner().checkDownloadNet();
                    NetTestDriver netTestDriver6 = this.this$0;
                    netTestDriver6.changeStartState(netTestDriver6.mIvNetDownload);
                } else if (i == 4) {
                    this.this$0.mDownloadResult = netTestBean.getResult();
                    NetTestDriver netTestDriver7 = this.this$0;
                    netTestDriver7.changeResultState(netTestDriver7.mTvNetDownload, this.this$0.mIvNetDownload, netTestBean.getResult());
                    this.this$0.checkFinish();
                }
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/NetTestDriver$Companion;", "", "()V", "TAG", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NetTestDriver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void load(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        super.load(viewGroup);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int i = R.layout.layout_device_test_net_driver;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, viewGroup) : XMLParseInstrumentation.inflate(from, i, viewGroup);
        this.mNetStateProgress = (DeviceNetStateProgress) inflate.findViewById(R.id.progress_net_state);
        this.mTvNetRtc = (TextView) inflate.findViewById(R.id.tv_net_rtc);
        this.mIvNetRtc = (ImageView) inflate.findViewById(R.id.iv_net_state_rtc);
        this.mTvNetIrc = (TextView) inflate.findViewById(R.id.tv_net_irc);
        this.mIvNetIrc = (ImageView) inflate.findViewById(R.id.iv_net_state_irc);
        this.mTvNetServer = (TextView) inflate.findViewById(R.id.tv_net_server);
        this.mIvNetServer = (ImageView) inflate.findViewById(R.id.iv_net_state_server);
        this.mTvNetDownload = (TextView) inflate.findViewById(R.id.tv_net_download);
        this.mIvNetDownload = (ImageView) inflate.findViewById(R.id.iv_net_state_download);
        this.mLayoutNetLoading = inflate.findViewById(R.id.layout_net_loading);
        this.mLayoutNetSuccess = inflate.findViewById(R.id.group_net_pass);
        this.mLayoutNetError = inflate.findViewById(R.id.group_net_error);
        View findViewById = inflate.findViewById(R.id.tv_net_fail);
        Intrinsics.checkNotNullExpressionValue(findViewById, "content.findViewById(R.id.tv_net_fail)");
        initNetErrorHint((TextView) findViewById);
        CountdownTextView countdownTextView = (CountdownTextView) inflate.findViewById(R.id.tv_pass_next);
        this.mBottomSuccessNext = countdownTextView;
        if (countdownTextView != null) {
            countdownTextView.setOnClickListener(new NetTestDriver$$ExternalSyntheticLambda1(this));
        }
        inflate.findViewById(R.id.tv_error_retest).setOnClickListener(new NetTestDriver$$ExternalSyntheticLambda0(this));
        inflate.findViewById(R.id.tv_error_next).setOnClickListener(new NetTestDriver$$ExternalSyntheticLambda2(this));
        resetState();
        startCheck();
    }

    /* access modifiers changed from: private */
    /* renamed from: load$lambda-0  reason: not valid java name */
    public static final void m160load$lambda0(NetTestDriver netTestDriver, View view) {
        Intrinsics.checkNotNullParameter(netTestDriver, "this$0");
        Function0<Unit> mFinishCallBlock = netTestDriver.getMFinishCallBlock();
        if (mFinishCallBlock != null) {
            mFinishCallBlock.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: load$lambda-1  reason: not valid java name */
    public static final void m161load$lambda1(NetTestDriver netTestDriver, View view) {
        Intrinsics.checkNotNullParameter(netTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"重新测试"});
        netTestDriver.reload();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: load$lambda-2  reason: not valid java name */
    public static final void m162load$lambda2(NetTestDriver netTestDriver, View view) {
        Intrinsics.checkNotNullParameter(netTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"网络测试失败，跳转下一项测试"});
        Function0<Unit> mFinishCallBlock = netTestDriver.getMFinishCallBlock();
        if (mFinishCallBlock != null) {
            mFinishCallBlock.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final void checkFinish() {
        boolean z = this.mRtcResult && this.mIrcResult && this.mServerResult && this.mDownloadResult;
        Function1<Boolean, Unit> mResultCallBlock = getMResultCallBlock();
        if (mResultCallBlock != null) {
            mResultCallBlock.invoke(Boolean.valueOf(z));
        }
        if (z) {
            DeviceNetStateProgress deviceNetStateProgress = this.mNetStateProgress;
            if (deviceNetStateProgress != null) {
                deviceNetStateProgress.reset();
            }
        } else {
            DeviceNetStateProgress deviceNetStateProgress2 = this.mNetStateProgress;
            if (deviceNetStateProgress2 != null) {
                deviceNetStateProgress2.error();
            }
        }
        cancelStateAnimator();
        bottomViewState(z ? "success" : "error");
    }

    private final void initNetErrorHint(TextView textView) {
        String string = getMDriverOwner().getContext().getString(R.string.there_seems_wrong_with_your_network);
        Intrinsics.checkNotNullExpressionValue(string, "mDriverOwner.getContext(…_wrong_with_your_network)");
        String string2 = getMDriverOwner().getContext().getString(R.string.check_the_solution_suggestions);
        Intrinsics.checkNotNullExpressionValue(string2, "mDriverOwner.getContext(…the_solution_suggestions)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(string);
        SpannableString spannableString = new SpannableString(string2);
        spannableString.setSpan(new NetTestDriver$initNetErrorHint$1(this, ContextCompat.getColor(getMDriverOwner().getContext(), R.color.color_007AFF)), 0, string2.length(), 33);
        spannableStringBuilder.append(spannableString);
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
    }

    private final void reload() {
        resetState();
        startCheck();
    }

    private final void startCheck() {
        XesLog.it(TAG, new Object[]{"开始网络测试"});
        DeviceNetStateProgress deviceNetStateProgress = this.mNetStateProgress;
        if (deviceNetStateProgress != null) {
            deviceNetStateProgress.startLoop();
        }
        getMDriverOwner().checkRtcNet();
        changeStartState(this.mIvNetRtc);
        bottomViewState("loading");
    }

    private final void bottomViewState(String str) {
        XesLog.it(TAG, new Object[]{Intrinsics.stringPlus("底部测试结果状态改变：", str)});
        int hashCode = str.hashCode();
        if (hashCode != -1867169789) {
            if (hashCode != 96784904) {
                if (hashCode == 336650556 && str.equals("loading")) {
                    View view = this.mLayoutNetLoading;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                    View view2 = this.mLayoutNetSuccess;
                    if (view2 != null) {
                        view2.setVisibility(8);
                    }
                    View view3 = this.mLayoutNetError;
                    if (view3 != null) {
                        view3.setVisibility(8);
                    }
                }
            } else if (str.equals("error")) {
                View view4 = this.mLayoutNetLoading;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
                View view5 = this.mLayoutNetSuccess;
                if (view5 != null) {
                    view5.setVisibility(8);
                }
                View view6 = this.mLayoutNetError;
                if (view6 != null) {
                    view6.setVisibility(0);
                }
            }
        } else if (str.equals("success")) {
            View view7 = this.mLayoutNetLoading;
            if (view7 != null) {
                view7.setVisibility(8);
            }
            View view8 = this.mLayoutNetSuccess;
            if (view8 != null) {
                view8.setVisibility(0);
            }
            View view9 = this.mLayoutNetError;
            if (view9 != null) {
                view9.setVisibility(8);
            }
            CountdownTextView countdownTextView = this.mBottomSuccessNext;
            if (countdownTextView != null) {
                CountdownTextView.start$default(countdownTextView, 5500, 0, new NetTestDriver$bottomViewState$1(this), 2, (Object) null);
            }
        }
    }

    private final void resetState() {
        Context context = getMDriverOwner().getContext();
        TextView textView = this.mTvNetRtc;
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(context, R.color.color_172B4D));
        }
        TextView textView2 = this.mTvNetIrc;
        if (textView2 != null) {
            textView2.setTextColor(ContextCompat.getColor(context, R.color.color_172B4D));
        }
        TextView textView3 = this.mTvNetServer;
        if (textView3 != null) {
            textView3.setTextColor(ContextCompat.getColor(context, R.color.color_172B4D));
        }
        TextView textView4 = this.mTvNetDownload;
        if (textView4 != null) {
            textView4.setTextColor(ContextCompat.getColor(context, R.color.color_172B4D));
        }
        ImageView imageView = this.mIvNetRtc;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.mIvNetIrc;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        ImageView imageView3 = this.mIvNetServer;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        ImageView imageView4 = this.mIvNetDownload;
        if (imageView4 != null) {
            imageView4.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void changeResultState(TextView textView, ImageView imageView, boolean z) {
        Context context = getMDriverOwner().getContext();
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(context, z ? R.color.color_172B4D : R.color.color_ff3b30));
        }
        if (imageView != null) {
            imageView.setImageResource(z ? R.drawable.ic_device_test_state_pass : R.drawable.ic_device_test_state_error);
        }
    }

    /* access modifiers changed from: private */
    public final void changeStartState(ImageView imageView) {
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ic_device_test_state_load);
        }
        cancelStateAnimator();
        if (imageView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", new float[]{0.0f, 3600.0f});
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(1);
            ofFloat.setDuration(10000);
            ofFloat.start();
            this.mObjAnimator = ofFloat;
        }
    }

    private final void cancelStateAnimator() {
        ObjectAnimator objectAnimator = this.mObjAnimator;
        if (objectAnimator != null) {
            Object target = objectAnimator.getTarget();
            ImageView imageView = target instanceof ImageView ? (ImageView) target : null;
            if (imageView != null) {
                imageView.setRotation(0.0f);
            }
            objectAnimator.removeAllUpdateListeners();
            objectAnimator.cancel();
            this.mObjAnimator = null;
        }
    }

    public void release() {
        super.release();
        CountdownTextView countdownTextView = this.mBottomSuccessNext;
        if (countdownTextView != null) {
            countdownTextView.release();
        }
        DeviceNetStateProgress deviceNetStateProgress = this.mNetStateProgress;
        if (deviceNetStateProgress != null) {
            deviceNetStateProgress.release();
        }
        cancelStateAnimator();
    }
}
