package com.tal.app.thinkacademy.live.business.allonstage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStageTeacherBinding;
import com.tal.app.thinkacademy.live.business.liveplay.bean.TeacherOnStageMsg;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J(\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/view/TeacherView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBinding", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessLayoutAllOnStageTeacherBinding;", "mContext", "mTeacherInfo", "Lcom/tal/app/thinkacademy/live/business/liveplay/bean/TeacherOnStageMsg;", "enableCorner", "", "enable", "", "onSizeChanged", "w", "h", "oldw", "oldh", "resizeChild", "width", "height", "setTeacherInfo", "info", "setTeacherVolume", "volume", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherView.kt */
public final class TeacherView extends ConstraintLayout {
    private LiveBusinessLayoutAllOnStageTeacherBinding mBinding;
    private Context mContext;
    private TeacherOnStageMsg mTeacherInfo;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TeacherView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TeacherView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void enableCorner(boolean z) {
    }

    public final void setTeacherVolume(int i) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TeacherView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        LiveBusinessLayoutAllOnStageTeacherBinding inflate = LiveBusinessLayoutAllOnStageTeacherBinding.inflate(LayoutInflater.from(context), (ViewGroup) this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = inflate;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TeacherView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setTeacherInfo(TeacherOnStageMsg teacherOnStageMsg) {
        Intrinsics.checkNotNullParameter(teacherOnStageMsg, "info");
        this.mTeacherInfo = teacherOnStageMsg;
        this.mBinding.studentName.setText(teacherOnStageMsg.getTeacherName());
        SurfaceView surfaceView = teacherOnStageMsg.getSurfaceView();
        if (surfaceView != null) {
            if (surfaceView.getParent() == null) {
                enableCorner(true);
                this.mBinding.surfaceViewRoot.addView(teacherOnStageMsg.getSurfaceView());
            } else if (!Intrinsics.areEqual(surfaceView.getParent(), this.mBinding.surfaceViewRoot)) {
                ViewParent parent = surfaceView.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(teacherOnStageMsg.getSurfaceView());
                enableCorner(true);
                this.mBinding.surfaceViewRoot.addView(teacherOnStageMsg.getSurfaceView());
            }
        }
        int i = 0;
        this.mBinding.micShow.setVisibility(teacherOnStageMsg.isOnLine() ? 0 : 8);
        ImageView imageView = this.mBinding.noTeacherBg;
        if (teacherOnStageMsg.isOpenCamera()) {
            i = 8;
        }
        imageView.setVisibility(i);
        this.mBinding.micShow.setEnabled(teacherOnStageMsg.isOpenMic());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        TeacherView.super.onSizeChanged(i, i2, i3, i4);
        XesLog.dt("TeacherView", "w = " + i + ",h=" + i2 + ",oldW=" + i3 + ",oldH=" + i4);
        resizeChild(i, i2);
    }

    private final void resizeChild(int i, int i2) {
        setOutlineProvider(new TeacherView$resizeChild$1(i2));
        setClipToOutline(true);
        ConstraintLayout.LayoutParams layoutParams = this.mBinding.bottomLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        layoutParams.height = (i2 * 31) / 165;
        ViewGroup.LayoutParams layoutParams2 = this.mBinding.micShow.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
        int i3 = (i2 * 14) / 165;
        layoutParams3.width = i3;
        layoutParams3.height = i3;
        layoutParams3.rightMargin = (i2 * 5) / 165;
        ViewGroup.LayoutParams layoutParams4 = this.mBinding.studentName.getLayoutParams();
        Objects.requireNonNull(layoutParams4, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) layoutParams4;
        layoutParams5.leftMargin = (i2 * 10) / 165;
        layoutParams5.rightMargin = (i2 * 4) / 165;
        this.mBinding.studentName.setTextSize(0, (float) ((i2 * 16) / 165));
    }
}
