package com.adyen.checkout.card;

import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.components.PaymentComponentState;
import com.adyen.checkout.components.model.payments.request.CardPaymentMethod;
import com.adyen.checkout.components.model.payments.request.PaymentComponentData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/adyen/checkout/card/CardComponentState;", "Lcom/adyen/checkout/components/PaymentComponentState;", "Lcom/adyen/checkout/components/model/payments/request/CardPaymentMethod;", "paymentComponentData", "Lcom/adyen/checkout/components/model/payments/request/PaymentComponentData;", "isInputValid", "", "isReady", "cardType", "Lcom/adyen/checkout/card/data/CardType;", "binValue", "", "lastFourDigits", "(Lcom/adyen/checkout/components/model/payments/request/PaymentComponentData;ZZLcom/adyen/checkout/card/data/CardType;Ljava/lang/String;Ljava/lang/String;)V", "getBinValue", "()Ljava/lang/String;", "getCardType", "()Lcom/adyen/checkout/card/data/CardType;", "getLastFourDigits", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardComponentState.kt */
public final class CardComponentState extends PaymentComponentState<CardPaymentMethod> {
    private final String binValue;
    private final CardType cardType;
    private final String lastFourDigits;

    public final CardType getCardType() {
        return this.cardType;
    }

    public final String getBinValue() {
        return this.binValue;
    }

    public final String getLastFourDigits() {
        return this.lastFourDigits;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardComponentState(PaymentComponentData<CardPaymentMethod> paymentComponentData, boolean z, boolean z2, CardType cardType2, String str, String str2) {
        super(paymentComponentData, z, z2);
        Intrinsics.checkNotNullParameter(paymentComponentData, "paymentComponentData");
        Intrinsics.checkNotNullParameter(str, "binValue");
        this.cardType = cardType2;
        this.binValue = str;
        this.lastFourDigits = str2;
    }
}
