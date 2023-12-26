package io.ktor.client.call;

import io.ktor.client.statement.HttpResponse;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002HHø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a\u001d\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0004HHø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a#\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"body", "T", "Lio/ktor/client/call/HttpClientCall;", "(Lio/ktor/client/call/HttpClientCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "typeInfo", "Lio/ktor/util/reflect/TypeInfo;", "(Lio/ktor/client/statement/HttpResponse;Lio/ktor/util/reflect/TypeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpClientCall.kt */
public final class HttpClientCallKt {
    public static final /* synthetic */ <T> Object body(HttpClientCall httpClientCall, Continuation<? super T> continuation) {
        Intrinsics.reifiedOperationMarker(6, "T");
        Type javaType = TypesJVMKt.getJavaType((KType) null);
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), (KType) null);
        InlineMarker.mark(0);
        Object body = httpClientCall.body(typeInfoImpl, continuation);
        InlineMarker.mark(1);
        Intrinsics.reifiedOperationMarker(1, "T");
        return body;
    }

    public static final /* synthetic */ <T> Object body(HttpResponse httpResponse, Continuation<? super T> continuation) {
        HttpClientCall call = httpResponse.getCall();
        Intrinsics.reifiedOperationMarker(6, "T");
        Type javaType = TypesJVMKt.getJavaType((KType) null);
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), (KType) null);
        InlineMarker.mark(0);
        Object body = call.body(typeInfoImpl, continuation);
        InlineMarker.mark(1);
        Intrinsics.reifiedOperationMarker(1, "T");
        return body;
    }

    public static final <T> Object body(HttpResponse httpResponse, TypeInfo typeInfo, Continuation<? super T> continuation) {
        Object body = httpResponse.getCall().body(typeInfo, continuation);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return body;
    }
}
