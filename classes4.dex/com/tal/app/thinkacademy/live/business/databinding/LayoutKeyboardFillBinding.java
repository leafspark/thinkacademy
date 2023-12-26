package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView;
import com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.NumAndMarkKeyboard;

public final class LayoutKeyboardFillBinding implements ViewBinding {
    public final NumAndMarkKeyboard keyboard;
    private final ConstraintLayout rootView;
    public final SubmitResultView submitResultView;

    private LayoutKeyboardFillBinding(ConstraintLayout constraintLayout, NumAndMarkKeyboard numAndMarkKeyboard, SubmitResultView submitResultView2) {
        this.rootView = constraintLayout;
        this.keyboard = numAndMarkKeyboard;
        this.submitResultView = submitResultView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutKeyboardFillBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutKeyboardFillBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_keyboard_fill;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutKeyboardFillBinding bind(View view) {
        int i = R.id.keyboard;
        NumAndMarkKeyboard numAndMarkKeyboard = (NumAndMarkKeyboard) ViewBindings.findChildViewById(view, i);
        if (numAndMarkKeyboard != null) {
            i = R.id.submit_result_view;
            SubmitResultView submitResultView2 = (SubmitResultView) ViewBindings.findChildViewById(view, i);
            if (submitResultView2 != null) {
                return new LayoutKeyboardFillBinding((ConstraintLayout) view, numAndMarkKeyboard, submitResultView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
