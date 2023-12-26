package io.ktor.http.content;

import io.ktor.http.content.PartData;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"streamProvider", "Lkotlin/Function0;", "Ljava/io/InputStream;", "Lio/ktor/http/content/PartData$FileItem;", "getStreamProvider", "(Lio/ktor/http/content/PartData$FileItem;)Lkotlin/jvm/functions/Function0;", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MultipartJvm.kt */
public final class MultipartJvmKt {
    public static final Function0<InputStream> getStreamProvider(PartData.FileItem fileItem) {
        Intrinsics.checkNotNullParameter(fileItem, "<this>");
        return (Function0) new MultipartJvmKt$streamProvider$1(fileItem);
    }
}
