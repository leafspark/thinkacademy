package com.adyen.checkout.card;

import com.adyen.checkout.card.api.model.Brand;
import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.card.data.DetectedCardType;
import com.adyen.checkout.card.data.ExpiryDate;
import com.adyen.checkout.components.ui.FieldState;
import com.adyen.checkout.components.ui.Validation;
import com.adyen.checkout.core.util.StringUtil;
import java.util.Calendar;
import java.util.GregorianCalendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eJ\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u001e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u001e2\u0006\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010$R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/adyen/checkout/card/CardValidationUtils;", "", "()V", "AMEX_SECURITY_CODE_SIZE", "", "FIVE_DIGIT", "GENERAL_CARD_SECURITY_CODE_SIZE", "MAXIMUM_CARD_NUMBER_LENGTH", "MAXIMUM_EXPIRED_MONTHS", "MAXIMUM_YEARS_IN_FUTURE", "MINIMUM_CARD_NUMBER_LENGTH", "MONTHS_IN_YEAR", "RADIX", "dateExists", "", "expiryDate", "Lcom/adyen/checkout/card/data/ExpiryDate;", "getExpiryCalendar", "Ljava/util/Calendar;", "isLuhnChecksumValid", "normalizedNumber", "", "isValidMonth", "month", "validateCardNumber", "Lcom/adyen/checkout/card/CardNumberValidation;", "number", "enableLuhnCheck", "isBrandSupported", "validateExpiryDate", "Lcom/adyen/checkout/components/ui/FieldState;", "fieldPolicy", "Lcom/adyen/checkout/card/api/model/Brand$FieldPolicy;", "validateSecurityCode", "securityCode", "cardType", "Lcom/adyen/checkout/card/data/DetectedCardType;", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardValidationUtils.kt */
public final class CardValidationUtils {
    private static final int AMEX_SECURITY_CODE_SIZE = 4;
    private static final int FIVE_DIGIT = 5;
    private static final int GENERAL_CARD_SECURITY_CODE_SIZE = 3;
    public static final CardValidationUtils INSTANCE = new CardValidationUtils();
    public static final int MAXIMUM_CARD_NUMBER_LENGTH = 19;
    private static final int MAXIMUM_EXPIRED_MONTHS = 3;
    private static final int MAXIMUM_YEARS_IN_FUTURE = 30;
    private static final int MINIMUM_CARD_NUMBER_LENGTH = 8;
    private static final int MONTHS_IN_YEAR = 12;
    private static final int RADIX = 10;

    private final boolean isValidMonth(int i) {
        return 1 <= i && i <= 12;
    }

    private CardValidationUtils() {
    }

