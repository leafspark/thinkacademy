package com.tal.app.thinkacademy.live.business.function.view;

import com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView;
import com.tal.app.thinkcademy.lib.commui.widget.CircleProgressView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/function/view/FunctionPluginView$initViews$1$1", "Lcom/tal/app/thinkcademy/lib/commui/widget/CircleProgressView$OnProgressCallback;", "onEnd", "", "onProgress", "progress", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FunctionPluginView.kt */
public final class FunctionPluginView$initViews$1$1 implements CircleProgressView.OnProgressCallback {
    final /* synthetic */ FunctionPluginView this$0;

    public void onProgress(float f) {
    }

    FunctionPluginView$initViews$1$1(FunctionPluginView functionPluginView) {
        this.this$0 = functionPluginView;
    }

    public void onEnd() {
        this.this$0.setHandUpState(FunctionPluginView.ButtonState.NORMAL);
    }
}
