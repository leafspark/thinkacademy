package com.tal.app.thinkacademy.lib.commui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.R;

public final class DialogPhotoBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvAlbum;
    public final TextView tvPhoto;
    public final TextView tvPhotoCancel;

    private DialogPhotoBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.tvAlbum = textView;
        this.tvPhoto = textView2;
        this.tvPhotoCancel = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogPhotoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogPhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.dialog_photo;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogPhotoBinding bind(View view) {
        int i = R.id.tv_album;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.tv_photo;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.tv_photo_cancel;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    return new DialogPhotoBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}