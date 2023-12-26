package com.adyen.checkout.card.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import com.adyen.checkout.card.R;
import com.adyen.checkout.card.ui.CardNumberInput;
import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.adyen.checkout.card.ui.SecurityCodeInput;
import com.adyen.checkout.card.ui.SocialSecurityNumberInput;
import com.adyen.checkout.components.ui.view.AdyenTextInputEditText;
import com.adyen.checkout.components.ui.view.RoundCornerImageView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Objects;

public final class CardViewBinding implements ViewBinding {
    public final AppCompatAutoCompleteTextView autoCompleteTextViewInstallments;
    public final LinearLayout cardBrandLogoContainer;
    public final FrameLayout cardBrandLogoContainerPrimary;
    public final FrameLayout cardBrandLogoContainerSecondary;
    public final RoundCornerImageView cardBrandLogoImageViewPrimary;
    public final RoundCornerImageView cardBrandLogoImageViewSecondary;
    public final AdyenTextInputEditText editTextCardHolder;
    public final CardNumberInput editTextCardNumber;
    public final ExpiryDateInput editTextExpiryDate;
    public final AdyenTextInputEditText editTextKcpBirthDateOrTaxNumber;
    public final AdyenTextInputEditText editTextKcpCardPassword;
    public final AdyenTextInputEditText editTextPostalCode;
    public final SecurityCodeInput editTextSecurityCode;
    public final SocialSecurityNumberInput editTextSocialSecurityNumber;
    private final View rootView;
    public final SwitchCompat switchStorePaymentMethod;
    public final TextInputLayout textInputLayoutCardHolder;
    public final TextInputLayout textInputLayoutCardNumber;
    public final TextInputLayout textInputLayoutExpiryDate;
    public final TextInputLayout textInputLayoutInstallments;
    public final TextInputLayout textInputLayoutKcpBirthDateOrTaxNumber;
    public final TextInputLayout textInputLayoutKcpCardPassword;
    public final TextInputLayout textInputLayoutPostalCode;
    public final TextInputLayout textInputLayoutSecurityCode;
    public final TextInputLayout textInputLayoutSocialSecurityNumber;

