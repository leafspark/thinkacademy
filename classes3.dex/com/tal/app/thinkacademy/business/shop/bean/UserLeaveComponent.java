package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponent;", "", "clue", "", "dataList", "", "Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponentData;", "intro", "title", "host", "secret", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClue", "()Ljava/lang/String;", "getDataList", "()Ljava/util/List;", "getHost", "getIntro", "getSecret", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserLeaveInfoBean.kt */
public final class UserLeaveComponent {
    private final String clue;
    private final List<UserLeaveComponentData> dataList;
    private final String host;
    private final String intro;
    private final String secret;
    private final String title;

    public UserLeaveComponent() {
        this((String) null, (List) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserLeaveComponent copy$default(UserLeaveComponent userLeaveComponent, String str, List<UserLeaveComponentData> list, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userLeaveComponent.clue;
        }
        if ((i & 2) != 0) {
            list = userLeaveComponent.dataList;
        }
        List<UserLeaveComponentData> list2 = list;
        if ((i & 4) != 0) {
            str2 = userLeaveComponent.intro;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = userLeaveComponent.title;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = userLeaveComponent.host;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = userLeaveComponent.secret;
        }
        return userLeaveComponent.copy(str, list2, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.clue;
    }

    public final List<UserLeaveComponentData> component2() {
        return this.dataList;
    }

    public final String component3() {
        return this.intro;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.host;
    }

    public final String component6() {
        return this.secret;
    }

    public final UserLeaveComponent copy(String str, List<UserLeaveComponentData> list, String str2, String str3, String str4, String str5) {
        return new UserLeaveComponent(str, list, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserLeaveComponent)) {
            return false;
        }
        UserLeaveComponent userLeaveComponent = (UserLeaveComponent) obj;
        return Intrinsics.areEqual((Object) this.clue, (Object) userLeaveComponent.clue) && Intrinsics.areEqual((Object) this.dataList, (Object) userLeaveComponent.dataList) && Intrinsics.areEqual((Object) this.intro, (Object) userLeaveComponent.intro) && Intrinsics.areEqual((Object) this.title, (Object) userLeaveComponent.title) && Intrinsics.areEqual((Object) this.host, (Object) userLeaveComponent.host) && Intrinsics.areEqual((Object) this.secret, (Object) userLeaveComponent.secret);
    }

    public int hashCode() {
        String str = this.clue;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<UserLeaveComponentData> list = this.dataList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.intro;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.host;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.secret;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "UserLeaveComponent(clue=" + this.clue + ", dataList=" + this.dataList + ", intro=" + this.intro + ", title=" + this.title + ", host=" + this.host + ", secret=" + this.secret + ')';
    }

    public UserLeaveComponent(String str, List<UserLeaveComponentData> list, String str2, String str3, String str4, String str5) {
        this.clue = str;
        this.dataList = list;
        this.intro = str2;
        this.title = str3;
        this.host = str4;
        this.secret = str5;
    }

    public final String getClue() {
        return this.clue;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UserLeaveComponent(java.lang.String r6, java.util.List r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            java.lang.String r0 = ""
            if (r13 == 0) goto L_0x0008
            r13 = r0
            goto L_0x0009
        L_0x0008:
            r13 = r6
        L_0x0009:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x0011
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0011:
            r1 = r7
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0018
            r2 = r0
            goto L_0x0019
        L_0x0018:
            r2 = r8
        L_0x0019:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001f
            r3 = r0
            goto L_0x0020
        L_0x001f:
            r3 = r9
        L_0x0020:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0026
            r4 = r0
            goto L_0x0027
        L_0x0026:
            r4 = r10
        L_0x0027:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002d
            r12 = r0
            goto L_0x002e
        L_0x002d:
            r12 = r11
        L_0x002e:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponent.<init>(java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<UserLeaveComponentData> getDataList() {
        return this.dataList;
    }

    public final String getIntro() {
        return this.intro;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getSecret() {
        return this.secret;
    }
}
