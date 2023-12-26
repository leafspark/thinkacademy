package com.adyen.checkout.core.util;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adyen/checkout/core/util/BuildUtils;", "", "()V", "isDebugBuild", "", "context", "Landroid/content/Context;", "checkout-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BuildUtils.kt */
public final class BuildUtils {
    public static final BuildUtils INSTANCE = new BuildUtils();

    private BuildUtils() {
    }

    public final boolean isDebugBuild(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (context.getApplicationInfo().flags & 2) != 0;
    }
}
