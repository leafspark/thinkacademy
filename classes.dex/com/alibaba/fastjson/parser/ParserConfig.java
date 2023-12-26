package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JSONPDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimeDeserializer;
import com.alibaba.fastjson.serializer.AtomicCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharArrayCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.spi.Module;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;

public class ParserConfig {
    public static final String AUTOTYPE_ACCEPT = "fastjson.parser.autoTypeAccept";
    public static final String AUTOTYPE_SUPPORT_PROPERTY = "fastjson.parser.autoTypeSupport";
    public static final boolean AUTO_SUPPORT = "true".equals(IOUtils.getStringProperty(AUTOTYPE_SUPPORT_PROPERTY));
    private static final String[] AUTO_TYPE_ACCEPT_LIST;
    public static final String[] DENYS = splitItemsFormProperty(IOUtils.getStringProperty(DENY_PROPERTY));
    public static final String DENY_PROPERTY = "fastjson.parser.deny";
    private static boolean awtError = false;
    public static ParserConfig global = new ParserConfig();
    private static boolean guavaError = false;
    private static boolean jdk8Error = false;
    private static boolean jodaError = false;
    private long[] acceptHashCodes;
    private boolean asmEnable;
    protected ASMDeserializerFactory asmFactory;
    private boolean autoTypeSupport;
    public boolean compatibleWithJavaBean;
    protected ClassLoader defaultClassLoader;
    private long[] denyHashCodes;
    private final IdentityHashMap<Type, ObjectDeserializer> deserializers;
    public final boolean fieldBased;
    private boolean jacksonCompatible;
    private final IdentityHashMap<Type, IdentityHashMap<Type, ObjectDeserializer>> mixInDeserializers;
    private List<Module> modules;
    public PropertyNamingStrategy propertyNamingStrategy;
    public final SymbolTable symbolTable;
    private final ConcurrentMap<String, Class<?>> typeMapping;

    static {
        String[] splitItemsFormProperty = splitItemsFormProperty(IOUtils.getStringProperty(AUTOTYPE_ACCEPT));
        if (splitItemsFormProperty == null) {
            splitItemsFormProperty = new String[0];
        }
        AUTO_TYPE_ACCEPT_LIST = splitItemsFormProperty;
    }

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    public ParserConfig() {
        this(false);
    }

    public ParserConfig(boolean z) {
        this((ASMDeserializerFactory) null, (ClassLoader) null, z);
    }

    public ParserConfig(ClassLoader classLoader) {
        this((ASMDeserializerFactory) null, classLoader, false);
    }

    public ParserConfig(ASMDeserializerFactory aSMDeserializerFactory) {
        this(aSMDeserializerFactory, (ClassLoader) null, false);
    }

    private ParserConfig(ASMDeserializerFactory aSMDeserializerFactory, ClassLoader classLoader, boolean z) {
        this.deserializers = new IdentityHashMap<>();
        this.mixInDeserializers = new IdentityHashMap<>(16);
        this.typeMapping = new ConcurrentHashMap(16, 0.75f, 1);
        this.asmEnable = !ASMUtils.IS_ANDROID;
        this.symbolTable = new SymbolTable(4096);
        this.autoTypeSupport = AUTO_SUPPORT;
        this.jacksonCompatible = false;
        this.compatibleWithJavaBean = TypeUtils.compatibleWithJavaBean;
        this.modules = new ArrayList();
        this.denyHashCodes = new long[]{-8720046426850100497L, -8165637398350707645L, -8109300701639721088L, -8083514888460375884L, -7966123100503199569L, -7921218830998286408L, -7768608037458185275L, -7766605818834748097L, -6835437086156813536L, -6179589609550493385L, -5194641081268104286L, -4837536971810737970L, -4082057040235125754L, -3935185854875733362L, -2753427844400776271L, -2364987994247679115L, -2262244760619952081L, -1872417015366588117L, -1589194880214235129L, -254670111376247151L, -190281065685395680L, 33238344207745342L, 313864100207897507L, 1073634739308289776L, 1203232727967308606L, 1459860845934817624L, 1502845958873959152L, 3547627781654598988L, 3688179072722109200L, 3730752432285826863L, 3794316665763266033L, 4147696707147271408L, 4904007817188630457L, 5100336081510080343L, 5347909877633654828L, 5450448828334921485L, 5688200883751798389L, 5751393439502795295L, 5944107969236155580L, 6456855723474196908L, 6742705432718011780L, 7017492163108594270L, 7179336928365889465L, 7442624256860549330L, 8389032537095247355L, 8409640769019589119L, 8537233257283452655L, 8838294710098435315L};
        int length = AUTO_TYPE_ACCEPT_LIST.length + 1;
        long[] jArr = new long[length];
        int i = 0;
        while (true) {
            String[] strArr = AUTO_TYPE_ACCEPT_LIST;
            if (i >= strArr.length) {
                break;
            }
            jArr[i] = TypeUtils.fnv1a_64(strArr[i]);
            i++;
        }
        jArr[length - 1] = -6293031534589903644L;
        Arrays.sort(jArr);
        this.acceptHashCodes = jArr;
        this.fieldBased = z;
        if (aSMDeserializerFactory == null && !ASMUtils.IS_ANDROID) {
            if (classLoader == null) {
                try {
                    aSMDeserializerFactory = new ASMDeserializerFactory(new ASMClassLoader());
                } catch (ExceptionInInitializerError | NoClassDefFoundError | AccessControlException unused) {
                }
            } else {
                aSMDeserializerFactory = new ASMDeserializerFactory(classLoader);
            }
        }
        this.asmFactory = aSMDeserializerFactory;
        if (aSMDeserializerFactory == null) {
            this.asmEnable = false;
        }
        initDeserializers();
        addItemsToDeny(DENYS);
        addItemsToAccept(AUTO_TYPE_ACCEPT_LIST);
    }

