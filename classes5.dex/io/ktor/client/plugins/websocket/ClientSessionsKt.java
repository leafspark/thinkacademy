package io.ktor.client.plugins.websocket;

import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.serialization.ContentConverterKt;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketConverterNotFoundException;
import io.ktor.serialization.WebsocketDeserializeException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.websocket.Frame;
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

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u00020\u0002HHø\u0001\u0000¢\u0006\u0002\u0010\b\u001a)\u0010\t\u001a\u00020\n\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u00020\u00022\u0006\u0010\u000b\u001a\u0002H\u0006HHø\u0001\u0000¢\u0006\u0002\u0010\f\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"converter", "Lio/ktor/serialization/WebsocketContentConverter;", "Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "getConverter", "(Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;)Lio/ktor/serialization/WebsocketContentConverter;", "receiveDeserialized", "T", "", "(Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSerialized", "", "data", "(Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClientSessions.kt */
public final class ClientSessionsKt {
    public static final WebsocketContentConverter getConverter(DefaultClientWebSocketSession defaultClientWebSocketSession) {
        Intrinsics.checkNotNullParameter(defaultClientWebSocketSession, "<this>");
        WebSockets webSockets = (WebSockets) HttpClientPluginKt.pluginOrNull(defaultClientWebSocketSession.getCall().getClient(), WebSockets.Plugin);
        if (webSockets != null) {
            return webSockets.getContentConverter();
        }
        return null;
    }

    public static final /* synthetic */ <T> Object sendSerialized(DefaultClientWebSocketSession defaultClientWebSocketSession, T t, Continuation<? super Unit> continuation) {
        WebsocketContentConverter converter = getConverter(defaultClientWebSocketSession);
        if (converter != null) {
            Charset suitableCharset$default = ContentConverterKt.suitableCharset$default(defaultClientWebSocketSession.getCall().getRequest().getHeaders(), (Charset) null, 1, (Object) null);
            Intrinsics.reifiedOperationMarker(6, "T");
            Type javaType = TypesJVMKt.getJavaType((KType) null);
            Intrinsics.reifiedOperationMarker(4, "T");
            TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), (KType) null);
            InlineMarker.mark(0);
            Object serialize = converter.serialize(suitableCharset$default, typeInfoImpl, t, continuation);
            InlineMarker.mark(1);
            SendChannel<Frame> outgoing = defaultClientWebSocketSession.getOutgoing();
            InlineMarker.mark(0);
            outgoing.send((Frame) serialize, continuation);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        }
        throw new WebsocketConverterNotFoundException("No converter was found for websocket", (Throwable) null, 2, (DefaultConstructorMarker) null);
    }

    public static final /* synthetic */ <T> Object receiveDeserialized(DefaultClientWebSocketSession defaultClientWebSocketSession, Continuation<? super T> continuation) {
        WebsocketContentConverter converter = getConverter(defaultClientWebSocketSession);
        if (converter != null) {
            Charset suitableCharset$default = ContentConverterKt.suitableCharset$default(defaultClientWebSocketSession.getCall().getRequest().getHeaders(), (Charset) null, 1, (Object) null);
            ReceiveChannel<Frame> incoming = defaultClientWebSocketSession.getIncoming();
            InlineMarker.mark(0);
            Object receive = incoming.receive(continuation);
            InlineMarker.mark(1);
            Frame frame = (Frame) receive;
            if (converter.isApplicable(frame)) {
                Intrinsics.reifiedOperationMarker(6, "T");
                Type javaType = TypesJVMKt.getJavaType((KType) null);
                Intrinsics.reifiedOperationMarker(4, "T");
                TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), (KType) null);
                InlineMarker.mark(0);
                Object deserialize = converter.deserialize(suitableCharset$default, typeInfoImpl, frame, continuation);
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
        throw new WebsocketConverterNotFoundException("No converter was found for websocket", (Throwable) null, 2, (DefaultConstructorMarker) null);
    }
}
