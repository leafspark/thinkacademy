package com.adyen.checkout.components.base;

import android.content.Intent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/adyen/checkout/components/base/ActivityResultHandlingComponent;", "Lcom/adyen/checkout/components/base/ResultHandlingComponent;", "handleActivityResult", "", "resultCode", "", "data", "Landroid/content/Intent;", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ActivityResultHandlingComponent.kt */
public interface ActivityResultHandlingComponent extends ResultHandlingComponent {
    void handleActivityResult(int i, Intent intent);
}
