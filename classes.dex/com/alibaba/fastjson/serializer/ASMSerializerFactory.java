package com.alibaba.fastjson.serializer;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ASMSerializerFactory implements Opcodes {
    static final String JSONSerializer = ASMUtils.type(JSONSerializer.class);
    static final String JavaBeanSerializer = ASMUtils.type(JavaBeanSerializer.class);
    static final String JavaBeanSerializer_desc = ("L" + ASMUtils.type(JavaBeanSerializer.class) + ";");
    static final String ObjectSerializer;
    static final String ObjectSerializer_desc;
    static final String SerialContext_desc = ASMUtils.desc((Class<?>) SerialContext.class);
    static final String SerializeFilterable_desc = ASMUtils.desc((Class<?>) SerializeFilterable.class);
    static final String SerializeWriter;
    static final String SerializeWriter_desc;
    protected final ASMClassLoader classLoader = new ASMClassLoader();
    private final AtomicLong seed = new AtomicLong();

    static {
        String type = ASMUtils.type(ObjectSerializer.class);
        ObjectSerializer = type;
        ObjectSerializer_desc = "L" + type + ";";
        String type2 = ASMUtils.type(SerializeWriter.class);
        SerializeWriter = type2;
        SerializeWriter_desc = "L" + type2 + ";";
    }

    static class Context {
        static final int features = 5;
        static int fieldName = 6;
        static final int obj = 2;
        static int original = 7;
        static final int paramFieldName = 3;
        static final int paramFieldType = 4;
        static int processValue = 8;
        static final int serializer = 1;
        /* access modifiers changed from: private */
        public final SerializeBeanInfo beanInfo;
        /* access modifiers changed from: private */
        public final String className;
        private final FieldInfo[] getters;
        /* access modifiers changed from: private */
        public final boolean nonContext;
        /* access modifiers changed from: private */
        public int variantIndex = 9;
        private Map<String, Integer> variants = new HashMap();
        /* access modifiers changed from: private */
        public final boolean writeDirect;

        public Context(FieldInfo[] fieldInfoArr, SerializeBeanInfo serializeBeanInfo, String str, boolean z, boolean z2) {
            this.getters = fieldInfoArr;
            this.className = str;
            this.beanInfo = serializeBeanInfo;
            this.writeDirect = z;
            this.nonContext = z2 || serializeBeanInfo.beanType.isEnum();
        }

        public int var(String str) {
            if (this.variants.get(str) == null) {
                Map<String, Integer> map = this.variants;
                int i = this.variantIndex;
                this.variantIndex = i + 1;
                map.put(str, Integer.valueOf(i));
            }
            return this.variants.get(str).intValue();
        }

        public int var(String str, int i) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, Integer.valueOf(this.variantIndex));
                this.variantIndex += i;
            }
            return this.variants.get(str).intValue();
        }

        public int getFieldOrinal(String str) {
            int length = this.getters.length;
            for (int i = 0; i < length; i++) {
                if (this.getters[i].name.equals(str)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public JavaBeanSerializer createJavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) throws Exception {
        String str;
        String str2;
        boolean z;
        FieldInfo[] fieldInfoArr;
        String str3;
        String str4;
        boolean z2;
        boolean z3;
        boolean z4;
        String str5;
        boolean z5;
        JSONType jSONType;
        String str6;
        int i;
        boolean z6;
        char c;
        int i2;
        ClassWriter classWriter;
        int i3;
        SerializeBeanInfo serializeBeanInfo2 = serializeBeanInfo;
        Class<ASMSerializerFactory> cls = ASMSerializerFactory.class;
        Class<?> cls2 = serializeBeanInfo2.beanType;
        if (!cls2.isPrimitive()) {
            JSONType jSONType2 = (JSONType) TypeUtils.getAnnotation(cls2, JSONType.class);
            FieldInfo[] fieldInfoArr2 = serializeBeanInfo2.fields;
            for (FieldInfo fieldInfo : fieldInfoArr2) {
                if (fieldInfo.field == null && fieldInfo.method != null && fieldInfo.method.getDeclaringClass().isInterface()) {
                    return new JavaBeanSerializer(serializeBeanInfo2);
                }
            }
            FieldInfo[] fieldInfoArr3 = serializeBeanInfo2.sortedFields;
            boolean z7 = serializeBeanInfo2.sortedFields == serializeBeanInfo2.fields;
            if (fieldInfoArr3.length > 256) {
                return new JavaBeanSerializer(serializeBeanInfo2);
            }
            for (FieldInfo member : fieldInfoArr3) {
                if (!ASMUtils.checkName(member.getMember().getName())) {
                    return new JavaBeanSerializer(serializeBeanInfo2);
                }
            }
            String str7 = "ASMSerializer_" + this.seed.incrementAndGet() + "_" + cls2.getSimpleName();
            Package packageR = cls.getPackage();
            if (packageR != null) {
                String name = packageR.getName();
                str2 = name + "." + str7;
                str = name.replace('.', '/') + ExpiryDateInput.SEPARATOR + str7;
            } else {
                str2 = str7;
                str = str2;
            }
            cls.getPackage().getName();
            ClassWriter classWriter2 = new ClassWriter();
            classWriter2.visit(49, 33, str, JavaBeanSerializer, new String[]{ObjectSerializer});
            int length = fieldInfoArr3.length;
            int i4 = 0;
            while (i4 < length) {
                FieldInfo fieldInfo2 = fieldInfoArr3[i4];
                if (fieldInfo2.fieldClass.isPrimitive() || fieldInfo2.fieldClass == String.class) {
                    i3 = length;
                } else {
                    i3 = length;
                    new FieldWriter(classWriter2, 1, fieldInfo2.name + "_asm_fieldType", "Ljava/lang/reflect/Type;").visitEnd();
                    if (List.class.isAssignableFrom(fieldInfo2.fieldClass)) {
                        new FieldWriter(classWriter2, 1, fieldInfo2.name + "_asm_list_item_ser_", ObjectSerializer_desc).visitEnd();
                    }
                    new FieldWriter(classWriter2, 1, fieldInfo2.name + "_asm_ser_", ObjectSerializer_desc).visitEnd();
                }
                i4++;
                length = i3;
            }
            MethodWriter methodWriter = new MethodWriter(classWriter2, 1, "<init>", "(" + ASMUtils.desc((Class<?>) SerializeBeanInfo.class) + ")V", (String) null, (String[]) null);
            methodWriter.visitVarInsn(25, 0);
            methodWriter.visitVarInsn(25, 1);
            methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, JavaBeanSerializer, "<init>", "(" + ASMUtils.desc((Class<?>) SerializeBeanInfo.class) + ")V");
            int i5 = 0;
            while (i5 < fieldInfoArr3.length) {
                FieldInfo fieldInfo3 = fieldInfoArr3[i5];
                if (fieldInfo3.fieldClass.isPrimitive() || fieldInfo3.fieldClass == String.class) {
                    classWriter = classWriter2;
                } else {
                    methodWriter.visitVarInsn(25, 0);
                    if (fieldInfo3.method != null) {
                        methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo3.declaringClass)));
                        methodWriter.visitLdcInsn(fieldInfo3.method.getName());
                        classWriter = classWriter2;
                        methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, ASMUtils.type(ASMUtils.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
                    } else {
                        classWriter = classWriter2;
                        methodWriter.visitVarInsn(25, 0);
                        methodWriter.visitLdcInsn(Integer.valueOf(i5));
                        methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, JavaBeanSerializer, "getFieldType", "(I)Ljava/lang/reflect/Type;");
                    }
                    methodWriter.visitFieldInsn(Opcodes.PUTFIELD, str, fieldInfo3.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                }
                i5++;
                classWriter2 = classWriter;
            }
            ClassWriter classWriter3 = classWriter2;
            methodWriter.visitInsn(Opcodes.RETURN);
            methodWriter.visitMaxs(4, 4);
            methodWriter.visitEnd();
            if (jSONType2 != null) {
                SerializerFeature[] serialzeFeatures = jSONType2.serialzeFeatures();
                int length2 = serialzeFeatures.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length2) {
                        break;
                    } else if (serialzeFeatures[i6] == SerializerFeature.DisableCircularReferenceDetect) {
                        z = true;
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            z = false;
            int i7 = 0;
            while (true) {
                fieldInfoArr = fieldInfoArr2;
                if (i7 >= 3) {
                    break;
                }
                if (i7 == 0) {
                    str5 = "write";
                    z4 = z;
                    z5 = true;
                } else if (i7 == 1) {
                    str5 = "writeNormal";
                    z4 = z;
                    z5 = false;
                } else {
                    str5 = "writeDirectNonContext";
                    z5 = true;
                    z4 = true;
                }
                Context context = r1;
                String str8 = "entity";
                ClassWriter classWriter4 = classWriter3;
                String str9 = str2;
                String str10 = str;
                Context context2 = new Context(fieldInfoArr3, serializeBeanInfo, str, z5, z4);
                StringBuilder sb = new StringBuilder();
                sb.append("(L");
                String str11 = JSONSerializer;
                sb.append(str11);
                sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                int i8 = i7;
                MethodWriter methodWriter2 = new MethodWriter(classWriter3, 1, str5, sb.toString(), (String) null, new String[]{"java/io/IOException"});
                Label label = new Label();
                methodWriter2.visitVarInsn(25, 2);
                methodWriter2.visitJumpInsn(Opcodes.IFNONNULL, label);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str11, "writeNull", "()V");
                methodWriter2.visitInsn(Opcodes.RETURN);
                methodWriter2.visitLabel(label);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str11, "out", SerializeWriter_desc);
                Context context3 = context;
                methodWriter2.visitVarInsn(58, context3.var("out"));
                if (z7 || context3.writeDirect || (jSONType2 != null && !jSONType2.alphabetic())) {
                    jSONType = jSONType2;
                    str6 = str10;
                } else {
                    Label label2 = new Label();
                    methodWriter2.visitVarInsn(25, context3.var("out"));
                    jSONType = jSONType2;
                    methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isSortField", "()Z");
                    methodWriter2.visitJumpInsn(Opcodes.IFNE, label2);
                    methodWriter2.visitVarInsn(25, 0);
                    methodWriter2.visitVarInsn(25, 1);
                    methodWriter2.visitVarInsn(25, 2);
                    methodWriter2.visitVarInsn(25, 3);
                    methodWriter2.visitVarInsn(25, 4);
                    methodWriter2.visitVarInsn(21, 5);
                    str6 = str10;
                    methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str6, "writeUnsorted", "(L" + str11 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    methodWriter2.visitInsn(Opcodes.RETURN);
                    methodWriter2.visitLabel(label2);
                }
                if (!context3.writeDirect || z4) {
                    i = i8;
                    z6 = z7;
                    i2 = Opcodes.RETURN;
                    c = 4;
                } else {
                    Label label3 = new Label();
                    Label label4 = new Label();
                    methodWriter2.visitVarInsn(25, 0);
                    methodWriter2.visitVarInsn(25, 1);
                    String str12 = JavaBeanSerializer;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("(L");
                    sb2.append(str11);
                    z6 = z7;
                    sb2.append(";)Z");
                    i = i8;
                    methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str12, "writeDirect", sb2.toString());
                    methodWriter2.visitJumpInsn(Opcodes.IFNE, label4);
                    methodWriter2.visitVarInsn(25, 0);
                    methodWriter2.visitVarInsn(25, 1);
                    methodWriter2.visitVarInsn(25, 2);
                    methodWriter2.visitVarInsn(25, 3);
                    methodWriter2.visitVarInsn(25, 4);
                    methodWriter2.visitVarInsn(21, 5);
                    methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str6, "writeNormal", "(L" + str11 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    methodWriter2.visitInsn(Opcodes.RETURN);
                    methodWriter2.visitLabel(label4);
                    methodWriter2.visitVarInsn(25, context3.var("out"));
                    methodWriter2.visitLdcInsn(Integer.valueOf(SerializerFeature.DisableCircularReferenceDetect.mask));
                    methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                    methodWriter2.visitJumpInsn(Opcodes.IFEQ, label3);
                    methodWriter2.visitVarInsn(25, 0);
                    methodWriter2.visitVarInsn(25, 1);
                    methodWriter2.visitVarInsn(25, 2);
                    methodWriter2.visitVarInsn(25, 3);
                    c = 4;
                    methodWriter2.visitVarInsn(25, 4);
                    methodWriter2.visitVarInsn(21, 5);
                    methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str6, "writeDirectNonContext", "(L" + str11 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    i2 = Opcodes.RETURN;
                    methodWriter2.visitInsn(Opcodes.RETURN);
                    methodWriter2.visitLabel(label3);
                }
                methodWriter2.visitVarInsn(25, 2);
                methodWriter2.visitTypeInsn(Opcodes.CHECKCAST, ASMUtils.type(cls2));
                methodWriter2.visitVarInsn(58, context3.var(str8));
                generateWriteMethod(cls2, methodWriter2, fieldInfoArr3, context3);
                methodWriter2.visitInsn(i2);
                methodWriter2.visitMaxs(7, context3.variantIndex + 2);
                methodWriter2.visitEnd();
                i7 = i + 1;
                SerializeBeanInfo serializeBeanInfo3 = serializeBeanInfo;
                char c2 = c;
                str = str6;
                jSONType2 = jSONType;
                z7 = z6;
                fieldInfoArr2 = fieldInfoArr;
                classWriter3 = classWriter4;
                str2 = str9;
            }
            String str13 = "entity";
            String str14 = str2;
            String str15 = str;
            ClassWriter classWriter5 = classWriter3;
            if (!z7) {
                Context context4 = r1;
                Context context5 = new Context(fieldInfoArr3, serializeBeanInfo, str15, false, z);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("(L");
                String str16 = JSONSerializer;
                sb3.append(str16);
                sb3.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                str3 = str13;
                MethodWriter methodWriter3 = new MethodWriter(classWriter5, 1, "writeUnsorted", sb3.toString(), (String) null, new String[]{"java/io/IOException"});
                methodWriter3.visitVarInsn(25, 1);
                methodWriter3.visitFieldInsn(Opcodes.GETFIELD, str16, "out", SerializeWriter_desc);
                methodWriter3.visitVarInsn(58, context4.var("out"));
                methodWriter3.visitVarInsn(25, 2);
                methodWriter3.visitTypeInsn(Opcodes.CHECKCAST, ASMUtils.type(cls2));
                methodWriter3.visitVarInsn(58, context4.var(str3));
                generateWriteMethod(cls2, methodWriter3, fieldInfoArr, context4);
                methodWriter3.visitInsn(Opcodes.RETURN);
                methodWriter3.visitMaxs(7, context4.variantIndex + 2);
                methodWriter3.visitEnd();
            } else {
                str3 = str13;
            }
            int i9 = 0;
            for (int i10 = 3; i9 < i10; i10 = i10) {
                if (i9 == 0) {
                    str4 = "writeAsArray";
                    z2 = z;
                    z3 = true;
                } else if (i9 == 1) {
                    str4 = "writeAsArrayNormal";
                    z2 = z;
                    z3 = false;
                } else {
                    str4 = "writeAsArrayNonContext";
                    z3 = true;
                    z2 = true;
                }
                Context context6 = r1;
                Context context7 = new Context(fieldInfoArr3, serializeBeanInfo, str15, z3, z2);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("(L");
                String str17 = JSONSerializer;
                sb4.append(str17);
                sb4.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                int i11 = i9;
                MethodWriter methodWriter4 = new MethodWriter(classWriter5, 1, str4, sb4.toString(), (String) null, new String[]{"java/io/IOException"});
                methodWriter4.visitVarInsn(25, 1);
                methodWriter4.visitFieldInsn(Opcodes.GETFIELD, str17, "out", SerializeWriter_desc);
                methodWriter4.visitVarInsn(58, context6.var("out"));
                methodWriter4.visitVarInsn(25, 2);
                methodWriter4.visitTypeInsn(Opcodes.CHECKCAST, ASMUtils.type(cls2));
                str3 = str3;
                methodWriter4.visitVarInsn(58, context6.var(str3));
                generateWriteAsArray(cls2, methodWriter4, fieldInfoArr3, context6);
                methodWriter4.visitInsn(Opcodes.RETURN);
                methodWriter4.visitMaxs(7, context6.variantIndex + 2);
                methodWriter4.visitEnd();
                i9 = i11 + 1;
            }
            byte[] byteArray = classWriter5.toByteArray();
            return (JavaBeanSerializer) this.classLoader.defineClassPublic(str14, byteArray, 0, byteArray.length).getConstructor(new Class[]{SerializeBeanInfo.class}).newInstance(new Object[]{serializeBeanInfo});
        }
        throw new JSONException("unsupportd class " + cls2.getName());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v52, resolved type: java.lang.Class<java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v53, resolved type: java.lang.Class<java.lang.Object>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void generateWriteAsArray(java.lang.Class<?> r34, com.alibaba.fastjson.asm.MethodVisitor r35, com.alibaba.fastjson.util.FieldInfo[] r36, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context r37) throws java.lang.Exception {
        /*
            r33 = this;
            r0 = r33
            r1 = r35
            r2 = r36
            r3 = r37
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            r5 = 25
            r6 = 1
            r1.visitVarInsn(r5, r6)
            r7 = 0
            r1.visitVarInsn(r5, r7)
            java.lang.String r8 = JSONSerializer
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "("
            r9.append(r10)
            java.lang.String r10 = SerializeFilterable_desc
            r9.append(r10)
            java.lang.String r10 = ")Z"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r10 = 182(0xb6, float:2.55E-43)
            java.lang.String r11 = "hasPropertyFilters"
            r1.visitMethodInsn(r10, r8, r11, r9)
            r9 = 154(0x9a, float:2.16E-43)
            r1.visitJumpInsn(r9, r4)
            r1.visitVarInsn(r5, r7)
            r1.visitVarInsn(r5, r6)
            r9 = 2
            r1.visitVarInsn(r5, r9)
            r9 = 3
            r1.visitVarInsn(r5, r9)
            r9 = 4
            r1.visitVarInsn(r5, r9)
            r9 = 21
            r11 = 5
            r1.visitVarInsn(r9, r11)
            java.lang.String r11 = JavaBeanSerializer
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "(L"
            r12.append(r13)
            r12.append(r8)
            java.lang.String r8 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            r12.append(r8)
            java.lang.String r12 = r12.toString()
            r14 = 183(0xb7, float:2.56E-43)
            java.lang.String r15 = "writeNoneASM"
            r1.visitMethodInsn(r14, r11, r15, r12)
            r11 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r11)
            r1.visitLabel(r4)
            java.lang.String r4 = "out"
            int r11 = r3.var(r4)
            r1.visitVarInsn(r5, r11)
            r11 = 16
            r12 = 91
            r1.visitVarInsn(r11, r12)
            java.lang.String r12 = SerializeWriter
            java.lang.String r14 = "write"
            java.lang.String r15 = "(I)V"
            r1.visitMethodInsn(r10, r12, r14, r15)
            int r6 = r2.length
            if (r6 != 0) goto L_0x00aa
            int r2 = r3.var(r4)
            r1.visitVarInsn(r5, r2)
            r2 = 93
            r1.visitVarInsn(r11, r2)
            r1.visitMethodInsn(r10, r12, r14, r15)
            return
        L_0x00aa:
            r12 = r7
        L_0x00ab:
            if (r12 >= r6) goto L_0x08c4
            int r9 = r6 + -1
            if (r12 != r9) goto L_0x00b4
            r9 = 93
            goto L_0x00b6
        L_0x00b4:
            r9 = 44
        L_0x00b6:
            r7 = r2[r12]
            java.lang.Class<?> r11 = r7.fieldClass
            java.lang.String r10 = r7.name
            r1.visitLdcInsn(r10)
            int r10 = com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName
            r5 = 58
            r1.visitVarInsn(r5, r10)
            java.lang.Class r10 = java.lang.Byte.TYPE
            r5 = 89
            if (r11 == r10) goto L_0x0880
            java.lang.Class r10 = java.lang.Short.TYPE
            if (r11 == r10) goto L_0x0880
            java.lang.Class r10 = java.lang.Integer.TYPE
            if (r11 != r10) goto L_0x00d6
            goto L_0x0880
        L_0x00d6:
            java.lang.Class r10 = java.lang.Long.TYPE
            if (r11 != r10) goto L_0x010e
            int r10 = r3.var(r4)
            r11 = 25
            r1.visitVarInsn(r11, r10)
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeLong"
            java.lang.String r10 = "(J)V"
            r11 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r11, r5, r7, r10)
            r7 = 16
            r1.visitVarInsn(r7, r9)
            r1.visitMethodInsn(r11, r5, r14, r15)
        L_0x00fd:
            r20 = r6
            r10 = r11
        L_0x0100:
            r21 = r12
            r5 = r13
            r11 = r15
            r2 = 0
            r6 = 1
            r9 = 25
        L_0x0108:
            r13 = 16
            r12 = r0
            r0 = r4
            goto L_0x08af
        L_0x010e:
            java.lang.Class r10 = java.lang.Float.TYPE
            if (r11 != r10) goto L_0x013a
            int r10 = r3.var(r4)
            r11 = 25
            r1.visitVarInsn(r11, r10)
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            r5 = 4
            r1.visitInsn(r5)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeFloat"
            java.lang.String r10 = "(FZ)V"
            r11 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r11, r5, r7, r10)
            r7 = 16
            r1.visitVarInsn(r7, r9)
            r1.visitMethodInsn(r11, r5, r14, r15)
            goto L_0x00fd
        L_0x013a:
            java.lang.Class r10 = java.lang.Double.TYPE
            if (r11 != r10) goto L_0x0166
            int r10 = r3.var(r4)
            r11 = 25
            r1.visitVarInsn(r11, r10)
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            r5 = 4
            r1.visitInsn(r5)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeDouble"
            java.lang.String r10 = "(DZ)V"
            r11 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r11, r5, r7, r10)
            r7 = 16
            r1.visitVarInsn(r7, r9)
            r1.visitMethodInsn(r11, r5, r14, r15)
            goto L_0x00fd
        L_0x0166:
            java.lang.Class r10 = java.lang.Boolean.TYPE
            if (r11 != r10) goto L_0x018e
            int r10 = r3.var(r4)
            r11 = 25
            r1.visitVarInsn(r11, r10)
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "(Z)V"
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r5, r14, r7)
            r7 = 16
            r1.visitVarInsn(r7, r9)
            r1.visitMethodInsn(r10, r5, r14, r15)
        L_0x018a:
            r20 = r6
            goto L_0x0100
        L_0x018e:
            java.lang.Class r10 = java.lang.Character.TYPE
            r5 = 184(0xb8, float:2.58E-43)
            if (r11 != r10) goto L_0x01ca
            int r10 = r3.var(r4)
            r11 = 25
            r1.visitVarInsn(r11, r10)
            r0._get(r1, r3, r7)
            java.lang.String r7 = "java/lang/Character"
            java.lang.String r10 = "toString"
            java.lang.String r11 = "(C)Ljava/lang/String;"
            r1.visitMethodInsn(r5, r7, r10, r11)
            r10 = 16
            r1.visitVarInsn(r10, r9)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeString"
            java.lang.String r9 = "(Ljava/lang/String;C)V"
            r11 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r11, r5, r7, r9)
            r20 = r6
            r21 = r12
            r5 = r13
            r2 = 0
            r6 = 1
            r9 = 25
            r12 = r0
            r0 = r4
            r13 = r10
            r10 = r11
            r11 = r15
            goto L_0x08af
        L_0x01ca:
            r10 = 16
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            if (r11 != r5) goto L_0x01f6
            int r5 = r3.var(r4)
            r11 = 25
            r1.visitVarInsn(r11, r5)
            r0._get(r1, r3, r7)
            r1.visitVarInsn(r10, r9)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeString"
            java.lang.String r9 = "(Ljava/lang/String;C)V"
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r5, r7, r9)
            r20 = r6
            r9 = r11
            r21 = r12
            r5 = r13
            r11 = r15
            r2 = 0
            r6 = 1
            goto L_0x0108
        L_0x01f6:
            r5 = 25
            r10 = 182(0xb6, float:2.55E-43)
            boolean r16 = r11.isEnum()
            if (r16 == 0) goto L_0x0223
            int r11 = r3.var(r4)
            r1.visitVarInsn(r5, r11)
            r5 = 89
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeEnum"
            java.lang.String r11 = "(Ljava/lang/Enum;)V"
            r1.visitMethodInsn(r10, r5, r7, r11)
            r7 = 16
            r1.visitVarInsn(r7, r9)
            r1.visitMethodInsn(r10, r5, r14, r15)
            goto L_0x018a
        L_0x0223:
            java.lang.Class<java.util.List> r5 = java.util.List.class
            boolean r5 = r5.isAssignableFrom(r11)
            java.lang.String r10 = "writeWithFieldName"
            if (r5 == 0) goto L_0x0602
            java.lang.reflect.Type r5 = r7.fieldType
            boolean r11 = r5 instanceof java.lang.Class
            if (r11 == 0) goto L_0x0237
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            goto L_0x0240
        L_0x0237:
            java.lang.reflect.ParameterizedType r5 = (java.lang.reflect.ParameterizedType) r5
            java.lang.reflect.Type[] r5 = r5.getActualTypeArguments()
            r11 = 0
            r5 = r5[r11]
        L_0x0240:
            boolean r11 = r5 instanceof java.lang.Class
            if (r11 == 0) goto L_0x024b
            r11 = r5
            java.lang.Class r11 = (java.lang.Class) r11
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            if (r11 != r2) goto L_0x024c
        L_0x024b:
            r11 = 0
        L_0x024c:
            r0._get(r1, r3, r7)
            r2 = 192(0xc0, float:2.69E-43)
            r20 = r6
            java.lang.String r6 = "java/util/List"
            r1.visitTypeInsn(r2, r6)
            java.lang.String r2 = "list"
            int r6 = r3.var(r2)
            r21 = r12
            r12 = 58
            r1.visitVarInsn(r12, r6)
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            if (r11 != r6) goto L_0x0296
            boolean r6 = r37.writeDirect
            if (r6 == 0) goto L_0x0296
            int r5 = r3.var(r4)
            r6 = 25
            r1.visitVarInsn(r6, r5)
            int r2 = r3.var(r2)
            r1.visitVarInsn(r6, r2)
            java.lang.String r2 = SerializeWriter
            java.lang.String r5 = "(Ljava/util/List;)V"
            r6 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r6, r2, r14, r5)
            r0 = r4
            r22 = r9
            r5 = r13
            r10 = r15
            r2 = 21
            r7 = 16
            r9 = r6
            r6 = 25
            goto L_0x05e5
        L_0x0296:
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            com.alibaba.fastjson.asm.Label r12 = new com.alibaba.fastjson.asm.Label
            r12.<init>()
            r22 = r9
            int r9 = r3.var(r2)
            r23 = r10
            r10 = 25
            r1.visitVarInsn(r10, r9)
            r9 = 199(0xc7, float:2.79E-43)
            r1.visitJumpInsn(r9, r12)
            int r9 = r3.var(r4)
            r1.visitVarInsn(r10, r9)
            java.lang.String r9 = SerializeWriter
            java.lang.String r10 = "writeNull"
            r18 = r5
            java.lang.String r5 = "()V"
            r24 = r8
            r8 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r8, r9, r10, r5)
            r5 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r5, r6)
            r1.visitLabel(r12)
            int r5 = r3.var(r2)
            r8 = 25
            r1.visitVarInsn(r8, r5)
            java.lang.String r5 = "java/util/List"
            java.lang.String r10 = "size"
            java.lang.String r12 = "()I"
            r8 = 185(0xb9, float:2.59E-43)
            r1.visitMethodInsn(r8, r5, r10, r12)
            r5 = 54
            java.lang.String r8 = "size"
            int r8 = r3.var(r8)
            r1.visitVarInsn(r5, r8)
            int r5 = r3.var(r4)
            r8 = 25
            r1.visitVarInsn(r8, r5)
            r5 = 91
            r8 = 16
            r1.visitVarInsn(r8, r5)
            r5 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r5, r9, r14, r15)
            com.alibaba.fastjson.asm.Label r5 = new com.alibaba.fastjson.asm.Label
            r5.<init>()
            com.alibaba.fastjson.asm.Label r8 = new com.alibaba.fastjson.asm.Label
            r8.<init>()
            com.alibaba.fastjson.asm.Label r10 = new com.alibaba.fastjson.asm.Label
            r10.<init>()
            r12 = 3
            r1.visitInsn(r12)
            r12 = 54
            r25 = r6
            java.lang.String r6 = "i"
            r26 = r13
            int r13 = r3.var(r6)
            r1.visitVarInsn(r12, r13)
            r1.visitLabel(r5)
            int r12 = r3.var(r6)
            r13 = 21
            r1.visitVarInsn(r13, r12)
            java.lang.String r12 = "size"
            int r12 = r3.var(r12)
            r1.visitVarInsn(r13, r12)
            r12 = 162(0xa2, float:2.27E-43)
            r1.visitJumpInsn(r12, r10)
            int r12 = r3.var(r6)
            r1.visitVarInsn(r13, r12)
            r12 = 153(0x99, float:2.14E-43)
            r1.visitJumpInsn(r12, r8)
            int r12 = r3.var(r4)
            r13 = 25
            r1.visitVarInsn(r13, r12)
            r12 = 44
            r13 = 16
            r1.visitVarInsn(r13, r12)
            r12 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r12, r9, r14, r15)
            r1.visitLabel(r8)
            int r2 = r3.var(r2)
            r8 = 25
            r1.visitVarInsn(r8, r2)
            int r2 = r3.var(r6)
            r8 = 21
            r1.visitVarInsn(r8, r2)
            java.lang.String r2 = "java/util/List"
            java.lang.String r8 = "get"
            java.lang.String r12 = "(I)Ljava/lang/Object;"
            r13 = 185(0xb9, float:2.59E-43)
            r1.visitMethodInsn(r13, r2, r8, r12)
            java.lang.String r2 = "list_item"
            int r8 = r3.var(r2)
            r12 = 58
            r1.visitVarInsn(r12, r8)
            com.alibaba.fastjson.asm.Label r8 = new com.alibaba.fastjson.asm.Label
            r8.<init>()
            com.alibaba.fastjson.asm.Label r12 = new com.alibaba.fastjson.asm.Label
            r12.<init>()
            int r13 = r3.var(r2)
            r27 = r15
            r15 = 25
            r1.visitVarInsn(r15, r13)
            r13 = 199(0xc7, float:2.79E-43)
            r1.visitJumpInsn(r13, r12)
            int r13 = r3.var(r4)
            r1.visitVarInsn(r15, r13)
            java.lang.String r13 = "writeNull"
            java.lang.String r15 = "()V"
            r28 = r4
            r4 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r4, r9, r13, r15)
            r4 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r4, r8)
            r1.visitLabel(r12)
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            com.alibaba.fastjson.asm.Label r12 = new com.alibaba.fastjson.asm.Label
            r12.<init>()
            if (r11 == 0) goto L_0x0530
            int r13 = r11.getModifiers()
            boolean r13 = java.lang.reflect.Modifier.isPublic(r13)
            if (r13 == 0) goto L_0x0530
            int r13 = r3.var(r2)
            r15 = 25
            r1.visitVarInsn(r15, r13)
            java.lang.String r13 = "java/lang/Object"
            java.lang.String r15 = "getClass"
            r29 = r9
            java.lang.String r9 = "()Ljava/lang/Class;"
            r30 = r10
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r13, r15, r9)
            java.lang.String r9 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r11)
            com.alibaba.fastjson.asm.Type r9 = com.alibaba.fastjson.asm.Type.getType(r9)
            r1.visitLdcInsn(r9)
            r9 = 166(0xa6, float:2.33E-43)
            r1.visitJumpInsn(r9, r12)
            r0._getListFieldItemSer(r3, r1, r7, r11)
            java.lang.String r9 = "list_item_desc"
            int r9 = r3.var(r9)
            r10 = 58
            r1.visitVarInsn(r10, r9)
            com.alibaba.fastjson.asm.Label r9 = new com.alibaba.fastjson.asm.Label
            r9.<init>()
            com.alibaba.fastjson.asm.Label r10 = new com.alibaba.fastjson.asm.Label
            r10.<init>()
            boolean r13 = r37.writeDirect
            if (r13 == 0) goto L_0x04b7
            java.lang.String r13 = "list_item_desc"
            int r13 = r3.var(r13)
            r15 = 25
            r1.visitVarInsn(r15, r13)
            r13 = 193(0xc1, float:2.7E-43)
            java.lang.String r15 = JavaBeanSerializer
            r1.visitTypeInsn(r13, r15)
            r13 = 153(0x99, float:2.14E-43)
            r1.visitJumpInsn(r13, r9)
            java.lang.String r13 = "list_item_desc"
            int r13 = r3.var(r13)
            r0 = 25
            r1.visitVarInsn(r0, r13)
            r13 = 192(0xc0, float:2.69E-43)
            r1.visitTypeInsn(r13, r15)
            r13 = 1
            r1.visitVarInsn(r0, r13)
            int r13 = r3.var(r2)
            r1.visitVarInsn(r0, r13)
            boolean r0 = r37.nonContext
            if (r0 == 0) goto L_0x045f
            r0 = 1
            r1.visitInsn(r0)
            r17 = r5
            r31 = r8
            goto L_0x0478
        L_0x045f:
            int r0 = r3.var(r6)
            r13 = 21
            r1.visitVarInsn(r13, r0)
            java.lang.String r0 = "java/lang/Integer"
            java.lang.String r13 = "valueOf"
            r17 = r5
            java.lang.String r5 = "(I)Ljava/lang/Integer;"
            r31 = r8
            r8 = 184(0xb8, float:2.58E-43)
            r1.visitMethodInsn(r8, r0, r13, r5)
        L_0x0478:
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r11)
            com.alibaba.fastjson.asm.Type r0 = com.alibaba.fastjson.asm.Type.getType(r0)
            r1.visitLdcInsn(r0)
            int r0 = r7.serialzeFeatures
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.visitLdcInsn(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r5 = r26
            r0.append(r5)
            java.lang.String r8 = JSONSerializer
            r0.append(r8)
            r8 = r24
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.String r13 = "writeAsArrayNonContext"
            r24 = r12
            r12 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r12, r15, r13, r0)
            r0 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r0, r10)
            r1.visitLabel(r9)
            goto L_0x04c1
        L_0x04b7:
            r17 = r5
            r31 = r8
            r8 = r24
            r5 = r26
            r24 = r12
        L_0x04c1:
            java.lang.String r0 = "list_item_desc"
            int r0 = r3.var(r0)
            r9 = 25
            r1.visitVarInsn(r9, r0)
            r0 = 1
            r1.visitVarInsn(r9, r0)
            int r12 = r3.var(r2)
            r1.visitVarInsn(r9, r12)
            boolean r9 = r37.nonContext
            if (r9 == 0) goto L_0x04e1
            r1.visitInsn(r0)
            goto L_0x04f6
        L_0x04e1:
            int r0 = r3.var(r6)
            r9 = 21
            r1.visitVarInsn(r9, r0)
            java.lang.String r0 = "java/lang/Integer"
            java.lang.String r9 = "valueOf"
            java.lang.String r12 = "(I)Ljava/lang/Integer;"
            r13 = 184(0xb8, float:2.58E-43)
            r1.visitMethodInsn(r13, r0, r9, r12)
        L_0x04f6:
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r11)
            com.alibaba.fastjson.asm.Type r0 = com.alibaba.fastjson.asm.Type.getType(r0)
            r1.visitLdcInsn(r0)
            int r0 = r7.serialzeFeatures
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.visitLdcInsn(r0)
            java.lang.String r0 = ObjectSerializer
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            java.lang.String r12 = JSONSerializer
            r9.append(r12)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            r12 = 185(0xb9, float:2.59E-43)
            r1.visitMethodInsn(r12, r0, r14, r9)
            r1.visitLabel(r10)
            r0 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r0, r4)
            r0 = r24
            goto L_0x053d
        L_0x0530:
            r17 = r5
            r31 = r8
            r29 = r9
            r30 = r10
            r8 = r24
            r5 = r26
            r0 = r12
        L_0x053d:
            r1.visitLabel(r0)
            r0 = 1
            r9 = 25
            r1.visitVarInsn(r9, r0)
            int r2 = r3.var(r2)
            r1.visitVarInsn(r9, r2)
            boolean r2 = r37.nonContext
            if (r2 == 0) goto L_0x0559
            r1.visitInsn(r0)
            r2 = 21
            goto L_0x056e
        L_0x0559:
            int r0 = r3.var(r6)
            r2 = 21
            r1.visitVarInsn(r2, r0)
            java.lang.String r0 = "java/lang/Integer"
            java.lang.String r9 = "valueOf"
            java.lang.String r10 = "(I)Ljava/lang/Integer;"
            r12 = 184(0xb8, float:2.58E-43)
            r1.visitMethodInsn(r12, r0, r9, r10)
        L_0x056e:
            if (r11 == 0) goto L_0x059e
            int r0 = r11.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isPublic(r0)
            if (r0 == 0) goto L_0x059e
            r0 = r18
            java.lang.Class r0 = (java.lang.Class) r0
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r0)
            com.alibaba.fastjson.asm.Type r0 = com.alibaba.fastjson.asm.Type.getType(r0)
            r1.visitLdcInsn(r0)
            int r0 = r7.serialzeFeatures
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.visitLdcInsn(r0)
            java.lang.String r0 = JSONSerializer
            java.lang.String r7 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            r9 = r23
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r0, r9, r7)
            goto L_0x05a9
        L_0x059e:
            r9 = r23
            r10 = 182(0xb6, float:2.55E-43)
            java.lang.String r0 = JSONSerializer
            java.lang.String r7 = "(Ljava/lang/Object;Ljava/lang/Object;)V"
            r1.visitMethodInsn(r10, r0, r9, r7)
        L_0x05a9:
            r1.visitLabel(r4)
            r0 = r31
            r1.visitLabel(r0)
            int r0 = r3.var(r6)
            r4 = 1
            r1.visitIincInsn(r0, r4)
            r0 = r17
            r4 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r4, r0)
            r0 = r30
            r1.visitLabel(r0)
            r0 = r28
            int r4 = r3.var(r0)
            r6 = 25
            r1.visitVarInsn(r6, r4)
            r4 = 93
            r7 = 16
            r1.visitVarInsn(r7, r4)
            r10 = r27
            r4 = r29
            r9 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r9, r4, r14, r10)
            r4 = r25
            r1.visitLabel(r4)
        L_0x05e5:
            int r4 = r3.var(r0)
            r1.visitVarInsn(r6, r4)
            r4 = r22
            r1.visitVarInsn(r7, r4)
            java.lang.String r4 = SerializeWriter
            r1.visitMethodInsn(r9, r4, r14, r10)
            r12 = r33
            r11 = r10
            r2 = 0
            r6 = 1
            r13 = 16
            r10 = r9
            r9 = 25
            goto L_0x08af
        L_0x0602:
            r0 = r4
            r20 = r6
            r4 = r9
            r9 = r10
            r21 = r12
            r5 = r13
            r10 = r15
            r2 = 21
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            com.alibaba.fastjson.asm.Label r12 = new com.alibaba.fastjson.asm.Label
            r12.<init>()
            r13 = r33
            r13._get(r1, r3, r7)
            r15 = 89
            r1.visitInsn(r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r2 = "field_"
            r15.append(r2)
            r27 = r10
            java.lang.Class<?> r10 = r7.fieldClass
            java.lang.String r10 = r10.getName()
            r15.append(r10)
            java.lang.String r10 = r15.toString()
            int r10 = r3.var(r10)
            r15 = 58
            r1.visitVarInsn(r15, r10)
            r10 = 199(0xc7, float:2.79E-43)
            r1.visitJumpInsn(r10, r12)
            int r10 = r3.var(r0)
            r15 = 25
            r1.visitVarInsn(r15, r10)
            java.lang.String r10 = SerializeWriter
            java.lang.String r15 = "writeNull"
            r22 = r4
            java.lang.String r4 = "()V"
            r28 = r0
            r0 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r0, r10, r15, r4)
            r0 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r0, r6)
            r1.visitLabel(r12)
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r2)
            java.lang.Class<?> r15 = r7.fieldClass
            java.lang.String r15 = r15.getName()
            r12.append(r15)
            java.lang.String r12 = r12.toString()
            int r12 = r3.var(r12)
            r15 = 25
            r1.visitVarInsn(r15, r12)
            java.lang.String r12 = "java/lang/Object"
            java.lang.String r15 = "getClass"
            r18 = r10
            java.lang.String r10 = "()Ljava/lang/Class;"
            r19 = r6
            r6 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r6, r12, r15, r10)
            java.lang.String r6 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r11)
            com.alibaba.fastjson.asm.Type r6 = com.alibaba.fastjson.asm.Type.getType(r6)
            r1.visitLdcInsn(r6)
            r6 = 166(0xa6, float:2.33E-43)
            r1.visitJumpInsn(r6, r4)
            r13._getFieldSer(r3, r1, r7)
            java.lang.String r6 = "fied_ser"
            int r10 = r3.var(r6)
            r12 = 58
            r1.visitVarInsn(r12, r10)
            com.alibaba.fastjson.asm.Label r10 = new com.alibaba.fastjson.asm.Label
            r10.<init>()
            com.alibaba.fastjson.asm.Label r12 = new com.alibaba.fastjson.asm.Label
            r12.<init>()
            boolean r15 = r37.writeDirect
            if (r15 == 0) goto L_0x075f
            int r15 = r11.getModifiers()
            boolean r15 = java.lang.reflect.Modifier.isPublic(r15)
            if (r15 == 0) goto L_0x075f
            int r15 = r3.var(r6)
            r13 = 25
            r1.visitVarInsn(r13, r15)
            r15 = 193(0xc1, float:2.7E-43)
            java.lang.String r13 = JavaBeanSerializer
            r1.visitTypeInsn(r15, r13)
            r15 = 153(0x99, float:2.14E-43)
            r1.visitJumpInsn(r15, r10)
            int r15 = r3.var(r6)
            r23 = r9
            r9 = 25
            r1.visitVarInsn(r9, r15)
            r15 = 192(0xc0, float:2.69E-43)
            r1.visitTypeInsn(r15, r13)
            r15 = 1
            r1.visitVarInsn(r9, r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r2)
            java.lang.Class<?> r9 = r7.fieldClass
            java.lang.String r9 = r9.getName()
            r15.append(r9)
            java.lang.String r9 = r15.toString()
            int r9 = r3.var(r9)
            r15 = 25
            r1.visitVarInsn(r15, r9)
            int r9 = com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName
            r1.visitVarInsn(r15, r9)
            java.lang.String r9 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r11)
            com.alibaba.fastjson.asm.Type r9 = com.alibaba.fastjson.asm.Type.getType(r9)
            r1.visitLdcInsn(r9)
            int r9 = r7.serialzeFeatures
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r1.visitLdcInsn(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            java.lang.String r15 = JSONSerializer
            r9.append(r15)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            java.lang.String r15 = "writeAsArrayNonContext"
            r17 = r4
            r4 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r4, r13, r15, r9)
            r4 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r4, r12)
            r1.visitLabel(r10)
            goto L_0x0763
        L_0x075f:
            r17 = r4
            r23 = r9
        L_0x0763:
            int r4 = r3.var(r6)
            r6 = 25
            r1.visitVarInsn(r6, r4)
            r4 = 1
            r1.visitVarInsn(r6, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.Class<?> r9 = r7.fieldClass
            java.lang.String r9 = r9.getName()
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            int r4 = r3.var(r4)
            r1.visitVarInsn(r6, r4)
            int r4 = com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName
            r1.visitVarInsn(r6, r4)
            java.lang.String r4 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r11)
            com.alibaba.fastjson.asm.Type r4 = com.alibaba.fastjson.asm.Type.getType(r4)
            r1.visitLdcInsn(r4)
            int r4 = r7.serialzeFeatures
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.visitLdcInsn(r4)
            java.lang.String r4 = ObjectSerializer
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r9 = JSONSerializer
            r6.append(r9)
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r10 = 185(0xb9, float:2.59E-43)
            r1.visitMethodInsn(r10, r4, r14, r6)
            r1.visitLabel(r12)
            r4 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r4, r0)
            r4 = r17
            r1.visitLabel(r4)
            java.lang.String r4 = r7.getFormat()
            r6 = 1
            r10 = 25
            r1.visitVarInsn(r10, r6)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r2)
            java.lang.Class<?> r2 = r7.fieldClass
            java.lang.String r2 = r2.getName()
            r11.append(r2)
            java.lang.String r2 = r11.toString()
            int r2 = r3.var(r2)
            r1.visitVarInsn(r10, r2)
            if (r4 == 0) goto L_0x0805
            r1.visitLdcInsn(r4)
            java.lang.String r2 = "writeWithFormat"
            java.lang.String r4 = "(Ljava/lang/Object;Ljava/lang/String;)V"
            r7 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r7, r9, r2, r4)
        L_0x0802:
            r10 = r7
            r2 = 0
            goto L_0x085a
        L_0x0805:
            int r2 = com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName
            r1.visitVarInsn(r10, r2)
            java.lang.reflect.Type r2 = r7.fieldType
            boolean r2 = r2 instanceof java.lang.Class
            if (r2 == 0) goto L_0x0824
            java.lang.reflect.Type r2 = r7.fieldType
            java.lang.Class r2 = (java.lang.Class) r2
            boolean r2 = r2.isPrimitive()
            if (r2 == 0) goto L_0x0824
            java.lang.String r2 = "(Ljava/lang/Object;Ljava/lang/Object;)V"
            r4 = r23
            r7 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r7, r9, r4, r2)
            goto L_0x0802
        L_0x0824:
            r4 = r23
            r2 = 0
            r10 = 25
            r1.visitVarInsn(r10, r2)
            r10 = 180(0xb4, float:2.52E-43)
            java.lang.String r11 = r37.className
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = r7.name
            r12.append(r13)
            java.lang.String r13 = "_asm_fieldType"
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.String r13 = "Ljava/lang/reflect/Type;"
            r1.visitFieldInsn(r10, r11, r12, r13)
            int r7 = r7.serialzeFeatures
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r1.visitLdcInsn(r7)
            java.lang.String r7 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r9, r4, r7)
        L_0x085a:
            r1.visitLabel(r0)
            r0 = r19
            r1.visitLabel(r0)
            r0 = r28
            int r4 = r3.var(r0)
            r9 = 25
            r1.visitVarInsn(r9, r4)
            r4 = r22
            r7 = 16
            r1.visitVarInsn(r7, r4)
            r4 = r18
            r11 = r27
            r1.visitMethodInsn(r10, r4, r14, r11)
            r12 = r33
            r13 = 16
            goto L_0x08af
        L_0x0880:
            r0 = r4
            r20 = r6
            r4 = r9
            r21 = r12
            r5 = r13
            r11 = r15
            r2 = 0
            r6 = 1
            r9 = 25
            r10 = 182(0xb6, float:2.55E-43)
            int r12 = r3.var(r0)
            r1.visitVarInsn(r9, r12)
            r12 = 89
            r1.visitInsn(r12)
            r12 = r33
            r12._get(r1, r3, r7)
            java.lang.String r7 = SerializeWriter
            java.lang.String r13 = "writeInt"
            r1.visitMethodInsn(r10, r7, r13, r11)
            r13 = 16
            r1.visitVarInsn(r13, r4)
            r1.visitMethodInsn(r10, r7, r14, r11)
        L_0x08af:
            int r4 = r21 + 1
            r7 = r2
            r15 = r11
            r11 = r13
            r6 = r20
            r2 = r36
            r13 = r5
            r5 = r9
            r9 = 21
            r32 = r4
            r4 = r0
            r0 = r12
            r12 = r32
            goto L_0x00ab
        L_0x08c4:
            r12 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ASMSerializerFactory.generateWriteAsArray(java.lang.Class, com.alibaba.fastjson.asm.MethodVisitor, com.alibaba.fastjson.util.FieldInfo[], com.alibaba.fastjson.serializer.ASMSerializerFactory$Context):void");
    }

    private void generateWriteMethod(Class<?> cls, MethodVisitor methodVisitor, FieldInfo[] fieldInfoArr, Context context) throws Exception {
        Label label;
        String str;
        String str2;
        int i;
        Class<?> cls2;
        int i2;
        Class<?> cls3 = cls;
        MethodVisitor methodVisitor2 = methodVisitor;
        FieldInfo[] fieldInfoArr2 = fieldInfoArr;
        Context context2 = context;
        Label label2 = new Label();
        int length = fieldInfoArr2.length;
        String str3 = "out";
        if (!context.writeDirect) {
            Label label3 = new Label();
            Label label4 = new Label();
            label = label2;
            methodVisitor2.visitVarInsn(25, context2.var(str3));
            methodVisitor2.visitLdcInsn(Integer.valueOf(SerializerFeature.PrettyFormat.mask));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor2.visitJumpInsn(Opcodes.IFNE, label4);
            int length2 = fieldInfoArr2.length;
            int i3 = 0;
            boolean z = false;
            while (i3 < length2) {
                int i4 = length2;
                if (fieldInfoArr2[i3].method != null) {
                    z = true;
                }
                i3++;
                length2 = i4;
            }
            if (z) {
                methodVisitor2.visitVarInsn(25, context2.var(str3));
                methodVisitor2.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreErrorGetter.mask));
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label3);
            } else {
                methodVisitor2.visitJumpInsn(Opcodes.GOTO, label3);
            }
            methodVisitor2.visitLabel(label4);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(21, 5);
            String str4 = JavaBeanSerializer;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESPECIAL, str4, "write", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitInsn(Opcodes.RETURN);
            methodVisitor2.visitLabel(label3);
        } else {
            label = label2;
        }
        if (!context.nonContext) {
            Label label5 = new Label();
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(21, 5);
            String str5 = JavaBeanSerializer;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "writeReference", "(L" + JSONSerializer + ";Ljava/lang/Object;I)Z");
            methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label5);
            methodVisitor2.visitInsn(Opcodes.RETURN);
            methodVisitor2.visitLabel(label5);
        }
        String str6 = context.writeDirect ? context.nonContext ? "writeAsArrayNonContext" : "writeAsArray" : "writeAsArrayNormal";
        if ((context.beanInfo.features & SerializerFeature.BeanToArray.mask) == 0) {
            Label label6 = new Label();
            methodVisitor2.visitVarInsn(25, context2.var(str3));
            methodVisitor2.visitLdcInsn(Integer.valueOf(SerializerFeature.BeanToArray.mask));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label6);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(21, 5);
            String access$300 = context.className;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, access$300, str6, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitInsn(Opcodes.RETURN);
            methodVisitor2.visitLabel(label6);
        } else {
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(21, 5);
            String access$3002 = context.className;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, access$3002, str6, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitInsn(Opcodes.RETURN);
        }
        if (!context.nonContext) {
            methodVisitor2.visitVarInsn(25, 1);
            String str7 = JSONSerializer;
            StringBuilder sb = new StringBuilder();
            sb.append("()");
            String str8 = SerialContext_desc;
            sb.append(str8);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str7, "getContext", sb.toString());
            methodVisitor2.visitVarInsn(58, context2.var("parent"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context2.var("parent"));
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitLdcInsn(Integer.valueOf(context.beanInfo.features));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str7, "setContext", "(" + str8 + "Ljava/lang/Object;Ljava/lang/Object;I)V");
        }
        boolean z2 = (context.beanInfo.features & SerializerFeature.WriteClassName.mask) != 0;
        if (z2 || !context.writeDirect) {
            Label label7 = new Label();
            Label label8 = new Label();
            Label label9 = new Label();
            if (!z2) {
                methodVisitor2.visitVarInsn(25, 1);
                methodVisitor2.visitVarInsn(25, 4);
                methodVisitor2.visitVarInsn(25, 2);
                String str9 = JSONSerializer;
                str = "parent";
                i2 = Opcodes.INVOKEVIRTUAL;
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str9, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
                methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label8);
            } else {
                str = "parent";
                i2 = Opcodes.INVOKEVIRTUAL;
            }
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitMethodInsn(i2, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodVisitor2.visitJumpInsn(Opcodes.IF_ACMPEQ, label8);
            methodVisitor2.visitLabel(label9);
            methodVisitor2.visitVarInsn(25, context2.var(str3));
            methodVisitor2.visitVarInsn(16, 123);
            methodVisitor2.visitMethodInsn(i2, SerializeWriter, "write", "(I)V");
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            if (context.beanInfo.typeKey != null) {
                methodVisitor2.visitLdcInsn(context.beanInfo.typeKey);
            } else {
                methodVisitor2.visitInsn(1);
            }
            methodVisitor2.visitVarInsn(25, 2);
            String str10 = JavaBeanSerializer;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str10, "writeClassName", "(L" + JSONSerializer + ";Ljava/lang/String;Ljava/lang/Object;)V");
            methodVisitor2.visitVarInsn(16, 44);
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label7);
            methodVisitor2.visitLabel(label8);
            methodVisitor2.visitVarInsn(16, 123);
            methodVisitor2.visitLabel(label7);
        } else {
            methodVisitor2.visitVarInsn(16, 123);
            str = "parent";
        }
        methodVisitor2.visitVarInsn(54, context2.var("seperator"));
        if (!context.writeDirect) {
            _before(methodVisitor2, context2);
        }
        if (!context.writeDirect) {
            methodVisitor2.visitVarInsn(25, context2.var(str3));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isNotWriteDefaultValue", "()Z");
            methodVisitor2.visitVarInsn(54, context2.var("notWriteDefaultValue"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 0);
            String str11 = JSONSerializer;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(");
            String str12 = SerializeFilterable_desc;
            sb2.append(str12);
            sb2.append(")Z");
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str11, "checkValue", sb2.toString());
            methodVisitor2.visitVarInsn(54, context2.var("checkValue"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str11, "hasNameFilters", "(" + str12 + ")Z");
            methodVisitor2.visitVarInsn(54, context2.var("hasNameFilters"));
        }
        int i5 = 0;
        while (i5 < length) {
            FieldInfo fieldInfo = fieldInfoArr2[i5];
            Class<?> cls4 = fieldInfo.fieldClass;
            methodVisitor2.visitLdcInsn(fieldInfo.name);
            methodVisitor2.visitVarInsn(58, Context.fieldName);
            if (cls4 == Byte.TYPE || cls4 == Short.TYPE || cls4 == Integer.TYPE) {
                Class<?> cls5 = cls;
                str2 = str3;
                i = i5;
                _int(cls, methodVisitor, fieldInfo, context, context2.var(cls4.getName()), 'I');
            } else {
                if (cls4 == Long.TYPE) {
                    cls2 = cls;
                    _long(cls2, methodVisitor2, fieldInfo, context2);
                } else {
                    cls2 = cls;
                    if (cls4 == Float.TYPE) {
                        _float(cls2, methodVisitor2, fieldInfo, context2);
                    } else if (cls4 == Double.TYPE) {
                        _double(cls2, methodVisitor2, fieldInfo, context2);
                    } else if (cls4 == Boolean.TYPE) {
                        Class<?> cls6 = cls2;
                        str2 = str3;
                        i = i5;
                        _int(cls, methodVisitor, fieldInfo, context, context2.var("boolean"), 'Z');
                    } else {
                        FieldInfo fieldInfo2 = fieldInfo;
                        Class<?> cls7 = cls2;
                        str2 = str3;
                        i = i5;
                        if (cls4 == Character.TYPE) {
                            _int(cls, methodVisitor, fieldInfo2, context, context2.var("char"), 'C');
                        } else if (cls4 == String.class) {
                            _string(cls7, methodVisitor2, fieldInfo2, context2);
                        } else {
                            FieldInfo fieldInfo3 = fieldInfo2;
                            if (cls4 == BigDecimal.class) {
                                _decimal(cls7, methodVisitor2, fieldInfo3, context2);
                            } else if (List.class.isAssignableFrom(cls4)) {
                                _list(cls7, methodVisitor2, fieldInfo3, context2);
                            } else if (cls4.isEnum()) {
                                _enum(cls7, methodVisitor2, fieldInfo3, context2);
                            } else {
                                _object(cls7, methodVisitor2, fieldInfo3, context2);
                            }
                        }
                    }
                }
                Class<?> cls8 = cls2;
                str2 = str3;
                i = i5;
            }
            i5 = i + 1;
            str3 = str2;
        }
        String str13 = str3;
        if (!context.writeDirect) {
            _after(methodVisitor2, context2);
        }
        Label label10 = new Label();
        Label label11 = new Label();
        methodVisitor2.visitVarInsn(21, context2.var("seperator"));
        methodVisitor2.visitIntInsn(16, 123);
        methodVisitor2.visitJumpInsn(Opcodes.IF_ICMPNE, label10);
        String str14 = str13;
        methodVisitor2.visitVarInsn(25, context2.var(str14));
        methodVisitor2.visitVarInsn(16, 123);
        String str15 = SerializeWriter;
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "write", "(I)V");
        methodVisitor2.visitLabel(label10);
        methodVisitor2.visitVarInsn(25, context2.var(str14));
        methodVisitor2.visitVarInsn(16, 125);
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "write", "(I)V");
        methodVisitor2.visitLabel(label11);
        methodVisitor2.visitLabel(label);
        if (!context.nonContext) {
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context2.var(str));
            String str16 = JSONSerializer;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str16, "setContext", "(" + SerialContext_desc + ")V");
        }
    }

    private void _object(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("object"));
        _filters(methodVisitor, fieldInfo, context, label);
        _writeObject(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitLabel(label);
    }

    private void _enum(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label3);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/lang/Enum");
        methodVisitor.visitVarInsn(58, context.var("enum"));
        _filters(methodVisitor, fieldInfo, context, label3);
        methodVisitor.visitVarInsn(25, context.var("enum"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
        methodVisitor.visitLabel(label);
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Enum", "name", "()Ljava/lang/String;");
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            String str = SerializeWriter;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitInsn(3);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeFieldName", "(Ljava/lang/String;Z)V");
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        }
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitLabel(label3);
    }

    private void _int(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, int i, char c) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(54, i);
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(21, i);
        String str = SerializeWriter;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeFieldValue", "(CLjava/lang/String;" + c + ")V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _long(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(55, context.var("long", 2));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(22, context.var("long", 2));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;J)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _float(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(56, context.var("float"));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(23, context.var("float"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;F)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _double(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(57, context.var("double", 2));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(24, context.var("double", 2));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;D)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _get(MethodVisitor methodVisitor, Context context, FieldInfo fieldInfo) {
        Method method = fieldInfo.method;
        if (method != null) {
            methodVisitor.visitVarInsn(25, context.var("entity"));
            Class<?> declaringClass = method.getDeclaringClass();
            methodVisitor.visitMethodInsn(declaringClass.isInterface() ? Opcodes.INVOKEINTERFACE : Opcodes.INVOKEVIRTUAL, ASMUtils.type(declaringClass), method.getName(), ASMUtils.desc(method));
            if (!method.getReturnType().equals(fieldInfo.fieldClass)) {
                methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, ASMUtils.type(fieldInfo.fieldClass));
                return;
            }
            return;
        }
        methodVisitor.visitVarInsn(25, context.var("entity"));
        Field field = fieldInfo.field;
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, ASMUtils.type(fieldInfo.declaringClass), field.getName(), ASMUtils.desc(field.getType()));
        if (!field.getType().equals(fieldInfo.fieldClass)) {
            methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, ASMUtils.type(fieldInfo.fieldClass));
        }
    }

    private void _decimal(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("decimal"));
        _filters(methodVisitor, fieldInfo, context, label);
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        methodVisitor.visitLabel(label2);
        methodVisitor.visitVarInsn(25, context.var("decimal"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label3);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(25, context.var("decimal"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitLabel(label);
    }

    private void _string(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        if (fieldInfo.name.equals(context.beanInfo.typeKey)) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 4);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        }
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("string"));
        _filters(methodVisitor, fieldInfo, context, label);
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var("string"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label2);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label3);
        methodVisitor.visitLabel(label2);
        if ("trim".equals(fieldInfo.format)) {
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "trim", "()Ljava/lang/String;");
            methodVisitor.visitVarInsn(58, context.var("string"));
        }
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        }
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitLabel(label);
    }

    private void _list(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label;
        int i;
        int i2;
        int i3;
        Label label2;
        Label label3;
        Label label4;
        Label label5;
        String str;
        String str2;
        FieldInfo fieldInfo2;
        Label label6;
        String str3;
        Label label7;
        String str4;
        MethodVisitor methodVisitor2 = methodVisitor;
        FieldInfo fieldInfo3 = fieldInfo;
        Context context2 = context;
        java.lang.reflect.Type collectionItemType = TypeUtils.getCollectionItemType(fieldInfo3.fieldType);
        Class<Serializable> cls2 = null;
        Class<Serializable> cls3 = collectionItemType instanceof Class ? (Class) collectionItemType : null;
        if (!(cls3 == Object.class || cls3 == Serializable.class)) {
            cls2 = cls3;
        }
        Label label8 = new Label();
        Label label9 = new Label();
        Label label10 = new Label();
        _nameApply(methodVisitor2, fieldInfo3, context2, label8);
        _get(methodVisitor2, context2, fieldInfo3);
        methodVisitor2.visitTypeInsn(Opcodes.CHECKCAST, "java/util/List");
        methodVisitor2.visitVarInsn(58, context2.var("list"));
        _filters(methodVisitor2, fieldInfo3, context2, label8);
        methodVisitor2.visitVarInsn(25, context2.var("list"));
        methodVisitor2.visitJumpInsn(Opcodes.IFNONNULL, label9);
        _if_write_null(methodVisitor2, fieldInfo3, context2);
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label10);
        methodVisitor2.visitLabel(label9);
        methodVisitor2.visitVarInsn(25, context2.var("out"));
        methodVisitor2.visitVarInsn(21, context2.var("seperator"));
        String str5 = SerializeWriter;
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "write", "(I)V");
        _writeFieldName(methodVisitor2, context2);
        methodVisitor2.visitVarInsn(25, context2.var("list"));
        Label label11 = label8;
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "size", "()I");
        methodVisitor2.visitVarInsn(54, context2.var("size"));
        Label label12 = new Label();
        Label label13 = new Label();
        Label label14 = label10;
        methodVisitor2.visitVarInsn(21, context2.var("size"));
        methodVisitor2.visitInsn(3);
        methodVisitor2.visitJumpInsn(Opcodes.IF_ICMPNE, label12);
        methodVisitor2.visitVarInsn(25, context2.var("out"));
        methodVisitor2.visitLdcInsn("[]");
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "write", "(Ljava/lang/String;)V");
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label13);
        methodVisitor2.visitLabel(label12);
        if (!context.nonContext) {
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context2.var("list"));
            methodVisitor2.visitVarInsn(25, Context.fieldName);
            label = label13;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        } else {
            label = label13;
        }
        if (collectionItemType != String.class || !context.writeDirect) {
            methodVisitor2.visitVarInsn(25, context2.var("out"));
            methodVisitor2.visitVarInsn(16, 91);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "write", "(I)V");
            Label label15 = new Label();
            Label label16 = new Label();
            Label label17 = new Label();
            methodVisitor2.visitInsn(3);
            java.lang.reflect.Type type = collectionItemType;
            methodVisitor2.visitVarInsn(54, context2.var("i"));
            methodVisitor2.visitLabel(label15);
            methodVisitor2.visitVarInsn(21, context2.var("i"));
            methodVisitor2.visitVarInsn(21, context2.var("size"));
            methodVisitor2.visitJumpInsn(Opcodes.IF_ICMPGE, label17);
            methodVisitor2.visitVarInsn(21, context2.var("i"));
            methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label16);
            methodVisitor2.visitVarInsn(25, context2.var("out"));
            methodVisitor2.visitVarInsn(16, 44);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "write", "(I)V");
            methodVisitor2.visitLabel(label16);
            methodVisitor2.visitVarInsn(25, context2.var("list"));
            methodVisitor2.visitVarInsn(21, context2.var("i"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "get", "(I)Ljava/lang/Object;");
            methodVisitor2.visitVarInsn(58, context2.var("list_item"));
            Label label18 = new Label();
            Label label19 = new Label();
            methodVisitor2.visitVarInsn(25, context2.var("list_item"));
            methodVisitor2.visitJumpInsn(Opcodes.IFNONNULL, label19);
            methodVisitor2.visitVarInsn(25, context2.var("out"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "writeNull", "()V");
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label18);
            methodVisitor2.visitLabel(label19);
            Label label20 = new Label();
            Label label21 = new Label();
            String str6 = str5;
            String str7 = "(I)V";
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                label4 = label15;
                label2 = label18;
                str = "out";
                label6 = label20;
                label3 = label21;
                str2 = "write";
                label5 = label17;
                fieldInfo2 = fieldInfo;
            } else {
                str = "out";
                methodVisitor2.visitVarInsn(25, context2.var("list_item"));
                label5 = label17;
                label4 = label15;
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) cls2)));
                methodVisitor2.visitJumpInsn(Opcodes.IF_ACMPNE, label21);
                fieldInfo2 = fieldInfo;
                _getListFieldItemSer(context2, methodVisitor2, fieldInfo2, cls2);
                methodVisitor2.visitVarInsn(58, context2.var("list_item_desc"));
                Label label22 = new Label();
                Label label23 = new Label();
                if (context.writeDirect) {
                    if (!context.nonContext || !context.writeDirect) {
                        label2 = label18;
                        label3 = label21;
                        str4 = "write";
                    } else {
                        label2 = label18;
                        str4 = "writeDirectNonContext";
                        label3 = label21;
                    }
                    label7 = label20;
                    methodVisitor2.visitVarInsn(25, context2.var("list_item_desc"));
                    String str8 = JavaBeanSerializer;
                    methodVisitor2.visitTypeInsn(Opcodes.INSTANCEOF, str8);
                    methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label22);
                    str3 = "write";
                    methodVisitor2.visitVarInsn(25, context2.var("list_item_desc"));
                    methodVisitor2.visitTypeInsn(Opcodes.CHECKCAST, str8);
                    methodVisitor2.visitVarInsn(25, 1);
                    methodVisitor2.visitVarInsn(25, context2.var("list_item"));
                    if (context.nonContext) {
                        methodVisitor2.visitInsn(1);
                    } else {
                        methodVisitor2.visitVarInsn(21, context2.var("i"));
                        methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) cls2)));
                    methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                    methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, str4, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    methodVisitor2.visitJumpInsn(Opcodes.GOTO, label23);
                    methodVisitor2.visitLabel(label22);
                } else {
                    label2 = label18;
                    label7 = label20;
                    label3 = label21;
                    str3 = "write";
                }
                methodVisitor2.visitVarInsn(25, context2.var("list_item_desc"));
                methodVisitor2.visitVarInsn(25, 1);
                methodVisitor2.visitVarInsn(25, context2.var("list_item"));
                if (context.nonContext) {
                    methodVisitor2.visitInsn(1);
                } else {
                    methodVisitor2.visitVarInsn(21, context2.var("i"));
                    methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) cls2)));
                methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                str2 = str3;
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEINTERFACE, ObjectSerializer, str2, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodVisitor2.visitLabel(label23);
                label6 = label7;
                methodVisitor2.visitJumpInsn(Opcodes.GOTO, label6);
            }
            methodVisitor2.visitLabel(label3);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context2.var("list_item"));
            if (context.nonContext) {
                methodVisitor2.visitInsn(1);
            } else {
                methodVisitor2.visitVarInsn(21, context2.var("i"));
                methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) (Class) type)));
                methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
            methodVisitor2.visitLabel(label6);
            methodVisitor2.visitLabel(label2);
            i3 = 1;
            methodVisitor2.visitIincInsn(context2.var("i"), 1);
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label4);
            methodVisitor2.visitLabel(label5);
            i2 = 25;
            methodVisitor2.visitVarInsn(25, context2.var(str));
            methodVisitor2.visitVarInsn(16, 93);
            i = Opcodes.INVOKEVIRTUAL;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str6, str2, str7);
        } else {
            methodVisitor2.visitVarInsn(25, context2.var("out"));
            methodVisitor2.visitVarInsn(25, context2.var("list"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "write", "(Ljava/util/List;)V");
            i2 = 25;
            i = 182;
            i3 = 1;
        }
        methodVisitor2.visitVarInsn(i2, i3);
        methodVisitor2.visitMethodInsn(i, JSONSerializer, "popContext", "()V");
        methodVisitor2.visitLabel(label);
        _seperator(methodVisitor2, context2);
        methodVisitor2.visitLabel(label14);
        methodVisitor2.visitLabel(label11);
    }

    private void _filters(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (fieldInfo.fieldTransient) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.SkipTransientField.mask));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        }
        _notWriteDefault(methodVisitor, fieldInfo, context, label);
        if (!context.writeDirect) {
            _apply(methodVisitor, fieldInfo, context);
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            _processKey(methodVisitor, fieldInfo, context);
            _processValue(methodVisitor, fieldInfo, context, label);
        }
    }

    private void _nameApply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (!context.writeDirect) {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, Context.fieldName);
            String str = JavaBeanSerializer;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "applyName", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            _labelApply(methodVisitor, fieldInfo, context, label);
        }
        if (fieldInfo.field == null) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreNonFieldGetter.mask));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        }
    }

    private void _labelApply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(fieldInfo.label);
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "applyLabel", "(L" + JSONSerializer + ";Ljava/lang/String;)Z");
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
    }

    private void _writeObject(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        String str;
        Label label2;
        Label label3;
        MethodVisitor methodVisitor2 = methodVisitor;
        FieldInfo fieldInfo2 = fieldInfo;
        Context context2 = context;
        String format = fieldInfo.getFormat();
        Class<?> cls = fieldInfo2.fieldClass;
        Label label4 = new Label();
        if (context.writeDirect) {
            methodVisitor2.visitVarInsn(25, context2.var("object"));
        } else {
            methodVisitor2.visitVarInsn(25, Context.processValue);
        }
        methodVisitor2.visitInsn(89);
        methodVisitor2.visitVarInsn(58, context2.var("object"));
        methodVisitor2.visitJumpInsn(Opcodes.IFNONNULL, label4);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label);
        methodVisitor2.visitLabel(label4);
        methodVisitor2.visitVarInsn(25, context2.var("out"));
        methodVisitor2.visitVarInsn(21, context2.var("seperator"));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "write", "(I)V");
        _writeFieldName(methodVisitor2, context2);
        Label label5 = new Label();
        Label label6 = new Label();
        if (!Modifier.isPublic(cls.getModifiers()) || ParserConfig.isPrimitive2(cls)) {
            str = format;
            label3 = label5;
            label2 = label6;
        } else {
            methodVisitor2.visitVarInsn(25, context2.var("object"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
            methodVisitor2.visitJumpInsn(Opcodes.IF_ACMPNE, label6);
            _getFieldSer(context2, methodVisitor2, fieldInfo2);
            methodVisitor2.visitVarInsn(58, context2.var("fied_ser"));
            Label label7 = new Label();
            Label label8 = new Label();
            methodVisitor2.visitVarInsn(25, context2.var("fied_ser"));
            String str2 = JavaBeanSerializer;
            methodVisitor2.visitTypeInsn(Opcodes.INSTANCEOF, str2);
            methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label7);
            boolean z = (SerializerFeature.DisableCircularReferenceDetect.mask & fieldInfo2.serialzeFeatures) != 0;
            str = format;
            boolean z2 = (SerializerFeature.BeanToArray.mask & fieldInfo2.serialzeFeatures) != 0;
            String str3 = (z || (context.nonContext && context.writeDirect)) ? z2 ? "writeAsArrayNonContext" : "writeDirectNonContext" : z2 ? "writeAsArray" : "write";
            methodVisitor2.visitVarInsn(25, context2.var("fied_ser"));
            methodVisitor2.visitTypeInsn(Opcodes.CHECKCAST, str2);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context2.var("object"));
            methodVisitor2.visitVarInsn(25, Context.fieldName);
            methodVisitor2.visitVarInsn(25, 0);
            String access$300 = context.className;
            StringBuilder sb = new StringBuilder();
            Label label9 = label6;
            sb.append(fieldInfo2.name);
            sb.append("_asm_fieldType");
            methodVisitor2.visitFieldInsn(Opcodes.GETFIELD, access$300, sb.toString(), "Ljava/lang/reflect/Type;");
            methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(L");
            String str4 = JSONSerializer;
            sb2.append(str4);
            sb2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, str3, sb2.toString());
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label8);
            methodVisitor2.visitLabel(label7);
            methodVisitor2.visitVarInsn(25, context2.var("fied_ser"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context2.var("object"));
            methodVisitor2.visitVarInsn(25, Context.fieldName);
            methodVisitor2.visitVarInsn(25, 0);
            String access$3002 = context.className;
            methodVisitor2.visitFieldInsn(Opcodes.GETFIELD, access$3002, fieldInfo2.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
            String str5 = ObjectSerializer;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEINTERFACE, str5, "write", "(L" + str4 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitLabel(label8);
            label3 = label5;
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label3);
            label2 = label9;
        }
        methodVisitor2.visitLabel(label2);
        methodVisitor2.visitVarInsn(25, 1);
        if (context.writeDirect) {
            methodVisitor2.visitVarInsn(25, context2.var("object"));
        } else {
            methodVisitor2.visitVarInsn(25, Context.processValue);
        }
        if (str != null) {
            methodVisitor2.visitLdcInsn(str);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            methodVisitor2.visitVarInsn(25, Context.fieldName);
            if (!(fieldInfo2.fieldType instanceof Class) || !((Class) fieldInfo2.fieldType).isPrimitive()) {
                if (fieldInfo2.fieldClass == String.class) {
                    methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) String.class)));
                } else {
                    methodVisitor2.visitVarInsn(25, 0);
                    String access$3003 = context.className;
                    methodVisitor2.visitFieldInsn(Opcodes.GETFIELD, access$3003, fieldInfo2.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                }
                methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            } else {
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            }
        }
        methodVisitor2.visitLabel(label3);
        _seperator(methodVisitor2, context2);
    }

    private void _before(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeBefore", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _after(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeAfter", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _notWriteDefault(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (!context.writeDirect) {
            Label label2 = new Label();
            methodVisitor.visitVarInsn(21, context.var("notWriteDefaultValue"));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label2);
            Class<?> cls = fieldInfo.fieldClass;
            if (cls == Boolean.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("boolean"));
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            } else if (cls == Byte.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("byte"));
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            } else if (cls == Short.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("short"));
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            } else if (cls == Integer.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("int"));
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            } else if (cls == Long.TYPE) {
                methodVisitor.visitVarInsn(22, context.var("long"));
                methodVisitor.visitInsn(9);
                methodVisitor.visitInsn(Opcodes.LCMP);
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            } else if (cls == Float.TYPE) {
                methodVisitor.visitVarInsn(23, context.var("float"));
                methodVisitor.visitInsn(11);
                methodVisitor.visitInsn(Opcodes.FCMPL);
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            } else if (cls == Double.TYPE) {
                methodVisitor.visitVarInsn(24, context.var("double"));
                methodVisitor.visitInsn(14);
                methodVisitor.visitInsn(Opcodes.DCMPL);
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            }
            methodVisitor.visitLabel(label2);
        }
    }

    private void _apply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Class<?> cls = fieldInfo.fieldClass;
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var("string"));
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("list"));
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
        }
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "apply", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
    }

    private void _processValue(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        MethodVisitor methodVisitor2 = methodVisitor;
        FieldInfo fieldInfo2 = fieldInfo;
        Context context2 = context;
        Label label2 = new Label();
        Class<?> cls = fieldInfo2.fieldClass;
        if (cls.isPrimitive()) {
            Label label3 = new Label();
            methodVisitor2.visitVarInsn(21, context2.var("checkValue"));
            methodVisitor2.visitJumpInsn(Opcodes.IFNE, label3);
            methodVisitor2.visitInsn(1);
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(58, Context.processValue);
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label2);
            methodVisitor2.visitLabel(label3);
        }
        methodVisitor2.visitVarInsn(25, 0);
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitVarInsn(25, 0);
        methodVisitor2.visitLdcInsn(Integer.valueOf(context2.getFieldOrinal(fieldInfo2.name)));
        String str = JavaBeanSerializer;
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getBeanContext", "(I)" + ASMUtils.desc((Class<?>) BeanContext.class));
        methodVisitor2.visitVarInsn(25, 2);
        methodVisitor2.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var("byte"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Short.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var("short"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Integer.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var("int"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Character.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var("char"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Long.TYPE) {
            methodVisitor2.visitVarInsn(22, context2.var("long", 2));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Float.TYPE) {
            methodVisitor2.visitVarInsn(23, context2.var("float"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Double.TYPE) {
            methodVisitor2.visitVarInsn(24, context2.var("double", 2));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Boolean.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var("boolean"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == BigDecimal.class) {
            methodVisitor2.visitVarInsn(25, context2.var("decimal"));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        } else if (cls == String.class) {
            methodVisitor2.visitVarInsn(25, context2.var("string"));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        } else if (cls.isEnum()) {
            methodVisitor2.visitVarInsn(25, context2.var("enum"));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor2.visitVarInsn(25, context2.var("list"));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        } else {
            methodVisitor2.visitVarInsn(25, context2.var("object"));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        }
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "processValue", "(L" + JSONSerializer + ";" + ASMUtils.desc((Class<?>) BeanContext.class) + "Ljava/lang/Object;Ljava/lang/String;" + "Ljava/lang/Object;" + ")Ljava/lang/Object;");
        methodVisitor2.visitVarInsn(58, Context.processValue);
        methodVisitor2.visitVarInsn(25, Context.original);
        methodVisitor2.visitVarInsn(25, Context.processValue);
        methodVisitor2.visitJumpInsn(Opcodes.IF_ACMPEQ, label2);
        _writeObject(methodVisitor, fieldInfo, context, label);
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label);
        methodVisitor2.visitLabel(label2);
    }

    private void _processKey(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        methodVisitor.visitVarInsn(21, context.var("hasNameFilters"));
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        Class<?> cls = fieldInfo.fieldClass;
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var("string"));
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("list"));
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
        }
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "processKey", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        methodVisitor.visitVarInsn(58, Context.fieldName);
        methodVisitor.visitLabel(label);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void _if_write_null(com.alibaba.fastjson.asm.MethodVisitor r12, com.alibaba.fastjson.util.FieldInfo r13, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context r14) {
        /*
            r11 = this;
            java.lang.Class<?> r0 = r13.fieldClass
            com.alibaba.fastjson.asm.Label r1 = new com.alibaba.fastjson.asm.Label
            r1.<init>()
            com.alibaba.fastjson.asm.Label r2 = new com.alibaba.fastjson.asm.Label
            r2.<init>()
            com.alibaba.fastjson.asm.Label r3 = new com.alibaba.fastjson.asm.Label
            r3.<init>()
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            r12.visitLabel(r1)
            com.alibaba.fastjson.annotation.JSONField r13 = r13.getAnnotation()
            r1 = 0
            if (r13 == 0) goto L_0x0029
            com.alibaba.fastjson.serializer.SerializerFeature[] r13 = r13.serialzeFeatures()
            int r13 = com.alibaba.fastjson.serializer.SerializerFeature.of(r13)
            goto L_0x002a
        L_0x0029:
            r13 = r1
        L_0x002a:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r5 = r14.beanInfo
            com.alibaba.fastjson.annotation.JSONType r5 = r5.jsonType
            if (r5 == 0) goto L_0x003b
            com.alibaba.fastjson.serializer.SerializerFeature[] r5 = r5.serialzeFeatures()
            int r5 = com.alibaba.fastjson.serializer.SerializerFeature.of(r5)
            r13 = r13 | r5
        L_0x003b:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            if (r0 != r5) goto L_0x004d
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
            int r5 = r5.getMask()
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty
            int r6 = r6.getMask()
        L_0x004b:
            r5 = r5 | r6
            goto L_0x008a
        L_0x004d:
            java.lang.Class<java.lang.Number> r5 = java.lang.Number.class
            boolean r5 = r5.isAssignableFrom(r0)
            if (r5 == 0) goto L_0x0062
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
            int r5 = r5.getMask()
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero
            int r6 = r6.getMask()
            goto L_0x004b
        L_0x0062:
            java.lang.Class<java.util.Collection> r5 = java.util.Collection.class
            boolean r5 = r5.isAssignableFrom(r0)
            if (r5 == 0) goto L_0x0077
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
            int r5 = r5.getMask()
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty
            int r6 = r6.getMask()
            goto L_0x004b
        L_0x0077:
            java.lang.Class<java.lang.Boolean> r5 = java.lang.Boolean.class
            if (r5 != r0) goto L_0x0088
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
            int r5 = r5.getMask()
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse
            int r6 = r6.getMask()
            goto L_0x004b
        L_0x0088:
            int r5 = com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES
        L_0x008a:
            r6 = r13 & r5
            r7 = 182(0xb6, float:2.55E-43)
            java.lang.String r8 = "out"
            r9 = 25
            if (r6 != 0) goto L_0x00b0
            int r6 = r14.var(r8)
            r12.visitVarInsn(r9, r6)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r12.visitLdcInsn(r5)
            java.lang.String r5 = SerializeWriter
            java.lang.String r6 = "isEnabled"
            java.lang.String r10 = "(I)Z"
            r12.visitMethodInsn(r7, r5, r6, r10)
            r5 = 153(0x99, float:2.14E-43)
            r12.visitJumpInsn(r5, r2)
        L_0x00b0:
            r12.visitLabel(r3)
            int r3 = r14.var(r8)
            r12.visitVarInsn(r9, r3)
            r3 = 21
            java.lang.String r5 = "seperator"
            int r5 = r14.var(r5)
            r12.visitVarInsn(r3, r5)
            java.lang.String r3 = SerializeWriter
            java.lang.String r5 = "write"
            java.lang.String r6 = "(I)V"
            r12.visitMethodInsn(r7, r3, r5, r6)
            r11._writeFieldName(r12, r14)
            int r5 = r14.var(r8)
            r12.visitVarInsn(r9, r5)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r12.visitLdcInsn(r13)
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            if (r0 == r13) goto L_0x0130
            java.lang.Class<java.lang.Character> r13 = java.lang.Character.class
            if (r0 != r13) goto L_0x00e9
            goto L_0x0130
        L_0x00e9:
            java.lang.Class<java.lang.Number> r13 = java.lang.Number.class
            boolean r13 = r13.isAssignableFrom(r0)
            if (r13 == 0) goto L_0x00fd
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero
            int r13 = r13.mask
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r12.visitLdcInsn(r13)
            goto L_0x013b
        L_0x00fd:
            java.lang.Class<java.lang.Boolean> r13 = java.lang.Boolean.class
            if (r0 != r13) goto L_0x010d
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse
            int r13 = r13.mask
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r12.visitLdcInsn(r13)
            goto L_0x013b
        L_0x010d:
            java.lang.Class<java.util.Collection> r13 = java.util.Collection.class
            boolean r13 = r13.isAssignableFrom(r0)
            if (r13 != 0) goto L_0x0124
            boolean r13 = r0.isArray()
            if (r13 == 0) goto L_0x011c
            goto L_0x0124
        L_0x011c:
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            r12.visitLdcInsn(r13)
            goto L_0x013b
        L_0x0124:
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty
            int r13 = r13.mask
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r12.visitLdcInsn(r13)
            goto L_0x013b
        L_0x0130:
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty
            int r13 = r13.mask
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r12.visitLdcInsn(r13)
        L_0x013b:
            java.lang.String r13 = "writeNull"
            java.lang.String r0 = "(II)V"
            r12.visitMethodInsn(r7, r3, r13, r0)
            r11._seperator(r12, r14)
            r13 = 167(0xa7, float:2.34E-43)
            r12.visitJumpInsn(r13, r4)
            r12.visitLabel(r2)
            r12.visitLabel(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ASMSerializerFactory._if_write_null(com.alibaba.fastjson.asm.MethodVisitor, com.alibaba.fastjson.util.FieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory$Context):void");
    }

    private void _writeFieldName(MethodVisitor methodVisitor, Context context) {
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldNameDirect", "(Ljava/lang/String;)V");
            return;
        }
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitInsn(3);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
    }

    private void _seperator(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(16, 44);
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _getListFieldItemSer(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = ObjectSerializer_desc;
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, fieldInfo.name + "_asm_list_item_ser_", str);
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "getObjectWriter", "(Ljava/lang/Class;)" + str);
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, context.className, fieldInfo.name + "_asm_list_item_ser_", str);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, fieldInfo.name + "_asm_list_item_ser_", str);
    }

    private void _getFieldSer(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = ObjectSerializer_desc;
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, fieldInfo.name + "_asm_ser_", str);
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "getObjectWriter", "(Ljava/lang/Class;)" + str);
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, context.className, fieldInfo.name + "_asm_ser_", str);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, fieldInfo.name + "_asm_ser_", str);
    }
}
