package com.tal.app.thinkacademy.lib.commui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.R;

public final class XesTabBottomBinding implements ViewBinding {
    public final ImageView ivImage;
    public final RelativeLayout rlRoot;
    private final RelativeLayout rootView;
    public final TextView tvIcon;
    public final TextView tvName;
    public final View viewPoint;

    private XesTabBottomBinding(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView, TextView textView2, View view) {
        this.rootView = relativeLayout;
        this.ivImage = imageView;
        this.rlRoot = relativeLayout2;
        this.tvIcon = textView;
        this.tvName = textView2;
        this.viewPoint = view;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static XesTabBottomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static XesTabBottomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.xes_tab_bottom;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        r0 = com.tal.app.thinkacademy.lib.commui.R.id.view_point;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.lib.commui.databinding.XesTabBottomBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.lib.commui.R.id.iv_image
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0034
            r5 = r9
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            int r0 = com.tal.app.thinkacademy.lib.commui.R.id.tv_icon
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0034
            int r0 = com.tal.app.thinkacademy.lib.commui.R.id.tv_name
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0034
            int r0 = com.tal.app.thinkacademy.lib.commui.R.id.view_point
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r8 == 0) goto L_0x0034
            com.tal.app.thinkacademy.lib.commui.databinding.XesTabBottomBinding r9 = new com.tal.app.thinkacademy.lib.commui.databinding.XesTabBottomBinding
            r2 = r9
            r3 = r5
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r9
        L_0x0034:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.commui.databinding.XesTabBottomBinding.bind(android.view.View):com.tal.app.thinkacademy.lib.commui.databinding.XesTabBottomBinding");
    }
}
