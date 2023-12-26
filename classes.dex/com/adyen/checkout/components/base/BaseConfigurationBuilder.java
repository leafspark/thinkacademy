package com.adyen.checkout.components.base;

import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.util.ValidationUtils;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.util.LocaleUtil;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nB\u001d\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\r\u0010\u001f\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u001eJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/adyen/checkout/components/base/BaseConfigurationBuilder;", "ConfigurationT", "Lcom/adyen/checkout/components/base/Configuration;", "", "context", "Landroid/content/Context;", "clientKey", "", "(Landroid/content/Context;Ljava/lang/String;)V", "configuration", "(Lcom/adyen/checkout/components/base/Configuration;)V", "builderShopperLocale", "Ljava/util/Locale;", "builderEnvironment", "Lcom/adyen/checkout/core/api/Environment;", "builderClientKey", "(Ljava/util/Locale;Lcom/adyen/checkout/core/api/Environment;Ljava/lang/String;)V", "getBuilderClientKey", "()Ljava/lang/String;", "setBuilderClientKey", "(Ljava/lang/String;)V", "getBuilderEnvironment", "()Lcom/adyen/checkout/core/api/Environment;", "setBuilderEnvironment", "(Lcom/adyen/checkout/core/api/Environment;)V", "getBuilderShopperLocale", "()Ljava/util/Locale;", "setBuilderShopperLocale", "(Ljava/util/Locale;)V", "build", "()Lcom/adyen/checkout/components/base/Configuration;", "buildInternal", "setEnvironment", "setShopperLocale", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BaseConfigurationBuilder.kt */
public abstract class BaseConfigurationBuilder<ConfigurationT extends Configuration> {
    private String builderClientKey;
    private Environment builderEnvironment;
    private Locale builderShopperLocale;

    /* access modifiers changed from: protected */
    public abstract ConfigurationT buildInternal();

    public BaseConfigurationBuilder(Locale locale, Environment environment, String str) {
        Intrinsics.checkNotNullParameter(locale, "builderShopperLocale");
        Intrinsics.checkNotNullParameter(environment, "builderEnvironment");
        Intrinsics.checkNotNullParameter(str, "builderClientKey");
        this.builderShopperLocale = locale;
        this.builderEnvironment = environment;
        this.builderClientKey = str;
        if (!ValidationUtils.INSTANCE.isClientKeyValid(this.builderClientKey)) {
            throw new CheckoutException("Client key is not valid.");
        }
    }

    public final Locale getBuilderShopperLocale() {
        return this.builderShopperLocale;
    }

    public final void setBuilderShopperLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<set-?>");
        this.builderShopperLocale = locale;
    }

    public final Environment getBuilderEnvironment() {
        return this.builderEnvironment;
    }

    public final void setBuilderEnvironment(Environment environment) {
        Intrinsics.checkNotNullParameter(environment, "<set-?>");
        this.builderEnvironment = environment;
    }

    public final String getBuilderClientKey() {
        return this.builderClientKey;
    }

    public final void setBuilderClientKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.builderClientKey = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BaseConfigurationBuilder(android.content.Context r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "clientKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.Locale r3 = com.adyen.checkout.core.util.LocaleUtil.getLocale(r3)
            com.adyen.checkout.core.api.Environment r0 = com.adyen.checkout.core.api.Environment.TEST
            java.lang.String r1 = "TEST"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r3, r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.components.base.BaseConfigurationBuilder.<init>(android.content.Context, java.lang.String):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseConfigurationBuilder(ConfigurationT configurationt) {
        this(configurationt.getShopperLocale(), configurationt.getEnvironment(), configurationt.getClientKey());
        Intrinsics.checkNotNullParameter(configurationt, "configuration");
    }

    public BaseConfigurationBuilder<ConfigurationT> setShopperLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "builderShopperLocale");
        this.builderShopperLocale = locale;
        return this;
    }

    public BaseConfigurationBuilder<ConfigurationT> setEnvironment(Environment environment) {
        Intrinsics.checkNotNullParameter(environment, "builderEnvironment");
        this.builderEnvironment = environment;
        return this;
    }

    public final ConfigurationT build() {
        if (!ValidationUtils.INSTANCE.doesClientKeyMatchEnvironment(this.builderClientKey, this.builderEnvironment)) {
            throw new CheckoutException("Client key does not match the environment.");
        } else if (LocaleUtil.isValidLocale(this.builderShopperLocale)) {
            return buildInternal();
        } else {
            throw new CheckoutException("Invalid shopper locale: " + this.builderShopperLocale + '.');
        }
    }
}
