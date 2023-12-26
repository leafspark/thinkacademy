package com.adyen.checkout.card;

import com.adyen.checkout.card.data.DetectedCardType;
import com.adyen.checkout.card.data.ExpiryDate;
import com.adyen.checkout.components.base.OutputData;
import com.adyen.checkout.components.ui.FieldState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BÑ\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\u0002\u0010\u001bJ\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003J\t\u0010/\u001a\u00020\u0012HÆ\u0003J\t\u00100\u001a\u00020\u0012HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003J\t\u00102\u001a\u00020\u0010HÆ\u0003J\t\u00103\u001a\u00020\u0010HÆ\u0003J\t\u00104\u001a\u00020\u0010HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015HÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0003HÆ\u0003J÷\u0001\u0010>\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00102\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015HÆ\u0001J\u0013\u0010?\u001a\u00020\u00102\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020CHÖ\u0001J\b\u0010D\u001a\u00020\u0010H\u0016J\t\u0010E\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u0018\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010'R\u0011\u0010\u0019\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010'R\u0011\u0010\u0017\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010'R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010'R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001d¨\u0006F"}, d2 = {"Lcom/adyen/checkout/card/CardOutputData;", "Lcom/adyen/checkout/components/base/OutputData;", "cardNumberState", "Lcom/adyen/checkout/components/ui/FieldState;", "", "expiryDateState", "Lcom/adyen/checkout/card/data/ExpiryDate;", "securityCodeState", "holderNameState", "socialSecurityNumberState", "kcpBirthDateOrTaxNumberState", "kcpCardPasswordState", "postalCodeState", "installmentState", "Lcom/adyen/checkout/card/InstallmentModel;", "isStoredPaymentMethodEnable", "", "cvcUIState", "Lcom/adyen/checkout/card/InputFieldUIState;", "expiryDateUIState", "detectedCardTypes", "", "Lcom/adyen/checkout/card/data/DetectedCardType;", "isSocialSecurityNumberRequired", "isKCPAuthRequired", "isPostalCodeRequired", "installmentOptions", "(Lcom/adyen/checkout/components/ui/FieldState;Lcom/adyen/checkout/components/ui/FieldState;Lcom/adyen/checkout/components/ui/FieldState;Lcom/adyen/checkout/components/ui/FieldState;Lcom/adyen/checkout/components/ui/FieldState;Lcom/adyen/checkout/components/ui/FieldState;Lcom/adyen/checkout/components/ui/FieldState;Lcom/adyen/checkout/components/ui/FieldState;Lcom/adyen/checkout/components/ui/FieldState;ZLcom/adyen/checkout/card/InputFieldUIState;Lcom/adyen/checkout/card/InputFieldUIState;Ljava/util/List;ZZZLjava/util/List;)V", "getCardNumberState", "()Lcom/adyen/checkout/components/ui/FieldState;", "getCvcUIState", "()Lcom/adyen/checkout/card/InputFieldUIState;", "getDetectedCardTypes", "()Ljava/util/List;", "getExpiryDateState", "getExpiryDateUIState", "getHolderNameState", "getInstallmentOptions", "getInstallmentState", "()Z", "getKcpBirthDateOrTaxNumberState", "getKcpCardPasswordState", "getPostalCodeState", "getSecurityCodeState", "getSocialSecurityNumberState", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "isValid", "toString", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardOutputData.kt */
public final class CardOutputData implements OutputData {
    private final FieldState<String> cardNumberState;
    private final InputFieldUIState cvcUIState;
    private final List<DetectedCardType> detectedCardTypes;
    private final FieldState<ExpiryDate> expiryDateState;
    private final InputFieldUIState expiryDateUIState;
    private final FieldState<String> holderNameState;
    private final List<InstallmentModel> installmentOptions;
    private final FieldState<InstallmentModel> installmentState;
    private final boolean isKCPAuthRequired;
    private final boolean isPostalCodeRequired;
    private final boolean isSocialSecurityNumberRequired;
    private final boolean isStoredPaymentMethodEnable;
    private final FieldState<String> kcpBirthDateOrTaxNumberState;
    private final FieldState<String> kcpCardPasswordState;
    private final FieldState<String> postalCodeState;
    private final FieldState<String> securityCodeState;
    private final FieldState<String> socialSecurityNumberState;

