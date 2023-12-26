package io.ktor.websocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0011H\u0002J=\u0010\u0012\u001a\u00020\u000f\"\b\b\u0000\u0010\u0013*\u00020\u00012\u0010\u0010\u0014\u001a\f\u0012\u0004\u0012\u0002H\u0013\u0012\u0002\b\u00030\u00112\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u000f0\u0016¢\u0006\u0002\b\u0017R\"\u0010\u0003\u001a\u0016\u0012\u0012\u0012\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005j\u0002`\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0018"}, d2 = {"Lio/ktor/websocket/WebSocketExtensionsConfig;", "", "()V", "installers", "", "Lkotlin/Function0;", "Lio/ktor/websocket/WebSocketExtension;", "Lio/ktor/websocket/ExtensionInstaller;", "rcv", "", "", "[Ljava/lang/Boolean;", "build", "", "checkConflicts", "", "extensionFactory", "Lio/ktor/websocket/WebSocketExtensionFactory;", "install", "ConfigType", "extension", "config", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebSocketExtension.kt */
public final class WebSocketExtensionsConfig {
    private final List<Function0<WebSocketExtension<?>>> installers = new ArrayList();
    private final Boolean[] rcv = {false, false, false};

    public static /* synthetic */ void install$default(WebSocketExtensionsConfig webSocketExtensionsConfig, WebSocketExtensionFactory webSocketExtensionFactory, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) WebSocketExtensionsConfig$install$1.INSTANCE;
        }
        webSocketExtensionsConfig.install(webSocketExtensionFactory, function1);
    }

    public final <ConfigType> void install(WebSocketExtensionFactory<ConfigType, ?> webSocketExtensionFactory, Function1<? super ConfigType, Unit> function1) {
        Intrinsics.checkNotNullParameter(webSocketExtensionFactory, "extension");
        Intrinsics.checkNotNullParameter(function1, "config");
        checkConflicts(webSocketExtensionFactory);
        this.installers.add(new WebSocketExtensionsConfig$install$2(webSocketExtensionFactory, function1));
    }

    public final List<WebSocketExtension<?>> build() {
        Iterable<Function0> iterable = this.installers;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Function0 invoke : iterable) {
            arrayList.add((WebSocketExtension) invoke.invoke());
        }
        return (List) arrayList;
    }

    private final void checkConflicts(WebSocketExtensionFactory<?, ?> webSocketExtensionFactory) {
        boolean z = false;
        if (((webSocketExtensionFactory.getRsv1() && this.rcv[1].booleanValue()) || (webSocketExtensionFactory.getRsv2() && this.rcv[2].booleanValue())) || (webSocketExtensionFactory.getRsv3() && this.rcv[3].booleanValue())) {
            z = true;
        }
        if (!(!z)) {
            throw new IllegalStateException("Failed to install extension. Please check configured extensions for conflicts.".toString());
        }
    }
}
