package com.adyen.checkout.core.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.core.exception.CheckoutException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public final class Environment implements Parcelable {
    public static final Environment AUSTRALIA;
    public static final Parcelable.Creator<Environment> CREATOR = new Parcelable.Creator<Environment>() {
        public Environment createFromParcel(Parcel parcel) {
            return new Environment(parcel);
        }

        public Environment[] newArray(int i) {
            return new Environment[i];
        }
    };
    public static final Environment EUROPE;
    public static final Environment LIVE;
    public static final Environment TEST;
    public static final Environment UNITED_STATES;
    private final URL mBaseUrl;

    public int describeContents() {
        return 1;
    }

    static {
        try {
            TEST = new Environment(new URL("https://checkoutshopper-test.adyen.com/checkoutshopper/"));
            Environment environment = new Environment(new URL("https://checkoutshopper-live.adyen.com/checkoutshopper/"));
            EUROPE = environment;
            UNITED_STATES = new Environment(new URL("https://checkoutshopper-live-us.adyen.com/checkoutshopper/"));
            AUSTRALIA = new Environment(new URL("https://checkoutshopper-live-au.adyen.com/checkoutshopper/"));
            LIVE = environment;
        } catch (MalformedURLException e) {
            throw new CheckoutException("Failed to parse Environment URL.", e);
        }
    }

    public Environment(URL url) {
        this.mBaseUrl = url;
    }

    Environment(Parcel parcel) {
        this.mBaseUrl = (URL) parcel.readSerializable();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.mBaseUrl);
    }

    public String getBaseUrl() {
        return this.mBaseUrl.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mBaseUrl.toString().equals(((Environment) obj).mBaseUrl.toString());
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mBaseUrl});
    }
}
