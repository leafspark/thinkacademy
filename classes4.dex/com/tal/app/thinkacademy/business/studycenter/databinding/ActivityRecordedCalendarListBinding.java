package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.widget.TagTextView;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class ActivityRecordedCalendarListBinding implements ViewBinding {
    public final ImageView ivStudyItemTagExpired;
    public final LoadStatusView loadviewSpeakerList;
    public final TitleBar recordedCalendarTitle;
    private final ConstraintLayout rootView;
    public final RecyclerView rvSpeakerList;
    public final RecyclerView rvTeacherList;
    public final TextView tvItemStudyCourseDuration;
    public final TagTextView tvItemStudyCourseName;

    private ActivityRecordedCalendarListBinding(ConstraintLayout constraintLayout, ImageView imageView, LoadStatusView loadStatusView, TitleBar titleBar, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TagTextView tagTextView) {
        this.rootView = constraintLayout;
        this.ivStudyItemTagExpired = imageView;
        this.loadviewSpeakerList = loadStatusView;
        this.recordedCalendarTitle = titleBar;
        this.rvSpeakerList = recyclerView;
        this.rvTeacherList = recyclerView2;
        this.tvItemStudyCourseDuration = textView;
        this.tvItemStudyCourseName = tagTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityRecordedCalendarListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityRecordedCalendarListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_recorded_calendar_list;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.loadviewSpeakerList;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.rvSpeakerList;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.rvTeacherList;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding bind(android.view.View r11) {
        /*
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.ivStudyItemTagExpired
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.loadviewSpeakerList
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r5 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r5
            if (r5 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.recordedCalendarTitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r6 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r6
            if (r6 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.rvSpeakerList
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.rvTeacherList
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            if (r8 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvItemStudyCourseDuration
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvItemStudyCourseName
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            com.tal.app.thinkacademy.lib.commui.widget.TagTextView r10 = (com.tal.app.thinkacademy.lib.commui.widget.TagTextView) r10
            if (r10 == 0) goto L_0x0057
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding
            r3 = r11
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0057:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding");
    }
}
