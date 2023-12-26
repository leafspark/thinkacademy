package com.tal.app.thinkacademy.live.core.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/utils/WebDomain;", "Lcom/tal/app/thinkacademy/live/core/utils/Domain;", "code", "", "msg", "", "(ILjava/lang/String;)V", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveTrack.kt */
public final class WebDomain extends Domain {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebDomain(int i, String str) {
        super(DomainType.WebView, i, str, (String) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "msg");
    }
}
