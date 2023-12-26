package io.github.ponnamkarthik.toast.fluttertoast;

import android.widget.Toast;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"io/github/ponnamkarthik/toast/fluttertoast/MethodCallHandlerImpl$onMethodCall$2", "Landroid/widget/Toast$Callback;", "onToastHidden", "", "fluttertoast_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MethodCallHandlerImpl.kt */
public final class MethodCallHandlerImpl$onMethodCall$2 extends Toast.Callback {
    final /* synthetic */ MethodCallHandlerImpl this$0;

    MethodCallHandlerImpl$onMethodCall$2(MethodCallHandlerImpl methodCallHandlerImpl) {
        this.this$0 = methodCallHandlerImpl;
    }

    public void onToastHidden() {
        MethodCallHandlerImpl$onMethodCall$2.super.onToastHidden();
        this.this$0.mToast = null;
    }
}
