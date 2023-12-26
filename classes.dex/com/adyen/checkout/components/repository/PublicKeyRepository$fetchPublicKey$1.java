package com.adyen.checkout.components.repository;

import com.adyen.checkout.core.api.Environment;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.adyen.checkout.components.repository.PublicKeyRepository", f = "PublicKeyRepository.kt", i = {0, 0}, l = {39}, m = "fetchPublicKey", n = {"environment", "clientKey"}, s = {"L$0", "L$1"})
/* compiled from: PublicKeyRepository.kt */
final class PublicKeyRepository$fetchPublicKey$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PublicKeyRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PublicKeyRepository$fetchPublicKey$1(PublicKeyRepository publicKeyRepository, Continuation<? super PublicKeyRepository$fetchPublicKey$1> continuation) {
        super(continuation);
        this.this$0 = publicKeyRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchPublicKey((Environment) null, (String) null, (Continuation) this);
    }
}
