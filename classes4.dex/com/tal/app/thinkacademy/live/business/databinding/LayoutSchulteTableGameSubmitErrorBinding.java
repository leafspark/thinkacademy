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

public final class LayoutSchulteTableGameSubmitErrorBinding implements ViewBinding {
    public final TextView dialogCommonBtnConfirm;
    public final TextView dialogCommonMsg;
    public final TextView dialogCommonTitle;
    private final FrameLayout rootView;

    private LayoutSchulteTableGameSubmitErrorBinding(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.dialogCommonBtnConfirm = textView;
        this.dialogCommonMsg = textView2;
        this.dialogCommonTitle = textView3;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutSchulteTableGameSubmitErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutSchulteTableGameSubmitErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_schulte_table_game_submit_error;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutSchulteTableGameSubmitErrorBinding bind(View view) {
        int i = R.id.dialog_common_btn_confirm;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.dialog_common_msg;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.dialog_common_title;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    return new LayoutSchulteTableGameSubmitErrorBinding((FrameLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
