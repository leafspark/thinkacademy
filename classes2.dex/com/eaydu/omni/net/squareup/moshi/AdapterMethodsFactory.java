package com.eaydu.omni.net.squareup.moshi;

import com.eaydu.omni.net.squareup.moshi.JsonAdapter;
import com.eaydu.omni.net.squareup.moshi.JsonReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

final class AdapterMethodsFactory implements JsonAdapter.Factory {
    private final List<AdapterMethod> fromAdapters;
    private final List<AdapterMethod> toAdapters;

    public AdapterMethodsFactory(List<AdapterMethod> list, List<AdapterMethod> list2) {
        this.toAdapters = list;
        this.fromAdapters = list2;
    }

    public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
        final AdapterMethod adapterMethod = get(this.toAdapters, type, set);
        final AdapterMethod adapterMethod2 = get(this.fromAdapters, type, set);
        JsonAdapter<T> jsonAdapter = null;
        if (adapterMethod == null && adapterMethod2 == null) {
            return null;
        }
        if (adapterMethod == null || adapterMethod2 == null) {
            try {
                jsonAdapter = moshi.nextAdapter(this, type, set);
            } catch (IllegalArgumentException unused) {
                String str = adapterMethod == null ? "@ToJson" : "@FromJson";
                throw new IllegalArgumentException("No " + str + " adapter for " + type + " annotated " + set);
            }
        }
        final JsonAdapter<T> jsonAdapter2 = jsonAdapter;
        final Moshi moshi2 = moshi;
        final Set<? extends Annotation> set2 = set;
        final Type type2 = type;
        return new JsonAdapter<Object>() {
            public void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
                AdapterMethod adapterMethod = adapterMethod;
                if (adapterMethod == null) {
                    jsonAdapter2.toJson(jsonWriter, obj);
                } else if (adapterMethod.nullable || obj != null) {
                    try {
                        adapterMethod.toJson(moshi2, jsonWriter, obj);
                    } catch (IllegalAccessException unused) {
                        throw new AssertionError();
                    } catch (InvocationTargetException e) {
                        if (e.getCause() instanceof IOException) {
                            throw ((IOException) e.getCause());
                        }
                        throw new JsonDataException(e.getCause() + " at " + jsonWriter.getPath());
                    }
                } else {
                    jsonWriter.nullValue();
                }
            }

            public Object fromJson(JsonReader jsonReader) throws IOException {
                AdapterMethod adapterMethod = adapterMethod2;
                if (adapterMethod == null) {
                    return jsonAdapter2.fromJson(jsonReader);
                }
                if (adapterMethod.nullable || jsonReader.peek() != JsonReader.Token.NULL) {
                    try {
                        return adapterMethod2.fromJson(moshi2, jsonReader);
                    } catch (IllegalAccessException unused) {
                        throw new AssertionError();
                    } catch (InvocationTargetException e) {
                        if (e.getCause() instanceof IOException) {
                            throw ((IOException) e.getCause());
                        }
                        throw new JsonDataException(e.getCause() + " at " + jsonReader.getPath());
                    }
                } else {
                    jsonReader.nextNull();
                    return null;
                }
            }

