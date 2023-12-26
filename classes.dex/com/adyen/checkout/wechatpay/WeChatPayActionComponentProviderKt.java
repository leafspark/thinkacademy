package com.adyen.checkout.wechatpay;

import com.adyen.checkout.components.util.PaymentMethodTypes;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0003"}, d2 = {"PAYMENT_METHODS", "", "", "wechatpay_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: WeChatPayActionComponentProvider.kt */
public final class WeChatPayActionComponentProviderKt {
    /* access modifiers changed from: private */
    public static final List<String> PAYMENT_METHODS = CollectionsKt.listOf(PaymentMethodTypes.WECHAT_PAY_SDK);
}
