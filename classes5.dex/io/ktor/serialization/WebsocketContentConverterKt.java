package io.ktor.serialization;

import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.websocket.Frame;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a3\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\b\u0002\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007HHø\u0001\u0000¢\u0006\u0002\u0010\b\u001a3\u0010\t\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\n\u001a\u0002H\u00012\f\b\u0002\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"deserialize", "T", "Lio/ktor/serialization/WebsocketContentConverter;", "content", "Lio/ktor/websocket/Frame;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "(Lio/ktor/serialization/WebsocketContentConverter;Lio/ktor/websocket/Frame;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serialize", "value", "(Lio/ktor/serialization/WebsocketContentConverter;Ljava/lang/Object;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-serialization"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebsocketContentConverter.kt */
public final class WebsocketContentConverterKt {
    public static /* synthetic */ Object serialize$default(WebsocketContentConverter websocketContentConverter, Object obj, Charset charset, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.reifiedOperationMarker(6, "T");
        Type javaType = TypesJVMKt.getJavaType((KType) null);
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), (KType) null);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Any");
        InlineMarker.mark(0);
        Object serialize = websocketContentConverter.serialize(charset, typeInfoImpl, obj, continuation);
        InlineMarker.mark(1);
        return serialize;
    }

    public static final /* synthetic */ <T> Object serialize(WebsocketContentConverter websocketContentConverter, T t, Charset charset, Continuation<? super Frame> continuation) {
        Intrinsics.reifiedOperationMarker(6, "T");
        Type javaType = TypesJVMKt.getJavaType((KType) null);
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), (KType) null);
        Objects.requireNonNull(t, "null cannot be cast to non-null type kotlin.Any");
        InlineMarker.mark(0);
        Object serialize = websocketContentConverter.serialize(charset, typeInfoImpl, (Object) t, continuation);
        InlineMarker.mark(1);
        return serialize;
    }

    public static /* synthetic */ Object deserialize$default(WebsocketContentConverter websocketContentConverter, Frame frame, Charset charset, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.reifiedOperationMarker(6, "T");
        Type javaType = TypesJVMKt.getJavaType((KType) null);
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), (KType) null);
        InlineMarker.mark(0);
        Object deserialize = websocketContentConverter.deserialize(charset, typeInfoImpl, frame, continuation);
        InlineMarker.mark(1);
        Intrinsics.reifiedOperationMarker(1, "T");
        return deserialize;
    }

    public static final /* synthetic */ <T> Object deserialize(WebsocketContentConverter websocketContentConverter, Frame frame, Charset charset, Continuation<? super T> continuation) {
        Intrinsics.reifiedOperationMarker(6, "T");
        Type javaType = TypesJVMKt.getJavaType((KType) null);
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), (KType) null);
        InlineMarker.mark(0);
        Object deserialize = websocketContentConverter.deserialize(charset, typeInfoImpl, frame, continuation);
        InlineMarker.mark(1);
        Intrinsics.reifiedOperationMarker(1, "T");
        return deserialize;
    }
}
