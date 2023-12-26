package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessCanvasTripleScreenLayoutBinding implements ViewBinding {
    public final ImageView ivLiveBusinessNoCourseware;
    public final ScrollView liveBusinessCanvasTripleScreenCoursewareArea;
    public final FrameLayout liveBusinessCanvasTripleScreenCoursewareAreaInner;
    public final ImageView liveBusinessCanvasTripleScreenStateIv;
    public final FrameLayout liveBusinessCanvasTripleScreenStateLayout;
    public final TextView liveBusinessCanvasTripleScreenStateTv;
    private final ConstraintLayout rootView;

    private LiveBusinessCanvasTripleScreenLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ScrollView scrollView, FrameLayout frameLayout, ImageView imageView2, FrameLayout frameLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.ivLiveBusinessNoCourseware = imageView;
        this.liveBusinessCanvasTripleScreenCoursewareArea = scrollView;
        this.liveBusinessCanvasTripleScreenCoursewareAreaInner = frameLayout;
        this.liveBusinessCanvasTripleScreenStateIv = imageView2;
        this.liveBusinessCanvasTripleScreenStateLayout = frameLayout2;
        this.liveBusinessCanvasTripleScreenStateTv = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessCanvasTripleScreenLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessCanvasTripleScreenLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_canvas_triple_screen_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessCanvasTripleScreenLayoutBinding bind(View view) {
        int i = R.id.iv_live_business_no_courseware;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.live_business_canvas_triple_screen_courseware_area;
            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
            if (scrollView != null) {
                i = R.id.live_business_canvas_triple_screen_courseware_area_inner;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.live_business_canvas_triple_screen_state_iv;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.live_business_canvas_triple_screen_state_layout;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout2 != null) {
                            i = R.id.live_business_canvas_triple_screen_state_tv;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new LiveBusinessCanvasTripleScreenLayoutBinding((ConstraintLayout) view, imageView, scrollView, frameLayout, imageView2, frameLayout2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
