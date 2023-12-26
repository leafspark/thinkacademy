package com.tal.app.thinkacademy.live.abilitypack.allonstage.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B+\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001d\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0014H\u0016R%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/cloud/OnStageData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "lowDeviceConfig", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/cloud/DeviceConfig;", "deviceList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/cloud/DeviceConfig;Ljava/util/ArrayList;)V", "getDeviceList", "()Ljava/util/ArrayList;", "getLowDeviceConfig", "()Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/cloud/DeviceConfig;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OnStageData.kt */
public final class OnStageData implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final ArrayList<String> deviceList;
    private final DeviceConfig lowDeviceConfig;

    public static /* synthetic */ OnStageData copy$default(OnStageData onStageData, DeviceConfig deviceConfig, ArrayList<String> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceConfig = onStageData.lowDeviceConfig;
        }
        if ((i & 2) != 0) {
            arrayList = onStageData.deviceList;
        }
        return onStageData.copy(deviceConfig, arrayList);
    }

    public final DeviceConfig component1() {
        return this.lowDeviceConfig;
    }

    public final ArrayList<String> component2() {
        return this.deviceList;
    }

    public final OnStageData copy(DeviceConfig deviceConfig, ArrayList<String> arrayList) {
        return new OnStageData(deviceConfig, arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnStageData)) {
            return false;
        }
        OnStageData onStageData = (OnStageData) obj;
        return Intrinsics.areEqual(this.lowDeviceConfig, onStageData.lowDeviceConfig) && Intrinsics.areEqual(this.deviceList, onStageData.deviceList);
    }

    public int hashCode() {
        DeviceConfig deviceConfig = this.lowDeviceConfig;
        int i = 0;
        int hashCode = (deviceConfig == null ? 0 : deviceConfig.hashCode()) * 31;
        ArrayList<String> arrayList = this.deviceList;
        if (arrayList != null) {
            i = arrayList.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "OnStageData(lowDeviceConfig=" + this.lowDeviceConfig + ", deviceList=" + this.deviceList + ')';
    }

    public OnStageData(DeviceConfig deviceConfig, ArrayList<String> arrayList) {
        this.lowDeviceConfig = deviceConfig;
        this.deviceList = arrayList;
    }

    public final DeviceConfig getLowDeviceConfig() {
        return this.lowDeviceConfig;
    }

    public final ArrayList<String> getDeviceList() {
        return this.deviceList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OnStageData(Parcel parcel) {
        this((DeviceConfig) parcel.readParcelable(DeviceConfig.class.getClassLoader()), parcel.createStringArrayList());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.lowDeviceConfig, i);
        parcel.writeStringList(this.deviceList);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/cloud/OnStageData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/cloud/OnStageData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/cloud/OnStageData;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OnStageData.kt */
    public static final class CREATOR implements Parcelable.Creator<OnStageData> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public OnStageData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OnStageData(parcel);
        }

        public OnStageData[] newArray(int i) {
            return new OnStageData[i];
        }
    }
}
