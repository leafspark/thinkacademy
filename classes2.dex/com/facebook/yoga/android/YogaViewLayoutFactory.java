package com.facebook.yoga.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class YogaViewLayoutFactory implements LayoutInflater.Factory {
    private static YogaViewLayoutFactory sYogaViewLayoutFactory;

    public static YogaViewLayoutFactory getInstance() {
        if (sYogaViewLayoutFactory == null) {
            sYogaViewLayoutFactory = new YogaViewLayoutFactory();
        }
        return sYogaViewLayoutFactory;
    }

    YogaViewLayoutFactory() {
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        Class<YogaLayout> cls = YogaLayout.class;
        if ("YogaLayout".equals(str)) {
            return new YogaLayout(context, attributeSet);
        }
        Class<VirtualYogaLayout> cls2 = VirtualYogaLayout.class;
        if ("VirtualYogaLayout".equals(str)) {
            return new VirtualYogaLayout(context, attributeSet);
        }
        return null;
    }
}
