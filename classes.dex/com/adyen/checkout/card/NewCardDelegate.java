package com.adyen.checkout.card;

import com.adyen.checkout.card.api.model.Brand;
import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.card.data.DetectedCardType;
import com.adyen.checkout.card.data.ExpiryDate;
import com.adyen.checkout.card.repository.BinLookupRepository;
import com.adyen.checkout.components.base.AddressVisibility;
import com.adyen.checkout.components.model.paymentmethods.PaymentMethod;
import com.adyen.checkout.components.repository.PublicKeyRepository;
import com.adyen.checkout.components.ui.FieldState;
import com.adyen.checkout.components.ui.Validation;
import com.adyen.checkout.core.log.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0016J*\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020$H\u0016J\b\u0010(\u001a\u00020$H\u0016J\b\u0010)\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020$H\u0016J\u001e\u0010+\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002J\b\u0010-\u001a\u00020$H\u0016J&\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00170/2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020$H\u0016J \u00102\u001a\b\u0012\u0004\u0012\u0002030/2\u0006\u00104\u001a\u0002032\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0016\u00107\u001a\b\u0012\u0004\u0012\u00020\u00170/2\u0006\u00108\u001a\u00020\u0017H\u0016J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020\u00170/2\u0006\u0010:\u001a\u00020\u0017H\u0016J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00170/2\u0006\u0010<\u001a\u00020\u0017H\u0016J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00170/2\u0006\u0010>\u001a\u00020\u0017H\u0016J \u0010?\u001a\b\u0012\u0004\u0012\u00020\u00170/2\u0006\u0010@\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u0010H\u0016J\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00170/2\u0006\u0010B\u001a\u00020\u0017H\u0016R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/adyen/checkout/card/NewCardDelegate;", "Lcom/adyen/checkout/card/CardDelegate;", "paymentMethod", "Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;", "cardConfiguration", "Lcom/adyen/checkout/card/CardConfiguration;", "binLookupRepository", "Lcom/adyen/checkout/card/repository/BinLookupRepository;", "publicKeyRepository", "Lcom/adyen/checkout/components/repository/PublicKeyRepository;", "cardValidationMapper", "Lcom/adyen/checkout/card/CardValidationMapper;", "(Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;Lcom/adyen/checkout/card/CardConfiguration;Lcom/adyen/checkout/card/repository/BinLookupRepository;Lcom/adyen/checkout/components/repository/PublicKeyRepository;Lcom/adyen/checkout/card/CardValidationMapper;)V", "_binLookupFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "Lcom/adyen/checkout/card/data/DetectedCardType;", "binLookupFlow", "Lkotlinx/coroutines/flow/Flow;", "getBinLookupFlow$card_release", "()Lkotlinx/coroutines/flow/Flow;", "detectCardLocally", "cardNumber", "", "detectCardType", "publicKey", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getFundingSource", "getInstallmentOptions", "Lcom/adyen/checkout/card/InstallmentModel;", "installmentConfiguration", "Lcom/adyen/checkout/card/InstallmentConfiguration;", "cardType", "Lcom/adyen/checkout/card/data/CardType;", "isCardTypeReliable", "", "getPaymentMethodType", "isCvcHidden", "isHolderNameRequired", "isKCPAuthRequired", "isPostalCodeRequired", "isSocialSecurityNumberRequired", "localDetectedCard", "supportedCardTypes", "requiresInput", "validateCardNumber", "Lcom/adyen/checkout/components/ui/FieldState;", "enableLuhnCheck", "isBrandSupported", "validateExpiryDate", "Lcom/adyen/checkout/card/data/ExpiryDate;", "expiryDate", "expiryDatePolicy", "Lcom/adyen/checkout/card/api/model/Brand$FieldPolicy;", "validateHolderName", "holderName", "validateKcpBirthDateOrTaxNumber", "kcpBirthDateOrTaxNumber", "validateKcpCardPassword", "kcpCardPassword", "validatePostalCode", "postalCode", "validateSecurityCode", "securityCode", "validateSocialSecurityNumber", "socialSecurityNumber", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: NewCardDelegate.kt */
public final class NewCardDelegate extends CardDelegate {
    /* access modifiers changed from: private */
    public final MutableSharedFlow<List<DetectedCardType>> _binLookupFlow;
    private final Flow<List<DetectedCardType>> binLookupFlow;
    /* access modifiers changed from: private */
    public final BinLookupRepository binLookupRepository;
    private final CardValidationMapper cardValidationMapper;
    private final PaymentMethod paymentMethod;

