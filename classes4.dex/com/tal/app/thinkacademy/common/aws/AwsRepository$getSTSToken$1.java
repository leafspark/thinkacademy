package com.tal.app.thinkacademy.common.aws;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.common.aws.AwsRepository", f = "AwsRepository.kt", i = {}, l = {24, 20}, m = "getSTSToken", n = {}, s = {})
/* compiled from: AwsRepository.kt */
final class AwsRepository$getSTSToken$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AwsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AwsRepository$getSTSToken$1(AwsRepository awsRepository, Continuation<? super AwsRepository$getSTSToken$1> continuation) {
        super(continuation);
        this.this$0 = awsRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getSTSToken((String) null, (String[]) null, (Continuation) this);
    }
}
