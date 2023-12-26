package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessFeedbackPlaybackBinding implements ViewBinding {
    public final RoundTextView btnCancel;
    public final TextView btnSend;
    public final ImageView feedbackAllow;
    public final TextView feedbackTip;
    public final TextView feedbackTitle;
    public final EditText questionDesc;
    private final RoundLinearLayout rootView;

    private LiveBusinessFeedbackPlaybackBinding(RoundLinearLayout roundLinearLayout, RoundTextView roundTextView, TextView textView, ImageView imageView, TextView textView2, TextView textView3, EditText editText) {
        this.rootView = roundLinearLayout;
        this.btnCancel = roundTextView;
        this.btnSend = textView;
        this.feedbackAllow = imageView;
        this.feedbackTip = textView2;
        this.feedbackTitle = textView3;
        this.questionDesc = editText;
    }

    public RoundLinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessFeedbackPlaybackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessFeedbackPlaybackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_feedback_playback;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessFeedbackPlaybackBinding bind(View view) {
        int i = R.id.btnCancel;
        RoundTextView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.btnSend;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.feedbackAllow;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.feedbackTip;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.feedbackTitle;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.questionDesc;
                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText != null) {
                                return new LiveBusinessFeedbackPlaybackBinding((RoundLinearLayout) view, findChildViewById, textView, imageView, textView2, textView3, editText);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
