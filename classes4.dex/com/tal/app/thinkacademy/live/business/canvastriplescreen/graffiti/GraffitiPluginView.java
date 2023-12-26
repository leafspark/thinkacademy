package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import android.content.Context;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiPluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseLivePluginView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getLayoutId", "", "initViews", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiPluginView.kt */
public final class GraffitiPluginView extends BaseLivePluginView {
    public void initViews() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraffitiPluginView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public int getLayoutId() {
        return R.layout.layout_graffiti_plugin_view;
    }
}
