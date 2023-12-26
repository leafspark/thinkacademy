package com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode;

import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rHÆ\u0003Jt\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u000b\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\t\u0010\u001e\"\u0004\b\"\u0010 R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012¨\u00064"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/gradeaggregatenode/GradeAggregateTeacherNode;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "id", "", "name", "", "avatar", "education", "experience", "isTop", "", "isBottom", "childNode", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getChildNode", "()Ljava/util/List;", "getEducation", "setEducation", "getExperience", "setExperience", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "setBottom", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setTop", "getName", "setName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/shop/bean/gradeaggregatenode/GradeAggregateTeacherNode;", "equals", "other", "", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateTeacherNode.kt */
public final class GradeAggregateTeacherNode extends BaseNode {
    private String avatar;
    private final List<BaseNode> childNode;
    private String education;
    private String experience;
    private Integer id;
    private Boolean isBottom;
    private Boolean isTop;
    private String name;

    public GradeAggregateTeacherNode() {
        this((Integer) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (List) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GradeAggregateTeacherNode copy$default(GradeAggregateTeacherNode gradeAggregateTeacherNode, Integer num, String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, List list, int i, Object obj) {
        GradeAggregateTeacherNode gradeAggregateTeacherNode2 = gradeAggregateTeacherNode;
        int i2 = i;
        return gradeAggregateTeacherNode.copy((i2 & 1) != 0 ? gradeAggregateTeacherNode2.id : num, (i2 & 2) != 0 ? gradeAggregateTeacherNode2.name : str, (i2 & 4) != 0 ? gradeAggregateTeacherNode2.avatar : str2, (i2 & 8) != 0 ? gradeAggregateTeacherNode2.education : str3, (i2 & 16) != 0 ? gradeAggregateTeacherNode2.experience : str4, (i2 & 32) != 0 ? gradeAggregateTeacherNode2.isTop : bool, (i2 & 64) != 0 ? gradeAggregateTeacherNode2.isBottom : bool2, (i2 & 128) != 0 ? gradeAggregateTeacherNode.getChildNode() : list);
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.education;
    }

    public final String component5() {
        return this.experience;
    }

    public final Boolean component6() {
        return this.isTop;
    }

    public final Boolean component7() {
        return this.isBottom;
    }

    public final List<BaseNode> component8() {
        return getChildNode();
    }

    public final GradeAggregateTeacherNode copy(Integer num, String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, List<BaseNode> list) {
        return new GradeAggregateTeacherNode(num, str, str2, str3, str4, bool, bool2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GradeAggregateTeacherNode)) {
            return false;
        }
        GradeAggregateTeacherNode gradeAggregateTeacherNode = (GradeAggregateTeacherNode) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) gradeAggregateTeacherNode.id) && Intrinsics.areEqual((Object) this.name, (Object) gradeAggregateTeacherNode.name) && Intrinsics.areEqual((Object) this.avatar, (Object) gradeAggregateTeacherNode.avatar) && Intrinsics.areEqual((Object) this.education, (Object) gradeAggregateTeacherNode.education) && Intrinsics.areEqual((Object) this.experience, (Object) gradeAggregateTeacherNode.experience) && Intrinsics.areEqual((Object) this.isTop, (Object) gradeAggregateTeacherNode.isTop) && Intrinsics.areEqual((Object) this.isBottom, (Object) gradeAggregateTeacherNode.isBottom) && Intrinsics.areEqual((Object) getChildNode(), (Object) gradeAggregateTeacherNode.getChildNode());
    }

    public int hashCode() {
        Integer num = this.id;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.avatar;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.education;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.experience;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.isTop;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isBottom;
        int hashCode7 = (hashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        if (getChildNode() != null) {
            i = getChildNode().hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "GradeAggregateTeacherNode(id=" + this.id + ", name=" + this.name + ", avatar=" + this.avatar + ", education=" + this.education + ", experience=" + this.experience + ", isTop=" + this.isTop + ", isBottom=" + this.isBottom + ", childNode=" + getChildNode() + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GradeAggregateTeacherNode(java.lang.Integer r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.Boolean r15, java.lang.Boolean r16, java.util.List r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            r1 = -1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x000d
        L_0x000c:
            r1 = r10
        L_0x000d:
            r2 = r0 & 2
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0015
            r2 = r3
            goto L_0x0016
        L_0x0015:
            r2 = r11
        L_0x0016:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001c
            r4 = r3
            goto L_0x001d
        L_0x001c:
            r4 = r12
        L_0x001d:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0023
            r5 = r3
            goto L_0x0024
        L_0x0023:
            r5 = r13
        L_0x0024:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r3 = r14
        L_0x002a:
            r6 = r0 & 32
            r7 = 0
            if (r6 == 0) goto L_0x0034
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r7)
            goto L_0x0035
        L_0x0034:
            r6 = r15
        L_0x0035:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003e
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            goto L_0x0040
        L_0x003e:
            r7 = r16
        L_0x0040:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0046
            r0 = 0
            goto L_0x0048
        L_0x0046:
            r0 = r17
        L_0x0048:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r4
            r14 = r5
            r15 = r3
            r16 = r6
            r17 = r7
            r18 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTeacherNode.<init>(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getId() {
        return this.id;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final String getEducation() {
        return this.education;
    }

    public final void setEducation(String str) {
        this.education = str;
    }

    public final String getExperience() {
        return this.experience;
    }

    public final void setExperience(String str) {
        this.experience = str;
    }

    public final Boolean isTop() {
        return this.isTop;
    }

    public final void setTop(Boolean bool) {
        this.isTop = bool;
    }

    public final Boolean isBottom() {
        return this.isBottom;
    }

    public final void setBottom(Boolean bool) {
        this.isBottom = bool;
    }

    public List<BaseNode> getChildNode() {
        return this.childNode;
    }

    public GradeAggregateTeacherNode(Integer num, String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, List<BaseNode> list) {
        this.id = num;
        this.name = str;
        this.avatar = str2;
        this.education = str3;
        this.experience = str4;
        this.isTop = bool;
        this.isBottom = bool2;
        this.childNode = list;
    }
}
