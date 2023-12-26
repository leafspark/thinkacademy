package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;

public final class ScreenCustomization extends Customization {
    private String d;
    private String e;

    public String getBackgroundColor() {
        return this.e;
    }

    public String getStatusBarColor() {
        return this.d;
    }

    public void setBackgroundColor(String str) throws InvalidInputException {
        this.e = a(str);
    }

    public void setStatusBarColor(String str) {
        this.d = a(str);
    }
}
