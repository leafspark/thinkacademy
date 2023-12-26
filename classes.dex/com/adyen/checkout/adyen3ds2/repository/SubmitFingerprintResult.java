package com.adyen.checkout.adyen3ds2.repository;

import com.adyen.checkout.components.model.payments.response.RedirectAction;
import com.adyen.checkout.components.model.payments.response.Threeds2Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintResult;", "", "()V", "Completed", "Redirect", "Threeds2", "Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintResult$Completed;", "Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintResult$Redirect;", "Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintResult$Threeds2;", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SubmitFingerprintResult.kt */
public abstract class SubmitFingerprintResult {
    public /* synthetic */ SubmitFingerprintResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintResult$Completed;", "Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintResult;", "details", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getDetails", "()Lorg/json/JSONObject;", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: SubmitFingerprintResult.kt */
    public static final class Completed extends SubmitFingerprintResult {
        private final JSONObject details;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Completed(JSONObject jSONObject) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(jSONObject, "details");
            this.details = jSONObject;
        }

        public final JSONObject getDetails() {
            return this.details;
        }
    }

    private SubmitFingerprintResult() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintResult$Redirect;", "Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintResult;", "action", "Lcom/adyen/checkout/components/model/payments/response/RedirectAction;", "(Lcom/adyen/checkout/components/model/payments/response/RedirectAction;)V", "getAction", "()Lcom/adyen/checkout/components/model/payments/response/RedirectAction;", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: SubmitFingerprintResult.kt */
    public static final class Redirect extends SubmitFingerprintResult {
        private final RedirectAction action;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Redirect(RedirectAction redirectAction) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(redirectAction, "action");
            this.action = redirectAction;
        }

        public final RedirectAction getAction() {
            return this.action;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintResult$Threeds2;", "Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintResult;", "action", "Lcom/adyen/checkout/components/model/payments/response/Threeds2Action;", "(Lcom/adyen/checkout/components/model/payments/response/Threeds2Action;)V", "getAction", "()Lcom/adyen/checkout/components/model/payments/response/Threeds2Action;", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: SubmitFingerprintResult.kt */
    public static final class Threeds2 extends SubmitFingerprintResult {
        private final Threeds2Action action;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Threeds2(Threeds2Action threeds2Action) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(threeds2Action, "action");
            this.action = threeds2Action;
        }

        public final Threeds2Action getAction() {
            return this.action;
        }
    }
}
