package com.adyen.checkout.card;

import com.adyen.checkout.card.data.ExpiryDate;
import com.adyen.checkout.components.base.InputData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u000fHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\rHÆ\u0003Jy\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0013\u0010>\u001a\u00020\r2\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020\u000fHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u0016¨\u0006C"}, d2 = {"Lcom/adyen/checkout/card/CardInputData;", "Lcom/adyen/checkout/components/base/InputData;", "cardNumber", "", "expiryDate", "Lcom/adyen/checkout/card/data/ExpiryDate;", "securityCode", "holderName", "socialSecurityNumber", "kcpBirthDateOrTaxNumber", "kcpCardPassword", "postalCode", "isStorePaymentSelected", "", "selectedCardIndex", "", "installmentOption", "Lcom/adyen/checkout/card/InstallmentModel;", "(Ljava/lang/String;Lcom/adyen/checkout/card/data/ExpiryDate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILcom/adyen/checkout/card/InstallmentModel;)V", "getCardNumber", "()Ljava/lang/String;", "setCardNumber", "(Ljava/lang/String;)V", "getExpiryDate", "()Lcom/adyen/checkout/card/data/ExpiryDate;", "setExpiryDate", "(Lcom/adyen/checkout/card/data/ExpiryDate;)V", "getHolderName", "setHolderName", "getInstallmentOption", "()Lcom/adyen/checkout/card/InstallmentModel;", "setInstallmentOption", "(Lcom/adyen/checkout/card/InstallmentModel;)V", "()Z", "setStorePaymentSelected", "(Z)V", "getKcpBirthDateOrTaxNumber", "setKcpBirthDateOrTaxNumber", "getKcpCardPassword", "setKcpCardPassword", "getPostalCode", "setPostalCode", "getSecurityCode", "setSecurityCode", "getSelectedCardIndex", "()I", "setSelectedCardIndex", "(I)V", "getSocialSecurityNumber", "setSocialSecurityNumber", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardInputData.kt */
public final class CardInputData implements InputData {
    private String cardNumber;
    private ExpiryDate expiryDate;
    private String holderName;
    private InstallmentModel installmentOption;
    private boolean isStorePaymentSelected;
    private String kcpBirthDateOrTaxNumber;
    private String kcpCardPassword;
    private String postalCode;
    private String securityCode;
    private int selectedCardIndex;
    private String socialSecurityNumber;

