package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import java.util.Objects;

public final class LiveBusinessLayoutAllOnStageTeacherBinding implements ViewBinding {
    public final RelativeLayout bottomLayout;
    public final ImageView micShow;
    public final ImageView noTeacherBg;
    private final View rootView;
    public final TextView studentName;
    public final FrameLayout surfaceViewRoot;

    private LiveBusinessLayoutAllOnStageTeacherBinding(View view, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, TextView textView, FrameLayout frameLayout) {
        this.rootView = view;
        this.bottomLayout = relativeLayout;
        this.micShow = imageView;
        this.noTeacherBg = imageView2;
        this.studentName = textView;
        this.surfaceViewRoot = frameLayout;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLayoutAllOnStageTeacherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        int i = R.layout.live_business_layout_all_on_stage_teacher;
        if (!(layoutInflater instanceof LayoutInflater)) {
            layoutInflater.inflate(i, viewGroup);
        } else {
            XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup);
        }
        return bind(viewGroup);
    }

    public static LiveBusinessLayoutAllOnStageTeacherBinding bind(View view) {
        int i = R.id.bottom_layout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.mic_show;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.no_teacher_bg;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.student_name;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.surfaceView_root;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            return new LiveBusinessLayoutAllOnStageTeacherBinding(view, relativeLayout, imageView, imageView2, textView, frameLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
