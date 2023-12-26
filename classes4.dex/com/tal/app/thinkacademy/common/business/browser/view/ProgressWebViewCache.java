package com.tal.app.thinkacademy.common.business.browser.view;

import android.content.Context;
import android.util.AttributeSet;

public class ProgressWebViewCache extends ProgressWebView {
    public boolean isCanUseWebCache() {
        return true;
    }

    public ProgressWebViewCache(Context context) {
        super(context);
    }

    public ProgressWebViewCache(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProgressWebViewCache(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
