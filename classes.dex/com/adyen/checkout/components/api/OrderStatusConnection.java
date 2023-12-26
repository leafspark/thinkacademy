package com.adyen.checkout.components.api;

import com.adyen.checkout.components.model.connection.OrderStatusRequest;
import com.adyen.checkout.components.model.connection.OrderStatusResponse;
import com.adyen.checkout.core.api.Connection;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.log.Logger;
import com.adyen.checkout.core.model.JsonUtilsKt;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/adyen/checkout/components/api/OrderStatusConnection;", "Lcom/adyen/checkout/core/api/Connection;", "Lcom/adyen/checkout/components/model/connection/OrderStatusResponse;", "request", "Lcom/adyen/checkout/components/model/connection/OrderStatusRequest;", "environment", "Lcom/adyen/checkout/core/api/Environment;", "clientKey", "", "(Lcom/adyen/checkout/components/model/connection/OrderStatusRequest;Lcom/adyen/checkout/core/api/Environment;Ljava/lang/String;)V", "call", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: OrderStatusConnection.kt */
public final class OrderStatusConnection extends Connection<OrderStatusResponse> {
    private final OrderStatusRequest request;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderStatusConnection(OrderStatusRequest orderStatusRequest, Environment environment, String str) {
        super(environment.getBaseUrl() + "v1/order/status?clientKey=" + str);
        Intrinsics.checkNotNullParameter(orderStatusRequest, "request");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(str, "clientKey");
        this.request = orderStatusRequest;
    }

    public OrderStatusResponse call() throws IOException, JSONException {
        Logger.v(OrderStatusConnectionKt.TAG, Intrinsics.stringPlus("call - ", getUrl()));
        JSONObject serialize = OrderStatusRequest.Companion.getSERIALIZER().serialize(this.request);
        Intrinsics.checkNotNullExpressionValue(serialize, "OrderStatusRequest.SERIALIZER.serialize(request)");
        Logger.v(OrderStatusConnectionKt.TAG, Intrinsics.stringPlus("request - ", JsonUtilsKt.toStringPretty(serialize)));
        Map<String, String> map = Connection.CONTENT_TYPE_JSON_HEADER;
        String jSONObject = !(serialize instanceof JSONObject) ? serialize.toString() : JSONObjectInstrumentation.toString(serialize);
        Intrinsics.checkNotNullExpressionValue(jSONObject, "requestJson.toString()");
        byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] post = post(map, bytes);
        Intrinsics.checkNotNullExpressionValue(post, "post(CONTENT_TYPE_JSON_HEADER, requestJson.toString().toByteArray(Charsets.UTF_8))");
        JSONObject jSONObject2 = new JSONObject(new String(post, Charsets.UTF_8));
        Logger.v(OrderStatusConnectionKt.TAG, Intrinsics.stringPlus("response: ", JsonUtilsKt.toStringPretty(jSONObject2)));
        OrderStatusResponse deserialize = OrderStatusResponse.Companion.getSERIALIZER().deserialize(jSONObject2);
        Intrinsics.checkNotNullExpressionValue(deserialize, "OrderStatusResponse.SERIALIZER.deserialize(resultJson)");
        return deserialize;
    }
}