            public String toString() {
                return "JsonAdapter" + set2 + "(" + type2 + ")";
            }
        };
    }

    public static AdapterMethodsFactory get(Object obj) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Class cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ToJson.class)) {
                    AdapterMethod adapter = toAdapter(obj, method);
                    AdapterMethod adapterMethod = get(arrayList, adapter.type, adapter.annotations);
                    if (adapterMethod == null) {
                        arrayList.add(adapter);
                    } else {
                        throw new IllegalArgumentException("Conflicting @ToJson methods:\n    " + adapterMethod.method + "\n    " + adapter.method);
                    }
                }
                if (method.isAnnotationPresent(FromJson.class)) {
                    AdapterMethod fromAdapter = fromAdapter(obj, method);
                    AdapterMethod adapterMethod2 = get(arrayList2, fromAdapter.type, fromAdapter.annotations);
                    if (adapterMethod2 == null) {
                        arrayList2.add(fromAdapter);
                    } else {
                        throw new IllegalArgumentException("Conflicting @FromJson methods:\n    " + adapterMethod2.method + "\n    " + fromAdapter.method);
                    }
                }
            }
        }
        if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
            return new AdapterMethodsFactory(arrayList, arrayList2);
        }
        throw new IllegalArgumentException("Expected at least one @ToJson or @FromJson method on " + obj.getClass().getName());
    }

    static AdapterMethod toAdapter(Object obj, Method method) {
        method.setAccessible(true);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        final Type genericReturnType = method.getGenericReturnType();
        if (genericParameterTypes.length == 2 && genericParameterTypes[0] == JsonWriter.class && genericReturnType == Void.TYPE) {
            return new AdapterMethod(genericParameterTypes[1], Util.jsonAnnotations(method.getParameterAnnotations()[1]), obj, method, false) {
                public void toJson(Moshi moshi, JsonWriter jsonWriter, Object obj) throws IOException, InvocationTargetException, IllegalAccessException {
                    this.method.invoke(this.adapter, new Object[]{jsonWriter, obj});
                }
            };
        } else if (genericParameterTypes.length != 1 || genericReturnType == Void.TYPE) {
            throw new IllegalArgumentException("Unexpected signature for " + method + ".\n@ToJson method signatures may have one of the following structures:\n    <any access modifier> void toJson(JsonWriter writer, T value) throws <any>;\n    <any access modifier> R toJson(T value) throws <any>;\n");
        } else {
            final Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations((AnnotatedElement) method);
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            return new AdapterMethod(genericParameterTypes[0], Util.jsonAnnotations(parameterAnnotations[0]), obj, method, Util.hasNullable(parameterAnnotations[0])) {
                public void toJson(Moshi moshi, JsonWriter jsonWriter, Object obj) throws IOException, InvocationTargetException, IllegalAccessException {
                    moshi.adapter(genericReturnType, jsonAnnotations).toJson(jsonWriter, this.method.invoke(this.adapter, new Object[]{obj}));
                }
            };
        }
    }

    static AdapterMethod fromAdapter(Object obj, Method method) {
        method.setAccessible(true);
        final Type[] genericParameterTypes = method.getGenericParameterTypes();
        Type genericReturnType = method.getGenericReturnType();
        if (genericParameterTypes.length == 1 && genericParameterTypes[0] == JsonReader.class && genericReturnType != Void.TYPE) {
            return new AdapterMethod(genericReturnType, Util.jsonAnnotations((AnnotatedElement) method), obj, method, false) {
                public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, IllegalAccessException, InvocationTargetException {
                    return this.method.invoke(this.adapter, new Object[]{jsonReader});
                }
            };
        }
        if (genericParameterTypes.length != 1 || genericReturnType == Void.TYPE) {
            throw new IllegalArgumentException("Unexpected signature for " + method + ".\n@FromJson method signatures may have one of the following structures:\n    <any access modifier> void fromJson(JsonReader jsonReader) throws <any>;\n    <any access modifier> R fromJson(T value) throws <any>;\n");
        }
        Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations((AnnotatedElement) method);
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        final Set<? extends Annotation> jsonAnnotations2 = Util.jsonAnnotations(parameterAnnotations[0]);
        return new AdapterMethod(genericReturnType, jsonAnnotations, obj, method, Util.hasNullable(parameterAnnotations[0])) {
            public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, IllegalAccessException, InvocationTargetException {
                Object fromJson = moshi.adapter(genericParameterTypes[0], jsonAnnotations2).fromJson(jsonReader);
                return this.method.invoke(this.adapter, new Object[]{fromJson});
            }
        };
    }

    private static AdapterMethod get(List<AdapterMethod> list, Type type, Set<? extends Annotation> set) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AdapterMethod adapterMethod = list.get(i);
            if (adapterMethod.type.equals(type) && adapterMethod.annotations.equals(set)) {
                return adapterMethod;
            }
        }
        return null;
    }

    static abstract class AdapterMethod {
        final Object adapter;
        final Set<? extends Annotation> annotations;
        final Method method;
        final boolean nullable;
        final Type type;

        public AdapterMethod(Type type2, Set<? extends Annotation> set, Object obj, Method method2, boolean z) {
            this.type = type2;
            this.annotations = set;
            this.adapter = obj;
            this.method = method2;
            this.nullable = z;
        }

        public void toJson(Moshi moshi, JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException, InvocationTargetException {
            throw new AssertionError();
        }

        public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, IllegalAccessException, InvocationTargetException {
            throw new AssertionError();
        }
    }
}
