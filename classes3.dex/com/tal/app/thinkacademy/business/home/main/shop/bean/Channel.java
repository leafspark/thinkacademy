package com.tal.app.thinkacademy.business.home.main.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0012JJ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Channel;", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelDialogSection;", "groupId", "", "id", "name", "", "weight", "", "isLocalSelect", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;)V", "getGroupId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "isHeader", "()Z", "()Ljava/lang/Boolean;", "setLocalSelect", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getName", "()Ljava/lang/String;", "getWeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Channel;", "equals", "other", "", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelListData.kt */
public final class Channel extends ChannelDialogSection {
    private final Integer groupId;
    private final Integer id;
    private Boolean isLocalSelect;
    private final String name;
    private final Double weight;

    public Channel() {
        this((Integer) null, (Integer) null, (String) null, (Double) null, (Boolean) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Channel copy$default(Channel channel, Integer num, Integer num2, String str, Double d, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = channel.groupId;
        }
        if ((i & 2) != 0) {
            num2 = channel.id;
        }
        Integer num3 = num2;
        if ((i & 4) != 0) {
            str = channel.name;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            d = channel.weight;
        }
        Double d2 = d;
        if ((i & 16) != 0) {
            bool = channel.isLocalSelect;
        }
        return channel.copy(num, num3, str2, d2, bool);
    }

    public final Integer component1() {
        return this.groupId;
    }

    public final Integer component2() {
        return this.id;
    }

    public final String component3() {
        return this.name;
    }

    public final Double component4() {
        return this.weight;
    }

    public final Boolean component5() {
        return this.isLocalSelect;
    }

    public final Channel copy(Integer num, Integer num2, String str, Double d, Boolean bool) {
        return new Channel(num, num2, str, d, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Channel)) {
            return false;
        }
        Channel channel = (Channel) obj;
        return Intrinsics.areEqual((Object) this.groupId, (Object) channel.groupId) && Intrinsics.areEqual((Object) this.id, (Object) channel.id) && Intrinsics.areEqual((Object) this.name, (Object) channel.name) && Intrinsics.areEqual((Object) this.weight, (Object) channel.weight) && Intrinsics.areEqual((Object) this.isLocalSelect, (Object) channel.isLocalSelect);
    }

    public int hashCode() {
        Integer num = this.groupId;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.id;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Double d = this.weight;
        int hashCode4 = (hashCode3 + (d == null ? 0 : d.hashCode())) * 31;
        Boolean bool = this.isLocalSelect;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode4 + i;
    }

    public boolean isHeader() {
        return false;
    }

    public String toString() {
        return "Channel(groupId=" + this.groupId + ", id=" + this.id + ", name=" + this.name + ", weight=" + this.weight + ", isLocalSelect=" + this.isLocalSelect + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Channel(java.lang.Integer r5, java.lang.Integer r6, java.lang.String r7, java.lang.Double r8, java.lang.Boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            if (r11 == 0) goto L_0x000b
            r11 = r1
            goto L_0x000c
        L_0x000b:
            r11 = r5
        L_0x000c:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r1 = r6
        L_0x0012:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0018
            java.lang.String r7 = ""
        L_0x0018:
            r2 = r7
            r5 = r10 & 8
            if (r5 == 0) goto L_0x0023
            r5 = 0
            java.lang.Double r8 = java.lang.Double.valueOf(r5)
        L_0x0023:
            r3 = r8
            r5 = r10 & 16
            if (r5 == 0) goto L_0x002c
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r0)
        L_0x002c:
            r10 = r9
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.bean.Channel.<init>(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Double, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getGroupId() {
        return this.groupId;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Double getWeight() {
        return this.weight;
    }

    public final Boolean isLocalSelect() {
        return this.isLocalSelect;
    }

    public final void setLocalSelect(Boolean bool) {
        this.isLocalSelect = bool;
    }

    public Channel(Integer num, Integer num2, String str, Double d, Boolean bool) {
        super(false);
        this.groupId = num;
        this.id = num2;
        this.name = str;
        this.weight = d;
        this.isLocalSelect = bool;
    }
}
