package com.tal.app.thinkacademy.live.business.direction;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.Tag;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginDriver$getDirectionGold$2", f = "DirectionGoldNewPluginDriver.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DirectionGoldNewPluginDriver.kt */
final class DirectionGoldNewPluginDriver$getDirectionGold$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $interactId;
    final /* synthetic */ DirectionRepository $repository;
    final /* synthetic */ String $type;
    Object L$0;
    int label;
    final /* synthetic */ DirectionGoldNewPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DirectionGoldNewPluginDriver$getDirectionGold$2(DirectionGoldNewPluginDriver directionGoldNewPluginDriver, DirectionRepository directionRepository, String str, String str2, Continuation<? super DirectionGoldNewPluginDriver$getDirectionGold$2> continuation) {
        super(2, continuation);
        this.this$0 = directionGoldNewPluginDriver;
        this.$repository = directionRepository;
        this.$interactId = str;
        this.$type = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new DirectionGoldNewPluginDriver$getDirectionGold$2(this.this$0, this.$repository, this.$interactId, this.$type, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        DirectionGoldNewPluginDriver directionGoldNewPluginDriver;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DirectionGoldNewPluginDriver directionGoldNewPluginDriver2 = this.this$0;
            this.L$0 = directionGoldNewPluginDriver2;
            this.label = 1;
            Object directionGold = this.$repository.getDirectionGold(directionGoldNewPluginDriver2.mPlanId, this.$interactId, this.$type, (Continuation) this);
            if (directionGold == coroutine_suspended) {
                return coroutine_suspended;
            }
            directionGoldNewPluginDriver = directionGoldNewPluginDriver2;
            obj = directionGold;
        } else if (i == 1) {
            directionGoldNewPluginDriver = (DirectionGoldNewPluginDriver) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        directionGoldNewPluginDriver.mDirectionBean = (DirectionBean) obj;
        XesLog.s(Tag.DIRECTION_GOLD, Intrinsics.stringPlus("定向金币配置接口请求成功=", GsonUtil.getInstance().objToJson(this.this$0.mDirectionBean)));
        this.this$0.loadView(this.$type);
        return Unit.INSTANCE;
    }
}
