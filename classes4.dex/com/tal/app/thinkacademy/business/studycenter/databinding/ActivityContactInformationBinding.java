package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;

public final class ActivityContactInformationBinding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final TitleBar tbContactInformation;

    private ActivityContactInformationBinding(LinearLayout linearLayout, RecyclerView recyclerView2, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.recyclerView = recyclerView2;
        this.tbContactInformation = titleBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityContactInformationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityContactInformationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_contact_information;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityContactInformationBinding bind(View view) {
        int i = R.id.recyclerView;
        RecyclerView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.tbContactInformation;
            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
            if (titleBar != null) {
                return new ActivityContactInformationBinding((LinearLayout) view, findChildViewById, titleBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
