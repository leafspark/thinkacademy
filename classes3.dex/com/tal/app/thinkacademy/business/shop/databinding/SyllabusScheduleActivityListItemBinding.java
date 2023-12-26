package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.lib.commui.widget.TagTextView;

public final class SyllabusScheduleActivityListItemBinding implements ViewBinding {
    public final View bottomLine;
    private final ConstraintLayout rootView;
    public final TextView scheduleDateDesc;
    public final TagTextView scheduleName;
    public final ConstraintLayout scheduleRootLayout;

    private SyllabusScheduleActivityListItemBinding(ConstraintLayout constraintLayout, View view, TextView textView, TagTextView tagTextView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.bottomLine = view;
        this.scheduleDateDesc = textView;
        this.scheduleName = tagTextView;
        this.scheduleRootLayout = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SyllabusScheduleActivityListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SyllabusScheduleActivityListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.syllabus_schedule_activity_list_item;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.schedule_name;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.SyllabusScheduleActivityListItemBinding bind(android.view.View r7) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.bottom_line
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            if (r3 == 0) goto L_0x0029
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.schedule_date_desc
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0029
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.schedule_name
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            r5 = r1
            com.tal.app.thinkacademy.lib.commui.widget.TagTextView r5 = (com.tal.app.thinkacademy.lib.commui.widget.TagTextView) r5
            if (r5 == 0) goto L_0x0029
            r6 = r7
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            com.tal.app.thinkacademy.business.shop.databinding.SyllabusScheduleActivityListItemBinding r7 = new com.tal.app.thinkacademy.business.shop.databinding.SyllabusScheduleActivityListItemBinding
            r1 = r7
            r2 = r6
            r1.<init>(r2, r3, r4, r5, r6)
            return r7
        L_0x0029:
            android.content.res.Resources r7 = r7.getResources()
            java.lang.String r7 = r7.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.SyllabusScheduleActivityListItemBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.SyllabusScheduleActivityListItemBinding");
    }
}
