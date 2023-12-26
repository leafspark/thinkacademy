package com.adyen.checkout.components.util;

import com.adyen.checkout.components.model.payments.Amount;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.exception.NoConstructorException;
import com.adyen.checkout.core.log.LogUtil;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public final class CurrencyUtils {
    public static final String TAG = LogUtil.getTag();

    public static String formatAmount(Amount amount, Locale locale) {
        String currency = amount.getCurrency();
        CheckoutCurrency find = CheckoutCurrency.find(currency);
        Currency instance = Currency.getInstance(currency);
        NumberFormat currencyInstance = DecimalFormat.getCurrencyInstance(locale);
        currencyInstance.setCurrency(instance);
        currencyInstance.setMinimumFractionDigits(find.getFractionDigits());
        currencyInstance.setMaximumFractionDigits(find.getFractionDigits());
        return currencyInstance.format(BigDecimal.valueOf((long) amount.getValue(), find.getFractionDigits()));
    }

    static void assertCurrency(String str) {
        if (!CheckoutCurrency.isSupported(str)) {
            throw new CheckoutException("Currency " + str + " not supported");
        }
    }

    private CurrencyUtils() {
        throw new NoConstructorException();
    }
}
