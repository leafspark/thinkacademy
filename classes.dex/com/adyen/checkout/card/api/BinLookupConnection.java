package com.adyen.checkout.card.api;

import com.adyen.checkout.card.api.model.BinLookupRequest;
import com.adyen.checkout.card.api.model.BinLookupResponse;
import com.adyen.checkout.core.api.Connection;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.log.Logger;
import com.adyen.checkout.core.model.JsonUtilsKt;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/adyen/checkout/card/api/BinLookupConnection;", "Lcom/adyen/checkout/core/api/Connection;", "Lcom/adyen/checkout/card/api/model/BinLookupResponse;", "request", "Lcom/adyen/checkout/card/api/model/BinLookupRequest;", "environment", "Lcom/adyen/checkout/core/api/Environment;", "clientKey", "", "(Lcom/adyen/checkout/card/api/model/BinLookupRequest;Lcom/adyen/checkout/core/api/Environment;Ljava/lang/String;)V", "call", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BinLookupConnection.kt */
public final class BinLookupConnection extends Connection<BinLookupResponse> {
    private final BinLookupRequest request;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BinLookupConnection(BinLookupRequest binLookupRequest, Environment environment, String str) {
        super(environment.getBaseUrl() + "v2/bin/binLookup?clientKey=" + str);
        Intrinsics.checkNotNullParameter(binLookupRequest, "request");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(str, "clientKey");
        this.request = binLookupRequest;
    }

    public BinLookupResponse call() {
        Logger.v(BinLookupConnectionKt.TAG, Intrinsics.stringPlus("call - ", getUrl()));
        String access$getTAG$p = BinLookupConnectionKt.TAG;
        JSONObject serialize = BinLookupRequest.Companion.getSERIALIZER().serialize(this.request);
        Intrinsics.checkNotNullExpressionValue(serialize, "BinLookupRequest.SERIALIZER.serialize(request)");
        Logger.v(access$getTAG$p, Intrinsics.stringPlus("request - ", JsonUtilsKt.toStringPretty(serialize)));
        JSONObject serialize2 = BinLookupRequest.Companion.getSERIALIZER().serialize(this.request);
        String jSONObject = !(serialize2 instanceof JSONObject) ? serialize2.toString() : JSONObjectInstrumentation.toString(serialize2);
        Intrinsics.checkNotNullExpressionValue(jSONObject, "BinLookupRequest.SERIALIZER.serialize(request).toString()");
        Map<String, String> map = Connection.CONTENT_TYPE_JSON_HEADER;
        byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] post = post(map, bytes);
        Intrinsics.checkNotNullExpressionValue(post, "post(CONTENT_TYPE_JSON_HEADER, requestString.toByteArray(Charsets.UTF_8))");
        JSONObject jSONObject2 = new JSONObject(new String(post, Charsets.UTF_8));
        Logger.v(BinLookupConnectionKt.TAG, Intrinsics.stringPlus("response: ", JsonUtilsKt.toStringPretty(jSONObject2)));
        BinLookupResponse deserialize = BinLookupResponse.Companion.getSERIALIZER().deserialize(jSONObject2);
        Intrinsics.checkNotNullExpressionValue(deserialize, "BinLookupResponse.SERIALIZER.deserialize(resultJson)");
        return deserialize;
    }
}
