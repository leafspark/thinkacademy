package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.tal.app.thinkacademy.business.shop.R;

public final class BusShopTeacherDetailsItemVideoBinding implements ViewBinding {
    public final ImageView ivVideoBg;
    public final ImageView ivVideoPlay;
    private final RoundRelativeLayout rootView;

    private BusShopTeacherDetailsItemVideoBinding(RoundRelativeLayout roundRelativeLayout, ImageView imageView, ImageView imageView2) {
        this.rootView = roundRelativeLayout;
        this.ivVideoBg = imageView;
        this.ivVideoPlay = imageView2;
    }

    public RoundRelativeLayout getRoot() {
        return this.rootView;
    }

    public static BusShopTeacherDetailsItemVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusShopTeacherDetailsItemVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.bus_shop_teacher_details_item_video;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BusShopTeacherDetailsItemVideoBinding bind(View view) {
        int i = R.id.ivVideoBg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.ivVideoPlay;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                return new BusShopTeacherDetailsItemVideoBinding((RoundRelativeLayout) view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
