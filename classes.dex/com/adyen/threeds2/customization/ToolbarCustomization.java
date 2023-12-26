package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;

public final class ToolbarCustomization extends Customization {
    private String d;
    private String e;
    private String f;

    public String getBackgroundColor() {
        return this.d;
    }

    public String getButtonText() {
        return this.f;
    }

    public String getHeaderText() {
        return this.e;
    }

    public void setBackgroundColor(String str) throws InvalidInputException {
        this.d = a(str);
    }

    public void setButtonText(String str) throws InvalidInputException {
        this.f = a("buttonText", str);
    }

    public void setHeaderText(String str) throws InvalidInputException {
        this.e = a("headerText", str);
    }
}
