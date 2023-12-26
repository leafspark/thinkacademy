package com.didi.hummer.component.input;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

public class FocusUtil {
    public static void requestFocus(View view) {
        if (view != null) {
            view.post(new FocusUtil$$ExternalSyntheticLambda1(view));
        }
    }

    static /* synthetic */ void lambda$requestFocus$0(View view) {
        view.requestFocus();
        KeyboardUtil.showKeyboard(view);
    }

    public static void clearFocus(View view) {
        if (view != null) {
            view.post(new FocusUtil$$ExternalSyntheticLambda0(view));
        }
    }

    static /* synthetic */ void lambda$clearFocus$1(View view) {
        focusParent(view);
        view.clearFocus();
        KeyboardUtil.hideKeyboard(view);
    }

    public static void clearFocus(Context context) {
        InputMethodManager inputMethodManager;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null && inputMethodManager.isActive()) {
                clearFocus(activity.getCurrentFocus());
            }
        }
    }

    private static void focusParent(View view) {
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (Build.VERSION.SDK_INT >= 26) {
                viewGroup.setDefaultFocusHighlightEnabled(false);
            }
            viewGroup.setFocusable(true);
            viewGroup.setFocusableInTouchMode(true);
            viewGroup.requestFocus();
        }
    }
}
