package com.adyen.checkout.card;

import com.adyen.checkout.core.log.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"TAG", "", "card_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardComponentProvider.kt */
public final class CardComponentProviderKt {
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String tag = LogUtil.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "getTag()");
        TAG = tag;
    }
}
