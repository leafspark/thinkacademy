package com.tal.app.thinkacademy.common.widget.gold;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinConfig;", "", "isPlaySound", "", "isTargetViewAnimation", "line1", "Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinLineConfig;", "line2", "line3", "(ZZLcom/tal/app/thinkacademy/common/widget/gold/FlyCoinLineConfig;Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinLineConfig;Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinLineConfig;)V", "()Z", "getLine1", "()Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinLineConfig;", "getLine2", "getLine3", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlyCoinConfig.kt */
public class FlyCoinConfig {
    private final boolean isPlaySound;
    private final boolean isTargetViewAnimation;
    private final FlyCoinLineConfig line1;
    private final FlyCoinLineConfig line2;
    private final FlyCoinLineConfig line3;

    public FlyCoinConfig(boolean z, boolean z2, FlyCoinLineConfig flyCoinLineConfig, FlyCoinLineConfig flyCoinLineConfig2, FlyCoinLineConfig flyCoinLineConfig3) {
        this.isPlaySound = z;
        this.isTargetViewAnimation = z2;
        this.line1 = flyCoinLineConfig;
        this.line2 = flyCoinLineConfig2;
        this.line3 = flyCoinLineConfig3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlyCoinConfig(boolean z, boolean z2, FlyCoinLineConfig flyCoinLineConfig, FlyCoinLineConfig flyCoinLineConfig2, FlyCoinLineConfig flyCoinLineConfig3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, flyCoinLineConfig, flyCoinLineConfig2, flyCoinLineConfig3);
    }

    public final boolean isPlaySound() {
        return this.isPlaySound;
    }

    public final boolean isTargetViewAnimation() {
        return this.isTargetViewAnimation;
    }

    public final FlyCoinLineConfig getLine1() {
        return this.line1;
    }

    public final FlyCoinLineConfig getLine2() {
        return this.line2;
    }

    public final FlyCoinLineConfig getLine3() {
        return this.line3;
    }
}
