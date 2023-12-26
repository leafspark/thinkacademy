package io.ktor.websocket;

import io.ktor.util.AttributeKey;
import io.ktor.websocket.WebSocketExtension;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0002J&\u0010\u0011\u001a\u00028\u00012\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\b\u0015H&¢\u0006\u0002\u0010\u0016R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0012\u0010\u000f\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u0017"}, d2 = {"Lio/ktor/websocket/WebSocketExtensionFactory;", "ConfigType", "", "ExtensionType", "Lio/ktor/websocket/WebSocketExtension;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "rsv1", "", "getRsv1", "()Z", "rsv2", "getRsv2", "rsv3", "getRsv3", "install", "config", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/websocket/WebSocketExtension;", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebSocketExtension.kt */
public interface WebSocketExtensionFactory<ConfigType, ExtensionType extends WebSocketExtension<ConfigType>> {
    AttributeKey<ExtensionType> getKey();

    boolean getRsv1();

    boolean getRsv2();

    boolean getRsv3();

    ExtensionType install(Function1<? super ConfigType, Unit> function1);
}
