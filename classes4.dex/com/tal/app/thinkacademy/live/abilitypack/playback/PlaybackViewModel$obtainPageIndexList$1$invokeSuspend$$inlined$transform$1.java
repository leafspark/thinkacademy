package com.tal.app.thinkacademy.live.abilitypack.playback;

import com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@¨\u0006\u0005"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1", f = "PlaybackViewModel.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Emitters.kt */
public final class PlaybackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super PageIndexData>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlaybackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.$this_transform = flow;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> playbackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1 = new PlaybackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1(this.$this_transform, continuation);
        playbackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1.L$0 = obj;
        return (Continuation) playbackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1;
    }

    public final Object invoke(FlowCollector<? super PageIndexData> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final FlowCollector flowCollector = (FlowCollector) this.L$0;
            this.label = 1;
            if (this.$this_transform.collect(new FlowCollector() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(T r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
                    /*
                        r13 = this;
                        boolean r0 = r15 instanceof com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1.AnonymousClass1.AnonymousClass1
                        if (r0 == 0) goto L_0x0014
                        r0 = r15
                        com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1$1$1 r0 = (com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1.AnonymousClass1.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L_0x0014
                        int r15 = r0.label
                        int r15 = r15 - r2
                        r0.label = r15
                        goto L_0x0019
                    L_0x0014:
                        com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1$1$1 r0 = new com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1$1$1
                        r0.<init>(r13, r15)
                    L_0x0019:
                        java.lang.Object r15 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L_0x0037
                        if (r2 != r3) goto L_0x002f
                        java.lang.Object r14 = r0.L$0
                        org.json.JSONObject r14 = (org.json.JSONObject) r14
                        kotlin.ResultKt.throwOnFailure(r15)
                        goto L_0x00c9
                    L_0x002f:
                        java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                        java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
                        r14.<init>(r15)
                        throw r14
                    L_0x0037:
                        kotlin.ResultKt.throwOnFailure(r15)
                        kotlinx.coroutines.flow.FlowCollector<com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData> r15 = r5
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent r14 = (com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent) r14
                        org.json.JSONObject r2 = new org.json.JSONObject
                        java.lang.String r4 = r14.getProperties()
                        r2.<init>(r4)
                        java.lang.String r4 = "canvas_switch_courseware"
                        org.json.JSONObject r2 = r2.optJSONObject(r4)
                        if (r2 != 0) goto L_0x0054
                        goto L_0x00c9
                    L_0x0054:
                        org.json.JSONObject r2 = r2.optJSONObject(r4)
                        if (r2 != 0) goto L_0x005c
                        goto L_0x00c9
                    L_0x005c:
                        java.lang.String r4 = "currentCourseWare"
                        org.json.JSONObject r2 = r2.optJSONObject(r4)
                        if (r2 != 0) goto L_0x0065
                        goto L_0x00c9
                    L_0x0065:
                        java.lang.String r4 = "blackBoardType"
                        int r4 = r2.optInt(r4)
                        java.lang.String r5 = "imgUrl"
                        java.lang.String r10 = r2.optString(r5)
                        java.lang.String r6 = "jsString"
                        java.lang.String r7 = r2.optString(r6)
                        if (r4 != 0) goto L_0x00c9
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
                        java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                        int r4 = r7.length()
                        r6 = 0
                        if (r4 <= 0) goto L_0x0087
                        r4 = r3
                        goto L_0x0088
                    L_0x0087:
                        r4 = r6
                    L_0x0088:
                        if (r4 == 0) goto L_0x00c9
                        java.lang.String r4 = "pageChanged"
                        java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                        r8 = 2
                        r9 = 0
                        boolean r4 = kotlin.text.StringsKt.contains$default(r7, r4, r6, r8, r9)
                        if (r4 == 0) goto L_0x00c9
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r5)
                        r4 = r10
                        java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                        int r4 = r4.length()
                        if (r4 <= 0) goto L_0x00a3
                        r6 = r3
                    L_0x00a3:
                        if (r6 == 0) goto L_0x00c9
                        java.lang.String r4 = "timestamp"
                        long r11 = r2.optLong(r4)
                        java.lang.String r4 = "pageId"
                        java.lang.String r9 = r2.optString(r4)
                        com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData r5 = new com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData
                        long r7 = r14.getActionTsOffset()
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r4)
                        r6 = r5
                        r6.<init>(r7, r9, r10, r11)
                        r0.L$0 = r2
                        r0.label = r3
                        java.lang.Object r14 = r15.emit(r5, r0)
                        if (r14 != r1) goto L_0x00c9
                        return r1
                    L_0x00c9:
                        kotlin.Unit r14 = kotlin.Unit.INSTANCE
                        return r14
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$obtainPageIndexList$1$invokeSuspend$$inlined$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
