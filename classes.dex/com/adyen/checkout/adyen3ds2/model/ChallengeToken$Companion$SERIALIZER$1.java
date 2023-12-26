package com.adyen.checkout.adyen3ds2.model;

import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtilsKt;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/adyen/checkout/adyen3ds2/model/ChallengeToken$Companion$SERIALIZER$1", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "Lcom/adyen/checkout/adyen3ds2/model/ChallengeToken;", "deserialize", "jsonObject", "Lorg/json/JSONObject;", "serialize", "modelObject", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ChallengeToken.kt */
public final class ChallengeToken$Companion$SERIALIZER$1 implements ModelObject.Serializer<ChallengeToken> {
    ChallengeToken$Companion$SERIALIZER$1() {
    }

    public JSONObject serialize(ChallengeToken challengeToken) {
        Intrinsics.checkNotNullParameter(challengeToken, "modelObject");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("acsReferenceNumber", challengeToken.getAcsReferenceNumber());
            jSONObject.putOpt("acsSignedContent", challengeToken.getAcsSignedContent());
            jSONObject.putOpt("acsTransID", challengeToken.getAcsTransID());
            jSONObject.putOpt("acsURL", challengeToken.getAcsURL());
            jSONObject.putOpt("messageVersion", challengeToken.getMessageVersion());
            jSONObject.putOpt("threeDSServerTransID", challengeToken.getThreeDSServerTransID());
            return jSONObject;
        } catch (JSONException e) {
            throw new ModelSerializationException(ChallengeToken.class, e);
        }
    }

    public ChallengeToken deserialize(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        try {
            return new ChallengeToken(JsonUtilsKt.getStringOrNull(jSONObject, "acsReferenceNumber"), JsonUtilsKt.getStringOrNull(jSONObject, "acsSignedContent"), JsonUtilsKt.getStringOrNull(jSONObject, "acsTransID"), JsonUtilsKt.getStringOrNull(jSONObject, "acsURL"), JsonUtilsKt.getStringOrNull(jSONObject, "messageVersion"), JsonUtilsKt.getStringOrNull(jSONObject, "threeDSServerTransID"));
        } catch (JSONException e) {
            throw new ModelSerializationException(ChallengeToken.class, e);
        }
    }
}
