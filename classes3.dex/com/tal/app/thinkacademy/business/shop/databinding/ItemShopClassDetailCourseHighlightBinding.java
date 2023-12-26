package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkcademy.lib.commui.widget.DrawableCenterTextView;

public final class ItemShopClassDetailCourseHighlightBinding implements ViewBinding {
    public final TextView courseHighLightsContent;
    public final TextView courseHighLightsTitle;
    private final ConstraintLayout rootView;
    public final DrawableCenterTextView suitInfo;
    public final DrawableCenterTextView teachingVideo;

    private ItemShopClassDetailCourseHighlightBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, DrawableCenterTextView drawableCenterTextView, DrawableCenterTextView drawableCenterTextView2) {
        this.rootView = constraintLayout;
        this.courseHighLightsContent = textView;
        this.courseHighLightsTitle = textView2;
        this.suitInfo = drawableCenterTextView;
        this.teachingVideo = drawableCenterTextView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemShopClassDetailCourseHighlightBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemShopClassDetailCourseHighlightBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_shop_class_detail_course_highlight;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemShopClassDetailCourseHighlightBinding bind(View view) {
        int i = R.id.course_high_lights_content;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.course_high_lights_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.suit_info;
                DrawableCenterTextView drawableCenterTextView = (DrawableCenterTextView) ViewBindings.findChildViewById(view, i);
                if (drawableCenterTextView != null) {
                    i = R.id.teaching_video;
                    DrawableCenterTextView drawableCenterTextView2 = (DrawableCenterTextView) ViewBindings.findChildViewById(view, i);
                    if (drawableCenterTextView2 != null) {
                        return new ItemShopClassDetailCourseHighlightBinding((ConstraintLayout) view, textView, textView2, drawableCenterTextView, drawableCenterTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
