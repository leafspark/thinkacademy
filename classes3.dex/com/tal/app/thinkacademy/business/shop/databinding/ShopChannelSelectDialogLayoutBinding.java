package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;

public final class ShopChannelSelectDialogLayoutBinding implements ViewBinding {
    public final ImageView btnClose;
    public final TextView channelDialogTitle;
    public final ConstraintLayout dialogRoot;
    public final RelativeLayout dialogTop;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;

    private ShopChannelSelectDialogLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2, RelativeLayout relativeLayout, RecyclerView recyclerView2) {
        this.rootView = constraintLayout;
        this.btnClose = imageView;
        this.channelDialogTitle = textView;
        this.dialogRoot = constraintLayout2;
        this.dialogTop = relativeLayout;
        this.recyclerView = recyclerView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ShopChannelSelectDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShopChannelSelectDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.shop_channel_select_dialog_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.recyclerView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.ShopChannelSelectDialogLayoutBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.btn_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0037
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.channel_dialog_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0037
            r6 = r9
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_top
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            if (r7 == 0) goto L_0x0037
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.recyclerView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            if (r8 == 0) goto L_0x0037
            com.tal.app.thinkacademy.business.shop.databinding.ShopChannelSelectDialogLayoutBinding r9 = new com.tal.app.thinkacademy.business.shop.databinding.ShopChannelSelectDialogLayoutBinding
            r2 = r9
            r3 = r6
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r9
        L_0x0037:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.ShopChannelSelectDialogLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.ShopChannelSelectDialogLayoutBinding");
    }
}
