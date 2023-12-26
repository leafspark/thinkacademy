package io.ktor.serialization;

import io.ktor.http.ContentType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u00042\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0002\b\u000bH&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/serialization/Configuration;", "", "register", "", "T", "Lio/ktor/serialization/ContentConverter;", "contentType", "Lio/ktor/http/ContentType;", "converter", "configuration", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lio/ktor/http/ContentType;Lio/ktor/serialization/ContentConverter;Lkotlin/jvm/functions/Function1;)V", "ktor-serialization"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContentConverter.kt */
public interface Configuration {
    <T extends ContentConverter> void register(ContentType contentType, T t, Function1<? super T, Unit> function1);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ContentConverter.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void register$default(Configuration configuration, ContentType contentType, ContentConverter contentConverter, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = (Function1) Configuration$register$1.INSTANCE;
                }
                configuration.register(contentType, contentConverter, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
    }
}
