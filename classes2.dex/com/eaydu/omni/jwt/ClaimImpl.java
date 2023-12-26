package com.eaydu.omni.jwt;

import com.eaydu.omni.gson.Gson;
import com.eaydu.omni.gson.JsonArray;
import com.eaydu.omni.gson.JsonElement;
import com.eaydu.omni.gson.JsonObject;
import com.eaydu.omni.gson.JsonSyntaxException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class ClaimImpl extends BaseClaim {
    private final JsonElement value;

    ClaimImpl(JsonElement jsonElement) {
        this.value = jsonElement;
    }

    public Boolean asBoolean() {
        if (!this.value.isJsonPrimitive()) {
            return null;
        }
        return Boolean.valueOf(this.value.getAsBoolean());
    }

    public Integer asInt() {
        if (!this.value.isJsonPrimitive()) {
            return null;
        }
        return Integer.valueOf(this.value.getAsInt());
    }

    public Double asDouble() {
        if (!this.value.isJsonPrimitive()) {
            return null;
        }
        return Double.valueOf(this.value.getAsDouble());
    }

    public String asString() {
        if (!this.value.isJsonPrimitive()) {
            return null;
        }
        return this.value.getAsString();
    }

    public Date asDate() {
        if (!this.value.isJsonPrimitive()) {
            return null;
        }
        return new Date(Long.parseLong(this.value.getAsString()) * 1000);
    }

    public JsonObject asJsonObject() {
        if (!this.value.isJsonObject()) {
            return null;
        }
        return this.value.getAsJsonObject();
    }

    public <T> T[] asArray(Class<T> cls) throws DecodeException {
        try {
            if (this.value.isJsonArray()) {
                if (!this.value.isJsonNull()) {
                    Gson gson = new Gson();
                    JsonArray asJsonArray = this.value.getAsJsonArray();
                    T[] tArr = (Object[]) Array.newInstance(cls, asJsonArray.size());
                    for (int i = 0; i < asJsonArray.size(); i++) {
                        tArr[i] = gson.fromJson(asJsonArray.get(i), cls);
                    }
                    return tArr;
                }
            }
            return (Object[]) Array.newInstance(cls, 0);
        } catch (JsonSyntaxException e) {
            throw new DecodeException("Failed to decode claim as array", e);
        }
    }

    public <T> List<T> asList(Class<T> cls) throws DecodeException {
        try {
            if (this.value.isJsonArray()) {
                if (!this.value.isJsonNull()) {
                    Gson gson = new Gson();
                    JsonArray asJsonArray = this.value.getAsJsonArray();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < asJsonArray.size(); i++) {
                        arrayList.add(gson.fromJson(asJsonArray.get(i), cls));
                    }
                    return arrayList;
                }
            }
            return new ArrayList();
        } catch (JsonSyntaxException e) {
            throw new DecodeException("Failed to decode claim as list", e);
        }
    }
}
