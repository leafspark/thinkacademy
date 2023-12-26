package com.tal.app.thinkacademy.live.abilitypack.playback;

import com.tal.app.thinkacademy.live.core.interfaces.ILiveBackControllerProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$dispatchIrcMessage$1", f = "PlaybackViewModel.kt", i = {}, l = {454}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PlaybackViewModel.kt */
final class PlaybackViewModel$dispatchIrcMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $ircMsg;
    final /* synthetic */ String $ircType;
    int label;
    final /* synthetic */ PlaybackViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlaybackViewModel$dispatchIrcMessage$1(PlaybackViewModel playbackViewModel, String str, String str2, Continuation<? super PlaybackViewModel$dispatchIrcMessage$1> continuation) {
        super(2, continuation);
        this.this$0 = playbackViewModel;
        this.$ircType = str;
        this.$ircMsg = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new PlaybackViewModel$dispatchIrcMessage$1(this.this$0, this.$ircType, this.$ircMsg, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$dispatchIrcMessage$1$1", f = "PlaybackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel$dispatchIrcMessage$1$1  reason: invalid class name */
    /* compiled from: PlaybackViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return (Continuation) new AnonymousClass1(playbackViewModel, str, str2, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ((ILiveBackControllerProvider) playbackViewModel.getMLiveRoomProvider()).dispatchIrcMessage(str, str2);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final PlaybackViewModel playbackViewModel = this.this$0;
            final String str = this.$ircType;
            final String str2 = this.$ircMsg;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), (Continuation) this) == coroutine_suspended) {
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
