package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.shop.R;

public final class ShopSignUpReminderLayoutBinding implements ViewBinding {
    public final RoundTextView reminderBtn;
    public final TextView reminderMsg;
    public final TextView reminderTitle;
    private final ConstraintLayout rootView;

    private ShopSignUpReminderLayoutBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.reminderBtn = roundTextView;
        this.reminderMsg = textView;
        this.reminderTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ShopSignUpReminderLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShopSignUpReminderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.shop_sign_up_reminder_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ShopSignUpReminderLayoutBinding bind(View view) {
        int i = R.id.reminder_btn;
        RoundTextView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.reminder_msg;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.reminder_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new ShopSignUpReminderLayoutBinding((ConstraintLayout) view, findChildViewById, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
