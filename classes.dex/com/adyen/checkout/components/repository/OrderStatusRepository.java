package com.adyen.checkout.components.repository;

import com.adyen.checkout.core.log.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/adyen/checkout/components/repository/OrderStatusRepository;", "", "()V", "getOrderStatus", "Lcom/adyen/checkout/components/model/connection/OrderStatusResponse;", "configuration", "Lcom/adyen/checkout/components/base/Configuration;", "orderData", "", "(Lcom/adyen/checkout/components/base/Configuration;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: OrderStatusRepository.kt */
public final class OrderStatusRepository {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/adyen/checkout/components/repository/OrderStatusRepository$Companion;", "", "()V", "TAG", "", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: OrderStatusRepository.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String tag = LogUtil.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "getTag()");
        TAG = tag;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getOrderStatus(com.adyen.checkout.components.base.Configuration r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.adyen.checkout.components.model.connection.OrderStatusResponse> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.adyen.checkout.components.repository.OrderStatusRepository$getOrderStatus$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.adyen.checkout.components.repository.OrderStatusRepository$getOrderStatus$1 r0 = (com.adyen.checkout.components.repository.OrderStatusRepository$getOrderStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.adyen.checkout.components.repository.OrderStatusRepository$getOrderStatus$1 r0 = new com.adyen.checkout.components.repository.OrderStatusRepository$getOrderStatus$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "Unable to get order status"
            r4 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r4) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            goto L_0x0069
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = TAG
            java.lang.String r2 = "Getting order status"
            com.adyen.checkout.core.log.Logger.d(r8, r2)
            com.adyen.checkout.components.model.connection.OrderStatusRequest r8 = new com.adyen.checkout.components.model.connection.OrderStatusRequest     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            r8.<init>(r7)     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            com.adyen.checkout.components.api.OrderStatusConnection r7 = new com.adyen.checkout.components.api.OrderStatusConnection     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            com.adyen.checkout.core.api.Environment r2 = r6.getEnvironment()     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            java.lang.String r6 = r6.getClientKey()     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            r7.<init>(r8, r2, r6)     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            com.adyen.checkout.core.api.Connection r7 = (com.adyen.checkout.core.api.Connection) r7     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            com.adyen.checkout.components.repository.OrderStatusRepository$getOrderStatus$$inlined$suspendedCall$1 r8 = new com.adyen.checkout.components.repository.OrderStatusRepository$getOrderStatus$$inlined$suspendedCall$1     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            r2 = 0
            r8.<init>(r7, r2)     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            r0.label = r4     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r6, r8, r0)     // Catch:{ IOException -> 0x007a, JSONException -> 0x006a }
            if (r8 != r1) goto L_0x0069
            return r1
        L_0x0069:
            return r8
        L_0x006a:
            r6 = move-exception
            java.lang.String r7 = TAG
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.String r8 = "OrderStatusConnection unexpected result"
            com.adyen.checkout.core.log.Logger.e(r7, r8, r6)
            com.adyen.checkout.core.exception.CheckoutException r6 = new com.adyen.checkout.core.exception.CheckoutException
            r6.<init>(r3)
            throw r6
        L_0x007a:
            r6 = move-exception
            java.lang.String r7 = TAG
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.String r8 = "OrderStatusConnection Failed"
            com.adyen.checkout.core.log.Logger.e(r7, r8, r6)
            com.adyen.checkout.core.exception.CheckoutException r6 = new com.adyen.checkout.core.exception.CheckoutException
            r6.<init>(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.components.repository.OrderStatusRepository.getOrderStatus(com.adyen.checkout.components.base.Configuration, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
