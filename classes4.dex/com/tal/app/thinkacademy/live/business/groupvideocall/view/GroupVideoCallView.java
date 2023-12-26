package com.tal.app.thinkacademy.live.business.groupvideocall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessGroupVideocallBinding;
import com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J \u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001eH\u0016J\u0016\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u001eJ\u0016\u0010&\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fJ\u001a\u0010(\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u000e\u0010+\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010-\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\f2\u0006\u0010.\u001a\u00020\bJ\u0016\u0010/\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\f2\u0006\u00100\u001a\u00020\bR:\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u00061"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/groupvideocall/view/GroupVideoCallView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessGroupVideocallBinding;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "studentWindowMap", "Ljava/util/LinkedHashMap;", "", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/view/BaseVideoWindow;", "Lkotlin/collections/LinkedHashMap;", "getStudentWindowMap", "()Ljava/util/LinkedHashMap;", "setStudentWindowMap", "(Ljava/util/LinkedHashMap;)V", "addCoin", "", "student", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/VideoCallBean;", "authPen", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "layoutGroup", "courseRate", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaCompat$CourseRate;", "useCourseRate", "remotefirstVideoRecvWithUid", "uid", "isShow", "showFace", "emojiString", "singleStage", "surfaceView", "Landroid/view/TextureView;", "singleStep", "studentSliding", "updateLevel", "level", "updateMic", "volume", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupVideoCallView.kt */
public class GroupVideoCallView extends BaseVBLivePluginView<LiveBusinessGroupVideocallBinding> {
    private LinkedHashMap<String, BaseVideoWindow> studentWindowMap;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GroupVideoCallView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GroupVideoCallView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void layoutGroup(LiveAreaCompat.CourseRate courseRate, boolean z) {
        Intrinsics.checkNotNullParameter(courseRate, "courseRate");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GroupVideoCallView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroupVideoCallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.studentWindowMap = new LinkedHashMap<>();
    }

    /* access modifiers changed from: protected */
    public final LinkedHashMap<String, BaseVideoWindow> getStudentWindowMap() {
        return this.studentWindowMap;
    }

    /* access modifiers changed from: protected */
    public final void setStudentWindowMap(LinkedHashMap<String, BaseVideoWindow> linkedHashMap) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "<set-?>");
        this.studentWindowMap = linkedHashMap;
    }

    public void singleStage(VideoCallBean videoCallBean, TextureView textureView) {
        Intrinsics.checkNotNullParameter(videoCallBean, "student");
        BaseVideoWindow baseVideoWindow = this.studentWindowMap.get(videoCallBean.getUserId());
        if (baseVideoWindow == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            baseVideoWindow = new DDStudentVideoWindow(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            this.studentWindowMap.put(videoCallBean.getUserId(), baseVideoWindow);
        }
        baseVideoWindow.setStudentInform(videoCallBean);
        baseVideoWindow.setSurfaceView(textureView);
        float f = (float) LiveAreaContext.get().getPptLp().width;
        Float wRatio = videoCallBean.getWRatio();
        float f2 = 0.0f;
        float floatValue = f * (wRatio == null ? 0.0f : wRatio.floatValue());
        float f3 = (float) LiveAreaContext.get().getPptLp().height;
        Float hRatio = videoCallBean.getHRatio();
        float floatValue2 = f3 * (hRatio == null ? 0.0f : hRatio.floatValue());
        float f4 = (float) LiveAreaContext.get().getPptLp().width;
        Float originXRatio = videoCallBean.getOriginXRatio();
        float floatValue3 = f4 * (originXRatio == null ? 0.0f : originXRatio.floatValue());
        float f5 = (float) LiveAreaContext.get().getPptLp().height;
        Float originYRatio = videoCallBean.getOriginYRatio();
        if (originYRatio != null) {
            f2 = originYRatio.floatValue();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) floatValue, (int) floatValue2);
        layoutParams.leftMargin = (int) floatValue3;
        layoutParams.topMargin = (int) (f5 * f2);
        this.mBinding.videoRemovableArea.addView(baseVideoWindow, layoutParams);
    }

    public final void singleStep(VideoCallBean videoCallBean) {
        Intrinsics.checkNotNullParameter(videoCallBean, "student");
        BaseVideoWindow baseVideoWindow = this.studentWindowMap.get(videoCallBean.getUserId());
        if (baseVideoWindow != null) {
            this.mBinding.videoRemovableArea.removeView(baseVideoWindow);
            getStudentWindowMap().remove(videoCallBean.getUserId());
            baseVideoWindow.release();
        }
    }

    public final void authPen(VideoCallBean videoCallBean) {
        Intrinsics.checkNotNullParameter(videoCallBean, "student");
        BaseVideoWindow baseVideoWindow = this.studentWindowMap.get(videoCallBean.getUserId());
        if (baseVideoWindow != null) {
            Integer isAuthorize = videoCallBean.isAuthorize();
            boolean z = true;
            if (isAuthorize == null || 1 != isAuthorize.intValue()) {
                z = false;
            }
            baseVideoWindow.authPen(z);
        }
    }

    public final void addCoin(VideoCallBean videoCallBean) {
        Intrinsics.checkNotNullParameter(videoCallBean, "student");
        BaseVideoWindow baseVideoWindow = this.studentWindowMap.get(videoCallBean.getUserId());
        if (baseVideoWindow != null) {
            baseVideoWindow.addCoin(videoCallBean);
        }
    }

    public void studentSliding(VideoCallBean videoCallBean) {
        Intrinsics.checkNotNullParameter(videoCallBean, "student");
        BaseVideoWindow baseVideoWindow = this.studentWindowMap.get(videoCallBean.getUserId());
        if (baseVideoWindow != null) {
            float f = (float) LiveAreaContext.get().getPptLp().width;
            Float wRatio = videoCallBean.getWRatio();
            float f2 = 0.0f;
            float floatValue = f * (wRatio == null ? 0.0f : wRatio.floatValue());
            float f3 = (float) LiveAreaContext.get().getPptLp().height;
            Float hRatio = videoCallBean.getHRatio();
            float floatValue2 = f3 * (hRatio == null ? 0.0f : hRatio.floatValue());
            float f4 = (float) LiveAreaContext.get().getPptLp().width;
            Float originXRatio = videoCallBean.getOriginXRatio();
            float floatValue3 = f4 * (originXRatio == null ? 0.0f : originXRatio.floatValue());
            float f5 = (float) LiveAreaContext.get().getPptLp().height;
            Float originYRatio = videoCallBean.getOriginYRatio();
            if (originYRatio != null) {
                f2 = originYRatio.floatValue();
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) floatValue, (int) floatValue2);
            layoutParams.leftMargin = (int) floatValue3;
            layoutParams.topMargin = (int) (f5 * f2);
            baseVideoWindow.setLayoutParams(layoutParams);
        }
    }

    public final void updateLevel(String str, int i) {
        Intrinsics.checkNotNullParameter(str, LeanplumUtil.uid);
        BaseVideoWindow baseVideoWindow = this.studentWindowMap.get(str);
        if (baseVideoWindow != null) {
            baseVideoWindow.updateLevel(i);
        }
    }

    public final void updateMic(String str, int i) {
        Intrinsics.checkNotNullParameter(str, LeanplumUtil.uid);
        BaseVideoWindow baseVideoWindow = this.studentWindowMap.get(str);
        if (baseVideoWindow != null) {
            baseVideoWindow.updateMic(i);
        }
    }

    public final void showFace(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, LeanplumUtil.uid);
        Intrinsics.checkNotNullParameter(str2, "emojiString");
        BaseVideoWindow baseVideoWindow = this.studentWindowMap.get(str);
        if (baseVideoWindow != null) {
            baseVideoWindow.showFace(str2);
        }
    }

    public final void remotefirstVideoRecvWithUid(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, LeanplumUtil.uid);
        BaseVideoWindow baseVideoWindow = this.studentWindowMap.get(str);
        if (baseVideoWindow != null) {
            baseVideoWindow.remotefirstVideoRecvWithUid(z);
        }
    }

    /* access modifiers changed from: protected */
    public LiveBusinessGroupVideocallBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessGroupVideocallBinding inflate = LiveBusinessGroupVideocallBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }
}
