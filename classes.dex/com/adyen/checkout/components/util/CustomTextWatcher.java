package com.adyen.checkout.components.util;

import android.text.Editable;

public abstract class CustomTextWatcher extends SimpleTextWatcher {
    private boolean mChangedByUser;

    public abstract void afterTextChangedByUser(Editable editable);

    private boolean isChangedByUser() {
        return this.mChangedByUser;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z = true;
        if (Math.abs(i3 - i2) != 1) {
            z = false;
        }
        this.mChangedByUser = z;
    }

    public void afterTextChanged(Editable editable) {
        if (isChangedByUser()) {
            afterTextChangedByUser(editable);
        }
    }
}
