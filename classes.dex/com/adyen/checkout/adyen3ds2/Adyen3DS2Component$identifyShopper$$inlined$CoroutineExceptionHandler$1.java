package com.adyen.checkout.adyen3ds2;

import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.log.Logger;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CoroutineExceptionHandler.kt */
public final class Adyen3DS2Component$identifyShopper$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ Adyen3DS2Component this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Adyen3DS2Component$identifyShopper$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key, Adyen3DS2Component adyen3DS2Component) {
        super((CoroutineContext.Key) key);
        this.this$0 = adyen3DS2Component;
    }

    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        Logger.e(Adyen3DS2Component.TAG, "Unexpected uncaught 3DS2 Exception", th);
        this.this$0.notifyException(new CheckoutException("Unexpected 3DS2 exception.", th));
    }
}
