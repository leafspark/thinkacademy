package com.tal.app.thinkacademy.business.login.view.devicetest.driver;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.view.customview.CountdownTextView;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkcademy.lib.commui.widget.CircleProgressView;
import com.tal.app.thinkcademy.lib.commui.widget.StateImageView;
import com.tal.app.thinkcademy.lib.commui.widget.ViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/MicTestDriver;", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/BaseTestDriver;", "owner", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;", "(Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;)V", "mGroupInput", "Landroid/view/View;", "mGroupMicState", "mIvMicState", "Lcom/tal/app/thinkcademy/lib/commui/widget/StateImageView;", "mLayoutMicState", "Landroid/widget/TextView;", "mMicMaxVolume", "", "mTvMicErrorNext", "mTvMicMsg", "mTvMicPassNext", "Lcom/tal/app/thinkacademy/business/login/view/customview/CountdownTextView;", "mTvMicRetest", "mViewInputProgress", "Lcom/tal/app/thinkcademy/lib/commui/widget/CircleProgressView;", "load", "", "group", "Landroid/view/ViewGroup;", "release", "showMicOk", "showNoPermissionView", "showNoVoiceView", "startInputTest", "Companion", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MicTestDriver.kt */
public final class MicTestDriver extends BaseTestDriver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "DeviceTest_mic";
    private View mGroupInput;
    private View mGroupMicState;
    /* access modifiers changed from: private */
    public StateImageView mIvMicState;
    private TextView mLayoutMicState;
    /* access modifiers changed from: private */
    public double mMicMaxVolume;
    private TextView mTvMicErrorNext;
    private TextView mTvMicMsg;
    /* access modifiers changed from: private */
    public CountdownTextView mTvMicPassNext;
    private TextView mTvMicRetest;
    private CircleProgressView mViewInputProgress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MicTestDriver(DeviceTestDriverOwner deviceTestDriverOwner) {
        super(deviceTestDriverOwner);
        Intrinsics.checkNotNullParameter(deviceTestDriverOwner, "owner");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/MicTestDriver$Companion;", "", "()V", "TAG", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MicTestDriver.kt */
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
        int i = R.layout.layout_device_test_mic_driver;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, viewGroup) : XMLParseInstrumentation.inflate(from, i, viewGroup);
        this.mIvMicState = (StateImageView) inflate.findViewById(R.id.iv_mic_state);
        this.mTvMicMsg = (TextView) inflate.findViewById(R.id.tv_mic_msg);
        this.mGroupMicState = inflate.findViewById(R.id.group_mic_state);
        this.mLayoutMicState = (TextView) inflate.findViewById(R.id.layout_mic_state);
        this.mTvMicPassNext = (CountdownTextView) inflate.findViewById(R.id.tv_mic_pass_next);
        this.mTvMicRetest = (TextView) inflate.findViewById(R.id.tv_error_retest);
        this.mTvMicErrorNext = (TextView) inflate.findViewById(R.id.tv_error_next);
        this.mGroupInput = inflate.findViewById(R.id.group_mic_input);
        CircleProgressView circleProgressView = (CircleProgressView) inflate.findViewById(R.id.view_input_progress);
        this.mViewInputProgress = circleProgressView;
        if (circleProgressView != null) {
            circleProgressView.setBgColor(0);
        }
        CircleProgressView circleProgressView2 = this.mViewInputProgress;
        if (circleProgressView2 != null) {
            circleProgressView2.setBackWidth(SizeUtils.dp2px(4.0f));
        }
        CircleProgressView circleProgressView3 = this.mViewInputProgress;
        if (circleProgressView3 != null) {
            circleProgressView3.setBackColor(ContextCompat.getColor(viewGroup.getContext(), R.color.color_C8CDD7));
        }
        CircleProgressView circleProgressView4 = this.mViewInputProgress;
        if (circleProgressView4 != null) {
            circleProgressView4.setProgressWidth(SizeUtils.dp2px(4.0f));
        }
        CircleProgressView circleProgressView5 = this.mViewInputProgress;
        if (circleProgressView5 != null) {
            circleProgressView5.setProgressColor(ContextCompat.getColor(viewGroup.getContext(), R.color.color_39CD5F));
        }
        CircleProgressView circleProgressView6 = this.mViewInputProgress;
        if (circleProgressView6 != null) {
            circleProgressView6.setProgressCallback(new MicTestDriver$load$1(this));
        }
        getMDriverOwner().requestPermission("android.permission.RECORD_AUDIO", new MicTestDriver$load$2(this));
    }

    /* access modifiers changed from: private */
    public final void showMicOk() {
        XesLog.it(TAG, new Object[]{"麦克风检测通过"});
        View view = this.mGroupMicState;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.mGroupInput;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        StateImageView stateImageView = this.mIvMicState;
        if (stateImageView != null) {
            stateImageView.setSelected(false);
        }
        StateImageView stateImageView2 = this.mIvMicState;
        if (stateImageView2 != null) {
            stateImageView2.changeState(ViewState.ONE, true);
        }
        TextView textView = this.mTvMicMsg;
        if (textView != null) {
            textView.setText(getMDriverOwner().getContext().getString(R.string.microphone_test_complete));
        }
        TextView textView2 = this.mLayoutMicState;
        if (textView2 != null) {
            textView2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_device_test_state_pass_big, 0, 0);
        }
        TextView textView3 = this.mLayoutMicState;
        if (textView3 != null) {
            textView3.setText(getMDriverOwner().getContext().getString(R.string.your_device_microphone_is_working_properly));
        }
        CountdownTextView countdownTextView = this.mTvMicPassNext;
        if (countdownTextView != null) {
            countdownTextView.setVisibility(0);
        }
        TextView textView4 = this.mTvMicRetest;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        TextView textView5 = this.mTvMicErrorNext;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        CountdownTextView countdownTextView2 = this.mTvMicPassNext;
        if (countdownTextView2 != null) {
            countdownTextView2.setOnClickListener(new MicTestDriver$$ExternalSyntheticLambda4(this));
        }
        CountdownTextView countdownTextView3 = this.mTvMicPassNext;
        if (countdownTextView3 != null) {
            CountdownTextView.start$default(countdownTextView3, 5500, 0, new MicTestDriver$showMicOk$2(this), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showMicOk$lambda-0  reason: not valid java name */
    public static final void m154showMicOk$lambda0(MicTestDriver micTestDriver, View view) {
        Intrinsics.checkNotNullParameter(micTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"麦克风检测完成，主动点击下一项"});
        Function0<Unit> mFinishCallBlock = micTestDriver.getMFinishCallBlock();
        if (mFinishCallBlock != null) {
            mFinishCallBlock.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final void showNoPermissionView() {
        XesLog.it(TAG, new Object[]{"无麦克风权限异常页面"});
        View view = this.mGroupMicState;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.mGroupInput;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        CountdownTextView countdownTextView = this.mTvMicPassNext;
        if (countdownTextView != null) {
            countdownTextView.setVisibility(8);
        }
        StateImageView stateImageView = this.mIvMicState;
        if (stateImageView != null) {
            stateImageView.setSelected(true);
        }
        StateImageView stateImageView2 = this.mIvMicState;
        if (stateImageView2 != null) {
            stateImageView2.changeState(ViewState.ONE, false);
        }
        TextView textView = this.mTvMicMsg;
        if (textView != null) {
            textView.setText(getMDriverOwner().getContext().getString(R.string.thinkAcademy_can_not_use_your_microphone));
        }
        TextView textView2 = this.mLayoutMicState;
        if (textView2 != null) {
            textView2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_device_test_state_error_big, 0, 0);
        }
        TextView textView3 = this.mLayoutMicState;
        if (textView3 != null) {
            textView3.setText(getMDriverOwner().getContext().getString(R.string.access_microphone_to_system_settings));
        }
        TextView textView4 = this.mTvMicRetest;
        if (textView4 != null) {
            textView4.setText(getMDriverOwner().getContext().getString(R.string.settings));
        }
        TextView textView5 = this.mTvMicRetest;
        if (textView5 != null) {
            textView5.setOnClickListener(new MicTestDriver$$ExternalSyntheticLambda1(this));
        }
        TextView textView6 = this.mTvMicErrorNext;
        if (textView6 != null) {
            textView6.setOnClickListener(new MicTestDriver$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showNoPermissionView$lambda-1  reason: not valid java name */
    public static final void m155showNoPermissionView$lambda1(MicTestDriver micTestDriver, View view) {
        Intrinsics.checkNotNullParameter(micTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"麦克风无权限，跳转系统settings"});
        micTestDriver.getMDriverOwner().saveStateAndToSystemSettings();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showNoPermissionView$lambda-2  reason: not valid java name */
    public static final void m156showNoPermissionView$lambda2(MicTestDriver micTestDriver, View view) {
        Intrinsics.checkNotNullParameter(micTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"麦克风无权限，跳转下一项检测"});
        Function0<Unit> mFinishCallBlock = micTestDriver.getMFinishCallBlock();
        if (mFinishCallBlock != null) {
            mFinishCallBlock.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final void showNoVoiceView() {
        XesLog.it(TAG, new Object[]{"麦克风测试失败"});
        View view = this.mGroupMicState;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.mGroupInput;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        CountdownTextView countdownTextView = this.mTvMicPassNext;
        if (countdownTextView != null) {
            countdownTextView.setVisibility(8);
        }
        StateImageView stateImageView = this.mIvMicState;
        if (stateImageView != null) {
            stateImageView.setSelected(true);
        }
        StateImageView stateImageView2 = this.mIvMicState;
        if (stateImageView2 != null) {
            stateImageView2.changeState(ViewState.ONE, false);
        }
        TextView textView = this.mTvMicMsg;
        if (textView != null) {
            textView.setText(getMDriverOwner().getContext().getString(R.string.no_available_microphone_devices_were_detected));
        }
        TextView textView2 = this.mLayoutMicState;
        if (textView2 != null) {
            textView2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_device_test_state_error_big, 0, 0);
        }
        TextView textView3 = this.mLayoutMicState;
        if (textView3 != null) {
            textView3.setText(getMDriverOwner().getContext().getString(R.string.check_mic_settings_or_wear_headphones));
        }
        TextView textView4 = this.mTvMicRetest;
        if (textView4 != null) {
            textView4.setText(getMDriverOwner().getContext().getString(R.string.retest));
        }
        TextView textView5 = this.mTvMicRetest;
        if (textView5 != null) {
            textView5.setOnClickListener(new MicTestDriver$$ExternalSyntheticLambda0(this));
        }
        TextView textView6 = this.mTvMicErrorNext;
        if (textView6 != null) {
            textView6.setOnClickListener(new MicTestDriver$$ExternalSyntheticLambda3(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showNoVoiceView$lambda-3  reason: not valid java name */
    public static final void m157showNoVoiceView$lambda3(MicTestDriver micTestDriver, View view) {
        Intrinsics.checkNotNullParameter(micTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"麦克风测试失败，重新测试"});
        micTestDriver.startInputTest();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showNoVoiceView$lambda-4  reason: not valid java name */
    public static final void m158showNoVoiceView$lambda4(MicTestDriver micTestDriver, View view) {
        Intrinsics.checkNotNullParameter(micTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"麦克风测试失败，跳转下一项测试"});
        Function0<Unit> mFinishCallBlock = micTestDriver.getMFinishCallBlock();
        if (mFinishCallBlock != null) {
            mFinishCallBlock.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final void startInputTest() {
        XesLog.it(TAG, new Object[]{"开始麦克风收音测试"});
        View view = this.mGroupMicState;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mGroupInput;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        CircleProgressView circleProgressView = this.mViewInputProgress;
        if (circleProgressView != null) {
            circleProgressView.startProgress(100, 10000);
        }
        StateImageView stateImageView = this.mIvMicState;
        if (stateImageView != null) {
            stateImageView.setSelected(false);
        }
        StateImageView stateImageView2 = this.mIvMicState;
        if (stateImageView2 != null) {
            stateImageView2.changeState(ViewState.ONE, false);
        }
        TextView textView = this.mTvMicMsg;
        if (textView != null) {
            textView.setText(getMDriverOwner().getContext().getString(R.string.now_try_to_read_the_following_text_into_the_microphone));
        }
        getMDriverOwner().startRecord(new MicTestDriver$startInputTest$1(this));
    }

    public void release() {
        super.release();
        CircleProgressView circleProgressView = this.mViewInputProgress;
        if (circleProgressView != null) {
            circleProgressView.reset();
        }
        CountdownTextView countdownTextView = this.mTvMicPassNext;
        if (countdownTextView != null) {
            countdownTextView.release();
        }
    }
}
