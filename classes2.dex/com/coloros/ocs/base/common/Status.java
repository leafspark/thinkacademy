package com.coloros.ocs.base.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.coloros.ocs.base.a.e;
import com.coloros.ocs.base.common.constant.CommonStatusCodes;
import com.coloros.ocs.base.internal.safeparcel.AbstractSafeParcelable;
import com.coloros.ocs.base.internal.safeparcel.b;
import com.huawei.multimedia.audiokit.config.ResultCode;
import java.util.Arrays;

public class Status extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new b();
    private int a;
    private int b;
    private String c;
    private PendingIntent d;

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = pendingIntent;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b), this.c, this.d});
    }

    public String toString() {
        e.a a2 = e.a(this);
        String str = this.c;
        if (str == null) {
            str = CommonStatusCodes.getStatusCodeString(this.b);
        }
        return a2.a("statusCode", str).a("resolution", this.d).toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Status) {
            Status status = (Status) obj;
            return this.a == status.a && this.b == status.b && e.a(this.c, status.c) && e.a(this.d, status.d);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel, 20293);
        b.a(parcel, 1, this.b);
        b.a(parcel, ResultCode.KARAOKE_SUCCESS, this.a);
        String str = this.c;
        if (str != null) {
            int b3 = b.b(parcel, 2);
            parcel.writeString(str);
            b.a(parcel, b3);
        }
        PendingIntent pendingIntent = this.d;
        if (pendingIntent != null) {
            int b4 = b.b(parcel, 3);
            pendingIntent.writeToParcel(parcel, i);
            b.a(parcel, b4);
        }
        b.a(parcel, b2);
    }
}
