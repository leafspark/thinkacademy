package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkcademy.lib.commui.widget.StateImageView;

public final class LayoutDeviceTestStepBinding implements ViewBinding {
    public final StateImageView ivStepCamera;
    public final StateImageView ivStepLine1;
    public final StateImageView ivStepLine2;
    public final StateImageView ivStepLine3;
    public final StateImageView ivStepMic;
    public final StateImageView ivStepNet;
    public final StateImageView ivStepVoice;
    private final ConstraintLayout rootView;
    public final TextView tvStepCamera;
    public final TextView tvStepMic;
    public final TextView tvStepNet;
    public final TextView tvStepVoice;

    private LayoutDeviceTestStepBinding(ConstraintLayout constraintLayout, StateImageView stateImageView, StateImageView stateImageView2, StateImageView stateImageView3, StateImageView stateImageView4, StateImageView stateImageView5, StateImageView stateImageView6, StateImageView stateImageView7, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.ivStepCamera = stateImageView;
        this.ivStepLine1 = stateImageView2;
        this.ivStepLine2 = stateImageView3;
        this.ivStepLine3 = stateImageView4;
        this.ivStepMic = stateImageView5;
        this.ivStepNet = stateImageView6;
        this.ivStepVoice = stateImageView7;
        this.tvStepCamera = textView;
        this.tvStepMic = textView2;
        this.tvStepNet = textView3;
        this.tvStepVoice = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDeviceTestStepBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutDeviceTestStepBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_device_test_step;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutDeviceTestStepBinding bind(View view) {
        int i = R.id.iv_step_camera;
        StateImageView stateImageView = (StateImageView) ViewBindings.findChildViewById(view, i);
        if (stateImageView != null) {
            i = R.id.iv_step_line_1;
            StateImageView stateImageView2 = (StateImageView) ViewBindings.findChildViewById(view, i);
            if (stateImageView2 != null) {
                i = R.id.iv_step_line_2;
                StateImageView stateImageView3 = (StateImageView) ViewBindings.findChildViewById(view, i);
                if (stateImageView3 != null) {
                    i = R.id.iv_step_line_3;
                    StateImageView stateImageView4 = (StateImageView) ViewBindings.findChildViewById(view, i);
                    if (stateImageView4 != null) {
                        i = R.id.iv_step_mic;
                        StateImageView stateImageView5 = (StateImageView) ViewBindings.findChildViewById(view, i);
                        if (stateImageView5 != null) {
                            i = R.id.iv_step_net;
                            StateImageView stateImageView6 = (StateImageView) ViewBindings.findChildViewById(view, i);
                            if (stateImageView6 != null) {
                                i = R.id.iv_step_voice;
                                StateImageView stateImageView7 = (StateImageView) ViewBindings.findChildViewById(view, i);
                                if (stateImageView7 != null) {
                                    i = R.id.tv_step_camera;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.tv_step_mic;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.tv_step_net;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.tv_step_voice;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    return new LayoutDeviceTestStepBinding((ConstraintLayout) view, stateImageView, stateImageView2, stateImageView3, stateImageView4, stateImageView5, stateImageView6, stateImageView7, textView, textView2, textView3, textView4);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
