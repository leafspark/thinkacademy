package io.ktor.client.request.forms;

import io.ktor.http.Headers;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\u0011\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J2\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lio/ktor/client/request/forms/FormPart;", "T", "", "key", "", "value", "headers", "Lio/ktor/http/Headers;", "(Ljava/lang/String;Ljava/lang/Object;Lio/ktor/http/Headers;)V", "getHeaders", "()Lio/ktor/http/Headers;", "getKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Object;Lio/ktor/http/Headers;)Lio/ktor/client/request/forms/FormPart;", "equals", "", "other", "hashCode", "", "toString", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: formDsl.kt */
public final class FormPart<T> {
    private final Headers headers;
    private final String key;
    private final T value;

    public static /* synthetic */ FormPart copy$default(FormPart formPart, String str, T t, Headers headers2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = formPart.key;
        }
        if ((i & 2) != 0) {
            t = formPart.value;
        }
        if ((i & 4) != 0) {
            headers2 = formPart.headers;
        }
        return formPart.copy(str, t, headers2);
    }

    public final String component1() {
        return this.key;
    }

    public final T component2() {
        return this.value;
    }

    public final Headers component3() {
        return this.headers;
    }

    public final FormPart<T> copy(String str, T t, Headers headers2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(t, "value");
        Intrinsics.checkNotNullParameter(headers2, "headers");
        return new FormPart<>(str, t, headers2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormPart)) {
            return false;
        }
        FormPart formPart = (FormPart) obj;
        return Intrinsics.areEqual(this.key, formPart.key) && Intrinsics.areEqual(this.value, formPart.value) && Intrinsics.areEqual(this.headers, formPart.headers);
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + this.value.hashCode()) * 31) + this.headers.hashCode();
    }

    public String toString() {
        return "FormPart(key=" + this.key + ", value=" + this.value + ", headers=" + this.headers + ')';
    }

    public FormPart(String str, T t, Headers headers2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(t, "value");
        Intrinsics.checkNotNullParameter(headers2, "headers");
        this.key = str;
        this.value = t;
        this.headers = headers2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FormPart(String str, Object obj, Headers headers2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, (i & 4) != 0 ? Headers.Companion.getEmpty() : headers2);
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final String getKey() {
        return this.key;
    }

    public final T getValue() {
        return this.value;
    }
}
