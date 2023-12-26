package com.tal.app.thinkacademy.lib.network;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\u0007¢\u0006\u0002\u0010\u0007J)\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/Api;", "", "()V", "create", "T", "service", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "baseUrl", "", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Api.kt */
public final class Api {
    public static final Api INSTANCE = new Api();

    private Api() {
    }

    @JvmStatic
    public static final <T> T create(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "service");
        return NetworkManager.INSTANCE.create(cls);
    }

    @JvmStatic
    public static final <T> T create(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(cls, "service");
        return NetworkManager.INSTANCE.create(str, cls);
    }
}
