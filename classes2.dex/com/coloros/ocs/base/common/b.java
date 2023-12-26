package com.coloros.ocs.base.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.coloros.ocs.base.internal.safeparcel.a;
import com.facebook.soloader.MinElf;

final class b implements Parcelable.Creator<Status> {
    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Status[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcelable parcelable;
        int readInt = parcel.readInt();
        int b = a.b(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if ((readInt & MinElf.PN_XNUM) == 20293) {
            int i = b + dataPosition;
            if (i < dataPosition || i > parcel.dataSize()) {
                throw new a.C0025a("Size read is invalid start=" + dataPosition + " end=" + i);
            }
            int i2 = 0;
            int i3 = 0;
            String str = null;
            PendingIntent pendingIntent = null;
            while (parcel.dataPosition() < i) {
                int readInt2 = parcel.readInt();
                int i4 = readInt2 & MinElf.PN_XNUM;
                if (i4 == 1) {
                    i3 = a.a(parcel, readInt2);
                } else if (i4 == 2) {
                    int b2 = a.b(parcel, readInt2);
                    int dataPosition2 = parcel.dataPosition();
                    if (b2 == 0) {
                        str = null;
                    } else {
                        String readString = parcel.readString();
                        parcel.setDataPosition(dataPosition2 + b2);
                        str = readString;
                    }
                } else if (i4 == 3) {
                    Parcelable.Creator creator = PendingIntent.CREATOR;
                    int b3 = a.b(parcel, readInt2);
                    int dataPosition3 = parcel.dataPosition();
                    if (b3 == 0) {
                        parcelable = null;
                    } else {
                        parcelable = (Parcelable) creator.createFromParcel(parcel);
                        parcel.setDataPosition(dataPosition3 + b3);
                    }
                    pendingIntent = (PendingIntent) parcelable;
                } else if (i4 != 1000) {
                    parcel.setDataPosition(parcel.dataPosition() + a.b(parcel, readInt2));
                } else {
                    i2 = a.a(parcel, readInt2);
                }
            }
            if (parcel.dataPosition() == i) {
                return new Status(i2, i3, str, pendingIntent);
            }
            throw new a.C0025a("Overread allowed size end=".concat(String.valueOf(i)));
        }
        throw new a.C0025a("Expected object header. Got 0x" + Integer.toHexString(readInt));
    }
}
