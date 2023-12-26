package atd.i0;

import java.security.Provider;
import java.util.Locale;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi;

public final class a extends Provider {
    public static final a a = new a();
    private static final String b = String.format(Locale.US, atd.s0.a.a(-797282033003072L), new Object[]{Double.valueOf(1.0d)});

    static {
        atd.s0.a.a(-797264853133888L);
    }

    private a() {
        super(atd.s0.a.a(-797402292087360L), 1.0d, b);
        put(atd.s0.a.a(-797419471956544L), PSSSignatureSpi.SHA256withRSA.class.getName());
    }
}
