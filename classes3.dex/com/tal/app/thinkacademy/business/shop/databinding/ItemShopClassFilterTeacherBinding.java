package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.widget.view.StateTextView;

public final class ItemShopClassFilterTeacherBinding implements ViewBinding {
    public final StateTextView bgTeacherItem;
    public final ImageView ivTeacherAvatar;
    private final ConstraintLayout rootView;
    public final StateTextView tvTeacherName;
    public final StateTextView tvTeacherSchool;

    private ItemShopClassFilterTeacherBinding(ConstraintLayout constraintLayout, StateTextView stateTextView, ImageView imageView, StateTextView stateTextView2, StateTextView stateTextView3) {
        this.rootView = constraintLayout;
        this.bgTeacherItem = stateTextView;
        this.ivTeacherAvatar = imageView;
        this.tvTeacherName = stateTextView2;
        this.tvTeacherSchool = stateTextView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemShopClassFilterTeacherBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemShopClassFilterTeacherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_shop_class_filter_teacher;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemShopClassFilterTeacherBinding bind(View view) {
        int i = R.id.bg_teacher_item;
        StateTextView stateTextView = (StateTextView) ViewBindings.findChildViewById(view, i);
        if (stateTextView != null) {
            i = R.id.iv_teacher_avatar;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.tv_teacher_name;
                StateTextView stateTextView2 = (StateTextView) ViewBindings.findChildViewById(view, i);
                if (stateTextView2 != null) {
                    i = R.id.tv_teacher_school;
                    StateTextView stateTextView3 = (StateTextView) ViewBindings.findChildViewById(view, i);
                    if (stateTextView3 != null) {
                        return new ItemShopClassFilterTeacherBinding((ConstraintLayout) view, stateTextView, imageView, stateTextView2, stateTextView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
