package com.tal.app.thinkacademy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import java.util.Objects;

public final class ViewAppTitlebarBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private ViewAppTitlebarBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewAppTitlebarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewAppTitlebarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(2131493568, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, 2131493568, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewAppTitlebarBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ViewAppTitlebarBinding((ConstraintLayout) view);
    }
}
