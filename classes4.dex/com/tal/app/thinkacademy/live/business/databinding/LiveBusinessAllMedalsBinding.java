package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessAllMedalsBinding implements ViewBinding {
    public final RoundLinearLayout liveBusinessMedalsLayoutCoins;
    public final ImageView medalsIvClose;
    public final ImageView medalsIvIndicator1;
    public final ImageView medalsIvIndicator2;
    public final ImageView medalsIvIndicator3;
    public final ImageView medalsIvIndicator4;
    public final ImageView medalsIvIndicator5;
    public final ImageView medalsIvIndicator6;
    public final ImageView medalsIvMedal1;
    public final ImageView medalsIvMedal2;
    public final ImageView medalsIvMedal3;
    public final ImageView medalsIvMedal4;
    public final ImageView medalsIvMedal5;
    public final ImageView medalsIvMedal6;
    public final ImageView medalsIvMedal7;
    public final TextView medalsTvCurrentCoins;
    public final TextView medalsTvTip;
    public final TextView medalsTvTotalCoins;
    private final ConstraintLayout rootView;

    private LiveBusinessAllMedalsBinding(ConstraintLayout constraintLayout, RoundLinearLayout roundLinearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, ImageView imageView14, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.liveBusinessMedalsLayoutCoins = roundLinearLayout;
        this.medalsIvClose = imageView;
        this.medalsIvIndicator1 = imageView2;
        this.medalsIvIndicator2 = imageView3;
        this.medalsIvIndicator3 = imageView4;
        this.medalsIvIndicator4 = imageView5;
        this.medalsIvIndicator5 = imageView6;
        this.medalsIvIndicator6 = imageView7;
        this.medalsIvMedal1 = imageView8;
        this.medalsIvMedal2 = imageView9;
        this.medalsIvMedal3 = imageView10;
        this.medalsIvMedal4 = imageView11;
        this.medalsIvMedal5 = imageView12;
        this.medalsIvMedal6 = imageView13;
        this.medalsIvMedal7 = imageView14;
        this.medalsTvCurrentCoins = textView;
        this.medalsTvTip = textView2;
        this.medalsTvTotalCoins = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessAllMedalsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessAllMedalsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_all_medals;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessAllMedalsBinding bind(View view) {
        View view2 = view;
        int i = R.id.live_business_medals_layout_coins;
        RoundLinearLayout findChildViewById = ViewBindings.findChildViewById(view2, i);
        if (findChildViewById != null) {
            i = R.id.medals_iv_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
            if (imageView != null) {
                i = R.id.medals_iv_indicator1;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                if (imageView2 != null) {
                    i = R.id.medals_iv_indicator2;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                    if (imageView3 != null) {
                        i = R.id.medals_iv_indicator3;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i);
                        if (imageView4 != null) {
                            i = R.id.medals_iv_indicator4;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, i);
                            if (imageView5 != null) {
                                i = R.id.medals_iv_indicator5;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                if (imageView6 != null) {
                                    i = R.id.medals_iv_indicator6;
                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                    if (imageView7 != null) {
                                        i = R.id.medals_iv_medal1;
                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                        if (imageView8 != null) {
                                            i = R.id.medals_iv_medal2;
                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                            if (imageView9 != null) {
                                                i = R.id.medals_iv_medal3;
                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                if (imageView10 != null) {
                                                    i = R.id.medals_iv_medal4;
                                                    ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                    if (imageView11 != null) {
                                                        i = R.id.medals_iv_medal5;
                                                        ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                        if (imageView12 != null) {
                                                            i = R.id.medals_iv_medal6;
                                                            ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                            if (imageView13 != null) {
                                                                i = R.id.medals_iv_medal7;
                                                                ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                if (imageView14 != null) {
                                                                    i = R.id.medals_tv_current_coins;
                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                    if (textView != null) {
                                                                        i = R.id.medals_tv_tip;
                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                        if (textView2 != null) {
                                                                            i = R.id.medals_tv_total_coins;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                            if (textView3 != null) {
                                                                                return new LiveBusinessAllMedalsBinding((ConstraintLayout) view2, findChildViewById, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14, textView, textView2, textView3);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
