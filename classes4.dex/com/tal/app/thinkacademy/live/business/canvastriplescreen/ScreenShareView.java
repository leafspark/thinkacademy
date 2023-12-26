package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import android.content.Context;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0010R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/ScreenShareView;", "", "context", "Landroid/content/Context;", "isBack", "", "couse", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/CourseWareBean;", "liveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;ZLcom/tal/app/thinkacademy/live/business/canvastriplescreen/CourseWareBean;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "layout", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/BaseScreenShareView;", "getLayout", "()Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/BaseScreenShareView;", "notifyDataChange", "", "release", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenShareView.kt */
public final class ScreenShareView {
    private final BaseScreenShareView layout;

    public ScreenShareView(Context context, boolean z, CourseWareBean courseWareBean, ILiveRoomProvider iLiveRoomProvider) {
        BaseScreenShareView baseScreenShareView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(courseWareBean, "couse");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "liveRoomProvider");
        if (z) {
            baseScreenShareView = new ScreenSharePlayBackView(context, iLiveRoomProvider, courseWareBean);
        } else {
            baseScreenShareView = new ScreenShareLiveView(context, courseWareBean.shareInfoUid);
        }
        this.layout = baseScreenShareView;
        baseScreenShareView._initView();
    }

    public final BaseScreenShareView getLayout() {
        return this.layout;
    }

    public final void release() {
        this.layout._release();
    }

    public final void notifyDataChange(CourseWareBean courseWareBean) {
        Intrinsics.checkNotNullParameter(courseWareBean, "couse");
        this.layout._notifyDataChange(courseWareBean);
    }
}
