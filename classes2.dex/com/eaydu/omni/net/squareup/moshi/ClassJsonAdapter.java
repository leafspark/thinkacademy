package com.eaydu.omni.net.squareup.moshi;

import com.eaydu.omni.net.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

final class ClassJsonAdapter<T> extends JsonAdapter<T> {
    public static final JsonAdapter.Factory FACTORY = new JsonAdapter.Factory() {
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Class<?> rawType = Types.getRawType(type);
            if (rawType.isInterface() || rawType.isEnum()) {
                return null;
            }
            if (isPlatformType(rawType)) {
                throw new IllegalArgumentException("Platform " + type + " annotated " + set + " requires explicit JsonAdapter to be registered");
            } else if (!set.isEmpty()) {
                return null;
            } else {
                if (rawType.getEnclosingClass() == null || Modifier.isStatic(rawType.getModifiers())) {
                    if (!Modifier.isAbstract(rawType.getModifiers())) {
                        ClassFactory<?> classFactory = ClassFactory.get(rawType);
                        TreeMap treeMap = new TreeMap();
                        while (type != Object.class) {
                            createFieldBindings(moshi, type, treeMap);
                            type = Types.getGenericSuperclass(type);
                        }
                        return new ClassJsonAdapter(classFactory, treeMap).nullSafe();
                    }
                    throw new IllegalArgumentException("Cannot serialize abstract class " + rawType.getName());
                } else if (rawType.getSimpleName().isEmpty()) {
                    throw new IllegalArgumentException("Cannot serialize anonymous class " + rawType.getName());
                } else {
                    throw new IllegalArgumentException("Cannot serialize non-static nested class " + rawType.getName());
                }
            }
        }

        private void createFieldBindings(Moshi moshi, Type type, Map<String, FieldBinding<?>> map) {
            Class<?> rawType = Types.getRawType(type);
            boolean isPlatformType = isPlatformType(rawType);
            for (Field field : rawType.getDeclaredFields()) {
                if (includeField(isPlatformType, field.getModifiers())) {
                    JsonAdapter<T> adapter = moshi.adapter(Types.resolve(type, rawType, field.getGenericType()), Util.jsonAnnotations((AnnotatedElement) field));
                    field.setAccessible(true);
                    FieldBinding fieldBinding = new FieldBinding(field, adapter);
                    Json json = (Json) field.getAnnotation(Json.class);
                    FieldBinding put = map.put(json != null ? json.name() : field.getName(), fieldBinding);
                    if (put != null) {
                        throw new IllegalArgumentException("Conflicting fields:\n    " + put.field + "\n    " + fieldBinding.field);
                    }
                }
            }
        }

        private boolean isPlatformType(Class<?> cls) {
            return cls.getName().startsWith("java.") || cls.getName().startsWith("javax.") || cls.getName().startsWith("android.");
        }

        private boolean includeField(boolean z, int i) {
            if (Modifier.isStatic(i) || Modifier.isTransient(i)) {
                return false;
            }
            if (Modifier.isPublic(i) || Modifier.isProtected(i) || !z) {
                return true;
            }
            return false;
        }
    };
    private final ClassFactory<T> classFactory;
    private final Map<String, FieldBinding<?>> jsonFields;

    ClassJsonAdapter(ClassFactory<T> classFactory2, Map<String, FieldBinding<?>> map) {
        this.classFactory = classFactory2;
        this.jsonFields = map;
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        try {
            T newInstance = this.classFactory.newInstance();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    FieldBinding fieldBinding = this.jsonFields.get(jsonReader.nextName());
                    if (fieldBinding != null) {
                        fieldBinding.read(jsonReader, newInstance);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                return newInstance;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            } else if (targetException instanceof Error) {
                throw ((Error) targetException);
            } else {
                throw new RuntimeException(targetException);
            }
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    public void toJson(JsonWriter jsonWriter, T t) throws IOException {
        try {
            jsonWriter.beginObject();
            for (Map.Entry next : this.jsonFields.entrySet()) {
                jsonWriter.name((String) next.getKey());
                ((FieldBinding) next.getValue()).write(jsonWriter, t);
            }
            jsonWriter.endObject();
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        }
    }

    public String toString() {
        return "JsonAdapter(" + this.classFactory + ")";
    }

    static class FieldBinding<T> {
        private final JsonAdapter<T> adapter;
        /* access modifiers changed from: private */
        public final Field field;

        public FieldBinding(Field field2, JsonAdapter<T> jsonAdapter) {
            this.field = field2;
            this.adapter = jsonAdapter;
        }

        /* access modifiers changed from: package-private */
        public void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
            this.field.set(obj, this.adapter.fromJson(jsonReader));
        }

        /* access modifiers changed from: package-private */
        public void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException {
            this.adapter.toJson(jsonWriter, this.field.get(obj));
        }
    }
}
