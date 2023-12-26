package com.bonree.sdk.j;

import android.view.Choreographer;

final class f implements Choreographer.FrameCallback {
    private /* synthetic */ b a;

    f(b bVar) {
        this.a = bVar;
    }

    public final void doFrame(long j) {
        b.a(this.a, j, 0);
    }
}
