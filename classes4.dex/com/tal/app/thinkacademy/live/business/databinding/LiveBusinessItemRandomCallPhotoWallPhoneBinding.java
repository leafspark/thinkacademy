package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundFrameLayout;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessItemRandomCallPhotoWallPhoneBinding implements ViewBinding {
    public final ImageView ivUserAvatar;
    public final TextView ivUserName;
    public final RelativeLayout rlStudentRoot;
    public final RelativeLayout rlUserAvatar;
    public final RoundFrameLayout rootView;
    private final RoundFrameLayout rootView_;
    public final FrameLayout studentVideoContainer;

    private LiveBusinessItemRandomCallPhotoWallPhoneBinding(RoundFrameLayout roundFrameLayout, ImageView imageView, TextView textView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RoundFrameLayout roundFrameLayout2, FrameLayout frameLayout) {
        this.rootView_ = roundFrameLayout;
        this.ivUserAvatar = imageView;
        this.ivUserName = textView;
        this.rlStudentRoot = relativeLayout;
        this.rlUserAvatar = relativeLayout2;
        this.rootView = roundFrameLayout2;
        this.studentVideoContainer = frameLayout;
    }

    public RoundFrameLayout getRoot() {
        return this.rootView_;
    }

    public static LiveBusinessItemRandomCallPhotoWallPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessItemRandomCallPhotoWallPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_item_random_call_photo_wall_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessItemRandomCallPhotoWallPhoneBinding bind(View view) {
        int i = R.id.iv_user_avatar;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_user_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.rl_student_root;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.rl_user_avatar;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        RoundFrameLayout roundFrameLayout = (RoundFrameLayout) view;
                        i = R.id.student_video_container;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            return new LiveBusinessItemRandomCallPhotoWallPhoneBinding(roundFrameLayout, imageView, textView, relativeLayout, relativeLayout2, roundFrameLayout, frameLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
