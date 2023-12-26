package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessPopupwindowTeacheronlyControllerBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ImageButton swLiveBusinessTeacheronlyController;

    private LiveBusinessPopupwindowTeacheronlyControllerBinding(LinearLayout linearLayout, ImageButton imageButton) {
        this.rootView = linearLayout;
        this.swLiveBusinessTeacheronlyController = imageButton;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessPopupwindowTeacheronlyControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessPopupwindowTeacheronlyControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_popupwindow_teacheronly_controller;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessPopupwindowTeacheronlyControllerBinding bind(View view) {
        int i = R.id.sw_live_business_teacheronly_controller;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            return new LiveBusinessPopupwindowTeacheronlyControllerBinding((LinearLayout) view, imageButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
