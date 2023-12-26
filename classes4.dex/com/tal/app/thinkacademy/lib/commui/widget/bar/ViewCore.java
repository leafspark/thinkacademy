package com.tal.app.thinkacademy.lib.commui.widget.bar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

final class ViewCore {
    ViewCore() {
    }

    static LinearLayout newMainLayout(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return linearLayout;
    }

    static View newLineView(Context context) {
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, 1, 80));
        return view;
    }

    static TextView newLeftView(Context context) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        textView.setGravity(16);
        textView.setFocusable(true);
        textView.setClickable(true);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    static TextView newTitleView(Context context) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        textView.setGravity(17);
        textView.setFocusable(true);
        textView.setSingleLine();
        if (Build.VERSION.SDK_INT >= 2) {
            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            textView.setMarqueeRepeatLimit(-1);
            textView.setSelected(true);
        } else {
            textView.setEllipsize(TextUtils.TruncateAt.END);
        }
        return textView;
    }

    static TextView newRightView(Context context) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        textView.setGravity(16);
        textView.setFocusable(true);
        textView.setClickable(true);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    static boolean hasTextViewContent(TextView textView) {
        if (!"".equals(textView.getText().toString())) {
            return true;
        }
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                return true;
            }
        }
        return false;
    }

    static Drawable getDrawable(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        return context.getResources().getDrawable(i);
    }

    static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
