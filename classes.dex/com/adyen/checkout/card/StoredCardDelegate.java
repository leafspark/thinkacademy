package com.adyen.checkout.card;

import com.adyen.checkout.card.api.model.Brand;
import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.card.data.DetectedCardType;
import com.adyen.checkout.card.data.ExpiryDate;
import com.adyen.checkout.components.model.paymentmethods.StoredPaymentMethod;
import com.adyen.checkout.components.repository.PublicKeyRepository;
import com.adyen.checkout.components.ui.FieldState;
import com.adyen.checkout.components.ui.Validation;
import com.adyen.checkout.core.log.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010\u0015\u001a\u00020\u0010J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\b\u0010!\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u001bH\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J&\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100&2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001bH\u0016J \u0010)\u001a\b\u0012\u0004\u0012\u00020*0&2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100&2\u0006\u0010/\u001a\u00020\u0010H\u0016J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00100&2\u0006\u00101\u001a\u00020\u0010H\u0016J\u0016\u00102\u001a\b\u0012\u0004\u0012\u00020\u00100&2\u0006\u00103\u001a\u00020\u0010H\u0016J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100&2\u0006\u00105\u001a\u00020\u0010H\u0016J \u00106\u001a\b\u0012\u0004\u0012\u00020\u00100&2\u0006\u00107\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\rH\u0016J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u00100&2\u0006\u00109\u001a\u00020\u0010H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/adyen/checkout/card/StoredCardDelegate;", "Lcom/adyen/checkout/card/CardDelegate;", "storedPaymentMethod", "Lcom/adyen/checkout/components/model/paymentmethods/StoredPaymentMethod;", "cardConfiguration", "Lcom/adyen/checkout/card/CardConfiguration;", "publicKeyRepository", "Lcom/adyen/checkout/components/repository/PublicKeyRepository;", "(Lcom/adyen/checkout/components/model/paymentmethods/StoredPaymentMethod;Lcom/adyen/checkout/card/CardConfiguration;Lcom/adyen/checkout/components/repository/PublicKeyRepository;)V", "cardType", "Lcom/adyen/checkout/card/data/CardType;", "storedDetectedCardTypes", "", "Lcom/adyen/checkout/card/data/DetectedCardType;", "detectCardType", "cardNumber", "", "publicKey", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getFundingSource", "getId", "getInstallmentOptions", "Lcom/adyen/checkout/card/InstallmentModel;", "installmentConfiguration", "Lcom/adyen/checkout/card/InstallmentConfiguration;", "isCardTypeReliable", "", "getPaymentMethodType", "getStoredCardInputData", "Lcom/adyen/checkout/card/CardInputData;", "isCvcHidden", "isHolderNameRequired", "isKCPAuthRequired", "isPostalCodeRequired", "isSocialSecurityNumberRequired", "requiresInput", "validateCardNumber", "Lcom/adyen/checkout/components/ui/FieldState;", "enableLuhnCheck", "isBrandSupported", "validateExpiryDate", "Lcom/adyen/checkout/card/data/ExpiryDate;", "expiryDate", "expiryDatePolicy", "Lcom/adyen/checkout/card/api/model/Brand$FieldPolicy;", "validateHolderName", "holderName", "validateKcpBirthDateOrTaxNumber", "kcpBirthDateOrTaxNumber", "validateKcpCardPassword", "kcpCardPassword", "validatePostalCode", "postalCode", "validateSecurityCode", "securityCode", "validateSocialSecurityNumber", "socialSecurityNumber", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StoredCardDelegate.kt */
public final class StoredCardDelegate extends CardDelegate {
    private final CardType cardType;
    private final List<DetectedCardType> storedDetectedCardTypes;
    private final StoredPaymentMethod storedPaymentMethod;

    public String getFundingSource() {
        return null;
    }

    public boolean isHolderNameRequired() {
        return false;
    }

    public boolean isKCPAuthRequired() {
        return false;
    }

    public boolean isPostalCodeRequired() {
        return false;
    }

    public boolean isSocialSecurityNumberRequired() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoredCardDelegate(StoredPaymentMethod storedPaymentMethod2, CardConfiguration cardConfiguration, PublicKeyRepository publicKeyRepository) {
        super(cardConfiguration, publicKeyRepository);
        List<DetectedCardType> list;
        Brand.FieldPolicy fieldPolicy;
        Intrinsics.checkNotNullParameter(storedPaymentMethod2, "storedPaymentMethod");
        Intrinsics.checkNotNullParameter(cardConfiguration, "cardConfiguration");
        Intrinsics.checkNotNullParameter(publicKeyRepository, "publicKeyRepository");
        this.storedPaymentMethod = storedPaymentMethod2;
        String brand = storedPaymentMethod2.getBrand();
        CardType byBrandName = CardType.getByBrandName(brand == null ? "" : brand);
        this.cardType = byBrandName;
        if (byBrandName != null) {
            if (cardConfiguration.isHideCvcStoredCard() || getNoCvcBrands().contains(byBrandName)) {
                fieldPolicy = Brand.FieldPolicy.HIDDEN;
            } else {
                fieldPolicy = Brand.FieldPolicy.REQUIRED;
            }
            list = CollectionsKt.listOf(new DetectedCardType(byBrandName, true, true, fieldPolicy, Brand.FieldPolicy.REQUIRED, true, false, 64, (DefaultConstructorMarker) null));
        } else {
            list = CollectionsKt.emptyList();
        }
        this.storedDetectedCardTypes = list;
    }

