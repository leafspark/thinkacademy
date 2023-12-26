package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;

public final class ExpandableInfoCustomization extends Customization {
    private String d;
    private String e;
    private int f = -1;
    private String g;
    private int h = -1;
    private String i;
    private String j;

    public String getBorderColor() {
        return this.g;
    }

    public int getBorderWidth() {
        return this.h;
    }

    public String getExpandedStateIndicatorColor() {
        return this.i;
    }

    public String getHeadingTextColor() {
        return this.d;
    }

    public String getHeadingTextFontName() {
        return this.e;
    }

    public int getHeadingTextFontSize() {
        return this.f;
    }

    public String getHighlightedBackgroundColor() {
        return this.j;
    }

    public void setBorderColor(String str) throws InvalidInputException {
        this.g = a(str);
    }

    public void setBorderWidth(int i2) throws InvalidInputException {
        this.h = a("borderWidth", i2).intValue();
    }

    public void setExpandStateIndicatorColor(String str) throws InvalidInputException {
        this.i = a(str);
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

    public void setHighlightedBackgroundColor(String str) throws InvalidInputException {
        this.j = a(str);
    }
}
