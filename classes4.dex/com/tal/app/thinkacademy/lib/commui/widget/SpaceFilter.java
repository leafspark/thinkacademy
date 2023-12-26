package com.tal.app.thinkacademy.lib.commui.widget;

import android.text.InputFilter;
import android.text.Spanned;

public class SpaceFilter implements InputFilter {
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (" ".equals(charSequence)) {
            return "";
        }
        return null;
    }
}
