package com.adyen.checkout.card.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import com.adyen.checkout.components.ui.view.AdyenTextInputEditText;
import java.util.Arrays;

public class CardNumberInput extends AdyenTextInputEditText {
    private static final int[] AMEX_CARD_NUMBER_MASK = {4, 6, 5, 4};
    private static final int[] DEFAULT_CARD_NUMBER_MASK = {4, 4, 4, 4, 3};
    private static final char DIGIT_SEPARATOR = ' ';
    private static final int MAX_DIGIT_SEPARATOR_COUNT = 4;
    private static final int START_OF_STRING = 0;
    private static final String SUPPORTED_DIGITS = "0123456789";
    private boolean mIsAmexCard;

    public CardNumberInput(Context context) {
        this(context, (AttributeSet) null);
    }

    public CardNumberInput(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CardNumberInput(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        enforceMaxInputLength(23);
        setInputType(2);
        setKeyListener(DigitsKeyListener.getInstance("0123456789 "));
    }

    public String getRawValue() {
        return getText().toString().replace(String.valueOf(DIGIT_SEPARATOR), "");
    }

    public void setAmexCardFormat(boolean z) {
        if (this.mIsAmexCard || !z) {
            this.mIsAmexCard = z;
            return;
        }
        this.mIsAmexCard = true;
        afterTextChanged(getEditableText());
    }

    /* access modifiers changed from: protected */
    public void afterTextChanged(Editable editable) {
        String obj = editable.toString();
        String formatProcessedString = formatProcessedString(obj.trim().replaceAll(String.valueOf(DIGIT_SEPARATOR), ""));
        if (!obj.equals(formatProcessedString)) {
            editable.replace(0, obj.length(), formatProcessedString);
        }
        super.afterTextChanged(editable);
    }

    private String formatProcessedString(String str) {
        return TextUtils.join(" ", splitStringWithMask(str, this.mIsAmexCard ? AMEX_CARD_NUMBER_MASK : DEFAULT_CARD_NUMBER_MASK)).trim();
    }

    private String[] splitStringWithMask(String str, int... iArr) {
        String[] strArr = new String[iArr.length];
        Arrays.fill(strArr, "");
        int i = 0;
        while (true) {
            if (i < iArr.length) {
                if (str.length() < iArr[i]) {
                    strArr[i] = str;
                    break;
                }
                strArr[i] = str.substring(0, iArr[i]);
                str = str.substring(iArr[i]);
                i++;
            } else {
                break;
            }
        }
        return strArr;
    }
}
