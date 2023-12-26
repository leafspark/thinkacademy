package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;

public final class PersonalInfoItemLayoutBinding implements ViewBinding {
    public final ClearEditText itemEt;
    public final TextView itemTitle;
    private final LinearLayout rootView;

    private PersonalInfoItemLayoutBinding(LinearLayout linearLayout, ClearEditText clearEditText, TextView textView) {
        this.rootView = linearLayout;
        this.itemEt = clearEditText;
        this.itemTitle = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PersonalInfoItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PersonalInfoItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.personal_info_item_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PersonalInfoItemLayoutBinding bind(View view) {
        int i = R.id.itemEt;
        ClearEditText clearEditText = (ClearEditText) ViewBindings.findChildViewById(view, i);
        if (clearEditText != null) {
            i = R.id.itemTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new PersonalInfoItemLayoutBinding((LinearLayout) view, clearEditText, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
