package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class ItemStudyTestingBinding implements ViewBinding {
    public final ImageView ivDeviceTestClose;
    private final RoundRelativeLayout rootView;
    public final RoundTextView tvDeviceTest;
    public final TextView tvDeviceTestTitle;

    private ItemStudyTestingBinding(RoundRelativeLayout roundRelativeLayout, ImageView imageView, RoundTextView roundTextView, TextView textView) {
        this.rootView = roundRelativeLayout;
        this.ivDeviceTestClose = imageView;
        this.tvDeviceTest = roundTextView;
        this.tvDeviceTestTitle = textView;
    }

    public RoundRelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemStudyTestingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemStudyTestingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_study_testing;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvDeviceTest;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyTestingBinding bind(android.view.View r4) {
        /*
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.ivDeviceTestClose
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0026
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvDeviceTest
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            com.flyco.roundview.RoundTextView r2 = (com.flyco.roundview.RoundTextView) r2
            if (r2 == 0) goto L_0x0026
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvDeviceTestTitle
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r3 == 0) goto L_0x0026
            com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyTestingBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyTestingBinding
            com.flyco.roundview.RoundRelativeLayout r4 = (com.flyco.roundview.RoundRelativeLayout) r4
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyTestingBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyTestingBinding");
    }
}
