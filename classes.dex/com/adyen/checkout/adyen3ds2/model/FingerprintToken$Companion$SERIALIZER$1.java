package com.adyen.checkout.adyen3ds2.model;

import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtilsKt;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/adyen/checkout/adyen3ds2/model/FingerprintToken$Companion$SERIALIZER$1", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "Lcom/adyen/checkout/adyen3ds2/model/FingerprintToken;", "deserialize", "jsonObject", "Lorg/json/JSONObject;", "serialize", "modelObject", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FingerprintToken.kt */
public final class FingerprintToken$Companion$SERIALIZER$1 implements ModelObject.Serializer<FingerprintToken> {
    FingerprintToken$Companion$SERIALIZER$1() {
    }

    public JSONObject serialize(FingerprintToken fingerprintToken) {
        Intrinsics.checkNotNullParameter(fingerprintToken, "modelObject");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("directoryServerId", fingerprintToken.getDirectoryServerId());
            jSONObject.putOpt("directoryServerPublicKey", fingerprintToken.getDirectoryServerPublicKey());
            jSONObject.putOpt("threeDSServerTransID", fingerprintToken.getThreeDSServerTransID());
            jSONObject.putOpt("threeDSMessageVersion", fingerprintToken.getThreeDSMessageVersion());
            return jSONObject;
        } catch (JSONException e) {
            throw new ModelSerializationException(FingerprintToken.class, e);
        }
    }

    public FingerprintToken deserialize(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        try {
            return new FingerprintToken(JsonUtilsKt.getStringOrNull(jSONObject, "directoryServerId"), JsonUtilsKt.getStringOrNull(jSONObject, "directoryServerPublicKey"), JsonUtilsKt.getStringOrNull(jSONObject, "threeDSServerTransID"), JsonUtilsKt.getStringOrNull(jSONObject, "threeDSMessageVersion"));
        } catch (JSONException e) {
            throw new ModelSerializationException(FingerprintToken.class, e);
        }
    }
}
