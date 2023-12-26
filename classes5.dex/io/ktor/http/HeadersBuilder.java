package io.ktor.http;

import io.ktor.http.ContentDisposition;
import io.ktor.util.StringValuesBuilderImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0014¨\u0006\r"}, d2 = {"Lio/ktor/http/HeadersBuilder;", "Lio/ktor/util/StringValuesBuilderImpl;", "size", "", "(I)V", "build", "Lio/ktor/http/Headers;", "validateName", "", "name", "", "validateValue", "value", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Headers.kt */
public final class HeadersBuilder extends StringValuesBuilderImpl {
    public HeadersBuilder() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public HeadersBuilder(int i) {
        super(true, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeadersBuilder(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 8 : i);
    }

    public Headers build() {
        return new HeadersImpl(getValues());
    }

    /* access modifiers changed from: protected */
    public void validateName(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        super.validateName(str);
        HttpHeaders.INSTANCE.checkHeaderName(str);
    }

    /* access modifiers changed from: protected */
    public void validateValue(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        super.validateValue(str);
        HttpHeaders.INSTANCE.checkHeaderValue(str);
    }
}
