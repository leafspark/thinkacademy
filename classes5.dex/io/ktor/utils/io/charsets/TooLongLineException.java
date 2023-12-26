package io.ktor.utils.io.charsets;

import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/utils/io/charsets/TooLongLineException;", "Lio/ktor/utils/io/charsets/MalformedInputException;", "message", "", "(Ljava/lang/String;)V", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Encoding.kt */
public final class TooLongLineException extends MalformedInputException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TooLongLineException(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_MESSAGE);
    }
}
