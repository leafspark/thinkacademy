package com.tal.app.thinkacademy.live.core.live.http.response;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B9\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u001d\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJD\u0010\u0016\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0006\u0010\n\"\u0004\b\u000e\u0010\fR.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiDetailEntity;", "", "list", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiDetailPackage;", "Lkotlin/collections/ArrayList;", "isUpdate", "", "isReportedOverdue", "(Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "setReportedOverdue", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setUpdate", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "copy", "(Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiDetailEntity;", "equals", "other", "hashCode", "", "toString", "", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiDetailEntity.kt */
public final class EmojiDetailEntity {
    private Boolean isReportedOverdue;
    private Boolean isUpdate;
    private ArrayList<EmojiDetailPackage> list;

    public static /* synthetic */ EmojiDetailEntity copy$default(EmojiDetailEntity emojiDetailEntity, ArrayList<EmojiDetailPackage> arrayList, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = emojiDetailEntity.list;
        }
        if ((i & 2) != 0) {
            bool = emojiDetailEntity.isUpdate;
        }
        if ((i & 4) != 0) {
            bool2 = emojiDetailEntity.isReportedOverdue;
        }
        return emojiDetailEntity.copy(arrayList, bool, bool2);
    }

    public final ArrayList<EmojiDetailPackage> component1() {
        return this.list;
    }

    public final Boolean component2() {
        return this.isUpdate;
    }

    public final Boolean component3() {
        return this.isReportedOverdue;
    }

    public final EmojiDetailEntity copy(ArrayList<EmojiDetailPackage> arrayList, Boolean bool, Boolean bool2) {
        return new EmojiDetailEntity(arrayList, bool, bool2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmojiDetailEntity)) {
            return false;
        }
        EmojiDetailEntity emojiDetailEntity = (EmojiDetailEntity) obj;
        return Intrinsics.areEqual((Object) this.list, (Object) emojiDetailEntity.list) && Intrinsics.areEqual((Object) this.isUpdate, (Object) emojiDetailEntity.isUpdate) && Intrinsics.areEqual((Object) this.isReportedOverdue, (Object) emojiDetailEntity.isReportedOverdue);
    }

    public int hashCode() {
        ArrayList<EmojiDetailPackage> arrayList = this.list;
        int i = 0;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        Boolean bool = this.isUpdate;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isReportedOverdue;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "EmojiDetailEntity(list=" + this.list + ", isUpdate=" + this.isUpdate + ", isReportedOverdue=" + this.isReportedOverdue + ')';
    }

    public EmojiDetailEntity(ArrayList<EmojiDetailPackage> arrayList, Boolean bool, Boolean bool2) {
        this.list = arrayList;
        this.isUpdate = bool;
        this.isReportedOverdue = bool2;
    }

    public final ArrayList<EmojiDetailPackage> getList() {
        return this.list;
    }

    public final void setList(ArrayList<EmojiDetailPackage> arrayList) {
        this.list = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EmojiDetailEntity(ArrayList arrayList, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, (i & 2) != 0 ? false : bool, (i & 4) != 0 ? false : bool2);
    }

    public final Boolean isUpdate() {
        return this.isUpdate;
    }

    public final void setUpdate(Boolean bool) {
        this.isUpdate = bool;
    }

    public final Boolean isReportedOverdue() {
        return this.isReportedOverdue;
    }

    public final void setReportedOverdue(Boolean bool) {
        this.isReportedOverdue = bool;
    }
}
