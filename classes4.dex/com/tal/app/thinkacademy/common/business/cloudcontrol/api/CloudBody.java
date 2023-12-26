package com.tal.app.thinkacademy.common.business.cloudcontrol.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudBody;", "", "appCode", "", "deviceId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppCode", "()Ljava/lang/String;", "setAppCode", "(Ljava/lang/String;)V", "getDeviceId", "setDeviceId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CloudBody.kt */
public final class CloudBody {
    private String appCode;
    private String deviceId;

    public static /* synthetic */ CloudBody copy$default(CloudBody cloudBody, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cloudBody.appCode;
        }
        if ((i & 2) != 0) {
            str2 = cloudBody.deviceId;
        }
        return cloudBody.copy(str, str2);
    }

    public final String component1() {
        return this.appCode;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final CloudBody copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "appCode");
        Intrinsics.checkNotNullParameter(str2, "deviceId");
        return new CloudBody(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloudBody)) {
            return false;
        }
        CloudBody cloudBody = (CloudBody) obj;
        return Intrinsics.areEqual(this.appCode, cloudBody.appCode) && Intrinsics.areEqual(this.deviceId, cloudBody.deviceId);
    }

    public int hashCode() {
        return (this.appCode.hashCode() * 31) + this.deviceId.hashCode();
    }

    public String toString() {
        return "CloudBody(appCode=" + this.appCode + ", deviceId=" + this.deviceId + ')';
    }

    public CloudBody(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "appCode");
        Intrinsics.checkNotNullParameter(str2, "deviceId");
        this.appCode = str;
        this.deviceId = str2;
    }

    public final String getAppCode() {
        return this.appCode;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setAppCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appCode = str;
    }

    public final void setDeviceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceId = str;
    }
}
