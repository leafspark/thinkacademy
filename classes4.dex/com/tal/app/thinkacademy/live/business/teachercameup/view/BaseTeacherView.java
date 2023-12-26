package com.tal.app.thinkacademy.live.business.teachercameup.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import androidx.viewbinding.ViewBinding;
import com.tal.app.thinkacademy.live.business.teachercameup.bean.TeacherCameUpBean;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0016H&J\b\u0010\u001c\u001a\u00020\u0012H&J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\tH&J\"\u0010 \u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010#H&R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/teachercameup/view/BaseTeacherView;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mTeacherInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/TeacherInfo;", "getMTeacherInfo", "()Lcom/tal/app/thinkacademy/live/core/live/http/bean/TeacherInfo;", "setMTeacherInfo", "(Lcom/tal/app/thinkacademy/live/core/live/http/bean/TeacherInfo;)V", "layoutView", "", "courseRate", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaCompat$CourseRate;", "useCourseRate", "", "onThePlatform", "bean", "Lcom/tal/app/thinkacademy/live/business/teachercameup/bean/TeacherCameUpBean;", "setPrivateCallLabelVisible", "isVisible", "underThePlatform", "updateMic", "isOpenMic", "volume", "videoOperation", "isOpenCamera", "surfaceView", "Landroid/view/SurfaceView;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseTeacherView.kt */
public abstract class BaseTeacherView<VB extends ViewBinding> extends BaseVBLivePluginView<VB> {
    private TeacherInfo mTeacherInfo;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseTeacherView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseTeacherView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void layoutView(LiveAreaCompat.CourseRate courseRate, boolean z) {
        Intrinsics.checkNotNullParameter(courseRate, "courseRate");
    }

    public abstract void onThePlatform(TeacherCameUpBean teacherCameUpBean);

    public abstract void setPrivateCallLabelVisible(boolean z);

    public abstract void underThePlatform();

    public abstract void updateMic(boolean z, int i);

    public abstract void videoOperation(TeacherCameUpBean teacherCameUpBean, boolean z, SurfaceView surfaceView);

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseTeacherView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseTeacherView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final TeacherInfo getMTeacherInfo() {
        return this.mTeacherInfo;
    }

    public final void setMTeacherInfo(TeacherInfo teacherInfo) {
        this.mTeacherInfo = teacherInfo;
    }
}
