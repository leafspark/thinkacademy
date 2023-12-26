package com.tal.app.thinkacademy.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.common.R;

public final class LiveBusinessLayoutFlyGoldBinding implements ViewBinding {
    public final ImageView ivLine1Coin1;
    public final ImageView ivLine1Coin2;
    public final ImageView ivLine1Coin3;
    public final ImageView ivLine2Coin1;
    public final ImageView ivLine2Coin2;
    public final ImageView ivLine2Coin3;
    public final ImageView ivLine3Coin1;
    public final ImageView ivLine3Coin2;
    public final ImageView ivLine3Coin3;
    private final ConstraintLayout rootView;

    private LiveBusinessLayoutFlyGoldBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9) {
        this.rootView = constraintLayout;
        this.ivLine1Coin1 = imageView;
        this.ivLine1Coin2 = imageView2;
        this.ivLine1Coin3 = imageView3;
        this.ivLine2Coin1 = imageView4;
        this.ivLine2Coin2 = imageView5;
        this.ivLine2Coin3 = imageView6;
        this.ivLine3Coin1 = imageView7;
        this.ivLine3Coin2 = imageView8;
        this.ivLine3Coin3 = imageView9;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLayoutFlyGoldBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLayoutFlyGoldBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_layout_fly_gold;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessLayoutFlyGoldBinding bind(View view) {
        int i = R.id.iv_line1_coin1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_line1_coin2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_line1_coin3;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.iv_line2_coin1;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.iv_line2_coin2;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView5 != null) {
                            i = R.id.iv_line2_coin3;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView6 != null) {
                                i = R.id.iv_line3_coin1;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView7 != null) {
                                    i = R.id.iv_line3_coin2;
                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView8 != null) {
                                        i = R.id.iv_line3_coin3;
                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView9 != null) {
                                            return new LiveBusinessLayoutFlyGoldBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
