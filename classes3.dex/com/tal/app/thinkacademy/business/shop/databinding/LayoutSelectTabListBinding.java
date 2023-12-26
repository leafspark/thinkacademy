package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.widget.view.StateTextView;

public final class LayoutSelectTabListBinding implements ViewBinding {
    public final StateTextView filterDay;
    public final StateTextView filterTeacher;
    public final StateTextView filterTime;
    private final ConstraintLayout rootView;

    private LayoutSelectTabListBinding(ConstraintLayout constraintLayout, StateTextView stateTextView, StateTextView stateTextView2, StateTextView stateTextView3) {
        this.rootView = constraintLayout;
        this.filterDay = stateTextView;
        this.filterTeacher = stateTextView2;
        this.filterTime = stateTextView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutSelectTabListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutSelectTabListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_select_tab_list;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutSelectTabListBinding bind(View view) {
        int i = R.id.filter_day;
        StateTextView stateTextView = (StateTextView) ViewBindings.findChildViewById(view, i);
        if (stateTextView != null) {
            i = R.id.filter_teacher;
            StateTextView stateTextView2 = (StateTextView) ViewBindings.findChildViewById(view, i);
            if (stateTextView2 != null) {
                i = R.id.filter_time;
                StateTextView stateTextView3 = (StateTextView) ViewBindings.findChildViewById(view, i);
                if (stateTextView3 != null) {
                    return new LayoutSelectTabListBinding((ConstraintLayout) view, stateTextView, stateTextView2, stateTextView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
