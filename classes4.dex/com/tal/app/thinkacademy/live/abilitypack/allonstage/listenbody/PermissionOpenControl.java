package com.tal.app.thinkacademy.live.abilitypack.allonstage.listenbody;

import com.tal.app.thinkacademy.live.abilitypack.allonstage.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/listenbody/PermissionOpenControl;", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/listenbody/AllOnStageListenerBody;", "type", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/Type;", "(Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/Type;)V", "getType", "()Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/Type;", "setType", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStageListenerBody.kt */
public final class PermissionOpenControl extends AllOnStageListenerBody {
    private Type type;

    public static /* synthetic */ PermissionOpenControl copy$default(PermissionOpenControl permissionOpenControl, Type type2, int i, Object obj) {
        if ((i & 1) != 0) {
            type2 = permissionOpenControl.type;
        }
        return permissionOpenControl.copy(type2);
    }

    public final Type component1() {
        return this.type;
    }

    public final PermissionOpenControl copy(Type type2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        return new PermissionOpenControl(type2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PermissionOpenControl) && this.type == ((PermissionOpenControl) obj).type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return "PermissionOpenControl(type=" + this.type + ')';
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionOpenControl(Type type2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(type2, "type");
        this.type = type2;
    }

    public final Type getType() {
        return this.type;
    }

    public final void setType(Type type2) {
        Intrinsics.checkNotNullParameter(type2, "<set-?>");
        this.type = type2;
    }
}
