package com.adyen.checkout.wechatpay;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.components.base.BaseConfigurationBuilder;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.core.api.Environment;
import java.util.Locale;

public class WeChatPayActionConfiguration extends Configuration {
    public static final Parcelable.Creator<WeChatPayActionConfiguration> CREATOR = new Parcelable.Creator<WeChatPayActionConfiguration>() {
        public WeChatPayActionConfiguration createFromParcel(Parcel parcel) {
            return new WeChatPayActionConfiguration(parcel);
        }

        public WeChatPayActionConfiguration[] newArray(int i) {
            return new WeChatPayActionConfiguration[i];
        }
    };

    protected WeChatPayActionConfiguration(Builder builder) {
        super(builder.getBuilderShopperLocale(), builder.getBuilderEnvironment(), builder.getBuilderClientKey());
    }

    protected WeChatPayActionConfiguration(Parcel parcel) {
        super(parcel);
    }

    public static final class Builder extends BaseConfigurationBuilder<WeChatPayActionConfiguration> {
        public Builder(Context context, String str) {
            super(context, str);
        }

        public Builder(Locale locale, Environment environment, String str) {
            super(locale, environment, str);
        }

        public Builder(WeChatPayActionConfiguration weChatPayActionConfiguration) {
            super(weChatPayActionConfiguration);
        }

        public Builder setShopperLocale(Locale locale) {
            return (Builder) super.setShopperLocale(locale);
        }

        public Builder setEnvironment(Environment environment) {
            return (Builder) super.setEnvironment(environment);
        }

        /* access modifiers changed from: protected */
        public WeChatPayActionConfiguration buildInternal() {
            return new WeChatPayActionConfiguration(this);
        }
    }
}
