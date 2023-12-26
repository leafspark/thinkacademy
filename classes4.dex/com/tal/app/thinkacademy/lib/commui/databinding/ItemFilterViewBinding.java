package com.tal.app.thinkacademy.lib.commui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.R;
import java.util.Objects;

public final class ItemFilterViewBinding implements ViewBinding {
    private final TextView rootView;

    private ItemFilterViewBinding(TextView textView) {
        this.rootView = textView;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static ItemFilterViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemFilterViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_filter_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemFilterViewBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ItemFilterViewBinding((TextView) view);
    }
}
