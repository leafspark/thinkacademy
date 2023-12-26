package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundRelativeLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.shop.R;

public final class BusShopDialogPerfectInforBinding implements ViewBinding {
    public final EditText etDisplayName;
    public final EditText etNameOne;
    public final EditText etNameTwo;
    public final ImageView ivAvatar;
    public final ImageView ivClose;
    public final ImageView ivDisplayName;
    public final ImageView ivGrade;
    public final ImageView ivNameOne;
    public final ImageView ivNameTwo;
    public final RecyclerView recyclerView;
    public final RoundLinearLayout recyclerViewBg;
    public final RoundLinearLayout rlEditBg;
    public final RelativeLayout rlGrade;
    public final RelativeLayout rlTitle;
    private final RelativeLayout rootView;
    public final RoundRelativeLayout rvBg;
    public final RoundTextView tvContinue;
    public final TextView tvGrade;
    public final TextView tvId;
    public final TextView tvNameOne;
    public final TextView tvNameTwo;

    private BusShopDialogPerfectInforBinding(RelativeLayout relativeLayout, EditText editText, EditText editText2, EditText editText3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, RecyclerView recyclerView2, RoundLinearLayout roundLinearLayout, RoundLinearLayout roundLinearLayout2, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RoundRelativeLayout roundRelativeLayout, RoundTextView roundTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = relativeLayout;
        this.etDisplayName = editText;
        this.etNameOne = editText2;
        this.etNameTwo = editText3;
        this.ivAvatar = imageView;
        this.ivClose = imageView2;
        this.ivDisplayName = imageView3;
        this.ivGrade = imageView4;
        this.ivNameOne = imageView5;
        this.ivNameTwo = imageView6;
        this.recyclerView = recyclerView2;
        this.recyclerViewBg = roundLinearLayout;
        this.rlEditBg = roundLinearLayout2;
        this.rlGrade = relativeLayout2;
        this.rlTitle = relativeLayout3;
        this.rvBg = roundRelativeLayout;
        this.tvContinue = roundTextView;
        this.tvGrade = textView;
        this.tvId = textView2;
        this.tvNameOne = textView3;
        this.tvNameTwo = textView4;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BusShopDialogPerfectInforBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusShopDialogPerfectInforBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.bus_shop_dialog_perfect_infor;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.recyclerView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.recyclerViewBg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.rlEditBg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.rvBg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ab, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.tvContinue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogPerfectInforBinding bind(android.view.View r25) {
        /*
            r0 = r25
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.etDisplayName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.EditText r5 = (android.widget.EditText) r5
            if (r5 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.etNameOne
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.EditText r6 = (android.widget.EditText) r6
            if (r6 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.etNameTwo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.EditText r7 = (android.widget.EditText) r7
            if (r7 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.ivAvatar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.ivClose
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.ivDisplayName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.ivGrade
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.ivNameOne
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.ivNameTwo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.recyclerView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.recyclerview.widget.RecyclerView r14 = (androidx.recyclerview.widget.RecyclerView) r14
            if (r14 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.recyclerViewBg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            com.flyco.roundview.RoundLinearLayout r15 = (com.flyco.roundview.RoundLinearLayout) r15
            if (r15 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.rlEditBg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.flyco.roundview.RoundLinearLayout r16 = (com.flyco.roundview.RoundLinearLayout) r16
            if (r16 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.rlGrade
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.RelativeLayout r17 = (android.widget.RelativeLayout) r17
            if (r17 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.rlTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.RelativeLayout r18 = (android.widget.RelativeLayout) r18
            if (r18 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.rvBg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            com.flyco.roundview.RoundRelativeLayout r19 = (com.flyco.roundview.RoundRelativeLayout) r19
            if (r19 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tvContinue
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            com.flyco.roundview.RoundTextView r20 = (com.flyco.roundview.RoundTextView) r20
            if (r20 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tvGrade
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tvId
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tvNameOne
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tvNameTwo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x00f1
            com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogPerfectInforBinding r1 = new com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogPerfectInforBinding
            r3 = r1
            r4 = r0
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r1
        L_0x00f1:
            android.content.res.Resources r0 = r25.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogPerfectInforBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogPerfectInforBinding");
    }
}
