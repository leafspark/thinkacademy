package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessSpeechStudentLayoutBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView tvSpeechStudent;

    private LiveBusinessSpeechStudentLayoutBinding(FrameLayout frameLayout, TextView textView) {
        this.rootView = frameLayout;
        this.tvSpeechStudent = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessSpeechStudentLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessSpeechStudentLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_speech_student_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessSpeechStudentLayoutBinding bind(View view) {
        int i = R.id.tvSpeechStudent;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new LiveBusinessSpeechStudentLayoutBinding((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
