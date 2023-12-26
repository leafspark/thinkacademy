package com.adyen.checkout.card;

import com.adyen.checkout.components.ui.FieldState;
import com.adyen.checkout.components.ui.Validation;
import com.adyen.checkout.components.util.DateUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/adyen/checkout/card/KcpValidationUtils;", "", "()V", "KCP_BIRTH_DATE_FORMAT", "", "KCP_BIRTH_DATE_LENGTH", "", "KCP_CARD_PASSWORD_REQUIRED_LENGTH", "KCP_TAX_NUMBER_LENGTH", "validateKcpBirthDateOrTaxNumber", "Lcom/adyen/checkout/components/ui/FieldState;", "birthDateOrTaxNumber", "validateKcpCardPassword", "cardPassword", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: KcpValidationUtils.kt */
public final class KcpValidationUtils {
    public static final KcpValidationUtils INSTANCE = new KcpValidationUtils();
    private static final String KCP_BIRTH_DATE_FORMAT = "yyMMdd";
    public static final int KCP_BIRTH_DATE_LENGTH = 6;
    private static final int KCP_CARD_PASSWORD_REQUIRED_LENGTH = 2;
    private static final int KCP_TAX_NUMBER_LENGTH = 10;

    private KcpValidationUtils() {
    }

    public final FieldState<String> validateKcpBirthDateOrTaxNumber(String str) {
        Validation validation;
        Intrinsics.checkNotNullParameter(str, "birthDateOrTaxNumber");
        int length = str.length();
        if (length == 6 && DateUtils.INSTANCE.matchesFormat(str, KCP_BIRTH_DATE_FORMAT)) {
            validation = Validation.Valid.INSTANCE;
        } else if (length == 10) {
            validation = Validation.Valid.INSTANCE;
        } else {
            validation = new Validation.Invalid(R.string.checkout_kcp_birth_date_or_tax_number_invalid);
        }
        return new FieldState<>(str, validation);
    }

    public final FieldState<String> validateKcpCardPassword(String str) {
        Validation validation;
        Intrinsics.checkNotNullParameter(str, "cardPassword");
        if (str.length() == 2) {
            validation = Validation.Valid.INSTANCE;
        } else {
            validation = new Validation.Invalid(R.string.checkout_kcp_password_invalid);
        }
        return new FieldState<>(str, validation);
    }
}
