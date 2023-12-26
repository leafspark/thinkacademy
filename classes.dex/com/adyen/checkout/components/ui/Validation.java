package com.adyen.checkout.components.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/adyen/checkout/components/ui/Validation;", "", "()V", "isValid", "", "Invalid", "Valid", "Lcom/adyen/checkout/components/ui/Validation$Valid;", "Lcom/adyen/checkout/components/ui/Validation$Invalid;", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Validation.kt */
public abstract class Validation {
    public /* synthetic */ Validation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Validation() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/adyen/checkout/components/ui/Validation$Valid;", "Lcom/adyen/checkout/components/ui/Validation;", "()V", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Validation.kt */
    public static final class Valid extends Validation {
        public static final Valid INSTANCE = new Valid();

        private Valid() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/adyen/checkout/components/ui/Validation$Invalid;", "Lcom/adyen/checkout/components/ui/Validation;", "reason", "", "(I)V", "showErrorWhileEditing", "", "(IZ)V", "getReason", "()I", "getShowErrorWhileEditing", "()Z", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Validation.kt */
    public static final class Invalid extends Validation {
        private final int reason;
        private final boolean showErrorWhileEditing;

        public Invalid(int i, boolean z) {
            super((DefaultConstructorMarker) null);
            this.reason = i;
            this.showErrorWhileEditing = z;
        }

        public final int getReason() {
            return this.reason;
        }

        public final boolean getShowErrorWhileEditing() {
            return this.showErrorWhileEditing;
        }

        public Invalid(int i) {
            this(i, false);
        }
    }

    public final boolean isValid() {
        return this instanceof Valid;
    }
}
