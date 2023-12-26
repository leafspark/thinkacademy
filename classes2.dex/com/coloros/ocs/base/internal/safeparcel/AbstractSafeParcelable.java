package com.coloros.ocs.base.internal.safeparcel;

public abstract class AbstractSafeParcelable implements SafeParcelable {
    public final int describeContents() {
        return 0;
    }
}
