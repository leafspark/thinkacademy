package com.adyen.checkout.adyen3ds2.repository;

import com.adyen.checkout.core.log.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintRepository;", "", "()V", "submitFingerprint", "Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintResult;", "encodedFingerprint", "", "configuration", "Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration;", "paymentData", "(Ljava/lang/String;Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SubmitFingerprintRepository.kt */
public final class SubmitFingerprintRepository {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String RESPONSE_TYPE_ACTION = "action";
    private static final String RESPONSE_TYPE_COMPLETED = "completed";
    private static final String TAG;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintRepository$Companion;", "", "()V", "RESPONSE_TYPE_ACTION", "", "RESPONSE_TYPE_COMPLETED", "TAG", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: SubmitFingerprintRepository.kt */
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

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object submitFingerprint(java.lang.String r5, com.adyen.checkout.adyen3ds2.Adyen3DS2Configuration r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository$submitFingerprint$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository$submitFingerprint$1 r0 = (com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository$submitFingerprint$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository$submitFingerprint$1 r0 = new com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository$submitFingerprint$1
            r0.<init>(r4, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0067
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = TAG
            java.lang.String r2 = "Submitting fingerprint automatically"
            com.adyen.checkout.core.log.Logger.d(r8, r2)
            com.adyen.checkout.adyen3ds2.model.SubmitFingerprintRequest r8 = new com.adyen.checkout.adyen3ds2.model.SubmitFingerprintRequest
            r8.<init>(r5, r7)
            com.adyen.checkout.adyen3ds2.connection.SubmitFingerprintConnection r5 = new com.adyen.checkout.adyen3ds2.connection.SubmitFingerprintConnection
            com.adyen.checkout.core.api.Environment r7 = r6.getEnvironment()
            java.lang.String r6 = r6.getClientKey()
            r5.<init>(r8, r7, r6)
            com.adyen.checkout.core.api.Connection r5 = (com.adyen.checkout.core.api.Connection) r5
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository$submitFingerprint$$inlined$suspendedCall$1 r7 = new com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository$submitFingerprint$$inlined$suspendedCall$1
            r8 = 0
            r7.<init>(r5, r8)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r6, r7, r0)
            if (r8 != r1) goto L_0x0067
            return r1
        L_0x0067:
            com.adyen.checkout.adyen3ds2.model.SubmitFingerprintResponse r8 = (com.adyen.checkout.adyen3ds2.model.SubmitFingerprintResponse) r8
            java.lang.String r5 = r8.getType()
            java.lang.String r6 = "completed"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L_0x0093
            java.lang.String r5 = r8.getDetails()
            if (r5 == 0) goto L_0x0093
            java.lang.String r5 = TAG
            java.lang.String r6 = "submitFingerprint: challenge completed"
            com.adyen.checkout.core.log.Logger.d(r5, r6)
            com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult$Completed r5 = new com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult$Completed
            org.json.JSONObject r6 = new org.json.JSONObject
            java.lang.String r7 = r8.getDetails()
            r6.<init>(r7)
            r5.<init>(r6)
            com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult r5 = (com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult) r5
            goto L_0x00e2
        L_0x0093:
            java.lang.String r5 = r8.getType()
            java.lang.String r6 = "action"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L_0x00bc
            com.adyen.checkout.components.model.payments.response.Action r5 = r8.getAction()
            boolean r5 = r5 instanceof com.adyen.checkout.components.model.payments.response.RedirectAction
            if (r5 == 0) goto L_0x00bc
            java.lang.String r5 = TAG
            java.lang.String r6 = "submitFingerprint: received new RedirectAction"
            com.adyen.checkout.core.log.Logger.d(r5, r6)
            com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult$Redirect r5 = new com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult$Redirect
            com.adyen.checkout.components.model.payments.response.Action r6 = r8.getAction()
            com.adyen.checkout.components.model.payments.response.RedirectAction r6 = (com.adyen.checkout.components.model.payments.response.RedirectAction) r6
            r5.<init>(r6)
            com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult r5 = (com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult) r5
            goto L_0x00e2
        L_0x00bc:
            java.lang.String r5 = r8.getType()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L_0x00e3
            com.adyen.checkout.components.model.payments.response.Action r5 = r8.getAction()
            boolean r5 = r5 instanceof com.adyen.checkout.components.model.payments.response.Threeds2Action
            if (r5 == 0) goto L_0x00e3
            java.lang.String r5 = TAG
            java.lang.String r6 = "submitFingerprint: received new Threeds2Action"
            com.adyen.checkout.core.log.Logger.d(r5, r6)
            com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult$Threeds2 r5 = new com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult$Threeds2
            com.adyen.checkout.components.model.payments.response.Action r6 = r8.getAction()
            com.adyen.checkout.components.model.payments.response.Threeds2Action r6 = (com.adyen.checkout.components.model.payments.response.Threeds2Action) r6
            r5.<init>(r6)
            com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult r5 = (com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult) r5
        L_0x00e2:
            return r5
        L_0x00e3:
            java.lang.String r5 = TAG
            java.lang.String r6 = "submitFingerprint: unexpected response "
            java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r8)
            com.adyen.checkout.core.log.Logger.e(r5, r6)
            com.adyen.checkout.core.exception.ComponentException r5 = new com.adyen.checkout.core.exception.ComponentException
            java.lang.String r6 = "Failed to retrieve 3DS2 fingerprint result"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository.submitFingerprint(java.lang.String, com.adyen.checkout.adyen3ds2.Adyen3DS2Configuration, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
