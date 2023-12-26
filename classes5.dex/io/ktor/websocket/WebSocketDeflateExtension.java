package io.ktor.websocket;

import io.ktor.util.AttributeKey;
import io.ktor.websocket.Frame;
import io.ktor.websocket.internals.DeflaterUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension;", "Lio/ktor/websocket/WebSocketExtension;", "Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "config", "(Lio/ktor/websocket/WebSocketDeflateExtension$Config;)V", "deflater", "Ljava/util/zip/Deflater;", "factory", "Lio/ktor/websocket/WebSocketExtensionFactory;", "getFactory", "()Lio/ktor/websocket/WebSocketExtensionFactory;", "incomingContextTakeover", "", "inflater", "Ljava/util/zip/Inflater;", "outgoingContextTakeover", "protocols", "", "Lio/ktor/websocket/WebSocketExtensionHeader;", "getProtocols", "()Ljava/util/List;", "clientNegotiation", "negotiatedProtocols", "processIncomingFrame", "Lio/ktor/websocket/Frame;", "frame", "processOutgoingFrame", "serverNegotiation", "requestedProtocols", "Companion", "Config", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebSocketDeflateExtension.kt */
public final class WebSocketDeflateExtension implements WebSocketExtension<Config> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AttributeKey<WebSocketDeflateExtension> key = new AttributeKey<>("WebsocketDeflateExtension");
    /* access modifiers changed from: private */
    public static final boolean rsv1 = true;
    /* access modifiers changed from: private */
    public static final boolean rsv2 = false;
    /* access modifiers changed from: private */
    public static final boolean rsv3 = false;
    private final Config config;
    private final Deflater deflater;
    private final WebSocketExtensionFactory<Config, ? extends WebSocketExtension<Config>> factory = Companion;
    private boolean incomingContextTakeover;
    private final Inflater inflater;
    private boolean outgoingContextTakeover;
    private final List<WebSocketExtensionHeader> protocols;

    public WebSocketDeflateExtension(Config config2) {
        Intrinsics.checkNotNullParameter(config2, "config");
        this.config = config2;
        this.protocols = config2.build$ktor_websockets();
        this.inflater = new Inflater(true);
        this.deflater = new Deflater(config2.getCompressionLevel(), true);
        this.outgoingContextTakeover = true;
        this.incomingContextTakeover = true;
    }

    public WebSocketExtensionFactory<Config, ? extends WebSocketExtension<Config>> getFactory() {
        return this.factory;
    }

    public List<WebSocketExtensionHeader> getProtocols() {
        return this.protocols;
    }

    public boolean clientNegotiation(List<WebSocketExtensionHeader> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "negotiatedProtocols");
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((WebSocketExtensionHeader) obj).getName(), "permessage-deflate")) {
                break;
            }
        }
        WebSocketExtensionHeader webSocketExtensionHeader = (WebSocketExtensionHeader) obj;
        if (webSocketExtensionHeader == null) {
            return false;
        }
        this.incomingContextTakeover = this.config.getServerNoContextTakeOver();
        this.outgoingContextTakeover = this.config.getClientNoContextTakeOver();
        Iterator it2 = webSocketExtensionHeader.parseParameters().iterator();
        while (true) {
            boolean z = true;
            if (it2.hasNext()) {
                Pair pair = (Pair) it2.next();
                String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                switch (str.hashCode()) {
                    case -708713803:
                        if (str.equals("client_no_context_takeover") && !StringsKt.isBlank(str2)) {
                            throw new IllegalStateException(("WebSocket permessage-deflate extension parameter client_no_context_takeover shouldn't have a value. Current: " + str2).toString());
                        }
                    case 646404390:
                        if (str.equals("client_max_window_bits") && !StringsKt.isBlank(str2)) {
                            if (Integer.parseInt(str2) != 15) {
                                z = false;
                            }
                            if (z) {
                                break;
                            } else {
                                throw new IllegalStateException("Only 15 window size is supported.".toString());
                            }
                        }
                    case 1266201133:
                        if (str.equals("server_no_context_takeover") && !StringsKt.isBlank(str2)) {
                            throw new IllegalStateException(("WebSocket permessage-deflate extension parameter server_no_context_takeover shouldn't have a value. Current: " + str2).toString());
                        }
                    case 2034279582:
                        str.equals("server_max_window_bits");
                        break;
                }
            } else {
                return true;
            }
        }
    }

    public List<WebSocketExtensionHeader> serverNegotiation(List<WebSocketExtensionHeader> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "requestedProtocols");
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((WebSocketExtensionHeader) obj).getName(), "permessage-deflate")) {
                break;
            }
        }
        WebSocketExtensionHeader webSocketExtensionHeader = (WebSocketExtensionHeader) obj;
        if (webSocketExtensionHeader == null) {
            return CollectionsKt.emptyList();
        }
        List arrayList = new ArrayList();
        for (Pair pair : webSocketExtensionHeader.parseParameters()) {
            String str = (String) pair.component1();
            String str2 = (String) pair.component2();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            boolean z = false;
            switch (lowerCase.hashCode()) {
                case -708713803:
                    if (!lowerCase.equals("client_no_context_takeover")) {
                        break;
                    } else if (StringsKt.isBlank(str2)) {
                        this.incomingContextTakeover = false;
                        arrayList.add("client_no_context_takeover");
                        continue;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                case 646404390:
                    if (!lowerCase.equals("client_max_window_bits")) {
                        break;
                    } else {
                        continue;
                    }
                case 1266201133:
                    if (!lowerCase.equals("server_no_context_takeover")) {
                        break;
                    } else if (StringsKt.isBlank(str2)) {
                        this.outgoingContextTakeover = false;
                        arrayList.add("server_no_context_takeover");
                        continue;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                case 2034279582:
                    if (!lowerCase.equals("server_max_window_bits")) {
                        break;
                    } else {
                        if (Integer.parseInt(str2) == 15) {
                            z = true;
                        }
                        if (z) {
                            continue;
                        } else {
                            throw new IllegalStateException("Only 15 window size is supported".toString());
                        }
                    }
            }
            throw new IllegalStateException(("Unsupported extension parameter: (" + str + ", " + str2 + ')').toString());
        }
        return CollectionsKt.listOf(new WebSocketExtensionHeader("permessage-deflate", arrayList));
    }

    public Frame processOutgoingFrame(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        if ((!(frame instanceof Frame.Text) && !(frame instanceof Frame.Binary)) || !((Boolean) this.config.getCompressCondition$ktor_websockets().invoke(frame)).booleanValue()) {
            return frame;
        }
        byte[] deflateFully = DeflaterUtilsKt.deflateFully(this.deflater, frame.getData());
        if (!this.outgoingContextTakeover) {
            this.deflater.reset();
        }
        return Frame.Companion.byType(frame.getFin(), frame.getFrameType(), deflateFully, rsv1, frame.getRsv2(), frame.getRsv3());
    }

    public Frame processIncomingFrame(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        if (!frame.getRsv1()) {
            return frame;
        }
        if (!(frame instanceof Frame.Text) && !(frame instanceof Frame.Binary)) {
            return frame;
        }
        byte[] inflateFully = DeflaterUtilsKt.inflateFully(this.inflater, frame.getData());
        if (!this.incomingContextTakeover) {
            this.inflater.reset();
        }
        return Frame.Companion.byType(frame.getFin(), frame.getFrameType(), inflateFully, !rsv1, frame.getRsv2(), frame.getRsv3());
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180 H\u0000¢\u0006\u0002\b!J)\u0010\"\u001a\u00020\u00192!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00040\nJ\u000e\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0011J/\u0010)\u001a\u00020\u00192'\u0010#\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00190\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R,\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0004\u0012\u00020\u00190\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b¨\u0006+"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "", "()V", "clientNoContextTakeOver", "", "getClientNoContextTakeOver", "()Z", "setClientNoContextTakeOver", "(Z)V", "compressCondition", "Lkotlin/Function1;", "Lio/ktor/websocket/Frame;", "getCompressCondition$ktor_websockets", "()Lkotlin/jvm/functions/Function1;", "setCompressCondition$ktor_websockets", "(Lkotlin/jvm/functions/Function1;)V", "compressionLevel", "", "getCompressionLevel", "()I", "setCompressionLevel", "(I)V", "manualConfig", "", "Lio/ktor/websocket/WebSocketExtensionHeader;", "", "getManualConfig$ktor_websockets", "setManualConfig$ktor_websockets", "serverNoContextTakeOver", "getServerNoContextTakeOver", "setServerNoContextTakeOver", "build", "", "build$ktor_websockets", "compressIf", "block", "Lkotlin/ParameterName;", "name", "frame", "compressIfBiggerThan", "bytes", "configureProtocols", "protocols", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebSocketDeflateExtension.kt */
    public static final class Config {
        private boolean clientNoContextTakeOver;
        private Function1<? super Frame, Boolean> compressCondition = ((Function1) WebSocketDeflateExtension$Config$compressCondition$1.INSTANCE);
        private int compressionLevel = -1;
        private Function1<? super List<WebSocketExtensionHeader>, Unit> manualConfig = ((Function1) WebSocketDeflateExtension$Config$manualConfig$1.INSTANCE);
        private boolean serverNoContextTakeOver;

        public final boolean getClientNoContextTakeOver() {
            return this.clientNoContextTakeOver;
        }

        public final void setClientNoContextTakeOver(boolean z) {
            this.clientNoContextTakeOver = z;
        }

        public final boolean getServerNoContextTakeOver() {
            return this.serverNoContextTakeOver;
        }

        public final void setServerNoContextTakeOver(boolean z) {
            this.serverNoContextTakeOver = z;
        }

        public final int getCompressionLevel() {
            return this.compressionLevel;
        }

        public final void setCompressionLevel(int i) {
            this.compressionLevel = i;
        }

        public final Function1<List<WebSocketExtensionHeader>, Unit> getManualConfig$ktor_websockets() {
            return this.manualConfig;
        }

        public final void setManualConfig$ktor_websockets(Function1<? super List<WebSocketExtensionHeader>, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.manualConfig = function1;
        }

        public final Function1<Frame, Boolean> getCompressCondition$ktor_websockets() {
            return this.compressCondition;
        }

        public final void setCompressCondition$ktor_websockets(Function1<? super Frame, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.compressCondition = function1;
        }

        public final void configureProtocols(Function1<? super List<WebSocketExtensionHeader>, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            this.manualConfig = (Function1) new WebSocketDeflateExtension$Config$configureProtocols$1(this, function1);
        }

        public final void compressIf(Function1<? super Frame, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            this.compressCondition = (Function1) new WebSocketDeflateExtension$Config$compressIf$1(function1, this.compressCondition);
        }

        public final void compressIfBiggerThan(int i) {
            compressIf(new WebSocketDeflateExtension$Config$compressIfBiggerThan$1(i));
        }

        public final List<WebSocketExtensionHeader> build$ktor_websockets() {
            List<WebSocketExtensionHeader> arrayList = new ArrayList<>();
            List arrayList2 = new ArrayList();
            if (this.clientNoContextTakeOver) {
                arrayList2.add("client_no_context_takeover");
            }
            if (this.serverNoContextTakeOver) {
                arrayList2.add("server_no_context_takeover");
            }
            arrayList.add(new WebSocketExtensionHeader("permessage-deflate", arrayList2));
            this.manualConfig.invoke(arrayList);
            return arrayList;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J!\u0010\u0011\u001a\u00020\u00032\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\b\u0015H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0016"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension$Companion;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "Lio/ktor/websocket/WebSocketDeflateExtension;", "()V", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "rsv1", "", "getRsv1", "()Z", "rsv2", "getRsv2", "rsv3", "getRsv3", "install", "config", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebSocketDeflateExtension.kt */
    public static final class Companion implements WebSocketExtensionFactory<Config, WebSocketDeflateExtension> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public AttributeKey<WebSocketDeflateExtension> getKey() {
            return WebSocketDeflateExtension.key;
        }

        public boolean getRsv1() {
            return WebSocketDeflateExtension.rsv1;
        }

        public boolean getRsv2() {
            return WebSocketDeflateExtension.rsv2;
        }

        public boolean getRsv3() {
            return WebSocketDeflateExtension.rsv3;
        }

        public WebSocketDeflateExtension install(Function1<? super Config, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "config");
            Config config = new Config();
            function1.invoke(config);
            return new WebSocketDeflateExtension(config);
        }
    }
}
