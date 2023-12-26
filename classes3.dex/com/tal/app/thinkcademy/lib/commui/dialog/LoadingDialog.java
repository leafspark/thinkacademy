package com.tal.app.thinkcademy.lib.commui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.animation.AnimationUtils;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.databinding.LoadingViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0014¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/dialog/LoadingDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/lib/commui/databinding/LoadingViewBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoadingDialog.kt */
public final class LoadingDialog extends BaseBindDialog<LoadingViewBinding> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadingDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        canceledOnTouchOutside(false);
        dimAmount(0.0f);
        setOnShowListener(new LoadingDialog$$ExternalSyntheticLambda1(context, this));
        setOnDismissListener(new LoadingDialog$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m514_init_$lambda0(Context context, LoadingDialog loadingDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(loadingDialog, "this$0");
        loadingDialog.binding.imgLoading.startAnimation(AnimationUtils.loadAnimation(context, R.anim.loading_animation));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m515_init_$lambda1(LoadingDialog loadingDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(loadingDialog, "this$0");
        loadingDialog.binding.imgLoading.clearAnimation();
    }

    /* access modifiers changed from: protected */
    public LoadingViewBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LoadingViewBinding inflate = LoadingViewBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
