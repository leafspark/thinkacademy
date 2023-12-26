package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.shop.R;

public final class BusShopTeacherDetailsItemAchievementsItemBinding implements ViewBinding {
    public final RoundLinearLayout ivPoint;
    private final ConstraintLayout rootView;
    public final TextView tvAchievementsItem;

    private BusShopTeacherDetailsItemAchievementsItemBinding(ConstraintLayout constraintLayout, RoundLinearLayout roundLinearLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.ivPoint = roundLinearLayout;
        this.tvAchievementsItem = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BusShopTeacherDetailsItemAchievementsItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusShopTeacherDetailsItemAchievementsItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.bus_shop_teacher_details_item_achievements_item;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BusShopTeacherDetailsItemAchievementsItemBinding bind(View view) {
        int i = R.id.ivPoint;
        RoundLinearLayout findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.tvAchievementsItem;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new BusShopTeacherDetailsItemAchievementsItemBinding((ConstraintLayout) view, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
