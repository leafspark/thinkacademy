package com.adyen.threeds2.internal;

import atd.f0.b;
import atd.f0.h;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import java.security.GeneralSecurityException;
import org.json.JSONException;
import org.json.JSONObject;

final class c {
    static h a(b bVar, JSONObject jSONObject) {
        try {
            return bVar.a().a((!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).getBytes(b.a));
        } catch (GeneralSecurityException | JSONException e) {
            throw atd.y.c.CRYPTO_FAILURE.a(e);
        }
    }
}
