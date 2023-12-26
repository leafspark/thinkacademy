package com.tal.app.thinkacademy.live.core.live.http.response;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b0\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007¢\u0006\u0002\u0010\u0013J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0011HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u001d\u0010<\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ \u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\u00072\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020\u0011HÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001R.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u0006\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\b\u0010\u001e\"\u0004\b\"\u0010 R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u000f\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010)\"\u0004\b+\u0010,R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u001bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001b¨\u0006E"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiDetailPackage;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "emojiPackageName", "", "emojiPackageId", "orderId", "isAnimation", "", "isOver", "picture", "overShow", "content", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiViewEntity;", "Lkotlin/collections/ArrayList;", "isPay", "lineCount", "", "isSelected", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/lang/Boolean;IZ)V", "getContent", "()Ljava/util/ArrayList;", "setContent", "(Ljava/util/ArrayList;)V", "getEmojiPackageId", "()Ljava/lang/String;", "setEmojiPackageId", "(Ljava/lang/String;)V", "getEmojiPackageName", "setEmojiPackageName", "()Ljava/lang/Boolean;", "setAnimation", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setOver", "setPay", "()Z", "setSelected", "(Z)V", "itemType", "getItemType", "()I", "getLineCount", "setLineCount", "(I)V", "getOrderId", "setOrderId", "getOverShow", "setOverShow", "getPicture", "setPicture", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/lang/Boolean;IZ)Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiDetailPackage;", "equals", "other", "", "hashCode", "toString", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiDetailEntity.kt */
public final class EmojiDetailPackage implements MultiItemEntity {
    private ArrayList<EmojiViewEntity> content;
    private String emojiPackageId;
    private String emojiPackageName;
    private Boolean isAnimation;
    private Boolean isOver;
    private Boolean isPay;
    private boolean isSelected;
    private int lineCount;
    private String orderId;
    private Boolean overShow;
    private String picture;

