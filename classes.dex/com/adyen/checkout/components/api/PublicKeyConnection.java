package com.adyen.checkout.components.api;

import com.adyen.checkout.core.api.Connection;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.log.Logger;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/adyen/checkout/components/api/PublicKeyConnection;", "Lcom/adyen/checkout/core/api/Connection;", "", "environment", "Lcom/adyen/checkout/core/api/Environment;", "clientKey", "(Lcom/adyen/checkout/core/api/Environment;Ljava/lang/String;)V", "call", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PublicKeyConnection.kt */
public final class PublicKeyConnection extends Connection<String> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublicKeyConnection(Environment environment, String str) {
        super(environment.getBaseUrl() + "v1/clientKeys/" + str);
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(str, "clientKey");
    }

    public String call() throws IOException, JSONException {
        Logger.v(PublicKeyConnectionKt.TAG, Intrinsics.stringPlus("call - ", getUrl()));
        byte[] bArr = get();
        Intrinsics.checkNotNullExpressionValue(bArr, "get()");
        String str = new String(bArr, Charsets.UTF_8);
        JSONObject jSONObject = new JSONObject(str);
        Logger.v(PublicKeyConnectionKt.TAG, Intrinsics.stringPlus("result: ", str));
        String string = jSONObject.getString("publicKey");
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(PUBLIC_KEY_JSON_KEY)");
        return string;
    }
}
