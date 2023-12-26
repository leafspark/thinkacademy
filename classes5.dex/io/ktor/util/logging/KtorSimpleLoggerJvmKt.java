package io.ktor.util.logging;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"KtorSimpleLogger", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "name", "", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: KtorSimpleLoggerJvm.kt */
public final class KtorSimpleLoggerJvmKt {
    public static final Logger KtorSimpleLogger(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Logger logger = LoggerFactory.getLogger(str);
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(name)");
        return logger;
    }
}