    public static /* synthetic */ CardOutputData copy$default(CardOutputData cardOutputData, FieldState fieldState, FieldState fieldState2, FieldState fieldState3, FieldState fieldState4, FieldState fieldState5, FieldState fieldState6, FieldState fieldState7, FieldState fieldState8, FieldState fieldState9, boolean z, InputFieldUIState inputFieldUIState, InputFieldUIState inputFieldUIState2, List list, boolean z2, boolean z3, boolean z4, List list2, int i, Object obj) {
        CardOutputData cardOutputData2 = cardOutputData;
        int i2 = i;
        return cardOutputData.copy((i2 & 1) != 0 ? cardOutputData2.cardNumberState : fieldState, (i2 & 2) != 0 ? cardOutputData2.expiryDateState : fieldState2, (i2 & 4) != 0 ? cardOutputData2.securityCodeState : fieldState3, (i2 & 8) != 0 ? cardOutputData2.holderNameState : fieldState4, (i2 & 16) != 0 ? cardOutputData2.socialSecurityNumberState : fieldState5, (i2 & 32) != 0 ? cardOutputData2.kcpBirthDateOrTaxNumberState : fieldState6, (i2 & 64) != 0 ? cardOutputData2.kcpCardPasswordState : fieldState7, (i2 & 128) != 0 ? cardOutputData2.postalCodeState : fieldState8, (i2 & 256) != 0 ? cardOutputData2.installmentState : fieldState9, (i2 & 512) != 0 ? cardOutputData2.isStoredPaymentMethodEnable : z, (i2 & 1024) != 0 ? cardOutputData2.cvcUIState : inputFieldUIState, (i2 & 2048) != 0 ? cardOutputData2.expiryDateUIState : inputFieldUIState2, (i2 & 4096) != 0 ? cardOutputData2.detectedCardTypes : list, (i2 & 8192) != 0 ? cardOutputData2.isSocialSecurityNumberRequired : z2, (i2 & 16384) != 0 ? cardOutputData2.isKCPAuthRequired : z3, (i2 & 32768) != 0 ? cardOutputData2.isPostalCodeRequired : z4, (i2 & 65536) != 0 ? cardOutputData2.installmentOptions : list2);
    }

    public final FieldState<String> component1() {
        return this.cardNumberState;
    }

    public final boolean component10() {
        return this.isStoredPaymentMethodEnable;
    }

    public final InputFieldUIState component11() {
        return this.cvcUIState;
    }

    public final InputFieldUIState component12() {
        return this.expiryDateUIState;
    }

    public final List<DetectedCardType> component13() {
        return this.detectedCardTypes;
    }

    public final boolean component14() {
        return this.isSocialSecurityNumberRequired;
    }

    public final boolean component15() {
        return this.isKCPAuthRequired;
    }

    public final boolean component16() {
        return this.isPostalCodeRequired;
    }

    public final List<InstallmentModel> component17() {
        return this.installmentOptions;
    }

    public final FieldState<ExpiryDate> component2() {
        return this.expiryDateState;
    }

    public final FieldState<String> component3() {
        return this.securityCodeState;
    }

    public final FieldState<String> component4() {
        return this.holderNameState;
    }

    public final FieldState<String> component5() {
        return this.socialSecurityNumberState;
    }

    public final FieldState<String> component6() {
        return this.kcpBirthDateOrTaxNumberState;
    }

    public final FieldState<String> component7() {
        return this.kcpCardPasswordState;
    }

    public final FieldState<String> component8() {
        return this.postalCodeState;
    }

