package com.eaydu.omni.jwt;

import com.eaydu.omni.gson.JsonArray;
import com.eaydu.omni.gson.JsonDeserializationContext;
import com.eaydu.omni.gson.JsonDeserializer;
import com.eaydu.omni.gson.JsonElement;
import com.eaydu.omni.gson.JsonObject;
import com.eaydu.omni.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class JWTDeserializer implements JsonDeserializer<JWTPayload> {
    JWTDeserializer() {
    }

    public JWTPayload deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.isJsonNull() || !jsonElement.isJsonObject()) {
            throw new DecodeException("The token's payload had an invalid JSON format.");
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        String string = getString(asJsonObject, "iss");
        String string2 = getString(asJsonObject, "sub");
        Date date = getDate(asJsonObject, "exp");
        Date date2 = getDate(asJsonObject, "nbf");
        Date date3 = getDate(asJsonObject, "iat");
        String string3 = getString(asJsonObject, "jti");
        List<String> stringOrArray = getStringOrArray(asJsonObject, "aud");
        HashMap hashMap = new HashMap();
        for (Map.Entry next : asJsonObject.entrySet()) {
            hashMap.put((String) next.getKey(), new ClaimImpl((JsonElement) next.getValue()));
        }
        return new JWTPayload(string, string2, date, date2, date3, string3, stringOrArray, hashMap);
    }

    private List<String> getStringOrArray(JsonObject jsonObject, String str) {
        List<String> emptyList = Collections.emptyList();
        if (!jsonObject.has(str)) {
            return emptyList;
        }
        JsonElement jsonElement = jsonObject.get(str);
        if (!jsonElement.isJsonArray()) {
            return Collections.singletonList(jsonElement.getAsString());
        }
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        ArrayList arrayList = new ArrayList(asJsonArray.size());
        for (int i = 0; i < asJsonArray.size(); i++) {
            arrayList.add(asJsonArray.get(i).getAsString());
        }
        return arrayList;
    }

    private Date getDate(JsonObject jsonObject, String str) {
        if (!jsonObject.has(str)) {
            return null;
        }
        return new Date(jsonObject.get(str).getAsLong() * 1000);
    }

    private String getString(JsonObject jsonObject, String str) {
        if (!jsonObject.has(str)) {
            return null;
        }
        return jsonObject.get(str).getAsString();
    }
}
