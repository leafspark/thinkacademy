package io.flutter.view;

import io.flutter.util.Predicate;
import io.flutter.view.AccessibilityBridge;

public final /* synthetic */ class AccessibilityBridge$$ExternalSyntheticLambda1 implements Predicate {
    public static final /* synthetic */ AccessibilityBridge$$ExternalSyntheticLambda1 INSTANCE = new AccessibilityBridge$$ExternalSyntheticLambda1();

    private /* synthetic */ AccessibilityBridge$$ExternalSyntheticLambda1() {
    }

    public final boolean test(Object obj) {
        return ((AccessibilityBridge.SemanticsNode) obj).hasFlag(AccessibilityBridge.Flag.HAS_IMPLICIT_SCROLLING);
    }
}
