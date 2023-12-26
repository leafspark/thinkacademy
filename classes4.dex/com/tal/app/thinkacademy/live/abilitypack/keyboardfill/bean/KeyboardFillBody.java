package com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillBody;", "", "planId", "", "classId", "interactionId", "", "option", "(IILjava/lang/String;Ljava/lang/String;)V", "getClassId", "()I", "getInteractionId", "()Ljava/lang/String;", "getOption", "getPlanId", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardFillBody.kt */
public final class KeyboardFillBody {
    private final int classId;
    private final String interactionId;
    private final String option;
    private final int planId;

    public KeyboardFillBody(int i, int i2, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "interactionId");
        this.planId = i;
        this.classId = i2;
        this.interactionId = str;
        this.option = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KeyboardFillBody(int i, int i2, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str, (i3 & 8) != 0 ? null : str2);
    }

    public final int getPlanId() {
        return this.planId;
    }

    public final int getClassId() {
        return this.classId;
    }

    public final String getInteractionId() {
        return this.interactionId;
    }

    public final String getOption() {
        return this.option;
    }
}
