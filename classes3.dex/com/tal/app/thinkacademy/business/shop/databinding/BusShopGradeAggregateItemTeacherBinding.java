package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkcademy.lib.commui.widget.DrawableCenterTextView;

public final class BusShopGradeAggregateItemTeacherBinding implements ViewBinding {
    public final RoundLinearLayout rlBg;
    private final RoundLinearLayout rootView;
    public final TextView teacherDesc;
    public final ImageView teacherIcon;
    public final TextView teacherName;
    public final DrawableCenterTextView teacherNext;

    private BusShopGradeAggregateItemTeacherBinding(RoundLinearLayout roundLinearLayout, RoundLinearLayout roundLinearLayout2, TextView textView, ImageView imageView, TextView textView2, DrawableCenterTextView drawableCenterTextView) {
        this.rootView = roundLinearLayout;
        this.rlBg = roundLinearLayout2;
        this.teacherDesc = textView;
        this.teacherIcon = imageView;
        this.teacherName = textView2;
        this.teacherNext = drawableCenterTextView;
    }

    public RoundLinearLayout getRoot() {
        return this.rootView;
    }

    public static BusShopGradeAggregateItemTeacherBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusShopGradeAggregateItemTeacherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.bus_shop_grade_aggregate_item_teacher;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BusShopGradeAggregateItemTeacherBinding bind(View view) {
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) view;
        int i = R.id.teacher_desc;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.teacher_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.teacher_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.teacher_next;
                    DrawableCenterTextView drawableCenterTextView = (DrawableCenterTextView) ViewBindings.findChildViewById(view, i);
                    if (drawableCenterTextView != null) {
                        return new BusShopGradeAggregateItemTeacherBinding(roundLinearLayout, roundLinearLayout, textView, imageView, textView2, drawableCenterTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
