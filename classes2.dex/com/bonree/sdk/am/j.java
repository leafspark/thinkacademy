package com.bonree.sdk.am;

import android.database.ContentObserver;
import android.os.Handler;

final class j extends ContentObserver {
    private /* synthetic */ i a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    j(i iVar, Handler handler) {
        super((Handler) null);
        this.a = iVar;
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        i iVar = this.a;
        iVar.f = iVar.w.isProviderEnabled("gps");
    }
}
