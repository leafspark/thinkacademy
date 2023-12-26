package com.coloros.ocs.base.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class CapabilityInfo implements Parcelable {
    public static final Parcelable.Creator<CapabilityInfo> CREATOR = new Parcelable.Creator<CapabilityInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CapabilityInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CapabilityInfo(parcel);
        }
    };
    private List<Feature> a;
    private int b;
    private AuthResult c;
    private IBinder d;

    public int describeContents() {
        return 0;
    }

    public CapabilityInfo(List<Feature> list, int i, AuthResult authResult) {
        this(list, i, authResult, (IBinder) null);
    }

    public CapabilityInfo(List<Feature> list, int i, AuthResult authResult, IBinder iBinder) {
        this.a = list;
        this.b = i;
        this.c = authResult;
        this.d = iBinder;
    }

    public List<Feature> getFeatures() {
        return this.a;
    }

    public int getVersion() {
        return this.b;
    }

    public AuthResult getAuthResult() {
        return this.c;
    }

    public IBinder getBinder() {
        return this.d;
    }

    public void setBinder(IBinder iBinder) {
        this.d = iBinder;
    }

    protected CapabilityInfo(Parcel parcel) {
        this.a = parcel.readArrayList(Feature.class.getClassLoader());
        this.b = parcel.readInt();
        this.c = (AuthResult) parcel.readParcelable(AuthResult.class.getClassLoader());
        this.d = parcel.readStrongBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.a);
        parcel.writeInt(this.b);
        parcel.writeParcelable(this.c, 0);
        parcel.writeStrongBinder(this.d);
    }
}
