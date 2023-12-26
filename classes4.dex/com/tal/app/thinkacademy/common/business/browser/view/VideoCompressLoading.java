package com.tal.app.thinkacademy.common.business.browser.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.databinding.VideoCompressLoadingDialogBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/view/VideoCompressLoading;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/common/databinding/VideoCompressLoadingDialogBinding;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "mListener", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setProgress", "value", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCompressLoading.kt */
public final class VideoCompressLoading extends BaseBindDialog<VideoCompressLoadingDialogBinding> {
    private Function0<Unit> mListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoCompressLoading(Context context, Function0<Unit> function0) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mListener = function0;
        canceledOnTouchOutside(false);
        setCancelable(false);
        setOnShowListener(new VideoCompressLoading$$ExternalSyntheticLambda1(context, this));
        setOnDismissListener(new VideoCompressLoading$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoCompressLoading(Context context, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function0);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m26_init_$lambda0(Context context, VideoCompressLoading videoCompressLoading, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(videoCompressLoading, "this$0");
        videoCompressLoading.binding.imgLoading.startAnimation(AnimationUtils.loadAnimation(context, R.anim.loading_animation));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m27_init_$lambda1(VideoCompressLoading videoCompressLoading, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(videoCompressLoading, "this$0");
        videoCompressLoading.binding.imgLoading.clearAnimation();
    }

    public final void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        TextView textView = this.binding.progressTextView;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('%');
        textView.setText(sb.toString());
    }

    /* access modifiers changed from: protected */
    public VideoCompressLoadingDialogBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        VideoCompressLoadingDialogBinding inflate = VideoCompressLoadingDialogBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
