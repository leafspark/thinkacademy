package com.adyen.checkout.redirect;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.components.base.BaseConfigurationBuilder;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.core.api.Environment;
import java.util.Locale;

public class RedirectConfiguration extends Configuration {
    public static final Parcelable.Creator<RedirectConfiguration> CREATOR = new Parcelable.Creator<RedirectConfiguration>() {
        public RedirectConfiguration createFromParcel(Parcel parcel) {
            return new RedirectConfiguration(parcel);
        }

        public RedirectConfiguration[] newArray(int i) {
            return new RedirectConfiguration[i];
        }
    };

    protected RedirectConfiguration(Builder builder) {
        super(builder.getBuilderShopperLocale(), builder.getBuilderEnvironment(), builder.getBuilderClientKey());
    }

    protected RedirectConfiguration(Parcel parcel) {
        super(parcel);
    }

    public static final class Builder extends BaseConfigurationBuilder<RedirectConfiguration> {
        public Builder(Context context, String str) {
            super(context, str);
        }

        public Builder(Locale locale, Environment environment, String str) {
            super(locale, environment, str);
        }

        public Builder(RedirectConfiguration redirectConfiguration) {
            super(redirectConfiguration);
        }

        public Builder setShopperLocale(Locale locale) {
            return (Builder) super.setShopperLocale(locale);
        }

        public Builder setEnvironment(Environment environment) {
            return (Builder) super.setEnvironment(environment);
        }

        /* access modifiers changed from: protected */
        public RedirectConfiguration buildInternal() {
            return new RedirectConfiguration(this);
        }
    }
}
