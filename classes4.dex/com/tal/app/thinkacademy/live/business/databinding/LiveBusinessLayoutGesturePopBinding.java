package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessLayoutGesturePopBinding implements ViewBinding {
    public final FrameLayout flGestureTimeRoot;
    public final ImageView ivGestureIcon;
    public final LinearLayout ivGestureVolumeRoot;
    private final FrameLayout rootView;
    public final SeekBar seekGestureProgress;
    public final TextView tvGestureTime;

    private LiveBusinessLayoutGesturePopBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, LinearLayout linearLayout, SeekBar seekBar, TextView textView) {
        this.rootView = frameLayout;
        this.flGestureTimeRoot = frameLayout2;
        this.ivGestureIcon = imageView;
        this.ivGestureVolumeRoot = linearLayout;
        this.seekGestureProgress = seekBar;
        this.tvGestureTime = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLayoutGesturePopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLayoutGesturePopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_layout_gesture_pop;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessLayoutGesturePopBinding bind(View view) {
        int i = R.id.fl_gesture_time_root;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.iv_gesture_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_gesture_volume_root;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.seek_gesture_progress;
                    SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, i);
                    if (seekBar != null) {
                        i = R.id.tv_gesture_time;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new LiveBusinessLayoutGesturePopBinding((FrameLayout) view, frameLayout, imageView, linearLayout, seekBar, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
