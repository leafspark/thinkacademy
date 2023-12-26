package com.adyen.checkout.components.repository;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/adyen/checkout/components/repository/PublicKeyRepository;", "", "()V", "fetchPublicKey", "", "environment", "Lcom/adyen/checkout/core/api/Environment;", "clientKey", "(Lcom/adyen/checkout/core/api/Environment;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PublicKeyRepository.kt */
public final class PublicKeyRepository {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchPublicKey(com.adyen.checkout.core.api.Environment r10, java.lang.String r11, kotlin.coroutines.Continuation<? super java.lang.String> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.adyen.checkout.components.repository.PublicKeyRepository$fetchPublicKey$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.adyen.checkout.components.repository.PublicKeyRepository$fetchPublicKey$1 r0 = (com.adyen.checkout.components.repository.PublicKeyRepository$fetchPublicKey$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.adyen.checkout.components.repository.PublicKeyRepository$fetchPublicKey$1 r0 = new com.adyen.checkout.components.repository.PublicKeyRepository$fetchPublicKey$1
            r0.<init>(r9, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            int r10 = r0.I$1
            int r11 = r0.I$0
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r0.L$0
            com.adyen.checkout.core.api.Environment r4 = (com.adyen.checkout.core.api.Environment) r4
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ IOException -> 0x0038, JSONException -> 0x0036 }
            goto L_0x0086
        L_0x0036:
            r12 = move-exception
            goto L_0x008d
        L_0x0038:
            r12 = move-exception
            goto L_0x009f
        L_0x003b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.String r12 = com.adyen.checkout.components.repository.PublicKeyRepositoryKt.TAG
            java.lang.String r2 = "fetching publicKey from API"
            com.adyen.checkout.core.log.Logger.d(r12, r2)
            r12 = 3
            r2 = 0
            r8 = r11
            r11 = r10
            r10 = r12
            r12 = r8
        L_0x0055:
            if (r2 >= r10) goto L_0x00af
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            java.lang.Number r4 = (java.lang.Number) r4
            r4.intValue()
            com.adyen.checkout.components.api.PublicKeyConnection r4 = new com.adyen.checkout.components.api.PublicKeyConnection     // Catch:{ IOException -> 0x0099, JSONException -> 0x0087 }
            r4.<init>(r11, r12)     // Catch:{ IOException -> 0x0099, JSONException -> 0x0087 }
            com.adyen.checkout.core.api.Connection r4 = (com.adyen.checkout.core.api.Connection) r4     // Catch:{ IOException -> 0x0099, JSONException -> 0x0087 }
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ IOException -> 0x0099, JSONException -> 0x0087 }
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5     // Catch:{ IOException -> 0x0099, JSONException -> 0x0087 }
            com.adyen.checkout.components.repository.PublicKeyRepository$fetchPublicKey$lambda-0$$inlined$suspendedCall$1 r6 = new com.adyen.checkout.components.repository.PublicKeyRepository$fetchPublicKey$lambda-0$$inlined$suspendedCall$1     // Catch:{ IOException -> 0x0099, JSONException -> 0x0087 }
            r7 = 0
            r6.<init>(r4, r7)     // Catch:{ IOException -> 0x0099, JSONException -> 0x0087 }
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ IOException -> 0x0099, JSONException -> 0x0087 }
            r0.L$0 = r11     // Catch:{ IOException -> 0x0099, JSONException -> 0x0087 }
            r0.L$1 = r12     // Catch:{ IOException -> 0x0099, JSONException -> 0x0087 }
            r0.I$0 = r2     // Catch:{ IOException -> 0x0099, JSONException -> 0x0087 }
            r0.I$1 = r10     // Catch:{ IOException -> 0x0099, JSONException -> 0x0087 }
            r0.label = r3     // Catch:{ IOException -> 0x0099, JSONException -> 0x0087 }
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r0)     // Catch:{ IOException -> 0x0099, JSONException -> 0x0087 }
            if (r12 != r1) goto L_0x0086
            return r1
        L_0x0086:
            return r12
        L_0x0087:
            r4 = move-exception
            r8 = r4
            r4 = r11
            r11 = r2
            r2 = r12
            r12 = r8
        L_0x008d:
            java.lang.String r5 = com.adyen.checkout.components.repository.PublicKeyRepositoryKt.TAG
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            java.lang.String r6 = "PublicKeyConnection unexpected result"
            com.adyen.checkout.core.log.Logger.e(r5, r6, r12)
            goto L_0x00aa
        L_0x0099:
            r4 = move-exception
            r8 = r4
            r4 = r11
            r11 = r2
            r2 = r12
            r12 = r8
        L_0x009f:
            java.lang.String r5 = com.adyen.checkout.components.repository.PublicKeyRepositoryKt.TAG
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            java.lang.String r6 = "PublicKeyConnection Failed"
            com.adyen.checkout.core.log.Logger.e(r5, r6, r12)
        L_0x00aa:
            r12 = r2
            int r2 = r11 + 1
            r11 = r4
            goto L_0x0055
        L_0x00af:
            com.adyen.checkout.core.exception.CheckoutException r10 = new com.adyen.checkout.core.exception.CheckoutException
            java.lang.String r11 = "Unable to fetch public key"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.components.repository.PublicKeyRepository.fetchPublicKey(com.adyen.checkout.core.api.Environment, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
