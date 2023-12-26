package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.live.business.R;
import java.util.Objects;

public final class LayoutTeacherMuteBinding implements ViewBinding {
    private final RoundLinearLayout rootView;

    private LayoutTeacherMuteBinding(RoundLinearLayout roundLinearLayout) {
        this.rootView = roundLinearLayout;
    }

    public RoundLinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutTeacherMuteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutTeacherMuteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_teacher_mute;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutTeacherMuteBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new LayoutTeacherMuteBinding((RoundLinearLayout) view);
    }
}
