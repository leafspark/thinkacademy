package com.tal.app.thinkacademy.live.abilitypack.redpackagerain.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0006H\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/cloud/DeviceConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "minSdkVersion", "", "minRam", "(II)V", "getMinRam", "()I", "getMinSdkVersion", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "flags", "CREATOR", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainData.kt */
public final class DeviceConfig implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final int minRam;
    private final int minSdkVersion;

    public DeviceConfig() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DeviceConfig copy$default(DeviceConfig deviceConfig, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = deviceConfig.minSdkVersion;
        }
        if ((i3 & 2) != 0) {
            i2 = deviceConfig.minRam;
        }
        return deviceConfig.copy(i, i2);
    }

    public final int component1() {
        return this.minSdkVersion;
    }

    public final int component2() {
        return this.minRam;
    }

    public final DeviceConfig copy(int i, int i2) {
        return new DeviceConfig(i, i2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceConfig)) {
            return false;
        }
        DeviceConfig deviceConfig = (DeviceConfig) obj;
        return this.minSdkVersion == deviceConfig.minSdkVersion && this.minRam == deviceConfig.minRam;
    }

    public int hashCode() {
        return (this.minSdkVersion * 31) + this.minRam;
    }

    public String toString() {
        return "DeviceConfig(minSdkVersion=" + this.minSdkVersion + ", minRam=" + this.minRam + ')';
    }

    public DeviceConfig(int i, int i2) {
        this.minSdkVersion = i;
        this.minRam = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceConfig(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getMinSdkVersion() {
        return this.minSdkVersion;
    }

    public final int getMinRam() {
        return this.minRam;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeviceConfig(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeInt(this.minSdkVersion);
        parcel.writeInt(this.minRam);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/cloud/DeviceConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/cloud/DeviceConfig;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/cloud/DeviceConfig;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RedPackageRainData.kt */
    public static final class CREATOR implements Parcelable.Creator<DeviceConfig> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public DeviceConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DeviceConfig(parcel);
        }

        public DeviceConfig[] newArray(int i) {
            return new DeviceConfig[i];
        }
    }
}
