package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import java.util.Objects;

public final class ShopSelectDialogItemNormalBinding implements ViewBinding {
    public final TextView channelItemName;
    private final TextView rootView;

    private ShopSelectDialogItemNormalBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.channelItemName = textView2;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static ShopSelectDialogItemNormalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShopSelectDialogItemNormalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.shop_select_dialog_item_normal;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ShopSelectDialogItemNormalBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new ShopSelectDialogItemNormalBinding(textView, textView);
    }
}
