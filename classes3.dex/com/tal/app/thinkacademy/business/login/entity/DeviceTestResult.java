package com.tal.app.thinkacademy.business.login.entity;

import com.tal.app.thinkacademy.lib.util.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u001eJ\t\u0010!\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/DeviceTestResult;", "", "network", "", "mic", "camera", "voice", "(ZZZZ)V", "getCamera", "()Z", "setCamera", "(Z)V", "getMic", "setMic", "getNetwork", "setNetwork", "getVoice", "setVoice", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "merge", "", "json", "", "testSuccess", "toJson", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestResult.kt */
public final class DeviceTestResult {
    private boolean camera;
    private boolean mic;
    private boolean network;
    private boolean voice;

    public DeviceTestResult() {
        this(false, false, false, false, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DeviceTestResult copy$default(DeviceTestResult deviceTestResult, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = deviceTestResult.network;
        }
        if ((i & 2) != 0) {
            z2 = deviceTestResult.mic;
        }
        if ((i & 4) != 0) {
            z3 = deviceTestResult.camera;
        }
        if ((i & 8) != 0) {
            z4 = deviceTestResult.voice;
        }
        return deviceTestResult.copy(z, z2, z3, z4);
    }

    public final boolean component1() {
        return this.network;
    }

    public final boolean component2() {
        return this.mic;
    }

    public final boolean component3() {
        return this.camera;
    }

    public final boolean component4() {
        return this.voice;
    }

    public final DeviceTestResult copy(boolean z, boolean z2, boolean z3, boolean z4) {
        return new DeviceTestResult(z, z2, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceTestResult)) {
            return false;
        }
        DeviceTestResult deviceTestResult = (DeviceTestResult) obj;
        return this.network == deviceTestResult.network && this.mic == deviceTestResult.mic && this.camera == deviceTestResult.camera && this.voice == deviceTestResult.voice;
    }

    public int hashCode() {
        boolean z = this.network;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.mic;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.camera;
        if (z4) {
            z4 = true;
        }
        int i3 = (i2 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.voice;
        if (!z5) {
            z2 = z5;
        }
        return i3 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "DeviceTestResult(network=" + this.network + ", mic=" + this.mic + ", camera=" + this.camera + ", voice=" + this.voice + ')';
    }

    public DeviceTestResult(boolean z, boolean z2, boolean z3, boolean z4) {
        this.network = z;
        this.mic = z2;
        this.camera = z3;
        this.voice = z4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceTestResult(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4);
    }

    public final boolean getNetwork() {
        return this.network;
    }

    public final void setNetwork(boolean z) {
        this.network = z;
    }

    public final boolean getMic() {
        return this.mic;
    }

    public final void setMic(boolean z) {
        this.mic = z;
    }

    public final boolean getCamera() {
        return this.camera;
    }

    public final void setCamera(boolean z) {
        this.camera = z;
    }

    public final boolean getVoice() {
        return this.voice;
    }

    public final void setVoice(boolean z) {
        this.voice = z;
    }

    public final boolean testSuccess() {
        return this.network && this.mic && this.camera && this.voice;
    }

    public final String toJson() {
        String json = GsonUtils.toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(this)");
        return json;
    }

    public final void merge(String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        DeviceTestResult deviceTestResult = (DeviceTestResult) GsonUtils.fromJson(str, DeviceTestResult.class);
        if (deviceTestResult != null) {
            this.network = deviceTestResult.network;
            this.mic = deviceTestResult.mic;
            this.camera = deviceTestResult.camera;
            this.voice = deviceTestResult.voice;
        }
    }
}
