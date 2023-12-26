package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import java.util.Comparator;

public final /* synthetic */ class OptionsBundle$$ExternalSyntheticLambda0 implements Comparator {
    public static final /* synthetic */ OptionsBundle$$ExternalSyntheticLambda0 INSTANCE = new OptionsBundle$$ExternalSyntheticLambda0();

    private /* synthetic */ OptionsBundle$$ExternalSyntheticLambda0() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((Config.Option) obj).getId().compareTo(((Config.Option) obj2).getId());
    }
}
