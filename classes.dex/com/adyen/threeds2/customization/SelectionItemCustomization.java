package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;

public final class SelectionItemCustomization extends Customization {
    private String d;
    private String e;
    private String f;
    private int g = -1;

    public String getBorderColor() {
        return this.f;
    }

    public int getBorderWidth() {
        return this.g;
    }

    public String getHighlightedBackgroundColor() {
        return this.e;
    }

    public String getSelectionIndicatorTintColor() {
        return this.d;
    }

    public void setBorderColor(String str) throws InvalidInputException {
        this.f = a(str);
    }

    public void setBorderWidth(int i) throws InvalidInputException {
        this.g = a("borderWidth", i).intValue();
    }

    public void setHighlightedBackgroundColor(String str) throws InvalidInputException {
        this.e = a(str);
    }

    public void setSelectionIndicatorTintColor(String str) throws InvalidInputException {
        this.d = a(str);
    }
}
