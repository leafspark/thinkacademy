package com.tal.app.thinkacademy.live.business.groupvideocall.driver;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver$getGroupStudentList$2", f = "GroupVideoCallPluginDriver.kt", i = {}, l = {806, 804}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GroupVideoCallPluginDriver.kt */
final class GroupVideoCallPluginDriver$getGroupStudentList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ GroupVideoCallPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GroupVideoCallPluginDriver$getGroupStudentList$2(GroupVideoCallPluginDriver groupVideoCallPluginDriver, Continuation<? super GroupVideoCallPluginDriver$getGroupStudentList$2> continuation) {
        super(2, continuation);
        this.this$0 = groupVideoCallPluginDriver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new GroupVideoCallPluginDriver$getGroupStudentList$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r4) goto L_0x001b
            if (r1 != r3) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0072
        L_0x0013:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001b:
            java.lang.Object r1 = r9.L$0
            com.tal.app.thinkacademy.common.network.NetData r1 = (com.tal.app.thinkacademy.common.network.NetData) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0062
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.network.NetData r1 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.business.groupvideocall.api.GroupVideoCallApi> r10 = com.tal.app.thinkacademy.live.business.groupvideocall.api.GroupVideoCallApi.class
            java.lang.Object r10 = com.tal.app.thinkacademy.lib.network.Api.create(r10)
            com.tal.app.thinkacademy.live.business.groupvideocall.api.GroupVideoCallApi r10 = (com.tal.app.thinkacademy.live.business.groupvideocall.api.GroupVideoCallApi) r10
            com.tal.app.thinkacademy.common.imconfig.ImConfig r5 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r5 = r5.getOverseaApi()
            java.lang.String r6 = "/api/hub/linkmic/getLinkMicStudentDataOfMulti"
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r6)
            com.tal.app.thinkacademy.live.business.groupvideocall.bean.request.GroupVideoCallRequest r6 = new com.tal.app.thinkacademy.live.business.groupvideocall.bean.request.GroupVideoCallRequest
            com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver r7 = r9.this$0
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r7 = r7.mCourseInfo
            if (r7 != 0) goto L_0x0048
            r7 = r2
            goto L_0x0051
        L_0x0048:
            int r7 = r7.getPlanId()
            long r7 = (long) r7
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
        L_0x0051:
            r6.<init>(r7)
            r7 = r9
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r9.L$0 = r1
            r9.label = r4
            java.lang.Object r10 = r10.getLinkMicStudentDataOfMulti(r5, r6, r7)
            if (r10 != r0) goto L_0x0062
            return r0
        L_0x0062:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r5 = r9
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r9.L$0 = r2
            r9.label = r3
            java.lang.Object r10 = r1.transform(r10, r5)
            if (r10 != r0) goto L_0x0072
            return r0
        L_0x0072:
            com.tal.app.thinkacademy.live.business.groupvideocall.bean.GroupStudentInfoList r10 = (com.tal.app.thinkacademy.live.business.groupvideocall.bean.GroupStudentInfoList) r10
            com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver r0 = r9.this$0
            if (r10 != 0) goto L_0x007a
            r10 = r2
            goto L_0x007e
        L_0x007a:
            java.util.List r10 = r10.getList()
        L_0x007e:
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            r0.mGroupStudentList = r10
            com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver r10 = r9.this$0
            java.util.ArrayList r10 = r10.mGroupStudentList
            if (r10 != 0) goto L_0x008d
            goto L_0x017a
        L_0x008d:
            com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver r0 = r9.this$0
            java.util.ArrayList r0 = r0.mGroupStudentList
            java.util.Collection r0 = (java.util.Collection) r0
            r1 = 0
            if (r0 == 0) goto L_0x00a1
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x009f
            goto L_0x00a1
        L_0x009f:
            r0 = r1
            goto L_0x00a2
        L_0x00a1:
            r0 = r4
        L_0x00a2:
            r0 = r0 ^ r4
            if (r0 == 0) goto L_0x00a6
            r2 = r10
        L_0x00a6:
            if (r2 != 0) goto L_0x00aa
            goto L_0x017a
        L_0x00aa:
            com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver r10 = r9.this$0
            java.util.Iterator r0 = r2.iterator()
        L_0x00b0:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x017a
            java.lang.Object r2 = r0.next()
            com.tal.app.thinkacademy.live.business.groupvideocall.bean.GroupStudentInfo r2 = (com.tal.app.thinkacademy.live.business.groupvideocall.bean.GroupStudentInfo) r2
            java.util.LinkedHashMap r5 = r10.mLocalStudent
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r6 = r2.getUserId()
            java.lang.Object r5 = r5.get(r6)
            com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean r5 = (com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean) r5
            if (r5 != 0) goto L_0x00cf
            goto L_0x00b0
        L_0x00cf:
            java.lang.String r6 = r2.getUserId()
            java.lang.String r7 = r10.mUserId
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r6 != 0) goto L_0x00b0
            java.lang.Integer r6 = r5.getCameraIsInit()
            r7 = -1
            if (r6 != 0) goto L_0x00e5
            goto L_0x0126
        L_0x00e5:
            int r6 = r6.intValue()
            if (r6 != r7) goto L_0x0126
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r5.setCameraIsInit(r6)
            java.lang.String r6 = r2.getCameraIsOpen()
            if (r6 != 0) goto L_0x00fa
        L_0x00f8:
            r6 = r1
            goto L_0x0101
        L_0x00fa:
            int r6 = java.lang.Integer.parseInt(r6)
            if (r6 != r4) goto L_0x00f8
            r6 = r4
        L_0x0101:
            if (r6 == 0) goto L_0x0108
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            goto L_0x010c
        L_0x0108:
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
        L_0x010c:
            r5.setCameraIsOpen(r6)
            java.lang.String r6 = r5.getUserId()
            java.lang.Integer r8 = r5.getCameraIsOpen()
            if (r8 != 0) goto L_0x011a
            goto L_0x0122
        L_0x011a:
            int r8 = r8.intValue()
            if (r8 != r4) goto L_0x0122
            r8 = r4
            goto L_0x0123
        L_0x0122:
            r8 = r1
        L_0x0123:
            r10.remotefirstVideoRecvWithUid(r6, r8)
        L_0x0126:
            java.lang.Integer r6 = r5.getMicIsInit()
            if (r6 != 0) goto L_0x012d
            goto L_0x00b0
        L_0x012d:
            int r6 = r6.intValue()
            if (r6 != r7) goto L_0x00b0
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r5.setMicIsInit(r6)
            java.lang.String r2 = r2.getMicIsOpen()
            if (r2 != 0) goto L_0x0142
        L_0x0140:
            r2 = r1
            goto L_0x0149
        L_0x0142:
            int r2 = java.lang.Integer.parseInt(r2)
            if (r2 != r4) goto L_0x0140
            r2 = r4
        L_0x0149:
            if (r2 == 0) goto L_0x0150
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            goto L_0x0154
        L_0x0150:
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
        L_0x0154:
            r5.setMicIsOpen(r2)
            java.lang.String r2 = r5.getUserId()
            java.lang.Integer r6 = r5.getMicIsOpen()
            if (r6 != 0) goto L_0x0162
            goto L_0x016a
        L_0x0162:
            int r6 = r6.intValue()
            if (r6 == r4) goto L_0x0169
            goto L_0x016a
        L_0x0169:
            r7 = r1
        L_0x016a:
            r10.updateMic(r2, r7)
            java.lang.String r2 = r5.getUserId()
            long r5 = java.lang.Long.parseLong(r2)
            r10.playingAudioStart(r5)
            goto L_0x00b0
        L_0x017a:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver$getGroupStudentList$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
