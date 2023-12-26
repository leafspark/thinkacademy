package io.ktor.util;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lio/ktor/util/AlwaysFailNonceManager;", "Lio/ktor/util/NonceManager;", "()V", "newNonce", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyNonce", "", "nonce", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.ERROR, message = "This should be removed with OAuth2StateProvider")
@InternalAPI
/* compiled from: NonceManager.kt */
public final class AlwaysFailNonceManager implements NonceManager {
    public static final AlwaysFailNonceManager INSTANCE = new AlwaysFailNonceManager();

    private AlwaysFailNonceManager() {
    }

    public Object newNonce(Continuation<? super String> continuation) {
        throw new UnsupportedOperationException("This manager should never be used");
    }

    public Object verifyNonce(String str, Continuation<? super Boolean> continuation) {
        throw new UnsupportedOperationException("This manager should never be used");
    }
}
