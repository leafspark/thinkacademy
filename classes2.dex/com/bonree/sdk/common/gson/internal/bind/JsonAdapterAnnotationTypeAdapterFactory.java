package com.bonree.sdk.common.gson.internal.bind;

import com.bonree.sdk.common.gson.Gson;
import com.bonree.sdk.common.gson.TypeAdapter;
import com.bonree.sdk.common.gson.TypeAdapterFactory;
import com.bonree.sdk.common.gson.annotations.JsonAdapter;
import com.bonree.sdk.common.gson.internal.ConstructorConstructor;
import com.bonree.sdk.common.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor2) {
        this.constructorConstructor = constructorConstructor2;
    }

    public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: com.bonree.sdk.common.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: com.bonree.sdk.common.gson.TypeAdapter<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: com.bonree.sdk.common.gson.TypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.bonree.sdk.common.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: com.bonree.sdk.common.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: com.bonree.sdk.common.gson.internal.bind.TreeTypeAdapter} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bonree.sdk.common.gson.TypeAdapter<?> getTypeAdapter(com.bonree.sdk.common.gson.internal.ConstructorConstructor r9, com.bonree.sdk.common.gson.Gson r10, com.bonree.sdk.common.gson.reflect.TypeToken<?> r11, com.bonree.sdk.common.gson.annotations.JsonAdapter r12) {
        /*
            r8 = this;
            java.lang.Class r0 = r12.value()
            com.bonree.sdk.common.gson.reflect.TypeToken r0 = com.bonree.sdk.common.gson.reflect.TypeToken.get(r0)
            com.bonree.sdk.common.gson.internal.ObjectConstructor r9 = r9.get(r0)
            java.lang.Object r9 = r9.construct()
            boolean r0 = r9 instanceof com.bonree.sdk.common.gson.TypeAdapter
            if (r0 == 0) goto L_0x0017
            com.bonree.sdk.common.gson.TypeAdapter r9 = (com.bonree.sdk.common.gson.TypeAdapter) r9
            goto L_0x0072
        L_0x0017:
            boolean r0 = r9 instanceof com.bonree.sdk.common.gson.TypeAdapterFactory
            if (r0 == 0) goto L_0x0022
            com.bonree.sdk.common.gson.TypeAdapterFactory r9 = (com.bonree.sdk.common.gson.TypeAdapterFactory) r9
            com.bonree.sdk.common.gson.TypeAdapter r9 = r9.create(r10, r11)
            goto L_0x0072
        L_0x0022:
            boolean r0 = r9 instanceof com.bonree.sdk.common.gson.JsonSerializer
            if (r0 != 0) goto L_0x0058
            boolean r1 = r9 instanceof com.bonree.sdk.common.gson.JsonDeserializer
            if (r1 == 0) goto L_0x002b
            goto L_0x0058
        L_0x002b:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid attempt to bind an instance of "
            r12.<init>(r0)
            java.lang.Class r9 = r9.getClass()
            java.lang.String r9 = r9.getName()
            r12.append(r9)
            java.lang.String r9 = " as a @JsonAdapter for "
            r12.append(r9)
            java.lang.String r9 = r11.toString()
            r12.append(r9)
            java.lang.String r9 = ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer."
            r12.append(r9)
            java.lang.String r9 = r12.toString()
            r10.<init>(r9)
            throw r10
        L_0x0058:
            r1 = 0
            if (r0 == 0) goto L_0x0060
            r0 = r9
            com.bonree.sdk.common.gson.JsonSerializer r0 = (com.bonree.sdk.common.gson.JsonSerializer) r0
            r3 = r0
            goto L_0x0061
        L_0x0060:
            r3 = r1
        L_0x0061:
            boolean r0 = r9 instanceof com.bonree.sdk.common.gson.JsonDeserializer
            if (r0 == 0) goto L_0x0068
            r1 = r9
            com.bonree.sdk.common.gson.JsonDeserializer r1 = (com.bonree.sdk.common.gson.JsonDeserializer) r1
        L_0x0068:
            r4 = r1
            com.bonree.sdk.common.gson.internal.bind.TreeTypeAdapter r9 = new com.bonree.sdk.common.gson.internal.bind.TreeTypeAdapter
            r7 = 0
            r2 = r9
            r5 = r10
            r6 = r11
            r2.<init>(r3, r4, r5, r6, r7)
        L_0x0072:
            if (r9 == 0) goto L_0x007e
            boolean r10 = r12.nullSafe()
            if (r10 == 0) goto L_0x007e
            com.bonree.sdk.common.gson.TypeAdapter r9 = r9.nullSafe()
        L_0x007e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.common.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(com.bonree.sdk.common.gson.internal.ConstructorConstructor, com.bonree.sdk.common.gson.Gson, com.bonree.sdk.common.gson.reflect.TypeToken, com.bonree.sdk.common.gson.annotations.JsonAdapter):com.bonree.sdk.common.gson.TypeAdapter");
    }
}
