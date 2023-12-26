package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    protected SerializeBeanInfo beanInfo;
    protected final FieldSerializer[] getters;
    private volatile transient long[] hashArray;
    private volatile transient short[] hashArrayMapping;
    protected final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    static Map<String, String> createAliasMap(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public Class<?> getType() {
        return this.beanInfo.beanType;
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, (PropertyNamingStrategy) null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        boolean z;
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i = 0;
        while (true) {
            FieldSerializer[] fieldSerializerArr = this.sortedGetters;
            if (i >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i]);
            i++;
        }
        if (serializeBeanInfo.fields == serializeBeanInfo.sortedFields) {
            this.getters = this.sortedGetters;
        } else {
            this.getters = new FieldSerializer[serializeBeanInfo.fields.length];
            int i2 = 0;
            while (true) {
                if (i2 >= this.getters.length) {
                    z = false;
                    break;
                }
                FieldSerializer fieldSerializer = getFieldSerializer(serializeBeanInfo.fields[i2].name);
                if (fieldSerializer == null) {
                    z = true;
                    break;
                } else {
                    this.getters[i2] = fieldSerializer;
                    i2++;
                }
            }
            if (z) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                System.arraycopy(fieldSerializerArr2, 0, this.getters, 0, fieldSerializerArr2.length);
            }
        }
        if (serializeBeanInfo.jsonType != null) {
            for (Class constructor : serializeBeanInfo.jsonType.serialzeFilters()) {
                try {
                    addFilter((SerializeFilter) constructor.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                }
            }
        }
        if (serializeBeanInfo.jsonType != null) {
            for (Class constructor2 : serializeBeanInfo.jsonType.serialzeFilters()) {
                try {
                    addFilter((SerializeFilter) constructor2.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused2) {
                }
            }
        }
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public void writeNoneASM(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x03fb, code lost:
        if (r0 == 0) goto L_0x03da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x044d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x044e, code lost:
        r2 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x0459, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:343:0x045a, code lost:
        r2 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x045d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x045e, code lost:
        r2 = r14;
        r1 = null;
        r0 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0154 A[Catch:{ Exception -> 0x0406, all -> 0x044d }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x015e A[Catch:{ Exception -> 0x0406, all -> 0x044d }] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x03dc A[Catch:{ Exception -> 0x0406, all -> 0x044d }] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x0401  */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x0428  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x042a  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x0443 A[Catch:{ Exception -> 0x0452, all -> 0x044d }] */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x044d A[ExcHandler: all (th java.lang.Throwable), PHI: r21 
      PHI: (r21v3 com.alibaba.fastjson.serializer.SerialContext) = (r21v0 com.alibaba.fastjson.serializer.SerialContext), (r21v4 com.alibaba.fastjson.serializer.SerialContext), (r21v4 com.alibaba.fastjson.serializer.SerialContext), (r21v4 com.alibaba.fastjson.serializer.SerialContext), (r21v4 com.alibaba.fastjson.serializer.SerialContext), (r21v4 com.alibaba.fastjson.serializer.SerialContext), (r21v4 com.alibaba.fastjson.serializer.SerialContext) binds: [B:326:0x042b, B:60:0x00d2, B:100:0x014e, B:113:0x0196, B:96:0x0143, B:317:0x040d, B:318:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:100:0x014e] */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x0459 A[ExcHandler: all (th java.lang.Throwable), PHI: r14 
      PHI: (r14v1 com.alibaba.fastjson.serializer.SerialContext) = (r14v2 com.alibaba.fastjson.serializer.SerialContext), (r14v0 com.alibaba.fastjson.serializer.SerialContext) binds: [B:55:0x00c7, B:23:0x0058] A[DONT_GENERATE, DONT_INLINE], Splitter:B:23:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x0466 A[SYNTHETIC, Splitter:B:348:0x0466] */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x0488 A[SYNTHETIC, Splitter:B:352:0x0488] */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x049b A[ADDED_TO_REGION, Catch:{ all -> 0x0509 }] */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x04de A[Catch:{ all -> 0x0509 }] */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x04fa A[Catch:{ all -> 0x0509 }] */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0500 A[Catch:{ all -> 0x0509 }] */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0501 A[Catch:{ all -> 0x0509 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a4 A[Catch:{ Exception -> 0x045d, all -> 0x0459 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a6 A[Catch:{ Exception -> 0x045d, all -> 0x0459 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b3 A[Catch:{ Exception -> 0x045d, all -> 0x0459 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b5 A[Catch:{ Exception -> 0x045d, all -> 0x0459 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ca A[Catch:{ Exception -> 0x0456, all -> 0x0459 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x013a A[SYNTHETIC, Splitter:B:91:0x013a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r33, java.lang.Object r34, java.lang.Object r35, java.lang.reflect.Type r36, int r37, boolean r38) throws java.io.IOException {
        /*
            r32 = this;
            r7 = r32
            r8 = r33
            r9 = r34
            r10 = r35
            r11 = r36
            r0 = r37
            com.alibaba.fastjson.serializer.SerializeWriter r12 = r8.out
            if (r9 != 0) goto L_0x0014
            r12.writeNull()
            return
        L_0x0014:
            boolean r1 = r7.writeReference(r8, r9, r0)
            if (r1 == 0) goto L_0x001b
            return
        L_0x001b:
            boolean r1 = r12.sortField
            if (r1 == 0) goto L_0x0022
            com.alibaba.fastjson.serializer.FieldSerializer[] r1 = r7.sortedGetters
            goto L_0x0024
        L_0x0022:
            com.alibaba.fastjson.serializer.FieldSerializer[] r1 = r7.getters
        L_0x0024:
            r13 = r1
            com.alibaba.fastjson.serializer.SerialContext r14 = r8.context
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r7.beanInfo
            java.lang.Class<?> r1 = r1.beanType
            boolean r1 = r1.isEnum()
            if (r1 != 0) goto L_0x0041
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r7.beanInfo
            int r5 = r1.features
            r1 = r33
            r2 = r14
            r3 = r34
            r4 = r35
            r6 = r37
            r1.setContext(r2, r3, r4, r5, r6)
        L_0x0041:
            boolean r15 = r7.isWriteAsArray(r8, r0)
            if (r15 == 0) goto L_0x004a
            r1 = 91
            goto L_0x004c
        L_0x004a:
            r1 = 123(0x7b, float:1.72E-43)
        L_0x004c:
            if (r15 == 0) goto L_0x0051
            r2 = 93
            goto L_0x0053
        L_0x0051:
            r2 = 125(0x7d, float:1.75E-43)
        L_0x0053:
            r6 = r2
            r16 = 0
            if (r38 != 0) goto L_0x005b
            r12.append((char) r1)     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
        L_0x005b:
            int r1 = r13.length     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            if (r1 <= 0) goto L_0x006c
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            boolean r1 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            if (r1 == 0) goto L_0x006c
            r33.incrementIndent()     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            r33.println()     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
        L_0x006c:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r7.beanInfo     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            int r1 = r1.features     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            int r2 = r2.mask     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            r1 = r1 & r2
            if (r1 != 0) goto L_0x0084
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            int r1 = r1.mask     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            r0 = r0 & r1
            if (r0 != 0) goto L_0x0084
            boolean r0 = r8.isWriteClassName(r11, r9)     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            if (r0 == 0) goto L_0x009f
        L_0x0084:
            java.lang.Class r0 = r34.getClass()     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            if (r0 == r11) goto L_0x0093
            boolean r1 = r11 instanceof java.lang.reflect.WildcardType     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            if (r1 == 0) goto L_0x0093
            java.lang.Class r1 = com.alibaba.fastjson.util.TypeUtils.getClass(r36)     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            goto L_0x0094
        L_0x0093:
            r1 = r11
        L_0x0094:
            if (r0 == r1) goto L_0x009f
            com.alibaba.fastjson.serializer.SerializeBeanInfo r0 = r7.beanInfo     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            java.lang.String r0 = r0.typeKey     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            r7.writeClassName(r8, r0, r9)     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            r0 = 1
            goto L_0x00a0
        L_0x009f:
            r0 = 0
        L_0x00a0:
            r3 = 44
            if (r0 == 0) goto L_0x00a6
            r0 = r3
            goto L_0x00a7
        L_0x00a6:
            r0 = 0
        L_0x00a7:
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            boolean r17 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            char r0 = r7.writeBefore(r8, r9, r0)     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            if (r0 != r3) goto L_0x00b5
            r0 = 1
            goto L_0x00b6
        L_0x00b5:
            r0 = 0
        L_0x00b6:
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.SkipTransientField     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            boolean r18 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreNonFieldGetter     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            boolean r19 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ Exception -> 0x045d, all -> 0x0459 }
            r20 = r0
            r1 = r16
            r2 = 0
        L_0x00c7:
            int r0 = r13.length     // Catch:{ Exception -> 0x0456, all -> 0x0459 }
            if (r2 >= r0) goto L_0x041f
            r10 = r13[r2]     // Catch:{ Exception -> 0x0456, all -> 0x0459 }
            com.alibaba.fastjson.util.FieldInfo r0 = r10.fieldInfo     // Catch:{ Exception -> 0x0456, all -> 0x0459 }
            java.lang.reflect.Field r0 = r0.field     // Catch:{ Exception -> 0x0456, all -> 0x0459 }
            r21 = r14
            com.alibaba.fastjson.util.FieldInfo r14 = r10.fieldInfo     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            r22 = r13
            java.lang.String r13 = r14.name     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            r23 = r6
            java.lang.Class<?> r6 = r14.fieldClass     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            int r3 = r12.features     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            int r4 = r14.serialzeFeatures     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            boolean r26 = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(r3, r4, r5)     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            boolean r3 = r12.quoteFieldNames     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            if (r3 == 0) goto L_0x00ef
            if (r26 != 0) goto L_0x00ef
            r27 = 1
            goto L_0x00f1
        L_0x00ef:
            r27 = 0
        L_0x00f1:
            if (r18 == 0) goto L_0x00fa
            if (r14 == 0) goto L_0x00fa
            boolean r3 = r14.fieldTransient     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            if (r3 == 0) goto L_0x00fa
            goto L_0x00fe
        L_0x00fa:
            if (r19 == 0) goto L_0x0108
            if (r0 != 0) goto L_0x0108
        L_0x00fe:
            r29 = r2
            r31 = r23
            r3 = 44
            r5 = 1
            r6 = 0
            goto L_0x0411
        L_0x0108:
            boolean r0 = r7.applyName(r8, r9, r13)     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            if (r0 == 0) goto L_0x0119
            java.lang.String r0 = r14.label     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            boolean r0 = r7.applyLabel(r8, r0)     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            if (r0 != 0) goto L_0x0117
            goto L_0x0119
        L_0x0117:
            r0 = 0
            goto L_0x011c
        L_0x0119:
            if (r15 == 0) goto L_0x00fe
            r0 = 1
        L_0x011c:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r3 = r7.beanInfo     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            java.lang.String r3 = r3.typeKey     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            if (r3 == 0) goto L_0x0133
            com.alibaba.fastjson.serializer.SerializeBeanInfo r3 = r7.beanInfo     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            java.lang.String r3 = r3.typeKey     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            boolean r3 = r13.equals(r3)     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            if (r3 == 0) goto L_0x0133
            boolean r3 = r8.isWriteClassName(r11, r9)     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            if (r3 == 0) goto L_0x0133
            goto L_0x00fe
        L_0x0133:
            if (r0 == 0) goto L_0x013a
            r28 = r1
        L_0x0137:
            r0 = r16
            goto L_0x014e
        L_0x013a:
            java.lang.Object r0 = r10.getPropertyValueDirect(r9)     // Catch:{ InvocationTargetException -> 0x0141 }
            r28 = r1
            goto L_0x014e
        L_0x0141:
            r0 = move-exception
            r1 = r0
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreErrorGetter     // Catch:{ Exception -> 0x040e, all -> 0x044d }
            boolean r0 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r0)     // Catch:{ Exception -> 0x040e, all -> 0x044d }
            if (r0 == 0) goto L_0x040d
            r28 = r10
            goto L_0x0137
        L_0x014e:
            boolean r1 = r7.apply(r8, r9, r13, r0)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r1 != 0) goto L_0x015e
            r29 = r2
            r31 = r23
            r3 = 44
            r5 = 1
            r6 = 0
            goto L_0x0403
        L_0x015e:
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            if (r6 != r1) goto L_0x0174
            java.lang.String r1 = "trim"
            java.lang.String r3 = r14.format     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r1 == 0) goto L_0x0174
            if (r0 == 0) goto L_0x0174
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
        L_0x0174:
            java.lang.String r5 = r7.processKey(r8, r9, r13, r0)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            com.alibaba.fastjson.serializer.BeanContext r3 = r10.fieldContext     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r1 = r32
            r29 = r2
            r2 = r33
            r4 = 44
            r11 = r4
            r37 = 0
            r4 = r34
            r30 = r5
            r5 = r13
            r11 = r6
            r31 = r23
            r6 = r0
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0260
            int r3 = r14.serialzeFeatures     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            com.alibaba.fastjson.serializer.SerializeBeanInfo r4 = r7.beanInfo     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            com.alibaba.fastjson.annotation.JSONType r4 = r4.jsonType     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r4 == 0) goto L_0x01ab
            com.alibaba.fastjson.serializer.SerializeBeanInfo r4 = r7.beanInfo     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            com.alibaba.fastjson.annotation.JSONType r4 = r4.jsonType     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r4.serialzeFeatures()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.of(r4)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r3 = r3 | r4
        L_0x01ab:
            java.lang.Class<java.lang.Boolean> r4 = java.lang.Boolean.class
            if (r11 != r4) goto L_0x01d3
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r4 = r4.mask     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r5 = r5.mask     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r5 = r5 | r4
            if (r15 != 0) goto L_0x01c5
            r6 = r3 & r5
            if (r6 != 0) goto L_0x01c5
            int r6 = r12.features     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r5 = r5 & r6
            if (r5 != 0) goto L_0x01c5
            goto L_0x031b
        L_0x01c5:
            r3 = r3 & r4
            if (r3 != 0) goto L_0x01cd
            int r3 = r12.features     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0260
        L_0x01cd:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r37)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            goto L_0x0260
        L_0x01d3:
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            if (r11 != r4) goto L_0x01f8
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r4 = r4.mask     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r5 = r5.mask     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r5 = r5 | r4
            if (r15 != 0) goto L_0x01ed
            r6 = r3 & r5
            if (r6 != 0) goto L_0x01ed
            int r6 = r12.features     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r5 = r5 & r6
            if (r5 != 0) goto L_0x01ed
            goto L_0x031b
        L_0x01ed:
            r3 = r3 & r4
            if (r3 != 0) goto L_0x01f5
            int r3 = r12.features     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0260
        L_0x01f5:
            r1 = r2
            goto L_0x0260
        L_0x01f8:
            java.lang.Class<java.lang.Number> r4 = java.lang.Number.class
            boolean r4 = r4.isAssignableFrom(r11)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r4 == 0) goto L_0x0223
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r4 = r4.mask     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r5 = r5.mask     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r5 = r5 | r4
            if (r15 != 0) goto L_0x0216
            r6 = r3 & r5
            if (r6 != 0) goto L_0x0216
            int r6 = r12.features     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r5 = r5 & r6
            if (r5 != 0) goto L_0x0216
            goto L_0x031b
        L_0x0216:
            r3 = r3 & r4
            if (r3 != 0) goto L_0x021e
            int r3 = r12.features     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0260
        L_0x021e:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r37)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            goto L_0x0260
        L_0x0223:
            java.lang.Class<java.util.Collection> r4 = java.util.Collection.class
            boolean r4 = r4.isAssignableFrom(r11)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r4 == 0) goto L_0x024e
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r4 = r4.mask     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r5 = r5.mask     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r5 = r5 | r4
            if (r15 != 0) goto L_0x0241
            r6 = r3 & r5
            if (r6 != 0) goto L_0x0241
            int r6 = r12.features     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r5 = r5 & r6
            if (r5 != 0) goto L_0x0241
            goto L_0x031b
        L_0x0241:
            r3 = r3 & r4
            if (r3 != 0) goto L_0x0249
            int r3 = r12.features     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0260
        L_0x0249:
            java.util.List r1 = java.util.Collections.emptyList()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            goto L_0x0260
        L_0x024e:
            if (r15 != 0) goto L_0x0260
            boolean r3 = r10.writeNull     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 != 0) goto L_0x0260
            com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r3 = r3.mask     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            boolean r3 = r12.isEnabled((int) r3)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 != 0) goto L_0x0260
            goto L_0x031b
        L_0x0260:
            if (r1 == 0) goto L_0x0308
            boolean r3 = r12.notWriteDefaultValue     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 != 0) goto L_0x027a
            int r3 = r14.serialzeFeatures     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r4 = r4.mask     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r3 = r3 & r4
            if (r3 != 0) goto L_0x027a
            com.alibaba.fastjson.serializer.SerializeBeanInfo r3 = r7.beanInfo     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r3 = r3.features     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r4 = r4.mask     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0308
        L_0x027a:
            java.lang.Class<?> r3 = r14.fieldClass     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            java.lang.Class r4 = java.lang.Byte.TYPE     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 != r4) goto L_0x028f
            boolean r4 = r1 instanceof java.lang.Byte     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r4 == 0) goto L_0x028f
            r4 = r1
            java.lang.Byte r4 = (java.lang.Byte) r4     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            byte r4 = r4.byteValue()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r4 != 0) goto L_0x028f
            goto L_0x031b
        L_0x028f:
            java.lang.Class r4 = java.lang.Short.TYPE     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 != r4) goto L_0x02a2
            boolean r4 = r1 instanceof java.lang.Short     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r4 == 0) goto L_0x02a2
            r4 = r1
            java.lang.Short r4 = (java.lang.Short) r4     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            short r4 = r4.shortValue()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r4 != 0) goto L_0x02a2
            goto L_0x031b
        L_0x02a2:
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 != r4) goto L_0x02b5
            boolean r4 = r1 instanceof java.lang.Integer     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r4 == 0) goto L_0x02b5
            r4 = r1
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r4 != 0) goto L_0x02b5
            goto L_0x031b
        L_0x02b5:
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 != r4) goto L_0x02cb
            boolean r4 = r1 instanceof java.lang.Long     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r4 == 0) goto L_0x02cb
            r4 = r1
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r24 = 0
            int r4 = (r4 > r24 ? 1 : (r4 == r24 ? 0 : -1))
            if (r4 != 0) goto L_0x02cb
            goto L_0x031b
        L_0x02cb:
            java.lang.Class r4 = java.lang.Float.TYPE     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 != r4) goto L_0x02e0
            boolean r4 = r1 instanceof java.lang.Float     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r4 == 0) goto L_0x02e0
            r4 = r1
            java.lang.Float r4 = (java.lang.Float) r4     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            float r4 = r4.floatValue()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x02e0
            goto L_0x031b
        L_0x02e0:
            java.lang.Class r4 = java.lang.Double.TYPE     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 != r4) goto L_0x02f6
            boolean r4 = r1 instanceof java.lang.Double     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r4 == 0) goto L_0x02f6
            r4 = r1
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            double r4 = r4.doubleValue()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r24 = 0
            int r4 = (r4 > r24 ? 1 : (r4 == r24 ? 0 : -1))
            if (r4 != 0) goto L_0x02f6
            goto L_0x031b
        L_0x02f6:
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 != r4) goto L_0x0308
            boolean r3 = r1 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 == 0) goto L_0x0308
            r3 = r1
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 != 0) goto L_0x0308
            goto L_0x031b
        L_0x0308:
            if (r20 == 0) goto L_0x0333
            boolean r3 = r14.unwrapped     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 == 0) goto L_0x0322
            boolean r3 = r1 instanceof java.util.Map     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 == 0) goto L_0x0322
            r3 = r1
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r3 = r3.size()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r3 != 0) goto L_0x0322
        L_0x031b:
            r6 = r37
            r3 = 44
            r5 = 1
            goto L_0x0403
        L_0x0322:
            r3 = 44
            r12.write((int) r3)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            boolean r4 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r4)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r4 == 0) goto L_0x0335
            r33.println()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            goto L_0x0335
        L_0x0333:
            r3 = 44
        L_0x0335:
            r4 = r30
            if (r4 == r13) goto L_0x0348
            if (r15 != 0) goto L_0x0340
            r5 = 1
            r12.writeFieldName(r4, r5)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            goto L_0x0341
        L_0x0340:
            r5 = 1
        L_0x0341:
            r8.write((java.lang.Object) r1)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
        L_0x0344:
            r6 = r37
            goto L_0x03ca
        L_0x0348:
            r5 = 1
            if (r0 == r1) goto L_0x0354
            if (r15 != 0) goto L_0x0350
            r10.writePrefix(r8)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
        L_0x0350:
            r8.write((java.lang.Object) r1)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            goto L_0x0344
        L_0x0354:
            if (r15 != 0) goto L_0x036f
            if (r17 != 0) goto L_0x035c
            boolean r0 = r14.unwrapped     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r0 != 0) goto L_0x036f
        L_0x035c:
            if (r27 == 0) goto L_0x0369
            char[] r0 = r14.name_chars     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            char[] r4 = r14.name_chars     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r4 = r4.length     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r6 = r37
            r12.write((char[]) r0, (int) r6, (int) r4)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            goto L_0x0371
        L_0x0369:
            r6 = r37
            r10.writePrefix(r8)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            goto L_0x0371
        L_0x036f:
            r6 = r37
        L_0x0371:
            if (r15 != 0) goto L_0x03c7
            com.alibaba.fastjson.annotation.JSONField r0 = r14.getAnnotation()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            if (r11 != r4) goto L_0x03af
            if (r0 == 0) goto L_0x0385
            java.lang.Class r0 = r0.serializeUsing()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            java.lang.Class<java.lang.Void> r4 = java.lang.Void.class
            if (r0 != r4) goto L_0x03af
        L_0x0385:
            if (r1 != 0) goto L_0x03a2
            int r0 = r12.features     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r4 = r4.mask     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r0 = r0 & r4
            if (r0 != 0) goto L_0x039e
            int r0 = r10.features     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r4 = r4.mask     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            r0 = r0 & r4
            if (r0 == 0) goto L_0x039a
            goto L_0x039e
        L_0x039a:
            r12.writeNull()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            goto L_0x03ca
        L_0x039e:
            r12.writeString((java.lang.String) r2)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            goto L_0x03ca
        L_0x03a2:
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r26 == 0) goto L_0x03ab
            r12.writeStringWithSingleQuote((java.lang.String) r0)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            goto L_0x03ca
        L_0x03ab:
            r12.writeStringWithDoubleQuote((java.lang.String) r0, (char) r6)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            goto L_0x03ca
        L_0x03af:
            boolean r0 = r14.unwrapped     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r0 == 0) goto L_0x03c3
            boolean r0 = r1 instanceof java.util.Map     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r0 == 0) goto L_0x03c3
            r0 = r1
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r0 = r0.size()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r0 != 0) goto L_0x03c3
            r20 = r6
            goto L_0x0403
        L_0x03c3:
            r10.writeValue(r8, r1)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            goto L_0x03ca
        L_0x03c7:
            r10.writeValue(r8, r1)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
        L_0x03ca:
            boolean r0 = r14.unwrapped     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r0 == 0) goto L_0x03fe
            boolean r0 = r1 instanceof java.util.Map     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r0 == 0) goto L_0x03fe
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            int r0 = r1.size()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r0 != 0) goto L_0x03dc
        L_0x03da:
            r0 = r5
            goto L_0x03ff
        L_0x03dc:
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            boolean r0 = r8.isEnabled(r0)     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r0 != 0) goto L_0x03fe
            java.util.Collection r0 = r1.values()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
        L_0x03ec:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r1 == 0) goto L_0x03fa
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0406, all -> 0x044d }
            if (r1 == 0) goto L_0x03ec
            r0 = r5
            goto L_0x03fb
        L_0x03fa:
            r0 = r6
        L_0x03fb:
            if (r0 != 0) goto L_0x03fe
            goto L_0x03da
        L_0x03fe:
            r0 = r6
        L_0x03ff:
            if (r0 != 0) goto L_0x0403
            r20 = r5
        L_0x0403:
            r1 = r28
            goto L_0x0411
        L_0x0406:
            r0 = move-exception
            r2 = r21
            r1 = r28
            goto L_0x0461
        L_0x040d:
            throw r1     // Catch:{ Exception -> 0x040e, all -> 0x044d }
        L_0x040e:
            r0 = move-exception
            r1 = r10
            goto L_0x0453
        L_0x0411:
            int r2 = r29 + 1
            r10 = r35
            r11 = r36
            r14 = r21
            r13 = r22
            r6 = r31
            goto L_0x00c7
        L_0x041f:
            r31 = r6
            r22 = r13
            r21 = r14
            r6 = 0
            if (r20 == 0) goto L_0x042a
            r4 = r3
            goto L_0x042b
        L_0x042a:
            r4 = r6
        L_0x042b:
            r7.writeAfter(r8, r9, r4)     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            r2 = r22
            int r0 = r2.length     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            if (r0 <= 0) goto L_0x0441
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            boolean r0 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r0)     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            if (r0 == 0) goto L_0x0441
            r33.decrementIdent()     // Catch:{ Exception -> 0x0452, all -> 0x044d }
            r33.println()     // Catch:{ Exception -> 0x0452, all -> 0x044d }
        L_0x0441:
            if (r38 != 0) goto L_0x0448
            r2 = r31
            r12.append((char) r2)     // Catch:{ Exception -> 0x0452, all -> 0x044d }
        L_0x0448:
            r2 = r21
            r8.context = r2
            return
        L_0x044d:
            r0 = move-exception
            r2 = r21
            goto L_0x050a
        L_0x0452:
            r0 = move-exception
        L_0x0453:
            r2 = r21
            goto L_0x0461
        L_0x0456:
            r0 = move-exception
            r2 = r14
            goto L_0x0461
        L_0x0459:
            r0 = move-exception
            r2 = r14
            goto L_0x050a
        L_0x045d:
            r0 = move-exception
            r2 = r14
            r1 = r16
        L_0x0461:
            java.lang.String r3 = "write javaBean error, fastjson version 1.2.60"
            if (r9 == 0) goto L_0x0482
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0509 }
            r4.<init>()     // Catch:{ all -> 0x0509 }
            r4.append(r3)     // Catch:{ all -> 0x0509 }
            java.lang.String r3 = ", class "
            r4.append(r3)     // Catch:{ all -> 0x0509 }
            java.lang.Class r3 = r34.getClass()     // Catch:{ all -> 0x0509 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x0509 }
            r4.append(r3)     // Catch:{ all -> 0x0509 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0509 }
        L_0x0482:
            java.lang.String r4 = ", fieldName : "
            r5 = r35
            if (r5 == 0) goto L_0x049b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0509 }
            r1.<init>()     // Catch:{ all -> 0x0509 }
            r1.append(r3)     // Catch:{ all -> 0x0509 }
            r1.append(r4)     // Catch:{ all -> 0x0509 }
            r1.append(r5)     // Catch:{ all -> 0x0509 }
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x0509 }
            goto L_0x04d8
        L_0x049b:
            if (r1 == 0) goto L_0x04d8
            com.alibaba.fastjson.util.FieldInfo r5 = r1.fieldInfo     // Catch:{ all -> 0x0509 }
            if (r5 == 0) goto L_0x04d8
            com.alibaba.fastjson.util.FieldInfo r5 = r1.fieldInfo     // Catch:{ all -> 0x0509 }
            java.lang.reflect.Method r6 = r5.method     // Catch:{ all -> 0x0509 }
            if (r6 == 0) goto L_0x04c2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0509 }
            r1.<init>()     // Catch:{ all -> 0x0509 }
            r1.append(r3)     // Catch:{ all -> 0x0509 }
            java.lang.String r3 = ", method : "
            r1.append(r3)     // Catch:{ all -> 0x0509 }
            java.lang.reflect.Method r3 = r5.method     // Catch:{ all -> 0x0509 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x0509 }
            r1.append(r3)     // Catch:{ all -> 0x0509 }
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x0509 }
            goto L_0x04d8
        L_0x04c2:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0509 }
            r5.<init>()     // Catch:{ all -> 0x0509 }
            r5.append(r3)     // Catch:{ all -> 0x0509 }
            r5.append(r4)     // Catch:{ all -> 0x0509 }
            com.alibaba.fastjson.util.FieldInfo r1 = r1.fieldInfo     // Catch:{ all -> 0x0509 }
            java.lang.String r1 = r1.name     // Catch:{ all -> 0x0509 }
            r5.append(r1)     // Catch:{ all -> 0x0509 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0509 }
        L_0x04d8:
            java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x0509 }
            if (r1 == 0) goto L_0x04f6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0509 }
            r1.<init>()     // Catch:{ all -> 0x0509 }
            r1.append(r3)     // Catch:{ all -> 0x0509 }
            java.lang.String r3 = ", "
            r1.append(r3)     // Catch:{ all -> 0x0509 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x0509 }
            r1.append(r3)     // Catch:{ all -> 0x0509 }
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x0509 }
        L_0x04f6:
            boolean r1 = r0 instanceof java.lang.reflect.InvocationTargetException     // Catch:{ all -> 0x0509 }
            if (r1 == 0) goto L_0x04fe
            java.lang.Throwable r16 = r0.getCause()     // Catch:{ all -> 0x0509 }
        L_0x04fe:
            if (r16 != 0) goto L_0x0501
            goto L_0x0503
        L_0x0501:
            r0 = r16
        L_0x0503:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0509 }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x0509 }
            throw r1     // Catch:{ all -> 0x0509 }
        L_0x0509:
            r0 = move-exception
        L_0x050a:
            r8.context = r2
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    /* access modifiers changed from: protected */
    public void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        String str2 = this.beanInfo.typeName;
        if (str2 == null) {
            Class cls = obj.getClass();
            if (TypeUtils.isProxy(cls)) {
                cls = cls.getSuperclass();
            }
            str2 = cls.getName();
        }
        jSONSerializer.write(str2);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i) {
        SerialContext serialContext = jSONSerializer.context;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext == null || (serialContext.features & i2) != 0 || (i & i2) != 0 || jSONSerializer.references == null || !jSONSerializer.references.containsKey(obj)) {
            return false;
        }
        jSONSerializer.writeReference(obj);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    /* access modifiers changed from: protected */
    public boolean isWriteAsArray(JSONSerializer jSONSerializer, int i) {
        int i2 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i2) == 0 && !jSONSerializer.out.beanToArray && (i & i2) == 0) ? false : true;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer != null) {
            try {
                return fieldSerializer.getPropertyValue(obj);
            } catch (InvocationTargetException e) {
                throw new JSONException("getFieldValue error." + str, e);
            } catch (IllegalAccessException e2) {
                throw new JSONException("getFieldValue error." + str, e2);
            }
        } else {
            throw new JSONException("field not found. " + str);
        }
    }

    public Object getFieldValue(Object obj, String str, long j, boolean z) {
        FieldSerializer fieldSerializer = getFieldSerializer(j);
        if (fieldSerializer != null) {
            try {
                return fieldSerializer.getPropertyValue(obj);
            } catch (InvocationTargetException e) {
                throw new JSONException("getFieldValue error." + str, e);
            } catch (IllegalAccessException e2) {
                throw new JSONException("getFieldValue error." + str, e2);
            }
        } else if (!z) {
            return null;
        } else {
            throw new JSONException("field not found. " + str);
        }
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.sortedGetters.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedGetters[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo <= 0) {
                return this.sortedGetters[i2];
            } else {
                length = i2 - 1;
            }
        }
        return null;
    }

    public FieldSerializer getFieldSerializer(long j) {
        PropertyNamingStrategy[] propertyNamingStrategyArr;
        int binarySearch;
        if (this.hashArray == null) {
            propertyNamingStrategyArr = PropertyNamingStrategy.values();
            long[] jArr = new long[(this.sortedGetters.length * propertyNamingStrategyArr.length)];
            int i = 0;
            int i2 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr = this.sortedGetters;
                if (i >= fieldSerializerArr.length) {
                    break;
                }
                String str = fieldSerializerArr[i].fieldInfo.name;
                jArr[i2] = TypeUtils.fnv1a_64(str);
                i2++;
                for (PropertyNamingStrategy translate : propertyNamingStrategyArr) {
                    String translate2 = translate.translate(str);
                    if (!str.equals(translate2)) {
                        jArr[i2] = TypeUtils.fnv1a_64(translate2);
                        i2++;
                    }
                }
                i++;
            }
            Arrays.sort(jArr, 0, i2);
            this.hashArray = new long[i2];
            System.arraycopy(jArr, 0, this.hashArray, 0, i2);
        } else {
            propertyNamingStrategyArr = null;
        }
        int binarySearch2 = Arrays.binarySearch(this.hashArray, j);
        if (binarySearch2 < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            if (propertyNamingStrategyArr == null) {
                propertyNamingStrategyArr = PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, -1);
            int i3 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                if (i3 >= fieldSerializerArr2.length) {
                    break;
                }
                String str2 = fieldSerializerArr2[i3].fieldInfo.name;
                int binarySearch3 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(str2));
                if (binarySearch3 >= 0) {
                    sArr[binarySearch3] = (short) i3;
                }
                for (PropertyNamingStrategy translate3 : propertyNamingStrategyArr) {
                    String translate4 = translate3.translate(str2);
                    if (!str2.equals(translate4) && (binarySearch = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(translate4))) >= 0) {
                        sArr[binarySearch] = (short) i3;
                    }
                }
                i3++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch2];
        if (s != -1) {
            return this.sortedGetters[s];
        }
        return null;
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer propertyValue : this.sortedGetters) {
            arrayList.add(propertyValue.getPropertyValue(obj));
        }
        return arrayList;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i = 0;
        for (FieldSerializer propertyValueDirect : this.sortedGetters) {
            if (propertyValueDirect.getPropertyValueDirect(obj) != null) {
                i++;
            }
        }
        return i;
    }

    public Set<String> getFieldNames(Object obj) throws Exception {
        HashSet hashSet = new HashSet();
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                hashSet.add(fieldSerializer.fieldInfo.name);
            }
        }
        return hashSet;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            boolean isEnabled = SerializerFeature.isEnabled(fieldSerializer.features, SerializerFeature.SkipTransientField);
            FieldInfo fieldInfo = fieldSerializer.fieldInfo;
            if (!isEnabled || fieldInfo == null || !fieldInfo.fieldTransient) {
                linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
            }
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: protected */
    public BeanContext getBeanContext(int i) {
        return this.sortedGetters[i].fieldContext;
    }

    /* access modifiers changed from: protected */
    public Type getFieldType(int i) {
        return this.sortedGetters[i].fieldInfo.fieldType;
    }

    /* access modifiers changed from: protected */
    public char writeBefore(JSONSerializer jSONSerializer, Object obj, char c) {
        if (jSONSerializer.beforeFilters != null) {
            for (BeforeFilter writeBefore : jSONSerializer.beforeFilters) {
                c = writeBefore.writeBefore(jSONSerializer, obj, c);
            }
        }
        if (this.beforeFilters != null) {
            for (BeforeFilter writeBefore2 : this.beforeFilters) {
                c = writeBefore2.writeBefore(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    /* access modifiers changed from: protected */
    public char writeAfter(JSONSerializer jSONSerializer, Object obj, char c) {
        if (jSONSerializer.afterFilters != null) {
            for (AfterFilter writeAfter : jSONSerializer.afterFilters) {
                c = writeAfter.writeAfter(jSONSerializer, obj, c);
            }
        }
        if (this.afterFilters != null) {
            for (AfterFilter writeAfter2 : this.afterFilters) {
                c = writeAfter2.writeAfter(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    /* access modifiers changed from: protected */
    public boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        if (jSONSerializer.labelFilters != null) {
            for (LabelFilter apply : jSONSerializer.labelFilters) {
                if (!apply.apply(str)) {
                    return false;
                }
            }
        }
        if (this.labelFilters == null) {
            return true;
        }
        for (LabelFilter apply2 : this.labelFilters) {
            if (!apply2.apply(str)) {
                return false;
            }
        }
        return true;
    }
}
