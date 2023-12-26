package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class ActivityPlayerStudyBinding implements ViewBinding {
    public final ImageView playerBackBtn;
    public final LinearLayout playerBottomLayout;
    public final ImageView playerBtnPlayPause;
    public final LinearLayout playerLoading;
    public final SeekBar playerProgress;
    public final ConstraintLayout playerRootView;
    public final SurfaceView playerSurfaceView;
    public final TextView playerTimeCurrent;
    public final TextView playerTimeTotal;
    public final LinearLayout playerTopLayout;
    public final TextView playerVideoName;
    private final ConstraintLayout rootView;

    private ActivityPlayerStudyBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, LinearLayout linearLayout2, SeekBar seekBar, ConstraintLayout constraintLayout2, SurfaceView surfaceView, TextView textView, TextView textView2, LinearLayout linearLayout3, TextView textView3) {
        this.rootView = constraintLayout;
        this.playerBackBtn = imageView;
        this.playerBottomLayout = linearLayout;
        this.playerBtnPlayPause = imageView2;
        this.playerLoading = linearLayout2;
        this.playerProgress = seekBar;
        this.playerRootView = constraintLayout2;
        this.playerSurfaceView = surfaceView;
        this.playerTimeCurrent = textView;
        this.playerTimeTotal = textView2;
        this.playerTopLayout = linearLayout3;
        this.playerVideoName = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPlayerStudyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPlayerStudyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_player_study;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityPlayerStudyBinding bind(View view) {
        int i = R.id.player_back_btn;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.player_bottom_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.player_btn_play_pause;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.player_loading;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.player_progress;
                        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, i);
                        if (seekBar != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            i = R.id.player_surface_view;
                            SurfaceView surfaceView = (SurfaceView) ViewBindings.findChildViewById(view, i);
                            if (surfaceView != null) {
                                i = R.id.player_time_current;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.player_time_total;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.player_top_layout;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.player_video_name;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                return new ActivityPlayerStudyBinding(constraintLayout, imageView, linearLayout, imageView2, linearLayout2, seekBar, constraintLayout, surfaceView, textView, textView2, linearLayout3, textView3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
