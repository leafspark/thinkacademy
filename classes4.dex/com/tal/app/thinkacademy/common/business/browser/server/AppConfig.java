package com.tal.app.thinkacademy.common.business.browser.server;

import android.content.Context;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.yanzhenjie.andserver.framework.config.WebConfig;
import com.yanzhenjie.andserver.framework.website.StorageWebsite;

public class AppConfig implements WebConfig {
    public void onConfig(Context context, WebConfig.Delegate delegate) {
        XesLog.et("AndServeConfig success", new Object[0]);
        delegate.addWebsite(new StorageWebsite(CoreService.getRootPath()));
    }
}
