package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.spi.Module;
import com.alibaba.fastjson.support.moneta.MonetaCodec;
import com.alibaba.fastjson.support.springfox.SwaggerJsonSerializer;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3c.dom.Node;

public class SerializeConfig {
    private static boolean awtError = false;
    public static final SerializeConfig globalInstance = new SerializeConfig();
    private static boolean guavaError = false;
    private static boolean jdk8Error = false;
    private static boolean jodaError = false;
    private static boolean jsonnullError = false;
    private static boolean jsonobjectError = false;
    private static boolean oracleJdbcError = false;
    private static boolean springfoxError = false;
    private boolean asm;
    private ASMSerializerFactory asmFactory;
    private long[] denyClasses;
    private final boolean fieldBased;
    private final IdentityHashMap<Type, IdentityHashMap<Type, ObjectSerializer>> mixInSerializers;
    private List<Module> modules;
    public PropertyNamingStrategy propertyNamingStrategy;
    private final IdentityHashMap<Type, ObjectSerializer> serializers;
    protected String typeKey;

    public String getTypeKey() {
        return this.typeKey;
    }

    public void setTypeKey(String str) {
        this.typeKey = str;
    }

    private final JavaBeanSerializer createASMSerializer(SerializeBeanInfo serializeBeanInfo) throws Exception {
        JavaBeanSerializer createJavaBeanSerializer = this.asmFactory.createJavaBeanSerializer(serializeBeanInfo);
        for (FieldSerializer fieldSerializer : createJavaBeanSerializer.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (cls.isEnum() && !(getObjectWriter(cls) instanceof EnumSerializer)) {
                createJavaBeanSerializer.writeDirect = false;
            }
        }
        return createJavaBeanSerializer;
    }

