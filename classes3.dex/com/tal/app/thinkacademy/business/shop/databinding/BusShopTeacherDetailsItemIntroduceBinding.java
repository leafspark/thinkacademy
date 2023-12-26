package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.widget.view.AutoLineFeedLayout;

public final class BusShopTeacherDetailsItemIntroduceBinding implements ViewBinding {
    public final AutoLineFeedLayout autoLineFeedLayout;
    public final ImageView ivTeacher;
    private final RoundLinearLayout rootView;
    public final TextView tvIntroduce;
    public final TextView tvTeacherName;
    public final TextView tvTeacherUni;

    private BusShopTeacherDetailsItemIntroduceBinding(RoundLinearLayout roundLinearLayout, AutoLineFeedLayout autoLineFeedLayout2, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = roundLinearLayout;
        this.autoLineFeedLayout = autoLineFeedLayout2;
        this.ivTeacher = imageView;
        this.tvIntroduce = textView;
        this.tvTeacherName = textView2;
        this.tvTeacherUni = textView3;
    }

    public RoundLinearLayout getRoot() {
        return this.rootView;
    }

    public static BusShopTeacherDetailsItemIntroduceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusShopTeacherDetailsItemIntroduceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.bus_shop_teacher_details_item_introduce;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BusShopTeacherDetailsItemIntroduceBinding bind(View view) {
        int i = R.id.autoLineFeedLayout;
        AutoLineFeedLayout autoLineFeedLayout2 = (AutoLineFeedLayout) ViewBindings.findChildViewById(view, i);
        if (autoLineFeedLayout2 != null) {
            i = R.id.ivTeacher;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.tvIntroduce;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tvTeacherName;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tvTeacherUni;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new BusShopTeacherDetailsItemIntroduceBinding((RoundLinearLayout) view, autoLineFeedLayout2, imageView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
