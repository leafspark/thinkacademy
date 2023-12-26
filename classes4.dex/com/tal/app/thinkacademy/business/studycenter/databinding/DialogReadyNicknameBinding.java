package com.tal.app.thinkacademy.business.studycenter.databinding;

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
import com.tal.app.thinkacademy.business.studycenter.R;

public final class DialogReadyNicknameBinding implements ViewBinding {
    public final ImageView btnClearName;
    public final EditText etNickName;
    private final RoundLinearLayout rootView;
    public final TextView tvCancel;
    public final TextView tvConfirm;
    public final TextView tvDialogSubtitle;

    private DialogReadyNicknameBinding(RoundLinearLayout roundLinearLayout, ImageView imageView, EditText editText, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = roundLinearLayout;
        this.btnClearName = imageView;
        this.etNickName = editText;
        this.tvCancel = textView;
        this.tvConfirm = textView2;
        this.tvDialogSubtitle = textView3;
    }

    public RoundLinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogReadyNicknameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogReadyNicknameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.dialog_ready_nickname;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogReadyNicknameBinding bind(View view) {
        int i = R.id.btn_clear_name;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.et_nick_name;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.tv_cancel;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_confirm;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_dialog_subtitle;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new DialogReadyNicknameBinding((RoundLinearLayout) view, imageView, editText, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
