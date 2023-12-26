package com.didi.hummer.component.text;

import android.text.TextPaint;
import android.text.style.URLSpan;

public class URLSpanEx extends URLSpan {
    private int linkColor = 0;
    private boolean showUnderline = true;

    public URLSpanEx(String str) {
        super(str);
    }

    public URLSpanEx(String str, int i) {
        super(str);
        this.linkColor = i;
    }

    public URLSpanEx(String str, int i, boolean z) {
        super(str);
        this.linkColor = i;
        this.showUnderline = z;
    }

    public void updateDrawState(TextPaint textPaint) {
        if (this.linkColor == 0) {
            this.linkColor = textPaint.linkColor;
        }
        textPaint.setColor(this.linkColor);
        textPaint.setUnderlineText(this.showUnderline);
    }
}
