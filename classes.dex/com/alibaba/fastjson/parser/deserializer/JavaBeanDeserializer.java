package com.alibaba.fastjson.parser.deserializer;

import com.adyen.checkout.components.status.api.StatusResponseUtils;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private Map<String, FieldDeserializer> fieldDeserializerMap;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] hashArray;
    private transient short[] hashArrayMapping;
    private transient long[] smartMatchHashArray;
    private transient short[] smartMatchHashArrayMapping;
    protected final FieldDeserializer[] sortedFieldDeserializers;

    public int getFastMatchToken() {
        return 12;
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean, parserConfig.isJacksonCompatible()));
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) {
        this.clazz = javaBeanInfo.clazz;
        this.beanInfo = javaBeanInfo;
        this.sortedFieldDeserializers = new FieldDeserializer[javaBeanInfo.sortedFields.length];
        int length = javaBeanInfo.sortedFields.length;
        HashMap hashMap = null;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
            this.sortedFieldDeserializers[i] = createFieldDeserializer;
            if (length > 128) {
                if (this.fieldDeserializerMap == null) {
                    this.fieldDeserializerMap = new HashMap();
                }
                this.fieldDeserializerMap.put(fieldInfo.name, createFieldDeserializer);
            }
            for (String str : fieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        this.fieldDeserializers = new FieldDeserializer[javaBeanInfo.fields.length];
        int length2 = javaBeanInfo.fields.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return getFieldDeserializer(str, (int[]) null);
    }

    public FieldDeserializer getFieldDeserializer(String str, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        if (str == null) {
            return null;
        }
        Map<String, FieldDeserializer> map = this.fieldDeserializerMap;
        if (map != null && (fieldDeserializer = map.get(str)) != null) {
            return fieldDeserializer;
        }
        int i = 0;
        int length = this.sortedFieldDeserializers.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo > 0) {
                length = i2 - 1;
            } else if (isSetFlag(i2, iArr)) {
                return null;
            } else {
                return this.sortedFieldDeserializers[i2];
            }
        }
        Map<String, FieldDeserializer> map2 = this.alterNameFieldDeserializers;
        if (map2 != null) {
            return map2.get(str);
        }
        return null;
    }

    public FieldDeserializer getFieldDeserializer(long j) {
        int i = 0;
        if (this.hashArray == null) {
            long[] jArr = new long[this.sortedFieldDeserializers.length];
            int i2 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i2 >= fieldDeserializerArr.length) {
                    break;
                }
                jArr[i2] = TypeUtils.fnv1a_64(fieldDeserializerArr[i2].fieldInfo.name);
                i2++;
            }
            Arrays.sort(jArr);
            this.hashArray = jArr;
        }
        int binarySearch = Arrays.binarySearch(this.hashArray, j);
        if (binarySearch < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, -1);
            while (true) {
                FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                if (i >= fieldDeserializerArr2.length) {
                    break;
                }
                int binarySearch2 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(fieldDeserializerArr2[i].fieldInfo.name));
                if (binarySearch2 >= 0) {
                    sArr[binarySearch2] = (short) i;
                }
                i++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch];
        if (s != -1) {
            return this.sortedFieldDeserializers[s];
        }
        return null;
    }

    static boolean isSetFlag(int i, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int i2 = i / 32;
        int i3 = i % 32;
        if (i2 < iArr.length) {
            if (((1 << i3) & iArr[i2]) != 0) {
                return true;
            }
        }
        return false;
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object obj;
        if (!(type instanceof Class) || !this.clazz.isInterface()) {
            Object obj2 = null;
            if (this.beanInfo.defaultConstructor == null && this.beanInfo.factoryMethod == null) {
                return null;
            }
            if (this.beanInfo.factoryMethod != null && this.beanInfo.defaultConstructorParameterSize > 0) {
                return null;
            }
            try {
                Constructor<?> constructor = this.beanInfo.defaultConstructor;
                if (this.beanInfo.defaultConstructorParameterSize != 0) {
                    ParseContext context = defaultJSONParser.getContext();
                    if (context != null) {
                        if (context.object != null) {
                            if (type instanceof Class) {
                                String name = ((Class) type).getName();
                                String substring = name.substring(0, name.lastIndexOf(36));
                                Object obj3 = context.object;
                                String name2 = obj3.getClass().getName();
                                if (!name2.equals(substring)) {
                                    ParseContext parseContext = context.parent;
                                    if (parseContext == null || parseContext.object == null || (!"java.util.ArrayList".equals(name2) && !"java.util.List".equals(name2) && !"java.util.Collection".equals(name2) && !"java.util.Map".equals(name2) && !"java.util.HashMap".equals(name2))) {
                                        obj2 = obj3;
                                    } else if (parseContext.object.getClass().getName().equals(substring)) {
                                        obj2 = parseContext.object;
                                    }
                                    obj3 = obj2;
                                }
                                if (obj3 == null || ((obj3 instanceof Collection) && ((Collection) obj3).isEmpty())) {
                                    throw new JSONException("can't create non-static inner class instance.");
                                }
                                obj = constructor.newInstance(new Object[]{obj3});
                            } else {
                                throw new JSONException("can't create non-static inner class instance.");
                            }
                        }
                    }
                    throw new JSONException("can't create non-static inner class instance.");
                } else if (constructor != null) {
                    obj = constructor.newInstance(new Object[0]);
                } else {
                    obj = this.beanInfo.factoryMethod.invoke((Object) null, new Object[0]);
                }
                if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                    for (FieldInfo fieldInfo : this.beanInfo.fields) {
                        if (fieldInfo.fieldClass == String.class) {
                            try {
                                fieldInfo.set(obj, "");
                            } catch (Exception e) {
                                throw new JSONException("create instance error, class " + this.clazz.getName(), e);
                            }
                        }
                    }
                }
                return obj;
            } catch (JSONException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new JSONException("create instance error, class " + this.clazz.getName(), e3);
            }
        } else {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return deserialze(defaultJSONParser, type, obj, 0);
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i) {
        return deserialze(defaultJSONParser, type, obj, (Object) null, i, (int[]) null);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        Enum<?> enumR;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 14) {
            T createInstance = createInstance(defaultJSONParser, type);
            int i = 0;
            int length = this.sortedFieldDeserializers.length;
            while (true) {
                int i2 = 16;
                if (i >= length) {
                    break;
                }
                char c = i == length + -1 ? ']' : ',';
                FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
                Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                if (cls == Integer.TYPE) {
                    fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanInt(c));
                } else if (cls == String.class) {
                    fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanString(c));
                } else if (cls == Long.TYPE) {
                    fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanLong(c));
                } else if (cls.isEnum()) {
                    char current = jSONLexer.getCurrent();
                    if (current == '\"' || current == 'n') {
                        enumR = jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c);
                    } else if (current < '0' || current > '9') {
                        enumR = scanEnum(jSONLexer, c);
                    } else {
                        enumR = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c));
                    }
                    fieldDeserializer.setValue((Object) createInstance, (Object) enumR);
                } else if (cls == Boolean.TYPE) {
                    fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanBoolean(c));
                } else if (cls == Float.TYPE) {
                    fieldDeserializer.setValue((Object) createInstance, (Object) Float.valueOf(jSONLexer.scanFloat(c)));
                } else if (cls == Double.TYPE) {
                    fieldDeserializer.setValue((Object) createInstance, (Object) Double.valueOf(jSONLexer.scanDouble(c)));
                } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                    fieldDeserializer.setValue((Object) createInstance, (Object) new Date(jSONLexer.scanLong(c)));
                } else if (cls == BigDecimal.class) {
                    fieldDeserializer.setValue((Object) createInstance, (Object) jSONLexer.scanDecimal(c));
                } else {
                    jSONLexer.nextToken(14);
                    fieldDeserializer.setValue((Object) createInstance, defaultJSONParser.parseObject(fieldDeserializer.fieldInfo.fieldType, (Object) fieldDeserializer.fieldInfo.name));
                    if (jSONLexer.token() == 15) {
                        break;
                    }
                    if (c == ']') {
                        i2 = 15;
                    }
                    check(jSONLexer, i2);
                }
                i++;
            }
            jSONLexer.nextToken(16);
            return createInstance;
        }
        throw new JSONException(StatusResponseUtils.RESULT_ERROR);
    }

    /* access modifiers changed from: protected */
    public void check(JSONLexer jSONLexer, int i) {
        if (jSONLexer.token() != i) {
            throw new JSONException("syntax error");
        }
    }

    /* access modifiers changed from: protected */
    public Enum<?> scanEnum(JSONLexer jSONLexer, char c) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v16, resolved type: ?} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v17, resolved type: ?} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: ?} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v18, resolved type: T} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v38, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v124, resolved type: com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v58, resolved type: java.lang.Class} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v28, resolved type: com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v60, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v74, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v79, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v80, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v73, resolved type: java.lang.Class} */
    /* JADX WARNING: type inference failed for: r6v32 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0134, code lost:
        throw new com.alibaba.fastjson.JSONException(r1.getMessage(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
        r1 = r0;
        r3 = r7;
        r5 = null;
        r15 = r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x037e, code lost:
        if (r12.matchStat == -2) goto L_0x0380;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x040f, code lost:
        if (r12.isEnabled(com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas) != false) goto L_0x0411;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:?, code lost:
        r12.nextTokenWithColon(4);
        r1 = r12.token();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x042b, code lost:
        if (r1 != 4) goto L_0x04e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x042d, code lost:
        r1 = r12.stringVal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x0437, code lost:
        if ("@".equals(r1) == false) goto L_0x043d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x0439, code lost:
        r1 = r7.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x0443, code lost:
        if ("..".equals(r1) == false) goto L_0x045b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x0445, code lost:
        r2 = r7.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x0449, code lost:
        if (r2.object == null) goto L_0x044f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x044b, code lost:
        r1 = r2.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x044f, code lost:
        r9.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r2, r1));
        r9.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x0461, code lost:
        if ("$".equals(r1) == false) goto L_0x047e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x0463, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x0466, code lost:
        if (r2.parent == null) goto L_0x046b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x0468, code lost:
        r2 = r2.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x046d, code lost:
        if (r2.object == null) goto L_0x0472;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x046f, code lost:
        r1 = r2.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x0472, code lost:
        r9.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r2, r1));
        r9.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x0484, code lost:
        if (r1.indexOf(92) <= 0) goto L_0x04a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x0486, code lost:
        r3 = new java.lang.StringBuilder();
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x0490, code lost:
        if (r4 >= r1.length()) goto L_0x04a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x0492, code lost:
        r6 = r1.charAt(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0496, code lost:
        if (r6 != '\\') goto L_0x049e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x0498, code lost:
        r4 = r4 + 1;
        r6 = r1.charAt(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x049e, code lost:
        r3.append(r6);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x04a4, code lost:
        r1 = r3.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x04a8, code lost:
        r2 = r9.resolveReference(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x04ac, code lost:
        if (r2 == null) goto L_0x04b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x04ae, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x04b0, code lost:
        r9.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r7, r1));
        r9.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x04bb, code lost:
        r1 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:?, code lost:
        r12.nextToken(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x04c6, code lost:
        if (r12.token() != 13) goto L_0x04d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:389:0x04c8, code lost:
        r12.nextToken(16);
        r9.setContext(r7, r1, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:390:0x04d0, code lost:
        if (r5 == null) goto L_0x04d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:391:0x04d2, code lost:
        r5.object = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:392:0x04d4, code lost:
        r9.setContext(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:393:0x04d7, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x04df, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:399:0x04fa, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x052d, code lost:
        r2 = getSeeAlso(r13, r8.beanInfo, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x0533, code lost:
        if (r2 != null) goto L_0x054a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:?, code lost:
        r15 = r13.checkAutoType(r1, com.alibaba.fastjson.util.TypeUtils.getClass(r35), r12.getFeatures());
        r2 = r34.getConfig().getDeserializer(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x054a, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:419:?, code lost:
        r3 = r2.deserialze(r9, r15, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:420:0x0551, code lost:
        if ((r2 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L_0x055e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:422:?, code lost:
        r2 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:423:0x0555, code lost:
        if (r4 == null) goto L_0x055e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:424:0x0557, code lost:
        r2.getFieldDeserializer(r4).setValue((java.lang.Object) r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:425:0x055e, code lost:
        if (r5 == null) goto L_0x0564;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:426:0x0560, code lost:
        r5.object = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:427:0x0564, code lost:
        r9.setContext(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:428:0x0567, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:510:0x06c5, code lost:
        r1 = r16;
        r5 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:711:0x0998, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r12.token()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0129, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x012a, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:14:0x0039, B:82:0x00ee] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0317 A[Catch:{ all -> 0x0417 }] */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x03ac A[Catch:{ all -> 0x0417 }] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x03af A[Catch:{ all -> 0x0417 }] */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x03e8 A[SYNTHETIC, Splitter:B:329:0x03e8] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0072 A[Catch:{ Exception -> 0x0129, all -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x05ad A[Catch:{ all -> 0x05a5, all -> 0x05e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x05b8 A[ADDED_TO_REGION, Catch:{ all -> 0x05a5, all -> 0x05e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x05f3  */
    /* JADX WARNING: Removed duplicated region for block: B:489:0x0668  */
    /* JADX WARNING: Removed duplicated region for block: B:506:0x06b7 A[Catch:{ all -> 0x09a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:507:0x06bc A[Catch:{ all -> 0x09a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:634:0x0852 A[SYNTHETIC, Splitter:B:634:0x0852] */
    /* JADX WARNING: Removed duplicated region for block: B:655:0x0891 A[SYNTHETIC, Splitter:B:655:0x0891] */
    /* JADX WARNING: Removed duplicated region for block: B:724:0x09bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r34, java.lang.reflect.Type r35, java.lang.Object r36, java.lang.Object r37, int r38, int[] r39) {
        /*
            r33 = this;
            r8 = r33
            r9 = r34
            r10 = r35
            r11 = r36
            java.lang.Class<com.alibaba.fastjson.JSON> r1 = com.alibaba.fastjson.JSON.class
            if (r10 == r1) goto L_0x09c1
            java.lang.Class<com.alibaba.fastjson.JSONObject> r1 = com.alibaba.fastjson.JSONObject.class
            if (r10 != r1) goto L_0x0012
            goto L_0x09c1
        L_0x0012:
            com.alibaba.fastjson.parser.JSONLexer r1 = r9.lexer
            r12 = r1
            com.alibaba.fastjson.parser.JSONLexerBase r12 = (com.alibaba.fastjson.parser.JSONLexerBase) r12
            com.alibaba.fastjson.parser.ParserConfig r13 = r34.getConfig()
            int r1 = r12.token()
            r2 = 8
            r14 = 16
            r15 = 0
            if (r1 != r2) goto L_0x002a
            r12.nextToken(r14)
            return r15
        L_0x002a:
            com.alibaba.fastjson.parser.ParseContext r2 = r34.getContext()
            if (r37 == 0) goto L_0x0034
            if (r2 == 0) goto L_0x0034
            com.alibaba.fastjson.parser.ParseContext r2 = r2.parent
        L_0x0034:
            r7 = r2
            r6 = 13
            if (r1 != r6) goto L_0x0051
            r12.nextToken(r14)     // Catch:{ all -> 0x0049 }
            if (r37 != 0) goto L_0x0043
            java.lang.Object r1 = r33.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r34, (java.lang.reflect.Type) r35)     // Catch:{ all -> 0x0049 }
            goto L_0x0045
        L_0x0043:
            r1 = r37
        L_0x0045:
            r9.setContext(r7)
            return r1
        L_0x0049:
            r0 = move-exception
            r1 = r0
            r3 = r7
            r5 = r15
            r15 = r37
            goto L_0x09b9
        L_0x0051:
            r2 = 14
            if (r1 != r2) goto L_0x007a
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean     // Catch:{ all -> 0x0049 }
            int r3 = r3.mask     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.util.JavaBeanInfo r6 = r8.beanInfo     // Catch:{ all -> 0x0049 }
            int r6 = r6.parserFeatures     // Catch:{ all -> 0x0049 }
            r6 = r6 & r3
            if (r6 != 0) goto L_0x006f
            com.alibaba.fastjson.parser.Feature r6 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean     // Catch:{ all -> 0x0049 }
            boolean r6 = r12.isEnabled((com.alibaba.fastjson.parser.Feature) r6)     // Catch:{ all -> 0x0049 }
            if (r6 != 0) goto L_0x006f
            r3 = r38 & r3
            if (r3 == 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r3 = 0
            goto L_0x0070
        L_0x006f:
            r3 = 1
        L_0x0070:
            if (r3 == 0) goto L_0x007a
            java.lang.Object r1 = r33.deserialzeArrayMapping(r34, r35, r36, r37)     // Catch:{ all -> 0x0049 }
            r9.setContext(r7)
            return r1
        L_0x007a:
            r3 = 12
            r6 = 5
            r5 = 4
            if (r1 == r3) goto L_0x0172
            if (r1 == r14) goto L_0x0172
            boolean r3 = r12.isBlankInput()     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x008c
            r9.setContext(r7)
            return r15
        L_0x008c:
            if (r1 != r5) goto L_0x00c7
            java.lang.String r3 = r12.stringVal()     // Catch:{ all -> 0x0049 }
            int r6 = r3.length()     // Catch:{ all -> 0x0049 }
            if (r6 != 0) goto L_0x009f
            r12.nextToken()     // Catch:{ all -> 0x0049 }
            r9.setContext(r7)
            return r15
        L_0x009f:
            com.alibaba.fastjson.util.JavaBeanInfo r6 = r8.beanInfo     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.annotation.JSONType r6 = r6.jsonType     // Catch:{ all -> 0x0049 }
            if (r6 == 0) goto L_0x00cc
            com.alibaba.fastjson.util.JavaBeanInfo r6 = r8.beanInfo     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.annotation.JSONType r6 = r6.jsonType     // Catch:{ all -> 0x0049 }
            java.lang.Class[] r6 = r6.seeAlso()     // Catch:{ all -> 0x0049 }
            int r10 = r6.length     // Catch:{ all -> 0x0049 }
            r14 = 0
        L_0x00af:
            if (r14 >= r10) goto L_0x00cc
            r5 = r6[r14]     // Catch:{ all -> 0x0049 }
            java.lang.Class<java.lang.Enum> r4 = java.lang.Enum.class
            boolean r4 = r4.isAssignableFrom(r5)     // Catch:{ all -> 0x0049 }
            if (r4 == 0) goto L_0x00c3
            java.lang.Enum r1 = java.lang.Enum.valueOf(r5, r3)     // Catch:{ IllegalArgumentException -> 0x00c3 }
            r9.setContext(r7)
            return r1
        L_0x00c3:
            int r14 = r14 + 1
            r5 = 4
            goto L_0x00af
        L_0x00c7:
            if (r1 != r6) goto L_0x00cc
            r12.getCalendar()     // Catch:{ all -> 0x0049 }
        L_0x00cc:
            if (r1 != r2) goto L_0x00e0
            char r2 = r12.getCurrent()     // Catch:{ all -> 0x0049 }
            r3 = 93
            if (r2 != r3) goto L_0x00e0
            r12.next()     // Catch:{ all -> 0x0049 }
            r12.nextToken()     // Catch:{ all -> 0x0049 }
            r9.setContext(r7)
            return r15
        L_0x00e0:
            com.alibaba.fastjson.util.JavaBeanInfo r2 = r8.beanInfo     // Catch:{ all -> 0x0049 }
            java.lang.reflect.Method r2 = r2.factoryMethod     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x0135
            com.alibaba.fastjson.util.JavaBeanInfo r2 = r8.beanInfo     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.util.FieldInfo[] r2 = r2.fields     // Catch:{ all -> 0x0049 }
            int r2 = r2.length     // Catch:{ all -> 0x0049 }
            r3 = 1
            if (r2 != r3) goto L_0x0135
            com.alibaba.fastjson.util.JavaBeanInfo r2 = r8.beanInfo     // Catch:{ Exception -> 0x0129 }
            com.alibaba.fastjson.util.FieldInfo[] r2 = r2.fields     // Catch:{ Exception -> 0x0129 }
            r3 = 0
            r2 = r2[r3]     // Catch:{ Exception -> 0x0129 }
            java.lang.Class<?> r3 = r2.fieldClass     // Catch:{ Exception -> 0x0129 }
            java.lang.Class<java.lang.Integer> r4 = java.lang.Integer.class
            if (r3 != r4) goto L_0x0111
            r3 = 2
            if (r1 != r3) goto L_0x0135
            int r1 = r12.intValue()     // Catch:{ Exception -> 0x0129 }
            r12.nextToken()     // Catch:{ Exception -> 0x0129 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0129 }
            java.lang.Object r1 = r8.createFactoryInstance(r13, r1)     // Catch:{ Exception -> 0x0129 }
            r9.setContext(r7)
            return r1
        L_0x0111:
            java.lang.Class<?> r2 = r2.fieldClass     // Catch:{ Exception -> 0x0129 }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r2 != r3) goto L_0x0135
            r2 = 4
            if (r1 != r2) goto L_0x0135
            java.lang.String r1 = r12.stringVal()     // Catch:{ Exception -> 0x0129 }
            r12.nextToken()     // Catch:{ Exception -> 0x0129 }
            java.lang.Object r1 = r8.createFactoryInstance(r13, r1)     // Catch:{ Exception -> 0x0129 }
            r9.setContext(r7)
            return r1
        L_0x0129:
            r0 = move-exception
            r1 = r0
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x0049 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0049 }
            throw r2     // Catch:{ all -> 0x0049 }
        L_0x0135:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r1.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = "syntax error, expect {, actual "
            r1.append(r2)     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = r12.tokenName()     // Catch:{ all -> 0x0049 }
            r1.append(r2)     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = ", pos "
            r1.append(r2)     // Catch:{ all -> 0x0049 }
            int r2 = r12.pos()     // Catch:{ all -> 0x0049 }
            r1.append(r2)     // Catch:{ all -> 0x0049 }
            boolean r2 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x015e
            java.lang.String r2 = ", fieldName "
            r1.append(r2)     // Catch:{ all -> 0x0049 }
            r1.append(r11)     // Catch:{ all -> 0x0049 }
        L_0x015e:
            java.lang.String r2 = ", fastjson-version "
            r1.append(r2)     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = "1.2.60"
            r1.append(r2)     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0049 }
            r2.<init>(r1)     // Catch:{ all -> 0x0049 }
            throw r2     // Catch:{ all -> 0x0049 }
        L_0x0172:
            int r1 = r9.resolveStatus     // Catch:{ all -> 0x09b2 }
            r2 = 2
            if (r1 != r2) goto L_0x017b
            r5 = 0
            r9.resolveStatus = r5     // Catch:{ all -> 0x0049 }
            goto L_0x017c
        L_0x017b:
            r5 = 0
        L_0x017c:
            com.alibaba.fastjson.util.JavaBeanInfo r1 = r8.beanInfo     // Catch:{ all -> 0x09b2 }
            java.lang.String r4 = r1.typeKey     // Catch:{ all -> 0x09b2 }
            r1 = r37
            r2 = r39
            r3 = r5
            r19 = r15
            r5 = r19
            r15 = r3
        L_0x018a:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r6 = r8.sortedFieldDeserializers     // Catch:{ all -> 0x09ac }
            int r14 = r6.length     // Catch:{ all -> 0x09ac }
            if (r3 >= r14) goto L_0x01bc
            r14 = 16
            if (r15 >= r14) goto L_0x01bc
            r6 = r6[r3]     // Catch:{ all -> 0x01b6 }
            com.alibaba.fastjson.util.FieldInfo r14 = r6.fieldInfo     // Catch:{ all -> 0x01b6 }
            r37 = r3
            java.lang.Class<?> r3 = r14.fieldClass     // Catch:{ all -> 0x01b6 }
            com.alibaba.fastjson.annotation.JSONField r21 = r14.getAnnotation()     // Catch:{ all -> 0x01b6 }
            if (r21 == 0) goto L_0x01ae
            r39 = r3
            boolean r3 = r6 instanceof com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer     // Catch:{ all -> 0x01b6 }
            if (r3 == 0) goto L_0x01b0
            r3 = r6
            com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer r3 = (com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer) r3     // Catch:{ all -> 0x01b6 }
            boolean r3 = r3.customDeserilizer     // Catch:{ all -> 0x01b6 }
            r10 = r14
            goto L_0x01b2
        L_0x01ae:
            r39 = r3
        L_0x01b0:
            r10 = r14
            r3 = 0
        L_0x01b2:
            r14 = r6
            r6 = r39
            goto L_0x01c4
        L_0x01b6:
            r0 = move-exception
            r15 = r1
            r3 = r7
        L_0x01b9:
            r1 = r0
            goto L_0x09b9
        L_0x01bc:
            r37 = r3
            r3 = 0
            r6 = 0
            r10 = 0
            r14 = 0
            r21 = 0
        L_0x01c4:
            r22 = 0
            r24 = 0
            r25 = 0
            if (r14 == 0) goto L_0x03dc
            r39 = r2
            char[] r2 = r10.name_chars     // Catch:{ all -> 0x03d3 }
            if (r3 == 0) goto L_0x01e2
            boolean r3 = r12.matchField((char[]) r2)     // Catch:{ all -> 0x01b6 }
            if (r3 == 0) goto L_0x01e2
            r27 = r1
        L_0x01da:
            r28 = r10
            r1 = 0
            r2 = 0
        L_0x01de:
            r3 = 1
        L_0x01df:
            r10 = 5
            goto L_0x03e6
        L_0x01e2:
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x03d3 }
            r27 = r1
            r1 = -2
            if (r6 == r3) goto L_0x0393
            java.lang.Class<java.lang.Integer> r3 = java.lang.Integer.class
            if (r6 != r3) goto L_0x01ef
            goto L_0x0393
        L_0x01ef:
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0417 }
            if (r6 == r3) goto L_0x0360
            java.lang.Class<java.lang.Long> r3 = java.lang.Long.class
            if (r6 != r3) goto L_0x01f9
            goto L_0x0360
        L_0x01f9:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r6 != r3) goto L_0x0214
            java.lang.String r2 = r12.scanFieldString(r2)     // Catch:{ all -> 0x0417 }
            int r3 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r3 <= 0) goto L_0x0209
        L_0x0205:
            r28 = r10
            r1 = 1
            goto L_0x01de
        L_0x0209:
            int r3 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r3 != r1) goto L_0x020f
            goto L_0x0380
        L_0x020f:
            r28 = r10
            r1 = 0
            r3 = 0
            goto L_0x01df
        L_0x0214:
            java.lang.Class<java.util.Date> r3 = java.util.Date.class
            if (r6 != r3) goto L_0x022b
            java.lang.String r3 = r10.format     // Catch:{ all -> 0x0417 }
            if (r3 != 0) goto L_0x022b
            java.util.Date r2 = r12.scanFieldDate(r2)     // Catch:{ all -> 0x0417 }
            int r3 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r3 <= 0) goto L_0x0225
            goto L_0x0205
        L_0x0225:
            int r3 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r3 != r1) goto L_0x020f
            goto L_0x0380
        L_0x022b:
            java.lang.Class<java.math.BigDecimal> r3 = java.math.BigDecimal.class
            if (r6 != r3) goto L_0x023e
            java.math.BigDecimal r2 = r12.scanFieldDecimal(r2)     // Catch:{ all -> 0x0417 }
            int r3 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r3 <= 0) goto L_0x0238
            goto L_0x0205
        L_0x0238:
            int r3 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r3 != r1) goto L_0x020f
            goto L_0x0380
        L_0x023e:
            java.lang.Class<java.math.BigInteger> r3 = java.math.BigInteger.class
            if (r6 != r3) goto L_0x0251
            java.math.BigInteger r2 = r12.scanFieldBigInteger(r2)     // Catch:{ all -> 0x0417 }
            int r3 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r3 <= 0) goto L_0x024b
            goto L_0x0205
        L_0x024b:
            int r3 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r3 != r1) goto L_0x020f
            goto L_0x0380
        L_0x0251:
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0417 }
            if (r6 == r3) goto L_0x0343
            java.lang.Class<java.lang.Boolean> r3 = java.lang.Boolean.class
            if (r6 != r3) goto L_0x025b
            goto L_0x0343
        L_0x025b:
            java.lang.Class r3 = java.lang.Float.TYPE     // Catch:{ all -> 0x0417 }
            if (r6 == r3) goto L_0x0322
            java.lang.Class<java.lang.Float> r3 = java.lang.Float.class
            if (r6 != r3) goto L_0x0265
            goto L_0x0322
        L_0x0265:
            java.lang.Class r3 = java.lang.Double.TYPE     // Catch:{ all -> 0x0417 }
            if (r6 == r3) goto L_0x02f7
            java.lang.Class<java.lang.Double> r3 = java.lang.Double.class
            if (r6 != r3) goto L_0x026f
            goto L_0x02f7
        L_0x026f:
            boolean r3 = r6.isEnum()     // Catch:{ all -> 0x0417 }
            if (r3 == 0) goto L_0x02ac
            com.alibaba.fastjson.parser.ParserConfig r3 = r34.getConfig()     // Catch:{ all -> 0x0417 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r3 = r3.getDeserializer((java.lang.reflect.Type) r6)     // Catch:{ all -> 0x0417 }
            boolean r3 = r3 instanceof com.alibaba.fastjson.parser.deserializer.EnumDeserializer     // Catch:{ all -> 0x0417 }
            if (r3 == 0) goto L_0x02ac
            if (r21 == 0) goto L_0x028b
            java.lang.Class r3 = r21.deserializeUsing()     // Catch:{ all -> 0x0417 }
            java.lang.Class<java.lang.Void> r1 = java.lang.Void.class
            if (r3 != r1) goto L_0x02ac
        L_0x028b:
            boolean r1 = r14 instanceof com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer     // Catch:{ all -> 0x0417 }
            if (r1 == 0) goto L_0x03e0
            r1 = r14
            com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer r1 = (com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer) r1     // Catch:{ all -> 0x0417 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r1 = r1.fieldValueDeserilizer     // Catch:{ all -> 0x0417 }
            java.lang.Enum r2 = r8.scanEnum(r12, r2, r1)     // Catch:{ all -> 0x0417 }
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r1 <= 0) goto L_0x029f
            r1 = 1
            r3 = 1
            goto L_0x02a8
        L_0x029f:
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            r3 = -2
            if (r1 != r3) goto L_0x02a6
            goto L_0x0380
        L_0x02a6:
            r1 = 0
            r3 = 0
        L_0x02a8:
            r28 = r10
            goto L_0x0391
        L_0x02ac:
            java.lang.Class<int[]> r1 = int[].class
            if (r6 != r1) goto L_0x02c1
            int[] r2 = r12.scanFieldIntArray(r2)     // Catch:{ all -> 0x0417 }
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r1 <= 0) goto L_0x02ba
            goto L_0x0205
        L_0x02ba:
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            r3 = -2
            if (r1 != r3) goto L_0x020f
            goto L_0x0380
        L_0x02c1:
            java.lang.Class<float[]> r1 = float[].class
            if (r6 != r1) goto L_0x02d6
            float[] r2 = r12.scanFieldFloatArray(r2)     // Catch:{ all -> 0x0417 }
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r1 <= 0) goto L_0x02cf
            goto L_0x0205
        L_0x02cf:
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            r3 = -2
            if (r1 != r3) goto L_0x020f
            goto L_0x0380
        L_0x02d6:
            java.lang.Class<float[][]> r1 = float[][].class
            if (r6 != r1) goto L_0x02eb
            float[][] r2 = r12.scanFieldFloatArray2(r2)     // Catch:{ all -> 0x0417 }
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r1 <= 0) goto L_0x02e4
            goto L_0x0205
        L_0x02e4:
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            r3 = -2
            if (r1 != r3) goto L_0x020f
            goto L_0x0380
        L_0x02eb:
            boolean r1 = r12.matchField((char[]) r2)     // Catch:{ all -> 0x0417 }
            if (r1 == 0) goto L_0x02f3
            goto L_0x01da
        L_0x02f3:
            r21 = r15
            goto L_0x0411
        L_0x02f7:
            double r1 = r12.scanFieldDouble(r2)     // Catch:{ all -> 0x0417 }
            int r3 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x0308
            int r3 = r12.matchStat     // Catch:{ all -> 0x0417 }
            r28 = r10
            r10 = 5
            if (r3 != r10) goto L_0x030a
            r2 = 0
            goto L_0x030f
        L_0x0308:
            r28 = r10
        L_0x030a:
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ all -> 0x0417 }
            r2 = r1
        L_0x030f:
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r1 <= 0) goto L_0x0317
        L_0x0313:
            r1 = 1
            r3 = 1
            goto L_0x0391
        L_0x0317:
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            r3 = -2
            if (r1 != r3) goto L_0x031e
            goto L_0x0380
        L_0x031e:
            r1 = 0
            r3 = 0
            goto L_0x0391
        L_0x0322:
            r28 = r10
            float r1 = r12.scanFieldFloat(r2)     // Catch:{ all -> 0x0417 }
            int r2 = (r1 > r24 ? 1 : (r1 == r24 ? 0 : -1))
            if (r2 != 0) goto L_0x0333
            int r2 = r12.matchStat     // Catch:{ all -> 0x0417 }
            r3 = 5
            if (r2 != r3) goto L_0x0333
            r2 = 0
            goto L_0x0338
        L_0x0333:
            java.lang.Float r1 = java.lang.Float.valueOf(r1)     // Catch:{ all -> 0x0417 }
            r2 = r1
        L_0x0338:
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r1 <= 0) goto L_0x033d
            goto L_0x0313
        L_0x033d:
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            r3 = -2
            if (r1 != r3) goto L_0x031e
            goto L_0x0380
        L_0x0343:
            r28 = r10
            boolean r1 = r12.scanFieldBoolean(r2)     // Catch:{ all -> 0x0417 }
            int r2 = r12.matchStat     // Catch:{ all -> 0x0417 }
            r3 = 5
            if (r2 != r3) goto L_0x0350
            r2 = 0
            goto L_0x0355
        L_0x0350:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0417 }
            r2 = r1
        L_0x0355:
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r1 <= 0) goto L_0x035a
            goto L_0x0313
        L_0x035a:
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            r3 = -2
            if (r1 != r3) goto L_0x031e
            goto L_0x0380
        L_0x0360:
            r28 = r10
            long r1 = r12.scanFieldLong(r2)     // Catch:{ all -> 0x0417 }
            int r3 = (r1 > r25 ? 1 : (r1 == r25 ? 0 : -1))
            if (r3 != 0) goto L_0x0371
            int r3 = r12.matchStat     // Catch:{ all -> 0x0417 }
            r10 = 5
            if (r3 != r10) goto L_0x0371
            r2 = 0
            goto L_0x0376
        L_0x0371:
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0417 }
            r2 = r1
        L_0x0376:
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r1 <= 0) goto L_0x037b
            goto L_0x0313
        L_0x037b:
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            r3 = -2
            if (r1 != r3) goto L_0x031e
        L_0x0380:
            int r15 = r15 + 1
            r17 = r37
            r10 = r4
            r3 = r7
            r16 = r19
            r1 = 0
            r2 = 16
            r4 = 0
            r6 = 1
            r14 = 13
            goto L_0x058e
        L_0x0391:
            r10 = 5
            goto L_0x03cd
        L_0x0393:
            r28 = r10
            int r1 = r12.scanFieldInt(r2)     // Catch:{ all -> 0x0417 }
            if (r1 != 0) goto L_0x03a2
            int r2 = r12.matchStat     // Catch:{ all -> 0x0417 }
            r10 = 5
            if (r2 != r10) goto L_0x03a3
            r2 = 0
            goto L_0x03a8
        L_0x03a2:
            r10 = 5
        L_0x03a3:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0417 }
            r2 = r1
        L_0x03a8:
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            if (r1 <= 0) goto L_0x03af
            r1 = 1
            r3 = 1
            goto L_0x03cd
        L_0x03af:
            int r1 = r12.matchStat     // Catch:{ all -> 0x0417 }
            r3 = -2
            if (r1 != r3) goto L_0x03cb
            int r15 = r15 + 1
            r17 = r37
            r3 = r7
            r20 = r10
            r16 = r19
            r1 = 0
            r2 = 16
            r6 = 1
            r14 = 13
            r18 = 4
            r19 = r39
            r10 = r4
            r4 = 0
            goto L_0x0967
        L_0x03cb:
            r1 = 0
            r3 = 0
        L_0x03cd:
            r32 = r3
            r3 = r1
            r1 = r32
            goto L_0x03e6
        L_0x03d3:
            r0 = move-exception
            r27 = r1
        L_0x03d6:
            r1 = r0
            r3 = r7
            r15 = r27
            goto L_0x09b9
        L_0x03dc:
            r27 = r1
            r39 = r2
        L_0x03e0:
            r28 = r10
            r10 = 5
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x03e6:
            if (r3 != 0) goto L_0x05ad
            com.alibaba.fastjson.parser.SymbolTable r10 = r9.symbolTable     // Catch:{ all -> 0x05a5 }
            java.lang.String r10 = r12.scanSymbol(r10)     // Catch:{ all -> 0x05a5 }
            if (r10 != 0) goto L_0x0419
            r21 = r15
            int r15 = r12.token()     // Catch:{ all -> 0x0417 }
            r29 = r6
            r6 = 13
            if (r15 != r6) goto L_0x0405
            r6 = 16
            r12.nextToken(r6)     // Catch:{ all -> 0x0417 }
            r6 = r27
            goto L_0x0575
        L_0x0405:
            r6 = 16
            if (r15 != r6) goto L_0x041d
            com.alibaba.fastjson.parser.Feature r6 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x0417 }
            boolean r6 = r12.isEnabled((com.alibaba.fastjson.parser.Feature) r6)     // Catch:{ all -> 0x0417 }
            if (r6 == 0) goto L_0x041d
        L_0x0411:
            r6 = r27
            r15 = 13
            goto L_0x057e
        L_0x0417:
            r0 = move-exception
            goto L_0x03d6
        L_0x0419:
            r29 = r6
            r21 = r15
        L_0x041d:
            java.lang.String r6 = "$ref"
            if (r6 != r10) goto L_0x04fb
            if (r7 == 0) goto L_0x04fb
            r6 = 4
            r12.nextTokenWithColon(r6)     // Catch:{ all -> 0x0417 }
            int r1 = r12.token()     // Catch:{ all -> 0x0417 }
            if (r1 != r6) goto L_0x04e0
            java.lang.String r1 = r12.stringVal()     // Catch:{ all -> 0x0417 }
            java.lang.String r2 = "@"
            boolean r2 = r2.equals(r1)     // Catch:{ all -> 0x0417 }
            if (r2 == 0) goto L_0x043d
            java.lang.Object r1 = r7.object     // Catch:{ all -> 0x0417 }
            goto L_0x04bd
        L_0x043d:
            java.lang.String r2 = ".."
            boolean r2 = r2.equals(r1)     // Catch:{ all -> 0x0417 }
            if (r2 == 0) goto L_0x045b
            com.alibaba.fastjson.parser.ParseContext r2 = r7.parent     // Catch:{ all -> 0x0417 }
            java.lang.Object r3 = r2.object     // Catch:{ all -> 0x0417 }
            if (r3 == 0) goto L_0x044f
            java.lang.Object r1 = r2.object     // Catch:{ all -> 0x0417 }
            goto L_0x04bd
        L_0x044f:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r3 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0417 }
            r3.<init>(r2, r1)     // Catch:{ all -> 0x0417 }
            r9.addResolveTask(r3)     // Catch:{ all -> 0x0417 }
            r1 = 1
            r9.resolveStatus = r1     // Catch:{ all -> 0x0417 }
            goto L_0x04bb
        L_0x045b:
            java.lang.String r2 = "$"
            boolean r2 = r2.equals(r1)     // Catch:{ all -> 0x0417 }
            if (r2 == 0) goto L_0x047e
            r2 = r7
        L_0x0464:
            com.alibaba.fastjson.parser.ParseContext r3 = r2.parent     // Catch:{ all -> 0x0417 }
            if (r3 == 0) goto L_0x046b
            com.alibaba.fastjson.parser.ParseContext r2 = r2.parent     // Catch:{ all -> 0x0417 }
            goto L_0x0464
        L_0x046b:
            java.lang.Object r3 = r2.object     // Catch:{ all -> 0x0417 }
            if (r3 == 0) goto L_0x0472
            java.lang.Object r1 = r2.object     // Catch:{ all -> 0x0417 }
            goto L_0x04bd
        L_0x0472:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r3 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0417 }
            r3.<init>(r2, r1)     // Catch:{ all -> 0x0417 }
            r9.addResolveTask(r3)     // Catch:{ all -> 0x0417 }
            r1 = 1
            r9.resolveStatus = r1     // Catch:{ all -> 0x0417 }
            goto L_0x04bb
        L_0x047e:
            r2 = 92
            int r3 = r1.indexOf(r2)     // Catch:{ all -> 0x0417 }
            if (r3 <= 0) goto L_0x04a8
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0417 }
            r3.<init>()     // Catch:{ all -> 0x0417 }
            r4 = 0
        L_0x048c:
            int r6 = r1.length()     // Catch:{ all -> 0x0417 }
            if (r4 >= r6) goto L_0x04a4
            char r6 = r1.charAt(r4)     // Catch:{ all -> 0x0417 }
            if (r6 != r2) goto L_0x049e
            int r4 = r4 + 1
            char r6 = r1.charAt(r4)     // Catch:{ all -> 0x0417 }
        L_0x049e:
            r3.append(r6)     // Catch:{ all -> 0x0417 }
            r6 = 1
            int r4 = r4 + r6
            goto L_0x048c
        L_0x04a4:
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0417 }
        L_0x04a8:
            java.lang.Object r2 = r9.resolveReference(r1)     // Catch:{ all -> 0x0417 }
            if (r2 == 0) goto L_0x04b0
            r1 = r2
            goto L_0x04bd
        L_0x04b0:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0417 }
            r2.<init>(r7, r1)     // Catch:{ all -> 0x0417 }
            r9.addResolveTask(r2)     // Catch:{ all -> 0x0417 }
            r1 = 1
            r9.resolveStatus = r1     // Catch:{ all -> 0x0417 }
        L_0x04bb:
            r1 = r27
        L_0x04bd:
            r2 = 13
            r12.nextToken(r2)     // Catch:{ all -> 0x01b6 }
            int r3 = r12.token()     // Catch:{ all -> 0x01b6 }
            if (r3 != r2) goto L_0x04d8
            r2 = 16
            r12.nextToken(r2)     // Catch:{ all -> 0x01b6 }
            r9.setContext(r7, r1, r11)     // Catch:{ all -> 0x01b6 }
            if (r5 == 0) goto L_0x04d4
            r5.object = r1
        L_0x04d4:
            r9.setContext(r7)
            return r1
        L_0x04d8:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x01b6 }
            java.lang.String r3 = "illegal ref"
            r2.<init>(r3)     // Catch:{ all -> 0x01b6 }
            throw r2     // Catch:{ all -> 0x01b6 }
        L_0x04e0:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0417 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0417 }
            r3.<init>()     // Catch:{ all -> 0x0417 }
            java.lang.String r4 = "illegal ref, "
            r3.append(r4)     // Catch:{ all -> 0x0417 }
            java.lang.String r1 = com.alibaba.fastjson.parser.JSONToken.name(r1)     // Catch:{ all -> 0x0417 }
            r3.append(r1)     // Catch:{ all -> 0x0417 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0417 }
            r2.<init>(r1)     // Catch:{ all -> 0x0417 }
            throw r2     // Catch:{ all -> 0x0417 }
        L_0x04fb:
            if (r4 == 0) goto L_0x0503
            boolean r6 = r4.equals(r10)     // Catch:{ all -> 0x0417 }
            if (r6 != 0) goto L_0x0507
        L_0x0503:
            java.lang.String r6 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x05a5 }
            if (r6 != r10) goto L_0x05a0
        L_0x0507:
            r1 = 4
            r12.nextTokenWithColon(r1)     // Catch:{ all -> 0x05a5 }
            int r2 = r12.token()     // Catch:{ all -> 0x05a5 }
            if (r2 != r1) goto L_0x0596
            java.lang.String r1 = r12.stringVal()     // Catch:{ all -> 0x05a5 }
            r2 = 16
            r12.nextToken(r2)     // Catch:{ all -> 0x05a5 }
            com.alibaba.fastjson.util.JavaBeanInfo r2 = r8.beanInfo     // Catch:{ all -> 0x05a5 }
            java.lang.String r2 = r2.typeName     // Catch:{ all -> 0x05a5 }
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x05a5 }
            if (r2 != 0) goto L_0x0568
            com.alibaba.fastjson.parser.Feature r2 = com.alibaba.fastjson.parser.Feature.IgnoreAutoType     // Catch:{ all -> 0x05a5 }
            boolean r2 = r9.isEnabled(r2)     // Catch:{ all -> 0x05a5 }
            if (r2 == 0) goto L_0x052d
            goto L_0x0568
        L_0x052d:
            com.alibaba.fastjson.util.JavaBeanInfo r2 = r8.beanInfo     // Catch:{ all -> 0x05a5 }
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r2 = r8.getSeeAlso(r13, r2, r1)     // Catch:{ all -> 0x05a5 }
            if (r2 != 0) goto L_0x054a
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.getClass(r35)     // Catch:{ all -> 0x0417 }
            int r3 = r12.getFeatures()     // Catch:{ all -> 0x0417 }
            java.lang.Class r15 = r13.checkAutoType(r1, r2, r3)     // Catch:{ all -> 0x0417 }
            com.alibaba.fastjson.parser.ParserConfig r2 = r34.getConfig()     // Catch:{ all -> 0x0417 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r2 = r2.getDeserializer((java.lang.reflect.Type) r15)     // Catch:{ all -> 0x0417 }
            goto L_0x054b
        L_0x054a:
            r15 = 0
        L_0x054b:
            java.lang.Object r3 = r2.deserialze(r9, r15, r11)     // Catch:{ all -> 0x05a5 }
            boolean r6 = r2 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer     // Catch:{ all -> 0x05a5 }
            if (r6 == 0) goto L_0x055e
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r2 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r2     // Catch:{ all -> 0x0417 }
            if (r4 == 0) goto L_0x055e
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r2 = r2.getFieldDeserializer((java.lang.String) r4)     // Catch:{ all -> 0x0417 }
            r2.setValue((java.lang.Object) r3, (java.lang.String) r1)     // Catch:{ all -> 0x0417 }
        L_0x055e:
            if (r5 == 0) goto L_0x0564
            r6 = r27
            r5.object = r6
        L_0x0564:
            r9.setContext(r7)
            return r3
        L_0x0568:
            r6 = r27
            int r1 = r12.token()     // Catch:{ all -> 0x05e6 }
            r15 = 13
            if (r1 != r15) goto L_0x057e
            r12.nextToken()     // Catch:{ all -> 0x05e6 }
        L_0x0575:
            r15 = r6
            r31 = r7
            r1 = r19
            r37 = 0
            goto L_0x06c9
        L_0x057e:
            r17 = r37
            r10 = r4
            r27 = r6
            r3 = r7
            r14 = r15
            r16 = r19
            r15 = r21
            r1 = 0
            r2 = 16
            r4 = 0
            r6 = 1
        L_0x058e:
            r18 = 4
            r20 = 5
            r19 = r39
            goto L_0x0967
        L_0x0596:
            r6 = r27
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05e6 }
            java.lang.String r2 = "syntax error"
            r1.<init>(r2)     // Catch:{ all -> 0x05e6 }
            throw r1     // Catch:{ all -> 0x05e6 }
        L_0x05a0:
            r6 = r27
            r15 = 13
            goto L_0x05b6
        L_0x05a5:
            r0 = move-exception
            r6 = r27
        L_0x05a8:
            r1 = r0
            r15 = r6
            r3 = r7
            goto L_0x09b9
        L_0x05ad:
            r29 = r6
            r21 = r15
            r6 = r27
            r15 = 13
            r10 = 0
        L_0x05b6:
            if (r6 != 0) goto L_0x05e8
            if (r19 != 0) goto L_0x05e8
            java.lang.Object r6 = r33.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r34, (java.lang.reflect.Type) r35)     // Catch:{ all -> 0x05e6 }
            if (r6 != 0) goto L_0x05cd
            java.util.HashMap r15 = new java.util.HashMap     // Catch:{ all -> 0x05e6 }
            r27 = r4
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r4 = r8.fieldDeserializers     // Catch:{ all -> 0x05e6 }
            int r4 = r4.length     // Catch:{ all -> 0x05e6 }
            r15.<init>(r4)     // Catch:{ all -> 0x05e6 }
            r19 = r15
            goto L_0x05cf
        L_0x05cd:
            r27 = r4
        L_0x05cf:
            com.alibaba.fastjson.parser.ParseContext r5 = r9.setContext(r7, r6, r11)     // Catch:{ all -> 0x05e6 }
            if (r39 != 0) goto L_0x05ea
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r4 = r8.fieldDeserializers     // Catch:{ all -> 0x05e6 }
            int r4 = r4.length     // Catch:{ all -> 0x05e6 }
            int r4 = r4 / 32
            r15 = 1
            int r4 = r4 + r15
            int[] r4 = new int[r4]     // Catch:{ all -> 0x05e6 }
            r30 = r5
            r15 = r6
            r6 = r19
            r19 = r4
            goto L_0x05f1
        L_0x05e6:
            r0 = move-exception
            goto L_0x05a8
        L_0x05e8:
            r27 = r4
        L_0x05ea:
            r30 = r5
            r15 = r6
            r6 = r19
            r19 = r39
        L_0x05f1:
            if (r3 == 0) goto L_0x0668
            if (r1 != 0) goto L_0x0611
            r5 = r35
            r14.parseField(r9, r15, r5, r6)     // Catch:{ all -> 0x060c }
            r17 = r37
            r16 = r6
            r31 = r7
            r10 = r27
            r37 = 0
            r14 = 13
            r18 = 4
        L_0x0608:
            r20 = 5
            goto L_0x06af
        L_0x060c:
            r0 = move-exception
            r1 = r0
            r3 = r7
            goto L_0x09a9
        L_0x0611:
            r5 = r35
            r1 = r28
            if (r15 != 0) goto L_0x061d
            java.lang.String r1 = r1.name     // Catch:{ all -> 0x060c }
            r6.put(r1, r2)     // Catch:{ all -> 0x060c }
            goto L_0x063c
        L_0x061d:
            if (r2 != 0) goto L_0x0639
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ all -> 0x060c }
            r3 = r29
            if (r3 == r1) goto L_0x063c
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x060c }
            if (r3 == r1) goto L_0x063c
            java.lang.Class r1 = java.lang.Float.TYPE     // Catch:{ all -> 0x060c }
            if (r3 == r1) goto L_0x063c
            java.lang.Class r1 = java.lang.Double.TYPE     // Catch:{ all -> 0x060c }
            if (r3 == r1) goto L_0x063c
            java.lang.Class r1 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x060c }
            if (r3 == r1) goto L_0x063c
            r14.setValue((java.lang.Object) r15, (java.lang.Object) r2)     // Catch:{ all -> 0x060c }
            goto L_0x063c
        L_0x0639:
            r14.setValue((java.lang.Object) r15, (java.lang.Object) r2)     // Catch:{ all -> 0x060c }
        L_0x063c:
            if (r19 == 0) goto L_0x064b
            int r3 = r37 / 32
            int r1 = r37 % 32
            r2 = r19[r3]     // Catch:{ all -> 0x060c }
            r4 = 1
            int r1 = r4 << r1
            r1 = r1 | r2
            r19[r3] = r1     // Catch:{ all -> 0x060c }
            goto L_0x064c
        L_0x064b:
            r4 = 1
        L_0x064c:
            int r1 = r12.matchStat     // Catch:{ all -> 0x060c }
            r14 = 4
            if (r1 != r14) goto L_0x0659
            r16 = r6
            r31 = r7
            r37 = 0
            goto L_0x06c5
        L_0x0659:
            r17 = r37
            r16 = r6
            r31 = r7
            r18 = r14
            r10 = r27
            r37 = 0
            r14 = 13
            goto L_0x0608
        L_0x0668:
            r5 = r35
            r4 = 1
            r14 = 4
            r1 = r33
            r2 = r34
            r17 = r37
            r3 = r10
            r14 = r4
            r10 = r27
            r4 = r15
            r37 = 0
            r18 = 4
            r16 = r6
            r14 = 13
            r20 = 5
            r31 = r7
            r7 = r19
            boolean r1 = r1.parseField(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x09a5 }
            if (r1 != 0) goto L_0x06a7
            int r1 = r12.token()     // Catch:{ all -> 0x069f }
            if (r1 != r14) goto L_0x0695
            r12.nextToken()     // Catch:{ all -> 0x069f }
            goto L_0x06c5
        L_0x0695:
            r1 = r37
            r3 = r31
            r2 = 16
        L_0x069b:
            r4 = 0
            r6 = 1
            goto L_0x0961
        L_0x069f:
            r0 = move-exception
            r1 = r0
            r5 = r30
            r3 = r31
            goto L_0x09b9
        L_0x06a7:
            int r1 = r12.token()     // Catch:{ all -> 0x09a5 }
            r2 = 17
            if (r1 == r2) goto L_0x0999
        L_0x06af:
            int r1 = r12.token()     // Catch:{ all -> 0x09a5 }
            r2 = 16
            if (r1 != r2) goto L_0x06bc
            r1 = r37
            r3 = r31
            goto L_0x069b
        L_0x06bc:
            int r1 = r12.token()     // Catch:{ all -> 0x09a5 }
            if (r1 != r14) goto L_0x094d
            r12.nextToken(r2)     // Catch:{ all -> 0x09a5 }
        L_0x06c5:
            r1 = r16
            r5 = r30
        L_0x06c9:
            if (r15 != 0) goto L_0x0921
            if (r1 != 0) goto L_0x06ed
            java.lang.Object r1 = r33.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r34, (java.lang.reflect.Type) r35)     // Catch:{ all -> 0x06e8 }
            if (r5 != 0) goto L_0x06de
            r3 = r31
            com.alibaba.fastjson.parser.ParseContext r5 = r9.setContext(r3, r1, r11)     // Catch:{ all -> 0x06da }
            goto L_0x06e0
        L_0x06da:
            r0 = move-exception
            r15 = r1
            goto L_0x01b9
        L_0x06de:
            r3 = r31
        L_0x06e0:
            if (r5 == 0) goto L_0x06e4
            r5.object = r1
        L_0x06e4:
            r9.setContext(r3)
            return r1
        L_0x06e8:
            r0 = move-exception
            r3 = r31
            goto L_0x01b9
        L_0x06ed:
            r3 = r31
            com.alibaba.fastjson.util.JavaBeanInfo r2 = r8.beanInfo     // Catch:{ all -> 0x094a }
            java.lang.String[] r2 = r2.creatorConstructorParameters     // Catch:{ all -> 0x094a }
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x07a6
            int r6 = r2.length     // Catch:{ all -> 0x094a }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x094a }
            r7 = r37
        L_0x06fc:
            int r10 = r2.length     // Catch:{ all -> 0x094a }
            if (r7 >= r10) goto L_0x081b
            r10 = r2[r7]     // Catch:{ all -> 0x094a }
            java.lang.Object r10 = r1.remove(r10)     // Catch:{ all -> 0x094a }
            if (r10 != 0) goto L_0x0761
            com.alibaba.fastjson.util.JavaBeanInfo r11 = r8.beanInfo     // Catch:{ all -> 0x094a }
            java.lang.reflect.Type[] r11 = r11.creatorConstructorParameterTypes     // Catch:{ all -> 0x094a }
            r11 = r11[r7]     // Catch:{ all -> 0x094a }
            com.alibaba.fastjson.util.JavaBeanInfo r12 = r8.beanInfo     // Catch:{ all -> 0x094a }
            com.alibaba.fastjson.util.FieldInfo[] r12 = r12.fields     // Catch:{ all -> 0x094a }
            r12 = r12[r7]     // Catch:{ all -> 0x094a }
            java.lang.Class r13 = java.lang.Byte.TYPE     // Catch:{ all -> 0x094a }
            if (r11 != r13) goto L_0x071c
            java.lang.Byte r10 = java.lang.Byte.valueOf(r37)     // Catch:{ all -> 0x094a }
            goto L_0x075e
        L_0x071c:
            java.lang.Class r13 = java.lang.Short.TYPE     // Catch:{ all -> 0x094a }
            if (r11 != r13) goto L_0x0725
            java.lang.Short r10 = java.lang.Short.valueOf(r37)     // Catch:{ all -> 0x094a }
            goto L_0x075e
        L_0x0725:
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ all -> 0x094a }
            if (r11 != r13) goto L_0x072e
            java.lang.Integer r10 = java.lang.Integer.valueOf(r37)     // Catch:{ all -> 0x094a }
            goto L_0x075e
        L_0x072e:
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x094a }
            if (r11 != r13) goto L_0x0737
            java.lang.Long r10 = java.lang.Long.valueOf(r25)     // Catch:{ all -> 0x094a }
            goto L_0x075e
        L_0x0737:
            java.lang.Class r13 = java.lang.Float.TYPE     // Catch:{ all -> 0x094a }
            if (r11 != r13) goto L_0x0740
            java.lang.Float r10 = java.lang.Float.valueOf(r24)     // Catch:{ all -> 0x094a }
            goto L_0x075e
        L_0x0740:
            java.lang.Class r13 = java.lang.Double.TYPE     // Catch:{ all -> 0x094a }
            if (r11 != r13) goto L_0x0749
            java.lang.Double r10 = java.lang.Double.valueOf(r22)     // Catch:{ all -> 0x094a }
            goto L_0x075e
        L_0x0749:
            java.lang.Class r13 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x094a }
            if (r11 != r13) goto L_0x0750
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x094a }
            goto L_0x075e
        L_0x0750:
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            if (r11 != r13) goto L_0x075e
            int r11 = r12.parserFeatures     // Catch:{ all -> 0x094a }
            com.alibaba.fastjson.parser.Feature r12 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty     // Catch:{ all -> 0x094a }
            int r12 = r12.mask     // Catch:{ all -> 0x094a }
            r11 = r11 & r12
            if (r11 == 0) goto L_0x075e
            r10 = r4
        L_0x075e:
            r13 = r37
            goto L_0x079e
        L_0x0761:
            com.alibaba.fastjson.util.JavaBeanInfo r11 = r8.beanInfo     // Catch:{ all -> 0x094a }
            java.lang.reflect.Type[] r11 = r11.creatorConstructorParameterTypes     // Catch:{ all -> 0x094a }
            if (r11 == 0) goto L_0x075e
            com.alibaba.fastjson.util.JavaBeanInfo r11 = r8.beanInfo     // Catch:{ all -> 0x094a }
            java.lang.reflect.Type[] r11 = r11.creatorConstructorParameterTypes     // Catch:{ all -> 0x094a }
            int r11 = r11.length     // Catch:{ all -> 0x094a }
            if (r7 >= r11) goto L_0x075e
            com.alibaba.fastjson.util.JavaBeanInfo r11 = r8.beanInfo     // Catch:{ all -> 0x094a }
            java.lang.reflect.Type[] r11 = r11.creatorConstructorParameterTypes     // Catch:{ all -> 0x094a }
            r11 = r11[r7]     // Catch:{ all -> 0x094a }
            boolean r12 = r11 instanceof java.lang.Class     // Catch:{ all -> 0x094a }
            if (r12 == 0) goto L_0x075e
            java.lang.Class r11 = (java.lang.Class) r11     // Catch:{ all -> 0x094a }
            boolean r12 = r11.isInstance(r10)     // Catch:{ all -> 0x094a }
            if (r12 != 0) goto L_0x075e
            boolean r12 = r10 instanceof java.util.List     // Catch:{ all -> 0x094a }
            if (r12 == 0) goto L_0x075e
            r12 = r10
            java.util.List r12 = (java.util.List) r12     // Catch:{ all -> 0x094a }
            int r13 = r12.size()     // Catch:{ all -> 0x094a }
            r14 = 1
            if (r13 != r14) goto L_0x075e
            r13 = r37
            java.lang.Object r14 = r12.get(r13)     // Catch:{ all -> 0x094a }
            boolean r11 = r11.isInstance(r14)     // Catch:{ all -> 0x094a }
            if (r11 == 0) goto L_0x079e
            java.lang.Object r10 = r12.get(r13)     // Catch:{ all -> 0x094a }
        L_0x079e:
            r6[r7] = r10     // Catch:{ all -> 0x094a }
            int r7 = r7 + 1
            r37 = r13
            goto L_0x06fc
        L_0x07a6:
            r13 = r37
            com.alibaba.fastjson.util.JavaBeanInfo r6 = r8.beanInfo     // Catch:{ all -> 0x094a }
            com.alibaba.fastjson.util.FieldInfo[] r6 = r6.fields     // Catch:{ all -> 0x094a }
            int r7 = r6.length     // Catch:{ all -> 0x094a }
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ all -> 0x094a }
            r11 = r13
        L_0x07b0:
            if (r11 >= r7) goto L_0x081a
            r12 = r6[r11]     // Catch:{ all -> 0x094a }
            java.lang.String r14 = r12.name     // Catch:{ all -> 0x094a }
            java.lang.Object r14 = r1.get(r14)     // Catch:{ all -> 0x094a }
            if (r14 != 0) goto L_0x0810
            java.lang.reflect.Type r13 = r12.fieldType     // Catch:{ all -> 0x094a }
            r35 = r4
            java.lang.Class r4 = java.lang.Byte.TYPE     // Catch:{ all -> 0x094a }
            if (r13 != r4) goto L_0x07ca
            r4 = 0
            java.lang.Byte r14 = java.lang.Byte.valueOf(r4)     // Catch:{ all -> 0x094a }
            goto L_0x0812
        L_0x07ca:
            java.lang.Class r4 = java.lang.Short.TYPE     // Catch:{ all -> 0x094a }
            if (r13 != r4) goto L_0x07d4
            r4 = 0
            java.lang.Short r14 = java.lang.Short.valueOf(r4)     // Catch:{ all -> 0x094a }
            goto L_0x0812
        L_0x07d4:
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ all -> 0x094a }
            if (r13 != r4) goto L_0x07de
            r4 = 0
            java.lang.Integer r14 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x094a }
            goto L_0x0812
        L_0x07de:
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ all -> 0x094a }
            if (r13 != r4) goto L_0x07e7
            java.lang.Long r14 = java.lang.Long.valueOf(r25)     // Catch:{ all -> 0x094a }
            goto L_0x0812
        L_0x07e7:
            java.lang.Class r4 = java.lang.Float.TYPE     // Catch:{ all -> 0x094a }
            if (r13 != r4) goto L_0x07f0
            java.lang.Float r14 = java.lang.Float.valueOf(r24)     // Catch:{ all -> 0x094a }
            goto L_0x0812
        L_0x07f0:
            java.lang.Class r4 = java.lang.Double.TYPE     // Catch:{ all -> 0x094a }
            if (r13 != r4) goto L_0x07f9
            java.lang.Double r14 = java.lang.Double.valueOf(r22)     // Catch:{ all -> 0x094a }
            goto L_0x0812
        L_0x07f9:
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x094a }
            if (r13 != r4) goto L_0x0800
            java.lang.Boolean r14 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x094a }
            goto L_0x0812
        L_0x0800:
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            if (r13 != r4) goto L_0x0812
            int r4 = r12.parserFeatures     // Catch:{ all -> 0x094a }
            com.alibaba.fastjson.parser.Feature r12 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty     // Catch:{ all -> 0x094a }
            int r12 = r12.mask     // Catch:{ all -> 0x094a }
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0812
            r14 = r35
            goto L_0x0812
        L_0x0810:
            r35 = r4
        L_0x0812:
            r10[r11] = r14     // Catch:{ all -> 0x094a }
            int r11 = r11 + 1
            r4 = r35
            r13 = 0
            goto L_0x07b0
        L_0x081a:
            r6 = r10
        L_0x081b:
            com.alibaba.fastjson.util.JavaBeanInfo r4 = r8.beanInfo     // Catch:{ all -> 0x094a }
            java.lang.reflect.Constructor<?> r4 = r4.creatorConstructor     // Catch:{ all -> 0x094a }
            if (r4 == 0) goto L_0x08ea
            com.alibaba.fastjson.util.JavaBeanInfo r4 = r8.beanInfo     // Catch:{ all -> 0x094a }
            boolean r4 = r4.kotlin     // Catch:{ all -> 0x094a }
            if (r4 == 0) goto L_0x084e
            r4 = 0
        L_0x0828:
            int r7 = r6.length     // Catch:{ all -> 0x094a }
            if (r4 >= r7) goto L_0x084e
            r7 = r6[r4]     // Catch:{ all -> 0x094a }
            if (r7 != 0) goto L_0x084b
            com.alibaba.fastjson.util.JavaBeanInfo r7 = r8.beanInfo     // Catch:{ all -> 0x094a }
            com.alibaba.fastjson.util.FieldInfo[] r7 = r7.fields     // Catch:{ all -> 0x094a }
            if (r7 == 0) goto L_0x084b
            com.alibaba.fastjson.util.JavaBeanInfo r7 = r8.beanInfo     // Catch:{ all -> 0x094a }
            com.alibaba.fastjson.util.FieldInfo[] r7 = r7.fields     // Catch:{ all -> 0x094a }
            int r7 = r7.length     // Catch:{ all -> 0x094a }
            if (r4 >= r7) goto L_0x084b
            com.alibaba.fastjson.util.JavaBeanInfo r7 = r8.beanInfo     // Catch:{ all -> 0x094a }
            com.alibaba.fastjson.util.FieldInfo[] r7 = r7.fields     // Catch:{ all -> 0x094a }
            r4 = r7[r4]     // Catch:{ all -> 0x094a }
            java.lang.Class<?> r4 = r4.fieldClass     // Catch:{ all -> 0x094a }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            if (r4 != r7) goto L_0x084e
            r27 = 1
            goto L_0x0850
        L_0x084b:
            int r4 = r4 + 1
            goto L_0x0828
        L_0x084e:
            r27 = 0
        L_0x0850:
            if (r27 == 0) goto L_0x0887
            com.alibaba.fastjson.util.JavaBeanInfo r4 = r8.beanInfo     // Catch:{ Exception -> 0x08bb }
            java.lang.reflect.Constructor<?> r4 = r4.kotlinDefaultConstructor     // Catch:{ Exception -> 0x08bb }
            if (r4 == 0) goto L_0x0887
            com.alibaba.fastjson.util.JavaBeanInfo r4 = r8.beanInfo     // Catch:{ Exception -> 0x08bb }
            java.lang.reflect.Constructor<?> r4 = r4.kotlinDefaultConstructor     // Catch:{ Exception -> 0x08bb }
            r7 = 0
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x08bb }
            java.lang.Object r4 = r4.newInstance(r10)     // Catch:{ Exception -> 0x08bb }
            r7 = 0
        L_0x0864:
            int r10 = r6.length     // Catch:{ Exception -> 0x0884 }
            if (r7 >= r10) goto L_0x088f
            r10 = r6[r7]     // Catch:{ Exception -> 0x0884 }
            if (r10 == 0) goto L_0x0881
            com.alibaba.fastjson.util.JavaBeanInfo r11 = r8.beanInfo     // Catch:{ Exception -> 0x0884 }
            com.alibaba.fastjson.util.FieldInfo[] r11 = r11.fields     // Catch:{ Exception -> 0x0884 }
            if (r11 == 0) goto L_0x0881
            com.alibaba.fastjson.util.JavaBeanInfo r11 = r8.beanInfo     // Catch:{ Exception -> 0x0884 }
            com.alibaba.fastjson.util.FieldInfo[] r11 = r11.fields     // Catch:{ Exception -> 0x0884 }
            int r11 = r11.length     // Catch:{ Exception -> 0x0884 }
            if (r7 >= r11) goto L_0x0881
            com.alibaba.fastjson.util.JavaBeanInfo r11 = r8.beanInfo     // Catch:{ Exception -> 0x0884 }
            com.alibaba.fastjson.util.FieldInfo[] r11 = r11.fields     // Catch:{ Exception -> 0x0884 }
            r11 = r11[r7]     // Catch:{ Exception -> 0x0884 }
            r11.set(r4, r10)     // Catch:{ Exception -> 0x0884 }
        L_0x0881:
            int r7 = r7 + 1
            goto L_0x0864
        L_0x0884:
            r0 = move-exception
            r1 = r0
            goto L_0x08be
        L_0x0887:
            com.alibaba.fastjson.util.JavaBeanInfo r4 = r8.beanInfo     // Catch:{ Exception -> 0x08bb }
            java.lang.reflect.Constructor<?> r4 = r4.creatorConstructor     // Catch:{ Exception -> 0x08bb }
            java.lang.Object r4 = r4.newInstance(r6)     // Catch:{ Exception -> 0x08bb }
        L_0x088f:
            if (r2 == 0) goto L_0x08b9
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x08e5 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x08e5 }
        L_0x0899:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x08e5 }
            if (r2 == 0) goto L_0x08b9
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x08e5 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x08e5 }
            java.lang.Object r6 = r2.getKey()     // Catch:{ all -> 0x08e5 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x08e5 }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r6 = r8.getFieldDeserializer((java.lang.String) r6)     // Catch:{ all -> 0x08e5 }
            if (r6 == 0) goto L_0x0899
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x08e5 }
            r6.setValue((java.lang.Object) r4, (java.lang.Object) r2)     // Catch:{ all -> 0x08e5 }
            goto L_0x0899
        L_0x08b9:
            r15 = r4
            goto L_0x091c
        L_0x08bb:
            r0 = move-exception
            r1 = r0
            r4 = r15
        L_0x08be:
            com.alibaba.fastjson.JSONException r6 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x08e5 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x08e5 }
            r7.<init>()     // Catch:{ all -> 0x08e5 }
            java.lang.String r10 = "create instance error, "
            r7.append(r10)     // Catch:{ all -> 0x08e5 }
            r7.append(r2)     // Catch:{ all -> 0x08e5 }
            java.lang.String r2 = ", "
            r7.append(r2)     // Catch:{ all -> 0x08e5 }
            com.alibaba.fastjson.util.JavaBeanInfo r2 = r8.beanInfo     // Catch:{ all -> 0x08e5 }
            java.lang.reflect.Constructor<?> r2 = r2.creatorConstructor     // Catch:{ all -> 0x08e5 }
            java.lang.String r2 = r2.toGenericString()     // Catch:{ all -> 0x08e5 }
            r7.append(r2)     // Catch:{ all -> 0x08e5 }
            java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x08e5 }
            r6.<init>(r2, r1)     // Catch:{ all -> 0x08e5 }
            throw r6     // Catch:{ all -> 0x08e5 }
        L_0x08e5:
            r0 = move-exception
            r1 = r0
            r15 = r4
            goto L_0x09b9
        L_0x08ea:
            com.alibaba.fastjson.util.JavaBeanInfo r1 = r8.beanInfo     // Catch:{ all -> 0x094a }
            java.lang.reflect.Method r1 = r1.factoryMethod     // Catch:{ all -> 0x094a }
            if (r1 == 0) goto L_0x091c
            com.alibaba.fastjson.util.JavaBeanInfo r1 = r8.beanInfo     // Catch:{ Exception -> 0x08fb }
            java.lang.reflect.Method r1 = r1.factoryMethod     // Catch:{ Exception -> 0x08fb }
            r4 = 0
            java.lang.Object r1 = r1.invoke(r4, r6)     // Catch:{ Exception -> 0x08fb }
            r15 = r1
            goto L_0x091c
        L_0x08fb:
            r0 = move-exception
            r1 = r0
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x094a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x094a }
            r4.<init>()     // Catch:{ all -> 0x094a }
            java.lang.String r6 = "create factory method error, "
            r4.append(r6)     // Catch:{ all -> 0x094a }
            com.alibaba.fastjson.util.JavaBeanInfo r6 = r8.beanInfo     // Catch:{ all -> 0x094a }
            java.lang.reflect.Method r6 = r6.factoryMethod     // Catch:{ all -> 0x094a }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x094a }
            r4.append(r6)     // Catch:{ all -> 0x094a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x094a }
            r2.<init>(r4, r1)     // Catch:{ all -> 0x094a }
            throw r2     // Catch:{ all -> 0x094a }
        L_0x091c:
            if (r5 == 0) goto L_0x0923
            r5.object = r15     // Catch:{ all -> 0x094a }
            goto L_0x0923
        L_0x0921:
            r3 = r31
        L_0x0923:
            com.alibaba.fastjson.util.JavaBeanInfo r1 = r8.beanInfo     // Catch:{ all -> 0x094a }
            java.lang.reflect.Method r1 = r1.buildMethod     // Catch:{ all -> 0x094a }
            if (r1 != 0) goto L_0x0931
            if (r5 == 0) goto L_0x092d
            r5.object = r15
        L_0x092d:
            r9.setContext(r3)
            return r15
        L_0x0931:
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0940 }
            java.lang.Object r1 = r1.invoke(r15, r2)     // Catch:{ Exception -> 0x0940 }
            if (r5 == 0) goto L_0x093c
            r5.object = r15
        L_0x093c:
            r9.setContext(r3)
            return r1
        L_0x0940:
            r0 = move-exception
            r1 = r0
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x094a }
            java.lang.String r4 = "build object error"
            r2.<init>(r4, r1)     // Catch:{ all -> 0x094a }
            throw r2     // Catch:{ all -> 0x094a }
        L_0x094a:
            r0 = move-exception
            goto L_0x01b9
        L_0x094d:
            r1 = r37
            r3 = r31
            r4 = 0
            int r5 = r12.token()     // Catch:{ all -> 0x09a3 }
            r6 = 18
            if (r5 == r6) goto L_0x097a
            int r5 = r12.token()     // Catch:{ all -> 0x09a3 }
            r6 = 1
            if (r5 == r6) goto L_0x097a
        L_0x0961:
            r27 = r15
            r15 = r21
            r5 = r30
        L_0x0967:
            int r7 = r17 + 1
            r14 = r2
            r4 = r10
            r2 = r19
            r1 = r27
            r10 = r35
            r19 = r16
            r32 = r7
            r7 = r3
            r3 = r32
            goto L_0x018a
        L_0x097a:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x09a3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x09a3 }
            r2.<init>()     // Catch:{ all -> 0x09a3 }
            java.lang.String r4 = "syntax error, unexpect token "
            r2.append(r4)     // Catch:{ all -> 0x09a3 }
            int r4 = r12.token()     // Catch:{ all -> 0x09a3 }
            java.lang.String r4 = com.alibaba.fastjson.parser.JSONToken.name(r4)     // Catch:{ all -> 0x09a3 }
            r2.append(r4)     // Catch:{ all -> 0x09a3 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x09a3 }
            r1.<init>(r2)     // Catch:{ all -> 0x09a3 }
            throw r1     // Catch:{ all -> 0x09a3 }
        L_0x0999:
            r3 = r31
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x09a3 }
            java.lang.String r2 = "syntax error, unexpect token ':'"
            r1.<init>(r2)     // Catch:{ all -> 0x09a3 }
            throw r1     // Catch:{ all -> 0x09a3 }
        L_0x09a3:
            r0 = move-exception
            goto L_0x09a8
        L_0x09a5:
            r0 = move-exception
            r3 = r31
        L_0x09a8:
            r1 = r0
        L_0x09a9:
            r5 = r30
            goto L_0x09b9
        L_0x09ac:
            r0 = move-exception
            r6 = r1
            r3 = r7
            r1 = r0
            r15 = r6
            goto L_0x09b9
        L_0x09b2:
            r0 = move-exception
            r3 = r7
            r4 = r15
            r15 = r37
            r1 = r0
            r5 = r4
        L_0x09b9:
            if (r5 == 0) goto L_0x09bd
            r5.object = r15
        L_0x09bd:
            r9.setContext(r3)
            throw r1
        L_0x09c1:
            java.lang.Object r1 = r34.parse()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
        EnumDeserializer enumDeserializer = objectDeserializer instanceof EnumDeserializer ? (EnumDeserializer) objectDeserializer : null;
        if (enumDeserializer == null) {
            jSONLexerBase.matchStat = -1;
            return null;
        }
        long scanEnumSymbol = jSONLexerBase.scanEnumSymbol(cArr);
        if (jSONLexerBase.matchStat <= 0) {
            return null;
        }
        Enum enumByHashCode = enumDeserializer.getEnumByHashCode(scanEnumSymbol);
        if (enumByHashCode == null) {
            if (scanEnumSymbol == -3750763034362895579L) {
                return null;
            }
            if (jSONLexerBase.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                throw new JSONException("not match enum value, " + enumDeserializer.enumClass);
            }
        }
        return enumByHashCode;
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        return parseField(defaultJSONParser, str, obj, type, map, (int[]) null);
    }

    /* JADX WARNING: type inference failed for: r17v0, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r17v1 */
    /* JADX WARNING: type inference failed for: r17v2 */
    /* JADX WARNING: type inference failed for: r17v4 */
    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        ? r17;
        JSONLexer jSONLexer;
        DefaultJSONParser defaultJSONParser2 = defaultJSONParser;
        String str2 = str;
        Object obj2 = obj;
        Type type2 = type;
        Map<String, Object> map2 = map;
        int[] iArr2 = iArr;
        JSONLexer jSONLexer2 = defaultJSONParser2.lexer;
        int i = Feature.DisableFieldSmartMatch.mask;
        if (jSONLexer2.isEnabled(i) || (i & this.beanInfo.parserFeatures) != 0) {
            fieldDeserializer = getFieldDeserializer(str2);
        } else {
            fieldDeserializer = smartMatch(str2, iArr2);
        }
        int i2 = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer != null || (!jSONLexer2.isEnabled(i2) && (i2 & this.beanInfo.parserFeatures) == 0)) {
            r17 = 1;
            jSONLexer = jSONLexer2;
        } else {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                Class cls = this.clazz;
                while (cls != null && cls != Object.class) {
                    for (Field field : cls.getDeclaredFields()) {
                        String name = field.getName();
                        if (getFieldDeserializer(name) == null) {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                concurrentHashMap.put(name, field);
                            }
                        }
                    }
                    cls = cls.getSuperclass();
                }
                this.extraFieldDeserializers = concurrentHashMap;
            }
            Object obj3 = this.extraFieldDeserializers.get(str2);
            if (obj3 != null) {
                if (obj3 instanceof FieldDeserializer) {
                    fieldDeserializer = (FieldDeserializer) obj3;
                } else {
                    Field field2 = (Field) obj3;
                    field2.setAccessible(true);
                    FieldInfo fieldInfo = r2;
                    r17 = 1;
                    jSONLexer = jSONLexer2;
                    FieldInfo fieldInfo2 = new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0, 0);
                    fieldDeserializer = new DefaultFieldDeserializer(defaultJSONParser.getConfig(), this.clazz, fieldInfo);
                    this.extraFieldDeserializers.put(str2, fieldDeserializer);
                }
            }
            jSONLexer = jSONLexer2;
            r17 = 1;
        }
        if (fieldDeserializer != null) {
            int[] iArr3 = iArr;
            JSONLexer jSONLexer3 = jSONLexer;
            int i3 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i3 >= fieldDeserializerArr.length) {
                    i3 = -1;
                    break;
                } else if (fieldDeserializerArr[i3] == fieldDeserializer) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1 || iArr3 == null || !str2.startsWith("_") || !isSetFlag(i3, iArr3)) {
                jSONLexer3.nextTokenWithColon(fieldDeserializer.getFastMatchToken());
                fieldDeserializer.parseField(defaultJSONParser2, obj2, type2, map2);
                if (iArr3 != null) {
                    int i4 = i3 / 32;
                    iArr3[i4] = iArr3[i4] | (r17 << (i3 % 32));
                }
                return r17;
            }
            defaultJSONParser2.parseExtra(obj2, str2);
            return false;
        } else if (jSONLexer.isEnabled(Feature.IgnoreNotMatch)) {
            int i5 = -1;
            int i6 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                if (i6 >= fieldDeserializerArr2.length) {
                    break;
                }
                FieldDeserializer fieldDeserializer2 = fieldDeserializerArr2[i6];
                FieldInfo fieldInfo3 = fieldDeserializer2.fieldInfo;
                if (fieldInfo3.unwrapped && (fieldDeserializer2 instanceof DefaultFieldDeserializer)) {
                    if (fieldInfo3.field != null) {
                        DefaultFieldDeserializer defaultFieldDeserializer = (DefaultFieldDeserializer) fieldDeserializer2;
                        ObjectDeserializer fieldValueDeserilizer = defaultFieldDeserializer.getFieldValueDeserilizer(defaultJSONParser.getConfig());
                        if (fieldValueDeserilizer instanceof JavaBeanDeserializer) {
                            FieldDeserializer fieldDeserializer3 = ((JavaBeanDeserializer) fieldValueDeserilizer).getFieldDeserializer(str2);
                            if (fieldDeserializer3 != null) {
                                try {
                                    Object obj4 = fieldInfo3.field.get(obj2);
                                    if (obj4 == null) {
                                        obj4 = ((JavaBeanDeserializer) fieldValueDeserilizer).createInstance(defaultJSONParser2, fieldInfo3.fieldType);
                                        fieldDeserializer2.setValue(obj2, obj4);
                                    }
                                    jSONLexer.nextTokenWithColon(defaultFieldDeserializer.getFastMatchToken());
                                    fieldDeserializer3.parseField(defaultJSONParser2, obj4, type2, map2);
                                } catch (Exception e) {
                                    throw new JSONException("parse unwrapped field error.", e);
                                }
                            }
                        } else if (fieldValueDeserilizer instanceof MapDeserializer) {
                            MapDeserializer mapDeserializer = (MapDeserializer) fieldValueDeserilizer;
                            try {
                                Map<Object, Object> map3 = (Map) fieldInfo3.field.get(obj2);
                                if (map3 == null) {
                                    map3 = mapDeserializer.createMap(fieldInfo3.fieldType);
                                    fieldDeserializer2.setValue(obj2, (Object) map3);
                                }
                                jSONLexer.nextTokenWithColon();
                                map3.put(str2, defaultJSONParser.parse(str));
                            } catch (Exception e2) {
                                throw new JSONException("parse unwrapped field error.", e2);
                            }
                        }
                    } else if (fieldInfo3.method.getParameterTypes().length == 2) {
                        jSONLexer.nextTokenWithColon();
                        Object parse = defaultJSONParser.parse(str);
                        try {
                            Method method = fieldInfo3.method;
                            Object[] objArr = new Object[2];
                            objArr[0] = str2;
                            objArr[r17] = parse;
                            method.invoke(obj2, objArr);
                        } catch (Exception e3) {
                            throw new JSONException("parse unwrapped field error.", e3);
                        }
                    }
                    i5 = i6;
                }
                i6++;
            }
            if (i5 != -1) {
                int[] iArr4 = iArr;
                if (iArr4 != null) {
                    int i7 = i5 / 32;
                    iArr4[i7] = iArr4[i7] | (r17 << (i5 % 32));
                }
                return r17;
            }
            defaultJSONParser2.parseExtra(obj2, str2);
            return false;
        } else {
            throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str2);
        }
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, (int[]) null);
    }

    public FieldDeserializer smartMatch(String str, int[] iArr) {
        boolean z;
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str, iArr);
        if (fieldDeserializer == null) {
            long fnv1a_64_lower = TypeUtils.fnv1a_64_lower(str);
            int i = 0;
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i2 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i2 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i2] = TypeUtils.fnv1a_64_lower(fieldDeserializerArr[i2].fieldInfo.name);
                    i2++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv1a_64_lower);
            if (binarySearch < 0) {
                z = str.startsWith("is");
                if (z) {
                    binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(str.substring(2)));
                }
            } else {
                z = false;
            }
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    short[] sArr = new short[this.smartMatchHashArray.length];
                    Arrays.fill(sArr, -1);
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(fieldDeserializerArr2[i].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            sArr[binarySearch2] = (short) i;
                        }
                        i++;
                    }
                    this.smartMatchHashArrayMapping = sArr;
                }
                short s = this.smartMatchHashArrayMapping[binarySearch];
                if (s != -1 && !isSetFlag(s, iArr)) {
                    fieldDeserializer = this.sortedFieldDeserializers[s];
                }
            }
            if (fieldDeserializer != null) {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                if ((fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0) {
                    return null;
                }
                Class<?> cls = fieldInfo.fieldClass;
                if (!(!z || cls == Boolean.TYPE || cls == Boolean.class)) {
                    return null;
                }
            }
        }
        return fieldDeserializer;
    }

    private Object createFactoryInstance(ParserConfig parserConfig, Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return this.beanInfo.factoryMethod.invoke((Object) null, new Object[]{obj});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0201, code lost:
        if (r11.beanInfo.fields[r12].fieldClass == java.lang.String.class) goto L_0x0208;
     */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0212 A[SYNTHETIC, Splitter:B:137:0x0212] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x025b A[SYNTHETIC, Splitter:B:152:0x025b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object createInstance(java.util.Map<java.lang.String, java.lang.Object> r12, com.alibaba.fastjson.parser.ParserConfig r13) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r11 = this;
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r11.beanInfo
            java.lang.reflect.Constructor<?> r0 = r0.creatorConstructor
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0124
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r11.beanInfo
            java.lang.reflect.Method r0 = r0.factoryMethod
            if (r0 != 0) goto L_0x0124
            java.lang.Class<?> r0 = r11.clazz
            java.lang.Object r0 = r11.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r1, (java.lang.reflect.Type) r0)
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x001d:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x0109
            java.lang.Object r1 = r12.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r4 = r1.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r1 = r1.getValue()
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r4 = r11.smartMatch(r4)
            if (r4 != 0) goto L_0x003a
            goto L_0x001d
        L_0x003a:
            com.alibaba.fastjson.util.FieldInfo r5 = r4.fieldInfo
            com.alibaba.fastjson.util.FieldInfo r6 = r4.fieldInfo
            java.lang.reflect.Field r6 = r6.field
            java.lang.reflect.Type r7 = r5.fieldType
            if (r6 == 0) goto L_0x00e8
            java.lang.Class r8 = r6.getType()
            java.lang.Class r9 = java.lang.Boolean.TYPE
            if (r8 != r9) goto L_0x005c
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            if (r1 != r8) goto L_0x0054
            r6.setBoolean(r0, r3)
            goto L_0x001d
        L_0x0054:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            if (r1 != r8) goto L_0x00e8
            r6.setBoolean(r0, r2)
            goto L_0x001d
        L_0x005c:
            java.lang.Class r9 = java.lang.Integer.TYPE
            if (r8 != r9) goto L_0x006e
            boolean r8 = r1 instanceof java.lang.Number
            if (r8 == 0) goto L_0x00e8
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r6.setInt(r0, r1)
            goto L_0x001d
        L_0x006e:
            java.lang.Class r9 = java.lang.Long.TYPE
            if (r8 != r9) goto L_0x0080
            boolean r8 = r1 instanceof java.lang.Number
            if (r8 == 0) goto L_0x00e8
            java.lang.Number r1 = (java.lang.Number) r1
            long r4 = r1.longValue()
            r6.setLong(r0, r4)
            goto L_0x001d
        L_0x0080:
            java.lang.Class r9 = java.lang.Float.TYPE
            r10 = 10
            if (r8 != r9) goto L_0x00ae
            boolean r8 = r1 instanceof java.lang.Number
            if (r8 == 0) goto L_0x0094
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            r6.setFloat(r0, r1)
            goto L_0x001d
        L_0x0094:
            boolean r8 = r1 instanceof java.lang.String
            if (r8 == 0) goto L_0x00e8
            java.lang.String r1 = (java.lang.String) r1
            int r4 = r1.length()
            if (r4 > r10) goto L_0x00a5
            float r1 = com.alibaba.fastjson.util.TypeUtils.parseFloat(r1)
            goto L_0x00a9
        L_0x00a5:
            float r1 = java.lang.Float.parseFloat(r1)
        L_0x00a9:
            r6.setFloat(r0, r1)
            goto L_0x001d
        L_0x00ae:
            java.lang.Class r9 = java.lang.Double.TYPE
            if (r8 != r9) goto L_0x00db
            boolean r8 = r1 instanceof java.lang.Number
            if (r8 == 0) goto L_0x00c1
            java.lang.Number r1 = (java.lang.Number) r1
            double r4 = r1.doubleValue()
            r6.setDouble(r0, r4)
            goto L_0x001d
        L_0x00c1:
            boolean r8 = r1 instanceof java.lang.String
            if (r8 == 0) goto L_0x00e8
            java.lang.String r1 = (java.lang.String) r1
            int r4 = r1.length()
            if (r4 > r10) goto L_0x00d2
            double r4 = com.alibaba.fastjson.util.TypeUtils.parseDouble(r1)
            goto L_0x00d6
        L_0x00d2:
            double r4 = java.lang.Double.parseDouble(r1)
        L_0x00d6:
            r6.setDouble(r0, r4)
            goto L_0x001d
        L_0x00db:
            if (r1 == 0) goto L_0x00e8
            java.lang.Class r8 = r1.getClass()
            if (r7 != r8) goto L_0x00e8
            r6.set(r0, r1)
            goto L_0x001d
        L_0x00e8:
            java.lang.String r5 = r5.format
            if (r5 == 0) goto L_0x00f5
            java.lang.Class<java.util.Date> r6 = java.util.Date.class
            if (r7 != r6) goto L_0x00f5
            java.util.Date r1 = com.alibaba.fastjson.util.TypeUtils.castToDate(r1, r5)
            goto L_0x0104
        L_0x00f5:
            boolean r5 = r7 instanceof java.lang.reflect.ParameterizedType
            if (r5 == 0) goto L_0x0100
            java.lang.reflect.ParameterizedType r7 = (java.lang.reflect.ParameterizedType) r7
            java.lang.Object r1 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r1, (java.lang.reflect.ParameterizedType) r7, (com.alibaba.fastjson.parser.ParserConfig) r13)
            goto L_0x0104
        L_0x0100:
            java.lang.Object r1 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r1, (java.lang.reflect.Type) r7, (com.alibaba.fastjson.parser.ParserConfig) r13)
        L_0x0104:
            r4.setValue((java.lang.Object) r0, (java.lang.Object) r1)
            goto L_0x001d
        L_0x0109:
            com.alibaba.fastjson.util.JavaBeanInfo r12 = r11.beanInfo
            java.lang.reflect.Method r12 = r12.buildMethod
            if (r12 == 0) goto L_0x0123
            com.alibaba.fastjson.util.JavaBeanInfo r12 = r11.beanInfo     // Catch:{ Exception -> 0x011a }
            java.lang.reflect.Method r12 = r12.buildMethod     // Catch:{ Exception -> 0x011a }
            java.lang.Object[] r13 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x011a }
            java.lang.Object r12 = r12.invoke(r0, r13)     // Catch:{ Exception -> 0x011a }
            return r12
        L_0x011a:
            r12 = move-exception
            com.alibaba.fastjson.JSONException r13 = new com.alibaba.fastjson.JSONException
            java.lang.String r0 = "build object error"
            r13.<init>(r0, r12)
            throw r13
        L_0x0123:
            return r0
        L_0x0124:
            com.alibaba.fastjson.util.JavaBeanInfo r13 = r11.beanInfo
            com.alibaba.fastjson.util.FieldInfo[] r13 = r13.fields
            int r0 = r13.length
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r6 = r1
            r5 = r3
        L_0x012d:
            if (r5 >= r0) goto L_0x019e
            r7 = r13[r5]
            java.lang.String r8 = r7.name
            java.lang.Object r8 = r12.get(r8)
            if (r8 != 0) goto L_0x0199
            java.lang.Class<?> r9 = r7.fieldClass
            java.lang.Class r10 = java.lang.Integer.TYPE
            if (r9 != r10) goto L_0x0144
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            goto L_0x0189
        L_0x0144:
            java.lang.Class r10 = java.lang.Long.TYPE
            if (r9 != r10) goto L_0x014f
            r8 = 0
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            goto L_0x0189
        L_0x014f:
            java.lang.Class r10 = java.lang.Short.TYPE
            if (r9 != r10) goto L_0x0158
            java.lang.Short r8 = java.lang.Short.valueOf(r3)
            goto L_0x0189
        L_0x0158:
            java.lang.Class r10 = java.lang.Byte.TYPE
            if (r9 != r10) goto L_0x0161
            java.lang.Byte r8 = java.lang.Byte.valueOf(r3)
            goto L_0x0189
        L_0x0161:
            java.lang.Class r10 = java.lang.Float.TYPE
            if (r9 != r10) goto L_0x016b
            r8 = 0
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            goto L_0x0189
        L_0x016b:
            java.lang.Class r10 = java.lang.Double.TYPE
            if (r9 != r10) goto L_0x0176
            r8 = 0
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            goto L_0x0189
        L_0x0176:
            java.lang.Class r10 = java.lang.Character.TYPE
            if (r9 != r10) goto L_0x0181
            r8 = 48
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            goto L_0x0189
        L_0x0181:
            java.lang.Class r10 = java.lang.Boolean.TYPE
            if (r9 != r10) goto L_0x0189
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r3)
        L_0x0189:
            if (r6 != 0) goto L_0x0190
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
        L_0x0190:
            java.lang.String r7 = r7.name
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            r6.put(r7, r9)
        L_0x0199:
            r4[r5] = r8
            int r5 = r5 + 1
            goto L_0x012d
        L_0x019e:
            if (r6 == 0) goto L_0x01d7
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x01a8:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01d7
            java.lang.Object r13 = r12.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r5 = r13.getKey()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r13 = r13.getValue()
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r5 = r11.smartMatch(r5)
            if (r5 == 0) goto L_0x01a8
            com.alibaba.fastjson.util.FieldInfo r5 = r5.fieldInfo
            java.lang.String r5 = r5.name
            java.lang.Object r5 = r6.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x01a8
            int r5 = r5.intValue()
            r4[r5] = r13
            goto L_0x01a8
        L_0x01d7:
            com.alibaba.fastjson.util.JavaBeanInfo r12 = r11.beanInfo
            java.lang.reflect.Constructor<?> r12 = r12.creatorConstructor
            if (r12 == 0) goto L_0x0283
            com.alibaba.fastjson.util.JavaBeanInfo r12 = r11.beanInfo
            boolean r12 = r12.kotlin
            if (r12 == 0) goto L_0x0207
            r12 = r3
        L_0x01e4:
            if (r12 >= r0) goto L_0x0207
            r13 = r4[r12]
            if (r13 != 0) goto L_0x0204
            com.alibaba.fastjson.util.JavaBeanInfo r13 = r11.beanInfo
            com.alibaba.fastjson.util.FieldInfo[] r13 = r13.fields
            if (r13 == 0) goto L_0x0204
            com.alibaba.fastjson.util.JavaBeanInfo r13 = r11.beanInfo
            com.alibaba.fastjson.util.FieldInfo[] r13 = r13.fields
            int r13 = r13.length
            if (r12 >= r13) goto L_0x0204
            com.alibaba.fastjson.util.JavaBeanInfo r13 = r11.beanInfo
            com.alibaba.fastjson.util.FieldInfo[] r13 = r13.fields
            r12 = r13[r12]
            java.lang.Class<?> r12 = r12.fieldClass
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            if (r12 != r13) goto L_0x0207
            goto L_0x0208
        L_0x0204:
            int r12 = r12 + 1
            goto L_0x01e4
        L_0x0207:
            r2 = r3
        L_0x0208:
            java.lang.String r12 = "create instance error, "
            if (r2 == 0) goto L_0x025b
            com.alibaba.fastjson.util.JavaBeanInfo r13 = r11.beanInfo
            java.lang.reflect.Constructor<?> r13 = r13.kotlinDefaultConstructor
            if (r13 == 0) goto L_0x025b
            com.alibaba.fastjson.util.JavaBeanInfo r13 = r11.beanInfo     // Catch:{ Exception -> 0x023d }
            java.lang.reflect.Constructor<?> r13 = r13.kotlinDefaultConstructor     // Catch:{ Exception -> 0x023d }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x023d }
            java.lang.Object r13 = r13.newInstance(r1)     // Catch:{ Exception -> 0x023d }
        L_0x021c:
            if (r3 >= r0) goto L_0x023b
            r1 = r4[r3]     // Catch:{ Exception -> 0x023d }
            if (r1 == 0) goto L_0x0238
            com.alibaba.fastjson.util.JavaBeanInfo r2 = r11.beanInfo     // Catch:{ Exception -> 0x023d }
            com.alibaba.fastjson.util.FieldInfo[] r2 = r2.fields     // Catch:{ Exception -> 0x023d }
            if (r2 == 0) goto L_0x0238
            com.alibaba.fastjson.util.JavaBeanInfo r2 = r11.beanInfo     // Catch:{ Exception -> 0x023d }
            com.alibaba.fastjson.util.FieldInfo[] r2 = r2.fields     // Catch:{ Exception -> 0x023d }
            int r2 = r2.length     // Catch:{ Exception -> 0x023d }
            if (r3 >= r2) goto L_0x0238
            com.alibaba.fastjson.util.JavaBeanInfo r2 = r11.beanInfo     // Catch:{ Exception -> 0x023d }
            com.alibaba.fastjson.util.FieldInfo[] r2 = r2.fields     // Catch:{ Exception -> 0x023d }
            r2 = r2[r3]     // Catch:{ Exception -> 0x023d }
            r2.set(r13, r1)     // Catch:{ Exception -> 0x023d }
        L_0x0238:
            int r3 = r3 + 1
            goto L_0x021c
        L_0x023b:
            r1 = r13
            goto L_0x02b2
        L_0x023d:
            r13 = move-exception
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r12)
            com.alibaba.fastjson.util.JavaBeanInfo r12 = r11.beanInfo
            java.lang.reflect.Constructor<?> r12 = r12.creatorConstructor
            java.lang.String r12 = r12.toGenericString()
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r0.<init>(r12, r13)
            throw r0
        L_0x025b:
            com.alibaba.fastjson.util.JavaBeanInfo r13 = r11.beanInfo     // Catch:{ Exception -> 0x0265 }
            java.lang.reflect.Constructor<?> r13 = r13.creatorConstructor     // Catch:{ Exception -> 0x0265 }
            java.lang.Object r12 = r13.newInstance(r4)     // Catch:{ Exception -> 0x0265 }
            r1 = r12
            goto L_0x02b2
        L_0x0265:
            r13 = move-exception
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r12)
            com.alibaba.fastjson.util.JavaBeanInfo r12 = r11.beanInfo
            java.lang.reflect.Constructor<?> r12 = r12.creatorConstructor
            java.lang.String r12 = r12.toGenericString()
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r0.<init>(r12, r13)
            throw r0
        L_0x0283:
            com.alibaba.fastjson.util.JavaBeanInfo r12 = r11.beanInfo
            java.lang.reflect.Method r12 = r12.factoryMethod
            if (r12 == 0) goto L_0x02b2
            com.alibaba.fastjson.util.JavaBeanInfo r12 = r11.beanInfo     // Catch:{ Exception -> 0x0292 }
            java.lang.reflect.Method r12 = r12.factoryMethod     // Catch:{ Exception -> 0x0292 }
            java.lang.Object r1 = r12.invoke(r1, r4)     // Catch:{ Exception -> 0x0292 }
            goto L_0x02b2
        L_0x0292:
            r12 = move-exception
            com.alibaba.fastjson.JSONException r13 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "create factory method error, "
            r0.append(r1)
            com.alibaba.fastjson.util.JavaBeanInfo r1 = r11.beanInfo
            java.lang.reflect.Method r1 = r1.factoryMethod
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r13.<init>(r0, r12)
            throw r13
        L_0x02b2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.createInstance(java.util.Map, com.alibaba.fastjson.parser.ParserConfig):java.lang.Object");
    }

    public Type getFieldType(int i) {
        return this.sortedFieldDeserializers[i].fieldInfo.fieldType;
    }

    /* access modifiers changed from: protected */
    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i) {
        return parseRest(defaultJSONParser, type, obj, obj2, i, new int[0]);
    }

    /* access modifiers changed from: protected */
    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i, int[] iArr) {
        return deserialze(defaultJSONParser, type, obj, obj2, i, iArr);
    }

    /* access modifiers changed from: protected */
    public JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        if (javaBeanInfo.jsonType == null) {
            return null;
        }
        for (Class deserializer : javaBeanInfo.jsonType.seeAlso()) {
            ObjectDeserializer deserializer2 = parserConfig.getDeserializer((Type) deserializer);
            if (deserializer2 instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer2;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    protected static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        int i = jSONLexerBase.token();
        if (i == 8) {
            jSONLexerBase.nextToken(16);
            jSONLexerBase.token();
            return;
        }
        if (i != 14) {
            defaultJSONParser.throwException(i);
        }
        if (jSONLexerBase.getCurrent() == '[') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(14);
        } else {
            jSONLexerBase.nextToken(14);
        }
        if (jSONLexerBase.token() == 15) {
            jSONLexerBase.nextToken();
            return;
        }
        int i2 = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i2)));
            i2++;
            if (jSONLexerBase.token() != 16) {
                break;
            } else if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
        }
        int i3 = jSONLexerBase.token();
        if (i3 != 15) {
            defaultJSONParser.throwException(i3);
        }
        if (jSONLexerBase.getCurrent() == ',') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(16);
            return;
        }
        jSONLexerBase.nextToken(16);
    }
}
