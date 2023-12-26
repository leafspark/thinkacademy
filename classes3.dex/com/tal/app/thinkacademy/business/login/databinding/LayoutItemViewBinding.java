package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.tal.app.thinkacademy.business.login.R;

public final class LayoutItemViewBinding implements ViewBinding {
    public final ImageView ivGo;
    public final ImageView ivIcon;
    public final ImageView ivRight;
    public final RoundRelativeLayout rlItem;
    public final RelativeLayout rlRight;
    private final RoundRelativeLayout rootView;
    public final TextView tvDetail;
    public final TextView tvRight;
    public final TextView tvRightContent;

    private LayoutItemViewBinding(RoundRelativeLayout roundRelativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, RoundRelativeLayout roundRelativeLayout2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = roundRelativeLayout;
        this.ivGo = imageView;
        this.ivIcon = imageView2;
        this.ivRight = imageView3;
        this.rlItem = roundRelativeLayout2;
        this.rlRight = relativeLayout;
        this.tvDetail = textView;
        this.tvRight = textView2;
        this.tvRightContent = textView3;
    }

    public RoundRelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutItemViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutItemViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_item_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutItemViewBinding bind(View view) {
        int i = R.id.ivGo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_icon;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_right;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) view;
                    i = R.id.rl_right;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = R.id.tv_detail;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tv_right;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.tv_right_content;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new LayoutItemViewBinding(roundRelativeLayout, imageView, imageView2, imageView3, roundRelativeLayout, relativeLayout, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
