package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;

public final class ShopCourseHighlightsDialogLayoutBinding implements ViewBinding {
    public final ImageView dialogClose;
    public final RecyclerView dialogRecyclerview;
    public final TextView dialogTitle;
    private final ConstraintLayout rootView;

    private ShopCourseHighlightsDialogLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, TextView textView) {
        this.rootView = constraintLayout;
        this.dialogClose = imageView;
        this.dialogRecyclerview = recyclerView;
        this.dialogTitle = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ShopCourseHighlightsDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShopCourseHighlightsDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.shop_course_highlights_dialog_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_recyclerview;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.ShopCourseHighlightsDialogLayoutBinding bind(android.view.View r4) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0026
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_recyclerview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            androidx.recyclerview.widget.RecyclerView r2 = (androidx.recyclerview.widget.RecyclerView) r2
            if (r2 == 0) goto L_0x0026
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_title
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r3 == 0) goto L_0x0026
            com.tal.app.thinkacademy.business.shop.databinding.ShopCourseHighlightsDialogLayoutBinding r0 = new com.tal.app.thinkacademy.business.shop.databinding.ShopCourseHighlightsDialogLayoutBinding
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.ShopCourseHighlightsDialogLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.ShopCourseHighlightsDialogLayoutBinding");
    }
}
