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

public final class ItemSwitchViewBinding implements ViewBinding {
    public final ImageView ivBranchSchool;
    public final ImageView ivUserHeader;
    public final ImageView ivUserSelect;
    private final RoundLinearLayout rootView;
    public final TextView tvUserNickname;
    public final TextView tvUserNo;

    private ItemSwitchViewBinding(RoundLinearLayout roundLinearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2) {
        this.rootView = roundLinearLayout;
        this.ivBranchSchool = imageView;
        this.ivUserHeader = imageView2;
        this.ivUserSelect = imageView3;
        this.tvUserNickname = textView;
        this.tvUserNo = textView2;
    }

    public RoundLinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemSwitchViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemSwitchViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_switch_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemSwitchViewBinding bind(View view) {
        int i = R.id.ivBranchSchool;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.ivUserHeader;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.ivUserSelect;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.tvUserNickname;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tvUserNo;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new ItemSwitchViewBinding((RoundLinearLayout) view, imageView, imageView2, imageView3, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
