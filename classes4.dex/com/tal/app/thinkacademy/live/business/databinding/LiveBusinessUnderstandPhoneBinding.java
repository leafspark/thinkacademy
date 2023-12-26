package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessUnderstandPhoneBinding implements ViewBinding {
    public final ConstraintLayout clLiveBusinessUnderstand;
    public final Group groupLiveBusinessUnderstand;
    public final ImageView ivLiveBusinessUnderstandLine;
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessUnderstand;
    public final TextView tvLiveBusinessUnderstandNo;
    public final TextView tvLiveBusinessUnderstandYes;
    public final ViewStub vsLiveBusinessUnderstandNoLayout;
    public final ViewStub vsLiveBusinessUnderstandYesLayout;

    private LiveBusinessUnderstandPhoneBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Group group, ImageView imageView, TextView textView, TextView textView2, TextView textView3, ViewStub viewStub, ViewStub viewStub2) {
        this.rootView = constraintLayout;
        this.clLiveBusinessUnderstand = constraintLayout2;
        this.groupLiveBusinessUnderstand = group;
        this.ivLiveBusinessUnderstandLine = imageView;
        this.tvLiveBusinessUnderstand = textView;
        this.tvLiveBusinessUnderstandNo = textView2;
        this.tvLiveBusinessUnderstandYes = textView3;
        this.vsLiveBusinessUnderstandNoLayout = viewStub;
        this.vsLiveBusinessUnderstandYesLayout = viewStub2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessUnderstandPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessUnderstandPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_understand_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessUnderstandPhoneBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.group_live_business_understand;
        Group findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.iv_live_business_understand_line;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.tv_live_business_understand;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_live_business_understand_no;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_live_business_understand_yes;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.vs_live_business_understand_no_layout;
                            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i);
                            if (viewStub != null) {
                                i = R.id.vs_live_business_understand_yes_layout;
                                ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, i);
                                if (viewStub2 != null) {
                                    return new LiveBusinessUnderstandPhoneBinding(constraintLayout, constraintLayout, findChildViewById, imageView, textView, textView2, textView3, viewStub, viewStub2);
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
