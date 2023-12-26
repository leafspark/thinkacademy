package com.tal.app.thinkacademy.common.business.cloudcontrol.api;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BK\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jb\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020#H\u0016J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\b\u0010'\u001a\u0004\u0018\u00010\u0006J\t\u0010(\u001a\u00020#HÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\u0018\u0010*\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010,\u001a\u00020#H\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006."}, d2 = {"Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudItem;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "configKey", "", "configValue", "configDes", "configGray", "configGrayHit", "", "configDefaultValue", "lastUpdateTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getConfigDefaultValue", "()Ljava/lang/String;", "getConfigDes", "getConfigGray", "getConfigGrayHit", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getConfigKey", "getConfigValue", "getLastUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudItem;", "describeContents", "", "equals", "other", "", "getValue", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CloudData.kt */
public final class CloudItem implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final String configDefaultValue;
    private final String configDes;
    private final String configGray;
    private final Boolean configGrayHit;
    private final String configKey;
    private final String configValue;
    private final String lastUpdateTime;

    public static /* synthetic */ CloudItem copy$default(CloudItem cloudItem, String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cloudItem.configKey;
        }
        if ((i & 2) != 0) {
            str2 = cloudItem.configValue;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = cloudItem.configDes;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = cloudItem.configGray;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            bool = cloudItem.configGrayHit;
        }
        Boolean bool2 = bool;
        if ((i & 32) != 0) {
            str5 = cloudItem.configDefaultValue;
        }
        String str10 = str5;
        if ((i & 64) != 0) {
            str6 = cloudItem.lastUpdateTime;
        }
        return cloudItem.copy(str, str7, str8, str9, bool2, str10, str6);
    }

    public final String component1() {
        return this.configKey;
    }

    public final String component2() {
        return this.configValue;
    }

    public final String component3() {
        return this.configDes;
    }

    public final String component4() {
        return this.configGray;
    }

    public final Boolean component5() {
        return this.configGrayHit;
    }

    public final String component6() {
        return this.configDefaultValue;
    }

    public final String component7() {
        return this.lastUpdateTime;
    }

    public final CloudItem copy(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6) {
        return new CloudItem(str, str2, str3, str4, bool, str5, str6);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloudItem)) {
            return false;
        }
        CloudItem cloudItem = (CloudItem) obj;
        return Intrinsics.areEqual(this.configKey, cloudItem.configKey) && Intrinsics.areEqual(this.configValue, cloudItem.configValue) && Intrinsics.areEqual(this.configDes, cloudItem.configDes) && Intrinsics.areEqual(this.configGray, cloudItem.configGray) && Intrinsics.areEqual(this.configGrayHit, cloudItem.configGrayHit) && Intrinsics.areEqual(this.configDefaultValue, cloudItem.configDefaultValue) && Intrinsics.areEqual(this.lastUpdateTime, cloudItem.lastUpdateTime);
    }

    public int hashCode() {
        String str = this.configKey;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.configValue;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.configDes;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.configGray;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.configGrayHit;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str5 = this.configDefaultValue;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.lastUpdateTime;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "CloudItem(configKey=" + this.configKey + ", configValue=" + this.configValue + ", configDes=" + this.configDes + ", configGray=" + this.configGray + ", configGrayHit=" + this.configGrayHit + ", configDefaultValue=" + this.configDefaultValue + ", lastUpdateTime=" + this.lastUpdateTime + ')';
    }

    public CloudItem(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6) {
        this.configKey = str;
        this.configValue = str2;
        this.configDes = str3;
        this.configGray = str4;
        this.configGrayHit = bool;
        this.configDefaultValue = str5;
        this.lastUpdateTime = str6;
    }

    public final String getConfigKey() {
        return this.configKey;
    }

    public final String getConfigValue() {
        return this.configValue;
    }

    public final String getConfigDes() {
        return this.configDes;
    }

    public final String getConfigGray() {
        return this.configGray;
    }

    public final Boolean getConfigGrayHit() {
        return this.configGrayHit;
    }

    public final String getConfigDefaultValue() {
        return this.configDefaultValue;
    }

    public final String getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CloudItem(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), Boolean.valueOf(parcel.readByte() != 0), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    public final String getValue() {
        if (Intrinsics.areEqual(this.configGrayHit, true)) {
            return this.configValue;
        }
        return this.configDefaultValue;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.configKey);
        parcel.writeString(this.configValue);
        parcel.writeString(this.configDes);
        parcel.writeString(this.configGray);
        parcel.writeByte(Intrinsics.areEqual(this.configGrayHit, true) ? (byte) 1 : 0);
        parcel.writeString(this.configDefaultValue);
        parcel.writeString(this.lastUpdateTime);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudItem;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudItem;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CloudData.kt */
    public static final class CREATOR implements Parcelable.Creator<CloudItem> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public CloudItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CloudItem(parcel);
        }

        public CloudItem[] newArray(int i) {
            return new CloudItem[i];
        }
    }
}
