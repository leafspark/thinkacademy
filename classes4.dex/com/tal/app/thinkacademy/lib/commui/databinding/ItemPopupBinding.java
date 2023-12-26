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

public final class ItemPopupBinding implements ViewBinding {
    public final Button btnHaha;
    public final Button btnXixi;
    private final ConstraintLayout rootView;

    private ItemPopupBinding(ConstraintLayout constraintLayout, Button button, Button button2) {
        this.rootView = constraintLayout;
        this.btnHaha = button;
        this.btnXixi = button2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_popup;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemPopupBinding bind(View view) {
        int i = R.id.btn_haha;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_xixi;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                return new ItemPopupBinding((ConstraintLayout) view, button, button2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
