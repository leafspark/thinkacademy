package com.tal.app.thinkacademy.lib.commui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class MarqueeText extends AppCompatTextView {
    public boolean isFocused() {
        return true;
    }

    public MarqueeText(Context context) {
        super(context);
    }

    public MarqueeText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MarqueeText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
