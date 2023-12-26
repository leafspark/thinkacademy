package com.tal.app.thinkacademy.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.common.R;
import java.util.Objects;

public final class DialogBrowserBinding implements ViewBinding {
    public final CardView container;
    private final CardView rootView;

    private DialogBrowserBinding(CardView cardView, CardView cardView2) {
        this.rootView = cardView;
        this.container = cardView2;
    }

    public CardView getRoot() {
        return this.rootView;
    }

    public static DialogBrowserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogBrowserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.dialog_browser;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogBrowserBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        CardView cardView = (CardView) view;
        return new DialogBrowserBinding(cardView, cardView);
    }
}
