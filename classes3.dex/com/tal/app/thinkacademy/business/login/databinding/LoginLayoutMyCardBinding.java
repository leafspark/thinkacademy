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
import com.tal.app.thinkacademy.business.login.R;

public final class LoginLayoutMyCardBinding implements ViewBinding {
    public final ImageView cardBottomBg;
    public final ImageView cardIcon;
    public final TextView cardName;
    private final RelativeLayout rootView;

    private LoginLayoutMyCardBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = relativeLayout;
        this.cardBottomBg = imageView;
        this.cardIcon = imageView2;
        this.cardName = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LoginLayoutMyCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LoginLayoutMyCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.login_layout_my_card;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LoginLayoutMyCardBinding bind(View view) {
        int i = R.id.card_bottom_bg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.card_icon;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.card_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new LoginLayoutMyCardBinding((RelativeLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
