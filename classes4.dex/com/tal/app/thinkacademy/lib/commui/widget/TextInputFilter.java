package com.tal.app.thinkacademy.lib.commui.widget;

import android.text.InputFilter;
import android.text.Spanned;
import com.tal.app.thinkacademy.lib.util.RegexUtils;

public class TextInputFilter implements InputFilter {
    private static final String regEx = "[0-9a-zA-Z\\u4E00-\\u9FA5 ]+";

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (!RegexUtils.isMatch(regEx, charSequence)) {
            return "";
        }
        return null;
    }
}
