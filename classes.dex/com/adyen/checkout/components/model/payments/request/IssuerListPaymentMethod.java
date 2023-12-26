package com.adyen.checkout.components.model.payments.request;

public abstract class IssuerListPaymentMethod extends PaymentMethodDetails {
    static final String ISSUER = "issuer";
    private String issuer;

    public String getIssuer() {
        return this.issuer;
    }

    public void setIssuer(String str) {
        this.issuer = str;
    }
}
