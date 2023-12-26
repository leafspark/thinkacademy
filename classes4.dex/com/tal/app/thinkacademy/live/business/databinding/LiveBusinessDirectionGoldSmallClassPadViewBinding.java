package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.direction.PlugGoldView;
import org.libpag.PAGImageView;

public final class LiveBusinessDirectionGoldSmallClassPadViewBinding implements ViewBinding {
    public final ConstraintLayout layout;
    public final PlugGoldView layoutCoins;
    public final LinearLayout layoutName;
    public final PAGImageView pagConis;
    private final ConstraintLayout rootView;
    public final TextView tvName;

    private LiveBusinessDirectionGoldSmallClassPadViewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, PlugGoldView plugGoldView, LinearLayout linearLayout, PAGImageView pAGImageView, TextView textView) {
        this.rootView = constraintLayout;
        this.layout = constraintLayout2;
        this.layoutCoins = plugGoldView;
        this.layoutName = linearLayout;
        this.pagConis = pAGImageView;
        this.tvName = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessDirectionGoldSmallClassPadViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessDirectionGoldSmallClassPadViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_direction_gold_small_class_pad_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.pag_conis;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldSmallClassPadViewBinding bind(android.view.View r7) {
        /*
            r2 = r7
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_coins
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            r3 = r1
            com.tal.app.thinkacademy.live.business.direction.PlugGoldView r3 = (com.tal.app.thinkacademy.live.business.direction.PlugGoldView) r3
            if (r3 == 0) goto L_0x0037
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_name
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            r4 = r1
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x0037
            int r0 = com.tal.app.thinkacademy.live.business.R.id.pag_conis
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            r5 = r1
            org.libpag.PAGImageView r5 = (org.libpag.PAGImageView) r5
            if (r5 == 0) goto L_0x0037
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_name
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0037
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldSmallClassPadViewBinding r7 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldSmallClassPadViewBinding
            r0 = r7
            r1 = r2
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r7
        L_0x0037:
            android.content.res.Resources r7 = r7.getResources()
            java.lang.String r7 = r7.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldSmallClassPadViewBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldSmallClassPadViewBinding");
    }
}
