package com.tal.app.thinkacademy.common.business.browser.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.databinding.VideoUploadDialogLayoutBinding;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/view/VideoUploadLoadingDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/common/databinding/VideoUploadDialogLayoutBinding;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "mIsVideo", "", "mListener", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setProgress", "value", "", "setUploadType", "isVideo", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoUploadLoadingDialog.kt */
public final class VideoUploadLoadingDialog extends BaseBindDialog<VideoUploadDialogLayoutBinding> {
    private boolean mIsVideo;
    private Function0<Unit> mListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoUploadLoadingDialog(Context context, Function0<Unit> function0) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mListener = function0;
        this.mIsVideo = true;
        gravity(17).layoutParams(new LinearLayout.LayoutParams(-1, -1));
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        this.binding.btnUploadCancel.setOnClickListener(new VideoUploadLoadingDialog$$ExternalSyntheticLambda2(this));
        setProgress(0);
        setUploadType(true);
        setOnShowListener(new VideoUploadLoadingDialog$$ExternalSyntheticLambda1(context, this));
        setOnDismissListener(new VideoUploadLoadingDialog$$ExternalSyntheticLambda0(this));
        if (PadUtils.isPad(context)) {
            this.binding.videoRoot.getLayoutParams().width = SizeUtils.dp2px(343.0f);
            return;
        }
        this.binding.videoRoot.getLayoutParams().width = -1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoUploadLoadingDialog(Context context, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function0);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m29_init_$lambda0(VideoUploadLoadingDialog videoUploadLoadingDialog, View view) {
        Intrinsics.checkNotNullParameter(videoUploadLoadingDialog, "this$0");
        Function0<Unit> function0 = videoUploadLoadingDialog.mListener;
        if (function0 != null) {
            function0.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m30_init_$lambda1(Context context, VideoUploadLoadingDialog videoUploadLoadingDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(videoUploadLoadingDialog, "this$0");
        videoUploadLoadingDialog.binding.imgLoading.startAnimation(AnimationUtils.loadAnimation(context, R.anim.loading_animation));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m31_init_$lambda2(VideoUploadLoadingDialog videoUploadLoadingDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(videoUploadLoadingDialog, "this$0");
        videoUploadLoadingDialog.binding.imgLoading.clearAnimation();
    }

    public final void setUploadType(boolean z) {
        this.mIsVideo = z;
        if (z) {
            this.binding.imageRoot.setVisibility(8);
            this.binding.videoRoot.setVisibility(0);
            return;
        }
        this.binding.imageRoot.setVisibility(0);
        this.binding.videoRoot.setVisibility(8);
    }

    public final void setProgress(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i > 100) {
            i2 = 100;
        }
        this.binding.uploadProgressView.setProgress(i2);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        CharSequence charSequence = format;
        this.binding.progressTextview.setText(charSequence);
        this.binding.imageProgressTextView.setText(charSequence);
    }

    /* access modifiers changed from: protected */
    public VideoUploadDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        VideoUploadDialogLayoutBinding inflate = VideoUploadDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