    public final CardNumberValidation validateCardNumber(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "number");
        String normalize = StringUtil.normalize(str, new char[0]);
        Intrinsics.checkNotNullExpressionValue(normalize, "normalize(number)");
        int length = normalize.length();
        if (!StringUtil.isDigitsAndSeparatorsOnly(normalize, new char[0])) {
            return CardNumberValidation.INVALID_ILLEGAL_CHARACTERS;
        }
        if (length > 19) {
            return CardNumberValidation.INVALID_TOO_LONG;
        }
        if (length < 8) {
            return CardNumberValidation.INVALID_TOO_SHORT;
        }
        if (!z2) {
            return CardNumberValidation.INVALID_UNSUPPORTED_BRAND;
        }
        if (!z || isLuhnChecksumValid(normalize)) {
            return CardNumberValidation.VALID;
        }
        return CardNumberValidation.INVALID_LUHN_CHECK;
    }

    private final boolean isLuhnChecksumValid(String str) {
        int i;
        int i2;
        String stringBuffer = new StringBuffer(str).reverse().toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer, "StringBuffer(normalizedNumber).reverse().toString()");
        int length = stringBuffer.length() - 1;
        if (length >= 0) {
            int i3 = 0;
            i2 = 0;
            i = 0;
            while (true) {
                int i4 = i3 + 1;
                int digit = Character.digit(stringBuffer.charAt(i3), 10);
                if (i3 % 2 == 0) {
                    i += digit;
                } else {
                    i2 += digit * 2;
                    if (digit >= 5) {
                        i2 -= 9;
                    }
                }
                if (i4 > length) {
                    break;
                }
                i3 = i4;
            }
        } else {
            i2 = 0;
            i = 0;
        }
        if ((i + i2) % 10 == 0) {
            return true;
        }
        return false;
    }

    public final FieldState<ExpiryDate> validateExpiryDate(ExpiryDate expiryDate, Brand.FieldPolicy fieldPolicy) {
        Intrinsics.checkNotNullParameter(expiryDate, "expiryDate");
        FieldState<ExpiryDate> fieldState = new FieldState<>(expiryDate, new Validation.Invalid(R.string.checkout_expiry_date_not_valid));
        if (!dateExists(expiryDate)) {
            return (fieldPolicy != Brand.FieldPolicy.OPTIONAL || Intrinsics.areEqual(expiryDate, ExpiryDate.INVALID_DATE)) ? fieldState : new FieldState<>(expiryDate, Validation.Valid.INSTANCE);
        }
        Calendar expiryCalendar = getExpiryCalendar(expiryDate);
        Calendar instance = GregorianCalendar.getInstance();
        instance.add(1, 30);
        Calendar instance2 = GregorianCalendar.getInstance();
        instance2.add(2, -3);
        if (expiryCalendar.compareTo(instance2) < 0 || expiryCalendar.compareTo(instance) > 0) {
            return fieldState;
        }
        return new FieldState<>(expiryDate, Validation.Valid.INSTANCE);
    }

    public final FieldState<String> validateSecurityCode(String str, DetectedCardType detectedCardType) {
        Validation validation;
        Brand.FieldPolicy fieldPolicy;
        CardType cardType;
        Intrinsics.checkNotNullParameter(str, "securityCode");
        String normalize = StringUtil.normalize(str, new char[0]);
        Intrinsics.checkNotNullExpressionValue(normalize, "normalize(securityCode)");
        int length = normalize.length();
        Validation.Invalid invalid = new Validation.Invalid(R.string.checkout_security_code_not_valid);
        if (!StringUtil.isDigitsAndSeparatorsOnly(normalize, new char[0])) {
            validation = invalid;
        } else {
            CardType cardType2 = null;
            if (detectedCardType == null) {
                fieldPolicy = null;
            } else {
                fieldPolicy = detectedCardType.getCvcPolicy();
            }
            if (fieldPolicy == Brand.FieldPolicy.OPTIONAL && length == 0) {
                validation = Validation.Valid.INSTANCE;
            } else {
                if (detectedCardType == null) {
                    cardType = null;
                } else {
                    cardType = detectedCardType.getCardType();
                }
                if (cardType == CardType.AMERICAN_EXPRESS && length == 4) {
                    validation = Validation.Valid.INSTANCE;
                } else {
                    if (detectedCardType != null) {
                        cardType2 = detectedCardType.getCardType();
                    }
                    if (cardType2 == CardType.AMERICAN_EXPRESS || length != 3) {
                        validation = invalid;
                    } else {
                        validation = Validation.Valid.INSTANCE;
                    }
                }
            }
        }
        return new FieldState<>(normalize, validation);
    }

    private final boolean dateExists(ExpiryDate expiryDate) {
        return (expiryDate == ExpiryDate.EMPTY_DATE || expiryDate.getExpiryMonth() == 0 || expiryDate.getExpiryYear() == 0 || !isValidMonth(expiryDate.getExpiryMonth()) || expiryDate.getExpiryYear() <= 0) ? false : true;
    }

    private final Calendar getExpiryCalendar(ExpiryDate expiryDate) {
        Calendar instance = GregorianCalendar.getInstance();
        instance.clear();
        instance.set(expiryDate.getExpiryYear(), expiryDate.getExpiryMonth() - 1, 1);
        instance.add(2, 1);
        instance.add(5, -1);
        Intrinsics.checkNotNullExpressionValue(instance, "expiryCalendar");
        return instance;
    }
}
