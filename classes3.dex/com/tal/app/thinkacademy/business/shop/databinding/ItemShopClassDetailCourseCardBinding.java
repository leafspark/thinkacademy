package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.widget.view.StateTextView;

public final class ItemShopClassDetailCourseCardBinding implements ViewBinding {
    public final LinearLayout layoutClassDifficulty;
    public final ImageView priceDescBtn;
    public final AppCompatRatingBar ratingbarClassDifficulty;
    private final ConstraintLayout rootView;
    public final TextView totalLessonAndRemain;
    public final TextView tvClassAddress;
    public final TextView tvClassDate;
    public final TextView tvClassDifficulty;
    public final TextView tvClassForm;
    public final TextView tvClassPhoneNum;
    public final TextView tvClassSpace;
    public final TextView tvClassTime;
    public final TextView tvOrgPrice;
    public final StateTextView tvPriceCompany;
    public final StateTextView tvShowPrice;
    public final RoundTextView vatInfoDescription;

    private ItemShopClassDetailCourseCardBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageView imageView, AppCompatRatingBar appCompatRatingBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, StateTextView stateTextView, StateTextView stateTextView2, RoundTextView roundTextView) {
        this.rootView = constraintLayout;
        this.layoutClassDifficulty = linearLayout;
        this.priceDescBtn = imageView;
        this.ratingbarClassDifficulty = appCompatRatingBar;
        this.totalLessonAndRemain = textView;
        this.tvClassAddress = textView2;
        this.tvClassDate = textView3;
        this.tvClassDifficulty = textView4;
        this.tvClassForm = textView5;
        this.tvClassPhoneNum = textView6;
        this.tvClassSpace = textView7;
        this.tvClassTime = textView8;
        this.tvOrgPrice = textView9;
        this.tvPriceCompany = stateTextView;
        this.tvShowPrice = stateTextView2;
        this.vatInfoDescription = roundTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemShopClassDetailCourseCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemShopClassDetailCourseCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_shop_class_detail_course_card;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.vat_info_description;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.ratingbar_class_difficulty;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.ItemShopClassDetailCourseCardBinding bind(android.view.View r20) {
        /*
            r0 = r20
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.layout_class_difficulty
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.price_desc_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.ratingbar_class_difficulty
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.appcompat.widget.AppCompatRatingBar r7 = (androidx.appcompat.widget.AppCompatRatingBar) r7
            if (r7 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.total_lesson_and_remain
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_address
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_date
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_difficulty
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_form
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_phone_num
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_space
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_time
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tv_org_price
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tv_price_company
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            com.tal.app.thinkacademy.business.shop.widget.view.StateTextView r17 = (com.tal.app.thinkacademy.business.shop.widget.view.StateTextView) r17
            if (r17 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tv_show_price
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            com.tal.app.thinkacademy.business.shop.widget.view.StateTextView r18 = (com.tal.app.thinkacademy.business.shop.widget.view.StateTextView) r18
            if (r18 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.vat_info_description
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            com.flyco.roundview.RoundTextView r19 = (com.flyco.roundview.RoundTextView) r19
            if (r19 == 0) goto L_0x00b5
            com.tal.app.thinkacademy.business.shop.databinding.ItemShopClassDetailCourseCardBinding r1 = new com.tal.app.thinkacademy.business.shop.databinding.ItemShopClassDetailCourseCardBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        L_0x00b5:
            android.content.res.Resources r0 = r20.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.ItemShopClassDetailCourseCardBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.ItemShopClassDetailCourseCardBinding");
    }
}
