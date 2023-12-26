package com.bonree.sdk.common.gson;

import com.bonree.sdk.common.gson.reflect.TypeToken;

public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}
