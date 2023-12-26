package com.eaydu.omni.net.squareup.moshi;

import com.eaydu.omni.net.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Moshi {
    static final List<JsonAdapter.Factory> BUILT_IN_FACTORIES;
    private final Map<Object, JsonAdapter<?>> adapterCache = new LinkedHashMap();
    private final List<JsonAdapter.Factory> factories;
    private final ThreadLocal<List<DeferredAdapter<?>>> reentrantCalls = new ThreadLocal<>();

    static {
        ArrayList arrayList = new ArrayList(5);
        BUILT_IN_FACTORIES = arrayList;
        arrayList.add(StandardJsonAdapters.FACTORY);
        arrayList.add(CollectionJsonAdapter.FACTORY);
        arrayList.add(MapJsonAdapter.FACTORY);
        arrayList.add(ArrayJsonAdapter.FACTORY);
        arrayList.add(ClassJsonAdapter.FACTORY);
    }

    Moshi(Builder builder) {
        int size = builder.factories.size();
        List<JsonAdapter.Factory> list = BUILT_IN_FACTORIES;
        ArrayList arrayList = new ArrayList(size + list.size());
        arrayList.addAll(builder.factories);
        arrayList.addAll(list);
        this.factories = Collections.unmodifiableList(arrayList);
    }

    public <T> JsonAdapter<T> adapter(Type type) {
        return adapter(type, Util.NO_ANNOTATIONS);
    }

    public <T> JsonAdapter<T> adapter(Class<T> cls) {
        return adapter(cls, Util.NO_ANNOTATIONS);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        r3 = r1.size();
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        if (r4 >= r3) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        r5 = (com.eaydu.omni.net.squareup.moshi.Moshi.DeferredAdapter) r1.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r5.cacheKey.equals(r0) == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        r1 = new java.util.ArrayList();
        r7.reentrantCalls.set(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        r3 = new com.eaydu.omni.net.squareup.moshi.Moshi.DeferredAdapter(r0);
        r1.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4 = r7.factories.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        if (r2 >= r4) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        r5 = r7.factories.get(r2).create(r8, r9, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        if (r5 == null) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
        r3.ready(r5);
        r8 = r7.adapterCache;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r7.adapterCache.put(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006c, code lost:
        r1.remove(r1.size() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0079, code lost:
        if (r1.isEmpty() == false) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007b, code lost:
        r7.reentrantCalls.remove();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0080, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0084, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0087, code lost:
        r1.remove(r1.size() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0094, code lost:
        if (r1.isEmpty() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0096, code lost:
        r7.reentrantCalls.remove();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b9, code lost:
        throw new java.lang.IllegalArgumentException("No JsonAdapter for " + r8 + " annotated " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ba, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bb, code lost:
        r1.remove(r1.size() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c8, code lost:
        if (r1.isEmpty() != false) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ca, code lost:
        r7.reentrantCalls.remove();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cf, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        r1 = r7.reentrantCalls.get();
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r1 == null) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> com.eaydu.omni.net.squareup.moshi.JsonAdapter<T> adapter(java.lang.reflect.Type r8, java.util.Set<? extends java.lang.annotation.Annotation> r9) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.cacheKey(r8, r9)
            java.util.Map<java.lang.Object, com.eaydu.omni.net.squareup.moshi.JsonAdapter<?>> r1 = r7.adapterCache
            monitor-enter(r1)
            java.util.Map<java.lang.Object, com.eaydu.omni.net.squareup.moshi.JsonAdapter<?>> r2 = r7.adapterCache     // Catch:{ all -> 0x00d0 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x00d0 }
            com.eaydu.omni.net.squareup.moshi.JsonAdapter r2 = (com.eaydu.omni.net.squareup.moshi.JsonAdapter) r2     // Catch:{ all -> 0x00d0 }
            if (r2 == 0) goto L_0x0013
            monitor-exit(r1)     // Catch:{ all -> 0x00d0 }
            return r2
        L_0x0013:
            monitor-exit(r1)     // Catch:{ all -> 0x00d0 }
            java.lang.ThreadLocal<java.util.List<com.eaydu.omni.net.squareup.moshi.Moshi$DeferredAdapter<?>>> r1 = r7.reentrantCalls
            java.lang.Object r1 = r1.get()
            java.util.List r1 = (java.util.List) r1
            r2 = 0
            if (r1 == 0) goto L_0x0038
            int r3 = r1.size()
            r4 = r2
        L_0x0024:
            if (r4 >= r3) goto L_0x0042
            java.lang.Object r5 = r1.get(r4)
            com.eaydu.omni.net.squareup.moshi.Moshi$DeferredAdapter r5 = (com.eaydu.omni.net.squareup.moshi.Moshi.DeferredAdapter) r5
            java.lang.Object r6 = r5.cacheKey
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0035
            return r5
        L_0x0035:
            int r4 = r4 + 1
            goto L_0x0024
        L_0x0038:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.ThreadLocal<java.util.List<com.eaydu.omni.net.squareup.moshi.Moshi$DeferredAdapter<?>>> r3 = r7.reentrantCalls
            r3.set(r1)
        L_0x0042:
            com.eaydu.omni.net.squareup.moshi.Moshi$DeferredAdapter r3 = new com.eaydu.omni.net.squareup.moshi.Moshi$DeferredAdapter
            r3.<init>(r0)
            r1.add(r3)
            java.util.List<com.eaydu.omni.net.squareup.moshi.JsonAdapter$Factory> r4 = r7.factories     // Catch:{ all -> 0x00ba }
            int r4 = r4.size()     // Catch:{ all -> 0x00ba }
        L_0x0050:
            if (r2 >= r4) goto L_0x0087
            java.util.List<com.eaydu.omni.net.squareup.moshi.JsonAdapter$Factory> r5 = r7.factories     // Catch:{ all -> 0x00ba }
            java.lang.Object r5 = r5.get(r2)     // Catch:{ all -> 0x00ba }
            com.eaydu.omni.net.squareup.moshi.JsonAdapter$Factory r5 = (com.eaydu.omni.net.squareup.moshi.JsonAdapter.Factory) r5     // Catch:{ all -> 0x00ba }
            com.eaydu.omni.net.squareup.moshi.JsonAdapter r5 = r5.create(r8, r9, r7)     // Catch:{ all -> 0x00ba }
            if (r5 == 0) goto L_0x0084
            r3.ready(r5)     // Catch:{ all -> 0x00ba }
            java.util.Map<java.lang.Object, com.eaydu.omni.net.squareup.moshi.JsonAdapter<?>> r8 = r7.adapterCache     // Catch:{ all -> 0x00ba }
            monitor-enter(r8)     // Catch:{ all -> 0x00ba }
            java.util.Map<java.lang.Object, com.eaydu.omni.net.squareup.moshi.JsonAdapter<?>> r9 = r7.adapterCache     // Catch:{ all -> 0x0081 }
            r9.put(r0, r5)     // Catch:{ all -> 0x0081 }
            monitor-exit(r8)     // Catch:{ all -> 0x0081 }
            int r8 = r1.size()
            int r8 = r8 + -1
            r1.remove(r8)
            boolean r8 = r1.isEmpty()
            if (r8 == 0) goto L_0x0080
            java.lang.ThreadLocal<java.util.List<com.eaydu.omni.net.squareup.moshi.Moshi$DeferredAdapter<?>>> r8 = r7.reentrantCalls
            r8.remove()
        L_0x0080:
            return r5
        L_0x0081:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0081 }
            throw r9     // Catch:{ all -> 0x00ba }
        L_0x0084:
            int r2 = r2 + 1
            goto L_0x0050
        L_0x0087:
            int r0 = r1.size()
            int r0 = r0 + -1
            r1.remove(r0)
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x009b
            java.lang.ThreadLocal<java.util.List<com.eaydu.omni.net.squareup.moshi.Moshi$DeferredAdapter<?>>> r0 = r7.reentrantCalls
            r0.remove()
        L_0x009b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "No JsonAdapter for "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = " annotated "
            r1.append(r8)
            r1.append(r9)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L_0x00ba:
            r8 = move-exception
            int r9 = r1.size()
            int r9 = r9 + -1
            r1.remove(r9)
            boolean r9 = r1.isEmpty()
            if (r9 == 0) goto L_0x00cf
            java.lang.ThreadLocal<java.util.List<com.eaydu.omni.net.squareup.moshi.Moshi$DeferredAdapter<?>>> r9 = r7.reentrantCalls
            r9.remove()
        L_0x00cf:
            throw r8
        L_0x00d0:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00d0 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.net.squareup.moshi.Moshi.adapter(java.lang.reflect.Type, java.util.Set):com.eaydu.omni.net.squareup.moshi.JsonAdapter");
    }

    public <T> JsonAdapter<T> nextAdapter(JsonAdapter.Factory factory, Type type, Set<? extends Annotation> set) {
        int indexOf = this.factories.indexOf(factory);
        if (indexOf != -1) {
            int size = this.factories.size();
            for (int i = indexOf + 1; i < size; i++) {
                JsonAdapter<?> create = this.factories.get(i).create(type, set, this);
                if (create != null) {
                    return create;
                }
            }
            throw new IllegalArgumentException("No next JsonAdapter for " + type + " annotated " + set);
        }
        throw new IllegalArgumentException("Unable to skip past unknown factory " + factory);
    }

    public Builder newBuilder() {
        return new Builder().addAll(this.factories.subList(0, this.factories.size() - BUILT_IN_FACTORIES.size()));
    }

    private Object cacheKey(Type type, Set<? extends Annotation> set) {
        if (set.isEmpty()) {
            return type;
        }
        return Arrays.asList(new Object[]{type, set});
    }

    public static final class Builder {
        final List<JsonAdapter.Factory> factories = new ArrayList();

        public <T> Builder add(final Type type, final JsonAdapter<T> jsonAdapter) {
            if (type == null) {
                throw new IllegalArgumentException("type == null");
            } else if (jsonAdapter != null) {
                return add((JsonAdapter.Factory) new JsonAdapter.Factory() {
                    public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
                        if (!set.isEmpty() || !Util.typesMatch(type, type)) {
                            return null;
                        }
                        return jsonAdapter;
                    }
                });
            } else {
                throw new IllegalArgumentException("jsonAdapter == null");
            }
        }

        public <T> Builder add(final Type type, final Class<? extends Annotation> cls, final JsonAdapter<T> jsonAdapter) {
            if (type == null) {
                throw new IllegalArgumentException("type == null");
            } else if (cls == null) {
                throw new IllegalArgumentException("annotation == null");
            } else if (jsonAdapter == null) {
                throw new IllegalArgumentException("jsonAdapter == null");
            } else if (!cls.isAnnotationPresent(JsonQualifier.class)) {
                throw new IllegalArgumentException(cls + " does not have @JsonQualifier");
            } else if (cls.getDeclaredMethods().length <= 0) {
                return add((JsonAdapter.Factory) new JsonAdapter.Factory() {
                    public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
                        if (!Util.typesMatch(type, type) || set.size() != 1 || !Util.isAnnotationPresent(set, cls)) {
                            return null;
                        }
                        return jsonAdapter;
                    }
                });
            } else {
                throw new IllegalArgumentException("Use JsonAdapter.Factory for annotations with elements");
            }
        }

        public Builder add(JsonAdapter.Factory factory) {
            this.factories.add(factory);
            return this;
        }

        public Builder add(Object obj) {
            return add((JsonAdapter.Factory) AdapterMethodsFactory.get(obj));
        }

        /* access modifiers changed from: package-private */
        public Builder addAll(List<JsonAdapter.Factory> list) {
            this.factories.addAll(list);
            return this;
        }

        public Moshi build() {
            return new Moshi(this);
        }
    }

    private static class DeferredAdapter<T> extends JsonAdapter<T> {
        Object cacheKey;
        private JsonAdapter<T> delegate;

        DeferredAdapter(Object obj) {
            this.cacheKey = obj;
        }

        /* access modifiers changed from: package-private */
        public void ready(JsonAdapter<T> jsonAdapter) {
            this.delegate = jsonAdapter;
            this.cacheKey = null;
        }

        public T fromJson(JsonReader jsonReader) throws IOException {
            JsonAdapter<T> jsonAdapter = this.delegate;
            if (jsonAdapter != null) {
                return jsonAdapter.fromJson(jsonReader);
            }
            throw new IllegalStateException("Type adapter isn't ready");
        }

        public void toJson(JsonWriter jsonWriter, T t) throws IOException {
            JsonAdapter<T> jsonAdapter = this.delegate;
            if (jsonAdapter != null) {
                jsonAdapter.toJson(jsonWriter, t);
                return;
            }
            throw new IllegalStateException("Type adapter isn't ready");
        }
    }
}
