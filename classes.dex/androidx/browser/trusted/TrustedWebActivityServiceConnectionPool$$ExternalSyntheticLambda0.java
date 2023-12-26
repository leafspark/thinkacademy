package androidx.browser.trusted;

import android.net.Uri;

public final /* synthetic */ class TrustedWebActivityServiceConnectionPool$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ TrustedWebActivityServiceConnectionPool f$0;
    public final /* synthetic */ Uri f$1;

    public /* synthetic */ TrustedWebActivityServiceConnectionPool$$ExternalSyntheticLambda0(TrustedWebActivityServiceConnectionPool trustedWebActivityServiceConnectionPool, Uri uri) {
        this.f$0 = trustedWebActivityServiceConnectionPool;
        this.f$1 = uri;
    }

    public final void run() {
        this.f$0.lambda$connect$0$TrustedWebActivityServiceConnectionPool(this.f$1);
    }
}
