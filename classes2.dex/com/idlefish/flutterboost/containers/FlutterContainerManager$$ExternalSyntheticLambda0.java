package com.idlefish.flutterboost.containers;

import java.util.function.Consumer;

public final /* synthetic */ class FlutterContainerManager$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ StringBuilder f$0;

    public /* synthetic */ FlutterContainerManager$$ExternalSyntheticLambda0(StringBuilder sb) {
        this.f$0 = sb;
    }

    public final void accept(Object obj) {
        this.f$0.append(((FlutterViewContainer) obj).getUrl() + ',');
    }
}
