package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessStudentvideoAuditorBinding implements ViewBinding {
    public final RelativeLayout flLiveBusinessStudent2;
    public final RelativeLayout flLiveBusinessStudent3;
    public final RelativeLayout flLiveBusinessStudent4;
    public final ImageView ivLiveBusinessHead2;
    public final ImageView ivLiveBusinessHead3;
    public final ImageView ivLiveBusinessHead4;
    public final ImageView ivLiveBusinessLevel2;
    public final ImageView ivLiveBusinessLevel3;
    public final ImageView ivLiveBusinessLevel4;
    public final RelativeLayout rlLiveBusinessHeadParent2;
    public final RelativeLayout rlLiveBusinessHeadParent3;
    public final RelativeLayout rlLiveBusinessHeadParent4;
    public final RelativeLayout rlLiveBusinessStudent1;
    public final RelativeLayout rlLiveBusinessStudent2;
    public final RelativeLayout rlLiveBusinessStudent3;
    public final RelativeLayout rlLiveBusinessStudent4;
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessName2;
    public final TextView tvLiveBusinessName3;
    public final TextView tvLiveBusinessName4;

    private LiveBusinessStudentvideoAuditorBinding(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.flLiveBusinessStudent2 = relativeLayout;
        this.flLiveBusinessStudent3 = relativeLayout2;
        this.flLiveBusinessStudent4 = relativeLayout3;
        this.ivLiveBusinessHead2 = imageView;
        this.ivLiveBusinessHead3 = imageView2;
        this.ivLiveBusinessHead4 = imageView3;
        this.ivLiveBusinessLevel2 = imageView4;
        this.ivLiveBusinessLevel3 = imageView5;
        this.ivLiveBusinessLevel4 = imageView6;
        this.rlLiveBusinessHeadParent2 = relativeLayout4;
        this.rlLiveBusinessHeadParent3 = relativeLayout5;
        this.rlLiveBusinessHeadParent4 = relativeLayout6;
        this.rlLiveBusinessStudent1 = relativeLayout7;
        this.rlLiveBusinessStudent2 = relativeLayout8;
        this.rlLiveBusinessStudent3 = relativeLayout9;
        this.rlLiveBusinessStudent4 = relativeLayout10;
        this.tvLiveBusinessName2 = textView;
        this.tvLiveBusinessName3 = textView2;
        this.tvLiveBusinessName4 = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessStudentvideoAuditorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessStudentvideoAuditorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_studentvideo_auditor;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessStudentvideoAuditorBinding bind(View view) {
        View view2 = view;
        int i = R.id.fl_live_business_student_2;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
        if (relativeLayout != null) {
            i = R.id.fl_live_business_student_3;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
            if (relativeLayout2 != null) {
                i = R.id.fl_live_business_student_4;
                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
                if (relativeLayout3 != null) {
                    i = R.id.iv_live_business_head2;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
                    if (imageView != null) {
                        i = R.id.iv_live_business_head3;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                        if (imageView2 != null) {
                            i = R.id.iv_live_business_head4;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                            if (imageView3 != null) {
                                i = R.id.iv_live_business_level_2;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                if (imageView4 != null) {
                                    i = R.id.iv_live_business_level_3;
                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                    if (imageView5 != null) {
                                        i = R.id.iv_live_business_level_4;
                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                        if (imageView6 != null) {
                                            i = R.id.rl_live_business_head_parent2;
                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
                                            if (relativeLayout4 != null) {
                                                i = R.id.rl_live_business_head_parent3;
                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
                                                if (relativeLayout5 != null) {
                                                    i = R.id.rl_live_business_head_parent4;
                                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
                                                    if (relativeLayout6 != null) {
                                                        i = R.id.rl_live_business_student_1;
                                                        RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
                                                        if (relativeLayout7 != null) {
                                                            i = R.id.rl_live_business_student_2;
                                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
                                                            if (relativeLayout8 != null) {
                                                                i = R.id.rl_live_business_student_3;
                                                                RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
                                                                if (relativeLayout9 != null) {
                                                                    i = R.id.rl_live_business_student_4;
                                                                    RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
                                                                    if (relativeLayout10 != null) {
                                                                        i = R.id.tv_live_business_name_2;
                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                        if (textView != null) {
                                                                            i = R.id.tv_live_business_name_3;
                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                            if (textView2 != null) {
                                                                                i = R.id.tv_live_business_name_4;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                if (textView3 != null) {
                                                                                    return new LiveBusinessStudentvideoAuditorBinding((ConstraintLayout) view2, relativeLayout, relativeLayout2, relativeLayout3, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, relativeLayout10, textView, textView2, textView3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
