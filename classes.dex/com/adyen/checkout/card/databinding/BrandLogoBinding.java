package com.adyen.checkout.card.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.adyen.checkout.card.R;
import com.adyen.checkout.components.ui.view.RoundCornerImageView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import java.util.Objects;

public final class BrandLogoBinding implements ViewBinding {
    private final RoundCornerImageView rootView;

    private BrandLogoBinding(RoundCornerImageView roundCornerImageView) {
        this.rootView = roundCornerImageView;
    }

    public RoundCornerImageView getRoot() {
        return this.rootView;
    }

    public static BrandLogoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BrandLogoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.brand_logo;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BrandLogoBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new BrandLogoBinding((RoundCornerImageView) view);
    }
}
