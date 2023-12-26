package com.tal.app.thinkacademy.live.business.photosonthewall.dialog;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flyco.roundview.RoundTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPreviewSubmitGuideBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aR\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/dialog/SubmitGuideDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessPreviewSubmitGuideBinding;", "cxt", "Landroid/content/Context;", "listener", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/dialog/SubmitGuideOperating;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "mCountDownTimer", "Landroid/os/CountDownTimer;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "dismiss", "endCountdown", "isUseImmersive", "", "onKeyDown", "keyCode", "", "event", "Landroid/view/KeyEvent;", "startCountdown", "millisDuration", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitGuideDialog.kt */
public final class SubmitGuideDialog extends BaseBindDialog<LiveBusinessPreviewSubmitGuideBinding> {
    /* access modifiers changed from: private */
    public final Function1<SubmitGuideOperating, Unit> listener;
    private CountDownTimer mCountDownTimer;

    public boolean isUseImmersive() {
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubmitGuideDialog(Context context, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function1);
    }

    public SubmitGuideDialog(Context context, Function1<? super SubmitGuideOperating, Unit> function1) {
        super(context);
        this.listener = function1;
        dimAmount(0.0f);
        canceledOnTouchOutside(true);
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        RoundTextView roundTextView = this.binding.tvBack;
        if (roundTextView != null) {
            roundTextView.setOnClickListener(new SubmitGuideDialog$$ExternalSyntheticLambda1(this));
        }
        TextView textView = this.binding.tvSubmit;
        if (textView != null) {
            textView.setOnClickListener(new SubmitGuideDialog$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: protected */
    public LiveBusinessPreviewSubmitGuideBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LiveBusinessPreviewSubmitGuideBinding inflate = LiveBusinessPreviewSubmitGuideBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m354_init_$lambda1(SubmitGuideDialog submitGuideDialog, View view) {
        Intrinsics.checkNotNullParameter(submitGuideDialog, "this$0");
        submitGuideDialog.dismiss();
        Function1<SubmitGuideOperating, Unit> function1 = submitGuideDialog.listener;
        if (function1 != null) {
            function1.invoke(SubmitGuideOperating.Back);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m355_init_$lambda3(SubmitGuideDialog submitGuideDialog, View view) {
        Intrinsics.checkNotNullParameter(submitGuideDialog, "this$0");
        submitGuideDialog.dismiss();
        Function1<SubmitGuideOperating, Unit> function1 = submitGuideDialog.listener;
        if (function1 != null) {
            function1.invoke(SubmitGuideOperating.Submit);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void dismiss() {
        super.dismiss();
        endCountdown();
    }

    public final void startCountdown(long j) {
        CountDownTimer submitGuideDialog$startCountdown$1 = new SubmitGuideDialog$startCountdown$1(RangesKt.coerceAtLeast(j, 0), this);
        this.mCountDownTimer = submitGuideDialog$startCountdown$1;
        submitGuideDialog$startCountdown$1.start();
    }

    private final void endCountdown() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mCountDownTimer = null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        Function1<SubmitGuideOperating, Unit> function1 = this.listener;
        if (function1 != null) {
            function1.invoke(SubmitGuideOperating.OnKeyDown);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
