package io.flutter.util;

import android.view.View;
import io.flutter.util.ViewUtils;

public final /* synthetic */ class ViewUtils$$ExternalSyntheticLambda0 implements ViewUtils.ViewVisitor {
    public final /* synthetic */ Class[] f$0;

    public /* synthetic */ ViewUtils$$ExternalSyntheticLambda0(Class[] clsArr) {
        this.f$0 = clsArr;
    }

    public final boolean run(View view) {
        return ViewUtils.lambda$hasChildViewOfType$1(this.f$0, view);
    }
}
