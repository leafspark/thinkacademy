package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;

public final class TextBoxCustomization extends Customization {
    private String d;
    private int e = -1;
    private int f = -1;

    public String getBorderColor() {
        return this.d;
    }

    public int getBorderWidth() {
        return this.e;
    }

    public int getCornerRadius() {
        return this.f;
    }

    public void setBorderColor(String str) throws InvalidInputException {
        this.d = a(str);
    }

    public void setBorderWidth(int i) throws InvalidInputException {
        this.e = a("borderWidth", i).intValue();
    }

    public void setCornerRadius(int i) throws InvalidInputException {
        this.f = a("cornerRadius", i).intValue();
    }
}
