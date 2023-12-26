package com.alibaba.fastjson;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.FieldSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.TypeUtils;
import com.bonree.sdk.agent.engine.external.FastJsonInstrumentation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

public class JSONPath implements JSONAware {
    static final long LENGTH = -1580386065683472715L;
    static final long SIZE = 5614464919154503228L;
    private static ConcurrentMap<String, JSONPath> pathCache = new ConcurrentHashMap(128, 0.75f, 1);
    private boolean hasRefSegment;
    private ParserConfig parserConfig;
    private final String path;
    private Segment[] segments;
    private SerializeConfig serializeConfig;

    interface Filter {
        boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN,
        And,
        Or,
        REG_MATCH
    }

    interface Segment {
        Object eval(JSONPath jSONPath, Object obj, Object obj2);

        void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context);
    }

    public JSONPath(String str) {
        this(str, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance());
    }

    public JSONPath(String str, SerializeConfig serializeConfig2, ParserConfig parserConfig2) {
        if (str == null || str.length() == 0) {
            throw new JSONPathException("json-path can not be null or empty");
        }
        this.path = str;
        this.serializeConfig = serializeConfig2;
        this.parserConfig = parserConfig2;
    }

    /* access modifiers changed from: protected */
    public void init() {
        if (this.segments == null) {
            if ("*".equals(this.path)) {
                this.segments = new Segment[]{WildCardSegment.instance};
                return;
            }
            JSONPathParser jSONPathParser = new JSONPathParser(this.path);
            this.segments = jSONPathParser.explain();
            this.hasRefSegment = jSONPathParser.hasRefSegment;
        }
    }

    public Object eval(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return obj2;
            }
            obj2 = segmentArr[i].eval(this, obj, obj2);
            i++;
        }
    }

    public Object extract(DefaultJSONParser defaultJSONParser) {
        if (defaultJSONParser == null) {
            return null;
        }
        init();
        if (this.hasRefSegment) {
            return eval(defaultJSONParser.parse());
        }
        if (this.segments.length == 0) {
            return defaultJSONParser.parse();
        }
        Context context = null;
        int i = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return context.object;
            }
            Segment segment = segmentArr[i];
            boolean z = true;
            boolean z2 = i == segmentArr.length - 1;
            if (context == null || context.object == null) {
                if (!z2) {
                    Segment segment2 = this.segments[i + 1];
                    if ((!(segment instanceof PropertySegment) || !((PropertySegment) segment).deep || (!(segment2 instanceof ArrayAccessSegment) && !(segment2 instanceof MultiIndexSegment) && !(segment2 instanceof MultiPropertySegment) && !(segment2 instanceof SizeSegment) && !(segment2 instanceof PropertySegment) && !(segment2 instanceof FilterSegment))) && ((!(segment2 instanceof ArrayAccessSegment) || ((ArrayAccessSegment) segment2).index >= 0) && !(segment2 instanceof FilterSegment) && !(segment instanceof WildCardSegment))) {
                        z = false;
                    }
                }
                Context context2 = new Context(context, z);
                segment.extract(this, defaultJSONParser, context2);
                context = context2;
            } else {
                context.object = segment.eval(this, (Object) null, context.object);
            }
            i++;
        }
    }

    private static class Context {
        final boolean eval;
        Object object;
        final Context parent;

        public Context(Context context, boolean z) {
            this.parent = context;
            this.eval = z;
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        init();
        Object obj2 = obj;
        int i = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return true;
            }
            Object eval = segmentArr[i].eval(this, obj, obj2);
            if (eval == null) {
                return false;
            }
            if (eval == Collections.EMPTY_LIST && (obj2 instanceof List)) {
                return ((List) obj2).contains(eval);
            }
            i++;
            obj2 = eval;
        }
    }

    public boolean containsValue(Object obj, Object obj2) {
        Object eval = eval(obj);
        if (eval == obj2) {
            return true;
        }
        if (eval == null) {
            return false;
        }
        if (!(eval instanceof Iterable)) {
            return eq(eval, obj2);
        }
        for (Object eq : (Iterable) eval) {
            if (eq(eq, obj2)) {
                return true;
            }
        }
        return false;
    }

    public int size(Object obj) {
        if (obj == null) {
            return -1;
        }
        init();
        int i = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return evalSize(obj2);
            }
            obj2 = segmentArr[i].eval(this, obj, obj2);
            i++;
        }
    }

    public Set<?> keySet(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return evalKeySet(obj2);
            }
            obj2 = segmentArr[i].eval(this, obj, obj2);
            i++;
        }
    }

    public void arrayAdd(Object obj, Object... objArr) {
        if (objArr != null && objArr.length != 0 && obj != null) {
            init();
            Object obj2 = null;
            int i = 0;
            Object obj3 = obj;
            int i2 = 0;
            while (true) {
                Segment[] segmentArr = this.segments;
                if (i2 >= segmentArr.length) {
                    break;
                }
                if (i2 == segmentArr.length - 1) {
                    obj2 = obj3;
                }
                obj3 = segmentArr[i2].eval(this, obj, obj3);
                i2++;
            }
            if (obj3 == null) {
                throw new JSONPathException("value not found in path " + this.path);
            } else if (obj3 instanceof Collection) {
                Collection collection = (Collection) obj3;
                int length = objArr.length;
                while (i < length) {
                    collection.add(objArr[i]);
                    i++;
                }
            } else {
                Class<?> cls = obj3.getClass();
                if (cls.isArray()) {
                    int length2 = Array.getLength(obj3);
                    Object newInstance = Array.newInstance(cls.getComponentType(), objArr.length + length2);
                    System.arraycopy(obj3, 0, newInstance, 0, length2);
                    while (i < objArr.length) {
                        Array.set(newInstance, length2 + i, objArr[i]);
                        i++;
                    }
                    Segment[] segmentArr2 = this.segments;
                    Segment segment = segmentArr2[segmentArr2.length - 1];
                    if (segment instanceof PropertySegment) {
                        ((PropertySegment) segment).setValue(this, obj2, newInstance);
                    } else if (segment instanceof ArrayAccessSegment) {
                        ((ArrayAccessSegment) segment).setValue(this, obj2, newInstance);
                    } else {
                        throw new UnsupportedOperationException();
                    }
                } else {
                    throw new JSONException("unsupported array put operation. " + cls);
                }
            }
        }
    }

    public boolean remove(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        init();
        Collection<Object> collection = null;
        Object obj2 = obj;
        int i = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                break;
            } else if (i == segmentArr.length - 1) {
                collection = obj2;
                break;
            } else {
                obj2 = segmentArr[i].eval(this, obj, obj2);
                if (obj2 == null) {
                    break;
                }
                i++;
            }
        }
        if (collection == null) {
            return false;
        }
        Segment[] segmentArr2 = this.segments;
        Segment segment = segmentArr2[segmentArr2.length - 1];
        if (segment instanceof PropertySegment) {
            PropertySegment propertySegment = (PropertySegment) segment;
            if ((collection instanceof Collection) && segmentArr2.length > 1) {
                Segment segment2 = segmentArr2[segmentArr2.length - 2];
                if ((segment2 instanceof RangeSegment) || (segment2 instanceof MultiIndexSegment)) {
                    for (Object remove : collection) {
                        if (propertySegment.remove(this, remove)) {
                            z = true;
                        }
                    }
                    return z;
                }
            }
            return propertySegment.remove(this, collection);
        } else if (segment instanceof ArrayAccessSegment) {
            return ((ArrayAccessSegment) segment).remove(this, collection);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean set(Object obj, Object obj2) {
        return set(obj, obj2, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean set(java.lang.Object r9, java.lang.Object r10, boolean r11) {
        /*
            r8 = this;
            r11 = 0
            if (r9 != 0) goto L_0x0004
            return r11
        L_0x0004:
            r8.init()
            r0 = 0
            r2 = r9
            r1 = r11
            r3 = r0
        L_0x000b:
            com.alibaba.fastjson.JSONPath$Segment[] r4 = r8.segments
            int r5 = r4.length
            r6 = 1
            if (r1 >= r5) goto L_0x0086
            r3 = r4[r1]
            java.lang.Object r4 = r3.eval(r8, r9, r2)
            if (r4 != 0) goto L_0x0081
            com.alibaba.fastjson.JSONPath$Segment[] r4 = r8.segments
            int r5 = r4.length
            int r5 = r5 - r6
            if (r1 >= r5) goto L_0x0024
            int r5 = r1 + 1
            r4 = r4[r5]
            goto L_0x0025
        L_0x0024:
            r4 = r0
        L_0x0025:
            boolean r5 = r4 instanceof com.alibaba.fastjson.JSONPath.PropertySegment
            if (r5 == 0) goto L_0x0061
            boolean r4 = r3 instanceof com.alibaba.fastjson.JSONPath.PropertySegment
            if (r4 == 0) goto L_0x004b
            r4 = r3
            com.alibaba.fastjson.JSONPath$PropertySegment r4 = (com.alibaba.fastjson.JSONPath.PropertySegment) r4
            java.lang.String r4 = r4.propertyName
            java.lang.Class r5 = r2.getClass()
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r5 = r8.getJavaBeanDeserializer(r5)
            if (r5 == 0) goto L_0x004b
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r4 = r5.getFieldDeserializer((java.lang.String) r4)
            com.alibaba.fastjson.util.FieldInfo r4 = r4.fieldInfo
            java.lang.Class<?> r4 = r4.fieldClass
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r5 = r8.getJavaBeanDeserializer(r4)
            goto L_0x004d
        L_0x004b:
            r4 = r0
            r5 = r4
        L_0x004d:
            if (r5 == 0) goto L_0x005b
            com.alibaba.fastjson.util.JavaBeanInfo r7 = r5.beanInfo
            java.lang.reflect.Constructor<?> r7 = r7.defaultConstructor
            if (r7 == 0) goto L_0x005a
            java.lang.Object r4 = r5.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r0, (java.lang.reflect.Type) r4)
            goto L_0x006c
        L_0x005a:
            return r11
        L_0x005b:
            com.alibaba.fastjson.JSONObject r4 = new com.alibaba.fastjson.JSONObject
            r4.<init>()
            goto L_0x006c
        L_0x0061:
            boolean r4 = r4 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment
            if (r4 == 0) goto L_0x006b
            com.alibaba.fastjson.JSONArray r4 = new com.alibaba.fastjson.JSONArray
            r4.<init>()
            goto L_0x006c
        L_0x006b:
            r4 = r0
        L_0x006c:
            if (r4 == 0) goto L_0x0087
            boolean r5 = r3 instanceof com.alibaba.fastjson.JSONPath.PropertySegment
            if (r5 == 0) goto L_0x0078
            com.alibaba.fastjson.JSONPath$PropertySegment r3 = (com.alibaba.fastjson.JSONPath.PropertySegment) r3
            r3.setValue(r8, r2, r4)
            goto L_0x0081
        L_0x0078:
            boolean r5 = r3 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment
            if (r5 == 0) goto L_0x0087
            com.alibaba.fastjson.JSONPath$ArrayAccessSegment r3 = (com.alibaba.fastjson.JSONPath.ArrayAccessSegment) r3
            r3.setValue(r8, r2, r4)
        L_0x0081:
            int r1 = r1 + 1
            r3 = r2
            r2 = r4
            goto L_0x000b
        L_0x0086:
            r2 = r3
        L_0x0087:
            if (r2 != 0) goto L_0x008a
            return r11
        L_0x008a:
            com.alibaba.fastjson.JSONPath$Segment[] r9 = r8.segments
            int r11 = r9.length
            int r11 = r11 - r6
            r9 = r9[r11]
            boolean r11 = r9 instanceof com.alibaba.fastjson.JSONPath.PropertySegment
            if (r11 == 0) goto L_0x009a
            com.alibaba.fastjson.JSONPath$PropertySegment r9 = (com.alibaba.fastjson.JSONPath.PropertySegment) r9
            r9.setValue(r8, r2, r10)
            return r6
        L_0x009a:
            boolean r11 = r9 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment
            if (r11 == 0) goto L_0x00a5
            com.alibaba.fastjson.JSONPath$ArrayAccessSegment r9 = (com.alibaba.fastjson.JSONPath.ArrayAccessSegment) r9
            boolean r9 = r9.setValue(r8, r2, r10)
            return r9
        L_0x00a5:
            java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.set(java.lang.Object, java.lang.Object, boolean):boolean");
    }

    public static Object eval(Object obj, String str) {
        return compile(str).eval(obj);
    }

    public static int size(Object obj, String str) {
        JSONPath compile = compile(str);
        return compile.evalSize(compile.eval(obj));
    }

    public static Set<?> keySet(Object obj, String str) {
        JSONPath compile = compile(str);
        return compile.evalKeySet(compile.eval(obj));
    }

    public static boolean contains(Object obj, String str) {
        if (obj == null) {
            return false;
        }
        return compile(str).contains(obj);
    }

    public static boolean containsValue(Object obj, String str, Object obj2) {
        return compile(str).containsValue(obj, obj2);
    }

    public static void arrayAdd(Object obj, String str, Object... objArr) {
        compile(str).arrayAdd(obj, objArr);
    }

    public static boolean set(Object obj, String str, Object obj2) {
        return compile(str).set(obj, obj2);
    }

    public static boolean remove(Object obj, String str) {
        return compile(str).remove(obj);
    }

    public static JSONPath compile(String str) {
        if (str != null) {
            JSONPath jSONPath = (JSONPath) pathCache.get(str);
            if (jSONPath != null) {
                return jSONPath;
            }
            JSONPath jSONPath2 = new JSONPath(str);
            if (pathCache.size() >= 1024) {
                return jSONPath2;
            }
            pathCache.putIfAbsent(str, jSONPath2);
            return (JSONPath) pathCache.get(str);
        }
        throw new JSONPathException("jsonpath can not be null");
    }

    public static Object read(String str, String str2) {
        return compile(str2).eval(JSON.parse(str));
    }

    public static Object extract(String str, String str2, ParserConfig parserConfig2, int i, Feature... featureArr) {
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig2, i | Feature.OrderedField.mask);
        Object extract = compile(str2).extract(defaultJSONParser);
        defaultJSONParser.lexer.close();
        return extract;
    }

    public static Object extract(String str, String str2) {
        return extract(str, str2, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE, new Feature[0]);
    }

    public static Map<String, Object> paths(Object obj) {
        return paths(obj, SerializeConfig.globalInstance);
    }

    public static Map<String, Object> paths(Object obj, SerializeConfig serializeConfig2) {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        HashMap hashMap = new HashMap();
        paths(identityHashMap, hashMap, ExpiryDateInput.SEPARATOR, obj, serializeConfig2);
        return hashMap;
    }

    private static void paths(Map<Object, String> map, Map<String, Object> map2, String str, Object obj, SerializeConfig serializeConfig2) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        if (obj != null) {
            int i = 0;
            if (map.put(obj, str) != null) {
                if (!((obj instanceof String) || (obj instanceof Number) || (obj instanceof Date) || (obj instanceof UUID))) {
                    return;
                }
            }
            map2.put(str, obj);
            if (obj instanceof Map) {
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    if (key instanceof String) {
                        if (str.equals(ExpiryDateInput.SEPARATOR)) {
                            sb4 = new StringBuilder();
                        } else {
                            sb4 = new StringBuilder();
                            sb4.append(str);
                        }
                        sb4.append(ExpiryDateInput.SEPARATOR);
                        sb4.append(key);
                        paths(map, map2, sb4.toString(), entry.getValue(), serializeConfig2);
                    }
                }
            } else if (obj instanceof Collection) {
                for (Object next : (Collection) obj) {
                    if (str.equals(ExpiryDateInput.SEPARATOR)) {
                        sb3 = new StringBuilder();
                    } else {
                        sb3 = new StringBuilder();
                        sb3.append(str);
                    }
                    sb3.append(ExpiryDateInput.SEPARATOR);
                    sb3.append(i);
                    paths(map, map2, sb3.toString(), next, serializeConfig2);
                    i++;
                }
            } else {
                Class<?> cls = obj.getClass();
                if (cls.isArray()) {
                    int length = Array.getLength(obj);
                    while (i < length) {
                        Object obj2 = Array.get(obj, i);
                        if (str.equals(ExpiryDateInput.SEPARATOR)) {
                            sb2 = new StringBuilder();
                        } else {
                            sb2 = new StringBuilder();
                            sb2.append(str);
                        }
                        sb2.append(ExpiryDateInput.SEPARATOR);
                        sb2.append(i);
                        paths(map, map2, sb2.toString(), obj2, serializeConfig2);
                        i++;
                    }
                } else if (!ParserConfig.isPrimitive2(cls) && !cls.isEnum()) {
                    ObjectSerializer objectWriter = serializeConfig2.getObjectWriter(cls);
                    if (objectWriter instanceof JavaBeanSerializer) {
                        try {
                            for (Map.Entry next2 : ((JavaBeanSerializer) objectWriter).getFieldValuesMap(obj).entrySet()) {
                                String str2 = (String) next2.getKey();
                                if (str2 instanceof String) {
                                    if (str.equals(ExpiryDateInput.SEPARATOR)) {
                                        sb = new StringBuilder();
                                        sb.append(ExpiryDateInput.SEPARATOR);
                                        sb.append(str2);
                                    } else {
                                        sb = new StringBuilder();
                                        sb.append(str);
                                        sb.append(ExpiryDateInput.SEPARATOR);
                                        sb.append(str2);
                                    }
                                    paths(map, map2, sb.toString(), next2.getValue(), serializeConfig2);
                                }
                            }
                        } catch (Exception e) {
                            throw new JSONException("toJSON error", e);
                        }
                    }
                }
            }
        }
    }

    public String getPath() {
        return this.path;
    }

    static class JSONPathParser {
        private char ch;
        /* access modifiers changed from: private */
        public boolean hasRefSegment;
        private int level;
        private final String path;
        private int pos;

        static boolean isDigitFirst(char c) {
            return c == '-' || c == '+' || (c >= '0' && c <= '9');
        }

        public JSONPathParser(String str) {
            this.path = str;
            next();
        }

        /* access modifiers changed from: package-private */
        public void next() {
            String str = this.path;
            int i = this.pos;
            this.pos = i + 1;
            this.ch = str.charAt(i);
        }

        /* access modifiers changed from: package-private */
        public char getNextChar() {
            return this.path.charAt(this.pos);
        }

        /* access modifiers changed from: package-private */
        public boolean isEOF() {
            return this.pos >= this.path.length();
        }

        /* access modifiers changed from: package-private */
        public Segment readSegement() {
            boolean z = true;
            if (this.level == 0 && this.path.length() == 1) {
                if (isDigitFirst(this.ch)) {
                    return new ArrayAccessSegment(this.ch - '0');
                }
                char c = this.ch;
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    return new PropertySegment(Character.toString(c), false);
                }
            }
            while (!isEOF()) {
                skipWhitespace();
                char c2 = this.ch;
                if (c2 == '$') {
                    next();
                } else if (c2 == '.' || c2 == '/') {
                    next();
                    if (c2 == '.' && this.ch == '.') {
                        next();
                        int length = this.path.length();
                        int i = this.pos;
                        if (length > i + 3 && this.ch == '[' && this.path.charAt(i) == '*' && this.path.charAt(this.pos + 1) == ']' && this.path.charAt(this.pos + 2) == '.') {
                            next();
                            next();
                            next();
                            next();
                        }
                    } else {
                        z = false;
                    }
                    char c3 = this.ch;
                    if (c3 == '*') {
                        if (!isEOF()) {
                            next();
                        }
                        return z ? WildCardSegment.instance_deep : WildCardSegment.instance;
                    } else if (isDigitFirst(c3)) {
                        return parseArrayAccess(false);
                    } else {
                        String readName = readName();
                        if (this.ch != '(') {
                            return new PropertySegment(readName, z);
                        }
                        next();
                        if (this.ch == ')') {
                            if (!isEOF()) {
                                next();
                            }
                            if ("size".equals(readName) || "length".equals(readName)) {
                                return SizeSegment.instance;
                            }
                            if ("max".equals(readName)) {
                                return MaxSegment.instance;
                            }
                            if ("min".equals(readName)) {
                                return MinSegment.instance;
                            }
                            if ("keySet".equals(readName)) {
                                return KeySetSegment.instance;
                            }
                            throw new JSONPathException("not support jsonpath : " + this.path);
                        }
                        throw new JSONPathException("not support jsonpath : " + this.path);
                    }
                } else if (c2 == '[') {
                    return parseArrayAccess(true);
                } else {
                    if (this.level == 0) {
                        return new PropertySegment(readName(), false);
                    }
                    throw new JSONPathException("not support jsonpath : " + this.path);
                }
            }
            return null;
        }

        public final void skipWhitespace() {
            while (true) {
                char c = this.ch;
                if (c > ' ') {
                    return;
                }
                if (c == ' ' || c == 13 || c == 10 || c == 9 || c == 12 || c == 8) {
                    next();
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public Segment parseArrayAccess(boolean z) {
            Object parseArrayAccessFilter = parseArrayAccessFilter(z);
            if (parseArrayAccessFilter instanceof Segment) {
                return (Segment) parseArrayAccessFilter;
            }
            return new FilterSegment((Filter) parseArrayAccessFilter);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:280:0x03d6 A[LOOP:10: B:278:0x03d2->B:280:0x03d6, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:285:0x03e4  */
        /* JADX WARNING: Removed duplicated region for block: B:287:0x03e9  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0063  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0067  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:471:0x03da A[EDGE_INSN: B:471:0x03da->B:281:0x03da ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00c0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object parseArrayAccessFilter(boolean r23) {
            /*
                r22 = this;
                r0 = r22
                if (r23 == 0) goto L_0x0009
                r1 = 91
                r0.accept(r1)
            L_0x0009:
                char r1 = r0.ch
                r2 = 63
                r3 = 40
                r4 = 0
                r5 = 1
                if (r1 != r2) goto L_0x001b
                r22.next()
                r0.accept(r3)
                r1 = r5
                goto L_0x001c
            L_0x001b:
                r1 = r4
            L_0x001c:
                r2 = 64
                r6 = 39
                r7 = 92
                r8 = -1
                r9 = 47
                r10 = 46
                r11 = 2
                r12 = 93
                r13 = 41
                if (r1 != 0) goto L_0x00d0
                char r14 = r0.ch
                boolean r14 = com.alibaba.fastjson.util.IOUtils.firstIdentifier(r14)
                if (r14 != 0) goto L_0x00d0
                char r14 = r0.ch
                if (r14 == r7) goto L_0x00d0
                if (r14 != r2) goto L_0x003e
                goto L_0x00d0
            L_0x003e:
                int r2 = r0.pos
                int r2 = r2 - r5
            L_0x0041:
                char r3 = r0.ch
                if (r3 == r12) goto L_0x0061
                if (r3 == r9) goto L_0x0061
                boolean r3 = r22.isEOF()
                if (r3 != 0) goto L_0x0061
                char r3 = r0.ch
                if (r3 != r10) goto L_0x0058
                if (r1 != 0) goto L_0x0058
                if (r1 != 0) goto L_0x0058
                if (r14 == r6) goto L_0x0058
                goto L_0x0061
            L_0x0058:
                if (r3 != r7) goto L_0x005d
                r22.next()
            L_0x005d:
                r22.next()
                goto L_0x0041
            L_0x0061:
                if (r23 == 0) goto L_0x0067
                int r3 = r0.pos
            L_0x0065:
                int r3 = r3 - r5
                goto L_0x0074
            L_0x0067:
                char r3 = r0.ch
                if (r3 == r9) goto L_0x0071
                if (r3 != r10) goto L_0x006e
                goto L_0x0071
            L_0x006e:
                int r3 = r0.pos
                goto L_0x0074
            L_0x0071:
                int r3 = r0.pos
                goto L_0x0065
            L_0x0074:
                java.lang.String r7 = r0.path
                java.lang.String r2 = r7.substring(r2, r3)
                java.lang.String r3 = "\\."
                int r7 = r2.indexOf(r3)
                if (r7 == r8) goto L_0x00c0
                if (r14 != r6) goto L_0x009f
                int r6 = r2.length()
                if (r6 <= r11) goto L_0x009f
                int r6 = r2.length()
                int r6 = r6 - r5
                char r6 = r2.charAt(r6)
                if (r6 != r14) goto L_0x009f
                int r3 = r2.length()
                int r3 = r3 - r5
                java.lang.String r2 = r2.substring(r5, r3)
                goto L_0x00b5
            L_0x009f:
                java.lang.String r5 = "\\\\\\."
                java.lang.String r2 = r2.replaceAll(r5, r3)
                java.lang.String r3 = "\\-"
                int r3 = r2.indexOf(r3)
                if (r3 == r8) goto L_0x00b5
                java.lang.String r3 = "\\\\-"
                java.lang.String r5 = "-"
                java.lang.String r2 = r2.replaceAll(r3, r5)
            L_0x00b5:
                if (r1 == 0) goto L_0x00ba
                r0.accept(r13)
            L_0x00ba:
                com.alibaba.fastjson.JSONPath$PropertySegment r1 = new com.alibaba.fastjson.JSONPath$PropertySegment
                r1.<init>(r2, r4)
                return r1
            L_0x00c0:
                com.alibaba.fastjson.JSONPath$Segment r1 = r0.buildArraySegement(r2)
                if (r23 == 0) goto L_0x00cf
                boolean r2 = r22.isEOF()
                if (r2 != 0) goto L_0x00cf
                r0.accept(r12)
            L_0x00cf:
                return r1
            L_0x00d0:
                char r14 = r0.ch
                if (r14 != r2) goto L_0x00da
                r22.next()
                r0.accept(r10)
            L_0x00da:
                java.lang.String r2 = r22.readName()
                r22.skipWhitespace()
                r14 = 124(0x7c, float:1.74E-43)
                r15 = 38
                r3 = 32
                if (r1 == 0) goto L_0x010b
                char r11 = r0.ch
                if (r11 != r13) goto L_0x010b
                r22.next()
                com.alibaba.fastjson.JSONPath$NotNullSegement r1 = new com.alibaba.fastjson.JSONPath$NotNullSegement
                r1.<init>(r2)
            L_0x00f5:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x00fd
                r22.next()
                goto L_0x00f5
            L_0x00fd:
                if (r2 == r15) goto L_0x0101
                if (r2 != r14) goto L_0x0105
            L_0x0101:
                com.alibaba.fastjson.JSONPath$Filter r1 = r0.filterRest(r1)
            L_0x0105:
                if (r23 == 0) goto L_0x010a
                r0.accept(r12)
            L_0x010a:
                return r1
            L_0x010b:
                if (r23 == 0) goto L_0x0137
                char r11 = r0.ch
                if (r11 != r12) goto L_0x0137
                r22.next()
                com.alibaba.fastjson.JSONPath$NotNullSegement r4 = new com.alibaba.fastjson.JSONPath$NotNullSegement
                r4.<init>(r2)
            L_0x0119:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x0121
                r22.next()
                goto L_0x0119
            L_0x0121:
                if (r2 == r15) goto L_0x0125
                if (r2 != r14) goto L_0x0129
            L_0x0125:
                com.alibaba.fastjson.JSONPath$Filter r4 = r0.filterRest(r4)
            L_0x0129:
                r0.accept(r13)
                if (r1 == 0) goto L_0x0131
                r0.accept(r13)
            L_0x0131:
                if (r23 == 0) goto L_0x0136
                r0.accept(r12)
            L_0x0136:
                return r4
            L_0x0137:
                com.alibaba.fastjson.JSONPath$Operator r11 = r22.readOp()
                r22.skipWhitespace()
                com.alibaba.fastjson.JSONPath$Operator r8 = com.alibaba.fastjson.JSONPath.Operator.BETWEEN
                if (r11 == r8) goto L_0x05c9
                com.alibaba.fastjson.JSONPath$Operator r8 = com.alibaba.fastjson.JSONPath.Operator.NOT_BETWEEN
                if (r11 != r8) goto L_0x0148
                goto L_0x05c9
            L_0x0148:
                com.alibaba.fastjson.JSONPath$Operator r8 = com.alibaba.fastjson.JSONPath.Operator.IN
                if (r11 == r8) goto L_0x03ed
                com.alibaba.fastjson.JSONPath$Operator r8 = com.alibaba.fastjson.JSONPath.Operator.NOT_IN
                if (r11 != r8) goto L_0x0152
                goto L_0x03ed
            L_0x0152:
                char r8 = r0.ch
                r16 = 0
                if (r8 == r6) goto L_0x02ef
                r6 = 34
                if (r8 != r6) goto L_0x015e
                goto L_0x02ef
            L_0x015e:
                boolean r6 = isDigitFirst(r8)
                if (r6 == 0) goto L_0x019e
                long r4 = r22.readLongValue()
                char r6 = r0.ch
                r7 = 0
                if (r6 != r10) goto L_0x0173
                double r9 = r0.readDoubleValue(r4)
                goto L_0x0174
            L_0x0173:
                r9 = r7
            L_0x0174:
                int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                if (r6 != 0) goto L_0x017e
                com.alibaba.fastjson.JSONPath$IntOpSegement r6 = new com.alibaba.fastjson.JSONPath$IntOpSegement
                r6.<init>(r2, r4, r11)
                goto L_0x0183
            L_0x017e:
                com.alibaba.fastjson.JSONPath$DoubleOpSegement r6 = new com.alibaba.fastjson.JSONPath$DoubleOpSegement
                r6.<init>(r2, r9, r11)
            L_0x0183:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x018b
                r22.next()
                goto L_0x0183
            L_0x018b:
                if (r2 == r15) goto L_0x018f
                if (r2 != r14) goto L_0x0193
            L_0x018f:
                com.alibaba.fastjson.JSONPath$Filter r6 = r0.filterRest(r6)
            L_0x0193:
                if (r1 == 0) goto L_0x0198
                r0.accept(r13)
            L_0x0198:
                if (r23 == 0) goto L_0x019d
                r0.accept(r12)
            L_0x019d:
                return r6
            L_0x019e:
                char r6 = r0.ch
                r8 = 36
                if (r6 != r8) goto L_0x01c2
                com.alibaba.fastjson.JSONPath$Segment r4 = r22.readSegement()
                com.alibaba.fastjson.JSONPath$RefOpSegement r6 = new com.alibaba.fastjson.JSONPath$RefOpSegement
                r6.<init>(r2, r4, r11)
                r0.hasRefSegment = r5
            L_0x01af:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x01b7
                r22.next()
                goto L_0x01af
            L_0x01b7:
                if (r1 == 0) goto L_0x01bc
                r0.accept(r13)
            L_0x01bc:
                if (r23 == 0) goto L_0x01c1
                r0.accept(r12)
            L_0x01c1:
                return r6
            L_0x01c2:
                if (r6 != r9) goto L_0x0204
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
            L_0x01c9:
                r22.next()
                char r3 = r0.ch
                if (r3 != r9) goto L_0x01f5
                r22.next()
                char r3 = r0.ch
                r5 = 105(0x69, float:1.47E-43)
                if (r3 != r5) goto L_0x01dd
                r22.next()
                r4 = 2
            L_0x01dd:
                java.lang.String r3 = r8.toString()
                java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3, r4)
                com.alibaba.fastjson.JSONPath$RegMatchSegement r4 = new com.alibaba.fastjson.JSONPath$RegMatchSegement
                r4.<init>(r2, r3, r11)
                if (r1 == 0) goto L_0x01ef
                r0.accept(r13)
            L_0x01ef:
                if (r23 == 0) goto L_0x01f4
                r0.accept(r12)
            L_0x01f4:
                return r4
            L_0x01f5:
                if (r3 != r7) goto L_0x0200
                r22.next()
                char r3 = r0.ch
                r8.append(r3)
                goto L_0x01c9
            L_0x0200:
                r8.append(r3)
                goto L_0x01c9
            L_0x0204:
                r7 = 110(0x6e, float:1.54E-43)
                if (r6 != r7) goto L_0x024d
                java.lang.String r4 = r22.readName()
                java.lang.String r5 = "null"
                boolean r4 = r5.equals(r4)
                if (r4 == 0) goto L_0x02e9
                com.alibaba.fastjson.JSONPath$Operator r4 = com.alibaba.fastjson.JSONPath.Operator.EQ
                if (r11 != r4) goto L_0x021e
                com.alibaba.fastjson.JSONPath$NullSegement r4 = new com.alibaba.fastjson.JSONPath$NullSegement
                r4.<init>(r2)
                goto L_0x022a
            L_0x021e:
                com.alibaba.fastjson.JSONPath$Operator r4 = com.alibaba.fastjson.JSONPath.Operator.NE
                if (r11 != r4) goto L_0x0228
                com.alibaba.fastjson.JSONPath$NotNullSegement r4 = new com.alibaba.fastjson.JSONPath$NotNullSegement
                r4.<init>(r2)
                goto L_0x022a
            L_0x0228:
                r4 = r16
            L_0x022a:
                if (r4 == 0) goto L_0x023c
            L_0x022c:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x0234
                r22.next()
                goto L_0x022c
            L_0x0234:
                if (r2 == r15) goto L_0x0238
                if (r2 != r14) goto L_0x023c
            L_0x0238:
                com.alibaba.fastjson.JSONPath$Filter r4 = r0.filterRest(r4)
            L_0x023c:
                if (r1 == 0) goto L_0x0241
                r0.accept(r13)
            L_0x0241:
                r0.accept(r12)
                if (r4 == 0) goto L_0x0247
                return r4
            L_0x0247:
                java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
                r1.<init>()
                throw r1
            L_0x024d:
                r7 = 116(0x74, float:1.63E-43)
                if (r6 != r7) goto L_0x029b
                java.lang.String r6 = r22.readName()
                java.lang.String r7 = "true"
                boolean r6 = r7.equals(r6)
                if (r6 == 0) goto L_0x02e9
                com.alibaba.fastjson.JSONPath$Operator r6 = com.alibaba.fastjson.JSONPath.Operator.EQ
                if (r11 != r6) goto L_0x0269
                com.alibaba.fastjson.JSONPath$ValueSegment r4 = new com.alibaba.fastjson.JSONPath$ValueSegment
                java.lang.Boolean r6 = java.lang.Boolean.TRUE
                r4.<init>(r2, r6, r5)
                goto L_0x0278
            L_0x0269:
                com.alibaba.fastjson.JSONPath$Operator r5 = com.alibaba.fastjson.JSONPath.Operator.NE
                if (r11 != r5) goto L_0x0276
                com.alibaba.fastjson.JSONPath$ValueSegment r5 = new com.alibaba.fastjson.JSONPath$ValueSegment
                java.lang.Boolean r6 = java.lang.Boolean.TRUE
                r5.<init>(r2, r6, r4)
                r4 = r5
                goto L_0x0278
            L_0x0276:
                r4 = r16
            L_0x0278:
                if (r4 == 0) goto L_0x028a
            L_0x027a:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x0282
                r22.next()
                goto L_0x027a
            L_0x0282:
                if (r2 == r15) goto L_0x0286
                if (r2 != r14) goto L_0x028a
            L_0x0286:
                com.alibaba.fastjson.JSONPath$Filter r4 = r0.filterRest(r4)
            L_0x028a:
                if (r1 == 0) goto L_0x028f
                r0.accept(r13)
            L_0x028f:
                r0.accept(r12)
                if (r4 == 0) goto L_0x0295
                return r4
            L_0x0295:
                java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
                r1.<init>()
                throw r1
            L_0x029b:
                r7 = 102(0x66, float:1.43E-43)
                if (r6 != r7) goto L_0x02e9
                java.lang.String r6 = r22.readName()
                java.lang.String r7 = "false"
                boolean r6 = r7.equals(r6)
                if (r6 == 0) goto L_0x02e9
                com.alibaba.fastjson.JSONPath$Operator r6 = com.alibaba.fastjson.JSONPath.Operator.EQ
                if (r11 != r6) goto L_0x02b7
                com.alibaba.fastjson.JSONPath$ValueSegment r4 = new com.alibaba.fastjson.JSONPath$ValueSegment
                java.lang.Boolean r6 = java.lang.Boolean.FALSE
                r4.<init>(r2, r6, r5)
                goto L_0x02c6
            L_0x02b7:
                com.alibaba.fastjson.JSONPath$Operator r5 = com.alibaba.fastjson.JSONPath.Operator.NE
                if (r11 != r5) goto L_0x02c4
                com.alibaba.fastjson.JSONPath$ValueSegment r5 = new com.alibaba.fastjson.JSONPath$ValueSegment
                java.lang.Boolean r6 = java.lang.Boolean.FALSE
                r5.<init>(r2, r6, r4)
                r4 = r5
                goto L_0x02c6
            L_0x02c4:
                r4 = r16
            L_0x02c6:
                if (r4 == 0) goto L_0x02d8
            L_0x02c8:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x02d0
                r22.next()
                goto L_0x02c8
            L_0x02d0:
                if (r2 == r15) goto L_0x02d4
                if (r2 != r14) goto L_0x02d8
            L_0x02d4:
                com.alibaba.fastjson.JSONPath$Filter r4 = r0.filterRest(r4)
            L_0x02d8:
                if (r1 == 0) goto L_0x02dd
                r0.accept(r13)
            L_0x02dd:
                r0.accept(r12)
                if (r4 == 0) goto L_0x02e3
                return r4
            L_0x02e3:
                java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
                r1.<init>()
                throw r1
            L_0x02e9:
                java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
                r1.<init>()
                throw r1
            L_0x02ef:
                java.lang.String r6 = r22.readString()
                com.alibaba.fastjson.JSONPath$Operator r7 = com.alibaba.fastjson.JSONPath.Operator.RLIKE
                if (r11 != r7) goto L_0x02ff
                com.alibaba.fastjson.JSONPath$RlikeSegement r5 = new com.alibaba.fastjson.JSONPath$RlikeSegement
                r5.<init>(r2, r6, r4)
            L_0x02fc:
                r6 = r15
                goto L_0x03d2
            L_0x02ff:
                com.alibaba.fastjson.JSONPath$Operator r7 = com.alibaba.fastjson.JSONPath.Operator.NOT_RLIKE
                if (r11 != r7) goto L_0x030a
                com.alibaba.fastjson.JSONPath$RlikeSegement r4 = new com.alibaba.fastjson.JSONPath$RlikeSegement
                r4.<init>(r2, r6, r5)
                r5 = r4
                goto L_0x02fc
            L_0x030a:
                com.alibaba.fastjson.JSONPath$Operator r7 = com.alibaba.fastjson.JSONPath.Operator.LIKE
                if (r11 == r7) goto L_0x0319
                com.alibaba.fastjson.JSONPath$Operator r7 = com.alibaba.fastjson.JSONPath.Operator.NOT_LIKE
                if (r11 != r7) goto L_0x0313
                goto L_0x0319
            L_0x0313:
                com.alibaba.fastjson.JSONPath$StringOpSegement r5 = new com.alibaba.fastjson.JSONPath$StringOpSegement
                r5.<init>(r2, r6, r11)
                goto L_0x02fc
            L_0x0319:
                java.lang.String r7 = "%%"
                int r8 = r6.indexOf(r7)
                java.lang.String r9 = "%"
                r10 = -1
                if (r8 == r10) goto L_0x0329
                java.lang.String r6 = r6.replaceAll(r7, r9)
                goto L_0x0319
            L_0x0329:
                com.alibaba.fastjson.JSONPath$Operator r7 = com.alibaba.fastjson.JSONPath.Operator.NOT_LIKE
                if (r11 != r7) goto L_0x0330
                r20 = r5
                goto L_0x0332
            L_0x0330:
                r20 = r4
            L_0x0332:
                r7 = 37
                int r8 = r6.indexOf(r7)
                if (r8 != r10) goto L_0x0349
                com.alibaba.fastjson.JSONPath$Operator r4 = com.alibaba.fastjson.JSONPath.Operator.LIKE
                if (r11 != r4) goto L_0x0341
                com.alibaba.fastjson.JSONPath$Operator r4 = com.alibaba.fastjson.JSONPath.Operator.EQ
                goto L_0x0343
            L_0x0341:
                com.alibaba.fastjson.JSONPath$Operator r4 = com.alibaba.fastjson.JSONPath.Operator.NE
            L_0x0343:
                com.alibaba.fastjson.JSONPath$StringOpSegement r5 = new com.alibaba.fastjson.JSONPath$StringOpSegement
                r5.<init>(r2, r6, r4)
                goto L_0x02fc
            L_0x0349:
                java.lang.String[] r9 = r6.split(r9)
                if (r8 != 0) goto L_0x0386
                int r8 = r6.length()
                int r8 = r8 - r5
                char r6 = r6.charAt(r8)
                if (r6 != r7) goto L_0x0369
                int r6 = r9.length
                int r6 = r6 - r5
                java.lang.String[] r7 = new java.lang.String[r6]
                java.lang.System.arraycopy(r9, r5, r7, r4, r6)
                r19 = r7
            L_0x0363:
                r17 = r16
                r18 = r17
                goto L_0x03c8
            L_0x0369:
                int r6 = r9.length
                int r6 = r6 - r5
                r6 = r9[r6]
                int r7 = r9.length
                r8 = 2
                if (r7 <= r8) goto L_0x037f
                int r7 = r9.length
                int r7 = r7 - r8
                java.lang.String[] r8 = new java.lang.String[r7]
                java.lang.System.arraycopy(r9, r5, r8, r4, r7)
                r18 = r6
                r19 = r8
                r17 = r16
                goto L_0x03c8
            L_0x037f:
                r18 = r6
                r17 = r16
                r19 = r17
                goto L_0x03c8
            L_0x0386:
                int r8 = r6.length()
                int r8 = r8 - r5
                char r6 = r6.charAt(r8)
                if (r6 != r7) goto L_0x039a
                int r6 = r9.length
                if (r6 != r5) goto L_0x0397
                r4 = r9[r4]
                goto L_0x039f
            L_0x0397:
                r19 = r9
                goto L_0x0363
            L_0x039a:
                int r6 = r9.length
                if (r6 != r5) goto L_0x03a6
                r4 = r9[r4]
            L_0x039f:
                r17 = r4
                r18 = r16
                r19 = r18
                goto L_0x03c8
            L_0x03a6:
                int r6 = r9.length
                r7 = 2
                if (r6 != r7) goto L_0x03b5
                r4 = r9[r4]
                r5 = r9[r5]
                r17 = r4
                r18 = r5
                r19 = r16
                goto L_0x03c8
            L_0x03b5:
                r6 = r9[r4]
                int r8 = r9.length
                int r8 = r8 - r5
                r8 = r9[r8]
                int r10 = r9.length
                int r10 = r10 - r7
                java.lang.String[] r7 = new java.lang.String[r10]
                java.lang.System.arraycopy(r9, r5, r7, r4, r10)
                r17 = r6
                r19 = r7
                r18 = r8
            L_0x03c8:
                com.alibaba.fastjson.JSONPath$MatchSegement r4 = new com.alibaba.fastjson.JSONPath$MatchSegement
                r6 = r15
                r15 = r4
                r16 = r2
                r15.<init>(r16, r17, r18, r19, r20)
                r5 = r4
            L_0x03d2:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x03da
                r22.next()
                goto L_0x03d2
            L_0x03da:
                if (r2 == r6) goto L_0x03de
                if (r2 != r14) goto L_0x03e2
            L_0x03de:
                com.alibaba.fastjson.JSONPath$Filter r5 = r0.filterRest(r5)
            L_0x03e2:
                if (r1 == 0) goto L_0x03e7
                r0.accept(r13)
            L_0x03e7:
                if (r23 == 0) goto L_0x03ec
                r0.accept(r12)
            L_0x03ec:
                return r5
            L_0x03ed:
                r6 = r15
                com.alibaba.fastjson.JSONPath$Operator r7 = com.alibaba.fastjson.JSONPath.Operator.NOT_IN
                if (r11 != r7) goto L_0x03f4
                r7 = r5
                goto L_0x03f5
            L_0x03f4:
                r7 = r4
            L_0x03f5:
                r8 = 40
                r0.accept(r8)
                com.alibaba.fastjson.JSONArray r8 = new com.alibaba.fastjson.JSONArray
                r8.<init>()
                java.lang.Object r9 = r22.readValue()
                r8.add(r9)
            L_0x0406:
                r22.skipWhitespace()
                char r9 = r0.ch
                r10 = 44
                if (r9 == r10) goto L_0x05bb
                java.util.Iterator r9 = r8.iterator()
                r10 = r5
                r11 = r10
                r15 = r11
            L_0x0416:
                boolean r16 = r9.hasNext()
                if (r16 == 0) goto L_0x044a
                java.lang.Object r16 = r9.next()
                if (r16 != 0) goto L_0x0426
                if (r10 == 0) goto L_0x0416
                r10 = r4
                goto L_0x0416
            L_0x0426:
                java.lang.Class r12 = r16.getClass()
                if (r10 == 0) goto L_0x043e
                java.lang.Class<java.lang.Byte> r13 = java.lang.Byte.class
                if (r12 == r13) goto L_0x043e
                java.lang.Class<java.lang.Short> r13 = java.lang.Short.class
                if (r12 == r13) goto L_0x043e
                java.lang.Class<java.lang.Integer> r13 = java.lang.Integer.class
                if (r12 == r13) goto L_0x043e
                java.lang.Class<java.lang.Long> r13 = java.lang.Long.class
                if (r12 == r13) goto L_0x043e
                r10 = r4
                r15 = r10
            L_0x043e:
                if (r11 == 0) goto L_0x0445
                java.lang.Class<java.lang.String> r13 = java.lang.String.class
                if (r12 == r13) goto L_0x0445
                r11 = r4
            L_0x0445:
                r12 = 93
                r13 = 41
                goto L_0x0416
            L_0x044a:
                int r9 = r8.size()
                if (r9 != r5) goto L_0x0485
                java.lang.Object r9 = r8.get(r4)
                if (r9 != 0) goto L_0x0485
                if (r7 == 0) goto L_0x045e
                com.alibaba.fastjson.JSONPath$NotNullSegement r4 = new com.alibaba.fastjson.JSONPath$NotNullSegement
                r4.<init>(r2)
                goto L_0x0463
            L_0x045e:
                com.alibaba.fastjson.JSONPath$NullSegement r4 = new com.alibaba.fastjson.JSONPath$NullSegement
                r4.<init>(r2)
            L_0x0463:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x046b
                r22.next()
                goto L_0x0463
            L_0x046b:
                if (r2 == r6) goto L_0x046f
                if (r2 != r14) goto L_0x0473
            L_0x046f:
                com.alibaba.fastjson.JSONPath$Filter r4 = r0.filterRest(r4)
            L_0x0473:
                r2 = 41
                r0.accept(r2)
                if (r1 == 0) goto L_0x047d
                r0.accept(r2)
            L_0x047d:
                if (r23 == 0) goto L_0x0484
                r1 = 93
                r0.accept(r1)
            L_0x0484:
                return r4
            L_0x0485:
                if (r10 == 0) goto L_0x0503
                int r9 = r8.size()
                if (r9 != r5) goto L_0x04c5
                java.lang.Object r4 = r8.get(r4)
                java.lang.Number r4 = (java.lang.Number) r4
                long r4 = com.alibaba.fastjson.util.TypeUtils.longExtractValue(r4)
                if (r7 == 0) goto L_0x049c
                com.alibaba.fastjson.JSONPath$Operator r7 = com.alibaba.fastjson.JSONPath.Operator.NE
                goto L_0x049e
            L_0x049c:
                com.alibaba.fastjson.JSONPath$Operator r7 = com.alibaba.fastjson.JSONPath.Operator.EQ
            L_0x049e:
                com.alibaba.fastjson.JSONPath$IntOpSegement r8 = new com.alibaba.fastjson.JSONPath$IntOpSegement
                r8.<init>(r2, r4, r7)
            L_0x04a3:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x04ab
                r22.next()
                goto L_0x04a3
            L_0x04ab:
                if (r2 == r6) goto L_0x04af
                if (r2 != r14) goto L_0x04b3
            L_0x04af:
                com.alibaba.fastjson.JSONPath$Filter r8 = r0.filterRest(r8)
            L_0x04b3:
                r2 = 41
                r0.accept(r2)
                if (r1 == 0) goto L_0x04bd
                r0.accept(r2)
            L_0x04bd:
                if (r23 == 0) goto L_0x04c4
                r1 = 93
                r0.accept(r1)
            L_0x04c4:
                return r8
            L_0x04c5:
                int r5 = r8.size()
                long[] r9 = new long[r5]
            L_0x04cb:
                if (r4 >= r5) goto L_0x04dc
                java.lang.Object r10 = r8.get(r4)
                java.lang.Number r10 = (java.lang.Number) r10
                long r10 = com.alibaba.fastjson.util.TypeUtils.longExtractValue(r10)
                r9[r4] = r10
                int r4 = r4 + 1
                goto L_0x04cb
            L_0x04dc:
                com.alibaba.fastjson.JSONPath$IntInSegement r4 = new com.alibaba.fastjson.JSONPath$IntInSegement
                r4.<init>(r2, r9, r7)
            L_0x04e1:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x04e9
                r22.next()
                goto L_0x04e1
            L_0x04e9:
                if (r2 == r6) goto L_0x04ed
                if (r2 != r14) goto L_0x04f1
            L_0x04ed:
                com.alibaba.fastjson.JSONPath$Filter r4 = r0.filterRest(r4)
            L_0x04f1:
                r2 = 41
                r0.accept(r2)
                if (r1 == 0) goto L_0x04fb
                r0.accept(r2)
            L_0x04fb:
                if (r23 == 0) goto L_0x0502
                r1 = 93
                r0.accept(r1)
            L_0x0502:
                return r4
            L_0x0503:
                if (r11 == 0) goto L_0x056f
                int r9 = r8.size()
                if (r9 != r5) goto L_0x053f
                java.lang.Object r4 = r8.get(r4)
                java.lang.String r4 = (java.lang.String) r4
                if (r7 == 0) goto L_0x0516
                com.alibaba.fastjson.JSONPath$Operator r5 = com.alibaba.fastjson.JSONPath.Operator.NE
                goto L_0x0518
            L_0x0516:
                com.alibaba.fastjson.JSONPath$Operator r5 = com.alibaba.fastjson.JSONPath.Operator.EQ
            L_0x0518:
                com.alibaba.fastjson.JSONPath$StringOpSegement r7 = new com.alibaba.fastjson.JSONPath$StringOpSegement
                r7.<init>(r2, r4, r5)
            L_0x051d:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x0525
                r22.next()
                goto L_0x051d
            L_0x0525:
                if (r2 == r6) goto L_0x0529
                if (r2 != r14) goto L_0x052d
            L_0x0529:
                com.alibaba.fastjson.JSONPath$Filter r7 = r0.filterRest(r7)
            L_0x052d:
                r2 = 41
                r0.accept(r2)
                if (r1 == 0) goto L_0x0537
                r0.accept(r2)
            L_0x0537:
                if (r23 == 0) goto L_0x053e
                r1 = 93
                r0.accept(r1)
            L_0x053e:
                return r7
            L_0x053f:
                int r4 = r8.size()
                java.lang.String[] r4 = new java.lang.String[r4]
                r8.toArray(r4)
                com.alibaba.fastjson.JSONPath$StringInSegement r5 = new com.alibaba.fastjson.JSONPath$StringInSegement
                r5.<init>(r2, r4, r7)
            L_0x054d:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x0555
                r22.next()
                goto L_0x054d
            L_0x0555:
                if (r2 == r6) goto L_0x0559
                if (r2 != r14) goto L_0x055d
            L_0x0559:
                com.alibaba.fastjson.JSONPath$Filter r5 = r0.filterRest(r5)
            L_0x055d:
                r2 = 41
                r0.accept(r2)
                if (r1 == 0) goto L_0x0567
                r0.accept(r2)
            L_0x0567:
                if (r23 == 0) goto L_0x056e
                r1 = 93
                r0.accept(r1)
            L_0x056e:
                return r5
            L_0x056f:
                if (r15 == 0) goto L_0x05b5
                int r5 = r8.size()
                java.lang.Long[] r9 = new java.lang.Long[r5]
            L_0x0577:
                if (r4 >= r5) goto L_0x058e
                java.lang.Object r10 = r8.get(r4)
                java.lang.Number r10 = (java.lang.Number) r10
                if (r10 == 0) goto L_0x058b
                long r10 = com.alibaba.fastjson.util.TypeUtils.longExtractValue(r10)
                java.lang.Long r10 = java.lang.Long.valueOf(r10)
                r9[r4] = r10
            L_0x058b:
                int r4 = r4 + 1
                goto L_0x0577
            L_0x058e:
                com.alibaba.fastjson.JSONPath$IntObjInSegement r4 = new com.alibaba.fastjson.JSONPath$IntObjInSegement
                r4.<init>(r2, r9, r7)
            L_0x0593:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x059b
                r22.next()
                goto L_0x0593
            L_0x059b:
                if (r2 == r6) goto L_0x059f
                if (r2 != r14) goto L_0x05a3
            L_0x059f:
                com.alibaba.fastjson.JSONPath$Filter r4 = r0.filterRest(r4)
            L_0x05a3:
                r9 = 41
                r0.accept(r9)
                if (r1 == 0) goto L_0x05ad
                r0.accept(r9)
            L_0x05ad:
                if (r23 == 0) goto L_0x05b4
                r10 = 93
                r0.accept(r10)
            L_0x05b4:
                return r4
            L_0x05b5:
                java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
                r1.<init>()
                throw r1
            L_0x05bb:
                r10 = r12
                r9 = r13
                r22.next()
                java.lang.Object r11 = r22.readValue()
                r8.add(r11)
                goto L_0x0406
            L_0x05c9:
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.NOT_BETWEEN
                if (r11 != r1) goto L_0x05d0
                r21 = r5
                goto L_0x05d2
            L_0x05d0:
                r21 = r4
            L_0x05d2:
                java.lang.Object r1 = r22.readValue()
                java.lang.String r3 = r22.readName()
                java.lang.String r4 = "and"
                boolean r3 = r4.equalsIgnoreCase(r3)
                if (r3 == 0) goto L_0x0623
                java.lang.Object r3 = r22.readValue()
                if (r1 == 0) goto L_0x061b
                if (r3 == 0) goto L_0x061b
                java.lang.Class r4 = r1.getClass()
                boolean r4 = com.alibaba.fastjson.JSONPath.isInt(r4)
                if (r4 == 0) goto L_0x0613
                java.lang.Class r4 = r3.getClass()
                boolean r4 = com.alibaba.fastjson.JSONPath.isInt(r4)
                if (r4 == 0) goto L_0x0613
                com.alibaba.fastjson.JSONPath$IntBetweenSegement r4 = new com.alibaba.fastjson.JSONPath$IntBetweenSegement
                java.lang.Number r1 = (java.lang.Number) r1
                long r17 = com.alibaba.fastjson.util.TypeUtils.longExtractValue(r1)
                java.lang.Number r3 = (java.lang.Number) r3
                long r19 = com.alibaba.fastjson.util.TypeUtils.longExtractValue(r3)
                r15 = r4
                r16 = r2
                r15.<init>(r16, r17, r19, r21)
                return r4
            L_0x0613:
                com.alibaba.fastjson.JSONPathException r1 = new com.alibaba.fastjson.JSONPathException
                java.lang.String r2 = r0.path
                r1.<init>(r2)
                throw r1
            L_0x061b:
                com.alibaba.fastjson.JSONPathException r1 = new com.alibaba.fastjson.JSONPathException
                java.lang.String r2 = r0.path
                r1.<init>(r2)
                throw r1
            L_0x0623:
                com.alibaba.fastjson.JSONPathException r1 = new com.alibaba.fastjson.JSONPathException
                java.lang.String r2 = r0.path
                r1.<init>(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.JSONPathParser.parseArrayAccessFilter(boolean):java.lang.Object");
        }

        /* access modifiers changed from: package-private */
        public Filter filterRest(Filter filter) {
            char c = this.ch;
            boolean z = c == '&';
            if ((c != '&' || getNextChar() != '&') && (this.ch != '|' || getNextChar() != '|')) {
                return filter;
            }
            next();
            next();
            while (this.ch == ' ') {
                next();
            }
            return new FilterGroup(filter, (Filter) parseArrayAccessFilter(false), z);
        }

        /* access modifiers changed from: protected */
        public long readLongValue() {
            int i = this.pos - 1;
            char c = this.ch;
            if (c == '+' || c == '-') {
                next();
            }
            while (true) {
                char c2 = this.ch;
                if (c2 < '0' || c2 > '9') {
                } else {
                    next();
                }
            }
            return Long.parseLong(this.path.substring(i, this.pos - 1));
        }

        /* access modifiers changed from: protected */
        public double readDoubleValue(long j) {
            int i = this.pos - 1;
            next();
            while (true) {
                char c = this.ch;
                if (c < '0' || c > '9') {
                } else {
                    next();
                }
            }
            return Double.parseDouble(this.path.substring(i, this.pos - 1)) + ((double) j);
        }

        /* access modifiers changed from: protected */
        public Object readValue() {
            skipWhitespace();
            if (isDigitFirst(this.ch)) {
                return Long.valueOf(readLongValue());
            }
            char c = this.ch;
            if (c == '\"' || c == '\'') {
                return readString();
            }
            if (c != 'n') {
                throw new UnsupportedOperationException();
            } else if ("null".equals(readName())) {
                return null;
            } else {
                throw new JSONPathException(this.path);
            }
        }

        /* access modifiers changed from: protected */
        public Operator readOp() {
            Operator operator;
            char c = this.ch;
            if (c == '=') {
                next();
                char c2 = this.ch;
                if (c2 == '~') {
                    next();
                    operator = Operator.REG_MATCH;
                } else if (c2 == '=') {
                    next();
                    operator = Operator.EQ;
                } else {
                    operator = Operator.EQ;
                }
            } else if (c == '!') {
                next();
                accept('=');
                operator = Operator.NE;
            } else if (c == '<') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.LE;
                } else {
                    operator = Operator.LT;
                }
            } else if (c == '>') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.GE;
                } else {
                    operator = Operator.GT;
                }
            } else {
                operator = null;
            }
            if (operator != null) {
                return operator;
            }
            String readName = readName();
            if ("not".equalsIgnoreCase(readName)) {
                skipWhitespace();
                String readName2 = readName();
                if ("like".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_LIKE;
                }
                if ("rlike".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_RLIKE;
                }
                if ("in".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_IN;
                }
                if ("between".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_BETWEEN;
                }
                throw new UnsupportedOperationException();
            } else if ("nin".equalsIgnoreCase(readName)) {
                return Operator.NOT_IN;
            } else {
                if ("like".equalsIgnoreCase(readName)) {
                    return Operator.LIKE;
                }
                if ("rlike".equalsIgnoreCase(readName)) {
                    return Operator.RLIKE;
                }
                if ("in".equalsIgnoreCase(readName)) {
                    return Operator.IN;
                }
                if ("between".equalsIgnoreCase(readName)) {
                    return Operator.BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
        }

        /* access modifiers changed from: package-private */
        public String readName() {
            skipWhitespace();
            char c = this.ch;
            if (c == '\\' || Character.isJavaIdentifierStart(c)) {
                StringBuilder sb = new StringBuilder();
                while (!isEOF()) {
                    char c2 = this.ch;
                    if (c2 == '\\') {
                        next();
                        sb.append(this.ch);
                        if (isEOF()) {
                            return sb.toString();
                        }
                        next();
                    } else if (!Character.isJavaIdentifierPart(c2)) {
                        break;
                    } else {
                        sb.append(this.ch);
                        next();
                    }
                }
                if (isEOF() && Character.isJavaIdentifierPart(this.ch)) {
                    sb.append(this.ch);
                }
                return sb.toString();
            }
            throw new JSONPathException("illeal jsonpath syntax. " + this.path);
        }

        /* access modifiers changed from: package-private */
        public String readString() {
            char c = this.ch;
            next();
            int i = this.pos - 1;
            while (this.ch != c && !isEOF()) {
                next();
            }
            String substring = this.path.substring(i, isEOF() ? this.pos : this.pos - 1);
            accept(c);
            return substring;
        }

        /* access modifiers changed from: package-private */
        public void accept(char c) {
            if (this.ch != c) {
                throw new JSONPathException("expect '" + c + ", but '" + this.ch + "'");
            } else if (!isEOF()) {
                next();
            }
        }

        public Segment[] explain() {
            String str = this.path;
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException();
            }
            Segment[] segmentArr = new Segment[8];
            while (true) {
                Segment readSegement = readSegement();
                if (readSegement == null) {
                    break;
                }
                if (readSegement instanceof PropertySegment) {
                    PropertySegment propertySegment = (PropertySegment) readSegement;
                    if (!propertySegment.deep && propertySegment.propertyName.equals("*")) {
                    }
                }
                int i = this.level;
                if (i == segmentArr.length) {
                    Segment[] segmentArr2 = new Segment[((i * 3) / 2)];
                    System.arraycopy(segmentArr, 0, segmentArr2, 0, i);
                    segmentArr = segmentArr2;
                }
                int i2 = this.level;
                this.level = i2 + 1;
                segmentArr[i2] = readSegement;
            }
            int i3 = this.level;
            if (i3 == segmentArr.length) {
                return segmentArr;
            }
            Segment[] segmentArr3 = new Segment[i3];
            System.arraycopy(segmentArr, 0, segmentArr3, 0, i3);
            return segmentArr3;
        }

        /* access modifiers changed from: package-private */
        public Segment buildArraySegement(String str) {
            int length = str.length();
            int i = 0;
            char charAt = str.charAt(0);
            int i2 = 1;
            int i3 = length - 1;
            char charAt2 = str.charAt(i3);
            int indexOf = str.indexOf(44);
            int i4 = -1;
            if (str.length() <= 2 || charAt != '\'' || charAt2 != '\'') {
                int indexOf2 = str.indexOf(58);
                if (indexOf == -1 && indexOf2 == -1) {
                    if (TypeUtils.isNumber(str)) {
                        try {
                            return new ArrayAccessSegment(Integer.parseInt(str));
                        } catch (NumberFormatException unused) {
                            return new PropertySegment(str, false);
                        }
                    } else {
                        if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
                            str = str.substring(1, str.length() - 1);
                        }
                        return new PropertySegment(str, false);
                    }
                } else if (indexOf != -1) {
                    String[] split = str.split(",");
                    int[] iArr = new int[split.length];
                    while (i < split.length) {
                        iArr[i] = Integer.parseInt(split[i]);
                        i++;
                    }
                    return new MultiIndexSegment(iArr);
                } else if (indexOf2 != -1) {
                    String[] split2 = str.split(":");
                    int length2 = split2.length;
                    int[] iArr2 = new int[length2];
                    for (int i5 = 0; i5 < split2.length; i5++) {
                        String str2 = split2[i5];
                        if (str2.length() != 0) {
                            iArr2[i5] = Integer.parseInt(str2);
                        } else if (i5 == 0) {
                            iArr2[i5] = 0;
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    }
                    int i6 = iArr2[0];
                    if (length2 > 1) {
                        i4 = iArr2[1];
                    }
                    if (length2 == 3) {
                        i2 = iArr2[2];
                    }
                    if (i4 >= 0 && i4 < i6) {
                        throw new UnsupportedOperationException("end must greater than or equals start. start " + i6 + ",  end " + i4);
                    } else if (i2 > 0) {
                        return new RangeSegment(i6, i4, i2);
                    } else {
                        throw new UnsupportedOperationException("step must greater than zero : " + i2);
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            } else if (indexOf == -1) {
                return new PropertySegment(str.substring(1, i3), false);
            } else {
                String[] split3 = str.split(",");
                String[] strArr = new String[split3.length];
                while (i < split3.length) {
                    String str3 = split3[i];
                    strArr[i] = str3.substring(1, str3.length() - 1);
                    i++;
                }
                return new MultiPropertySegment(strArr);
            }
        }
    }

    static class SizeSegment implements Segment {
        public static final SizeSegment instance = new SizeSegment();

        SizeSegment() {
        }

        public Integer eval(JSONPath jSONPath, Object obj, Object obj2) {
            return Integer.valueOf(jSONPath.evalSize(obj2));
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    static class MaxSegment implements Segment {
        public static final MaxSegment instance = new MaxSegment();

        MaxSegment() {
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj instanceof Collection) {
                Object obj3 = null;
                for (Object next : (Collection) obj) {
                    if (next != null && (obj3 == null || JSONPath.compare(obj3, next) < 0)) {
                        obj3 = next;
                    }
                }
                return obj3;
            }
            throw new UnsupportedOperationException();
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    static class MinSegment implements Segment {
        public static final MinSegment instance = new MinSegment();

        MinSegment() {
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj instanceof Collection) {
                Object obj3 = null;
                for (Object next : (Collection) obj) {
                    if (next != null && (obj3 == null || JSONPath.compare(obj3, next) > 0)) {
                        obj3 = next;
                    }
                }
                return obj3;
            }
            throw new UnsupportedOperationException();
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    static int compare(Object obj, Object obj2) {
        Object obj3;
        Object f;
        if (obj.getClass() == obj2.getClass()) {
            return ((Comparable) obj).compareTo(obj2);
        }
        Class<?> cls = obj.getClass();
        Class<?> cls2 = obj2.getClass();
        if (cls != BigDecimal.class) {
            if (cls == Long.class) {
                if (cls2 == Integer.class) {
                    f = new Long((long) ((Integer) obj2).intValue());
                } else if (cls2 == BigDecimal.class) {
                    obj3 = new BigDecimal(((Long) obj).longValue());
                } else if (cls2 == Float.class) {
                    obj3 = new Float((float) ((Long) obj).longValue());
                } else {
                    if (cls2 == Double.class) {
                        obj3 = new Double((double) ((Long) obj).longValue());
                    }
                    return ((Comparable) obj).compareTo(obj2);
                }
            } else if (cls == Integer.class) {
                if (cls2 == Long.class) {
                    obj3 = new Long((long) ((Integer) obj).intValue());
                } else if (cls2 == BigDecimal.class) {
                    obj3 = new BigDecimal(((Integer) obj).intValue());
                } else if (cls2 == Float.class) {
                    obj3 = new Float((float) ((Integer) obj).intValue());
                } else {
                    if (cls2 == Double.class) {
                        obj3 = new Double((double) ((Integer) obj).intValue());
                    }
                    return ((Comparable) obj).compareTo(obj2);
                }
            } else if (cls != Double.class) {
                if (cls == Float.class) {
                    if (cls2 == Integer.class) {
                        f = new Float((float) ((Integer) obj2).intValue());
                    } else if (cls2 == Long.class) {
                        f = new Float((float) ((Long) obj2).longValue());
                    } else if (cls2 == Double.class) {
                        obj3 = new Double((double) ((Float) obj).floatValue());
                    }
                }
                return ((Comparable) obj).compareTo(obj2);
            } else if (cls2 == Integer.class) {
                f = new Double((double) ((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f = new Double((double) ((Long) obj2).longValue());
            } else {
                if (cls2 == Float.class) {
                    f = new Double((double) ((Float) obj2).floatValue());
                }
                return ((Comparable) obj).compareTo(obj2);
            }
            obj = obj3;
            return ((Comparable) obj).compareTo(obj2);
        } else if (cls2 == Integer.class) {
            f = new BigDecimal(((Integer) obj2).intValue());
        } else if (cls2 == Long.class) {
            f = new BigDecimal(((Long) obj2).longValue());
        } else if (cls2 == Float.class) {
            f = new BigDecimal((double) ((Float) obj2).floatValue());
        } else {
            if (cls2 == Double.class) {
                f = new BigDecimal(((Double) obj2).doubleValue());
            }
            return ((Comparable) obj).compareTo(obj2);
        }
        obj2 = f;
        return ((Comparable) obj).compareTo(obj2);
    }

    static class KeySetSegment implements Segment {
        public static final KeySetSegment instance = new KeySetSegment();

        KeySetSegment() {
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.evalKeySet(obj2);
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    static class PropertySegment implements Segment {
        /* access modifiers changed from: private */
        public final boolean deep;
        /* access modifiers changed from: private */
        public final String propertyName;
        private final long propertyNameHash;

        public PropertySegment(String str, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.deep = z;
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.deep) {
                return jSONPath.getPropertyValue(obj2, this.propertyName, this.propertyNameHash);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.deepScan(obj2, this.propertyName, arrayList);
            return arrayList;
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Object obj;
            Object obj2;
            JSONArray jSONArray;
            Object obj3;
            Context context2 = context;
            JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
            if (this.deep && context2.object == null) {
                context2.object = new JSONArray();
            }
            if (jSONLexerBase.token() != 14) {
                boolean z = this.deep;
                if (z) {
                    while (true) {
                        int seekObjectToField = jSONLexerBase.seekObjectToField(this.propertyNameHash, this.deep);
                        if (seekObjectToField != -1) {
                            if (seekObjectToField == 3) {
                                if (context2.eval) {
                                    int i = jSONLexerBase.token();
                                    if (i == 2) {
                                        obj = jSONLexerBase.integerValue();
                                        jSONLexerBase.nextToken(16);
                                    } else if (i == 3) {
                                        obj = jSONLexerBase.decimalValue();
                                        jSONLexerBase.nextToken(16);
                                    } else if (i != 4) {
                                        obj = defaultJSONParser.parse();
                                    } else {
                                        obj = jSONLexerBase.stringVal();
                                        jSONLexerBase.nextToken(16);
                                    }
                                    if (context2.eval) {
                                        if (context2.object instanceof List) {
                                            List list = (List) context2.object;
                                            if (list.size() != 0 || !(obj instanceof List)) {
                                                list.add(obj);
                                            } else {
                                                context2.object = obj;
                                            }
                                        } else {
                                            context2.object = obj;
                                        }
                                    }
                                }
                            } else if (seekObjectToField == 1 || seekObjectToField == 2) {
                                extract(jSONPath, defaultJSONParser, context);
                            }
                        } else {
                            return;
                        }
                    }
                } else if (jSONLexerBase.seekObjectToField(this.propertyNameHash, z) == 3 && context2.eval) {
                    int i2 = jSONLexerBase.token();
                    if (i2 == 2) {
                        obj2 = jSONLexerBase.integerValue();
                        jSONLexerBase.nextToken(16);
                    } else if (i2 == 3) {
                        obj2 = jSONLexerBase.decimalValue();
                        jSONLexerBase.nextToken(16);
                    } else if (i2 != 4) {
                        obj2 = defaultJSONParser.parse();
                    } else {
                        obj2 = jSONLexerBase.stringVal();
                        jSONLexerBase.nextToken(16);
                    }
                    if (context2.eval) {
                        context2.object = obj2;
                    }
                }
            } else if (!"*".equals(this.propertyName)) {
                jSONLexerBase.nextToken();
                if (this.deep) {
                    jSONArray = (JSONArray) context2.object;
                } else {
                    jSONArray = new JSONArray();
                }
                while (true) {
                    int i3 = jSONLexerBase.token();
                    if (i3 == 12) {
                        boolean z2 = this.deep;
                        if (z2) {
                            extract(jSONPath, defaultJSONParser, context);
                        } else {
                            int seekObjectToField2 = jSONLexerBase.seekObjectToField(this.propertyNameHash, z2);
                            if (seekObjectToField2 == 3) {
                                int i4 = jSONLexerBase.token();
                                if (i4 == 2) {
                                    obj3 = jSONLexerBase.integerValue();
                                    jSONLexerBase.nextToken();
                                } else if (i4 != 4) {
                                    obj3 = defaultJSONParser.parse();
                                } else {
                                    obj3 = jSONLexerBase.stringVal();
                                    jSONLexerBase.nextToken();
                                }
                                jSONArray.add(obj3);
                                if (jSONLexerBase.token() == 13) {
                                    jSONLexerBase.nextToken();
                                } else {
                                    jSONLexerBase.skipObject(false);
                                }
                            } else if (seekObjectToField2 == -1) {
                                continue;
                            } else if (!this.deep) {
                                jSONLexerBase.skipObject(false);
                            } else {
                                throw new UnsupportedOperationException(jSONLexerBase.info());
                            }
                        }
                    } else if (i3 != 14) {
                        switch (i3) {
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                jSONLexerBase.nextToken();
                                break;
                        }
                    } else if (this.deep) {
                        extract(jSONPath, defaultJSONParser, context);
                    } else {
                        jSONLexerBase.skipObject(false);
                    }
                    if (jSONLexerBase.token() == 15) {
                        jSONLexerBase.nextToken();
                        if (!this.deep && jSONArray.size() > 0) {
                            context2.object = jSONArray;
                            return;
                        }
                        return;
                    } else if (jSONLexerBase.token() == 16) {
                        jSONLexerBase.nextToken();
                    } else {
                        throw new JSONException("illegal json : " + jSONLexerBase.info());
                    }
                }
            }
        }

        public void setValue(JSONPath jSONPath, Object obj, Object obj2) {
            if (this.deep) {
                jSONPath.deepSet(obj, this.propertyName, this.propertyNameHash, obj2);
                return;
            }
            jSONPath.setPropertyValue(obj, this.propertyName, this.propertyNameHash, obj2);
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removePropertyValue(obj, this.propertyName, this.deep);
        }
    }

    static class MultiPropertySegment implements Segment {
        private final String[] propertyNames;
        private final long[] propertyNamesHash;

        public MultiPropertySegment(String[] strArr) {
            this.propertyNames = strArr;
            this.propertyNamesHash = new long[strArr.length];
            int i = 0;
            while (true) {
                long[] jArr = this.propertyNamesHash;
                if (i < jArr.length) {
                    jArr[i] = TypeUtils.fnv1a_64(strArr[i]);
                    i++;
                } else {
                    return;
                }
            }
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.propertyNames.length);
            int i = 0;
            while (true) {
                String[] strArr = this.propertyNames;
                if (i >= strArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.getPropertyValue(obj2, strArr[i], this.propertyNamesHash[i]));
                i++;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.alibaba.fastjson.JSONArray} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void extract(com.alibaba.fastjson.JSONPath r6, com.alibaba.fastjson.parser.DefaultJSONParser r7, com.alibaba.fastjson.JSONPath.Context r8) {
            /*
                r5 = this;
                com.alibaba.fastjson.parser.JSONLexer r6 = r7.lexer
                com.alibaba.fastjson.parser.JSONLexerBase r6 = (com.alibaba.fastjson.parser.JSONLexerBase) r6
                java.lang.Object r0 = r8.object
                if (r0 != 0) goto L_0x0010
                com.alibaba.fastjson.JSONArray r0 = new com.alibaba.fastjson.JSONArray
                r0.<init>()
                r8.object = r0
                goto L_0x0015
            L_0x0010:
                java.lang.Object r8 = r8.object
                r0 = r8
                com.alibaba.fastjson.JSONArray r0 = (com.alibaba.fastjson.JSONArray) r0
            L_0x0015:
                int r8 = r0.size()
            L_0x0019:
                long[] r1 = r5.propertyNamesHash
                int r1 = r1.length
                if (r8 >= r1) goto L_0x0025
                r1 = 0
                r0.add(r1)
                int r8 = r8 + 1
                goto L_0x0019
            L_0x0025:
                long[] r8 = r5.propertyNamesHash
                int r8 = r6.seekObjectToField(r8)
                int r1 = r6.matchStat
                r2 = 3
                if (r1 != r2) goto L_0x0064
                int r1 = r6.token()
                r3 = 2
                r4 = 16
                if (r1 == r3) goto L_0x0053
                if (r1 == r2) goto L_0x004b
                r2 = 4
                if (r1 == r2) goto L_0x0043
                java.lang.Object r1 = r7.parse()
                goto L_0x005a
            L_0x0043:
                java.lang.String r1 = r6.stringVal()
                r6.nextToken(r4)
                goto L_0x005a
            L_0x004b:
                java.math.BigDecimal r1 = r6.decimalValue()
                r6.nextToken(r4)
                goto L_0x005a
            L_0x0053:
                java.lang.Number r1 = r6.integerValue()
                r6.nextToken(r4)
            L_0x005a:
                r0.set(r8, r1)
                int r8 = r6.token()
                if (r8 != r4) goto L_0x0064
                goto L_0x0025
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.MultiPropertySegment.extract(com.alibaba.fastjson.JSONPath, com.alibaba.fastjson.parser.DefaultJSONParser, com.alibaba.fastjson.JSONPath$Context):void");
        }
    }

    static class WildCardSegment implements Segment {
        public static final WildCardSegment instance = new WildCardSegment(false);
        public static final WildCardSegment instance_deep = new WildCardSegment(true);
        private boolean deep;

        private WildCardSegment(boolean z) {
            this.deep = z;
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.deep) {
                return jSONPath.getPropertyValues(obj2);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.deepGetPropertyValues(obj2, arrayList);
            return arrayList;
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (context.eval) {
                Object parse = defaultJSONParser.parse();
                if (this.deep) {
                    ArrayList arrayList = new ArrayList();
                    jSONPath.deepGetPropertyValues(parse, arrayList);
                    context.object = arrayList;
                    return;
                } else if (parse instanceof JSONObject) {
                    Collection<Object> values = ((JSONObject) parse).values();
                    JSONArray jSONArray = new JSONArray(values.size());
                    for (Object add : values) {
                        jSONArray.add(add);
                    }
                    context.object = jSONArray;
                    return;
                } else if (parse instanceof JSONArray) {
                    context.object = parse;
                    return;
                }
            }
            throw new JSONException("TODO");
        }
    }

    static class ArrayAccessSegment implements Segment {
        /* access modifiers changed from: private */
        public final int index;

        public ArrayAccessSegment(int i) {
            this.index = i;
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getArrayItem(obj2, this.index);
        }

        public boolean setValue(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.setArrayItem(jSONPath, obj, this.index, obj2);
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removeArrayItem(jSONPath, obj, this.index);
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (((JSONLexerBase) defaultJSONParser.lexer).seekArrayToItem(this.index) && context.eval) {
                context.object = defaultJSONParser.parse();
            }
        }
    }

    static class MultiIndexSegment implements Segment {
        private final int[] indexes;

        public MultiIndexSegment(int[] iArr) {
            this.indexes = iArr;
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            JSONArray jSONArray = new JSONArray(this.indexes.length);
            int i = 0;
            while (true) {
                int[] iArr = this.indexes;
                if (i >= iArr.length) {
                    return jSONArray;
                }
                jSONArray.add(jSONPath.getArrayItem(obj2, iArr[i]));
                i++;
            }
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (context.eval) {
                Object parse = defaultJSONParser.parse();
                if (parse instanceof List) {
                    int[] iArr = this.indexes;
                    int length = iArr.length;
                    int[] iArr2 = new int[length];
                    boolean z = false;
                    System.arraycopy(iArr, 0, iArr2, 0, length);
                    if (iArr2[0] >= 0) {
                        z = true;
                    }
                    List list = (List) parse;
                    if (z) {
                        for (int size = list.size() - 1; size >= 0; size--) {
                            if (Arrays.binarySearch(iArr2, size) < 0) {
                                list.remove(size);
                            }
                        }
                        context.object = list;
                        return;
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    static class RangeSegment implements Segment {
        private final int end;
        private final int start;
        private final int step;

        public RangeSegment(int i, int i2, int i3) {
            this.start = i;
            this.end = i2;
            this.step = i3;
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            int intValue = SizeSegment.instance.eval(jSONPath, obj, obj2).intValue();
            int i = this.start;
            if (i < 0) {
                i += intValue;
            }
            int i2 = this.end;
            if (i2 < 0) {
                i2 += intValue;
            }
            int i3 = ((i2 - i) / this.step) + 1;
            if (i3 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i3);
            while (i <= i2 && i < intValue) {
                arrayList.add(jSONPath.getArrayItem(obj2, i));
                i += this.step;
            }
            return arrayList;
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    static class NotNullSegement implements Filter {
        private final String propertyName;
        private final long propertyNameHash;

        public NotNullSegement(String str) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash) != null;
        }
    }

    static class NullSegement implements Filter {
        private final String propertyName;
        private final long propertyNameHash;

        public NullSegement(String str) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash) == null;
        }
    }

    static class ValueSegment implements Filter {
        private boolean eq = true;
        private final String propertyName;
        private final long propertyNameHash;
        private final Object value;

        public ValueSegment(String str, Object obj, boolean z) {
            if (obj != null) {
                this.propertyName = str;
                this.propertyNameHash = TypeUtils.fnv1a_64(str);
                this.value = obj;
                this.eq = z;
                return;
            }
            throw new IllegalArgumentException("value is null");
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean equals = this.value.equals(jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash));
            return !this.eq ? !equals : equals;
        }
    }

    static class IntInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final long[] values;

        public IntInSegement(String str, long[] jArr, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.values = jArr;
            this.not = z;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longExtractValue = TypeUtils.longExtractValue((Number) propertyValue);
                for (long j : this.values) {
                    if (j == longExtractValue) {
                        return !this.not;
                    }
                }
            }
            return this.not;
        }
    }

    static class IntBetweenSegement implements Filter {
        private final long endValue;
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final long startValue;

        public IntBetweenSegement(String str, long j, long j2, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.startValue = j;
            this.endValue = j2;
            this.not = z;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longExtractValue = TypeUtils.longExtractValue((Number) propertyValue);
                if (longExtractValue >= this.startValue && longExtractValue <= this.endValue) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    static class IntObjInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final Long[] values;

        public IntObjInSegement(String str, Long[] lArr, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.values = lArr;
            this.not = z;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            int i = 0;
            if (propertyValue == null) {
                Long[] lArr = this.values;
                int length = lArr.length;
                while (i < length) {
                    if (lArr[i] == null) {
                        return !this.not;
                    }
                    i++;
                }
                return this.not;
            }
            if (propertyValue instanceof Number) {
                long longExtractValue = TypeUtils.longExtractValue((Number) propertyValue);
                Long[] lArr2 = this.values;
                int length2 = lArr2.length;
                while (i < length2) {
                    Long l = lArr2[i];
                    if (l != null && l.longValue() == longExtractValue) {
                        return !this.not;
                    }
                    i++;
                }
            }
            return this.not;
        }
    }

    static class StringInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final String[] values;

        public StringInSegement(String str, String[] strArr, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.values = strArr;
            this.not = z;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            for (String str : this.values) {
                if (str == propertyValue) {
                    return !this.not;
                }
                if (str != null && str.equals(propertyValue)) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    static class IntOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final long value;
        private BigDecimal valueDecimal;
        private Double valueDouble;
        private Float valueFloat;

        public IntOpSegement(String str, long j, Operator operator) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.value = j;
            this.op = operator;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null || !(propertyValue instanceof Number)) {
                return false;
            }
            if (propertyValue instanceof BigDecimal) {
                if (this.valueDecimal == null) {
                    this.valueDecimal = BigDecimal.valueOf(this.value);
                }
                int compareTo = this.valueDecimal.compareTo((BigDecimal) propertyValue);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        if (compareTo == 0) {
                            return true;
                        }
                        return false;
                    case 2:
                        if (compareTo != 0) {
                            return true;
                        }
                        return false;
                    case 3:
                        if (compareTo <= 0) {
                            return true;
                        }
                        return false;
                    case 4:
                        if (compareTo < 0) {
                            return true;
                        }
                        return false;
                    case 5:
                        if (compareTo >= 0) {
                            return true;
                        }
                        return false;
                    case 6:
                        if (compareTo > 0) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            } else if (propertyValue instanceof Float) {
                if (this.valueFloat == null) {
                    this.valueFloat = Float.valueOf((float) this.value);
                }
                int compareTo2 = this.valueFloat.compareTo((Float) propertyValue);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        if (compareTo2 == 0) {
                            return true;
                        }
                        return false;
                    case 2:
                        if (compareTo2 != 0) {
                            return true;
                        }
                        return false;
                    case 3:
                        if (compareTo2 <= 0) {
                            return true;
                        }
                        return false;
                    case 4:
                        if (compareTo2 < 0) {
                            return true;
                        }
                        return false;
                    case 5:
                        if (compareTo2 >= 0) {
                            return true;
                        }
                        return false;
                    case 6:
                        if (compareTo2 > 0) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            } else if (propertyValue instanceof Double) {
                if (this.valueDouble == null) {
                    this.valueDouble = Double.valueOf((double) this.value);
                }
                int compareTo3 = this.valueDouble.compareTo((Double) propertyValue);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        if (compareTo3 == 0) {
                            return true;
                        }
                        return false;
                    case 2:
                        if (compareTo3 != 0) {
                            return true;
                        }
                        return false;
                    case 3:
                        if (compareTo3 <= 0) {
                            return true;
                        }
                        return false;
                    case 4:
                        if (compareTo3 < 0) {
                            return true;
                        }
                        return false;
                    case 5:
                        if (compareTo3 >= 0) {
                            return true;
                        }
                        return false;
                    case 6:
                        if (compareTo3 > 0) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            } else {
                long longExtractValue = TypeUtils.longExtractValue((Number) propertyValue);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        if (longExtractValue == this.value) {
                            return true;
                        }
                        return false;
                    case 2:
                        if (longExtractValue != this.value) {
                            return true;
                        }
                        return false;
                    case 3:
                        if (longExtractValue >= this.value) {
                            return true;
                        }
                        return false;
                    case 4:
                        if (longExtractValue > this.value) {
                            return true;
                        }
                        return false;
                    case 5:
                        if (longExtractValue <= this.value) {
                            return true;
                        }
                        return false;
                    case 6:
                        if (longExtractValue < this.value) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            }
        }
    }

    /* renamed from: com.alibaba.fastjson.JSONPath$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$JSONPath$Operator;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.alibaba.fastjson.JSONPath$Operator[] r0 = com.alibaba.fastjson.JSONPath.Operator.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator = r0
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.EQ     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPath$Operator     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.NE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPath$Operator     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.GE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPath$Operator     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.GT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPath$Operator     // Catch:{ NoSuchFieldError -> 0x003e }
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.LE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPath$Operator     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.LT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.AnonymousClass1.<clinit>():void");
        }
    }

    static class DoubleOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final double value;

        public DoubleOpSegement(String str, double d, Operator operator) {
            this.propertyName = str;
            this.value = d;
            this.op = operator;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null || !(propertyValue instanceof Number)) {
                return false;
            }
            double doubleValue = ((Number) propertyValue).doubleValue();
            switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                case 1:
                    if (doubleValue == this.value) {
                        return true;
                    }
                    return false;
                case 2:
                    if (doubleValue != this.value) {
                        return true;
                    }
                    return false;
                case 3:
                    if (doubleValue >= this.value) {
                        return true;
                    }
                    return false;
                case 4:
                    if (doubleValue > this.value) {
                        return true;
                    }
                    return false;
                case 5:
                    if (doubleValue <= this.value) {
                        return true;
                    }
                    return false;
                case 6:
                    if (doubleValue < this.value) {
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }
    }

    static class RefOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final Segment refSgement;

        public RefOpSegement(String str, Segment segment, Operator operator) {
            this.propertyName = str;
            this.refSgement = segment;
            this.op = operator;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null || !(propertyValue instanceof Number)) {
                return false;
            }
            Object eval = this.refSgement.eval(jSONPath, obj, obj);
            if ((eval instanceof Integer) || (eval instanceof Long) || (eval instanceof Short) || (eval instanceof Byte)) {
                long longExtractValue = TypeUtils.longExtractValue((Number) eval);
                if ((propertyValue instanceof Integer) || (propertyValue instanceof Long) || (propertyValue instanceof Short) || (propertyValue instanceof Byte)) {
                    long longExtractValue2 = TypeUtils.longExtractValue((Number) propertyValue);
                    switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                        case 1:
                            if (longExtractValue2 == longExtractValue) {
                                return true;
                            }
                            return false;
                        case 2:
                            if (longExtractValue2 != longExtractValue) {
                                return true;
                            }
                            return false;
                        case 3:
                            if (longExtractValue2 >= longExtractValue) {
                                return true;
                            }
                            return false;
                        case 4:
                            if (longExtractValue2 > longExtractValue) {
                                return true;
                            }
                            return false;
                        case 5:
                            if (longExtractValue2 <= longExtractValue) {
                                return true;
                            }
                            return false;
                        case 6:
                            if (longExtractValue2 < longExtractValue) {
                                return true;
                            }
                            return false;
                    }
                } else if (propertyValue instanceof BigDecimal) {
                    int compareTo = BigDecimal.valueOf(longExtractValue).compareTo((BigDecimal) propertyValue);
                    switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                        case 1:
                            if (compareTo == 0) {
                                return true;
                            }
                            return false;
                        case 2:
                            if (compareTo != 0) {
                                return true;
                            }
                            return false;
                        case 3:
                            if (compareTo <= 0) {
                                return true;
                            }
                            return false;
                        case 4:
                            if (compareTo < 0) {
                                return true;
                            }
                            return false;
                        case 5:
                            if (compareTo >= 0) {
                                return true;
                            }
                            return false;
                        case 6:
                            if (compareTo > 0) {
                                return true;
                            }
                            return false;
                        default:
                            return false;
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    static class MatchSegement implements Filter {
        private final String[] containsValues;
        private final String endsWithValue;
        private final int minLength;
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final String startsWithValue;

        public MatchSegement(String str, String str2, String str3, String[] strArr, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.startsWithValue = str2;
            this.endsWithValue = str3;
            this.containsValues = strArr;
            this.not = z;
            int length = str2 != null ? str2.length() + 0 : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (String length2 : strArr) {
                    length += length2.length();
                }
            }
            this.minLength = length;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int i;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            String obj4 = propertyValue.toString();
            if (obj4.length() < this.minLength) {
                return this.not;
            }
            String str = this.startsWithValue;
            if (str == null) {
                i = 0;
            } else if (!obj4.startsWith(str)) {
                return this.not;
            } else {
                i = this.startsWithValue.length() + 0;
            }
            String[] strArr = this.containsValues;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int indexOf = obj4.indexOf(str2, i);
                    if (indexOf == -1) {
                        return this.not;
                    }
                    i = indexOf + str2.length();
                }
            }
            String str3 = this.endsWithValue;
            if (str3 == null || obj4.endsWith(str3)) {
                return !this.not;
            }
            return this.not;
        }
    }

    static class RlikeSegement implements Filter {
        private final boolean not;
        private final Pattern pattern;
        private final String propertyName;
        private final long propertyNameHash;

        public RlikeSegement(String str, String str2, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.pattern = Pattern.compile(str2);
            this.not = z;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            boolean matches = this.pattern.matcher(propertyValue.toString()).matches();
            return this.not ? !matches : matches;
        }
    }

    static class StringOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final String value;

        public StringOpSegement(String str, String str2, Operator operator) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.value = str2;
            this.op = operator;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (this.op == Operator.EQ) {
                return this.value.equals(propertyValue);
            }
            if (this.op == Operator.NE) {
                return !this.value.equals(propertyValue);
            }
            if (propertyValue == null) {
                return false;
            }
            int compareTo = this.value.compareTo(propertyValue.toString());
            if (this.op == Operator.GE) {
                if (compareTo <= 0) {
                    return true;
                }
                return false;
            } else if (this.op == Operator.GT) {
                if (compareTo < 0) {
                    return true;
                }
                return false;
            } else if (this.op == Operator.LE) {
                if (compareTo >= 0) {
                    return true;
                }
                return false;
            } else if (this.op != Operator.LT) {
                return false;
            } else {
                if (compareTo > 0) {
                    return true;
                }
                return false;
            }
        }
    }

    static class RegMatchSegement implements Filter {
        private final Operator op;
        private final Pattern pattern;
        private final String propertyName;
        private final long propertyNameHash;

        public RegMatchSegement(String str, Pattern pattern2, Operator operator) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.pattern = pattern2;
            this.op = operator;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            return this.pattern.matcher(propertyValue.toString()).matches();
        }
    }

    public static class FilterSegment implements Segment {
        private final Filter filter;

        public FilterSegment(Filter filter2) {
            this.filter = filter2;
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (obj2 instanceof Iterable) {
                for (Object next : (Iterable) obj2) {
                    if (this.filter.apply(jSONPath, obj, obj2, next)) {
                        jSONArray.add(next);
                    }
                }
                return jSONArray;
            } else if (this.filter.apply(jSONPath, obj, obj2, obj2)) {
                return obj2;
            } else {
                return null;
            }
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    static class FilterGroup implements Filter {
        private boolean and;
        private List<Filter> fitlers;

        public FilterGroup(Filter filter, Filter filter2, boolean z) {
            ArrayList arrayList = new ArrayList(2);
            this.fitlers = arrayList;
            arrayList.add(filter);
            this.fitlers.add(filter2);
            this.and = z;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            if (this.and) {
                for (Filter apply : this.fitlers) {
                    if (!apply.apply(jSONPath, obj, obj2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
            for (Filter apply2 : this.fitlers) {
                if (apply2.apply(jSONPath, obj, obj2, obj3)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public Object getArrayItem(Object obj, int i) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                if (i < list.size()) {
                    return list.get(i);
                }
                return null;
            } else if (Math.abs(i) <= list.size()) {
                return list.get(list.size() + i);
            } else {
                return null;
            }
        } else if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    return Array.get(obj, i);
                }
                return null;
            } else if (Math.abs(i) <= length) {
                return Array.get(obj, length + i);
            } else {
                return null;
            }
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i));
            return obj2 == null ? map.get(Integer.toString(i)) : obj2;
        } else if (obj instanceof Collection) {
            int i2 = 0;
            for (Object next : (Collection) obj) {
                if (i2 == i) {
                    return next;
                }
                i2++;
            }
            return null;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean setArrayItem(JSONPath jSONPath, Object obj, int i, Object obj2) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                list.set(i, obj2);
            } else {
                list.set(list.size() + i, obj2);
            }
            return true;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    Array.set(obj, i, obj2);
                }
            } else if (Math.abs(i) <= length) {
                Array.set(obj, length + i, obj2);
            }
            return true;
        }
        throw new JSONPathException("unsupported set operation." + cls);
    }

    public boolean removeArrayItem(JSONPath jSONPath, Object obj, int i) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i < 0) {
                int size = list.size() + i;
                if (size < 0) {
                    return false;
                }
                list.remove(size);
                return true;
            } else if (i >= list.size()) {
                return false;
            } else {
                list.remove(i);
                return true;
            }
        } else {
            Class<?> cls = obj.getClass();
            throw new JSONPathException("unsupported set operation." + cls);
        }
    }

    /* access modifiers changed from: protected */
    public Collection<Object> getPropertyValues(Object obj) {
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path, e);
            }
        } else if (obj instanceof Map) {
            return ((Map) obj).values();
        } else {
            if (obj instanceof Collection) {
                return (Collection) obj;
            }
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: protected */
    public void deepGetPropertyValues(Object obj, List<Object> list) {
        Collection collection;
        Class<?> cls = obj.getClass();
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(cls);
        if (javaBeanSerializer != null) {
            try {
                collection = javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path, e);
            }
        } else if (obj instanceof Map) {
            collection = ((Map) obj).values();
        } else {
            collection = obj instanceof Collection ? (Collection) obj : null;
        }
        if (collection != null) {
            for (Object next : collection) {
                if (next == null || ParserConfig.isPrimitive2(next.getClass())) {
                    list.add(next);
                } else {
                    deepGetPropertyValues(next, list);
                }
            }
            return;
        }
        throw new UnsupportedOperationException(cls.getName());
    }

    static boolean eq(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (obj.getClass() == obj2.getClass()) {
            return obj.equals(obj2);
        }
        if (!(obj instanceof Number)) {
            return obj.equals(obj2);
        }
        if (obj2 instanceof Number) {
            return eqNotNull((Number) obj, (Number) obj2);
        }
        return false;
    }

    static boolean eqNotNull(Number number, Number number2) {
        Class<?> cls = number.getClass();
        boolean isInt = isInt(cls);
        Class<?> cls2 = number2.getClass();
        boolean isInt2 = isInt(cls2);
        if (number instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) number;
            if (isInt2) {
                return bigDecimal.equals(BigDecimal.valueOf(TypeUtils.longExtractValue(number2)));
            }
        }
        if (isInt) {
            if (isInt2) {
                if (number.longValue() == number2.longValue()) {
                    return true;
                }
                return false;
            } else if (number2 instanceof BigInteger) {
                return BigInteger.valueOf(number.longValue()).equals((BigInteger) number);
            }
        }
        if (isInt2 && (number instanceof BigInteger)) {
            return ((BigInteger) number).equals(BigInteger.valueOf(TypeUtils.longExtractValue(number2)));
        }
        boolean isDouble = isDouble(cls);
        boolean isDouble2 = isDouble(cls2);
        if ((!isDouble || !isDouble2) && ((!isDouble || !isInt2) && (!isDouble2 || !isInt))) {
            return false;
        }
        if (number.doubleValue() == number2.doubleValue()) {
            return true;
        }
        return false;
    }

    protected static boolean isDouble(Class<?> cls) {
        return cls == Float.class || cls == Double.class;
    }

    protected static boolean isInt(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    /* access modifiers changed from: protected */
    public Object getPropertyValue(Object obj, String str, long j) {
        JSONArray jSONArray = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            try {
                obj = JSON.parseObject((String) obj);
            } catch (Exception unused) {
            }
        }
        Object obj2 = obj;
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get(str);
            if (obj3 == null) {
                return (SIZE == j || LENGTH == j) ? Integer.valueOf(map.size()) : obj3;
            }
            return obj3;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj2.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValue(obj2, str, j, false);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e);
            }
        } else {
            int i = 0;
            if (obj2 instanceof List) {
                List list = (List) obj2;
                if (SIZE == j || LENGTH == j) {
                    return Integer.valueOf(list.size());
                }
                while (i < list.size()) {
                    Object obj4 = list.get(i);
                    if (obj4 == list) {
                        if (jSONArray == null) {
                            jSONArray = new JSONArray(list.size());
                        }
                        jSONArray.add(obj4);
                    } else {
                        Object propertyValue = getPropertyValue(obj4, str, j);
                        if (propertyValue instanceof Collection) {
                            Collection collection = (Collection) propertyValue;
                            if (jSONArray == null) {
                                jSONArray = new JSONArray(list.size());
                            }
                            jSONArray.addAll(collection);
                        } else if (propertyValue != null) {
                            if (jSONArray == null) {
                                jSONArray = new JSONArray(list.size());
                            }
                            jSONArray.add(propertyValue);
                        }
                    }
                    i++;
                }
                if (jSONArray == null) {
                    return Collections.emptyList();
                }
                return jSONArray;
            } else if (obj2 instanceof Object[]) {
                Object[] objArr = (Object[]) obj2;
                if (SIZE == j || LENGTH == j) {
                    return Integer.valueOf(objArr.length);
                }
                JSONArray jSONArray2 = new JSONArray(objArr.length);
                while (i < objArr.length) {
                    Object[] objArr2 = objArr[i];
                    if (objArr2 == objArr) {
                        jSONArray2.add(objArr2);
                    } else {
                        Object propertyValue2 = getPropertyValue(objArr2, str, j);
                        if (propertyValue2 instanceof Collection) {
                            jSONArray2.addAll((Collection) propertyValue2);
                        } else if (propertyValue2 != null) {
                            jSONArray2.add(propertyValue2);
                        }
                    }
                    i++;
                }
                return jSONArray2;
            } else {
                if (obj2 instanceof Enum) {
                    Enum enumR = (Enum) obj2;
                    if (-4270347329889690746L == j) {
                        return enumR.name();
                    }
                    if (-1014497654951707614L == j) {
                        return Integer.valueOf(enumR.ordinal());
                    }
                }
                if (obj2 instanceof Calendar) {
                    Calendar calendar = (Calendar) obj2;
                    if (8963398325558730460L == j) {
                        return Integer.valueOf(calendar.get(1));
                    }
                    if (-811277319855450459L == j) {
                        return Integer.valueOf(calendar.get(2));
                    }
                    if (-3851359326990528739L == j) {
                        return Integer.valueOf(calendar.get(5));
                    }
                    if (4647432019745535567L == j) {
                        return Integer.valueOf(calendar.get(11));
                    }
                    if (6607618197526598121L == j) {
                        return Integer.valueOf(calendar.get(12));
                    }
                    if (-6586085717218287427L == j) {
                        return Integer.valueOf(calendar.get(13));
                    }
                }
                return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void deepScan(Object obj, String str, List<Object> list) {
        if (obj != null) {
            if (obj instanceof Map) {
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object value = entry.getValue();
                    if (str.equals(entry.getKey())) {
                        if (value instanceof Collection) {
                            list.addAll((Collection) value);
                        } else {
                            list.add(value);
                        }
                    } else if (value != null && !ParserConfig.isPrimitive2(value.getClass())) {
                        deepScan(value, str, list);
                    }
                }
            } else if (obj instanceof Collection) {
                for (Object next : (Collection) obj) {
                    if (!ParserConfig.isPrimitive2(next.getClass())) {
                        deepScan(next, str, list);
                    }
                }
            } else {
                JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
                if (javaBeanSerializer != null) {
                    try {
                        FieldSerializer fieldSerializer = javaBeanSerializer.getFieldSerializer(str);
                        if (fieldSerializer != null) {
                            list.add(fieldSerializer.getPropertyValueDirect(obj));
                            return;
                        }
                        for (Object deepScan : javaBeanSerializer.getFieldValues(obj)) {
                            deepScan(deepScan, str, list);
                        }
                    } catch (InvocationTargetException e) {
                        throw new JSONException("getFieldValue error." + str, e);
                    } catch (IllegalAccessException e2) {
                        throw new JSONException("getFieldValue error." + str, e2);
                    } catch (Exception e3) {
                        throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e3);
                    }
                } else if (obj instanceof List) {
                    List list2 = (List) obj;
                    for (int i = 0; i < list2.size(); i++) {
                        deepScan(list2.get(i), str, list);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void deepSet(Object obj, String str, long j, Object obj2) {
        if (obj != null) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.containsKey(str)) {
                    map.get(str);
                    map.put(str, obj2);
                    return;
                }
                for (Object deepSet : map.values()) {
                    deepSet(deepSet, str, j, obj2);
                }
                return;
            }
            Class<?> cls = obj.getClass();
            JavaBeanDeserializer javaBeanDeserializer = getJavaBeanDeserializer(cls);
            if (javaBeanDeserializer != null) {
                try {
                    FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
                    if (fieldDeserializer != null) {
                        fieldDeserializer.setValue(obj, obj2);
                        return;
                    }
                    for (Object deepSet2 : getJavaBeanSerializer(cls).getObjectFieldValues(obj)) {
                        deepSet(deepSet2, str, j, obj2);
                    }
                } catch (Exception e) {
                    throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e);
                }
            } else if (obj instanceof List) {
                List list = (List) obj;
                for (int i = 0; i < list.size(); i++) {
                    deepSet(list.get(i), str, j, obj2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean setPropertyValue(Object obj, String str, long j, Object obj2) {
        if (obj instanceof Map) {
            ((Map) obj).put(str, obj2);
            return true;
        } else if (obj instanceof List) {
            for (Object next : (List) obj) {
                if (next != null) {
                    setPropertyValue(next, str, j, obj2);
                }
            }
            return true;
        } else {
            ObjectDeserializer deserializer = this.parserConfig.getDeserializer((Type) obj.getClass());
            JavaBeanDeserializer javaBeanDeserializer = null;
            if (deserializer instanceof JavaBeanDeserializer) {
                javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
            }
            if (javaBeanDeserializer != null) {
                FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(j);
                if (fieldDeserializer == null) {
                    return false;
                }
                fieldDeserializer.setValue(obj, obj2);
                return true;
            }
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: protected */
    public boolean removePropertyValue(Object obj, String str, boolean z) {
        boolean z2 = true;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.remove(str) == null) {
                z2 = false;
            }
            if (z) {
                for (Object removePropertyValue : map.values()) {
                    removePropertyValue(removePropertyValue, str, z);
                }
            }
            return z2;
        }
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer((Type) obj.getClass());
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (javaBeanDeserializer != null) {
            FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
            if (fieldDeserializer != null) {
                fieldDeserializer.setValue(obj, (String) null);
            } else {
                z2 = false;
            }
            if (z) {
                for (Object next : getPropertyValues(obj)) {
                    if (next != null) {
                        removePropertyValue(next, str, z);
                    }
                }
            }
            return z2;
        } else if (z) {
            return false;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: protected */
    public JavaBeanSerializer getJavaBeanSerializer(Class<?> cls) {
        ObjectSerializer objectWriter = this.serializeConfig.getObjectWriter(cls);
        if (objectWriter instanceof JavaBeanSerializer) {
            return (JavaBeanSerializer) objectWriter;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JavaBeanDeserializer getJavaBeanDeserializer(Class<?> cls) {
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer((Type) cls);
        if (deserializer instanceof JavaBeanDeserializer) {
            return (JavaBeanDeserializer) deserializer;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int evalSize(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            int i = 0;
            for (Object obj2 : ((Map) obj).values()) {
                if (obj2 != null) {
                    i++;
                }
            }
            return i;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer == null) {
            return -1;
        }
        try {
            return javaBeanSerializer.getSize(obj);
        } catch (Exception e) {
            throw new JSONPathException("evalSize error : " + this.path, e);
        }
    }

    /* access modifiers changed from: package-private */
    public Set<?> evalKeySet(Object obj) {
        JavaBeanSerializer javaBeanSerializer;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).keySet();
        }
        if ((obj instanceof Collection) || (obj instanceof Object[]) || obj.getClass().isArray() || (javaBeanSerializer = getJavaBeanSerializer(obj.getClass())) == null) {
            return null;
        }
        try {
            return javaBeanSerializer.getFieldNames(obj);
        } catch (Exception e) {
            throw new JSONPathException("evalKeySet error : " + this.path, e);
        }
    }

    public String toJSONString() {
        return FastJsonInstrumentation.toJSONString(this.path);
    }

    public static Object reserveToArray(Object obj, String... strArr) {
        JSONArray jSONArray = new JSONArray();
        if (!(strArr == null || strArr.length == 0)) {
            for (String compile : strArr) {
                JSONPath compile2 = compile(compile);
                compile2.init();
                jSONArray.add(compile2.eval(obj));
            }
        }
        return jSONArray;
    }

    public static Object reserveToObject(Object obj, String... strArr) {
        Object eval;
        if (strArr == null || strArr.length == 0) {
            return obj;
        }
        JSONObject jSONObject = new JSONObject(true);
        for (String compile : strArr) {
            JSONPath compile2 = compile(compile);
            compile2.init();
            Segment[] segmentArr = compile2.segments;
            if ((segmentArr[segmentArr.length - 1] instanceof PropertySegment) && (eval = compile2.eval(obj)) != null) {
                compile2.set(jSONObject, eval);
            }
        }
        return jSONObject;
    }
}
