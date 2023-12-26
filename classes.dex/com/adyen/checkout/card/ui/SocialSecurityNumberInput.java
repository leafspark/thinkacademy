package com.adyen.checkout.card.ui;

import android.content.Context;
import android.text.Editable;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import com.adyen.checkout.card.SocialSecurityNumberUtils;
import com.adyen.checkout.components.ui.view.AdyenTextInputEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014¨\u0006\u0010"}, d2 = {"Lcom/adyen/checkout/card/ui/SocialSecurityNumberInput;", "Lcom/adyen/checkout/components/ui/view/AdyenTextInputEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "Companion", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SocialSecurityNumberInput.kt */
public final class SocialSecurityNumberInput extends AdyenTextInputEditText {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SUPPORTED_CHARS = "0123456789./-";

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SocialSecurityNumberInput(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SocialSecurityNumberInput(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        enforceMaxInputLength(SocialSecurityNumberUtils.INSTANCE.getCNPJ_MASK_SEPARATORS().size() + 14);
        setInputType(2);
        setKeyListener(DigitsKeyListener.getInstance(SUPPORTED_CHARS));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/adyen/checkout/card/ui/SocialSecurityNumberInput$Companion;", "", "()V", "SUPPORTED_CHARS", "", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: SocialSecurityNumberInput.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SocialSecurityNumberInput(Context context) {
        this(context, (AttributeSet) null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SocialSecurityNumberInput(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: protected */
    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "editable");
        String obj = editable.toString();
        String formatInput = SocialSecurityNumberUtils.INSTANCE.formatInput(obj);
        if (!Intrinsics.areEqual(formatInput, obj)) {
            editable.replace(0, obj.length(), formatInput);
        }
        super.afterTextChanged(editable);
    }
}