    public String getPaymentMethodType() {
        String type = this.storedPaymentMethod.getType();
        return type == null ? "unknown" : type;
    }

    public FieldState<String> validateCardNumber(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        return new FieldState<>(str, Validation.Valid.INSTANCE);
    }

    public FieldState<ExpiryDate> validateExpiryDate(ExpiryDate expiryDate, Brand.FieldPolicy fieldPolicy) {
        Intrinsics.checkNotNullParameter(expiryDate, "expiryDate");
        return new FieldState<>(expiryDate, Validation.Valid.INSTANCE);
    }

    public FieldState<String> validateSecurityCode(String str, DetectedCardType detectedCardType) {
        Intrinsics.checkNotNullParameter(str, "securityCode");
        if (!getCardConfiguration().isHideCvcStoredCard()) {
            if (!CollectionsKt.contains(getNoCvcBrands(), detectedCardType == null ? null : detectedCardType.getCardType())) {
                return CardValidationUtils.INSTANCE.validateSecurityCode(str, detectedCardType);
            }
        }
        return new FieldState<>(str, Validation.Valid.INSTANCE);
    }

    public FieldState<String> validateHolderName(String str) {
        Intrinsics.checkNotNullParameter(str, "holderName");
        return new FieldState<>(str, Validation.Valid.INSTANCE);
    }

    public FieldState<String> validateSocialSecurityNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "socialSecurityNumber");
        return new FieldState<>(str, Validation.Valid.INSTANCE);
    }

    public FieldState<String> validateKcpBirthDateOrTaxNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "kcpBirthDateOrTaxNumber");
        return new FieldState<>(str, Validation.Valid.INSTANCE);
    }

    public FieldState<String> validateKcpCardPassword(String str) {
        Intrinsics.checkNotNullParameter(str, "kcpCardPassword");
        return new FieldState<>(str, Validation.Valid.INSTANCE);
    }

    public FieldState<String> validatePostalCode(String str) {
        Intrinsics.checkNotNullParameter(str, "postalCode");
        return new FieldState<>(str, Validation.Valid.INSTANCE);
    }

    public boolean isCvcHidden() {
        return getCardConfiguration().isHideCvcStoredCard() || CollectionsKt.contains(getNoCvcBrands(), this.cardType);
    }

    public boolean requiresInput() {
        return !getCardConfiguration().isHideCvcStoredCard();
    }

    public List<DetectedCardType> detectCardType(String str, String str2, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        return this.storedDetectedCardTypes;
    }

    public List<InstallmentModel> getInstallmentOptions(InstallmentConfiguration installmentConfiguration, CardType cardType2, boolean z) {
        return CollectionsKt.emptyList();
    }

    public final CardInputData getStoredCardInputData() {
        CardInputData cardInputData = new CardInputData((String) null, (ExpiryDate) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, 0, (InstallmentModel) null, 2047, (DefaultConstructorMarker) null);
        String lastFour = this.storedPaymentMethod.getLastFour();
        String str = "";
        if (lastFour == null) {
            lastFour = str;
        }
        cardInputData.setCardNumber(lastFour);
        try {
            String expiryMonth = this.storedPaymentMethod.getExpiryMonth();
            if (expiryMonth == null) {
                expiryMonth = str;
            }
            int parseInt = Integer.parseInt(expiryMonth);
            String expiryYear = this.storedPaymentMethod.getExpiryYear();
            if (expiryYear != null) {
                str = expiryYear;
            }
            cardInputData.setExpiryDate(new ExpiryDate(parseInt, Integer.parseInt(str), true));
        } catch (NumberFormatException e) {
            Logger.e(StoredCardDelegateKt.TAG, "Failed to parse stored Date", e);
            ExpiryDate expiryDate = ExpiryDate.EMPTY_DATE;
            Intrinsics.checkNotNullExpressionValue(expiryDate, "EMPTY_DATE");
            cardInputData.setExpiryDate(expiryDate);
        }
        return cardInputData;
    }

    public final String getId() {
        String id = this.storedPaymentMethod.getId();
        return id == null ? "ID_NOT_FOUND" : id;
    }
}
