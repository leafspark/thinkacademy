package com.adyen.checkout.card;

import com.adyen.checkout.core.log.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"BIN_VALUE_LENGTH", "", "LAST_FOUR_LENGTH", "SINGLE_CARD_LIST_SIZE", "TAG", "", "card_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardComponent.kt */
public final class CardComponentKt {
    private static final int BIN_VALUE_LENGTH = 6;
    private static final int LAST_FOUR_LENGTH = 4;
    private static final int SINGLE_CARD_LIST_SIZE = 1;
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String tag = LogUtil.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "getTag()");
        TAG = tag;
    }
}
