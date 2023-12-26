package com.adyen.checkout.adyen3ds2;

import com.adyen.checkout.adyen3ds2.model.ChallengeResult;
import com.adyen.checkout.core.exception.ComponentException;
import com.adyen.threeds2.CompletionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t¨\u0006\r"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Serializer;", "", "()V", "createChallengeDetails", "Lorg/json/JSONObject;", "completionEvent", "Lcom/adyen/threeds2/CompletionEvent;", "createFingerprintDetails", "encodedFingerprint", "", "createThreeDsResultDetails", "authorisationToken", "Companion", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Adyen3DS2Serializer.kt */
public final class Adyen3DS2Serializer {
    private static final String CHALLENGE_DETAILS_KEY = "threeds2.challengeResult";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FINGERPRINT_DETAILS_KEY = "threeds2.fingerprint";
    private static final String THREEDS_RESULT_KEY = "threeDSResult";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Serializer$Companion;", "", "()V", "CHALLENGE_DETAILS_KEY", "", "FINGERPRINT_DETAILS_KEY", "THREEDS_RESULT_KEY", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Adyen3DS2Serializer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final JSONObject createFingerprintDetails(String str) throws ComponentException {
        Intrinsics.checkNotNullParameter(str, "encodedFingerprint");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FINGERPRINT_DETAILS_KEY, str);
            return jSONObject;
        } catch (JSONException e) {
            throw new ComponentException("Failed to create fingerprint details", e);
        }
    }

    public final JSONObject createChallengeDetails(CompletionEvent completionEvent) throws ComponentException {
        Intrinsics.checkNotNullParameter(completionEvent, "completionEvent");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CHALLENGE_DETAILS_KEY, ChallengeResult.Companion.from$default(ChallengeResult.Companion, completionEvent, (String) null, 2, (Object) null).getPayload());
            return jSONObject;
        } catch (JSONException e) {
            throw new ComponentException("Failed to create challenge details", e);
        }
    }

    public final JSONObject createThreeDsResultDetails(CompletionEvent completionEvent, String str) throws ComponentException {
        Intrinsics.checkNotNullParameter(completionEvent, "completionEvent");
        Intrinsics.checkNotNullParameter(str, "authorisationToken");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(THREEDS_RESULT_KEY, ChallengeResult.Companion.from(completionEvent, str).getPayload());
            return jSONObject;
        } catch (JSONException e) {
            throw new ComponentException("Failed to create ThreeDS Result details", e);
        }
    }
}
