package com.tal.app.thinkacademy.common.aws;

import android.content.Context;
import android.os.SystemClock;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.entity.STSToken;
import com.tal.app.thinkacademy.common.oss.OSSService;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import java.io.File;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.common.aws.AwsS3Util$uploadFile$2", f = "AwsS3Util.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AwsS3Util.kt */
final class AwsS3Util$uploadFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ File $file;
    final /* synthetic */ String $key;
    final /* synthetic */ AwsS3Util.SingleTransferListener $listener;
    final /* synthetic */ String $scene;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AwsS3Util$uploadFile$2(String str, String str2, AwsS3Util.SingleTransferListener singleTransferListener, File file, Context context, Continuation<? super AwsS3Util$uploadFile$2> continuation) {
        super(2, continuation);
        this.$key = str;
        this.$scene = str2;
        this.$listener = singleTransferListener;
        this.$file = file;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new AwsS3Util$uploadFile$2(this.$key, this.$scene, this.$listener, this.$file, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String[] strArr = {this.$key};
            this.label = 1;
            obj = AwsS3Util.mRepository.getSTSToken(this.$scene, strArr, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        STSToken sTSToken = (STSToken) obj;
        if (sTSToken == null) {
            AwsS3Util.SingleTransferListener singleTransferListener = this.$listener;
            if (singleTransferListener != null) {
                singleTransferListener.onError(0, new Exception("too many request"));
            }
            return Unit.INSTANCE;
        }
        XesLog.i(AwsS3Util.tag, "单个文件上传>>>target=" + sTSToken.getTarget() + "，filePaths=" + GsonUtil.getInstance().objToJson(sTSToken.getFilePaths()) + "，文件大小：" + this.$file.length());
        if (Intrinsics.areEqual("s3", sTSToken.getTarget())) {
            AwsS3Util.INSTANCE.initAws(this.$context, sTSToken);
            String str = sTSToken.getFilePaths()[0];
            AwsS3Util awsS3Util = AwsS3Util.INSTANCE;
            File file = this.$file;
            awsS3Util.uploadFile(str, file, new AwsS3Util$uploadFile$2$transferListener$1(this.$listener, this.$file, SystemClock.elapsedRealtime(), sTSToken, str, this.$scene));
        } else {
            OSSService.uploadFile(this.$file, sTSToken, 0, this.$listener, this.$scene);
        }
        return Unit.INSTANCE;
    }
}
