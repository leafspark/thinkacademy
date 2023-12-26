package com.tal.app.thinkacademy.common.courseware;

import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J \u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R$\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo;", "Ljava/io/Serializable;", "list", "", "Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList;", "([Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList;)V", "getList", "()[Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList;", "setList", "[Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList;", "component1", "copy", "([Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList;)Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo;", "equals", "", "other", "", "hashCode", "", "toString", "", "CourseInfoList", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CouseWareInfo.kt */
public final class CouseWareInfo implements Serializable {
    private CourseInfoList[] list;

    public static /* synthetic */ CouseWareInfo copy$default(CouseWareInfo couseWareInfo, CourseInfoList[] courseInfoListArr, int i, Object obj) {
        if ((i & 1) != 0) {
            courseInfoListArr = couseWareInfo.list;
        }
        return couseWareInfo.copy(courseInfoListArr);
    }

    public final CourseInfoList[] component1() {
        return this.list;
    }

    public final CouseWareInfo copy(CourseInfoList[] courseInfoListArr) {
        return new CouseWareInfo(courseInfoListArr);
    }

    public String toString() {
        return "CouseWareInfo(list=" + Arrays.toString(this.list) + ')';
    }

    public CouseWareInfo(CourseInfoList[] courseInfoListArr) {
        this.list = courseInfoListArr;
    }

    public final CourseInfoList[] getList() {
        return this.list;
    }

    public final void setList(CourseInfoList[] courseInfoListArr) {
        this.list = courseInfoListArr;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList;", "Ljava/io/Serializable;", "id", "", "detail", "Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList$CourseInfoContent;", "(Ljava/lang/Integer;Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList$CourseInfoContent;)V", "getDetail", "()Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList$CourseInfoContent;", "setDetail", "(Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList$CourseInfoContent;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList$CourseInfoContent;)Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList;", "equals", "", "other", "", "hashCode", "toString", "", "CourseInfoContent", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CouseWareInfo.kt */
    public static final class CourseInfoList implements Serializable {
        private CourseInfoContent detail;
        private Integer id;

        public static /* synthetic */ CourseInfoList copy$default(CourseInfoList courseInfoList, Integer num, CourseInfoContent courseInfoContent, int i, Object obj) {
            if ((i & 1) != 0) {
                num = courseInfoList.id;
            }
            if ((i & 2) != 0) {
                courseInfoContent = courseInfoList.detail;
            }
            return courseInfoList.copy(num, courseInfoContent);
        }

        public final Integer component1() {
            return this.id;
        }

        public final CourseInfoContent component2() {
            return this.detail;
        }

        public final CourseInfoList copy(Integer num, CourseInfoContent courseInfoContent) {
            return new CourseInfoList(num, courseInfoContent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CourseInfoList)) {
                return false;
            }
            CourseInfoList courseInfoList = (CourseInfoList) obj;
            return Intrinsics.areEqual(this.id, courseInfoList.id) && Intrinsics.areEqual(this.detail, courseInfoList.detail);
        }

        public int hashCode() {
            Integer num = this.id;
            int i = 0;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            CourseInfoContent courseInfoContent = this.detail;
            if (courseInfoContent != null) {
                i = courseInfoContent.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "CourseInfoList(id=" + this.id + ", detail=" + this.detail + ')';
        }

        public CourseInfoList(Integer num, CourseInfoContent courseInfoContent) {
            this.id = num;
            this.detail = courseInfoContent;
        }

        public final Integer getId() {
            return this.id;
        }

        public final void setId(Integer num) {
            this.id = num;
        }

        public final CourseInfoContent getDetail() {
            return this.detail;
        }

        public final void setDetail(CourseInfoContent courseInfoContent) {
            this.detail = courseInfoContent;
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b-\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0016\u00105\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0016\u00107\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b\u000e\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0014¨\u0006A"}, d2 = {"Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList$CourseInfoContent;", "Ljava/io/Serializable;", "id", "", "catalog", "modifyTime", "compressState", "compressIndexUrl", "compressIndexUrlSpareList", "", "baseZipUrl", "baseZipUrlSpareList", "baseZipSize", "baseZipMd5", "isBindCourseware", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getBaseZipMd5", "()Ljava/lang/String;", "setBaseZipMd5", "(Ljava/lang/String;)V", "getBaseZipSize", "setBaseZipSize", "getBaseZipUrl", "setBaseZipUrl", "getBaseZipUrlSpareList", "()[Ljava/lang/String;", "setBaseZipUrlSpareList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getCatalog", "setCatalog", "getCompressIndexUrl", "setCompressIndexUrl", "getCompressIndexUrlSpareList", "setCompressIndexUrlSpareList", "getCompressState", "setCompressState", "getId", "setId", "()Ljava/lang/Boolean;", "setBindCourseware", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getModifyTime", "setModifyTime", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList$CourseInfoContent;", "equals", "other", "", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: CouseWareInfo.kt */
        public static final class CourseInfoContent implements Serializable {
            private String baseZipMd5;
            private String baseZipSize;
            private String baseZipUrl;
            private String[] baseZipUrlSpareList;
            private String catalog;
            private String compressIndexUrl;
            private String[] compressIndexUrlSpareList;
            private String compressState;
            private String id;
            private Boolean isBindCourseware;
            private String modifyTime;

            public CourseInfoContent() {
                this((String) null, (String) null, (String) null, (String) null, (String) null, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (Boolean) null, 2047, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ CourseInfoContent copy$default(CourseInfoContent courseInfoContent, String str, String str2, String str3, String str4, String str5, String[] strArr, String str6, String[] strArr2, String str7, String str8, Boolean bool, int i, Object obj) {
                CourseInfoContent courseInfoContent2 = courseInfoContent;
                int i2 = i;
                return courseInfoContent.copy((i2 & 1) != 0 ? courseInfoContent2.id : str, (i2 & 2) != 0 ? courseInfoContent2.catalog : str2, (i2 & 4) != 0 ? courseInfoContent2.modifyTime : str3, (i2 & 8) != 0 ? courseInfoContent2.compressState : str4, (i2 & 16) != 0 ? courseInfoContent2.compressIndexUrl : str5, (i2 & 32) != 0 ? courseInfoContent2.compressIndexUrlSpareList : strArr, (i2 & 64) != 0 ? courseInfoContent2.baseZipUrl : str6, (i2 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? courseInfoContent2.baseZipUrlSpareList : strArr2, (i2 & 256) != 0 ? courseInfoContent2.baseZipSize : str7, (i2 & 512) != 0 ? courseInfoContent2.baseZipMd5 : str8, (i2 & 1024) != 0 ? courseInfoContent2.isBindCourseware : bool);
            }

            public final String component1() {
                return this.id;
            }

            public final String component10() {
                return this.baseZipMd5;
            }

            public final Boolean component11() {
                return this.isBindCourseware;
            }

            public final String component2() {
                return this.catalog;
            }

            public final String component3() {
                return this.modifyTime;
            }

            public final String component4() {
                return this.compressState;
            }

            public final String component5() {
                return this.compressIndexUrl;
            }

            public final String[] component6() {
                return this.compressIndexUrlSpareList;
            }

            public final String component7() {
                return this.baseZipUrl;
            }

            public final String[] component8() {
                return this.baseZipUrlSpareList;
            }

            public final String component9() {
                return this.baseZipSize;
            }

            public final CourseInfoContent copy(String str, String str2, String str3, String str4, String str5, String[] strArr, String str6, String[] strArr2, String str7, String str8, Boolean bool) {
                return new CourseInfoContent(str, str2, str3, str4, str5, strArr, str6, strArr2, str7, str8, bool);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CourseInfoContent)) {
                    return false;
                }
                CourseInfoContent courseInfoContent = (CourseInfoContent) obj;
                return Intrinsics.areEqual(this.id, courseInfoContent.id) && Intrinsics.areEqual(this.catalog, courseInfoContent.catalog) && Intrinsics.areEqual(this.modifyTime, courseInfoContent.modifyTime) && Intrinsics.areEqual(this.compressState, courseInfoContent.compressState) && Intrinsics.areEqual(this.compressIndexUrl, courseInfoContent.compressIndexUrl) && Intrinsics.areEqual(this.compressIndexUrlSpareList, courseInfoContent.compressIndexUrlSpareList) && Intrinsics.areEqual(this.baseZipUrl, courseInfoContent.baseZipUrl) && Intrinsics.areEqual(this.baseZipUrlSpareList, courseInfoContent.baseZipUrlSpareList) && Intrinsics.areEqual(this.baseZipSize, courseInfoContent.baseZipSize) && Intrinsics.areEqual(this.baseZipMd5, courseInfoContent.baseZipMd5) && Intrinsics.areEqual(this.isBindCourseware, courseInfoContent.isBindCourseware);
            }

            public int hashCode() {
                String str = this.id;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.catalog;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.modifyTime;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.compressState;
                int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.compressIndexUrl;
                int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String[] strArr = this.compressIndexUrlSpareList;
                int hashCode6 = (hashCode5 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
                String str6 = this.baseZipUrl;
                int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
                String[] strArr2 = this.baseZipUrlSpareList;
                int hashCode8 = (hashCode7 + (strArr2 == null ? 0 : Arrays.hashCode(strArr2))) * 31;
                String str7 = this.baseZipSize;
                int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
                String str8 = this.baseZipMd5;
                int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
                Boolean bool = this.isBindCourseware;
                if (bool != null) {
                    i = bool.hashCode();
                }
                return hashCode10 + i;
            }

            public String toString() {
                return "CourseInfoContent(id=" + this.id + ", catalog=" + this.catalog + ", modifyTime=" + this.modifyTime + ", compressState=" + this.compressState + ", compressIndexUrl=" + this.compressIndexUrl + ", compressIndexUrlSpareList=" + Arrays.toString(this.compressIndexUrlSpareList) + ", baseZipUrl=" + this.baseZipUrl + ", baseZipUrlSpareList=" + Arrays.toString(this.baseZipUrlSpareList) + ", baseZipSize=" + this.baseZipSize + ", baseZipMd5=" + this.baseZipMd5 + ", isBindCourseware=" + this.isBindCourseware + ')';
            }

            public CourseInfoContent(String str, String str2, String str3, String str4, String str5, String[] strArr, String str6, String[] strArr2, String str7, String str8, Boolean bool) {
                this.id = str;
                this.catalog = str2;
                this.modifyTime = str3;
                this.compressState = str4;
                this.compressIndexUrl = str5;
                this.compressIndexUrlSpareList = strArr;
                this.baseZipUrl = str6;
                this.baseZipUrlSpareList = strArr2;
                this.baseZipSize = str7;
                this.baseZipMd5 = str8;
                this.isBindCourseware = bool;
            }

            public final String getId() {
                return this.id;
            }

            public final void setId(String str) {
                this.id = str;
            }

            public final String getCatalog() {
                return this.catalog;
            }

            public final void setCatalog(String str) {
                this.catalog = str;
            }

            public final String getModifyTime() {
                return this.modifyTime;
            }

            public final void setModifyTime(String str) {
                this.modifyTime = str;
            }

            public final String getCompressState() {
                return this.compressState;
            }

            public final void setCompressState(String str) {
                this.compressState = str;
            }

            public final String getCompressIndexUrl() {
                return this.compressIndexUrl;
            }

            public final void setCompressIndexUrl(String str) {
                this.compressIndexUrl = str;
            }

            public final String[] getCompressIndexUrlSpareList() {
                return this.compressIndexUrlSpareList;
            }

            public final void setCompressIndexUrlSpareList(String[] strArr) {
                this.compressIndexUrlSpareList = strArr;
            }

            public final String getBaseZipUrl() {
                return this.baseZipUrl;
            }

            public final void setBaseZipUrl(String str) {
                this.baseZipUrl = str;
            }

            public final String[] getBaseZipUrlSpareList() {
                return this.baseZipUrlSpareList;
            }

            public final void setBaseZipUrlSpareList(String[] strArr) {
                this.baseZipUrlSpareList = strArr;
            }

            public final String getBaseZipSize() {
                return this.baseZipSize;
            }

            public final void setBaseZipSize(String str) {
                this.baseZipSize = str;
            }

            public final String getBaseZipMd5() {
                return this.baseZipMd5;
            }

            public final void setBaseZipMd5(String str) {
                this.baseZipMd5 = str;
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ CourseInfoContent(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String[] r18, java.lang.String r19, java.lang.String[] r20, java.lang.String r21, java.lang.String r22, java.lang.Boolean r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
                /*
                    r12 = this;
                    r0 = r24
                    r1 = r0 & 1
                    java.lang.String r2 = ""
                    if (r1 == 0) goto L_0x000a
                    r1 = r2
                    goto L_0x000b
                L_0x000a:
                    r1 = r13
                L_0x000b:
                    r3 = r0 & 2
                    if (r3 == 0) goto L_0x0011
                    r3 = r2
                    goto L_0x0012
                L_0x0011:
                    r3 = r14
                L_0x0012:
                    r4 = r0 & 4
                    if (r4 == 0) goto L_0x0018
                    r4 = r2
                    goto L_0x0019
                L_0x0018:
                    r4 = r15
                L_0x0019:
                    r5 = r0 & 8
                    if (r5 == 0) goto L_0x001f
                    r5 = r2
                    goto L_0x0021
                L_0x001f:
                    r5 = r16
                L_0x0021:
                    r6 = r0 & 16
                    if (r6 == 0) goto L_0x0027
                    r6 = r2
                    goto L_0x0029
                L_0x0027:
                    r6 = r17
                L_0x0029:
                    r7 = r0 & 32
                    r8 = 0
                    if (r7 == 0) goto L_0x0031
                    java.lang.String[] r7 = new java.lang.String[r8]
                    goto L_0x0033
                L_0x0031:
                    r7 = r18
                L_0x0033:
                    r9 = r0 & 64
                    if (r9 == 0) goto L_0x0039
                    r9 = r2
                    goto L_0x003b
                L_0x0039:
                    r9 = r19
                L_0x003b:
                    r10 = r0 & 128(0x80, float:1.794E-43)
                    if (r10 == 0) goto L_0x0042
                    java.lang.String[] r8 = new java.lang.String[r8]
                    goto L_0x0044
                L_0x0042:
                    r8 = r20
                L_0x0044:
                    r10 = r0 & 256(0x100, float:3.59E-43)
                    if (r10 == 0) goto L_0x004a
                    r10 = r2
                    goto L_0x004c
                L_0x004a:
                    r10 = r21
                L_0x004c:
                    r11 = r0 & 512(0x200, float:7.175E-43)
                    if (r11 == 0) goto L_0x0051
                    goto L_0x0053
                L_0x0051:
                    r2 = r22
                L_0x0053:
                    r0 = r0 & 1024(0x400, float:1.435E-42)
                    if (r0 == 0) goto L_0x005d
                    r0 = 1
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                    goto L_0x005f
                L_0x005d:
                    r0 = r23
                L_0x005f:
                    r13 = r12
                    r14 = r1
                    r15 = r3
                    r16 = r4
                    r17 = r5
                    r18 = r6
                    r19 = r7
                    r20 = r9
                    r21 = r8
                    r22 = r10
                    r23 = r2
                    r24 = r0
                    r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.courseware.CouseWareInfo.CourseInfoList.CourseInfoContent.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }

            public final Boolean isBindCourseware() {
                return this.isBindCourseware;
            }

            public final void setBindCourseware(Boolean bool) {
                this.isBindCourseware = bool;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.tal.app.thinkacademy.common.courseware.CouseWareInfo");
        CouseWareInfo couseWareInfo = (CouseWareInfo) obj;
        CourseInfoList[] courseInfoListArr = this.list;
        if (courseInfoListArr != null) {
            Intrinsics.checkNotNull(courseInfoListArr);
            CourseInfoList[] courseInfoListArr2 = couseWareInfo.list;
            Intrinsics.checkNotNull(courseInfoListArr2);
            return Arrays.equals(courseInfoListArr, courseInfoListArr2);
        }
    }

    public int hashCode() {
        CourseInfoList[] courseInfoListArr = this.list;
        if (courseInfoListArr == null) {
            return -1;
        }
        Intrinsics.checkNotNull(courseInfoListArr);
        return Arrays.hashCode(courseInfoListArr);
    }
}
