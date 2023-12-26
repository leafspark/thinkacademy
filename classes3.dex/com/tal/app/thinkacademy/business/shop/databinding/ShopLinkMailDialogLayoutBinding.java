package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;

public final class ShopLinkMailDialogLayoutBinding implements ViewBinding {
    public final ImageView dialogClose;
    public final TextView dialogSubTitle;
    public final TextView dialogTitle;
    public final TextView linkMailBtnNext;
    public final TextView linkNumberTips;
    public final EditText mailEdit;
    private final ConstraintLayout rootView;

    private ShopLinkMailDialogLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, EditText editText) {
        this.rootView = constraintLayout;
        this.dialogClose = imageView;
        this.dialogSubTitle = textView;
        this.dialogTitle = textView2;
        this.linkMailBtnNext = textView3;
        this.linkNumberTips = textView4;
        this.mailEdit = editText;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ShopLinkMailDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShopLinkMailDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.shop_link_mail_dialog_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ShopLinkMailDialogLayoutBinding bind(View view) {
        int i = R.id.dialog_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.dialog_sub_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.dialog_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.link_mail_btn_next;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.link_number_tips;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.mail_edit;
                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText != null) {
                                return new ShopLinkMailDialogLayoutBinding((ConstraintLayout) view, imageView, textView, textView2, textView3, textView4, editText);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
