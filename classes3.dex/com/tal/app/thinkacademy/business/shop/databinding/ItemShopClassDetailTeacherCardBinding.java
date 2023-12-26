package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkcademy.lib.commui.widget.DrawableCenterTextView;

public final class ItemShopClassDetailTeacherCardBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView teacherDesc;
    public final ImageView teacherIcon;
    public final TextView teacherName;
    public final DrawableCenterTextView teacherNext;
    public final ConstraintLayout teacherRootLayout;

    private ItemShopClassDetailTeacherCardBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, DrawableCenterTextView drawableCenterTextView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.teacherDesc = textView;
        this.teacherIcon = imageView;
        this.teacherName = textView2;
        this.teacherNext = drawableCenterTextView;
        this.teacherRootLayout = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemShopClassDetailTeacherCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemShopClassDetailTeacherCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_shop_class_detail_teacher_card;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemShopClassDetailTeacherCardBinding bind(View view) {
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
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        return new ItemShopClassDetailTeacherCardBinding(constraintLayout, textView, imageView, textView2, drawableCenterTextView, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
