package com.bonree.sdk.am;

import android.database.ContentObserver;
import android.os.Handler;

final class c extends ContentObserver {
    private /* synthetic */ b a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    c(b bVar, Handler handler) {
        super((Handler) null);
        this.a = bVar;
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        b bVar = this.a;
        bVar.f = bVar.o.isProviderEnabled("gps");
    }
}
