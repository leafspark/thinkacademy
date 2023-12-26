package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;

public final class ActivityChangeNicknameBinding implements ViewBinding {
    public final ClearEditText etNickName;
    public final ImageView ivClose;
    private final RoundRelativeLayout rootView;
    public final TextView tvEnter;

    private ActivityChangeNicknameBinding(RoundRelativeLayout roundRelativeLayout, ClearEditText clearEditText, ImageView imageView, TextView textView) {
        this.rootView = roundRelativeLayout;
        this.etNickName = clearEditText;
        this.ivClose = imageView;
        this.tvEnter = textView;
    }

    public RoundRelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityChangeNicknameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityChangeNicknameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_change_nickname;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityChangeNicknameBinding bind(View view) {
        int i = R.id.et_nickName;
        ClearEditText findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.iv_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.tv_enter;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new ActivityChangeNicknameBinding((RoundRelativeLayout) view, findChildViewById, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
