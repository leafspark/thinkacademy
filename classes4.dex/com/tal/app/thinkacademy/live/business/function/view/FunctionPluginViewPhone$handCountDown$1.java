package com.tal.app.thinkacademy.live.business.function.view;

import android.widget.TextView;
import com.tal.app.thinkcademy.lib.commui.widget.CircleProgressView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/function/view/FunctionPluginViewPhone$handCountDown$1", "Lcom/tal/app/thinkcademy/lib/commui/widget/CircleProgressView$OnProgressCallback;", "onEnd", "", "onProgress", "progress", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FunctionPluginViewPhone.kt */
public final class FunctionPluginViewPhone$handCountDown$1 implements CircleProgressView.OnProgressCallback {
    final /* synthetic */ FunctionPluginViewPhone this$0;

    FunctionPluginViewPhone$handCountDown$1(FunctionPluginViewPhone functionPluginViewPhone) {
        this.this$0 = functionPluginViewPhone;
    }

    public void onProgress(float f) {
        TextView textView = this.this$0.mBinding.liveBusinessFunctionTvHandProgress;
        StringBuilder sb = new StringBuilder();
        sb.append((int) ((((float) 105) - f) / ((float) 10)));
        sb.append('s');
        textView.setText(sb.toString());
    }

    public void onEnd() {
        this.this$0.mBinding.liveBusinessFunctionIvHand.setVisibility(0);
        this.this$0.mBinding.liveBusinessFunctionCpbHand.setVisibility(8);
        this.this$0.mBinding.liveBusinessFunctionTvHandProgress.setVisibility(8);
        this.this$0.mBinding.liveBusinessFunctionIvHandDis.setVisibility(8);
    }
}
