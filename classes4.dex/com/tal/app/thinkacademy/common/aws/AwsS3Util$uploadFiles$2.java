package com.tal.app.thinkacademy.common.aws;

import android.content.Context;
import android.os.SystemClock;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.entity.STSToken;
import com.tal.app.thinkacademy.common.oss.OSSService;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.common.aws.AwsS3Util$uploadFiles$2", f = "AwsS3Util.kt", i = {}, l = {272}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AwsS3Util.kt */
final class AwsS3Util$uploadFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<File> $files;
    final /* synthetic */ List<String> $keys;
    final /* synthetic */ AwsS3Util.MultiTransferListener $listener;
    final /* synthetic */ String $scene;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AwsS3Util$uploadFiles$2(List<String> list, String str, AwsS3Util.MultiTransferListener multiTransferListener, Context context, List<? extends File> list2, Continuation<? super AwsS3Util$uploadFiles$2> continuation) {
        super(2, continuation);
        this.$keys = list;
        this.$scene = str;
        this.$listener = multiTransferListener;
        this.$context = context;
        this.$files = list2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new AwsS3Util$uploadFiles$2(this.$keys, this.$scene, this.$listener, this.$context, this.$files, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object[] array = this.$keys.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            AwsRepository access$getMRepository$p = AwsS3Util.mRepository;
            String str = this.$scene;
            this.label = 1;
            obj = access$getMRepository$p.getSTSToken(str, (String[]) array, (Continuation) this);
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
            AwsS3Util.MultiTransferListener multiTransferListener = this.$listener;
            if (multiTransferListener != null) {
                multiTransferListener.onError(0, 9999, new Exception("too many request"));
            }
            return Unit.INSTANCE;
        }
        XesLog.i(AwsS3Util.tag, "批量上传>>>target=" + sTSToken.getTarget() + "，filePaths" + GsonUtil.getInstance().objToJson(sTSToken.getFilePaths()));
        if (Intrinsics.areEqual("s3", sTSToken.getTarget())) {
            AwsS3Util.INSTANCE.initAws(this.$context, sTSToken);
            List list = ArraysKt.toList(sTSToken.getFilePaths());
            Ref.IntRef intRef = new Ref.IntRef();
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = SystemClock.elapsedRealtime();
            Ref.IntRef intRef2 = intRef;
            List list2 = list;
            AwsS3Util.INSTANCE.uploadFile((String) list.get(intRef.element), this.$files.get(intRef.element), new AwsS3Util$uploadFiles$2$transferListener$1(this.$listener, intRef2, this.$files, longRef, sTSToken, list2, this.$scene));
        } else {
            OSSService.uploadFiles(this.$files, sTSToken, 0, this.$listener, this.$scene);
        }
        return Unit.INSTANCE;
    }
}
