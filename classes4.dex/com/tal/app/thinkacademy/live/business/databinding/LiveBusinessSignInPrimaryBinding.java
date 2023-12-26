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
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessSignInPrimaryBinding implements ViewBinding {
    public final ImageView ivPageLivevideoSignInToast;
    public final TextView ivSigninButton;
    public final LinearLayout liveBusinessSigninBackground;
    public final LinearLayout liveBusinessSigninBackgroundResult;
    public final ImageView liveBusinessSigninClose;
    public final RelativeLayout rootRelativeSignInLayout;
    private final RelativeLayout rootView;
    public final TextView tvPageLivevideoSignInToast;

    private LiveBusinessSignInPrimaryBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView2, RelativeLayout relativeLayout2, TextView textView2) {
        this.rootView = relativeLayout;
        this.ivPageLivevideoSignInToast = imageView;
        this.ivSigninButton = textView;
        this.liveBusinessSigninBackground = linearLayout;
        this.liveBusinessSigninBackgroundResult = linearLayout2;
        this.liveBusinessSigninClose = imageView2;
        this.rootRelativeSignInLayout = relativeLayout2;
        this.tvPageLivevideoSignInToast = textView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessSignInPrimaryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessSignInPrimaryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_sign_in_primary;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessSignInPrimaryBinding bind(View view) {
        int i = R.id.iv_page_livevideo_sign_in_toast;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_signin_button;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.live_business_signin_background;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.live_business_signin_background_result;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.live_business_signin_close;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) view;
                            i = R.id.tv_page_livevideo_sign_in_toast;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new LiveBusinessSignInPrimaryBinding(relativeLayout, imageView, textView, linearLayout, linearLayout2, imageView2, relativeLayout, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
