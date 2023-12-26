package com.adyen.checkout.card.api.model;

import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.JsonUtilsKt;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/adyen/checkout/card/api/model/BinLookupRequest$Companion$SERIALIZER$1", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "Lcom/adyen/checkout/card/api/model/BinLookupRequest;", "deserialize", "jsonObject", "Lorg/json/JSONObject;", "serialize", "modelObject", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BinLookupRequest.kt */
public final class BinLookupRequest$Companion$SERIALIZER$1 implements ModelObject.Serializer<BinLookupRequest> {
    BinLookupRequest$Companion$SERIALIZER$1() {
    }

    public JSONObject serialize(BinLookupRequest binLookupRequest) {
        Intrinsics.checkNotNullParameter(binLookupRequest, "modelObject");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("encryptedBin", binLookupRequest.getEncryptedBin());
            jSONObject.putOpt("requestId", binLookupRequest.getRequestId());
            jSONObject.putOpt("supportedBrands", JsonUtils.serializeOptStringList(binLookupRequest.getSupportedBrands()));
            return jSONObject;
        } catch (JSONException e) {
            throw new ModelSerializationException(BinLookupRequest.class, e);
        }
    }

    public BinLookupRequest deserialize(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        try {
            return new BinLookupRequest(JsonUtilsKt.getStringOrNull(jSONObject, "encryptedBin"), JsonUtilsKt.getStringOrNull(jSONObject, "requestId"), JsonUtilsKt.optStringList(jSONObject, "supportedBrands"));
        } catch (JSONException e) {
            throw new ModelSerializationException(BinLookupRequest.class, e);
        }
    }
}
