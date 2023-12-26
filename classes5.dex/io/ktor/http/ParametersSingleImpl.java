package io.ktor.http;

import io.ktor.http.ContentDisposition;
import io.ktor.util.StringValuesSingleImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"Lio/ktor/http/ParametersSingleImpl;", "Lio/ktor/http/Parameters;", "Lio/ktor/util/StringValuesSingleImpl;", "name", "", "values", "", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Parameters.kt */
public final class ParametersSingleImpl extends StringValuesSingleImpl implements Parameters {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ParametersSingleImpl(String str, List<String> list) {
        super(true, str, list);
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(list, "values");
    }

    public String toString() {
        return "Parameters " + entries();
    }
}
