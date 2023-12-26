package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import android.content.Context;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\bJ\b\u0010\r\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\bH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/BaseScreenShareView;", "Landroid/widget/FrameLayout;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "_initView", "", "_notifyDataChange", "couse", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/CourseWareBean;", "_release", "initView", "notifyDataChange", "release", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenShareView.kt */
public abstract class BaseScreenShareView extends FrameLayout {
    private final Context mContext;

    public abstract void initView();

    public abstract void notifyDataChange(CourseWareBean courseWareBean);

    public abstract void release();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseScreenShareView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final void _initView() {
        XesLog.i(Tag.SCREEN_SHARE, "initView");
        initView();
    }

    public final void _release() {
        XesLog.i(Tag.SCREEN_SHARE, "release");
        release();
    }

    public final void _notifyDataChange(CourseWareBean courseWareBean) {
        Intrinsics.checkNotNullParameter(courseWareBean, "couse");
        XesLog.i(Tag.SCREEN_SHARE, "notifyDataChange", courseWareBean);
        notifyDataChange(courseWareBean);
    }
}
