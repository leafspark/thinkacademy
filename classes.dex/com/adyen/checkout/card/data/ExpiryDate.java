package com.adyen.checkout.card.data;

public class ExpiryDate {
    public static final ExpiryDate EMPTY_DATE = new ExpiryDate(0, 0, false);
    public static final int EMPTY_VALUE = 0;
    public static final ExpiryDate INVALID_DATE = new ExpiryDate(0, 0, true);
    private final int mExpiryMonth;
    private final int mExpiryYear;
    private final boolean mHasInput;

    public ExpiryDate(int i, int i2, boolean z) {
        this.mExpiryMonth = i;
        this.mExpiryYear = i2;
        this.mHasInput = z;
    }

    public int getExpiryMonth() {
        return this.mExpiryMonth;
    }

    public int getExpiryYear() {
        return this.mExpiryYear;
    }

    public boolean hasInput() {
        return this.mHasInput;
    }
}
