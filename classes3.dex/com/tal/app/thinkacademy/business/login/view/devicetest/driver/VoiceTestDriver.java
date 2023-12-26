package com.tal.app.thinkacademy.business.login.view.devicetest.driver;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0017J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u0019H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/VoiceTestDriver;", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/BaseTestDriver;", "owner", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;", "(Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;)V", "mGroupVoicePreview", "Landroid/view/View;", "mGroupVoiceState", "mIvVoiceState", "Landroid/widget/ImageView;", "mLayoutVoicePreview", "mLine", "mProgressVoice", "Landroid/widget/ProgressBar;", "mSoundId", "", "Ljava/lang/Integer;", "mTvErrorNext", "Landroid/widget/TextView;", "mTvErrorRetest", "mTvVoiceMsg", "mTvVoiceResultNo", "mTvVoiceResultYes", "mTvVoiceSize", "load", "", "group", "Landroid/view/ViewGroup;", "playMusic", "release", "showSystemVoice", "showVoiceError", "stopMusic", "Companion", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoiceTestDriver.kt */
public final class VoiceTestDriver extends BaseTestDriver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "DeviceTest_voice";
    private View mGroupVoicePreview;
    private View mGroupVoiceState;
    private ImageView mIvVoiceState;
    private View mLayoutVoicePreview;
    private View mLine;
    /* access modifiers changed from: private */
    public ProgressBar mProgressVoice;
    private Integer mSoundId;
    private TextView mTvErrorNext;
    private TextView mTvErrorRetest;
    private TextView mTvVoiceMsg;
    private View mTvVoiceResultNo;
    private View mTvVoiceResultYes;
    /* access modifiers changed from: private */
    public TextView mTvVoiceSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceTestDriver(DeviceTestDriverOwner deviceTestDriverOwner) {
        super(deviceTestDriverOwner);
        Intrinsics.checkNotNullParameter(deviceTestDriverOwner, "owner");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/VoiceTestDriver$Companion;", "", "()V", "TAG", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VoiceTestDriver.kt */
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
        LayoutInflater from = LayoutInflater.from(getMDriverOwner().getContext());
        int i = R.layout.layout_device_test_voice_driver;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, viewGroup) : XMLParseInstrumentation.inflate(from, i, viewGroup);
        this.mLayoutVoicePreview = inflate.findViewById(R.id.layout_voice_preview);
        this.mProgressVoice = (ProgressBar) inflate.findViewById(R.id.progress_voice);
        this.mTvVoiceSize = (TextView) inflate.findViewById(R.id.tv_voice_size);
        this.mIvVoiceState = (ImageView) inflate.findViewById(R.id.iv_voice_state);
        this.mTvVoiceMsg = (TextView) inflate.findViewById(R.id.tv_voice_msg);
        this.mLine = inflate.findViewById(R.id.line_content);
        this.mGroupVoiceState = inflate.findViewById(R.id.group_voice_state);
        this.mTvErrorRetest = (TextView) inflate.findViewById(R.id.tv_error_retest);
        this.mTvErrorNext = (TextView) inflate.findViewById(R.id.tv_error_next);
        this.mGroupVoicePreview = inflate.findViewById(R.id.group_voice_preview);
        this.mTvVoiceResultNo = inflate.findViewById(R.id.tv_voice_result_no);
        this.mTvVoiceResultYes = inflate.findViewById(R.id.tv_voice_result_yes);
        getMDriverOwner().obtainSystemMediaVoiceSize(new VoiceTestDriver$load$1(this));
        View view = this.mTvVoiceResultNo;
        if (view != null) {
            view.setOnClickListener(new VoiceTestDriver$$ExternalSyntheticLambda1(this));
        }
        View view2 = this.mTvVoiceResultYes;
        if (view2 != null) {
            view2.setOnClickListener(new VoiceTestDriver$$ExternalSyntheticLambda2(this));
        }
        TextView textView = this.mTvErrorRetest;
        if (textView != null) {
            textView.setOnClickListener(new VoiceTestDriver$$ExternalSyntheticLambda3(this));
        }
        TextView textView2 = this.mTvErrorNext;
        if (textView2 != null) {
            textView2.setOnClickListener(new VoiceTestDriver$$ExternalSyntheticLambda0(this));
        }
        showSystemVoice();
    }

    /* access modifiers changed from: private */
    /* renamed from: load$lambda-0  reason: not valid java name */
    public static final void m165load$lambda0(VoiceTestDriver voiceTestDriver, View view) {
        Intrinsics.checkNotNullParameter(voiceTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"用户点击听不到播放声音"});
        Function1<Boolean, Unit> mResultCallBlock = voiceTestDriver.getMResultCallBlock();
        if (mResultCallBlock != null) {
            mResultCallBlock.invoke(false);
        }
        voiceTestDriver.showVoiceError();
        voiceTestDriver.stopMusic();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: load$lambda-1  reason: not valid java name */
    public static final void m166load$lambda1(VoiceTestDriver voiceTestDriver, View view) {
        Intrinsics.checkNotNullParameter(voiceTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"用户点击听到播放声音"});
        Function1<Boolean, Unit> mResultCallBlock = voiceTestDriver.getMResultCallBlock();
        if (mResultCallBlock != null) {
            mResultCallBlock.invoke(true);
        }
        Function0<Unit> mFinishCallBlock = voiceTestDriver.getMFinishCallBlock();
        if (mFinishCallBlock != null) {
            mFinishCallBlock.invoke();
        }
        voiceTestDriver.stopMusic();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: load$lambda-2  reason: not valid java name */
    public static final void m167load$lambda2(VoiceTestDriver voiceTestDriver, View view) {
        Intrinsics.checkNotNullParameter(voiceTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"重新测试"});
        voiceTestDriver.showSystemVoice();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: load$lambda-3  reason: not valid java name */
    public static final void m168load$lambda3(VoiceTestDriver voiceTestDriver, View view) {
        Intrinsics.checkNotNullParameter(voiceTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"重新失败，点击下一项测试"});
        Function0<Unit> mFinishCallBlock = voiceTestDriver.getMFinishCallBlock();
        if (mFinishCallBlock != null) {
            mFinishCallBlock.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void showSystemVoice() {
        XesLog.it(TAG, new Object[]{"开始声音测试"});
        View view = this.mLayoutVoicePreview;
        if (view != null) {
            view.setVisibility(0);
        }
        ImageView imageView = this.mIvVoiceState;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.mTvVoiceMsg;
        if (textView != null) {
            textView.setVisibility(8);
        }
        View view2 = this.mLine;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.mGroupVoiceState;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.mGroupVoicePreview;
        if (view4 != null) {
            view4.setVisibility(0);
        }
        playMusic();
    }

    private final void showVoiceError() {
        View view = this.mLayoutVoicePreview;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView = this.mIvVoiceState;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        TextView textView = this.mTvVoiceMsg;
        if (textView != null) {
            textView.setVisibility(0);
        }
        View view2 = this.mLine;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.mGroupVoiceState;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        View view4 = this.mGroupVoicePreview;
        if (view4 != null) {
            view4.setVisibility(8);
        }
    }

    private final void playMusic() {
        this.mSoundId = Integer.valueOf(getMDriverOwner().playVoice(R.raw.bgm_card, -1));
    }

    private final void stopMusic() {
        Integer num = this.mSoundId;
        if (num != null) {
            getMDriverOwner().stopPlayVoice(num.intValue());
        }
        this.mSoundId = null;
    }

    public void release() {
        super.release();
        stopMusic();
    }
}
