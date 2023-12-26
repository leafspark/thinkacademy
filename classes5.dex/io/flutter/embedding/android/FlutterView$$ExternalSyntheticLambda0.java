package io.flutter.embedding.android;

import android.view.textservice.SpellCheckerInfo;
import java.util.function.Predicate;

public final /* synthetic */ class FlutterView$$ExternalSyntheticLambda0 implements Predicate {
    public static final /* synthetic */ FlutterView$$ExternalSyntheticLambda0 INSTANCE = new FlutterView$$ExternalSyntheticLambda0();

    private /* synthetic */ FlutterView$$ExternalSyntheticLambda0() {
    }

    public final boolean test(Object obj) {
        return ((SpellCheckerInfo) obj).getPackageName().equals("com.google.android.inputmethod.latin");
    }
}
