package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.widget.TagTextView;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class ActivityPlanListBinding implements ViewBinding {
    public final LoadStatusView loadviewSpeakerList;
    public final ConstraintLayout rlBgUserPrompts;
    private final ConstraintLayout rootView;
    public final RecyclerView rvSpeakerList;
    public final RecyclerView rvSpeakerTeaceherList;
    public final TitleBar tbActivitySpeakerList;
    public final TextView tvActivitySpeakerStudyCourseDuration;
    public final TagTextView tvActivitySpeakerStudyCourseName;
    public final TextView tvActivitySpeakerStudyCourseTime;

    private ActivityPlanListBinding(ConstraintLayout constraintLayout, LoadStatusView loadStatusView, ConstraintLayout constraintLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, TitleBar titleBar, TextView textView, TagTextView tagTextView, TextView textView2) {
        this.rootView = constraintLayout;
        this.loadviewSpeakerList = loadStatusView;
        this.rlBgUserPrompts = constraintLayout2;
        this.rvSpeakerList = recyclerView;
        this.rvSpeakerTeaceherList = recyclerView2;
        this.tbActivitySpeakerList = titleBar;
        this.tvActivitySpeakerStudyCourseDuration = textView;
        this.tvActivitySpeakerStudyCourseName = tagTextView;
        this.tvActivitySpeakerStudyCourseTime = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPlanListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPlanListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_plan_list;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.rlBgUserPrompts;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.rvSpeakerList;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.rvSpeakerTeaceherList;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPlanListBinding bind(android.view.View r12) {
        /*
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.loadview_speaker_list
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r4 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r4
            if (r4 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.rlBgUserPrompts
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.rvSpeakerList
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            if (r6 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.rvSpeakerTeaceherList
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tb_activity_speaker_list
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r8 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r8
            if (r8 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_activity_speaker_study_course_duration
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_activity_speaker_study_course_name
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            com.tal.app.thinkacademy.lib.commui.widget.TagTextView r10 = (com.tal.app.thinkacademy.lib.commui.widget.TagTextView) r10
            if (r10 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_activity_speaker_study_course_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0062
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPlanListBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPlanListBinding
            r3 = r12
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x0062:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPlanListBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPlanListBinding");
    }
}
