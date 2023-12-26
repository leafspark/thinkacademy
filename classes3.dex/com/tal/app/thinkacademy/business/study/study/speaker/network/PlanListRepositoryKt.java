package com.tal.app.thinkacademy.business.study.study.speaker.network;

import com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi;
import com.tal.app.thinkacademy.business.study.study.entity.request.EnterRequest;
import com.tal.app.thinkacademy.business.study.study.entity.request.InitModuleRequest;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000â\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001d\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a/\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0002\u001a\u0004\u0018\u00010\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010 \u001a\u001b\u0010!\u001a\u00020\u001d2\b\u0010\u0002\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010$\u001a'\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u0002\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010'\u001a\u001d\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u0002\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010*\u001a\u0004\u0018\u00010+2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010$\u001a\u001b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/H@ø\u0001\u0000¢\u0006\u0002\u00100\u001a\u0013\u00101\u001a\u0004\u0018\u000102H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a#\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u000207H@ø\u0001\u0000¢\u0006\u0002\u00108\u001a'\u00109\u001a\u0004\u0018\u00010:2\b\u0010\u0004\u001a\u0004\u0018\u00010\r2\b\u0010;\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010'\u001a\u0013\u0010<\u001a\u0004\u0018\u00010=H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001d\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a'\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010\r2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010D\u001aE\u0010E\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010\r2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010F\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010G\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010H\u001a;\u0010I\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010\r2\b\u0010G\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010L\u001a\u00020\u00032\b\b\u0002\u0010F\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010M\u001a'\u0010N\u001a\u0004\u0018\u00010O2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a'\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u001b\u0010R\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010S\u001a\u0004\u0018\u00010T2\b\u0010U\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001b\u0010V\u001a\u0004\u0018\u00010?2\u0006\u0010V\u001a\u00020WH@ø\u0001\u0000¢\u0006\u0002\u0010X\u001a\u001b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010[\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\\"}, d2 = {"checkStudentInClass", "Lcom/tal/app/thinkacademy/business/study/study/entity/CheckStudentInClass;", "planId", "", "classId", "(Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSchoolsList", "Lcom/tal/app/thinkacademy/business/study/study/entity/AllSchoolsList;", "request", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/AllSchoolsRequest;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/AllSchoolsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassCalendar", "Lcom/tal/app/thinkacademy/business/study/study/entity/ClassCalendarEntity;", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassList", "Lcom/tal/app/thinkacademy/business/study/study/entity/ClassListEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentSchool", "Lcom/tal/app/thinkacademy/business/study/study/entity/CurrentSchool;", "getHomeWorkJumpUrl", "jumpParamsEntity", "Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNetStatus", "Lokhttp3/ResponseBody;", "getNickname", "Lcom/tal/app/thinkacademy/business/study/study/entity/Nickname;", "getPlaybackEnter", "", "courseId", "bizId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlaybackInitModule", "getPlaybackOfflineData", "Lcom/tal/app/thinkacademy/business/study/study/entity/PlaybackOfflineBean;", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrepareClass", "Lcom/tal/app/thinkacademy/business/study/study/entity/ReadyClassBean;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrepareClassBack", "Lcom/tal/app/thinkacademy/business/study/study/entity/ReadyClassBackBean;", "getPrepareClassDate", "Lcom/tal/app/thinkacademy/business/study/study/entity/PrepareClassBean;", "getRecordedCalendarData", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCalendarListEntity;", "studentCourseId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecordedClass", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedClassList;", "getSwitchOptions", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsList;", "category", "haveCourse", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTeachMethod", "Lcom/tal/app/thinkacademy/business/study/study/entity/TeachMethodEntity;", "orderNum", "initEntryInfoData", "Lcom/tal/app/thinkacademy/common/entity/InitEntryInfoBean;", "modifyNickname", "", "nickname", "paperDetail", "Lcom/tal/app/thinkacademy/business/study/study/entity/PaperDetailEntity;", "paperId", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paperOverview", "homeworkType", "platform", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordedPaperOverview", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedPaperDetailEntity;", "entityId", "bindType", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestCheckInData", "Lcom/tal/app/thinkacademy/business/study/study/entity/CheckInData;", "requestCheckInStatus", "Lcom/tal/app/thinkacademy/business/study/study/entity/CheckInStatus;", "setNickname", "switchLogin", "Lcom/tal/app/thinkacademy/common/user/UserBean;", "targetUid", "syncHomeWork", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/SyncHomeWork;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/SyncHomeWork;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timezoneCheck", "Lcom/tal/app/thinkacademy/common/entity/TimeZoneCheckEntity;", "timeZone", "bus_study_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlanListRepository.kt */
public final class PlanListRepositoryKt {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0071 A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:19:0x006e, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getClassCalendar(java.lang.String r7, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.ClassCalendarEntity> r8) {
        /*
            boolean r0 = r8 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getClassCalendar$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getClassCalendar$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getClassCalendar$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getClassCalendar$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getClassCalendar$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0071
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r7 = (com.tal.app.thinkacademy.common.network.NetData) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0063
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r8)
            com.tal.app.thinkacademy.common.network.NetData r8 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.business.study.study.entity.request.ClassCalendarRequest r5 = new com.tal.app.thinkacademy.business.study.study.entity.request.ClassCalendarRequest
            r5.<init>(r7)
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r7 = r2.getClassCalendar(r5, r0)
            if (r7 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x0063:
            com.tal.app.thinkacademy.lib.restful.HiResponse r8 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r8
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r7.transform(r8, r0)
            if (r8 != r1) goto L_0x0071
            return r1
        L_0x0071:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.getClassCalendar(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0071 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x006e, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getTeachMethod(java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.TeachMethodEntity> r9) {
        /*
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getTeachMethod$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getTeachMethod$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getTeachMethod$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getTeachMethod$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getTeachMethod$1
            r0.<init>(r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0071
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r7 = (com.tal.app.thinkacademy.common.network.NetData) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0063
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.business.study.study.entity.request.TeachMethodRequest r5 = new com.tal.app.thinkacademy.business.study.study.entity.request.TeachMethodRequest
            r5.<init>(r7, r8)
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r7 = r2.requestTeachMethod(r5, r0)
            if (r7 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r6 = r9
            r9 = r7
            r7 = r6
        L_0x0063:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r8 = 0
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = r7.transform(r9, r0)
            if (r9 != r1) goto L_0x0071
            return r1
        L_0x0071:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.getTeachMethod(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069 A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x0066, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getClassList(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.ClassListEntity> r7) {
        /*
            boolean r0 = r7 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getClassList$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getClassList$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getClassList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getClassList$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getClassList$1
            r0.<init>(r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0069
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0036:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005c
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r7 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r7 = r7.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r6 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.network.Api.create(r7, r6)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r7 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r7
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r7 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.DefaultImpls.getClassListByStuId$default(r7, r4, r0, r5, r4)
            if (r7 != r1) goto L_0x005c
            return r1
        L_0x005c:
            com.tal.app.thinkacademy.lib.restful.HiResponse r7 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r7
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r2.transform(r7, r0)
            if (r7 != r1) goto L_0x0069
            return r1
        L_0x0069:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.getClassList(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076 A[PHI: r11 
      PHI: (r11v2 java.lang.Object) = (r11v5 java.lang.Object), (r11v1 java.lang.Object) binds: [B:19:0x0073, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getSwitchOptions(java.lang.String r9, boolean r10, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList> r11) {
        /*
            boolean r0 = r11 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getSwitchOptions$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getSwitchOptions$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getSwitchOptions$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getSwitchOptions$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getSwitchOptions$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0076
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            java.lang.Object r9 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r9 = (com.tal.app.thinkacademy.common.network.NetData) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0069
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r11)
            com.tal.app.thinkacademy.common.network.NetData r11 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r6 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r6)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.business.study.study.entity.request.GoGlobalRequest r6 = new com.tal.app.thinkacademy.business.study.study.entity.request.GoGlobalRequest
            com.tal.app.thinkacademy.business.study.study.entity.request.SwitchOptionsRequest r7 = new com.tal.app.thinkacademy.business.study.study.entity.request.SwitchOptionsRequest
            r7.<init>(r9, r10)
            r6.<init>(r4, r7, r5, r4)
            r0.L$0 = r11
            r0.label = r5
            java.lang.Object r9 = r2.getSwitchOptions(r6, r0)
            if (r9 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r8 = r11
            r11 = r9
            r9 = r8
        L_0x0069:
            com.tal.app.thinkacademy.lib.restful.HiResponse r11 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r11
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r11 = r9.transform(r11, r0)
            if (r11 != r1) goto L_0x0076
            return r1
        L_0x0076:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.getSwitchOptions(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0073, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object modifyNickname(java.lang.String r8, kotlin.coroutines.Continuation<java.lang.Object> r9) {
        /*
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$modifyNickname$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$modifyNickname$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$modifyNickname$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$modifyNickname$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$modifyNickname$1
            r0.<init>(r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0076
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0068
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.business.study.study.entity.request.ModifyNickNameRequest r5 = new com.tal.app.thinkacademy.business.study.study.entity.request.ModifyNickNameRequest
            com.tal.app.thinkacademy.business.study.study.entity.request.Body r6 = new com.tal.app.thinkacademy.business.study.study.entity.request.Body
            r6.<init>(r8)
            r5.<init>(r6)
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.modifyNickname(r5, r0)
            if (r8 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x0068:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x0076
            return r1
        L_0x0076:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.modifyNickname(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0073, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object setNickname(java.lang.String r8, kotlin.coroutines.Continuation<java.lang.Object> r9) {
        /*
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$setNickname$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$setNickname$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$setNickname$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$setNickname$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$setNickname$1
            r0.<init>(r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0076
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0068
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.business.study.study.entity.request.ModifyNickNameRequest r5 = new com.tal.app.thinkacademy.business.study.study.entity.request.ModifyNickNameRequest
            com.tal.app.thinkacademy.business.study.study.entity.request.Body r6 = new com.tal.app.thinkacademy.business.study.study.entity.request.Body
            r6.<init>(r8)
            r5.<init>(r6)
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.modifyNickname(r5, r0)
            if (r8 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x0068:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x0076
            return r1
        L_0x0076:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.setNickname(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[PHI: r6 
      PHI: (r6v2 java.lang.Object) = (r6v5 java.lang.Object), (r6v1 java.lang.Object) binds: [B:18:0x0068, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getNickname(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.Nickname> r6) {
        /*
            boolean r0 = r6 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getNickname$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getNickname$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getNickname$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getNickname$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getNickname$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x006b
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005d
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r6)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r6 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r6 = r6.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r6 = com.tal.app.thinkacademy.lib.network.Api.create(r6, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r6 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r6
            r0.L$0 = r2
            r0.label = r4
            java.lang.String r4 = "{}"
            java.lang.Object r6 = r6.getNickname(r4, r0)
            if (r6 != r1) goto L_0x005d
            return r1
        L_0x005d:
            com.tal.app.thinkacademy.lib.restful.HiResponse r6 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r6
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r2.transform(r6, r0)
            if (r6 != r1) goto L_0x006b
            return r1
        L_0x006b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.getNickname(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object getNetStatus(Continuation<? super ResponseBody> continuation) {
        return ((StudyCenterApi) Api.create(ServerConfigUrl.INSTANCE.getBASE_URL(), StudyCenterApi.class)).getNetStatus(continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e A[PHI: r11 
      PHI: (r11v2 java.lang.Object) = (r11v5 java.lang.Object), (r11v1 java.lang.Object) binds: [B:23:0x007b, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getPrepareClassDate(java.lang.Integer r10, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.PrepareClassBean> r11) {
        /*
            boolean r0 = r11 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClassDate$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClassDate$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClassDate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClassDate$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClassDate$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x007e
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0036:
            java.lang.Object r10 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r10 = (com.tal.app.thinkacademy.common.network.NetData) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0071
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r11)
            com.tal.app.thinkacademy.common.network.NetData r11 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r2 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r6 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r6)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.common.entity.BaseRequestBean r6 = new com.tal.app.thinkacademy.common.entity.BaseRequestBean
            if (r10 != 0) goto L_0x0057
            r10 = r3
            goto L_0x0060
        L_0x0057:
            int r10 = r10.intValue()
            long r7 = (long) r10
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
        L_0x0060:
            r6.<init>(r10)
            r0.L$0 = r11
            r0.label = r5
            java.lang.Object r10 = r2.getPrepareClassDate(r6, r0)
            if (r10 != r1) goto L_0x006e
            return r1
        L_0x006e:
            r9 = r11
            r11 = r10
            r10 = r9
        L_0x0071:
            com.tal.app.thinkacademy.lib.restful.HiResponse r11 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r11
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r11 = r10.transform(r11, r0)
            if (r11 != r1) goto L_0x007e
            return r1
        L_0x007e:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.getPrepareClassDate(java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082 A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:19:0x007f, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getPrepareClass(java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.ReadyClassBean> r10) {
        /*
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClass$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClass$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClass$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClass$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClass$1
            r0.<init>(r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0082
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0074
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.network.NetData r10 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r2 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.common.entity.ReadyRequestBean r5 = new com.tal.app.thinkacademy.common.entity.ReadyRequestBean
            r6 = 0
            int r8 = com.tal.app.thinkacademy.lib.util.ParseUtils.tryParseInt(r8, r6)
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            int r9 = com.tal.app.thinkacademy.lib.util.ParseUtils.tryParseInt(r9, r6)
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            r5.<init>(r8, r9)
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r8 = r2.getPrepareClass(r5, r0)
            if (r8 != r1) goto L_0x0071
            return r1
        L_0x0071:
            r7 = r10
            r10 = r8
            r8 = r7
        L_0x0074:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r9 = 0
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r10 = r8.transform(r10, r0)
            if (r10 != r1) goto L_0x0082
            return r1
        L_0x0082:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.getPrepareClass(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:19:0x0078, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getPrepareClassBack(java.lang.String r9, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.ReadyClassBackBean> r10) {
        /*
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClassBack$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClassBack$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClassBack$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClassBack$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPrepareClassBack$1
            r0.<init>(r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x007b
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0035:
            java.lang.Object r9 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r9 = (com.tal.app.thinkacademy.common.network.NetData) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006d
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.network.NetData r10 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r2 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.common.entity.BaseRequestBean r5 = new com.tal.app.thinkacademy.common.entity.BaseRequestBean
            r6 = 0
            long r6 = com.tal.app.thinkacademy.lib.util.ParseUtils.tryParseLong(r9, r6)
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            r5.<init>(r9)
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r9 = r2.getPlaybackInfo(r5, r0)
            if (r9 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r8 = r10
            r10 = r9
            r9 = r8
        L_0x006d:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r10 = r9.transform(r10, r0)
            if (r10 != r1) goto L_0x007b
            return r1
        L_0x007b:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.getPrepareClassBack(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object getPlaybackEnter(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        Object requestPlaybackEnter = ((StudyCenterApi) Api.create(StudyCenterApi.class)).requestPlaybackEnter(Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/playback/student/initEntry"), false, new EnterRequest(Boxing.boxInt(ParseUtils.tryParseInt(str3, 0)), Boxing.boxInt(ParseUtils.tryParseInt(str, 0)), Boxing.boxInt(ParseUtils.tryParseInt(str2, 0)), Boxing.boxInt(0), Boxing.boxInt(0)), continuation);
        return requestPlaybackEnter == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? requestPlaybackEnter : Unit.INSTANCE;
    }

    public static final Object getPlaybackInitModule(String str, Continuation<? super Unit> continuation) {
        Object requestInitModule = ((StudyCenterApi) Api.create(StudyCenterApi.class)).requestInitModule(Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/classroom/student/initModule"), false, new InitModuleRequest(Boxing.boxInt(ParseUtils.tryParseInt(str, 0)), Boxing.boxInt(1), Boxing.boxInt(0)), continuation);
        return requestInitModule == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? requestInitModule : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0077 A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:19:0x0074, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestCheckInStatus(java.lang.Integer r8, java.lang.Integer r9, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.CheckInStatus> r10) {
        /*
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$requestCheckInStatus$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$requestCheckInStatus$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$requestCheckInStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$requestCheckInStatus$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$requestCheckInStatus$1
            r0.<init>(r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0077
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0069
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.network.NetData r10 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r2 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.common.imconfig.ImConfig r5 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r5 = r5.getOverseaApi()
            java.lang.String r6 = "/classroom-hub/sign/student/v2/status"
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r6)
            com.tal.app.thinkacademy.business.study.study.entity.request.CheckInRequest r6 = new com.tal.app.thinkacademy.business.study.study.entity.request.CheckInRequest
            r6.<init>(r8, r9)
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r8 = r2.requestCheckInStatus(r5, r6, r0)
            if (r8 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r7 = r10
            r10 = r8
            r8 = r7
        L_0x0069:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r9 = 0
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r10 = r8.transform(r10, r0)
            if (r10 != r1) goto L_0x0077
            return r1
        L_0x0077:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.requestCheckInStatus(java.lang.Integer, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0077 A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:19:0x0074, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestCheckInData(java.lang.Integer r8, java.lang.Integer r9, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.CheckInData> r10) {
        /*
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$requestCheckInData$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$requestCheckInData$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$requestCheckInData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$requestCheckInData$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$requestCheckInData$1
            r0.<init>(r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0077
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0069
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.network.NetData r10 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r2 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.common.imconfig.ImConfig r5 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r5 = r5.getOverseaApi()
            java.lang.String r6 = "/classroom-hub/sign/student/v2/arrive"
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r6)
            com.tal.app.thinkacademy.business.study.study.entity.request.CheckInRequest r6 = new com.tal.app.thinkacademy.business.study.study.entity.request.CheckInRequest
            r6.<init>(r8, r9)
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r8 = r2.requestCheckInData(r5, r6, r0)
            if (r8 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r7 = r10
            r10 = r8
            r8 = r7
        L_0x0069:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r9 = 0
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r10 = r8.transform(r10, r0)
            if (r10 != r1) goto L_0x0077
            return r1
        L_0x0077:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.requestCheckInData(java.lang.Integer, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getHomeWorkJumpUrl(com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity r7, kotlin.coroutines.Continuation<? super java.lang.String> r8) {
        /*
            boolean r0 = r8 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getHomeWorkJumpUrl$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getHomeWorkJumpUrl$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getHomeWorkJumpUrl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getHomeWorkJumpUrl$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getHomeWorkJumpUrl$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r7 = (com.tal.app.thinkacademy.common.network.NetData) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r8)
            com.tal.app.thinkacademy.common.network.NetData r8 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r2 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r7 = r2.getHomeWorkJumpUrl(r7, r0)
            if (r7 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r8 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r8
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r7.transform(r8, r0)
            if (r8 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.getHomeWorkJumpUrl(com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object syncHomeWork(com.tal.app.thinkacademy.business.study.study.entity.request.SyncHomeWork r7, kotlin.coroutines.Continuation<java.lang.Object> r8) {
        /*
            boolean r0 = r8 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$syncHomeWork$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$syncHomeWork$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$syncHomeWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$syncHomeWork$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$syncHomeWork$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r7 = (com.tal.app.thinkacademy.common.network.NetData) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r8)
            com.tal.app.thinkacademy.common.network.NetData r8 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r2 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r7 = r2.syncHomeWork(r7, r0)
            if (r7 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r8 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r8
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r7.transform(r8, r0)
            if (r8 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.syncHomeWork(com.tal.app.thinkacademy.business.study.study.entity.request.SyncHomeWork, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0071 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x006e, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object paperDetail(java.lang.String r7, java.lang.Integer r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.PaperDetailEntity> r9) {
        /*
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$paperDetail$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$paperDetail$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$paperDetail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$paperDetail$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$paperDetail$1
            r0.<init>(r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0071
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r7 = (com.tal.app.thinkacademy.common.network.NetData) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0063
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r2 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.business.study.study.entity.request.PaperDetailRequest r5 = new com.tal.app.thinkacademy.business.study.study.entity.request.PaperDetailRequest
            r5.<init>(r7, r8)
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r7 = r2.getPaperDetail(r5, r0)
            if (r7 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r6 = r9
            r9 = r7
            r7 = r6
        L_0x0063:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r8 = 0
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = r7.transform(r9, r0)
            if (r9 != r1) goto L_0x0071
            return r1
        L_0x0071:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.paperDetail(java.lang.String, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078 A[PHI: r0 
      PHI: (r0v2 java.lang.Object) = (r0v5 java.lang.Object), (r0v1 java.lang.Object) binds: [B:18:0x0075, B:10:0x002b] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object paperOverview(java.lang.String r13, java.lang.Integer r14, java.lang.Integer r15, java.lang.Integer r16, java.lang.String r17, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.PaperDetailEntity> r18) {
        /*
            r0 = r18
            boolean r1 = r0 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$paperOverview$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$paperOverview$1 r1 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$paperOverview$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$paperOverview$1 r1 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$paperOverview$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L_0x003f
            if (r3 == r5) goto L_0x0037
            if (r3 != r4) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0078
        L_0x002f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0037:
            java.lang.Object r3 = r1.L$0
            com.tal.app.thinkacademy.common.network.NetData r3 = (com.tal.app.thinkacademy.common.network.NetData) r3
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x006a
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r0)
            com.tal.app.thinkacademy.common.network.NetData r3 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r0 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r0 = r0.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r6 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r0 = com.tal.app.thinkacademy.lib.network.Api.create(r0, r6)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r0 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r0
            com.tal.app.thinkacademy.business.study.study.entity.request.PaperOverviewRequest r12 = new com.tal.app.thinkacademy.business.study.study.entity.request.PaperOverviewRequest
            r6 = r12
            r7 = r13
            r8 = r14
            r9 = r15
            r10 = r16
            r11 = r17
            r6.<init>(r7, r8, r9, r10, r11)
            r1.L$0 = r3
            r1.label = r5
            java.lang.Object r0 = r0.getPaperOverview(r12, r1)
            if (r0 != r2) goto L_0x006a
            return r2
        L_0x006a:
            com.tal.app.thinkacademy.lib.restful.HiResponse r0 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r0
            r5 = 0
            r1.L$0 = r5
            r1.label = r4
            java.lang.Object r0 = r3.transform(r0, r1)
            if (r0 != r2) goto L_0x0078
            return r2
        L_0x0078:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.paperOverview(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075 A[PHI: r11 
      PHI: (r11v2 java.lang.Object) = (r11v5 java.lang.Object), (r11v1 java.lang.Object) binds: [B:19:0x0072, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object recordedPaperOverview(java.lang.String r7, java.lang.String r8, int r9, int r10, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.RecordedPaperDetailEntity> r11) {
        /*
            boolean r0 = r11 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$recordedPaperOverview$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$recordedPaperOverview$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$recordedPaperOverview$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$recordedPaperOverview$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$recordedPaperOverview$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0075
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r7 = (com.tal.app.thinkacademy.common.network.NetData) r7
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0067
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r11)
            com.tal.app.thinkacademy.common.network.NetData r11 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r2 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.business.study.study.entity.request.RecordedPaperOverviewRequest r5 = new com.tal.app.thinkacademy.business.study.study.entity.request.RecordedPaperOverviewRequest
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            r5.<init>(r7, r8, r9, r10)
            r0.L$0 = r11
            r0.label = r4
            java.lang.Object r7 = r2.getRecordedPaperOverview(r5, r0)
            if (r7 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r6 = r11
            r11 = r7
            r7 = r6
        L_0x0067:
            com.tal.app.thinkacademy.lib.restful.HiResponse r11 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r11
            r8 = 0
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r11 = r7.transform(r11, r0)
            if (r11 != r1) goto L_0x0075
            return r1
        L_0x0075:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.recordedPaperOverview(java.lang.String, java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object recordedPaperOverview$default(String str, String str2, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 1;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return recordedPaperOverview(str, str2, i, i2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0085 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0086 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:18:0x0083, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object switchLogin(java.lang.String r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.user.UserBean> r9) {
        /*
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$switchLogin$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$switchLogin$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$switchLogin$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$switchLogin$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$switchLogin$1
            r0.<init>(r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0086
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0078
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r9 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r5 = "school_code"
            java.lang.String r6 = ""
            java.lang.String r9 = r9.getString(r5, r6, r2)
            com.tal.app.thinkacademy.common.entity.SwitchData r2 = new com.tal.app.thinkacademy.common.entity.SwitchData
            r2.<init>(r8)
            com.tal.app.thinkacademy.common.network.NetData r8 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r5 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r5 = r5.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r6 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r5 = com.tal.app.thinkacademy.lib.network.Api.create(r5, r6)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r5 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r5
            com.tal.app.thinkacademy.common.entity.SwitchLogin r6 = new com.tal.app.thinkacademy.common.entity.SwitchLogin
            com.tal.app.thinkacademy.common.entity.Header r7 = new com.tal.app.thinkacademy.common.entity.Header
            r7.<init>(r9)
            r6.<init>(r7, r2)
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r9 = r5.switchLogin(r6, r0)
            if (r9 != r1) goto L_0x0078
            return r1
        L_0x0078:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x0086
            return r1
        L_0x0086:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.switchLogin(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[PHI: r6 
      PHI: (r6v2 java.lang.Object) = (r6v5 java.lang.Object), (r6v1 java.lang.Object) binds: [B:18:0x0068, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object initEntryInfoData(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.entity.InitEntryInfoBean> r6) {
        /*
            boolean r0 = r6 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$initEntryInfoData$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$initEntryInfoData$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$initEntryInfoData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$initEntryInfoData$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$initEntryInfoData$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x006b
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005d
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r6)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r6 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r6 = r6.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r6 = com.tal.app.thinkacademy.lib.network.Api.create(r6, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r6 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r6
            r0.L$0 = r2
            r0.label = r4
            java.lang.String r4 = "{}"
            java.lang.Object r6 = r6.initEntryInfoData(r4, r0)
            if (r6 != r1) goto L_0x005d
            return r1
        L_0x005d:
            com.tal.app.thinkacademy.lib.restful.HiResponse r6 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r6
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r2.transform(r6, r0)
            if (r6 != r1) goto L_0x006b
            return r1
        L_0x006b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.initEntryInfoData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0077 A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:19:0x0074, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object checkStudentInClass(java.lang.Integer r8, java.lang.Integer r9, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.CheckStudentInClass> r10) {
        /*
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$checkStudentInClass$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$checkStudentInClass$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$checkStudentInClass$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$checkStudentInClass$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$checkStudentInClass$1
            r0.<init>(r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0077
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0069
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.network.NetData r10 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r2 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.common.imconfig.ImConfig r5 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r5 = r5.getOverseaApi()
            java.lang.String r6 = "/api/hub/classroom/student/inClass"
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r6)
            com.tal.app.thinkacademy.business.study.study.entity.request.CheckInRequest r6 = new com.tal.app.thinkacademy.business.study.study.entity.request.CheckInRequest
            r6.<init>(r8, r9)
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r8 = r2.checkStudentClass(r5, r6, r0)
            if (r8 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r7 = r10
            r10 = r8
            r8 = r7
        L_0x0069:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r9 = 0
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r10 = r8.transform(r10, r0)
            if (r10 != r1) goto L_0x0077
            return r1
        L_0x0077:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.checkStudentInClass(java.lang.Integer, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getAllSchoolsList(com.tal.app.thinkacademy.business.study.study.entity.request.AllSchoolsRequest r7, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.AllSchoolsList> r8) {
        /*
            boolean r0 = r8 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getAllSchoolsList$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getAllSchoolsList$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getAllSchoolsList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getAllSchoolsList$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getAllSchoolsList$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r7 = (com.tal.app.thinkacademy.common.network.NetData) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r8)
            com.tal.app.thinkacademy.common.network.NetData r8 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r7 = r2.getAllSchoolsList(r7, r0)
            if (r7 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r8 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r8
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r7.transform(r8, r0)
            if (r8 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.getAllSchoolsList(com.tal.app.thinkacademy.business.study.study.entity.request.AllSchoolsRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069 A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x0066, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getCurrentSchool(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.CurrentSchool> r7) {
        /*
            boolean r0 = r7 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getCurrentSchool$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getCurrentSchool$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getCurrentSchool$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getCurrentSchool$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getCurrentSchool$1
            r0.<init>(r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0069
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0036:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005c
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r7 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r7 = r7.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r6 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.network.Api.create(r7, r6)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r7 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r7
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r7 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.DefaultImpls.getCurrentSchool$default(r7, r4, r0, r5, r4)
            if (r7 != r1) goto L_0x005c
            return r1
        L_0x005c:
            com.tal.app.thinkacademy.lib.restful.HiResponse r7 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r7
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r2.transform(r7, r0)
            if (r7 != r1) goto L_0x0069
            return r1
        L_0x0069:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.getCurrentSchool(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e A[PHI: r11 
      PHI: (r11v2 java.lang.Object) = (r11v5 java.lang.Object), (r11v1 java.lang.Object) binds: [B:23:0x007b, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getPlaybackOfflineData(java.lang.Integer r10, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.PlaybackOfflineBean> r11) {
        /*
            boolean r0 = r11 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPlaybackOfflineData$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPlaybackOfflineData$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPlaybackOfflineData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPlaybackOfflineData$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getPlaybackOfflineData$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x007e
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0036:
            java.lang.Object r10 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r10 = (com.tal.app.thinkacademy.common.network.NetData) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0071
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r11)
            com.tal.app.thinkacademy.common.network.NetData r11 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r2 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r6 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r6)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.common.entity.BaseRequestBean r6 = new com.tal.app.thinkacademy.common.entity.BaseRequestBean
            if (r10 != 0) goto L_0x0057
            r10 = r3
            goto L_0x0060
        L_0x0057:
            int r10 = r10.intValue()
            long r7 = (long) r10
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
        L_0x0060:
            r6.<init>(r10)
            r0.L$0 = r11
            r0.label = r5
            java.lang.Object r10 = r2.getPlaybackOfflineData(r6, r0)
            if (r10 != r1) goto L_0x006e
            return r1
        L_0x006e:
            r9 = r11
            r11 = r10
            r10 = r9
        L_0x0071:
            com.tal.app.thinkacademy.lib.restful.HiResponse r11 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r11
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r11 = r10.transform(r11, r0)
            if (r11 != r1) goto L_0x007e
            return r1
        L_0x007e:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.getPlaybackOfflineData(java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0073, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object timezoneCheck(java.lang.String r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.entity.TimeZoneCheckEntity> r9) {
        /*
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$timezoneCheck$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$timezoneCheck$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$timezoneCheck$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$timezoneCheck$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$timezoneCheck$1
            r0.<init>(r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0076
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0068
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.common.network.CommonApi> r5 = com.tal.app.thinkacademy.common.network.CommonApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.common.network.CommonApi r2 = (com.tal.app.thinkacademy.common.network.CommonApi) r2
            com.tal.app.thinkacademy.business.study.study.entity.request.TimeZoneCheckRequest r5 = new com.tal.app.thinkacademy.business.study.study.entity.request.TimeZoneCheckRequest
            com.tal.app.thinkacademy.business.study.study.entity.request.TimeZoneCheckRequestData r6 = new com.tal.app.thinkacademy.business.study.study.entity.request.TimeZoneCheckRequestData
            r6.<init>(r8)
            r5.<init>(r6)
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.timeZoneCheck(r5, r0)
            if (r8 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x0068:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x0076
            return r1
        L_0x0076:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.timezoneCheck(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069 A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x0066, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getRecordedClass(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.RecordedClassList> r7) {
        /*
            boolean r0 = r7 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getRecordedClass$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getRecordedClass$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getRecordedClass$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getRecordedClass$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getRecordedClass$1
            r0.<init>(r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0069
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0036:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005c
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r7 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r7 = r7.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r6 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.network.Api.create(r7, r6)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r7 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r7
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r7 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.DefaultImpls.getRecordedClassList$default(r7, r4, r0, r5, r4)
            if (r7 != r1) goto L_0x005c
            return r1
        L_0x005c:
            com.tal.app.thinkacademy.lib.restful.HiResponse r7 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r7
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r2.transform(r7, r0)
            if (r7 != r1) goto L_0x0069
            return r1
        L_0x0069:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.getRecordedClass(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b A[PHI: r11 
      PHI: (r11v2 java.lang.Object) = (r11v5 java.lang.Object), (r11v1 java.lang.Object) binds: [B:19:0x0078, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getRecordedCalendarData(long r9, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity> r11) {
        /*
            boolean r0 = r11 instanceof com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getRecordedCalendarData$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getRecordedCalendarData$1 r0 = (com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getRecordedCalendarData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getRecordedCalendarData$1 r0 = new com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt$getRecordedCalendarData$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x007b
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0035:
            java.lang.Object r9 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r9 = (com.tal.app.thinkacademy.common.network.NetData) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x006d
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r11)
            com.tal.app.thinkacademy.common.network.NetData r11 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.business.study.study.entity.request.GoGlobalRequest r5 = new com.tal.app.thinkacademy.business.study.study.entity.request.GoGlobalRequest
            com.tal.app.thinkacademy.business.study.study.entity.request.GoGlobalRequestHeader r6 = new com.tal.app.thinkacademy.business.study.study.entity.request.GoGlobalRequestHeader
            r6.<init>()
            com.tal.app.thinkacademy.business.study.study.entity.request.RecordedCalendarRequestData r7 = new com.tal.app.thinkacademy.business.study.study.entity.request.RecordedCalendarRequestData
            r7.<init>(r9)
            r5.<init>(r6, r7)
            r0.L$0 = r11
            r0.label = r4
            java.lang.Object r9 = r2.getRecordedCalendarData(r5, r0)
            if (r9 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r8 = r11
            r11 = r9
            r9 = r8
        L_0x006d:
            com.tal.app.thinkacademy.lib.restful.HiResponse r11 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r11
            r10 = 0
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r11 = r9.transform(r11, r0)
            if (r11 != r1) goto L_0x007b
            return r1
        L_0x007b:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.getRecordedCalendarData(long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
