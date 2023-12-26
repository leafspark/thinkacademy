package com.adyen.checkout.card;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.components.base.AddressVisibility;
import com.adyen.checkout.components.base.BaseConfigurationBuilder;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.util.ParcelUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class CardConfiguration extends Configuration {
    public static final Parcelable.Creator<CardConfiguration> CREATOR = new Parcelable.Creator<CardConfiguration>() {
        public CardConfiguration createFromParcel(Parcel parcel) {
            return new CardConfiguration(parcel);
        }

        public CardConfiguration[] newArray(int i) {
            return new CardConfiguration[i];
        }
    };
    private static final CardType[] DEFAULT_SUPPORTED_CARDS;
    public static final List<CardType> DEFAULT_SUPPORTED_CARDS_LIST;
    private final AddressVisibility mAddressVisibility;
    private final boolean mHideCvc;
    private final boolean mHideCvcStoredCard;
    private final boolean mHolderNameRequired;
    private final InstallmentConfiguration mInstallmentConfiguration;
    private final KCPAuthVisibility mKcpAuthVisibility;
    private final String mShopperReference;
    private final boolean mShowStorePaymentField;
    private final SocialSecurityNumberVisibility mSocialSecurityNumberVisibility;
    private final List<CardType> mSupportedCardTypes;

    static {
        CardType[] cardTypeArr = {CardType.VISA, CardType.AMERICAN_EXPRESS, CardType.MASTERCARD};
        DEFAULT_SUPPORTED_CARDS = cardTypeArr;
        DEFAULT_SUPPORTED_CARDS_LIST = Collections.unmodifiableList(Arrays.asList(cardTypeArr));
    }

    CardConfiguration(Builder builder) {
        super(builder.getBuilderShopperLocale(), builder.getBuilderEnvironment(), builder.getBuilderClientKey());
        this.mHolderNameRequired = builder.mBuilderHolderNameRequired;
        this.mSupportedCardTypes = builder.mBuilderSupportedCardTypes;
        this.mShopperReference = builder.mShopperReference;
        this.mShowStorePaymentField = builder.mBuilderShowStorePaymentField;
        this.mHideCvc = builder.mBuilderHideCvc;
        this.mHideCvcStoredCard = builder.mBuilderHideCvcStoredCard;
        this.mSocialSecurityNumberVisibility = builder.mBuilderSocialSecurityNumberVisibility;
        this.mKcpAuthVisibility = builder.mBuilderKcpAuthVisibility;
        this.mAddressVisibility = builder.mBuilderAddressVisibility;
        this.mInstallmentConfiguration = builder.mBuilderInstallmentConfiguration;
    }

    CardConfiguration(Parcel parcel) {
        super(parcel);
        this.mShopperReference = parcel.readString();
        this.mHolderNameRequired = ParcelUtils.readBoolean(parcel);
        this.mSupportedCardTypes = parcel.readArrayList(CardType.class.getClassLoader());
        this.mShowStorePaymentField = ParcelUtils.readBoolean(parcel);
        this.mHideCvc = ParcelUtils.readBoolean(parcel);
        this.mHideCvcStoredCard = ParcelUtils.readBoolean(parcel);
        this.mSocialSecurityNumberVisibility = SocialSecurityNumberVisibility.valueOf(parcel.readString());
        this.mKcpAuthVisibility = KCPAuthVisibility.valueOf(parcel.readString());
        this.mAddressVisibility = (AddressVisibility) parcel.readSerializable();
        this.mInstallmentConfiguration = (InstallmentConfiguration) parcel.readParcelable(InstallmentConfiguration.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mShopperReference);
        ParcelUtils.writeBoolean(parcel, this.mHolderNameRequired);
        parcel.writeList(this.mSupportedCardTypes);
        ParcelUtils.writeBoolean(parcel, this.mShowStorePaymentField);
        ParcelUtils.writeBoolean(parcel, this.mHideCvc);
        ParcelUtils.writeBoolean(parcel, this.mHideCvcStoredCard);
        parcel.writeString(this.mSocialSecurityNumberVisibility.name());
        parcel.writeString(this.mKcpAuthVisibility.name());
        parcel.writeSerializable(this.mAddressVisibility);
        parcel.writeParcelable(this.mInstallmentConfiguration, i);
    }

    public List<CardType> getSupportedCardTypes() {
        return this.mSupportedCardTypes;
    }

    public boolean isHolderNameRequired() {
        return this.mHolderNameRequired;
    }

    public String getShopperReference() {
        return this.mShopperReference;
    }

    @Deprecated
    public boolean isShowStorePaymentFieldEnable() {
        return this.mShowStorePaymentField;
    }

    public boolean isStorePaymentFieldVisible() {
        return this.mShowStorePaymentField;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public boolean isHideCvc() {
        return this.mHideCvc;
    }

    public boolean isHideCvcStoredCard() {
        return this.mHideCvcStoredCard;
    }

    public SocialSecurityNumberVisibility getSocialSecurityNumberVisibility() {
        return this.mSocialSecurityNumberVisibility;
    }

    public KCPAuthVisibility getKcpAuthVisibility() {
        return this.mKcpAuthVisibility;
    }

    public AddressVisibility getAddressVisibility() {
        return this.mAddressVisibility;
    }

    public InstallmentConfiguration getInstallmentConfiguration() {
        return this.mInstallmentConfiguration;
    }

    public static final class Builder extends BaseConfigurationBuilder<CardConfiguration> {
        /* access modifiers changed from: private */
        public AddressVisibility mBuilderAddressVisibility = AddressVisibility.NONE;
        /* access modifiers changed from: private */
        public boolean mBuilderHideCvc;
        /* access modifiers changed from: private */
        public boolean mBuilderHideCvcStoredCard;
        /* access modifiers changed from: private */
        public boolean mBuilderHolderNameRequired;
        /* access modifiers changed from: private */
        public InstallmentConfiguration mBuilderInstallmentConfiguration;
        /* access modifiers changed from: private */
        public KCPAuthVisibility mBuilderKcpAuthVisibility = KCPAuthVisibility.HIDE;
        /* access modifiers changed from: private */
        public boolean mBuilderShowStorePaymentField = true;
        /* access modifiers changed from: private */
        public SocialSecurityNumberVisibility mBuilderSocialSecurityNumberVisibility = SocialSecurityNumberVisibility.HIDE;
        /* access modifiers changed from: private */
        public List<CardType> mBuilderSupportedCardTypes = Collections.emptyList();
        /* access modifiers changed from: private */
        public String mShopperReference;

        public Builder(CardConfiguration cardConfiguration) {
            super(cardConfiguration);
            this.mBuilderSupportedCardTypes = cardConfiguration.getSupportedCardTypes();
            this.mBuilderHolderNameRequired = cardConfiguration.isHolderNameRequired();
            this.mBuilderShowStorePaymentField = cardConfiguration.isStorePaymentFieldVisible();
            this.mShopperReference = cardConfiguration.getShopperReference();
            this.mBuilderHideCvc = cardConfiguration.isHideCvc();
            this.mBuilderHideCvcStoredCard = cardConfiguration.isHideCvcStoredCard();
            this.mBuilderSocialSecurityNumberVisibility = cardConfiguration.getSocialSecurityNumberVisibility();
            this.mBuilderKcpAuthVisibility = cardConfiguration.getKcpAuthVisibility();
            this.mBuilderAddressVisibility = cardConfiguration.getAddressVisibility();
            this.mBuilderInstallmentConfiguration = cardConfiguration.getInstallmentConfiguration();
        }

        public Builder(Context context, String str) {
            super(context, str);
        }

        public Builder(Locale locale, Environment environment, String str) {
            super(locale, environment, str);
        }

        public Builder setShopperLocale(Locale locale) {
            return (Builder) super.setShopperLocale(locale);
        }

        public Builder setEnvironment(Environment environment) {
            return (Builder) super.setEnvironment(environment);
        }

        public Builder setSupportedCardTypes(CardType... cardTypeArr) {
            this.mBuilderSupportedCardTypes = Arrays.asList(cardTypeArr);
            return this;
        }

        public Builder setHolderNameRequired(boolean z) {
            this.mBuilderHolderNameRequired = z;
            return this;
        }

        public Builder setShowStorePaymentField(boolean z) {
            this.mBuilderShowStorePaymentField = z;
            return this;
        }

        public Builder setShopperReference(String str) {
            this.mShopperReference = str;
            return this;
        }

        public Builder setHideCvc(boolean z) {
            this.mBuilderHideCvc = z;
            return this;
        }

        public Builder setHideCvcStoredCard(boolean z) {
            this.mBuilderHideCvcStoredCard = z;
            return this;
        }

        public Builder setSocialSecurityNumberVisibility(SocialSecurityNumberVisibility socialSecurityNumberVisibility) {
            this.mBuilderSocialSecurityNumberVisibility = socialSecurityNumberVisibility;
            return this;
        }

        public Builder setKcpAuthVisibility(KCPAuthVisibility kCPAuthVisibility) {
            this.mBuilderKcpAuthVisibility = kCPAuthVisibility;
            return this;
        }

        public Builder setAddressVisibility(AddressVisibility addressVisibility) {
            this.mBuilderAddressVisibility = addressVisibility;
            return this;
        }

        public Builder setInstallmentConfigurations(InstallmentConfiguration installmentConfiguration) {
            this.mBuilderInstallmentConfiguration = installmentConfiguration;
            return this;
        }

        /* access modifiers changed from: protected */
        public CardConfiguration buildInternal() {
            return new CardConfiguration(this);
        }
    }
}
