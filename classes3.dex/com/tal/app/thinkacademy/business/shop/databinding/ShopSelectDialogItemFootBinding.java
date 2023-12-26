package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import java.util.Objects;

public final class ShopSelectDialogItemFootBinding implements ViewBinding {
    private final View rootView;

    private ShopSelectDialogItemFootBinding(View view) {
        this.rootView = view;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static ShopSelectDialogItemFootBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShopSelectDialogItemFootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.shop_select_dialog_item_foot;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ShopSelectDialogItemFootBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ShopSelectDialogItemFootBinding(view);
    }
}
