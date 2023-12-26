package com.tal.app.thinkacademy.lib.commui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.R;

public final class LayoutFilterViewBinding implements ViewBinding {
    public final LinearLayout llFilterPannel;
    public final LinearLayout llFilterTitles;
    private final LinearLayout rootView;
    public final RecyclerView rvFilterItems;

    private LayoutFilterViewBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.llFilterPannel = linearLayout2;
        this.llFilterTitles = linearLayout3;
        this.rvFilterItems = recyclerView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutFilterViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutFilterViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_filter_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = com.tal.app.thinkacademy.lib.commui.R.id.rv_filter_items;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.lib.commui.databinding.LayoutFilterViewBinding bind(android.view.View r4) {
        /*
            int r0 = com.tal.app.thinkacademy.lib.commui.R.id.ll_filter_pannel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            if (r1 == 0) goto L_0x0026
            int r0 = com.tal.app.thinkacademy.lib.commui.R.id.ll_filter_titles
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            if (r2 == 0) goto L_0x0026
            int r0 = com.tal.app.thinkacademy.lib.commui.R.id.rv_filter_items
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            androidx.recyclerview.widget.RecyclerView r3 = (androidx.recyclerview.widget.RecyclerView) r3
            if (r3 == 0) goto L_0x0026
            com.tal.app.thinkacademy.lib.commui.databinding.LayoutFilterViewBinding r0 = new com.tal.app.thinkacademy.lib.commui.databinding.LayoutFilterViewBinding
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r0.<init>(r4, r1, r2, r3)
            return r0
        L_0x0026:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.commui.databinding.LayoutFilterViewBinding.bind(android.view.View):com.tal.app.thinkacademy.lib.commui.databinding.LayoutFilterViewBinding");
    }
}
