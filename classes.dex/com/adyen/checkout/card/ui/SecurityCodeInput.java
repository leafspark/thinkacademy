package com.adyen.checkout.card.ui;

import android.content.Context;
import android.util.AttributeSet;

public class SecurityCodeInput extends CardNumberInput {
    private static final int MAX_LENGTH = 4;

    public SecurityCodeInput(Context context) {
        this(context, (AttributeSet) null);
    }

    public SecurityCodeInput(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SecurityCodeInput(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        enforceMaxInputLength(4);
    }
}
