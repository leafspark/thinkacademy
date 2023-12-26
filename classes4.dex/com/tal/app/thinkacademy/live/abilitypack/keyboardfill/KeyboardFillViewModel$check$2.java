package com.tal.app.thinkacademy.live.abilitypack.keyboardfill;

import com.tal.app.thinkacademy.live.abilitypack.LiveRepository;
import com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean.KeyboardFillBody;
import com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean.KeyboardFillResult;
import com.tal.app.thinkacademy.live.abilitypack.keyboardfill.listenbody.KeyboardFillListenerBody;
import com.tal.app.thinkacademy.live.business.keyboardfill.CheckScene;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.abilitypack.keyboardfill.KeyboardFillViewModel$check$2", f = "KeyboardFillViewModel.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: KeyboardFillViewModel.kt */
final class KeyboardFillViewModel$check$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $classId;
    final /* synthetic */ String $interactionId;
    final /* synthetic */ int $planId;
    final /* synthetic */ CheckScene $scene;
    int label;
    final /* synthetic */ KeyboardFillViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KeyboardFillViewModel$check$2(KeyboardFillViewModel keyboardFillViewModel, int i, int i2, String str, CheckScene checkScene, Continuation<? super KeyboardFillViewModel$check$2> continuation) {
        super(2, continuation);
        this.this$0 = keyboardFillViewModel;
        this.$planId = i;
        this.$classId = i2;
        this.$interactionId = str;
        this.$scene = checkScene;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new KeyboardFillViewModel$check$2(this.this$0, this.$planId, this.$classId, this.$interactionId, this.$scene, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LiveRepository access$getMLiveRepository$p = this.this$0.mLiveRepository;
            int i2 = this.$planId;
            int i3 = this.$classId;
            String str = this.$interactionId;
            if (str == null) {
                str = "";
            }
            this.label = 1;
            obj = access$getMLiveRepository$p.check(new KeyboardFillBody(i2, i3, str, (String) null, 8, (DefaultConstructorMarker) null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getMListenerData().postStickyData(new KeyboardFillListenerBody.CheckResult((KeyboardFillResult) obj, this.$scene));
        return Unit.INSTANCE;
    }
}
