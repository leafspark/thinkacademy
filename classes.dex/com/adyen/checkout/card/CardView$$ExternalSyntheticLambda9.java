package com.adyen.checkout.card;

import android.text.Editable;
import com.adyen.checkout.components.ui.view.AdyenTextInputEditText;

public final /* synthetic */ class CardView$$ExternalSyntheticLambda9 implements AdyenTextInputEditText.Listener {
    public final /* synthetic */ CardView f$0;

    public /* synthetic */ CardView$$ExternalSyntheticLambda9(CardView cardView) {
        this.f$0 = cardView;
    }

    public final void onTextChanged(Editable editable) {
        CardView.m31initPostalCodeInput$lambda26(this.f$0, editable);
    }
}
