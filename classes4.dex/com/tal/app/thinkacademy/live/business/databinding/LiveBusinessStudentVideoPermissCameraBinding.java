package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessStudentVideoPermissCameraBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessPermissionCancel;
    public final TextView tvLiveBusinessPermissionSetting;
    public final TextView tvLiveBusinessPermissionTip;

    private LiveBusinessStudentVideoPermissCameraBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.tvLiveBusinessPermissionCancel = textView;
        this.tvLiveBusinessPermissionSetting = textView2;
        this.tvLiveBusinessPermissionTip = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessStudentVideoPermissCameraBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessStudentVideoPermissCameraBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_student_video_permiss_camera;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessStudentVideoPermissCameraBinding bind(View view) {
        int i = R.id.tv_live_business_permission_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.tv_live_business_permission_setting;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.tv_live_business_permission_tip;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    return new LiveBusinessStudentVideoPermissCameraBinding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
