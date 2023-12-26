package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class ItemPlanListDateBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RoundTextView tvSpeakerDate;

    private ItemPlanListDateBinding(LinearLayout linearLayout, RoundTextView roundTextView) {
        this.rootView = linearLayout;
        this.tvSpeakerDate = roundTextView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemPlanListDateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemPlanListDateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_plan_list_date;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemPlanListDateBinding bind(View view) {
        int i = R.id.tvSpeakerDate;
        RoundTextView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new ItemPlanListDateBinding((LinearLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
