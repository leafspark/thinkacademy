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

public final class LayoutBaseDialogBinding implements ViewBinding {
    public final Button btnBottom;
    public final Button btnCenter;
    public final Button btnLeft;
    public final Button btnRight;
    public final Button btnTop;
    private final ConstraintLayout rootView;

    private LayoutBaseDialogBinding(ConstraintLayout constraintLayout, Button button, Button button2, Button button3, Button button4, Button button5) {
        this.rootView = constraintLayout;
        this.btnBottom = button;
        this.btnCenter = button2;
        this.btnLeft = button3;
        this.btnRight = button4;
        this.btnTop = button5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutBaseDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutBaseDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_base_dialog;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutBaseDialogBinding bind(View view) {
        int i = R.id.btn_bottom;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_center;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.btn_left;
                Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                if (button3 != null) {
                    i = R.id.btn_right;
                    Button button4 = (Button) ViewBindings.findChildViewById(view, i);
                    if (button4 != null) {
                        i = R.id.btn_top;
                        Button button5 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button5 != null) {
                            return new LayoutBaseDialogBinding((ConstraintLayout) view, button, button2, button3, button4, button5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
