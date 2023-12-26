package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class ItemMaterialListBinding implements ViewBinding {
    public final ImageView ivMaterialsJump;
    public final ImageView ivMaterialsType;
    public final RoundLinearLayout llMaterialItem;
    private final RoundLinearLayout rootView;
    public final TextView tvMaterialsSize;
    public final TextView tvMaterialsTime;
    public final TextView tvMaterialsTitle;

    private ItemMaterialListBinding(RoundLinearLayout roundLinearLayout, ImageView imageView, ImageView imageView2, RoundLinearLayout roundLinearLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = roundLinearLayout;
        this.ivMaterialsJump = imageView;
        this.ivMaterialsType = imageView2;
        this.llMaterialItem = roundLinearLayout2;
        this.tvMaterialsSize = textView;
        this.tvMaterialsTime = textView2;
        this.tvMaterialsTitle = textView3;
    }

    public RoundLinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemMaterialListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemMaterialListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_material_list;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemMaterialListBinding bind(View view) {
        int i = R.id.ivMaterialsJump;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.ivMaterialsType;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                RoundLinearLayout roundLinearLayout = (RoundLinearLayout) view;
                i = R.id.tvMaterialsSize;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tvMaterialsTime;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tvMaterialsTitle;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new ItemMaterialListBinding(roundLinearLayout, imageView, imageView2, roundLinearLayout, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
