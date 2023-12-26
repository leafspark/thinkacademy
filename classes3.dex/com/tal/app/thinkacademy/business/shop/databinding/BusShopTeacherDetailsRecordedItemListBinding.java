package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import java.util.Objects;

public final class BusShopTeacherDetailsRecordedItemListBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private BusShopTeacherDetailsRecordedItemListBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BusShopTeacherDetailsRecordedItemListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusShopTeacherDetailsRecordedItemListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.bus_shop_teacher_details_recorded_item_list;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BusShopTeacherDetailsRecordedItemListBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new BusShopTeacherDetailsRecordedItemListBinding((ConstraintLayout) view);
    }
}