    public final FieldState<InstallmentModel> component9() {
        return this.installmentState;
    }

    public final CardOutputData copy(FieldState<String> fieldState, FieldState<ExpiryDate> fieldState2, FieldState<String> fieldState3, FieldState<String> fieldState4, FieldState<String> fieldState5, FieldState<String> fieldState6, FieldState<String> fieldState7, FieldState<String> fieldState8, FieldState<InstallmentModel> fieldState9, boolean z, InputFieldUIState inputFieldUIState, InputFieldUIState inputFieldUIState2, List<DetectedCardType> list, boolean z2, boolean z3, boolean z4, List<InstallmentModel> list2) {
        FieldState<String> fieldState10 = fieldState;
        Intrinsics.checkNotNullParameter(fieldState10, "cardNumberState");
        Intrinsics.checkNotNullParameter(fieldState2, "expiryDateState");
        Intrinsics.checkNotNullParameter(fieldState3, "securityCodeState");
        Intrinsics.checkNotNullParameter(fieldState4, "holderNameState");
        Intrinsics.checkNotNullParameter(fieldState5, "socialSecurityNumberState");
        Intrinsics.checkNotNullParameter(fieldState6, "kcpBirthDateOrTaxNumberState");
        Intrinsics.checkNotNullParameter(fieldState7, "kcpCardPasswordState");
        Intrinsics.checkNotNullParameter(fieldState8, "postalCodeState");
        Intrinsics.checkNotNullParameter(fieldState9, "installmentState");
        Intrinsics.checkNotNullParameter(inputFieldUIState, "cvcUIState");
        Intrinsics.checkNotNullParameter(inputFieldUIState2, "expiryDateUIState");
        Intrinsics.checkNotNullParameter(list, "detectedCardTypes");
        Intrinsics.checkNotNullParameter(list2, "installmentOptions");
        return new CardOutputData(fieldState10, fieldState2, fieldState3, fieldState4, fieldState5, fieldState6, fieldState7, fieldState8, fieldState9, z, inputFieldUIState, inputFieldUIState2, list, z2, z3, z4, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardOutputData)) {
            return false;
        }
        CardOutputData cardOutputData = (CardOutputData) obj;
        return Intrinsics.areEqual(this.cardNumberState, cardOutputData.cardNumberState) && Intrinsics.areEqual(this.expiryDateState, cardOutputData.expiryDateState) && Intrinsics.areEqual(this.securityCodeState, cardOutputData.securityCodeState) && Intrinsics.areEqual(this.holderNameState, cardOutputData.holderNameState) && Intrinsics.areEqual(this.socialSecurityNumberState, cardOutputData.socialSecurityNumberState) && Intrinsics.areEqual(this.kcpBirthDateOrTaxNumberState, cardOutputData.kcpBirthDateOrTaxNumberState) && Intrinsics.areEqual(this.kcpCardPasswordState, cardOutputData.kcpCardPasswordState) && Intrinsics.areEqual(this.postalCodeState, cardOutputData.postalCodeState) && Intrinsics.areEqual(this.installmentState, cardOutputData.installmentState) && this.isStoredPaymentMethodEnable == cardOutputData.isStoredPaymentMethodEnable && this.cvcUIState == cardOutputData.cvcUIState && this.expiryDateUIState == cardOutputData.expiryDateUIState && Intrinsics.areEqual(this.detectedCardTypes, cardOutputData.detectedCardTypes) && this.isSocialSecurityNumberRequired == cardOutputData.isSocialSecurityNumberRequired && this.isKCPAuthRequired == cardOutputData.isKCPAuthRequired && this.isPostalCodeRequired == cardOutputData.isPostalCodeRequired && Intrinsics.areEqual(this.installmentOptions, cardOutputData.installmentOptions);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.cardNumberState.hashCode() * 31) + this.expiryDateState.hashCode()) * 31) + this.securityCodeState.hashCode()) * 31) + this.holderNameState.hashCode()) * 31) + this.socialSecurityNumberState.hashCode()) * 31) + this.kcpBirthDateOrTaxNumberState.hashCode()) * 31) + this.kcpCardPasswordState.hashCode()) * 31) + this.postalCodeState.hashCode()) * 31) + this.installmentState.hashCode()) * 31;
        boolean z = this.isStoredPaymentMethodEnable;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode2 = (((((((hashCode + (z ? 1 : 0)) * 31) + this.cvcUIState.hashCode()) * 31) + this.expiryDateUIState.hashCode()) * 31) + this.detectedCardTypes.hashCode()) * 31;
        boolean z3 = this.isSocialSecurityNumberRequired;
        if (z3) {
            z3 = true;
        }
        int i = (hashCode2 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isKCPAuthRequired;
        if (z4) {
            z4 = true;
        }
        int i2 = (i + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.isPostalCodeRequired;
        if (!z5) {
            z2 = z5;
        }
        return ((i2 + (z2 ? 1 : 0)) * 31) + this.installmentOptions.hashCode();
    }

    public String toString() {
        return "CardOutputData(cardNumberState=" + this.cardNumberState + ", expiryDateState=" + this.expiryDateState + ", securityCodeState=" + this.securityCodeState + ", holderNameState=" + this.holderNameState + ", socialSecurityNumberState=" + this.socialSecurityNumberState + ", kcpBirthDateOrTaxNumberState=" + this.kcpBirthDateOrTaxNumberState + ", kcpCardPasswordState=" + this.kcpCardPasswordState + ", postalCodeState=" + this.postalCodeState + ", installmentState=" + this.installmentState + ", isStoredPaymentMethodEnable=" + this.isStoredPaymentMethodEnable + ", cvcUIState=" + this.cvcUIState + ", expiryDateUIState=" + this.expiryDateUIState + ", detectedCardTypes=" + this.detectedCardTypes + ", isSocialSecurityNumberRequired=" + this.isSocialSecurityNumberRequired + ", isKCPAuthRequired=" + this.isKCPAuthRequired + ", isPostalCodeRequired=" + this.isPostalCodeRequired + ", installmentOptions=" + this.installmentOptions + ')';
    }

    public CardOutputData(FieldState<String> fieldState, FieldState<ExpiryDate> fieldState2, FieldState<String> fieldState3, FieldState<String> fieldState4, FieldState<String> fieldState5, FieldState<String> fieldState6, FieldState<String> fieldState7, FieldState<String> fieldState8, FieldState<InstallmentModel> fieldState9, boolean z, InputFieldUIState inputFieldUIState, InputFieldUIState inputFieldUIState2, List<DetectedCardType> list, boolean z2, boolean z3, boolean z4, List<InstallmentModel> list2) {
        FieldState<String> fieldState10 = fieldState;
        FieldState<ExpiryDate> fieldState11 = fieldState2;
        FieldState<String> fieldState12 = fieldState3;
        FieldState<String> fieldState13 = fieldState4;
        FieldState<String> fieldState14 = fieldState5;
        FieldState<String> fieldState15 = fieldState6;
        FieldState<String> fieldState16 = fieldState7;
        FieldState<String> fieldState17 = fieldState8;
        FieldState<InstallmentModel> fieldState18 = fieldState9;
        InputFieldUIState inputFieldUIState3 = inputFieldUIState;
        InputFieldUIState inputFieldUIState4 = inputFieldUIState2;
        List<DetectedCardType> list3 = list;
        List<InstallmentModel> list4 = list2;
        Intrinsics.checkNotNullParameter(fieldState10, "cardNumberState");
        Intrinsics.checkNotNullParameter(fieldState11, "expiryDateState");
        Intrinsics.checkNotNullParameter(fieldState12, "securityCodeState");
        Intrinsics.checkNotNullParameter(fieldState13, "holderNameState");
        Intrinsics.checkNotNullParameter(fieldState14, "socialSecurityNumberState");
        Intrinsics.checkNotNullParameter(fieldState15, "kcpBirthDateOrTaxNumberState");
        Intrinsics.checkNotNullParameter(fieldState16, "kcpCardPasswordState");
        Intrinsics.checkNotNullParameter(fieldState17, "postalCodeState");
        Intrinsics.checkNotNullParameter(fieldState18, "installmentState");
        Intrinsics.checkNotNullParameter(inputFieldUIState3, "cvcUIState");
        Intrinsics.checkNotNullParameter(inputFieldUIState4, "expiryDateUIState");
        Intrinsics.checkNotNullParameter(list3, "detectedCardTypes");
        Intrinsics.checkNotNullParameter(list4, "installmentOptions");
        this.cardNumberState = fieldState10;
        this.expiryDateState = fieldState11;
        this.securityCodeState = fieldState12;
        this.holderNameState = fieldState13;
        this.socialSecurityNumberState = fieldState14;
        this.kcpBirthDateOrTaxNumberState = fieldState15;
        this.kcpCardPasswordState = fieldState16;
        this.postalCodeState = fieldState17;
        this.installmentState = fieldState18;
        this.isStoredPaymentMethodEnable = z;
        this.cvcUIState = inputFieldUIState3;
        this.expiryDateUIState = inputFieldUIState4;
        this.detectedCardTypes = list3;
        this.isSocialSecurityNumberRequired = z2;
        this.isKCPAuthRequired = z3;
        this.isPostalCodeRequired = z4;
        this.installmentOptions = list4;
    }

    public final FieldState<String> getCardNumberState() {
        return this.cardNumberState;
    }

    public final FieldState<ExpiryDate> getExpiryDateState() {
        return this.expiryDateState;
    }

    public final FieldState<String> getSecurityCodeState() {
        return this.securityCodeState;
    }

    public final FieldState<String> getHolderNameState() {
        return this.holderNameState;
    }

    public final FieldState<String> getSocialSecurityNumberState() {
        return this.socialSecurityNumberState;
    }

    public final FieldState<String> getKcpBirthDateOrTaxNumberState() {
        return this.kcpBirthDateOrTaxNumberState;
    }

    public final FieldState<String> getKcpCardPasswordState() {
        return this.kcpCardPasswordState;
    }

    public final FieldState<String> getPostalCodeState() {
        return this.postalCodeState;
    }

    public final FieldState<InstallmentModel> getInstallmentState() {
        return this.installmentState;
    }

    public final boolean isStoredPaymentMethodEnable() {
        return this.isStoredPaymentMethodEnable;
    }

    public final InputFieldUIState getCvcUIState() {
        return this.cvcUIState;
    }

    public final InputFieldUIState getExpiryDateUIState() {
        return this.expiryDateUIState;
    }

    public final List<DetectedCardType> getDetectedCardTypes() {
        return this.detectedCardTypes;
    }

    public final boolean isSocialSecurityNumberRequired() {
        return this.isSocialSecurityNumberRequired;
    }

    public final boolean isKCPAuthRequired() {
        return this.isKCPAuthRequired;
    }

    public final boolean isPostalCodeRequired() {
        return this.isPostalCodeRequired;
    }

    public final List<InstallmentModel> getInstallmentOptions() {
        return this.installmentOptions;
    }

    public boolean isValid() {
        return this.cardNumberState.getValidation().isValid() && this.expiryDateState.getValidation().isValid() && this.securityCodeState.getValidation().isValid() && this.holderNameState.getValidation().isValid() && this.socialSecurityNumberState.getValidation().isValid() && this.kcpBirthDateOrTaxNumberState.getValidation().isValid() && this.kcpCardPasswordState.getValidation().isValid() && this.postalCodeState.getValidation().isValid() && this.installmentState.getValidation().isValid();
    }
}
