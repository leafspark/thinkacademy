package com.adyen.checkout.card;

import android.view.View;

public final /* synthetic */ class CardView$$ExternalSyntheticLambda18 implements View.OnFocusChangeListener {
    public final /* synthetic */ CardView f$0;

    public /* synthetic */ CardView$$ExternalSyntheticLambda18(CardView cardView) {
        this.f$0 = cardView;
    }

    public final void onFocusChange(View view, boolean z) {
        CardView.m23initExpiryDateInput$lambda15(this.f$0, view, z);
    }
}
