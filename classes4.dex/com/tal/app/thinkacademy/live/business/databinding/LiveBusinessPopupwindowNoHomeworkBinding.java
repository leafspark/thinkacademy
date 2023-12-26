package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;
import java.util.Objects;

public final class LiveBusinessPopupwindowNoHomeworkBinding implements ViewBinding {
    private final RoundTextView rootView;

    private LiveBusinessPopupwindowNoHomeworkBinding(RoundTextView roundTextView) {
        this.rootView = roundTextView;
    }

    public RoundTextView getRoot() {
        return this.rootView;
    }

    public static LiveBusinessPopupwindowNoHomeworkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessPopupwindowNoHomeworkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_popupwindow_no_homework;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessPopupwindowNoHomeworkBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new LiveBusinessPopupwindowNoHomeworkBinding((RoundTextView) view);
    }
}
