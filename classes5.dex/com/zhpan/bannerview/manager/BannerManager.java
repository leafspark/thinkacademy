package com.zhpan.bannerview.manager;

import android.content.Context;
import android.util.AttributeSet;

public class BannerManager {
    private AttributeController mAttributeController;
    private BannerOptions mBannerOptions;

    public BannerManager() {
        BannerOptions bannerOptions = new BannerOptions();
        this.mBannerOptions = bannerOptions;
        this.mAttributeController = new AttributeController(bannerOptions);
    }

    public BannerOptions bannerOptions() {
        if (this.mBannerOptions == null) {
            this.mBannerOptions = new BannerOptions();
        }
        return this.mBannerOptions;
    }

    public void initAttrs(Context context, AttributeSet attributeSet) {
        this.mAttributeController.init(context, attributeSet);
    }
}
