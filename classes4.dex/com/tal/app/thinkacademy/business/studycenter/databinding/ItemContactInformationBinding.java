package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class ItemContactInformationBinding implements ViewBinding {
    public final LinearLayout accountLayout;
    public final RoundLinearLayout contactItemRoot;
    public final ImageView imageViewCopyCommon;
    public final ImageView ivContactInfo;
    public final ImageView ivCopyTwo;
    public final ImageView ivQRCode;
    public final ImageView ivTakeASweep;
    public final LinearLayout qrDescLayout;
    private final RoundLinearLayout rootView;
    public final TextView textViewCopyCommon;
    public final TextView tvAccountNumber;
    public final TextView wechatCopyDesc;
    public final LinearLayout wechatCopyLayout;

    private ItemContactInformationBinding(RoundLinearLayout roundLinearLayout, LinearLayout linearLayout, RoundLinearLayout roundLinearLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout3) {
        this.rootView = roundLinearLayout;
        this.accountLayout = linearLayout;
        this.contactItemRoot = roundLinearLayout2;
        this.imageViewCopyCommon = imageView;
        this.ivContactInfo = imageView2;
        this.ivCopyTwo = imageView3;
        this.ivQRCode = imageView4;
        this.ivTakeASweep = imageView5;
        this.qrDescLayout = linearLayout2;
        this.textViewCopyCommon = textView;
        this.tvAccountNumber = textView2;
        this.wechatCopyDesc = textView3;
        this.wechatCopyLayout = linearLayout3;
    }

    public RoundLinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemContactInformationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemContactInformationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_contact_information;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemContactInformationBinding bind(View view) {
        View view2 = view;
        int i = R.id.accountLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
        if (linearLayout != null) {
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) view2;
            i = R.id.imageViewCopyCommon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
            if (imageView != null) {
                i = R.id.ivContactInfo;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                if (imageView2 != null) {
                    i = R.id.ivCopyTwo;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                    if (imageView3 != null) {
                        i = R.id.ivQRCode;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i);
                        if (imageView4 != null) {
                            i = R.id.ivTakeASweep;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, i);
                            if (imageView5 != null) {
                                i = R.id.qrDescLayout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                if (linearLayout2 != null) {
                                    i = R.id.textViewCopyCommon;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                                    if (textView != null) {
                                        i = R.id.tvAccountNumber;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView2 != null) {
                                            i = R.id.wechatCopyDesc;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                            if (textView3 != null) {
                                                i = R.id.wechatCopyLayout;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                if (linearLayout3 != null) {
                                                    return new ItemContactInformationBinding(roundLinearLayout, linearLayout, roundLinearLayout, imageView, imageView2, imageView3, imageView4, imageView5, linearLayout2, textView, textView2, textView3, linearLayout3);
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
