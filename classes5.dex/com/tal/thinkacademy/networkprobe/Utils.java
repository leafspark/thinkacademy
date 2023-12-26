package com.tal.thinkacademy.networkprobe;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/tal/thinkacademy/networkprobe/Utils;", "", "()V", "platform", "Lcom/tal/thinkacademy/networkprobe/Platform;", "getPlatform", "()Lcom/tal/thinkacademy/networkprobe/Platform;", "getUuid", "", "log", "", "tag", "msg", "networkprobe_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Utils.kt */
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    private final Platform getPlatform() {
        return new Platform();
    }

    public final void log(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        getPlatform().log(str, str2);
    }

    public final String getUuid() {
        return getPlatform().getUuid();
    }
}
