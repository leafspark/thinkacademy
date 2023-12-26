package com.tal.app.thinkacademy.live.business.drawing;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiDrawAgent;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/drawing/DrawPluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseLivePluginView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "blackboard", "Landroid/widget/FrameLayout;", "tvTeacherLook", "Landroid/widget/TextView;", "destroy", "", "getLayoutId", "", "initViews", "setCanvasView", "agent", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiDrawAgent;", "setTeacherLook", "look", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DrawPluginView.kt */
public final class DrawPluginView extends BaseLivePluginView {
    private FrameLayout blackboard;
    private TextView tvTeacherLook;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawPluginView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public int getLayoutId() {
        return R.layout.live_business_drawing;
    }

    public void initViews() {
        DrawPluginView.super.initViews();
        View findViewById = findViewById(R.id.live_business_fl_draw_broad);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.live_business_fl_draw_broad)");
        this.blackboard = (FrameLayout) findViewById;
        this.tvTeacherLook = (TextView) findViewById(R.id.tv_teacher_looking);
    }

    public final void setTeacherLook(boolean z) {
        TextView textView;
        if (this.mContext != null && (textView = this.tvTeacherLook) != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    public final void setCanvasView(GraffitiDrawAgent graffitiDrawAgent) {
        if (graffitiDrawAgent != null) {
            FrameLayout frameLayout = this.blackboard;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blackboard");
                frameLayout = null;
            }
            graffitiDrawAgent.bindCanvasView(frameLayout);
        }
    }

    public final void destroy() {
        removeAllViews();
    }
}
