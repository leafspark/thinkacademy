package com.adyen.checkout.card;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/adyen/checkout/card/InstallmentOption;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "ONE_TIME", "REGULAR", "REVOLVING", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstallmentOption.kt */
public enum InstallmentOption {
    ONE_TIME((String) null),
    REGULAR("regular"),
    REVOLVING("revolving");
    
    private final String type;

    private InstallmentOption(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
