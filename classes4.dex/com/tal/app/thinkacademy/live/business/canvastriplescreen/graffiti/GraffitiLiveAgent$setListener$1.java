package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import android.os.SystemClock;
import com.tal.app.thinkacademy.lib.utils.HWCoroutineScopeKt;
import com.xueersi.lib.graffiti.WXWBAction;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0018\u00010\u0005H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "pageId", "", "actionMap", "", "", "Lcom/xueersi/lib/graffiti/WXWBAction;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiLiveAgent.kt */
final class GraffitiLiveAgent$setListener$1 extends Lambda implements Function2<String, Map<String, ? extends List<? extends WXWBAction>>, Unit> {
    final /* synthetic */ GraffitiLiveAgent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraffitiLiveAgent$setListener$1(GraffitiLiveAgent graffitiLiveAgent) {
        super(2);
        this.this$0 = graffitiLiveAgent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (Map<String, ? extends List<? extends WXWBAction>>) (Map) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, Map<String, ? extends List<? extends WXWBAction>> map) {
        Intrinsics.checkNotNullParameter(str, "pageId");
        this.this$0.mLoadHistoryTime = SystemClock.elapsedRealtime();
        final Map linkedHashMap = new LinkedHashMap();
        if (this.this$0.getMTeacherUid() != null) {
            linkedHashMap.put(str, -1L);
        }
        Job job = null;
        if (this.this$0.mScope == null) {
            this.this$0.mScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        }
        GraffitiLiveAgent graffitiLiveAgent = this.this$0;
        CoroutineScope access$getMScope$p = graffitiLiveAgent.mScope;
        if (access$getMScope$p != null) {
            final GraffitiLiveAgent graffitiLiveAgent2 = this.this$0;
            final GraffitiLiveAgent graffitiLiveAgent3 = this.this$0;
            final Map<String, ? extends List<? extends WXWBAction>> map2 = map;
            final String str2 = str;
            job = HWCoroutineScopeKt.launchWithException(access$getMScope$p, new Function2<Integer, String, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(((Number) obj).intValue(), (String) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i, String str) {
                    GraffitiLiveAgent graffitiLiveAgent = graffitiLiveAgent2;
                    graffitiLiveAgent.log("涂鸦历史消息协程异常 code = " + i + " ; msg = " + str);
                }
            }, new AnonymousClass3((Continuation<? super AnonymousClass3>) null));
        }
        graffitiLiveAgent.mJob = job;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent$setListener$1$3", f = "GraffitiLiveAgent.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent$setListener$1$3  reason: invalid class name */
    /* compiled from: GraffitiLiveAgent.kt */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return (Continuation) new AnonymousClass3(graffitiLiveAgent3, map2, str2, linkedHashMap, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: com.xueersi.lib.graffiti.WXWBAction} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00c9  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00fb  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0172  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0256  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x02de  */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x0291 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                r22 = this;
                r1 = r22
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r1.label
                r3 = -1
                r5 = 95
                java.lang.String r6 = "ms"
                r7 = 0
                r8 = 1
                r9 = 0
                if (r2 == 0) goto L_0x002b
                if (r2 != r8) goto L_0x0023
                java.lang.Object r0 = r1.L$0
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r0 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent) r0
                kotlin.ResultKt.throwOnFailure(r23)     // Catch:{ Exception -> 0x0020 }
                r10 = r23
                goto L_0x00a3
            L_0x0020:
                r0 = move-exception
                goto L_0x00b1
            L_0x0023:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x002b:
                kotlin.ResultKt.throwOnFailure(r23)
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r2 = r2
                java.lang.Object[] r10 = new java.lang.Object[r8]
                java.lang.String r11 = "启动协程，查询历史数据"
                r10[r7] = r11
                r2.log(r10)
                java.lang.String r2 = "2"
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r10 = r2
                com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r10 = r10.getMLiveRoomProvider()
                java.lang.String r10 = r10.getClassType()
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                boolean r2 = android.text.TextUtils.equals(r2, r10)
                if (r2 == 0) goto L_0x013b
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r2 = r2
                java.util.List r2 = r2.mPageKeyList
                if (r2 != 0) goto L_0x00bf
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r2 = r2     // Catch:{ Exception -> 0x0020 }
                java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0020 }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                r11.<init>()     // Catch:{ Exception -> 0x0020 }
                java.lang.String r12 = "label->2 , 准备请求pageKeyList, 距上一步耗时: "
                r11.append(r12)     // Catch:{ Exception -> 0x0020 }
                long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0020 }
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r14 = r2     // Catch:{ Exception -> 0x0020 }
                long r14 = r14.mLoadHistoryTime     // Catch:{ Exception -> 0x0020 }
                long r12 = r12 - r14
                r11.append(r12)     // Catch:{ Exception -> 0x0020 }
                r11.append(r6)     // Catch:{ Exception -> 0x0020 }
                java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0020 }
                r10[r7] = r11     // Catch:{ Exception -> 0x0020 }
                r2.log(r10)     // Catch:{ Exception -> 0x0020 }
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r2 = r2     // Catch:{ Exception -> 0x0020 }
                long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0020 }
                r2.mLoadHistoryTime = r10     // Catch:{ Exception -> 0x0020 }
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r2 = r2     // Catch:{ Exception -> 0x0020 }
                com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasRepository r10 = r2.canvasRepository     // Catch:{ Exception -> 0x0020 }
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r11 = r2     // Catch:{ Exception -> 0x0020 }
                java.lang.String r11 = r11.getMPlanId()     // Catch:{ Exception -> 0x0020 }
                r12 = r1
                kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12     // Catch:{ Exception -> 0x0020 }
                r1.L$0 = r2     // Catch:{ Exception -> 0x0020 }
                r1.label = r8     // Catch:{ Exception -> 0x0020 }
                java.lang.Object r10 = r10.studentGetAllPageKey(r11, r12)     // Catch:{ Exception -> 0x0020 }
                if (r10 != r0) goto L_0x00a2
                return r0
            L_0x00a2:
                r0 = r2
            L_0x00a3:
                com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPageList r10 = (com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPageList) r10     // Catch:{ Exception -> 0x0020 }
                if (r10 != 0) goto L_0x00a9
                r2 = r9
                goto L_0x00ad
            L_0x00a9:
                java.util.List r2 = r10.getPageKeyList()     // Catch:{ Exception -> 0x0020 }
            L_0x00ad:
                r0.mPageKeyList = r2     // Catch:{ Exception -> 0x0020 }
                goto L_0x00bf
            L_0x00b1:
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r2 = r2
                java.lang.Object[] r10 = new java.lang.Object[r8]
                java.lang.String r11 = "授权人员接口为异常，部分学生涂鸦可能会不显示，除非本地数据库已有这些学生的涂鸦数据"
                r10[r7] = r11
                r2.log(r10)
                r0.printStackTrace()
            L_0x00bf:
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r0 = r2
                java.util.List r0 = r0.mPageKeyList
                if (r0 != 0) goto L_0x00c9
            L_0x00c7:
                r0 = r9
                goto L_0x00f8
            L_0x00c9:
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.lang.String r2 = r4
                java.util.Iterator r0 = r0.iterator()
            L_0x00d1:
                boolean r10 = r0.hasNext()
                if (r10 == 0) goto L_0x00ee
                java.lang.Object r10 = r0.next()
                r11 = r10
                com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPage r11 = (com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPage) r11
                java.lang.String r11 = r11.getPageKey()
                java.lang.CharSequence r11 = (java.lang.CharSequence) r11
                r12 = r2
                java.lang.CharSequence r12 = (java.lang.CharSequence) r12
                boolean r11 = android.text.TextUtils.equals(r11, r12)
                if (r11 == 0) goto L_0x00d1
                goto L_0x00ef
            L_0x00ee:
                r10 = r9
            L_0x00ef:
                com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPage r10 = (com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPage) r10
                if (r10 != 0) goto L_0x00f4
                goto L_0x00c7
            L_0x00f4:
                java.util.List r0 = r10.getUserIdList()
            L_0x00f8:
                if (r0 != 0) goto L_0x00fb
                goto L_0x012c
            L_0x00fb:
                r2 = r0
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                java.util.Map<java.lang.String, java.lang.Long> r10 = r5
                java.lang.String r11 = r4
                java.util.Iterator r2 = r2.iterator()
            L_0x0106:
                boolean r12 = r2.hasNext()
                if (r12 == 0) goto L_0x012c
                java.lang.Object r12 = r2.next()
                java.lang.String r12 = (java.lang.String) r12
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                r13.append(r12)
                r13.append(r5)
                r13.append(r11)
                java.lang.String r12 = r13.toString()
                java.lang.Long r13 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r3)
                r10.put(r12, r13)
                goto L_0x0106
            L_0x012c:
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r2 = r2
                java.lang.Object[] r10 = new java.lang.Object[r8]
                java.lang.String r11 = "当前页授权涂鸦人员-远端，"
                java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r0)
                r10[r7] = r0
                r2.log(r10)
            L_0x013b:
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r0 = r2
                java.lang.Object[] r2 = new java.lang.Object[r8]
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.lang.String r11 = "label->3 , 准备请求历史数据, 距上一步耗时: "
                r10.append(r11)
                long r11 = android.os.SystemClock.elapsedRealtime()
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r13 = r2
                long r13 = r13.mLoadHistoryTime
                long r11 = r11 - r13
                r10.append(r11)
                r10.append(r6)
                java.lang.String r6 = r10.toString()
                r2[r7] = r6
                r0.log(r2)
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r0 = r2
                long r10 = android.os.SystemClock.elapsedRealtime()
                r0.mLoadHistoryTime = r10
                java.util.Map<java.lang.String, java.util.List<com.xueersi.lib.graffiti.WXWBAction>> r0 = r3
                if (r0 != 0) goto L_0x0172
                goto L_0x02dc
            L_0x0172:
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r2 = r2
                java.lang.String r6 = r4
                java.util.Map<java.lang.String, java.lang.Long> r10 = r5
                java.util.Set r11 = r0.entrySet()
                java.util.Iterator r11 = r11.iterator()
            L_0x0180:
                boolean r12 = r11.hasNext()
                if (r12 == 0) goto L_0x0295
                java.lang.Object r12 = r11.next()
                java.util.Map$Entry r12 = (java.util.Map.Entry) r12
                java.lang.Object r13 = r12.getValue()
                java.util.List r13 = (java.util.List) r13
                java.lang.String r14 = "，共计有"
                if (r13 != 0) goto L_0x0199
            L_0x0196:
                r3 = r9
                goto L_0x0254
            L_0x0199:
                java.lang.Iterable r13 = (java.lang.Iterable) r13
                java.util.Iterator r13 = r13.iterator()
                boolean r15 = r13.hasNext()
                if (r15 != 0) goto L_0x01a7
                r15 = r9
                goto L_0x01d4
            L_0x01a7:
                java.lang.Object r15 = r13.next()
                boolean r16 = r13.hasNext()
                if (r16 != 0) goto L_0x01b2
                goto L_0x01d4
            L_0x01b2:
                r16 = r15
                com.xueersi.lib.graffiti.WXWBAction r16 = (com.xueersi.lib.graffiti.WXWBAction) r16
                long r16 = r16.getMsgId()
            L_0x01ba:
                java.lang.Object r18 = r13.next()
                r19 = r18
                com.xueersi.lib.graffiti.WXWBAction r19 = (com.xueersi.lib.graffiti.WXWBAction) r19
                long r19 = r19.getMsgId()
                int r21 = (r16 > r19 ? 1 : (r16 == r19 ? 0 : -1))
                if (r21 >= 0) goto L_0x01ce
                r15 = r18
                r16 = r19
            L_0x01ce:
                boolean r18 = r13.hasNext()
                if (r18 != 0) goto L_0x01ba
            L_0x01d4:
                com.xueersi.lib.graffiti.WXWBAction r15 = (com.xueersi.lib.graffiti.WXWBAction) r15
                if (r15 != 0) goto L_0x01d9
                goto L_0x0196
            L_0x01d9:
                java.lang.Object[] r13 = new java.lang.Object[r8]
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "本地DB 用户id "
                r3.append(r4)
                java.lang.Object r4 = r12.getKey()
                java.lang.String r4 = (java.lang.String) r4
                r3.append(r4)
                r3.append(r14)
                java.lang.Object r4 = r12.getValue()
                java.util.List r4 = (java.util.List) r4
                if (r4 != 0) goto L_0x01fb
                r4 = r9
                goto L_0x0203
            L_0x01fb:
                int r4 = r4.size()
                java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            L_0x0203:
                r3.append(r4)
                java.lang.String r4 = "条，最后一条消息是"
                r3.append(r4)
                java.lang.String r4 = r15.getUniqueKey()
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r13[r7] = r3
                r2.log(r13)
                java.lang.String r3 = r2.getMTeacherUid()
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                java.lang.Object r4 = r12.getKey()
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r3 = android.text.TextUtils.equals(r3, r4)
                if (r3 == 0) goto L_0x022f
                r3 = r6
                goto L_0x0247
            L_0x022f:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.Object r4 = r12.getKey()
                java.lang.String r4 = (java.lang.String) r4
                r3.append(r4)
                r3.append(r5)
                r3.append(r6)
                java.lang.String r3 = r3.toString()
            L_0x0247:
                long r15 = r15.getMsgId()
                java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r15)
                r10.put(r3, r4)
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
            L_0x0254:
                if (r3 != 0) goto L_0x0291
                java.lang.Object[] r3 = new java.lang.Object[r8]
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r13 = "本地DB 用户 "
                r4.append(r13)
                java.lang.Object r13 = r12.getKey()
                java.lang.String r13 = (java.lang.String) r13
                r4.append(r13)
                r4.append(r14)
                java.lang.Object r12 = r12.getValue()
                java.util.List r12 = (java.util.List) r12
                if (r12 != 0) goto L_0x0278
                r12 = r9
                goto L_0x0280
            L_0x0278:
                int r12 = r12.size()
                java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r12)
            L_0x0280:
                r4.append(r12)
                r12 = 26465(0x6761, float:3.7085E-41)
                r4.append(r12)
                java.lang.String r4 = r4.toString()
                r3[r7] = r4
                r2.log(r3)
            L_0x0291:
                r3 = -1
                goto L_0x0180
            L_0x0295:
                java.lang.String r3 = r2.getMUid()
                if (r3 != 0) goto L_0x029c
                goto L_0x02dc
            L_0x029c:
                java.lang.Object r0 = r0.get(r3)
                java.util.List r0 = (java.util.List) r0
                if (r0 != 0) goto L_0x02a5
                goto L_0x02ac
            L_0x02a5:
                java.lang.Object r0 = kotlin.collections.CollectionsKt.lastOrNull(r0)
                r9 = r0
                com.xueersi.lib.graffiti.WXWBAction r9 = (com.xueersi.lib.graffiti.WXWBAction) r9
            L_0x02ac:
                if (r9 != 0) goto L_0x02b1
                r3 = -1
                goto L_0x02b5
            L_0x02b1:
                long r3 = r9.getMsgId()
            L_0x02b5:
                r2.setMLastSendMsgId(r3)
                java.lang.Object[] r0 = new java.lang.Object[r8]
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "自己最后一次发送的msgIg是 "
                r3.append(r4)
                long r4 = r2.getMLastSendMsgId()
                r3.append(r4)
                java.lang.String r4 = " , -1表示未发送过"
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r0[r7] = r3
                r2.log(r0)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                r9 = r0
            L_0x02dc:
                if (r9 != 0) goto L_0x02ef
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r0 = r2
                java.lang.Object[] r2 = new java.lang.Object[r8]
                java.lang.String r3 = r4
                java.lang.String r4 = "本地DB数据为空,当前pageId "
                java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r3)
                r2[r7] = r3
                r0.log(r2)
            L_0x02ef:
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent r0 = r2
                java.lang.String r2 = r4
                java.util.Map<java.lang.String, java.lang.Long> r3 = r5
                r0.requestHistoryMsg(r2, r3)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent$setListener$1.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
