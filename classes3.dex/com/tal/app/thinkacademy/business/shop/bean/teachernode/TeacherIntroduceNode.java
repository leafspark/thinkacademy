package com.tal.app.thinkacademy.business.shop.bean.teachernode;

import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BY\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fHÆ\u0003Jn\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\nHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00061"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/teachernode/TeacherIntroduceNode;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "experience", "", "name", "avatar", "education", "highlightList", "", "teacherId", "", "childNode", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getChildNode", "()Ljava/util/List;", "getEducation", "setEducation", "getExperience", "setExperience", "getHighlightList", "setHighlightList", "(Ljava/util/List;)V", "getName", "setName", "getTeacherId", "()Ljava/lang/Integer;", "setTeacherId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/shop/bean/teachernode/TeacherIntroduceNode;", "equals", "", "other", "", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherIntroduceNode.kt */
public final class TeacherIntroduceNode extends BaseNode {
    private String avatar;
    private final List<BaseNode> childNode;
    private String education;
    private String experience;
    private List<String> highlightList;
    private String name;
    private Integer teacherId;

    public static /* synthetic */ TeacherIntroduceNode copy$default(TeacherIntroduceNode teacherIntroduceNode, String str, String str2, String str3, String str4, List<String> list, Integer num, List<BaseNode> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = teacherIntroduceNode.experience;
        }
        if ((i & 2) != 0) {
            str2 = teacherIntroduceNode.name;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = teacherIntroduceNode.avatar;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = teacherIntroduceNode.education;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            list = teacherIntroduceNode.highlightList;
        }
        List<String> list3 = list;
        if ((i & 32) != 0) {
            num = teacherIntroduceNode.teacherId;
        }
        Integer num2 = num;
        if ((i & 64) != 0) {
            list2 = teacherIntroduceNode.getChildNode();
        }
        return teacherIntroduceNode.copy(str, str5, str6, str7, list3, num2, list2);
    }

    public final String component1() {
        return this.experience;
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

    public final List<String> component5() {
        return this.highlightList;
    }

    public final Integer component6() {
        return this.teacherId;
    }

    public final List<BaseNode> component7() {
        return getChildNode();
    }

    public final TeacherIntroduceNode copy(String str, String str2, String str3, String str4, List<String> list, Integer num, List<BaseNode> list2) {
        return new TeacherIntroduceNode(str, str2, str3, str4, list, num, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeacherIntroduceNode)) {
            return false;
        }
        TeacherIntroduceNode teacherIntroduceNode = (TeacherIntroduceNode) obj;
        return Intrinsics.areEqual((Object) this.experience, (Object) teacherIntroduceNode.experience) && Intrinsics.areEqual((Object) this.name, (Object) teacherIntroduceNode.name) && Intrinsics.areEqual((Object) this.avatar, (Object) teacherIntroduceNode.avatar) && Intrinsics.areEqual((Object) this.education, (Object) teacherIntroduceNode.education) && Intrinsics.areEqual((Object) this.highlightList, (Object) teacherIntroduceNode.highlightList) && Intrinsics.areEqual((Object) this.teacherId, (Object) teacherIntroduceNode.teacherId) && Intrinsics.areEqual((Object) getChildNode(), (Object) teacherIntroduceNode.getChildNode());
    }

    public int hashCode() {
        String str = this.experience;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatar;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.education;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<String> list = this.highlightList;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.teacherId;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        if (getChildNode() != null) {
            i = getChildNode().hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "TeacherIntroduceNode(experience=" + this.experience + ", name=" + this.name + ", avatar=" + this.avatar + ", education=" + this.education + ", highlightList=" + this.highlightList + ", teacherId=" + this.teacherId + ", childNode=" + getChildNode() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TeacherIntroduceNode(String str, String str2, String str3, String str4, List list, Integer num, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, list, num, (i & 64) != 0 ? null : list2);
    }

    public final String getExperience() {
        return this.experience;
    }

    public final void setExperience(String str) {
        this.experience = str;
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

    public final List<String> getHighlightList() {
        return this.highlightList;
    }

    public final void setHighlightList(List<String> list) {
        this.highlightList = list;
    }

    public final Integer getTeacherId() {
        return this.teacherId;
    }

    public final void setTeacherId(Integer num) {
        this.teacherId = num;
    }

    public List<BaseNode> getChildNode() {
        return this.childNode;
    }

    public TeacherIntroduceNode(String str, String str2, String str3, String str4, List<String> list, Integer num, List<BaseNode> list2) {
        this.experience = str;
        this.name = str2;
        this.avatar = str3;
        this.education = str4;
        this.highlightList = list;
        this.teacherId = num;
        this.childNode = list2;
    }
}
