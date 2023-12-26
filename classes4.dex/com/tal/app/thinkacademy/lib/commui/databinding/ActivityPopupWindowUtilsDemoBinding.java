package com.tal.app.thinkacademy.lib.commui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.R;

public final class ActivityPopupWindowUtilsDemoBinding implements ViewBinding {
    public final Button button;
    public final ConstraintLayout rootView;
    private final ConstraintLayout rootView_;

    private ActivityPopupWindowUtilsDemoBinding(ConstraintLayout constraintLayout, Button button2, ConstraintLayout constraintLayout2) {
        this.rootView_ = constraintLayout;
        this.button = button2;
        this.rootView = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView_;
    }

    public static ActivityPopupWindowUtilsDemoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPopupWindowUtilsDemoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_popup_window_utils_demo;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityPopupWindowUtilsDemoBinding bind(View view) {
        int i = R.id.button;
        Button button2 = (Button) ViewBindings.findChildViewById(view, i);
        if (button2 != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new ActivityPopupWindowUtilsDemoBinding(constraintLayout, button2, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
