package com.tal.app.thinkacademy.live.business.groupvideocall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/groupvideocall/view/GroupVideoCallSmallView;", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/view/GroupVideoCallView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "layoutGroup", "", "courseRate", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaCompat$CourseRate;", "useCourseRate", "", "singleStage", "student", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/VideoCallBean;", "surfaceView", "Landroid/view/TextureView;", "studentSliding", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupVideoCallSmallView.kt */
public final class GroupVideoCallSmallView extends GroupVideoCallView {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GroupVideoCallSmallView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GroupVideoCallSmallView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GroupVideoCallSmallView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroupVideoCallSmallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void layoutGroup(LiveAreaCompat.CourseRate courseRate, boolean z) {
        Intrinsics.checkNotNullParameter(courseRate, "courseRate");
        ViewGroup.LayoutParams layoutParams = this.mBinding.videoRemovableArea.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        LiveAreaLayoutParams pptCenterLp = LiveAreaCompat.pptCenterLp(courseRate);
        layoutParams2.width = pptCenterLp.width;
        layoutParams2.height = pptCenterLp.height;
        if (LiveAreaCompat.isSmallPad()) {
            if (!z && courseRate == LiveAreaCompat.CourseRate.RATE_16_9) {
                layoutParams2.height = (int) ((((float) layoutParams2.width) / 4.0f) * ((float) 3));
            }
        } else if (LiveAreaCompat.isSmallPhone() && z && courseRate == LiveAreaCompat.CourseRate.RATE_16_9) {
            layoutParams2.height = (int) ((((float) layoutParams2.width) / 16.0f) * ((float) 9));
        }
        this.mBinding.videoRemovableArea.setLayoutParams(layoutParams2);
    }

    public void singleStage(VideoCallBean videoCallBean, TextureView textureView) {
        Intrinsics.checkNotNullParameter(videoCallBean, "student");
        BaseVideoWindow baseVideoWindow = getStudentWindowMap().get(videoCallBean.getUserId());
        if (baseVideoWindow == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            baseVideoWindow = new DDStudentVideoWindowSmallPad(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            getStudentWindowMap().put(videoCallBean.getUserId(), baseVideoWindow);
        }
        baseVideoWindow.setStudentInform(videoCallBean);
        baseVideoWindow.setSurfaceView(textureView);
        ConstraintLayout.LayoutParams layoutParams = this.mBinding.videoRemovableArea.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
        float f = (float) layoutParams2.width;
        Float wRatio = videoCallBean.getWRatio();
        float f2 = 0.0f;
        float floatValue = f * (wRatio == null ? 0.0f : wRatio.floatValue());
        float f3 = (float) layoutParams2.height;
        Float hRatio = videoCallBean.getHRatio();
        float floatValue2 = f3 * (hRatio == null ? 0.0f : hRatio.floatValue());
        float f4 = (float) layoutParams2.width;
        Float originXRatio = videoCallBean.getOriginXRatio();
        float floatValue3 = f4 * (originXRatio == null ? 0.0f : originXRatio.floatValue());
        float f5 = (float) layoutParams2.height;
        Float originYRatio = videoCallBean.getOriginYRatio();
        if (originYRatio != null) {
            f2 = originYRatio.floatValue();
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) floatValue, (int) floatValue2);
        layoutParams3.leftMargin = (int) floatValue3;
        layoutParams3.topMargin = (int) (f5 * f2);
        this.mBinding.videoRemovableArea.addView(baseVideoWindow, layoutParams3);
    }

    public void studentSliding(VideoCallBean videoCallBean) {
        Intrinsics.checkNotNullParameter(videoCallBean, "student");
        BaseVideoWindow baseVideoWindow = getStudentWindowMap().get(videoCallBean.getUserId());
        if (baseVideoWindow != null) {
            ConstraintLayout.LayoutParams layoutParams = this.mBinding.videoRemovableArea.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
            float f = (float) layoutParams2.width;
            Float wRatio = videoCallBean.getWRatio();
            float f2 = 0.0f;
            float floatValue = f * (wRatio == null ? 0.0f : wRatio.floatValue());
            float f3 = (float) layoutParams2.height;
            Float hRatio = videoCallBean.getHRatio();
            float floatValue2 = f3 * (hRatio == null ? 0.0f : hRatio.floatValue());
            float f4 = (float) layoutParams2.width;
            Float originXRatio = videoCallBean.getOriginXRatio();
            float floatValue3 = f4 * (originXRatio == null ? 0.0f : originXRatio.floatValue());
            float f5 = (float) layoutParams2.height;
            Float originYRatio = videoCallBean.getOriginYRatio();
            if (originYRatio != null) {
                f2 = originYRatio.floatValue();
            }
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) floatValue, (int) floatValue2);
            layoutParams3.leftMargin = (int) floatValue3;
            layoutParams3.topMargin = (int) (f5 * f2);
            baseVideoWindow.setLayoutParams(layoutParams3);
        }
    }
}
