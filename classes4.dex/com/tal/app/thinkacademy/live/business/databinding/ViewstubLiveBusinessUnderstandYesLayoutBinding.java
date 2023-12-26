package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import java.util.Objects;

public final class ViewstubLiveBusinessUnderstandYesLayoutBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private ViewstubLiveBusinessUnderstandYesLayoutBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewstubLiveBusinessUnderstandYesLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewstubLiveBusinessUnderstandYesLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.viewstub_live_business_understand_yes_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewstubLiveBusinessUnderstandYesLayoutBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ViewstubLiveBusinessUnderstandYesLayoutBinding((ConstraintLayout) view);
    }
}
