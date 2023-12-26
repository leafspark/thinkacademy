package com.tal.app.thinkacademy.live.abilitypack.chatbox;

import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxConfigBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel$formatInitData$1", f = "ChatBoxViewModel.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChatBoxViewModel.kt */
final class ChatBoxViewModel$formatInitData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ChatBoxConfigBean, Unit> $block;
    final /* synthetic */ String $json;
    int label;
    final /* synthetic */ ChatBoxViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatBoxViewModel$formatInitData$1(String str, ChatBoxViewModel chatBoxViewModel, Function1<? super ChatBoxConfigBean, Unit> function1, Continuation<? super ChatBoxViewModel$formatInitData$1> continuation) {
        super(2, continuation);
        this.$json = str;
        this.this$0 = chatBoxViewModel;
        this.$block = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new ChatBoxViewModel$formatInitData$1(this.$json, this.this$0, this.$block, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d A[Catch:{ Exception -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x001c
            if (r1 != r3) goto L_0x0014
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ Exception -> 0x0011 }
            goto L_0x00a8
        L_0x0011:
            r12 = move-exception
            goto L_0x0091
        L_0x0014:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.String r12 = r11.$json     // Catch:{ Exception -> 0x0011 }
            java.lang.Class<com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxConfigBean> r1 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxConfigBean.class
            java.lang.Object r12 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson((java.lang.String) r12, r1)     // Catch:{ Exception -> 0x0011 }
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxConfigBean r12 = (com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxConfigBean) r12     // Catch:{ Exception -> 0x0011 }
            java.lang.String r1 = r12.getQuickMsgList()     // Catch:{ Exception -> 0x005b }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x005b }
            if (r1 == 0) goto L_0x003a
            int r1 = r1.length()     // Catch:{ Exception -> 0x005b }
            if (r1 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r1 = r2
            goto L_0x003b
        L_0x003a:
            r1 = r3
        L_0x003b:
            if (r1 != 0) goto L_0x0073
            java.lang.String r1 = r12.getQuickMsgList()     // Catch:{ Exception -> 0x005b }
            java.lang.String r4 = "bean.quickMsgList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)     // Catch:{ Exception -> 0x005b }
            r5 = r1
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x005b }
            java.lang.String r1 = ","
            java.lang.String[] r6 = new java.lang.String[]{r1}     // Catch:{ Exception -> 0x005b }
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            java.util.List r1 = kotlin.text.StringsKt.split$default(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x005b }
            r12.setQuickMsgArray(r1)     // Catch:{ Exception -> 0x005b }
            goto L_0x0073
        L_0x005b:
            r1 = move-exception
            com.tal.app.thinkacademy.live.Tag r4 = com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel.TAG     // Catch:{ Exception -> 0x0011 }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r4 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r4     // Catch:{ Exception -> 0x0011 }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0011 }
            java.lang.String r6 = "初始化数据，快捷回复解析失败 "
            java.lang.String r1 = r1.getMessage()     // Catch:{ Exception -> 0x0011 }
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r1)     // Catch:{ Exception -> 0x0011 }
            r5[r2] = r1     // Catch:{ Exception -> 0x0011 }
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r4, r5)     // Catch:{ Exception -> 0x0011 }
        L_0x0073:
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()     // Catch:{ Exception -> 0x0011 }
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch:{ Exception -> 0x0011 }
            com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel$formatInitData$1$1 r4 = new com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel$formatInitData$1$1     // Catch:{ Exception -> 0x0011 }
            com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel r5 = r11.this$0     // Catch:{ Exception -> 0x0011 }
            kotlin.jvm.functions.Function1<com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxConfigBean, kotlin.Unit> r6 = r11.$block     // Catch:{ Exception -> 0x0011 }
            r7 = 0
            r4.<init>(r5, r12, r6, r7)     // Catch:{ Exception -> 0x0011 }
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ Exception -> 0x0011 }
            r12 = r11
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12     // Catch:{ Exception -> 0x0011 }
            r11.label = r3     // Catch:{ Exception -> 0x0011 }
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r12)     // Catch:{ Exception -> 0x0011 }
            if (r12 != r0) goto L_0x00a8
            return r0
        L_0x0091:
            com.tal.app.thinkacademy.live.Tag r0 = com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r12 = r12.getMessage()
            java.lang.String r3 = "初始化数据解析失败 "
            java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r12)
            r1[r2] = r12
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r0, r1)
        L_0x00a8:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel$formatInitData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
