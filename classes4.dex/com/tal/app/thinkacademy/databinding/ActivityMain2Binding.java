package com.tal.app.thinkacademy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;

public final class ActivityMain2Binding implements ViewBinding {
    public final Button buttonChangeLanguage;
    public final Button buttonFragment;
    public final Button buttonWebview;
    public final ImageView ivTest;
    public final ImageView ivTest2;
    public final ImageView ivTest3;
    public final Button loginBtn;
    private final ConstraintLayout rootView;
    public final Button testBtn;
    public final Button testBtnBack;
    public final TitleBar titleBar;

    private ActivityMain2Binding(ConstraintLayout constraintLayout, Button button, Button button2, Button button3, ImageView imageView, ImageView imageView2, ImageView imageView3, Button button4, Button button5, Button button6, TitleBar titleBar2) {
        this.rootView = constraintLayout;
        this.buttonChangeLanguage = button;
        this.buttonFragment = button2;
        this.buttonWebview = button3;
        this.ivTest = imageView;
        this.ivTest2 = imageView2;
        this.ivTest3 = imageView3;
        this.loginBtn = button4;
        this.testBtn = button5;
        this.testBtnBack = button6;
        this.titleBar = titleBar2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMain2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMain2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(2131492936, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, 2131492936, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMain2Binding bind(View view) {
        int i = 2131296485;
        Button button = (Button) ViewBindings.findChildViewById(view, 2131296485);
        if (button != null) {
            i = 2131296487;
            Button button2 = (Button) ViewBindings.findChildViewById(view, 2131296487);
            if (button2 != null) {
                i = 2131296490;
                Button button3 = (Button) ViewBindings.findChildViewById(view, 2131296490);
                if (button3 != null) {
                    i = 2131297263;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, 2131297263);
                    if (imageView != null) {
                        i = 2131297264;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, 2131297264);
                        if (imageView2 != null) {
                            i = 2131297265;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, 2131297265);
                            if (imageView3 != null) {
                                i = 2131297582;
                                Button button4 = (Button) ViewBindings.findChildViewById(view, 2131297582);
                                if (button4 != null) {
                                    i = 2131298268;
                                    Button button5 = (Button) ViewBindings.findChildViewById(view, 2131298268);
                                    if (button5 != null) {
                                        i = 2131298269;
                                        Button button6 = (Button) ViewBindings.findChildViewById(view, 2131298269);
                                        if (button6 != null) {
                                            i = 2131298319;
                                            TitleBar titleBar2 = (TitleBar) ViewBindings.findChildViewById(view, 2131298319);
                                            if (titleBar2 != null) {
                                                return new ActivityMain2Binding((ConstraintLayout) view, button, button2, button3, imageView, imageView2, imageView3, button4, button5, button6, titleBar2);
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
