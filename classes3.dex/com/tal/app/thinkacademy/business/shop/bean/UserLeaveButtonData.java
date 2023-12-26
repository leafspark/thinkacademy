package com.tal.app.thinkacademy.business.shop.bean;

import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bw\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fHÆ\u0003J{\u00103\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fHÆ\u0001J\u0013\u00104\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\bHÖ\u0001R\u001c\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010#¨\u0006:"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveButtonData;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "mLocalButtonTypeChild", "", "Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponentData;", "mLocalIsClick", "", "componentId", "", "componentName", "emailSubscribe", "isShowEmailSubscribe", "host", "secret", "tags", "", "(Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "childNode", "getChildNode", "()Ljava/util/List;", "getComponentId", "()Ljava/lang/String;", "setComponentId", "(Ljava/lang/String;)V", "getComponentName", "setComponentName", "getEmailSubscribe", "()Z", "setEmailSubscribe", "(Z)V", "getHost", "setHost", "setShowEmailSubscribe", "getMLocalButtonTypeChild", "setMLocalButtonTypeChild", "(Ljava/util/List;)V", "getMLocalIsClick", "setMLocalIsClick", "getSecret", "setSecret", "getTags", "setTags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserLeaveInfoBean.kt */
public final class UserLeaveButtonData extends BaseNode {
    private String componentId;
    private String componentName;
    private boolean emailSubscribe;
    private String host;
    private boolean isShowEmailSubscribe;
    private List<UserLeaveComponentData> mLocalButtonTypeChild;
    private boolean mLocalIsClick;
    private String secret;
    private List<String> tags;

    public UserLeaveButtonData() {
        this((List) null, false, (String) null, (String) null, false, false, (String) null, (String) null, (List) null, 511, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserLeaveButtonData copy$default(UserLeaveButtonData userLeaveButtonData, List list, boolean z, String str, String str2, boolean z2, boolean z3, String str3, String str4, List list2, int i, Object obj) {
        UserLeaveButtonData userLeaveButtonData2 = userLeaveButtonData;
        int i2 = i;
        return userLeaveButtonData.copy((i2 & 1) != 0 ? userLeaveButtonData2.mLocalButtonTypeChild : list, (i2 & 2) != 0 ? userLeaveButtonData2.mLocalIsClick : z, (i2 & 4) != 0 ? userLeaveButtonData2.componentId : str, (i2 & 8) != 0 ? userLeaveButtonData2.componentName : str2, (i2 & 16) != 0 ? userLeaveButtonData2.emailSubscribe : z2, (i2 & 32) != 0 ? userLeaveButtonData2.isShowEmailSubscribe : z3, (i2 & 64) != 0 ? userLeaveButtonData2.host : str3, (i2 & 128) != 0 ? userLeaveButtonData2.secret : str4, (i2 & 256) != 0 ? userLeaveButtonData2.tags : list2);
    }

    public final List<UserLeaveComponentData> component1() {
        return this.mLocalButtonTypeChild;
    }

    public final boolean component2() {
        return this.mLocalIsClick;
    }

    public final String component3() {
        return this.componentId;
    }

    public final String component4() {
        return this.componentName;
    }

    public final boolean component5() {
        return this.emailSubscribe;
    }

    public final boolean component6() {
        return this.isShowEmailSubscribe;
    }

    public final String component7() {
        return this.host;
    }

    public final String component8() {
        return this.secret;
    }

    public final List<String> component9() {
        return this.tags;
    }

    public final UserLeaveButtonData copy(List<UserLeaveComponentData> list, boolean z, String str, String str2, boolean z2, boolean z3, String str3, String str4, List<String> list2) {
        return new UserLeaveButtonData(list, z, str, str2, z2, z3, str3, str4, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserLeaveButtonData)) {
            return false;
        }
        UserLeaveButtonData userLeaveButtonData = (UserLeaveButtonData) obj;
        return Intrinsics.areEqual((Object) this.mLocalButtonTypeChild, (Object) userLeaveButtonData.mLocalButtonTypeChild) && this.mLocalIsClick == userLeaveButtonData.mLocalIsClick && Intrinsics.areEqual((Object) this.componentId, (Object) userLeaveButtonData.componentId) && Intrinsics.areEqual((Object) this.componentName, (Object) userLeaveButtonData.componentName) && this.emailSubscribe == userLeaveButtonData.emailSubscribe && this.isShowEmailSubscribe == userLeaveButtonData.isShowEmailSubscribe && Intrinsics.areEqual((Object) this.host, (Object) userLeaveButtonData.host) && Intrinsics.areEqual((Object) this.secret, (Object) userLeaveButtonData.secret) && Intrinsics.areEqual((Object) this.tags, (Object) userLeaveButtonData.tags);
    }

    public List<BaseNode> getChildNode() {
        return null;
    }

    public int hashCode() {
        List<UserLeaveComponentData> list = this.mLocalButtonTypeChild;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        boolean z = this.mLocalIsClick;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        String str = this.componentId;
        int hashCode2 = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.componentName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z3 = this.emailSubscribe;
        if (z3) {
            z3 = true;
        }
        int i3 = (hashCode3 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isShowEmailSubscribe;
        if (!z4) {
            z2 = z4;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        String str3 = this.host;
        int hashCode4 = (i4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.secret;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<String> list2 = this.tags;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "UserLeaveButtonData(mLocalButtonTypeChild=" + this.mLocalButtonTypeChild + ", mLocalIsClick=" + this.mLocalIsClick + ", componentId=" + this.componentId + ", componentName=" + this.componentName + ", emailSubscribe=" + this.emailSubscribe + ", isShowEmailSubscribe=" + this.isShowEmailSubscribe + ", host=" + this.host + ", secret=" + this.secret + ", tags=" + this.tags + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UserLeaveButtonData(java.util.List r12, boolean r13, java.lang.String r14, java.lang.String r15, boolean r16, boolean r17, java.lang.String r18, java.lang.String r19, java.util.List r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r11 = this;
            r0 = r21
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0011
            r3 = r4
            goto L_0x0012
        L_0x0011:
            r3 = r13
        L_0x0012:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0018
            r5 = r2
            goto L_0x0019
        L_0x0018:
            r5 = r14
        L_0x0019:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x001f
            r6 = r2
            goto L_0x0020
        L_0x001f:
            r6 = r15
        L_0x0020:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0026
            r7 = 1
            goto L_0x0028
        L_0x0026:
            r7 = r16
        L_0x0028:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r4 = r17
        L_0x002f:
            r8 = r0 & 64
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x0037
            r8 = r9
            goto L_0x0039
        L_0x0037:
            r8 = r18
        L_0x0039:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r9 = r19
        L_0x0040:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r2 = r20
        L_0x0047:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r4
            r19 = r8
            r20 = r9
            r21 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.UserLeaveButtonData.<init>(java.util.List, boolean, java.lang.String, java.lang.String, boolean, boolean, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<UserLeaveComponentData> getMLocalButtonTypeChild() {
        return this.mLocalButtonTypeChild;
    }

    public final void setMLocalButtonTypeChild(List<UserLeaveComponentData> list) {
        this.mLocalButtonTypeChild = list;
    }

    public final boolean getMLocalIsClick() {
        return this.mLocalIsClick;
    }

    public final void setMLocalIsClick(boolean z) {
        this.mLocalIsClick = z;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final void setComponentId(String str) {
        this.componentId = str;
    }

    public final String getComponentName() {
        return this.componentName;
    }

    public final void setComponentName(String str) {
        this.componentName = str;
    }

    public final boolean getEmailSubscribe() {
        return this.emailSubscribe;
    }

    public final void setEmailSubscribe(boolean z) {
        this.emailSubscribe = z;
    }

    public final boolean isShowEmailSubscribe() {
        return this.isShowEmailSubscribe;
    }

    public final void setShowEmailSubscribe(boolean z) {
        this.isShowEmailSubscribe = z;
    }

    public final String getHost() {
        return this.host;
    }

    public final void setHost(String str) {
        this.host = str;
    }

    public final String getSecret() {
        return this.secret;
    }

    public final void setSecret(String str) {
        this.secret = str;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final void setTags(List<String> list) {
        this.tags = list;
    }

    public UserLeaveButtonData(List<UserLeaveComponentData> list, boolean z, String str, String str2, boolean z2, boolean z3, String str3, String str4, List<String> list2) {
        this.mLocalButtonTypeChild = list;
        this.mLocalIsClick = z;
        this.componentId = str;
        this.componentName = str2;
        this.emailSubscribe = z2;
        this.isShowEmailSubscribe = z3;
        this.host = str3;
        this.secret = str4;
        this.tags = list2;
    }
}
