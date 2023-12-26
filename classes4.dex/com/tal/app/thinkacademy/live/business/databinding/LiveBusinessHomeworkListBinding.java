package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessHomeworkListBinding implements ViewBinding {
    public final FrameLayout layoutLiveBusinessHomeworkWindow;
    private final ConstraintLayout rootView;
    public final RecyclerView rvLiveBusinessHomeworkWindow;
    public final View viewLiveBusinessHomeworkWindow;
    public final View viewLiveBusinessHomeworkWindowPhone;

    private LiveBusinessHomeworkListBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, RecyclerView recyclerView, View view, View view2) {
        this.rootView = constraintLayout;
        this.layoutLiveBusinessHomeworkWindow = frameLayout;
        this.rvLiveBusinessHomeworkWindow = recyclerView;
        this.viewLiveBusinessHomeworkWindow = view;
        this.viewLiveBusinessHomeworkWindowPhone = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessHomeworkListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessHomeworkListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_homework_list;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.rv_live_business_homework_window;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.view_live_business_homework_window;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.view_live_business_homework_window_phone;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkListBinding bind(android.view.View r8) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_live_business_homework_window
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            if (r4 == 0) goto L_0x0030
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rv_live_business_homework_window
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r1
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            if (r5 == 0) goto L_0x0030
            int r0 = com.tal.app.thinkacademy.live.business.R.id.view_live_business_homework_window
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r6 == 0) goto L_0x0030
            int r0 = com.tal.app.thinkacademy.live.business.R.id.view_live_business_homework_window_phone
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r7 == 0) goto L_0x0030
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkListBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkListBinding
            r3 = r8
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x0030:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkListBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkListBinding");
    }
}
