package com.tal.app.thinkacademy.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.common.R;

public final class CommonDialogGoldcoinBinding implements ViewBinding {
    public final ImageView ivGoldcoin;
    public final LinearLayout llTwo;
    private final RelativeLayout rootView;
    public final TextView tvGotIt;
    public final TextView tvOne;
    public final TextView tvTwo;

    private CommonDialogGoldcoinBinding(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.ivGoldcoin = imageView;
        this.llTwo = linearLayout;
        this.tvGotIt = textView;
        this.tvOne = textView2;
        this.tvTwo = textView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CommonDialogGoldcoinBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CommonDialogGoldcoinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.common_dialog_goldcoin;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CommonDialogGoldcoinBinding bind(View view) {
        int i = R.id.ivGoldcoin;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.llTwo;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.tvGotIt;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tvOne;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tvTwo;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new CommonDialogGoldcoinBinding((RelativeLayout) view, imageView, linearLayout, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
