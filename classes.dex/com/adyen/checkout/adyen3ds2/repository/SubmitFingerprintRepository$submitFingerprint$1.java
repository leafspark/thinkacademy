package com.adyen.checkout.adyen3ds2.repository;

import com.adyen.checkout.adyen3ds2.Adyen3DS2Configuration;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository", f = "SubmitFingerprintRepository.kt", i = {}, l = {66}, m = "submitFingerprint", n = {}, s = {})
/* compiled from: SubmitFingerprintRepository.kt */
final class SubmitFingerprintRepository$submitFingerprint$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SubmitFingerprintRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubmitFingerprintRepository$submitFingerprint$1(SubmitFingerprintRepository submitFingerprintRepository, Continuation<? super SubmitFingerprintRepository$submitFingerprint$1> continuation) {
        super(continuation);
        this.this$0 = submitFingerprintRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.submitFingerprint((String) null, (Adyen3DS2Configuration) null, (String) null, (Continuation) this);
    }
}
