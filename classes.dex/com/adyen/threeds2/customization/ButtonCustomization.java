package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;

public final class ButtonCustomization extends Customization {
    private String d;
    private int e = -1;

    public String getBackgroundColor() {
        return this.d;
    }

    public int getCornerRadius() {
        return this.e;
    }

    public void setBackgroundColor(String str) throws InvalidInputException {
        this.d = a(str);
    }

    public void setCornerRadius(int i) throws InvalidInputException {
        this.e = a("cornerRadius", i).intValue();
    }
}
