package io.ktor.util.converters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006J \u0010\n\u001a\u0004\u0018\u00010\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0013"}, d2 = {"Lio/ktor/util/converters/DefaultConversionService;", "Lio/ktor/util/converters/ConversionService;", "()V", "convertPrimitives", "", "klass", "Lkotlin/reflect/KClass;", "value", "", "fromValue", "fromValues", "values", "", "type", "Lio/ktor/util/reflect/TypeInfo;", "throwConversionException", "", "typeName", "toValues", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversionService.kt */
public final class DefaultConversionService implements ConversionService {
    public static final DefaultConversionService INSTANCE = new DefaultConversionService();

    private DefaultConversionService() {
    }

    public List<String> toValues(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (obj == null) {
            return CollectionsKt.emptyList();
        }
        List<String> platformDefaultToValues = ConversionServiceJvmKt.platformDefaultToValues(obj);
        if (platformDefaultToValues != null) {
            return platformDefaultToValues;
        }
        if (obj instanceof Iterable) {
            Collection arrayList = new ArrayList();
            for (Object values : (Iterable) obj) {
                CollectionsKt.addAll(arrayList, INSTANCE.toValues(values));
            }
            return (List) arrayList;
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(obj.getClass());
        boolean z7 = true;
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            z = true;
        } else {
            z = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE));
        }
        if (z) {
            z2 = true;
        } else {
            z2 = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE));
        }
        if (z2) {
            z3 = true;
        } else {
            z3 = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE));
        }
        if (z3) {
            z4 = true;
        } else {
            z4 = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE));
        }
        if (z4) {
            z5 = true;
        } else {
            z5 = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Character.TYPE));
        }
        if (z5) {
            z6 = true;
        } else {
            z6 = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE));
        }
        if (!z6) {
            z7 = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class));
        }
        if (z7) {
            return CollectionsKt.listOf(obj.toString());
        }
        throw new DataConversionException("Class " + orCreateKotlinClass + " is not supported in default data conversion service");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r0 = (r0 = (kotlin.reflect.KTypeProjection) kotlin.collections.CollectionsKt.single((r0 = r0.getArguments()))).getType();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object fromValues(java.util.List<java.lang.String> r4, io.ktor.util.reflect.TypeInfo r5) {
        /*
            r3 = this;
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r4.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0012
            return r1
        L_0x0012:
            kotlin.reflect.KClass r0 = r5.getType()
            java.lang.Class<java.util.List> r2 = java.util.List.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 != 0) goto L_0x0032
            kotlin.reflect.KClass r0 = r5.getType()
            java.lang.Class<java.util.List> r2 = java.util.List.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 == 0) goto L_0x0087
        L_0x0032:
            kotlin.reflect.KType r0 = r5.getKotlinType()
            if (r0 == 0) goto L_0x0051
            java.util.List r0 = r0.getArguments()
            if (r0 == 0) goto L_0x0051
            java.lang.Object r0 = kotlin.collections.CollectionsKt.single(r0)
            kotlin.reflect.KTypeProjection r0 = (kotlin.reflect.KTypeProjection) r0
            if (r0 == 0) goto L_0x0051
            kotlin.reflect.KType r0 = r0.getType()
            if (r0 == 0) goto L_0x0051
            kotlin.reflect.KClassifier r0 = r0.getClassifier()
            goto L_0x0052
        L_0x0051:
            r0 = r1
        L_0x0052:
            boolean r2 = r0 instanceof kotlin.reflect.KClass
            if (r2 == 0) goto L_0x0059
            r1 = r0
            kotlin.reflect.KClass r1 = (kotlin.reflect.KClass) r1
        L_0x0059:
            if (r1 == 0) goto L_0x0087
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r0)
            r5.<init>(r0)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x006e:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0084
            java.lang.Object r0 = r4.next()
            java.lang.String r0 = (java.lang.String) r0
            io.ktor.util.converters.DefaultConversionService r2 = INSTANCE
            java.lang.Object r0 = r2.fromValue(r0, r1)
            r5.add(r0)
            goto L_0x006e
        L_0x0084:
            java.util.List r5 = (java.util.List) r5
            return r5
        L_0x0087:
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L_0x00ba
            int r0 = r4.size()
            r1 = 1
            if (r0 > r1) goto L_0x00a3
            java.lang.Object r4 = kotlin.collections.CollectionsKt.single(r4)
            java.lang.String r4 = (java.lang.String) r4
            kotlin.reflect.KClass r5 = r5.getType()
            java.lang.Object r4 = r3.fromValue(r4, r5)
            return r4
        L_0x00a3:
            io.ktor.util.converters.DataConversionException r4 = new io.ktor.util.converters.DataConversionException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "There are multiple values when trying to construct single value "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r4.<init>(r5)
            throw r4
        L_0x00ba:
            io.ktor.util.converters.DataConversionException r4 = new io.ktor.util.converters.DataConversionException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "There are no values when trying to construct single value "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.converters.DefaultConversionService.fromValues(java.util.List, io.ktor.util.reflect.TypeInfo):java.lang.Object");
    }

    public final Object fromValue(String str, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(kClass, "klass");
        Object convertPrimitives = convertPrimitives(kClass, str);
        if (convertPrimitives != null) {
            return convertPrimitives;
        }
        Object platformDefaultFromValues = ConversionServiceJvmKt.platformDefaultFromValues(str, kClass);
        if (platformDefaultFromValues != null) {
            return platformDefaultFromValues;
        }
        throwConversionException(kClass.toString());
        throw new KotlinNothingValueException();
    }

    private final Object convertPrimitives(KClass<?> kClass, String str) {
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            return Float.valueOf(Float.parseFloat(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return Double.valueOf(Double.parseDouble(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
            return Short.valueOf(Short.parseShort(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
            return Character.valueOf(StringsKt.single(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(String.class))) {
            return str;
        }
        return null;
    }

    private final Void throwConversionException(String str) {
        throw new DataConversionException("Type " + str + " is not supported in default data conversion service");
    }
}
