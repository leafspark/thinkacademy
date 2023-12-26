package com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B)\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0006H\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillResult;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "userTotalGold", "", "addCoin", "option", "", "answerStat", "(IILjava/lang/String;I)V", "getAddCoin", "()I", "getAnswerStat", "getOption", "()Ljava/lang/String;", "getUserTotalGold", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardFillResult.kt */
public final class KeyboardFillResult implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final int addCoin;
    private final int answerStat;
    private final String option;
    private final int userTotalGold;

    public static /* synthetic */ KeyboardFillResult copy$default(KeyboardFillResult keyboardFillResult, int i, int i2, String str, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardFillResult.userTotalGold;
        }
        if ((i4 & 2) != 0) {
            i2 = keyboardFillResult.addCoin;
        }
        if ((i4 & 4) != 0) {
            str = keyboardFillResult.option;
        }
        if ((i4 & 8) != 0) {
            i3 = keyboardFillResult.answerStat;
        }
        return keyboardFillResult.copy(i, i2, str, i3);
    }

    public final int component1() {
        return this.userTotalGold;
    }

    public final int component2() {
        return this.addCoin;
    }

    public final String component3() {
        return this.option;
    }

    public final int component4() {
        return this.answerStat;
    }

    public final KeyboardFillResult copy(int i, int i2, String str, int i3) {
        return new KeyboardFillResult(i, i2, str, i3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardFillResult)) {
            return false;
        }
        KeyboardFillResult keyboardFillResult = (KeyboardFillResult) obj;
        return this.userTotalGold == keyboardFillResult.userTotalGold && this.addCoin == keyboardFillResult.addCoin && Intrinsics.areEqual(this.option, keyboardFillResult.option) && this.answerStat == keyboardFillResult.answerStat;
    }

    public int hashCode() {
        int i = ((this.userTotalGold * 31) + this.addCoin) * 31;
        String str = this.option;
        return ((i + (str == null ? 0 : str.hashCode())) * 31) + this.answerStat;
    }

    public String toString() {
        return "KeyboardFillResult(userTotalGold=" + this.userTotalGold + ", addCoin=" + this.addCoin + ", option=" + this.option + ", answerStat=" + this.answerStat + ')';
    }

    public KeyboardFillResult(int i, int i2, String str, int i3) {
        this.userTotalGold = i;
        this.addCoin = i2;
        this.option = str;
        this.answerStat = i3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KeyboardFillResult(int i, int i2, String str, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? null : str, i3);
    }

    public final int getUserTotalGold() {
        return this.userTotalGold;
    }

    public final int getAddCoin() {
        return this.addCoin;
    }

    public final String getOption() {
        return this.option;
    }

    public final int getAnswerStat() {
        return this.answerStat;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public KeyboardFillResult(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.userTotalGold);
        parcel.writeInt(this.addCoin);
        parcel.writeString(this.option);
        parcel.writeInt(this.answerStat);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillResult;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: KeyboardFillResult.kt */
    public static final class CREATOR implements Parcelable.Creator<KeyboardFillResult> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public KeyboardFillResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new KeyboardFillResult(parcel);
        }

        public KeyboardFillResult[] newArray(int i) {
            return new KeyboardFillResult[i];
        }
    }
}
