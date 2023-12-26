package com.tal.app.thinkacademy.business.login.view.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkcademy.lib.commui.widget.StateImageView;
import com.tal.app.thinkcademy.lib.commui.widget.ViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u001c\u001a\u00020\u0016H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/customview/DeviceTestStepTitle;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIvCameraState", "Lcom/tal/app/thinkcademy/lib/commui/widget/StateImageView;", "mIvLineState1", "mIvLineState2", "mIvLineState3", "mIvMicState", "mIvNetState", "mIvVoiceState", "mTvStepCamera", "Landroid/widget/TextView;", "mTvStepMic", "mTvStepVoice", "changeCamera", "", "state", "Lcom/tal/app/thinkcademy/lib/commui/widget/ViewState;", "changeMic", "changeNet", "changeVoice", "setup", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestStepTitle.kt */
public final class DeviceTestStepTitle extends FrameLayout {
    private StateImageView mIvCameraState;
    private StateImageView mIvLineState1;
    private StateImageView mIvLineState2;
    private StateImageView mIvLineState3;
    private StateImageView mIvMicState;
    private StateImageView mIvNetState;
    private StateImageView mIvVoiceState;
    private TextView mTvStepCamera;
    private TextView mTvStepMic;
    private TextView mTvStepVoice;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeviceTestStepTitle(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeviceTestStepTitle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceTestStepTitle(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceTestStepTitle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.inflate(context, R.layout.layout_device_test_step, this);
        setup();
    }

    private final void setup() {
        this.mIvNetState = (StateImageView) findViewById(R.id.iv_step_net);
        this.mIvMicState = (StateImageView) findViewById(R.id.iv_step_mic);
        this.mIvCameraState = (StateImageView) findViewById(R.id.iv_step_camera);
        this.mIvVoiceState = (StateImageView) findViewById(R.id.iv_step_voice);
        this.mIvLineState1 = (StateImageView) findViewById(R.id.iv_step_line_1);
        this.mIvLineState2 = (StateImageView) findViewById(R.id.iv_step_line_2);
        this.mIvLineState3 = (StateImageView) findViewById(R.id.iv_step_line_3);
        this.mTvStepMic = (TextView) findViewById(R.id.tv_step_mic);
        this.mTvStepCamera = (TextView) findViewById(R.id.tv_step_camera);
        this.mTvStepVoice = (TextView) findViewById(R.id.tv_step_voice);
    }

    public final void changeNet(ViewState viewState) {
        Intrinsics.checkNotNullParameter(viewState, "state");
        StateImageView stateImageView = this.mIvNetState;
        if (stateImageView != null) {
            stateImageView.changeState(viewState);
        }
    }

    public final void changeMic(ViewState viewState) {
        Intrinsics.checkNotNullParameter(viewState, "state");
        StateImageView stateImageView = this.mIvMicState;
        if (stateImageView != null) {
            stateImageView.changeState(viewState);
        }
        StateImageView stateImageView2 = this.mIvLineState1;
        if (stateImageView2 != null) {
            stateImageView2.changeState(ViewState.ONE);
        }
        TextView textView = this.mTvStepMic;
        if (textView != null) {
            textView.setAlpha(1.0f);
        }
    }

    public final void changeCamera(ViewState viewState) {
        Intrinsics.checkNotNullParameter(viewState, "state");
        StateImageView stateImageView = this.mIvCameraState;
        if (stateImageView != null) {
            stateImageView.changeState(viewState);
        }
        StateImageView stateImageView2 = this.mIvLineState2;
        if (stateImageView2 != null) {
            stateImageView2.changeState(ViewState.ONE);
        }
        TextView textView = this.mTvStepCamera;
        if (textView != null) {
            textView.setAlpha(1.0f);
        }
    }

    public final void changeVoice(ViewState viewState) {
        Intrinsics.checkNotNullParameter(viewState, "state");
        StateImageView stateImageView = this.mIvVoiceState;
        if (stateImageView != null) {
            stateImageView.changeState(viewState);
        }
        StateImageView stateImageView2 = this.mIvLineState3;
        if (stateImageView2 != null) {
            stateImageView2.changeState(ViewState.ONE);
        }
        TextView textView = this.mTvStepVoice;
        if (textView != null) {
            textView.setAlpha(1.0f);
        }
    }
}
