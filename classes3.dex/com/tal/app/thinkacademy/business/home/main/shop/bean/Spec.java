package com.tal.app.thinkacademy.business.home.main.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bW\b\b\u0018\u00002\u00020\u0001Bë\u0003\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010.J\u0011\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010[\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u0011\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010`\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010a\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010c\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010d\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010e\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010g\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010i\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010l\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010o\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u0011\u0010p\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010q\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0003HÆ\u0003J\u0010\u0010r\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010s\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010u\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010w\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010x\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010y\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010z\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\fHÆ\u0003Jô\u0003\u0010}\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010~J\u0014\u0010\u001a\u00020\u00072\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÖ\u0001J\n\u0010\u0001\u001a\u00020\fHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b7\u00102R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b8\u00102R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b9\u00102R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b<\u0010;R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b=\u0010;R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b>\u0010;R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b?\u00102R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b@\u00102R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\bA\u00102R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u00100R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bC\u0010;R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b\u0016\u00102R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b\u0017\u00102R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\bD\u00102R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\bE\u00102R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\bF\u00102R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bG\u0010;R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\bH\u00102R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bI\u0010;R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010;R\u0019\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u00100R\u0013\u0010 \u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bL\u0010;R\u0015\u0010!\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\bM\u00102R\u0013\u0010\"\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bN\u0010;R\u0013\u0010#\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bO\u0010;R\u0015\u0010$\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\bP\u00102R\u0019\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u00100R\u0019\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u00100R\u0015\u0010(\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\bS\u00102R\u0013\u0010)\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bT\u0010;R\u0019\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u00100R\u0019\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u00100R\u0013\u0010-\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bW\u0010;¨\u0006\u0001"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Spec;", "", "attachedSkuIds", "", "", "clazzId", "courseClosed", "", "courseId", "courseType", "curriculumPackageId", "endDate", "", "feeDescClazz", "feeDescOrder", "feeDescRefund", "freeTrialLesson", "goodsCategoryId", "grade", "gradeList", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Grade;", "gradeName", "isCompetition", "isEntranceTest", "leftLesson", "lessonCount", "levelDegree", "levelDegreeDesc", "levelDegreeId", "levelDegreeName", "platformType", "specValueList", "startDate", "subPlatformType", "subject", "subjectFullName", "subjectId", "teacherIds", "teacherList", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Teacher;", "term", "timeDesc", "tutorIds", "tutorList", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Tutor;", "year", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getAttachedSkuIds", "()Ljava/util/List;", "getClazzId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCourseClosed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCourseId", "getCourseType", "getCurriculumPackageId", "getEndDate", "()Ljava/lang/String;", "getFeeDescClazz", "getFeeDescOrder", "getFeeDescRefund", "getFreeTrialLesson", "getGoodsCategoryId", "getGrade", "getGradeList", "getGradeName", "getLeftLesson", "getLessonCount", "getLevelDegree", "getLevelDegreeDesc", "getLevelDegreeId", "getLevelDegreeName", "getPlatformType", "getSpecValueList", "getStartDate", "getSubPlatformType", "getSubject", "getSubjectFullName", "getSubjectId", "getTeacherIds", "getTeacherList", "getTerm", "getTimeDesc", "getTutorIds", "getTutorList", "getYear", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Spec;", "equals", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeDataType2.kt */
public final class Spec {
    private final List<Integer> attachedSkuIds;
    private final Integer clazzId;
    private final Boolean courseClosed;
    private final Integer courseId;
    private final Integer courseType;
    private final Integer curriculumPackageId;
    private final String endDate;
    private final String feeDescClazz;
    private final String feeDescOrder;
    private final String feeDescRefund;
    private final Integer freeTrialLesson;
    private final Integer goodsCategoryId;
    private final Integer grade;
    private final List<Grade> gradeList;
    private final String gradeName;
    private final Integer isCompetition;
    private final Integer isEntranceTest;
    private final Integer leftLesson;
    private final Integer lessonCount;
    private final Integer levelDegree;
    private final String levelDegreeDesc;
    private final Integer levelDegreeId;
    private final String levelDegreeName;
    private final String platformType;
    private final List<Object> specValueList;
    private final String startDate;
    private final Integer subPlatformType;
    private final String subject;
    private final String subjectFullName;
    private final Integer subjectId;
    private final List<Integer> teacherIds;
    private final List<Teacher> teacherList;
    private final Integer term;
    private final String timeDesc;
    private final List<Integer> tutorIds;
    private final List<Tutor> tutorList;
    private final String year;

    public Spec() {
        this((List) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (List) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Integer) null, (String) null, (String) null, (Integer) null, (List) null, (List) null, (Integer) null, (String) null, (List) null, (List) null, (String) null, -1, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Spec copy$default(Spec spec, List list, Integer num, Boolean bool, Integer num2, Integer num3, Integer num4, String str, String str2, String str3, String str4, Integer num5, Integer num6, Integer num7, List list2, String str5, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, String str6, Integer num13, String str7, String str8, List list3, String str9, Integer num14, String str10, String str11, Integer num15, List list4, List list5, Integer num16, String str12, List list6, List list7, String str13, int i, int i2, Object obj) {
        Spec spec2 = spec;
        int i3 = i;
        return spec.copy((i3 & 1) != 0 ? spec2.attachedSkuIds : list, (i3 & 2) != 0 ? spec2.clazzId : num, (i3 & 4) != 0 ? spec2.courseClosed : bool, (i3 & 8) != 0 ? spec2.courseId : num2, (i3 & 16) != 0 ? spec2.courseType : num3, (i3 & 32) != 0 ? spec2.curriculumPackageId : num4, (i3 & 64) != 0 ? spec2.endDate : str, (i3 & 128) != 0 ? spec2.feeDescClazz : str2, (i3 & 256) != 0 ? spec2.feeDescOrder : str3, (i3 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? spec2.feeDescRefund : str4, (i3 & 1024) != 0 ? spec2.freeTrialLesson : num5, (i3 & 2048) != 0 ? spec2.goodsCategoryId : num6, (i3 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? spec2.grade : num7, (i3 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? spec2.gradeList : list2, (i3 & 16384) != 0 ? spec2.gradeName : str5, (i3 & 32768) != 0 ? spec2.isCompetition : num8, (i3 & 65536) != 0 ? spec2.isEntranceTest : num9, (i3 & 131072) != 0 ? spec2.leftLesson : num10, (i3 & 262144) != 0 ? spec2.lessonCount : num11, (i3 & 524288) != 0 ? spec2.levelDegree : num12, (i3 & 1048576) != 0 ? spec2.levelDegreeDesc : str6, (i3 & 2097152) != 0 ? spec2.levelDegreeId : num13, (i3 & 4194304) != 0 ? spec2.levelDegreeName : str7, (i3 & 8388608) != 0 ? spec2.platformType : str8, (i3 & 16777216) != 0 ? spec2.specValueList : list3, (i3 & 33554432) != 0 ? spec2.startDate : str9, (i3 & 67108864) != 0 ? spec2.subPlatformType : num14, (i3 & 134217728) != 0 ? spec2.subject : str10, (i3 & 268435456) != 0 ? spec2.subjectFullName : str11, (i3 & 536870912) != 0 ? spec2.subjectId : num15, (i3 & 1073741824) != 0 ? spec2.teacherIds : list4, (i3 & IntCompanionObject.MIN_VALUE) != 0 ? spec2.teacherList : list5, (i2 & 1) != 0 ? spec2.term : num16, (i2 & 2) != 0 ? spec2.timeDesc : str12, (i2 & 4) != 0 ? spec2.tutorIds : list6, (i2 & 8) != 0 ? spec2.tutorList : list7, (i2 & 16) != 0 ? spec2.year : str13);
    }

    public final List<Integer> component1() {
        return this.attachedSkuIds;
    }

    public final String component10() {
        return this.feeDescRefund;
    }

    public final Integer component11() {
        return this.freeTrialLesson;
    }

    public final Integer component12() {
        return this.goodsCategoryId;
    }

    public final Integer component13() {
        return this.grade;
    }

    public final List<Grade> component14() {
        return this.gradeList;
    }

    public final String component15() {
        return this.gradeName;
    }

    public final Integer component16() {
        return this.isCompetition;
    }

    public final Integer component17() {
        return this.isEntranceTest;
    }

    public final Integer component18() {
        return this.leftLesson;
    }

    public final Integer component19() {
        return this.lessonCount;
    }

    public final Integer component2() {
        return this.clazzId;
    }

    public final Integer component20() {
        return this.levelDegree;
    }

    public final String component21() {
        return this.levelDegreeDesc;
    }

    public final Integer component22() {
        return this.levelDegreeId;
    }

    public final String component23() {
        return this.levelDegreeName;
    }

    public final String component24() {
        return this.platformType;
    }

    public final List<Object> component25() {
        return this.specValueList;
    }

    public final String component26() {
        return this.startDate;
    }

    public final Integer component27() {
        return this.subPlatformType;
    }

    public final String component28() {
        return this.subject;
    }

    public final String component29() {
        return this.subjectFullName;
    }

    public final Boolean component3() {
        return this.courseClosed;
    }

    public final Integer component30() {
        return this.subjectId;
    }

    public final List<Integer> component31() {
        return this.teacherIds;
    }

    public final List<Teacher> component32() {
        return this.teacherList;
    }

    public final Integer component33() {
        return this.term;
    }

    public final String component34() {
        return this.timeDesc;
    }

    public final List<Integer> component35() {
        return this.tutorIds;
    }

    public final List<Tutor> component36() {
        return this.tutorList;
    }

    public final String component37() {
        return this.year;
    }

    public final Integer component4() {
        return this.courseId;
    }

    public final Integer component5() {
        return this.courseType;
    }

    public final Integer component6() {
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

    public final Spec copy(List<Integer> list, Integer num, Boolean bool, Integer num2, Integer num3, Integer num4, String str, String str2, String str3, String str4, Integer num5, Integer num6, Integer num7, List<Grade> list2, String str5, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, String str6, Integer num13, String str7, String str8, List<? extends Object> list3, String str9, Integer num14, String str10, String str11, Integer num15, List<Integer> list4, List<Teacher> list5, Integer num16, String str12, List<Integer> list6, List<Tutor> list7, String str13) {
        return new Spec(list, num, bool, num2, num3, num4, str, str2, str3, str4, num5, num6, num7, list2, str5, num8, num9, num10, num11, num12, str6, num13, str7, str8, list3, str9, num14, str10, str11, num15, list4, list5, num16, str12, list6, list7, str13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Spec)) {
            return false;
        }
        Spec spec = (Spec) obj;
        return Intrinsics.areEqual((Object) this.attachedSkuIds, (Object) spec.attachedSkuIds) && Intrinsics.areEqual((Object) this.clazzId, (Object) spec.clazzId) && Intrinsics.areEqual((Object) this.courseClosed, (Object) spec.courseClosed) && Intrinsics.areEqual((Object) this.courseId, (Object) spec.courseId) && Intrinsics.areEqual((Object) this.courseType, (Object) spec.courseType) && Intrinsics.areEqual((Object) this.curriculumPackageId, (Object) spec.curriculumPackageId) && Intrinsics.areEqual((Object) this.endDate, (Object) spec.endDate) && Intrinsics.areEqual((Object) this.feeDescClazz, (Object) spec.feeDescClazz) && Intrinsics.areEqual((Object) this.feeDescOrder, (Object) spec.feeDescOrder) && Intrinsics.areEqual((Object) this.feeDescRefund, (Object) spec.feeDescRefund) && Intrinsics.areEqual((Object) this.freeTrialLesson, (Object) spec.freeTrialLesson) && Intrinsics.areEqual((Object) this.goodsCategoryId, (Object) spec.goodsCategoryId) && Intrinsics.areEqual((Object) this.grade, (Object) spec.grade) && Intrinsics.areEqual((Object) this.gradeList, (Object) spec.gradeList) && Intrinsics.areEqual((Object) this.gradeName, (Object) spec.gradeName) && Intrinsics.areEqual((Object) this.isCompetition, (Object) spec.isCompetition) && Intrinsics.areEqual((Object) this.isEntranceTest, (Object) spec.isEntranceTest) && Intrinsics.areEqual((Object) this.leftLesson, (Object) spec.leftLesson) && Intrinsics.areEqual((Object) this.lessonCount, (Object) spec.lessonCount) && Intrinsics.areEqual((Object) this.levelDegree, (Object) spec.levelDegree) && Intrinsics.areEqual((Object) this.levelDegreeDesc, (Object) spec.levelDegreeDesc) && Intrinsics.areEqual((Object) this.levelDegreeId, (Object) spec.levelDegreeId) && Intrinsics.areEqual((Object) this.levelDegreeName, (Object) spec.levelDegreeName) && Intrinsics.areEqual((Object) this.platformType, (Object) spec.platformType) && Intrinsics.areEqual((Object) this.specValueList, (Object) spec.specValueList) && Intrinsics.areEqual((Object) this.startDate, (Object) spec.startDate) && Intrinsics.areEqual((Object) this.subPlatformType, (Object) spec.subPlatformType) && Intrinsics.areEqual((Object) this.subject, (Object) spec.subject) && Intrinsics.areEqual((Object) this.subjectFullName, (Object) spec.subjectFullName) && Intrinsics.areEqual((Object) this.subjectId, (Object) spec.subjectId) && Intrinsics.areEqual((Object) this.teacherIds, (Object) spec.teacherIds) && Intrinsics.areEqual((Object) this.teacherList, (Object) spec.teacherList) && Intrinsics.areEqual((Object) this.term, (Object) spec.term) && Intrinsics.areEqual((Object) this.timeDesc, (Object) spec.timeDesc) && Intrinsics.areEqual((Object) this.tutorIds, (Object) spec.tutorIds) && Intrinsics.areEqual((Object) this.tutorList, (Object) spec.tutorList) && Intrinsics.areEqual((Object) this.year, (Object) spec.year);
    }

    public int hashCode() {
        List<Integer> list = this.attachedSkuIds;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.clazzId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.courseClosed;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num2 = this.courseId;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.courseType;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.curriculumPackageId;
        int hashCode6 = (hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str = this.endDate;
        int hashCode7 = (hashCode6 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.feeDescClazz;
        int hashCode8 = (hashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.feeDescOrder;
        int hashCode9 = (hashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.feeDescRefund;
        int hashCode10 = (hashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num5 = this.freeTrialLesson;
        int hashCode11 = (hashCode10 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.goodsCategoryId;
        int hashCode12 = (hashCode11 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.grade;
        int hashCode13 = (hashCode12 + (num7 == null ? 0 : num7.hashCode())) * 31;
        List<Grade> list2 = this.gradeList;
        int hashCode14 = (hashCode13 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str5 = this.gradeName;
        int hashCode15 = (hashCode14 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num8 = this.isCompetition;
        int hashCode16 = (hashCode15 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.isEntranceTest;
        int hashCode17 = (hashCode16 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.leftLesson;
        int hashCode18 = (hashCode17 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.lessonCount;
        int hashCode19 = (hashCode18 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.levelDegree;
        int hashCode20 = (hashCode19 + (num12 == null ? 0 : num12.hashCode())) * 31;
        String str6 = this.levelDegreeDesc;
        int hashCode21 = (hashCode20 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num13 = this.levelDegreeId;
        int hashCode22 = (hashCode21 + (num13 == null ? 0 : num13.hashCode())) * 31;
        String str7 = this.levelDegreeName;
        int hashCode23 = (hashCode22 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.platformType;
        int hashCode24 = (hashCode23 + (str8 == null ? 0 : str8.hashCode())) * 31;
        List<Object> list3 = this.specValueList;
        int hashCode25 = (hashCode24 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str9 = this.startDate;
        int hashCode26 = (hashCode25 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num14 = this.subPlatformType;
        int hashCode27 = (hashCode26 + (num14 == null ? 0 : num14.hashCode())) * 31;
        String str10 = this.subject;
        int hashCode28 = (hashCode27 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.subjectFullName;
        int hashCode29 = (hashCode28 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Integer num15 = this.subjectId;
        int hashCode30 = (hashCode29 + (num15 == null ? 0 : num15.hashCode())) * 31;
        List<Integer> list4 = this.teacherIds;
        int hashCode31 = (hashCode30 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<Teacher> list5 = this.teacherList;
        int hashCode32 = (hashCode31 + (list5 == null ? 0 : list5.hashCode())) * 31;
        Integer num16 = this.term;
        int hashCode33 = (hashCode32 + (num16 == null ? 0 : num16.hashCode())) * 31;
        String str12 = this.timeDesc;
        int hashCode34 = (hashCode33 + (str12 == null ? 0 : str12.hashCode())) * 31;
        List<Integer> list6 = this.tutorIds;
        int hashCode35 = (hashCode34 + (list6 == null ? 0 : list6.hashCode())) * 31;
        List<Tutor> list7 = this.tutorList;
        int hashCode36 = (hashCode35 + (list7 == null ? 0 : list7.hashCode())) * 31;
        String str13 = this.year;
        if (str13 != null) {
            i = str13.hashCode();
        }
        return hashCode36 + i;
    }

    public String toString() {
        return "Spec(attachedSkuIds=" + this.attachedSkuIds + ", clazzId=" + this.clazzId + ", courseClosed=" + this.courseClosed + ", courseId=" + this.courseId + ", courseType=" + this.courseType + ", curriculumPackageId=" + this.curriculumPackageId + ", endDate=" + this.endDate + ", feeDescClazz=" + this.feeDescClazz + ", feeDescOrder=" + this.feeDescOrder + ", feeDescRefund=" + this.feeDescRefund + ", freeTrialLesson=" + this.freeTrialLesson + ", goodsCategoryId=" + this.goodsCategoryId + ", grade=" + this.grade + ", gradeList=" + this.gradeList + ", gradeName=" + this.gradeName + ", isCompetition=" + this.isCompetition + ", isEntranceTest=" + this.isEntranceTest + ", leftLesson=" + this.leftLesson + ", lessonCount=" + this.lessonCount + ", levelDegree=" + this.levelDegree + ", levelDegreeDesc=" + this.levelDegreeDesc + ", levelDegreeId=" + this.levelDegreeId + ", levelDegreeName=" + this.levelDegreeName + ", platformType=" + this.platformType + ", specValueList=" + this.specValueList + ", startDate=" + this.startDate + ", subPlatformType=" + this.subPlatformType + ", subject=" + this.subject + ", subjectFullName=" + this.subjectFullName + ", subjectId=" + this.subjectId + ", teacherIds=" + this.teacherIds + ", teacherList=" + this.teacherList + ", term=" + this.term + ", timeDesc=" + this.timeDesc + ", tutorIds=" + this.tutorIds + ", tutorList=" + this.tutorList + ", year=" + this.year + ')';
    }

    public Spec(List<Integer> list, Integer num, Boolean bool, Integer num2, Integer num3, Integer num4, String str, String str2, String str3, String str4, Integer num5, Integer num6, Integer num7, List<Grade> list2, String str5, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, String str6, Integer num13, String str7, String str8, List<? extends Object> list3, String str9, Integer num14, String str10, String str11, Integer num15, List<Integer> list4, List<Teacher> list5, Integer num16, String str12, List<Integer> list6, List<Tutor> list7, String str13) {
        this.attachedSkuIds = list;
        this.clazzId = num;
        this.courseClosed = bool;
        this.courseId = num2;
        this.courseType = num3;
        this.curriculumPackageId = num4;
        this.endDate = str;
        this.feeDescClazz = str2;
        this.feeDescOrder = str3;
        this.feeDescRefund = str4;
        this.freeTrialLesson = num5;
        this.goodsCategoryId = num6;
        this.grade = num7;
        this.gradeList = list2;
        this.gradeName = str5;
        this.isCompetition = num8;
        this.isEntranceTest = num9;
        this.leftLesson = num10;
        this.lessonCount = num11;
        this.levelDegree = num12;
        this.levelDegreeDesc = str6;
        this.levelDegreeId = num13;
        this.levelDegreeName = str7;
        this.platformType = str8;
        this.specValueList = list3;
        this.startDate = str9;
        this.subPlatformType = num14;
        this.subject = str10;
        this.subjectFullName = str11;
        this.subjectId = num15;
        this.teacherIds = list4;
        this.teacherList = list5;
        this.term = num16;
        this.timeDesc = str12;
        this.tutorIds = list6;
        this.tutorList = list7;
        this.year = str13;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Spec(java.util.List r38, java.lang.Integer r39, java.lang.Boolean r40, java.lang.Integer r41, java.lang.Integer r42, java.lang.Integer r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.Integer r48, java.lang.Integer r49, java.lang.Integer r50, java.util.List r51, java.lang.String r52, java.lang.Integer r53, java.lang.Integer r54, java.lang.Integer r55, java.lang.Integer r56, java.lang.Integer r57, java.lang.String r58, java.lang.Integer r59, java.lang.String r60, java.lang.String r61, java.util.List r62, java.lang.String r63, java.lang.Integer r64, java.lang.String r65, java.lang.String r66, java.lang.Integer r67, java.util.List r68, java.util.List r69, java.lang.Integer r70, java.lang.String r71, java.util.List r72, java.util.List r73, java.lang.String r74, int r75, int r76, kotlin.jvm.internal.DefaultConstructorMarker r77) {
        /*
            r37 = this;
            r0 = r75
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000b
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x000d
        L_0x000b:
            r1 = r38
        L_0x000d:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0017
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            goto L_0x0019
        L_0x0017:
            r2 = r39
        L_0x0019:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0022
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            goto L_0x0024
        L_0x0022:
            r4 = r40
        L_0x0024:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x002d
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            goto L_0x002f
        L_0x002d:
            r5 = r41
        L_0x002f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0038
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            goto L_0x003a
        L_0x0038:
            r6 = r42
        L_0x003a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0043
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            goto L_0x0045
        L_0x0043:
            r7 = r43
        L_0x0045:
            r8 = r0 & 64
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x004d
            r8 = r9
            goto L_0x004f
        L_0x004d:
            r8 = r44
        L_0x004f:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0055
            r10 = r9
            goto L_0x0057
        L_0x0055:
            r10 = r45
        L_0x0057:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x005d
            r11 = r9
            goto L_0x005f
        L_0x005d:
            r11 = r46
        L_0x005f:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0065
            r12 = r9
            goto L_0x0067
        L_0x0065:
            r12 = r47
        L_0x0067:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0070
            java.lang.Integer r13 = java.lang.Integer.valueOf(r3)
            goto L_0x0072
        L_0x0070:
            r13 = r48
        L_0x0072:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x007b
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)
            goto L_0x007d
        L_0x007b:
            r14 = r49
        L_0x007d:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0086
            java.lang.Integer r15 = java.lang.Integer.valueOf(r3)
            goto L_0x0088
        L_0x0086:
            r15 = r50
        L_0x0088:
            r3 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x0091
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0093
        L_0x0091:
            r3 = r51
        L_0x0093:
            r39 = r9
            r9 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x009c
            r9 = r39
            goto L_0x009e
        L_0x009c:
            r9 = r52
        L_0x009e:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00ac
            r16 = 0
            java.lang.Integer r17 = java.lang.Integer.valueOf(r16)
            goto L_0x00b0
        L_0x00ac:
            r16 = 0
            r17 = r53
        L_0x00b0:
            r18 = 65536(0x10000, float:9.18355E-41)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00bb
            java.lang.Integer r18 = java.lang.Integer.valueOf(r16)
            goto L_0x00bd
        L_0x00bb:
            r18 = r54
        L_0x00bd:
            r19 = 131072(0x20000, float:1.83671E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00c8
            java.lang.Integer r19 = java.lang.Integer.valueOf(r16)
            goto L_0x00ca
        L_0x00c8:
            r19 = r55
        L_0x00ca:
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00d5
            java.lang.Integer r20 = java.lang.Integer.valueOf(r16)
            goto L_0x00d7
        L_0x00d5:
            r20 = r56
        L_0x00d7:
            r21 = 524288(0x80000, float:7.34684E-40)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00e2
            java.lang.Integer r21 = java.lang.Integer.valueOf(r16)
            goto L_0x00e4
        L_0x00e2:
            r21 = r57
        L_0x00e4:
            r22 = 1048576(0x100000, float:1.469368E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00ed
            r22 = r39
            goto L_0x00ef
        L_0x00ed:
            r22 = r58
        L_0x00ef:
            r23 = 2097152(0x200000, float:2.938736E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00fa
            java.lang.Integer r23 = java.lang.Integer.valueOf(r16)
            goto L_0x00fc
        L_0x00fa:
            r23 = r59
        L_0x00fc:
            r16 = 4194304(0x400000, float:5.877472E-39)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0105
            r16 = r39
            goto L_0x0107
        L_0x0105:
            r16 = r60
        L_0x0107:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x0110
            r24 = r39
            goto L_0x0112
        L_0x0110:
            r24 = r61
        L_0x0112:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x011d
            java.util.List r25 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x011f
        L_0x011d:
            r25 = r62
        L_0x011f:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x0128
            r26 = r39
            goto L_0x012a
        L_0x0128:
            r26 = r63
        L_0x012a:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x0137
            r27 = 0
            java.lang.Integer r28 = java.lang.Integer.valueOf(r27)
            goto L_0x0139
        L_0x0137:
            r28 = r64
        L_0x0139:
            r27 = 134217728(0x8000000, float:3.85186E-34)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x0142
            r27 = r39
            goto L_0x0144
        L_0x0142:
            r27 = r65
        L_0x0144:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x014d
            r29 = r39
            goto L_0x014f
        L_0x014d:
            r29 = r66
        L_0x014f:
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x015c
            r30 = 0
            java.lang.Integer r31 = java.lang.Integer.valueOf(r30)
            goto L_0x015e
        L_0x015c:
            r31 = r67
        L_0x015e:
            r30 = 1073741824(0x40000000, float:2.0)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x0169
            java.util.List r30 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x016b
        L_0x0169:
            r30 = r68
        L_0x016b:
            r32 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r32
            if (r0 == 0) goto L_0x0176
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0178
        L_0x0176:
            r0 = r69
        L_0x0178:
            r32 = r76 & 1
            if (r32 == 0) goto L_0x0183
            r32 = 0
            java.lang.Integer r32 = java.lang.Integer.valueOf(r32)
            goto L_0x0185
        L_0x0183:
            r32 = r70
        L_0x0185:
            r33 = r76 & 2
            if (r33 == 0) goto L_0x018c
            r33 = r39
            goto L_0x018e
        L_0x018c:
            r33 = r71
        L_0x018e:
            r34 = r76 & 4
            if (r34 == 0) goto L_0x0197
            java.util.List r34 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0199
        L_0x0197:
            r34 = r72
        L_0x0199:
            r35 = r76 & 8
            if (r35 == 0) goto L_0x01a2
            java.util.List r35 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x01a4
        L_0x01a2:
            r35 = r73
        L_0x01a4:
            r36 = r76 & 16
            if (r36 == 0) goto L_0x01ab
            r36 = r39
            goto L_0x01ad
        L_0x01ab:
            r36 = r74
        L_0x01ad:
            r38 = r37
            r39 = r1
            r40 = r2
            r41 = r4
            r42 = r5
            r43 = r6
            r44 = r7
            r45 = r8
            r46 = r10
            r47 = r11
            r48 = r12
            r49 = r13
            r50 = r14
            r51 = r15
            r52 = r3
            r53 = r9
            r54 = r17
            r55 = r18
            r56 = r19
            r57 = r20
            r58 = r21
            r59 = r22
            r60 = r23
            r61 = r16
            r62 = r24
            r63 = r25
            r64 = r26
            r65 = r28
            r66 = r27
            r67 = r29
            r68 = r31
            r69 = r30
            r70 = r0
            r71 = r32
            r72 = r33
            r73 = r34
            r74 = r35
            r75 = r36
            r38.<init>(r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.bean.Spec.<init>(java.util.List, java.lang.Integer, java.lang.Boolean, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.util.List, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, java.util.List, java.util.List, java.lang.Integer, java.lang.String, java.util.List, java.util.List, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<Integer> getAttachedSkuIds() {
        return this.attachedSkuIds;
    }

    public final Integer getClazzId() {
        return this.clazzId;
    }

    public final Boolean getCourseClosed() {
        return this.courseClosed;
    }

    public final Integer getCourseId() {
        return this.courseId;
    }

    public final Integer getCourseType() {
        return this.courseType;
    }

    public final Integer getCurriculumPackageId() {
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

    public final Integer getFreeTrialLesson() {
        return this.freeTrialLesson;
    }

    public final Integer getGoodsCategoryId() {
        return this.goodsCategoryId;
    }

    public final Integer getGrade() {
        return this.grade;
    }

    public final List<Grade> getGradeList() {
        return this.gradeList;
    }

    public final String getGradeName() {
        return this.gradeName;
    }

    public final Integer isCompetition() {
        return this.isCompetition;
    }

    public final Integer isEntranceTest() {
        return this.isEntranceTest;
    }

    public final Integer getLeftLesson() {
        return this.leftLesson;
    }

    public final Integer getLessonCount() {
        return this.lessonCount;
    }

    public final Integer getLevelDegree() {
        return this.levelDegree;
    }

    public final String getLevelDegreeDesc() {
        return this.levelDegreeDesc;
    }

    public final Integer getLevelDegreeId() {
        return this.levelDegreeId;
    }

    public final String getLevelDegreeName() {
        return this.levelDegreeName;
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

    public final Integer getSubPlatformType() {
        return this.subPlatformType;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getSubjectFullName() {
        return this.subjectFullName;
    }

    public final Integer getSubjectId() {
        return this.subjectId;
    }

    public final List<Integer> getTeacherIds() {
        return this.teacherIds;
    }

    public final List<Teacher> getTeacherList() {
        return this.teacherList;
    }

    public final Integer getTerm() {
        return this.term;
    }

    public final String getTimeDesc() {
        return this.timeDesc;
    }

    public final List<Integer> getTutorIds() {
        return this.tutorIds;
    }

    public final List<Tutor> getTutorList() {
        return this.tutorList;
    }

    public final String getYear() {
        return this.year;
    }
}
