package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.lib.commui.widget.TagTextView;

public final class ItemShopClassDetailCourseTitleBinding implements ViewBinding {
    public final TagTextView courseTitle;
    private final ConstraintLayout rootView;

    private ItemShopClassDetailCourseTitleBinding(ConstraintLayout constraintLayout, TagTextView tagTextView) {
        this.rootView = constraintLayout;
        this.courseTitle = tagTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemShopClassDetailCourseTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemShopClassDetailCourseTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_shop_class_detail_course_title;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemShopClassDetailCourseTitleBinding bind(View view) {
        int i = R.id.course_title;
        TagTextView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new ItemShopClassDetailCourseTitleBinding((ConstraintLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
