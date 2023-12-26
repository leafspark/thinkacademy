package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.shop.R;

public final class BusShopTeacherDetailsItemAchievementsBinding implements ViewBinding {
    public final RecyclerView recycleAchievements;
    public final RoundLinearLayout rlAchievements;
    private final RelativeLayout rootView;

    private BusShopTeacherDetailsItemAchievementsBinding(RelativeLayout relativeLayout, RecyclerView recyclerView, RoundLinearLayout roundLinearLayout) {
        this.rootView = relativeLayout;
        this.recycleAchievements = recyclerView;
        this.rlAchievements = roundLinearLayout;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BusShopTeacherDetailsItemAchievementsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusShopTeacherDetailsItemAchievementsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.bus_shop_teacher_details_item_achievements;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.rlAchievements;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.BusShopTeacherDetailsItemAchievementsBinding bind(android.view.View r3) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.recycleAchievements
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            if (r1 == 0) goto L_0x001c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.rlAchievements
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            com.flyco.roundview.RoundLinearLayout r2 = (com.flyco.roundview.RoundLinearLayout) r2
            if (r2 == 0) goto L_0x001c
            com.tal.app.thinkacademy.business.shop.databinding.BusShopTeacherDetailsItemAchievementsBinding r0 = new com.tal.app.thinkacademy.business.shop.databinding.BusShopTeacherDetailsItemAchievementsBinding
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.BusShopTeacherDetailsItemAchievementsBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.BusShopTeacherDetailsItemAchievementsBinding");
    }
}
