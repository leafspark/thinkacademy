package com.tal.app.thinkacademy.common.business.browser.handler;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.lib.language.AppUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ActivityUtils;

public class FilterSchemeHandler extends WebViewLifeHandler {
    public boolean onUrlLoading(String str) {
        XesLog.dt("Leather***********FilterSchemeHandler url***********" + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (!str.startsWith("alipays:") && !str.startsWith("alipay")) {
            return super.onUrlLoading(str);
        }
        Activity topActivity = ActivityUtils.getTopActivity();
        try {
            XesLog.dt("WebViewPayHandler", "拦截到alipay url");
            topActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            Toast.makeText(topActivity, R.string.please_install_alipay, 1).show();
            e.printStackTrace();
            XesLog.dt("WebViewPayHandler", e.getMessage());
        }
        return true;
    }

    private boolean alipayInstalled() {
        PackageInfo packageInfo;
        try {
            packageInfo = AppUtil.getApplication().getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 0);
        } catch (Exception e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return true;
        }
        return false;
    }
}
