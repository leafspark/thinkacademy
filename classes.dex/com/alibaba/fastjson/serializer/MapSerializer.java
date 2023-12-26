package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    private static final int NON_STRINGKEY_AS_STRING = SerializerFeature.of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});
    public static MapSerializer instance = new MapSerializer();

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e6, code lost:
        if (applyName(r8, r0, (java.lang.String) r1) == false) goto L_0x00e8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01fc A[Catch:{ all -> 0x02fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0215 A[Catch:{ all -> 0x02fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x024a A[Catch:{ all -> 0x02fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0261 A[Catch:{ all -> 0x02fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0284 A[Catch:{ all -> 0x02fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x028e A[Catch:{ all -> 0x02fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a7 A[Catch:{ all -> 0x02fe }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r24, java.lang.Object r25, java.lang.Object r26, java.lang.reflect.Type r27, int r28, boolean r29) throws java.io.IOException {
        /*
            r23 = this;
            r7 = r23
            r8 = r24
            r0 = r25
            r9 = r27
            r10 = r28
            com.alibaba.fastjson.serializer.SerializeWriter r11 = r8.out
            if (r0 != 0) goto L_0x0012
            r11.writeNull()
            return
        L_0x0012:
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.MapSortField
            int r2 = r2.mask
            int r3 = r11.features
            r3 = r3 & r2
            if (r3 != 0) goto L_0x0024
            r2 = r2 & r10
            if (r2 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r12 = r1
            goto L_0x003c
        L_0x0024:
            boolean r2 = r1 instanceof com.alibaba.fastjson.JSONObject
            if (r2 == 0) goto L_0x002e
            com.alibaba.fastjson.JSONObject r1 = (com.alibaba.fastjson.JSONObject) r1
            java.util.Map r1 = r1.getInnerMap()
        L_0x002e:
            boolean r2 = r1 instanceof java.util.SortedMap
            if (r2 != 0) goto L_0x0022
            boolean r2 = r1 instanceof java.util.LinkedHashMap
            if (r2 != 0) goto L_0x0022
            java.util.TreeMap r2 = new java.util.TreeMap     // Catch:{ Exception -> 0x0022 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0022 }
            r12 = r2
        L_0x003c:
            boolean r1 = r24.containsReference(r25)
            if (r1 == 0) goto L_0x0046
            r24.writeReference(r25)
            return
        L_0x0046:
            com.alibaba.fastjson.serializer.SerialContext r13 = r8.context
            r14 = 0
            r1 = r26
            r8.setContext(r13, r0, r1, r14)
            if (r29 != 0) goto L_0x0055
            r1 = 123(0x7b, float:1.72E-43)
            r11.write((int) r1)     // Catch:{ all -> 0x02fe }
        L_0x0055:
            r24.incrementIndent()     // Catch:{ all -> 0x02fe }
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ all -> 0x02fe }
            boolean r1 = r11.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ all -> 0x02fe }
            r15 = 1
            if (r1 == 0) goto L_0x0090
            com.alibaba.fastjson.serializer.SerializeConfig r1 = r8.config     // Catch:{ all -> 0x02fe }
            java.lang.String r1 = r1.typeKey     // Catch:{ all -> 0x02fe }
            java.lang.Class r2 = r12.getClass()     // Catch:{ all -> 0x02fe }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r3 = com.alibaba.fastjson.JSONObject.class
            if (r2 == r3) goto L_0x0075
            java.lang.Class<java.util.HashMap> r3 = java.util.HashMap.class
            if (r2 == r3) goto L_0x0075
            java.lang.Class<java.util.LinkedHashMap> r3 = java.util.LinkedHashMap.class
            if (r2 != r3) goto L_0x007d
        L_0x0075:
            boolean r2 = r12.containsKey(r1)     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x007d
            r2 = r15
            goto L_0x007e
        L_0x007d:
            r2 = r14
        L_0x007e:
            if (r2 != 0) goto L_0x0090
            r11.writeFieldName(r1)     // Catch:{ all -> 0x02fe }
            java.lang.Class r1 = r25.getClass()     // Catch:{ all -> 0x02fe }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x02fe }
            r11.writeString((java.lang.String) r1)     // Catch:{ all -> 0x02fe }
            r1 = r14
            goto L_0x0091
        L_0x0090:
            r1 = r15
        L_0x0091:
            java.util.Set r2 = r12.entrySet()     // Catch:{ all -> 0x02fe }
            java.util.Iterator r16 = r2.iterator()     // Catch:{ all -> 0x02fe }
            r17 = 0
            r18 = r1
            r6 = r17
            r19 = r6
        L_0x00a1:
            boolean r1 = r16.hasNext()     // Catch:{ all -> 0x02fe }
            if (r1 == 0) goto L_0x02e0
            java.lang.Object r1 = r16.next()     // Catch:{ all -> 0x02fe }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x02fe }
            java.lang.Object r5 = r1.getValue()     // Catch:{ all -> 0x02fe }
            java.lang.Object r1 = r1.getKey()     // Catch:{ all -> 0x02fe }
            java.util.List r2 = r8.propertyPreFilters     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x00ec
            int r2 = r2.size()     // Catch:{ all -> 0x02fe }
            if (r2 <= 0) goto L_0x00ec
            if (r1 == 0) goto L_0x00df
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x00c6
            goto L_0x00df
        L_0x00c6:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02fe }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02fe }
            if (r2 != 0) goto L_0x00d4
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x00ec
        L_0x00d4:
            java.lang.String r2 = com.bonree.sdk.agent.engine.external.FastJsonInstrumentation.toJSONString(r1)     // Catch:{ all -> 0x02fe }
            boolean r2 = r7.applyName(r8, r0, r2)     // Catch:{ all -> 0x02fe }
            if (r2 != 0) goto L_0x00ec
            goto L_0x00e8
        L_0x00df:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02fe }
            boolean r2 = r7.applyName(r8, r0, r2)     // Catch:{ all -> 0x02fe }
            if (r2 != 0) goto L_0x00ec
        L_0x00e8:
            r22 = r6
            goto L_0x023f
        L_0x00ec:
            java.util.List r2 = r7.propertyPreFilters     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x0120
            int r2 = r2.size()     // Catch:{ all -> 0x02fe }
            if (r2 <= 0) goto L_0x0120
            if (r1 == 0) goto L_0x0116
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x00fd
            goto L_0x0116
        L_0x00fd:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02fe }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02fe }
            if (r2 != 0) goto L_0x010b
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x0120
        L_0x010b:
            java.lang.String r2 = com.bonree.sdk.agent.engine.external.FastJsonInstrumentation.toJSONString(r1)     // Catch:{ all -> 0x02fe }
            boolean r2 = r7.applyName(r8, r0, r2)     // Catch:{ all -> 0x02fe }
            if (r2 != 0) goto L_0x0120
            goto L_0x00e8
        L_0x0116:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02fe }
            boolean r2 = r7.applyName(r8, r0, r2)     // Catch:{ all -> 0x02fe }
            if (r2 != 0) goto L_0x0120
            goto L_0x00e8
        L_0x0120:
            java.util.List r2 = r8.propertyFilters     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x0154
            int r2 = r2.size()     // Catch:{ all -> 0x02fe }
            if (r2 <= 0) goto L_0x0154
            if (r1 == 0) goto L_0x014a
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x0131
            goto L_0x014a
        L_0x0131:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02fe }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02fe }
            if (r2 != 0) goto L_0x013f
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x0154
        L_0x013f:
            java.lang.String r2 = com.bonree.sdk.agent.engine.external.FastJsonInstrumentation.toJSONString(r1)     // Catch:{ all -> 0x02fe }
            boolean r2 = r7.apply(r8, r0, r2, r5)     // Catch:{ all -> 0x02fe }
            if (r2 != 0) goto L_0x0154
            goto L_0x00e8
        L_0x014a:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02fe }
            boolean r2 = r7.apply(r8, r0, r2, r5)     // Catch:{ all -> 0x02fe }
            if (r2 != 0) goto L_0x0154
            goto L_0x00e8
        L_0x0154:
            java.util.List r2 = r7.propertyFilters     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x018a
            int r2 = r2.size()     // Catch:{ all -> 0x02fe }
            if (r2 <= 0) goto L_0x018a
            if (r1 == 0) goto L_0x017f
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x0165
            goto L_0x017f
        L_0x0165:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02fe }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02fe }
            if (r2 != 0) goto L_0x0173
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x018a
        L_0x0173:
            java.lang.String r2 = com.bonree.sdk.agent.engine.external.FastJsonInstrumentation.toJSONString(r1)     // Catch:{ all -> 0x02fe }
            boolean r2 = r7.apply(r8, r0, r2, r5)     // Catch:{ all -> 0x02fe }
            if (r2 != 0) goto L_0x018a
            goto L_0x00e8
        L_0x017f:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02fe }
            boolean r2 = r7.apply(r8, r0, r2, r5)     // Catch:{ all -> 0x02fe }
            if (r2 != 0) goto L_0x018a
            goto L_0x00e8
        L_0x018a:
            java.util.List r2 = r8.nameFilters     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x01b8
            int r2 = r2.size()     // Catch:{ all -> 0x02fe }
            if (r2 <= 0) goto L_0x01b8
            if (r1 == 0) goto L_0x01b2
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x019b
            goto L_0x01b2
        L_0x019b:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02fe }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02fe }
            if (r2 != 0) goto L_0x01a9
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x01b8
        L_0x01a9:
            java.lang.String r1 = com.bonree.sdk.agent.engine.external.FastJsonInstrumentation.toJSONString(r1)     // Catch:{ all -> 0x02fe }
            java.lang.String r1 = r7.processKey(r8, r0, r1, r5)     // Catch:{ all -> 0x02fe }
            goto L_0x01b8
        L_0x01b2:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x02fe }
            java.lang.String r1 = r7.processKey(r8, r0, r1, r5)     // Catch:{ all -> 0x02fe }
        L_0x01b8:
            java.util.List r2 = r7.nameFilters     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x01e6
            int r2 = r2.size()     // Catch:{ all -> 0x02fe }
            if (r2 <= 0) goto L_0x01e6
            if (r1 == 0) goto L_0x01e0
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x01c9
            goto L_0x01e0
        L_0x01c9:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02fe }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02fe }
            if (r2 != 0) goto L_0x01d7
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02fe }
            if (r2 == 0) goto L_0x01e6
        L_0x01d7:
            java.lang.String r1 = com.bonree.sdk.agent.engine.external.FastJsonInstrumentation.toJSONString(r1)     // Catch:{ all -> 0x02fe }
            java.lang.String r1 = r7.processKey(r8, r0, r1, r5)     // Catch:{ all -> 0x02fe }
            goto L_0x01e6
        L_0x01e0:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x02fe }
            java.lang.String r1 = r7.processKey(r8, r0, r1, r5)     // Catch:{ all -> 0x02fe }
        L_0x01e6:
            r4 = r1
            if (r4 == 0) goto L_0x021d
            boolean r1 = r4 instanceof java.lang.String     // Catch:{ all -> 0x02fe }
            if (r1 == 0) goto L_0x01ee
            goto L_0x021d
        L_0x01ee:
            boolean r1 = r4 instanceof java.util.Map     // Catch:{ all -> 0x02fe }
            if (r1 != 0) goto L_0x01f9
            boolean r1 = r4 instanceof java.util.Collection     // Catch:{ all -> 0x02fe }
            if (r1 == 0) goto L_0x01f7
            goto L_0x01f9
        L_0x01f7:
            r1 = r14
            goto L_0x01fa
        L_0x01f9:
            r1 = r15
        L_0x01fa:
            if (r1 != 0) goto L_0x0215
            java.lang.String r20 = com.bonree.sdk.agent.engine.external.FastJsonInstrumentation.toJSONString(r4)     // Catch:{ all -> 0x02fe }
            r3 = 0
            r1 = r23
            r2 = r24
            r14 = r4
            r4 = r25
            r21 = r5
            r5 = r20
            r22 = r6
            r6 = r21
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x02fe }
            goto L_0x0232
        L_0x0215:
            r14 = r4
            r21 = r5
            r22 = r6
            r3 = r21
            goto L_0x0233
        L_0x021d:
            r14 = r4
            r21 = r5
            r22 = r6
            r3 = 0
            r5 = r14
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x02fe }
            r1 = r23
            r2 = r24
            r4 = r25
            r6 = r21
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x02fe }
        L_0x0232:
            r3 = r1
        L_0x0233:
            if (r3 != 0) goto L_0x0244
            int r1 = r11.features     // Catch:{ all -> 0x02fe }
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ all -> 0x02fe }
            boolean r1 = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(r1, r10, r2)     // Catch:{ all -> 0x02fe }
            if (r1 != 0) goto L_0x0244
        L_0x023f:
            r6 = r22
            r14 = 0
            goto L_0x00a1
        L_0x0244:
            boolean r1 = r14 instanceof java.lang.String     // Catch:{ all -> 0x02fe }
            r2 = 44
            if (r1 == 0) goto L_0x0261
            r4 = r14
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x02fe }
            if (r18 != 0) goto L_0x0252
            r11.write((int) r2)     // Catch:{ all -> 0x02fe }
        L_0x0252:
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ all -> 0x02fe }
            boolean r1 = r11.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ all -> 0x02fe }
            if (r1 == 0) goto L_0x025d
            r24.println()     // Catch:{ all -> 0x02fe }
        L_0x025d:
            r11.writeFieldName(r4, r15)     // Catch:{ all -> 0x02fe }
            goto L_0x0282
        L_0x0261:
            if (r18 != 0) goto L_0x0266
            r11.write((int) r2)     // Catch:{ all -> 0x02fe }
        L_0x0266:
            int r1 = NON_STRINGKEY_AS_STRING     // Catch:{ all -> 0x02fe }
            boolean r1 = r11.isEnabled((int) r1)     // Catch:{ all -> 0x02fe }
            if (r1 == 0) goto L_0x027a
            boolean r1 = r14 instanceof java.lang.Enum     // Catch:{ all -> 0x02fe }
            if (r1 != 0) goto L_0x027a
            java.lang.String r1 = com.bonree.sdk.agent.engine.external.FastJsonInstrumentation.toJSONString(r14)     // Catch:{ all -> 0x02fe }
            r8.write((java.lang.String) r1)     // Catch:{ all -> 0x02fe }
            goto L_0x027d
        L_0x027a:
            r8.write((java.lang.Object) r14)     // Catch:{ all -> 0x02fe }
        L_0x027d:
            r1 = 58
            r11.write((int) r1)     // Catch:{ all -> 0x02fe }
        L_0x0282:
            if (r3 != 0) goto L_0x028e
            r11.writeNull()     // Catch:{ all -> 0x02fe }
            r6 = r22
        L_0x0289:
            r14 = 0
            r18 = 0
            goto L_0x00a1
        L_0x028e:
            java.lang.Class r1 = r3.getClass()     // Catch:{ all -> 0x02fe }
            r2 = r22
            if (r1 == r2) goto L_0x029d
            com.alibaba.fastjson.serializer.ObjectSerializer r19 = r8.getObjectWriter(r1)     // Catch:{ all -> 0x02fe }
            r18 = r1
            goto L_0x029f
        L_0x029d:
            r18 = r2
        L_0x029f:
            r6 = r19
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ all -> 0x02fe }
            boolean r1 = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(r10, r1)     // Catch:{ all -> 0x02fe }
            if (r1 == 0) goto L_0x02d0
            boolean r1 = r6 instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer     // Catch:{ all -> 0x02fe }
            if (r1 == 0) goto L_0x02d0
            boolean r1 = r9 instanceof java.lang.reflect.ParameterizedType     // Catch:{ all -> 0x02fe }
            if (r1 == 0) goto L_0x02c0
            r1 = r9
            java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1     // Catch:{ all -> 0x02fe }
            java.lang.reflect.Type[] r1 = r1.getActualTypeArguments()     // Catch:{ all -> 0x02fe }
            int r2 = r1.length     // Catch:{ all -> 0x02fe }
            r4 = 2
            if (r2 != r4) goto L_0x02c0
            r1 = r1[r15]     // Catch:{ all -> 0x02fe }
            r5 = r1
            goto L_0x02c2
        L_0x02c0:
            r5 = r17
        L_0x02c2:
            r1 = r6
            com.alibaba.fastjson.serializer.JavaBeanSerializer r1 = (com.alibaba.fastjson.serializer.JavaBeanSerializer) r1     // Catch:{ all -> 0x02fe }
            r2 = r24
            r4 = r14
            r19 = r6
            r6 = r28
            r1.writeNoneASM(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x02fe }
            goto L_0x02dd
        L_0x02d0:
            r19 = r6
            r5 = 0
            r1 = r19
            r2 = r24
            r4 = r14
            r6 = r28
            r1.write(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x02fe }
        L_0x02dd:
            r6 = r18
            goto L_0x0289
        L_0x02e0:
            r8.context = r13
            r24.decrementIdent()
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat
            boolean r0 = r11.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r0)
            if (r0 == 0) goto L_0x02f6
            int r0 = r12.size()
            if (r0 <= 0) goto L_0x02f6
            r24.println()
        L_0x02f6:
            if (r29 != 0) goto L_0x02fd
            r0 = 125(0x7d, float:1.75E-43)
            r11.write((int) r0)
        L_0x02fd:
            return
        L_0x02fe:
            r0 = move-exception
            r8.context = r13
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.MapSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }
}
