package com.idlefish.flutterboost;

import java.util.LinkedList;

public final /* synthetic */ class FlutterBoostPlugin$$ExternalSyntheticLambda0 implements ListenerRemover {
    public final /* synthetic */ LinkedList f$0;
    public final /* synthetic */ EventListener f$1;

    public /* synthetic */ FlutterBoostPlugin$$ExternalSyntheticLambda0(LinkedList linkedList, EventListener eventListener) {
        this.f$0 = linkedList;
        this.f$1 = eventListener;
    }

    public final void remove() {
        this.f$0.remove(this.f$1);
    }
}
