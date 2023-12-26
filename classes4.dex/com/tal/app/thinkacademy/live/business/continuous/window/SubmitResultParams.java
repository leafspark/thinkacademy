package com.tal.app.thinkacademy.live.business.continuous.window;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/continuous/window/SubmitResultParams;", "", "type", "Lcom/tal/app/thinkacademy/live/business/continuous/window/AwardType;", "totalCoins", "", "addCoins", "level", "isTopLevel", "", "(Lcom/tal/app/thinkacademy/live/business/continuous/window/AwardType;IIIZ)V", "getAddCoins", "()I", "()Z", "getLevel", "getTotalCoins", "getType", "()Lcom/tal/app/thinkacademy/live/business/continuous/window/AwardType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitResultView.kt */
public final class SubmitResultParams {
    private final int addCoins;
    private final boolean isTopLevel;
    private final int level;
    private final int totalCoins;
    private final AwardType type;

    public static /* synthetic */ SubmitResultParams copy$default(SubmitResultParams submitResultParams, AwardType awardType, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            awardType = submitResultParams.type;
        }
        if ((i4 & 2) != 0) {
            i = submitResultParams.totalCoins;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = submitResultParams.addCoins;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            i3 = submitResultParams.level;
        }
        int i7 = i3;
        if ((i4 & 16) != 0) {
            z = submitResultParams.isTopLevel;
        }
        return submitResultParams.copy(awardType, i5, i6, i7, z);
    }

    public final AwardType component1() {
        return this.type;
    }

    public final int component2() {
        return this.totalCoins;
    }

    public final int component3() {
        return this.addCoins;
    }

    public final int component4() {
        return this.level;
    }

    public final boolean component5() {
        return this.isTopLevel;
    }

    public final SubmitResultParams copy(AwardType awardType, int i, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(awardType, "type");
        return new SubmitResultParams(awardType, i, i2, i3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitResultParams)) {
            return false;
        }
        SubmitResultParams submitResultParams = (SubmitResultParams) obj;
        return this.type == submitResultParams.type && this.totalCoins == submitResultParams.totalCoins && this.addCoins == submitResultParams.addCoins && this.level == submitResultParams.level && this.isTopLevel == submitResultParams.isTopLevel;
    }

    public int hashCode() {
        int hashCode = ((((((this.type.hashCode() * 31) + this.totalCoins) * 31) + this.addCoins) * 31) + this.level) * 31;
        boolean z = this.isTopLevel;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "SubmitResultParams(type=" + this.type + ", totalCoins=" + this.totalCoins + ", addCoins=" + this.addCoins + ", level=" + this.level + ", isTopLevel=" + this.isTopLevel + ')';
    }

    public SubmitResultParams(AwardType awardType, int i, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(awardType, "type");
        this.type = awardType;
        this.totalCoins = i;
        this.addCoins = i2;
        this.level = i3;
        this.isTopLevel = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubmitResultParams(AwardType awardType, int i, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(awardType, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3, (i4 & 16) != 0 ? false : z);
    }

    public final AwardType getType() {
        return this.type;
    }

    public final int getTotalCoins() {
        return this.totalCoins;
    }

    public final int getAddCoins() {
        return this.addCoins;
    }

    public final int getLevel() {
        return this.level;
    }

    public final boolean isTopLevel() {
        return this.isTopLevel;
    }
}
