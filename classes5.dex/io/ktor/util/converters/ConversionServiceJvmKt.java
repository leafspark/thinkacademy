package io.ktor.util.converters;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0000\u001a\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\t"}, d2 = {"convertSimpleTypes", "", "value", "", "klass", "Lkotlin/reflect/KClass;", "platformDefaultFromValues", "platformDefaultToValues", "", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversionServiceJvm.kt */
public final class ConversionServiceJvmKt {
    public static final Object platformDefaultFromValues(String str, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(kClass, "klass");
        Object convertSimpleTypes = convertSimpleTypes(str, kClass);
        if (convertSimpleTypes != null) {
            return convertSimpleTypes;
        }
        Object obj = null;
        if (!JvmClassMappingKt.getJavaClass(kClass).isEnum()) {
            return null;
        }
        Object[] enumConstants = JvmClassMappingKt.getJavaClass(kClass).getEnumConstants();
        if (enumConstants != null) {
            int i = 0;
            int length = enumConstants.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                Object obj2 = enumConstants[i];
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                if (Intrinsics.areEqual(((Enum) obj2).name(), str)) {
                    obj = obj2;
                    break;
                }
                i++;
            }
            if (obj != null) {
                return obj;
            }
        }
        throw new DataConversionException("Value " + str + " is not a enum member name of " + kClass);
    }

    private static final Object convertSimpleTypes(String str, KClass<?> kClass) {
        Object bigInteger;
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Float.class))) {
            return Float.valueOf(Float.parseFloat(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Double.class))) {
            return Double.valueOf(Double.parseDouble(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Long.class))) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Short.class))) {
            return Short.valueOf(Short.parseShort(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Boolean.class))) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(String.class))) {
            return str;
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Character.class))) {
            return Character.valueOf(str.charAt(0));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(BigDecimal.class))) {
            bigInteger = new BigDecimal(str);
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(BigInteger.class))) {
            bigInteger = new BigInteger(str);
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(UUID.class))) {
            return UUID.fromString(str);
        } else {
            return null;
        }
        return bigInteger;
    }

    public static final List<String> platformDefaultToValues(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        if (obj instanceof Enum) {
            return CollectionsKt.listOf(((Enum) obj).name());
        }
        if (obj instanceof Integer) {
            return CollectionsKt.listOf(obj.toString());
        }
        if (obj instanceof Float) {
            return CollectionsKt.listOf(obj.toString());
        }
        if (obj instanceof Double) {
            return CollectionsKt.listOf(obj.toString());
        }
        if (obj instanceof Long) {
            return CollectionsKt.listOf(obj.toString());
        }
        if (obj instanceof Boolean) {
            return CollectionsKt.listOf(obj.toString());
        }
        if (obj instanceof Short) {
            return CollectionsKt.listOf(obj.toString());
        }
        if (obj instanceof String) {
            return CollectionsKt.listOf(obj.toString());
        }
        if (obj instanceof Character) {
            return CollectionsKt.listOf(obj.toString());
        }
        if (obj instanceof BigDecimal) {
            return CollectionsKt.listOf(obj.toString());
        }
        if (obj instanceof BigInteger) {
            return CollectionsKt.listOf(obj.toString());
        }
        if (obj instanceof UUID) {
            return CollectionsKt.listOf(obj.toString());
        }
        return null;
    }
}
