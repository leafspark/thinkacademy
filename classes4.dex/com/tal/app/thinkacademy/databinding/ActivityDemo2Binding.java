package com.tal.app.thinkacademy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import java.util.Objects;

public final class ActivityDemo2Binding implements ViewBinding {
    private final LinearLayout rootView;

    private ActivityDemo2Binding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDemo2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityDemo2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(2131492919, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, 2131492919, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityDemo2Binding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ActivityDemo2Binding((LinearLayout) view);
    }
}