    private CardViewBinding(View view, AppCompatAutoCompleteTextView appCompatAutoCompleteTextView, LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, RoundCornerImageView roundCornerImageView, RoundCornerImageView roundCornerImageView2, AdyenTextInputEditText adyenTextInputEditText, CardNumberInput cardNumberInput, ExpiryDateInput expiryDateInput, AdyenTextInputEditText adyenTextInputEditText2, AdyenTextInputEditText adyenTextInputEditText3, AdyenTextInputEditText adyenTextInputEditText4, SecurityCodeInput securityCodeInput, SocialSecurityNumberInput socialSecurityNumberInput, SwitchCompat switchCompat, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, TextInputLayout textInputLayout4, TextInputLayout textInputLayout5, TextInputLayout textInputLayout6, TextInputLayout textInputLayout7, TextInputLayout textInputLayout8, TextInputLayout textInputLayout9) {
        this.rootView = view;
        this.autoCompleteTextViewInstallments = appCompatAutoCompleteTextView;
        this.cardBrandLogoContainer = linearLayout;
        this.cardBrandLogoContainerPrimary = frameLayout;
        this.cardBrandLogoContainerSecondary = frameLayout2;
        this.cardBrandLogoImageViewPrimary = roundCornerImageView;
        this.cardBrandLogoImageViewSecondary = roundCornerImageView2;
        this.editTextCardHolder = adyenTextInputEditText;
        this.editTextCardNumber = cardNumberInput;
        this.editTextExpiryDate = expiryDateInput;
        this.editTextKcpBirthDateOrTaxNumber = adyenTextInputEditText2;
        this.editTextKcpCardPassword = adyenTextInputEditText3;
        this.editTextPostalCode = adyenTextInputEditText4;
        this.editTextSecurityCode = securityCodeInput;
        this.editTextSocialSecurityNumber = socialSecurityNumberInput;
        this.switchStorePaymentMethod = switchCompat;
        this.textInputLayoutCardHolder = textInputLayout;
        this.textInputLayoutCardNumber = textInputLayout2;
        this.textInputLayoutExpiryDate = textInputLayout3;
        this.textInputLayoutInstallments = textInputLayout4;
        this.textInputLayoutKcpBirthDateOrTaxNumber = textInputLayout5;
        this.textInputLayoutKcpCardPassword = textInputLayout6;
        this.textInputLayoutPostalCode = textInputLayout7;
        this.textInputLayoutSecurityCode = textInputLayout8;
        this.textInputLayoutSocialSecurityNumber = textInputLayout9;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static CardViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        int i = R.layout.card_view;
        if (!(layoutInflater instanceof LayoutInflater)) {
            layoutInflater.inflate(i, viewGroup);
        } else {
            XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup);
        }
        return bind(viewGroup);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0098, code lost:
        r0 = com.adyen.checkout.card.R.id.textInputLayout_cardHolder;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a2, code lost:
        r0 = com.adyen.checkout.card.R.id.textInputLayout_cardNumber;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ac, code lost:
        r0 = com.adyen.checkout.card.R.id.textInputLayout_expiryDate;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b6, code lost:
        r0 = com.adyen.checkout.card.R.id.textInputLayout_installments;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c0, code lost:
        r0 = com.adyen.checkout.card.R.id.textInputLayout_kcpBirthDateOrTaxNumber;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ca, code lost:
        r0 = com.adyen.checkout.card.R.id.textInputLayout_kcpCardPassword;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d4, code lost:
        r0 = com.adyen.checkout.card.R.id.textInputLayout_postalCode;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00de, code lost:
        r0 = com.adyen.checkout.card.R.id.textInputLayout_securityCode;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e8, code lost:
        r0 = com.adyen.checkout.card.R.id.textInputLayout_socialSecurityNumber;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.adyen.checkout.card.databinding.CardViewBinding bind(android.view.View r27) {
        /*
            r1 = r27
            int r0 = com.adyen.checkout.card.R.id.autoCompleteTextView_installments
            android.view.View r2 = r1.findViewById(r0)
            androidx.appcompat.widget.AppCompatAutoCompleteTextView r2 = (androidx.appcompat.widget.AppCompatAutoCompleteTextView) r2
            if (r2 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.cardBrandLogo_container
            android.view.View r3 = r1.findViewById(r0)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            if (r3 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.cardBrandLogo_container_primary
            android.view.View r4 = r1.findViewById(r0)
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            if (r4 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.cardBrandLogo_container_secondary
            android.view.View r5 = r1.findViewById(r0)
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            if (r5 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.cardBrandLogo_imageView_primary
            android.view.View r6 = r1.findViewById(r0)
            com.adyen.checkout.components.ui.view.RoundCornerImageView r6 = (com.adyen.checkout.components.ui.view.RoundCornerImageView) r6
            if (r6 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.cardBrandLogo_imageView_secondary
            android.view.View r7 = r1.findViewById(r0)
            com.adyen.checkout.components.ui.view.RoundCornerImageView r7 = (com.adyen.checkout.components.ui.view.RoundCornerImageView) r7
            if (r7 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.editText_cardHolder
            android.view.View r8 = r1.findViewById(r0)
            com.adyen.checkout.components.ui.view.AdyenTextInputEditText r8 = (com.adyen.checkout.components.ui.view.AdyenTextInputEditText) r8
            if (r8 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.editText_cardNumber
            android.view.View r9 = r1.findViewById(r0)
            com.adyen.checkout.card.ui.CardNumberInput r9 = (com.adyen.checkout.card.ui.CardNumberInput) r9
            if (r9 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.editText_expiryDate
            android.view.View r10 = r1.findViewById(r0)
            com.adyen.checkout.card.ui.ExpiryDateInput r10 = (com.adyen.checkout.card.ui.ExpiryDateInput) r10
            if (r10 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.editText_kcpBirthDateOrTaxNumber
            android.view.View r11 = r1.findViewById(r0)
            com.adyen.checkout.components.ui.view.AdyenTextInputEditText r11 = (com.adyen.checkout.components.ui.view.AdyenTextInputEditText) r11
            if (r11 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.editText_kcpCardPassword
            android.view.View r12 = r1.findViewById(r0)
            com.adyen.checkout.components.ui.view.AdyenTextInputEditText r12 = (com.adyen.checkout.components.ui.view.AdyenTextInputEditText) r12
            if (r12 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.editText_postalCode
            android.view.View r13 = r1.findViewById(r0)
            com.adyen.checkout.components.ui.view.AdyenTextInputEditText r13 = (com.adyen.checkout.components.ui.view.AdyenTextInputEditText) r13
            if (r13 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.editText_securityCode
            android.view.View r14 = r1.findViewById(r0)
            com.adyen.checkout.card.ui.SecurityCodeInput r14 = (com.adyen.checkout.card.ui.SecurityCodeInput) r14
            if (r14 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.editText_socialSecurityNumber
            android.view.View r15 = r1.findViewById(r0)
            com.adyen.checkout.card.ui.SocialSecurityNumberInput r15 = (com.adyen.checkout.card.ui.SocialSecurityNumberInput) r15
            if (r15 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.switch_storePaymentMethod
            android.view.View r16 = r1.findViewById(r0)
            androidx.appcompat.widget.SwitchCompat r16 = (androidx.appcompat.widget.SwitchCompat) r16
            if (r16 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.textInputLayout_cardHolder
            android.view.View r17 = r1.findViewById(r0)
            com.google.android.material.textfield.TextInputLayout r17 = (com.google.android.material.textfield.TextInputLayout) r17
            if (r17 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.textInputLayout_cardNumber
            android.view.View r18 = r1.findViewById(r0)
            com.google.android.material.textfield.TextInputLayout r18 = (com.google.android.material.textfield.TextInputLayout) r18
            if (r18 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.textInputLayout_expiryDate
            android.view.View r19 = r1.findViewById(r0)
            com.google.android.material.textfield.TextInputLayout r19 = (com.google.android.material.textfield.TextInputLayout) r19
            if (r19 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.textInputLayout_installments
            android.view.View r20 = r1.findViewById(r0)
            com.google.android.material.textfield.TextInputLayout r20 = (com.google.android.material.textfield.TextInputLayout) r20
            if (r20 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.textInputLayout_kcpBirthDateOrTaxNumber
            android.view.View r21 = r1.findViewById(r0)
            com.google.android.material.textfield.TextInputLayout r21 = (com.google.android.material.textfield.TextInputLayout) r21
            if (r21 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.textInputLayout_kcpCardPassword
            android.view.View r22 = r1.findViewById(r0)
            com.google.android.material.textfield.TextInputLayout r22 = (com.google.android.material.textfield.TextInputLayout) r22
            if (r22 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.textInputLayout_postalCode
            android.view.View r23 = r1.findViewById(r0)
            com.google.android.material.textfield.TextInputLayout r23 = (com.google.android.material.textfield.TextInputLayout) r23
            if (r23 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.textInputLayout_securityCode
            android.view.View r24 = r1.findViewById(r0)
            com.google.android.material.textfield.TextInputLayout r24 = (com.google.android.material.textfield.TextInputLayout) r24
            if (r24 == 0) goto L_0x00fc
            int r0 = com.adyen.checkout.card.R.id.textInputLayout_socialSecurityNumber
            android.view.View r25 = r1.findViewById(r0)
            com.google.android.material.textfield.TextInputLayout r25 = (com.google.android.material.textfield.TextInputLayout) r25
            if (r25 == 0) goto L_0x00fc
            com.adyen.checkout.card.databinding.CardViewBinding r26 = new com.adyen.checkout.card.databinding.CardViewBinding
            r0 = r26
            r1 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return r26
        L_0x00fc:
            android.content.res.Resources r1 = r27.getResources()
            java.lang.String r0 = r1.getResourceName(r0)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.databinding.CardViewBinding.bind(android.view.View):com.adyen.checkout.card.databinding.CardViewBinding");
    }
}
