package com.adyen.checkout.card;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/adyen/checkout/card/CardNumberValidation;", "", "(Ljava/lang/String;I)V", "VALID", "INVALID_ILLEGAL_CHARACTERS", "INVALID_LUHN_CHECK", "INVALID_TOO_SHORT", "INVALID_TOO_LONG", "INVALID_UNSUPPORTED_BRAND", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardValidationUtils.kt */
public enum CardNumberValidation {
    VALID,
    INVALID_ILLEGAL_CHARACTERS,
    INVALID_LUHN_CHECK,
    INVALID_TOO_SHORT,
    INVALID_TOO_LONG,
    INVALID_UNSUPPORTED_BRAND
}
