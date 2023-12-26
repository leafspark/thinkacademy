package com.tal.app.thinkacademy.business.shop.bean;

import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007¢\u0006\u0002\u0010\u0015J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010:\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010-JÈ\u0001\u0010D\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020\u000fHÖ\u0001J\t\u0010J\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010\u0019R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b3\u0010-\"\u0004\b4\u0010/R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001d¨\u0006K"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/TeacherDetailsHeader;", "", "achievementList", "", "", "avatar", "contactInfoList", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ContactInfo;", "education", "experience", "highlightList", "identityTag", "name", "state", "", "subjects", "teacherId", "videoUrl", "nodeList", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getAchievementList", "()Ljava/util/List;", "setAchievementList", "(Ljava/util/List;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getContactInfoList", "setContactInfoList", "getEducation", "setEducation", "getExperience", "setExperience", "getHighlightList", "setHighlightList", "getIdentityTag", "setIdentityTag", "getName", "setName", "getNodeList", "setNodeList", "getState", "()Ljava/lang/Integer;", "setState", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSubjects", "setSubjects", "getTeacherId", "setTeacherId", "getVideoUrl", "setVideoUrl", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/shop/bean/TeacherDetailsHeader;", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherDetailsHeader.kt */
public final class TeacherDetailsHeader {
    private List<String> achievementList;
    private String avatar;
    private List<ContactInfo> contactInfoList;
    private String education;
    private String experience;
    private List<String> highlightList;
    private String identityTag;
    private String name;
    private List<? extends BaseNode> nodeList;
    private Integer state;
    private List<? extends Object> subjects;
    private Integer teacherId;
    private String videoUrl;

    public static /* synthetic */ TeacherDetailsHeader copy$default(TeacherDetailsHeader teacherDetailsHeader, List list, String str, List list2, String str2, String str3, List list3, String str4, String str5, Integer num, List list4, Integer num2, String str6, List list5, int i, Object obj) {
        TeacherDetailsHeader teacherDetailsHeader2 = teacherDetailsHeader;
        int i2 = i;
        return teacherDetailsHeader.copy((i2 & 1) != 0 ? teacherDetailsHeader2.achievementList : list, (i2 & 2) != 0 ? teacherDetailsHeader2.avatar : str, (i2 & 4) != 0 ? teacherDetailsHeader2.contactInfoList : list2, (i2 & 8) != 0 ? teacherDetailsHeader2.education : str2, (i2 & 16) != 0 ? teacherDetailsHeader2.experience : str3, (i2 & 32) != 0 ? teacherDetailsHeader2.highlightList : list3, (i2 & 64) != 0 ? teacherDetailsHeader2.identityTag : str4, (i2 & 128) != 0 ? teacherDetailsHeader2.name : str5, (i2 & 256) != 0 ? teacherDetailsHeader2.state : num, (i2 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? teacherDetailsHeader2.subjects : list4, (i2 & 1024) != 0 ? teacherDetailsHeader2.teacherId : num2, (i2 & 2048) != 0 ? teacherDetailsHeader2.videoUrl : str6, (i2 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? teacherDetailsHeader2.nodeList : list5);
    }

    public final List<String> component1() {
        return this.achievementList;
    }

    public final List<Object> component10() {
        return this.subjects;
    }

    public final Integer component11() {
        return this.teacherId;
    }

    public final String component12() {
        return this.videoUrl;
    }

    public final List<BaseNode> component13() {
        return this.nodeList;
    }

    public final String component2() {
        return this.avatar;
    }

    public final List<ContactInfo> component3() {
        return this.contactInfoList;
    }

    public final String component4() {
        return this.education;
    }

    public final String component5() {
        return this.experience;
    }

    public final List<String> component6() {
        return this.highlightList;
    }

    public final String component7() {
        return this.identityTag;
    }

    public final String component8() {
        return this.name;
    }

    public final Integer component9() {
        return this.state;
    }

    public final TeacherDetailsHeader copy(List<String> list, String str, List<ContactInfo> list2, String str2, String str3, List<String> list3, String str4, String str5, Integer num, List<? extends Object> list4, Integer num2, String str6, List<? extends BaseNode> list5) {
        return new TeacherDetailsHeader(list, str, list2, str2, str3, list3, str4, str5, num, list4, num2, str6, list5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeacherDetailsHeader)) {
            return false;
        }
        TeacherDetailsHeader teacherDetailsHeader = (TeacherDetailsHeader) obj;
        return Intrinsics.areEqual((Object) this.achievementList, (Object) teacherDetailsHeader.achievementList) && Intrinsics.areEqual((Object) this.avatar, (Object) teacherDetailsHeader.avatar) && Intrinsics.areEqual((Object) this.contactInfoList, (Object) teacherDetailsHeader.contactInfoList) && Intrinsics.areEqual((Object) this.education, (Object) teacherDetailsHeader.education) && Intrinsics.areEqual((Object) this.experience, (Object) teacherDetailsHeader.experience) && Intrinsics.areEqual((Object) this.highlightList, (Object) teacherDetailsHeader.highlightList) && Intrinsics.areEqual((Object) this.identityTag, (Object) teacherDetailsHeader.identityTag) && Intrinsics.areEqual((Object) this.name, (Object) teacherDetailsHeader.name) && Intrinsics.areEqual((Object) this.state, (Object) teacherDetailsHeader.state) && Intrinsics.areEqual((Object) this.subjects, (Object) teacherDetailsHeader.subjects) && Intrinsics.areEqual((Object) this.teacherId, (Object) teacherDetailsHeader.teacherId) && Intrinsics.areEqual((Object) this.videoUrl, (Object) teacherDetailsHeader.videoUrl) && Intrinsics.areEqual((Object) this.nodeList, (Object) teacherDetailsHeader.nodeList);
    }

    public int hashCode() {
        List<String> list = this.achievementList;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.avatar;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<ContactInfo> list2 = this.contactInfoList;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.education;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.experience;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list3 = this.highlightList;
        int hashCode6 = (hashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str4 = this.identityTag;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.name;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.state;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        List<? extends Object> list4 = this.subjects;
        int hashCode10 = (hashCode9 + (list4 == null ? 0 : list4.hashCode())) * 31;
        Integer num2 = this.teacherId;
        int hashCode11 = (hashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str6 = this.videoUrl;
        int hashCode12 = (hashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<? extends BaseNode> list5 = this.nodeList;
        if (list5 != null) {
            i = list5.hashCode();
        }
        return hashCode12 + i;
    }

    public String toString() {
        return "TeacherDetailsHeader(achievementList=" + this.achievementList + ", avatar=" + this.avatar + ", contactInfoList=" + this.contactInfoList + ", education=" + this.education + ", experience=" + this.experience + ", highlightList=" + this.highlightList + ", identityTag=" + this.identityTag + ", name=" + this.name + ", state=" + this.state + ", subjects=" + this.subjects + ", teacherId=" + this.teacherId + ", videoUrl=" + this.videoUrl + ", nodeList=" + this.nodeList + ')';
    }

    public TeacherDetailsHeader(List<String> list, String str, List<ContactInfo> list2, String str2, String str3, List<String> list3, String str4, String str5, Integer num, List<? extends Object> list4, Integer num2, String str6, List<? extends BaseNode> list5) {
        this.achievementList = list;
        this.avatar = str;
        this.contactInfoList = list2;
        this.education = str2;
        this.experience = str3;
        this.highlightList = list3;
        this.identityTag = str4;
        this.name = str5;
        this.state = num;
        this.subjects = list4;
        this.teacherId = num2;
        this.videoUrl = str6;
        this.nodeList = list5;
    }

    public final List<String> getAchievementList() {
        return this.achievementList;
    }

    public final void setAchievementList(List<String> list) {
        this.achievementList = list;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final List<ContactInfo> getContactInfoList() {
        return this.contactInfoList;
    }

    public final void setContactInfoList(List<ContactInfo> list) {
        this.contactInfoList = list;
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

    public final List<String> getHighlightList() {
        return this.highlightList;
    }

    public final void setHighlightList(List<String> list) {
        this.highlightList = list;
    }

    public final String getIdentityTag() {
        return this.identityTag;
    }

    public final void setIdentityTag(String str) {
        this.identityTag = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final Integer getState() {
        return this.state;
    }

    public final void setState(Integer num) {
        this.state = num;
    }

    public final List<Object> getSubjects() {
        return this.subjects;
    }

    public final void setSubjects(List<? extends Object> list) {
        this.subjects = list;
    }

    public final Integer getTeacherId() {
        return this.teacherId;
    }

    public final void setTeacherId(Integer num) {
        this.teacherId = num;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public final List<BaseNode> getNodeList() {
        return this.nodeList;
    }

    public final void setNodeList(List<? extends BaseNode> list) {
        this.nodeList = list;
    }
}
