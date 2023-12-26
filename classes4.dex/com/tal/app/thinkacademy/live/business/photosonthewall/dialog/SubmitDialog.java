package com.tal.app.thinkacademy.live.business.photosonthewall.dialog;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPreviewSubmittingBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0012R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/dialog/SubmitDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessPreviewSubmittingBinding;", "cxt", "Landroid/content/Context;", "listener", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "sSubmitting", "", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "isUseImmersive", "", "onKeyDown", "keyCode", "", "event", "Landroid/view/KeyEvent;", "updateProgress", "progress", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitDialog.kt */
public final class SubmitDialog extends BaseBindDialog<LiveBusinessPreviewSubmittingBinding> {
    private final Function0<Unit> listener;
    private final String sSubmitting;

    public boolean isUseImmersive() {
        return true;
    }

    public SubmitDialog(Context context, Function0<Unit> function0) {
        super(context);
        String str;
        this.listener = function0;
        if (context == null) {
            str = null;
        } else {
            str = context.getString(R.string.submitting);
        }
        this.sSubmitting = str;
        dimAmount(0.0f);
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        TextView textView = this.binding.tvProgress;
        if (textView != null) {
            textView.setText(Intrinsics.stringPlus(str, "…0%"));
        }
        ProgressBar progressBar = this.binding.barProgress;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubmitDialog(Context context, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function0);
    }

    public final void updateProgress(int i) {
        TextView textView = this.binding.tvProgress;
        if (textView != null) {
            textView.setText(this.sSubmitting + 8230 + i + '%');
        }
        ProgressBar progressBar = this.binding.barProgress;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        Function0<Unit> function0 = this.listener;
        if (function0 != null) {
            function0.invoke();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public LiveBusinessPreviewSubmittingBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LiveBusinessPreviewSubmittingBinding inflate = LiveBusinessPreviewSubmittingBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
