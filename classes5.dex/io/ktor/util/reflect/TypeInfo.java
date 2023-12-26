package io.ktor.util.reflect;

import io.ktor.http.LinkHeader;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\r\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\r\u0010\u0011\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lio/ktor/util/reflect/TypeInfo;", "", "type", "Lkotlin/reflect/KClass;", "reifiedType", "Ljava/lang/reflect/Type;", "Lio/ktor/util/reflect/Type;", "kotlinType", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KClass;Ljava/lang/reflect/Type;Lkotlin/reflect/KType;)V", "getKotlinType", "()Lkotlin/reflect/KType;", "getReifiedType", "()Ljava/lang/reflect/Type;", "getType", "()Lkotlin/reflect/KClass;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Type.kt */
public final class TypeInfo {
    private final KType kotlinType;
    private final Type reifiedType;
    private final KClass<?> type;

    public static /* synthetic */ TypeInfo copy$default(TypeInfo typeInfo, KClass<?> kClass, Type type2, KType kType, int i, Object obj) {
        if ((i & 1) != 0) {
            kClass = typeInfo.type;
        }
        if ((i & 2) != 0) {
            type2 = typeInfo.reifiedType;
        }
        if ((i & 4) != 0) {
            kType = typeInfo.kotlinType;
        }
        return typeInfo.copy(kClass, type2, kType);
    }

    public final KClass<?> component1() {
        return this.type;
    }

    public final Type component2() {
        return this.reifiedType;
    }

    public final KType component3() {
        return this.kotlinType;
    }

    public final TypeInfo copy(KClass<?> kClass, Type type2, KType kType) {
        Intrinsics.checkNotNullParameter(kClass, LinkHeader.Parameters.Type);
        Intrinsics.checkNotNullParameter(type2, "reifiedType");
        return new TypeInfo(kClass, type2, kType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeInfo)) {
            return false;
        }
        TypeInfo typeInfo = (TypeInfo) obj;
        return Intrinsics.areEqual(this.type, typeInfo.type) && Intrinsics.areEqual(this.reifiedType, typeInfo.reifiedType) && Intrinsics.areEqual(this.kotlinType, typeInfo.kotlinType);
    }

    public int hashCode() {
        int hashCode = ((this.type.hashCode() * 31) + this.reifiedType.hashCode()) * 31;
        KType kType = this.kotlinType;
        return hashCode + (kType == null ? 0 : kType.hashCode());
    }

    public String toString() {
        return "TypeInfo(type=" + this.type + ", reifiedType=" + this.reifiedType + ", kotlinType=" + this.kotlinType + ')';
    }

    public TypeInfo(KClass<?> kClass, Type type2, KType kType) {
        Intrinsics.checkNotNullParameter(kClass, LinkHeader.Parameters.Type);
        Intrinsics.checkNotNullParameter(type2, "reifiedType");
        this.type = kClass;
        this.reifiedType = type2;
        this.kotlinType = kType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypeInfo(KClass kClass, Type type2, KType kType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, type2, (i & 4) != 0 ? null : kType);
    }

    public final KClass<?> getType() {
        return this.type;
    }

    public final Type getReifiedType() {
        return this.reifiedType;
    }

    public final KType getKotlinType() {
        return this.kotlinType;
    }
}
