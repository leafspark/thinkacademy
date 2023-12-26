package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import java.util.Objects;

public final class LiveBusinessIncludeTopicOptionsRadiobuttonLayoutBinding implements ViewBinding {
    public final RadioGroup rgLiveBusinessTopicSingle;
    private final RadioGroup rootView;

    private LiveBusinessIncludeTopicOptionsRadiobuttonLayoutBinding(RadioGroup radioGroup, RadioGroup radioGroup2) {
        this.rootView = radioGroup;
        this.rgLiveBusinessTopicSingle = radioGroup2;
    }

    public RadioGroup getRoot() {
        return this.rootView;
    }

    public static LiveBusinessIncludeTopicOptionsRadiobuttonLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessIncludeTopicOptionsRadiobuttonLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_include_topic_options_radiobutton_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessIncludeTopicOptionsRadiobuttonLayoutBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        RadioGroup radioGroup = (RadioGroup) view;
        return new LiveBusinessIncludeTopicOptionsRadiobuttonLayoutBinding(radioGroup, radioGroup);
    }
}