    public EmojiDetailPackage() {
        this((String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (Boolean) null, (ArrayList) null, (Boolean) null, 0, false, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ EmojiDetailPackage copy$default(EmojiDetailPackage emojiDetailPackage, String str, String str2, String str3, Boolean bool, Boolean bool2, String str4, Boolean bool3, ArrayList arrayList, Boolean bool4, int i, boolean z, int i2, Object obj) {
        EmojiDetailPackage emojiDetailPackage2 = emojiDetailPackage;
        int i3 = i2;
        return emojiDetailPackage.copy((i3 & 1) != 0 ? emojiDetailPackage2.emojiPackageName : str, (i3 & 2) != 0 ? emojiDetailPackage2.emojiPackageId : str2, (i3 & 4) != 0 ? emojiDetailPackage2.orderId : str3, (i3 & 8) != 0 ? emojiDetailPackage2.isAnimation : bool, (i3 & 16) != 0 ? emojiDetailPackage2.isOver : bool2, (i3 & 32) != 0 ? emojiDetailPackage2.picture : str4, (i3 & 64) != 0 ? emojiDetailPackage2.overShow : bool3, (i3 & 128) != 0 ? emojiDetailPackage2.content : arrayList, (i3 & 256) != 0 ? emojiDetailPackage2.isPay : bool4, (i3 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? emojiDetailPackage2.lineCount : i, (i3 & 1024) != 0 ? emojiDetailPackage2.isSelected : z);
    }

    public final String component1() {
        return this.emojiPackageName;
    }

    public final int component10() {
        return this.lineCount;
    }

    public final boolean component11() {
        return this.isSelected;
    }

    public final String component2() {
        return this.emojiPackageId;
    }

    public final String component3() {
        return this.orderId;
    }

    public final Boolean component4() {
        return this.isAnimation;
    }

    public final Boolean component5() {
        return this.isOver;
    }

    public final String component6() {
        return this.picture;
    }

    public final Boolean component7() {
        return this.overShow;
    }

    public final ArrayList<EmojiViewEntity> component8() {
        return this.content;
    }

    public final Boolean component9() {
        return this.isPay;
    }

    public final EmojiDetailPackage copy(String str, String str2, String str3, Boolean bool, Boolean bool2, String str4, Boolean bool3, ArrayList<EmojiViewEntity> arrayList, Boolean bool4, int i, boolean z) {
        return new EmojiDetailPackage(str, str2, str3, bool, bool2, str4, bool3, arrayList, bool4, i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmojiDetailPackage)) {
            return false;
        }
        EmojiDetailPackage emojiDetailPackage = (EmojiDetailPackage) obj;
        return Intrinsics.areEqual((Object) this.emojiPackageName, (Object) emojiDetailPackage.emojiPackageName) && Intrinsics.areEqual((Object) this.emojiPackageId, (Object) emojiDetailPackage.emojiPackageId) && Intrinsics.areEqual((Object) this.orderId, (Object) emojiDetailPackage.orderId) && Intrinsics.areEqual((Object) this.isAnimation, (Object) emojiDetailPackage.isAnimation) && Intrinsics.areEqual((Object) this.isOver, (Object) emojiDetailPackage.isOver) && Intrinsics.areEqual((Object) this.picture, (Object) emojiDetailPackage.picture) && Intrinsics.areEqual((Object) this.overShow, (Object) emojiDetailPackage.overShow) && Intrinsics.areEqual((Object) this.content, (Object) emojiDetailPackage.content) && Intrinsics.areEqual((Object) this.isPay, (Object) emojiDetailPackage.isPay) && this.lineCount == emojiDetailPackage.lineCount && this.isSelected == emojiDetailPackage.isSelected;
    }

    public int hashCode() {
        String str = this.emojiPackageName;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.emojiPackageId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.orderId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.isAnimation;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isOver;
        int hashCode5 = (hashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str4 = this.picture;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool3 = this.overShow;
        int hashCode7 = (hashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        ArrayList<EmojiViewEntity> arrayList = this.content;
        int hashCode8 = (hashCode7 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        Boolean bool4 = this.isPay;
        if (bool4 != null) {
            i = bool4.hashCode();
        }
        int i2 = (((hashCode8 + i) * 31) + this.lineCount) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "EmojiDetailPackage(emojiPackageName=" + this.emojiPackageName + ", emojiPackageId=" + this.emojiPackageId + ", orderId=" + this.orderId + ", isAnimation=" + this.isAnimation + ", isOver=" + this.isOver + ", picture=" + this.picture + ", overShow=" + this.overShow + ", content=" + this.content + ", isPay=" + this.isPay + ", lineCount=" + this.lineCount + ", isSelected=" + this.isSelected + ')';
    }

    public EmojiDetailPackage(String str, String str2, String str3, Boolean bool, Boolean bool2, String str4, Boolean bool3, ArrayList<EmojiViewEntity> arrayList, Boolean bool4, int i, boolean z) {
        this.emojiPackageName = str;
        this.emojiPackageId = str2;
        this.orderId = str3;
        this.isAnimation = bool;
        this.isOver = bool2;
        this.picture = str4;
        this.overShow = bool3;
        this.content = arrayList;
        this.isPay = bool4;
        this.lineCount = i;
        this.isSelected = z;
    }

    public final String getEmojiPackageName() {
        return this.emojiPackageName;
    }

    public final void setEmojiPackageName(String str) {
        this.emojiPackageName = str;
    }

    public final String getEmojiPackageId() {
        return this.emojiPackageId;
    }

    public final void setEmojiPackageId(String str) {
        this.emojiPackageId = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ EmojiDetailPackage(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.Boolean r16, java.lang.Boolean r17, java.lang.String r18, java.lang.Boolean r19, java.util.ArrayList r20, java.lang.Boolean r21, int r22, boolean r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = "默认"
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0011
            java.lang.String r2 = "0"
            goto L_0x0012
        L_0x0011:
            r2 = r14
        L_0x0012:
            r3 = r0 & 4
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001a
            r3 = r4
            goto L_0x001b
        L_0x001a:
            r3 = r15
        L_0x001b:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L_0x0025
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)
            goto L_0x0027
        L_0x0025:
            r5 = r16
        L_0x0027:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0030
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            goto L_0x0032
        L_0x0030:
            r7 = r17
        L_0x0032:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r4 = r18
        L_0x0039:
            r8 = r0 & 64
            r9 = 1
            if (r8 == 0) goto L_0x0043
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r9)
            goto L_0x0045
        L_0x0043:
            r8 = r19
        L_0x0045:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x004f
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            goto L_0x0051
        L_0x004f:
            r10 = r20
        L_0x0051:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x005a
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            goto L_0x005c
        L_0x005a:
            r9 = r21
        L_0x005c:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0062
            r11 = 2
            goto L_0x0064
        L_0x0062:
            r11 = r22
        L_0x0064:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r6 = r23
        L_0x006b:
            r13 = r12
            r14 = r1
            r15 = r2
            r16 = r3
            r17 = r5
            r18 = r7
            r19 = r4
            r20 = r8
            r21 = r10
            r22 = r9
            r23 = r11
            r24 = r6
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailPackage.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Boolean, java.util.ArrayList, java.lang.Boolean, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Boolean isAnimation() {
        return this.isAnimation;
    }

    public final void setAnimation(Boolean bool) {
        this.isAnimation = bool;
    }

    public final Boolean isOver() {
        return this.isOver;
    }

    public final void setOver(Boolean bool) {
        this.isOver = bool;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final void setPicture(String str) {
        this.picture = str;
    }

    public final Boolean getOverShow() {
        return this.overShow;
    }

    public final void setOverShow(Boolean bool) {
        this.overShow = bool;
    }

    public final ArrayList<EmojiViewEntity> getContent() {
        return this.content;
    }

    public final void setContent(ArrayList<EmojiViewEntity> arrayList) {
        this.content = arrayList;
    }

    public final Boolean isPay() {
        return this.isPay;
    }

    public final void setPay(Boolean bool) {
        this.isPay = bool;
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final void setLineCount(int i) {
        this.lineCount = i;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public int getItemType() {
        if (Intrinsics.areEqual((Object) this.isPay, (Object) true)) {
            return Intrinsics.areEqual((Object) this.isOver, (Object) true) ? 2 : 1;
        }
        return 0;
    }
}
