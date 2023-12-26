package com.eaydu.omni.jwt;

import com.eaydu.omni.gson.JsonObject;
import java.util.Date;
import java.util.List;

public interface Claim {
    <T> T[] asArray(Class<T> cls) throws DecodeException;

    Boolean asBoolean();

    Date asDate();

    Double asDouble();

    Integer asInt();

    JsonObject asJsonObject();

    <T> List<T> asList(Class<T> cls) throws DecodeException;

    String asString();
}
