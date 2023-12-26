package com.adyen.checkout.components.api;

import com.adyen.checkout.core.log.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"ENDPOINT", "", "PUBLIC_KEY_JSON_KEY", "TAG", "components-core_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: PublicKeyConnection.kt */
public final class PublicKeyConnectionKt {
    private static final String ENDPOINT = "v1/clientKeys/";
    private static final String PUBLIC_KEY_JSON_KEY = "publicKey";
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String tag = LogUtil.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "getTag()");
        TAG = tag;
    }
}
