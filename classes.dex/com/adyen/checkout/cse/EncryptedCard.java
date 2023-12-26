package com.adyen.checkout.cse;

import android.os.Parcel;
import android.os.Parcelable;

public final class EncryptedCard implements Parcelable {
    public static final Parcelable.Creator<EncryptedCard> CREATOR = new Parcelable.Creator<EncryptedCard>() {
        public EncryptedCard createFromParcel(Parcel parcel) {
            return new EncryptedCard(parcel);
        }

        public EncryptedCard[] newArray(int i) {
            return new EncryptedCard[i];
        }
    };
    private final String mEncryptedCardNumber;
    private final String mEncryptedExpiryMonth;
    private final String mEncryptedExpiryYear;
    private final String mEncryptedSecurityCode;

    public int describeContents() {
        return 1;
    }

    EncryptedCard(String str, String str2, String str3, String str4) {
        this.mEncryptedCardNumber = str;
        this.mEncryptedExpiryMonth = str2;
        this.mEncryptedExpiryYear = str3;
        this.mEncryptedSecurityCode = str4;
    }

    private EncryptedCard(Parcel parcel) {
        this.mEncryptedCardNumber = parcel.readString();
        this.mEncryptedExpiryMonth = parcel.readString();
        this.mEncryptedExpiryYear = parcel.readString();
        this.mEncryptedSecurityCode = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mEncryptedCardNumber);
        parcel.writeString(this.mEncryptedExpiryMonth);
        parcel.writeString(this.mEncryptedExpiryYear);
        parcel.writeString(this.mEncryptedSecurityCode);
    }

    public String getEncryptedCardNumber() {
        return this.mEncryptedCardNumber;
    }

    public String getEncryptedExpiryMonth() {
        return this.mEncryptedExpiryMonth;
    }

    public String getEncryptedExpiryYear() {
        return this.mEncryptedExpiryYear;
    }

    public String getEncryptedSecurityCode() {
        return this.mEncryptedSecurityCode;
    }
}
