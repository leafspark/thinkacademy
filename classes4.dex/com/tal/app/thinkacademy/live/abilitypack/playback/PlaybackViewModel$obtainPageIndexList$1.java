package com.tal.app.thinkacademy.live.abilitypack.playback;

import com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1", f = "PlaybackViewModel.kt", i = {0}, l = {109}, m = "invokeSuspend", n = {"pageIndexList"}, s = {"L$0"})
/* compiled from: PlaybackViewModel.kt */
final class PlaybackViewModel$obtainPageIndexList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<MetaDataEvent> $metadataList;
    Object L$0;
    int label;
    final /* synthetic */ PlaybackViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlaybackViewModel$obtainPageIndexList$1(List<MetaDataEvent> list, PlaybackViewModel playbackViewModel, Continuation<? super PlaybackViewModel$obtainPageIndexList$1> continuation) {
        super(2, continuation);
        this.$metadataList = list;
        this.this$0 = playbackViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new PlaybackViewModel$obtainPageIndexList$1(this.$metadataList, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x001c
            if (r1 != r3) goto L_0x0014
            java.lang.Object r0 = r12.L$0
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0054
        L_0x0014:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r13)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.List<com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent> r1 = r12.$metadataList
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.asFlow(r1)
            com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$filter$1 r4 = new com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$filter$1
            r4.<init>(r1)
            kotlinx.coroutines.flow.Flow r4 = (kotlinx.coroutines.flow.Flow) r4
            com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1 r1 = new com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1
            r1.<init>(r4, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.flow(r1)
            com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1$3 r4 = new com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1$3
            r4.<init>(r13)
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            r5 = r12
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r12.L$0 = r13
            r12.label = r3
            java.lang.Object r1 = r1.collect(r4, r5)
            if (r1 != r0) goto L_0x0053
            return r0
        L_0x0053:
            r0 = r13
        L_0x0054:
            r13 = r0
            java.util.Collection r13 = (java.util.Collection) r13
            boolean r13 = r13.isEmpty()
            r13 = r13 ^ r3
            if (r13 == 0) goto L_0x005f
            r2 = r0
        L_0x005f:
            if (r2 != 0) goto L_0x0063
            goto L_0x0167
        L_0x0063:
            r13 = r2
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r13 = r13.iterator()
            r1 = 0
            r4 = r1
        L_0x0073:
            boolean r5 = r13.hasNext()
            if (r5 == 0) goto L_0x00b3
            java.lang.Object r5 = r13.next()
            int r6 = r4 + 1
            if (r4 >= 0) goto L_0x0084
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0084:
            r7 = r5
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData r7 = (com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData) r7
            int r8 = r2.size()
            int r8 = r8 - r3
            if (r4 != r8) goto L_0x0090
        L_0x008e:
            r4 = r3
            goto L_0x00ac
        L_0x0090:
            java.lang.Object r4 = r2.get(r6)
            java.lang.String r8 = "it[index + 1]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData r4 = (com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData) r4
            long r8 = r4.getTimestamp()
            long r10 = r7.getTimestamp()
            long r8 = r8 - r10
            r10 = 10000(0x2710, double:4.9407E-320)
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x00ab
            goto L_0x008e
        L_0x00ab:
            r4 = r1
        L_0x00ac:
            if (r4 == 0) goto L_0x00b1
            r0.add(r5)
        L_0x00b1:
            r4 = r6
            goto L_0x0073
        L_0x00b3:
            java.util.List r0 = (java.util.List) r0
            r13 = r0
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r13 = r13.iterator()
            r4 = r1
        L_0x00c4:
            boolean r5 = r13.hasNext()
            if (r5 == 0) goto L_0x00fb
            java.lang.Object r5 = r13.next()
            int r6 = r4 + 1
            if (r4 >= 0) goto L_0x00d5
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00d5:
            r7 = r5
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData r7 = (com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData) r7
            if (r4 <= 0) goto L_0x00f3
            int r4 = r4 + -1
            java.lang.Object r4 = r0.get(r4)
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData r4 = (com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData) r4
            java.lang.String r4 = r4.getPageId()
            java.lang.String r7 = r7.getPageId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r7)
            if (r4 != 0) goto L_0x00f1
            goto L_0x00f3
        L_0x00f1:
            r4 = r1
            goto L_0x00f4
        L_0x00f3:
            r4 = r3
        L_0x00f4:
            if (r4 == 0) goto L_0x00f9
            r2.add(r5)
        L_0x00f9:
            r4 = r6
            goto L_0x00c4
        L_0x00fb:
            java.util.List r2 = (java.util.List) r2
            com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel r13 = r12.this$0
            com.tal.app.thinkacademy.live.Tag r0 = com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel.TAG_PAGE
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "回放索引点共："
            r5.append(r6)
            int r6 = r2.size()
            r5.append(r6)
            java.lang.String r6 = " 个"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4[r1] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r4)
            r0 = r2
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x012d:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0147
            java.lang.Object r4 = r0.next()
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData r4 = (com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData) r4
            com.tal.app.thinkacademy.live.Tag r5 = com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel.TAG_PAGE
            com.tal.app.thinkacademy.lib.logger.XesLogTag r5 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r5
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r6[r1] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r5, r6)
            goto L_0x012d
        L_0x0147:
            java.util.List r0 = r13.mPageIndexList
            r0.clear()
            java.util.List r0 = r13.mPageIndexList
            java.util.Collection r2 = (java.util.Collection) r2
            r0.addAll(r2)
            com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData r0 = r13.getMListenerData()
            com.tal.app.thinkacademy.live.abilitypack.playback.listenbody.PlaybackListenerBody$ObtainPageIndexData r1 = new com.tal.app.thinkacademy.live.abilitypack.playback.listenbody.PlaybackListenerBody$ObtainPageIndexData
            java.util.List r13 = r13.mPageIndexList
            r1.<init>(r13)
            r0.postStickyData(r1)
        L_0x0167:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
