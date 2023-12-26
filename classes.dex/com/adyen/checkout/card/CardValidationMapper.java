package com.adyen.checkout.card;

import com.adyen.checkout.components.ui.FieldState;
import com.adyen.checkout.components.ui.Validation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/adyen/checkout/card/CardValidationMapper;", "", "()V", "mapCardNumberValidation", "Lcom/adyen/checkout/components/ui/FieldState;", "", "cardNumber", "validation", "Lcom/adyen/checkout/card/CardNumberValidation;", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardValidationMapper.kt */
public final class CardValidationMapper {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CardValidationMapper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardNumberValidation.values().length];
            iArr[CardNumberValidation.INVALID_ILLEGAL_CHARACTERS.ordinal()] = 1;
            iArr[CardNumberValidation.INVALID_TOO_SHORT.ordinal()] = 2;
            iArr[CardNumberValidation.INVALID_TOO_LONG.ordinal()] = 3;
            iArr[CardNumberValidation.INVALID_UNSUPPORTED_BRAND.ordinal()] = 4;
            iArr[CardNumberValidation.INVALID_LUHN_CHECK.ordinal()] = 5;
            iArr[CardNumberValidation.VALID.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final FieldState<String> mapCardNumberValidation(String str, CardNumberValidation cardNumberValidation) {
        Validation validation;
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(cardNumberValidation, "validation");
        switch (WhenMappings.$EnumSwitchMapping$0[cardNumberValidation.ordinal()]) {
            case 1:
                validation = new Validation.Invalid(R.string.checkout_card_number_not_valid);
                break;
            case 2:
                validation = new Validation.Invalid(R.string.checkout_card_number_not_valid);
                break;
            case 3:
                validation = new Validation.Invalid(R.string.checkout_card_number_not_valid);
                break;
            case 4:
                validation = new Validation.Invalid(R.string.checkout_card_brand_not_supported, true);
                break;
            case 5:
                validation = new Validation.Invalid(R.string.checkout_card_number_not_valid);
                break;
            case 6:
                validation = Validation.Valid.INSTANCE;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return new FieldState<>(str, validation);
    }
}
