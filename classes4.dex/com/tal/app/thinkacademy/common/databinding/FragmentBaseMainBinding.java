package com.tal.app.thinkacademy.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.common.R;

public final class FragmentBaseMainBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final FrameLayout screenMain;
    public final FrameLayout screenSecond;

    private FragmentBaseMainBinding(LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = linearLayout;
        this.screenMain = frameLayout;
        this.screenSecond = frameLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBaseMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentBaseMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.fragment_base_main;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentBaseMainBinding bind(View view) {
        int i = R.id.screen_main;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.screen_second;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout2 != null) {
                return new FragmentBaseMainBinding((LinearLayout) view, frameLayout, frameLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
