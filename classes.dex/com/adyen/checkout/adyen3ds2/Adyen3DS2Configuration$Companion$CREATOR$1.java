package com.adyen.checkout.adyen3ds2;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/adyen/checkout/adyen3ds2/Adyen3DS2Configuration$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration;", "createFromParcel", "in", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration;", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Adyen3DS2Configuration.kt */
public final class Adyen3DS2Configuration$Companion$CREATOR$1 implements Parcelable.Creator<Adyen3DS2Configuration> {
    Adyen3DS2Configuration$Companion$CREATOR$1() {
    }

    public Adyen3DS2Configuration createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "in");
        return new Adyen3DS2Configuration(parcel, (DefaultConstructorMarker) null);
    }

    public Adyen3DS2Configuration[] newArray(int i) {
        return new Adyen3DS2Configuration[i];
    }
}
