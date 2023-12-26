package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.Objects;

public class DeviceStateInfoBean {
    @SerializedName("auc")
    public int mAppUsedCpu;
    @SerializedName("aura")
    public int mAppUsedMemory;
    @SerializedName("sab")
    public int mBattery;
    @SerializedName("ib")
    public Boolean mBluetoothOpen;
    @SerializedName("igo")
    public Boolean mGpsIsOpen = Boolean.FALSE;
    @SerializedName("ot")
    public Byte mOrientation;
    @SerializedName("iolo")
    public Boolean mOrientationLockOpen;
    @SerializedName("s")
    public long mSignal;
    @SerializedName("sara")
    public int mSystemUsableMemory;
    @SerializedName("suc")
    public int mSystemUsedCpu;
    @SerializedName("saro")
    public int mUsableStorage;

    public String toString() {
        return "DeviceStateInfoBean{mSystemUsedCpu=" + this.mSystemUsedCpu + ", mAppUsedCpu=" + this.mAppUsedCpu + ", mAppUsedMemory=" + this.mAppUsedMemory + ", mBattery=" + this.mBattery + ", mUsableStorage=" + this.mUsableStorage + ", mSystemUsableMemory=" + this.mSystemUsableMemory + ", mBluetoothOpen=" + this.mBluetoothOpen + ", mGpsIsOpen=" + this.mGpsIsOpen + ", mOrientationLockOpen=" + this.mOrientationLockOpen + ", mOrientation=" + this.mOrientation + ", mSignal=" + this.mSignal + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DeviceStateInfoBean deviceStateInfoBean = (DeviceStateInfoBean) obj;
            return Float.compare((float) deviceStateInfoBean.mSystemUsedCpu, (float) this.mSystemUsedCpu) == 0 && Float.compare((float) deviceStateInfoBean.mAppUsedCpu, (float) this.mAppUsedCpu) == 0 && Float.compare((float) deviceStateInfoBean.mAppUsedMemory, (float) this.mAppUsedMemory) == 0 && this.mBattery == deviceStateInfoBean.mBattery && Float.compare((float) deviceStateInfoBean.mUsableStorage, (float) this.mUsableStorage) == 0 && Float.compare((float) deviceStateInfoBean.mSystemUsableMemory, (float) this.mSystemUsableMemory) == 0 && equals(this.mBluetoothOpen, deviceStateInfoBean.mBluetoothOpen) && equals(this.mGpsIsOpen, deviceStateInfoBean.mGpsIsOpen) && equals(this.mOrientationLockOpen, deviceStateInfoBean.mOrientationLockOpen) && equals(this.mOrientation, deviceStateInfoBean.mOrientation) && this.mSignal == deviceStateInfoBean.mSignal;
        }
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mSystemUsedCpu), Integer.valueOf(this.mAppUsedCpu), Integer.valueOf(this.mAppUsedMemory), Integer.valueOf(this.mBattery), Integer.valueOf(this.mUsableStorage), Integer.valueOf(this.mSystemUsableMemory), this.mBluetoothOpen, this.mGpsIsOpen, this.mOrientationLockOpen, this.mOrientation, Long.valueOf(this.mSignal)});
    }
}
