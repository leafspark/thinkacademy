package com.tal.app.thinkacademy.common.entity;

import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b#\b\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003Jm\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0012R\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011¨\u0006/"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/UpdateVersionEntity;", "", "desc", "", "needForceUpgrade", "", "needPopUpWindow", "needUpgrade", "newVersion", "packageSize", "packageUrl", "isGray", "", "localForceUpgrade", "packageMd5", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "()Z", "getLocalForceUpgrade", "setLocalForceUpgrade", "(Z)V", "getNeedForceUpgrade", "()I", "getNeedPopUpWindow", "getNeedUpgrade", "getNewVersion", "getPackageMd5", "setPackageMd5", "(Ljava/lang/String;)V", "getPackageSize", "getPackageUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UpdateVersionEntity.kt */
public final class UpdateVersionEntity {
    private final String desc;
    private final boolean isGray;
    private boolean localForceUpgrade;
    private final int needForceUpgrade;
    private final int needPopUpWindow;
    private final int needUpgrade;
    private final String newVersion;
    private String packageMd5;
    private final String packageSize;
    private final String packageUrl;

    public static /* synthetic */ UpdateVersionEntity copy$default(UpdateVersionEntity updateVersionEntity, String str, int i, int i2, int i3, String str2, String str3, String str4, boolean z, boolean z2, String str5, int i4, Object obj) {
        UpdateVersionEntity updateVersionEntity2 = updateVersionEntity;
        int i5 = i4;
        return updateVersionEntity.copy((i5 & 1) != 0 ? updateVersionEntity2.desc : str, (i5 & 2) != 0 ? updateVersionEntity2.needForceUpgrade : i, (i5 & 4) != 0 ? updateVersionEntity2.needPopUpWindow : i2, (i5 & 8) != 0 ? updateVersionEntity2.needUpgrade : i3, (i5 & 16) != 0 ? updateVersionEntity2.newVersion : str2, (i5 & 32) != 0 ? updateVersionEntity2.packageSize : str3, (i5 & 64) != 0 ? updateVersionEntity2.packageUrl : str4, (i5 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? updateVersionEntity2.isGray : z, (i5 & 256) != 0 ? updateVersionEntity2.localForceUpgrade : z2, (i5 & 512) != 0 ? updateVersionEntity2.packageMd5 : str5);
    }

    public final String component1() {
        return this.desc;
    }

    public final String component10() {
        return this.packageMd5;
    }

    public final int component2() {
        return this.needForceUpgrade;
    }

    public final int component3() {
        return this.needPopUpWindow;
    }

    public final int component4() {
        return this.needUpgrade;
    }

    public final String component5() {
        return this.newVersion;
    }

    public final String component6() {
        return this.packageSize;
    }

    public final String component7() {
        return this.packageUrl;
    }

    public final boolean component8() {
        return this.isGray;
    }

    public final boolean component9() {
        return this.localForceUpgrade;
    }

    public final UpdateVersionEntity copy(String str, int i, int i2, int i3, String str2, String str3, String str4, boolean z, boolean z2, String str5) {
        Intrinsics.checkNotNullParameter(str, "desc");
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str6, "newVersion");
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str7, "packageSize");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "packageUrl");
        String str9 = str5;
        Intrinsics.checkNotNullParameter(str9, "packageMd5");
        return new UpdateVersionEntity(str, i, i2, i3, str6, str7, str8, z, z2, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateVersionEntity)) {
            return false;
        }
        UpdateVersionEntity updateVersionEntity = (UpdateVersionEntity) obj;
        return Intrinsics.areEqual(this.desc, updateVersionEntity.desc) && this.needForceUpgrade == updateVersionEntity.needForceUpgrade && this.needPopUpWindow == updateVersionEntity.needPopUpWindow && this.needUpgrade == updateVersionEntity.needUpgrade && Intrinsics.areEqual(this.newVersion, updateVersionEntity.newVersion) && Intrinsics.areEqual(this.packageSize, updateVersionEntity.packageSize) && Intrinsics.areEqual(this.packageUrl, updateVersionEntity.packageUrl) && this.isGray == updateVersionEntity.isGray && this.localForceUpgrade == updateVersionEntity.localForceUpgrade && Intrinsics.areEqual(this.packageMd5, updateVersionEntity.packageMd5);
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.desc.hashCode() * 31) + this.needForceUpgrade) * 31) + this.needPopUpWindow) * 31) + this.needUpgrade) * 31) + this.newVersion.hashCode()) * 31) + this.packageSize.hashCode()) * 31) + this.packageUrl.hashCode()) * 31;
        boolean z = this.isGray;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.localForceUpgrade;
        if (!z3) {
            z2 = z3;
        }
        return ((i + (z2 ? 1 : 0)) * 31) + this.packageMd5.hashCode();
    }

    public String toString() {
        return "UpdateVersionEntity(desc=" + this.desc + ", needForceUpgrade=" + this.needForceUpgrade + ", needPopUpWindow=" + this.needPopUpWindow + ", needUpgrade=" + this.needUpgrade + ", newVersion=" + this.newVersion + ", packageSize=" + this.packageSize + ", packageUrl=" + this.packageUrl + ", isGray=" + this.isGray + ", localForceUpgrade=" + this.localForceUpgrade + ", packageMd5=" + this.packageMd5 + ')';
    }

    public UpdateVersionEntity(String str, int i, int i2, int i3, String str2, String str3, String str4, boolean z, boolean z2, String str5) {
        Intrinsics.checkNotNullParameter(str, "desc");
        Intrinsics.checkNotNullParameter(str2, "newVersion");
        Intrinsics.checkNotNullParameter(str3, "packageSize");
        Intrinsics.checkNotNullParameter(str4, "packageUrl");
        Intrinsics.checkNotNullParameter(str5, "packageMd5");
        this.desc = str;
        this.needForceUpgrade = i;
        this.needPopUpWindow = i2;
        this.needUpgrade = i3;
        this.newVersion = str2;
        this.packageSize = str3;
        this.packageUrl = str4;
        this.isGray = z;
        this.localForceUpgrade = z2;
        this.packageMd5 = str5;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getNeedForceUpgrade() {
        return this.needForceUpgrade;
    }

    public final int getNeedPopUpWindow() {
        return this.needPopUpWindow;
    }

    public final int getNeedUpgrade() {
        return this.needUpgrade;
    }

    public final String getNewVersion() {
        return this.newVersion;
    }

    public final String getPackageSize() {
        return this.packageSize;
    }

    public final String getPackageUrl() {
        return this.packageUrl;
    }

    public final boolean isGray() {
        return this.isGray;
    }

    public final boolean getLocalForceUpgrade() {
        return this.localForceUpgrade;
    }

    public final void setLocalForceUpgrade(boolean z) {
        this.localForceUpgrade = z;
    }

    public final String getPackageMd5() {
        return this.packageMd5;
    }

    public final void setPackageMd5(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageMd5 = str;
    }
}
