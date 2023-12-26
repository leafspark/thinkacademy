package com.tal.app.thinkacademy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;

public final class ActivityServerBinding implements ViewBinding {
    public final Button btnStartServer;
    public final Button btnStopServer;
    private final LinearLayout rootView;
    public final TextView tvMsg;

    private ActivityServerBinding(LinearLayout linearLayout, Button button, Button button2, TextView textView) {
        this.rootView = linearLayout;
        this.btnStartServer = button;
        this.btnStopServer = button2;
        this.tvMsg = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityServerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityServerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(2131492952, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, 2131492952, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityServerBinding bind(View view) {
        int i = 2131296471;
        Button button = (Button) ViewBindings.findChildViewById(view, 2131296471);
        if (button != null) {
            i = 2131296472;
            Button button2 = (Button) ViewBindings.findChildViewById(view, 2131296472);
            if (button2 != null) {
                i = 2131298751;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, 2131298751);
                if (textView != null) {
                    return new ActivityServerBinding((LinearLayout) view, button, button2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
