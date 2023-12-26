package com.adyen.checkout.card;

import android.text.Editable;
import com.adyen.checkout.components.ui.view.AdyenTextInputEditText;

public final /* synthetic */ class CardView$$ExternalSyntheticLambda6 implements AdyenTextInputEditText.Listener {
    public final /* synthetic */ CardView f$0;

    public /* synthetic */ CardView$$ExternalSyntheticLambda6(CardView cardView) {
        this.f$0 = cardView;
    }

    public final void onTextChanged(Editable editable) {
        CardView.m24initHolderNameInput$lambda18(this.f$0, editable);
    }
}
