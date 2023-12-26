package io.ktor.client.engine.okhttp;

import io.ktor.http.ContentDisposition;
import io.ktor.http.Headers;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\b0\u0007H\u0016J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"io/ktor/client/engine/okhttp/OkUtilsKt$fromOkHttp$1", "Lio/ktor/http/Headers;", "caseInsensitiveName", "", "getCaseInsensitiveName", "()Z", "entries", "", "", "", "", "getAll", "name", "isEmpty", "names", "ktor-client-okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkUtils.kt */
public final class OkUtilsKt$fromOkHttp$1 implements Headers {
    final /* synthetic */ okhttp3.Headers $this_fromOkHttp;
    private final boolean caseInsensitiveName = true;

    OkUtilsKt$fromOkHttp$1(okhttp3.Headers headers) {
        this.$this_fromOkHttp = headers;
    }

    public boolean contains(String str) {
        return Headers.DefaultImpls.contains(this, str);
    }

    public boolean contains(String str, String str2) {
        return Headers.DefaultImpls.contains(this, str, str2);
    }

    public void forEach(Function2<? super String, ? super List<String>, Unit> function2) {
        Headers.DefaultImpls.forEach(this, function2);
    }

    public String get(String str) {
        return Headers.DefaultImpls.get(this, str);
    }

    public boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    public List<String> getAll(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        List<String> values = this.$this_fromOkHttp.values(str);
        if (!values.isEmpty()) {
            return values;
        }
        return null;
    }

    public Set<String> names() {
        return this.$this_fromOkHttp.names();
    }

    public Set<Map.Entry<String, List<String>>> entries() {
        return this.$this_fromOkHttp.toMultimap().entrySet();
    }

    public boolean isEmpty() {
        return this.$this_fromOkHttp.size() == 0;
    }
}
