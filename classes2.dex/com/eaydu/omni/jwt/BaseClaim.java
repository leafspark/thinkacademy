package com.eaydu.omni.jwt;

import com.eaydu.omni.gson.JsonObject;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Date;
import java.util.List;

class BaseClaim implements Claim {
    public Boolean asBoolean() {
        return null;
    }

    public Date asDate() {
        return null;
    }

    public Double asDouble() {
        return null;
    }

    public Integer asInt() {
        return null;
    }

    public JsonObject asJsonObject() {
        return null;
    }

    public String asString() {
        return null;
    }

    BaseClaim() {
    }

    public <T> T[] asArray(Class<T> cls) throws DecodeException {
        return (Object[]) Array.newInstance(cls, 0);
    }

    public <T> List<T> asList(Class<T> cls) throws DecodeException {
        return Collections.emptyList();
    }
}
