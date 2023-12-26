package io.ktor.websocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"parseWebSocketExtensions", "", "Lio/ktor/websocket/WebSocketExtensionHeader;", "value", "", "ktor-websockets"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebSocketExtensionHeader.kt */
public final class WebSocketExtensionHeaderKt {
    public static final List<WebSocketExtensionHeader> parseWebSocketExtensions(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Iterable<String> split$default = StringsKt.split$default((CharSequence) str, new String[]{";"}, false, 0, 6, (Object) null);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String split$default2 : split$default) {
            List split$default3 = StringsKt.split$default((CharSequence) split$default2, new String[]{","}, false, 0, 6, (Object) null);
            String obj = StringsKt.trim((CharSequence) (String) CollectionsKt.first(split$default3)).toString();
            Iterable<String> drop = CollectionsKt.drop(split$default3, 1);
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(drop, 10));
            for (String trim : drop) {
                arrayList2.add(StringsKt.trim((CharSequence) trim).toString());
            }
            arrayList.add(new WebSocketExtensionHeader(obj, (List) arrayList2));
        }
        return (List) arrayList;
    }
}
