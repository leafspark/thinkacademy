package com.adyen.checkout.components.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/adyen/checkout/components/ui/FieldState;", "T", "", "value", "validation", "Lcom/adyen/checkout/components/ui/Validation;", "(Ljava/lang/Object;Lcom/adyen/checkout/components/ui/Validation;)V", "getValidation", "()Lcom/adyen/checkout/components/ui/Validation;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/Object;Lcom/adyen/checkout/components/ui/Validation;)Lcom/adyen/checkout/components/ui/FieldState;", "equals", "", "other", "hashCode", "", "toString", "", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FieldState.kt */
public final class FieldState<T> {
    private final Validation validation;
    private final T value;

    public static /* synthetic */ FieldState copy$default(FieldState fieldState, T t, Validation validation2, int i, Object obj) {
        if ((i & 1) != 0) {
            t = fieldState.value;
        }
        if ((i & 2) != 0) {
            validation2 = fieldState.validation;
        }
        return fieldState.copy(t, validation2);
    }

    public final T component1() {
        return this.value;
    }

    public final Validation component2() {
        return this.validation;
    }

    public final FieldState<T> copy(T t, Validation validation2) {
        Intrinsics.checkNotNullParameter(validation2, "validation");
        return new FieldState<>(t, validation2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldState)) {
            return false;
        }
        FieldState fieldState = (FieldState) obj;
        return Intrinsics.areEqual(this.value, fieldState.value) && Intrinsics.areEqual(this.validation, fieldState.validation);
    }

    public int hashCode() {
        T t = this.value;
        return ((t == null ? 0 : t.hashCode()) * 31) + this.validation.hashCode();
    }

    public String toString() {
        return "FieldState(value=" + this.value + ", validation=" + this.validation + ')';
    }

    public FieldState(T t, Validation validation2) {
        Intrinsics.checkNotNullParameter(validation2, "validation");
        this.value = t;
        this.validation = validation2;
    }

    public final T getValue() {
        return this.value;
    }

    public final Validation getValidation() {
        return this.validation;
    }
}
