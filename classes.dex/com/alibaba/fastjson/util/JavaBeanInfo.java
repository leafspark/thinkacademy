package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class JavaBeanInfo {
    public final Method buildMethod;
    public final Class<?> builderClass;
    public final Class<?> clazz;
    public final Constructor<?> creatorConstructor;
    public Type[] creatorConstructorParameterTypes;
    public String[] creatorConstructorParameters;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final FieldInfo[] fields;
    public final JSONType jsonType;
    public boolean kotlin;
    public Constructor<?> kotlinDefaultConstructor;
    public String[] orders;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;
    public final String typeKey;
    public final String typeName;

    public JavaBeanInfo(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, JSONType jSONType, List<FieldInfo> list) {
        JSONField jSONField;
        this.clazz = cls;
        this.builderClass = cls2;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.parserFeatures = TypeUtils.getParserFeatures(cls);
        this.buildMethod = method2;
        this.jsonType = jSONType;
        if (jSONType != null) {
            String typeName2 = jSONType.typeName();
            String typeKey2 = jSONType.typeKey();
            this.typeKey = typeKey2.length() <= 0 ? null : typeKey2;
            if (typeName2.length() != 0) {
                this.typeName = typeName2;
            } else {
                this.typeName = cls.getName();
            }
            String[] orders2 = jSONType.orders();
            this.orders = orders2.length == 0 ? null : orders2;
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            this.orders = null;
        }
        FieldInfo[] fieldInfoArr = new FieldInfo[list.size()];
        this.fields = fieldInfoArr;
        list.toArray(fieldInfoArr);
        FieldInfo[] fieldInfoArr2 = new FieldInfo[fieldInfoArr.length];
        boolean z = false;
        if (this.orders != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (FieldInfo fieldInfo : fieldInfoArr) {
                linkedHashMap.put(fieldInfo.name, fieldInfo);
            }
            int i = 0;
            for (String str : this.orders) {
                FieldInfo fieldInfo2 = (FieldInfo) linkedHashMap.get(str);
                if (fieldInfo2 != null) {
                    fieldInfoArr2[i] = fieldInfo2;
                    linkedHashMap.remove(str);
                    i++;
                }
            }
            for (FieldInfo fieldInfo3 : linkedHashMap.values()) {
                fieldInfoArr2[i] = fieldInfo3;
                i++;
            }
        } else {
            System.arraycopy(fieldInfoArr, 0, fieldInfoArr2, 0, fieldInfoArr.length);
            Arrays.sort(fieldInfoArr2);
        }
        this.sortedFields = Arrays.equals(this.fields, fieldInfoArr2) ? this.fields : fieldInfoArr2;
        if (constructor != null) {
            this.defaultConstructorParameterSize = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.defaultConstructorParameterSize = method.getParameterTypes().length;
        } else {
            this.defaultConstructorParameterSize = 0;
        }
        if (constructor2 != null) {
            this.creatorConstructorParameterTypes = constructor2.getParameterTypes();
            boolean isKotlin = TypeUtils.isKotlin(cls);
            this.kotlin = isKotlin;
            if (isKotlin) {
                this.creatorConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                try {
                    this.kotlinDefaultConstructor = cls.getConstructor(new Class[0]);
                } catch (Throwable unused) {
                }
                Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations((Constructor) constructor2);
                int i2 = 0;
                while (i2 < this.creatorConstructorParameters.length && i2 < parameterAnnotations.length) {
                    Annotation[] annotationArr = parameterAnnotations[i2];
                    int length = annotationArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            jSONField = null;
                            break;
                        }
                        Annotation annotation = annotationArr[i3];
                        if (annotation instanceof JSONField) {
                            jSONField = (JSONField) annotation;
                            break;
                        }
                        i3++;
                    }
                    if (jSONField != null) {
                        String name = jSONField.name();
                        if (name.length() > 0) {
                            this.creatorConstructorParameters[i2] = name;
                        }
                    }
                    i2++;
                }
                return;
            }
            if (this.creatorConstructorParameterTypes.length == this.fields.length) {
                int i4 = 0;
                while (true) {
                    Type[] typeArr = this.creatorConstructorParameterTypes;
                    if (i4 >= typeArr.length) {
                        z = true;
                        break;
                    } else if (typeArr[i4] != this.fields[i4].fieldClass) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            if (!z) {
                this.creatorConstructorParameters = ASMUtils.lookupParameterNames(constructor2);
            }
        }
    }

    private static FieldInfo getField(List<FieldInfo> list, String str) {
        for (FieldInfo next : list) {
            if (next.name.equals(str)) {
                return next;
            }
            Field field = next.field;
            if (field != null && next.getAnnotation() != null && field.getName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    static boolean add(List<FieldInfo> list, FieldInfo fieldInfo) {
        int size = list.size() - 1;
        while (size >= 0) {
            FieldInfo fieldInfo2 = list.get(size);
            if (!fieldInfo2.name.equals(fieldInfo.name) || (fieldInfo2.getOnly && !fieldInfo.getOnly)) {
                size--;
            } else if (fieldInfo2.fieldClass.isAssignableFrom(fieldInfo.fieldClass)) {
                list.set(size, fieldInfo);
                return true;
            } else if (fieldInfo2.compareTo(fieldInfo) >= 0) {
                return false;
            } else {
                list.set(size, fieldInfo);
                return true;
            }
        }
        list.add(fieldInfo);
        return true;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy) {
        return build(cls, type, propertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean, false);
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2) {
        return build(cls, type, propertyNamingStrategy, z, z2, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v125, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v126, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v128, resolved type: java.lang.Class<?>} */
    /* JADX WARNING: type inference failed for: r1v38, types: [java.lang.annotation.Annotation] */
    /* JADX WARNING: type inference failed for: r0v97, types: [java.lang.annotation.Annotation] */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0269, code lost:
        r7 = r1;
        r21 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r0 = r14.naming();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x092e, code lost:
        if (r1.deserialize() == false) goto L_0x093e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x03be  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x05b5  */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x0863  */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x0993  */
    /* JADX WARNING: Removed duplicated region for block: B:455:0x0849 A[EDGE_INSN: B:455:0x0849->B:368:0x0849 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.fastjson.util.JavaBeanInfo build(java.lang.Class<?> r41, java.lang.reflect.Type r42, com.alibaba.fastjson.PropertyNamingStrategy r43, boolean r44, boolean r45, boolean r46) {
        /*
            r12 = r41
            r13 = r42
            r9 = r46
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r0 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r12, r0)
            r14 = r0
            com.alibaba.fastjson.annotation.JSONType r14 = (com.alibaba.fastjson.annotation.JSONType) r14
            if (r14 == 0) goto L_0x001d
            com.alibaba.fastjson.PropertyNamingStrategy r0 = r14.naming()
            if (r0 == 0) goto L_0x001d
            com.alibaba.fastjson.PropertyNamingStrategy r1 = com.alibaba.fastjson.PropertyNamingStrategy.CamelCase
            if (r0 == r1) goto L_0x001d
            r15 = r0
            goto L_0x001f
        L_0x001d:
            r15 = r43
        L_0x001f:
            java.lang.Class r11 = getBuilderClass(r12, r14)
            java.lang.reflect.Field[] r10 = r41.getDeclaredFields()
            java.lang.reflect.Method[] r8 = r41.getMethods()
            boolean r16 = com.alibaba.fastjson.util.TypeUtils.isKotlin(r41)
            java.lang.reflect.Constructor[] r0 = r41.getDeclaredConstructors()
            r17 = 0
            r7 = 1
            if (r16 == 0) goto L_0x003f
            int r1 = r0.length
            if (r1 != r7) goto L_0x003c
            goto L_0x003f
        L_0x003c:
            r18 = r17
            goto L_0x0050
        L_0x003f:
            if (r11 != 0) goto L_0x0046
            java.lang.reflect.Constructor r1 = getDefaultConstructor(r12, r0)
            goto L_0x004e
        L_0x0046:
            java.lang.reflect.Constructor[] r1 = r11.getDeclaredConstructors()
            java.lang.reflect.Constructor r1 = getDefaultConstructor(r11, r1)
        L_0x004e:
            r18 = r1
        L_0x0050:
            r19 = 0
            r20 = 0
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            if (r44 == 0) goto L_0x007d
            r0 = r12
        L_0x005c:
            if (r0 == 0) goto L_0x006a
            java.lang.reflect.Field[] r1 = r0.getDeclaredFields()
            computeFields(r12, r13, r15, r6, r1)
            java.lang.Class r0 = r0.getSuperclass()
            goto L_0x005c
        L_0x006a:
            com.alibaba.fastjson.util.JavaBeanInfo r9 = new com.alibaba.fastjson.util.JavaBeanInfo
            r4 = 0
            r0 = r9
            r1 = r41
            r2 = r11
            r3 = r18
            r5 = r20
            r8 = r6
            r6 = r19
            r7 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x007d:
            boolean r1 = r41.isInterface()
            if (r1 != 0) goto L_0x0090
            int r1 = r41.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isAbstract(r1)
            if (r1 == 0) goto L_0x008e
            goto L_0x0090
        L_0x008e:
            r1 = 0
            goto L_0x0091
        L_0x0090:
            r1 = r7
        L_0x0091:
            if (r18 != 0) goto L_0x0095
            if (r11 == 0) goto L_0x0097
        L_0x0095:
            if (r1 == 0) goto L_0x03d5
        L_0x0097:
            java.lang.reflect.Constructor r21 = getCreatorConstructor(r0)
            if (r21 == 0) goto L_0x0164
            if (r1 != 0) goto L_0x0164
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r21)
            java.lang.Class[] r9 = r21.getParameterTypes()
            int r0 = r9.length
            if (r0 <= 0) goto L_0x015e
            java.lang.annotation.Annotation[][] r22 = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations((java.lang.reflect.Constructor) r21)
            r0 = r17
            r2 = 0
        L_0x00b0:
            int r1 = r9.length
            if (r2 >= r1) goto L_0x015e
            r1 = r22[r2]
            int r3 = r1.length
            r4 = 0
        L_0x00b7:
            if (r4 >= r3) goto L_0x00c6
            r5 = r1[r4]
            boolean r7 = r5 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r7 == 0) goto L_0x00c2
            com.alibaba.fastjson.annotation.JSONField r5 = (com.alibaba.fastjson.annotation.JSONField) r5
            goto L_0x00c8
        L_0x00c2:
            int r4 = r4 + 1
            r7 = 1
            goto L_0x00b7
        L_0x00c6:
            r5 = r17
        L_0x00c8:
            r3 = r9[r2]
            java.lang.reflect.Type[] r1 = r21.getGenericParameterTypes()
            r4 = r1[r2]
            if (r5 == 0) goto L_0x00f3
            java.lang.String r1 = r5.name()
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r1, r10)
            int r7 = r5.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r25 = r5.serialzeFeatures()
            int r25 = com.alibaba.fastjson.serializer.SerializerFeature.of(r25)
            com.alibaba.fastjson.parser.Feature[] r26 = r5.parseFeatures()
            int r26 = com.alibaba.fastjson.parser.Feature.of(r26)
            java.lang.String r5 = r5.name()
            goto L_0x00fb
        L_0x00f3:
            r1 = r17
            r5 = r1
            r7 = 0
            r25 = 0
            r26 = 0
        L_0x00fb:
            if (r5 == 0) goto L_0x0103
            int r27 = r5.length()
            if (r27 != 0) goto L_0x010b
        L_0x0103:
            if (r0 != 0) goto L_0x0109
            java.lang.String[] r0 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r21)
        L_0x0109:
            r5 = r0[r2]
        L_0x010b:
            if (r1 != 0) goto L_0x012a
            if (r0 != 0) goto L_0x011a
            if (r16 == 0) goto L_0x0116
            java.lang.String[] r0 = com.alibaba.fastjson.util.TypeUtils.getKoltinConstructorParameters(r41)
            goto L_0x011a
        L_0x0116:
            java.lang.String[] r0 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r21)
        L_0x011a:
            r46 = r1
            int r1 = r0.length
            if (r1 <= r2) goto L_0x012c
            r1 = r0[r2]
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r1, r10)
            r27 = r0
            r28 = r1
            goto L_0x0130
        L_0x012a:
            r46 = r1
        L_0x012c:
            r28 = r46
            r27 = r0
        L_0x0130:
            com.alibaba.fastjson.util.FieldInfo r1 = new com.alibaba.fastjson.util.FieldInfo
            r0 = r1
            r46 = r9
            r9 = r1
            r1 = r5
            r29 = r2
            r2 = r41
            r5 = 3
            r13 = 2
            r5 = r28
            r13 = r6
            r6 = r7
            r23 = r15
            r15 = 1
            r7 = r25
            r15 = r8
            r8 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            add(r13, r9)
            int r2 = r29 + 1
            r9 = r46
            r6 = r13
            r8 = r15
            r15 = r23
            r0 = r27
            r7 = 1
            r13 = r42
            goto L_0x00b0
        L_0x015e:
            r13 = r6
            r23 = r15
            r15 = r8
            goto L_0x03db
        L_0x0164:
            r13 = r6
            r23 = r15
            r15 = r8
            java.lang.reflect.Method r20 = getFactoryMethod(r12, r15, r9)
            if (r20 == 0) goto L_0x0220
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r20)
            java.lang.Class[] r8 = r20.getParameterTypes()
            int r0 = r8.length
            if (r0 <= 0) goto L_0x03db
            java.lang.annotation.Annotation[][] r15 = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations((java.lang.reflect.Method) r20)
            r0 = r17
            r7 = 0
        L_0x017f:
            int r1 = r8.length
            if (r7 >= r1) goto L_0x020f
            r1 = r15[r7]
            int r2 = r1.length
            r5 = 0
        L_0x0186:
            if (r5 >= r2) goto L_0x0194
            r3 = r1[r5]
            boolean r4 = r3 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r4 == 0) goto L_0x0191
            com.alibaba.fastjson.annotation.JSONField r3 = (com.alibaba.fastjson.annotation.JSONField) r3
            goto L_0x0196
        L_0x0191:
            int r5 = r5 + 1
            goto L_0x0186
        L_0x0194:
            r3 = r17
        L_0x0196:
            if (r3 != 0) goto L_0x01a9
            if (r9 == 0) goto L_0x01a1
            boolean r1 = com.alibaba.fastjson.util.TypeUtils.isJacksonCreator(r20)
            if (r1 == 0) goto L_0x01a1
            goto L_0x01a9
        L_0x01a1:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "illegal json creator"
            r0.<init>(r1)
            throw r0
        L_0x01a9:
            if (r3 == 0) goto L_0x01c9
            java.lang.String r1 = r3.name()
            int r2 = r3.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r3.serialzeFeatures()
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.of(r4)
            com.alibaba.fastjson.parser.Feature[] r3 = r3.parseFeatures()
            int r3 = com.alibaba.fastjson.parser.Feature.of(r3)
            r6 = r2
            r18 = r3
            r16 = r4
            goto L_0x01d0
        L_0x01c9:
            r1 = r17
            r6 = 0
            r16 = 0
            r18 = 0
        L_0x01d0:
            if (r1 == 0) goto L_0x01dc
            int r2 = r1.length()
            if (r2 != 0) goto L_0x01d9
            goto L_0x01dc
        L_0x01d9:
            r19 = r0
            goto L_0x01e5
        L_0x01dc:
            if (r0 != 0) goto L_0x01e2
            java.lang.String[] r0 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r20)
        L_0x01e2:
            r1 = r0[r7]
            goto L_0x01d9
        L_0x01e5:
            r3 = r8[r7]
            java.lang.reflect.Type[] r0 = r20.getGenericParameterTypes()
            r4 = r0[r7]
            java.lang.reflect.Field r5 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r1, r10)
            com.alibaba.fastjson.util.FieldInfo r2 = new com.alibaba.fastjson.util.FieldInfo
            r0 = r2
            r9 = r2
            r2 = r41
            r21 = r7
            r7 = r16
            r16 = r8
            r8 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            add(r13, r9)
            int r7 = r21 + 1
            r9 = r46
            r8 = r16
            r0 = r19
            goto L_0x017f
        L_0x020f:
            com.alibaba.fastjson.util.JavaBeanInfo r9 = new com.alibaba.fastjson.util.JavaBeanInfo
            r3 = 0
            r4 = 0
            r6 = 0
            r0 = r9
            r1 = r41
            r2 = r11
            r5 = r20
            r7 = r14
            r8 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x0220:
            if (r1 != 0) goto L_0x03db
            java.lang.String r9 = r41.getName()
            if (r16 == 0) goto L_0x023c
            int r1 = r0.length
            if (r1 <= 0) goto L_0x023c
            java.lang.String[] r1 = com.alibaba.fastjson.util.TypeUtils.getKoltinConstructorParameters(r41)
            java.lang.reflect.Constructor r0 = com.alibaba.fastjson.util.TypeUtils.getKoltinConstructor(r0, r1)
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r0)
            r21 = r0
            r7 = r1
        L_0x0239:
            r8 = 0
            goto L_0x02e4
        L_0x023c:
            int r1 = r0.length
            r2 = r17
            r5 = 0
        L_0x0240:
            if (r5 >= r1) goto L_0x02e2
            r3 = r0[r5]
            java.lang.Class[] r4 = r3.getParameterTypes()
            java.lang.String r6 = "org.springframework.security.web.authentication.WebAuthenticationDetails"
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L_0x026d
            int r6 = r4.length
            r7 = 2
            if (r6 != r7) goto L_0x026d
            r8 = 0
            r6 = r4[r8]
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            if (r6 != r7) goto L_0x026d
            r6 = 1
            r7 = r4[r6]
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            if (r7 != r8) goto L_0x026d
            r3.setAccessible(r6)
            java.lang.String[] r1 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r3)
        L_0x0269:
            r7 = r1
            r21 = r3
            goto L_0x0239
        L_0x026d:
            java.lang.String r6 = "org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken"
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L_0x029c
            int r6 = r4.length
            r8 = 3
            if (r6 != r8) goto L_0x029c
            r6 = 0
            r7 = r4[r6]
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            if (r7 != r6) goto L_0x029c
            r6 = 1
            r7 = r4[r6]
            java.lang.Class<java.lang.Object> r8 = java.lang.Object.class
            if (r7 != r8) goto L_0x029c
            r7 = 2
            r8 = r4[r7]
            java.lang.Class<java.util.Collection> r7 = java.util.Collection.class
            if (r8 != r7) goto L_0x029c
            r3.setAccessible(r6)
            java.lang.String r0 = "principal"
            java.lang.String r1 = "credentials"
            java.lang.String r2 = "authorities"
            java.lang.String[] r1 = new java.lang.String[]{r0, r1, r2}
            goto L_0x0269
        L_0x029c:
            java.lang.String r6 = "org.springframework.security.core.authority.SimpleGrantedAuthority"
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L_0x02b9
            int r6 = r4.length
            r7 = 1
            r8 = 0
            if (r6 != r7) goto L_0x02bb
            r4 = r4[r8]
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            if (r4 != r6) goto L_0x02bb
            java.lang.String r0 = "authority"
            java.lang.String[] r1 = new java.lang.String[]{r0}
            r7 = r1
            r21 = r3
            goto L_0x02e4
        L_0x02b9:
            r7 = 1
            r8 = 0
        L_0x02bb:
            int r4 = r3.getModifiers()
            r4 = r4 & r7
            if (r4 == 0) goto L_0x02c4
            r7 = 1
            goto L_0x02c5
        L_0x02c4:
            r7 = r8
        L_0x02c5:
            if (r7 != 0) goto L_0x02c8
            goto L_0x02de
        L_0x02c8:
            java.lang.String[] r4 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r3)
            if (r4 == 0) goto L_0x02de
            int r6 = r4.length
            if (r6 != 0) goto L_0x02d2
            goto L_0x02de
        L_0x02d2:
            if (r21 == 0) goto L_0x02db
            if (r2 == 0) goto L_0x02db
            int r6 = r4.length
            int r7 = r2.length
            if (r6 > r7) goto L_0x02db
            goto L_0x02de
        L_0x02db:
            r21 = r3
            r2 = r4
        L_0x02de:
            int r5 = r5 + 1
            goto L_0x0240
        L_0x02e2:
            r8 = 0
            r7 = r2
        L_0x02e4:
            if (r7 == 0) goto L_0x02ec
            java.lang.Class[] r0 = r21.getParameterTypes()
            r6 = r0
            goto L_0x02ee
        L_0x02ec:
            r6 = r17
        L_0x02ee:
            if (r7 == 0) goto L_0x03be
            int r0 = r6.length
            int r1 = r7.length
            if (r0 != r1) goto L_0x03be
            java.lang.annotation.Annotation[][] r22 = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations((java.lang.reflect.Constructor) r21)
            r5 = r8
        L_0x02f9:
            int r0 = r6.length
            if (r5 >= r0) goto L_0x039f
            r0 = r22[r5]
            r1 = r7[r5]
            int r2 = r0.length
            r3 = r8
        L_0x0302:
            if (r3 >= r2) goto L_0x0311
            r4 = r0[r3]
            boolean r8 = r4 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r8 == 0) goto L_0x030d
            com.alibaba.fastjson.annotation.JSONField r4 = (com.alibaba.fastjson.annotation.JSONField) r4
            goto L_0x0313
        L_0x030d:
            int r3 = r3 + 1
            r8 = 0
            goto L_0x0302
        L_0x0311:
            r4 = r17
        L_0x0313:
            r3 = r6[r5]
            java.lang.reflect.Type[] r0 = r21.getGenericParameterTypes()
            r8 = r0[r5]
            java.lang.reflect.Field r2 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r1, r10)
            if (r2 == 0) goto L_0x032c
            if (r4 != 0) goto L_0x032c
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r0 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r2, r0)
            r4 = r0
            com.alibaba.fastjson.annotation.JSONField r4 = (com.alibaba.fastjson.annotation.JSONField) r4
        L_0x032c:
            if (r4 != 0) goto L_0x0350
            java.lang.String r0 = "org.springframework.security.core.userdetails.User"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0349
            java.lang.String r0 = "password"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0349
            com.alibaba.fastjson.parser.Feature r0 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty
            int r0 = r0.mask
            r27 = r0
            r25 = 0
            r26 = 0
            goto L_0x0375
        L_0x0349:
            r25 = 0
            r26 = 0
            r27 = 0
            goto L_0x0375
        L_0x0350:
            java.lang.String r0 = r4.name()
            int r25 = r0.length()
            if (r25 == 0) goto L_0x035b
            r1 = r0
        L_0x035b:
            int r0 = r4.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r25 = r4.serialzeFeatures()
            int r25 = com.alibaba.fastjson.serializer.SerializerFeature.of(r25)
            com.alibaba.fastjson.parser.Feature[] r4 = r4.parseFeatures()
            int r4 = com.alibaba.fastjson.parser.Feature.of(r4)
            r27 = r4
            r26 = r25
            r25 = r0
        L_0x0375:
            com.alibaba.fastjson.util.FieldInfo r4 = new com.alibaba.fastjson.util.FieldInfo
            r0 = r4
            r28 = r2
            r2 = r41
            r46 = r9
            r9 = r4
            r4 = r8
            r29 = r5
            r5 = r28
            r28 = r6
            r6 = r25
            r25 = r7
            r7 = r26
            r8 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            add(r13, r9)
            int r5 = r29 + 1
            r9 = r46
            r7 = r25
            r6 = r28
            r8 = 0
            goto L_0x02f9
        L_0x039f:
            if (r16 != 0) goto L_0x03db
            java.lang.String r0 = r41.getName()
            java.lang.String r1 = "javax.servlet.http.Cookie"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03db
            com.alibaba.fastjson.util.JavaBeanInfo r9 = new com.alibaba.fastjson.util.JavaBeanInfo
            r3 = 0
            r5 = 0
            r6 = 0
            r0 = r9
            r1 = r41
            r2 = r11
            r4 = r21
            r7 = r14
            r8 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x03be:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "default constructor not found. "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x03d5:
            r13 = r6
            r23 = r15
            r15 = r8
            r21 = r17
        L_0x03db:
            if (r18 == 0) goto L_0x03e0
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r18)
        L_0x03e0:
            java.lang.String r9 = "set"
            if (r11 == 0) goto L_0x05a8
            java.lang.Class<com.alibaba.fastjson.annotation.JSONPOJOBuilder> r0 = com.alibaba.fastjson.annotation.JSONPOJOBuilder.class
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r11, r0)
            com.alibaba.fastjson.annotation.JSONPOJOBuilder r0 = (com.alibaba.fastjson.annotation.JSONPOJOBuilder) r0
            if (r0 == 0) goto L_0x03f3
            java.lang.String r0 = r0.withPrefix()
            goto L_0x03f5
        L_0x03f3:
            r0 = r17
        L_0x03f5:
            if (r0 != 0) goto L_0x03fa
            java.lang.String r0 = "with"
        L_0x03fa:
            r8 = r0
            java.lang.reflect.Method[] r7 = r11.getMethods()
            int r6 = r7.length
            r5 = 0
        L_0x0401:
            if (r5 >= r6) goto L_0x0565
            r2 = r7[r5]
            int r0 = r2.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            if (r0 == 0) goto L_0x0420
        L_0x040f:
            r29 = r5
            r30 = r6
            r31 = r7
            r26 = r8
            r36 = r9
            r34 = r10
            r27 = r14
            r14 = r11
            goto L_0x0554
        L_0x0420:
            java.lang.Class r0 = r2.getReturnType()
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x042b
            goto L_0x040f
        L_0x042b:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r0 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Method) r2, r0)
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            if (r0 != 0) goto L_0x0439
            com.alibaba.fastjson.annotation.JSONField r0 = com.alibaba.fastjson.util.TypeUtils.getSuperMethodAnnotation(r12, r2)
        L_0x0439:
            r16 = r0
            if (r16 == 0) goto L_0x04b3
            boolean r0 = r16.deserialize()
            if (r0 != 0) goto L_0x0444
            goto L_0x040f
        L_0x0444:
            int r22 = r16.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r16.serialzeFeatures()
            int r25 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0)
            com.alibaba.fastjson.parser.Feature[] r0 = r16.parseFeatures()
            int r26 = com.alibaba.fastjson.parser.Feature.of(r0)
            java.lang.String r0 = r16.name()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x049d
            java.lang.String r1 = r16.name()
            com.alibaba.fastjson.util.FieldInfo r4 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r27 = 0
            r28 = 0
            r0 = r4
            r32 = r4
            r4 = r41
            r29 = r5
            r5 = r42
            r30 = r6
            r6 = r22
            r31 = r7
            r7 = r25
            r43 = r8
            r8 = r26
            r33 = r9
            r9 = r16
            r34 = r10
            r10 = r27
            r27 = r14
            r14 = r11
            r11 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r32
            add(r13, r0)
            r26 = r43
            r36 = r33
            goto L_0x0554
        L_0x049d:
            r29 = r5
            r30 = r6
            r31 = r7
            r43 = r8
            r33 = r9
            r34 = r10
            r27 = r14
            r14 = r11
            r6 = r22
            r7 = r25
            r8 = r26
            goto L_0x04c5
        L_0x04b3:
            r29 = r5
            r30 = r6
            r31 = r7
            r43 = r8
            r33 = r9
            r34 = r10
            r27 = r14
            r14 = r11
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x04c5:
            java.lang.String r0 = r2.getName()
            r11 = r33
            boolean r1 = r0.startsWith(r11)
            if (r1 == 0) goto L_0x04e2
            int r1 = r0.length()
            r10 = 3
            if (r1 <= r10) goto L_0x04e3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r0 = r0.substring(r10)
            r1.<init>(r0)
            goto L_0x04ee
        L_0x04e2:
            r10 = 3
        L_0x04e3:
            int r1 = r43.length()
            if (r1 != 0) goto L_0x04f2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
        L_0x04ee:
            r9 = r43
        L_0x04f0:
            r5 = 0
            goto L_0x0518
        L_0x04f2:
            r9 = r43
            boolean r1 = r0.startsWith(r9)
            if (r1 != 0) goto L_0x04ff
        L_0x04fa:
            r26 = r9
            r36 = r11
            goto L_0x0554
        L_0x04ff:
            int r1 = r0.length()
            int r3 = r9.length()
            if (r1 > r3) goto L_0x050a
            goto L_0x04fa
        L_0x050a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r3 = r9.length()
            java.lang.String r0 = r0.substring(r3)
            r1.<init>(r0)
            goto L_0x04f0
        L_0x0518:
            char r0 = r1.charAt(r5)
            int r3 = r9.length()
            if (r3 == 0) goto L_0x0529
            boolean r3 = java.lang.Character.isUpperCase(r0)
            if (r3 != 0) goto L_0x0529
            goto L_0x04fa
        L_0x0529:
            char r0 = java.lang.Character.toLowerCase(r0)
            r1.setCharAt(r5, r0)
            java.lang.String r1 = r1.toString()
            com.alibaba.fastjson.util.FieldInfo r4 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r22 = 0
            r25 = 0
            r0 = r4
            r35 = r4
            r4 = r41
            r5 = r42
            r26 = r9
            r9 = r16
            r10 = r22
            r36 = r11
            r11 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r35
            add(r13, r0)
        L_0x0554:
            int r5 = r29 + 1
            r11 = r14
            r8 = r26
            r14 = r27
            r6 = r30
            r7 = r31
            r10 = r34
            r9 = r36
            goto L_0x0401
        L_0x0565:
            r36 = r9
            r34 = r10
            r27 = r14
            r14 = r11
            if (r14 == 0) goto L_0x05af
            java.lang.Class<com.alibaba.fastjson.annotation.JSONPOJOBuilder> r0 = com.alibaba.fastjson.annotation.JSONPOJOBuilder.class
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r14, r0)
            com.alibaba.fastjson.annotation.JSONPOJOBuilder r0 = (com.alibaba.fastjson.annotation.JSONPOJOBuilder) r0
            if (r0 == 0) goto L_0x057d
            java.lang.String r0 = r0.buildMethod()
            goto L_0x057f
        L_0x057d:
            r0 = r17
        L_0x057f:
            if (r0 == 0) goto L_0x0587
            int r1 = r0.length()
            if (r1 != 0) goto L_0x0589
        L_0x0587:
            java.lang.String r0 = "build"
        L_0x0589:
            r11 = 0
            java.lang.Class[] r1 = new java.lang.Class[r11]     // Catch:{ NoSuchMethodException | SecurityException -> 0x0590 }
            java.lang.reflect.Method r19 = r14.getMethod(r0, r1)     // Catch:{ NoSuchMethodException | SecurityException -> 0x0590 }
        L_0x0590:
            if (r19 != 0) goto L_0x059a
            java.lang.String r0 = "create"
            java.lang.Class[] r1 = new java.lang.Class[r11]     // Catch:{ NoSuchMethodException | SecurityException -> 0x059a }
            java.lang.reflect.Method r19 = r14.getMethod(r0, r1)     // Catch:{ NoSuchMethodException | SecurityException -> 0x059a }
        L_0x059a:
            if (r19 == 0) goto L_0x05a0
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r19)
            goto L_0x05b0
        L_0x05a0:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "buildMethod not found."
            r0.<init>(r1)
            throw r0
        L_0x05a8:
            r36 = r9
            r34 = r10
            r27 = r14
            r14 = r11
        L_0x05af:
            r11 = 0
        L_0x05b0:
            int r10 = r15.length
            r9 = r11
        L_0x05b2:
            r8 = 4
            if (r9 >= r10) goto L_0x0849
            r2 = r15[r9]
            r6 = 0
            r7 = 0
            r16 = 0
            java.lang.String r0 = r2.getName()
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
            if (r1 == 0) goto L_0x05dd
        L_0x05c9:
            r29 = r9
            r30 = r10
            r31 = r11
            r45 = r14
            r25 = r15
            r14 = r23
            r33 = r36
            r26 = 1
            r28 = 2
            goto L_0x0839
        L_0x05dd:
            java.lang.Class r1 = r2.getReturnType()
            java.lang.Class r3 = java.lang.Void.TYPE
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x05f4
            java.lang.Class r3 = r2.getDeclaringClass()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x05f4
            goto L_0x05c9
        L_0x05f4:
            java.lang.Class r1 = r2.getDeclaringClass()
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            if (r1 != r3) goto L_0x05fd
            goto L_0x05c9
        L_0x05fd:
            java.lang.Class[] r1 = r2.getParameterTypes()
            int r3 = r1.length
            if (r3 == 0) goto L_0x05c9
            int r3 = r1.length
            r5 = 2
            if (r3 <= r5) goto L_0x061c
            r28 = r5
            r29 = r9
            r30 = r10
            r31 = r11
            r45 = r14
            r25 = r15
        L_0x0614:
            r14 = r23
            r33 = r36
            r26 = 1
            goto L_0x0839
        L_0x061c:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r3 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r3 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Method) r2, r3)
            r22 = r3
            com.alibaba.fastjson.annotation.JSONField r22 = (com.alibaba.fastjson.annotation.JSONField) r22
            if (r22 == 0) goto L_0x0666
            int r3 = r1.length
            if (r3 != r5) goto L_0x0666
            r3 = r1[r11]
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            if (r3 != r4) goto L_0x0666
            r3 = 1
            r4 = r1[r3]
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            if (r4 != r3) goto L_0x0666
            com.alibaba.fastjson.util.FieldInfo r8 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r25 = 0
            r26 = 0
            java.lang.String r1 = ""
            r0 = r8
            r4 = r41
            r28 = r5
            r5 = r42
            r37 = r8
            r8 = r16
            r29 = r9
            r9 = r22
            r30 = r10
            r10 = r25
            r25 = r15
            r15 = r11
            r11 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r37
            add(r13, r0)
        L_0x0661:
            r45 = r14
            r31 = r15
            goto L_0x0614
        L_0x0666:
            r28 = r5
            r29 = r9
            r30 = r10
            r25 = r15
            r15 = r11
            int r3 = r1.length
            r4 = 1
            if (r3 == r4) goto L_0x067f
            r26 = r4
            r45 = r14
            r31 = r15
            r14 = r23
            r33 = r36
            goto L_0x0839
        L_0x067f:
            if (r22 != 0) goto L_0x0687
            com.alibaba.fastjson.annotation.JSONField r3 = com.alibaba.fastjson.util.TypeUtils.getSuperMethodAnnotation(r12, r2)
            r9 = r3
            goto L_0x0689
        L_0x0687:
            r9 = r22
        L_0x0689:
            if (r9 != 0) goto L_0x0692
            int r3 = r0.length()
            if (r3 >= r8) goto L_0x0692
        L_0x0691:
            goto L_0x0661
        L_0x0692:
            if (r9 == 0) goto L_0x06de
            boolean r3 = r9.deserialize()
            if (r3 != 0) goto L_0x069b
            goto L_0x0691
        L_0x069b:
            int r6 = r9.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r3 = r9.serialzeFeatures()
            int r7 = com.alibaba.fastjson.serializer.SerializerFeature.of(r3)
            com.alibaba.fastjson.parser.Feature[] r3 = r9.parseFeatures()
            int r10 = com.alibaba.fastjson.parser.Feature.of(r3)
            java.lang.String r3 = r9.name()
            int r3 = r3.length()
            if (r3 == 0) goto L_0x06dc
            java.lang.String r1 = r9.name()
            com.alibaba.fastjson.util.FieldInfo r11 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r16 = 0
            r22 = 0
            r0 = r11
            r4 = r41
            r5 = r42
            r8 = r10
            r10 = r16
            r15 = r11
            r11 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            add(r13, r15)
            r45 = r14
            r14 = r23
            r33 = r36
            goto L_0x06ef
        L_0x06dc:
            r16 = r10
        L_0x06de:
            r15 = r36
            if (r9 != 0) goto L_0x06f5
            boolean r3 = r0.startsWith(r15)
            if (r3 == 0) goto L_0x06e9
            goto L_0x06f5
        L_0x06e9:
            r45 = r14
            r33 = r15
            r14 = r23
        L_0x06ef:
            r26 = 1
            r31 = 0
            goto L_0x0839
        L_0x06f5:
            if (r14 == 0) goto L_0x06f8
            goto L_0x06e9
        L_0x06f8:
            r11 = 3
            char r3 = r0.charAt(r11)
            boolean r4 = java.lang.Character.isUpperCase(r3)
            if (r4 != 0) goto L_0x0734
            r4 = 512(0x200, float:7.175E-43)
            if (r3 <= r4) goto L_0x0708
            goto L_0x0734
        L_0x0708:
            r4 = 95
            if (r3 != r4) goto L_0x0711
            java.lang.String r0 = r0.substring(r8)
            goto L_0x075c
        L_0x0711:
            r4 = 102(0x66, float:1.43E-43)
            if (r3 != r4) goto L_0x071a
            java.lang.String r0 = r0.substring(r11)
            goto L_0x075c
        L_0x071a:
            int r3 = r0.length()
            r4 = 5
            if (r3 < r4) goto L_0x06e9
            char r3 = r0.charAt(r8)
            boolean r3 = java.lang.Character.isUpperCase(r3)
            if (r3 == 0) goto L_0x06e9
            java.lang.String r0 = r0.substring(r11)
            java.lang.String r0 = com.alibaba.fastjson.util.TypeUtils.decapitalize(r0)
            goto L_0x075c
        L_0x0734:
            boolean r3 = com.alibaba.fastjson.util.TypeUtils.compatibleWithJavaBean
            if (r3 == 0) goto L_0x0741
            java.lang.String r0 = r0.substring(r11)
            java.lang.String r0 = com.alibaba.fastjson.util.TypeUtils.decapitalize(r0)
            goto L_0x075c
        L_0x0741:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            char r4 = r0.charAt(r11)
            char r4 = java.lang.Character.toLowerCase(r4)
            r3.append(r4)
            java.lang.String r0 = r0.substring(r8)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
        L_0x075c:
            r10 = r34
            java.lang.reflect.Field r3 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r0, r10)
            if (r3 != 0) goto L_0x0794
            r8 = 0
            r1 = r1[r8]
            java.lang.Class r4 = java.lang.Boolean.TYPE
            if (r1 != r4) goto L_0x0792
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "is"
            r1.append(r3)
            char r3 = r0.charAt(r8)
            char r3 = java.lang.Character.toUpperCase(r3)
            r1.append(r3)
            r5 = 1
            java.lang.String r3 = r0.substring(r5)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r1, r10)
            r3 = r1
            goto L_0x0796
        L_0x0792:
            r5 = 1
            goto L_0x0796
        L_0x0794:
            r5 = 1
            r8 = 0
        L_0x0796:
            if (r3 == 0) goto L_0x080e
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r1 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r1 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r3, r1)
            r22 = r1
            com.alibaba.fastjson.annotation.JSONField r22 = (com.alibaba.fastjson.annotation.JSONField) r22
            if (r22 == 0) goto L_0x0800
            boolean r1 = r22.deserialize()
            if (r1 != 0) goto L_0x07b8
            r26 = r5
            r31 = r8
            r34 = r10
            r45 = r14
            r33 = r15
        L_0x07b4:
            r14 = r23
            goto L_0x0839
        L_0x07b8:
            int r6 = r22.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r1 = r22.serialzeFeatures()
            int r7 = com.alibaba.fastjson.serializer.SerializerFeature.of(r1)
            com.alibaba.fastjson.parser.Feature[] r1 = r22.parseFeatures()
            int r16 = com.alibaba.fastjson.parser.Feature.of(r1)
            java.lang.String r1 = r22.name()
            int r1 = r1.length()
            if (r1 == 0) goto L_0x0800
            java.lang.String r1 = r22.name()
            com.alibaba.fastjson.util.FieldInfo r4 = new com.alibaba.fastjson.util.FieldInfo
            r24 = 0
            r0 = r4
            r38 = r4
            r4 = r41
            r26 = r5
            r5 = r42
            r31 = r8
            r8 = r16
            r33 = r15
            r15 = r10
            r10 = r22
            r34 = r15
            r15 = r11
            r11 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r38
            add(r13, r0)
            r45 = r14
            goto L_0x07b4
        L_0x0800:
            r26 = r5
            r31 = r8
            r34 = r10
            r33 = r15
            r15 = r11
            r8 = r16
            r10 = r22
            goto L_0x081b
        L_0x080e:
            r26 = r5
            r31 = r8
            r34 = r10
            r33 = r15
            r15 = r11
            r8 = r16
            r10 = r17
        L_0x081b:
            r11 = r23
            if (r23 == 0) goto L_0x0823
            java.lang.String r0 = r11.translate(r0)
        L_0x0823:
            r1 = r0
            com.alibaba.fastjson.util.FieldInfo r5 = new com.alibaba.fastjson.util.FieldInfo
            r16 = 0
            r0 = r5
            r4 = r41
            r15 = r5
            r5 = r42
            r45 = r14
            r14 = r11
            r11 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            add(r13, r15)
        L_0x0839:
            int r9 = r29 + 1
            r23 = r14
            r15 = r25
            r10 = r30
            r11 = r31
            r36 = r33
            r14 = r45
            goto L_0x05b2
        L_0x0849:
            r31 = r11
            r45 = r14
            r14 = r23
            r26 = 1
            java.lang.reflect.Field[] r0 = r41.getFields()
            r15 = r42
            computeFields(r12, r15, r14, r13, r0)
            java.lang.reflect.Method[] r11 = r41.getMethods()
            int r10 = r11.length
            r9 = r31
        L_0x0861:
            if (r9 >= r10) goto L_0x098b
            r2 = r11[r9]
            java.lang.String r0 = r2.getName()
            int r1 = r0.length()
            if (r1 >= r8) goto L_0x087d
        L_0x086f:
            r22 = r8
            r31 = r9
            r16 = r10
            r23 = r11
            r40 = r34
            r17 = 3
            goto L_0x097f
        L_0x087d:
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
            if (r1 == 0) goto L_0x0888
            goto L_0x086f
        L_0x0888:
            if (r45 != 0) goto L_0x086f
            java.lang.String r1 = "get"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x086f
            r1 = 3
            char r3 = r0.charAt(r1)
            boolean r1 = java.lang.Character.isUpperCase(r3)
            if (r1 == 0) goto L_0x086f
            java.lang.Class[] r1 = r2.getParameterTypes()
            int r1 = r1.length
            if (r1 == 0) goto L_0x08a5
            goto L_0x086f
        L_0x08a5:
            java.lang.Class<java.util.Collection> r1 = java.util.Collection.class
            java.lang.Class r3 = r2.getReturnType()
            boolean r1 = r1.isAssignableFrom(r3)
            if (r1 != 0) goto L_0x08d5
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            java.lang.Class r3 = r2.getReturnType()
            boolean r1 = r1.isAssignableFrom(r3)
            if (r1 != 0) goto L_0x08d5
            java.lang.Class<java.util.concurrent.atomic.AtomicBoolean> r1 = java.util.concurrent.atomic.AtomicBoolean.class
            java.lang.Class r3 = r2.getReturnType()
            if (r1 == r3) goto L_0x08d5
            java.lang.Class<java.util.concurrent.atomic.AtomicInteger> r1 = java.util.concurrent.atomic.AtomicInteger.class
            java.lang.Class r3 = r2.getReturnType()
            if (r1 == r3) goto L_0x08d5
            java.lang.Class<java.util.concurrent.atomic.AtomicLong> r1 = java.util.concurrent.atomic.AtomicLong.class
            java.lang.Class r3 = r2.getReturnType()
            if (r1 != r3) goto L_0x086f
        L_0x08d5:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r1 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r1 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Method) r2, r1)
            r16 = r1
            com.alibaba.fastjson.annotation.JSONField r16 = (com.alibaba.fastjson.annotation.JSONField) r16
            if (r16 == 0) goto L_0x08e8
            boolean r1 = r16.deserialize()
            if (r1 == 0) goto L_0x08e8
            goto L_0x086f
        L_0x08e8:
            if (r16 == 0) goto L_0x08fc
            java.lang.String r1 = r16.name()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x08fc
            java.lang.String r0 = r16.name()
            r6 = r34
            r7 = 3
            goto L_0x0931
        L_0x08fc:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r7 = 3
            char r3 = r0.charAt(r7)
            char r3 = java.lang.Character.toLowerCase(r3)
            r1.append(r3)
            java.lang.String r0 = r0.substring(r8)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r6 = r34
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r0, r6)
            if (r1 == 0) goto L_0x0931
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r3 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r1 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r1, r3)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            if (r1 == 0) goto L_0x0931
            boolean r1 = r1.deserialize()
            if (r1 != 0) goto L_0x0931
            goto L_0x093e
        L_0x0931:
            if (r14 == 0) goto L_0x0937
            java.lang.String r0 = r14.translate(r0)
        L_0x0937:
            r1 = r0
            com.alibaba.fastjson.util.FieldInfo r0 = getField(r13, r1)
            if (r0 == 0) goto L_0x094b
        L_0x093e:
            r40 = r6
            r17 = r7
            r22 = r8
            r31 = r9
            r16 = r10
            r23 = r11
            goto L_0x097f
        L_0x094b:
            com.alibaba.fastjson.util.FieldInfo r5 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r17 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r0 = r5
            r4 = r41
            r39 = r5
            r5 = r42
            r40 = r6
            r6 = r17
            r17 = r7
            r7 = r22
            r22 = r8
            r8 = r23
            r31 = r9
            r9 = r16
            r16 = r10
            r10 = r24
            r23 = r11
            r11 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r39
            add(r13, r0)
        L_0x097f:
            int r9 = r31 + 1
            r10 = r16
            r8 = r22
            r11 = r23
            r34 = r40
            goto L_0x0861
        L_0x098b:
            r40 = r34
            int r0 = r13.size()
            if (r0 != 0) goto L_0x09ab
            boolean r0 = com.alibaba.fastjson.util.TypeUtils.isXmlField(r41)
            if (r0 == 0) goto L_0x099a
            goto L_0x099c
        L_0x099a:
            r26 = r44
        L_0x099c:
            if (r26 == 0) goto L_0x09ab
            r0 = r12
        L_0x099f:
            if (r0 == 0) goto L_0x09ab
            r1 = r40
            computeFields(r12, r15, r14, r13, r1)
            java.lang.Class r0 = r0.getSuperclass()
            goto L_0x099f
        L_0x09ab:
            com.alibaba.fastjson.util.JavaBeanInfo r9 = new com.alibaba.fastjson.util.JavaBeanInfo
            r0 = r9
            r1 = r41
            r2 = r45
            r3 = r18
            r4 = r21
            r5 = r20
            r6 = r19
            r7 = r27
            r8 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.JavaBeanInfo.build(java.lang.Class, java.lang.reflect.Type, com.alibaba.fastjson.PropertyNamingStrategy, boolean, boolean, boolean):com.alibaba.fastjson.util.JavaBeanInfo");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if ((java.util.Map.class.isAssignableFrom(r5) || java.util.Collection.class.isAssignableFrom(r5) || java.util.concurrent.atomic.AtomicLong.class.equals(r5) || java.util.concurrent.atomic.AtomicInteger.class.equals(r5) || java.util.concurrent.atomic.AtomicBoolean.class.equals(r5)) == false) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void computeFields(java.lang.Class<?> r18, java.lang.reflect.Type r19, com.alibaba.fastjson.PropertyNamingStrategy r20, java.util.List<com.alibaba.fastjson.util.FieldInfo> r21, java.lang.reflect.Field[] r22) {
        /*
            r0 = r20
            r1 = r22
            int r2 = r1.length
            r4 = 0
        L_0x0006:
            if (r4 >= r2) goto L_0x00d2
            r8 = r1[r4]
            int r5 = r8.getModifiers()
            r6 = r5 & 8
            if (r6 == 0) goto L_0x0016
        L_0x0012:
            r5 = r21
            goto L_0x00ce
        L_0x0016:
            r5 = r5 & 16
            r6 = 1
            if (r5 == 0) goto L_0x004e
            java.lang.Class r5 = r8.getType()
            java.lang.Class<java.util.Map> r7 = java.util.Map.class
            boolean r7 = r7.isAssignableFrom(r5)
            if (r7 != 0) goto L_0x004a
            java.lang.Class<java.util.Collection> r7 = java.util.Collection.class
            boolean r7 = r7.isAssignableFrom(r5)
            if (r7 != 0) goto L_0x004a
            java.lang.Class<java.util.concurrent.atomic.AtomicLong> r7 = java.util.concurrent.atomic.AtomicLong.class
            boolean r7 = r7.equals(r5)
            if (r7 != 0) goto L_0x004a
            java.lang.Class<java.util.concurrent.atomic.AtomicInteger> r7 = java.util.concurrent.atomic.AtomicInteger.class
            boolean r7 = r7.equals(r5)
            if (r7 != 0) goto L_0x004a
            java.lang.Class<java.util.concurrent.atomic.AtomicBoolean> r7 = java.util.concurrent.atomic.AtomicBoolean.class
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r5 = 0
            goto L_0x004b
        L_0x004a:
            r5 = r6
        L_0x004b:
            if (r5 != 0) goto L_0x004e
            goto L_0x0012
        L_0x004e:
            java.util.Iterator r5 = r21.iterator()
        L_0x0052:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x006b
            java.lang.Object r7 = r5.next()
            com.alibaba.fastjson.util.FieldInfo r7 = (com.alibaba.fastjson.util.FieldInfo) r7
            java.lang.String r7 = r7.name
            java.lang.String r9 = r8.getName()
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x0052
            goto L_0x006c
        L_0x006b:
            r6 = 0
        L_0x006c:
            if (r6 == 0) goto L_0x006f
            goto L_0x0012
        L_0x006f:
            java.lang.String r5 = r8.getName()
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r6 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r6 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r8, r6)
            r15 = r6
            com.alibaba.fastjson.annotation.JSONField r15 = (com.alibaba.fastjson.annotation.JSONField) r15
            if (r15 == 0) goto L_0x00ab
            boolean r6 = r15.deserialize()
            if (r6 != 0) goto L_0x0085
            goto L_0x0012
        L_0x0085:
            int r6 = r15.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r7 = r15.serialzeFeatures()
            int r7 = com.alibaba.fastjson.serializer.SerializerFeature.of(r7)
            com.alibaba.fastjson.parser.Feature[] r9 = r15.parseFeatures()
            int r9 = com.alibaba.fastjson.parser.Feature.of(r9)
            java.lang.String r10 = r15.name()
            int r10 = r10.length()
            if (r10 == 0) goto L_0x00a7
            java.lang.String r5 = r15.name()
        L_0x00a7:
            r11 = r6
            r12 = r7
            r13 = r9
            goto L_0x00ae
        L_0x00ab:
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x00ae:
            if (r0 == 0) goto L_0x00b4
            java.lang.String r5 = r0.translate(r5)
        L_0x00b4:
            r6 = r5
            com.alibaba.fastjson.util.FieldInfo r14 = new com.alibaba.fastjson.util.FieldInfo
            r7 = 0
            r16 = 0
            r17 = 0
            r5 = r14
            r9 = r18
            r10 = r19
            r3 = r14
            r14 = r16
            r16 = r17
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r5 = r21
            add(r5, r3)
        L_0x00ce:
            int r4 = r4 + 1
            goto L_0x0006
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.JavaBeanInfo.computeFields(java.lang.Class, java.lang.reflect.Type, com.alibaba.fastjson.PropertyNamingStrategy, java.util.List, java.lang.reflect.Field[]):void");
    }

    static Constructor<?> getDefaultConstructor(Class<?> cls, Constructor<?>[] constructorArr) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        int length = constructorArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Constructor<?> constructor2 = constructorArr[i];
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
            i++;
        }
        if (constructor != null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return constructor;
        }
        for (Constructor<?> constructor3 : constructorArr) {
            Class[] parameterTypes = constructor3.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                return constructor3;
            }
        }
        return constructor;
    }

    public static Constructor<?> getCreatorConstructor(Constructor[] constructorArr) {
        boolean z;
        Constructor<?> constructor = null;
        for (Constructor<?> constructor2 : constructorArr) {
            if (((JSONCreator) constructor2.getAnnotation(JSONCreator.class)) != null) {
                if (constructor == null) {
                    constructor = constructor2;
                } else {
                    throw new JSONException("multi-JSONCreator");
                }
            }
        }
        if (constructor != null) {
            return constructor;
        }
        for (Constructor<?> constructor3 : constructorArr) {
            Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations((Constructor) constructor3);
            if (parameterAnnotations.length != 0) {
                int length = parameterAnnotations.length;
                int i = 0;
                while (true) {
                    z = true;
                    if (i >= length) {
                        break;
                    }
                    Annotation[] annotationArr = parameterAnnotations[i];
                    int length2 = annotationArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            z = false;
                            break;
                        } else if (annotationArr[i2] instanceof JSONField) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (!z) {
                    continue;
                } else if (constructor == null) {
                    constructor = constructor3;
                } else {
                    throw new JSONException("multi-JSONCreator");
                }
            }
        }
        return constructor;
    }

    private static Method getFactoryMethod(Class<?> cls, Method[] methodArr, boolean z) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((JSONCreator) TypeUtils.getAnnotation(method2, JSONCreator.class)) != null) {
                if (method == null) {
                    method = method2;
                } else {
                    throw new JSONException("multi-JSONCreator");
                }
            }
        }
        if (method != null || !z) {
            return method;
        }
        for (Method method3 : methodArr) {
            if (TypeUtils.isJacksonCreator(method3)) {
                return method3;
            }
        }
        return method;
    }

    public static Class<?> getBuilderClass(JSONType jSONType) {
        return getBuilderClass((Class<?>) null, jSONType);
    }

    public static Class<?> getBuilderClass(Class<?> cls, JSONType jSONType) {
        Class<?> builder;
        if (cls != null && cls.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest")) {
            return TypeUtils.loadClass("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
        }
        if (jSONType == null || (builder = jSONType.builder()) == Void.class) {
            return null;
        }
        return builder;
    }
}
