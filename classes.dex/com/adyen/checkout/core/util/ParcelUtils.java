package com.adyen.checkout.core.util;

import android.os.Parcel;
import com.adyen.checkout.core.exception.NoConstructorException;

public final class ParcelUtils {
    private static final int BOOLEAN_FALSE_VALUE = 0;
    private static final int BOOLEAN_TRUE_VALUE = 1;

    private ParcelUtils() {
        throw new NoConstructorException();
    }

    public static void writeBoolean(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static boolean readBoolean(Parcel parcel) {
        return parcel.readInt() == 1;
    }
}
