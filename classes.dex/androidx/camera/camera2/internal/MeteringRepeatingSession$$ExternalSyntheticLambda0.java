package androidx.camera.camera2.internal;

import android.util.Size;
import java.util.Comparator;

public final /* synthetic */ class MeteringRepeatingSession$$ExternalSyntheticLambda0 implements Comparator {
    public static final /* synthetic */ MeteringRepeatingSession$$ExternalSyntheticLambda0 INSTANCE = new MeteringRepeatingSession$$ExternalSyntheticLambda0();

    private /* synthetic */ MeteringRepeatingSession$$ExternalSyntheticLambda0() {
    }

    public final int compare(Object obj, Object obj2) {
        return Long.signum((((long) ((Size) obj).getWidth()) * ((long) ((Size) obj).getHeight())) - (((long) ((Size) obj2).getWidth()) * ((long) ((Size) obj2).getHeight())));
    }
}
