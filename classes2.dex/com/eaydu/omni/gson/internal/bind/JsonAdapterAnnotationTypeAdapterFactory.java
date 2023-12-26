package com.eaydu.omni.gson.internal.bind;

import com.eaydu.omni.gson.Gson;
import com.eaydu.omni.gson.TypeAdapter;
import com.eaydu.omni.gson.TypeAdapterFactory;
import com.eaydu.omni.gson.annotations.JsonAdapter;
import com.eaydu.omni.gson.internal.ConstructorConstructor;
import com.eaydu.omni.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor2) {
        this.constructorConstructor = constructorConstructor2;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: com.eaydu.omni.gson.TypeAdapter<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: com.eaydu.omni.gson.TypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.eaydu.omni.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: com.eaydu.omni.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: com.eaydu.omni.gson.internal.bind.TreeTypeAdapter} */
    /* JADX WARNING: type inference failed for: r9v3, types: [com.eaydu.omni.gson.TypeAdapter, com.eaydu.omni.gson.TypeAdapter<?>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.eaydu.omni.gson.TypeAdapter<?> getTypeAdapter(com.eaydu.omni.gson.internal.ConstructorConstructor r9, com.eaydu.omni.gson.Gson r10, com.eaydu.omni.gson.reflect.TypeToken<?> r11, com.eaydu.omni.gson.annotations.JsonAdapter r12) {
        /*
            r8 = this;
            java.lang.Class r0 = r12.value()
            com.eaydu.omni.gson.reflect.TypeToken r0 = com.eaydu.omni.gson.reflect.TypeToken.get(r0)
            com.eaydu.omni.gson.internal.ObjectConstructor r9 = r9.get(r0)
            java.lang.Object r9 = r9.construct()
            boolean r0 = r9 instanceof com.eaydu.omni.gson.TypeAdapter
            if (r0 == 0) goto L_0x0017
            com.eaydu.omni.gson.TypeAdapter r9 = (com.eaydu.omni.gson.TypeAdapter) r9
            goto L_0x0075
        L_0x0017:
            boolean r0 = r9 instanceof com.eaydu.omni.gson.TypeAdapterFactory
            if (r0 == 0) goto L_0x0022
            com.eaydu.omni.gson.TypeAdapterFactory r9 = (com.eaydu.omni.gson.TypeAdapterFactory) r9
            com.eaydu.omni.gson.TypeAdapter r9 = r9.create(r10, r11)
            goto L_0x0075
        L_0x0022:
            boolean r0 = r9 instanceof com.eaydu.omni.gson.JsonSerializer
            if (r0 != 0) goto L_0x005b
            boolean r1 = r9 instanceof com.eaydu.omni.gson.JsonDeserializer
            if (r1 == 0) goto L_0x002b
            goto L_0x005b
        L_0x002b:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Invalid attempt to bind an instance of "
            r12.append(r0)
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
        L_0x005b:
            r1 = 0
            if (r0 == 0) goto L_0x0063
            r0 = r9
            com.eaydu.omni.gson.JsonSerializer r0 = (com.eaydu.omni.gson.JsonSerializer) r0
            r3 = r0
            goto L_0x0064
        L_0x0063:
            r3 = r1
        L_0x0064:
            boolean r0 = r9 instanceof com.eaydu.omni.gson.JsonDeserializer
            if (r0 == 0) goto L_0x006b
            r1 = r9
            com.eaydu.omni.gson.JsonDeserializer r1 = (com.eaydu.omni.gson.JsonDeserializer) r1
        L_0x006b:
            r4 = r1
            com.eaydu.omni.gson.internal.bind.TreeTypeAdapter r9 = new com.eaydu.omni.gson.internal.bind.TreeTypeAdapter
            r7 = 0
            r2 = r9
            r5 = r10
            r6 = r11
            r2.<init>(r3, r4, r5, r6, r7)
        L_0x0075:
            if (r9 == 0) goto L_0x0081
            boolean r10 = r12.nullSafe()
            if (r10 == 0) goto L_0x0081
            com.eaydu.omni.gson.TypeAdapter r9 = r9.nullSafe()
        L_0x0081:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(com.eaydu.omni.gson.internal.ConstructorConstructor, com.eaydu.omni.gson.Gson, com.eaydu.omni.gson.reflect.TypeToken, com.eaydu.omni.gson.annotations.JsonAdapter):com.eaydu.omni.gson.TypeAdapter");
    }
}
