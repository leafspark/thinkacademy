package io.ktor.http.content;

import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.Input;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\"#$%B\u001d\b\u0004\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u00068FX\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0016R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00188FX\u0004¢\u0006\f\u0012\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001a\u0001\u0004&'()¨\u0006*"}, d2 = {"Lio/ktor/http/content/PartData;", "", "dispose", "Lkotlin/Function0;", "", "headers", "Lio/ktor/http/Headers;", "(Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;)V", "contentDisposition", "Lio/ktor/http/ContentDisposition;", "getContentDisposition", "()Lio/ktor/http/ContentDisposition;", "contentDisposition$delegate", "Lkotlin/Lazy;", "contentType", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "contentType$delegate", "getDispose", "()Lkotlin/jvm/functions/Function0;", "getHeaders", "()Lio/ktor/http/Headers;", "name", "", "getName", "()Ljava/lang/String;", "partHeaders", "getPartHeaders$annotations", "()V", "getPartHeaders", "partName", "getPartName$annotations", "getPartName", "BinaryChannelItem", "BinaryItem", "FileItem", "FormItem", "Lio/ktor/http/content/PartData$FormItem;", "Lio/ktor/http/content/PartData$FileItem;", "Lio/ktor/http/content/PartData$BinaryItem;", "Lio/ktor/http/content/PartData$BinaryChannelItem;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Multipart.kt */
public abstract class PartData {
    private final Lazy contentDisposition$delegate;
    private final Lazy contentType$delegate;
    private final Function0<Unit> dispose;
    private final Headers headers;

    public /* synthetic */ PartData(Function0 function0, Headers headers2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, headers2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use headers property instead", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
    public static /* synthetic */ void getPartHeaders$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use name property instead", replaceWith = @ReplaceWith(expression = "name", imports = {}))
    public static /* synthetic */ void getPartName$annotations() {
    }

    private PartData(Function0<Unit> function0, Headers headers2) {
        this.dispose = function0;
        this.headers = headers2;
        this.contentDisposition$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new PartData$contentDisposition$2(this));
        this.contentType$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new PartData$contentType$2(this));
    }

    public final Function0<Unit> getDispose() {
        return this.dispose;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/http/content/PartData$FormItem;", "Lio/ktor/http/content/PartData;", "value", "", "dispose", "Lkotlin/Function0;", "", "partHeaders", "Lio/ktor/http/Headers;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;)V", "getValue", "()Ljava/lang/String;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Multipart.kt */
    public static final class FormItem extends PartData {
        private final String value;

        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FormItem(String str, Function0<Unit> function0, Headers headers) {
            super(function0, headers, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "value");
            Intrinsics.checkNotNullParameter(function0, "dispose");
            Intrinsics.checkNotNullParameter(headers, "partHeaders");
            this.value = str;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/http/content/PartData$FileItem;", "Lio/ktor/http/content/PartData;", "provider", "Lkotlin/Function0;", "Lio/ktor/utils/io/core/Input;", "dispose", "", "partHeaders", "Lio/ktor/http/Headers;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;)V", "originalFileName", "", "getOriginalFileName", "()Ljava/lang/String;", "getProvider", "()Lkotlin/jvm/functions/Function0;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Multipart.kt */
    public static final class FileItem extends PartData {
        private final String originalFileName;
        private final Function0<Input> provider;

        public final Function0<Input> getProvider() {
            return this.provider;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FileItem(Function0<? extends Input> function0, Function0<Unit> function02, Headers headers) {
            super(function02, headers, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(function0, "provider");
            Intrinsics.checkNotNullParameter(function02, "dispose");
            Intrinsics.checkNotNullParameter(headers, "partHeaders");
            String str = null;
            this.provider = function0;
            ContentDisposition contentDisposition = getContentDisposition();
            this.originalFileName = contentDisposition != null ? contentDisposition.parameter(ContentDisposition.Parameters.FileName) : str;
        }

        public final String getOriginalFileName() {
            return this.originalFileName;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/http/content/PartData$BinaryItem;", "Lio/ktor/http/content/PartData;", "provider", "Lkotlin/Function0;", "Lio/ktor/utils/io/core/Input;", "dispose", "", "partHeaders", "Lio/ktor/http/Headers;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;)V", "getProvider", "()Lkotlin/jvm/functions/Function0;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Multipart.kt */
    public static final class BinaryItem extends PartData {
        private final Function0<Input> provider;

        public final Function0<Input> getProvider() {
            return this.provider;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BinaryItem(Function0<? extends Input> function0, Function0<Unit> function02, Headers headers) {
            super(function02, headers, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(function0, "provider");
            Intrinsics.checkNotNullParameter(function02, "dispose");
            Intrinsics.checkNotNullParameter(headers, "partHeaders");
            this.provider = function0;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/http/content/PartData$BinaryChannelItem;", "Lio/ktor/http/content/PartData;", "provider", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "partHeaders", "Lio/ktor/http/Headers;", "(Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;)V", "getProvider", "()Lkotlin/jvm/functions/Function0;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Multipart.kt */
    public static final class BinaryChannelItem extends PartData {
        private final Function0<ByteReadChannel> provider;

        public final Function0<ByteReadChannel> getProvider() {
            return this.provider;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BinaryChannelItem(Function0<? extends ByteReadChannel> function0, Headers headers) {
            super(AnonymousClass1.INSTANCE, headers, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(function0, "provider");
            Intrinsics.checkNotNullParameter(headers, "partHeaders");
            this.provider = function0;
        }
    }

    public final ContentDisposition getContentDisposition() {
        return (ContentDisposition) this.contentDisposition$delegate.getValue();
    }

    public final ContentType getContentType() {
        return (ContentType) this.contentType$delegate.getValue();
    }

    public final String getName() {
        ContentDisposition contentDisposition = getContentDisposition();
        if (contentDisposition != null) {
            return contentDisposition.getName();
        }
        return null;
    }

    public final String getPartName() {
        return getName();
    }

    public final Headers getPartHeaders() {
        return this.headers;
    }
}
