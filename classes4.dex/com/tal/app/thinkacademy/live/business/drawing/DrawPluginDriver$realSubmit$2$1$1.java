package com.tal.app.thinkacademy.live.business.drawing;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event;", "emit", "(Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DrawPluginDriver.kt */
final class DrawPluginDriver$realSubmit$2$1$1<T> implements FlowCollector, SuspendFunction {
    final /* synthetic */ Long $classId;
    final /* synthetic */ String $interactId;
    final /* synthetic */ Long $planId;
    final /* synthetic */ Long $tutorId;
    final /* synthetic */ DrawPluginDriver this$0;

    DrawPluginDriver$realSubmit$2$1$1(DrawPluginDriver drawPluginDriver, Long l, Long l2, Long l3, String str) {
        this.this$0 = drawPluginDriver;
        this.$planId = l;
        this.$classId = l2;
        this.$tutorId = l3;
        this.$interactId = str;
    }

    public final Object emit(AwsS3Util.Event event, Continuation<? super Unit> continuation) {
        if (event instanceof AwsS3Util.Event.OnUploadSuccess) {
            Object access$aswSuccess = this.this$0.aswSuccess(this.$planId, this.$classId, this.$tutorId, this.$interactId, ((AwsS3Util.Event.OnUploadSuccess) event).getName(), continuation);
            return access$aswSuccess == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? access$aswSuccess : Unit.INSTANCE;
        }
        if (event instanceof AwsS3Util.Event.OnProgressChanged) {
            AwsS3Util.Event.OnProgressChanged onProgressChanged = (AwsS3Util.Event.OnProgressChanged) event;
            this.this$0.updateProgress(onProgressChanged.getBytesCurrent(), onProgressChanged.getBytesTotal());
        } else {
            String str = null;
            if (event instanceof AwsS3Util.Event.OnError) {
                DrawPluginDriver drawPluginDriver = this.this$0;
                Exception ex = ((AwsS3Util.Event.OnError) event).getEx();
                if (ex != null) {
                    str = ex.getMessage();
                }
                drawPluginDriver.awsOnError(str);
            } else if (event instanceof AwsS3Util.Event.OnStateChanged) {
                DrawPluginDriver drawPluginDriver2 = this.this$0;
                Object[] objArr = new Object[2];
                objArr[0] = "OnStateChanged";
                TransferState state = ((AwsS3Util.Event.OnStateChanged) event).getState();
                if (state != null) {
                    str = state.name();
                }
                objArr[1] = str;
                drawPluginDriver2.log(objArr);
            }
        }
        return Unit.INSTANCE;
    }
}
