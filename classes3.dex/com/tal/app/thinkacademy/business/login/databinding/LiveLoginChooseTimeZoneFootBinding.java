package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;
import java.util.Objects;

public final class LiveLoginChooseTimeZoneFootBinding implements ViewBinding {
    private final LinearLayout rootView;

    private LiveLoginChooseTimeZoneFootBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveLoginChooseTimeZoneFootBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveLoginChooseTimeZoneFootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_login_choose_time_zone_foot;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveLoginChooseTimeZoneFootBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new LiveLoginChooseTimeZoneFootBinding((LinearLayout) view);
    }
}
