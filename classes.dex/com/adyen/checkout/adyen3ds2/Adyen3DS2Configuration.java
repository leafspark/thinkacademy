package com.adyen.checkout.adyen3ds2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.components.base.BaseConfigurationBuilder;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.core.api.Environment;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration;", "Lcom/adyen/checkout/components/base/Configuration;", "builder", "Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration$Builder;", "(Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration$Builder;)V", "inputParcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "Builder", "Companion", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Adyen3DS2Configuration.kt */
public final class Adyen3DS2Configuration extends Configuration {
    public static final Parcelable.Creator<Adyen3DS2Configuration> CREATOR = new Adyen3DS2Configuration$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ Adyen3DS2Configuration(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public /* synthetic */ Adyen3DS2Configuration(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private Adyen3DS2Configuration(Builder builder) {
        super(builder.getBuilderShopperLocale(), builder.getBuilderEnvironment(), builder.getBuilderClientKey());
    }

    private Adyen3DS2Configuration(Parcel parcel) {
        super(parcel);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\fB\u000f\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0014J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tH\u0016¨\u0006\u0014"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration$Builder;", "Lcom/adyen/checkout/components/base/BaseConfigurationBuilder;", "Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration;", "context", "Landroid/content/Context;", "clientKey", "", "(Landroid/content/Context;Ljava/lang/String;)V", "shopperLocale", "Ljava/util/Locale;", "environment", "Lcom/adyen/checkout/core/api/Environment;", "(Ljava/util/Locale;Lcom/adyen/checkout/core/api/Environment;Ljava/lang/String;)V", "configuration", "(Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration;)V", "buildInternal", "setEnvironment", "builderEnvironment", "setShopperLocale", "builderShopperLocale", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Adyen3DS2Configuration.kt */
    public static final class Builder extends BaseConfigurationBuilder<Adyen3DS2Configuration> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(Context context, String str) {
            super(context, str);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "clientKey");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(Locale locale, Environment environment, String str) {
            super(locale, environment, str);
            Intrinsics.checkNotNullParameter(locale, "shopperLocale");
            Intrinsics.checkNotNullParameter(environment, "environment");
            Intrinsics.checkNotNullParameter(str, "clientKey");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(Adyen3DS2Configuration adyen3DS2Configuration) {
            super(adyen3DS2Configuration);
            Intrinsics.checkNotNullParameter(adyen3DS2Configuration, "configuration");
        }

        public Builder setShopperLocale(Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "builderShopperLocale");
            return (Builder) super.setShopperLocale(locale);
        }

        public Builder setEnvironment(Environment environment) {
            Intrinsics.checkNotNullParameter(environment, "builderEnvironment");
            return (Builder) super.setEnvironment(environment);
        }

        /* access modifiers changed from: protected */
        public Adyen3DS2Configuration buildInternal() {
            return new Adyen3DS2Configuration(this, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration;", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Adyen3DS2Configuration.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
