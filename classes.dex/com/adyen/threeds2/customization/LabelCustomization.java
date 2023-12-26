package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;

public final class LabelCustomization extends Customization {
    private String d;
    private String e;
    private int f = -1;
    private String g;
    private String h;
    private int i = -1;

    public String getHeadingTextColor() {
        return this.d;
    }

    public String getHeadingTextFontName() {
        return this.e;
    }

    public int getHeadingTextFontSize() {
        return this.f;
    }

    public String getInputLabelTextColor() {
        return this.g;
    }

    public String getInputLabelTextFontName() {
        return this.h;
    }

    public int getInputLabelTextFontSize() {
        return this.i;
    }

    public void setHeadingTextColor(String str) throws InvalidInputException {
        this.d = a(str);
    }

    public void setHeadingTextFontName(String str) throws InvalidInputException {
        this.e = a("fontName", str);
    }

    public void setHeadingTextFontSize(int i2) throws InvalidInputException {
        this.f = a("fontSize", i2).intValue();
    }

    public void setInputLabelTextColor(String str) throws InvalidInputException {
        this.g = a(str);
    }

    public void setInputLabelTextFontName(String str) throws InvalidInputException {
        this.h = a("fontName", str);
    }

    public void setInputLabelTextFontSize(int i2) throws InvalidInputException {
        this.i = a("fontSize", i2).intValue();
    }
}