    private void initDeserializers() {
        this.deserializers.put(SimpleDateFormat.class, MiscCodec.instance);
        this.deserializers.put(Timestamp.class, SqlDateDeserializer.instance_timestamp);
        this.deserializers.put(Date.class, SqlDateDeserializer.instance);
        this.deserializers.put(Time.class, TimeDeserializer.instance);
        this.deserializers.put(java.util.Date.class, DateCodec.instance);
        this.deserializers.put(Calendar.class, CalendarCodec.instance);
        this.deserializers.put(XMLGregorianCalendar.class, CalendarCodec.instance);
        this.deserializers.put(JSONObject.class, MapDeserializer.instance);
        this.deserializers.put(JSONArray.class, CollectionCodec.instance);
        this.deserializers.put(Map.class, MapDeserializer.instance);
        this.deserializers.put(HashMap.class, MapDeserializer.instance);
        this.deserializers.put(LinkedHashMap.class, MapDeserializer.instance);
        this.deserializers.put(TreeMap.class, MapDeserializer.instance);
        this.deserializers.put(ConcurrentMap.class, MapDeserializer.instance);
        this.deserializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
        this.deserializers.put(Collection.class, CollectionCodec.instance);
        this.deserializers.put(List.class, CollectionCodec.instance);
        this.deserializers.put(ArrayList.class, CollectionCodec.instance);
        this.deserializers.put(Object.class, JavaObjectDeserializer.instance);
        this.deserializers.put(String.class, StringCodec.instance);
        this.deserializers.put(StringBuffer.class, StringCodec.instance);
        this.deserializers.put(StringBuilder.class, StringCodec.instance);
        this.deserializers.put(Character.TYPE, CharacterCodec.instance);
        this.deserializers.put(Character.class, CharacterCodec.instance);
        this.deserializers.put(Byte.TYPE, NumberDeserializer.instance);
        this.deserializers.put(Byte.class, NumberDeserializer.instance);
        this.deserializers.put(Short.TYPE, NumberDeserializer.instance);
        this.deserializers.put(Short.class, NumberDeserializer.instance);
        this.deserializers.put(Integer.TYPE, IntegerCodec.instance);
        this.deserializers.put(Integer.class, IntegerCodec.instance);
        this.deserializers.put(Long.TYPE, LongCodec.instance);
        this.deserializers.put(Long.class, LongCodec.instance);
        this.deserializers.put(BigInteger.class, BigIntegerCodec.instance);
        this.deserializers.put(BigDecimal.class, BigDecimalCodec.instance);
        this.deserializers.put(Float.TYPE, FloatCodec.instance);
        this.deserializers.put(Float.class, FloatCodec.instance);
        this.deserializers.put(Double.TYPE, NumberDeserializer.instance);
        this.deserializers.put(Double.class, NumberDeserializer.instance);
        this.deserializers.put(Boolean.TYPE, BooleanCodec.instance);
        this.deserializers.put(Boolean.class, BooleanCodec.instance);
        this.deserializers.put(Class.class, MiscCodec.instance);
        this.deserializers.put(char[].class, new CharArrayCodec());
        this.deserializers.put(AtomicBoolean.class, BooleanCodec.instance);
        this.deserializers.put(AtomicInteger.class, IntegerCodec.instance);
        this.deserializers.put(AtomicLong.class, LongCodec.instance);
        this.deserializers.put(AtomicReference.class, ReferenceCodec.instance);
        this.deserializers.put(WeakReference.class, ReferenceCodec.instance);
        this.deserializers.put(SoftReference.class, ReferenceCodec.instance);
        this.deserializers.put(UUID.class, MiscCodec.instance);
        this.deserializers.put(TimeZone.class, MiscCodec.instance);
        this.deserializers.put(Locale.class, MiscCodec.instance);
        this.deserializers.put(Currency.class, MiscCodec.instance);
        this.deserializers.put(Inet4Address.class, MiscCodec.instance);
        this.deserializers.put(Inet6Address.class, MiscCodec.instance);
        this.deserializers.put(InetSocketAddress.class, MiscCodec.instance);
        this.deserializers.put(File.class, MiscCodec.instance);
        this.deserializers.put(URI.class, MiscCodec.instance);
        this.deserializers.put(URL.class, MiscCodec.instance);
        this.deserializers.put(Pattern.class, MiscCodec.instance);
        this.deserializers.put(Charset.class, MiscCodec.instance);
        this.deserializers.put(JSONPath.class, MiscCodec.instance);
        this.deserializers.put(Number.class, NumberDeserializer.instance);
        this.deserializers.put(AtomicIntegerArray.class, AtomicCodec.instance);
        this.deserializers.put(AtomicLongArray.class, AtomicCodec.instance);
        this.deserializers.put(StackTraceElement.class, StackTraceElementDeserializer.instance);
        this.deserializers.put(Serializable.class, JavaObjectDeserializer.instance);
        this.deserializers.put(Cloneable.class, JavaObjectDeserializer.instance);
        this.deserializers.put(Comparable.class, JavaObjectDeserializer.instance);
        this.deserializers.put(Closeable.class, JavaObjectDeserializer.instance);
        this.deserializers.put(JSONPObject.class, new JSONPDeserializer());
    }

    private static String[] splitItemsFormProperty(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(",");
    }

    public void configFromPropety(Properties properties) {
        addItemsToDeny(splitItemsFormProperty(properties.getProperty(DENY_PROPERTY)));
        addItemsToAccept(splitItemsFormProperty(properties.getProperty(AUTOTYPE_ACCEPT)));
        String property = properties.getProperty(AUTOTYPE_SUPPORT_PROPERTY);
        if ("true".equals(property)) {
            this.autoTypeSupport = true;
        } else if ("false".equals(property)) {
            this.autoTypeSupport = false;
        }
    }

    private void addItemsToDeny(String[] strArr) {
        if (strArr != null) {
            for (String addDeny : strArr) {
                addDeny(addDeny);
            }
        }
    }

    private void addItemsToAccept(String[] strArr) {
        if (strArr != null) {
            for (String addAccept : strArr) {
                addAccept(addAccept);
            }
        }
    }

    public boolean isAutoTypeSupport() {
        return this.autoTypeSupport;
    }

    public void setAutoTypeSupport(boolean z) {
        this.autoTypeSupport = z;
    }

    public boolean isAsmEnable() {
        return this.asmEnable;
    }