    public final ObjectSerializer createJavaBeanSerializer(Class<?> cls) {
        String name = cls.getName();
        if (Arrays.binarySearch(this.denyClasses, TypeUtils.fnv1a_64(name)) < 0) {
            SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, (Map<String, String>) null, this.propertyNamingStrategy, this.fieldBased);
            if (buildBeanInfo.fields.length != 0 || !Iterable.class.isAssignableFrom(cls)) {
                return createJavaBeanSerializer(buildBeanInfo);
            }
            return MiscCodec.instance;
        }
        throw new JSONException("not support class : " + name);
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x013a A[SYNTHETIC, Splitter:B:103:0x013a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.fastjson.serializer.ObjectSerializer createJavaBeanSerializer(com.alibaba.fastjson.serializer.SerializeBeanInfo r13) {
        /*
            r12 = this;
            com.alibaba.fastjson.annotation.JSONType r0 = r13.jsonType
            boolean r1 = r12.asm
            r2 = 0
            if (r1 == 0) goto L_0x000d
            boolean r1 = r12.fieldBased
            if (r1 != 0) goto L_0x000d
            r1 = 1
            goto L_0x000e
        L_0x000d:
            r1 = r2
        L_0x000e:
            if (r0 == 0) goto L_0x0055
            java.lang.Class r3 = r0.serializer()
            java.lang.Class<java.lang.Void> r4 = java.lang.Void.class
            if (r3 == r4) goto L_0x0023
            java.lang.Object r3 = r3.newInstance()     // Catch:{ all -> 0x0023 }
            boolean r4 = r3 instanceof com.alibaba.fastjson.serializer.ObjectSerializer     // Catch:{ all -> 0x0023 }
            if (r4 == 0) goto L_0x0023
            com.alibaba.fastjson.serializer.ObjectSerializer r3 = (com.alibaba.fastjson.serializer.ObjectSerializer) r3     // Catch:{ all -> 0x0023 }
            return r3
        L_0x0023:
            boolean r3 = r0.asm()
            if (r3 != 0) goto L_0x002a
            r1 = r2
        L_0x002a:
            if (r1 == 0) goto L_0x004b
            com.alibaba.fastjson.serializer.SerializerFeature[] r3 = r0.serialzeFeatures()
            int r4 = r3.length
            r5 = r2
        L_0x0032:
            if (r5 >= r4) goto L_0x004b
            r6 = r3[r5]
            com.alibaba.fastjson.serializer.SerializerFeature r7 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringValueAsString
            if (r7 == r6) goto L_0x004a
            com.alibaba.fastjson.serializer.SerializerFeature r7 = com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString
            if (r7 == r6) goto L_0x004a
            com.alibaba.fastjson.serializer.SerializerFeature r7 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue
            if (r7 == r6) goto L_0x004a
            com.alibaba.fastjson.serializer.SerializerFeature r7 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            if (r7 != r6) goto L_0x0047
            goto L_0x004a
        L_0x0047:
            int r5 = r5 + 1
            goto L_0x0032
        L_0x004a:
            r1 = r2
        L_0x004b:
            if (r1 == 0) goto L_0x0055
            java.lang.Class[] r0 = r0.serialzeFilters()
            int r0 = r0.length
            if (r0 == 0) goto L_0x0055
            r1 = r2
        L_0x0055:
            java.lang.Class<?> r0 = r13.beanType
            java.lang.Class<?> r3 = r13.beanType
            int r3 = r3.getModifiers()
            boolean r3 = java.lang.reflect.Modifier.isPublic(r3)
            if (r3 != 0) goto L_0x0069
            com.alibaba.fastjson.serializer.JavaBeanSerializer r0 = new com.alibaba.fastjson.serializer.JavaBeanSerializer
            r0.<init>((com.alibaba.fastjson.serializer.SerializeBeanInfo) r13)
            return r0
        L_0x0069:
            if (r1 == 0) goto L_0x0075
            com.alibaba.fastjson.serializer.ASMSerializerFactory r3 = r12.asmFactory
            com.alibaba.fastjson.util.ASMClassLoader r3 = r3.classLoader
            boolean r3 = r3.isExternalClass(r0)
            if (r3 != 0) goto L_0x007d
        L_0x0075:
            java.lang.Class<java.io.Serializable> r3 = java.io.Serializable.class
            if (r0 == r3) goto L_0x007d
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            if (r0 != r3) goto L_0x007e
        L_0x007d:
            r1 = r2
        L_0x007e:
            if (r1 == 0) goto L_0x008b
            java.lang.String r3 = r0.getSimpleName()
            boolean r3 = com.alibaba.fastjson.util.ASMUtils.checkName(r3)
            if (r3 != 0) goto L_0x008b
            r1 = r2
        L_0x008b:
            if (r1 == 0) goto L_0x0096
            java.lang.Class<?> r3 = r13.beanType
            boolean r3 = r3.isInterface()
            if (r3 == 0) goto L_0x0096
            r1 = r2
        L_0x0096:
            if (r1 == 0) goto L_0x0137
            com.alibaba.fastjson.util.FieldInfo[] r3 = r13.fields
            int r4 = r3.length
            r5 = r2
        L_0x009c:
            if (r5 >= r4) goto L_0x0137
            r6 = r3[r5]
            java.lang.reflect.Field r7 = r6.field
            if (r7 == 0) goto L_0x00b2
            java.lang.Class r7 = r7.getType()
            java.lang.Class<?> r8 = r6.fieldClass
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x00b2
            goto L_0x0138
        L_0x00b2:
            java.lang.reflect.Method r7 = r6.method
            if (r7 == 0) goto L_0x00c4
            java.lang.Class r8 = r7.getReturnType()
            java.lang.Class<?> r9 = r6.fieldClass
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00c4
            goto L_0x0138
        L_0x00c4:
            com.alibaba.fastjson.annotation.JSONField r8 = r6.getAnnotation()
            if (r8 != 0) goto L_0x00cc
            goto L_0x0133
        L_0x00cc:
            java.lang.String r9 = r8.format()
            int r10 = r9.length()
            if (r10 == 0) goto L_0x00e4
            java.lang.Class<?> r6 = r6.fieldClass
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            if (r6 != r10) goto L_0x0138
            java.lang.String r6 = "trim"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0138
        L_0x00e4:
            java.lang.String r6 = r8.name()
            boolean r6 = com.alibaba.fastjson.util.ASMUtils.checkName(r6)
            if (r6 == 0) goto L_0x0138
            boolean r6 = r8.jsonDirect()
            if (r6 != 0) goto L_0x0138
            java.lang.Class r6 = r8.serializeUsing()
            java.lang.Class<java.lang.Void> r9 = java.lang.Void.class
            if (r6 != r9) goto L_0x0138
            boolean r6 = r8.unwrapped()
            if (r6 == 0) goto L_0x0103
            goto L_0x0138
        L_0x0103:
            com.alibaba.fastjson.serializer.SerializerFeature[] r6 = r8.serialzeFeatures()
            int r8 = r6.length
            r9 = r2
        L_0x0109:
            if (r9 >= r8) goto L_0x0126
            r10 = r6[r9]
            com.alibaba.fastjson.serializer.SerializerFeature r11 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringValueAsString
            if (r11 == r10) goto L_0x0125
            com.alibaba.fastjson.serializer.SerializerFeature r11 = com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString
            if (r11 == r10) goto L_0x0125
            com.alibaba.fastjson.serializer.SerializerFeature r11 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue
            if (r11 == r10) goto L_0x0125
            com.alibaba.fastjson.serializer.SerializerFeature r11 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            if (r11 == r10) goto L_0x0125
            com.alibaba.fastjson.serializer.SerializerFeature r11 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName
            if (r11 != r10) goto L_0x0122
            goto L_0x0125
        L_0x0122:
            int r9 = r9 + 1
            goto L_0x0109
        L_0x0125:
            r1 = r2
        L_0x0126:
            boolean r6 = com.alibaba.fastjson.util.TypeUtils.isAnnotationPresentOneToMany(r7)
            if (r6 != 0) goto L_0x0138
            boolean r6 = com.alibaba.fastjson.util.TypeUtils.isAnnotationPresentManyToMany(r7)
            if (r6 == 0) goto L_0x0133
            goto L_0x0138
        L_0x0133:
            int r5 = r5 + 1
            goto L_0x009c
        L_0x0137:
            r2 = r1
        L_0x0138:
            if (r2 == 0) goto L_0x0169
            com.alibaba.fastjson.serializer.JavaBeanSerializer r0 = r12.createASMSerializer(r13)     // Catch:{ ClassCastException | ClassFormatError | ClassNotFoundException -> 0x0169, OutOfMemoryError -> 0x0159, all -> 0x0141 }
            if (r0 == 0) goto L_0x0169
            return r0
        L_0x0141:
            r13 = move-exception
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "create asm serializer error, verson 1.2.60, class "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0, r13)
            throw r1
        L_0x0159:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = "Metaspace"
            int r1 = r1.indexOf(r2)
            r2 = -1
            if (r1 != r2) goto L_0x0168
            goto L_0x0169
        L_0x0168:
            throw r0
        L_0x0169:
            com.alibaba.fastjson.serializer.JavaBeanSerializer r0 = new com.alibaba.fastjson.serializer.JavaBeanSerializer
            r0.<init>((com.alibaba.fastjson.serializer.SerializeBeanInfo) r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeConfig.createJavaBeanSerializer(com.alibaba.fastjson.serializer.SerializeBeanInfo):com.alibaba.fastjson.serializer.ObjectSerializer");
    }

    public boolean isAsmEnable() {
        return this.asm;
    }

    public void setAsmEnable(boolean z) {
        if (!ASMUtils.IS_ANDROID) {
            this.asm = z;
        }
    }

    public static SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    public SerializeConfig() {
        this(8192);
    }

    public SerializeConfig(boolean z) {
        this(8192, z);
    }

    public SerializeConfig(int i) {
        this(i, false);
    }

    public SerializeConfig(int i, boolean z) {
        this.asm = !ASMUtils.IS_ANDROID;
        this.typeKey = JSON.DEFAULT_TYPE_KEY;
        this.denyClasses = new long[]{4165360493669296979L, 4446674157046724083L};
        this.modules = new ArrayList();
        this.fieldBased = z;
        this.serializers = new IdentityHashMap<>(i);
        this.mixInSerializers = new IdentityHashMap<>(16);
        try {
            if (this.asm) {
                this.asmFactory = new ASMSerializerFactory();
            }
        } catch (Throwable unused) {
            this.asm = false;
        }
        initSerializers();
    }

    private void initSerializers() {
        put(Boolean.class, BooleanCodec.instance);
        put(Character.class, CharacterCodec.instance);
        put(Byte.class, IntegerCodec.instance);
        put(Short.class, IntegerCodec.instance);
        put(Integer.class, IntegerCodec.instance);
        put(Long.class, LongCodec.instance);
        put(Float.class, FloatCodec.instance);
        put(Double.class, DoubleSerializer.instance);
        put(BigDecimal.class, BigDecimalCodec.instance);
        put(BigInteger.class, BigIntegerCodec.instance);
        put(String.class, StringCodec.instance);
        put(byte[].class, PrimitiveArraySerializer.instance);
        put(short[].class, PrimitiveArraySerializer.instance);
        put(int[].class, PrimitiveArraySerializer.instance);
        put(long[].class, PrimitiveArraySerializer.instance);
        put(float[].class, PrimitiveArraySerializer.instance);
        put(double[].class, PrimitiveArraySerializer.instance);
        put(boolean[].class, PrimitiveArraySerializer.instance);
        put(char[].class, PrimitiveArraySerializer.instance);
        put(Object[].class, ObjectArrayCodec.instance);
        put(Class.class, MiscCodec.instance);
        put(SimpleDateFormat.class, MiscCodec.instance);
        put(Currency.class, new MiscCodec());
        put(TimeZone.class, MiscCodec.instance);
        put(InetAddress.class, MiscCodec.instance);
        put(Inet4Address.class, MiscCodec.instance);
        put(Inet6Address.class, MiscCodec.instance);
        put(InetSocketAddress.class, MiscCodec.instance);
        put(File.class, MiscCodec.instance);
        put(Appendable.class, AppendableSerializer.instance);
        put(StringBuffer.class, AppendableSerializer.instance);
        put(StringBuilder.class, AppendableSerializer.instance);
        put(Charset.class, ToStringSerializer.instance);
        put(Pattern.class, ToStringSerializer.instance);
        put(Locale.class, ToStringSerializer.instance);
        put(URI.class, ToStringSerializer.instance);
        put(URL.class, ToStringSerializer.instance);
        put(UUID.class, ToStringSerializer.instance);
        put(AtomicBoolean.class, AtomicCodec.instance);
        put(AtomicInteger.class, AtomicCodec.instance);
        put(AtomicLong.class, AtomicCodec.instance);
        put(AtomicReference.class, ReferenceCodec.instance);
        put(AtomicIntegerArray.class, AtomicCodec.instance);
        put(AtomicLongArray.class, AtomicCodec.instance);
        put(WeakReference.class, ReferenceCodec.instance);
        put(SoftReference.class, ReferenceCodec.instance);
        put(LinkedList.class, CollectionCodec.instance);
    }

    public void addFilter(Class<?> cls, SerializeFilter serializeFilter) {
        ObjectSerializer objectWriter = getObjectWriter(cls);
        if (objectWriter instanceof SerializeFilterable) {
            SerializeFilterable serializeFilterable = (SerializeFilterable) objectWriter;
            if (this == globalInstance || serializeFilterable != MapSerializer.instance) {
                serializeFilterable.addFilter(serializeFilter);
                return;
            }
            MapSerializer mapSerializer = new MapSerializer();
            put(cls, mapSerializer);
            mapSerializer.addFilter(serializeFilter);
        }
    }

    public void config(Class<?> cls, SerializerFeature serializerFeature, boolean z) {
        ObjectSerializer objectWriter = getObjectWriter(cls, false);
        if (objectWriter == null) {
            SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, (Map<String, String>) null, this.propertyNamingStrategy);
            if (z) {
                buildBeanInfo.features = serializerFeature.mask | buildBeanInfo.features;
            } else {
                buildBeanInfo.features = (~serializerFeature.mask) & buildBeanInfo.features;
            }
            put(cls, createJavaBeanSerializer(buildBeanInfo));
        } else if (objectWriter instanceof JavaBeanSerializer) {
            SerializeBeanInfo serializeBeanInfo = ((JavaBeanSerializer) objectWriter).beanInfo;
            int i = serializeBeanInfo.features;
            if (z) {
                serializeBeanInfo.features = serializerFeature.mask | serializeBeanInfo.features;
            } else {
                serializeBeanInfo.features = (~serializerFeature.mask) & serializeBeanInfo.features;
            }
            if (i != serializeBeanInfo.features && objectWriter.getClass() != JavaBeanSerializer.class) {
                put(cls, createJavaBeanSerializer(serializeBeanInfo));
            }
        }
    }

    public ObjectSerializer getObjectWriter(Class<?> cls) {
        return getObjectWriter(cls, true);
    }

    private ObjectSerializer getObjectWriter(Class<?> cls, boolean z) {
        ClassLoader classLoader;
        Class<?> cls2 = cls;
        ObjectSerializer objectSerializer = get(cls);
        if (objectSerializer == null) {
            try {
                for (AutowiredObjectSerializer next : ServiceLoader.load(AutowiredObjectSerializer.class, Thread.currentThread().getContextClassLoader())) {
                    if (next instanceof AutowiredObjectSerializer) {
                        AutowiredObjectSerializer autowiredObjectSerializer = next;
                        for (Type put : autowiredObjectSerializer.getAutowiredFor()) {
                            put(put, autowiredObjectSerializer);
                        }
                    }
                }
            } catch (ClassCastException unused) {
            }
            objectSerializer = get(cls);
        }
        if (objectSerializer == null && (classLoader = JSON.class.getClassLoader()) != Thread.currentThread().getContextClassLoader()) {
            try {
                for (AutowiredObjectSerializer next2 : ServiceLoader.load(AutowiredObjectSerializer.class, classLoader)) {
                    if (next2 instanceof AutowiredObjectSerializer) {
                        AutowiredObjectSerializer autowiredObjectSerializer2 = next2;
                        for (Type put2 : autowiredObjectSerializer2.getAutowiredFor()) {
                            put(put2, autowiredObjectSerializer2);
                        }
                    }
                }
            } catch (ClassCastException unused2) {
            }
            objectSerializer = get(cls);
        }
        for (Module createSerializer : this.modules) {
            objectSerializer = createSerializer.createSerializer(this, cls2);
            if (objectSerializer != null) {
                put(cls2, objectSerializer);
                return objectSerializer;
            }
        }
        if (objectSerializer != null) {
            return objectSerializer;
        }
        String name = cls.getName();
        if (Map.class.isAssignableFrom(cls2)) {
            objectSerializer = MapSerializer.instance;
            put(cls2, objectSerializer);
        } else if (List.class.isAssignableFrom(cls2)) {
            objectSerializer = ListSerializer.instance;
            put(cls2, objectSerializer);
        } else if (Collection.class.isAssignableFrom(cls2)) {
            objectSerializer = CollectionCodec.instance;
            put(cls2, objectSerializer);
        } else if (Date.class.isAssignableFrom(cls2)) {
            objectSerializer = DateCodec.instance;
            put(cls2, objectSerializer);
        } else if (JSONAware.class.isAssignableFrom(cls2)) {
            objectSerializer = JSONAwareSerializer.instance;
            put(cls2, objectSerializer);
        } else if (JSONSerializable.class.isAssignableFrom(cls2)) {
            objectSerializer = JSONSerializableSerializer.instance;
            put(cls2, objectSerializer);
        } else if (JSONStreamAware.class.isAssignableFrom(cls2)) {
            objectSerializer = MiscCodec.instance;
            put(cls2, objectSerializer);
        } else if (cls.isEnum()) {
            JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls2, JSONType.class);
            if (jSONType == null || !jSONType.serializeEnumAsJavaBean()) {
                objectSerializer = EnumSerializer.instance;
                put(cls2, objectSerializer);
            } else {
                objectSerializer = createJavaBeanSerializer(cls);
                put(cls2, objectSerializer);
            }
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass != null && superclass.isEnum()) {
                JSONType jSONType2 = (JSONType) TypeUtils.getAnnotation((Class<?>) superclass, JSONType.class);
                if (jSONType2 == null || !jSONType2.serializeEnumAsJavaBean()) {
                    objectSerializer = EnumSerializer.instance;
                    put(cls2, objectSerializer);
                } else {
                    objectSerializer = createJavaBeanSerializer(cls);
                    put(cls2, objectSerializer);
                }
            } else if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                ArraySerializer arraySerializer = new ArraySerializer(componentType, getObjectWriter(componentType));
                put(cls2, arraySerializer);
                objectSerializer = arraySerializer;
            } else {
                Class cls3 = null;
                if (Throwable.class.isAssignableFrom(cls2)) {
                    SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls2, (Map<String, String>) null, this.propertyNamingStrategy);
                    buildBeanInfo.features |= SerializerFeature.WriteClassName.mask;
                    JavaBeanSerializer javaBeanSerializer = new JavaBeanSerializer(buildBeanInfo);
                    put(cls2, javaBeanSerializer);
                    objectSerializer = javaBeanSerializer;
                } else if (TimeZone.class.isAssignableFrom(cls2) || Map.Entry.class.isAssignableFrom(cls2)) {
                    objectSerializer = MiscCodec.instance;
                    put(cls2, objectSerializer);
                } else if (Appendable.class.isAssignableFrom(cls2)) {
                    objectSerializer = AppendableSerializer.instance;
                    put(cls2, objectSerializer);
                } else if (Charset.class.isAssignableFrom(cls2)) {
                    objectSerializer = ToStringSerializer.instance;
                    put(cls2, objectSerializer);
                } else if (Enumeration.class.isAssignableFrom(cls2)) {
                    objectSerializer = EnumerationSerializer.instance;
                    put(cls2, objectSerializer);
                } else if (Calendar.class.isAssignableFrom(cls2) || XMLGregorianCalendar.class.isAssignableFrom(cls2)) {
                    objectSerializer = CalendarCodec.instance;
                    put(cls2, objectSerializer);
                } else if (TypeUtils.isClob(cls)) {
                    objectSerializer = ClobSeriliazer.instance;
                    put(cls2, objectSerializer);
                } else if (TypeUtils.isPath(cls)) {
                    objectSerializer = ToStringSerializer.instance;
                    put(cls2, objectSerializer);
                } else if (Iterator.class.isAssignableFrom(cls2)) {
                    objectSerializer = MiscCodec.instance;
                    put(cls2, objectSerializer);
                } else if (Node.class.isAssignableFrom(cls2)) {
                    objectSerializer = MiscCodec.instance;
                    put(cls2, objectSerializer);
                } else {
                    int i = 0;
                    if (name.startsWith("java.awt.") && AwtCodec.support(cls) && !awtError) {
                        try {
                            String[] strArr = {"java.awt.Color", "java.awt.Font", "java.awt.Point", "java.awt.Rectangle"};
                            for (int i2 = 0; i2 < 4; i2++) {
                                String str = strArr[i2];
                                if (str.equals(name)) {
                                    Class<?> cls4 = Class.forName(str);
                                    AwtCodec awtCodec = AwtCodec.instance;
                                    put(cls4, awtCodec);
                                    return awtCodec;
                                }
                            }
                        } catch (Throwable unused3) {
                            awtError = true;
                        }
                    }
                    if (!jdk8Error && (name.startsWith("java.time.") || name.startsWith("java.util.Optional") || name.equals("java.util.concurrent.atomic.LongAdder") || name.equals("java.util.concurrent.atomic.DoubleAdder"))) {
                        try {
                            String[] strArr2 = {"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.Period", "java.time.Duration", "java.time.Instant"};
                            for (int i3 = 0; i3 < 11; i3++) {
                                String str2 = strArr2[i3];
                                if (str2.equals(name)) {
                                    Class<?> cls5 = Class.forName(str2);
                                    Jdk8DateCodec jdk8DateCodec = Jdk8DateCodec.instance;
                                    put(cls5, jdk8DateCodec);
                                    return jdk8DateCodec;
                                }
                            }
                            String[] strArr3 = {"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"};
                            for (int i4 = 0; i4 < 4; i4++) {
                                String str3 = strArr3[i4];
                                if (str3.equals(name)) {
                                    Class<?> cls6 = Class.forName(str3);
                                    OptionalCodec optionalCodec = OptionalCodec.instance;
                                    put(cls6, optionalCodec);
                                    return optionalCodec;
                                }
                            }
                            String[] strArr4 = {"java.util.concurrent.atomic.LongAdder", "java.util.concurrent.atomic.DoubleAdder"};
                            for (int i5 = 0; i5 < 2; i5++) {
                                String str4 = strArr4[i5];
                                if (str4.equals(name)) {
                                    Class<?> cls7 = Class.forName(str4);
                                    AdderSerializer adderSerializer = AdderSerializer.instance;
                                    put(cls7, adderSerializer);
                                    return adderSerializer;
                                }
                            }
                        } catch (Throwable unused4) {
                            jdk8Error = true;
                        }
                    }
                    if (!oracleJdbcError && name.startsWith("oracle.sql.")) {
                        try {
                            String[] strArr5 = {"oracle.sql.DATE", "oracle.sql.TIMESTAMP"};
                            for (int i6 = 0; i6 < 2; i6++) {
                                String str5 = strArr5[i6];
                                if (str5.equals(name)) {
                                    Class<?> cls8 = Class.forName(str5);
                                    DateCodec dateCodec = DateCodec.instance;
                                    put(cls8, dateCodec);
                                    return dateCodec;
                                }
                            }
                        } catch (Throwable unused5) {
                            oracleJdbcError = true;
                        }
                    }
                    if (!springfoxError && name.equals("springfox.documentation.spring.web.json.Json")) {
                        try {
                            Class<?> cls9 = Class.forName("springfox.documentation.spring.web.json.Json");
                            objectSerializer = SwaggerJsonSerializer.instance;
                            put(cls9, objectSerializer);
                            return objectSerializer;
                        } catch (ClassNotFoundException unused6) {
                            springfoxError = true;
                        }
                    }
                    if (!guavaError && name.startsWith("com.google.common.collect.")) {
                        try {
                            String[] strArr6 = {"com.google.common.collect.HashMultimap", "com.google.common.collect.LinkedListMultimap", "com.google.common.collect.LinkedHashMultimap", "com.google.common.collect.ArrayListMultimap", "com.google.common.collect.TreeMultimap"};
                            for (int i7 = 0; i7 < 5; i7++) {
                                String str6 = strArr6[i7];
                                if (str6.equals(name)) {
                                    Class<?> cls10 = Class.forName(str6);
                                    GuavaCodec guavaCodec = GuavaCodec.instance;
                                    put(cls10, guavaCodec);
                                    return guavaCodec;
                                }
                            }
                        } catch (ClassNotFoundException unused7) {
                            guavaError = true;
                        }
                    }
                    if (!jsonnullError && name.equals("net.sf.json.JSONNull")) {
                        try {
                            Class<?> cls11 = Class.forName("net.sf.json.JSONNull");
                            objectSerializer = MiscCodec.instance;
                            put(cls11, objectSerializer);
                            return objectSerializer;
                        } catch (ClassNotFoundException unused8) {
                            jsonnullError = true;
                        }
                    }
                    if (!jsonobjectError && name.equals("org.json.JSONObject")) {
                        try {
                            Class<?> cls12 = Class.forName("org.json.JSONObject");
                            objectSerializer = JSONObjectCodec.instance;
                            put(cls12, objectSerializer);
                            return objectSerializer;
                        } catch (ClassNotFoundException unused9) {
                            jsonobjectError = true;
                        }
                    }
                    if (!jodaError && name.startsWith("org.joda.")) {
                        try {
                            String[] strArr7 = {"org.joda.time.LocalDate", "org.joda.time.LocalDateTime", "org.joda.time.LocalTime", "org.joda.time.Instant", "org.joda.time.DateTime", "org.joda.time.Period", "org.joda.time.Duration", "org.joda.time.DateTimeZone", "org.joda.time.UTCDateTimeZone", "org.joda.time.tz.CachedDateTimeZone", "org.joda.time.tz.FixedDateTimeZone"};
                            for (int i8 = 0; i8 < 11; i8++) {
                                String str7 = strArr7[i8];
                                if (str7.equals(name)) {
                                    Class<?> cls13 = Class.forName(str7);
                                    JodaCodec jodaCodec = JodaCodec.instance;
                                    put(cls13, jodaCodec);
                                    return jodaCodec;
                                }
                            }
                        } catch (ClassNotFoundException unused10) {
                            jodaError = true;
                        }
                    }
                    if ("java.nio.HeapByteBuffer".equals(name)) {
                        ByteBufferCodec byteBufferCodec = ByteBufferCodec.instance;
                        put(cls2, byteBufferCodec);
                        return byteBufferCodec;
                    } else if ("org.javamoney.moneta.Money".equals(name)) {
                        MonetaCodec monetaCodec = MonetaCodec.instance;
                        put(cls2, monetaCodec);
                        return monetaCodec;
                    } else {
                        Class[] interfaces = cls.getInterfaces();
                        if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
                            put(cls2, AnnotationSerializer.instance);
                            return AnnotationSerializer.instance;
                        } else if (TypeUtils.isProxy(cls)) {
                            ObjectSerializer objectWriter = getObjectWriter(cls.getSuperclass());
                            put(cls2, objectWriter);
                            return objectWriter;
                        } else {
                            if (Proxy.isProxyClass(cls)) {
                                if (interfaces.length != 2) {
                                    int length = interfaces.length;
                                    Class cls14 = null;
                                    while (true) {
                                        if (i >= length) {
                                            cls3 = cls14;
                                            break;
                                        }
                                        Class cls15 = interfaces[i];
                                        if (!cls15.getName().startsWith("org.springframework.aop.")) {
                                            if (cls14 != null) {
                                                break;
                                            }
                                            cls14 = cls15;
                                        }
                                        i++;
                                    }
                                } else {
                                    cls3 = interfaces[1];
                                }
                                if (cls3 != null) {
                                    ObjectSerializer objectWriter2 = getObjectWriter(cls3);
                                    put(cls2, objectWriter2);
                                    return objectWriter2;
                                }
                            }
                            if (z) {
                                objectSerializer = createJavaBeanSerializer(cls);
                                put(cls2, objectSerializer);
                            }
                        }
                    }
                }
            }
        }
        return objectSerializer == null ? get(cls) : objectSerializer;
    }

    public final ObjectSerializer get(Type type) {
        Type mixInAnnotations = JSON.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            return this.serializers.get(type);
        }
        IdentityHashMap identityHashMap = this.mixInSerializers.get(type);
        if (identityHashMap == null) {
            return null;
        }
        return (ObjectSerializer) identityHashMap.get(mixInAnnotations);
    }

    public boolean put(Type type, ObjectSerializer objectSerializer) {
        Type mixInAnnotations = JSON.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            return this.serializers.put(type, objectSerializer);
        }
        IdentityHashMap identityHashMap = this.mixInSerializers.get(type);
        if (identityHashMap == null) {
            identityHashMap = new IdentityHashMap(4);
            this.mixInSerializers.put(type, identityHashMap);
        }
        return identityHashMap.put(mixInAnnotations, objectSerializer);
    }

    public void configEnumAsJavaBean(Class<? extends Enum>... clsArr) {
        for (Class<? extends Enum> cls : clsArr) {
            put(cls, createJavaBeanSerializer((Class<?>) cls));
        }
    }

    public void setPropertyNamingStrategy(PropertyNamingStrategy propertyNamingStrategy2) {
        this.propertyNamingStrategy = propertyNamingStrategy2;
    }

    public void clearSerializers() {
        this.serializers.clear();
        initSerializers();
    }

    public void register(Module module) {
        this.modules.add(module);
    }
}
