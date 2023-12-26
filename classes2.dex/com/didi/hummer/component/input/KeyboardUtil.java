package com.didi.hummer.component.input;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyboardUtil {
    public static void showKeyboard(View view) {
        InputMethodManager inputMethodManager;
        if (view != null && (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) != null) {
            inputMethodManager.showSoftInput(view, 2);
        }
    }

    public static void hideKeyboard(View view) {
        InputMethodManager inputMethodManager;
        if (view != null && (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