    public void setAsmEnable(boolean z) {
        this.asmEnable = z;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDerializers() {
        return this.deserializers;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDeserializers() {
        return this.deserializers;
    }

    public ObjectDeserializer getDeserializer(Type type) {
        ObjectDeserializer objectDeserializer = get(type);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        if (type instanceof Class) {
            return getDeserializer((Class) type, type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return getDeserializer((Class) rawType, type);
            }
            return getDeserializer(rawType);
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return getDeserializer(upperBounds[0]);
            }
        }
        return JavaObjectDeserializer.instance;
    }

    /* JADX WARNING: type inference failed for: r24v0, types: [java.lang.reflect.Type] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.fastjson.parser.deserializer.ObjectDeserializer getDeserializer(java.lang.Class<?> r23, java.lang.reflect.Type r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            java.lang.String r3 = "java.util.Optional"
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r0.get(r2)
            if (r4 == 0) goto L_0x000f
            return r4
        L_0x000f:
            if (r2 != 0) goto L_0x0012
            r2 = r1
        L_0x0012:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r0.get(r2)
            if (r4 == 0) goto L_0x0019
            return r4
        L_0x0019:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r5 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r5 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r1, r5)
            com.alibaba.fastjson.annotation.JSONType r5 = (com.alibaba.fastjson.annotation.JSONType) r5
            if (r5 == 0) goto L_0x0030
            java.lang.Class r5 = r5.mappingTo()
            java.lang.Class<java.lang.Void> r6 = java.lang.Void.class
            if (r5 == r6) goto L_0x0030
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r1 = r0.getDeserializer(r5, r5)
            return r1
        L_0x0030:
            boolean r5 = r2 instanceof java.lang.reflect.WildcardType
            if (r5 != 0) goto L_0x003c
            boolean r5 = r2 instanceof java.lang.reflect.TypeVariable
            if (r5 != 0) goto L_0x003c
            boolean r5 = r2 instanceof java.lang.reflect.ParameterizedType
            if (r5 == 0) goto L_0x0040
        L_0x003c:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r22.get(r23)
        L_0x0040:
            if (r4 == 0) goto L_0x0043
            return r4
        L_0x0043:
            java.util.List<com.alibaba.fastjson.spi.Module> r5 = r0.modules
            java.util.Iterator r5 = r5.iterator()
        L_0x0049:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x005f
            java.lang.Object r4 = r5.next()
            com.alibaba.fastjson.spi.Module r4 = (com.alibaba.fastjson.spi.Module) r4
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r4.createDeserializer(r0, r1)
            if (r4 == 0) goto L_0x0049
            r0.putDeserializer(r2, r4)
            return r4
        L_0x005f:
            java.lang.String r5 = r23.getName()
            r6 = 36
            r7 = 46
            java.lang.String r5 = r5.replace(r6, r7)
            java.lang.String r6 = "java.awt."
            boolean r6 = r5.startsWith(r6)
            r7 = 4
            r8 = 0
            r9 = 1
            if (r6 == 0) goto L_0x00a8
            boolean r6 = com.alibaba.fastjson.serializer.AwtCodec.support(r23)
            if (r6 == 0) goto L_0x00a8
            boolean r6 = awtError
            if (r6 != 0) goto L_0x00a8
            java.lang.String r4 = "java.awt.Point"
            java.lang.String r6 = "java.awt.Font"
            java.lang.String r10 = "java.awt.Rectangle"
            java.lang.String r11 = "java.awt.Color"
            java.lang.String[] r4 = new java.lang.String[]{r4, r6, r10, r11}
            r6 = r8
        L_0x008d:
            if (r6 >= r7) goto L_0x00a6
            r10 = r4[r6]     // Catch:{ all -> 0x00a4 }
            boolean r11 = r10.equals(r5)     // Catch:{ all -> 0x00a4 }
            if (r11 == 0) goto L_0x00a1
            java.lang.Class r4 = java.lang.Class.forName(r10)     // Catch:{ all -> 0x00a4 }
            com.alibaba.fastjson.serializer.AwtCodec r6 = com.alibaba.fastjson.serializer.AwtCodec.instance     // Catch:{ all -> 0x00a4 }
            r0.putDeserializer(r4, r6)     // Catch:{ all -> 0x00a4 }
            return r6
        L_0x00a1:
            int r6 = r6 + 1
            goto L_0x008d
        L_0x00a4:
            awtError = r9
        L_0x00a6:
            com.alibaba.fastjson.serializer.AwtCodec r4 = com.alibaba.fastjson.serializer.AwtCodec.instance
        L_0x00a8:
            boolean r6 = jdk8Error
            if (r6 != 0) goto L_0x0114
            java.lang.String r6 = "java.time."
            boolean r6 = r5.startsWith(r6)     // Catch:{ all -> 0x0112 }
            if (r6 == 0) goto L_0x00ea
            r3 = 12
            java.lang.String r10 = "java.time.LocalDateTime"
            java.lang.String r11 = "java.time.LocalDate"
            java.lang.String r12 = "java.time.LocalTime"
            java.lang.String r13 = "java.time.ZonedDateTime"
            java.lang.String r14 = "java.time.OffsetDateTime"
            java.lang.String r15 = "java.time.OffsetTime"
            java.lang.String r16 = "java.time.ZoneOffset"
            java.lang.String r17 = "java.time.ZoneRegion"
            java.lang.String r18 = "java.time.ZoneId"
            java.lang.String r19 = "java.time.Period"
            java.lang.String r20 = "java.time.Duration"
            java.lang.String r21 = "java.time.Instant"
            java.lang.String[] r6 = new java.lang.String[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ all -> 0x0112 }
            r7 = r8
        L_0x00d3:
            if (r7 >= r3) goto L_0x0114
            r10 = r6[r7]     // Catch:{ all -> 0x0112 }
            boolean r11 = r10.equals(r5)     // Catch:{ all -> 0x0112 }
            if (r11 == 0) goto L_0x00e7
            java.lang.Class r3 = java.lang.Class.forName(r10)     // Catch:{ all -> 0x0112 }
            com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec r4 = com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec.instance     // Catch:{ all -> 0x0112 }
            r0.putDeserializer(r3, r4)     // Catch:{ all -> 0x0112 }
            return r4
        L_0x00e7:
            int r7 = r7 + 1
            goto L_0x00d3
        L_0x00ea:
            boolean r6 = r5.startsWith(r3)     // Catch:{ all -> 0x0112 }
            if (r6 == 0) goto L_0x0114
            java.lang.String r6 = "java.util.OptionalDouble"
            java.lang.String r10 = "java.util.OptionalInt"
            java.lang.String r11 = "java.util.OptionalLong"
            java.lang.String[] r3 = new java.lang.String[]{r3, r6, r10, r11}     // Catch:{ all -> 0x0112 }
            r6 = r8
        L_0x00fb:
            if (r6 >= r7) goto L_0x0114
            r10 = r3[r6]     // Catch:{ all -> 0x0112 }
            boolean r11 = r10.equals(r5)     // Catch:{ all -> 0x0112 }
            if (r11 == 0) goto L_0x010f
            java.lang.Class r3 = java.lang.Class.forName(r10)     // Catch:{ all -> 0x0112 }
            com.alibaba.fastjson.parser.deserializer.OptionalCodec r4 = com.alibaba.fastjson.parser.deserializer.OptionalCodec.instance     // Catch:{ all -> 0x0112 }
            r0.putDeserializer(r3, r4)     // Catch:{ all -> 0x0112 }
            return r4
        L_0x010f:
            int r6 = r6 + 1
            goto L_0x00fb
        L_0x0112:
            jdk8Error = r9
        L_0x0114:
            boolean r3 = jodaError
            if (r3 != 0) goto L_0x0152
            java.lang.String r3 = "org.joda.time."
            boolean r3 = r5.startsWith(r3)     // Catch:{ all -> 0x0150 }
            if (r3 == 0) goto L_0x0152
            r3 = 9
            java.lang.String r10 = "org.joda.time.DateTime"
            java.lang.String r11 = "org.joda.time.LocalDate"
            java.lang.String r12 = "org.joda.time.LocalDateTime"
            java.lang.String r13 = "org.joda.time.LocalTime"
            java.lang.String r14 = "org.joda.time.Instant"
            java.lang.String r15 = "org.joda.time.Period"
            java.lang.String r16 = "org.joda.time.Duration"
            java.lang.String r17 = "org.joda.time.DateTimeZone"
            java.lang.String r18 = "org.joda.time.format.DateTimeFormatter"
            java.lang.String[] r6 = new java.lang.String[]{r10, r11, r12, r13, r14, r15, r16, r17, r18}     // Catch:{ all -> 0x0150 }
            r7 = r8
        L_0x0139:
            if (r7 >= r3) goto L_0x0152
            r10 = r6[r7]     // Catch:{ all -> 0x0150 }
            boolean r11 = r10.equals(r5)     // Catch:{ all -> 0x0150 }
            if (r11 == 0) goto L_0x014d
            java.lang.Class r3 = java.lang.Class.forName(r10)     // Catch:{ all -> 0x0150 }
            com.alibaba.fastjson.serializer.JodaCodec r4 = com.alibaba.fastjson.serializer.JodaCodec.instance     // Catch:{ all -> 0x0150 }
            r0.putDeserializer(r3, r4)     // Catch:{ all -> 0x0150 }
            return r4
        L_0x014d:
            int r7 = r7 + 1
            goto L_0x0139
        L_0x0150:
            jodaError = r9
        L_0x0152:
            boolean r3 = guavaError
            if (r3 != 0) goto L_0x0187
            java.lang.String r3 = "com.google.common.collect."
            boolean r3 = r5.startsWith(r3)
            if (r3 == 0) goto L_0x0187
            r3 = 5
            java.lang.String r6 = "com.google.common.collect.HashMultimap"
            java.lang.String r7 = "com.google.common.collect.LinkedListMultimap"
            java.lang.String r10 = "com.google.common.collect.LinkedHashMultimap"
            java.lang.String r11 = "com.google.common.collect.ArrayListMultimap"
            java.lang.String r12 = "com.google.common.collect.TreeMultimap"
            java.lang.String[] r6 = new java.lang.String[]{r6, r7, r10, r11, r12}     // Catch:{ ClassNotFoundException -> 0x0185 }
            r7 = r8
        L_0x016e:
            if (r7 >= r3) goto L_0x0187
            r10 = r6[r7]     // Catch:{ ClassNotFoundException -> 0x0185 }
            boolean r11 = r10.equals(r5)     // Catch:{ ClassNotFoundException -> 0x0185 }
            if (r11 == 0) goto L_0x0182
            java.lang.Class r3 = java.lang.Class.forName(r10)     // Catch:{ ClassNotFoundException -> 0x0185 }
            com.alibaba.fastjson.serializer.GuavaCodec r4 = com.alibaba.fastjson.serializer.GuavaCodec.instance     // Catch:{ ClassNotFoundException -> 0x0185 }
            r0.putDeserializer(r3, r4)     // Catch:{ ClassNotFoundException -> 0x0185 }
            return r4
        L_0x0182:
            int r7 = r7 + 1
            goto L_0x016e
        L_0x0185:
            guavaError = r9
        L_0x0187:
            java.lang.String r3 = "java.nio.ByteBuffer"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0194
            com.alibaba.fastjson.serializer.ByteBufferCodec r4 = com.alibaba.fastjson.serializer.ByteBufferCodec.instance
            r0.putDeserializer(r1, r4)
        L_0x0194:
            java.lang.String r3 = "java.nio.file.Path"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x01a1
            com.alibaba.fastjson.serializer.MiscCodec r4 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.putDeserializer(r1, r4)
        L_0x01a1:
            java.lang.Class<java.util.Map$Entry> r3 = java.util.Map.Entry.class
            if (r1 != r3) goto L_0x01aa
            com.alibaba.fastjson.serializer.MiscCodec r4 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.putDeserializer(r1, r4)
        L_0x01aa:
            java.lang.String r3 = "org.javamoney.moneta.Money"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x01b7
            com.alibaba.fastjson.support.moneta.MonetaCodec r4 = com.alibaba.fastjson.support.moneta.MonetaCodec.instance
            r0.putDeserializer(r1, r4)
        L_0x01b7:
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r3 = r3.getContextClassLoader()
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer> r5 = com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer.class
            java.util.Set r3 = com.alibaba.fastjson.util.ServiceLoader.load(r5, (java.lang.ClassLoader) r3)     // Catch:{ Exception -> 0x01ed }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x01ed }
        L_0x01c9:
            boolean r5 = r3.hasNext()     // Catch:{ Exception -> 0x01ed }
            if (r5 == 0) goto L_0x01ed
            java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x01ed }
            com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer r5 = (com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer) r5     // Catch:{ Exception -> 0x01ed }
            java.util.Set r6 = r5.getAutowiredFor()     // Catch:{ Exception -> 0x01ed }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x01ed }
        L_0x01dd:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x01ed }
            if (r7 == 0) goto L_0x01c9
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x01ed }
            java.lang.reflect.Type r7 = (java.lang.reflect.Type) r7     // Catch:{ Exception -> 0x01ed }
            r0.putDeserializer(r7, r5)     // Catch:{ Exception -> 0x01ed }
            goto L_0x01dd
        L_0x01ed:
            if (r4 != 0) goto L_0x01f3
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r0.get(r2)
        L_0x01f3:
            if (r4 == 0) goto L_0x01f6
            return r4
        L_0x01f6:
            boolean r3 = r23.isEnum()
            if (r3 == 0) goto L_0x0238
            boolean r3 = r0.jacksonCompatible
            if (r3 == 0) goto L_0x021a
            java.lang.reflect.Method[] r3 = r23.getMethods()
            int r4 = r3.length
        L_0x0205:
            if (r8 >= r4) goto L_0x021a
            r5 = r3[r8]
            boolean r5 = com.alibaba.fastjson.util.TypeUtils.isJacksonCreator(r5)
            if (r5 == 0) goto L_0x0217
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r1 = r0.createJavaBeanDeserializer(r1, r2)
            r0.putDeserializer(r2, r1)
            return r1
        L_0x0217:
            int r8 = r8 + 1
            goto L_0x0205
        L_0x021a:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r3 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r3 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r1, r3)
            com.alibaba.fastjson.annotation.JSONType r3 = (com.alibaba.fastjson.annotation.JSONType) r3
            if (r3 == 0) goto L_0x0232
            java.lang.Class r3 = r3.deserializer()
            java.lang.Object r3 = r3.newInstance()     // Catch:{ all -> 0x0232 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r3 = (com.alibaba.fastjson.parser.deserializer.ObjectDeserializer) r3     // Catch:{ all -> 0x0232 }
            r0.putDeserializer(r1, r3)     // Catch:{ all -> 0x0232 }
            return r3
        L_0x0232:
            com.alibaba.fastjson.parser.deserializer.EnumDeserializer r3 = new com.alibaba.fastjson.parser.deserializer.EnumDeserializer
            r3.<init>(r1)
            goto L_0x0296
        L_0x0238:
            boolean r3 = r23.isArray()
            if (r3 == 0) goto L_0x0241
            com.alibaba.fastjson.serializer.ObjectArrayCodec r3 = com.alibaba.fastjson.serializer.ObjectArrayCodec.instance
            goto L_0x0296
        L_0x0241:
            java.lang.Class<java.util.Set> r3 = java.util.Set.class
            if (r1 == r3) goto L_0x0294
            java.lang.Class<java.util.HashSet> r3 = java.util.HashSet.class
            if (r1 == r3) goto L_0x0294
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            if (r1 == r3) goto L_0x0294
            java.lang.Class<java.util.List> r3 = java.util.List.class
            if (r1 == r3) goto L_0x0294
            java.lang.Class<java.util.ArrayList> r3 = java.util.ArrayList.class
            if (r1 != r3) goto L_0x0256
            goto L_0x0294
        L_0x0256:
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L_0x0261
            com.alibaba.fastjson.serializer.CollectionCodec r3 = com.alibaba.fastjson.serializer.CollectionCodec.instance
            goto L_0x0296
        L_0x0261:
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L_0x026c
            com.alibaba.fastjson.parser.deserializer.MapDeserializer r3 = com.alibaba.fastjson.parser.deserializer.MapDeserializer.instance
            goto L_0x0296
        L_0x026c:
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L_0x027a
            com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer r3 = new com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer
            r3.<init>(r0, r1)
            goto L_0x0296
        L_0x027a:
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.PropertyProcessable> r3 = com.alibaba.fastjson.parser.deserializer.PropertyProcessable.class
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L_0x0288
            com.alibaba.fastjson.parser.deserializer.PropertyProcessableDeserializer r3 = new com.alibaba.fastjson.parser.deserializer.PropertyProcessableDeserializer
            r3.<init>(r1)
            goto L_0x0296
        L_0x0288:
            java.lang.Class<java.net.InetAddress> r3 = java.net.InetAddress.class
            if (r1 != r3) goto L_0x028f
            com.alibaba.fastjson.serializer.MiscCodec r3 = com.alibaba.fastjson.serializer.MiscCodec.instance
            goto L_0x0296
        L_0x028f:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r3 = r0.createJavaBeanDeserializer(r1, r2)
            goto L_0x0296
        L_0x0294:
            com.alibaba.fastjson.serializer.CollectionCodec r3 = com.alibaba.fastjson.serializer.CollectionCodec.instance
        L_0x0296:
            r0.putDeserializer(r2, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.ParserConfig.getDeserializer(java.lang.Class, java.lang.reflect.Type):com.alibaba.fastjson.parser.deserializer.ObjectDeserializer");
    }

    public void initJavaBeanDeserializers(Class<?>... clsArr) {
        if (clsArr != null) {
            for (Class<?> cls : clsArr) {
                if (cls != null) {
                    putDeserializer(cls, createJavaBeanDeserializer(cls, cls));
                }
            }
        }
    }

    public ObjectDeserializer createJavaBeanDeserializer(Class<?> cls, Type type) {
        JSONField annotation;
        ASMDeserializerFactory aSMDeserializerFactory;
        boolean z = this.asmEnable & (!this.fieldBased);
        boolean z2 = false;
        if (z) {
            JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class);
            if (jSONType != null) {
                Class<?> deserializer = jSONType.deserializer();
                if (deserializer != Void.class) {
                    try {
                        Object newInstance = deserializer.newInstance();
                        if (newInstance instanceof ObjectDeserializer) {
                            return (ObjectDeserializer) newInstance;
                        }
                    } catch (Throwable unused) {
                    }
                }
                z = jSONType.asm();
            }
            if (z) {
                Class<?> builderClass = JavaBeanInfo.getBuilderClass(cls, jSONType);
                if (builderClass == null) {
                    builderClass = cls;
                }
                while (true) {
                    if (Modifier.isPublic(builderClass.getModifiers())) {
                        builderClass = builderClass.getSuperclass();
                        if (builderClass != Object.class) {
                            if (builderClass == null) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            }
        }
        if (cls.getTypeParameters().length != 0) {
            z = false;
        }
        if (z && (aSMDeserializerFactory = this.asmFactory) != null && aSMDeserializerFactory.classLoader.isExternalClass(cls)) {
            z = false;
        }
        if (z) {
            z = ASMUtils.checkName(cls.getSimpleName());
        }
        if (z) {
            if (cls.isInterface()) {
                z = false;
            }
            JavaBeanInfo build = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean, this.jacksonCompatible);
            if (z && build.fields.length > 200) {
                z = false;
            }
            Constructor<?> constructor = build.defaultConstructor;
            if (z && constructor == null && !cls.isInterface()) {
                z = false;
            }
            FieldInfo[] fieldInfoArr = build.fields;
            int length = fieldInfoArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                FieldInfo fieldInfo = fieldInfoArr[i];
                if (!fieldInfo.getOnly) {
                    Class<?> cls2 = fieldInfo.fieldClass;
                    if (!Modifier.isPublic(cls2.getModifiers()) || ((cls2.isMemberClass() && !Modifier.isStatic(cls2.getModifiers())) || ((fieldInfo.getMember() != null && !ASMUtils.checkName(fieldInfo.getMember().getName())) || (((annotation = fieldInfo.getAnnotation()) != null && (!ASMUtils.checkName(annotation.name()) || annotation.format().length() != 0 || annotation.deserializeUsing() != Void.class || annotation.unwrapped())) || ((fieldInfo.method != null && fieldInfo.method.getParameterTypes().length > 1) || (cls2.isEnum() && !(getDeserializer((Type) cls2) instanceof EnumDeserializer))))))) {
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            z = false;
        }
        if (z && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
            z = false;
        }
        if (!z || !TypeUtils.isXmlField(cls)) {
            z2 = z;
        }
        if (!z2) {
            return new JavaBeanDeserializer(this, cls, type);
        }
        JavaBeanInfo build2 = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy);
        try {
            return this.asmFactory.createJavaBeanDeserializer(this, build2);
        } catch (NoSuchMethodException unused2) {
            return new JavaBeanDeserializer(this, cls, type);
        } catch (JSONException unused3) {
            return new JavaBeanDeserializer(this, build2);
        } catch (Exception e) {
            throw new JSONException("create asm deserializer error, " + cls.getName(), e);
        }
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, FieldInfo fieldInfo) {
        Class<?> deserializeUsing;
        Class<?> cls = javaBeanInfo.clazz;
        Class<?> cls2 = fieldInfo.fieldClass;
        JSONField annotation = fieldInfo.getAnnotation();
        Class<?> cls3 = null;
        if (!(annotation == null || (deserializeUsing = annotation.deserializeUsing()) == Void.class)) {
            cls3 = deserializeUsing;
        }
        if (cls3 == null && (cls2 == List.class || cls2 == ArrayList.class)) {
            return new ArrayListTypeFieldDeserializer(parserConfig, cls, fieldInfo);
        }
        return new DefaultFieldDeserializer(parserConfig, cls, fieldInfo);
    }

    public void putDeserializer(Type type, ObjectDeserializer objectDeserializer) {
        Type mixInAnnotations = JSON.getMixInAnnotations(type);
        if (mixInAnnotations != null) {
            IdentityHashMap identityHashMap = this.mixInDeserializers.get(type);
            if (identityHashMap == null) {
                identityHashMap = new IdentityHashMap(4);
                this.mixInDeserializers.put(type, identityHashMap);
            }
            identityHashMap.put(mixInAnnotations, objectDeserializer);
            return;
        }
        this.deserializers.put(type, objectDeserializer);
    }

    public ObjectDeserializer get(Type type) {
        Type mixInAnnotations = JSON.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            return this.deserializers.get(type);
        }
        IdentityHashMap identityHashMap = this.mixInDeserializers.get(type);
        if (identityHashMap == null) {
            return null;
        }
        return (ObjectDeserializer) identityHashMap.get(mixInAnnotations);
    }

    public ObjectDeserializer getDeserializer(FieldInfo fieldInfo) {
        return getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
    }

    public boolean isPrimitive(Class<?> cls) {
        return isPrimitive2(cls);
    }

    public static boolean isPrimitive2(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == java.util.Date.class || cls == Date.class || cls == Time.class || cls == Timestamp.class || cls.isEnum();
    }

    public static void parserAllFieldToCache(Class<?> cls, Map<String, Field> map) {
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            if (!map.containsKey(name)) {
                map.put(name, field);
            }
        }
        if (cls.getSuperclass() != null && cls.getSuperclass() != Object.class) {
            parserAllFieldToCache(cls.getSuperclass(), map);
        }
    }

    public static Field getFieldFromCache(String str, Map<String, Field> map) {
        Field field = map.get(str);
        if (field == null) {
            field = map.get("_" + str);
        }
        if (field == null) {
            field = map.get("m_" + str);
        }
        if (field != null) {
            return field;
        }
        char charAt = str.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] - ' ');
            field = map.get(new String(charArray));
        }
        if (str.length() <= 2) {
            return field;
        }
        char charAt2 = str.charAt(1);
        if (str.length() <= 2 || charAt < 'a' || charAt > 'z' || charAt2 < 'A' || charAt2 > 'Z') {
            return field;
        }
        for (Map.Entry next : map.entrySet()) {
            if (str.equalsIgnoreCase((String) next.getKey())) {
                return (Field) next.getValue();
            }
        }
        return field;
    }

    public ClassLoader getDefaultClassLoader() {
        return this.defaultClassLoader;
    }

    public void setDefaultClassLoader(ClassLoader classLoader) {
        this.defaultClassLoader = classLoader;
    }

    public void addDeny(String str) {
        if (str != null && str.length() != 0) {
            long fnv1a_64 = TypeUtils.fnv1a_64(str);
            if (Arrays.binarySearch(this.denyHashCodes, fnv1a_64) < 0) {
                long[] jArr = this.denyHashCodes;
                int length = jArr.length + 1;
                long[] jArr2 = new long[length];
                jArr2[length - 1] = fnv1a_64;
                System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
                Arrays.sort(jArr2);
                this.denyHashCodes = jArr2;
            }
        }
    }

    public void addAccept(String str) {
        if (str != null && str.length() != 0) {
            long fnv1a_64 = TypeUtils.fnv1a_64(str);
            if (Arrays.binarySearch(this.acceptHashCodes, fnv1a_64) < 0) {
                long[] jArr = this.acceptHashCodes;
                int length = jArr.length + 1;
                long[] jArr2 = new long[length];
                jArr2[length - 1] = fnv1a_64;
                System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
                Arrays.sort(jArr2);
                this.acceptHashCodes = jArr2;
            }
        }
    }

    public Class<?> checkAutoType(Class cls) {
        if (get(cls) != null) {
            return cls;
        }
        return checkAutoType(cls.getName(), (Class<?>) null, JSON.DEFAULT_PARSER_FEATURE);
    }

    public Class<?> checkAutoType(String str, Class<?> cls) {
        return checkAutoType(str, cls, JSON.DEFAULT_PARSER_FEATURE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: java.lang.Class<?>} */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01f1, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01f2, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01f4, code lost:
        r13 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f1 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:91:0x01da] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<?> checkAutoType(java.lang.String r22, java.lang.Class<?> r23, int r24) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r2 = r23
            r3 = 0
            if (r0 != 0) goto L_0x000a
            return r3
        L_0x000a:
            int r4 = r22.length()
            r5 = 192(0xc0, float:2.69E-43)
            java.lang.String r6 = "autoType is not support. "
            if (r4 >= r5) goto L_0x02ff
            int r4 = r22.length()
            r5 = 3
            if (r4 < r5) goto L_0x02ff
            r4 = 0
            r7 = 1
            if (r2 != 0) goto L_0x0021
        L_0x001f:
            r8 = r4
            goto L_0x003f
        L_0x0021:
            java.lang.Class<java.lang.Object> r8 = java.lang.Object.class
            if (r2 == r8) goto L_0x001f
            java.lang.Class<java.io.Serializable> r8 = java.io.Serializable.class
            if (r2 == r8) goto L_0x001f
            java.lang.Class<java.lang.Cloneable> r8 = java.lang.Cloneable.class
            if (r2 == r8) goto L_0x001f
            java.lang.Class<java.io.Closeable> r8 = java.io.Closeable.class
            if (r2 == r8) goto L_0x001f
            java.lang.Class<java.util.EventListener> r8 = java.util.EventListener.class
            if (r2 == r8) goto L_0x001f
            java.lang.Class<java.lang.Iterable> r8 = java.lang.Iterable.class
            if (r2 == r8) goto L_0x001f
            java.lang.Class<java.util.Collection> r8 = java.util.Collection.class
            if (r2 != r8) goto L_0x003e
            goto L_0x001f
        L_0x003e:
            r8 = r7
        L_0x003f:
            r9 = 36
            r10 = 46
            java.lang.String r9 = r0.replace(r9, r10)
            char r11 = r9.charAt(r4)
            long r11 = (long) r11
            r13 = -3750763034362895579(0xcbf29ce484222325, double:-7.302176725335867E57)
            long r11 = r11 ^ r13
            r15 = 1099511628211(0x100000001b3, double:5.43230922702E-312)
            long r11 = r11 * r15
            r17 = -5808493101479473382(0xaf64164c86024f1a, double:-2.1176223865607047E-80)
            int r17 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r17 == 0) goto L_0x02e9
            int r17 = r9.length()
            int r3 = r17 + -1
            char r3 = r9.charAt(r3)
            r17 = r6
            long r5 = (long) r3
            long r5 = r5 ^ r11
            long r5 = r5 * r15
            r11 = 655701488918567152(0x9198507b5af98f0, double:7.914409534561175E-265)
            int r3 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r3 == 0) goto L_0x02d2
            char r3 = r9.charAt(r4)
            long r5 = (long) r3
            long r5 = r5 ^ r13
            long r5 = r5 * r15
            char r3 = r9.charAt(r7)
            long r11 = (long) r3
            long r5 = r5 ^ r11
            long r5 = r5 * r15
            r3 = 2
            char r3 = r9.charAt(r3)
            long r11 = (long) r3
            long r5 = r5 ^ r11
            long r5 = r5 * r15
            boolean r3 = r1.autoTypeSupport
            if (r3 != 0) goto L_0x009c
            if (r8 == 0) goto L_0x0096
            goto L_0x009c
        L_0x0096:
            r19 = r5
            r4 = r17
            r11 = 0
            goto L_0x00f4
        L_0x009c:
            r12 = r5
            r3 = 3
            r11 = 0
        L_0x009f:
            int r14 = r9.length()
            if (r3 >= r14) goto L_0x00f0
            char r14 = r9.charAt(r3)
            r19 = r5
            long r4 = (long) r14
            long r4 = r4 ^ r12
            long r12 = r4 * r15
            long[] r4 = r1.acceptHashCodes
            int r4 = java.util.Arrays.binarySearch(r4, r12)
            if (r4 < 0) goto L_0x00c0
            java.lang.ClassLoader r4 = r1.defaultClassLoader
            java.lang.Class r11 = com.alibaba.fastjson.util.TypeUtils.loadClass(r0, r4, r7)
            if (r11 == 0) goto L_0x00c0
            return r11
        L_0x00c0:
            long[] r4 = r1.denyHashCodes
            int r4 = java.util.Arrays.binarySearch(r4, r12)
            if (r4 < 0) goto L_0x00e6
            java.lang.Class r4 = com.alibaba.fastjson.util.TypeUtils.getClassFromMapping(r22)
            if (r4 == 0) goto L_0x00cf
            goto L_0x00e6
        L_0x00cf:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = r17
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x00e6:
            r4 = r17
            int r3 = r3 + 1
            r17 = r4
            r5 = r19
            r4 = 0
            goto L_0x009f
        L_0x00f0:
            r19 = r5
            r4 = r17
        L_0x00f4:
            if (r11 != 0) goto L_0x00fa
            java.lang.Class r11 = com.alibaba.fastjson.util.TypeUtils.getClassFromMapping(r22)
        L_0x00fa:
            if (r11 != 0) goto L_0x0102
            com.alibaba.fastjson.util.IdentityHashMap<java.lang.reflect.Type, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer> r3 = r1.deserializers
            java.lang.Class r11 = r3.findClass(r0)
        L_0x0102:
            if (r11 != 0) goto L_0x010d
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r3 = r1.typeMapping
            java.lang.Object r3 = r3.get(r0)
            r11 = r3
            java.lang.Class r11 = (java.lang.Class) r11
        L_0x010d:
            java.lang.String r3 = " -> "
            java.lang.String r5 = "type not match. "
            if (r11 == 0) goto L_0x0140
            if (r2 == 0) goto L_0x013f
            java.lang.Class<java.util.HashMap> r4 = java.util.HashMap.class
            if (r11 == r4) goto L_0x013f
            boolean r4 = r2.isAssignableFrom(r11)
            if (r4 == 0) goto L_0x0120
            goto L_0x013f
        L_0x0120:
            com.alibaba.fastjson.JSONException r4 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            r6.append(r0)
            r6.append(r3)
            java.lang.String r0 = r23.getName()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r4.<init>(r0)
            throw r4
        L_0x013f:
            return r11
        L_0x0140:
            boolean r6 = r1.autoTypeSupport
            if (r6 != 0) goto L_0x01ae
            r6 = 3
        L_0x0145:
            int r12 = r9.length()
            if (r6 >= r12) goto L_0x01ae
            char r12 = r9.charAt(r6)
            long r12 = (long) r12
            long r12 = r19 ^ r12
            long r12 = r12 * r15
            long[] r14 = r1.denyHashCodes
            int r14 = java.util.Arrays.binarySearch(r14, r12)
            if (r14 >= 0) goto L_0x0199
            long[] r14 = r1.acceptHashCodes
            int r14 = java.util.Arrays.binarySearch(r14, r12)
            if (r14 < 0) goto L_0x0194
            if (r11 != 0) goto L_0x016b
            java.lang.ClassLoader r4 = r1.defaultClassLoader
            java.lang.Class r11 = com.alibaba.fastjson.util.TypeUtils.loadClass(r0, r4, r7)
        L_0x016b:
            if (r2 == 0) goto L_0x0193
            boolean r4 = r2.isAssignableFrom(r11)
            if (r4 != 0) goto L_0x0174
            goto L_0x0193
        L_0x0174:
            com.alibaba.fastjson.JSONException r4 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            r6.append(r0)
            r6.append(r3)
            java.lang.String r0 = r23.getName()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r4.<init>(r0)
            throw r4
        L_0x0193:
            return r11
        L_0x0194:
            int r6 = r6 + 1
            r19 = r12
            goto L_0x0145
        L_0x0199:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x01ae:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0204, all -> 0x01fe }
            r6.<init>()     // Catch:{ Exception -> 0x0204, all -> 0x01fe }
            r9 = 47
            java.lang.String r9 = r0.replace(r10, r9)     // Catch:{ Exception -> 0x0204, all -> 0x01fe }
            r6.append(r9)     // Catch:{ Exception -> 0x0204, all -> 0x01fe }
            java.lang.String r9 = ".class"
            r6.append(r9)     // Catch:{ Exception -> 0x0204, all -> 0x01fe }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0204, all -> 0x01fe }
            java.lang.ClassLoader r9 = r1.defaultClassLoader     // Catch:{ Exception -> 0x0204, all -> 0x01fe }
            if (r9 == 0) goto L_0x01ce
            java.io.InputStream r6 = r9.getResourceAsStream(r6)     // Catch:{ Exception -> 0x0204, all -> 0x01fe }
            goto L_0x01d8
        L_0x01ce:
            java.lang.Class<com.alibaba.fastjson.parser.ParserConfig> r9 = com.alibaba.fastjson.parser.ParserConfig.class
            java.lang.ClassLoader r9 = r9.getClassLoader()     // Catch:{ Exception -> 0x0204, all -> 0x01fe }
            java.io.InputStream r6 = r9.getResourceAsStream(r6)     // Catch:{ Exception -> 0x0204, all -> 0x01fe }
        L_0x01d8:
            if (r6 == 0) goto L_0x01f8
            com.alibaba.fastjson.asm.ClassReader r9 = new com.alibaba.fastjson.asm.ClassReader     // Catch:{ Exception -> 0x01f4, all -> 0x01f1 }
            r9.<init>(r6, r7)     // Catch:{ Exception -> 0x01f4, all -> 0x01f1 }
            com.alibaba.fastjson.asm.TypeCollector r10 = new com.alibaba.fastjson.asm.TypeCollector     // Catch:{ Exception -> 0x01f4, all -> 0x01f1 }
            java.lang.String r12 = "<clinit>"
            r13 = 0
            java.lang.Class[] r14 = new java.lang.Class[r13]     // Catch:{ Exception -> 0x01f5, all -> 0x01f1 }
            r10.<init>(r12, r14)     // Catch:{ Exception -> 0x01f5, all -> 0x01f1 }
            r9.accept(r10)     // Catch:{ Exception -> 0x01f5, all -> 0x01f1 }
            boolean r9 = r10.hasJsonType()     // Catch:{ Exception -> 0x01f5, all -> 0x01f1 }
            goto L_0x01fa
        L_0x01f1:
            r0 = move-exception
            r3 = r6
            goto L_0x0200
        L_0x01f4:
            r13 = 0
        L_0x01f5:
            r18 = r6
            goto L_0x0207
        L_0x01f8:
            r13 = 0
            r9 = r13
        L_0x01fa:
            com.alibaba.fastjson.util.IOUtils.close(r6)
            goto L_0x020b
        L_0x01fe:
            r0 = move-exception
            r3 = 0
        L_0x0200:
            com.alibaba.fastjson.util.IOUtils.close(r3)
            throw r0
        L_0x0204:
            r13 = 0
            r18 = 0
        L_0x0207:
            com.alibaba.fastjson.util.IOUtils.close(r18)
            r9 = r13
        L_0x020b:
            com.alibaba.fastjson.parser.Feature r6 = com.alibaba.fastjson.parser.Feature.SupportAutoType
            int r6 = r6.mask
            boolean r10 = r1.autoTypeSupport
            if (r10 != 0) goto L_0x021f
            r10 = r24 & r6
            if (r10 != 0) goto L_0x021f
            int r10 = com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE
            r6 = r6 & r10
            if (r6 == 0) goto L_0x021d
            goto L_0x021f
        L_0x021d:
            r6 = r13
            goto L_0x0220
        L_0x021f:
            r6 = r7
        L_0x0220:
            if (r11 != 0) goto L_0x0233
            if (r6 != 0) goto L_0x0228
            if (r9 != 0) goto L_0x0228
            if (r8 == 0) goto L_0x0233
        L_0x0228:
            if (r6 != 0) goto L_0x022c
            if (r9 == 0) goto L_0x022d
        L_0x022c:
            r13 = r7
        L_0x022d:
            java.lang.ClassLoader r7 = r1.defaultClassLoader
            java.lang.Class r11 = com.alibaba.fastjson.util.TypeUtils.loadClass(r0, r7, r13)
        L_0x0233:
            if (r11 == 0) goto L_0x02b5
            if (r9 == 0) goto L_0x023b
            com.alibaba.fastjson.util.TypeUtils.addMapping(r0, r11)
            return r11
        L_0x023b:
            java.lang.Class<java.lang.ClassLoader> r7 = java.lang.ClassLoader.class
            boolean r7 = r7.isAssignableFrom(r11)
            if (r7 != 0) goto L_0x02a0
            java.lang.Class<javax.sql.DataSource> r7 = javax.sql.DataSource.class
            boolean r7 = r7.isAssignableFrom(r11)
            if (r7 != 0) goto L_0x02a0
            java.lang.Class<javax.sql.RowSet> r7 = javax.sql.RowSet.class
            boolean r7 = r7.isAssignableFrom(r11)
            if (r7 != 0) goto L_0x02a0
            if (r2 == 0) goto L_0x027e
            boolean r4 = r2.isAssignableFrom(r11)
            if (r4 == 0) goto L_0x025f
            com.alibaba.fastjson.util.TypeUtils.addMapping(r0, r11)
            return r11
        L_0x025f:
            com.alibaba.fastjson.JSONException r4 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            r6.append(r0)
            r6.append(r3)
            java.lang.String r0 = r23.getName()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r4.<init>(r0)
            throw r4
        L_0x027e:
            com.alibaba.fastjson.PropertyNamingStrategy r2 = r1.propertyNamingStrategy
            com.alibaba.fastjson.util.JavaBeanInfo r2 = com.alibaba.fastjson.util.JavaBeanInfo.build(r11, r11, r2)
            java.lang.reflect.Constructor<?> r2 = r2.creatorConstructor
            if (r2 == 0) goto L_0x02b5
            if (r6 != 0) goto L_0x028b
            goto L_0x02b5
        L_0x028b:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x02a0:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x02b5:
            if (r6 == 0) goto L_0x02bd
            if (r11 == 0) goto L_0x02bc
            com.alibaba.fastjson.util.TypeUtils.addMapping(r0, r11)
        L_0x02bc:
            return r11
        L_0x02bd:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x02d2:
            r4 = r17
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x02e9:
            r4 = r6
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x02ff:
            r4 = r6
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.ParserConfig.checkAutoType(java.lang.String, java.lang.Class, int):java.lang.Class");
    }

    public void clearDeserializers() {
        this.deserializers.clear();
        initDeserializers();
    }

    public boolean isJacksonCompatible() {
        return this.jacksonCompatible;
    }

    public void setJacksonCompatible(boolean z) {
        this.jacksonCompatible = z;
    }

    public void register(String str, Class cls) {
        this.typeMapping.putIfAbsent(str, cls);
    }

    public void register(Module module) {
        this.modules.add(module);
    }
}
