package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessVideocallLayoutBinding implements ViewBinding {
    public final TextView liveBusinessVideoCallBt;
    public final TextView liveBusinessVideoCallCourseName;
    public final ImageView liveBusinessVideoCallIcon;
    public final ImageView liveBusinessVideoCallIconSmall;
    public final TextView liveBusinessVideoCallJoin;
    public final TextView liveBusinessVideoCallName;
    public final TextView liveBusinessVideoCallNameSmall;
    public final ImageView liveBusinessVideoCallPhoto;
    public final TextView liveBusinessVideoCallPhotoBg;
    public final TextView liveBusinessVideoCallWait;
    public final LinearLayout liveBusinessVideoSmallLayout;
    public final ImageView liveBusinessVideoTobig;
    public final ImageView liveBusinessVideoTosmall;
    public final RelativeLayout rlLiveBusinessVideocallVideo1;
    public final FrameLayout rlLiveBusinessVideocallVideo2;
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessVideoCallAction;

    private LiveBusinessVideocallLayoutBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, TextView textView3, TextView textView4, TextView textView5, ImageView imageView3, TextView textView6, TextView textView7, LinearLayout linearLayout, ImageView imageView4, ImageView imageView5, RelativeLayout relativeLayout, FrameLayout frameLayout, TextView textView8) {
        this.rootView = constraintLayout;
        this.liveBusinessVideoCallBt = textView;
        this.liveBusinessVideoCallCourseName = textView2;
        this.liveBusinessVideoCallIcon = imageView;
        this.liveBusinessVideoCallIconSmall = imageView2;
        this.liveBusinessVideoCallJoin = textView3;
        this.liveBusinessVideoCallName = textView4;
        this.liveBusinessVideoCallNameSmall = textView5;
        this.liveBusinessVideoCallPhoto = imageView3;
        this.liveBusinessVideoCallPhotoBg = textView6;
        this.liveBusinessVideoCallWait = textView7;
        this.liveBusinessVideoSmallLayout = linearLayout;
        this.liveBusinessVideoTobig = imageView4;
        this.liveBusinessVideoTosmall = imageView5;
        this.rlLiveBusinessVideocallVideo1 = relativeLayout;
        this.rlLiveBusinessVideocallVideo2 = frameLayout;
        this.tvLiveBusinessVideoCallAction = textView8;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessVideocallLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessVideocallLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_videocall_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessVideocallLayoutBinding bind(View view) {
        View view2 = view;
        int i = R.id.live_business_video_call_bt;
        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
        if (textView != null) {
            i = R.id.live_business_video_call_course_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
            if (textView2 != null) {
                i = R.id.live_business_video_call_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
                if (imageView != null) {
                    i = R.id.live_business_video_call_icon_small;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                    if (imageView2 != null) {
                        i = R.id.live_business_video_call_join;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                        if (textView3 != null) {
                            i = R.id.live_business_video_call_name;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView4 != null) {
                                i = R.id.live_business_video_call_name_small;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                if (textView5 != null) {
                                    i = R.id.live_business_video_call_photo;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                    if (imageView3 != null) {
                                        i = R.id.live_business_video_call_photo_bg;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView6 != null) {
                                            i = R.id.live_business_video_call_wait;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                            if (textView7 != null) {
                                                i = R.id.live_business_video_small_layout;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                if (linearLayout != null) {
                                                    i = R.id.live_business_video_tobig;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                    if (imageView4 != null) {
                                                        i = R.id.live_business_video_tosmall;
                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                        if (imageView5 != null) {
                                                            i = R.id.rl_live_business_videocall_video_1;
                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
                                                            if (relativeLayout != null) {
                                                                i = R.id.rl_live_business_videocall_video_2;
                                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                                                                if (frameLayout != null) {
                                                                    i = R.id.tv_live_business_video_call_action;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                    if (textView8 != null) {
                                                                        return new LiveBusinessVideocallLayoutBinding((ConstraintLayout) view2, textView, textView2, imageView, imageView2, textView3, textView4, textView5, imageView3, textView6, textView7, linearLayout, imageView4, imageView5, relativeLayout, frameLayout, textView8);
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
