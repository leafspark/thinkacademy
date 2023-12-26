package com.tal.user.global.trade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.user.global.trade.R;

public final class AdapterTalAppCheckoutItemBinding implements ViewBinding {
    public final CheckBox cbTalTradePayway;
    public final ImageView ivTalTradePaywayActiveicon;
    public final ImageView ivTalTradePaywayIcon;
    private final RelativeLayout rootView;
    public final RelativeLayout rvTalTradePayWay;
    public final TextView tvTalTradePaywayName;
    public final TextView tvTalTradePaywaySubtitle;

    private AdapterTalAppCheckoutItemBinding(RelativeLayout relativeLayout, CheckBox checkBox, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.cbTalTradePayway = checkBox;
        this.ivTalTradePaywayActiveicon = imageView;
        this.ivTalTradePaywayIcon = imageView2;
        this.rvTalTradePayWay = relativeLayout2;
        this.tvTalTradePaywayName = textView;
        this.tvTalTradePaywaySubtitle = textView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AdapterTalAppCheckoutItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AdapterTalAppCheckoutItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.adapter_tal_app_checkout_item;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AdapterTalAppCheckoutItemBinding bind(View view) {
        int i = R.id.cbTalTradePayway;
        CheckBox checkBox = (CheckBox) view.findViewById(i);
        if (checkBox != null) {
            i = R.id.ivTalTradePaywayActiveicon;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = R.id.ivTalTradePaywayIcon;
                ImageView imageView2 = (ImageView) view.findViewById(i);
                if (imageView2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i = R.id.tvTalTradePaywayName;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = R.id.tvTalTradePaywaySubtitle;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            return new AdapterTalAppCheckoutItemBinding(relativeLayout, checkBox, imageView, imageView2, relativeLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
