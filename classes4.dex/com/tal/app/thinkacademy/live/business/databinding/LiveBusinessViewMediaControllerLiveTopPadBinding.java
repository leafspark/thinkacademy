package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessViewMediaControllerLiveTopPadBinding implements ViewBinding {
    public final ImageView imgLiveBusinessLiveScreenshot;
    public final ImageView ivMediaControllerBack;
    public final ImageView ivMediaControllerExamReport;
    public final ImageView ivMediaControllerFeedback;
    public final ImageView ivMediaControllerMore;
    public final ImageView ivMediaControllerNetwork;
    public final ImageView ivMediaControllerRefresh;
    public final ImageView ivMediaControllerSwitchLine;
    public final RelativeLayout layoutMediaControllerHomework;
    public final LinearLayout rlMediaControllerRootTop;
    private final LinearLayout rootView;
    public final RoundTextView tvMediaControllerHomeworkDot;
    public final TextView tvMediaControllerTitle;

    private LiveBusinessViewMediaControllerLiveTopPadBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, RelativeLayout relativeLayout, LinearLayout linearLayout2, RoundTextView roundTextView, TextView textView) {
        this.rootView = linearLayout;
        this.imgLiveBusinessLiveScreenshot = imageView;
        this.ivMediaControllerBack = imageView2;
        this.ivMediaControllerExamReport = imageView3;
        this.ivMediaControllerFeedback = imageView4;
        this.ivMediaControllerMore = imageView5;
        this.ivMediaControllerNetwork = imageView6;
        this.ivMediaControllerRefresh = imageView7;
        this.ivMediaControllerSwitchLine = imageView8;
        this.layoutMediaControllerHomework = relativeLayout;
        this.rlMediaControllerRootTop = linearLayout2;
        this.tvMediaControllerHomeworkDot = roundTextView;
        this.tvMediaControllerTitle = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessViewMediaControllerLiveTopPadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessViewMediaControllerLiveTopPadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_view_media_controller_live_top_pad;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessViewMediaControllerLiveTopPadBinding bind(View view) {
        View view2 = view;
        int i = R.id.img_live_business_live_screenshot;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
        if (imageView != null) {
            i = R.id.iv_media_controller_back;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
            if (imageView2 != null) {
                i = R.id.iv_media_controller_exam_report;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                if (imageView3 != null) {
                    i = R.id.iv_media_controller_feedback;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i);
                    if (imageView4 != null) {
                        i = R.id.iv_media_controller_more;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, i);
                        if (imageView5 != null) {
                            i = R.id.iv_media_controller_network;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, i);
                            if (imageView6 != null) {
                                i = R.id.iv_media_controller_refresh;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                if (imageView7 != null) {
                                    i = R.id.iv_media_controller_switch_line;
                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                    if (imageView8 != null) {
                                        i = R.id.layout_media_controller_homework;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
                                        if (relativeLayout != null) {
                                            LinearLayout linearLayout = (LinearLayout) view2;
                                            i = R.id.tv_media_controller_homework_dot;
                                            RoundTextView findChildViewById = ViewBindings.findChildViewById(view2, i);
                                            if (findChildViewById != null) {
                                                i = R.id.tv_media_controller_title;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                                                if (textView != null) {
                                                    return new LiveBusinessViewMediaControllerLiveTopPadBinding(linearLayout, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, relativeLayout, linearLayout, findChildViewById, textView);
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
