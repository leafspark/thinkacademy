package com.tal.app.thinkacademy.business.study.study.vodplayer;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tal.app.thinkacademy.business.studycenter.databinding.VideoScreenShotDialogBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VideoScreenShotDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/VideoScreenShotDialogBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setAlphaProAnimation", "", "v", "Landroid/view/View;", "setScaleProAnimation", "setShotBitmap", "bitmap", "Landroid/graphics/Bitmap;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoScreenShotDialog.kt */
public final class VideoScreenShotDialog extends BaseBindDialog<VideoScreenShotDialogBinding> {
    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m496_init_$lambda1(DialogInterface dialogInterface) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoScreenShotDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        setOnShowListener(new VideoScreenShotDialog$$ExternalSyntheticLambda2(this));
        setOnDismissListener(VideoScreenShotDialog$$ExternalSyntheticLambda1.INSTANCE);
        dimAmount(0.0f);
        this.binding.screenShotImage.setOutlineProvider(new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                if (outline != null) {
                    outline.setRoundRect(0, 0, view == null ? 0 : view.getWidth(), view == null ? 0 : view.getHeight(), (float) SizeUtils.dp2px(10.0f));
                }
            }
        });
        this.binding.screenShotImage.setClipToOutline(true);
    }

    /* access modifiers changed from: protected */
    public VideoScreenShotDialogBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        VideoScreenShotDialogBinding inflate = VideoScreenShotDialogBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m495_init_$lambda0(VideoScreenShotDialog videoScreenShotDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(videoScreenShotDialog, "this$0");
        videoScreenShotDialog.binding.imageCardLayout.setVisibility(8);
        videoScreenShotDialog.setAlphaProAnimation(videoScreenShotDialog.binding.shotBg);
    }

    public final void setShotBitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        ConstraintLayout.LayoutParams layoutParams = this.binding.imageCardLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        StringBuilder sb = new StringBuilder();
        sb.append(bitmap.getWidth());
        sb.append(':');
        sb.append(bitmap.getHeight());
        layoutParams.dimensionRatio = sb.toString();
        this.binding.screenShotImage.setImageBitmap(bitmap);
    }

    private final void setAlphaProAnimation(View view) {
        if (view != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
            ofFloat.setDuration(300);
            ofFloat.addListener(new VideoScreenShotDialog$setAlphaProAnimation$1(this));
            ofFloat.start();
        }
    }

    /* access modifiers changed from: private */
    public final void setScaleProAnimation(View view) {
        if (view != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            ofFloat.setDuration(200);
            ofFloat.addUpdateListener(new VideoScreenShotDialog$$ExternalSyntheticLambda0(view));
            ofFloat.addListener(new VideoScreenShotDialog$setScaleProAnimation$2(this));
            ofFloat.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setScaleProAnimation$lambda-2  reason: not valid java name */
    public static final void m497setScaleProAnimation$lambda2(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        Float f = (Float) animatedValue;
        view.setScaleX(f.floatValue());
        view.setScaleY(f.floatValue());
    }
}
