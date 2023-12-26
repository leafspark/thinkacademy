package androidx.browser.trusted;

import java.util.Comparator;

public final /* synthetic */ class TokenContents$$ExternalSyntheticLambda0 implements Comparator {
    public static final /* synthetic */ TokenContents$$ExternalSyntheticLambda0 INSTANCE = new TokenContents$$ExternalSyntheticLambda0();

    private /* synthetic */ TokenContents$$ExternalSyntheticLambda0() {
    }

    public final int compare(Object obj, Object obj2) {
        return TokenContents.compareByteArrays((byte[]) obj, (byte[]) obj2);
    }
}
