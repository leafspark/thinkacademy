package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/SubmitHeaderData;", "", "type", "", "data", "Lcom/tal/app/thinkacademy/common/entity/GameSubmitH5Header;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/common/entity/GameSubmitH5Header;)V", "getData", "()Lcom/tal/app/thinkacademy/common/entity/GameSubmitH5Header;", "setData", "(Lcom/tal/app/thinkacademy/common/entity/GameSubmitH5Header;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitHeaderData.kt */
public final class SubmitHeaderData {
    private GameSubmitH5Header data;
    private String type;

    public SubmitHeaderData() {
        this((String) null, (GameSubmitH5Header) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SubmitHeaderData copy$default(SubmitHeaderData submitHeaderData, String str, GameSubmitH5Header gameSubmitH5Header, int i, Object obj) {
        if ((i & 1) != 0) {
            str = submitHeaderData.type;
        }
        if ((i & 2) != 0) {
            gameSubmitH5Header = submitHeaderData.data;
        }
        return submitHeaderData.copy(str, gameSubmitH5Header);
    }

    public final String component1() {
        return this.type;
    }

    public final GameSubmitH5Header component2() {
        return this.data;
    }

    public final SubmitHeaderData copy(String str, GameSubmitH5Header gameSubmitH5Header) {
        return new SubmitHeaderData(str, gameSubmitH5Header);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitHeaderData)) {
            return false;
        }
        SubmitHeaderData submitHeaderData = (SubmitHeaderData) obj;
        return Intrinsics.areEqual(this.type, submitHeaderData.type) && Intrinsics.areEqual(this.data, submitHeaderData.data);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        GameSubmitH5Header gameSubmitH5Header = this.data;
        if (gameSubmitH5Header != null) {
            i = gameSubmitH5Header.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SubmitHeaderData(type=" + this.type + ", data=" + this.data + ')';
    }

    public SubmitHeaderData(String str, GameSubmitH5Header gameSubmitH5Header) {
        this.type = str;
        this.data = gameSubmitH5Header;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubmitHeaderData(java.lang.String r15, com.tal.app.thinkacademy.common.entity.GameSubmitH5Header r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r14 = this;
            r0 = r17 & 1
            if (r0 == 0) goto L_0x0007
            java.lang.String r0 = "headers"
            goto L_0x0008
        L_0x0007:
            r0 = r15
        L_0x0008:
            r1 = r17 & 2
            if (r1 == 0) goto L_0x0020
            com.tal.app.thinkacademy.common.entity.GameSubmitH5Header r1 = new com.tal.app.thinkacademy.common.entity.GameSubmitH5Header
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 511(0x1ff, float:7.16E-43)
            r13 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r2 = r14
            goto L_0x0023
        L_0x0020:
            r2 = r14
            r1 = r16
        L_0x0023:
            r14.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.entity.SubmitHeaderData.<init>(java.lang.String, com.tal.app.thinkacademy.common.entity.GameSubmitH5Header, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final GameSubmitH5Header getData() {
        return this.data;
    }

    public final void setData(GameSubmitH5Header gameSubmitH5Header) {
        this.data = gameSubmitH5Header;
    }
}
