package com.tal.app.thinkacademy.common.aws;

import android.content.Context;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.common.aws.AwsS3Util$uploadFile$3", f = "AwsS3Util.kt", i = {}, l = {478}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AwsS3Util.kt */
final class AwsS3Util$uploadFile$3 extends SuspendLambda implements Function2<ProducerScope<? super AwsS3Util.Event>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ File $file;
    final /* synthetic */ String $key;
    final /* synthetic */ String $scene;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AwsS3Util$uploadFile$3(Context context, String str, String str2, File file, Continuation<? super AwsS3Util$uploadFile$3> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$scene = str;
        this.$key = str2;
        this.$file = file;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> awsS3Util$uploadFile$3 = new AwsS3Util$uploadFile$3(this.$context, this.$scene, this.$key, this.$file, continuation);
        awsS3Util$uploadFile$3.L$0 = obj;
        return (Continuation) awsS3Util$uploadFile$3;
    }

    public final Object invoke(ProducerScope<? super AwsS3Util.Event> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            AwsS3Util.INSTANCE.uploadFile(this.$context, this.$scene, this.$key, this.$file, (AwsS3Util.SingleTransferListener) new AwsS3Util.SingleTransferListener() {
                public void onUploadSuccess(String str, String str2) {
                    Intrinsics.checkNotNullParameter(str, "name");
                    Intrinsics.checkNotNullParameter(str2, "result");
                    ChannelsKt.trySendBlocking(producerScope, new AwsS3Util.Event.OnUploadSuccess(str, str2));
                }

                public void onStateChanged(int i, TransferState transferState) {
                    ChannelsKt.trySendBlocking(producerScope, new AwsS3Util.Event.OnStateChanged(i, transferState));
                }

                public void onProgressChanged(int i, long j, long j2) {
                    ChannelsKt.trySendBlocking(producerScope, new AwsS3Util.Event.OnProgressChanged(i, j, j2));
                }

                public void onError(int i, Exception exc) {
                    ChannelsKt.trySendBlocking(producerScope, new AwsS3Util.Event.OnError(i, exc));
                }
            });
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() {
                public final void invoke() {
                    SendChannel.DefaultImpls.close$default(producerScope, (Throwable) null, 1, (Object) null);
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
