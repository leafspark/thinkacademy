package io.ktor.http.content;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lio/ktor/http/content/MultiPartData;", "", "readPart", "Lio/ktor/http/content/PartData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Empty", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Multipart.kt */
public interface MultiPartData {
    Object readPart(Continuation<? super PartData> continuation);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lio/ktor/http/content/MultiPartData$Empty;", "Lio/ktor/http/content/MultiPartData;", "()V", "readPart", "Lio/ktor/http/content/PartData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Multipart.kt */
    public static final class Empty implements MultiPartData {
        public static final Empty INSTANCE = new Empty();

        public Object readPart(Continuation<? super PartData> continuation) {
            return null;
        }

        private Empty() {
        }
    }
}
