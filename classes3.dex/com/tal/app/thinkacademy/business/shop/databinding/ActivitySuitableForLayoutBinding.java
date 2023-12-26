package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;

public final class ActivitySuitableForLayoutBinding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TitleBar titleView;

    private ActivitySuitableForLayoutBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView2, TitleBar titleBar) {
        this.rootView = constraintLayout;
        this.recyclerView = recyclerView2;
        this.titleView = titleBar;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySuitableForLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivitySuitableForLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_suitable_for_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.title_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.ActivitySuitableForLayoutBinding bind(android.view.View r3) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.recyclerView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            if (r1 == 0) goto L_0x001c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.title_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r2 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r2
            if (r2 == 0) goto L_0x001c
            com.tal.app.thinkacademy.business.shop.databinding.ActivitySuitableForLayoutBinding r0 = new com.tal.app.thinkacademy.business.shop.databinding.ActivitySuitableForLayoutBinding
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r0.<init>(r3, r1, r2)
            return r0
        L_0x001c:
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r3 = r3.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r3 = r1.concat(r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.ActivitySuitableForLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.ActivitySuitableForLayoutBinding");
    }
}
