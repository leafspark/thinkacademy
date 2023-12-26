package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\\\b\b\u0018\u00002\u00020\u0001BÍ\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010'\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0014\u0012\b\b\u0002\u0010+\u001a\u00020\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0014\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u00100J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\u0011\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0005HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010m\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\u0011\u0010t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014HÆ\u0003J\u0011\u0010u\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0014HÆ\u0003J\t\u0010v\u001a\u00020\u0003HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010x\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014HÆ\u0003J\u0011\u0010y\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0014HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010|\u001a\u00020\u0003HÆ\u0003J\t\u0010}\u001a\u00020\u0003HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\u001a\u0004\u0018\u00010\fHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003JÒ\u0003\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00142\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010$\u001a\u00020\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010'\u001a\u00020\u00032\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00142\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u00142\b\b\u0002\u0010+\u001a\u00020\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00142\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u00142\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0015\u0010\u0001\u001a\u00020\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0001\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00102R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u00102R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b<\u0010;R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b=\u0010;R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b>\u0010;R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u00102R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u00102R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u00102R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bD\u0010;R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00102R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u00102R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u00102R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u00102R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00102R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u00102R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bI\u0010;R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u00102R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010!\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bM\u0010;R\u0019\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\bN\u0010CR\u0013\u0010#\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bO\u0010;R\u0011\u0010$\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u00102R\u0013\u0010%\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010;R\u0013\u0010&\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bR\u0010;R\u0011\u0010'\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u00102R\u0019\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\bT\u0010CR\u0019\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\bU\u0010CR\u0011\u0010+\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u00102R\u0013\u0010,\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bW\u0010;R\u0019\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\bX\u0010CR\u0019\u0010.\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\bY\u0010CR\u0013\u0010/\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010;¨\u0006\u0001"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailSpec;", "", "clazzId", "", "courseClosed", "", "courseId", "courseInfo", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailCourseInfo;", "courseType", "curriculumPackageId", "endDate", "", "feeDescClazz", "feeDescOrder", "feeDescRefund", "freeTrialLesson", "goodsCategoryId", "grade", "gradeList", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailGrade;", "gradeName", "isCompetition", "isEntranceTest", "leftLesson", "lessonCount", "levelDegree", "levelDegreeStar", "levelDegreeId", "levelDegreeName", "platformContent", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailPlatformContent;", "platformType", "specValueList", "startDate", "subPlatformType", "subject", "subjectFullName", "subjectId", "teacherIds", "teacherList", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailTeacher;", "term", "timeDesc", "tutorIds", "tutorList", "year", "(IZILcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailCourseInfo;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/util/List;Ljava/lang/String;IIIIIIILjava/lang/String;Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailPlatformContent;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getClazzId", "()I", "getCourseClosed", "()Z", "getCourseId", "getCourseInfo", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailCourseInfo;", "getCourseType", "getCurriculumPackageId", "getEndDate", "()Ljava/lang/String;", "getFeeDescClazz", "getFeeDescOrder", "getFeeDescRefund", "getFreeTrialLesson", "getGoodsCategoryId", "getGrade", "getGradeList", "()Ljava/util/List;", "getGradeName", "getLeftLesson", "getLessonCount", "getLevelDegree", "getLevelDegreeId", "getLevelDegreeName", "getLevelDegreeStar", "getPlatformContent", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailPlatformContent;", "getPlatformType", "getSpecValueList", "getStartDate", "getSubPlatformType", "getSubject", "getSubjectFullName", "getSubjectId", "getTeacherIds", "getTeacherList", "getTerm", "getTimeDesc", "getTutorIds", "getTutorList", "getYear", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailSpec {
    private final int clazzId;
    private final boolean courseClosed;
    private final int courseId;
    private final ShopClassDetailCourseInfo courseInfo;
    private final int courseType;
    private final int curriculumPackageId;
    private final String endDate;
    private final String feeDescClazz;
    private final String feeDescOrder;
    private final String feeDescRefund;
    private final int freeTrialLesson;
    private final int goodsCategoryId;
    private final int grade;
    private final List<ShopClassDetailGrade> gradeList;
    private final String gradeName;
    private final int isCompetition;
    private final int isEntranceTest;
    private final int leftLesson;
    private final int lessonCount;
    private final int levelDegree;
    private final int levelDegreeId;
    private final String levelDegreeName;
    private final int levelDegreeStar;
    private final ShopClassDetailPlatformContent platformContent;
    private final String platformType;
    private final List<Object> specValueList;
    private final String startDate;
    private final int subPlatformType;
    private final String subject;
    private final String subjectFullName;
    private final int subjectId;
    private final List<Integer> teacherIds;
    private final List<ShopClassDetailTeacher> teacherList;
    private final int term;
    private final String timeDesc;
    private final List<Integer> tutorIds;
    private final List<ShopClassDetailTeacher> tutorList;
    private final String year;

    public ShopClassDetailSpec() {
        this(0, false, 0, (ShopClassDetailCourseInfo) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, 0, (List) null, (String) null, 0, 0, 0, 0, 0, 0, 0, (String) null, (ShopClassDetailPlatformContent) null, (String) null, (List) null, (String) null, 0, (String) null, (String) null, 0, (List) null, (List) null, 0, (String) null, (List) null, (List) null, (String) null, -1, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailSpec copy$default(ShopClassDetailSpec shopClassDetailSpec, int i, boolean z, int i2, ShopClassDetailCourseInfo shopClassDetailCourseInfo, int i3, int i4, String str, String str2, String str3, String str4, int i5, int i6, int i7, List list, String str5, int i8, int i9, int i10, int i11, int i12, int i13, int i14, String str6, ShopClassDetailPlatformContent shopClassDetailPlatformContent, String str7, List list2, String str8, int i15, String str9, String str10, int i16, List list3, List list4, int i17, String str11, List list5, List list6, String str12, int i18, int i19, Object obj) {
        ShopClassDetailSpec shopClassDetailSpec2 = shopClassDetailSpec;
        int i20 = i18;
        return shopClassDetailSpec.copy((i20 & 1) != 0 ? shopClassDetailSpec2.clazzId : i, (i20 & 2) != 0 ? shopClassDetailSpec2.courseClosed : z, (i20 & 4) != 0 ? shopClassDetailSpec2.courseId : i2, (i20 & 8) != 0 ? shopClassDetailSpec2.courseInfo : shopClassDetailCourseInfo, (i20 & 16) != 0 ? shopClassDetailSpec2.courseType : i3, (i20 & 32) != 0 ? shopClassDetailSpec2.curriculumPackageId : i4, (i20 & 64) != 0 ? shopClassDetailSpec2.endDate : str, (i20 & 128) != 0 ? shopClassDetailSpec2.feeDescClazz : str2, (i20 & 256) != 0 ? shopClassDetailSpec2.feeDescOrder : str3, (i20 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? shopClassDetailSpec2.feeDescRefund : str4, (i20 & 1024) != 0 ? shopClassDetailSpec2.freeTrialLesson : i5, (i20 & 2048) != 0 ? shopClassDetailSpec2.goodsCategoryId : i6, (i20 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? shopClassDetailSpec2.grade : i7, (i20 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? shopClassDetailSpec2.gradeList : list, (i20 & 16384) != 0 ? shopClassDetailSpec2.gradeName : str5, (i20 & 32768) != 0 ? shopClassDetailSpec2.isCompetition : i8, (i20 & 65536) != 0 ? shopClassDetailSpec2.isEntranceTest : i9, (i20 & 131072) != 0 ? shopClassDetailSpec2.leftLesson : i10, (i20 & 262144) != 0 ? shopClassDetailSpec2.lessonCount : i11, (i20 & 524288) != 0 ? shopClassDetailSpec2.levelDegree : i12, (i20 & 1048576) != 0 ? shopClassDetailSpec2.levelDegreeStar : i13, (i20 & 2097152) != 0 ? shopClassDetailSpec2.levelDegreeId : i14, (i20 & 4194304) != 0 ? shopClassDetailSpec2.levelDegreeName : str6, (i20 & 8388608) != 0 ? shopClassDetailSpec2.platformContent : shopClassDetailPlatformContent, (i20 & 16777216) != 0 ? shopClassDetailSpec2.platformType : str7, (i20 & 33554432) != 0 ? shopClassDetailSpec2.specValueList : list2, (i20 & 67108864) != 0 ? shopClassDetailSpec2.startDate : str8, (i20 & 134217728) != 0 ? shopClassDetailSpec2.subPlatformType : i15, (i20 & 268435456) != 0 ? shopClassDetailSpec2.subject : str9, (i20 & 536870912) != 0 ? shopClassDetailSpec2.subjectFullName : str10, (i20 & 1073741824) != 0 ? shopClassDetailSpec2.subjectId : i16, (i20 & IntCompanionObject.MIN_VALUE) != 0 ? shopClassDetailSpec2.teacherIds : list3, (i19 & 1) != 0 ? shopClassDetailSpec2.teacherList : list4, (i19 & 2) != 0 ? shopClassDetailSpec2.term : i17, (i19 & 4) != 0 ? shopClassDetailSpec2.timeDesc : str11, (i19 & 8) != 0 ? shopClassDetailSpec2.tutorIds : list5, (i19 & 16) != 0 ? shopClassDetailSpec2.tutorList : list6, (i19 & 32) != 0 ? shopClassDetailSpec2.year : str12);
    }

    public final int component1() {
        return this.clazzId;
    }

    public final String component10() {
        return this.feeDescRefund;
    }

    public final int component11() {
        return this.freeTrialLesson;
    }

    public final int component12() {
        return this.goodsCategoryId;
    }

    public final int component13() {
        return this.grade;
    }

    public final List<ShopClassDetailGrade> component14() {
        return this.gradeList;
    }

    public final String component15() {
        return this.gradeName;
    }

    public final int component16() {
        return this.isCompetition;
    }

    public final int component17() {
        return this.isEntranceTest;
    }

    public final int component18() {
        return this.leftLesson;
    }

    public final int component19() {
        return this.lessonCount;
    }

    public final boolean component2() {
        return this.courseClosed;
    }

    public final int component20() {
        return this.levelDegree;
    }

    public final int component21() {
        return this.levelDegreeStar;
    }

    public final int component22() {
        return this.levelDegreeId;
    }

    public final String component23() {
        return this.levelDegreeName;
    }

    public final ShopClassDetailPlatformContent component24() {
        return this.platformContent;
    }

    public final String component25() {
        return this.platformType;
    }

    public final List<Object> component26() {
        return this.specValueList;
    }

    public final String component27() {
        return this.startDate;
    }

    public final int component28() {
        return this.subPlatformType;
    }

    public final String component29() {
        return this.subject;
    }

    public final int component3() {
        return this.courseId;
    }

    public final String component30() {
        return this.subjectFullName;
    }

    public final int component31() {
        return this.subjectId;
    }

    public final List<Integer> component32() {
        return this.teacherIds;
    }

    public final List<ShopClassDetailTeacher> component33() {
        return this.teacherList;
    }

    public final int component34() {
        return this.term;
    }

    public final String component35() {
        return this.timeDesc;
    }

    public final List<Integer> component36() {
        return this.tutorIds;
    }

    public final List<ShopClassDetailTeacher> component37() {
        return this.tutorList;
    }

    public final String component38() {
        return this.year;
    }

    public final ShopClassDetailCourseInfo component4() {
        return this.courseInfo;
    }

    public final int component5() {
        return this.courseType;
    }

    public final int component6() {
        return this.curriculumPackageId;
    }

    public final String component7() {
        return this.endDate;
    }

    public final String component8() {
        return this.feeDescClazz;
    }

    public final String component9() {
        return this.feeDescOrder;
    }

    public final ShopClassDetailSpec copy(int i, boolean z, int i2, ShopClassDetailCourseInfo shopClassDetailCourseInfo, int i3, int i4, String str, String str2, String str3, String str4, int i5, int i6, int i7, List<ShopClassDetailGrade> list, String str5, int i8, int i9, int i10, int i11, int i12, int i13, int i14, String str6, ShopClassDetailPlatformContent shopClassDetailPlatformContent, String str7, List<? extends Object> list2, String str8, int i15, String str9, String str10, int i16, List<Integer> list3, List<ShopClassDetailTeacher> list4, int i17, String str11, List<Integer> list5, List<ShopClassDetailTeacher> list6, String str12) {
        return new ShopClassDetailSpec(i, z, i2, shopClassDetailCourseInfo, i3, i4, str, str2, str3, str4, i5, i6, i7, list, str5, i8, i9, i10, i11, i12, i13, i14, str6, shopClassDetailPlatformContent, str7, list2, str8, i15, str9, str10, i16, list3, list4, i17, str11, list5, list6, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailSpec)) {
            return false;
        }
        ShopClassDetailSpec shopClassDetailSpec = (ShopClassDetailSpec) obj;
        return this.clazzId == shopClassDetailSpec.clazzId && this.courseClosed == shopClassDetailSpec.courseClosed && this.courseId == shopClassDetailSpec.courseId && Intrinsics.areEqual((Object) this.courseInfo, (Object) shopClassDetailSpec.courseInfo) && this.courseType == shopClassDetailSpec.courseType && this.curriculumPackageId == shopClassDetailSpec.curriculumPackageId && Intrinsics.areEqual((Object) this.endDate, (Object) shopClassDetailSpec.endDate) && Intrinsics.areEqual((Object) this.feeDescClazz, (Object) shopClassDetailSpec.feeDescClazz) && Intrinsics.areEqual((Object) this.feeDescOrder, (Object) shopClassDetailSpec.feeDescOrder) && Intrinsics.areEqual((Object) this.feeDescRefund, (Object) shopClassDetailSpec.feeDescRefund) && this.freeTrialLesson == shopClassDetailSpec.freeTrialLesson && this.goodsCategoryId == shopClassDetailSpec.goodsCategoryId && this.grade == shopClassDetailSpec.grade && Intrinsics.areEqual((Object) this.gradeList, (Object) shopClassDetailSpec.gradeList) && Intrinsics.areEqual((Object) this.gradeName, (Object) shopClassDetailSpec.gradeName) && this.isCompetition == shopClassDetailSpec.isCompetition && this.isEntranceTest == shopClassDetailSpec.isEntranceTest && this.leftLesson == shopClassDetailSpec.leftLesson && this.lessonCount == shopClassDetailSpec.lessonCount && this.levelDegree == shopClassDetailSpec.levelDegree && this.levelDegreeStar == shopClassDetailSpec.levelDegreeStar && this.levelDegreeId == shopClassDetailSpec.levelDegreeId && Intrinsics.areEqual((Object) this.levelDegreeName, (Object) shopClassDetailSpec.levelDegreeName) && Intrinsics.areEqual((Object) this.platformContent, (Object) shopClassDetailSpec.platformContent) && Intrinsics.areEqual((Object) this.platformType, (Object) shopClassDetailSpec.platformType) && Intrinsics.areEqual((Object) this.specValueList, (Object) shopClassDetailSpec.specValueList) && Intrinsics.areEqual((Object) this.startDate, (Object) shopClassDetailSpec.startDate) && this.subPlatformType == shopClassDetailSpec.subPlatformType && Intrinsics.areEqual((Object) this.subject, (Object) shopClassDetailSpec.subject) && Intrinsics.areEqual((Object) this.subjectFullName, (Object) shopClassDetailSpec.subjectFullName) && this.subjectId == shopClassDetailSpec.subjectId && Intrinsics.areEqual((Object) this.teacherIds, (Object) shopClassDetailSpec.teacherIds) && Intrinsics.areEqual((Object) this.teacherList, (Object) shopClassDetailSpec.teacherList) && this.term == shopClassDetailSpec.term && Intrinsics.areEqual((Object) this.timeDesc, (Object) shopClassDetailSpec.timeDesc) && Intrinsics.areEqual((Object) this.tutorIds, (Object) shopClassDetailSpec.tutorIds) && Intrinsics.areEqual((Object) this.tutorList, (Object) shopClassDetailSpec.tutorList) && Intrinsics.areEqual((Object) this.year, (Object) shopClassDetailSpec.year);
    }

    public int hashCode() {
        int i = this.clazzId * 31;
        boolean z = this.courseClosed;
        if (z) {
            z = true;
        }
        int i2 = (((i + (z ? 1 : 0)) * 31) + this.courseId) * 31;
        ShopClassDetailCourseInfo shopClassDetailCourseInfo = this.courseInfo;
        int i3 = 0;
        int hashCode = (((((i2 + (shopClassDetailCourseInfo == null ? 0 : shopClassDetailCourseInfo.hashCode())) * 31) + this.courseType) * 31) + this.curriculumPackageId) * 31;
        String str = this.endDate;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.feeDescClazz;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.feeDescOrder;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.feeDescRefund;
        int hashCode5 = (((((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.freeTrialLesson) * 31) + this.goodsCategoryId) * 31) + this.grade) * 31;
        List<ShopClassDetailGrade> list = this.gradeList;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        String str5 = this.gradeName;
        int hashCode7 = (((((((((((((((hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.isCompetition) * 31) + this.isEntranceTest) * 31) + this.leftLesson) * 31) + this.lessonCount) * 31) + this.levelDegree) * 31) + this.levelDegreeStar) * 31) + this.levelDegreeId) * 31;
        String str6 = this.levelDegreeName;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        ShopClassDetailPlatformContent shopClassDetailPlatformContent = this.platformContent;
        int hashCode9 = (hashCode8 + (shopClassDetailPlatformContent == null ? 0 : shopClassDetailPlatformContent.hashCode())) * 31;
        String str7 = this.platformType;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<Object> list2 = this.specValueList;
        int hashCode11 = (hashCode10 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str8 = this.startDate;
        int hashCode12 = (((hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31) + this.subPlatformType) * 31;
        String str9 = this.subject;
        int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.subjectFullName;
        int hashCode14 = (((hashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31) + this.subjectId) * 31;
        List<Integer> list3 = this.teacherIds;
        int hashCode15 = (hashCode14 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<ShopClassDetailTeacher> list4 = this.teacherList;
        int hashCode16 = (((hashCode15 + (list4 == null ? 0 : list4.hashCode())) * 31) + this.term) * 31;
        String str11 = this.timeDesc;
        int hashCode17 = (hashCode16 + (str11 == null ? 0 : str11.hashCode())) * 31;
        List<Integer> list5 = this.tutorIds;
        int hashCode18 = (hashCode17 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<ShopClassDetailTeacher> list6 = this.tutorList;
        int hashCode19 = (hashCode18 + (list6 == null ? 0 : list6.hashCode())) * 31;
        String str12 = this.year;
        if (str12 != null) {
            i3 = str12.hashCode();
        }
        return hashCode19 + i3;
    }

    public String toString() {
        return "ShopClassDetailSpec(clazzId=" + this.clazzId + ", courseClosed=" + this.courseClosed + ", courseId=" + this.courseId + ", courseInfo=" + this.courseInfo + ", courseType=" + this.courseType + ", curriculumPackageId=" + this.curriculumPackageId + ", endDate=" + this.endDate + ", feeDescClazz=" + this.feeDescClazz + ", feeDescOrder=" + this.feeDescOrder + ", feeDescRefund=" + this.feeDescRefund + ", freeTrialLesson=" + this.freeTrialLesson + ", goodsCategoryId=" + this.goodsCategoryId + ", grade=" + this.grade + ", gradeList=" + this.gradeList + ", gradeName=" + this.gradeName + ", isCompetition=" + this.isCompetition + ", isEntranceTest=" + this.isEntranceTest + ", leftLesson=" + this.leftLesson + ", lessonCount=" + this.lessonCount + ", levelDegree=" + this.levelDegree + ", levelDegreeStar=" + this.levelDegreeStar + ", levelDegreeId=" + this.levelDegreeId + ", levelDegreeName=" + this.levelDegreeName + ", platformContent=" + this.platformContent + ", platformType=" + this.platformType + ", specValueList=" + this.specValueList + ", startDate=" + this.startDate + ", subPlatformType=" + this.subPlatformType + ", subject=" + this.subject + ", subjectFullName=" + this.subjectFullName + ", subjectId=" + this.subjectId + ", teacherIds=" + this.teacherIds + ", teacherList=" + this.teacherList + ", term=" + this.term + ", timeDesc=" + this.timeDesc + ", tutorIds=" + this.tutorIds + ", tutorList=" + this.tutorList + ", year=" + this.year + ')';
    }

    public ShopClassDetailSpec(int i, boolean z, int i2, ShopClassDetailCourseInfo shopClassDetailCourseInfo, int i3, int i4, String str, String str2, String str3, String str4, int i5, int i6, int i7, List<ShopClassDetailGrade> list, String str5, int i8, int i9, int i10, int i11, int i12, int i13, int i14, String str6, ShopClassDetailPlatformContent shopClassDetailPlatformContent, String str7, List<? extends Object> list2, String str8, int i15, String str9, String str10, int i16, List<Integer> list3, List<ShopClassDetailTeacher> list4, int i17, String str11, List<Integer> list5, List<ShopClassDetailTeacher> list6, String str12) {
        this.clazzId = i;
        this.courseClosed = z;
        this.courseId = i2;
        this.courseInfo = shopClassDetailCourseInfo;
        this.courseType = i3;
        this.curriculumPackageId = i4;
        this.endDate = str;
        this.feeDescClazz = str2;
        this.feeDescOrder = str3;
        this.feeDescRefund = str4;
        this.freeTrialLesson = i5;
        this.goodsCategoryId = i6;
        this.grade = i7;
        this.gradeList = list;
        this.gradeName = str5;
        this.isCompetition = i8;
        this.isEntranceTest = i9;
        this.leftLesson = i10;
        this.lessonCount = i11;
        this.levelDegree = i12;
        this.levelDegreeStar = i13;
        this.levelDegreeId = i14;
        this.levelDegreeName = str6;
        this.platformContent = shopClassDetailPlatformContent;
        this.platformType = str7;
        this.specValueList = list2;
        this.startDate = str8;
        this.subPlatformType = i15;
        this.subject = str9;
        this.subjectFullName = str10;
        this.subjectId = i16;
        this.teacherIds = list3;
        this.teacherList = list4;
        this.term = i17;
        this.timeDesc = str11;
        this.tutorIds = list5;
        this.tutorList = list6;
        this.year = str12;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopClassDetailSpec(int r39, boolean r40, int r41, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseInfo r42, int r43, int r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, int r49, int r50, int r51, java.util.List r52, java.lang.String r53, int r54, int r55, int r56, int r57, int r58, int r59, int r60, java.lang.String r61, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPlatformContent r62, java.lang.String r63, java.util.List r64, java.lang.String r65, int r66, java.lang.String r67, java.lang.String r68, int r69, java.util.List r70, java.util.List r71, int r72, java.lang.String r73, java.util.List r74, java.util.List r75, java.lang.String r76, int r77, int r78, kotlin.jvm.internal.DefaultConstructorMarker r79) {
        /*
            r38 = this;
            r0 = r77
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r39
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r40
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r41
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r42
        L_0x0022:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0028
            r7 = 0
            goto L_0x002a
        L_0x0028:
            r7 = r43
        L_0x002a:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0030
            r8 = 0
            goto L_0x0032
        L_0x0030:
            r8 = r44
        L_0x0032:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0038
            r9 = 0
            goto L_0x003a
        L_0x0038:
            r9 = r45
        L_0x003a:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0040
            r10 = 0
            goto L_0x0042
        L_0x0040:
            r10 = r46
        L_0x0042:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0048
            r11 = 0
            goto L_0x004a
        L_0x0048:
            r11 = r47
        L_0x004a:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0050
            r12 = 0
            goto L_0x0052
        L_0x0050:
            r12 = r48
        L_0x0052:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0058
            r13 = 0
            goto L_0x005a
        L_0x0058:
            r13 = r49
        L_0x005a:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0060
            r14 = 0
            goto L_0x0062
        L_0x0060:
            r14 = r50
        L_0x0062:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0068
            r15 = 0
            goto L_0x006a
        L_0x0068:
            r15 = r51
        L_0x006a:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0070
            r2 = 0
            goto L_0x0072
        L_0x0070:
            r2 = r52
        L_0x0072:
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0078
            r6 = 0
            goto L_0x007a
        L_0x0078:
            r6 = r53
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r54
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r55
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r56
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r57
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r58
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r59
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r60
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r61
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00dc
            r24 = 0
            goto L_0x00de
        L_0x00dc:
            r24 = r62
        L_0x00de:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e7
            r25 = 0
            goto L_0x00e9
        L_0x00e7:
            r25 = r63
        L_0x00e9:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00f2
            r26 = 0
            goto L_0x00f4
        L_0x00f2:
            r26 = r64
        L_0x00f4:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00fd
            r27 = 0
            goto L_0x00ff
        L_0x00fd:
            r27 = r65
        L_0x00ff:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0108
            r28 = 0
            goto L_0x010a
        L_0x0108:
            r28 = r66
        L_0x010a:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x0113
            r29 = 0
            goto L_0x0115
        L_0x0113:
            r29 = r67
        L_0x0115:
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x011e
            r30 = 0
            goto L_0x0120
        L_0x011e:
            r30 = r68
        L_0x0120:
            r31 = 1073741824(0x40000000, float:2.0)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x0129
            r31 = 0
            goto L_0x012b
        L_0x0129:
            r31 = r69
        L_0x012b:
            r32 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r32
            if (r0 == 0) goto L_0x0133
            r0 = 0
            goto L_0x0135
        L_0x0133:
            r0 = r70
        L_0x0135:
            r32 = r78 & 1
            if (r32 == 0) goto L_0x013c
            r32 = 0
            goto L_0x013e
        L_0x013c:
            r32 = r71
        L_0x013e:
            r33 = r78 & 2
            if (r33 == 0) goto L_0x0145
            r33 = 0
            goto L_0x0147
        L_0x0145:
            r33 = r72
        L_0x0147:
            r34 = r78 & 4
            if (r34 == 0) goto L_0x014e
            r34 = 0
            goto L_0x0150
        L_0x014e:
            r34 = r73
        L_0x0150:
            r35 = r78 & 8
            if (r35 == 0) goto L_0x0157
            r35 = 0
            goto L_0x0159
        L_0x0157:
            r35 = r74
        L_0x0159:
            r36 = r78 & 16
            if (r36 == 0) goto L_0x0160
            r36 = 0
            goto L_0x0162
        L_0x0160:
            r36 = r75
        L_0x0162:
            r37 = r78 & 32
            if (r37 == 0) goto L_0x0169
            r37 = 0
            goto L_0x016b
        L_0x0169:
            r37 = r76
        L_0x016b:
            r39 = r38
            r40 = r1
            r41 = r3
            r42 = r4
            r43 = r5
            r44 = r7
            r45 = r8
            r46 = r9
            r47 = r10
            r48 = r11
            r49 = r12
            r50 = r13
            r51 = r14
            r52 = r15
            r53 = r2
            r54 = r6
            r55 = r16
            r56 = r17
            r57 = r18
            r58 = r19
            r59 = r20
            r60 = r21
            r61 = r22
            r62 = r23
            r63 = r24
            r64 = r25
            r65 = r26
            r66 = r27
            r67 = r28
            r68 = r29
            r69 = r30
            r70 = r31
            r71 = r0
            r72 = r32
            r73 = r33
            r74 = r34
            r75 = r35
            r76 = r36
            r77 = r37
            r39.<init>(r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec.<init>(int, boolean, int, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseInfo, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, java.util.List, java.lang.String, int, int, int, int, int, int, int, java.lang.String, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPlatformContent, java.lang.String, java.util.List, java.lang.String, int, java.lang.String, java.lang.String, int, java.util.List, java.util.List, int, java.lang.String, java.util.List, java.util.List, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getClazzId() {
        return this.clazzId;
    }

    public final boolean getCourseClosed() {
        return this.courseClosed;
    }

    public final int getCourseId() {
        return this.courseId;
    }

    public final ShopClassDetailCourseInfo getCourseInfo() {
        return this.courseInfo;
    }

    public final int getCourseType() {
        return this.courseType;
    }

    public final int getCurriculumPackageId() {
        return this.curriculumPackageId;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final String getFeeDescClazz() {
        return this.feeDescClazz;
    }

    public final String getFeeDescOrder() {
        return this.feeDescOrder;
    }

    public final String getFeeDescRefund() {
        return this.feeDescRefund;
    }

    public final int getFreeTrialLesson() {
        return this.freeTrialLesson;
    }

    public final int getGoodsCategoryId() {
        return this.goodsCategoryId;
    }

    public final int getGrade() {
        return this.grade;
    }

    public final List<ShopClassDetailGrade> getGradeList() {
        return this.gradeList;
    }

    public final String getGradeName() {
        return this.gradeName;
    }

    public final int isCompetition() {
        return this.isCompetition;
    }

    public final int isEntranceTest() {
        return this.isEntranceTest;
    }

    public final int getLeftLesson() {
        return this.leftLesson;
    }

    public final int getLessonCount() {
        return this.lessonCount;
    }

    public final int getLevelDegree() {
        return this.levelDegree;
    }

    public final int getLevelDegreeStar() {
        return this.levelDegreeStar;
    }

    public final int getLevelDegreeId() {
        return this.levelDegreeId;
    }

    public final String getLevelDegreeName() {
        return this.levelDegreeName;
    }

    public final ShopClassDetailPlatformContent getPlatformContent() {
        return this.platformContent;
    }

    public final String getPlatformType() {
        return this.platformType;
    }

    public final List<Object> getSpecValueList() {
        return this.specValueList;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final int getSubPlatformType() {
        return this.subPlatformType;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getSubjectFullName() {
        return this.subjectFullName;
    }

    public final int getSubjectId() {
        return this.subjectId;
    }

    public final List<Integer> getTeacherIds() {
        return this.teacherIds;
    }

    public final List<ShopClassDetailTeacher> getTeacherList() {
        return this.teacherList;
    }

    public final int getTerm() {
        return this.term;
    }

    public final String getTimeDesc() {
        return this.timeDesc;
    }

    public final List<Integer> getTutorIds() {
        return this.tutorIds;
    }

    public final List<ShopClassDetailTeacher> getTutorList() {
        return this.tutorList;
    }

    public final String getYear() {
        return this.year;
    }
}
