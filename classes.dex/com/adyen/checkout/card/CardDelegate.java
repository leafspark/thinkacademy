package com.adyen.checkout.card;

import com.adyen.checkout.card.api.model.Brand;
import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.card.data.DetectedCardType;
import com.adyen.checkout.card.data.ExpiryDate;
import com.adyen.checkout.components.base.PaymentMethodDelegate;
import com.adyen.checkout.components.repository.PublicKeyRepository;
import com.adyen.checkout.components.ui.FieldState;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0011\u0010\u0016\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0012H&J*\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\u001fH&J\b\u0010!\u001a\u00020\u001fH&J\b\u0010\"\u001a\u00020\u001fH&J\b\u0010#\u001a\u00020\u001fH&J\b\u0010$\u001a\u00020\u001fH&J\b\u0010%\u001a\u00020\u001fH&J&\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120'2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001fH&J \u0010*\u001a\b\u0012\u0004\u0012\u00020+0'2\u0006\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010.H&J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00120'2\u0006\u00100\u001a\u00020\u0012H&J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\u00120'2\u0006\u00102\u001a\u00020\u0012H&J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120'2\u0006\u00104\u001a\u00020\u0012H&J\u0016\u00105\u001a\b\u0012\u0004\u0012\u00020\u00120'2\u0006\u00106\u001a\u00020\u0012H&J\"\u00107\u001a\b\u0012\u0004\u0012\u00020\u00120'2\u0006\u00108\u001a\u00020\u00122\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0010H&J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020\u00120'2\u0006\u0010:\u001a\u00020\u0012H&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, d2 = {"Lcom/adyen/checkout/card/CardDelegate;", "Lcom/adyen/checkout/components/base/PaymentMethodDelegate;", "cardConfiguration", "Lcom/adyen/checkout/card/CardConfiguration;", "publicKeyRepository", "Lcom/adyen/checkout/components/repository/PublicKeyRepository;", "(Lcom/adyen/checkout/card/CardConfiguration;Lcom/adyen/checkout/components/repository/PublicKeyRepository;)V", "getCardConfiguration", "()Lcom/adyen/checkout/card/CardConfiguration;", "noCvcBrands", "", "Lcom/adyen/checkout/card/data/CardType;", "getNoCvcBrands", "()Ljava/util/Set;", "detectCardType", "", "Lcom/adyen/checkout/card/data/DetectedCardType;", "cardNumber", "", "publicKey", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "fetchPublicKey", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFundingSource", "getInstallmentOptions", "Lcom/adyen/checkout/card/InstallmentModel;", "installmentConfiguration", "Lcom/adyen/checkout/card/InstallmentConfiguration;", "cardType", "isCardTypeReliable", "", "isCvcHidden", "isHolderNameRequired", "isKCPAuthRequired", "isPostalCodeRequired", "isSocialSecurityNumberRequired", "requiresInput", "validateCardNumber", "Lcom/adyen/checkout/components/ui/FieldState;", "enableLuhnCheck", "isBrandSupported", "validateExpiryDate", "Lcom/adyen/checkout/card/data/ExpiryDate;", "expiryDate", "expiryDatePolicy", "Lcom/adyen/checkout/card/api/model/Brand$FieldPolicy;", "validateHolderName", "holderName", "validateKcpBirthDateOrTaxNumber", "kcpBirthDateOrTaxNumber", "validateKcpCardPassword", "kcpCardPassword", "validatePostalCode", "postalCode", "validateSecurityCode", "securityCode", "validateSocialSecurityNumber", "socialSecurityNumber", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardDelegate.kt */
public abstract class CardDelegate implements PaymentMethodDelegate {
    private final CardConfiguration cardConfiguration;
    private final Set<CardType> noCvcBrands = SetsKt.hashSetOf(new CardType[]{CardType.BCMC});
    private final PublicKeyRepository publicKeyRepository;

    public abstract List<DetectedCardType> detectCardType(String str, String str2, CoroutineScope coroutineScope);

    public abstract String getFundingSource();

    public abstract List<InstallmentModel> getInstallmentOptions(InstallmentConfiguration installmentConfiguration, CardType cardType, boolean z);

    public abstract boolean isCvcHidden();

    public abstract boolean isHolderNameRequired();

    public abstract boolean isKCPAuthRequired();

    public abstract boolean isPostalCodeRequired();

    public abstract boolean isSocialSecurityNumberRequired();

    public abstract boolean requiresInput();

    public abstract FieldState<String> validateCardNumber(String str, boolean z, boolean z2);

    public abstract FieldState<ExpiryDate> validateExpiryDate(ExpiryDate expiryDate, Brand.FieldPolicy fieldPolicy);

    public abstract FieldState<String> validateHolderName(String str);

    public abstract FieldState<String> validateKcpBirthDateOrTaxNumber(String str);

    public abstract FieldState<String> validateKcpCardPassword(String str);

    public abstract FieldState<String> validatePostalCode(String str);

    public abstract FieldState<String> validateSecurityCode(String str, DetectedCardType detectedCardType);

    public abstract FieldState<String> validateSocialSecurityNumber(String str);

    public CardDelegate(CardConfiguration cardConfiguration2, PublicKeyRepository publicKeyRepository2) {
        Intrinsics.checkNotNullParameter(cardConfiguration2, "cardConfiguration");
        Intrinsics.checkNotNullParameter(publicKeyRepository2, "publicKeyRepository");
        this.cardConfiguration = cardConfiguration2;
        this.publicKeyRepository = publicKeyRepository2;
    }

    /* access modifiers changed from: protected */
    public final CardConfiguration getCardConfiguration() {
        return this.cardConfiguration;
    }

    /* access modifiers changed from: protected */
    public final Set<CardType> getNoCvcBrands() {
        return this.noCvcBrands;
    }

    public static /* synthetic */ FieldState validateSecurityCode$default(CardDelegate cardDelegate, String str, DetectedCardType detectedCardType, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                detectedCardType = null;
            }
            return cardDelegate.validateSecurityCode(str, detectedCardType);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validateSecurityCode");
    }

    public final Object fetchPublicKey(Continuation<? super String> continuation) {
        return this.publicKeyRepository.fetchPublicKey(getCardConfiguration().getEnvironment(), getCardConfiguration().getClientKey(), continuation);
    }
}
