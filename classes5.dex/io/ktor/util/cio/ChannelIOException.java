package io.ktor.util.cio;

import com.tekartik.sqflite.Constant;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/util/cio/ChannelIOException;", "Ljava/io/IOException;", "Lio/ktor/utils/io/errors/IOException;", "message", "", "exception", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Channels.kt */
public class ChannelIOException extends IOException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelIOException(String str, Throwable th) {
        super(str, th);
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "exception");
    }
}