    public CardInputData() {
        this((String) null, (ExpiryDate) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, 0, (InstallmentModel) null, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CardInputData copy$default(CardInputData cardInputData, String str, ExpiryDate expiryDate2, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, InstallmentModel installmentModel, int i2, Object obj) {
        CardInputData cardInputData2 = cardInputData;
        int i3 = i2;
        return cardInputData.copy((i3 & 1) != 0 ? cardInputData2.cardNumber : str, (i3 & 2) != 0 ? cardInputData2.expiryDate : expiryDate2, (i3 & 4) != 0 ? cardInputData2.securityCode : str2, (i3 & 8) != 0 ? cardInputData2.holderName : str3, (i3 & 16) != 0 ? cardInputData2.socialSecurityNumber : str4, (i3 & 32) != 0 ? cardInputData2.kcpBirthDateOrTaxNumber : str5, (i3 & 64) != 0 ? cardInputData2.kcpCardPassword : str6, (i3 & 128) != 0 ? cardInputData2.postalCode : str7, (i3 & 256) != 0 ? cardInputData2.isStorePaymentSelected : z, (i3 & 512) != 0 ? cardInputData2.selectedCardIndex : i, (i3 & 1024) != 0 ? cardInputData2.installmentOption : installmentModel);
    }

    public final String component1() {
        return this.cardNumber;
    }

    public final int component10() {
        return this.selectedCardIndex;
    }

    public final InstallmentModel component11() {
        return this.installmentOption;
    }

    public final ExpiryDate component2() {
        return this.expiryDate;
    }

    public final String component3() {
        return this.securityCode;
    }

    public final String component4() {
        return this.holderName;
    }

    public final String component5() {
        return this.socialSecurityNumber;
    }

    public final String component6() {
        return this.kcpBirthDateOrTaxNumber;
    }

    public final String component7() {
        return this.kcpCardPassword;
    }

    public final String component8() {
        return this.postalCode;
    }

    public final boolean component9() {
        return this.isStorePaymentSelected;
    }

    public final CardInputData copy(String str, ExpiryDate expiryDate2, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, InstallmentModel installmentModel) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(expiryDate2, "expiryDate");
        String str8 = str2;
        Intrinsics.checkNotNullParameter(str8, "securityCode");
        String str9 = str3;
        Intrinsics.checkNotNullParameter(str9, "holderName");
        String str10 = str4;
        Intrinsics.checkNotNullParameter(str10, "socialSecurityNumber");
        String str11 = str5;
        Intrinsics.checkNotNullParameter(str11, "kcpBirthDateOrTaxNumber");
        String str12 = str6;
        Intrinsics.checkNotNullParameter(str12, "kcpCardPassword");
        String str13 = str7;
        Intrinsics.checkNotNullParameter(str13, "postalCode");
        return new CardInputData(str, expiryDate2, str8, str9, str10, str11, str12, str13, z, i, installmentModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardInputData)) {
            return false;
        }
        CardInputData cardInputData = (CardInputData) obj;
        return Intrinsics.areEqual(this.cardNumber, cardInputData.cardNumber) && Intrinsics.areEqual(this.expiryDate, cardInputData.expiryDate) && Intrinsics.areEqual(this.securityCode, cardInputData.securityCode) && Intrinsics.areEqual(this.holderName, cardInputData.holderName) && Intrinsics.areEqual(this.socialSecurityNumber, cardInputData.socialSecurityNumber) && Intrinsics.areEqual(this.kcpBirthDateOrTaxNumber, cardInputData.kcpBirthDateOrTaxNumber) && Intrinsics.areEqual(this.kcpCardPassword, cardInputData.kcpCardPassword) && Intrinsics.areEqual(this.postalCode, cardInputData.postalCode) && this.isStorePaymentSelected == cardInputData.isStorePaymentSelected && this.selectedCardIndex == cardInputData.selectedCardIndex && Intrinsics.areEqual(this.installmentOption, cardInputData.installmentOption);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((this.cardNumber.hashCode() * 31) + this.expiryDate.hashCode()) * 31) + this.securityCode.hashCode()) * 31) + this.holderName.hashCode()) * 31) + this.socialSecurityNumber.hashCode()) * 31) + this.kcpBirthDateOrTaxNumber.hashCode()) * 31) + this.kcpCardPassword.hashCode()) * 31) + this.postalCode.hashCode()) * 31;
        boolean z = this.isStorePaymentSelected;
        if (z) {
            z = true;
        }
        int i = (((hashCode + (z ? 1 : 0)) * 31) + this.selectedCardIndex) * 31;
        InstallmentModel installmentModel = this.installmentOption;
        return i + (installmentModel == null ? 0 : installmentModel.hashCode());
    }

    public String toString() {
        return "CardInputData(cardNumber=" + this.cardNumber + ", expiryDate=" + this.expiryDate + ", securityCode=" + this.securityCode + ", holderName=" + this.holderName + ", socialSecurityNumber=" + this.socialSecurityNumber + ", kcpBirthDateOrTaxNumber=" + this.kcpBirthDateOrTaxNumber + ", kcpCardPassword=" + this.kcpCardPassword + ", postalCode=" + this.postalCode + ", isStorePaymentSelected=" + this.isStorePaymentSelected + ", selectedCardIndex=" + this.selectedCardIndex + ", installmentOption=" + this.installmentOption + ')';
    }

    public CardInputData(String str, ExpiryDate expiryDate2, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, InstallmentModel installmentModel) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(expiryDate2, "expiryDate");
        Intrinsics.checkNotNullParameter(str2, "securityCode");
        Intrinsics.checkNotNullParameter(str3, "holderName");
        Intrinsics.checkNotNullParameter(str4, "socialSecurityNumber");
        Intrinsics.checkNotNullParameter(str5, "kcpBirthDateOrTaxNumber");
        Intrinsics.checkNotNullParameter(str6, "kcpCardPassword");
        Intrinsics.checkNotNullParameter(str7, "postalCode");
        this.cardNumber = str;
        this.expiryDate = expiryDate2;
        this.securityCode = str2;
        this.holderName = str3;
        this.socialSecurityNumber = str4;
        this.kcpBirthDateOrTaxNumber = str5;
        this.kcpCardPassword = str6;
        this.postalCode = str7;
        this.isStorePaymentSelected = z;
        this.selectedCardIndex = i;
        this.installmentOption = installmentModel;
    }

    public final String getCardNumber() {
        return this.cardNumber;
    }

    public final void setCardNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardNumber = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CardInputData(java.lang.String r13, com.adyen.checkout.card.data.ExpiryDate r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, boolean r21, int r22, com.adyen.checkout.card.InstallmentModel r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r13
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0017
            com.adyen.checkout.card.data.ExpiryDate r3 = com.adyen.checkout.card.data.ExpiryDate.EMPTY_DATE
            java.lang.String r4 = "EMPTY_DATE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            goto L_0x0018
        L_0x0017:
            r3 = r14
        L_0x0018:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001e
            r4 = r2
            goto L_0x001f
        L_0x001e:
            r4 = r15
        L_0x001f:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0025
            r5 = r2
            goto L_0x0027
        L_0x0025:
            r5 = r16
        L_0x0027:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002d
            r6 = r2
            goto L_0x002f
        L_0x002d:
            r6 = r17
        L_0x002f:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0035
            r7 = r2
            goto L_0x0037
        L_0x0035:
            r7 = r18
        L_0x0037:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003d
            r8 = r2
            goto L_0x003f
        L_0x003d:
            r8 = r19
        L_0x003f:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r2 = r20
        L_0x0046:
            r9 = r0 & 256(0x100, float:3.59E-43)
            r10 = 0
            if (r9 == 0) goto L_0x004d
            r9 = r10
            goto L_0x004f
        L_0x004d:
            r9 = r21
        L_0x004f:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r10 = r22
        L_0x0056:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x005c
            r0 = 0
            goto L_0x005e
        L_0x005c:
            r0 = r23
        L_0x005e:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r2
            r22 = r9
            r23 = r10
            r24 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.CardInputData.<init>(java.lang.String, com.adyen.checkout.card.data.ExpiryDate, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, com.adyen.checkout.card.InstallmentModel, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ExpiryDate getExpiryDate() {
        return this.expiryDate;
    }

    public final void setExpiryDate(ExpiryDate expiryDate2) {
        Intrinsics.checkNotNullParameter(expiryDate2, "<set-?>");
        this.expiryDate = expiryDate2;
    }

    public final String getSecurityCode() {
        return this.securityCode;
    }

    public final void setSecurityCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.securityCode = str;
    }

    public final String getHolderName() {
        return this.holderName;
    }

    public final void setHolderName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.holderName = str;
    }

    public final String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    public final void setSocialSecurityNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.socialSecurityNumber = str;
    }

    public final String getKcpBirthDateOrTaxNumber() {
        return this.kcpBirthDateOrTaxNumber;
    }

    public final void setKcpBirthDateOrTaxNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.kcpBirthDateOrTaxNumber = str;
    }

    public final String getKcpCardPassword() {
        return this.kcpCardPassword;
    }

    public final void setKcpCardPassword(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.kcpCardPassword = str;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public final void setPostalCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.postalCode = str;
    }

    public final boolean isStorePaymentSelected() {
        return this.isStorePaymentSelected;
    }

    public final void setStorePaymentSelected(boolean z) {
        this.isStorePaymentSelected = z;
    }

    public final int getSelectedCardIndex() {
        return this.selectedCardIndex;
    }

    public final void setSelectedCardIndex(int i) {
        this.selectedCardIndex = i;
    }

    public final InstallmentModel getInstallmentOption() {
        return this.installmentOption;
    }

    public final void setInstallmentOption(InstallmentModel installmentModel) {
        this.installmentOption = installmentModel;
    }
}
