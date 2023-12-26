package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import java.util.Objects;

public final class PageLivevodeoSignBinding implements ViewBinding {
    private final RelativeLayout rootView;

    private PageLivevodeoSignBinding(RelativeLayout relativeLayout) {
        this.rootView = relativeLayout;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PageLivevodeoSignBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PageLivevodeoSignBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.page_livevodeo_sign;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PageLivevodeoSignBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new PageLivevodeoSignBinding((RelativeLayout) view);
    }
}
