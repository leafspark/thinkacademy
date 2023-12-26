package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import java.util.Objects;

public final class LiveBusinessIncludeTopicOptionsCheckboxLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;

    private LiveBusinessIncludeTopicOptionsCheckboxLayoutBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessIncludeTopicOptionsCheckboxLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessIncludeTopicOptionsCheckboxLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_include_topic_options_checkbox_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessIncludeTopicOptionsCheckboxLayoutBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new LiveBusinessIncludeTopicOptionsCheckboxLayoutBinding((LinearLayout) view);
    }
}
