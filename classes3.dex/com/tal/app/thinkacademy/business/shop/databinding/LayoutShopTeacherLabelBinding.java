package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.shop.R;
import java.util.Objects;

public final class LayoutShopTeacherLabelBinding implements ViewBinding {
    private final RoundTextView rootView;
    public final RoundTextView textView;

    private LayoutShopTeacherLabelBinding(RoundTextView roundTextView, RoundTextView roundTextView2) {
        this.rootView = roundTextView;
        this.textView = roundTextView2;
    }

    public RoundTextView getRoot() {
        return this.rootView;
    }

    public static LayoutShopTeacherLabelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutShopTeacherLabelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_shop_teacher_label;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutShopTeacherLabelBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        RoundTextView roundTextView = (RoundTextView) view;
        return new LayoutShopTeacherLabelBinding(roundTextView, roundTextView);
    }
}
