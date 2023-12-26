package com.tal.app.thinkacademy.common.business.browser.handler;

import android.widget.TextView;
import com.tal.app.thinkacademy.lib.commui.R;

public class WebViewTitleHandler extends WebViewLifeHandler {
    private boolean keepTitle;
    private TextView tvTitle;

    private void setTitleBarStatus() {
    }

    public WebViewTitleHandler(TextView textView) {
        this.tvTitle = textView;
    }

    public boolean onUrlLoading(String str) {
        setTitleBarStatus();
        return super.onUrlLoading(str);
    }

    public void onPageStart(String str) {
        super.onPageStart(str);
        setTitle(this.tvTitle.getContext().getString(R.string.webview_loading_title), false);
    }

    public void onPageFinish(String str) {
        super.onPageFinish(str);
    }

    public void onReceiveTitle(String str) {
        super.onReceiveTitle(str);
        setTitle(str, false);
    }

    public void setTitle(String str, boolean z) {
        this.keepTitle = z;
        this.tvTitle.setText(str);
    }
}
