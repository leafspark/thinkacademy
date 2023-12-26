package com.coloros.ocs.base.internal.safeparcel;

import android.os.Parcel;
import com.facebook.soloader.MinElf;

public final class a {
    public static int a(Parcel parcel, int i) {
        c(parcel, i);
        return parcel.readInt();
    }

    public static int b(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & MinElf.PN_XNUM : parcel.readInt();
    }

    private static void c(Parcel parcel, int i) {
        int b = b(parcel, i);
        if (b != 4) {
            throw new C0025a("Expected size 4 got " + b + " (0x" + Integer.toHexString(b) + ")");
        }
    }

    /* renamed from: com.coloros.ocs.base.internal.safeparcel.a$a  reason: collision with other inner class name */
    public static class C0025a extends RuntimeException {
        public C0025a(String str) {
            super(str);
        }
    }
}