    public boolean requiresInput() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewCardDelegate(PaymentMethod paymentMethod2, CardConfiguration cardConfiguration, BinLookupRepository binLookupRepository2, PublicKeyRepository publicKeyRepository, CardValidationMapper cardValidationMapper2) {
        super(cardConfiguration, publicKeyRepository);
        Intrinsics.checkNotNullParameter(paymentMethod2, "paymentMethod");
        Intrinsics.checkNotNullParameter(cardConfiguration, "cardConfiguration");
        Intrinsics.checkNotNullParameter(binLookupRepository2, "binLookupRepository");
        Intrinsics.checkNotNullParameter(publicKeyRepository, "publicKeyRepository");
        Intrinsics.checkNotNullParameter(cardValidationMapper2, "cardValidationMapper");
        this.paymentMethod = paymentMethod2;
        this.binLookupRepository = binLookupRepository2;
        this.cardValidationMapper = cardValidationMapper2;
        Flow<List<DetectedCardType>> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST);
        this._binLookupFlow = MutableSharedFlow;
        this.binLookupFlow = (Flow) MutableSharedFlow;
    }

    public final Flow<List<DetectedCardType>> getBinLookupFlow$card_release() {
        return this.binLookupFlow;
    }

    public String getPaymentMethodType() {
        String type = this.paymentMethod.getType();
        return type == null ? "unknown" : type;
    }

    public FieldState<String> validateCardNumber(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        return this.cardValidationMapper.mapCardNumberValidation(str, CardValidationUtils.INSTANCE.validateCardNumber(str, z, z2));
    }

    public FieldState<ExpiryDate> validateExpiryDate(ExpiryDate expiryDate, Brand.FieldPolicy fieldPolicy) {
        Intrinsics.checkNotNullParameter(expiryDate, "expiryDate");
        return CardValidationUtils.INSTANCE.validateExpiryDate(expiryDate, fieldPolicy);
    }

    public FieldState<String> validateSecurityCode(String str, DetectedCardType detectedCardType) {
        Intrinsics.checkNotNullParameter(str, "securityCode");
        if (getCardConfiguration().isHideCvc()) {
            return new FieldState<>(str, Validation.Valid.INSTANCE);
        }
        return CardValidationUtils.INSTANCE.validateSecurityCode(str, detectedCardType);
    }

    public FieldState<String> validateHolderName(String str) {
        Intrinsics.checkNotNullParameter(str, "holderName");
        if (!getCardConfiguration().isHolderNameRequired() || !StringsKt.isBlank(str)) {
            return new FieldState<>(str, Validation.Valid.INSTANCE);
        }
        return new FieldState<>(str, new Validation.Invalid(R.string.checkout_holder_name_not_valid));
    }

    public FieldState<String> validateSocialSecurityNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "socialSecurityNumber");
        if (isSocialSecurityNumberRequired()) {
            return SocialSecurityNumberUtils.INSTANCE.validateSocialSecurityNumber(str);
        }
        return new FieldState<>(str, Validation.Valid.INSTANCE);
    }

    public FieldState<String> validateKcpBirthDateOrTaxNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "kcpBirthDateOrTaxNumber");
        if (isKCPAuthRequired()) {
            return KcpValidationUtils.INSTANCE.validateKcpBirthDateOrTaxNumber(str);
        }
        return new FieldState<>(str, Validation.Valid.INSTANCE);
    }

    public FieldState<String> validateKcpCardPassword(String str) {
        Intrinsics.checkNotNullParameter(str, "kcpCardPassword");
        if (isKCPAuthRequired()) {
            return KcpValidationUtils.INSTANCE.validateKcpCardPassword(str);
        }
        return new FieldState<>(str, Validation.Valid.INSTANCE);
    }

    public FieldState<String> validatePostalCode(String str) {
        Validation validation;
        Intrinsics.checkNotNullParameter(str, "postalCode");
        if (isPostalCodeRequired()) {
            if (str.length() > 0) {
                validation = Validation.Valid.INSTANCE;
            } else {
                validation = new Validation.Invalid(R.string.checkout_card_postal_not_valid);
            }
        } else {
            validation = Validation.Valid.INSTANCE;
        }
        return new FieldState<>(str, validation);
    }

    public boolean isCvcHidden() {
        return getCardConfiguration().isHideCvc();
    }

    public boolean isSocialSecurityNumberRequired() {
        return getCardConfiguration().getSocialSecurityNumberVisibility() == SocialSecurityNumberVisibility.SHOW;
    }

    public boolean isKCPAuthRequired() {
        return getCardConfiguration().getKcpAuthVisibility() == KCPAuthVisibility.SHOW;
    }

    public boolean isHolderNameRequired() {
        return getCardConfiguration().isHolderNameRequired();
    }

    public boolean isPostalCodeRequired() {
        return getCardConfiguration().getAddressVisibility() == AddressVisibility.POSTAL_CODE;
    }

    public List<DetectedCardType> detectCardType(String str, String str2, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Logger.d(NewCardDelegateKt.TAG, "detectCardType");
        if (this.binLookupRepository.isRequiredSize(str)) {
            if (this.binLookupRepository.contains(str)) {
                Logger.d(NewCardDelegateKt.TAG, "Returning cashed result.");
                return this.binLookupRepository.get(str);
            } else if (str2 != null) {
                Logger.d(NewCardDelegateKt.TAG, "Launching Bin Lookup");
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new NewCardDelegate$detectCardType$1(this, str, str2, (Continuation<? super NewCardDelegate$detectCardType$1>) null), 3, (Object) null);
            }
        }
        return detectCardLocally(str);
    }

    public String getFundingSource() {
        return this.paymentMethod.getFundingSource();
    }

    public List<InstallmentModel> getInstallmentOptions(InstallmentConfiguration installmentConfiguration, CardType cardType, boolean z) {
        if (Intrinsics.areEqual(getFundingSource(), "debit")) {
            return CollectionsKt.emptyList();
        }
        return InstallmentUtils.INSTANCE.makeInstallmentOptions(installmentConfiguration, cardType, z);
    }

    private final List<DetectedCardType> detectCardLocally(String str) {
        Logger.d(NewCardDelegateKt.TAG, "detectCardLocally");
        if (str.length() == 0) {
            return CollectionsKt.emptyList();
        }
        List<CardType> supportedCardTypes = getCardConfiguration().getSupportedCardTypes();
        Intrinsics.checkNotNullExpressionValue(supportedCardTypes, "cardConfiguration.supportedCardTypes");
        List<CardType> estimate = CardType.estimate(str);
        Intrinsics.checkNotNullExpressionValue(estimate, "estimate(cardNumber)");
        Iterable<CardType> iterable = estimate;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (CardType cardType : iterable) {
            Intrinsics.checkNotNullExpressionValue(cardType, "it");
            arrayList.add(localDetectedCard(cardType, supportedCardTypes));
        }
        return (List) arrayList;
    }

    private final DetectedCardType localDetectedCard(CardType cardType, List<? extends CardType> list) {
        Brand.FieldPolicy fieldPolicy;
        if (getNoCvcBrands().contains(cardType)) {
            fieldPolicy = Brand.FieldPolicy.HIDDEN;
        } else {
            fieldPolicy = Brand.FieldPolicy.REQUIRED;
        }
        return new DetectedCardType(cardType, false, true, fieldPolicy, Brand.FieldPolicy.REQUIRED, list.contains(cardType), false, 64, (DefaultConstructorMarker) null);
    }
}
