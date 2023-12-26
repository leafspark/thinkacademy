package io.ktor.websocket.serialization;

import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketDeserializeException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketSession;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000(\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bHHø\u0001\u0000¢\u0006\u0002\u0010\t\u001a=\u0010\n\u001a\u00020\u000b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\f\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bHHø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"receiveDeserializedBase", "T", "", "Lio/ktor/websocket/WebSocketSession;", "converter", "Lio/ktor/serialization/WebsocketContentConverter;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSerializedBase", "", "data", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Object;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websocket-serialization"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebsocketChannelSerialization.kt */
public final class WebsocketChannelSerializationKt {
    public static final /* synthetic */ <T> Object sendSerializedBase(WebSocketSession webSocketSession, T t, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<? super Unit> continuation) {
        Intrinsics.reifiedOperationMarker(6, "T");
        Type javaType = TypesJVMKt.getJavaType((KType) null);
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), (KType) null);
        InlineMarker.mark(0);
        Object serialize = websocketContentConverter.serialize(charset, typeInfoImpl, t, continuation);
        InlineMarker.mark(1);
        SendChannel<Frame> outgoing = webSocketSession.getOutgoing();
        InlineMarker.mark(0);
        outgoing.send((Frame) serialize, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ <T> Object receiveDeserializedBase(WebSocketSession webSocketSession, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<? super T> continuation) {
        ReceiveChannel<Frame> incoming = webSocketSession.getIncoming();
        InlineMarker.mark(0);
        Object receive = incoming.receive(continuation);
        InlineMarker.mark(1);
        Frame frame = (Frame) receive;
        if (websocketContentConverter.isApplicable(frame)) {
            Intrinsics.reifiedOperationMarker(6, "T");
            Type javaType = TypesJVMKt.getJavaType((KType) null);
            Intrinsics.reifiedOperationMarker(4, "T");
            TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), (KType) null);
            InlineMarker.mark(0);
            Object deserialize = websocketContentConverter.deserialize(charset, typeInfoImpl, frame, continuation);
            InlineMarker.mark(1);
            Intrinsics.reifiedOperationMarker(3, "T");
            if (deserialize instanceof Object) {
                return deserialize;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Can't deserialize value : expected value of type ");
            Intrinsics.reifiedOperationMarker(4, "T");
            sb.append(Reflection.getOrCreateKotlinClass(Object.class).getSimpleName());
            sb.append(", got ");
            sb.append(Reflection.getOrCreateKotlinClass(deserialize.getClass()).getSimpleName());
            throw new WebsocketDeserializeException(sb.toString(), (Throwable) null, frame, 2, (DefaultConstructorMarker) null);
        }
        throw new WebsocketDeserializeException("Converter doesn't support frame type " + frame.getFrameType().name(), (Throwable) null, frame, 2, (DefaultConstructorMarker) null);
    }
}
